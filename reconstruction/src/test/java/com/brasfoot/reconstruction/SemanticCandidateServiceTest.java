package com.brasfoot.reconstruction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

class SemanticCandidateServiceTest {
  @Test
  void detectsExactInstanceGetterAndSetter() {
    MethodNode getter = new MethodNode(Opcodes.ASM9, Opcodes.ACC_PUBLIC,
        "a", "()I", null, null);
    getter.visitVarInsn(Opcodes.ALOAD, 0);
    getter.visitFieldInsn(Opcodes.GETFIELD, "best/Test", "x", "I");
    getter.visitInsn(Opcodes.IRETURN);

    MethodNode setter = new MethodNode(Opcodes.ASM9, Opcodes.ACC_PUBLIC,
        "b", "(I)V", null, null);
    setter.visitVarInsn(Opcodes.ALOAD, 0);
    setter.visitVarInsn(Opcodes.ILOAD, 1);
    setter.visitFieldInsn(Opcodes.PUTFIELD, "best/Test", "x", "I");
    setter.visitInsn(Opcodes.RETURN);

    SemanticCandidateService.Accessor getterResult =
        SemanticCandidateService.detectAccessor("best/Test", getter);
    SemanticCandidateService.Accessor setterResult =
        SemanticCandidateService.detectAccessor("best/Test", setter);

    assertEquals("getter", getterResult.kind());
    assertEquals("x", getterResult.fieldName());
    assertEquals("setter", setterResult.kind());
    assertEquals("x", setterResult.fieldName());
  }

  @Test
  void rejectsAccessorWithAdditionalBehavior() {
    MethodNode method = new MethodNode(Opcodes.ASM9, Opcodes.ACC_PUBLIC,
        "a", "()I", null, null);
    method.visitVarInsn(Opcodes.ALOAD, 0);
    method.visitFieldInsn(Opcodes.GETFIELD, "best/Test", "x", "I");
    method.visitInsn(Opcodes.ICONST_1);
    method.visitInsn(Opcodes.IADD);
    method.visitInsn(Opcodes.IRETURN);

    assertNull(SemanticCandidateService.detectAccessor("best/Test", method));
  }

  @Test
  void derivesBeanNamesFromKnownSemanticFields() {
    assertEquals("getReputation",
        SemanticCandidateService.accessorName("getter", "reputation", "I"));
    assertEquals("isActive",
        SemanticCandidateService.accessorName("getter", "active", "Z"));
    assertEquals("setActive",
        SemanticCandidateService.accessorName("setter", "active", "Z"));
  }
}
