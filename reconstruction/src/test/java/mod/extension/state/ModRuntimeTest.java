package mod.extension.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import mod.extension.board.BoardEvaluation;
import mod.extension.board.BoardObjectivesService;
import mod.extension.board.BoardOutcome;
import mod.extension.board.BoardSnapshot;
import mod.extension.infrastructure.InfrastructureResult;
import mod.extension.infrastructure.InfrastructureSnapshot;
import mod.extension.infrastructure.InfrastructureStatus;
import mod.extension.infrastructure.StadiumInfrastructureService;
import mod.extension.reach.ClubReachResult;
import mod.extension.reach.ClubReachService;
import mod.extension.reach.ClubReachSnapshot;
import mod.extension.reach.ClubReachStatus;
import mod.extension.sponsorship.SponsorshipResult;
import mod.extension.sponsorship.SponsorshipService;
import mod.extension.sponsorship.SponsorshipSnapshot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ModRuntimeTest {
  @TempDir
  Path directory;

  @AfterEach
  void resetRuntime() {
    ModRuntime.startNewCareer();
  }

  @Test
  void disabledFeatureKeepsOriginalFallbackUntouched() {
    ModRuntime.startNewCareer();
    BoardEvaluation evaluation = ModRuntime.evaluateBoardObjectives(snapshot(2026, 1, 0, 0));

    assertEquals(BoardOutcome.DISABLED, evaluation.getOutcome());
    assertFalse(evaluation.isStateChanged());
    assertTrue(ModRuntime.getState().getModule(BoardObjectivesService.MODULE_ID).isEmpty());
  }

  @Test
  void persistsEnabledBoardObjectivesAcrossRuntimeAttach() throws Exception {
    Path save = this.directory.resolve("career.s22");
    Files.write(save, new byte[]{1, 2, 3});
    ModRuntime.startNewCareer();
    ModRuntime.setFeatureEnabled(Feature.BOARD_OBJECTIVES, true);
    ModRuntime.evaluateBoardObjectives(snapshot(2026, 1, 0, 0));
    BoardEvaluation february = ModRuntime.evaluateBoardObjectives(snapshot(2026, 2, 4, 3));

    assertEquals(3, february.getApprovalDelta());
    assertTrue(ModRuntime.persist(save));
    ModRuntime.startNewCareer();
    assertFalse(ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES));

    assertEquals(ModStateStore.LoadStatus.LOADED, ModRuntime.attach(save));
    assertTrue(ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES));
    assertFalse(ModRuntime.getState().getModule(BoardObjectivesService.MODULE_ID).isEmpty());
  }

  @Test
  void keepsSponsorshipsDisabledUntilExplicitlyEnabledAndPersistsTheContract()
      throws Exception {
    SponsorshipSnapshot snapshot = sponsorshipSnapshot(2026, 1, 1, 0, 0, 0);
    ModRuntime.startNewCareer();
    assertEquals(
        0, ModRuntime.ensureSponsorshipOffers(snapshot).getOffers().size());

    ModRuntime.setFeatureEnabled(Feature.SPONSORSHIPS, true);
    SponsorshipResult offers = ModRuntime.ensureSponsorshipOffers(snapshot);
    SponsorshipResult contract = ModRuntime.acceptSponsorshipOffer(
        snapshot, offers.getOffers().get(0).getId());
    ModRuntime.processSponsorshipMonth(snapshot);
    Path save = this.directory.resolve("sponsor.s22");
    Files.write(save, new byte[]{4, 5, 6});
    assertTrue(ModRuntime.persist(save));

    ModRuntime.startNewCareer();
    ModRuntime.attach(save);

    assertTrue(ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS));
    assertFalse(ModRuntime.getState().getModule(SponsorshipService.MODULE_ID).isEmpty());
    assertEquals(202612, contract.getContract().getEndPeriod());
  }

  @Test
  void keepsClubReachOptInAndPersistsItsProfile() throws Exception {
    ClubReachSnapshot snapshot = clubReachSnapshot(2026, 1, 0, 0, 0, 0);
    ModRuntime.startNewCareer();

    ClubReachResult disabled = ModRuntime.evaluateClubReach(snapshot);
    assertEquals(ClubReachStatus.DISABLED, disabled.getStatus());
    assertTrue(ModRuntime.getState().getModule(ClubReachService.MODULE_ID).isEmpty());

    ModRuntime.setFeatureEnabled(Feature.CLUB_REACH, true);
    ClubReachResult initialized = ModRuntime.evaluateClubReach(snapshot);
    Path save = this.directory.resolve("reach.s22");
    Files.write(save, new byte[]{7, 8, 9});
    assertTrue(initialized.isStateChanged());
    assertTrue(ModRuntime.persist(save));

    ModRuntime.startNewCareer();
    ModRuntime.attach(save);

    assertTrue(ModRuntime.isFeatureEnabled(Feature.CLUB_REACH));
    assertFalse(ModRuntime.getState().getModule(ClubReachService.MODULE_ID).isEmpty());
  }

  @Test
  void keepsInfrastructureOptInAndPersistsItsProfile() throws Exception {
    InfrastructureSnapshot snapshot = new InfrastructureSnapshot(
        2026, 1, 1, 101, 1, 3, 40_000, 1, 0, 100_000_000L);
    ModRuntime.startNewCareer();

    InfrastructureResult disabled = ModRuntime.inspectInfrastructure(snapshot);
    assertEquals(InfrastructureStatus.DISABLED, disabled.getStatus());
    assertTrue(ModRuntime.getState()
        .getModule(StadiumInfrastructureService.MODULE_ID).isEmpty());

    ModRuntime.setFeatureEnabled(Feature.STADIUM_INFRASTRUCTURE, true);
    InfrastructureResult initialized = ModRuntime.inspectInfrastructure(snapshot);
    Path save = this.directory.resolve("infrastructure.s22");
    Files.write(save, new byte[]{10, 11, 12});
    assertTrue(initialized.isStateChanged());
    assertTrue(ModRuntime.persist(save));

    ModRuntime.startNewCareer();
    ModRuntime.attach(save);

    assertTrue(ModRuntime.isFeatureEnabled(Feature.STADIUM_INFRASTRUCTURE));
    assertFalse(ModRuntime.getState()
        .getModule(StadiumInfrastructureService.MODULE_ID).isEmpty());
  }

  private BoardSnapshot snapshot(int year, int month, int matches, int wins) {
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

  private SponsorshipSnapshot sponsorshipSnapshot(
      int year, int month, int season, int matches, int wins, int titles) {
    return new SponsorshipSnapshot(
        year, month, season, 101, 1, 3, 6_000_000, matches, wins, titles);
  }

  private ClubReachSnapshot clubReachSnapshot(
      int year, int month, int matches, int wins, int losses, int titles) {
    return new ClubReachSnapshot(
        year, month, 1, 101, 1, 3, 80, 40_000,
        matches, wins, losses, titles);
  }
}
