package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.HybridService.OverlayManifest;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

final class SaveCompatibilityService {
  private final ProjectContext context;

  SaveCompatibilityService(ProjectContext context) {
    this.context = context;
  }

  void verify() throws Exception {
    new SaveFixtureService(context).verify();
    Path probeJar = context.buildDir().resolve("libs/brasfoot-runtime-probe.jar");
    if (!Files.isRegularFile(probeJar)) {
      throw new IOException("Compatibility probe JAR not found: " + probeJar);
    }

    OverlayManifest manifest = readManifest();
    ArchiveData original = new ArchiveService().analyze(context.normalizedGameJar());
    List<String> classes = new ArrayList<>();
    List<String> serializableClasses = new ArrayList<>();
    for (HybridService.OverlayEntry overlay : manifest.overlays()) {
      String name = overlay.entry().substring(0, overlay.entry().length() - 6);
      ClassInfo info = original.classes().get(name);
      if (info != null && (name.startsWith("est/")
          || info.interfaces().contains("java/io/Serializable"))) {
        String binaryName = name.replace('/', '.');
        classes.add(binaryName);
        if (info.interfaces().contains("java/io/Serializable")) {
          serializableClasses.add(binaryName);
        }
      }
    }
    if (classes.isEmpty()) {
      throw new IllegalStateException("No recovered serializable classes to verify");
    }

    Path output = context.reportsDir().resolve("save-compatibility.log");
    List<String> command = new ArrayList<>();
    command.add(context.java8Executable().toString());
    command.add("-cp");
    command.add(probeJar.toString());
    command.add("com.brasfoot.reconstruction.agent.SaveCompatibilityProbe");
    command.add(context.hybridJar().toString());
    command.add(context.referenceSaveDir().resolve("reference.info").toString());
    command.addAll(classes);

    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    builder.redirectOutput(output.toFile());
    Process process = builder.start();
    if (!process.waitFor(30, java.util.concurrent.TimeUnit.SECONDS)) {
      process.destroyForcibly();
      throw new IllegalStateException("Save compatibility probe timed out");
    }
    String log = Files.readString(output, StandardCharsets.UTF_8);
    if (process.exitValue() != 0) {
      throw new IllegalStateException("Save compatibility probe failed:\n" + log);
    }
    for (String className : classes) {
      if (!log.contains("CLASS " + className + " ")) {
        throw new IllegalStateException("Compatibility probe did not verify " + className);
      }
    }
    for (String className : serializableClasses) {
      if (!log.contains("CLASS " + className + " serializable=true")) {
        throw new IllegalStateException("Serializable contract was lost for " + className);
      }
    }
    if (!log.contains("FIXTURE est.InfoArquivoSalvoType uid=1")) {
      throw new IllegalStateException("Recovered SavedGameInfo could not read reference.info");
    }
    System.out.println("Save compatibility passed on Java 8: " + classes.size()
        + " recovered data classes loaded, " + serializableClasses.size()
        + " serialization contracts checked, and reference.info deserialized.");
  }

  private OverlayManifest readManifest() throws IOException {
    Path path = context.hybridRoot().resolve("overlay-manifest.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      OverlayManifest manifest = ProjectContext.JSON.fromJson(reader, OverlayManifest.class);
      if (manifest == null || manifest.overlays() == null) {
        throw new IOException("Invalid overlay manifest: " + path);
      }
      return manifest;
    }
  }
}
