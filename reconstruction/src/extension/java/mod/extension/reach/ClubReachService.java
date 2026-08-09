package mod.extension.reach;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;

public final class ClubReachService {
  public static final String MODULE_ID = "clubReach";
  private static final int MAX_HISTORY = 36;
  private static final long MAX_AUDIENCE = 20_000_000_000L;

  public ClubReachResult evaluate(ModState state, ClubReachSnapshot snapshot) {
    require(state, snapshot);
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> profile = copyObject(profiles.get(snapshot.getProfileKey()));
    ClubReachMetrics previous = readMetrics(profile);
    if (previous == null) {
      return initialize(state, snapshot, module, profiles);
    }

    int lastPeriod = integer(profile.get("lastPeriod"), -1);
    if (lastPeriod >= snapshot.getPeriod()) {
      return repeatedResult(state, snapshot, previous, profile);
    }

    int storedSeason = integer(profile.get("seasonNumber"), -1);
    int baselineMatches = Math.max(0, integer(profile.get("baselineMatches"), 0));
    int baselineWins = Math.max(0, integer(profile.get("baselineWins"), 0));
    int baselineLosses = Math.max(0, integer(profile.get("baselineLosses"), 0));
    int baselineTitles = Math.max(0, integer(profile.get("baselineTitles"), 0));
    boolean countersReset = storedSeason != snapshot.getSeasonNumber()
        || baselineMatches > snapshot.getMatchCount()
        || baselineWins > snapshot.getWinCount()
        || baselineLosses > snapshot.getLossCount()
        || baselineTitles > snapshot.getTitleCount();
    if (countersReset) {
      baselineMatches = 0;
      baselineWins = 0;
      baselineLosses = 0;
      baselineTitles = 0;
    }

    int monthlyMatches = difference(snapshot.getMatchCount(), baselineMatches);
    int monthlyWins = Math.min(
        monthlyMatches, difference(snapshot.getWinCount(), baselineWins));
    int monthlyLosses = Math.min(
        monthlyMatches - monthlyWins,
        difference(snapshot.getLossCount(), baselineLosses));
    int monthlyTitles = difference(snapshot.getTitleCount(), baselineTitles);
    int winRate = monthlyMatches == 0 ? 45
        : (int)Math.round(monthlyWins * 100.0D / monthlyMatches);
    int lossRate = monthlyMatches == 0 ? 25
        : (int)Math.round(monthlyLosses * 100.0D / monthlyMatches);
    int performance = clamp(
        (winRate - 45) * 2
            - Math.max(0, lossRate - 35)
            + monthlyTitles * 35
            + (snapshot.getFanApproval() - 50) / 3,
        -100,
        160);

    int sentimentTarget = clamp(
        snapshot.getFanApproval() + performance / 6 + monthlyTitles * 5,
        0,
        100);
    int sentiment = blend(previous.getSentiment(), sentimentTarget);
    int engagementTarget = clamp(
        25 + sentiment / 2 + Math.max(0, performance) / 4 + monthlyTitles * 8,
        10,
        100);
    int engagement = blend(previous.getEngagement(), engagementTarget);

    int localBasisPoints = clamp(
        8
            + (sentiment - 50) * 2
            + (monthlyMatches == 0 ? 0 : (winRate - 45) * 2)
            + monthlyTitles * 180,
        -250,
        550);
    int internationalBasisPoints = clamp(
        snapshot.getClubReputation() * 10
            + performance * 3
            + monthlyTitles * 350,
        -200,
        1_000);
    int socialBasisPoints = clamp(
        120
            + engagement * 4
            + performance * 4
            + monthlyTitles * 500,
        -300,
        1_800);

    long local = grow(previous.getLocalSupporters(), localBasisPoints, 500L);
    long international = grow(
        previous.getInternationalSupporters(), internationalBasisPoints, 0L);
    long social = grow(previous.getSocialFollowers(), socialBasisPoints, 100L);
    int membershipBasisPoints = clamp(
        100 + sentiment * 3 + engagement + snapshot.getClubReputation() * 15,
        200,
        700);
    long memberTarget = scale(local, membershipBasisPoints, 10_000L);
    long members = approach(previous.getSupporterMembers(), memberTarget, 3L);

    int anchor = initialGlobalReputation(snapshot);
    int reputationChange = clamp(
        (anchor - previous.getGlobalReputation()) / 24
            + performance / 12
            + monthlyTitles * 25,
        -30,
        60);
    int globalReputation = clamp(
        previous.getGlobalReputation() + reputationChange, 0, 1000);
    ClubReachMetrics current = new ClubReachMetrics(
        local,
        international,
        social,
        members,
        globalReputation,
        engagement,
        sentiment);

    putMetrics(profile, current);
    profile.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    profile.put("seasonNumber", Long.valueOf(snapshot.getSeasonNumber()));
    profile.put("baselineMatches", Long.valueOf(snapshot.getMatchCount()));
    profile.put("baselineWins", Long.valueOf(snapshot.getWinCount()));
    profile.put("baselineLosses", Long.valueOf(snapshot.getLossCount()));
    profile.put("baselineTitles", Long.valueOf(snapshot.getTitleCount()));
    profile.put("lastPerformance", Long.valueOf(performance));
    putLastResult(
        profile,
        previous,
        current,
        monthlyMatches,
        monthlyWins,
        monthlyLosses,
        monthlyTitles);
    appendHistory(
        profile,
        snapshot,
        ClubReachStatus.UPDATED,
        previous,
        current,
        monthlyMatches,
        monthlyWins,
        monthlyLosses,
        monthlyTitles);
    ModState updated = updateState(state, module, profiles, snapshot, profile);
    return result(
        updated,
        ClubReachStatus.UPDATED,
        snapshot,
        previous,
        current,
        monthlyMatches,
        monthlyWins,
        monthlyLosses,
        monthlyTitles,
        true);
  }

