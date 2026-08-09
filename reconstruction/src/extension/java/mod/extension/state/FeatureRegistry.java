package mod.extension.state;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public final class FeatureRegistry {
  private final Map<String, Boolean> overrides = new TreeMap<String, Boolean>();

  public FeatureRegistry() {
  }

  public FeatureRegistry(Map<String, Boolean> overrides) {
    if (overrides == null) {
      throw new NullPointerException("overrides");
    }
    for (Map.Entry<String, Boolean> entry : overrides.entrySet()) {
      if (entry.getValue() == null) {
        throw new IllegalArgumentException(
            "Feature override must be boolean: " + entry.getKey());
      }
      setEnabled(entry.getKey(), entry.getValue().booleanValue());
    }
  }

  public static FeatureRegistry from(ModState state) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    return new FeatureRegistry(state.getFeatureOverrides());
  }

  public boolean isEnabled(Feature feature) {
    if (feature == null) {
      throw new NullPointerException("feature");
    }
    Boolean override = this.overrides.get(feature.getId());
    return override == null ? feature.isEnabledByDefault() : override.booleanValue();
  }

  public boolean isEnabled(String featureId) {
    ModState.requireIdentifier(featureId, "featureId");
    Boolean override = this.overrides.get(featureId);
    return override != null && override.booleanValue();
  }

  public void setEnabled(Feature feature, boolean enabled) {
    if (feature == null) {
      throw new NullPointerException("feature");
    }
    setEnabled(feature.getId(), enabled);
  }

  public void setEnabled(String featureId, boolean enabled) {
    ModState.requireIdentifier(featureId, "featureId");
    this.overrides.put(featureId, Boolean.valueOf(enabled));
  }

  public void clearOverride(Feature feature) {
    if (feature == null) {
      throw new NullPointerException("feature");
    }
    this.overrides.remove(feature.getId());
  }

  public Map<String, Boolean> snapshot() {
    return Collections.unmodifiableMap(
        new LinkedHashMap<String, Boolean>(this.overrides));
  }

  public ModState applyTo(ModState state) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    return state.withFeatureOverrides(this.overrides);
  }
}
