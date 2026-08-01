package com.brasfoot.reconstruction;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

final class SyntheticMemberService {
  private final ProjectContext context;

  SyntheticMemberService(ProjectContext context) {
    this.context = context;
  }

  void markConfiguredMethods(Path archive) throws IOException {
    Configuration configuration = readConfiguration();
    if (configuration.schemaVersion() != 1 || configuration.classes() == null) {
      throw new IOException("Unsupported synthetic member configuration");
    }
    Map<String, byte[]> entries = ZipSupport.readEntries(archive);
    int marked = 0;
    for (ClassMembers classMembers : configuration.classes()) {
      String entry = classMembers.namedClass() + ".class";
      byte[] bytecode = entries.get(entry);
      if (bytecode == null) {
        throw new IOException("Synthetic member class not compiled: " + classMembers.namedClass());
      }
      Set<String> expected = new HashSet<>();
      for (MethodSpec method : classMembers.methods()) {
        expected.add(method.name() + method.descriptor());
      }
      Set<String> found = new HashSet<>();
      ClassReader reader = new ClassReader(bytecode);
      ClassWriter writer = new ClassWriter(0);
      reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
        @Override
        public MethodVisitor visitMethod(
            int access, String name, String descriptor, String signature, String[] exceptions) {
          if (expected.contains(name + descriptor)) {
            access |= Opcodes.ACC_SYNTHETIC;
            found.add(name + descriptor);
          }
          return super.visitMethod(access, name, descriptor, signature, exceptions);
        }
      }, 0);
      if (!found.equals(expected)) {
        Set<String> missing = new HashSet<>(expected);
        missing.removeAll(found);
        throw new IllegalStateException("Synthetic methods not found in "
            + classMembers.namedClass() + ": " + missing);
      }
      entries.put(entry, writer.toByteArray());
      marked += found.size();
    }
    int originalMembersMarked = restoreOriginalSyntheticMembers(entries);
    ZipSupport.writeArchive(archive, entries);
    System.out.println("Marked " + marked + " restored accessor methods and "
        + originalMembersMarked + " original synthetic members from bytecode.");
  }

  private int restoreOriginalSyntheticMembers(Map<String, byte[]> compiledEntries)
      throws IOException {
    Map<String, byte[]> originalEntries = ZipSupport.readEntries(context.namedGameJar());
    int restored = 0;
    for (Map.Entry<String, byte[]> compiledEntry : compiledEntries.entrySet()) {
      if (!compiledEntry.getKey().endsWith(".class")) {
        continue;
      }
      byte[] original = originalEntries.get(compiledEntry.getKey());
      if (original == null) {
        continue;
      }
      ClassNode originalClass = new ClassNode(Opcodes.ASM9);
      new ClassReader(original).accept(originalClass, 0);
      ClassNode compiledClass = new ClassNode(Opcodes.ASM9);
      new ClassReader(compiledEntry.getValue()).accept(compiledClass, 0);

      Map<String, FieldNode> originalFields = new HashMap<>();
      for (FieldNode field : originalClass.fields) {
        if ((field.access & Opcodes.ACC_SYNTHETIC) != 0) {
          originalFields.put(field.name + field.desc, field);
        }
      }
      for (FieldNode field : compiledClass.fields) {
        FieldNode originalField = originalFields.get(field.name + field.desc);
        if (originalField != null && (field.access & Opcodes.ACC_SYNTHETIC) == 0) {
          field.access |= Opcodes.ACC_SYNTHETIC;
          restored++;
        }
      }

      Map<String, Integer> compiledMethodIndexes = new HashMap<>();
      for (int index = 0; index < compiledClass.methods.size(); index++) {
        MethodNode method = compiledClass.methods.get(index);
        compiledMethodIndexes.put(method.name + method.desc, index);
      }
      for (MethodNode originalMethod : originalClass.methods) {
        if ((originalMethod.access & Opcodes.ACC_SYNTHETIC) == 0) {
          continue;
        }
        MethodNode replacement = cloneMethod(originalMethod);
        Integer index = compiledMethodIndexes.get(originalMethod.name + originalMethod.desc);
        if (index == null) {
          compiledClass.methods.add(replacement);
        } else {
          compiledClass.methods.set(index, replacement);
        }
        restored++;
      }

      ClassWriter writer = new ClassWriter(0);
      compiledClass.accept(writer);
      compiledEntry.setValue(writer.toByteArray());
    }
    return restored;
  }

  private MethodNode cloneMethod(MethodNode source) {
    MethodNode clone = new MethodNode(
        Opcodes.ASM9,
        source.access,
        source.name,
        source.desc,
        source.signature,
        source.exceptions == null ? null : source.exceptions.toArray(String[]::new));
    source.accept(clone);
    return clone;
  }

  private Configuration readConfiguration() throws IOException {
    Path path = context.projectDir().resolve("config/synthetic-members.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      Configuration configuration = ProjectContext.JSON.fromJson(reader, Configuration.class);
      if (configuration == null) {
        throw new IOException("Invalid synthetic member configuration: " + path);
      }
      return configuration;
    }
  }

  record Configuration(int schemaVersion, List<ClassMembers> classes) {
  }

  record ClassMembers(String namedClass, List<MethodSpec> methods) {
  }

  record MethodSpec(String name, String descriptor) {
  }
}
