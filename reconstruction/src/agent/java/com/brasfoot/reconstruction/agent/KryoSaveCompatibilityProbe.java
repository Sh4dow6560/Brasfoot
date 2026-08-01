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
      String stadiumExpansion = validateStadiumExpansion(loader);
      MatchEventSummary matchEvents = new MatchEventSummary();
      Map<String, Integer> counts = countTargets(roots, targets, matchEvents);
      matchEvents.validate();
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
      Map<String, Integer> restoredCounts = countTargets(restored, targets, restoredMatchEvents);
      if (!counts.equals(restoredCounts)) {
        throw new IllegalStateException("Kryo round-trip changed recovered model counts");
      }
      if (!matchEvents.equals(restoredMatchEvents)) {
        throw new IllegalStateException("Kryo round-trip changed match events: "
            + matchEvents + " -> " + restoredMatchEvents);
      }
      System.out.println("ROOT " + roots[0].getClass().getName()
          + " AUX " + roots[1].getClass().getName());
      System.out.println("CALENDAR " + calendar.toLogLine());
      System.out.println("MATCH_EVENTS " + matchEvents.toLogLine());
      System.out.println("MATCH_EVENT_API " + matchEventApi);
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
      Object[] roots, String[] targets, MatchEventSummary matchEvents) throws Exception {
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
