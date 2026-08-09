package mod.extension.state;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public final class ModState {
  public static final int CURRENT_SCHEMA_VERSION = 1;

  private final int schemaVersion;
  private final long revision;
  private final Map<String, Boolean> featureOverrides;
  private final Map<String, Map<String, Object>> modules;

  private ModState(
      int schemaVersion,
      long revision,
      Map<String, Boolean> featureOverrides,
      Map<String, ? extends Map<String, ?>> modules) {
    if (schemaVersion != CURRENT_SCHEMA_VERSION) {
      throw new IllegalArgumentException("Unsupported in-memory schema: " + schemaVersion);
    }
    if (revision < 0L) {
      throw new IllegalArgumentException("revision must not be negative");
    }
    this.schemaVersion = schemaVersion;
    this.revision = revision;
    this.featureOverrides = immutableFeatures(featureOverrides);
    this.modules = immutableModules(modules);
  }

  public static ModState empty() {
    return new ModState(
        CURRENT_SCHEMA_VERSION,
        0L,
        Collections.<String, Boolean>emptyMap(),
        Collections.<String, Map<String, ?>>emptyMap());
  }

  static ModState loaded(
      long revision,
      Map<String, Boolean> featureOverrides,
      Map<String, ? extends Map<String, ?>> modules) {
    return new ModState(CURRENT_SCHEMA_VERSION, revision, featureOverrides, modules);
  }

  public int getSchemaVersion() {
    return this.schemaVersion;
  }

  public long getRevision() {
    return this.revision;
  }

  public Map<String, Boolean> getFeatureOverrides() {
    return this.featureOverrides;
  }

  public Map<String, Map<String, Object>> getModules() {
    return this.modules;
  }

  public Map<String, Object> getModule(String moduleId) {
    requireIdentifier(moduleId, "moduleId");
    Map<String, Object> module = this.modules.get(moduleId);
    return module == null ? Collections.<String, Object>emptyMap() : module;
  }

  public ModState withModule(String moduleId, Map<String, ?> values) {
    requireIdentifier(moduleId, "moduleId");
    if (values == null) {
      throw new NullPointerException("values");
    }
    Map<String, Map<String, ?>> updated =
        new TreeMap<String, Map<String, ?>>(this.modules);
    updated.put(moduleId, values);
    return new ModState(
        this.schemaVersion, this.revision, this.featureOverrides, updated);
  }

  public ModState withoutModule(String moduleId) {
    requireIdentifier(moduleId, "moduleId");
    if (!this.modules.containsKey(moduleId)) {
      return this;
    }
    Map<String, Map<String, ?>> updated =
        new TreeMap<String, Map<String, ?>>(this.modules);
    updated.remove(moduleId);
    return new ModState(
        this.schemaVersion, this.revision, this.featureOverrides, updated);
  }

  ModState withFeatureOverrides(Map<String, Boolean> features) {
    return new ModState(this.schemaVersion, this.revision, features, this.modules);
  }

  ModState nextRevision() {
    if (this.revision == Long.MAX_VALUE) {
      throw new IllegalStateException("Mod state revision overflow");
    }
    return new ModState(
        this.schemaVersion, this.revision + 1L, this.featureOverrides, this.modules);
  }

  ModState atRevision(long revision) {
    return new ModState(
        this.schemaVersion, revision, this.featureOverrides, this.modules);
  }

  static void requireIdentifier(String value, String label) {
    if (value == null) {
      throw new NullPointerException(label);
    }
    if (value.length() == 0 || value.length() > 80) {
      throw new IllegalArgumentException(label + " has an invalid length");
    }
    for (int index = 0; index < value.length(); index++) {
      char item = value.charAt(index);
      boolean valid = item >= 'a' && item <= 'z'
          || item >= 'A' && item <= 'Z'
          || index > 0 && item >= '0' && item <= '9'
          || index > 0 && (item == '.' || item == '_' || item == '-');
      if (!valid) {
        throw new IllegalArgumentException(label + " is invalid: " + value);
      }
    }
  }

  private static Map<String, Boolean> immutableFeatures(Map<String, Boolean> source) {
    if (source == null) {
      throw new NullPointerException("featureOverrides");
    }
    Map<String, Boolean> sorted = new TreeMap<String, Boolean>();
    for (Map.Entry<String, Boolean> entry : source.entrySet()) {
      requireIdentifier(entry.getKey(), "featureId");
      if (entry.getValue() == null) {
        throw new IllegalArgumentException("Feature override must be boolean: " + entry.getKey());
      }
      sorted.put(entry.getKey(), entry.getValue());
    }
    return Collections.unmodifiableMap(
        new LinkedHashMap<String, Boolean>(sorted));
  }

  private static Map<String, Map<String, Object>> immutableModules(
      Map<String, ? extends Map<String, ?>> source) {
    if (source == null) {
      throw new NullPointerException("modules");
    }
    Map<String, Map<String, Object>> sorted =
        new TreeMap<String, Map<String, Object>>();
    for (Map.Entry<String, ? extends Map<String, ?>> entry : source.entrySet()) {
      requireIdentifier(entry.getKey(), "moduleId");
      if (entry.getValue() == null) {
        throw new IllegalArgumentException("Module data must be an object: " + entry.getKey());
      }
      sorted.put(entry.getKey(), JsonCodec.immutableObject(entry.getValue()));
    }
    return Collections.unmodifiableMap(
        new LinkedHashMap<String, Map<String, Object>>(sorted));
  }
}
