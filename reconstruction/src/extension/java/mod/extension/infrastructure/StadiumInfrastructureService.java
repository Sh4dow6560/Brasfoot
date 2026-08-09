package mod.extension.infrastructure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;

public final class StadiumInfrastructureService {
  public static final String MODULE_ID = "stadiumInfrastructure";
  private static final int MAX_HISTORY = 36;

  public InfrastructureResult inspect(
      ModState state, InfrastructureSnapshot snapshot) {
    require(state, snapshot);
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> stored = copyObject(profiles.get(snapshot.getProfileKey()));
    InfrastructureProfile profile = readProfile(stored);
    boolean changed = false;
    if (profile == null) {
      profile = initialProfile(snapshot);
      stored.remove("activeProject");
      changed = true;
    }

    InfrastructureProject project = readProject(stored.get("activeProject"));
    if (stored.containsKey("activeProject") && !validProject(project, profile)) {
      stored.remove("activeProject");
      project = null;
      changed = true;
    }

    int maintenance = calculateMaintenance(profile, snapshot.getStadiumCapacity());
    if (maintenance != profile.getMonthlyMaintenance()) {
      profile = profile.withMaintenance(maintenance);
      changed = true;
    }
    if (!changed) {
      return result(
          state,
          InfrastructureStatus.READY,
          snapshot,
          profile,
          project,
          null,
          0,
          0,
          false,
          false);
    }

    writeProfile(stored, profile);
    ModState updated = updateState(state, module, profiles, snapshot, stored);
    return result(
        updated,
        InfrastructureStatus.READY,
        snapshot,
        profile,
        project,
        null,
        0,
        0,
        false,
        true);
  }

