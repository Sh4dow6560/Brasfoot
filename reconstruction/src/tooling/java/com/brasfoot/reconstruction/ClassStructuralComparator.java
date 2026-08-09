package com.brasfoot.reconstruction;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

final class ClassStructuralComparator {
  private static final int CLASS_ACCESS_MASK = Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL
      | Opcodes.ACC_INTERFACE | Opcodes.ACC_ABSTRACT | Opcodes.ACC_ANNOTATION
      | Opcodes.ACC_ENUM | Opcodes.ACC_RECORD;
  private static final int MEMBER_ACCESS_MASK = Opcodes.ACC_PUBLIC | Opcodes.ACC_PRIVATE
      | Opcodes.ACC_PROTECTED | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL
      | Opcodes.ACC_SYNCHRONIZED | Opcodes.ACC_VOLATILE | Opcodes.ACC_TRANSIENT
      | Opcodes.ACC_NATIVE | Opcodes.ACC_ABSTRACT | Opcodes.ACC_STRICT
      | Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE | Opcodes.ACC_VARARGS
      | Opcodes.ACC_ENUM;

  private ClassStructuralComparator() {
  }

  static Comparison compare(
      byte[] baseline, byte[] candidate, Map<String, String> candidateRelocations) {
    Snapshot left = snapshot(baseline, Map.of());
    Snapshot right = snapshot(candidate, candidateRelocations);

    List<String> addedMembers = difference(right.declarations(), left.declarations());
    List<String> removedMembers = difference(left.declarations(), right.declarations());
    List<String> changedFields = changedKeys(left.fieldValues(), right.fieldValues());
    List<String> changedMethods = changedKeys(left.methodBodies(), right.methodBodies());
    boolean headerEquivalent = left.header().equals(right.header());
    boolean apiEquivalent = headerEquivalent && addedMembers.isEmpty() && removedMembers.isEmpty();
    boolean behaviorEquivalent = apiEquivalent && changedFields.isEmpty()
        && changedMethods.isEmpty();

    return new Comparison(
        apiEquivalent,
        behaviorEquivalent,
        headerEquivalent,
        addedMembers,
        removedMembers,
        changedFields,
        changedMethods,
        difference(right.strings(), left.strings()),
        difference(left.strings(), right.strings()),
        List.copyOf(right.references()));
  }

  static Snapshot snapshot(byte[] bytes, Map<String, String> relocations) {
    ClassNode node = new ClassNode(Opcodes.ASM9);
    new ClassReader(bytes).accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);

    String className = normalizeInternalName(node.name, relocations);
    List<String> interfaces = node.interfaces.stream()
        .map(value -> normalizeInternalName(value, relocations))
        .sorted()
        .toList();
    Header header = new Header(
        className,
        node.access & CLASS_ACCESS_MASK,
        normalizeInternalName(node.superName, relocations),
        interfaces);

    Set<String> declarations = new TreeSet<>();
    Map<String, String> fieldValues = new TreeMap<>();
    Map<String, String> methodBodies = new TreeMap<>();
    Set<String> strings = new TreeSet<>();
    Set<String> references = new TreeSet<>();
    addReference(references, node.superName, relocations);
    for (String interfaceName : node.interfaces) {
      addReference(references, interfaceName, relocations);
    }

    for (FieldNode field : node.fields) {
      String descriptor = normalizeDescriptor(field.desc, relocations);
      String key = "field:" + field.name + ":" + descriptor;
      declarations.add(key + ":" + (field.access & MEMBER_ACCESS_MASK));
      fieldValues.put(key, normalizeConstant(field.value, relocations));
      addDescriptorReferences(references, field.desc, relocations);
    }

    for (MethodNode method : node.methods) {
      String descriptor = normalizeDescriptor(method.desc, relocations);
      String key = "method:" + method.name + ":" + descriptor;
      List<String> exceptions = method.exceptions == null ? List.of()
          : method.exceptions.stream()
              .map(value -> normalizeInternalName(value, relocations))
              .sorted()
              .toList();
      declarations.add(key + ":" + (method.access & MEMBER_ACCESS_MASK)
          + ":" + String.join(",", exceptions));
      methodBodies.put(key, methodBody(method, relocations, strings, references));
      addMethodDescriptorReferences(references, method.desc, relocations);
      exceptions.forEach(references::add);
    }

