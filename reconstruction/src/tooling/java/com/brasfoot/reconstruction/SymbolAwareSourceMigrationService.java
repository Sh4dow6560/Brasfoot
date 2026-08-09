package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.SemanticMemberSourceMigrationService.MemberMigration;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

final class SymbolAwareSourceMigrationService {
  private final ProjectContext context;

  SymbolAwareSourceMigrationService(ProjectContext context) {
    this.context = context;
  }

  MigrationResult migrate(Path sourceRoot, List<MemberMigration> migrations) throws IOException {
    if (migrations.isEmpty()) {
      return new MigrationResult(0, 0, List.of());
    }
    Map<String, String> namedClasses = readNamedClasses();
    List<Target> targets = migrations.stream()
        .map(migration -> new Target(
            migration,
            migration.ownerNamed(),
            migration.ownerNamed().replace('/', '.'),
            remapMethodDescriptor(migration.descriptor(), namedClasses)))
        .sorted(Comparator.comparing(Target::key))
        .toList();
    Map<String, Target> targetsByResolvedKey = new HashMap<>();
    Map<String, List<Target>> targetsByCurrentName = new HashMap<>();
    for (Target target : targets) {
      Target previous = targetsByResolvedKey.putIfAbsent(target.resolvedKey(), target);
      if (previous != null) {
        throw new IllegalStateException(
            "Duplicate symbol-aware migration target: " + target.resolvedKey());
      }
      targetsByCurrentName.computeIfAbsent(
          target.migration().currentName(), ignored -> new ArrayList<>()).add(target);
    }

    ExpectedReferences expected = expectedReferences(targets);
    Set<String> sourceClasses = new LinkedHashSet<>(expected.callerClasses());
    targets.forEach(target -> sourceClasses.add(target.ownerInternal()));
    List<Path> sources = new ArrayList<>();
    for (String className : sourceClasses) {
      String topLevel = topLevelClass(className);
      Path source = sourceRoot.resolve(topLevel + ".java");
      if (Files.isRegularFile(source) && !sources.contains(source)) {
        sources.add(source);
      }
    }
    sources.sort(Comparator.comparing(path -> sourceRoot.relativize(path).toString()));

    CombinedTypeSolver typeSolver = new CombinedTypeSolver();
    ParserConfiguration parserConfiguration = new ParserConfiguration()
        .setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_8)
        .setSymbolResolver(new JavaSymbolSolver(typeSolver));
    typeSolver.add(new ReflectionTypeSolver(false));
    typeSolver.add(new JavaParserTypeSolver(sourceRoot, parserConfiguration));
    Path embedded = context.buildDir().resolve("work/embedded-libs");
    if (Files.isDirectory(embedded)) {
      try (var paths = Files.list(embedded)) {
        for (Path jar : paths.filter(Files::isRegularFile)
            .filter(path -> path.getFileName().toString().endsWith(".jar"))
            .sorted().toList()) {
          typeSolver.add(new JarTypeSolver(jar));
        }
      }
    }
    JavaParser parser = new JavaParser(parserConfiguration);

    Map<Path, CompilationUnit> units = new LinkedHashMap<>();
    for (Path source : sources) {
      ParseResult<CompilationUnit> parsed = parser.parse(source);
      if (!parsed.isSuccessful() || parsed.getResult().isEmpty()) {
        throw new IllegalStateException(
            "JavaParser could not parse " + source + ": " + parsed.getProblems());
      }
      CompilationUnit unit = parsed.getResult().orElseThrow();
      LexicalPreservingPrinter.setup(unit);
      units.put(source, unit);
    }

