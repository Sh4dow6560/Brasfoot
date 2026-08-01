package com.brasfoot.reconstruction.agent;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class KryoSaveCompatibilityProbe {
  private KryoSaveCompatibilityProbe() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      throw new IllegalArgumentException(
          "Usage: KryoSaveCompatibilityProbe <hybrid-jar> <reference-save> <class>...");
    }
    String[] targets = new String[args.length - 2];
    System.arraycopy(args, 2, targets, 0, targets.length);
    byte[] original = Files.readAllBytes(Paths.get(args[1]));
    URL hybrid = new java.io.File(args[0]).toURI().toURL();
    try (URLClassLoader loader = new URLClassLoader(
        new URL[]{hybrid}, KryoSaveCompatibilityProbe.class.getClassLoader())) {
      Object[] roots = read(original, loader);
      Map<String, Integer> counts = countTargets(roots, targets);
      for (String target : targets) {
        System.out.println("COUNT " + target + " " + counts.get(target));
      }
      byte[] roundTrip = write(roots, loader);
      Object[] restored = read(roundTrip, loader);
      Map<String, Integer> restoredCounts = countTargets(restored, targets);
      if (!counts.equals(restoredCounts)) {
        throw new IllegalStateException("Kryo round-trip changed recovered model counts");
      }
      System.out.println("ROOT " + roots[0].getClass().getName()
          + " AUX " + roots[1].getClass().getName());
      System.out.println("ROUNDTRIP originalBytes=" + original.length
          + " outputBytes=" + roundTrip.length
          + " byteIdentical=" + sha256(original).equals(sha256(roundTrip)));
    }
  }

  private static Object[] read(byte[] bytes, ClassLoader loader) {
    Kryo kryo = createKryo(loader);
    Input input = new Input(new ByteArrayInputStream(bytes));
    try {
      return new Object[]{kryo.readClassAndObject(input), kryo.readClassAndObject(input)};
    } finally {
      input.close();
    }
  }

  private static byte[] write(Object[] roots, ClassLoader loader) {
    Kryo kryo = createKryo(loader);
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    Output output = new Output(buffer);
    try {
      kryo.writeClassAndObject(output, roots[0]);
      kryo.writeClassAndObject(output, roots[1]);
      output.flush();
      return buffer.toByteArray();
    } finally {
      output.close();
    }
  }

  private static Kryo createKryo(ClassLoader loader) {
    Kryo kryo = new Kryo();
    kryo.setRegistrationRequired(false);
    kryo.setClassLoader(loader);
    return kryo;
  }

  private static Map<String, Integer> countTargets(Object[] roots, String[] targets)
      throws Exception {
    Map<String, Integer> counts = new LinkedHashMap<String, Integer>();
    for (String target : targets) {
      counts.put(target, 0);
    }
    Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<Object, Boolean>());
    ArrayDeque<Object> pending = new ArrayDeque<Object>();
    for (Object root : roots) {
      if (root != null) {
        pending.add(root);
      }
    }

    while (!pending.isEmpty()) {
      Object value = pending.removeFirst();
      if (value == null || !visited.add(value)) {
        continue;
      }
      if (visited.size() > 1_000_000) {
        throw new IllegalStateException("Reference save graph exceeded safety limit");
      }
      Class<?> type = value.getClass();
      String name = type.getName();
      if (counts.containsKey(name)) {
        counts.put(name, counts.get(name) + 1);
      }
      if (isTerminal(type)) {
        continue;
      }
      if (type.isArray()) {
        if (!type.getComponentType().isPrimitive()) {
          int length = Array.getLength(value);
          for (int index = 0; index < length; index++) {
            add(pending, Array.get(value, index));
          }
        }
        continue;
      }
      if (value instanceof Iterable) {
        for (Object item : (Iterable<?>)value) {
          add(pending, item);
        }
        continue;
      }
      if (value instanceof Map) {
        for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
          add(pending, entry.getKey());
          add(pending, entry.getValue());
        }
        continue;
      }
      if (name.startsWith("java.") || name.startsWith("javax.")) {
        continue;
      }
      for (Class<?> current = type; current != null && current != Object.class;
           current = current.getSuperclass()) {
        for (Field field : current.getDeclaredFields()) {
          int modifiers = field.getModifiers();
          if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)
              || field.getType().isPrimitive()) {
            continue;
          }
          field.setAccessible(true);
          add(pending, field.get(value));
        }
      }
    }
    return counts;
  }

  private static boolean isTerminal(Class<?> type) {
    return type.isPrimitive()
        || type.isEnum()
        || Number.class.isAssignableFrom(type)
        || type == String.class
        || type == Boolean.class
        || type == Character.class
        || type == Class.class;
  }

  private static void add(ArrayDeque<Object> pending, Object value) {
    if (value != null) {
      pending.addLast(value);
    }
  }

  private static String sha256(byte[] bytes) throws Exception {
    byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
    StringBuilder text = new StringBuilder();
    for (byte value : digest) {
      text.append(String.format("%02X", value));
    }
    return text.toString();
  }
}
