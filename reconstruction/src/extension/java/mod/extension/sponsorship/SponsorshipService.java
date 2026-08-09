package mod.extension.sponsorship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;

public final class SponsorshipService {
  public static final String MODULE_ID = "sponsorships";
  private static final int MAX_HISTORY = 36;
  private static final String[] SPONSOR_NAMES = new String[]{
      "Aurea Energia",
      "Banco Horizonte",
      "Conecta Telecom",
      "Delta Mobilidade",
      "Estrela Seguros",
      "Fortis Tecnologia",
      "Grupo Nacional",
      "Impulso Esportes",
      "Litoral Alimentos",
      "Nova Rede",
      "PontoBet",
      "Viva Saude"
  };

  public SponsorshipTransition prepareSeason(
      ModState state, SponsorshipSnapshot snapshot) {
    require(state, snapshot);
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> profile = copyObject(profiles.get(snapshot.getProfileKey()));
    int handledSeason = integer(profile.get("legacyRevenueHandledSeason"), -1);
    if (handledSeason == snapshot.getSeasonNumber()) {
      return new SponsorshipTransition(state, false);
    }
    profile.put(
        "legacyRevenueHandledSeason", Long.valueOf(snapshot.getSeasonNumber()));
    ModState updated = updateState(state, module, profiles, snapshot, profile);
    return new SponsorshipTransition(updated, true);
  }

  public SponsorshipResult ensureOffers(ModState state, SponsorshipSnapshot snapshot) {
    require(state, snapshot);
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> profile = copyObject(profiles.get(snapshot.getProfileKey()));
    SponsorContract contract = readContract(profile.get("activeContract"));
    if (contract != null && snapshot.getPeriod() <= contract.getEndPeriod()) {
      return result(
          state,
          SponsorshipStatus.CONTRACT_ACTIVE,
          Collections.<SponsorOffer>emptyList(),
          contract,
          0,
          0,
          0,
          false,
          false);
    }

    boolean expired = contract != null;
    if (expired) {
      profile.remove("activeContract");
    }
    int offerSeason = integer(profile.get("offerSeason"), -1);
    List<SponsorOffer> pending = readOffers(profile.get("pendingOffers"));
    if (!expired && offerSeason == snapshot.getSeasonNumber() && !pending.isEmpty()) {
      return result(
          state,
          SponsorshipStatus.OFFERS_AVAILABLE,
          pending,
          null,
          0,
          0,
          0,
          false,
          false);
    }

    List<SponsorOffer> generated = generateOffers(snapshot);
    profile.put("offerSeason", Long.valueOf(snapshot.getSeasonNumber()));
    profile.put("offerPeriod", Long.valueOf(snapshot.getPeriod()));
    profile.put("pendingOffers", writeOffers(generated));
    profile.put("lastStatus", expired
        ? SponsorshipStatus.CONTRACT_EXPIRED.name()
        : SponsorshipStatus.OFFERS_CREATED.name());
    appendEvent(profile, snapshot.getPeriod(), expired ? "expired" : "offers", 0L);
    ModState updated = updateState(state, module, profiles, snapshot, profile);
    return result(
        updated,
        expired ? SponsorshipStatus.CONTRACT_EXPIRED : SponsorshipStatus.OFFERS_CREATED,
        generated,
        null,
        0,
        0,
        0,
        false,
        true);
  }

