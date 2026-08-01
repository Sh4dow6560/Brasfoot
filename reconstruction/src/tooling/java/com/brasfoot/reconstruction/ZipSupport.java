package com.brasfoot.reconstruction;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class ZipSupport {
  private ZipSupport() {
  }

  static void normalize(Path input, Path output) throws IOException {
    writeArchive(output, readEntries(input));
  }

  static Map<String, byte[]> readEntries(Path archivePath) throws IOException {
    Map<String, byte[]> result = new TreeMap<>();
    try (ZipFile archive = new ZipFile(archivePath.toFile())) {
      List<? extends ZipEntry> entries = Collections.list(archive.entries());
      entries.sort((left, right) -> left.getName().compareTo(right.getName()));
      for (ZipEntry entry : entries) {
        if (entry.isDirectory()) {
          continue;
        }
        try (InputStream input = archive.getInputStream(entry)) {
          result.put(entry.getName(), input.readAllBytes());
        }
      }
    }
    return result;
  }

  static void writeArchive(Path output, Map<String, byte[]> entries) throws IOException {
    Files.createDirectories(output.toAbsolutePath().getParent());
    Path temporary = output.resolveSibling(output.getFileName() + ".tmp");
    Files.deleteIfExists(temporary);
    try (ZipOutputStream zip = new ZipOutputStream(Files.newOutputStream(temporary))) {
      for (Map.Entry<String, byte[]> item : new TreeMap<>(entries).entrySet()) {
        ZipEntry entry = new ZipEntry(item.getKey());
        entry.setTime(0L);
        zip.putNextEntry(entry);
        zip.write(item.getValue());
        zip.closeEntry();
      }
    }
    Files.move(temporary, output, StandardCopyOption.REPLACE_EXISTING);
  }

  static void jarDirectory(Path classesDirectory, Path output) throws IOException {
    if (!Files.isDirectory(classesDirectory)) {
      throw new IOException("Compiled classes directory not found: " + classesDirectory);
    }
    Map<String, byte[]> entries = new TreeMap<>();
    try (var paths = Files.walk(classesDirectory)) {
      for (Path file : paths.filter(Files::isRegularFile).sorted().toList()) {
        String name = classesDirectory.relativize(file).toString().replace('\\', '/');
        entries.put(name, Files.readAllBytes(file));
      }
    }
    if (entries.isEmpty()) {
      throw new IOException("No compiled classes found in: " + classesDirectory);
    }
    writeArchive(output, entries);
  }

  static void overlay(Path baseArchive, Path overlayArchive, Path output) throws IOException {
    Map<String, byte[]> entries = readEntries(baseArchive);
    entries.putAll(readEntries(overlayArchive));
    writeArchive(output, entries);
  }

  static void copyGameTree(Path source, Path target, String excludedExecutable) throws IOException {
    Path normalizedTarget = target.toAbsolutePath().normalize();
    Path allowedRoot = normalizedTarget.getParent();
    Path preservedSaves = null;
    if (Files.isDirectory(normalizedTarget.resolve("sav"))) {
      preservedSaves = Files.createTempDirectory(allowedRoot, ".brasfoot-saves-");
      copyDirectory(normalizedTarget.resolve("sav"), preservedSaves);
    }

    boolean savesRestored = preservedSaves == null;
    try {
      if (Files.exists(normalizedTarget)) {
        deleteTreeWithin(normalizedTarget, allowedRoot);
      }
      Files.createDirectories(normalizedTarget);

      Files.walkFileTree(source, new SimpleFileVisitor<>() {
        @Override
        public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes)
            throws IOException {
          Path relative = source.relativize(directory);
          Files.createDirectories(normalizedTarget.resolve(relative.toString()));
          return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
            throws IOException {
          Path relative = source.relativize(file);
          String portable = relative.toString().replace('\\', '/');
          if (portable.equalsIgnoreCase(excludedExecutable)
              || portable.startsWith("sav/")
              || portable.endsWith(".log")) {
            return FileVisitResult.CONTINUE;
          }
          Path destination = normalizedTarget.resolve(relative.toString());
          Files.createDirectories(destination.getParent());
          Files.copy(file, destination, StandardCopyOption.REPLACE_EXISTING,
              StandardCopyOption.COPY_ATTRIBUTES);
          return FileVisitResult.CONTINUE;
        }
      });

      if (preservedSaves != null) {
        copyDirectory(preservedSaves, normalizedTarget.resolve("sav"));
        savesRestored = true;
      }
    } finally {
      if (savesRestored && preservedSaves != null && Files.exists(preservedSaves)) {
        deleteTreeWithin(preservedSaves, allowedRoot);
      }
    }
  }

  private static void copyDirectory(Path source, Path target) throws IOException {
    Files.walkFileTree(source, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes)
          throws IOException {
        Files.createDirectories(target.resolve(source.relativize(directory).toString()));
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
          throws IOException {
        Path destination = target.resolve(source.relativize(file).toString());
        Files.createDirectories(destination.getParent());
        Files.copy(file, destination, StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES);
        return FileVisitResult.CONTINUE;
      }
    });
  }

  static void deleteTreeWithin(Path target, Path allowedRoot) throws IOException {
    Path normalizedTarget = target.toAbsolutePath().normalize();
    Path normalizedRoot = allowedRoot.toAbsolutePath().normalize();
    if (normalizedTarget.equals(normalizedRoot) || !normalizedTarget.startsWith(normalizedRoot)) {
      throw new IOException("Refusing to remove path outside allowed root: " + normalizedTarget);
    }
    if (!Files.exists(normalizedTarget)) {
      return;
    }
    Files.walkFileTree(normalizedTarget, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult postVisitDirectory(Path directory, IOException exception)
          throws IOException {
        if (exception != null) {
          throw exception;
        }
        Files.delete(directory);
        return FileVisitResult.CONTINUE;
      }
    });
  }
}
