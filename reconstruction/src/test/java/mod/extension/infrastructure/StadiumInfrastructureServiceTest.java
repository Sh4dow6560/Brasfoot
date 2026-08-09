package mod.extension.infrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class StadiumInfrastructureServiceTest {
  private final StadiumInfrastructureService service =
      new StadiumInfrastructureService();

  @Test
  void initializesADeterministicProfileWithoutChargingTheClub() {
    InfrastructureSnapshot snapshot = snapshot(2026, 1, 0, 100_000_000L, 40_000, 1);

    InfrastructureResult initialized = this.service.inspect(ModState.empty(), snapshot);
    InfrastructureResult repeated = this.service.inspect(initialized.getState(), snapshot);

    assertEquals(InfrastructureStatus.READY, initialized.getStatus());
    assertTrue(initialized.isStateChanged());
    assertFalse(repeated.isStateChanged());
    assertSame(initialized.getState(), repeated.getState());
    assertEquals(3, initialized.getProfile().getPitchLevel());
    assertEquals(76, initialized.getProfile().getPitchQuality());
    assertTrue(initialized.getProfile().getMonthlyMaintenance() > 0);
    assertEquals(0, initialized.getExpenseDue());
  }

  @Test
  void chargesMaintenanceAndProcessesEachMonthOnlyOnce() {
    InfrastructureResult initialized = this.service.inspect(
        ModState.empty(), snapshot(2026, 1, 0, 100_000_000L, 40_000, 1));
    InfrastructureSnapshot february =
        snapshot(2026, 2, 6, 100_000_000L, 40_000, 1);

    InfrastructureResult processed = this.service.processMonthly(
        initialized.getState(), february);
    InfrastructureResult repeated = this.service.processMonthly(
        processed.getState(), february);

    assertEquals(InfrastructureStatus.MONTHLY_PROCESSED, processed.getStatus());
    assertTrue(processed.isMaintenancePaid());
    assertEquals(processed.getProfile().getMonthlyMaintenance(), processed.getExpenseDue());
    assertEquals(3, processed.getHomeMatches());
    assertEquals(75, processed.getProfile().getPitchQuality());
    assertEquals(InfrastructureStatus.ALREADY_PROCESSED, repeated.getStatus());
    assertEquals(0, repeated.getExpenseDue());
    assertFalse(repeated.isStateChanged());
  }

  @Test
  void recordsMissedMaintenanceAndDegradesThePitchWithoutCreatingDebt() {
    InfrastructureResult initialized = this.service.inspect(
        ModState.empty(), snapshot(2026, 1, 0, 0L, 40_000, 1));

    InfrastructureResult result = this.service.processMonthly(
        initialized.getState(), snapshot(2026, 2, 6, 0L, 40_000, 1));

    assertEquals(InfrastructureStatus.MAINTENANCE_MISSED, result.getStatus());
    assertFalse(result.isMaintenancePaid());
    assertEquals(0, result.getExpenseDue());
    assertEquals(57, result.getProfile().getPitchQuality());
    assertEquals(1, result.getProfile().getMaintenanceFailures());
  }

  @Test
  void startsAndCompletesOneUpgradeAtATime() {
    InfrastructureSnapshot january =
        snapshot(2026, 1, 0, 100_000_000L, 40_000, 1);
    InfrastructureUpgradeOffer offer = this.service.quoteUpgrade(
        ModState.empty(), january, FacilityType.TRAINING);
    InfrastructureResult started = this.service.startUpgrade(
        ModState.empty(), january, FacilityType.TRAINING);

    assertEquals(InfrastructureStatus.UPGRADE_STARTED, started.getStatus());
    assertEquals(offer.getCost(), started.getExpenseDue());
    assertEquals(offer.getCompletionPeriod(),
        started.getActiveProject().getCompletionPeriod());
    assertEquals(offer.getCost(), started.getProfile().getTotalInvested());
    assertThrows(
        IllegalStateException.class,
        () -> this.service.quoteUpgrade(
            started.getState(), january, FacilityType.PITCH));

    InfrastructureResult completed = this.service.processMonthly(
        started.getState(),
        snapshot(
            offer.getCompletionPeriod() / 100,
            offer.getCompletionPeriod() % 100,
            0,
            100_000_000L - offer.getCost(),
            40_000,
            1));

    assertEquals(InfrastructureStatus.UPGRADE_COMPLETED, completed.getStatus());
    assertEquals(FacilityType.TRAINING, completed.getCompletedFacility());
    assertEquals(offer.getTargetLevel(), completed.getProfile().getTrainingLevel());
    assertNull(completed.getActiveProject());
  }

  @Test
  void rejectsAnUpgradeWhenCashIsInsufficient() {
    InfrastructureSnapshot snapshot = snapshot(2026, 1, 0, 1L, 40_000, 1);

    assertThrows(
        IllegalStateException.class,
        () -> this.service.startUpgrade(
            ModState.empty(), snapshot, FacilityType.PITCH));
  }

  @Test
  void repairsMalformedProfilesAndRecalculatesMaintenanceAfterExpansion() {
    Map<String, Object> invalidProfile = new LinkedHashMap<String, Object>();
    invalidProfile.put("pitchLevel", Long.valueOf(99L));
    Map<String, Object> profiles = new LinkedHashMap<String, Object>();
    profiles.put("club-101", invalidProfile);
    Map<String, Object> module = new LinkedHashMap<String, Object>();
    module.put("profiles", profiles);
    ModState malformed = ModState.empty().withModule(
        StadiumInfrastructureService.MODULE_ID, module);

    InfrastructureResult repaired = this.service.inspect(
        malformed, snapshot(2026, 1, 0, 10_000_000L, 40_000, 1));
    int originalMaintenance = repaired.getProfile().getMonthlyMaintenance();
    InfrastructureResult expanded = this.service.inspect(
        repaired.getState(), snapshot(2026, 1, 0, 10_000_000L, 80_000, 1));

    assertNotNull(repaired.getProfile());
    assertEquals(3, repaired.getProfile().getPitchLevel());
    assertTrue(expanded.getProfile().getMonthlyMaintenance() > originalMaintenance);
    assertTrue(expanded.isStateChanged());
  }

  private InfrastructureSnapshot snapshot(
      int year,
      int month,
      int matches,
      long cash,
      int capacity,
      int pitchCondition) {
    return new InfrastructureSnapshot(
        year,
        month,
        1,
        101,
        1,
        3,
        capacity,
        pitchCondition,
        matches,
        cash);
  }
}