    Map<String, MutableTargetResult> results = new TreeMap<>();
    for (Target target : targets) {
      results.put(target.key(), new MutableTargetResult(
          target,
          expected.referencesByTarget().getOrDefault(target.key(), 0),
          expected.locationsByTarget().getOrDefault(target.key(), List.of())));
    }
    Set<Path> changed = new LinkedHashSet<>();
    List<Runnable> renameActions = new ArrayList<>();
    for (Map.Entry<Path, CompilationUnit> item : units.entrySet()) {
      CompilationUnit unit = item.getValue();
      for (MethodDeclaration declaration : unit.findAll(MethodDeclaration.class)) {
        if (!targetsByCurrentName.containsKey(declaration.getNameAsString())) {
          continue;
        }
        Target target = resolveTarget(
            declaration::resolve, targetsByResolvedKey);
        if (target != null) {
          renameActions.add(() -> declaration.setName(target.migration().desiredName()));
          results.get(target.key()).declarations++;
          changed.add(item.getKey());
        }
      }
      for (MethodCallExpr call : unit.findAll(MethodCallExpr.class)) {
        if (!targetsByCurrentName.containsKey(call.getNameAsString())) {
          continue;
        }
        Target target = resolveTarget(
            call::resolve, targetsByResolvedKey);
        if (target != null) {
          renameActions.add(() -> call.setName(target.migration().desiredName()));
          results.get(target.key()).addReference(
              item.getKey().getFileName() + ":" + call.getRange().map(range -> range.begin.line)
                  .orElse(-1) + ":" + call);
          changed.add(item.getKey());
        }
      }
      for (MethodReferenceExpr reference : unit.findAll(MethodReferenceExpr.class)) {
        if (!targetsByCurrentName.containsKey(reference.getIdentifier())) {
          continue;
        }
        Target target = resolveTarget(
            reference::resolve, targetsByResolvedKey);
        if (target != null) {
          renameActions.add(() -> reference.setIdentifier(target.migration().desiredName()));
          results.get(target.key()).addReference(
              item.getKey().getFileName() + ":"
                  + reference.getRange().map(range -> range.begin.line).orElse(-1)
                  + ":" + reference);
          changed.add(item.getKey());
        }
      }
    }

