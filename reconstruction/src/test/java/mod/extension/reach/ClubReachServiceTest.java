package mod.extension.reach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class ClubReachServiceTest {
  private final ClubReachService service = new ClubReachService();

  @Test
  void initializesADeterministicProfileAndProcessesEachPeriodOnce() {
    ClubReachSnapshot january = snapshot(2026, 1, 1, 101, 80, 40_000, 0, 0, 0, 0);

    ClubReachResult initialized = this.service.evaluate(ModState.empty(), january);
    ClubReachResult repeated = this.service.evaluate(initialized.getState(), january);

    assertEquals(ClubReachStatus.INITIALIZED, initialized.getStatus());
    assertEquals(ClubReachStatus.ALREADY_PROCESSED, repeated.getStatus());
    assertSame(initialized.getState(), repeated.getState());
    assertTrue(initialized.getMetrics().getLocalSupporters() >= 40_000L);
    assertEquals(ReachLevel.NATIONAL, initialized.getMetrics().getLevel());
    assertFalse(initialized.getState().getModule(ClubReachService.MODULE_ID).isEmpty());
  }

  @Test
  void rewardsWinningFormAndPenalizesAWeakMonth() {
    ClubReachSnapshot january = snapshot(2026, 1, 1, 101, 60, 40_000, 0, 0, 0, 0);
    ModState baseline = this.service.evaluate(ModState.empty(), january).getState();

    ClubReachResult winning = this.service.evaluate(
        baseline,
        snapshot(2026, 2, 1, 101, 85, 40_000, 5, 4, 0, 0));
    ClubReachResult losing = this.service.evaluate(
        baseline,
        snapshot(2026, 2, 1, 101, 35, 40_000, 5, 1, 4, 0));

    assertTrue(winning.getLocalSupporterDelta() > losing.getLocalSupporterDelta());
    assertTrue(winning.getSocialFollowerDelta() > losing.getSocialFollowerDelta());
    assertTrue(winning.getGlobalReputationDelta() > losing.getGlobalReputationDelta());
    assertTrue(winning.getMetrics().getSentiment() > losing.getMetrics().getSentiment());

    ClubReachResult repeated = this.service.evaluate(winning.getState(), winning.getSnapshot());
    assertEquals(winning.getSocialFollowerDelta(), repeated.getSocialFollowerDelta());
    assertEquals(winning.getMonthlyMatches(), repeated.getMonthlyMatches());
    assertFalse(repeated.isStateChanged());
  }

  @Test
  void titlesAccelerateInternationalAndGlobalReach() {
    ClubReachSnapshot january = snapshot(2026, 1, 1, 101, 75, 40_000, 0, 0, 0, 0);
    ModState baseline = this.service.evaluate(ModState.empty(), january).getState();

    ClubReachResult regular = this.service.evaluate(
        baseline,
        snapshot(2026, 2, 1, 101, 75, 40_000, 6, 4, 1, 0));
    ClubReachResult champion = this.service.evaluate(
        baseline,
        snapshot(2026, 2, 1, 101, 75, 40_000, 6, 4, 1, 1));

    assertTrue(champion.getInternationalSupporterDelta()
        > regular.getInternationalSupporterDelta());
    assertTrue(champion.getGlobalReputationDelta() > regular.getGlobalReputationDelta());
    assertEquals(1, champion.getMonthlyTitles());
  }

  @Test
  void rebasesCountersWhenANewSeasonStarts() {
    ClubReachSnapshot finalMonth = snapshot(
        2026, 12, 1, 101, 70, 40_000, 30, 18, 7, 1);
    ModState previousSeason = this.service.evaluate(ModState.empty(), finalMonth).getState();

    ClubReachResult newSeason = this.service.evaluate(
        previousSeason,
        snapshot(2027, 1, 2, 101, 70, 40_000, 0, 0, 0, 0));

    assertEquals(ClubReachStatus.UPDATED, newSeason.getStatus());
    assertEquals(0, newSeason.getMonthlyMatches());
    assertEquals(0, newSeason.getMonthlyTitles());
  }

  @Test
  void keepsProfilesIsolatedByClub() {
    ClubReachResult first = this.service.evaluate(
        ModState.empty(), snapshot(2026, 1, 1, 101, 70, 40_000, 0, 0, 0, 0));
    ClubReachResult second = this.service.evaluate(
        first.getState(), snapshot(2026, 1, 1, 202, 70, 25_000, 0, 0, 0, 0));

    String module = second.getState().getModule(ClubReachService.MODULE_ID).toString();
    assertTrue(module.contains("club-101"));
    assertTrue(module.contains("club-202"));
  }

  @Test
  void repairsAnInvalidModuleProfileWithoutBreakingTheSidecar() {
    Map<String, Object> invalidProfile = new LinkedHashMap<String, Object>();
    invalidProfile.put("localSupporters", Long.valueOf(-1L));
    Map<String, Object> profiles = new LinkedHashMap<String, Object>();
    profiles.put("club-101", invalidProfile);
    Map<String, Object> module = new LinkedHashMap<String, Object>();
    module.put("profiles", profiles);
    ModState malformed = ModState.empty().withModule(ClubReachService.MODULE_ID, module);

    ClubReachResult repaired = this.service.evaluate(
        malformed, snapshot(2026, 1, 1, 101, 70, 40_000, 0, 0, 0, 0));

    assertEquals(ClubReachStatus.INITIALIZED, repaired.getStatus());
    assertTrue(repaired.getMetrics().getLocalSupporters() > 0L);
  }

  private ClubReachSnapshot snapshot(
      int year,
      int month,
      int season,
      int clubId,
      int fanApproval,
      int capacity,
      int matches,
      int wins,
      int losses,
      int titles) {
    return new ClubReachSnapshot(
        year,
        month,
        season,
        clubId,
        1,
        3,
        fanApproval,
        capacity,
        matches,
        wins,
        losses,
        titles);
  }
}
