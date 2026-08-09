package mod.extension.state;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class JsonCodec {
  private static final int MAX_DEPTH = 64;

  private JsonCodec() {
  }

  static Object parse(String text) {
    if (text == null) {
      throw new NullPointerException("text");
    }
    Parser parser = new Parser(text);
    Object value = parser.parseValue(0);
    parser.skipWhitespace();
    if (!parser.isEnd()) {
      throw parser.error("Unexpected trailing content");
    }
    return value;
  }

  static String write(Object value) {
    StringBuilder output = new StringBuilder();
    writeValue(output, normalize(value, 0), 0);
    return output.toString();
  }

  static Map<String, Object> immutableObject(Map<String, ?> source) {
    Object normalized = normalize(source, 0);
    @SuppressWarnings("unchecked")
    Map<String, Object> result = (Map<String, Object>)normalized;
    return result;
  }

  private static Object normalize(Object value, int depth) {
    if (depth > MAX_DEPTH) {
      throw new IllegalArgumentException("JSON value exceeds maximum depth");
    }
    if (value == null || value instanceof String || value instanceof Boolean) {
      return value;
    }
    if (value instanceof Byte || value instanceof Short || value instanceof Integer
        || value instanceof Long) {
      return Long.valueOf(((Number)value).longValue());
    }
    if (value instanceof Float || value instanceof Double) {
      double number = ((Number)value).doubleValue();
      if (Double.isInfinite(number) || Double.isNaN(number)) {
        throw new IllegalArgumentException("JSON numbers must be finite");
      }
      return Double.valueOf(number);
    }
    if (value instanceof Map) {
      Map<?, ?> source = (Map<?, ?>)value;
      Map<String, Object> sorted = new TreeMap<String, Object>();
      for (Map.Entry<?, ?> entry : source.entrySet()) {
        if (!(entry.getKey() instanceof String)) {
          throw new IllegalArgumentException("JSON object keys must be strings");
        }
        sorted.put((String)entry.getKey(), normalize(entry.getValue(), depth + 1));
      }
      return Collections.unmodifiableMap(new LinkedHashMap<String, Object>(sorted));
    }
    if (value instanceof Collection) {
      List<Object> result = new ArrayList<Object>();
      for (Object item : (Collection<?>)value) {
        result.add(normalize(item, depth + 1));
      }
      return Collections.unmodifiableList(result);
    }
    if (value.getClass().isArray()) {
      int length = java.lang.reflect.Array.getLength(value);
      List<Object> result = new ArrayList<Object>(length);
      for (int index = 0; index < length; index++) {
        result.add(normalize(java.lang.reflect.Array.get(value, index), depth + 1));
      }
      return Collections.unmodifiableList(result);
    }
    throw new IllegalArgumentException(
        "Unsupported JSON value type: " + value.getClass().getName());
  }

  private static void writeValue(StringBuilder output, Object value, int depth) {
    if (depth > MAX_DEPTH) {
      throw new IllegalArgumentException("JSON value exceeds maximum depth");
    }
    if (value == null) {
      output.append("null");
    } else if (value instanceof String) {
      writeString(output, (String)value);
    } else if (value instanceof Boolean || value instanceof Long) {
      output.append(value.toString());
    } else if (value instanceof Double) {
      output.append(Double.toString(((Double)value).doubleValue()));
    } else if (value instanceof Map) {
      output.append('{');
      boolean first = true;
      for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
        if (!first) {
          output.append(',');
        }
        first = false;
        writeString(output, (String)entry.getKey());
        output.append(':');
        writeValue(output, entry.getValue(), depth + 1);
      }
      output.append('}');
    } else if (value instanceof List) {
      output.append('[');
      boolean first = true;
      for (Object item : (List<?>)value) {
        if (!first) {
          output.append(',');
        }
        first = false;
        writeValue(output, item, depth + 1);
      }
      output.append(']');
    } else {
      throw new IllegalArgumentException("Value was not normalized for JSON");
    }
  }

  private static void writeString(StringBuilder output, String value) {
    output.append('"');
    for (int index = 0; index < value.length(); index++) {
      char item = value.charAt(index);
      switch (item) {
        case '"':
          output.append("\\\"");
          break;
        case '\\':
          output.append("\\\\");
          break;
        case '\b':
          output.append("\\b");
          break;
        case '\f':
          output.append("\\f");
          break;
        case '\n':
          output.append("\\n");
          break;
        case '\r':
          output.append("\\r");
          break;
        case '\t':
          output.append("\\t");
          break;
        default:
          if (item < 0x20) {
            output.append(String.format("\\u%04x", Integer.valueOf(item)));
          } else {
            output.append(item);
          }
      }
    }
    output.append('"');
  }

  private static final class Parser {
    private final String text;
    private int index;

    Parser(String text) {
      this.text = text.length() > 0 && text.charAt(0) == '\ufeff'
          ? text.substring(1) : text;
    }

    Object parseValue(int depth) {
      if (depth > MAX_DEPTH) {
        throw error("JSON value exceeds maximum depth");
      }
      skipWhitespace();
      if (isEnd()) {
        throw error("Expected a JSON value");
      }
      char item = this.text.charAt(this.index);
      if (item == '{') {
        return parseObject(depth + 1);
      }
      if (item == '[') {
        return parseArray(depth + 1);
      }
      if (item == '"') {
        return parseString();
      }
      if (item == 't') {
        expectLiteral("true");
        return Boolean.TRUE;
      }
      if (item == 'f') {
        expectLiteral("false");
        return Boolean.FALSE;
      }
      if (item == 'n') {
        expectLiteral("null");
        return null;
      }
      if (item == '-' || item >= '0' && item <= '9') {
        return parseNumber();
      }
      throw error("Unexpected character '" + item + "'");
    }

    private Map<String, Object> parseObject(int depth) {
      this.index++;
      Map<String, Object> result = new LinkedHashMap<String, Object>();
      skipWhitespace();
      if (consume('}')) {
        return result;
      }
      while (true) {
        skipWhitespace();
        if (isEnd() || this.text.charAt(this.index) != '"') {
          throw error("Expected an object key");
        }
        String key = parseString();
        skipWhitespace();
        expect(':');
        Object value = parseValue(depth);
        if (result.containsKey(key)) {
          throw error("Duplicate object key: " + key);
        }
        result.put(key, value);
        skipWhitespace();
        if (consume('}')) {
          return result;
        }
        expect(',');
      }
    }

    private List<Object> parseArray(int depth) {
      this.index++;
      List<Object> result = new ArrayList<Object>();
      skipWhitespace();
      if (consume(']')) {
        return result;
      }
      while (true) {
        result.add(parseValue(depth));
        skipWhitespace();
        if (consume(']')) {
          return result;
        }
        expect(',');
      }
    }

    private String parseString() {
      expect('"');
      StringBuilder result = new StringBuilder();
      while (!isEnd()) {
        char item = this.text.charAt(this.index++);
        if (item == '"') {
          return result.toString();
        }
        if (item == '\\') {
          if (isEnd()) {
            throw error("Unterminated string escape");
          }
          char escape = this.text.charAt(this.index++);
          switch (escape) {
            case '"':
            case '\\':
            case '/':
              result.append(escape);
              break;
            case 'b':
              result.append('\b');
              break;
            case 'f':
              result.append('\f');
              break;
            case 'n':
              result.append('\n');
              break;
            case 'r':
              result.append('\r');
              break;
            case 't':
              result.append('\t');
              break;
            case 'u':
              result.append(parseUnicodeEscape());
              break;
            default:
              throw error("Invalid string escape: " + escape);
          }
        } else {
          if (item < 0x20) {
            throw error("Unescaped control character in string");
          }
          result.append(item);
        }
      }
      throw error("Unterminated string");
    }

    private char parseUnicodeEscape() {
      if (this.index + 4 > this.text.length()) {
        throw error("Incomplete Unicode escape");
      }
      int value = 0;
      for (int count = 0; count < 4; count++) {
        int digit = Character.digit(this.text.charAt(this.index++), 16);
        if (digit < 0) {
          throw error("Invalid Unicode escape");
        }
        value = value * 16 + digit;
      }
      return (char)value;
    }

    private Number parseNumber() {
      int start = this.index;
      consume('-');
      if (consume('0')) {
        if (!isEnd() && isDigit(this.text.charAt(this.index))) {
          throw error("Leading zero in number");
        }
      } else {
        requireDigits();
      }
      boolean decimal = false;
      if (consume('.')) {
        decimal = true;
        requireDigits();
      }
      if (!isEnd() && (this.text.charAt(this.index) == 'e'
          || this.text.charAt(this.index) == 'E')) {
        decimal = true;
        this.index++;
        if (!isEnd() && (this.text.charAt(this.index) == '+'
            || this.text.charAt(this.index) == '-')) {
          this.index++;
        }
        requireDigits();
      }
      String number = this.text.substring(start, this.index);
      try {
        if (!decimal) {
          return Long.valueOf(number);
        }
        double value = Double.parseDouble(number);
        if (Double.isInfinite(value) || Double.isNaN(value)) {
          throw error("JSON number is not finite");
        }
        return Double.valueOf(value);
      } catch (NumberFormatException exception) {
        throw error("Invalid JSON number");
      }
    }

    private void requireDigits() {
      int start = this.index;
      while (!isEnd() && isDigit(this.text.charAt(this.index))) {
        this.index++;
      }
      if (this.index == start) {
        throw error("Expected a digit");
      }
    }

    private boolean isDigit(char item) {
      return item >= '0' && item <= '9';
    }

    private void expectLiteral(String literal) {
      if (!this.text.regionMatches(this.index, literal, 0, literal.length())) {
        throw error("Expected " + literal);
      }
      this.index += literal.length();
    }

    private void expect(char expected) {
      skipWhitespace();
      if (!consume(expected)) {
        throw error("Expected '" + expected + "'");
      }
    }

    private boolean consume(char expected) {
      if (!isEnd() && this.text.charAt(this.index) == expected) {
        this.index++;
        return true;
      }
      return false;
    }

    void skipWhitespace() {
      while (!isEnd()) {
        char item = this.text.charAt(this.index);
        if (item != ' ' && item != '\n' && item != '\r' && item != '\t') {
          return;
        }
        this.index++;
      }
    }

    boolean isEnd() {
      return this.index >= this.text.length();
    }

    IllegalArgumentException error(String message) {
      return new IllegalArgumentException(message + " at character " + this.index);
    }
  }
}