  public SponsorshipResult acceptOffer(
      ModState state, SponsorshipSnapshot snapshot, String offerId) {
    require(state, snapshot);
    if (offerId == null) {
      throw new NullPointerException("offerId");
    }
    SponsorshipResult available = ensureOffers(state, snapshot);
    SponsorOffer selected = null;
    for (SponsorOffer offer : available.getOffers()) {
      if (offer.getId().equals(offerId)) {
        selected = offer;
        break;
      }
    }
    if (selected == null) {
      throw new IllegalArgumentException("Sponsor offer is not available: " + offerId);
    }

    Map<String, Object> module = copyObject(available.getState().getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> profile = copyObject(profiles.get(snapshot.getProfileKey()));
    int previousContractCount = Math.max(0, integer(profile.get("contractCount"), 0));
    SponsorContract contract = new SponsorContract(
        selected,
        snapshot.getPeriod(),
        addMonths(snapshot.getPeriod(), selected.getDurationMonths() - 1),
        -1,
        -1,
        selected.getSigningBonus(),
        snapshot.getSeasonNumber(),
        snapshot.getMatchCount(),
        snapshot.getWinCount(),
        snapshot.getTitleCount());
    profile.put("activeContract", writeContract(contract));
    profile.remove("pendingOffers");
    profile.remove("offerSeason");
    profile.remove("offerPeriod");
    profile.put("contractCount", Long.valueOf(previousContractCount + 1L));
    profile.put("lastStatus", SponsorshipStatus.CONTRACT_ACTIVATED.name());
    appendEvent(profile, snapshot.getPeriod(), "activated", selected.getSigningBonus());
    ModState updated = updateState(available.getState(), module, profiles, snapshot, profile);
    return result(
        updated,
        SponsorshipStatus.CONTRACT_ACTIVATED,
        Collections.<SponsorOffer>emptyList(),
        contract,
        selected.getSigningBonus(),
        0,
        0,
        previousContractCount == 0,
        true);
  }

  public SponsorshipResult processMonthly(
      ModState state, SponsorshipSnapshot snapshot) {
    require(state, snapshot);
    SponsorshipResult current = ensureOffers(state, snapshot);
    if (current.getContract() == null) {
      return current;
    }
    SponsorContract contract = current.getContract();
    if (snapshot.getPeriod() < contract.getStartPeriod()) {
      return result(
          state,
          SponsorshipStatus.CONTRACT_ACTIVE,
          Collections.<SponsorOffer>emptyList(),
          contract,
          0,
          0,
          0,
          false,
          false);
    }
    if (contract.getLastPaymentPeriod() >= snapshot.getPeriod()) {
      return result(
          state,
          SponsorshipStatus.ALREADY_PROCESSED,
          Collections.<SponsorOffer>emptyList(),
          contract,
          0,
          0,
          0,
          false,
          false);
    }

    if (contract.getGoalBaselineSeason() != snapshot.getSeasonNumber()
        || snapshot.getMatchCount() < contract.getBaselineMatchCount()
        || snapshot.getWinCount() < contract.getBaselineWinCount()
        || snapshot.getTitleCount() < contract.getBaselineTitleCount()) {
      contract = contract.rebased(snapshot);
    }

    SponsorOffer offer = contract.getOffer();
    boolean goalReached = contract.getBonusPaidSeason() != snapshot.getSeasonNumber()
        && goalReached(contract, snapshot);
    int goalBonus = goalReached ? offer.getGoalBonus() : 0;
    int total = Math.addExact(offer.getMonthlyPayment(), goalBonus);
    SponsorContract paid = contract.paid(
        snapshot.getPeriod(), snapshot.getSeasonNumber(), total, goalReached);

    Map<String, Object> module = copyObject(current.getState().getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> profile = copyObject(profiles.get(snapshot.getProfileKey()));
    profile.put("activeContract", writeContract(paid));
    profile.put("lastStatus", SponsorshipStatus.PAYMENT_DUE.name());
    profile.put("lastPayment", Long.valueOf(total));
    appendEvent(profile, snapshot.getPeriod(), goalReached ? "payment+bonus" : "payment", total);
    ModState updated = updateState(current.getState(), module, profiles, snapshot, profile);
    return result(
        updated,
        SponsorshipStatus.PAYMENT_DUE,
        Collections.<SponsorOffer>emptyList(),
        paid,
        0,
        offer.getMonthlyPayment(),
        goalBonus,
        false,
        true);
  }

  private List<SponsorOffer> generateOffers(SponsorshipSnapshot snapshot) {
    long annual = snapshot.getBaseAnnualRevenue() > 0
        ? snapshot.getBaseAnnualRevenue() : 1_200_000L;
    int reputationFactor = clamp(80 + snapshot.getClubReputation() * 5, 80, 150);
    int baseMonthly = roundedAmount(annual * reputationFactor / 1200L);
    baseMonthly = Math.max(50_000, baseMonthly);
    int seed = snapshot.getClubId() * 31
        + snapshot.getSeasonNumber() * 17
        + snapshot.getPeriod();

    List<SponsorOffer> offers = new ArrayList<SponsorOffer>();
    offers.add(new SponsorOffer(
        offerId(snapshot, 0),
        sponsorName(seed, 0),
        12,
        baseMonthly,
        scaled(baseMonthly, 100),
        SponsorGoal.WIN_RATE,
        clamp(42 + snapshot.getClubReputation(), 42, 58),
        scaled(baseMonthly, 200)));
    offers.add(new SponsorOffer(
        offerId(snapshot, 1),
        sponsorName(seed, 1),
        18,
        scaled(baseMonthly, 50),
        scaled(baseMonthly, 115),
        SponsorGoal.SEASON_WINS,
        clamp(14 + snapshot.getClubReputation() * 2, 14, 30),
        scaled(baseMonthly, 300)));
    offers.add(new SponsorOffer(
        offerId(snapshot, 2),
        sponsorName(seed, 2),
        24,
        scaled(baseMonthly, 200),
        scaled(baseMonthly, 80),
        SponsorGoal.TITLE,
        1,
        scaled(baseMonthly, 600)));
    return offers;
  }

  private boolean goalReached(SponsorContract contract, SponsorshipSnapshot snapshot) {
    SponsorOffer offer = contract.getOffer();
    int matches = Math.max(
        0, snapshot.getMatchCount() - contract.getBaselineMatchCount());
    int wins = Math.max(
        0, snapshot.getWinCount() - contract.getBaselineWinCount());
    int titles = Math.max(
        0, snapshot.getTitleCount() - contract.getBaselineTitleCount());
    if (offer.getGoal() == SponsorGoal.WIN_RATE) {
      int winRate = matches == 0 ? 0
          : (int)Math.round(wins * 100.0D / matches);
      return matches >= 5 && winRate >= offer.getGoalTarget();
    }
    if (offer.getGoal() == SponsorGoal.SEASON_WINS) {
      return wins >= offer.getGoalTarget();
    }
    return titles >= offer.getGoalTarget();
  }

  private String sponsorName(int seed, int slot) {
    int index = Math.floorMod(seed + slot * 5, SPONSOR_NAMES.length);
    return SPONSOR_NAMES[index];
  }

  private String offerId(SponsorshipSnapshot snapshot, int slot) {
    return snapshot.getClubId() + "-" + snapshot.getSeasonNumber()
        + "-" + snapshot.getPeriod() + "-" + slot;
  }

  private int scaled(int base, int percent) {
    return roundedAmount((long)base * percent / 100L);
  }

  private int roundedAmount(long value) {
    long rounded = ((Math.max(0L, value) + 5_000L) / 10_000L) * 10_000L;
    return (int)Math.min(1_000_000_000L, rounded);
  }

  private int addMonths(int period, int months) {
    int year = period / 100;
    int month = period % 100;
    if (month < 1 || month > 12 || months < 0) {
      throw new IllegalArgumentException("Invalid sponsorship period");
    }
    int absoluteMonth = year * 12 + month - 1 + months;
    return absoluteMonth / 12 * 100 + absoluteMonth % 12 + 1;
  }

  private ModState updateState(
      ModState state,
      Map<String, Object> module,
      Map<String, Object> profiles,
      SponsorshipSnapshot snapshot,
      Map<String, Object> profile) {
    profiles.put(snapshot.getProfileKey(), profile);
    module.put("profiles", profiles);
    module.put("latestProfile", snapshot.getProfileKey());
    module.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    return state.withModule(MODULE_ID, module);
  }

  private void appendEvent(
      Map<String, Object> profile, int period, String type, long amount) {
    List<Object> history = copyList(profile.get("history"));
    Map<String, Object> event = new LinkedHashMap<String, Object>();
    event.put("period", Long.valueOf(period));
    event.put("type", type);
    event.put("amount", Long.valueOf(amount));
    history.add(event);
    while (history.size() > MAX_HISTORY) {
      history.remove(0);
    }
    profile.put("history", history);
  }

  private List<Object> writeOffers(List<SponsorOffer> offers) {
    List<Object> result = new ArrayList<Object>();
    for (SponsorOffer offer : offers) {
      result.add(writeOffer(offer));
    }
    return result;
  }

  private List<SponsorOffer> readOffers(Object value) {
    if (!(value instanceof List)) {
      return Collections.emptyList();
    }
    List<SponsorOffer> result = new ArrayList<SponsorOffer>();
    for (Object item : (List<?>)value) {
      result.add(readOffer(item));
    }
    return result;
  }

  private Map<String, Object> writeOffer(SponsorOffer offer) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("id", offer.getId());
    result.put("sponsorName", offer.getSponsorName());
    result.put("durationMonths", Long.valueOf(offer.getDurationMonths()));
    result.put("signingBonus", Long.valueOf(offer.getSigningBonus()));
    result.put("monthlyPayment", Long.valueOf(offer.getMonthlyPayment()));
    result.put("goal", offer.getGoal().name());
    result.put("goalTarget", Long.valueOf(offer.getGoalTarget()));
    result.put("goalBonus", Long.valueOf(offer.getGoalBonus()));
    return result;
  }

  private SponsorOffer readOffer(Object value) {
    Map<String, Object> source = copyObject(value);
    if (source.isEmpty()) {
      throw new IllegalArgumentException("Sponsor offer is not an object");
    }
    SponsorGoal goal;
    try {
      goal = SponsorGoal.valueOf(string(source.get("goal"), "goal"));
    } catch (IllegalArgumentException exception) {
      throw new IllegalArgumentException("Sponsor goal is invalid", exception);
    }
    return new SponsorOffer(
        string(source.get("id"), "id"),
        string(source.get("sponsorName"), "sponsorName"),
        integer(source.get("durationMonths"), -1),
        integer(source.get("signingBonus"), -1),
        integer(source.get("monthlyPayment"), -1),
        goal,
        integer(source.get("goalTarget"), -1),
        integer(source.get("goalBonus"), -1));
  }

  private Map<String, Object> writeContract(SponsorContract contract) {
    Map<String, Object> result = writeOffer(contract.getOffer());
    result.put("startPeriod", Long.valueOf(contract.getStartPeriod()));
    result.put("endPeriod", Long.valueOf(contract.getEndPeriod()));
    result.put("lastPaymentPeriod", Long.valueOf(contract.getLastPaymentPeriod()));
    result.put("bonusPaidSeason", Long.valueOf(contract.getBonusPaidSeason()));
    result.put("totalPaid", Long.valueOf(contract.getTotalPaid()));
    result.put("goalBaselineSeason", Long.valueOf(contract.getGoalBaselineSeason()));
    result.put("baselineMatchCount", Long.valueOf(contract.getBaselineMatchCount()));
    result.put("baselineWinCount", Long.valueOf(contract.getBaselineWinCount()));
    result.put("baselineTitleCount", Long.valueOf(contract.getBaselineTitleCount()));
    return result;
  }

  private SponsorContract readContract(Object value) {
    if (value == null) {
      return null;
    }
    Map<String, Object> source = copyObject(value);
    SponsorOffer offer = readOffer(source);
    return new SponsorContract(
        offer,
        integer(source.get("startPeriod"), -1),
        integer(source.get("endPeriod"), -1),
        integer(source.get("lastPaymentPeriod"), -1),
        integer(source.get("bonusPaidSeason"), -1),
        longValue(source.get("totalPaid"), -1L),
        integer(source.get("goalBaselineSeason"), -1),
        integer(source.get("baselineMatchCount"), -1),
        integer(source.get("baselineWinCount"), -1),
        integer(source.get("baselineTitleCount"), -1));
  }

  private SponsorshipResult result(
      ModState state,
      SponsorshipStatus status,
      List<SponsorOffer> offers,
      SponsorContract contract,
      int signingBonus,
      int monthlyPayment,
      int goalBonus,
      boolean firstContract,
      boolean changed) {
    return new SponsorshipResult(
        state,
        status,
        offers,
        contract,
        signingBonus,
        monthlyPayment,
        goalBonus,
        firstContract,
        changed);
  }

  private void require(ModState state, SponsorshipSnapshot snapshot) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    if (snapshot == null) {
      throw new NullPointerException("snapshot");
    }
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

  private String string(Object value, String label) {
    if (!(value instanceof String) || ((String)value).length() == 0) {
      throw new IllegalArgumentException("Sponsor " + label + " is missing");
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
}
