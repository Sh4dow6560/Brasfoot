package com.brasfoot.reconstruction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JavaIdentifiersTest {
  @Test
  void rejectsKeywordsAndInvalidIdentifiers() {
    assertFalse(JavaIdentifiers.isLegal("do"));
    assertFalse(JavaIdentifiers.isLegal("if"));
    assertFalse(JavaIdentifiers.isLegal("1class"));
    assertFalse(JavaIdentifiers.isLegal("non-sealed"));
  }

  @Test
  void acceptsGeneratedIdentifiers() {
    assertTrue(JavaIdentifiers.isLegal("C0001"));
    assertTrue(JavaIdentifiers.isLegal("method_kw_do"));
    assertTrue(JavaIdentifiers.isLegalInternalClassName("bf22/intermediary/C0001"));
  }
}
