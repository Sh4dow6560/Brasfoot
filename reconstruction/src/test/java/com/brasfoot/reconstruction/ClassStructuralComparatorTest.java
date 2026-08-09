package com.brasfoot.reconstruction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class ClassStructuralComparatorTest {
  @Test
  void treatsRelocatedClassesAndReferencesAsEquivalent() {
    byte[] baseline = classBytes("sample/Base", "sample/Dependency", 7, false);
    byte[] candidate = classBytes("variant/Base2", "variant/Dependency2", 7, false);

    ClassStructuralComparator.Comparison comparison = ClassStructuralComparator.compare(
        baseline,
        candidate,
        Map.of(
            "variant/Base2", "sample/Base",
            "variant/Dependency2", "sample/Dependency"));

    assertTrue(comparison.apiEquivalent());
    assertTrue(comparison.behaviorEquivalent());
  }

  @Test
  void detectsBehaviorChangesWithoutReportingApiChanges() {
    byte[] baseline = classBytes("sample/Base", "sample/Dependency", 7, false);
    byte[] candidate = classBytes("sample/Base", "sample/Dependency", 8, false);

    ClassStructuralComparator.Comparison comparison = ClassStructuralComparator.compare(
        baseline, candidate, Map.of());

    assertTrue(comparison.apiEquivalent());
    assertFalse(comparison.behaviorEquivalent());
    assertFalse(comparison.changedMethods().isEmpty());
  }

  @Test
  void detectsApiChanges() {
    byte[] baseline = classBytes("sample/Base", "sample/Dependency", 7, false);
    byte[] candidate = classBytes("sample/Base", "sample/Dependency", 7, true);

    ClassStructuralComparator.Comparison comparison = ClassStructuralComparator.compare(
        baseline, candidate, Map.of());

    assertFalse(comparison.apiEquivalent());
    assertFalse(comparison.addedMembers().isEmpty());
  }

  private byte[] classBytes(
      String className, String dependencyName, int constant, boolean addMethod) {
    ClassWriter writer = new ClassWriter(0);
    writer.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

    MethodVisitor constructor = writer.visitMethod(
        Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
    constructor.visitCode();
    constructor.visitVarInsn(Opcodes.ALOAD, 0);
    constructor.visitMethodInsn(
        Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    constructor.visitInsn(Opcodes.RETURN);
    constructor.visitMaxs(1, 1);
    constructor.visitEnd();

    MethodVisitor value = writer.visitMethod(
        Opcodes.ACC_PUBLIC, "value", "()I", null, null);
    value.visitCode();
    value.visitFieldInsn(Opcodes.GETSTATIC, dependencyName, "VALUE", "I");
    value.visitLdcInsn(constant);
    value.visitInsn(Opcodes.IADD);
    value.visitInsn(Opcodes.IRETURN);
    value.visitMaxs(2, 1);
    value.visitEnd();

    if (addMethod) {
      MethodVisitor added = writer.visitMethod(
          Opcodes.ACC_PUBLIC, "added", "()V", null, null);
      added.visitCode();
      added.visitInsn(Opcodes.RETURN);
      added.visitMaxs(0, 1);
      added.visitEnd();
    }

    writer.visitEnd();
    return writer.toByteArray();
  }
}
