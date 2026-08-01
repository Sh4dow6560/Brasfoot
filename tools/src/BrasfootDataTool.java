import e.g;
import e.t;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public final class BrasfootDataTool {
  private BrasfootDataTool() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0 || "--help".equals(args[0]) || "-h".equals(args[0])) {
      printHelp();
      return;
    }

    String command = args[0];
    Map<String, String> options = parseOptions(Arrays.copyOfRange(args, 1, args.length));

    if ("export-teams".equals(command)) {
      exportTeams(required(options, "--game"), required(options, "--out"));
    } else if ("import-teams".equals(command)) {
      importTeams(required(options, "--in"), required(options, "--out"));
    } else if ("validate".equals(command)) {
      validate(required(options, "--game-or-build"), true);
    } else if ("compare-teams".equals(command)) {
      compareTeams(required(options, "--left"), required(options, "--right"));
    } else {
      throw new IllegalArgumentException("Unknown command: " + command);
    }
  }

  private static void printHelp() {
    System.out.println("BrasfootDataTool");
    System.out.println("  export-teams --game <gameRootOrTeamsDir> --out <teams.json>");
    System.out.println("  import-teams --in <teams.json> --out <teamsDir>");
    System.out.println("  validate --game-or-build <gameRootOrTeamsDir>");
    System.out.println("  compare-teams --left <teams.json> --right <teams.json>");
  }

  private static Map<String, String> parseOptions(String[] args) {
    Map<String, String> options = new LinkedHashMap<String, String>();
    for (int i = 0; i < args.length; i++) {
      String key = args[i];
      if (!key.startsWith("--")) {
        throw new IllegalArgumentException("Expected option, got: " + key);
      }
      if (i + 1 >= args.length) {
        throw new IllegalArgumentException("Missing value for: " + key);
      }
      options.put(key, args[++i]);
    }
    return options;
  }

  private static String required(Map<String, String> options, String key) {
    String value = options.get(key);
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("Missing required option: " + key);
    }
    return value;
  }

  private static void exportTeams(String gamePath, String outPath) throws Exception {
    File teamsDir = findTeamsDir(new File(gamePath));
    List<File> files = listBanFiles(teamsDir);
    List<Object> teams = new ArrayList<Object>();

    for (File file : files) {
      Object loaded = readSerialized(file);
      if (!(loaded instanceof t)) {
        throw new IOException("Not a team file: " + file.getAbsolutePath());
      }
      teams.add(teamToJson(file, (t) loaded));
    }

    Map<String, Object> root = new LinkedHashMap<String, Object>();
    root.put("schemaVersion", 1);
    root.put("source", teamsDir.getAbsolutePath());
    root.put("generatedAt", isoNow());
    root.put("teamCount", teams.size());
    root.put("teams", teams);

    writeJson(new File(outPath), root);
    System.out.println("Exported " + teams.size() + " teams to " + new File(outPath).getAbsolutePath());
  }

  private static void importTeams(String inPath, String outPath) throws Exception {
    Map<String, Object> root = asMap(Json.parse(readText(new File(inPath))), "root");
    List<Object> teams = asList(root.get("teams"), "teams");
    File outDir = new File(outPath);
    if (!outDir.exists() && !outDir.mkdirs()) {
      throw new IOException("Could not create output directory: " + outDir.getAbsolutePath());
    }

    int written = 0;
    for (Object item : teams) {
      Map<String, Object> teamMap = asMap(item, "team");
      String fileName = safeFileName(asString(teamMap.get("file"), "file"));
      t team = jsonToTeam(teamMap, fileName);
      writeSerialized(new File(outDir, fileName), team);
      written++;
    }

    System.out.println("Imported " + written + " teams to " + outDir.getAbsolutePath());
  }

  private static void validate(String gameOrBuildPath, boolean printDetails) throws Exception {
    File teamsDir = findTeamsDir(new File(gameOrBuildPath));
    List<File> files = listBanFiles(teamsDir);
    List<String> errors = new ArrayList<String>();
    List<String> warnings = new ArrayList<String>();

    for (File file : files) {
      try {
        Object loaded = readSerialized(file);
        if (!(loaded instanceof t)) {
          errors.add(file.getName() + ": object is " + loaded.getClass().getName() + ", expected e.t");
          continue;
        }
        validateTeam(teamsDir, file, (t) loaded, warnings, errors);
      } catch (Exception ex) {
        errors.add(file.getName() + ": " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
      }
    }

    Map<String, Object> summary = new LinkedHashMap<String, Object>();
    summary.put("teamsDir", teamsDir.getAbsolutePath());
    summary.put("teamFiles", files.size());
    summary.put("errors", errors);
    summary.put("warnings", warnings);
    summary.put("ok", errors.isEmpty());

    if (printDetails) {
      System.out.println(Json.stringify(summary));
    }

    if (!errors.isEmpty()) {
      throw new IllegalStateException("Validation failed with " + errors.size() + " errors");
    }
  }

  private static void compareTeams(String leftPath, String rightPath) throws Exception {
    Map<String, Object> left = asMap(Json.parse(readText(new File(leftPath))), "left root");
    Map<String, Object> right = asMap(Json.parse(readText(new File(rightPath))), "right root");
    String leftCanonical = Json.stringify(left.get("teams"));
    String rightCanonical = Json.stringify(right.get("teams"));
    String leftHash = sha256(leftCanonical);
    String rightHash = sha256(rightCanonical);

    if (!leftCanonical.equals(rightCanonical)) {
      System.out.println("DIFFER");
      System.out.println("leftSha256=" + leftHash);
      System.out.println("rightSha256=" + rightHash);
      throw new IllegalStateException("Team JSON differs");
    }

    System.out.println("MATCH");
    System.out.println("teams=" + asList(left.get("teams"), "teams").size());
    System.out.println("sha256=" + leftHash);
  }

  private static void validateTeam(File teamsDir, File file, t team, List<String> warnings, List<String> errors) {
    String prefix = file.getName() + ": ";
    if (blank(team.getNome())) {
      errors.add(prefix + "empty team name");
    }
    if (team.getJogadores() == null || team.getJogadores().isEmpty()) {
      errors.add(prefix + "no players");
    } else {
      int count = team.getJogadores().size();
      if (count < 16 || count > 35) {
        warnings.add(prefix + "unusual player count: " + count);
      }
      Set<String> names = new LinkedHashSet<String>();
      for (Object obj : team.getJogadores()) {
        if (!(obj instanceof g)) {
          errors.add(prefix + "player object is not e.g");
          continue;
        }
        g player = (g) obj;
        String name = player.getNome();
        if (blank(name)) {
          errors.add(prefix + "player with empty name");
        } else if (!names.add(name.toLowerCase(Locale.ROOT))) {
          warnings.add(prefix + "duplicated player name: " + name);
        }
      }
    }

    String base = stripExtension(file.getName());
    File shield = new File(new File(teamsDir, "escudos"), base + ".png");
    File miniShield = new File(new File(teamsDir, "escudosMini"), base + ".png");
    File shirt1 = new File(new File(teamsDir, "camisas"), base + ".png");
    File shirt2 = new File(new File(teamsDir, "camisas2"), base + ".png");

    if (new File(teamsDir, "escudos").isDirectory() && !shield.isFile()) {
      warnings.add(prefix + "missing escudo: " + shield.getName());
    }
    if (new File(teamsDir, "escudosMini").isDirectory() && !miniShield.isFile()) {
      warnings.add(prefix + "missing escudo mini: " + miniShield.getName());
    }
    if (new File(teamsDir, "camisas").isDirectory() && !shirt1.isFile()) {
      warnings.add(prefix + "missing camisa 1: " + shirt1.getName());
    }
    if (new File(teamsDir, "camisas2").isDirectory() && !shirt2.isFile()) {
      warnings.add(prefix + "missing camisa 2: " + shirt2.getName());
    }
    if (!looksLikeHexColor(team.getCor1())) {
      warnings.add(prefix + "cor1 is not #RRGGBB: " + team.getCor1());
    }
    if (!looksLikeHexColor(team.getCor2())) {
      warnings.add(prefix + "cor2 is not #RRGGBB: " + team.getCor2());
    }
  }

  private static Map<String, Object> teamToJson(File file, t team) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    map.put("file", file.getName());
    map.put("valid", team.isValid());
    map.put("id", team.getId());
    map.put("pais", team.getPais());
    map.put("estado", team.getEstado());
    map.put("nivel", team.getNivel());
    map.put("fileRef", team.getFileRef());
    map.put("nome", team.getNome());
    map.put("estadio", team.getEstadio());
    map.put("capacidade", team.getCapacidade());
    map.put("tecnico", team.getTecnico());
    map.put("tecNac", team.getTecNac());
    map.put("reputacao", team.getReputacao());
    map.put("corBase", team.getCorBase());
    map.put("tid", team.getTid());
    map.put("sid", team.getSid());
    map.put("aid", team.getAid());
    map.put("vid", team.getVid());
    map.put("cor1", team.getCor1());
    map.put("cor2", team.getCor2());
    map.put("jogadores", playersToJson(team.getJogadores()));
    map.put("juniores", playersToJson(team.getJuniores()));
    return map;
  }

  private static t jsonToTeam(Map<String, Object> map, String fileName) {
    t team = new t();
    team.setValid(asBoolean(defaultValue(map.get("valid"), Boolean.TRUE), "valid"));
    team.setId(asInt(defaultValue(map.get("id"), 0), "id"));
    team.setPais(asInt(defaultValue(map.get("pais"), 0), "pais"));
    team.setEstado(asInt(defaultValue(map.get("estado"), 0), "estado"));
    team.setNivel(asInt(defaultValue(map.get("nivel"), 0), "nivel"));
    team.setFileRef(asString(defaultValue(map.get("fileRef"), stripExtension(fileName)), "fileRef"));
    team.setNome(asString(defaultValue(map.get("nome"), ""), "nome"));
    team.setEstadio(asString(defaultValue(map.get("estadio"), ""), "estadio"));
    team.setCapacidade(asInt(defaultValue(map.get("capacidade"), 0), "capacidade"));
    team.setTecnico(asString(defaultValue(map.get("tecnico"), ""), "tecnico"));
    team.setTecNac(asInt(defaultValue(map.get("tecNac"), 0), "tecNac"));
    team.setReputacao(asInt(defaultValue(map.get("reputacao"), 0), "reputacao"));
    team.setCorBase(asInt(defaultValue(map.get("corBase"), 0), "corBase"));
    team.setTid(asInt(defaultValue(map.get("tid"), 0), "tid"));
    team.setSid(asInt(defaultValue(map.get("sid"), 0), "sid"));
    team.setAid(asInt(defaultValue(map.get("aid"), 0), "aid"));
    team.setVid(asInt(defaultValue(map.get("vid"), 0), "vid"));
    team.setCor1(asString(defaultValue(map.get("cor1"), "#ffffff"), "cor1"));
    team.setCor2(asString(defaultValue(map.get("cor2"), "#000000"), "cor2"));
    team.setJogadores(jsonToPlayers(asList(defaultValue(map.get("jogadores"), new ArrayList<Object>()), "jogadores")));
    team.setJuniores(jsonToPlayers(asList(defaultValue(map.get("juniores"), new ArrayList<Object>()), "juniores")));
    return team;
  }

  private static List<Object> playersToJson(List players) {
    List<Object> result = new ArrayList<Object>();
    if (players == null) {
      return result;
    }
    for (Object obj : players) {
      if (!(obj instanceof g)) {
        continue;
      }
      g player = (g) obj;
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      map.put("nome", player.getNome());
      map.put("estrela", player.isEstrela());
      map.put("pais", player.getPais());
      map.put("idade", player.getIdade());
      map.put("posicao", player.getPosicao());
      map.put("status", player.getStatus());
      map.put("cr1", player.getCr1());
      map.put("cr2", player.getCr2());
      map.put("lado", player.getLado());
      map.put("hash", player.getHash());
      map.put("topMundial", player.isTopMundial());
      map.put("tid", player.getTid());
      map.put("sid", player.getSid());
      map.put("aid", player.getAid());
      result.add(map);
    }
    return result;
  }

  private static ArrayList jsonToPlayers(List<Object> values) {
    ArrayList players = new ArrayList();
    for (Object value : values) {
      Map<String, Object> map = asMap(value, "player");
      g player = new g();
      player.setNome(asString(defaultValue(map.get("nome"), ""), "nome"));
      player.setEstrela(asBoolean(defaultValue(map.get("estrela"), Boolean.FALSE), "estrela"));
      player.setPais(asInt(defaultValue(map.get("pais"), 0), "pais"));
      player.setIdade(asInt(defaultValue(map.get("idade"), 0), "idade"));
      player.setPosicao(asInt(defaultValue(map.get("posicao"), 0), "posicao"));
      player.setStatus(asInt(defaultValue(map.get("status"), 0), "status"));
      player.setCr1(asInt(defaultValue(map.get("cr1"), 0), "cr1"));
      player.setCr2(asInt(defaultValue(map.get("cr2"), 0), "cr2"));
      player.setLado(asInt(defaultValue(map.get("lado"), 0), "lado"));
      player.setHash(asInt(defaultValue(map.get("hash"), 0), "hash"));
      player.setTopMundial(asBoolean(defaultValue(map.get("topMundial"), Boolean.FALSE), "topMundial"));
      player.setTid(asInt(defaultValue(map.get("tid"), 0), "tid"));
      player.setSid(asInt(defaultValue(map.get("sid"), 0), "sid"));
      player.setAid(asInt(defaultValue(map.get("aid"), 0), "aid"));
      players.add(player);
    }
    return players;
  }

  private static File findTeamsDir(File input) throws IOException {
    File canonical = input.getCanonicalFile();
    if (!canonical.isDirectory()) {
      throw new IOException("Path is not a directory: " + canonical.getAbsolutePath());
    }
    if (new File(canonical, "teams").isDirectory()) {
      return new File(canonical, "teams").getCanonicalFile();
    }
    File[] banFiles = canonical.listFiles();
    if (banFiles != null) {
      for (File file : banFiles) {
        if (file.isFile() && file.getName().toLowerCase(Locale.ROOT).endsWith(".ban")) {
          return canonical;
        }
      }
    }
    throw new IOException("Could not find a teams directory in: " + canonical.getAbsolutePath());
  }

  private static List<File> listBanFiles(File teamsDir) {
    File[] files = teamsDir.listFiles();
    List<File> result = new ArrayList<File>();
    if (files != null) {
      for (File file : files) {
        if (file.isFile() && file.getName().toLowerCase(Locale.ROOT).endsWith(".ban")) {
          result.add(file);
        }
      }
    }
    Collections.sort(result, new Comparator<File>() {
      public int compare(File a, File b) {
        return a.getName().compareToIgnoreCase(b.getName());
      }
    });
    return result;
  }

  private static Object readSerialized(File file) throws IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
    try {
      return in.readObject();
    } finally {
      in.close();
    }
  }

  private static void writeSerialized(File file, Object value) throws IOException {
    File parent = file.getParentFile();
    if (parent != null && !parent.exists() && !parent.mkdirs()) {
      throw new IOException("Could not create directory: " + parent.getAbsolutePath());
    }
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
    try {
      out.writeObject(value);
    } finally {
      out.close();
    }
  }

  private static void writeJson(File file, Object value) throws IOException {
    File parent = file.getParentFile();
    if (parent != null && !parent.exists() && !parent.mkdirs()) {
      throw new IOException("Could not create directory: " + parent.getAbsolutePath());
    }
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
    try {
      writer.write(Json.stringify(value));
      writer.newLine();
    } finally {
      writer.close();
    }
  }

  private static String readText(File file) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    try {
      StringBuilder builder = new StringBuilder();
      char[] buffer = new char[8192];
      int read;
      while ((read = reader.read(buffer)) != -1) {
        builder.append(buffer, 0, read);
      }
      return builder.toString();
    } finally {
      reader.close();
    }
  }

  private static String safeFileName(String value) {
    String name = new File(value).getName();
    if (!name.equals(value) || name.contains("..") || name.indexOf('/') >= 0 || name.indexOf('\\') >= 0) {
      throw new IllegalArgumentException("Unsafe file name: " + value);
    }
    if (!name.toLowerCase(Locale.ROOT).endsWith(".ban")) {
      throw new IllegalArgumentException("Team file must end with .ban: " + value);
    }
    return name;
  }

  private static String stripExtension(String name) {
    int dot = name.lastIndexOf('.');
    return dot >= 0 ? name.substring(0, dot) : name;
  }

  private static boolean blank(String value) {
    return value == null || value.trim().isEmpty();
  }

  private static boolean looksLikeHexColor(String value) {
    return value != null && value.matches("#[0-9a-fA-F]{6}");
  }

  private static Object defaultValue(Object value, Object fallback) {
    return value == null ? fallback : value;
  }

  private static String isoNow() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    return format.format(new Date());
  }

  private static String sha256(String value) throws Exception {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] bytes = digest.digest(value.getBytes(StandardCharsets.UTF_8));
    StringBuilder builder = new StringBuilder();
    for (byte b : bytes) {
      builder.append(String.format("%02x", b & 0xff));
    }
    return builder.toString();
  }

  @SuppressWarnings("unchecked")
  private static Map<String, Object> asMap(Object value, String name) {
    if (!(value instanceof Map)) {
      throw new IllegalArgumentException(name + " must be an object");
    }
    return (Map<String, Object>) value;
  }

  @SuppressWarnings("unchecked")
  private static List<Object> asList(Object value, String name) {
    if (!(value instanceof List)) {
      throw new IllegalArgumentException(name + " must be an array");
    }
    return (List<Object>) value;
  }

  private static String asString(Object value, String name) {
    if (value == null) {
      return null;
    }
    if (!(value instanceof String)) {
      throw new IllegalArgumentException(name + " must be a string");
    }
    return (String) value;
  }

  private static int asInt(Object value, String name) {
    if (value instanceof Number) {
      return ((Number) value).intValue();
    }
    throw new IllegalArgumentException(name + " must be a number");
  }

  private static boolean asBoolean(Object value, String name) {
    if (value instanceof Boolean) {
      return ((Boolean) value).booleanValue();
    }
    throw new IllegalArgumentException(name + " must be a boolean");
  }

  private static final class Json {
    private final String input;
    private int pos;

    private Json(String input) {
      this.input = input;
    }

    static Object parse(String input) {
      Json parser = new Json(input);
      Object value = parser.parseValue();
      parser.skipWhitespace();
      if (parser.pos != parser.input.length()) {
        throw new IllegalArgumentException("Unexpected trailing JSON at position " + parser.pos);
      }
      return value;
    }

    static String stringify(Object value) {
      StringBuilder builder = new StringBuilder();
      writeValue(builder, value, 0);
      return builder.toString();
    }

    private Object parseValue() {
      skipWhitespace();
      if (pos >= input.length()) {
        throw new IllegalArgumentException("Unexpected end of JSON");
      }
      char ch = input.charAt(pos);
      if (ch == '{') {
        return parseObject();
      }
      if (ch == '[') {
        return parseArray();
      }
      if (ch == '"') {
        return parseString();
      }
      if (input.startsWith("true", pos)) {
        pos += 4;
        return Boolean.TRUE;
      }
      if (input.startsWith("false", pos)) {
        pos += 5;
        return Boolean.FALSE;
      }
      if (input.startsWith("null", pos)) {
        pos += 4;
        return null;
      }
      return parseNumber();
    }

    private Map<String, Object> parseObject() {
      expect('{');
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      skipWhitespace();
      if (peek('}')) {
        pos++;
        return map;
      }
      while (true) {
        String key = parseString();
        skipWhitespace();
        expect(':');
        map.put(key, parseValue());
        skipWhitespace();
        if (peek('}')) {
          pos++;
          return map;
        }
        expect(',');
      }
    }

    private List<Object> parseArray() {
      expect('[');
      List<Object> list = new ArrayList<Object>();
      skipWhitespace();
      if (peek(']')) {
        pos++;
        return list;
      }
      while (true) {
        list.add(parseValue());
        skipWhitespace();
        if (peek(']')) {
          pos++;
          return list;
        }
        expect(',');
      }
    }

    private String parseString() {
      expect('"');
      StringBuilder builder = new StringBuilder();
      while (pos < input.length()) {
        char ch = input.charAt(pos++);
        if (ch == '"') {
          return builder.toString();
        }
        if (ch == '\\') {
          if (pos >= input.length()) {
            throw new IllegalArgumentException("Invalid escape at end of JSON");
          }
          char esc = input.charAt(pos++);
          if (esc == '"' || esc == '\\' || esc == '/') {
            builder.append(esc);
          } else if (esc == 'b') {
            builder.append('\b');
          } else if (esc == 'f') {
            builder.append('\f');
          } else if (esc == 'n') {
            builder.append('\n');
          } else if (esc == 'r') {
            builder.append('\r');
          } else if (esc == 't') {
            builder.append('\t');
          } else if (esc == 'u') {
            if (pos + 4 > input.length()) {
              throw new IllegalArgumentException("Invalid unicode escape at position " + pos);
            }
            String hex = input.substring(pos, pos + 4);
            builder.append((char) Integer.parseInt(hex, 16));
            pos += 4;
          } else {
            throw new IllegalArgumentException("Invalid escape: \\" + esc);
          }
        } else {
          builder.append(ch);
        }
      }
      throw new IllegalArgumentException("Unterminated string");
    }

    private Number parseNumber() {
      int start = pos;
      if (peek('-')) {
        pos++;
      }
      while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
        pos++;
      }
      boolean decimal = false;
      if (peek('.')) {
        decimal = true;
        pos++;
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
          pos++;
        }
      }
      if (pos < input.length() && (input.charAt(pos) == 'e' || input.charAt(pos) == 'E')) {
        decimal = true;
        pos++;
        if (pos < input.length() && (input.charAt(pos) == '+' || input.charAt(pos) == '-')) {
          pos++;
        }
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
          pos++;
        }
      }
      if (start == pos) {
        throw new IllegalArgumentException("Expected number at position " + pos);
      }
      String raw = input.substring(start, pos);
      return decimal ? Double.valueOf(raw) : Long.valueOf(raw);
    }

    private void skipWhitespace() {
      while (pos < input.length()) {
        char ch = input.charAt(pos);
        if (ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t') {
          pos++;
        } else {
          return;
        }
      }
    }

    private boolean peek(char ch) {
      return pos < input.length() && input.charAt(pos) == ch;
    }

    private void expect(char ch) {
      skipWhitespace();
      if (pos >= input.length() || input.charAt(pos) != ch) {
        throw new IllegalArgumentException("Expected '" + ch + "' at position " + pos);
      }
      pos++;
    }

    private static void writeValue(StringBuilder builder, Object value, int indent) {
      if (value == null) {
        builder.append("null");
      } else if (value instanceof String) {
        writeString(builder, (String) value);
      } else if (value instanceof Number || value instanceof Boolean) {
        builder.append(value.toString());
      } else if (value instanceof Map) {
        writeObject(builder, (Map<?, ?>) value, indent);
      } else if (value instanceof List) {
        writeArray(builder, (List<?>) value, indent);
      } else {
        writeString(builder, value.toString());
      }
    }

    private static void writeObject(StringBuilder builder, Map<?, ?> map, int indent) {
      builder.append('{');
      if (!map.isEmpty()) {
        boolean first = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
          if (!first) {
            builder.append(',');
          }
          builder.append('\n');
          appendIndent(builder, indent + 2);
          writeString(builder, String.valueOf(entry.getKey()));
          builder.append(": ");
          writeValue(builder, entry.getValue(), indent + 2);
          first = false;
        }
        builder.append('\n');
        appendIndent(builder, indent);
      }
      builder.append('}');
    }

    private static void writeArray(StringBuilder builder, List<?> list, int indent) {
      builder.append('[');
      if (!list.isEmpty()) {
        for (int i = 0; i < list.size(); i++) {
          if (i > 0) {
            builder.append(',');
          }
          builder.append('\n');
          appendIndent(builder, indent + 2);
          writeValue(builder, list.get(i), indent + 2);
        }
        builder.append('\n');
        appendIndent(builder, indent);
      }
      builder.append(']');
    }

    private static void writeString(StringBuilder builder, String value) {
      builder.append('"');
      for (int i = 0; i < value.length(); i++) {
        char ch = value.charAt(i);
        if (ch == '"') {
          builder.append("\\\"");
        } else if (ch == '\\') {
          builder.append("\\\\");
        } else if (ch == '\b') {
          builder.append("\\b");
        } else if (ch == '\f') {
          builder.append("\\f");
        } else if (ch == '\n') {
          builder.append("\\n");
        } else if (ch == '\r') {
          builder.append("\\r");
        } else if (ch == '\t') {
          builder.append("\\t");
        } else if (ch < 0x20) {
          builder.append(String.format("\\u%04x", (int) ch));
        } else {
          builder.append(ch);
        }
      }
      builder.append('"');
    }

    private static void appendIndent(StringBuilder builder, int indent) {
      for (int i = 0; i < indent; i++) {
        builder.append(' ');
      }
    }
  }
}
