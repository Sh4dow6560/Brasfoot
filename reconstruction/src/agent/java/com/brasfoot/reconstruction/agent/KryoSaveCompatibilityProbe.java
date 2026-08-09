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
      String substitutionApi = validateSubstitutionBehavior(loader);
      String matchEngineApi = validateMatchEngineBehavior(loader, roots[0]);
      String lineupApi = validateLineupBehavior(loader);
      String contractLoanApi = validateContractAndLoanBehavior(loader, roots[0]);
      String transferNegotiationApi = validateTransferNegotiationBehavior(loader);
      String aiSquadApi = validateAiSquadManagerBehavior(loader, roots[0]);
      String coachCareerApi = validateCoachCareerBehavior(loader, roots[0]);
      String playerSearchApi = validatePlayerSearchCriteriaBehavior(loader, roots[0]);
      String transferHistoryApi = validatePlayerTransferRecordBehavior(loader, roots[0]);
      String clubFinancesApi = validateClubFinancesBehavior(loader, roots[0]);
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
      System.out.println("SUBSTITUTION_API " + substitutionApi);
      System.out.println("MATCH_ENGINE_API " + matchEngineApi);
      System.out.println("LINEUP_API " + lineupApi);
      System.out.println("CONTRACT_LOAN_API " + contractLoanApi);
      System.out.println("TRANSFER_NEGOTIATION_API " + transferNegotiationApi);
      System.out.println("AI_SQUAD_API " + aiSquadApi);
      System.out.println("COACH_CAREER_API " + coachCareerApi);
      System.out.println("PLAYER_SEARCH_API " + playerSearchApi);
      System.out.println("TRANSFER_HISTORY_API " + transferHistoryApi);
      System.out.println("CLUB_FINANCES_API " + clubFinancesApi);
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

  private static String validateSubstitutionBehavior(ClassLoader loader) throws Exception {
    Class<?> matchClass = loader.loadClass("best.I");
    Class<?> eventClass = loader.loadClass("best.A");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> playerClass = loader.loadClass("best.F");
    Object match = matchClass.getDeclaredConstructor().newInstance();
    Object homeClub = clubClass.getDeclaredConstructor().newInstance();
    Object awayClub = clubClass.getDeclaredConstructor().newInstance();
    Object outgoing = playerClass.getDeclaredConstructor().newInstance();
    Object incoming = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("as", Integer.TYPE).invoke(outgoing, 19);
    playerClass.getDeclaredMethod("as", Integer.TYPE).invoke(incoming, -1);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(incoming, 24);

    ArrayList<Object> homePlayers = new ArrayList<Object>();
    ArrayList<Object> homeBench = new ArrayList<Object>();
    ArrayList<Object> homeSubstitutesUsed = new ArrayList<Object>();
    ArrayList<Object> awaySubstitutesUsed = new ArrayList<Object>();
    ArrayList<Object> events = new ArrayList<Object>();
    homePlayers.add(outgoing);
    homeBench.add(incoming);
    setField(match, "fz", homeClub);
    setField(match, "fA", awayClub);
    setField(match, "fJ", homePlayers);
    setField(match, "fH", homeBench);
    setField(match, "fL", homeSubstitutesUsed);
    setField(match, "fM", awaySubstitutesUsed);
    setField(match, "fN", events);
    setField(match, "fR", new int[]{5, 5});

    Object event = matchClass.getDeclaredMethod(
        "a", Integer.TYPE, playerClass, playerClass,
        Integer.TYPE, Integer.TYPE, Integer.TYPE)
        .invoke(match, 0, outgoing, incoming, 2, 63, -1);
    if (event == null || !eventClass.isInstance(event)) {
      throw new IllegalStateException("Match substitution did not create an event");
    }
    assertInteger(eventClass, event, "b", 6);
    assertSame(outgoing, eventClass.getDeclaredMethod("eo").invoke(event),
        "substituted player");
    assertSame(incoming, eventClass.getDeclaredMethod("ep").invoke(event),
        "replacement player");
    if (homePlayers.size() != 1 || homePlayers.get(0) != incoming
        || homeBench.contains(incoming) || !homeSubstitutesUsed.contains(incoming)) {
      throw new IllegalStateException("Match substitution did not update squad lists");
    }
    assertInteger(playerClass, incoming, "fT", 19);
    int remaining = ((Integer)matchClass.getDeclaredMethod("aR", Integer.TYPE)
        .invoke(match, 0)).intValue();
    if (remaining != 4) {
      throw new IllegalStateException("Home substitutions remaining was " + remaining);
    }
    assertSame(homeSubstitutesUsed, matchClass.getDeclaredMethod("ie").invoke(match),
        "home substitutes used");
    assertSame(awaySubstitutesUsed, matchClass.getDeclaredMethod("if").invoke(match),
        "away substitutes used");
    if (events.size() != 1 || events.get(0) != event) {
      throw new IllegalStateException("Substitution event was not attached to the match");
    }
    if (!((Boolean)invokePrivate(matchClass, match, "hj")).booleanValue()) {
      throw new IllegalStateException("New match was not tied");
    }
    setField(match, "fC", 2);
    java.lang.reflect.Method trailingBy = matchClass.getDeclaredMethod(
        "n", Integer.TYPE, Integer.TYPE);
    trailingBy.setAccessible(true);
    if (!((Boolean)trailingBy.invoke(match, 1, 1)).booleanValue()) {
      throw new IllegalStateException("Match did not detect the trailing home team");
    }
    matchClass.getDeclaredMethod("l", Integer.TYPE, Integer.TYPE).invoke(match, 1, 7);
    assertInteger(playerClass, incoming, "fp", 98);
    return "remaining=4 eventType=6 lists=true tacticalPosition=19 "
        + "scoreState=true energy=98";
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

  private static String validateLineupBehavior(ClassLoader loader) throws Exception {
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> matchClass = loader.loadClass("best.I");
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> constantsClass = loader.loadClass("best.aq");
    Object club = clubClass.getDeclaredConstructor().newInstance();
    Object match = matchClass.getDeclaredConstructor().newInstance();
    setField(club, "mU", 31);
    setField(match, "fz", club);

    int[][] requirements = (int[][])readStaticField(constantsClass, "sE");
    int[][] formations = (int[][])readStaticField(constantsClass, "sJ");
    int[] benchPositions = (int[])readStaticField(constantsClass, "sI");
    int formation = 4;
    ArrayList<Object> players = new ArrayList<Object>();
    int ordinal = 0;
    for (int tacticalPosition : formations[formation]) {
      players.add(createLineupPlayer(
          playerClass, clubClass, club, requirements[tacticalPosition], ordinal++));
    }
    for (int tacticalPosition : benchPositions) {
      players.add(createLineupPlayer(
          playerClass, clubClass, club, requirements[tacticalPosition], ordinal++));
    }
    setField(club, "nd", players);

    int[] tactics = new int[]{formation, 1, 2, 1};
    clubClass.getDeclaredMethod("k", int[].class).invoke(club, (Object)tactics);
    assertIntArray((int[])clubClass.getDeclaredMethod("kj").invoke(club), tactics,
        "club tactical settings");
    clubClass.getDeclaredMethod("I", Boolean.TYPE).invoke(club, false);
    clubClass.getDeclaredMethod(
        "a", clubClass, matchClass, Integer.TYPE, Integer.TYPE, Boolean.TYPE)
        .invoke(null, club, match, 1, formation, false);

    List<?> startingLineup = (List<?>)clubClass.getDeclaredMethod("kY").invoke(club);
    List<?> bench = (List<?>)clubClass.getDeclaredMethod("kZ").invoke(club);
    List<?> matchStartingLineup = (List<?>)matchClass.getDeclaredMethod("hl").invoke(match);
    List<?> playersOnField = (List<?>)matchClass.getDeclaredMethod("hp").invoke(match);
    List<?> matchBench = (List<?>)matchClass.getDeclaredMethod("hn").invoke(match);
    if (startingLineup.size() != 11 || bench.size() != 11
        || matchStartingLineup.size() != 11 || playersOnField.size() != 11
        || matchBench.size() != 11) {
      throw new IllegalStateException("AI lineup did not produce 11 starters and 11 substitutes");
    }
    if (!((Boolean)clubClass.getDeclaredMethod("kf").invoke(club)).booleanValue()) {
      throw new IllegalStateException("AI lineup did not mark the club as ready");
    }
    for (int index = 0; index < startingLineup.size(); index++) {
      int tacticalPosition = ((Integer)playerClass.getDeclaredMethod("fT")
          .invoke(startingLineup.get(index))).intValue();
      if (tacticalPosition != formations[formation][index]) {
        throw new IllegalStateException("Starter " + index + " received tactical position "
            + tacticalPosition + " instead of " + formations[formation][index]);
      }
    }

    clubClass.getDeclaredMethod("a", matchClass, clubClass, Integer.TYPE)
        .invoke(null, match, club, 1);
    int lineupStrength = ((Integer)matchClass.getDeclaredMethod("hr").invoke(match)).intValue();
    if (lineupStrength <= 0) {
      throw new IllegalStateException("AI lineup produced non-positive strength " + lineupStrength);
    }
    return "formation=4 starters=11 bench=11 tactics=4/1/2/1 strength=" + lineupStrength;
  }

  private static Object createLineupPlayer(
      Class<?> playerClass, Class<?> clubClass, Object club, int[] requirement, int ordinal)
      throws Exception {
    Object player = playerClass.getDeclaredConstructor().newInstance();
    int side = requirement[1] < 0 ? ordinal % 2 : requirement[1];
    int role = requirement[2] < 0 ? 0 : requirement[2];
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, requirement[0]);
    playerClass.getDeclaredMethod("setLado", Integer.TYPE).invoke(player, side);
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 90 - ordinal % 10);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 22 + ordinal % 8);
    playerClass.getDeclaredMethod("n", clubClass).invoke(player, club);
    setField(player, "ex", role);
    return player;
  }

  private static String validateContractAndLoanBehavior(ClassLoader loader, Object career)
      throws Exception {
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> loanClass = loader.loadClass("components.t");
    Object player = playerClass.getDeclaredConstructor().newInstance();
    Object originalClub = clubClass.getDeclaredConstructor().newInstance();
    Object borrowingClub = clubClass.getDeclaredConstructor().newInstance();
    setField(originalClub, "mU", 51);
    setField(borrowingClub, "mU", 52);
    playerClass.getDeclaredMethod("n", clubClass).invoke(player, originalClub);
    List<Object> originalPlayers = castList(
        clubClass.getDeclaredMethod("kc").invoke(originalClub));
    List<Object> borrowingPlayers = castList(
        clubClass.getDeclaredMethod("kc").invoke(borrowingClub));
    originalPlayers.add(player);

    List<Object> transferHistory = castList(career.getClass().getDeclaredMethod("bo").invoke(career));
    List<Object> loanRecords = castList(career.getClass().getDeclaredMethod("bt").invoke(career));
    int originalTransferCount = transferHistory.size();
    int originalLoanCount = loanRecords.size();
    long dayMillis = 86_400_000L;
    long currentTime = ((Calendar)career.getClass().getDeclaredMethod("bb")
        .invoke(career)).getTimeInMillis();
    try {
      playerClass.getDeclaredMethod("a", Long.TYPE, Boolean.TYPE)
          .invoke(player, 30L, true);
      long firstEnd = ((Long)readField(player, "eJ")).longValue();
      if (firstEnd != currentTime + 30L * dayMillis) {
        throw new IllegalStateException("Contract renewal did not start from the current date");
      }
      playerClass.getDeclaredMethod("a", Long.TYPE, Boolean.TYPE)
          .invoke(player, 15L, false);
      long extendedEnd = ((Long)readField(player, "eJ")).longValue();
      if (extendedEnd != firstEnd + 15L * dayMillis) {
        throw new IllegalStateException("Contract extension did not use the existing end date");
      }
      assertInteger(playerClass, player, "fR", 45);

      playerClass.getDeclaredMethod("q", clubClass).invoke(player, borrowingClub);
      assertSame(borrowingClub, playerClass.getDeclaredMethod("fg").invoke(player),
          "borrowing club");
      assertBoolean(playerClass, player, "gl", true);
      if (originalPlayers.contains(player) || !borrowingPlayers.contains(player)
          || loanRecords.size() != originalLoanCount + 1
          || transferHistory.size() != originalTransferCount + 1) {
        throw new IllegalStateException("Loan did not update club and career lists");
      }
      assertInteger(playerClass, player, "fR", 365);

      Object loan = loanRecords.get(loanRecords.size() - 1);
      if (!loanClass.isInstance(loan)) {
        throw new IllegalStateException("Loan record used unexpected class "
            + loan.getClass().getName());
      }
      assertSame(player, loanClass.getDeclaredMethod("x").invoke(loan), "loan player");
      assertSame(originalClub, loanClass.getDeclaredMethod("tP").invoke(loan),
          "loan original club");
      long loanEnd = ((Long)loanClass.getDeclaredMethod("tO").invoke(loan)).longValue();
      if (loanEnd != currentTime + 366L * dayMillis) {
        throw new IllegalStateException("Loan record received unexpected end date");
      }
      loanClass.getDeclaredMethod("au", Boolean.TYPE).invoke(loan, true);
      assertBoolean(loanClass, loan, "tQ", true);
      loanClass.getDeclaredMethod("au", Boolean.TYPE).invoke(loan, false);
      setField(loan, "Pm", currentTime - 1L);
      assertBoolean(loanClass, loan, "tM", true);

      boolean returned = ((Boolean)loanClass.getDeclaredMethod("tN").invoke(loan))
          .booleanValue();
      if (!returned) {
        throw new IllegalStateException("Expired loan did not return to the original club");
      }
      assertSame(originalClub, playerClass.getDeclaredMethod("fg").invoke(player),
          "returned player club");
      assertBoolean(playerClass, player, "gl", false);
      if (!originalPlayers.contains(player) || borrowingPlayers.contains(player)
          || transferHistory.size() != originalTransferCount + 2) {
        throw new IllegalStateException("Loan return did not restore club lists");
      }
      assertInteger(playerClass, player, "fR", 180);
      return "renewal=30+15 loanDays=365 returnDays=180 record=true lists=true";
    } finally {
      while (transferHistory.size() > originalTransferCount) {
        transferHistory.remove(transferHistory.size() - 1);
      }
      while (loanRecords.size() > originalLoanCount) {
        loanRecords.remove(loanRecords.size() - 1);
      }
    }
  }

  private static String validateTransferNegotiationBehavior(ClassLoader loader)
      throws Exception {
    Class<?> negotiationClass = loader.loadClass("best.l");
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> countryClass = loader.loadClass("best.ac");
    Object[] countries = (Object[])countryClass.getDeclaredMethod("values").invoke(null);
    if (countries.length != 224) {
      throw new IllegalStateException("Expected 224 countries, got " + countries.length);
    }
    for (int index = 0; index < countries.length; index++) {
      int id = ((Integer)countryClass.getDeclaredMethod("getId")
          .invoke(countries[index])).intValue();
      if (id != index) {
        throw new IllegalStateException(
            "Country ordinal " + index + " contains id " + id);
      }
    }
    Object player = playerClass.getDeclaredConstructor().newInstance();
    Object sourceClub = clubClass.getDeclaredConstructor().newInstance();
    Object destinationClub = clubClass.getDeclaredConstructor().newInstance();
    Object salaryClub = clubClass.getDeclaredConstructor().newInstance();

    setField(sourceClub, "mU", 61);
    setField(destinationClub, "mU", 62);
    setField(salaryClub, "mU", 63);
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(sourceClub, 2);
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(destinationClub, 2);
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(salaryClub, 29);
    clubClass.getDeclaredMethod("setReputacao", Integer.TYPE).invoke(sourceClub, 4);
    clubClass.getDeclaredMethod("setReputacao", Integer.TYPE).invoke(destinationClub, 4);
    clubClass.getDeclaredMethod("setReputacao", Integer.TYPE).invoke(salaryClub, 3);
    clubClass.getDeclaredMethod("setDivisao", Integer.TYPE).invoke(destinationClub, 1);
    clubClass.getDeclaredMethod("setDivisao", Integer.TYPE).invoke(salaryClub, 2);
    clubClass.getDeclaredMethod("e", Long.TYPE).invoke(destinationClub, 10_000L);
    clubClass.getDeclaredMethod("e", Long.TYPE).invoke(salaryClub, 10_000L);

    playerClass.getDeclaredMethod("n", clubClass).invoke(player, sourceClub);
    playerClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(player, 2);
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, 2);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 24);
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 50);
    playerClass.getDeclaredMethod("ae", Integer.TYPE).invoke(player, 100);
    playerClass.getDeclaredMethod("af", Integer.TYPE).invoke(player, 1_000);
    playerClass.getDeclaredMethod("ag", Integer.TYPE).invoke(player, 1_200);
    playerClass.getDeclaredMethod("g", Boolean.class).invoke(player, Boolean.TRUE);
    playerClass.getDeclaredMethod("c", Boolean.class).invoke(player, Boolean.TRUE);
    castList(clubClass.getDeclaredMethod("kc").invoke(sourceClub)).add(player);
    assertInteger(playerClass, player, "fj", 100);
    assertInteger(playerClass, player, "fk", 1_000);
    assertInteger(playerClass, player, "fl", 1_200);
    assertBoolean(playerClass, player, "ft", true);
    assertBoolean(playerClass, player, "fz", true);
    assertBoolean(playerClass, player, "ff", false);
    assertBoolean(playerClass, player, "gm", false);
    playerClass.getDeclaredMethod("a", Boolean.class).invoke(player, Boolean.TRUE);
    assertBoolean(playerClass, player, "ff", true);
    setField(player, "el", Boolean.TRUE);
    playerClass.getDeclaredMethod("a", Boolean.class).invoke(player, Boolean.FALSE);
    assertBoolean(playerClass, player, "ff", true);
    assertBoolean(playerClass, player, "gm", true);
    setField(player, "el", Boolean.FALSE);
    playerClass.getDeclaredMethod("a", Boolean.class).invoke(player, Boolean.FALSE);
    assertBoolean(playerClass, player, "ff", false);
    assertBoolean(playerClass, player, "gm", false);
    playerClass.getDeclaredMethod("fm").invoke(player);
    assertInteger(playerClass, player, "fl", 1_000);
    playerClass.getDeclaredMethod("ag", Integer.TYPE).invoke(player, 1_200);

    Object negotiation = negotiationClass.getDeclaredConstructor(
        playerClass, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Integer.TYPE)
        .newInstance(player, 1_250, false, false, 2);
    assertSame(player, readField(negotiation, "U"), "negotiation player");
    assertSame(sourceClub, readField(negotiation, "ck"), "negotiation source club");
    assertFieldInteger(negotiation, "ci", 1_250);
    assertFieldInteger(negotiation, "cs", 2);
    assertFieldInteger(negotiation, "cx", 32);
    if (negotiationClass.getDeclaredMethod("cK").invoke(negotiation) != null) {
      throw new IllegalStateException("New negotiation unexpectedly selected a destination");
    }
    assertInteger(negotiationClass, negotiation, "cL", 0);
    negotiationClass.getDeclaredMethod("g", clubClass).invoke(negotiation, destinationClub);
    negotiationClass.getDeclaredMethod("F", Integer.TYPE).invoke(negotiation, 1_250);
    assertSame(destinationClub, negotiationClass.getDeclaredMethod("cK").invoke(negotiation),
        "negotiation destination club");
    assertInteger(negotiationClass, negotiation, "cL", 1_250);

    int nullLoan = ((Integer)negotiationClass.getDeclaredMethod(
        "a", playerClass, clubClass).invoke(null, null, null)).intValue();
    int sameClubLoan = ((Integer)negotiationClass.getDeclaredMethod(
        "a", playerClass, clubClass).invoke(null, player, sourceClub)).intValue();
    if (nullLoan != 0 || sameClubLoan != 2) {
      throw new IllegalStateException("Loan validation returned unexpected status codes");
    }
    int sameClubTransfer = ((Integer)negotiationClass.getDeclaredMethod(
        "b", playerClass, clubClass).invoke(null, player, sourceClub)).intValue();
    if (sameClubTransfer != 2) {
      throw new IllegalStateException("Listed transfer did not reject the current club");
    }
    assertBoolean(negotiationClass, null, "cO", false);

    boolean compatible = ((Boolean)negotiationClass.getDeclaredMethod(
        "d", playerClass, clubClass).invoke(null, player, destinationClub)).booleanValue();
    int interest = ((Integer)negotiationClass.getDeclaredMethod(
        "c", playerClass, clubClass).invoke(null, player, destinationClub)).intValue();
    if (!compatible || interest != 0) {
      throw new IllegalStateException("Compatible destination was rejected");
    }
    int acceptedOffer = ((Integer)negotiationClass.getDeclaredMethod(
        "a", playerClass, clubClass, Integer.TYPE)
        .invoke(null, player, destinationClub, 3_000)).intValue();
    int counterOffer = ((Integer)negotiationClass.getDeclaredMethod(
        "a", playerClass, clubClass, Integer.TYPE)
        .invoke(null, player, destinationClub, 100)).intValue();
    if (acceptedOffer != 1 || counterOffer != 7) {
      throw new IllegalStateException("Transfer offer evaluation returned unexpected status");
    }
    assertInteger(negotiationClass, null, "cN", 2_500);

    int salaryRequest = ((Integer)negotiationClass.getDeclaredMethod(
        "a", playerClass, clubClass, Integer.TYPE)
        .invoke(null, player, salaryClub, 3_000)).intValue();
    if (salaryRequest != 6) {
      throw new IllegalStateException("Salary negotiation returned status " + salaryRequest);
    }
    assertInteger(negotiationClass, null, "cM", 200);
    negotiationClass.getDeclaredMethod("l", Boolean.TYPE).invoke(null, true);
    assertBoolean(negotiationClass, null, "cO", true);
    negotiationClass.getDeclaredMethod("l", Boolean.TYPE).invoke(null, false);

    return "countries=224 state=true loanCodes=0/2 listedCode=2 compatible=true "
        + "offer=accepted counterOffer=2500 salary=200 marketFields=true completedFlag=true";
  }

  private static String validateAiSquadManagerBehavior(ClassLoader loader, Object career)
      throws Exception {
    Class<?> managerClass = loader.loadClass("best.ag");
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> leagueStageClass = loader.loadClass("f.s");
    Class<?> persistenceClass = loader.loadClass("c.a");

    Object previousCareer = readStaticField(persistenceClass, "SR");
    Object countries = readField(career, "ao");
    Object clubs = readField(career, "aj");
    Object nationalTeams = readField(career, "ap");
    Object coaches = readField(career, "al");
    Object coachChanges = readField(career, "at");
    try {
      setStaticField(persistenceClass, "SR", career);
      setField(career, "ao", new ArrayList<Object>());
      setField(career, "aj", new ArrayList<Object>());
      setField(career, "ap", new ArrayList<Object>());
      setField(career, "al", new ArrayList<Object>());
      setField(career, "at", new ArrayList<Object>());
      managerClass.getDeclaredMethod("jO").invoke(null);
      managerClass.getDeclaredMethod("jQ").invoke(null);
    } finally {
      setField(career, "ao", countries);
      setField(career, "aj", clubs);
      setField(career, "ap", nationalTeams);
      setField(career, "al", coaches);
      setField(career, "at", coachChanges);
      setStaticField(persistenceClass, "SR", previousCareer);
    }

    Object balancedClub = clubClass.getDeclaredConstructor().newInstance();
    setField(balancedClub, "mU", 71);
    List<Object> balancedPlayers = castList(
        clubClass.getDeclaredMethod("kc").invoke(balancedClub));
    for (int index = 0; index < 2; index++) {
      balancedPlayers.add(createAiMarketPlayer(
          playerClass, clubClass, balancedClub, 0, false));
    }

    java.lang.reflect.Method processClub = managerClass.getDeclaredMethod(
        "a", clubClass, Integer.TYPE, Boolean.TYPE);
    processClub.setAccessible(true);
    processClub.invoke(null, balancedClub, 12, true);
    if (balancedPlayers.size() != 2) {
      throw new IllegalStateException("Balanced squad was changed by market maintenance");
    }
    for (Object player : balancedPlayers) {
      assertSame(balancedClub, playerClass.getDeclaredMethod("fg").invoke(player),
          "balanced player club");
    }

    Object loanOnlyClub = clubClass.getDeclaredConstructor().newInstance();
    setField(loanOnlyClub, "mU", 72);
    List<Object> loanPlayers = castList(
        clubClass.getDeclaredMethod("kc").invoke(loanOnlyClub));
    for (int index = 0; index < 5; index++) {
      loanPlayers.add(createAiMarketPlayer(
          playerClass, clubClass, loanOnlyClub, 0, true));
    }
    java.lang.reflect.Method transferSurplus = managerClass.getDeclaredMethod(
        "a", clubClass, Boolean.TYPE, Boolean.TYPE);
    transferSurplus.setAccessible(true);
    transferSurplus.invoke(null, loanOnlyClub, true, true);
    transferSurplus.invoke(null, loanOnlyClub, false, false);
    if (loanPlayers.size() != 5) {
      throw new IllegalStateException("Loan-only squad was changed by market maintenance");
    }
    for (Object player : loanPlayers) {
      assertSame(loanOnlyClub, playerClass.getDeclaredMethod("fg").invoke(player),
          "loan player club");
      assertBoolean(playerClass, player, "gl", true);
    }

    Object userClub = clubClass.getDeclaredConstructor().newInstance();
    setField(userClub, "mU", 73);
    clubClass.getDeclaredMethod("k", Boolean.class).invoke(userClub, Boolean.TRUE);
    List<Object> userPlayers = castList(clubClass.getDeclaredMethod("kc").invoke(userClub));
    for (int index = 0; index < 5; index++) {
      userPlayers.add(createAiMarketPlayer(
          playerClass, clubClass, userClub, 0, false));
    }
    Object leagueStage = leagueStageClass.getDeclaredConstructor().newInstance();
    List<Object> leagueClubs = castList(leagueStageClass.getDeclaredMethod("yK")
        .invoke(leagueStage));
    leagueClubs.add(userClub);
    leagueClubs.add(balancedClub);
    managerClass.getDeclaredMethod("b", leagueStageClass).invoke(null, leagueStage);
    if (userPlayers.size() != 5 || balancedPlayers.size() != 2) {
      throw new IllegalStateException("League maintenance changed a protected squad");
    }
    for (Object player : userPlayers) {
      assertSame(userClub, playerClass.getDeclaredMethod("fg").invoke(player),
          "user player club");
    }

    return "entryPoints=true balancedPlayers=2 loanProtected=5 userProtected=5";
  }

  private static String validateCoachCareerBehavior(ClassLoader loader, Object career)
      throws Exception {
    Class<?> coachClass = loader.loadClass("best.al");
    Class<?> seasonRecordClass = loader.loadClass("best.j");
    Class<?> changeRecordClass = loader.loadClass("best.u");
    Class<?> marketClass = loader.loadClass("best.ay");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> countryClass = loader.loadClass("best.Z");
    Class<?> matchClass = loader.loadClass("best.I");
    Class<?> eventClass = loader.loadClass("best.A");
    Class<?> persistenceClass = loader.loadClass("c.a");

    Object previousCareer = readStaticField(persistenceClass, "SR");
    try {
      setStaticField(persistenceClass, "SR", career);
      int season = readInt(career, "ae");
      Object club = findProbeClub(clubClass, castList(readField(career, "aj")));
      int clubId = ((Integer)clubClass.getDeclaredMethod("lk").invoke(club)).intValue();
      int countryId = ((Integer)clubClass.getDeclaredMethod("getPais").invoke(club)).intValue();
      int division = ((Integer)clubClass.getDeclaredMethod("getDivisao").invoke(club)).intValue();
      String clubName = (String)clubClass.getDeclaredMethod("getNome").invoke(club);

      Object coach = coachClass.getDeclaredConstructor().newInstance();
      coachClass.getDeclaredMethod("i", String.class).invoke(coach, "Probe Coach");
      assertString("Probe Coach", coachClass.getDeclaredMethod("dS").invoke(coach),
          "coach name");
      coachClass.getDeclaredMethod("k", Boolean.class).invoke(coach, Boolean.TRUE);
      assertBoolean(coachClass, coach, "jZ", true);
      coachClass.getDeclaredMethod("n", clubClass).invoke(coach, club);
      assertSame(club, coachClass.getDeclaredMethod("fg").invoke(coach), "coach club");
      coachClass.getDeclaredMethod("cg", Integer.TYPE).invoke(coach, countryId);
      assertInteger(coachClass, coach, "lE", countryId);
      coachClass.getDeclaredMethod("B", clubClass).invoke(coach, club);
      assertSame(club, coachClass.getDeclaredMethod("lF").invoke(coach),
          "previous coach club");
      coachClass.getDeclaredMethod("ch", Integer.TYPE).invoke(coach, division - 1);
      assertInteger(coachClass, coach, "lG", division - 1);
      coachClass.getDeclaredMethod("ci", Integer.TYPE).invoke(coach, season - 1);
      assertInteger(coachClass, coach, "lH", season - 1);
      coachClass.getDeclaredMethod("v", Integer.TYPE).invoke(coach, countryId);
      assertInteger(coachClass, coach, "bz", countryId);
      coachClass.getDeclaredMethod("lN").invoke(coach);
      assertSame(club, coachClass.getDeclaredMethod("lF").invoke(coach),
          "remembered coach club");
      assertInteger(coachClass, coach, "bz", countryId);
      assertInteger(coachClass, coach, "lG", division - 1);

      coachClass.getDeclaredMethod("cl", Integer.TYPE).invoke(coach, 95);
      coachClass.getDeclaredMethod("cj", Integer.TYPE).invoke(coach, 10);
      assertInteger(coachClass, coach, "lL", 100);
      coachClass.getDeclaredMethod("cj", Integer.TYPE).invoke(coach, -150);
      assertInteger(coachClass, coach, "lL", 0);
      coachClass.getDeclaredMethod("cl", Integer.TYPE).invoke(coach, 80);
      coachClass.getDeclaredMethod("cm", Integer.TYPE).invoke(coach, 95);
      coachClass.getDeclaredMethod("ck", Integer.TYPE).invoke(coach, 10);
      assertInteger(coachClass, coach, "lM", 100);
      coachClass.getDeclaredMethod("ck", Integer.TYPE).invoke(coach, -150);
      assertInteger(coachClass, coach, "lM", 0);
      coachClass.getDeclaredMethod("cm", Integer.TYPE).invoke(coach, 70);

      ArrayList<String> inbox = new ArrayList<String>();
      inbox.add("probe-message");
      coachClass.getDeclaredMethod("T", ArrayList.class).invoke(coach, inbox);
      assertSame(inbox, coachClass.getDeclaredMethod("lQ").invoke(coach), "coach inbox");
      coachClass.getDeclaredMethod("cn", Integer.TYPE).invoke(coach, 2);
      coachClass.getDeclaredMethod("lS").invoke(coach);
      assertInteger(coachClass, coach, "lR", 3);
      coachClass.getDeclaredMethod("z", clubClass).invoke(coach, club);
      assertSame(club, coachClass.getDeclaredMethod("jo").invoke(coach),
          "coach national team");
      coachClass.getDeclaredMethod("z", clubClass).invoke(coach, new Object[]{null});

      coachClass.getDeclaredMethod("setReputacao", Integer.TYPE).invoke(coach, 0);
      coachClass.getDeclaredMethod(
          "a", Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE)
          .invoke(coach, 0, 1, 1, true, 1);
      coachClass.getDeclaredMethod("kk").invoke(coach);
      assertInteger(coachClass, coach, "getReputacao", 2);
      if (readInt(coach, "nu") != 600) {
        throw new IllegalStateException("Coach reputation progress was not preserved");
      }

      Object seasonRecord = coachClass.getDeclaredMethod("C", clubClass).invoke(coach, club);
      assertSame(seasonRecord,
          coachClass.getDeclaredMethod("C", clubClass).invoke(coach, club),
          "coach season record");
      assertInteger(seasonRecordClass, seasonRecord, "H", season);
      assertInteger(seasonRecordClass, seasonRecord, "ct", clubId);
      assertString(clubName, seasonRecordClass.getDeclaredMethod("ck").invoke(seasonRecord),
          "season club name");
      coachClass.getDeclaredMethod("D", clubClass).invoke(coach, club);

      Object awayClub = clubClass.getDeclaredConstructor().newInstance();
      setField(awayClub, "mU", 2_000_001);
      setField(awayClub, "dm", "Probe Away");
      Object match = matchClass.getDeclaredConstructor().newInstance();
      ArrayList<Object> events = new ArrayList<Object>();
      events.add(createMatchEvent(eventClass, clubClass, club, 1));
      events.add(createMatchEvent(eventClass, clubClass, awayClub, 1));
      events.add(createMatchEvent(eventClass, clubClass, club, 1));
      setField(match, "fz", club);
      setField(match, "fA", awayClub);
      setField(match, "fN", events);
      matchClass.getDeclaredMethod("hF").invoke(match);
      assertInteger(matchClass, match, "hu", 2);
      assertInteger(matchClass, match, "hw", 1);
      coachClass.getDeclaredMethod("e", matchClass).invoke(coach, match);
      assertInteger(coachClass, coach, "A", 1);
      assertInteger(coachClass, coach, "lJ", 1);
      assertInteger(coachClass, coach, "lK", 0);
      assertInteger(coachClass, coach, "lI", 0);
      assertInteger(coachClass, coach, "cr", 1);
      assertInteger(seasonRecordClass, seasonRecord, "w", 1);
      assertInteger(seasonRecordClass, seasonRecord, "cm", 1);
      assertInteger(seasonRecordClass, seasonRecord, "co", 0);
      assertInteger(seasonRecordClass, seasonRecord, "cr", 1);

      Object restoredCoach = roundTripObject(coach, loader);
      if (readField(restoredCoach, "nV") != null || readField(restoredCoach, "nW") != null) {
        throw new IllegalStateException("Transient coach club references were serialized");
      }
      assertString("Probe Coach", coachClass.getDeclaredMethod("dS").invoke(restoredCoach),
          "restored coach name");
      assertSame(club, coachClass.getDeclaredMethod("fg").invoke(restoredCoach),
          "restored coach club");
      assertSame(club, coachClass.getDeclaredMethod("lF").invoke(restoredCoach),
          "restored previous coach club");
      assertInteger(coachClass, restoredCoach, "lL", 80);
      assertInteger(coachClass, restoredCoach, "lM", 70);
      assertInteger(coachClass, restoredCoach, "lR", 3);
      assertInteger(coachClass, restoredCoach, "A", 1);
      assertInteger(coachClass, restoredCoach, "cr", 1);

      Object standaloneRecord = seasonRecordClass.getDeclaredConstructor(clubClass)
          .newInstance(club);
      seasonRecordClass.getDeclaredMethod("cl").invoke(standaloneRecord);
      seasonRecordClass.getDeclaredMethod("cl").invoke(standaloneRecord);
      seasonRecordClass.getDeclaredMethod("cn").invoke(standaloneRecord);
      seasonRecordClass.getDeclaredMethod("cp").invoke(standaloneRecord);
      seasonRecordClass.getDeclaredMethod("B", Integer.TYPE).invoke(standaloneRecord, 7);
      seasonRecordClass.getDeclaredMethod("cs").invoke(standaloneRecord);
      Object restoredRecord = roundTripObject(standaloneRecord, loader);
      assertInteger(seasonRecordClass, restoredRecord, "H", season);
      assertInteger(seasonRecordClass, restoredRecord, "ct", clubId);
      assertInteger(seasonRecordClass, restoredRecord, "w", 2);
      assertInteger(seasonRecordClass, restoredRecord, "cm", 1);
      assertInteger(seasonRecordClass, restoredRecord, "co", 1);
      assertInteger(seasonRecordClass, restoredRecord, "cq", 7);
      assertInteger(seasonRecordClass, restoredRecord, "cr", 1);
      assertString(clubName, seasonRecordClass.getDeclaredMethod("ck").invoke(restoredRecord),
          "restored season club name");

      Object outgoing = coachClass.getDeclaredConstructor().newInstance();
      Object incoming = coachClass.getDeclaredConstructor().newInstance();
      coachClass.getDeclaredMethod("i", String.class).invoke(outgoing, "Outgoing Coach");
      coachClass.getDeclaredMethod("i", String.class).invoke(incoming, "Incoming Coach");
      Calendar changeDate = Calendar.getInstance();
      changeDate.clear();
      changeDate.set(2026, Calendar.AUGUST, 14);
      Object change = changeRecordClass.getDeclaredConstructor().newInstance();
      changeRecordClass.getDeclaredMethod("c", coachClass).invoke(change, outgoing);
      changeRecordClass.getDeclaredMethod("d", coachClass).invoke(change, incoming);
      changeRecordClass.getDeclaredMethod("b", Calendar.class).invoke(change, changeDate);
      changeRecordClass.getDeclaredMethod("C", Integer.TYPE).invoke(change, clubId);
      changeRecordClass.getDeclaredMethod("M", Integer.TYPE).invoke(change, 7);
      assertSame(outgoing, changeRecordClass.getDeclaredMethod("dO").invoke(change),
          "outgoing coach");
      assertSame(incoming, changeRecordClass.getDeclaredMethod("dP").invoke(change),
          "incoming coach");
      assertInteger(changeRecordClass, change, "ct", clubId);
      assertInteger(changeRecordClass, change, "dQ", 7);
      assertString(clubName, changeRecordClass.getDeclaredMethod("dR").invoke(change),
          "coach change club name");
      String dateText = (String)changeRecordClass.getDeclaredMethod("f").invoke(change);
      if (dateText == null || dateText.trim().isEmpty()) {
        throw new IllegalStateException("Coach change date text is empty");
      }
      Object restoredChange = roundTripObject(change, loader);
      if (readField(restoredChange, "dl") != null) {
        throw new IllegalStateException("Transient coach change club name was serialized");
      }
      assertInteger(changeRecordClass, restoredChange, "ct", clubId);
      assertInteger(changeRecordClass, restoredChange, "dQ", 7);
      Calendar restoredDate = (Calendar)changeRecordClass.getDeclaredMethod("a")
          .invoke(restoredChange);
      if (restoredDate.getTimeInMillis() != changeDate.getTimeInMillis()) {
        throw new IllegalStateException("Coach change date changed during Kryo round-trip");
      }
      assertString("Outgoing Coach", coachClass.getDeclaredMethod("dS").invoke(
          changeRecordClass.getDeclaredMethod("dO").invoke(restoredChange)),
          "restored outgoing coach");
      assertString("Incoming Coach", coachClass.getDeclaredMethod("dS").invoke(
          changeRecordClass.getDeclaredMethod("dP").invoke(restoredChange)),
          "restored incoming coach");
      assertString(clubName, changeRecordClass.getDeclaredMethod("dR")
          .invoke(restoredChange), "restored coach change club name");

      Object previousCoachChanges = readField(career, "at");
      try {
        ArrayList<Object> coachChanges = new ArrayList<Object>();
        setField(career, "at", coachChanges);
        Object managedClub = clubClass.getDeclaredConstructor().newInstance();
        setField(managedClub, "mU", 2_000_002);
        setField(managedClub, "dm", "Probe Managed Club");
        clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(managedClub, countryId);
        clubClass.getDeclaredMethod("setDivisao", Integer.TYPE).invoke(managedClub, 1);
        Object departingCoach = coachClass.getDeclaredConstructor().newInstance();
        Object replacementCoach = coachClass.getDeclaredConstructor().newInstance();
        coachClass.getDeclaredMethod("i", String.class)
            .invoke(departingCoach, "Departing Coach");
        coachClass.getDeclaredMethod("i", String.class)
            .invoke(replacementCoach, "Replacement Coach");
        coachClass.getDeclaredMethod("k", Boolean.class)
            .invoke(departingCoach, Boolean.FALSE);
        coachClass.getDeclaredMethod("k", Boolean.class)
            .invoke(replacementCoach, Boolean.FALSE);
        coachClass.getDeclaredMethod("n", clubClass).invoke(departingCoach, managedClub);
        clubClass.getDeclaredMethod("h", coachClass).invoke(managedClub, departingCoach);

        coachClass.getDeclaredMethod("i", coachClass)
            .invoke(departingCoach, replacementCoach);
        if (coachChanges.size() != 1) {
          throw new IllegalStateException("Coach departure did not create one history record");
        }
        Object generatedChange = coachChanges.get(0);
        assertSame(departingCoach,
            changeRecordClass.getDeclaredMethod("dO").invoke(generatedChange),
            "generated outgoing coach");
        assertSame(replacementCoach,
            changeRecordClass.getDeclaredMethod("dP").invoke(generatedChange),
            "generated incoming coach");
        assertInteger(changeRecordClass, generatedChange, "ct", 2_000_002);
        if (coachClass.getDeclaredMethod("fg").invoke(departingCoach) != null
            || readField(managedClub, "mZ") != null) {
          throw new IllegalStateException("Departing coach remained assigned to the club");
        }
        assertSame(managedClub, coachClass.getDeclaredMethod("lF").invoke(departingCoach),
            "departing coach previous club");

        coachClass.getDeclaredMethod("E", clubClass).invoke(replacementCoach, managedClub);
        assertSame(managedClub, coachClass.getDeclaredMethod("fg").invoke(replacementCoach),
            "replacement coach club");
        assertSame(replacementCoach, clubClass.getDeclaredMethod("ka").invoke(managedClub),
            "club replacement coach");
        assertInteger(coachClass, replacementCoach, "lL", 95);
        assertInteger(coachClass, replacementCoach, "lM", 85);
        assertInteger(coachClass, replacementCoach, "lR", 0);
      } finally {
        setField(career, "at", previousCoachChanges);
      }

      Object market = marketClass.getDeclaredConstructor().newInstance();
      ArrayList<Object> syntheticCandidates = new ArrayList<Object>();
      syntheticCandidates.add(createCoachMarketClub(clubClass, 11, false));
      syntheticCandidates.add(createCoachMarketClub(clubClass, 11, false));
      syntheticCandidates.add(createCoachMarketClub(clubClass, 12, false));
      syntheticCandidates.add(createCoachMarketClub(clubClass, 13, true));
      marketClass.getDeclaredMethod("L", ArrayList.class).invoke(market, syntheticCandidates);
      List<Object> offerCountries = castList(readField(market, "Jg"));
      List<Object> vacancyCountries = castList(readField(market, "Jh"));
      if (offerCountries.size() != 2 || vacancyCountries.size() != 2
          || !offerCountries.contains(11) || !offerCountries.contains(12)
          || offerCountries.contains(13)) {
        throw new IllegalStateException("Coach market did not deduplicate national candidates");
      }
      marketClass.getDeclaredMethod("zi").invoke(market);
      if (!castList(readField(market, "Jg")).isEmpty()
          || !castList(readField(market, "Jh")).isEmpty()
          || !castList(readField(market, "Jj")).isEmpty()
          || !castList(readField(market, "Jl")).isEmpty()) {
        throw new IllegalStateException("Coach market candidate pools were not cleared");
      }
      ArrayList<Integer> vacancyIds = new ArrayList<Integer>();
      for (int index = 0; index < 5; index++) {
        vacancyIds.add(100 + index);
      }
      invokePrivateWithArgument(
          marketClass, market, "M", ArrayList.class, vacancyIds);
      List<Object> selectedVacancies = castList(readField(market, "Jl"));
      if (selectedVacancies.size() != 3 || !vacancyIds.containsAll(selectedVacancies)) {
        throw new IllegalStateException("Coach market did not select three club vacancies");
      }
      marketClass.getDeclaredMethod("L", ArrayList.class).invoke(market, syntheticCandidates);
      Object restoredMarket = roundTripObject(market, loader);
      if (!readField(market, "Jg").equals(readField(restoredMarket, "Jg"))
          || !readField(market, "Jh").equals(readField(restoredMarket, "Jh"))
          || !readField(market, "Jl").equals(readField(restoredMarket, "Jl"))) {
        throw new IllegalStateException("Coach market pools changed during Kryo round-trip");
      }

      Object liveMarket = marketClass.getDeclaredConstructor().newInstance();
      Object previousNationalCountries = readField(career, "ap");
      try {
        ArrayList<Object> nationalTeams = new ArrayList<Object>();
        for (Object country : castList(previousNationalCountries)) {
          if (country != null && countryClass.isInstance(country)) {
            Object nationalTeam = countryClass.getDeclaredMethod("jn").invoke(country);
            if (nationalTeam != null) {
              nationalTeams.add(nationalTeam);
            }
          }
        }
        if (nationalTeams.isEmpty()) {
          ArrayList<Object> syntheticCountries = new ArrayList<Object>();
          ArrayList<Integer> countryIds = new ArrayList<Integer>();
          countryIds.add(countryId);
          for (Object loadedCountry : castList(readField(career, "ao"))) {
            if (loadedCountry != null && countryClass.isInstance(loadedCountry)) {
              int loadedCountryId = ((Integer)countryClass.getDeclaredMethod("jc")
                  .invoke(loadedCountry)).intValue();
              if (!countryIds.contains(loadedCountryId)) {
                countryIds.add(loadedCountryId);
              }
              if (countryIds.size() == 3) {
                break;
              }
            }
          }
          for (int index = 0; index < countryIds.size(); index++) {
            int nationalCountryId = countryIds.get(index).intValue();
            Object country = countryClass.getDeclaredConstructor(Integer.TYPE)
                .newInstance(nationalCountryId);
            Object nationalTeam = createCoachMarketClub(
                clubClass, nationalCountryId, false);
            setField(nationalTeam, "mU", 3_000_000 + nationalCountryId);
            setField(nationalTeam, "dm", "Probe National " + nationalCountryId);
            clubClass.getDeclaredMethod("setReputacao", Integer.TYPE)
                .invoke(nationalTeam, 1 + index);
            countryClass.getDeclaredMethod("z", clubClass).invoke(country, nationalTeam);
            syntheticCountries.add(country);
            nationalTeams.add(nationalTeam);
          }
          setField(career, "ap", syntheticCountries);
        }
        marketClass.getDeclaredMethod("L", ArrayList.class).invoke(liveMarket, nationalTeams);
        int nationalVacancies = validateNonUserClubList(
            clubClass, marketClass.getDeclaredMethod("Aq").invoke(liveMarket),
            "national-team vacancies");
        if (nationalVacancies == 0) {
          throw new IllegalStateException("Coach market produced no national-team vacancies");
        }
        marketClass.getDeclaredMethod("zj").invoke(liveMarket);
        int clubVacancies = validateNonUserClubList(
            clubClass, marketClass.getDeclaredMethod("Ap").invoke(liveMarket),
            "club vacancies");
        if (clubVacancies == 0) {
          throw new IllegalStateException("Reference career produced no club vacancies");
        }
        int nationalOffers = validateNonUserClubList(
            clubClass,
            marketClass.getDeclaredMethod("a", coachClass, Boolean.TYPE)
                .invoke(liveMarket, coach, false),
            "national-team offers");
        int clubOffers = validateNonUserClubList(
            clubClass,
            marketClass.getDeclaredMethod("b", coachClass, Boolean.TYPE)
                .invoke(liveMarket, coach, false),
            "club offers");

        return "accessors=true approvals=0..100 matches=1 wins=1 titles=1 exchange=true "
            + "coachRoundTrip=true seasonRoundTrip=true changeRoundTrip=true "
            + "clubVacancies=" + clubVacancies
            + " nationalVacancies=" + nationalVacancies
            + " clubOffers=" + clubOffers
            + " nationalOffers=" + nationalOffers;
      } finally {
        setField(career, "ap", previousNationalCountries);
      }
    } finally {
      setStaticField(persistenceClass, "SR", previousCareer);
    }
  }

  private static Object findProbeClub(Class<?> clubClass, List<Object> clubs) throws Exception {
    for (Object club : clubs) {
      if (club == null || !clubClass.isInstance(club)) {
        continue;
      }
      String name = (String)clubClass.getDeclaredMethod("getNome").invoke(club);
      int clubId = ((Integer)clubClass.getDeclaredMethod("lk").invoke(club)).intValue();
      boolean userControlled = ((Boolean)clubClass.getDeclaredMethod("jZ").invoke(club))
          .booleanValue();
      if (clubId >= 0 && name != null && !name.trim().isEmpty() && !userControlled) {
        return club;
      }
    }
    throw new IllegalStateException("Reference career has no usable non-user club");
  }

  private static Object createCoachMarketClub(
      Class<?> clubClass, int countryId, boolean userControlled) throws Exception {
    Object club = clubClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(club, countryId);
    clubClass.getDeclaredMethod("k", Boolean.class)
        .invoke(club, Boolean.valueOf(userControlled));
    return club;
  }

  private static int validateNonUserClubList(
      Class<?> clubClass, Object value, String description) throws Exception {
    if (!(value instanceof List)) {
      throw new IllegalStateException(description + " is not a list");
    }
    int count = 0;
    for (Object club : (List<?>)value) {
      if (club == null || !clubClass.isInstance(club)) {
        throw new IllegalStateException(description + " contains an invalid club");
      }
      boolean userControlled = ((Boolean)clubClass.getDeclaredMethod("jZ").invoke(club))
          .booleanValue();
      if (userControlled) {
        throw new IllegalStateException(description + " contains a user-controlled club");
      }
      count++;
    }
    return count;
  }

  private static String validatePlayerSearchCriteriaBehavior(
      ClassLoader loader, Object career) throws Exception {
    Class<?> searchClass = loader.loadClass("best.af");
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> persistenceClass = loader.loadClass("c.a");

    Object club = clubClass.getDeclaredConstructor().newInstance();
    setField(club, "mU", 81);
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(club, 29);

    Object player = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("setNome", String.class)
        .invoke(player, "\u00c1lvaro Teste");
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, 2);
    playerClass.getDeclaredMethod("setLado", Integer.TYPE).invoke(player, 1);
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 72);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 24);
    playerClass.getDeclaredMethod("af", Integer.TYPE).invoke(player, 750_000);
    playerClass.getDeclaredMethod("setCr1", Integer.TYPE).invoke(player, 4);
    playerClass.getDeclaredMethod("setCr2", Integer.TYPE).invoke(player, 5);
    playerClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(player, 29);
    playerClass.getDeclaredMethod("aJ", Integer.TYPE).invoke(player, 11);
    playerClass.getDeclaredMethod("aI", Integer.TYPE).invoke(player, 61);
    playerClass.getDeclaredMethod("aK", Integer.TYPE).invoke(player, 62);
    playerClass.getDeclaredMethod("aL", Integer.TYPE).invoke(player, 63);
    playerClass.getDeclaredMethod("aM", Integer.TYPE).invoke(player, 64);
    playerClass.getDeclaredMethod("aN", Integer.TYPE).invoke(player, 65);
    playerClass.getDeclaredMethod("aO", Integer.TYPE).invoke(player, 66);
    playerClass.getDeclaredMethod("n", clubClass).invoke(player, club);
    setField(player, "ek", Boolean.TRUE);
    setField(player, "el", Boolean.TRUE);
    setField(player, "eW", Boolean.TRUE);
    setField(player, "eY", Boolean.TRUE);

    Object generatedPlayer = playerClass.getDeclaredConstructor().newInstance();
    Object previousCareer = readStaticField(persistenceClass, "SR");
    Object previousPrimaryPlayers = readField(career, "ag");
    Object previousGeneratedPlayers = readField(career, "ai");
    try {
      setStaticField(persistenceClass, "SR", career);
      ArrayList<Object> primaryPlayers = new ArrayList<Object>();
      primaryPlayers.add(player);
      ArrayList<Object> generatedPlayers = new ArrayList<Object>();
      generatedPlayers.add(generatedPlayer);
      setField(career, "ag", primaryPlayers);
      setField(career, "ai", generatedPlayers);

      Object poolSearch = searchClass.getDeclaredConstructor().newInstance();
      List<Object> primaryOnly = castList(searchClass.getDeclaredMethod(
          "D", Boolean.TYPE).invoke(poolSearch, false));
      List<Object> allPlayers = castList(searchClass.getDeclaredMethod(
          "D", Boolean.TYPE).invoke(poolSearch, true));
      if (primaryOnly.size() != 1 || primaryOnly.get(0) != player) {
        throw new IllegalStateException("Player search changed the primary player pool");
      }
      if (allPlayers.size() != 2 || allPlayers.get(0) != player
          || allPlayers.get(1) != generatedPlayer) {
        throw new IllegalStateException("Player search did not include generated players");
      }
    } finally {
      setField(career, "ag", previousPrimaryPlayers);
      setField(career, "ai", previousGeneratedPlayers);
      setStaticField(persistenceClass, "SR", previousCareer);
    }

    Object criteria = searchClass.getDeclaredConstructor().newInstance();
    searchClass.getDeclaredMethod("setNome", String.class).invoke(criteria, "alv");
    searchClass.getDeclaredMethod("bv", Integer.TYPE).invoke(criteria, 2);
    searchClass.getDeclaredMethod("bw", Integer.TYPE).invoke(criteria, 1);
    searchClass.getDeclaredMethod("bM", Integer.TYPE).invoke(criteria, 70);
    searchClass.getDeclaredMethod("bN", Integer.TYPE).invoke(criteria, 75);
    searchClass.getDeclaredMethod("bx", Integer.TYPE).invoke(criteria, 0);
    searchClass.getDeclaredMethod("bO", Integer.TYPE).invoke(criteria, 20);
    searchClass.getDeclaredMethod("bP", Integer.TYPE).invoke(criteria, 30);
    searchClass.getDeclaredMethod("by", Integer.TYPE).invoke(criteria, 0);
    searchClass.getDeclaredMethod("bz", Integer.TYPE).invoke(criteria, 2);
    searchClass.getDeclaredMethod("bA", Integer.TYPE).invoke(criteria, 4);
    searchClass.getDeclaredMethod("bB", Integer.TYPE).invoke(criteria, 5);
    searchClass.getDeclaredMethod("bC", Integer.TYPE).invoke(criteria, 29);
    searchClass.getDeclaredMethod("bD", Integer.TYPE).invoke(criteria, 0);
    searchClass.getDeclaredMethod("E", Boolean.TYPE).invoke(criteria, true);
    searchClass.getDeclaredMethod("F", Boolean.TYPE).invoke(criteria, true);
    searchClass.getDeclaredMethod("G", Boolean.TYPE).invoke(criteria, true);
    searchClass.getDeclaredMethod("H", Boolean.TYPE).invoke(criteria, true);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "gol", 10, 12);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "des", 63, 65);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "vel", 60, 62);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "fin", 65, 67);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "arm", 64, 66);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "tec", 61, 63);
    searchClass.getDeclaredMethod("b", String.class, Integer.TYPE, Integer.TYPE)
        .invoke(criteria, "pas", 62, 64);
    ArrayList<Integer> loadedCountryIds = new ArrayList<Integer>();
    loadedCountryIds.add(29);
    setField(criteria, "mS", loadedCountryIds);

    String[][] filterAccessors = new String[][]{
        {"jH", "bF"}, {"jI", "bG"}, {"jJ", "bH"}, {"jK", "bI"},
        {"jL", "bJ"}, {"jM", "bK"}, {"jN", "bL"}
    };
    for (String[] accessors : filterAccessors) {
      assertInteger(searchClass, criteria, accessors[0], 0);
      searchClass.getDeclaredMethod(accessors[1], Integer.TYPE).invoke(criteria, -1);
      assertInteger(searchClass, criteria, accessors[0], -1);
      searchClass.getDeclaredMethod(accessors[1], Integer.TYPE).invoke(criteria, 0);
    }
    searchClass.getDeclaredMethod("bE", Integer.TYPE).invoke(null, 0);
    assertSearchMatch(searchClass, criteria, playerClass, player, true, "all filters");

    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, 3);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "position");
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, 2);
    playerClass.getDeclaredMethod("setLado", Integer.TYPE).invoke(player, 0);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "side");
    playerClass.getDeclaredMethod("setLado", Integer.TYPE).invoke(player, 1);
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 69);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "strength");
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 72);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 31);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "age");
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 24);
    playerClass.getDeclaredMethod("af", Integer.TYPE).invoke(player, 500_000);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "market value");
    playerClass.getDeclaredMethod("af", Integer.TYPE).invoke(player, 750_000);
    playerClass.getDeclaredMethod("setCr1", Integer.TYPE).invoke(player, 3);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "primary trait");
    playerClass.getDeclaredMethod("setCr1", Integer.TYPE).invoke(player, 4);
    playerClass.getDeclaredMethod("setCr2", Integer.TYPE).invoke(player, 4);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "secondary trait");
    playerClass.getDeclaredMethod("setCr2", Integer.TYPE).invoke(player, 5);
    playerClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(player, 30);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "country");
    playerClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(player, 29);
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(club, 30);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "loaded country");
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(club, 29);

    setField(player, "ek", Boolean.FALSE);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "star flag");
    setField(player, "ek", Boolean.TRUE);
    setField(player, "el", Boolean.FALSE);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "world-class flag");
    setField(player, "el", Boolean.TRUE);
    setField(player, "eW", Boolean.FALSE);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "loan flag");
    setField(player, "eW", Boolean.TRUE);
    setField(player, "eY", Boolean.FALSE);
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "transfer flag");
    setField(player, "eY", Boolean.TRUE);

    String[] attributeSetters = new String[]{"aJ", "aI", "aN", "aL", "aM", "aO", "aK"};
    int[] failingValues = new int[]{9, 59, 63, 61, 62, 64, 60};
    int[] matchingValues = new int[]{11, 61, 65, 63, 64, 66, 62};
    for (int index = 0; index < attributeSetters.length; index++) {
      playerClass.getDeclaredMethod(attributeSetters[index], Integer.TYPE)
          .invoke(player, failingValues[index]);
      assertSearchMatch(searchClass, criteria, playerClass, player, false,
          "attribute " + attributeSetters[index]);
      playerClass.getDeclaredMethod(attributeSetters[index], Integer.TYPE)
          .invoke(player, matchingValues[index]);
    }
    searchClass.getDeclaredMethod("setNome", String.class).invoke(criteria, "zzz");
    assertSearchMatch(searchClass, criteria, playerClass, player, false, "name prefix");
    searchClass.getDeclaredMethod("setNome", String.class).invoke(criteria, "alv");
    assertSearchMatch(searchClass, criteria, playerClass, player, true, "restored filters");

    return "pools=1/2 filters=18 attributes=7 accentPrefix=true generatedPlayers=true";
  }

  private static void assertSearchMatch(
      Class<?> searchClass,
      Object criteria,
      Class<?> playerClass,
      Object player,
      boolean expected,
      String description) throws Exception {
    boolean actual = ((Boolean)invokePrivateWithArgument(
        searchClass, criteria, "i", playerClass, player)).booleanValue();
    if (actual != expected) {
      throw new IllegalStateException("Player search " + description
          + " returned " + actual + " instead of " + expected);
    }
  }

  private static String validatePlayerTransferRecordBehavior(
      ClassLoader loader, Object career) throws Exception {
    Class<?> recordClass = loader.loadClass("best.ap");
    Class<?> playerClass = loader.loadClass("best.F");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> persistenceClass = loader.loadClass("c.a");

    Object player = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("az", Integer.TYPE).invoke(player, 9_101);
    playerClass.getDeclaredMethod("aC", Integer.TYPE).invoke(player, 1);
    Object sourceClub = clubClass.getDeclaredConstructor().newInstance();
    setField(sourceClub, "mU", 101);
    setField(sourceClub, "dm", "Origem FC");
    Object destinationClub = clubClass.getDeclaredConstructor().newInstance();
    setField(destinationClub, "mU", 202);
    setField(destinationClub, "dm", "Destino FC");

    Object record = recordClass.getDeclaredConstructor().newInstance();
    recordClass.getDeclaredMethod("cp", Integer.TYPE).invoke(record, 2025);
    assertInteger(recordClass, record, "getY", 2025);
    recordClass.getDeclaredMethod("a", playerClass).invoke(record, player);
    recordClass.getDeclaredMethod("f", Integer.TYPE, Integer.TYPE, Integer.TYPE)
        .invoke(record, 14, 7, 2026);
    recordClass.getDeclaredMethod("cs", Integer.TYPE).invoke(record, 101);
    recordClass.getDeclaredMethod("cr", Integer.TYPE).invoke(record, 202);
    recordClass.getDeclaredMethod("cq", Integer.TYPE).invoke(record, 1_250_000);
    recordClass.getDeclaredMethod("mb").invoke(record);
    assertSame(player, recordClass.getDeclaredMethod("x").invoke(record),
        "transfer history player");
    assertInteger(recordClass, record, "getY", 2026);
    assertInteger(recordClass, record, "lY", 1_250_000);
    assertInteger(recordClass, record, "ma", 101);
    assertInteger(recordClass, record, "lZ", 202);
    assertInteger(recordClass, record, "gD", 9_101);
    String date = (String)recordClass.getDeclaredMethod("f").invoke(record);
    if (!"14/8/2026".equals(date)) {
      throw new IllegalStateException("Transfer history date changed: " + date);
    }

    Object previousCareer = readStaticField(persistenceClass, "SR");
    Object previousPrimaryPlayers = readField(career, "ag");
    Object previousClubs = readField(career, "aj");
    try {
      setStaticField(persistenceClass, "SR", career);
      ArrayList<Object> players = new ArrayList<Object>();
      players.add(player);
      ArrayList<Object> clubs = new ArrayList<Object>();
      clubs.add(sourceClub);
      clubs.add(destinationClub);
      setField(career, "ag", players);
      setField(career, "aj", clubs);

      if (!"Origem FC".equals(recordClass.getDeclaredMethod("mc").invoke(record))
          || !"Destino FC".equals(recordClass.getDeclaredMethod("md").invoke(record))) {
        throw new IllegalStateException("Transfer history club names were not resolved");
      }

      Object restored = roundTripObject(record, loader);
      if (recordClass.getDeclaredMethod("x").invoke(restored) != null) {
        throw new IllegalStateException("Transient transfer player survived Kryo round-trip");
      }
      assertInteger(recordClass, restored, "getY", 2026);
      assertInteger(recordClass, restored, "lY", 1_250_000);
      assertInteger(recordClass, restored, "ma", 101);
      assertInteger(recordClass, restored, "lZ", 202);
      assertInteger(recordClass, restored, "gD", 9_101);
      recordClass.getDeclaredMethod("me").invoke(restored);
      assertSame(player, recordClass.getDeclaredMethod("x").invoke(restored),
          "restored transfer history player");
      if (!"14/8/2026".equals(recordClass.getDeclaredMethod("f").invoke(restored))) {
        throw new IllegalStateException("Transfer history date changed after Kryo round-trip");
      }
    } finally {
      setField(career, "ag", previousPrimaryPlayers);
      setField(career, "aj", previousClubs);
      setStaticField(persistenceClass, "SR", previousCareer);
    }

    Object emptyRecord = recordClass.getDeclaredConstructor().newInstance();
    recordClass.getDeclaredMethod("mb").invoke(emptyRecord);
    assertInteger(recordClass, emptyRecord, "gD", -1);
    return "date=14/8/2026 fee=1250000 clubs=101/202 transient=true restored=true";
  }

  private static String validateClubFinancesBehavior(ClassLoader loader, Object career)
      throws Exception {
    Class<?> financesClass = loader.loadClass("best.C");
    Class<?> clubClass = loader.loadClass("best.ah");
    Class<?> playerClass = loader.loadClass("best.F");

    Object club = clubClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("k", Boolean.class).invoke(club, Boolean.TRUE);
    clubClass.getDeclaredMethod("e", Long.TYPE).invoke(club, 100_000L);
    Object finances = clubClass.getDeclaredMethod("kL").invoke(club);

    clubClass.getDeclaredMethod("v", Integer.TYPE, Integer.TYPE).invoke(club, 1_000, 1);
    clubClass.getDeclaredMethod("v", Integer.TYPE, Integer.TYPE).invoke(club, 2_000, 3);
    clubClass.getDeclaredMethod("v", Integer.TYPE, Integer.TYPE).invoke(club, 3_000, 5);
    clubClass.getDeclaredMethod("v", Integer.TYPE, Integer.TYPE).invoke(club, 4_000, 6);
    clubClass.getDeclaredMethod("v", Integer.TYPE, Integer.TYPE).invoke(club, 5_000, 9);
    clubClass.getDeclaredMethod("w", Integer.TYPE, Integer.TYPE).invoke(club, 600, 1);
    clubClass.getDeclaredMethod("w", Integer.TYPE, Integer.TYPE).invoke(club, 700, 4);
    clubClass.getDeclaredMethod("w", Integer.TYPE, Integer.TYPE).invoke(club, 800, 7);
    clubClass.getDeclaredMethod("w", Integer.TYPE, Integer.TYPE).invoke(club, 900, 8);
    clubClass.getDeclaredMethod("w", Integer.TYPE, Integer.TYPE).invoke(club, 1_000, 2);
    clubClass.getDeclaredMethod("f", Long.TYPE).invoke(club, 1_100L);

    assertLong(clubClass, club, "kb", 109_900L);
    assertInteger(financesClass, finances, "eE", 3_000);
    assertInteger(financesClass, finances, "eF", 2_000);
    assertLong(financesClass, finances, "eG", 1_000L);
    assertInteger(financesClass, finances, "eH", 4_000);
    assertInteger(financesClass, finances, "eR", 5_000);
    assertLong(financesClass, finances, "eJ", 600L);
    assertInteger(financesClass, finances, "eK", 700);
    assertInteger(financesClass, finances, "eI", 800);
    assertInteger(financesClass, finances, "eM", 900);
    assertInteger(financesClass, finances, "eL", 1_000);
    assertLong(financesClass, finances, "eO", 1_100L);
    assertLong(financesClass, finances, "ez", 15_000L);
    assertLong(financesClass, finances, "eB", 5_100L);
    assertLong(financesClass, finances, "eC", 9_900L);

    Object restoredFinances = roundTripObject(finances, loader);
    assertLong(financesClass, restoredFinances, "ez", 15_000L);
    assertLong(financesClass, restoredFinances, "eB", 5_100L);
    assertLong(financesClass, restoredFinances, "eC", 9_900L);

    financesClass.getDeclaredMethod("eA").invoke(finances);
    assertLong(financesClass, finances, "ez", 5_000L);
    assertLong(financesClass, finances, "eB", 0L);

    Object loanClub = clubClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("k", Boolean.class).invoke(loanClub, Boolean.TRUE);
    clubClass.getDeclaredMethod("e", Long.TYPE).invoke(loanClub, 1_000_000L);
    setField(loanClub, "divisao", 1);
    Object loanFinances = clubClass.getDeclaredMethod("kL").invoke(loanClub);
    for (int installment = 0; installment < 10; installment++) {
      boolean borrowed = ((Boolean)financesClass.getDeclaredMethod("m", clubClass)
          .invoke(loanFinances, loanClub)).booleanValue();
      if (!borrowed) {
        throw new IllegalStateException("Loan limit was reached before the tenth installment");
      }
    }
    boolean exceeded = ((Boolean)financesClass.getDeclaredMethod("m", clubClass)
        .invoke(loanFinances, loanClub)).booleanValue();
    if (exceeded) {
      throw new IllegalStateException("Loan exceeded the division-one principal limit");
    }
    assertInteger(financesClass, loanFinances, "eN", 5_000_000);
    assertInteger(financesClass, loanFinances, "eQ", 150_000);
    assertLong(clubClass, loanClub, "kb", 6_000_000L);

    boolean repaid = ((Boolean)financesClass.getDeclaredMethod("l", clubClass)
        .invoke(loanFinances, loanClub)).booleanValue();
    if (!repaid) {
      throw new IllegalStateException("Loan installment was not repaid");
    }
    assertInteger(financesClass, loanFinances, "eN", 4_500_000);
    assertInteger(financesClass, loanFinances, "eQ", 135_000);
    assertLong(clubClass, loanClub, "kb", 5_500_000L);
    Object restoredLoan = roundTripObject(loanFinances, loader);
    assertInteger(financesClass, restoredLoan, "eN", 4_500_000);
    assertInteger(financesClass, restoredLoan, "eQ", 135_000);

    assertString("0 mil", financesClass.getDeclaredMethod("c", Long.TYPE)
        .invoke(null, 0L), "zero amount");
    assertString("-1", financesClass.getDeclaredMethod("c", Long.TYPE)
        .invoke(null, -1L), "negative amount");
    assertString("1 milh\u00e3o ", financesClass.getDeclaredMethod("c", Long.TYPE)
        .invoke(null, 1_000_000L), "one million amount");
    assertString("2 milh\u00f5es 1 mil", financesClass.getDeclaredMethod("c", Long.TYPE)
        .invoke(null, 2_001_000L), "mixed million amount");
    assertString("1.5 mil", financesClass.getDeclaredMethod("a", Double.TYPE, Integer.TYPE)
        .invoke(null, 1_500.0, 0), "compact thousand amount");
    assertString("1M", financesClass.getDeclaredMethod("a", Double.TYPE, Integer.TYPE)
        .invoke(null, 1_000_000.0, 0), "compact million amount");

    Object payrollClub = clubClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("k", Boolean.class).invoke(payrollClub, Boolean.TRUE);
    clubClass.getDeclaredMethod("e", Long.TYPE).invoke(payrollClub, 10_000L);
    Object senior = playerClass.getDeclaredConstructor().newInstance();
    Object youth = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("ae", Integer.TYPE).invoke(senior, 200);
    playerClass.getDeclaredMethod("ae", Integer.TYPE).invoke(youth, 300);
    castList(clubClass.getDeclaredMethod("kc").invoke(payrollClub)).add(senior);
    castList(clubClass.getDeclaredMethod("ky").invoke(payrollClub)).add(youth);
    assertLong(clubClass, payrollClub, "kK", 500L);
    clubClass.getDeclaredMethod("kJ").invoke(payrollClub);
    assertLong(clubClass, payrollClub, "kb", 9_500L);
    Object payrollFinances = clubClass.getDeclaredMethod("kL").invoke(payrollClub);
    assertLong(financesClass, payrollFinances, "eO", 500L);

    Class<?> constantsClass = loader.loadClass("best.aq");
    long[][] initialCash = (long[][])readStaticField(constantsClass, "sC");
    int[][] sponsorship = (int[][])readStaticField(constantsClass, "sD");
    if (initialCash.length != 5 || sponsorship.length != 5
        || initialCash[1][0] != 15_000_000L || sponsorship[1][0] != 6_000_000
        || initialCash[4][0] != 3_500_000L || sponsorship[4][0] != 2_000_000) {
      throw new IllegalStateException("Division finance tables changed");
    }

    Object seasonClub = clubClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(seasonClub, 29);
    clubClass.getDeclaredMethod("setDivisao", Integer.TYPE).invoke(seasonClub, 2);
    clubClass.getDeclaredMethod("k", Boolean.class).invoke(seasonClub, Boolean.TRUE);
    clubClass.getDeclaredMethod("e", Long.TYPE).invoke(seasonClub, 100L);
    clubClass.getDeclaredMethod("kG").invoke(seasonClub);
    assertLong(clubClass, seasonClub, "kb", 4_500_100L);
    Object seasonFinances = clubClass.getDeclaredMethod("kL").invoke(seasonClub);
    assertInteger(financesClass, seasonFinances, "eH", 4_500_000);

    Object initializedClub = clubClass.getDeclaredConstructor().newInstance();
    clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(initializedClub, 29);
    clubClass.getDeclaredMethod("setDivisao", Integer.TYPE).invoke(initializedClub, 3);
    clubClass.getDeclaredMethod("kH").invoke(initializedClub);
    assertLong(clubClass, initializedClub, "kb", 10_000_000L);
    Object previousFinances = clubClass.getDeclaredMethod("kL").invoke(initializedClub);
    assertInteger(financesClass, previousFinances, "eH", 2_500_000);
    financesClass.getDeclaredMethod("X", Integer.TYPE).invoke(previousFinances, 321);
    clubClass.getDeclaredMethod("lg").invoke(initializedClub);
    Object resetFinances = clubClass.getDeclaredMethod("kL").invoke(initializedClub);
    if (resetFinances == previousFinances) {
      throw new IllegalStateException("Club finance reset reused the previous ledger");
    }
    assertLong(clubClass, initializedClub, "kb", 10_000_000L);
    assertInteger(financesClass, resetFinances, "eH", 2_500_000);
    assertInteger(financesClass, resetFinances, "eR", 0);

    Class<?> persistenceClass = loader.loadClass("c.a");
    Object previousCareer = readStaticField(persistenceClass, "SR");
    boolean previousStateChampionship = ((Boolean)career.getClass()
        .getDeclaredMethod("isJogaEstadual").invoke(career)).booleanValue();
    try {
      setStaticField(persistenceClass, "SR", career);
      career.getClass().getDeclaredMethod("setJogaEstadual", Boolean.TYPE)
          .invoke(career, true);
      Object foreignClub = clubClass.getDeclaredConstructor().newInstance();
      clubClass.getDeclaredMethod("setPais", Integer.TYPE).invoke(foreignClub, 10);
      clubClass.getDeclaredMethod("setDivisao", Integer.TYPE).invoke(foreignClub, 4);
      clubClass.getDeclaredMethod("k", Boolean.class).invoke(foreignClub, Boolean.TRUE);
      Object salariedPlayer = playerClass.getDeclaredConstructor().newInstance();
      playerClass.getDeclaredMethod("ae", Integer.TYPE).invoke(salariedPlayer, 1_000);
      castList(clubClass.getDeclaredMethod("kc").invoke(foreignClub)).add(salariedPlayer);
      clubClass.getDeclaredMethod("kG").invoke(foreignClub);
      assertLong(clubClass, foreignClub, "kb", 2_003_200L);
      Object foreignFinances = clubClass.getDeclaredMethod("kL").invoke(foreignClub);
      assertInteger(financesClass, foreignFinances, "eH", 2_000_000);
    } finally {
      career.getClass().getDeclaredMethod("setJogaEstadual", Boolean.TYPE)
          .invoke(career, previousStateChampionship);
      setStaticField(persistenceClass, "SR", previousCareer);
    }

    return "revenue=15000 expenses=5100 net=9900 resetPreservesOther=true "
        + "loan=4500000 interest=135000 payroll=500 sponsorship=4500000 "
        + "divisionTables=5 stateBonus=3200 formatting=true roundTrip=true";
  }

  private static Object createAiMarketPlayer(
      Class<?> playerClass, Class<?> clubClass, Object club, int position, boolean onLoan)
      throws Exception {
    Object player = playerClass.getDeclaredConstructor().newInstance();
    playerClass.getDeclaredMethod("n", clubClass).invoke(player, club);
    playerClass.getDeclaredMethod("setPosicao", Integer.TYPE).invoke(player, position);
    playerClass.getDeclaredMethod("ad", Integer.TYPE).invoke(player, 50);
    playerClass.getDeclaredMethod("setIdade", Integer.TYPE).invoke(player, 24);
    playerClass.getDeclaredMethod("i", Boolean.class).invoke(player, Boolean.valueOf(onLoan));
    return player;
  }

  @SuppressWarnings("unchecked")
  private static List<Object> castList(Object value) {
    return (List<Object>)value;
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
    playerClass.getDeclaredMethod("ai", Integer.TYPE).invoke(player, 80);
    assertInteger(playerClass, player, "fp", 80);
    playerClass.getDeclaredMethod("aj", Integer.TYPE).invoke(player, 10);
    assertInteger(playerClass, player, "fp", 70);
    playerClass.getDeclaredMethod("ak", Integer.TYPE).invoke(player, 40);
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

  private static void assertLong(
      Class<?> owner, Object value, String method, long expected) throws Exception {
    long actual = ((Long)owner.getDeclaredMethod(method).invoke(value)).longValue();
    if (actual != expected) {
      throw new IllegalStateException(method + " returned " + actual + " instead of " + expected);
    }
  }

  private static void assertString(String expected, Object actual, String description) {
    if (!expected.equals(actual)) {
      throw new IllegalStateException(description + " was " + actual + " instead of " + expected);
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

  private static Object readStaticField(Class<?> owner, String name) throws Exception {
    Field field = owner.getDeclaredField(name);
    field.setAccessible(true);
    return field.get(null);
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
