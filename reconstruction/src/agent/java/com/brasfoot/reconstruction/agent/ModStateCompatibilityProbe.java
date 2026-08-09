package com.brasfoot.reconstruction.agent;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import mod.extension.state.Feature;
import mod.extension.state.FeatureRegistry;
import mod.extension.state.ModState;
import mod.extension.state.ModStateStore;
import mod.extension.state.ModRuntime;
import mod.extension.board.BoardEvaluation;
import mod.extension.board.BoardOutcome;
import mod.extension.board.BoardSnapshot;
import mod.extension.reach.ClubReachResult;
import mod.extension.reach.ClubReachSnapshot;
import mod.extension.reach.ClubReachStatus;
import mod.extension.sponsorship.SponsorOffer;
import mod.extension.sponsorship.SponsorshipResult;
import mod.extension.sponsorship.SponsorshipSnapshot;
import mod.extension.sponsorship.SponsorshipStatus;
import mod.extension.sponsorship.SponsorshipTransition;

public final class ModStateCompatibilityProbe {
  private ModStateCompatibilityProbe() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new IllegalArgumentException("Usage: ModStateCompatibilityProbe <work-directory>");
    }
    Path root = Paths.get(args[0]);
    Files.createDirectories(root);
    ModStateStore store = new ModStateStore();

    Path currentSave = createSave(root, "current.s22");
    ModStateStore.LoadResult missing = store.load(currentSave);
    assertStatus(missing, ModStateStore.LoadStatus.MISSING);
    FeatureRegistry registry = FeatureRegistry.from(missing.getState());
    for (Feature feature : Feature.values()) {
      if (registry.isEnabled(feature)) {
        throw new IllegalStateException("Feature enabled without an override: " + feature);
      }
    }
    registry.setEnabled(Feature.BOARD_OBJECTIVES, true);
    Map<String, Object> board = new LinkedHashMap<String, Object>();
    board.put("club", "S\u00e3o Paulo");
    board.put("targetPoints", Integer.valueOf(72));
    ModState state = registry.applyTo(missing.getState())
        .withModule("boardObjectives", board);
    ModStateStore.LoadResult saved = store.save(currentSave, missing, state);
    assertStatus(saved, ModStateStore.LoadStatus.LOADED);
    if (saved.getState().getRevision() != 1L) {
      throw new IllegalStateException("First persisted revision was not 1");
    }
    ModStateStore.LoadResult current = store.load(currentSave);
    assertStatus(current, ModStateStore.LoadStatus.LOADED);
    if (!FeatureRegistry.from(current.getState()).isEnabled(Feature.BOARD_OBJECTIVES)
        || !"S\u00e3o Paulo".equals(
            current.getState().getModule("boardObjectives").get("club"))) {
      throw new IllegalStateException("Current mod state changed during JSON round-trip");
    }

    Path corruptSave = createSave(root, "corrupt.s22");
    Path corruptSidecar = store.sidecarFor(corruptSave);
    byte[] corruptBytes = "{broken".getBytes(StandardCharsets.UTF_8);
    Files.write(corruptSidecar, corruptBytes);
    ModStateStore.LoadResult corrupt = store.load(corruptSave);
    assertStatus(corrupt, ModStateStore.LoadStatus.CORRUPT);
    assertRefusesSave(store, corruptSave, corrupt);
    if (!java.util.Arrays.equals(corruptBytes, Files.readAllBytes(corruptSidecar))) {
      throw new IllegalStateException("Corrupt sidecar was modified");
    }

    Path legacySave = createSave(root, "legacy.s22");
    String legacyJson = "{\"schemaVersion\":0,\"revision\":3,"
        + "\"enabledFeatures\":[\"sponsorships\"],"
        + "\"data\":{\"sponsorships\":{\"monthlyPayment\":125000}}}";
    Files.write(store.sidecarFor(legacySave), legacyJson.getBytes(StandardCharsets.UTF_8));
    ModStateStore.LoadResult migrated = store.load(legacySave);
    assertStatus(migrated, ModStateStore.LoadStatus.MIGRATED);
    if (!FeatureRegistry.from(migrated.getState()).isEnabled(Feature.SPONSORSHIPS)
        || migrated.getState().getRevision() != 3L) {
      throw new IllegalStateException("Legacy sidecar migration lost state");
    }
    ModStateStore.LoadResult upgraded = store.save(legacySave, migrated, migrated.getState());
    if (upgraded.getState().getRevision() != 4L
        || store.load(legacySave).getStatus() != ModStateStore.LoadStatus.LOADED) {
      throw new IllegalStateException("Migrated sidecar was not upgraded");
    }

    Path futureSave = createSave(root, "future.s22");
    String futureJson = "{\"schemaVersion\":2,"
        + "\"features\":{\"sponsorships\":true}}";
    Files.write(store.sidecarFor(futureSave), futureJson.getBytes(StandardCharsets.UTF_8));
    ModStateStore.LoadResult future = store.load(futureSave);
    assertStatus(future, ModStateStore.LoadStatus.UNSUPPORTED);
    assertRefusesSave(store, futureSave, future);

    Path boardSave = createSave(root, "board.s22");
    ModRuntime.startNewCareer();
    ModRuntime.setFeatureEnabled(Feature.BOARD_OBJECTIVES, true);
    BoardSnapshot january = boardSnapshot(2026, 1, 0, 0);
    BoardSnapshot february = boardSnapshot(2026, 2, 4, 3);
    BoardEvaluation initialized = ModRuntime.evaluateBoardObjectives(january);
    BoardEvaluation evaluated = ModRuntime.evaluateBoardObjectives(february);
    BoardEvaluation duplicate = ModRuntime.evaluateBoardObjectives(february);
    if (initialized.getOutcome() != BoardOutcome.INITIALIZED
        || evaluated.getOutcome() != BoardOutcome.EXCEEDED
        || evaluated.getApprovalDelta() != 3
        || duplicate.getOutcome() != BoardOutcome.UNCHANGED) {
      throw new IllegalStateException("Board objectives evaluation is not deterministic");
    }
    ModRuntime.setFeatureEnabled(Feature.SPONSORSHIPS, true);
    SponsorshipSnapshot sponsorJanuary = sponsorshipSnapshot(2026, 1, 1, 8, 5, 1);
    SponsorshipTransition sponsorTransition =
        ModRuntime.prepareSponsorshipSeason(sponsorJanuary);
    SponsorshipTransition duplicateTransition =
        ModRuntime.prepareSponsorshipSeason(sponsorJanuary);
    if (!sponsorTransition.isLegacyRevenueReplacementDue()
        || duplicateTransition.isLegacyRevenueReplacementDue()) {
      throw new IllegalStateException("Legacy sponsorship transition is not idempotent");
    }
    SponsorshipResult offers = ModRuntime.ensureSponsorshipOffers(sponsorJanuary);
    if (offers.getOffers().size() != 3) {
      throw new IllegalStateException("Sponsorship offers were not generated");
    }
    SponsorOffer selected = offers.getOffers().get(2);
    SponsorshipResult activated = ModRuntime.acceptSponsorshipOffer(
        sponsorJanuary, selected.getId());
    SponsorshipResult sponsorPayment = ModRuntime.processSponsorshipMonth(
        sponsorJanuary);
    SponsorshipResult duplicatePayment = ModRuntime.processSponsorshipMonth(
        sponsorJanuary);
    SponsorshipResult sponsorBonus = ModRuntime.processSponsorshipMonth(
        sponsorshipSnapshot(2026, 2, 1, 12, 7, 2));
    if (activated.getContract().getEndPeriod() != 202712
        || activated.getSigningBonus() <= 0
        || sponsorPayment.getStatus() != SponsorshipStatus.PAYMENT_DUE
        || sponsorPayment.getMonthlyPayment() <= 0
        || sponsorPayment.getGoalBonus() != 0
        || duplicatePayment.getStatus() != SponsorshipStatus.ALREADY_PROCESSED
        || sponsorBonus.getGoalBonus() != selected.getGoalBonus()) {
      throw new IllegalStateException("Sponsorship contract processing is inconsistent");
    }
    ModRuntime.setFeatureEnabled(Feature.CLUB_REACH, true);
    ClubReachResult reachInitialized = ModRuntime.evaluateClubReach(
        clubReachSnapshot(2026, 1, 0, 0, 0, 0));
    ClubReachResult reachUpdated = ModRuntime.evaluateClubReach(
        clubReachSnapshot(2026, 2, 6, 4, 1, 1));
    ClubReachResult reachDuplicate = ModRuntime.evaluateClubReach(
        clubReachSnapshot(2026, 2, 6, 4, 1, 1));
    if (reachInitialized.getStatus() != ClubReachStatus.INITIALIZED
        || reachUpdated.getStatus() != ClubReachStatus.UPDATED
        || reachUpdated.getSocialFollowerDelta() <= 0L
        || reachUpdated.getInternationalSupporterDelta() <= 0L
        || reachUpdated.getGlobalReputationDelta() <= 0
        || reachDuplicate.getStatus() != ClubReachStatus.ALREADY_PROCESSED
        || reachDuplicate.getSocialFollowerDelta()
            != reachUpdated.getSocialFollowerDelta()) {
      throw new IllegalStateException("Club reach processing is inconsistent");
    }
    if (!ModRuntime.persist(boardSave)) {
      throw new IllegalStateException("Extension state was not persisted");
    }
    ModRuntime.startNewCareer();
    ModRuntime.attach(boardSave);
    if (!ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES)
        || !ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS)
        || !ModRuntime.isFeatureEnabled(Feature.CLUB_REACH)
        || ModRuntime.getState().getModule("boardObjectives").isEmpty()
        || ModRuntime.getState().getModule("sponsorships").isEmpty()
        || ModRuntime.getState().getModule("clubReach").isEmpty()) {
      throw new IllegalStateException("Extension modules were not restored");
    }
    try (java.util.stream.Stream<Path> files = Files.list(root)) {
      if (files.anyMatch(path -> path.getFileName().toString().endsWith(".tmp"))) {
        throw new IllegalStateException("Atomic save left a temporary file behind");
      }
    }
    System.out.println("MOD_STATE_API missing=true current=true corrupt=true migrated=true "
        + "unsupported=true atomic=true revision=true utf8=true defaultsDisabled=true "
        + "boardObjectives=true monthly=true idempotent=true jobSecurity=true "
        + "sponsorships=true offers=true contracts=true bonuses=true payments=true "
        + "transition=true clubReach=true audiences=true social=true reputation=true");
  }

  private static BoardSnapshot boardSnapshot(
      int year, int month, int matches, int wins) {
    return new BoardSnapshot(
        year,
        month,
        1,
        7,
        101,
        1,
        3,
        matches,
        wins,
        matches - wins,
        75,
        80,
        1_000_000L + month * 100_000L,
        month * 100_000L);
  }

  private static SponsorshipSnapshot sponsorshipSnapshot(
      int year,
      int month,
      int season,
      int matches,
      int wins,
      int titles) {
    return new SponsorshipSnapshot(
        year, month, season, 101, 1, 3, 6_000_000, matches, wins, titles);
  }

  private static ClubReachSnapshot clubReachSnapshot(
      int year,
      int month,
      int matches,
      int wins,
      int losses,
      int titles) {
    return new ClubReachSnapshot(
        year, month, 1, 101, 1, 3, 80, 40_000,
        matches, wins, losses, titles);
  }

  private static Path createSave(Path root, String name) throws Exception {
    Path save = root.resolve(name);
    Files.write(save, new byte[]{1, 2, 3});
    return save;
  }

  private static void assertStatus(
      ModStateStore.LoadResult result, ModStateStore.LoadStatus expected) {
    if (result.getStatus() != expected) {
      throw new IllegalStateException(
          "Expected " + expected + " mod state, got " + result.getStatus());
    }
  }

  private static void assertRefusesSave(
      ModStateStore store, Path save, ModStateStore.LoadResult result) throws Exception {
    try {
      store.save(save, result, result.getState());
      throw new IllegalStateException("Unsafe mod state overwrite was accepted");
    } catch (IllegalStateException expected) {
      if (expected.getMessage().contains("Unsafe mod state overwrite")) {
        throw expected;
      }
    }
  }
}
