package com.brasfoot.reconstruction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

final class SyntheticMethodSourceService {
  private final ProjectContext context;

  SyntheticMethodSourceService(ProjectContext context) {
    this.context = context;
  }

  int augment(Path sourceRoot) throws IOException {
    ArchiveService.ArchiveData namedArchive = new ArchiveService().analyze(context.namedGameJar());
    int restored = 0;
    for (ArchiveService.ClassInfo classInfo : namedArchive.classes().values()) {
      Path source = sourceRoot.resolve(classInfo.name() + ".java");
      if (!Files.isRegularFile(source)) {
        continue;
      }
      String text = Files.readString(source, StandardCharsets.UTF_8);
      if (text.contains("enum ") || text.contains("interface ")) {
        continue;
      }
      StringBuilder declarations = new StringBuilder();
      for (ArchiveService.MemberInfo member : classInfo.members()) {
        if (!"method".equals(member.kind())
            || member.name().startsWith("<")
            || (member.access() & Opcodes.ACC_SYNTHETIC) == 0
            || (member.access() & Opcodes.ACC_BRIDGE) != 0
            || isComparatorBridge(classInfo, member)
            || declaresMethod(text, member)) {
          continue;
        }
        declarations.append("\n\n   ").append(methodStub(member));
        restored++;
      }
      if (declarations.length() == 0) {
        continue;
      }
      String simpleName = classInfo.name().substring(classInfo.name().lastIndexOf('/') + 1);
      int declaration = text.indexOf("class " + simpleName);
      int openingBrace = declaration < 0 ? -1 : text.indexOf('{', declaration);
      if (openingBrace < 0) {
        throw new IllegalStateException("Cannot locate class declaration in " + source);
      }
      text = text.substring(0, openingBrace + 1) + declarations + text.substring(openingBrace + 1);
      Files.writeString(source, text, StandardCharsets.UTF_8);
    }
    return restored;
  }

  private boolean isComparatorBridge(
      ArchiveService.ClassInfo classInfo, ArchiveService.MemberInfo member) {
    return classInfo.interfaces().contains("java/util/Comparator")
        && "compare".equals(member.name())
        && "(Ljava/lang/Object;Ljava/lang/Object;)I".equals(member.descriptor());
  }

  private boolean declaresMethod(String text, ArchiveService.MemberInfo member) {
    Type method = Type.getMethodType(member.descriptor());
    StringBuilder parameters = new StringBuilder();
    Type[] arguments = method.getArgumentTypes();
    for (int index = 0; index < arguments.length; index++) {
      if (index > 0) {
        parameters.append("\\s*,\\s*");
      }
      parameters.append(typePattern(arguments[index]))
          .append("\\s+[A-Za-z_$][A-Za-z0-9_$]*");
    }
    String pattern = "(?m)^\\s*(?:(?:public|protected|private|static|final|synchronized|native|abstract)\\s+)*"
        + typePattern(method.getReturnType()) + "\\s+"
        + Pattern.quote(member.name()) + "\\s*\\(\\s*" + parameters + "\\s*\\)";
    return Pattern.compile(pattern).matcher(text).find();
  }

  private String typePattern(Type type) {
    String className = type.getClassName();
    String simpleName = className.substring(className.lastIndexOf('.') + 1);
    if (className.equals(simpleName)) {
      return Pattern.quote(className);
    }
    return "(?:" + Pattern.quote(className) + "|" + Pattern.quote(simpleName) + ")";
  }

  private String methodStub(ArchiveService.MemberInfo member) {
    Type method = Type.getMethodType(member.descriptor());
    StringBuilder source = new StringBuilder(methodModifiers(member.access()))
        .append(method.getReturnType().getClassName()).append(' ')
        .append(member.name()).append('(');
    Type[] arguments = method.getArgumentTypes();
    List<String> parameters = new ArrayList<>();
    for (int index = 0; index < arguments.length; index++) {
      parameters.add(arguments[index].getClassName() + " arg" + index);
    }
    source.append(String.join(", ", parameters)).append(") {");
    String defaultValue = defaultValue(method.getReturnType());
    if (defaultValue != null) {
      source.append("\n      return ").append(defaultValue).append(';').append("\n   ");
    }
    return source.append('}').toString();
  }

  private String methodModifiers(int access) {
    StringBuilder modifiers = new StringBuilder();
    if ((access & Opcodes.ACC_PUBLIC) != 0) {
      modifiers.append("public ");
    } else if ((access & Opcodes.ACC_PROTECTED) != 0) {
      modifiers.append("protected ");
    } else if ((access & Opcodes.ACC_PRIVATE) != 0) {
      modifiers.append("private ");
    }
    if ((access & Opcodes.ACC_STATIC) != 0) {
      modifiers.append("static ");
    }
    if ((access & Opcodes.ACC_FINAL) != 0) {
      modifiers.append("final ");
    }
    if ((access & Opcodes.ACC_SYNCHRONIZED) != 0) {
      modifiers.append("synchronized ");
    }
    return modifiers.toString();
  }

  private String defaultValue(Type type) {
    return switch (type.getSort()) {
      case Type.VOID -> null;
      case Type.BOOLEAN -> "false";
      case Type.CHAR -> "'\\0'";
      case Type.LONG -> "0L";
      case Type.FLOAT -> "0.0F";
      case Type.DOUBLE -> "0.0D";
      case Type.BYTE, Type.SHORT, Type.INT -> "0";
      default -> "null";
    };
  }
}
