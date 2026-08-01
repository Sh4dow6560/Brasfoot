package com.brasfoot.reconstruction;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class ArchiveService {
  ArchiveData analyze(Path path) throws IOException {
    if (!Files.isRegularFile(path)) {
      throw new IOException("Archive not found: " + path);
    }

    try (ZipFile archive = new ZipFile(path.toFile())) {
      Map<String, ClassInfo> classes = new TreeMap<>();
      Map<String, EntryInfo> resources = new TreeMap<>();
      int javaMajor = -1;

      List<? extends ZipEntry> entries = Collections.list(archive.entries());
      entries.sort((left, right) -> left.getName().compareTo(right.getName()));
      for (ZipEntry entry : entries) {
        if (entry.isDirectory()) {
          continue;
        }
        byte[] bytes;
        try (InputStream input = archive.getInputStream(entry)) {
          bytes = input.readAllBytes();
        }
        String hash = Hashing.sha256(bytes);
        if (entry.getName().endsWith(".class")) {
          ClassInfo info = readClass(bytes, hash);
          classes.put(info.name(), info);
          if ("best/h2".equals(info.name())) {
            javaMajor = info.javaMajor();
          }
        } else {
          resources.put(entry.getName(), new EntryInfo(entry.getName(), bytes.length, hash));
        }
      }

      ZipEntry manifestEntry = archive.getEntry("META-INF/MANIFEST.MF");
      String mainClass = null;
      String launcherClass = null;
      if (manifestEntry != null) {
        try (InputStream input = archive.getInputStream(manifestEntry)) {
          Attributes attributes = new Manifest(input).getMainAttributes();
          mainClass = attributes.getValue("Rsrc-Main-Class");
          launcherClass = attributes.getValue("Main-Class");
        }
      }

      long collisionGroups = classes.keySet().stream()
          .collect(java.util.stream.Collectors.groupingBy(
              value -> value.toLowerCase(Locale.ROOT), java.util.stream.Collectors.counting()))
          .values().stream().filter(count -> count > 1).count();
      long illegalClasses = classes.keySet().stream()
          .filter(value -> !JavaIdentifiers.isLegalInternalClassName(value)).count();
      long illegalMembers = classes.values().stream().flatMap(value -> value.members().stream())
          .filter(value -> !value.name().startsWith("<") && !JavaIdentifiers.isLegal(value.name()))
          .count();

      return new ArchiveData(
          path,
          Files.size(path),
          Hashing.sha256(path),
          archive.size(),
          javaMajor,
          mainClass,
          launcherClass,
          collisionGroups,
          illegalClasses,
          illegalMembers,
          classes,
          resources);
    }
  }

  private ClassInfo readClass(byte[] bytes, String hash) {
    ClassReader reader = new ClassReader(bytes);
    List<MemberInfo> members = new ArrayList<>();
    reader.accept(new ClassVisitor(Opcodes.ASM9) {
      @Override
      public FieldVisitor visitField(int access, String name, String descriptor,
          String signature, Object value) {
        members.add(new MemberInfo(
            "field", name, descriptor, access, signature,
            value == null ? null : String.valueOf(value)));
        return null;
      }

      @Override
      public MethodVisitor visitMethod(int access, String name, String descriptor,
          String signature, String[] exceptions) {
        members.add(new MemberInfo("method", name, descriptor, access, signature, null));
        return null;
      }
    }, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
    members.sort((left, right) -> left.signature().compareTo(right.signature()));

    int major = ((bytes[6] & 0xFF) << 8) | (bytes[7] & 0xFF);
    return new ClassInfo(
        reader.getClassName(),
        reader.getAccess(),
        reader.getSuperName(),
        Arrays.asList(reader.getInterfaces()),
        major,
        hash,
        List.copyOf(members));
  }

  record ArchiveData(
      Path path,
      long size,
      String sha256,
      int entries,
      int javaMajor,
      String mainClass,
      String launcherClass,
      long caseCollisionGroups,
      long illegalClasses,
      long illegalMembers,
      Map<String, ClassInfo> classes,
      Map<String, EntryInfo> resources) {
  }

  record ClassInfo(
      String name,
      int access,
      String superName,
      List<String> interfaces,
      int javaMajor,
      String sha256,
      List<MemberInfo> members) {
  }

  record MemberInfo(
      String kind,
      String name,
      String descriptor,
      int access,
      String genericSignature,
      String constantValue) {
    String signature() {
      return kind + ":" + name + ":" + descriptor;
    }
  }

  record EntryInfo(String name, long size, String sha256) {
  }
}
