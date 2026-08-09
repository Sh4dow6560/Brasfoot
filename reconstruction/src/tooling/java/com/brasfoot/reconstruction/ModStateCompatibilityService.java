package com.brasfoot.reconstruction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class ModStateCompatibilityService {
  private static final String SUCCESS_MARKER =
      "MOD_STATE_API missing=true current=true corrupt=true migrated=true "
          + "unsupported=true atomic=true revision=true utf8=true defaultsDisabled=true "
          + "boardObjectives=true monthly=true idempotent=true jobSecurity=true "
          + "sponsorships=true offers=true contracts=true bonuses=true payments=true "
          + "transition=true";

  private final ProjectContext context;

  ModStateCompatibilityService(ProjectContext context) {
    this.context = context;
  }

  void verify() throws Exception {
    Path probeJar = context.buildDir().resolve("libs/brasfoot-runtime-probe.jar");
    if (!Files.isRegularFile(probeJar) || !Files.isRegularFile(context.hybridJar())) {
      throw new IOException("Mod state compatibility runtime is not assembled");
    }
    Path workRoot = context.buildDir().resolve("work/mod-state-compatibility");
    Path allowedRoot = context.buildDir().resolve("work");
    if (Files.exists(workRoot)) {
      ZipSupport.deleteTreeWithin(workRoot, allowedRoot);
    }
    Files.createDirectories(workRoot);
    Path output = context.reportsDir().resolve("mod-state-compatibility.log");
    Files.createDirectories(output.getParent());

    List<String> command = List.of(
        context.java8Executable().toString(),
        "-cp",
        probeJar + File.pathSeparator + context.hybridJar(),
        "com.brasfoot.reconstruction.agent.ModStateCompatibilityProbe",
        workRoot.toString());
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    builder.redirectOutput(output.toFile());
    Process process = builder.start();
    if (!process.waitFor(30, TimeUnit.SECONDS)) {
      process.destroyForcibly();
      throw new IllegalStateException("Mod state compatibility probe timed out");
    }
    String log = Files.readString(output, StandardCharsets.UTF_8);
    if (process.exitValue() != 0 || !log.contains(SUCCESS_MARKER)) {
      throw new IllegalStateException(
          "Mod state compatibility probe failed:" + System.lineSeparator() + log);
    }
    ZipSupport.deleteTreeWithin(workRoot, allowedRoot);
    System.out.println("Mod state compatibility passed on Java 8: missing, current, corrupt, "
        + "migrated and unsupported sidecars preserve the original fallback.");
  }
}
