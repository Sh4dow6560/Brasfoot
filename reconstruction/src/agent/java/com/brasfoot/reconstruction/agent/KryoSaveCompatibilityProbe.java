package com.brasfoot.reconstruction.agent;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class KryoSaveCompatibilityProbe {
  private KryoSaveCompatibilityProbe() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      throw new IllegalArgumentException(
          "Usage: KryoSaveCompatibilityProbe <hybrid-jar> <reference-save> <class>...");
    }
    String[] targets = new String[args.length - 2];
    System.arraycopy(args, 2, targets, 0, targets.length);
    byte[] original = Files.readAllBytes(Paths.get(args[1]));
    URL hybrid = new java.io.File(args[0]).toURI().toURL();
    try (URLClassLoader loader = new URLClassLoader(
        new URL[]{hybrid}, KryoSaveCompatibilityProbe.class.getClassLoader())) {
      Object[] roots = read(original, loader);
      CalendarSummary calendar = validateCalendar(roots[0]);
      String matchEventApi = validateMatchEventBehavior(loader);
      String matchStateApi = validateMatchStateBehavior(loader);
      String matchEngineApi = validateMatchEngineBehavior(loader, roots[0]);
      String playerClubApi = validatePlayerAndClubBehavior(loader, roots[0]);
      String stadiumExpansion = validateStadiumExpansion(loader);
      MatchEventSummary matchEvents = new MatchEventSummary();
      MatchStateSummary matches = new MatchStateSummary();
      Map<String, Integer> counts = countTargets(roots, targets, matchEvents, matches);
      matchEvents.validate();
      matches.validate(matchEvents.count());
      for (String target : targets) {
        System.out.println("COUNT " + target + " " + counts.get(target));
      }
      byte[] roundTrip = write(roots, loader);
      Object[] restored = read(roundTrip, loader);
      CalendarSummary restoredCalendar = validateCalendar(restored[0]);
      if (!calendar.equals(restoredCalendar)) {
        throw new IllegalStateException("Kryo round-trip changed calendar state: "
            + calendar + " -> " + restoredCalendar);
      }
      MatchEventSummary restoredMatchEvents = new MatchEventSummary();
      MatchStateSummary restoredMatches = new MatchStateSummary();
      Map<String, Integer> restoredCounts = countTargets(
          restored, targets, restoredMatchEvents, restoredMatches);
      if (!counts.equals(restoredCounts)) {
        throw new IllegalStateException("Kryo round-trip changed recovered model counts");
      }
      if (!matchEvents.equals(restoredMatchEvents)) {
        throw new IllegalStateException("Kryo round-trip changed match events: "
            + matchEvents + " -> " + restoredMatchEvents);
      }
      if (!matches.equals(restoredMatches)) {
        throw new IllegalStateException("Kryo round-trip changed match state: "
            + matches + " -> " + restoredMatches);
      }
      System.out.println("ROOT " + roots[0].getClass().getName()
          + " AUX " + roots[1].getClass().getName());
      System.out.println("CALENDAR " + calendar.toLogLine());
      System.out.println("MATCH_EVENTS " + matchEvents.toLogLine());
      System.out.println("MATCH_EVENT_API " + matchEventApi);
      System.out.println("MATCH_STATE " + matches.toLogLine());
      System.out.println("MATCH_STATE_API " + matchStateApi);
      System.out.println("MATCH_ENGINE_API " + matchEngineApi);
      System.out.println("PLAYER_CLUB_API " + playerClubApi);
      System.out.println("STADIUM_EXPANSION " + stadiumExpansion);
      System.out.println("ROUNDTRIP originalBytes=" + original.length
          + " outputBytes=" + roundTrip.length
          + " byteIdentical=" + sha256(original).equals(sha256(roundTrip)));
    }
  }

  private static String validateMatchEventBehavior(ClassLoader loader) throws Exception {
    Class<?> eventClass = loader.loadClass("best.A");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> playerClass = loader.loadClass("best.F");
    Object event = eventClass.getDeclaredConstructor(Integer.TYPE).newInstance(1);
    Object club = clubClass.getDeclaredConstructor().newInstance();
    Object primaryPlayer = playerClass.getDeclaredConstructor().newInstance();
    Object secondaryPlayer = playerClass.getDeclaredConstructor().newInstance();

    eventClass.getDeclaredMethod("k", clubClass).invoke(event, club);
    eventClass.getDeclaredMethod("f", playerClass).invoke(event, primaryPlayer);
    eventClass.getDeclaredMethod("g", playerClass).invoke(event, secondaryPlayer);
    eventClass.getDeclaredMethod("a", Integer.TYPE).invoke(event, 3);
    eventClass.getDeclaredMethod("R", Integer.TYPE).invoke(event, 5);
    eventClass.getDeclaredMethod("S", Integer.TYPE).invoke(event, 37);
    eventClass.getDeclaredMethod("T", Integer.TYPE).invoke(event, 2);
    eventClass.getDeclaredMethod("p", Boolean.TYPE).invoke(event, true);
    eventClass.getDeclaredMethod("q", Boolean.TYPE).invoke(event, true);

    assertSame(club, eventClass.getDeclaredMethod("cu").invoke(event), "event club");
    assertSame(primaryPlayer, eventClass.getDeclaredMethod("eo").invoke(event),
        "event primary player");
    assertSame(secondaryPlayer, eventClass.getDeclaredMethod("ep").invoke(event),
        "event secondary player");
    assertInteger(eventClass, event, "b", 3);
    assertInteger(eventClass, event, "el", 5);
    assertInteger(eventClass, event, "em", 37);
    assertInteger(eventClass, event, "en", 2);
    assertInteger(eventClass, event, "et", 1);
    assertBoolean(eventClass, event, "isDone", true);
    assertBoolean(eventClass, event, "eu", true);
    String timeLabel = (String)eventClass.getDeclaredMethod("eq").invoke(event);
    if (!timeLabel.startsWith("37'") || !timeLabel.contains("2")) {
      throw new IllegalStateException("Match event produced an invalid time label: " + timeLabel);
    }
    String displayHtml = (String)eventClass.getDeclaredMethod("er").invoke(event);
    if (!displayHtml.startsWith("<html>") || !displayHtml.contains("37'")) {
      throw new IllegalStateException("Match event produced invalid display HTML: " + displayHtml);
    }
    if (eventClass.getDeclaredMethod("es").invoke(event) == null) {
      throw new IllegalStateException("Match event did not resolve its icon");
    }

    Object restored = roundTripObject(event, loader);
    assertInteger(eventClass, restored, "b", 3);
    assertInteger(eventClass, restored, "el", 5);
    assertInteger(eventClass, restored, "em", 37);
    assertInteger(eventClass, restored, "en", 2);
    assertInteger(eventClass, restored, "et", 1);
    assertBoolean(eventClass, restored, "isDone", true);
    assertBoolean(eventClass, restored, "eu", true);
    return "type=3 subtype=5 minute=37 period=2 teamSide=1 icon=true roundTrip=true";
  }

  private static String validateMatchStateBehavior(ClassLoader loader) throws Exception {
    Class<?> matchClass = loader.loadClass("best.I");
    Class<?> eventClass = loader.loadClass("best.A");
    Class<?> clubClass = loader.loadClass("best.ah");
    Object homeClub = clubClass.getDeclaredConstructor().newInstance();
    Object awayClub = clubClass.getDeclaredConstructor().newInstance();
    Object match = matchClass.getDeclaredConstructor().newInstance();
    ArrayList<Object> events = new ArrayList<Object>();
    events.add(createMatchEvent(eventClass, clubClass, homeClub, 1));
    events.add(createMatchEvent(eventClass, clubClass, awayClub, 1));
    events.add(createMatchEvent(eventClass, clubClass, homeClub, 1));
    events.add(createMatchEvent(eventClass, clubClass, homeClub, 2));

    setField(match, "fz", homeClub);
    setField(match, "fA", awayClub);
    setField(match, "fy", 42);
    setField(match, "fN", events);
    setField(match, "dH", loader.loadClass("best.v").getDeclaredConstructor().newInstance());
    setField(match, "fW", new int[]{57, 43});
    setField(match, "fY", new int[]{12, 8});
    setField(match, "fZ", new int[]{7, 3});
    setField(match, "ga", new int[]{5, 5});
    setField(match, "gb", new int[]{18, 15});
    setField(match, "gc", new int[]{21, 27});
    setField(match, "gd", new int[]{9, 11});
    setField(match, "go", loader.loadClass("c.b").getDeclaredConstructor().newInstance());

    assertSame(homeClub, matchClass.getDeclaredMethod("hc").invoke(match), "home club");
    assertSame(awayClub, matchClass.getDeclaredMethod("hd").invoke(match), "away club");
    assertMatchListAccessor(matchClass, match, "hl", "fF");
    assertMatchListAccessor(matchClass, match, "hm", "fG");
    assertMatchListAccessor(matchClass, match, "hn", "fH");
    assertMatchListAccessor(matchClass, match, "ho", "fI");
    assertMatchListAccessor(matchClass, match, "hp", "fJ");
    assertMatchListAccessor(matchClass, match, "hq", "fK");
    assertSame(events, matchClass.getDeclaredMethod("hE").invoke(match), "match events");
    assertSame(readField(match, "fW"), matchClass.getDeclaredMethod("hz").invoke(match),
        "possession percentages");
    assertSame(readField(match, "fY"), matchClass.getDeclaredMethod("hA").invoke(match),
        "shots");
    assertSame(readField(match, "fZ"), matchClass.getDeclaredMethod("hZ").invoke(match),
        "shots on target");
    assertSame(readField(match, "ga"), matchClass.getDeclaredMethod("ia").invoke(match),
        "shots off target");
    assertSame(readField(match, "gb"), matchClass.getDeclaredMethod("hB").invoke(match),
        "tackles");
    assertSame(readField(match, "gc"), matchClass.getDeclaredMethod("hC").invoke(match),
        "misplaced passes");
    assertSame(readField(match, "gd"), matchClass.getDeclaredMethod("hD").invoke(match),
        "fouls");
    assertSame(readField(match, "go"), matchClass.getDeclaredMethod("hW").invoke(match),
        "match engine");
    assertInteger(matchClass, match, "hM", 42);
    matchClass.getDeclaredMethod("hF").invoke(match);
    assertInteger(matchClass, match, "hu", 2);
    assertInteger(matchClass, match, "hw", 1);
    matchClass.getDeclaredMethod("hv").invoke(match);
    matchClass.getDeclaredMethod("hx").invoke(match);
    assertInteger(matchClass, match, "hu", 3);
    assertInteger(matchClass, match, "hw", 2);
    matchClass.getDeclaredMethod("hF").invoke(match);

    Object restored = roundTripObject(match, loader);
    assertInteger(matchClass, restored, "hM", 42);
    assertInteger(matchClass, restored, "hu", 2);
    assertInteger(matchClass, restored, "hw", 1);
    assertIntArray((int[])readField(restored, "fW"), new int[]{57, 43},
        "possession percentages");
    assertIntArray((int[])readField(restored, "fY"), new int[]{12, 8}, "shots");
    assertIntArray((int[])readField(restored, "fZ"), new int[]{7, 3}, "shots on target");
    assertIntArray((int[])readField(restored, "ga"), new int[]{5, 5}, "shots off target");
    assertIntArray((int[])readField(restored, "gb"), new int[]{18, 15}, "tackles");
    assertIntArray((int[])readField(restored, "gc"), new int[]{21, 27},
        "misplaced passes");
    assertIntArray((int[])readField(restored, "gd"), new int[]{9, 11}, "fouls");
    Object restoredEvents = matchClass.getDeclaredMethod("hE").invoke(restored);
    if (!(restoredEvents instanceof List) || ((List<?>)restoredEvents).size() != 4) {
      throw new IllegalStateException("Match event list changed in Kryo round-trip");
    }
    if (readField(restored, "go") != null) {
      throw new IllegalStateException("Transient match engine was serialized");
    }
    if (matchClass.getDeclaredMethod("hW").invoke(restored) != null) {
      throw new IllegalStateException("Match engine accessor returned a transient value");
    }
    matchClass.getDeclaredMethod("hF").invoke(restored);
    assertInteger(matchClass, restored, "hu", 2);
    assertInteger(matchClass, restored, "hw", 1);
    return "scheduleIndex=42 score=2x1 events=4 stats=true transientEngine=true "
        + "roundTrip=true";
  }

  private static String validateMatchEngineBehavior(ClassLoader loader, Object career)
      throws Exception {
    Class<?> engineClass = loader.loadClass("c.b");
    Class<?> matchClass = loader.loadClass("best.I");
    Class<?> eventClass = loader.loadClass("best.A");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> playerClass = loader.loadClass("best.F");
    loader.loadClass("best.M").getDeclaredConstructor(Boolean.TYPE).newInstance(true);
    Object engine = engineClass.getDeclaredConstructor().newInstance();
    Object match = matchClass.getDeclaredConstructor().newInstance();
    Object homeClub = clubClass.getDeclaredConstructor().newInstance();
    Object awayClub = clubClass.getDeclaredConstructor().newInstance();
    Object attacker = playerClass.getDeclaredConstructor().newInstance();
    Object defender = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("as", Integer.TYPE).invoke(attacker, 19);
    playerClass.getDeclaredMethod("as", Integer.TYPE).invoke(defender, 3);
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(attacker, 4);
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(defender, 2);
    ArrayList<Object> homePlayers = new ArrayList<Object>();
    ArrayList<Object> awayPlayers = new ArrayList<Object>();
    homePlayers.add(attacker);
    awayPlayers.add(defender);

    setField(match, "fz", homeClub);
    setField(match, "fA", awayClub);
    setField(match, "fJ", homePlayers);
    setField(match, "fK", awayPlayers);
    setField(match, "fx", loader.loadClass("f.a").getDeclaredConstructor().newInstance());
    setField(engine, "zz", match);
    setField(engine, "TA", Array.newInstance(clubClass, 2));
    Object clubs = readField(engine, "TA");
    Array.set(clubs, 0, homeClub);
    Array.set(clubs, 1, awayClub);
    setField(engine, "TB", 0);
    setField(engine, "TC", 0);
    setField(engine, "TD", false);
    setField(engine, "TE", attacker);
    setField(engine, "TG", new int[]{2, 3});
    setField(engine, "TM", new int[]{4, 5});
    setField(engine, "TN", new int[]{6, 7});
    setField(engine, "TO", new int[]{8, 9});
    setField(engine, "TP", new int[]{10, 11});
    setStaticField(loader.loadClass("c.a"), "SR", career);

    for (int index = 0; index < 32; index++) {
      int selected = ((Integer)engineClass.getDeclaredMethod("vN").invoke(engine)).intValue();
      if (selected < 0 || selected > 1) {
        throw new IllegalStateException("Match engine selected invalid team index " + selected);
      }
    }
    int opposing = ((Integer)invokePrivate(engineClass, engine, "vQ")).intValue();
    if (opposing != 1) {
      throw new IllegalStateException("Match engine returned invalid opposing team");
    }
    invokePrivate(engineClass, engine, "vP");
    assertFieldInteger(engine, "TB", 1);
    opposing = ((Integer)invokePrivate(engineClass, engine, "vQ")).intValue();
    if (opposing != 0) {
      throw new IllegalStateException("Match engine did not switch active team");
    }
    setField(engine, "TB", 0);

    assertSame(readField(engine, "zA"), engineClass.getDeclaredMethod("vX").invoke(engine),
        "engine goal counts");
    assertSame(readField(engine, "TG"), engineClass.getDeclaredMethod("vY").invoke(engine),
        "engine shot counts");
    assertSame(readField(engine, "TM"), engineClass.getDeclaredMethod("we").invoke(engine),
        "engine attacking advances");
    assertSame(readField(engine, "TN"), engineClass.getDeclaredMethod("wf").invoke(engine),
        "engine midfield advances");
    assertSame(readField(engine, "TO"), engineClass.getDeclaredMethod("wg").invoke(engine),
        "engine midfield tackles");
    assertSame(readField(engine, "TP"), engineClass.getDeclaredMethod("wh").invoke(engine),
        "engine defensive tackles");

    double playerStrength = ((Double)engineClass.getDeclaredMethod("B", playerClass)
        .invoke(engine, attacker)).doubleValue();
    if (playerStrength <= 0.0) {
      throw new IllegalStateException("Match engine produced non-positive player strength");
    }
    assertClose(((Double)invokePrivateWithArgument(
        engineClass, engine, "ez", Integer.TYPE, 0)).doubleValue(), 0.01,
        "midfield strength");
    double attackingStrength = ((Double)invokePrivateWithArgument(
        engineClass, engine, "eA", Integer.TYPE, 0)).doubleValue();
    if (attackingStrength <= 0.0) {
      throw new IllegalStateException("Match engine produced non-positive attacking strength");
    }
    assertClose(((Double)invokePrivateWithArgument(
        engineClass, engine, "eB", Integer.TYPE, 1)).doubleValue(), 0.1,
        "goalkeeper fallback strength");
    double selectedAttackerStrength = ((Double)invokePrivateWithArgument(
        engineClass, engine, "eC", Integer.TYPE, 0)).doubleValue();
    if (selectedAttackerStrength <= 0.0 || readField(engine, "TE") == null) {
      throw new IllegalStateException("Match engine did not select an attacker");
    }
    int defenders = ((Integer)invokePrivateWithArgument(
        engineClass, engine, "eD", Integer.TYPE, 1)).intValue();
    if (defenders != 1) {
      throw new IllegalStateException("Match engine counted " + defenders + " defenders");
    }
    assertClose(((Double)invokePrivateWithArgument(
        engineClass, engine, "eE", Integer.TYPE, 1)).doubleValue(), 0.01,
        "defensive strength");
    invokePrivateWithArgument(engineClass, engine, "eF", Integer.TYPE, 0);
    invokePrivateWithArgument(engineClass, engine, "eF", Integer.TYPE, 1);
    int[] possessionPercentages = (int[])matchClass.getDeclaredMethod("hz").invoke(match);
    if (possessionPercentages[0] + possessionPercentages[1] != 100) {
      throw new IllegalStateException("Match engine possession does not total 100 percent");
    }
    Object assistProvider = engineClass.getDeclaredMethod("C", playerClass)
        .invoke(engine, attacker);
    if (assistProvider != null && assistProvider != attacker) {
      throw new IllegalStateException("Match engine selected an unknown assist provider");
    }

    Object goal = eventClass.getDeclaredConstructor().newInstance();
    eventClass.getDeclaredMethod("k", clubClass).invoke(goal, homeClub);
    engineClass.getDeclaredMethod("a", eventClass, playerClass).invoke(engine, goal, attacker);
    assertInteger(eventClass, goal, "b", 1);
    if (eventClass.getDeclaredMethod("eo").invoke(goal) == null) {
      throw new IllegalStateException("Goal event has no primary player");
    }
    assertInteger(matchClass, match, "hu", 1);
    assertInteger(matchClass, match, "hw", 0);
    assertIntArray((int[])engineClass.getDeclaredMethod("vX").invoke(engine),
        new int[]{1, 0}, "engine goal counts");
    int fallbackPosition = ((Integer)engineClass.getDeclaredMethod("vW").invoke(engine)).intValue();
    boolean knownPosition = false;
    for (int candidate : (int[])readField(engine, "TY")) {
      knownPosition |= candidate == fallbackPosition;
    }
    if (!knownPosition) {
      throw new IllegalStateException("Match engine selected invalid fallback position");
    }
    return "activeSwitch=true randomTeamBounds=true score=1x0 goalCounts=1/0 "
        + "phaseCounters=true strengths=true possession=100";
  }

  private static Object invokePrivate(
      Class<?> owner, Object value, String method, Class<?>... parameterTypes) throws Exception {
    java.lang.reflect.Method declared = owner.getDeclaredMethod(method, parameterTypes);
    declared.setAccessible(true);
    return declared.invoke(value);
  }

  private static Object invokePrivateWithArgument(
      Class<?> owner, Object value, String method, Class<?> parameterType, Object argument)
      throws Exception {
    java.lang.reflect.Method declared = owner.getDeclaredMethod(method, parameterType);
    declared.setAccessible(true);
    return declared.invoke(value, argument);
  }

  private static String validatePlayerAndClubBehavior(ClassLoader loader, Object career)
      throws Exception {
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> clubClass = loader.loadClass("best.ah");
    Object player = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 72);
    playerClass.getDeclaredMethod("as", Integer.TYPE).invoke(player, 19);
    playerClass.getDeclaredMethod("h", Boolean.class).invoke(player, Boolean.TRUE);
    playerClass.getDeclaredMethod("aI", Integer.TYPE).invoke(player, 61);
    playerClass.getDeclaredMethod("aJ", Integer.TYPE).invoke(player, 62);
    playerClass.getDeclaredMethod("aK", Integer.TYPE).invoke(player, 63);
    playerClass.getDeclaredMethod("aL", Integer.TYPE).invoke(player, 64);
    playerClass.getDeclaredMethod("aM", Integer.TYPE).invoke(player, 65);
    playerClass.getDeclaredMethod("aN", Integer.TYPE).invoke(player, 66);
    playerClass.getDeclaredMethod("aO", Integer.TYPE).invoke(player, 67);
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, 4);

    assertInteger(playerClass, player, "fi", 72);
    assertInteger(playerClass, player, "fT", 19);
    assertBoolean(playerClass, player, "fC", true);
    assertInteger(playerClass, player, "gJ", 61);
    assertInteger(playerClass, player, "gK", 62);
    assertInteger(playerClass, player, "gL", 63);
    assertInteger(playerClass, player, "gM", 64);
    assertInteger(playerClass, player, "gN", 65);
    assertInteger(playerClass, player, "gO", 66);
    assertInteger(playerClass, player, "gP", 67);
    assertBoolean(playerClass, player, "gF", false);
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, 0);
    assertBoolean(playerClass, player, "gF", true);

    playerClass.getDeclaredMethod("h", Boolean.class).invoke(player, Boolean.FALSE);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 24);
    assertInteger(playerClass, player, "fp", 100);
    assertInteger(playerClass, player, "fU", 72);
    playerClass.getDeclaredMethod("fq").invoke(player);
    assertInteger(playerClass, player, "fp", 98);
    assertInteger(playerClass, player, "fU", 0);
    playerClass.getDeclaredMethod("fr").invoke(player);
    assertInteger(playerClass, player, "fp", 100);
    assertInteger(playerClass, player, "fU", 72);

    long currentTime = ((Calendar)career.getClass().getDeclaredMethod("bb")
        .invoke(career)).getTimeInMillis();
    long injuryEnd = currentTime + 2L * 86_400_000L;
    setField(player, "eI", injuryEnd);
    long returnedInjuryEnd = ((Long)playerClass.getDeclaredMethod("fo")
        .invoke(player)).longValue();
    if (returnedInjuryEnd != injuryEnd) {
      throw new IllegalStateException("Player injury end time changed");
    }
    assertBoolean(playerClass, player, "fP", true);
    setField(player, "eI", currentTime - 1L);
    assertBoolean(playerClass, player, "fP", false);

    setField(player, "eJ", currentTime + 10L * 86_400_000L);
    assertInteger(playerClass, player, "fR", 10);
    if ("contrato vencido".equals(playerClass.getDeclaredMethod("fQ").invoke(player))) {
      throw new IllegalStateException("Future player contract was reported as expired");
    }
    setField(player, "eJ", currentTime - 1L);
    assertInteger(playerClass, player, "fR", 0);
    if (!"contrato vencido".equals(playerClass.getDeclaredMethod("fQ").invoke(player))) {
      throw new IllegalStateException("Expired player contract was not reported");
    }

    Object club = clubClass.getDeclaredConstructor().newInstance();
    setField(club, "mU", 17);
    assertInteger(clubClass, club, "lk", 17);
    clubClass.getDeclaredMethod("k", Boolean.class).invoke(club, Boolean.TRUE);
    assertBoolean(clubClass, club, "jZ", true);
    playerClass.getDeclaredMethod("n", clubClass).invoke(player, club);
    assertSame(club, playerClass.getDeclaredMethod("fg").invoke(player),
        "player club");

    Class<?> coachClass = loader.loadClass("best.al");
    Object coach = coachClass.getDeclaredConstructor().newInstance();
    coachClass.getDeclaredMethod("n", clubClass).invoke(coach, club);
    coachClass.getDeclaredMethod("k", Boolean.class).invoke(coach, Boolean.TRUE);
    assertSame(club, coachClass.getDeclaredMethod("fg").invoke(coach), "coach club");
    assertBoolean(coachClass, coach, "jZ", true);

    Class<?> stadiumClass = loader.loadClass("best.v");
    Object stadium = stadiumClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("a", stadiumClass).invoke(club, stadium);
    assertSame(stadium, clubClass.getDeclaredMethod("ev").invoke(club), "club stadium");
    Class<?> matchClass = loader.loadClass("best.I");
    Object match = matchClass.getDeclaredConstructor().newInstance();
    setField(match, "dH", stadium);
    assertSame(stadium, matchClass.getDeclaredMethod("ev").invoke(match), "match stadium");

    Class<?> archivedClubStatsClass = loader.loadClass("components.ah");
    Object archivedClubStats = archivedClubStatsClass.getDeclaredConstructor().newInstance();
    setField(archivedClubStats, "mU", 17);
    assertInteger(archivedClubStatsClass, archivedClubStats, "lk", 17);
    Class<?> clubReferenceClass = loader.loadClass("best.an");
    Object clubReference = clubReferenceClass.getDeclaredConstructor().newInstance();
    setField(clubReference, "cg", club);
    assertSame(club, clubReferenceClass.getDeclaredMethod("fg").invoke(clubReference),
        "shared club reference");

    ArrayList<Object> seniorPlayers = new ArrayList<Object>();
    ArrayList<Object> youthPlayers = new ArrayList<Object>();
    ArrayList<Object> startingLineup = new ArrayList<Object>();
    ArrayList<Object> bench = new ArrayList<Object>();
    seniorPlayers.add(player);
    startingLineup.add(player);
    setField(club, "nd", seniorPlayers);
    setField(club, "ne", youthPlayers);
    setField(club, "nf", startingLineup);
    setField(club, "ng", bench);
    setField(club, "nv", true);
    assertSame(seniorPlayers, clubClass.getDeclaredMethod("kc").invoke(club),
        "club senior players");
    assertSame(youthPlayers, clubClass.getDeclaredMethod("ky").invoke(club),
        "club youth players");
    assertSame(startingLineup, clubClass.getDeclaredMethod("kY").invoke(club),
        "club starting lineup");
    assertSame(bench, clubClass.getDeclaredMethod("kZ").invoke(club), "club bench");
    assertBoolean(clubClass, club, "kf", true);
    if (clubClass.getDeclaredMethod("kL").invoke(club) == null) {
      throw new IllegalStateException("Club finances were not initialized");
    }
    if (clubClass.getDeclaredMethod("kX").invoke(club) != null) {
      throw new IllegalStateException("New club unexpectedly has a lineup preset");
    }
    return "overall=72 tacticalPosition=19 attributes=7 outOfPosition=true "
        + "energy=100 effectiveStrength=72 injury=true contractDays=10 "
        + "clubId=17 playerClub=true coachClub=true userControlled=true stadiums=2 "
        + "seniorPlayers=1 lineupReady=true finances=true";
  }

  private static Object createMatchEvent(
      Class<?> eventClass, Class<?> clubClass, Object club, int type) throws Exception {
    Object event = eventClass.getDeclaredConstructor().newInstance();
    eventClass.getDeclaredMethod("k", clubClass).invoke(event, club);
    eventClass.getDeclaredMethod("a", Integer.TYPE).invoke(event, type);
    return event;
  }

  private static void assertMatchListAccessor(
      Class<?> matchClass, Object match, String method, String field) throws Exception {
    assertSame(readField(match, field), matchClass.getDeclaredMethod(method).invoke(match),
        "match list " + field);
  }

  private static void assertFieldInteger(Object value, String field, int expected)
      throws Exception {
    int actual = readInt(value, field);
    if (actual != expected) {
      throw new IllegalStateException(field + " contained " + actual + " instead of " + expected);
    }
  }

  private static void assertClose(double actual, double expected, String description) {
    if (Math.abs(actual - expected) > 0.000_001) {
      throw new IllegalStateException(description + " was " + actual + " instead of " + expected);
    }
  }

  private static void assertSame(Object expected, Object actual, String description) {
    if (expected != actual) {
      throw new IllegalStateException(description + " accessor changed object identity");
    }
  }

  private static void assertInteger(
      Class<?> owner, Object value, String method, int expected) throws Exception {
    int actual = ((Integer)owner.getDeclaredMethod(method).invoke(value)).intValue();
    if (actual != expected) {
      throw new IllegalStateException(method + " returned " + actual + " instead of " + expected);
    }
  }

  private static void assertBoolean(
      Class<?> owner, Object value, String method, boolean expected) throws Exception {
    boolean actual = ((Boolean)owner.getDeclaredMethod(method).invoke(value)).booleanValue();
    if (actual != expected) {
      throw new IllegalStateException(method + " returned " + actual + " instead of " + expected);
    }
  }

  private static String validateStadiumExpansion(ClassLoader loader) throws Exception {
    Object stadium = loader.loadClass("best.v").getDeclaredConstructor().newInstance();
    setField(stadium, "dn", new int[]{100, 200, 300, 400});
    Object project = loader.loadClass("best.B").getDeclaredConstructor().newInstance();
    Calendar completionDate = Calendar.getInstance();
    completionDate.setTimeInMillis(1_700_000_000_000L);
    setField(project, "dH", stadium);
    setField(project, "dI", completionDate);
    setField(project, "dJ", new int[]{10, 20, 0, 40});

    Object restored = roundTripObject(project, loader);
    Object restoredStadium = readField(restored, "dH");
    restored.getClass().getDeclaredMethod("ex").invoke(restored);
    int[] capacities = (int[])readField(restoredStadium, "dn");
    int[] additions = (int[])readField(restored, "dJ");
    assertIntArray(capacities, new int[]{110, 220, 300, 440}, "expanded capacities");
    assertIntArray(additions, new int[]{0, 0, 0, 0}, "consumed additions");
    int[] appliedCapacities = capacities.clone();
    restored.getClass().getDeclaredMethod("ex").invoke(restored);
    assertIntArray((int[])readField(restoredStadium, "dn"), appliedCapacities,
        "idempotent capacities");
    Calendar restoredDate = (Calendar)readField(restored, "dI");
    if (restoredDate.getTimeInMillis() != completionDate.getTimeInMillis()) {
      throw new IllegalStateException("Stadium expansion completion date changed in Kryo");
    }
    return "totalBefore=1000 additions=70 totalAfter=1070 idempotent=true";
  }

  private static Object roundTripObject(Object value, ClassLoader loader) {
    Kryo writer = createKryo(loader);
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    Output output = new Output(buffer);
    try {
      writer.writeClassAndObject(output, value);
      output.flush();
    } finally {
      output.close();
    }
    Kryo reader = createKryo(loader);
    Input input = new Input(new ByteArrayInputStream(buffer.toByteArray()));
    try {
      return reader.readClassAndObject(input);
    } finally {
      input.close();
    }
  }

  private static void assertIntArray(int[] actual, int[] expected, String description) {
    if (actual.length != expected.length) {
      throw new IllegalStateException(description + " length changed");
    }
    for (int index = 0; index < actual.length; index++) {
      if (actual[index] != expected[index]) {
        throw new IllegalStateException(description + " differ at index " + index
            + ": " + actual[index] + " != " + expected[index]);
      }
    }
  }

  private static CalendarSummary validateCalendar(Object career) throws Exception {
    if (!"best.f".equals(career.getClass().getName())) {
      throw new IllegalStateException("Unexpected career root: " + career.getClass().getName());
    }
    int season = readInt(career, "ae");
    int firstSeasonYear = readInt(career, "rM");
    int currentIndex = readInt(career, "af");
    Object scheduleValue = readField(career, "as");
    if (!(scheduleValue instanceof List)) {
      throw new IllegalStateException("Career schedule is not a list");
    }
    List<?> days = (List<?>)scheduleValue;
    if (season < 1 || firstSeasonYear < 2000 || firstSeasonYear > 2100) {
      throw new IllegalStateException("Implausible career season: season=" + season
          + " firstYear=" + firstSeasonYear);
    }
    if (days.isEmpty() || currentIndex < 0 || currentIndex >= days.size()) {
      throw new IllegalStateException("Invalid current schedule index " + currentIndex
          + " for " + days.size() + " days");
    }

    long previousTime = Long.MIN_VALUE;
    long firstTime = Long.MIN_VALUE;
    long lastTime = Long.MIN_VALUE;
    long currentTime = Long.MIN_VALUE;
    int matchDays = 0;
    int matches = 0;
    for (int index = 0; index < days.size(); index++) {
      Object day = days.get(index);
      if (day == null || !"best.a".equals(day.getClass().getName())) {
        throw new IllegalStateException("Unexpected schedule day at index " + index);
      }
      Object dateValue = readField(day, "p");
      if (!(dateValue instanceof Calendar)) {
        throw new IllegalStateException("Schedule day has no Calendar at index " + index);
      }
      long time = ((Calendar)dateValue).getTimeInMillis();
      if (time < previousTime) {
        throw new IllegalStateException("Schedule is not chronological at index " + index);
      }
      if (index == 0) {
        firstTime = time;
      }
      if (index == currentIndex) {
        currentTime = time;
      }
      previousTime = time;
      lastTime = time;

      Object matchesValue = readField(day, "s");
      if (!(matchesValue instanceof List)) {
        throw new IllegalStateException("Schedule matches are not a list at index " + index);
      }
      int dayMatches = ((List<?>)matchesValue).size();
      if (dayMatches > 0) {
        matchDays++;
        matches += dayMatches;
      }
    }
    if (currentTime < firstTime || currentTime > lastTime || matches == 0) {
      throw new IllegalStateException("Calendar has invalid date bounds or no matches");
    }
    return new CalendarSummary(
        days.size(), currentIndex, matchDays, matches, season, firstSeasonYear,
        firstTime, currentTime, lastTime);
  }

  private static int readInt(Object owner, String name) throws Exception {
    return ((Integer)readField(owner, name)).intValue();
  }

  private static Object readField(Object owner, String name) throws Exception {
    Field field = owner.getClass().getDeclaredField(name);
    field.setAccessible(true);
    return field.get(owner);
  }

  private static void setField(Object owner, String name, Object value) throws Exception {
    Field field = owner.getClass().getDeclaredField(name);
    field.setAccessible(true);
    field.set(owner, value);
  }

  private static void setStaticField(Class<?> owner, String name, Object value) throws Exception {
    Field field = owner.getDeclaredField(name);
    field.setAccessible(true);
    field.set(null, value);
  }

  private static Object[] read(byte[] bytes, ClassLoader loader) {
    Kryo kryo = createKryo(loader);
    Input input = new Input(new ByteArrayInputStream(bytes));
    try {
      return new Object[]{kryo.readClassAndObject(input), kryo.readClassAndObject(input)};
    } finally {
      input.close();
    }
  }

  private static byte[] write(Object[] roots, ClassLoader loader) {
    Kryo kryo = createKryo(loader);
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    Output output = new Output(buffer);
    try {
      kryo.writeClassAndObject(output, roots[0]);
      kryo.writeClassAndObject(output, roots[1]);
      output.flush();
      return buffer.toByteArray();
    } finally {
      output.close();
    }
  }

  private static Kryo createKryo(ClassLoader loader) {
    Kryo kryo = new Kryo();
    kryo.setRegistrationRequired(false);
    kryo.setClassLoader(loader);
    return kryo;
  }

  private static Map<String, Integer> countTargets(
      Object[] roots,
      String[] targets,
      MatchEventSummary matchEvents,
      MatchStateSummary matches) throws Exception {
    Map<String, Integer> counts = new LinkedHashMap<String, Integer>();
    for (String target : targets) {
      counts.put(target, 0);
    }
    Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<Object, Boolean>());
    ArrayDeque<Object> pending = new ArrayDeque<Object>();
    for (Object root : roots) {
      if (root != null) {
        pending.add(root);
      }
    }

    while (!pending.isEmpty()) {
      Object value = pending.removeFirst();
      if (value == null || !visited.add(value)) {
        continue;
      }
      if (visited.size() > 1_000_000) {
        throw new IllegalStateException("Reference save graph exceeded safety limit");
      }
      Class<?> type = value.getClass();
      String name = type.getName();
      if (counts.containsKey(name)) {
        counts.put(name, counts.get(name) + 1);
      }
      if ("best.A".equals(name)) {
        matchEvents.accept(value);
      } else if ("best.I".equals(name)) {
        matches.accept(value);
      }
      if (isTerminal(type)) {
        continue;
      }
      if (type.isArray()) {
        if (!type.getComponentType().isPrimitive()) {
          int length = Array.getLength(value);
          for (int index = 0; index < length; index++) {
            add(pending, Array.get(value, index));
          }
        }
        continue;
      }
      if (value instanceof Iterable) {
        for (Object item : (Iterable<?>)value) {
          add(pending, item);
        }
        continue;
      }
      if (value instanceof Map) {
        for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
          add(pending, entry.getKey());
          add(pending, entry.getValue());
        }
        continue;
      }
      if (name.startsWith("java.") || name.startsWith("javax.")) {
        continue;
      }
      for (Class<?> current = type; current != null && current != Object.class;
           current = current.getSuperclass()) {
        for (Field field : current.getDeclaredFields()) {
          int modifiers = field.getModifiers();
          if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)
              || field.getType().isPrimitive()) {
            continue;
          }
          field.setAccessible(true);
          add(pending, field.get(value));
        }
      }
    }
    return counts;
  }

  private static boolean isTerminal(Class<?> type) {
    return type.isPrimitive()
        || type.isEnum()
        || Number.class.isAssignableFrom(type)
        || type == String.class
        || type == Boolean.class
        || type == Character.class
        || type == Class.class;
  }

  private static void add(ArrayDeque<Object> pending, Object value) {
    if (value != null) {
      pending.addLast(value);
    }
  }

  private static String sha256(byte[] bytes) throws Exception {
    byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
    StringBuilder text = new StringBuilder();
    for (byte value : digest) {
      text.append(String.format("%02X", value));
    }
    return text.toString();
  }

  private static final class CalendarSummary {
    private final int days;
    private final int currentIndex;
    private final int matchDays;
    private final int matches;
    private final int season;
    private final int firstSeasonYear;
    private final long firstTime;
    private final long currentTime;
    private final long lastTime;

    CalendarSummary(
        int days,
        int currentIndex,
        int matchDays,
        int matches,
        int season,
        int firstSeasonYear,
        long firstTime,
        long currentTime,
        long lastTime) {
      this.days = days;
      this.currentIndex = currentIndex;
      this.matchDays = matchDays;
      this.matches = matches;
      this.season = season;
      this.firstSeasonYear = firstSeasonYear;
      this.firstTime = firstTime;
      this.currentTime = currentTime;
      this.lastTime = lastTime;
    }

    String toLogLine() {
      return "days=" + days
          + " currentIndex=" + currentIndex
          + " matchDays=" + matchDays
          + " matches=" + matches
          + " season=" + season
          + " firstSeasonYear=" + firstSeasonYear
          + " firstTime=" + firstTime
          + " currentTime=" + currentTime
          + " lastTime=" + lastTime;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (!(other instanceof CalendarSummary)) {
        return false;
      }
      CalendarSummary value = (CalendarSummary)other;
      return days == value.days
          && currentIndex == value.currentIndex
          && matchDays == value.matchDays
          && matches == value.matches
          && season == value.season
          && firstSeasonYear == value.firstSeasonYear
          && firstTime == value.firstTime
          && currentTime == value.currentTime
          && lastTime == value.lastTime;
    }

    @Override
    public int hashCode() {
      int result = days;
      result = 31 * result + currentIndex;
      result = 31 * result + matchDays;
      result = 31 * result + matches;
      result = 31 * result + season;
      result = 31 * result + firstSeasonYear;
      result = 31 * result + (int)(firstTime ^ firstTime >>> 32);
      result = 31 * result + (int)(currentTime ^ currentTime >>> 32);
      return 31 * result + (int)(lastTime ^ lastTime >>> 32);
    }

    @Override
    public String toString() {
      return toLogLine();
    }
  }

  private static final class MatchStateSummary {
    private int count;
    private int withCompetitionStage;
    private int withCompetition;
    private int withStadium;
    private int minimumScheduleIndex = Integer.MAX_VALUE;
    private int maximumScheduleIndex = Integer.MIN_VALUE;
    private long totalGoals;
    private long totalEvents;

    void accept(Object match) throws Exception {
      count++;
      validateReference(readField(match, "fz"), "best.ah", "home club");
      validateReference(readField(match, "fA"), "best.ah", "away club");
      if (readField(match, "fw") != null) {
        withCompetitionStage++;
      }
      if (readField(match, "fx") != null) {
        withCompetition++;
      }
      Object stadium = readField(match, "dH");
      if (stadium != null) {
        validateReference(stadium, "best.v", "stadium");
        withStadium++;
      }
      int scheduleIndex = readInt(match, "fy");
      int homeGoals = readInt(match, "fB");
      int awayGoals = readInt(match, "fC");
      if (homeGoals < 0 || awayGoals < 0) {
        throw new IllegalStateException("Match has a negative score");
      }
      minimumScheduleIndex = Math.min(minimumScheduleIndex, scheduleIndex);
      maximumScheduleIndex = Math.max(maximumScheduleIndex, scheduleIndex);
      totalGoals += homeGoals + awayGoals;
      totalEvents += requireList(match, "fN").size();
      requireList(match, "fF");
      requireList(match, "fG");
      requireList(match, "fH");
      requireList(match, "fI");
      requireList(match, "fJ");
      requireList(match, "fK");
      requirePair(match, "fW");
      requirePair(match, "fY");
      requirePair(match, "fZ");
      requirePair(match, "ga");
      requirePair(match, "gb");
      requirePair(match, "gc");
      requirePair(match, "gd");
    }

    private void validateReference(Object value, String expectedClass, String description) {
      if (value == null || !expectedClass.equals(value.getClass().getName())) {
        throw new IllegalStateException("Match has invalid " + description);
      }
    }

    private List<?> requireList(Object match, String field) throws Exception {
      Object value = readField(match, field);
      if (!(value instanceof List)) {
        throw new IllegalStateException("Match field " + field + " is not a list");
      }
      return (List<?>)value;
    }

    private void requirePair(Object match, String field) throws Exception {
      Object value = readField(match, field);
      if (!(value instanceof int[]) || ((int[])value).length != 2) {
        throw new IllegalStateException("Match field " + field + " is not a two-team array");
      }
    }

    void validate(int expectedEvents) {
      if (count == 0 || minimumScheduleIndex < 0 || maximumScheduleIndex >= 1000
          || totalEvents != expectedEvents || totalGoals == 0) {
        throw new IllegalStateException("Reference save has invalid match state: " + this
            + " expectedEvents=" + expectedEvents);
      }
    }

    String toLogLine() {
      return "count=" + count
          + " scheduleIndex=" + minimumScheduleIndex + ".." + maximumScheduleIndex
          + " withCompetitionStage=" + withCompetitionStage
          + " withCompetition=" + withCompetition
          + " withStadium=" + withStadium
          + " goals=" + totalGoals
          + " events=" + totalEvents;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (!(other instanceof MatchStateSummary)) {
        return false;
      }
      MatchStateSummary value = (MatchStateSummary)other;
      return count == value.count
          && withCompetitionStage == value.withCompetitionStage
          && withCompetition == value.withCompetition
          && withStadium == value.withStadium
          && minimumScheduleIndex == value.minimumScheduleIndex
          && maximumScheduleIndex == value.maximumScheduleIndex
          && totalGoals == value.totalGoals
          && totalEvents == value.totalEvents;
    }

    @Override
    public int hashCode() {
      int result = count;
      result = 31 * result + withCompetitionStage;
      result = 31 * result + withCompetition;
      result = 31 * result + withStadium;
      result = 31 * result + minimumScheduleIndex;
      result = 31 * result + maximumScheduleIndex;
      result = 31 * result + (int)(totalGoals ^ totalGoals >>> 32);
      return 31 * result + (int)(totalEvents ^ totalEvents >>> 32);
    }

    @Override
    public String toString() {
      return toLogLine();
    }
  }

  private static final class MatchEventSummary {
    private final Map<Integer, Integer> types = new TreeMap<Integer, Integer>();
    private int count;
    private int withClub;
    private int withPrimaryPlayer;
    private int withSecondaryPlayer;
    private int done;
    private int confirmed;
    private int minimumMinute = Integer.MAX_VALUE;
    private int maximumMinute = Integer.MIN_VALUE;
    private int minimumPeriod = Integer.MAX_VALUE;
    private int maximumPeriod = Integer.MIN_VALUE;
    private int minimumTeamSide = Integer.MAX_VALUE;
    private int maximumTeamSide = Integer.MIN_VALUE;

    void accept(Object event) throws Exception {
      count++;
      int type = readInt(event, "w");
      types.put(type, types.containsKey(type) ? types.get(type) + 1 : 1);
      Object club = readField(event, "dy");
      Object primaryPlayer = readField(event, "dC");
      Object secondaryPlayer = readField(event, "dD");
      withClub += validateReference(club, "best.ah", "club");
      withPrimaryPlayer += validateReference(primaryPlayer, "best.F", "primary player");
      withSecondaryPlayer += validateReference(secondaryPlayer, "best.F", "secondary player");
      if (((Boolean)readField(event, "dE")).booleanValue()) {
        done++;
      }
      if (((Boolean)readField(event, "dG")).booleanValue()) {
        confirmed++;
      }
      int minute = readInt(event, "dA");
      int period = readInt(event, "dB");
      int teamSide = readInt(event, "dF");
      minimumMinute = Math.min(minimumMinute, minute);
      maximumMinute = Math.max(maximumMinute, minute);
      minimumPeriod = Math.min(minimumPeriod, period);
      maximumPeriod = Math.max(maximumPeriod, period);
      minimumTeamSide = Math.min(minimumTeamSide, teamSide);
      maximumTeamSide = Math.max(maximumTeamSide, teamSide);
    }

    private int validateReference(Object value, String expectedClass, String description) {
      if (value == null) {
        return 0;
      }
      if (!expectedClass.equals(value.getClass().getName())) {
        throw new IllegalStateException("Match event has unexpected " + description + ": "
            + value.getClass().getName());
      }
      return 1;
    }

    void validate() {
      if (count == 0 || types.isEmpty() || withClub == 0 || withPrimaryPlayer == 0) {
        throw new IllegalStateException("Reference save has no usable match events: " + this);
      }
    }

    int count() {
      return count;
    }

    String toLogLine() {
      return "count=" + count
          + " types=" + types
          + " withClub=" + withClub
          + " withPrimaryPlayer=" + withPrimaryPlayer
          + " withSecondaryPlayer=" + withSecondaryPlayer
          + " done=" + done
          + " confirmed=" + confirmed
          + " minute=" + minimumMinute + ".." + maximumMinute
          + " period=" + minimumPeriod + ".." + maximumPeriod
          + " teamSide=" + minimumTeamSide + ".." + maximumTeamSide;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (!(other instanceof MatchEventSummary)) {
        return false;
      }
      MatchEventSummary value = (MatchEventSummary)other;
      return count == value.count
          && withClub == value.withClub
          && withPrimaryPlayer == value.withPrimaryPlayer
          && withSecondaryPlayer == value.withSecondaryPlayer
          && done == value.done
          && confirmed == value.confirmed
          && minimumMinute == value.minimumMinute
          && maximumMinute == value.maximumMinute
          && minimumPeriod == value.minimumPeriod
          && maximumPeriod == value.maximumPeriod
          && minimumTeamSide == value.minimumTeamSide
          && maximumTeamSide == value.maximumTeamSide
          && types.equals(value.types);
    }

    @Override
    public int hashCode() {
      int result = types.hashCode();
      result = 31 * result + count;
      result = 31 * result + withClub;
      result = 31 * result + withPrimaryPlayer;
      result = 31 * result + withSecondaryPlayer;
      result = 31 * result + done;
      result = 31 * result + confirmed;
      result = 31 * result + minimumMinute;
      result = 31 * result + maximumMinute;
      result = 31 * result + minimumPeriod;
      result = 31 * result + maximumPeriod;
      result = 31 * result + minimumTeamSide;
      return 31 * result + maximumTeamSide;
    }

    @Override
    public String toString() {
      return toLogLine();
    }
  }
}
