package com.brasfoot.reconstruction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

final class ZipSupportTest {
  @TempDir
  Path temporaryDirectory;

  @Test
  void copyGameTreePreservesHybridSaves() throws Exception {
    Path source = temporaryDirectory.resolve("original");
    Path target = temporaryDirectory.resolve("hybrid");
    Files.createDirectories(source.resolve("teams"));
    Files.createDirectories(target.resolve("sav"));
    Files.writeString(source.resolve("teams/team.ban"), "team", StandardCharsets.UTF_8);
    Files.writeString(source.resolve("game.exe"), "binary", StandardCharsets.UTF_8);
    Files.writeString(target.resolve("sav/career.s22"), "save", StandardCharsets.UTF_8);
    Files.writeString(target.resolve("stale.txt"), "stale", StandardCharsets.UTF_8);

    ZipSupport.copyGameTree(source, target, "game.exe");

    assertEquals("save", Files.readString(target.resolve("sav/career.s22")));
    assertEquals("team", Files.readString(target.resolve("teams/team.ban")));
    assertFalse(Files.exists(target.resolve("game.exe")));
    assertFalse(Files.exists(target.resolve("stale.txt")));
  }
}
