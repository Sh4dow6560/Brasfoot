package mod.extension.state;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class ModStateStore {
  public static final String SIDECAR_SUFFIX = ".modstate.json";
  public static final int MAX_SIDECAR_BYTES = 16 * 1024 * 1024;

  public Path sidecarFor(Path saveFile) {
    if (saveFile == null) {
      throw new NullPointerException("saveFile");
    }
    Path fileName = saveFile.getFileName();
    if (fileName == null || fileName.toString().length() == 0) {
      throw new IllegalArgumentException("Save path has no file name: " + saveFile);
    }
    return saveFile.resolveSibling(fileName.toString() + SIDECAR_SUFFIX);
  }

  public LoadResult load(Path saveFile) throws IOException {
    Path sidecar = sidecarFor(saveFile);
    if (!Files.exists(sidecar)) {
      return new LoadResult(
          LoadStatus.MISSING, ModState.empty(), sidecar, null, null);
    }
    if (!Files.isRegularFile(sidecar)) {
      return new LoadResult(
          LoadStatus.CORRUPT,
          ModState.empty(),
          sidecar,
          null,
          "Sidecar is not a regular file");
    }
    if (Files.size(sidecar) > MAX_SIDECAR_BYTES) {
      return new LoadResult(
          LoadStatus.CORRUPT,
          ModState.empty(),
          sidecar,
          null,
          "Sidecar exceeds the 16 MiB safety limit");
    }

    byte[] bytes = Files.readAllBytes(sidecar);
    String sourceHash = sha256(bytes);
    try {
      Object parsed = JsonCodec.parse(new String(bytes, StandardCharsets.UTF_8));
      Map<String, Object> root = object(parsed, "root");
      int schemaVersion = root.containsKey("schemaVersion")
          ? integer(root.get("schemaVersion"), "schemaVersion") : 0;
      if (schemaVersion > ModState.CURRENT_SCHEMA_VERSION) {
        return new LoadResult(
            LoadStatus.UNSUPPORTED,
            ModState.empty(),
            sidecar,
            sourceHash,
            "Sidecar schema " + schemaVersion + " is newer than supported schema "
                + ModState.CURRENT_SCHEMA_VERSION);
      }
      if (schemaVersion < 0) {
        throw new IllegalArgumentException("schemaVersion must not be negative");
      }
      if (schemaVersion == 0) {
        return new LoadResult(
            LoadStatus.MIGRATED,
            migrateSchemaZero(root),
            sidecar,
            sourceHash,
            null);
      }
      return new LoadResult(
          LoadStatus.LOADED,
          decodeCurrent(root),
          sidecar,
          sourceHash,
          null);
    } catch (RuntimeException exception) {
      return new LoadResult(
          LoadStatus.CORRUPT,
          ModState.empty(),
          sidecar,
          sourceHash,
          exception.getMessage());
    }
  }

  public LoadResult save(Path saveFile, LoadResult baseline, ModState state)
      throws IOException {
    if (baseline == null) {
      throw new NullPointerException("baseline");
    }
    if (state == null) {
      throw new NullPointerException("state");
    }
    Path sidecar = sidecarFor(saveFile);
    if (!sidecar.toAbsolutePath().normalize().equals(
        baseline.getSidecar().toAbsolutePath().normalize())) {
      throw new IllegalArgumentException("Baseline belongs to a different save");
    }
    if (!baseline.isWritable()) {
      throw new IllegalStateException(
          "Refusing to overwrite " + baseline.getStatus() + " sidecar: " + sidecar);
    }
    if (state.getRevision() != baseline.getState().getRevision()) {
      throw new IllegalStateException(
          "Mod state revision does not match the loaded baseline");
    }
    verifyUnchanged(sidecar, baseline);

    ModState persisted = state.nextRevision();
    byte[] bytes = (JsonCodec.write(encode(persisted)) + System.lineSeparator())
        .getBytes(StandardCharsets.UTF_8);
    if (bytes.length > MAX_SIDECAR_BYTES) {
      throw new IOException("Mod state exceeds the 16 MiB safety limit");
    }
    writeAtomically(sidecar, bytes);
    return new LoadResult(
        LoadStatus.LOADED,
        persisted,
        sidecar,
        sha256(bytes),
        null);
  }

  private void verifyUnchanged(Path sidecar, LoadResult baseline) throws IOException {
    if (baseline.getStatus() == LoadStatus.MISSING) {
      if (Files.exists(sidecar)) {
        throw new IOException("Mod state sidecar appeared after it was loaded: " + sidecar);
      }
      return;
    }
    if (!Files.isRegularFile(sidecar)) {
      throw new IOException("Mod state sidecar disappeared after it was loaded: " + sidecar);
    }
    String currentHash = sha256(Files.readAllBytes(sidecar));
    if (!currentHash.equals(baseline.getSourceSha256())) {
      throw new IOException("Mod state sidecar changed after it was loaded: " + sidecar);
    }
  }

  private void writeAtomically(Path sidecar, byte[] bytes) throws IOException {
    Path parent = sidecar.toAbsolutePath().normalize().getParent();
    if (parent == null) {
      throw new IOException("Sidecar has no parent directory: " + sidecar);
    }
    Files.createDirectories(parent);
    Path temporary = Files.createTempFile(parent, ".modstate-", ".tmp");
    try {
      FileChannel channel = FileChannel.open(
          temporary, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
      try {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        while (buffer.hasRemaining()) {
          channel.write(buffer);
        }
        channel.force(true);
      } finally {
        channel.close();
      }
      try {
        Files.move(
            temporary,
            sidecar,
            StandardCopyOption.ATOMIC_MOVE,
            StandardCopyOption.REPLACE_EXISTING);
      } catch (AtomicMoveNotSupportedException exception) {
        Files.move(temporary, sidecar, StandardCopyOption.REPLACE_EXISTING);
      }
    } finally {
      Files.deleteIfExists(temporary);
    }
  }

  private ModState decodeCurrent(Map<String, Object> root) {
    int schemaVersion = integer(root.get("schemaVersion"), "schemaVersion");
    if (schemaVersion != ModState.CURRENT_SCHEMA_VERSION) {
      throw new IllegalArgumentException("Unsupported schemaVersion: " + schemaVersion);
    }
    long revision = optionalLong(root.get("revision"), "revision", 0L);
    Map<String, Boolean> features = decodeFeatureMap(root.get("features"));
    Map<String, Map<String, Object>> modules = decodeModules(root.get("modules"));
    return ModState.loaded(revision, features, modules);
  }

  private ModState migrateSchemaZero(Map<String, Object> root) {
    long revision = optionalLong(root.get("revision"), "revision", 0L);
    Map<String, Boolean> features = new TreeMap<String, Boolean>();
    Object enabled = root.get("enabledFeatures");
    if (enabled != null) {
      if (!(enabled instanceof List)) {
        throw new IllegalArgumentException("enabledFeatures must be an array");
      }
      for (Object value : (List<?>)enabled) {
        if (!(value instanceof String)) {
          throw new IllegalArgumentException("enabledFeatures must contain strings");
        }
        ModState.requireIdentifier((String)value, "featureId");
        features.put((String)value, Boolean.TRUE);
      }
    }
    Object oldModules = root.containsKey("data") ? root.get("data") : root.get("modules");
    return ModState.loaded(revision, features, decodeModules(oldModules));
  }

  private Map<String, Object> encode(ModState state) {
    Map<String, Object> root = new LinkedHashMap<String, Object>();
    root.put("schemaVersion", Long.valueOf(state.getSchemaVersion()));
    root.put("revision", Long.valueOf(state.getRevision()));
    root.put("features", state.getFeatureOverrides());
    root.put("modules", state.getModules());
    return root;
  }

  private Map<String, Boolean> decodeFeatureMap(Object value) {
    if (value == null) {
      return Collections.emptyMap();
    }
    Map<String, Object> object = object(value, "features");
    Map<String, Boolean> result = new TreeMap<String, Boolean>();
    for (Map.Entry<String, Object> entry : object.entrySet()) {
      ModState.requireIdentifier(entry.getKey(), "featureId");
      if (!(entry.getValue() instanceof Boolean)) {
        throw new IllegalArgumentException(
            "Feature override must be boolean: " + entry.getKey());
      }
      result.put(entry.getKey(), (Boolean)entry.getValue());
    }
    return result;
  }

  private Map<String, Map<String, Object>> decodeModules(Object value) {
    if (value == null) {
      return Collections.emptyMap();
    }
    Map<String, Object> object = object(value, "modules");
    Map<String, Map<String, Object>> result =
        new TreeMap<String, Map<String, Object>>();
    for (Map.Entry<String, Object> entry : object.entrySet()) {
      ModState.requireIdentifier(entry.getKey(), "moduleId");
      result.put(entry.getKey(), object(entry.getValue(), "module " + entry.getKey()));
    }
    return result;
  }

  private Map<String, Object> object(Object value, String label) {
    if (!(value instanceof Map)) {
      throw new IllegalArgumentException(label + " must be a JSON object");
    }
    Map<?, ?> source = (Map<?, ?>)value;
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    for (Map.Entry<?, ?> entry : source.entrySet()) {
      if (!(entry.getKey() instanceof String)) {
        throw new IllegalArgumentException(label + " contains a non-string key");
      }
      result.put((String)entry.getKey(), entry.getValue());
    }
    return result;
  }

  private int integer(Object value, String label) {
    long number = requiredLong(value, label);
    if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
      throw new IllegalArgumentException(label + " is outside the integer range");
    }
    return (int)number;
  }

  private long optionalLong(Object value, String label, long fallback) {
    return value == null ? fallback : requiredLong(value, label);
  }

  private long requiredLong(Object value, String label) {
    if (!(value instanceof Long)) {
      throw new IllegalArgumentException(label + " must be an integer");
    }
    long result = ((Long)value).longValue();
    if (result < 0L) {
      throw new IllegalArgumentException(label + " must not be negative");
    }
    return result;
  }

  private String sha256(byte[] bytes) {
    try {
      byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
      StringBuilder result = new StringBuilder(digest.length * 2);
      for (byte value : digest) {
        result.append(String.format("%02x", Integer.valueOf(value & 0xff)));
      }
      return result.toString();
    } catch (NoSuchAlgorithmException exception) {
      throw new IllegalStateException("SHA-256 is unavailable", exception);
    }
  }

  public enum LoadStatus {
    MISSING,
    LOADED,
    MIGRATED,
    CORRUPT,
    UNSUPPORTED
  }

  public static final class LoadResult {
    private final LoadStatus status;
    private final ModState state;
    private final Path sidecar;
    private final String sourceSha256;
    private final String warning;

    private LoadResult(
        LoadStatus status,
        ModState state,
        Path sidecar,
        String sourceSha256,
        String warning) {
      this.status = status;
      this.state = state;
      this.sidecar = sidecar;
      this.sourceSha256 = sourceSha256;
      this.warning = warning;
    }

    public LoadStatus getStatus() {
      return this.status;
    }

    public ModState getState() {
      return this.state;
    }

    public Path getSidecar() {
      return this.sidecar;
    }

    public String getSourceSha256() {
      return this.sourceSha256;
    }

    public String getWarning() {
      return this.warning;
    }

    public boolean isWritable() {
      return this.status == LoadStatus.MISSING
          || this.status == LoadStatus.LOADED
          || this.status == LoadStatus.MIGRATED;
    }
  }
}
