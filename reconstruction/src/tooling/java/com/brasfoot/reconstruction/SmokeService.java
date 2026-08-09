package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.HybridService.OverlayManifest;
import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

final class SmokeService {
  private final ProjectContext context;

  SmokeService(ProjectContext context) {
    this.context = context;
  }

  void staticSmoke() throws IOException {
    new MappingService(context).validateExisting();
    verifyMappingRoundTrip();
    if (!Files.isRegularFile(context.hybridJar())) {
      throw new IOException("Hybrid JAR not found: " + context.hybridJar());
    }

    OverlayManifest manifest;
    Path manifestPath = context.hybridRoot().resolve("overlay-manifest.json");
    try (Reader reader = Files.newBufferedReader(manifestPath, StandardCharsets.UTF_8)) {
      manifest = ProjectContext.JSON.fromJson(reader, OverlayManifest.class);
    }
    if (manifest == null || manifest.overlays() == null || manifest.overlays().isEmpty()) {
      throw new IllegalStateException("Overlay manifest is empty");
    }

    Map<String, byte[]> original = ZipSupport.readEntries(context.normalizedGameJar());
    Map<String, byte[]> hybrid = ZipSupport.readEntries(context.hybridJar());
    long classCount = hybrid.keySet().stream().filter(name -> name.endsWith(".class")).count();
    List<HybridService.OverlayEntry> addedClasses = manifest.overlays().stream()
        .filter(HybridService.OverlayEntry::added)
        .toList();
    for (HybridService.OverlayEntry overlay : addedClasses) {
      if (!overlay.entry().startsWith("mod/extension/")) {
        throw new IllegalStateException(
            "Added class is outside mod/extension: " + overlay.entry());
      }
    }
    long expectedClassCount = 1038L + addedClasses.size();
    if (classCount != expectedClassCount) {
      throw new IllegalStateException("Expected " + expectedClassCount
          + " classes in hybrid JAR, got " + classCount);
    }
    verifyExtensionHooks(hybrid);

    byte[] recovered = hybrid.get(HybridService.ORIGINAL_COMPONENT);
    if (recovered == null) {
      throw new IllegalStateException("Missing recovered class " + HybridService.ORIGINAL_COMPONENT);
    }
    ClassReader reader = new ClassReader(recovered);
    if (!"components/ar".equals(reader.getClassName())) {
      throw new IllegalStateException("Recovered class has wrong internal name: "
          + reader.getClassName());
    }
    boolean handler = java.util.Arrays.asList(reader.getInterfaces())
        .contains("java/lang/Thread$UncaughtExceptionHandler");
    if (!handler) {
      throw new IllegalStateException("Recovered class lost UncaughtExceptionHandler interface");
    }
    if (Hashing.sha256(recovered).equals(Hashing.sha256(original.get(HybridService.ORIGINAL_COMPONENT)))) {
      throw new IllegalStateException("Recovered class is still the original bytecode");
    }

    var overlayNames = manifest.overlays().stream().map(HybridService.OverlayEntry::entry)
        .collect(java.util.stream.Collectors.toSet());
    for (Map.Entry<String, byte[]> entry : original.entrySet()) {
      if (overlayNames.contains(entry.getKey())) {
        continue;
      }
      byte[] current = hybrid.get(entry.getKey());
      if (current == null || !Hashing.sha256(entry.getValue()).equals(Hashing.sha256(current))) {
        throw new IllegalStateException("Static smoke found changed non-overlay: " + entry.getKey());
      }
    }
    System.out.println("Static smoke passed: " + classCount
        + " classes, recovered component present, "
        + manifest.unchangedEntries() + " unchanged entries verified.");
  }

  private void verifyExtensionHooks(Map<String, byte[]> hybrid) {
    Set<String> scheduleCalls = methodCalls(hybrid, "best/a.class");
    requireCall(
        scheduleCalls,
        "mod/extension/board/BoardObjectivesBridge.evaluateMonthly(II)I",
        "monthly board evaluation");
    requireCall(
        scheduleCalls,
        "mod/extension/sponsorship/SponsorshipBridge.processMonthly(II)I",
        "monthly sponsorship payment");

    Set<String> clubCalls = methodCalls(hybrid, "best/ah.class");
    requireCall(
        clubCalls,
        "mod/extension/sponsorship/SponsorshipBridge.replaceLegacySeasonRevenue(Lbest/ah;)Z",
        "legacy sponsorship replacement");

    Set<String> mainPanelCalls = methodCalls(hybrid, "a/eg.class");
    requireCall(
        mainPanelCalls,
        "mod/extension/ui/ModSettingsAction.<init>(Ljava/awt/Component;)V",
        "extension settings menu");

    Set<String> persistenceCalls = methodCalls(hybrid, "c/a.class");
    requireCall(
        persistenceCalls,
        "mod/extension/state/ModRuntime.startNewCareer()V",
        "new-career state reset");
    requireCall(
        persistenceCalls,
        "mod/extension/state/ModRuntime.attach(Ljava/nio/file/Path;)"
            + "Lmod/extension/state/ModStateStore$LoadStatus;",
        "sidecar load");
    requireCall(
        persistenceCalls,
        "mod/extension/state/ModRuntime.persist(Ljava/nio/file/Path;)Z",
        "sidecar save");

    Set<String> inboxTemplates = stringConstants(hybrid, "best/ar.class");
    if (!inboxTemplates.contains("Avalia\u00e7\u00e3o mensal da diretoria")
        || !inboxTemplates.contains("A diretoria concluiu a avalia\u00e7\u00e3o mensal.")
        || !inboxTemplates.contains("Contrato de patroc\u00ednio")
        || !inboxTemplates.contains("B\u00f4nus de patroc\u00ednio")
        || !inboxTemplates.contains("Um novo contrato de patroc\u00ednio foi assinado.")
        || !inboxTemplates.contains(
            "Uma meta do contrato de patroc\u00ednio foi cumprida.")) {
      throw new IllegalStateException("Hybrid JAR is missing extension inbox templates");
    }
    Set<String> boardBridgeCalls = methodCalls(
        hybrid, "mod/extension/board/BoardObjectivesBridge.class");
    if (boardBridgeCalls.stream().noneMatch(call -> call.startsWith("components/as.<init>("))) {
      throw new IllegalStateException("Hybrid JAR is missing board inbox report hook");
    }
  }