  private ClubReachResult initialize(
      ModState state,
      ClubReachSnapshot snapshot,
      Map<String, Object> module,
      Map<String, Object> profiles) {
    long local = initialLocalSupporters(snapshot);
    long international = scale(
        local, Math.max(0, snapshot.getClubReputation() - 1) * 6L, 100L);
    long social = Math.max(
        100L,
        scale(
            boundedAdd(local, international),
            35L + snapshot.getClubReputation() * 8L,
            100L));
    int engagement = clamp(
        25 + snapshot.getFanApproval() / 2 + snapshot.getClubReputation() * 4,
        20,
        90);
    int sentiment = snapshot.getFanApproval();
    int membershipBasisPoints = clamp(
        100 + sentiment * 3 + snapshot.getClubReputation() * 20,
        200,
        650);
    long members = scale(local, membershipBasisPoints, 10_000L);
    ClubReachMetrics metrics = new ClubReachMetrics(
        local,
        international,
        social,
        members,
        initialGlobalReputation(snapshot),
        engagement,
        sentiment);

    Map<String, Object> profile = new LinkedHashMap<String, Object>();
    putMetrics(profile, metrics);
    profile.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    profile.put("seasonNumber", Long.valueOf(snapshot.getSeasonNumber()));
    profile.put("baselineMatches", Long.valueOf(snapshot.getMatchCount()));
    profile.put("baselineWins", Long.valueOf(snapshot.getWinCount()));
    profile.put("baselineLosses", Long.valueOf(snapshot.getLossCount()));
    profile.put("baselineTitles", Long.valueOf(snapshot.getTitleCount()));
    profile.put("lastPerformance", Long.valueOf(0L));
    putLastResult(profile, metrics, metrics, 0, 0, 0, 0);
    appendHistory(
        profile,
        snapshot,
        ClubReachStatus.INITIALIZED,
        metrics,
        metrics,
        0,
        0,
        0,
        0);
    ModState updated = updateState(state, module, profiles, snapshot, profile);
    return result(
        updated,
        ClubReachStatus.INITIALIZED,
        snapshot,
        metrics,
        metrics,
        0,
        0,
        0,
        0,
        true);
  }

  private long initialLocalSupporters(ClubReachSnapshot snapshot) {
    long[] reputationBase = new long[]{
        2_500L, 15_000L, 75_000L, 300_000L, 1_200_000L, 4_000_000L
    };
    int reputation = snapshot.getClubReputation();
    long base = reputationBase[Math.min(reputation, reputationBase.length - 1)];
    if (reputation >= reputationBase.length) {
      base = boundedMultiply(base, reputation - 3L);
    }
    long stadiumAudience = boundedMultiply(
        Math.max(1_000L, snapshot.getStadiumCapacity()), 4L + reputation * 2L);
    int divisionFactor;
    if (snapshot.getDivision() == 0) {
      divisionFactor = 120;
    } else if (snapshot.getDivision() == 1) {
      divisionFactor = 100;
    } else if (snapshot.getDivision() == 2) {
      divisionFactor = 80;
    } else if (snapshot.getDivision() == 3) {
      divisionFactor = 65;
    } else {
      divisionFactor = 50;
    }
    return clampAudience(scale(Math.max(base, stadiumAudience), divisionFactor, 100L));
  }