  public InfrastructureResult processMonthly(
      ModState state, InfrastructureSnapshot snapshot) {
    InfrastructureResult inspected = inspect(state, snapshot);
    ModState currentState = inspected.getState();
    InfrastructureProfile profile = inspected.getProfile();
    if (profile.getLastProcessedPeriod() >= snapshot.getPeriod()) {
      return result(
          currentState,
          InfrastructureStatus.ALREADY_PROCESSED,
          snapshot,
          profile,
          inspected.getActiveProject(),
          null,
          0,
          0,
          false,
          false);
    }

    Map<String, Object> module = copyObject(currentState.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> stored = copyObject(profiles.get(snapshot.getProfileKey()));
    InfrastructureProject project = readProject(stored.get("activeProject"));
    FacilityType completedFacility = null;
    if (project != null && project.getCompletionPeriod() <= snapshot.getPeriod()) {
      completedFacility = project.getFacilityType();
      profile = profile.withFacilityLevel(
          completedFacility,
          project.getTargetLevel(),
          profile.getMonthlyMaintenance());
      stored.remove("activeProject");
      project = null;
    }

    int maintenance = calculateMaintenance(profile, snapshot.getStadiumCapacity());
    profile = profile.withMaintenance(maintenance);
    int baselineMatches = profile.getBaselineMatches();
    if (profile.getBaselineSeason() != snapshot.getSeasonNumber()
        || baselineMatches > snapshot.getMatchCount()) {
      baselineMatches = 0;
    }
    int matches = Math.max(0, snapshot.getMatchCount() - baselineMatches);
    int homeMatches = (matches + 1) / 2;
    int wear = homeMatches * Math.max(2, 6 - profile.getPitchLevel());
    boolean paid = snapshot.getCashBalance() >= maintenance;
    int recovery = paid ? 2 + profile.getPitchLevel() * 2 : -10;
    int completionBonus = completedFacility == FacilityType.PITCH ? 15 : 0;
    int quality = clamp(
        profile.getPitchQuality() - wear + recovery + completionBonus,
        0,
        100);
    profile = profile.afterMonthlyProcessing(
        snapshot.getPeriod(),
        snapshot.getSeasonNumber(),
        snapshot.getMatchCount(),
        quality,
        maintenance,
        paid);

    writeProfile(stored, profile);
    appendHistory(
        stored,
        snapshot.getPeriod(),
        paid ? "maintenance-paid" : "maintenance-missed",
        maintenance,
        quality,
        completedFacility);
    ModState updated = updateState(currentState, module, profiles, snapshot, stored);
    InfrastructureStatus status;
    if (!paid) {
      status = InfrastructureStatus.MAINTENANCE_MISSED;
    } else if (completedFacility != null) {
      status = InfrastructureStatus.UPGRADE_COMPLETED;
    } else {
      status = InfrastructureStatus.MONTHLY_PROCESSED;
    }
    return result(
        updated,
        status,
        snapshot,
        profile,
        project,
        completedFacility,
        paid ? maintenance : 0,
        homeMatches,
        paid,
        true);
  }

  public InfrastructureUpgradeOffer quoteUpgrade(
      ModState state,
      InfrastructureSnapshot snapshot,
      FacilityType facilityType) {
    require(state, snapshot);
    if (facilityType == null) {
      throw new NullPointerException("facilityType");
    }
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> stored = copyObject(profiles.get(snapshot.getProfileKey()));
    InfrastructureProfile profile = readProfile(stored);
    if (profile == null) {
      profile = initialProfile(snapshot);
    }
    InfrastructureProject project = readProject(stored.get("activeProject"));
    if (validProject(project, profile)) {
      throw new IllegalStateException("A facility project is already active");
    }
    int currentLevel = profile.getLevel(facilityType);
    if (currentLevel >= 5) {
      throw new IllegalStateException("Facility is already at the maximum level");
    }
    int targetLevel = currentLevel + 1;
    int duration = facilityType.durationMonths(targetLevel);
    int cost = upgradeCost(facilityType, targetLevel);
    return new InfrastructureUpgradeOffer(
        facilityType,
        currentLevel,
        targetLevel,
        cost,
        duration,
        addMonths(snapshot.getPeriod(), duration));
  }

  public InfrastructureResult startUpgrade(
      ModState state,
      InfrastructureSnapshot snapshot,
      FacilityType facilityType) {
    InfrastructureResult inspected = inspect(state, snapshot);
    InfrastructureUpgradeOffer offer = quoteUpgrade(
        inspected.getState(), snapshot, facilityType);
    if (snapshot.getCashBalance() < offer.getCost()) {
      throw new IllegalStateException("Club does not have enough cash for this project");
    }

    InfrastructureProject project = new InfrastructureProject(
        facilityType,
        offer.getTargetLevel(),
        snapshot.getPeriod(),
        offer.getCompletionPeriod(),
        offer.getCost());
    InfrastructureProfile profile = inspected.getProfile().withInvestment(offer.getCost());
    Map<String, Object> module = copyObject(inspected.getState().getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> stored = copyObject(profiles.get(snapshot.getProfileKey()));
    writeProfile(stored, profile);
    stored.put("activeProject", writeProject(project));
    appendHistory(
        stored,
        snapshot.getPeriod(),
        "upgrade-started",
        offer.getCost(),
        profile.getPitchQuality(),
        facilityType);
    ModState updated = updateState(
        inspected.getState(), module, profiles, snapshot, stored);
    return result(
        updated,
        InfrastructureStatus.UPGRADE_STARTED,
        snapshot,
        profile,
        project,
        null,
        offer.getCost(),
        0,
        false,
        true);
  }

  private InfrastructureProfile initialProfile(InfrastructureSnapshot snapshot) {
    int reputation = snapshot.getClubReputation();
    int pitch = clamp(1 + (reputation + 1) / 2, 1, 5);
    int training = clamp(
        1 + reputation / 2 + (snapshot.getDivision() == 0 ? 1 : 0), 1, 5);
    int medical = clamp(1 + (reputation + 1) / 3, 1, 5);
    int youth = clamp(1 + (reputation + 2) / 3, 1, 5);
    int commercial = clamp(
        1 + snapshot.getStadiumCapacity() / 30_000 + reputation / 4, 1, 5);
    int quality = initialPitchQuality(snapshot.getLegacyPitchCondition());
    InfrastructureProfile profile = new InfrastructureProfile(
        pitch,
        training,
        medical,
        youth,
        commercial,
        quality,
        0,
        -1,
        snapshot.getSeasonNumber(),
        snapshot.getMatchCount(),
        0L,
        0L,
        0);
    return profile.withMaintenance(
        calculateMaintenance(profile, snapshot.getStadiumCapacity()));
  }

  private int initialPitchQuality(int legacyCondition) {
    if (legacyCondition == 0) {
      return 92;
    }
    if (legacyCondition == 1) {
      return 76;
    }
    if (legacyCondition == 2) {
      return 58;
    }
    return 38;
  }

  private int calculateMaintenance(
      InfrastructureProfile profile, int stadiumCapacity) {
    long amount = Math.max(10_000, stadiumCapacity);
    for (FacilityType type : FacilityType.values()) {
      amount += (long)type.getMaintenancePerLevel() * profile.getLevel(type);
    }
    long rounded = ((amount + 500L) / 1_000L) * 1_000L;
    return (int)Math.min(1_000_000_000L, rounded);
  }

  private int upgradeCost(FacilityType type, int targetLevel) {
    long amount = (long)type.getBaseUpgradeCost() * targetLevel * targetLevel;
    long rounded = ((amount + 50_000L) / 100_000L) * 100_000L;
    return (int)Math.min(1_000_000_000L, rounded);
  }

  private InfrastructureProfile readProfile(Map<String, Object> source) {
    if (source.isEmpty()) {
      return null;
    }
    try {
      InfrastructureProfile profile = new InfrastructureProfile(
          integer(source.get("pitchLevel"), -1),
          integer(source.get("trainingLevel"), -1),
          integer(source.get("medicalLevel"), -1),
          integer(source.get("youthLevel"), -1),
          integer(source.get("commercialLevel"), -1),
          integer(source.get("pitchQuality"), -1),
          integer(source.get("monthlyMaintenance"), -1),
          integer(source.get("lastProcessedPeriod"), -2),
          integer(source.get("baselineSeason"), -1),
          integer(source.get("baselineMatches"), -1),
          longValue(source.get("totalInvested"), -1L),
          longValue(source.get("totalMaintenancePaid"), -1L),
          integer(source.get("maintenanceFailures"), -1));
      return profile.getLastProcessedPeriod() == -1
              || validPeriod(profile.getLastProcessedPeriod())
          ? profile : null;
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }

  private void writeProfile(
      Map<String, Object> target, InfrastructureProfile profile) {
    target.put("pitchLevel", Long.valueOf(profile.getPitchLevel()));
    target.put("trainingLevel", Long.valueOf(profile.getTrainingLevel()));
    target.put("medicalLevel", Long.valueOf(profile.getMedicalLevel()));
    target.put("youthLevel", Long.valueOf(profile.getYouthLevel()));
    target.put("commercialLevel", Long.valueOf(profile.getCommercialLevel()));
    target.put("pitchQuality", Long.valueOf(profile.getPitchQuality()));
    target.put("monthlyMaintenance", Long.valueOf(profile.getMonthlyMaintenance()));
    target.put("lastProcessedPeriod", Long.valueOf(profile.getLastProcessedPeriod()));
    target.put("baselineSeason", Long.valueOf(profile.getBaselineSeason()));
    target.put("baselineMatches", Long.valueOf(profile.getBaselineMatches()));
    target.put("totalInvested", Long.valueOf(profile.getTotalInvested()));
    target.put(
        "totalMaintenancePaid", Long.valueOf(profile.getTotalMaintenancePaid()));
    target.put("maintenanceFailures", Long.valueOf(profile.getMaintenanceFailures()));
  }

  private InfrastructureProject readProject(Object value) {
    if (value == null) {
      return null;
    }
    Map<String, Object> source = copyObject(value);
    try {
      FacilityType type = FacilityType.fromId(string(source.get("facilityType")));
      int start = integer(source.get("startPeriod"), -1);
      int completion = integer(source.get("completionPeriod"), -1);
      if (!validPeriod(start) || !validPeriod(completion)) {
        return null;
      }
      return new InfrastructureProject(
          type,
          integer(source.get("targetLevel"), -1),
          start,
          completion,
          integer(source.get("cost"), -1));
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }

  private Map<String, Object> writeProject(InfrastructureProject project) {
    Map<String, Object> target = new LinkedHashMap<String, Object>();
    target.put("facilityType", project.getFacilityType().getId());
    target.put("targetLevel", Long.valueOf(project.getTargetLevel()));
    target.put("startPeriod", Long.valueOf(project.getStartPeriod()));
    target.put("completionPeriod", Long.valueOf(project.getCompletionPeriod()));
    target.put("cost", Long.valueOf(project.getCost()));
    return target;
  }

  private boolean validProject(
      InfrastructureProject project, InfrastructureProfile profile) {
    return project != null
        && project.getTargetLevel() == profile.getLevel(project.getFacilityType()) + 1;
  }

  private ModState updateState(
      ModState state,
      Map<String, Object> module,
      Map<String, Object> profiles,
      InfrastructureSnapshot snapshot,
      Map<String, Object> profile) {
    profiles.put(snapshot.getProfileKey(), profile);
    module.put("profiles", profiles);
    module.put("latestProfile", snapshot.getProfileKey());
    module.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    return state.withModule(MODULE_ID, module);
  }

  private void appendHistory(
      Map<String, Object> profile,
      int period,
      String type,
      int amount,
      int pitchQuality,
      FacilityType facilityType) {
    List<Object> history = copyList(profile.get("history"));
    Map<String, Object> event = new LinkedHashMap<String, Object>();
    event.put("period", Long.valueOf(period));
    event.put("type", type);
    event.put("amount", Long.valueOf(amount));
    event.put("pitchQuality", Long.valueOf(pitchQuality));
    if (facilityType != null) {
      event.put("facilityType", facilityType.getId());
    }
    history.add(event);
    while (history.size() > MAX_HISTORY) {
      history.remove(0);
    }
    profile.put("history", history);
  }

  private InfrastructureResult result(
      ModState state,
      InfrastructureStatus status,
      InfrastructureSnapshot snapshot,
      InfrastructureProfile profile,
      InfrastructureProject project,
      FacilityType completedFacility,
      int expenseDue,
      int homeMatches,
      boolean maintenancePaid,
      boolean changed) {
    return new InfrastructureResult(
        state,
        status,
        snapshot,
        profile,
        project,
        completedFacility,
        expenseDue,
        homeMatches,
        maintenancePaid,
        changed);
  }

  private int addMonths(int period, int months) {
    if (!validPeriod(period) || months < 0) {
      throw new IllegalArgumentException("Invalid infrastructure period");
    }
    int year = period / 100;
    int month = period % 100;
    int absoluteMonth = year * 12 + month - 1 + months;
    return absoluteMonth / 12 * 100 + absoluteMonth % 12 + 1;
  }

  private boolean validPeriod(int period) {
    int year = period / 100;
    int month = period % 100;
    return year >= 2000 && year <= 2200 && month >= 1 && month <= 12;
  }

  private int clamp(int value, int minimum, int maximum) {
    return Math.max(minimum, Math.min(maximum, value));
  }

  private int integer(Object value, int fallback) {
    long number = longValue(value, fallback);
    return number < Integer.MIN_VALUE || number > Integer.MAX_VALUE
        ? fallback : (int)number;
  }

  private long longValue(Object value, long fallback) {
    return value instanceof Number ? ((Number)value).longValue() : fallback;
  }

  private String string(Object value) {
    if (!(value instanceof String) || ((String)value).length() == 0) {
      throw new IllegalArgumentException("Infrastructure value is missing");
    }
    return (String)value;
  }

  private Map<String, Object> copyObject(Object value) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    if (!(value instanceof Map)) {
      return result;
    }
    for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
      if (entry.getKey() instanceof String) {
        result.put((String)entry.getKey(), entry.getValue());
      }
    }
    return result;
  }

  private List<Object> copyList(Object value) {
    return value instanceof List
        ? new ArrayList<Object>((List<?>)value) : new ArrayList<Object>();
  }

  private void require(ModState state, InfrastructureSnapshot snapshot) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    if (snapshot == null) {
      throw new NullPointerException("snapshot");
    }
  }
}
