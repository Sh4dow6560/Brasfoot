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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import java.util.TreeMap;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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
      exportTeams(
          required(options, "--game"),
          required(options, "--out"),
          optionalInt(options, "--country"),
          optionalBoolean(options, "--skip-invalid", false),
          options.get("--selection"));
    } else if ("import-teams".equals(command)) {
      importTeams(required(options, "--in"), required(options, "--out"));
    } else if ("validate".equals(command)) {
      validate(
          required(options, "--game-or-build"),
          true,
          optionalBoolean(options, "--summary-only", false));
    } else if ("compare-teams".equals(command)) {
      compareTeams(required(options, "--left"), required(options, "--right"));
    } else if ("audit-source".equals(command)) {
      auditSource(
          required(options, "--game"),
          required(options, "--out"),
          optionalInt(options, "--country"));
    } else if ("stage-resources".equals(command)) {
      stageResources(
          required(options, "--game"),
          required(options, "--selection"),
          required(options, "--out"));
    } else {
      throw new IllegalArgumentException("Unknown command: " + command);
    }
  }

  private static void printHelp() {
    System.out.println("BrasfootDataTool");
    System.out.println("  export-teams --game <gameRootOrTeamsDir> --out <teams.json>"
        + " [--country <id>] [--skip-invalid <true|false>] [--selection <manifest.json>]");
    System.out.println("  import-teams --in <teams.json> --out <teamsDir>");
    System.out.println("  validate --game-or-build <gameRootOrTeamsDir>"
        + " [--summary-only <true|false>]");
    System.out.println("  compare-teams --left <teams.json> --right <teams.json>");
    System.out.println("  audit-source --game <gameRootOrTeamsDir> --out <manifest.json>"
        + " [--country <id>]");
    System.out.println("  stage-resources --game <gameRootOrTeamsDir>"
        + " --selection <manifest.json> --out <teamsDir>");
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

  private static Integer optionalInt(Map<String, String> options, String key) {
    String value = options.get(key);
    if (value == null || value.trim().isEmpty()) {
      return null;
    }
    return Integer.valueOf(value);
  }

  private static boolean optionalBoolean(
      Map<String, String> options, String key, boolean fallback) {
    String value = options.get(key);
    if (value == null || value.trim().isEmpty()) {
      return fallback;
    }
    if (!"true".equalsIgnoreCase(value) && !"false".equalsIgnoreCase(value)) {
      throw new IllegalArgumentException(key + " must be true or false");
    }
    return Boolean.parseBoolean(value);
  }

  private static void exportTeams(
      String gamePath, String outPath, Integer countryFilter, boolean skipInvalid,
      String selectionPath)
      throws Exception {
    File teamsDir = findTeamsDir(new File(gamePath));
    List<File> files = listBanFiles(teamsDir);
    Set<String> selectedFiles = readSelectedFiles(selectionPath);
    Set<String> matchedSelection = new LinkedHashSet<String>();
    List<Object> teams = new ArrayList<Object>();
    List<String> skipped = new ArrayList<String>();
    List<String> warnings = new ArrayList<String>();

    for (File file : files) {
      if (selectedFiles != null
          && !selectedFiles.contains(file.getName().toLowerCase(Locale.ROOT))) {
        continue;
      }
      if (selectedFiles != null) {
        matchedSelection.add(file.getName().toLowerCase(Locale.ROOT));
      }
      try {
        Object loaded = readSerialized(file);
        if (!(loaded instanceof t)) {
          throw new IOException("Not a team file: " + file.getAbsolutePath());
        }
        t team = (t) loaded;
        List<String> teamWarnings = new ArrayList<String>();
        List<String> teamErrors = new ArrayList<String>();
        validateTeam(teamsDir, file, team, teamWarnings, teamErrors);
        if (skipInvalid && !teamErrors.isEmpty()) {
          skipped.addAll(teamErrors);
          continue;
        }
        if (countryFilter == null || team.getPais() == countryFilter.intValue()) {
          teams.add(teamToJson(file, team));
          warnings.addAll(teamWarnings);
        }
      } catch (Exception exception) {
        if (!skipInvalid) {
          throw exception;
        }
        skipped.add(file.getName() + ": " + exception.getClass().getSimpleName()
            + ": " + exception.getMessage());
      }
    }
    if (selectedFiles != null && !matchedSelection.equals(selectedFiles)) {
      Set<String> missing = new LinkedHashSet<String>(selectedFiles);
      missing.removeAll(matchedSelection);
      throw new IOException("Selection files not found: " + missing);
    }

    Map<String, Object> root = new LinkedHashMap<String, Object>();
    root.put("schemaVersion", 1);
    root.put("source", teamsDir.getAbsolutePath());
    root.put("generatedAt", isoNow());
    root.put("sourceTeamFiles", files.size());
    root.put("countryFilter", countryFilter);
    root.put("selection", selectionPath == null ? null : new File(selectionPath).getName());
    root.put("skipInvalid", Boolean.valueOf(skipInvalid));
    root.put("teamCount", teams.size());
    root.put("skipped", skipped);
    root.put("warningCount", warnings.size());
    root.put("teams", teams);

    writeJson(new File(outPath), root);
    System.out.println("Exported " + teams.size() + " teams to "
        + new File(outPath).getAbsolutePath() + "; skipped=" + skipped.size()
        + " warnings=" + warnings.size());
  }

  private static Set<String> readSelectedFiles(String selectionPath) throws Exception {
    if (selectionPath == null || selectionPath.trim().isEmpty()) {
      return null;
    }
    Map<String, Object> root = asMap(
        Json.parse(readText(new File(selectionPath))), "selection root");
    Set<String> selected = new LinkedHashSet<String>();
    Object files = root.get("files");
    if (files != null) {
      addSelectedFiles(selected, asList(files, "selection files"));
    }
    Object groups = root.get("groups");
    if (groups != null) {
      for (Object item : asList(groups, "selection groups")) {
        Map<String, Object> group = asMap(item, "selection group");
        addSelectedFiles(selected, asList(group.get("files"), "selection group files"));
      }
    }
    if (selected.isEmpty()) {
      throw new IllegalArgumentException("Selection contains no team files: " + selectionPath);
    }
    return selected;
  }

  private static void addSelectedFiles(Set<String> selected, List<Object> files) {
    for (Object item : files) {
      String file = safeFileName(asString(item, "selection file"));
      String normalized = file.toLowerCase(Locale.ROOT);
      if (!selected.add(normalized)) {
        throw new IllegalArgumentException("Duplicated selection file: " + file);
      }
    }
  }

  private static void auditSource(String gamePath, String outPath, Integer countryFilter)
      throws Exception {
    File input = new File(gamePath).getCanonicalFile();
    File teamsDir = findTeamsDir(input);
    File sourceRoot = teamsDir.getParentFile() == null ? teamsDir : teamsDir.getParentFile();
    List<File> allFiles = new ArrayList<File>();
    collectFiles(sourceRoot, allFiles);
    Collections.sort(allFiles, new Comparator<File>() {
      public int compare(File left, File right) {
        return relativePath(sourceRoot, left).compareToIgnoreCase(relativePath(sourceRoot, right));
      }
    });

    long totalBytes = 0L;
    Map<String, Integer> extensions = new TreeMap<String, Integer>();
    List<Object> executables = new ArrayList<Object>();
    for (File file : allFiles) {
      totalBytes += file.length();
      String extension = extension(file.getName());
      increment(extensions, extension);
      if (".exe".equals(extension)) {
        Map<String, Object> executable = new LinkedHashMap<String, Object>();
        executable.put("file", relativePath(sourceRoot, file));
        executable.put("size", Long.valueOf(file.length()));
        executable.put("sha256", sha256(file));
        executable.put("classEntries", Integer.valueOf(countClassEntries(file)));
        executables.add(executable);
      }
    }

    List<File> teamFiles = listBanFiles(teamsDir);
    List<String> errors = new ArrayList<String>();
    List<String> warnings = new ArrayList<String>();
    List<Object> selectedTeams = new ArrayList<Object>();
    StringBuilder selectedFingerprint = new StringBuilder();
    int readableTeams = 0;
    for (File file : teamFiles) {
      try {
        Object loaded = readSerialized(file);
        if (!(loaded instanceof t)) {
          errors.add(file.getName() + ": object is " + loaded.getClass().getName()
              + ", expected e.t");
          continue;
        }
        readableTeams++;
        t team = (t) loaded;
        List<String> teamWarnings = new ArrayList<String>();
        List<String> teamErrors = new ArrayList<String>();
        validateTeam(teamsDir, file, team, teamWarnings, teamErrors);
        warnings.addAll(teamWarnings);
        errors.addAll(teamErrors);
        if (countryFilter == null || team.getPais() == countryFilter.intValue()) {
          String teamHash = sha256(file);
          selectedFingerprint.append(file.getName().toLowerCase(Locale.ROOT))
              .append(':').append(teamHash).append('\n');
          selectedTeams.add(teamAuditSummary(
              teamsDir, file, team, teamHash, teamWarnings, teamErrors));
        }
      } catch (Exception exception) {
        errors.add(file.getName() + ": " + exception.getClass().getSimpleName()
            + ": " + exception.getMessage());
      }
    }

    Map<String, Integer> errorCategories = categorizeIssues(errors);
    Map<String, Integer> warningCategories = categorizeIssues(warnings);
    Map<String, Object> manifest = new LinkedHashMap<String, Object>();
    manifest.put("schemaVersion", 1);
    manifest.put("sourceName", sourceRoot.getName());
    manifest.put("generatedAt", isoNow());
    manifest.put("countryFilter", countryFilter);
    manifest.put("files", Integer.valueOf(allFiles.size()));
    manifest.put("bytes", Long.valueOf(totalBytes));
    manifest.put("extensions", extensions);
    manifest.put("executables", executables);
    manifest.put("teamFiles", Integer.valueOf(teamFiles.size()));
    manifest.put("readableTeams", Integer.valueOf(readableTeams));
    manifest.put("errorCount", Integer.valueOf(errors.size()));
    manifest.put("errorCategories", errorCategories);
    manifest.put("errors", errors);
    manifest.put("warningCount", Integer.valueOf(warnings.size()));
    manifest.put("warningCategories", warningCategories);
    manifest.put("selectedTeamCount", Integer.valueOf(selectedTeams.size()));
    manifest.put("selectedTeamSetSha256", sha256(selectedFingerprint.toString()));
    manifest.put("selectedTeams", selectedTeams);
    writeJson(new File(outPath), manifest);
    System.out.println("Audited " + teamFiles.size() + " teams and " + allFiles.size()
        + " files; selected=" + selectedTeams.size() + " errors=" + errors.size()
        + " warnings=" + warnings.size());
  }

  private static void stageResources(
      String gamePath, String selectionPath, String outPath) throws Exception {
    File teamsDir = findTeamsDir(new File(gamePath));
    File output = new File(outPath).getCanonicalFile();
    if (output.toPath().startsWith(teamsDir.toPath())) {
      throw new IOException("Resource output must be outside the source teams directory");
    }
    Set<String> selected = readSelectedFiles(selectionPath);
    String[] requiredDirectories = new String[]{
        "escudos", "escudosMini", "camisas", "camisas2"};
    String[] optionalDirectories = new String[]{"camisas3"};
    List<String> missing = new ArrayList<String>();
    List<Object> copied = new ArrayList<Object>();
    StringBuilder fingerprint = new StringBuilder();

    for (String selectedFile : selected) {
      String imageName = stripExtension(selectedFile) + ".png";
      for (String directory : requiredDirectories) {
        copySelectedResource(
            teamsDir, output, directory, imageName, true, missing, copied, fingerprint);
      }
      for (String directory : optionalDirectories) {
        copySelectedResource(
            teamsDir, output, directory, imageName, false, missing, copied, fingerprint);
      }
    }

    Map<String, Object> manifest = new LinkedHashMap<String, Object>();
    manifest.put("schemaVersion", 1);
    manifest.put("sourceName", teamsDir.getParentFile() == null
        ? teamsDir.getName() : teamsDir.getParentFile().getName());
    manifest.put("selection", new File(selectionPath).getName());
    manifest.put("teamCount", Integer.valueOf(selected.size()));
    manifest.put("copiedFiles", Integer.valueOf(copied.size()));
    manifest.put("missingRequired", missing);
    manifest.put("resourceSetSha256", sha256(fingerprint.toString()));
    manifest.put("resources", copied);
    writeJson(new File(output, "update-resource-manifest.json"), manifest);
    if (!missing.isEmpty()) {
      throw new IOException("Missing required selected resources: " + missing);
    }
    System.out.println("Staged " + copied.size() + " resources for " + selected.size()
        + " teams; sha256=" + sha256(fingerprint.toString()));
  }

  private static void copySelectedResource(
      File teamsDir, File output, String directory, String imageName, boolean required,
      List<String> missing, List<Object> copied, StringBuilder fingerprint) throws Exception {
    File source = new File(new File(teamsDir, directory), imageName);
    String relative = directory + "/" + imageName;
    if (!source.isFile()) {
      if (required) {
        missing.add(relative);
      }
      return;
    }
    File target = new File(new File(output, directory), imageName);
    File parent = target.getParentFile();
    if (!parent.isDirectory() && !parent.mkdirs()) {
      throw new IOException("Could not create resource directory: " + parent);
    }
    Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    String hash = sha256(source);
    if (target.length() != source.length() || !hash.equals(sha256(target))) {
      throw new IOException("Copied resource differs: " + relative);
    }
    Map<String, Object> metadata = new LinkedHashMap<String, Object>();
    metadata.put("file", relative);
    metadata.put("size", Long.valueOf(source.length()));
    metadata.put("sha256", hash);
    copied.add(metadata);
    fingerprint.append(relative.toLowerCase(Locale.ROOT)).append(':').append(hash).append('\n');
  }

  private static Map<String, Object> teamAuditSummary(
      File teamsDir, File file, t team, String teamHash,
      List<String> warnings, List<String> errors) throws Exception {
    Map<String, Object> summary = new LinkedHashMap<String, Object>();
    summary.put("file", file.getName());
    summary.put("sha256", teamHash);
    summary.put("modifiedAt", iso(file.lastModified()));
    summary.put("id", Integer.valueOf(team.getId()));
    summary.put("pais", Integer.valueOf(team.getPais()));
    summary.put("estado", Integer.valueOf(team.getEstado()));
    summary.put("nivel", Integer.valueOf(team.getNivel()));
    summary.put("nome", team.getNome());
    summary.put("estadio", team.getEstadio());
    summary.put("capacidade", Integer.valueOf(team.getCapacidade()));
    summary.put("tecnico", team.getTecnico());
    summary.put("reputacao", Integer.valueOf(team.getReputacao()));
    summary.put("players", Integer.valueOf(team.getJogadores() == null
        ? 0 : team.getJogadores().size()));
    summary.put("youthPlayers", Integer.valueOf(team.getJuniores() == null
        ? 0 : team.getJuniores().size()));
    summary.put("warningCount", Integer.valueOf(warnings.size()));
    summary.put("errorCount", Integer.valueOf(errors.size()));
    summary.put("resources", teamResourceSummary(teamsDir, file));
    return summary;
  }

  private static Map<String, Object> teamResourceSummary(File teamsDir, File teamFile)
      throws Exception {
    Map<String, Object> resources = new LinkedHashMap<String, Object>();
    String base = stripExtension(teamFile.getName()) + ".png";
    String[] directories = new String[]{
        "escudos", "escudosMini", "camisas", "camisas2", "camisas3"};
    for (String directory : directories) {
      File resource = new File(new File(teamsDir, directory), base);
      if (!resource.isFile()) {
        resources.put(directory, null);
        continue;
      }
      Map<String, Object> metadata = new LinkedHashMap<String, Object>();
      metadata.put("file", directory + "/" + base);
      metadata.put("size", Long.valueOf(resource.length()));
      metadata.put("sha256", sha256(resource));
      resources.put(directory, metadata);
    }
    return resources;
  }

  private static void collectFiles(File directory, List<File> files) {
    File[] children = directory.listFiles();
    if (children == null) {
      return;
    }
    Arrays.sort(children, new Comparator<File>() {
      public int compare(File left, File right) {
        return left.getName().compareToIgnoreCase(right.getName());
      }
    });
    for (File child : children) {
      if (child.isDirectory()) {
        collectFiles(child, files);
      } else if (child.isFile()) {
        files.add(child);
      }
    }
  }

  private static String relativePath(File root, File file) {
    return root.toPath().relativize(file.toPath()).toString()
        .replace(File.separatorChar, '/');
  }

  private static String extension(String name) {
    int index = name.lastIndexOf('.');
    return index < 0 ? "<none>" : name.substring(index).toLowerCase(Locale.ROOT);
  }

  private static void increment(Map<String, Integer> counts, String key) {
    Integer count = counts.get(key);
    counts.put(key, Integer.valueOf(count == null ? 1 : count.intValue() + 1));
  }

  private static int countClassEntries(File archiveFile) {
    try {
      ZipFile archive = new ZipFile(archiveFile);
      try {
        int classes = 0;
        Enumeration<? extends ZipEntry> entries = archive.entries();
        while (entries.hasMoreElements()) {
          ZipEntry entry = entries.nextElement();
          if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
            classes++;
          }
        }
        return classes;
      } finally {
        archive.close();
      }
    } catch (IOException exception) {
      return -1;
    }
  }

  private static Map<String, Integer> categorizeIssues(List<String> issues) {
    Map<String, Integer> categories = new TreeMap<String, Integer>();
    for (String issue : issues) {
      increment(categories, issueCategory(issue));
    }
    return categories;
  }

  private static String issueCategory(String issue) {
    String value = issue.toLowerCase(Locale.ROOT);
    if (value.contains("missing camisa 1")) return "missing-shirt-1";
    if (value.contains("missing camisa 2")) return "missing-shirt-2";
    if (value.contains("missing escudo mini")) return "missing-mini-shield";
    if (value.contains("missing escudo")) return "missing-shield";
    if (value.contains("duplicated player name")) return "duplicate-player-name";
    if (value.contains("unusual player count")) return "unusual-player-count";
    if (value.contains("player with empty name")) return "empty-player-name";
    if (value.contains("empty team name")) return "empty-team-name";
    if (value.contains("no players")) return "no-players";
    if (value.contains("cor1 is not")) return "invalid-color-1";
    if (value.contains("cor2 is not")) return "invalid-color-2";
    if (value.contains("streamcorruptedexception")) return "corrupt-serialization";
    if (value.contains("expected e.t") || value.contains("not a team file")) {
      return "invalid-team-type";
    }
    return "other";
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

  private static void validate(
      String gameOrBuildPath, boolean printDetails, boolean summaryOnly) throws Exception {
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
      if (summaryOnly) {
        Map<String, Object> compact = new LinkedHashMap<String, Object>();
        compact.put("teamsDir", teamsDir.getAbsolutePath());
        compact.put("teamFiles", Integer.valueOf(files.size()));
        compact.put("errorCount", Integer.valueOf(errors.size()));
        compact.put("errorCategories", categorizeIssues(errors));
        compact.put("errors", errors);
        compact.put("warningCount", Integer.valueOf(warnings.size()));
        compact.put("warningCategories", categorizeIssues(warnings));
        compact.put("ok", Boolean.valueOf(errors.isEmpty()));
        System.out.println(Json.stringify(compact));
      } else {
        System.out.println(Json.stringify(summary));
      }
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
    return iso(System.currentTimeMillis());
  }

  private static String iso(long time) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    return format.format(new Date(time));
  }

  private static String sha256(File file) throws Exception {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    FileInputStream input = new FileInputStream(file);
    try {
      byte[] buffer = new byte[8192];
      int read;
      while ((read = input.read(buffer)) >= 0) {
        if (read > 0) {
          digest.update(buffer, 0, read);
        }
      }
    } finally {
      input.close();
    }
    return hex(digest.digest());
  }

  private static String sha256(String value) throws Exception {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] bytes = digest.digest(value.getBytes(StandardCharsets.UTF_8));
    return hex(bytes);
  }

  private static String hex(byte[] bytes) {
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
