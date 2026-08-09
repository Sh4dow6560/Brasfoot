package com.brasfoot.reconstruction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

final class SemanticMemberSourceMigrationServiceTest {
  @Test
  void ownerMigrationDoesNotRenameMethodsOnOtherReceivers() {
    String source = "void w(Object value) { w(value); Other.w(false); state.w(1); }";
    String migrated = SemanticMemberSourceMigrationService.migrateOwnerMethodReferences(
        source, "w", "activate");

    assertEquals(
        "void activate(Object value) { activate(value); Other.w(false); state.w(1); }",
        migrated);
  }
}