  private Set<String> methodCalls(Map<String, byte[]> hybrid, String entry) {
    byte[] bytecode = hybrid.get(entry);
    if (bytecode == null) {
      throw new IllegalStateException("Hybrid JAR is missing hook owner " + entry);
    }
    ClassNode owner = new ClassNode(Opcodes.ASM9);
    new ClassReader(bytecode).accept(owner, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
    Set<String> calls = new TreeSet<>();
    for (MethodNode method : owner.methods) {
      for (var instruction : method.instructions) {
        if (instruction instanceof MethodInsnNode call) {
          calls.add(call.owner + "." + call.name + call.desc);
        }
      }
    }
    return calls;
  }

  private void requireCall(Set<String> calls, String expected, String purpose) {
    if (!calls.contains(expected)) {
      throw new IllegalStateException(
          "Hybrid JAR is missing " + purpose + " hook: " + expected);
    }
  }

  private Set<String> stringConstants(Map<String, byte[]> hybrid, String entry) {
    byte[] bytecode = hybrid.get(entry);
    if (bytecode == null) {
      throw new IllegalStateException("Hybrid JAR is missing template owner " + entry);
    }
    ClassNode owner = new ClassNode(Opcodes.ASM9);
    new ClassReader(bytecode).accept(owner, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
    Set<String> constants = new TreeSet<>();
    for (MethodNode method : owner.methods) {
      for (var instruction : method.instructions) {
        if (instruction instanceof LdcInsnNode constant && constant.cst instanceof String value) {
          constants.add(value);
        }
      }
    }
    return constants;
  }

  private void verifyMappingRoundTrip() throws IOException {
    Path roundTrip = context.buildDir().resolve("work/roundtrip/bf22-23-official.jar");
    new RemapService(context).remapNamedGameToOfficial(roundTrip);
    ArchiveService archiveService = new ArchiveService();
    ArchiveData expected = archiveService.analyze(context.normalizedGameJar());
    ArchiveData actual = archiveService.analyze(roundTrip);
    if (!expected.classes().keySet().equals(actual.classes().keySet())) {
      throw new IllegalStateException("Mapping round-trip changed the class set");
    }
    for (String name : expected.classes().keySet()) {
      ClassInfo left = expected.classes().get(name);
      ClassInfo right = actual.classes().get(name);
      if (left.access() != right.access()
          || !java.util.Objects.equals(left.superName(), right.superName())
          || !left.interfaces().equals(right.interfaces())
          || !left.members().equals(right.members())) {
        throw new IllegalStateException("Mapping round-trip changed class structure: " + name);
      }
    }
    if (!expected.resources().keySet().equals(actual.resources().keySet())) {
      throw new IllegalStateException("Mapping round-trip changed the resource set");
    }
    for (String name : expected.resources().keySet()) {
      if (!expected.resources().get(name).sha256().equals(actual.resources().get(name).sha256())) {
        throw new IllegalStateException("Mapping round-trip changed resource: " + name);
      }
    }
  }

  void runtimeSmoke() throws Exception {
    Path agentJar = context.buildDir().resolve("libs/brasfoot-runtime-probe.jar");
    if (!Files.isRegularFile(agentJar)) {
      throw new IOException("Runtime agent not found: " + agentJar);
    }
    Path probeLog = context.reportsDir().resolve("runtime-probe.log");
    Path processLog = context.reportsDir().resolve("runtime-process.log");
    Files.createDirectories(context.reportsDir());
    Files.deleteIfExists(probeLog);
    Files.deleteIfExists(processLog);
    Files.deleteIfExists(context.hybridRoot().resolve("erros.log"));

    OverlayManifest manifest = readOverlayManifest();
    Set<String> targets = new TreeSet<>();
    targets.add("best/h2");
    manifest.overlays().stream()
        .map(HybridService.OverlayEntry::entry)
        .map(entry -> entry.substring(0, entry.length() - ".class".length()))
        .forEach(targets::add);

    ProcessBuilder builder = new ProcessBuilder(
        context.java8Executable().toString(),
        "-javaagent:" + agentJar + "=" + probeLog + "|" + String.join(",", targets),
        "-jar",
        context.hybridJar().getFileName().toString());
    builder.directory(context.hybridRoot().toFile());
    builder.redirectErrorStream(true);
    builder.redirectOutput(processLog.toFile());
    Process process = builder.start();

    boolean loaded = false;
    Instant deadline = Instant.now().plus(Duration.ofSeconds(25));
    try {
      while (Instant.now().isBefore(deadline)) {
        if (Files.isRegularFile(probeLog)) {
          String text = Files.readString(probeLog, StandardCharsets.UTF_8);
          if (text.contains("LOADED best/h2 ") && text.contains("LOADED components/ar ")) {
            loaded = true;
            break;
          }
        }
        if (!process.isAlive()) {
          break;
        }
        Thread.sleep(250L);
      }
    } finally {
      if (process.isAlive()) {
        process.destroy();
        if (!process.waitFor(3, java.util.concurrent.TimeUnit.SECONDS)) {
          process.destroyForcibly();
          process.waitFor(3, java.util.concurrent.TimeUnit.SECONDS);
        }
      }
      terminateProbedProcess(probeLog);
    }

    if (!loaded) {
      String output = Files.isRegularFile(processLog)
          ? Files.readString(processLog, StandardCharsets.UTF_8) : "<no process output>";
      throw new IllegalStateException("Runtime did not load expected classes. Output:\n" + output);
    }
    String expected = Hashing.sha256(
        ZipSupport.readEntries(context.hybridJar()).get(HybridService.ORIGINAL_COMPONENT));
    String probe = Files.readString(probeLog, StandardCharsets.UTF_8);
    if (!probe.contains("LOADED components/ar " + expected)) {
      throw new IllegalStateException("Runtime loaded a different components/ar bytecode");
    }
    Set<String> loadedOverlays = new TreeSet<>();
    Map<String, byte[]> hybridEntries = ZipSupport.readEntries(context.hybridJar());
    for (HybridService.OverlayEntry overlay : manifest.overlays()) {
      String className = overlay.entry().substring(0, overlay.entry().length() - 6);
      String hash = Hashing.sha256(hybridEntries.get(overlay.entry()));
      if (probe.contains("LOADED " + className + " " + hash)) {
        loadedOverlays.add(className);
      } else if (probe.contains("LOADED " + className + " ")) {
        throw new IllegalStateException("Runtime loaded different bytecode for " + className);
      }
    }
    context.writeJson(context.reportsDir().resolve("runtime-overlay-report.json"),
        new RuntimeOverlayReport(
            manifest.overlays().size(), List.copyOf(loadedOverlays), List.copyOf(targets)));
    if (Files.exists(context.hybridRoot().resolve("erros.log"))) {
      throw new IllegalStateException("Game wrote erros.log during runtime smoke");
    }
    new AtlasService(context).verifyInputs();
    System.out.println("Runtime smoke passed: " + loadedOverlays.size() + " of "
        + manifest.overlays().size() + " recovered overlays loaded on Java 8 startup.");
  }

  private OverlayManifest readOverlayManifest() throws IOException {
    Path manifestPath = context.hybridRoot().resolve("overlay-manifest.json");
    try (Reader reader = Files.newBufferedReader(manifestPath, StandardCharsets.UTF_8)) {
      OverlayManifest manifest = ProjectContext.JSON.fromJson(reader, OverlayManifest.class);
      if (manifest == null || manifest.overlays() == null || manifest.overlays().isEmpty()) {
        throw new IllegalStateException("Overlay manifest is empty");
      }
      return manifest;
    }
  }

  private void terminateProbedProcess(Path probeLog) throws Exception {
    if (!Files.isRegularFile(probeLog)) {
      return;
    }
    String text = Files.readString(probeLog, StandardCharsets.UTF_8);
    for (String line : text.split("\\R")) {
      if (!line.startsWith("PID ")) {
        continue;
      }
      long pid = Long.parseLong(line.substring(4).trim());
      java.util.Optional<ProcessHandle> handle = ProcessHandle.of(pid);
      if (handle.isPresent() && handle.get().isAlive()) {
        handle.get().destroy();
        Thread.sleep(500L);
        if (handle.get().isAlive()) {
          handle.get().destroyForcibly();
        }
      }
    }
  }

  void runHybrid() throws Exception {
    ProcessBuilder builder = new ProcessBuilder(
        context.java8Executable().toString(), "-jar", context.hybridJar().getFileName().toString());
    builder.directory(context.hybridRoot().toFile());
    builder.inheritIO();
    int exit = builder.start().waitFor();
    if (exit != 0) {
      throw new IllegalStateException("Hybrid game exited with code " + exit);
    }
  }

  record RuntimeOverlayReport(
      int overlayCount,
      List<String> loadedOverlays,
      List<String> targets) {
  }
}