    List<TargetResult> snapshots = results.values().stream()
        .map(MutableTargetResult::snapshot)
        .toList();
    List<String> errors = new ArrayList<>();
    for (TargetResult result : snapshots) {
      if (result.renamedDeclarations() != 1) {
        errors.add(result.key() + " declarations expected=1 actual="
            + result.renamedDeclarations());
      }
      if (result.renamedReferences() != result.expectedReferences()) {
        errors.add(result.key() + " references expected=" + result.expectedReferences()
            + " actual=" + result.renamedReferences()
            + " locations=" + sample(result.expectedLocations())
            + " resolved=" + sample(result.resolvedLocations()));
      }
    }
    if (!errors.isEmpty()) {
      throw new IllegalStateException(
          "Symbol-aware source migration did not match compiled bytecode: " + errors);
    }
    renameActions.forEach(Runnable::run);
    for (Path source : changed) {
      Files.writeString(source, LexicalPreservingPrinter.print(units.get(source)),
          StandardCharsets.UTF_8);
    }
    return new MigrationResult(targets.size(), changed.size(), snapshots);
  }

  private Target resolveTarget(
      ResolvedMethodSupplier supplier, Map<String, Target> targets) {
    try {
      ResolvedMethodDeclaration method = supplier.resolve();
      String key = method.declaringType().getQualifiedName() + ":"
          + method.getName() + ":" + method.toDescriptor();
      return targets.get(key);
    } catch (RuntimeException exception) {
      return null;
    }
  }

  private List<String> sample(List<String> values) {
    return values.subList(0, Math.min(10, values.size()));
  }

  private ExpectedReferences expectedReferences(List<Target> targets) throws IOException {
    Map<String, Target> byBytecodeKey = new HashMap<>();
    Map<String, Integer> counts = new TreeMap<>();
    Map<String, List<String>> locations = new TreeMap<>();
    for (Target target : targets) {
      byBytecodeKey.put(target.bytecodeKey(), target);
      counts.put(target.key(), 0);
    }
    Set<String> callers = new LinkedHashSet<>();
    Set<String> originalSyntheticMethods = new LinkedHashSet<>();
    ArchiveService.ArchiveData namedGame = new ArchiveService().analyze(context.namedGameJar());
    for (ArchiveService.ClassInfo classInfo : namedGame.classes().values()) {
      for (ArchiveService.MemberInfo member : classInfo.members()) {
        if ("method".equals(member.kind())
            && (member.access() & (Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE)) != 0) {
          originalSyntheticMethods.add(
              classInfo.name() + ":" + member.name() + ":" + member.descriptor());
        }
      }
    }
    Path classesRoot = context.recoveredClassesDir();
    if (!Files.isDirectory(classesRoot)) {
      throw new IOException(
          "Recovered classes are required for symbol-aware migration: " + classesRoot);
    }
    try (var paths = Files.walk(classesRoot)) {
      for (Path classFile : paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".class"))
          .sorted().toList()) {
        ClassNode node = new ClassNode(Opcodes.ASM9);
        new ClassReader(Files.readAllBytes(classFile)).accept(node, 0);
        for (MethodNode method : node.methods) {
          if ((method.access & (Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE)) != 0
              || originalSyntheticMethods.contains(
                  node.name + ":" + method.name + ":" + method.desc)) {
            continue;
          }
          for (AbstractInsnNode instruction = method.instructions.getFirst();
              instruction != null; instruction = instruction.getNext()) {
            if (instruction instanceof MethodInsnNode call) {
              Target target = byBytecodeKey.get(
                  call.owner + ":" + call.name + ":" + call.desc);
              if (target != null) {
                counts.merge(target.key(), 1, Integer::sum);
                locations.computeIfAbsent(target.key(), ignored -> new ArrayList<>()).add(
                    node.name + "." + method.name + method.desc);
                callers.add(node.name);
              }
            } else if (instruction instanceof InvokeDynamicInsnNode dynamic) {
              for (Object argument : dynamic.bsmArgs) {
                if (argument instanceof Handle handle) {
                  Target target = byBytecodeKey.get(
                      handle.getOwner() + ":" + handle.getName() + ":" + handle.getDesc());
                  if (target != null) {
                    counts.merge(target.key(), 1, Integer::sum);
                    locations.computeIfAbsent(target.key(), ignored -> new ArrayList<>()).add(
                        node.name + "." + method.name + method.desc + " invokedynamic");
                    callers.add(node.name);
                  }
                }
              }
            }
          }
        }
      }
    }
    Map<String, List<String>> immutableLocations = new TreeMap<>();
    locations.forEach((key, value) -> immutableLocations.put(key, List.copyOf(value)));
    return new ExpectedReferences(
        Map.copyOf(counts), Map.copyOf(immutableLocations), Set.copyOf(callers));
  }

  private Map<String, String> readNamedClasses() throws IOException {
    Map<String, String> classes = new HashMap<>();
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (line.startsWith("c\t")) {
        String[] values = line.split("\t", -1);
        classes.put(values[1], values[3]);
      }
    }
    return classes;
  }

  private String remapMethodDescriptor(String descriptor, Map<String, String> classes) {
    Type method = Type.getMethodType(descriptor);
    Type[] arguments = method.getArgumentTypes();
    Type[] mappedArguments = new Type[arguments.length];
    for (int index = 0; index < arguments.length; index++) {
      mappedArguments[index] = remapType(arguments[index], classes);
    }
    return Type.getMethodDescriptor(remapType(method.getReturnType(), classes), mappedArguments);
  }

  private Type remapType(Type type, Map<String, String> classes) {
    if (type.getSort() == Type.ARRAY) {
      Type element = remapType(type.getElementType(), classes);
      return Type.getType("[".repeat(type.getDimensions()) + element.getDescriptor());
    }
    if (type.getSort() == Type.OBJECT) {
      return Type.getObjectType(classes.getOrDefault(type.getInternalName(), type.getInternalName()));
    }
    return type;
  }

  private String topLevelClass(String internalName) {
    int inner = internalName.indexOf('$');
    return inner < 0 ? internalName : internalName.substring(0, inner);
  }

  @FunctionalInterface
  private interface ResolvedMethodSupplier {
    ResolvedMethodDeclaration resolve();
  }

  record Target(
      MemberMigration migration,
      String ownerInternal,
      String ownerQualified,
      String namedDescriptor) {
    String key() {
      return migration.key();
    }

    String resolvedKey() {
      return ownerQualified + ":" + migration.currentName() + ":" + namedDescriptor;
    }

    String bytecodeKey() {
      return ownerInternal + ":" + migration.currentName() + ":" + namedDescriptor;
    }
  }

  record ExpectedReferences(
      Map<String, Integer> referencesByTarget,
      Map<String, List<String>> locationsByTarget,
      Set<String> callerClasses) {
  }

  record TargetResult(
      String key,
      String owner,
      String descriptor,
      String previousName,
      String desiredName,
      int expectedReferences,
      List<String> expectedLocations,
      List<String> resolvedLocations,
      int renamedDeclarations,
      int renamedReferences) {
  }

  record MigrationResult(
      int targets,
      int changedFiles,
      List<TargetResult> results) {
  }

  private static final class MutableTargetResult {
    private final Target target;
    private final int expected;
    private final List<String> expectedLocations;
    private int declarations;
    private int references;
    private final List<String> resolvedLocations = new ArrayList<>();

    private MutableTargetResult(
        Target target, int expected, List<String> expectedLocations) {
      this.target = target;
      this.expected = expected;
      this.expectedLocations = expectedLocations;
    }

    private TargetResult snapshot() {
      return new TargetResult(
          target.key(),
          target.migration().ownerNamed(),
          target.namedDescriptor(),
          target.migration().currentName(),
          target.migration().desiredName(),
          expected,
          expectedLocations,
          List.copyOf(resolvedLocations),
          declarations,
          references);
    }

    private void addReference(String location) {
      references++;
      resolvedLocations.add(location);
    }
  }
}
