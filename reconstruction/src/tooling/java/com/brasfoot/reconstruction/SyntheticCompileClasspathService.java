package com.brasfoot.reconstruction;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class SyntheticCompileClasspathService {
  private final ProjectContext context;

  SyntheticCompileClasspathService(ProjectContext context) {
    this.context = context;
  }

  void build() throws IOException {
    Map<String, byte[]> entries = ZipSupport.readEntries(context.namedGameJar());
    int[] exposed = {0};
    for (Map.Entry<String, byte[]> entry : entries.entrySet()) {
      if (!entry.getKey().endsWith(".class")) {
        continue;
      }
      ClassReader reader = new ClassReader(entry.getValue());
      ClassWriter writer = new ClassWriter(0);
      reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
        @Override
        public FieldVisitor visitField(
            int access, String name, String descriptor, String signature, Object value) {
          if ((access & Opcodes.ACC_SYNTHETIC) != 0) {
            access &= ~Opcodes.ACC_SYNTHETIC;
            exposed[0]++;
          }
          return super.visitField(access, name, descriptor, signature, value);
        }

        @Override
        public MethodVisitor visitMethod(
            int access, String name, String descriptor, String signature, String[] exceptions) {
          if ((access & Opcodes.ACC_SYNTHETIC) != 0
              && (access & Opcodes.ACC_BRIDGE) == 0) {
            access &= ~Opcodes.ACC_SYNTHETIC;
            exposed[0]++;
          }
          return super.visitMethod(access, name, descriptor, signature, exceptions);
        }
      }, 0);
      entry.setValue(writer.toByteArray());
    }
    Path output = context.buildDir().resolve("work/named/bf22-23-compile-support.jar");
    ZipSupport.writeArchive(output, entries);
    System.out.println("Built compile-only classpath exposing " + exposed[0]
        + " synthetic fields and accessor methods.");
  }
}