    references.remove(className);
    return new Snapshot(
        header,
        Collections.unmodifiableSet(declarations),
        Collections.unmodifiableMap(fieldValues),
        Collections.unmodifiableMap(methodBodies),
        Collections.unmodifiableSet(strings),
        Collections.unmodifiableSet(references));
  }

  private static String methodBody(
      MethodNode method,
      Map<String, String> relocations,
      Set<String> strings,
      Set<String> references) {
    StringBuilder value = new StringBuilder();
    Map<LabelNode, Integer> labels = labelIds(method);
    for (AbstractInsnNode instruction = method.instructions.getFirst();
        instruction != null; instruction = instruction.getNext()) {
      if (instruction instanceof LabelNode || instruction instanceof LineNumberNode
          || instruction instanceof FrameNode) {
        continue;
      }
      value.append(instruction.getOpcode()).append(':');
      if (instruction instanceof InsnNode) {
        value.append(';');
      } else if (instruction instanceof IntInsnNode item) {
        value.append(item.operand).append(';');
      } else if (instruction instanceof VarInsnNode item) {
        value.append(item.var).append(';');
      } else if (instruction instanceof TypeInsnNode item) {
        String type = normalizeInternalName(item.desc, relocations);
        value.append(type).append(';');
        references.add(type);
      } else if (instruction instanceof FieldInsnNode item) {
        String owner = normalizeInternalName(item.owner, relocations);
        value.append(owner).append('.').append(item.name).append(':')
            .append(normalizeDescriptor(item.desc, relocations)).append(';');
        references.add(owner);
        addDescriptorReferences(references, item.desc, relocations);
      } else if (instruction instanceof MethodInsnNode item) {
        String owner = normalizeInternalName(item.owner, relocations);
        value.append(owner).append('.').append(item.name)
            .append(normalizeDescriptor(item.desc, relocations))
            .append(':').append(item.itf).append(';');
        references.add(owner);
        addMethodDescriptorReferences(references, item.desc, relocations);
      } else if (instruction instanceof InvokeDynamicInsnNode item) {
        value.append(item.name).append(normalizeDescriptor(item.desc, relocations))
            .append(':').append(normalizeHandle(item.bsm, relocations));
        for (Object argument : item.bsmArgs) {
          value.append(':').append(normalizeConstant(argument, relocations));
        }
        value.append(';');
        addMethodDescriptorReferences(references, item.desc, relocations);
      } else if (instruction instanceof JumpInsnNode item) {
        value.append(labelId(labels, item.label)).append(';');
      } else if (instruction instanceof LdcInsnNode item) {
        value.append(normalizeConstant(item.cst, relocations)).append(';');
        if (item.cst instanceof String text) {
          strings.add(compact(text));
        } else if (item.cst instanceof Type type) {
          addTypeReference(references, type, relocations);
        }
      } else if (instruction instanceof IincInsnNode item) {
        value.append(item.var).append(':').append(item.incr).append(';');
      } else if (instruction instanceof TableSwitchInsnNode item) {
        value.append(item.min).append(':').append(item.max).append(':')
            .append(labelId(labels, item.dflt));
        for (LabelNode label : item.labels) {
          value.append(':').append(labelId(labels, label));
        }
        value.append(';');
      } else if (instruction instanceof LookupSwitchInsnNode item) {
        value.append(labelId(labels, item.dflt));
        for (int index = 0; index < item.keys.size(); index++) {
          value.append(':').append(item.keys.get(index)).append('>')
              .append(labelId(labels, item.labels.get(index)));
        }
        value.append(';');
      } else if (instruction instanceof MultiANewArrayInsnNode item) {
        value.append(normalizeDescriptor(item.desc, relocations))
            .append(':').append(item.dims).append(';');
        addDescriptorReferences(references, item.desc, relocations);
      } else {
        value.append(instruction.getType()).append(';');
      }
    }
    if (method.tryCatchBlocks != null) {
      for (TryCatchBlockNode block : method.tryCatchBlocks) {
        value.append("try:")
            .append(labelId(labels, block.start)).append(':')
            .append(labelId(labels, block.end)).append(':')
            .append(labelId(labels, block.handler)).append(':')
            .append(normalizeInternalName(block.type, relocations)).append(';');
        addReference(references, block.type, relocations);
      }
    }
    return Hashing.sha256(value.toString().getBytes(StandardCharsets.UTF_8));
  }

  private static Map<LabelNode, Integer> labelIds(MethodNode method) {
    Map<LabelNode, Integer> labels = new IdentityHashMap<>();
    for (AbstractInsnNode instruction = method.instructions.getFirst();
        instruction != null; instruction = instruction.getNext()) {
      if (instruction instanceof LabelNode label) {
        labelId(labels, label);
      }
    }
    if (method.tryCatchBlocks != null) {
      for (TryCatchBlockNode block : method.tryCatchBlocks) {
        labelId(labels, block.start);
        labelId(labels, block.end);
        labelId(labels, block.handler);
      }
    }
    return labels;
  }

  private static int labelId(Map<LabelNode, Integer> labels, LabelNode label) {
    if (label == null) {
      return -1;
    }
    Integer existing = labels.get(label);
    if (existing != null) {
      return existing;
    }
    int id = labels.size();
    labels.put(label, id);
    return id;
  }

  private static String normalizeDescriptor(String descriptor, Map<String, String> relocations) {
    if (descriptor == null) {
      return "";
    }
    return normalizeType(Type.getType(descriptor), relocations).getDescriptor();
  }

  private static Type normalizeType(Type type, Map<String, String> relocations) {
    return switch (type.getSort()) {
      case Type.ARRAY -> Type.getType("[".repeat(type.getDimensions())
          + normalizeType(type.getElementType(), relocations).getDescriptor());
      case Type.OBJECT -> Type.getObjectType(
          normalizeInternalName(type.getInternalName(), relocations));
      case Type.METHOD -> {
        Type[] arguments = type.getArgumentTypes();
        Type[] normalizedArguments = new Type[arguments.length];
        for (int index = 0; index < arguments.length; index++) {
          normalizedArguments[index] = normalizeType(arguments[index], relocations);
        }
        yield Type.getMethodType(
            normalizeType(type.getReturnType(), relocations), normalizedArguments);
      }
      default -> type;
    };
  }

  private static String normalizeInternalName(String name, Map<String, String> relocations) {
    if (name == null) {
      return "";
    }
    String direct = relocations.get(name);
    if (direct != null) {
      return direct;
    }
    int inner = name.indexOf('$');
    if (inner > 0) {
      String outer = relocations.get(name.substring(0, inner));
      if (outer != null) {
        return outer + name.substring(inner);
      }
    }
    return name;
  }

  private static String normalizeConstant(Object value, Map<String, String> relocations) {
    if (value == null) {
      return "null";
    }
    if (value instanceof Type type) {
      return "type:" + normalizeType(type, relocations).getDescriptor();
    }
    if (value instanceof Handle handle) {
      return "handle:" + normalizeHandle(handle, relocations);
    }
    if (value instanceof ConstantDynamic dynamic) {
      StringBuilder result = new StringBuilder("dynamic:")
          .append(dynamic.getName()).append(':')
          .append(normalizeDescriptor(dynamic.getDescriptor(), relocations)).append(':')
          .append(normalizeHandle(dynamic.getBootstrapMethod(), relocations));
      for (int index = 0; index < dynamic.getBootstrapMethodArgumentCount(); index++) {
        result.append(':').append(normalizeConstant(
            dynamic.getBootstrapMethodArgument(index), relocations));
      }
      return result.toString();
    }
    if (value instanceof String text) {
      return "string:" + text.length() + ':' + text;
    }
    return value.getClass().getName() + ':' + value;
  }

  private static String normalizeHandle(Handle handle, Map<String, String> relocations) {
    return handle.getTag() + ":" + normalizeInternalName(handle.getOwner(), relocations)
        + '.' + handle.getName() + normalizeDescriptor(handle.getDesc(), relocations)
        + ':' + handle.isInterface();
  }

  private static void addMethodDescriptorReferences(
      Set<String> references, String descriptor, Map<String, String> relocations) {
    Type method = Type.getMethodType(descriptor);
    addTypeReference(references, method.getReturnType(), relocations);
    for (Type argument : method.getArgumentTypes()) {
      addTypeReference(references, argument, relocations);
    }
  }

  private static void addDescriptorReferences(
      Set<String> references, String descriptor, Map<String, String> relocations) {
    addTypeReference(references, Type.getType(descriptor), relocations);
  }

  private static void addTypeReference(
      Set<String> references, Type type, Map<String, String> relocations) {
    if (type.getSort() == Type.ARRAY) {
      addTypeReference(references, type.getElementType(), relocations);
    } else if (type.getSort() == Type.OBJECT) {
      references.add(normalizeInternalName(type.getInternalName(), relocations));
    } else if (type.getSort() == Type.METHOD) {
      addTypeReference(references, type.getReturnType(), relocations);
      for (Type argument : type.getArgumentTypes()) {
        addTypeReference(references, argument, relocations);
      }
    }
  }

  private static void addReference(
      Set<String> references, String name, Map<String, String> relocations) {
    if (name != null) {
      references.add(normalizeInternalName(name, relocations));
    }
  }

  private static String compact(String value) {
    String result = value.replace('\r', ' ').replace('\n', ' ').trim();
    return result.length() <= 160 ? result : result.substring(0, 160);
  }

  private static List<String> changedKeys(
      Map<String, String> left, Map<String, String> right) {
    Set<String> common = new TreeSet<>(left.keySet());
    common.retainAll(right.keySet());
    List<String> changed = new ArrayList<>();
    for (String key : common) {
      if (!left.get(key).equals(right.get(key))) {
        changed.add(key);
      }
    }
    return List.copyOf(changed);
  }

  private static List<String> difference(Set<String> left, Set<String> right) {
    Set<String> values = new TreeSet<>(left);
    values.removeAll(right);
    return List.copyOf(values);
  }

  private static List<String> difference(
      java.util.Collection<String> left, java.util.Collection<String> right) {
    Set<String> values = new TreeSet<>(left);
    values.removeAll(new LinkedHashSet<>(right));
    return List.copyOf(values);
  }

  record Header(String name, int access, String superName, List<String> interfaces) {
  }

  record Snapshot(
      Header header,
      Set<String> declarations,
      Map<String, String> fieldValues,
      Map<String, String> methodBodies,
      Set<String> strings,
      Set<String> references) {
  }

  record Comparison(
      boolean apiEquivalent,
      boolean behaviorEquivalent,
      boolean headerEquivalent,
      List<String> addedMembers,
      List<String> removedMembers,
      List<String> changedFields,
      List<String> changedMethods,
      List<String> addedStrings,
      List<String> removedStrings,
      List<String> candidateReferences) {
  }
}