  private int initialGlobalReputation(ClubReachSnapshot snapshot) {
    int divisionBonus;
    if (snapshot.getDivision() == 0) {
      divisionBonus = 100;
    } else if (snapshot.getDivision() == 1) {
      divisionBonus = 70;
    } else if (snapshot.getDivision() == 2) {
      divisionBonus = 40;
    } else if (snapshot.getDivision() == 3) {
      divisionBonus = 20;
    } else {
      divisionBonus = 0;
    }
    return clamp(snapshot.getClubReputation() * 140 + divisionBonus, 0, 1000);
  }

  private ClubReachMetrics readMetrics(Map<String, Object> profile) {
    if (profile.isEmpty()) {
      return null;
    }
    try {
      long local = longValue(profile.get("localSupporters"), -1L);
      long international = longValue(profile.get("internationalSupporters"), -1L);
      long social = longValue(profile.get("socialFollowers"), -1L);
      long members = longValue(profile.get("supporterMembers"), -1L);
      int reputation = integer(profile.get("globalReputation"), -1);
      int engagement = integer(profile.get("engagement"), -1);
      int sentiment = integer(profile.get("sentiment"), -1);
      if (local > MAX_AUDIENCE || international > MAX_AUDIENCE
          || social > MAX_AUDIENCE || members > MAX_AUDIENCE) {
        return null;
      }
      return new ClubReachMetrics(
          local, international, social, members, reputation, engagement, sentiment);
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }

  private void putMetrics(Map<String, Object> profile, ClubReachMetrics metrics) {
    profile.put("localSupporters", Long.valueOf(metrics.getLocalSupporters()));
    profile.put(
        "internationalSupporters", Long.valueOf(metrics.getInternationalSupporters()));
    profile.put("socialFollowers", Long.valueOf(metrics.getSocialFollowers()));
    profile.put("supporterMembers", Long.valueOf(metrics.getSupporterMembers()));
    profile.put("globalReputation", Long.valueOf(metrics.getGlobalReputation()));
    profile.put("engagement", Long.valueOf(metrics.getEngagement()));
    profile.put("sentiment", Long.valueOf(metrics.getSentiment()));
    profile.put("reachLevel", metrics.getLevel().name());
  }

  private void appendHistory(
      Map<String, Object> profile,
      ClubReachSnapshot snapshot,
      ClubReachStatus status,
      ClubReachMetrics previous,
      ClubReachMetrics current,
      int matches,
      int wins,
      int losses,
      int titles) {
    List<Object> history = copyList(profile.get("history"));
    Map<String, Object> event = new LinkedHashMap<String, Object>();
    event.put("period", Long.valueOf(snapshot.getPeriod()));
    event.put("status", status.name());
    event.put("matches", Long.valueOf(matches));
    event.put("wins", Long.valueOf(wins));
    event.put("losses", Long.valueOf(losses));
    event.put("titles", Long.valueOf(titles));
    event.put("localSupporters", Long.valueOf(current.getLocalSupporters()));
    event.put(
        "localDelta",
        Long.valueOf(current.getLocalSupporters() - previous.getLocalSupporters()));
    event.put("internationalSupporters", Long.valueOf(current.getInternationalSupporters()));
    event.put(
        "internationalDelta",
        Long.valueOf(
            current.getInternationalSupporters() - previous.getInternationalSupporters()));
    event.put("socialFollowers", Long.valueOf(current.getSocialFollowers()));
    event.put(
        "socialDelta",
        Long.valueOf(current.getSocialFollowers() - previous.getSocialFollowers()));
    event.put("supporterMembers", Long.valueOf(current.getSupporterMembers()));
    event.put(
        "memberDelta",
        Long.valueOf(current.getSupporterMembers() - previous.getSupporterMembers()));
    event.put("globalReputation", Long.valueOf(current.getGlobalReputation()));
    event.put("reachLevel", current.getLevel().name());
    event.put("engagement", Long.valueOf(current.getEngagement()));
    event.put("sentiment", Long.valueOf(current.getSentiment()));
    history.add(event);
    while (history.size() > MAX_HISTORY) {
      history.remove(0);
    }
    profile.put("history", history);
  }

  private ModState updateState(
      ModState state,
      Map<String, Object> module,
      Map<String, Object> profiles,
      ClubReachSnapshot snapshot,
      Map<String, Object> profile) {
    profiles.put(snapshot.getProfileKey(), profile);
    module.put("profiles", profiles);
    module.put("latestProfile", snapshot.getProfileKey());
    module.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    return state.withModule(MODULE_ID, module);
  }

  private ClubReachResult result(
      ModState state,
      ClubReachStatus status,
      ClubReachSnapshot snapshot,
      ClubReachMetrics previous,
      ClubReachMetrics current,
      int matches,
      int wins,
      int losses,
      int titles,
      boolean changed) {
    return new ClubReachResult(
        state,
        status,
        snapshot,
        current,
        current.getLocalSupporters() - previous.getLocalSupporters(),
        current.getInternationalSupporters() - previous.getInternationalSupporters(),
        current.getSocialFollowers() - previous.getSocialFollowers(),
        current.getSupporterMembers() - previous.getSupporterMembers(),
        current.getGlobalReputation() - previous.getGlobalReputation(),
        matches,
        wins,
        losses,
        titles,
        changed);
  }

  private ClubReachResult repeatedResult(
      ModState state,
      ClubReachSnapshot snapshot,
      ClubReachMetrics metrics,
      Map<String, Object> profile) {
    return new ClubReachResult(
        state,
        ClubReachStatus.ALREADY_PROCESSED,
        snapshot,
        metrics,
        audienceDelta(profile.get("lastLocalDelta")),
        audienceDelta(profile.get("lastInternationalDelta")),
        audienceDelta(profile.get("lastSocialDelta")),
        audienceDelta(profile.get("lastMemberDelta")),
        clamp(integer(profile.get("lastGlobalReputationDelta"), 0), -1000, 1000),
        Math.max(0, integer(profile.get("lastMonthlyMatches"), 0)),
        Math.max(0, integer(profile.get("lastMonthlyWins"), 0)),
        Math.max(0, integer(profile.get("lastMonthlyLosses"), 0)),
        Math.max(0, integer(profile.get("lastMonthlyTitles"), 0)),
        false);
  }

  private void putLastResult(
      Map<String, Object> profile,
      ClubReachMetrics previous,
      ClubReachMetrics current,
      int matches,
      int wins,
      int losses,
      int titles) {
    profile.put(
        "lastLocalDelta",
        Long.valueOf(current.getLocalSupporters() - previous.getLocalSupporters()));
    profile.put(
        "lastInternationalDelta",
        Long.valueOf(
            current.getInternationalSupporters() - previous.getInternationalSupporters()));
    profile.put(
        "lastSocialDelta",
        Long.valueOf(current.getSocialFollowers() - previous.getSocialFollowers()));
    profile.put(
        "lastMemberDelta",
        Long.valueOf(current.getSupporterMembers() - previous.getSupporterMembers()));
    profile.put(
        "lastGlobalReputationDelta",
        Long.valueOf(current.getGlobalReputation() - previous.getGlobalReputation()));
    profile.put("lastMonthlyMatches", Long.valueOf(matches));
    profile.put("lastMonthlyWins", Long.valueOf(wins));
    profile.put("lastMonthlyLosses", Long.valueOf(losses));
    profile.put("lastMonthlyTitles", Long.valueOf(titles));
  }

  private long audienceDelta(Object value) {
    long delta = longValue(value, 0L);
    return Math.max(-MAX_AUDIENCE, Math.min(MAX_AUDIENCE, delta));
  }

  private long grow(long current, int basisPoints, long minimum) {
    long delta = scale(current, Math.abs((long)basisPoints), 10_000L);
    if (basisPoints > 0 && delta == 0L) {
      delta = 1L;
    } else if (basisPoints < 0) {
      delta = delta == 0L ? -1L : -delta;
    }
    return Math.max(minimum, clampAudience(boundedAdd(current, delta)));
  }

  private long approach(long current, long target, long divisor) {
    if (current == target) {
      return current;
    }
    long difference = target - current;
    long change = difference / divisor;
    if (change == 0L) {
      change = difference > 0L ? 1L : -1L;
    }
    return clampAudience(boundedAdd(current, change));
  }

  private int blend(int current, int target) {
    return clamp((current * 2 + target + 1) / 3, 0, 100);
  }

  private int difference(int current, int baseline) {
    return Math.max(0, current - baseline);
  }

  private long scale(long value, long numerator, long denominator) {
    if (value <= 0L || numerator <= 0L) {
      return 0L;
    }
    long whole = boundedMultiply(value / denominator, numerator);
    long remainder = value % denominator;
    long fraction = remainder * numerator / denominator;
    return clampAudience(boundedAdd(whole, fraction));
  }

  private long boundedAdd(long left, long right) {
    if (right > 0L && left > MAX_AUDIENCE - right) {
      return MAX_AUDIENCE;
    }
    if (right < 0L && left < -right) {
      return 0L;
    }
    return left + right;
  }

  private long boundedMultiply(long left, long right) {
    if (left <= 0L || right <= 0L) {
      return 0L;
    }
    if (left > MAX_AUDIENCE / right) {
      return MAX_AUDIENCE;
    }
    return left * right;
  }

  private long clampAudience(long value) {
    return Math.max(0L, Math.min(MAX_AUDIENCE, value));
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

  private void require(ModState state, ClubReachSnapshot snapshot) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    if (snapshot == null) {
      throw new NullPointerException("snapshot");
    }
  }
}
