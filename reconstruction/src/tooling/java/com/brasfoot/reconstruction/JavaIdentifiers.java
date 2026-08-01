package com.brasfoot.reconstruction;

import java.util.Set;

final class JavaIdentifiers {
  private static final Set<String> RESERVED = Set.of(
      "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
      "class", "const", "continue", "default", "do", "double", "else", "enum",
      "extends", "final", "finally", "float", "for", "goto", "if", "implements",
      "import", "instanceof", "int", "interface", "long", "native", "new", "package",
      "private", "protected", "public", "return", "short", "static", "strictfp",
      "super", "switch", "synchronized", "this", "throw", "throws", "transient",
      "try", "void", "volatile", "while", "true", "false", "null", "_",
      "exports", "module", "non-sealed", "open", "opens", "permits", "provides",
      "record", "requires", "sealed", "to", "transitive", "uses", "var", "with",
      "yield");

  private JavaIdentifiers() {
  }

  static boolean isLegal(String value) {
    if (value == null || value.isEmpty() || RESERVED.contains(value)) {
      return false;
    }
    if (!Character.isJavaIdentifierStart(value.charAt(0))) {
      return false;
    }
    for (int index = 1; index < value.length(); index++) {
      if (!Character.isJavaIdentifierPart(value.charAt(index))) {
        return false;
      }
    }
    return true;
  }

  static boolean isLegalInternalClassName(String internalName) {
    for (String part : internalName.split("/")) {
      if (!isLegal(part)) {
        return false;
      }
    }
    return true;
  }

  static String legalMemberName(String kind, String original) {
    String normalized = original.replaceAll("[^A-Za-z0-9_$]", "_");
    if (normalized.isEmpty() || !Character.isJavaIdentifierStart(normalized.charAt(0))) {
      normalized = "id_" + normalized;
    }
    return kind + "_kw_" + normalized;
  }
}
