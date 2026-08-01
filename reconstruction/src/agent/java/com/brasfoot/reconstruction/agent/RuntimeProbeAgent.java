package com.brasfoot.reconstruction.agent;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class RuntimeProbeAgent {
  private RuntimeProbeAgent() {
  }

  public static void premain(String agentArgs, Instrumentation instrumentation) throws IOException {
    String[] arguments = agentArgs.split("\\|", 2);
    final Path log = Paths.get(arguments[0]).toAbsolutePath();
    final Set<String> targets = new HashSet<String>();
    targets.add("best/h2");
    targets.add("components/ar");
    if (arguments.length == 2 && !arguments[1].isEmpty()) {
      targets.addAll(Arrays.asList(arguments[1].split(",")));
    }
    Files.createDirectories(log.getParent());
    Files.write(log, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    append(log, "AGENT_READY");
    append(log, "PID " + processId());

    instrumentation.addTransformer(new ClassFileTransformer() {
      @Override
      public byte[] transform(
          ClassLoader loader,
          String className,
          Class<?> classBeingRedefined,
          ProtectionDomain protectionDomain,
          byte[] classfileBuffer) throws IllegalClassFormatException {
        if (targets.contains(className)) {
          append(log, "LOADED " + className + " " + sha256(classfileBuffer)
              + " loader=" + (loader == null ? "bootstrap" : loader.getClass().getName()));
        }
        return null;
      }
    });
  }

  private static synchronized void append(Path log, String line) {
    try {
      Files.write(log, (line + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
          StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException exception) {
      throw new IllegalStateException("Could not write runtime probe log", exception);
    }
  }

  private static String sha256(byte[] bytes) {
    try {
      byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
      StringBuilder value = new StringBuilder(digest.length * 2);
      for (byte item : digest) {
        value.append(String.format("%02X", item));
      }
      return value.toString();
    } catch (Exception exception) {
      throw new IllegalStateException("SHA-256 is unavailable", exception);
    }
  }

  private static String processId() {
    String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
    int separator = runtimeName.indexOf('@');
    return separator < 0 ? runtimeName : runtimeName.substring(0, separator);
  }
}
