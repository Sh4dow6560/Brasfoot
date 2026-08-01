package com.brasfoot.reconstruction.agent;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public final class SaveCompatibilityProbe {
  private SaveCompatibilityProbe() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      throw new IllegalArgumentException(
          "Usage: SaveCompatibilityProbe <hybrid-jar> <reference-info> <class>...");
    }

    URL jar = new java.io.File(args[0]).toURI().toURL();
    try (URLClassLoader loader = new URLClassLoader(new URL[]{jar}, null)) {
      for (int index = 2; index < args.length; index++) {
        verifyClass(loader, args[index]);
      }
      verifyFixture(loader, args[1]);
    }
  }

  private static void verifyClass(ClassLoader loader, String className) throws Exception {
    Class<?> type = Class.forName(className, false, loader);
    boolean serializable = Serializable.class.isAssignableFrom(type);
    ObjectStreamClass descriptor = ObjectStreamClass.lookup(type);
    long uid = descriptor == null ? 0L : descriptor.getSerialVersionUID();
    boolean roundTripped = false;

    if (serializable) {
      Object value = instantiate(type);
      if (value != null) {
        byte[] bytes;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();
             ObjectOutputStream output = new ObjectOutputStream(buffer)) {
          output.writeObject(value);
          output.flush();
          bytes = buffer.toByteArray();
        }
        try (LoaderObjectInputStream input = new LoaderObjectInputStream(
            new ByteArrayInputStream(bytes), loader)) {
          Object restored = input.readObject();
          roundTripped = restored.getClass() == type;
        }
      }
    }

    System.out.println("CLASS " + className + " serializable=" + serializable
        + " uid=" + uid + " roundTrip=" + roundTripped);
  }

  private static Object instantiate(Class<?> type) throws Exception {
    Constructor<?>[] constructors = type.getDeclaredConstructors();
    java.util.Arrays.sort(constructors, new java.util.Comparator<Constructor<?>>() {
      @Override
      public int compare(Constructor<?> left, Constructor<?> right) {
        return Integer.compare(left.getParameterTypes().length, right.getParameterTypes().length);
      }
    });
    for (Constructor<?> constructor : constructors) {
      Class<?>[] parameterTypes = constructor.getParameterTypes();
      Object[] arguments = new Object[parameterTypes.length];
      boolean supported = true;
      for (int index = 0; index < parameterTypes.length; index++) {
        Class<?> parameter = parameterTypes[index];
        if (parameter == boolean.class) {
          arguments[index] = false;
        } else if (parameter == byte.class) {
          arguments[index] = (byte)0;
        } else if (parameter == short.class) {
          arguments[index] = (short)0;
        } else if (parameter == int.class) {
          arguments[index] = 0;
        } else if (parameter == long.class) {
          arguments[index] = 0L;
        } else if (parameter == float.class) {
          arguments[index] = 0.0F;
        } else if (parameter == double.class) {
          arguments[index] = 0.0D;
        } else if (parameter == char.class) {
          arguments[index] = '\0';
        } else if (parameter == String.class) {
          arguments[index] = "";
        } else {
          supported = false;
          break;
        }
      }
      if (supported) {
        constructor.setAccessible(true);
        return constructor.newInstance(arguments);
      }
    }
    return null;
  }

  private static void verifyFixture(ClassLoader loader, String fixturePath) throws Exception {
    Object fixture;
    try (LoaderObjectInputStream input = new LoaderObjectInputStream(
        new FileInputStream(fixturePath), loader)) {
      fixture = input.readObject();
    }
    ObjectStreamClass descriptor = ObjectStreamClass.lookup(fixture.getClass());
    if (descriptor == null) {
      throw new IllegalStateException("Reference info is not serializable");
    }
    System.out.println("FIXTURE " + fixture.getClass().getName()
        + " uid=" + descriptor.getSerialVersionUID());
  }

  private static final class LoaderObjectInputStream extends ObjectInputStream {
    private final ClassLoader loader;

    LoaderObjectInputStream(InputStream input, ClassLoader loader) throws java.io.IOException {
      super(input);
      this.loader = loader;
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass descriptor)
        throws java.io.IOException, ClassNotFoundException {
      return Class.forName(descriptor.getName(), false, loader);
    }
  }
}
