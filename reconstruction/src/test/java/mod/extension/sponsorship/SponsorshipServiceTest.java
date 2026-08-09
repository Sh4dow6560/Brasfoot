package mod.extension.sponsorship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class SponsorshipServiceTest {
  private final SponsorshipService service = new SponsorshipService();

  @Test
  void createsThreeDeterministicOffersOncePerSeason() {
    SponsorshipSnapshot snapshot = snapshot(2026, 1, 1, 101, 0, 0, 0);

    SponsorshipResult created = this.service.ensureOffers(ModState.empty(), snapshot);
    SponsorshipResult repeated = this.service.ensureOffers(created.getState(), snapshot);

    assertEquals(SponsorshipStatus.OFFERS_CREATED, created.getStatus());
    assertEquals(3, created.getOffers().size());
    assertEquals(SponsorshipStatus.OFFERS_AVAILABLE, repeated.getStatus());
    assertSame(created.getState(), repeated.getState());
    for (int index = 0; index < 3; index++) {
      assertEquals(
          created.getOffers().get(index).getId(),
          repeated.getOffers().get(index).getId());
    }
    assertNotEquals(
        created.getOffers().get(0).getSponsorName(),
        created.getOffers().get(1).getSponsorName());
  }

  @Test
  void requestsLegacyRevenueReplacementOnlyOncePerSeason() {
    SponsorshipSnapshot firstSeason = snapshot(2026, 1, 1, 101, 0, 0, 0);
    SponsorshipTransition initial = this.service.prepareSeason(
        ModState.empty(), firstSeason);
    SponsorshipTransition repeated = this.service.prepareSeason(
        initial.getState(), firstSeason);
    SponsorshipTransition nextSeason = this.service.prepareSeason(
        repeated.getState(), snapshot(2027, 1, 2, 101, 0, 0, 0));

    assertTrue(initial.isLegacyRevenueReplacementDue());
    assertFalse(repeated.isLegacyRevenueReplacementDue());
    assertSame(initial.getState(), repeated.getState());
    assertTrue(nextSeason.isLegacyRevenueReplacementDue());
  }

  @Test
  void activatesAContractAndPaysEachMonthOnlyOnce() {
    SponsorshipSnapshot january = snapshot(2026, 1, 1, 101, 0, 0, 0);
    SponsorshipResult offers = this.service.ensureOffers(ModState.empty(), january);
    SponsorOffer selected = offers.getOffers().get(0);
    SponsorshipResult activated = this.service.acceptOffer(
        offers.getState(), january, selected.getId());

    SponsorshipResult payment = this.service.processMonthly(
        activated.getState(), january);
    SponsorshipResult duplicate = this.service.processMonthly(
        payment.getState(), january);

    assertEquals(SponsorshipStatus.CONTRACT_ACTIVATED, activated.getStatus());
    assertTrue(activated.isFirstContract());
    assertEquals(selected.getSigningBonus(), activated.getSigningBonus());
    assertEquals(202612, activated.getContract().getEndPeriod());
    assertEquals(SponsorshipStatus.PAYMENT_DUE, payment.getStatus());
    assertEquals(selected.getMonthlyPayment(), payment.getMonthlyPayment());
    assertEquals(0, payment.getGoalBonus());
    assertEquals(SponsorshipStatus.ALREADY_PROCESSED, duplicate.getStatus());
    assertFalse(duplicate.isStateChanged());
    assertSame(payment.getState(), duplicate.getState());
  }

  @Test
  void paysPerformanceBonusOnlyOnceInTheSameSeason() {
    SponsorshipSnapshot january = snapshot(2026, 1, 1, 101, 0, 0, 0);
    SponsorshipResult offers = this.service.ensureOffers(ModState.empty(), january);
    SponsorOffer selected = offers.getOffers().get(2);
    SponsorshipResult activated = this.service.acceptOffer(
        offers.getState(), january, selected.getId());

    SponsorshipResult first = this.service.processMonthly(
        activated.getState(), snapshot(2026, 1, 1, 101, 8, 5, 1));
    SponsorshipResult second = this.service.processMonthly(
        first.getState(), snapshot(2026, 2, 1, 101, 10, 6, 1));
    SponsorshipResult nextSeasonBaseline = this.service.processMonthly(
        second.getState(), snapshot(2027, 1, 2, 101, 0, 0, 0));
    SponsorshipResult nextSeason = this.service.processMonthly(
        nextSeasonBaseline.getState(), snapshot(2027, 2, 2, 101, 5, 3, 1));

    assertEquals(selected.getGoalBonus(), first.getGoalBonus());
    assertEquals(0, second.getGoalBonus());
    assertEquals(0, nextSeasonBaseline.getGoalBonus());
    assertEquals(selected.getGoalBonus(), nextSeason.getGoalBonus());
  }

  @Test
  void doesNotRewardResultsCompletedBeforeTheContractWasSigned() {
    SponsorshipSnapshot signedAfterTitle = snapshot(2026, 6, 1, 101, 20, 12, 1);
    SponsorshipResult offers = this.service.ensureOffers(
        ModState.empty(), signedAfterTitle);
    SponsorOffer titleOffer = offers.getOffers().get(2);
    SponsorshipResult activated = this.service.acceptOffer(
        offers.getState(), signedAfterTitle, titleOffer.getId());

    SponsorshipResult firstPayment = this.service.processMonthly(
        activated.getState(), signedAfterTitle);
    SponsorshipResult titleAfterSigning = this.service.processMonthly(
        firstPayment.getState(), snapshot(2026, 7, 1, 101, 24, 14, 2));

    assertEquals(0, firstPayment.getGoalBonus());
    assertEquals(titleOffer.getGoalBonus(), titleAfterSigning.getGoalBonus());
  }

  @Test
  void evaluatesWinRateAndSeasonWinGoalsAfterTheirBaselines() {
    SponsorshipSnapshot start = snapshot(2026, 1, 1, 101, 10, 6, 0);
    SponsorshipResult winRateOffers = this.service.ensureOffers(ModState.empty(), start);
    SponsorOffer winRateOffer = winRateOffers.getOffers().get(0);
    SponsorshipResult winRateContract = this.service.acceptOffer(
        winRateOffers.getState(), start, winRateOffer.getId());
    SponsorshipResult winRatePayment = this.service.processMonthly(
        winRateContract.getState(), snapshot(2026, 2, 1, 101, 15, 9, 0));

    SponsorshipResult winsOffers = this.service.ensureOffers(
        ModState.empty(), snapshot(2026, 1, 1, 202, 0, 0, 0));
    SponsorOffer winsOffer = winsOffers.getOffers().get(1);
    SponsorshipResult winsContract = this.service.acceptOffer(
        winsOffers.getState(),
        snapshot(2026, 1, 1, 202, 0, 0, 0),
        winsOffer.getId());
    SponsorshipResult winsPayment = this.service.processMonthly(
        winsContract.getState(),
        snapshot(2026, 2, 1, 202, 25, winsOffer.getGoalTarget(), 0));

    assertEquals(winRateOffer.getGoalBonus(), winRatePayment.getGoalBonus());
    assertEquals(winsOffer.getGoalBonus(), winsPayment.getGoalBonus());
  }

  @Test
  void expiresTheContractAndCreatesANewOfferRound() {
    SponsorshipSnapshot january = snapshot(2026, 1, 1, 101, 0, 0, 0);
    SponsorshipResult offers = this.service.ensureOffers(ModState.empty(), january);
    SponsorshipResult activated = this.service.acceptOffer(
        offers.getState(), january, offers.getOffers().get(0).getId());

    SponsorshipResult expired = this.service.ensureOffers(
        activated.getState(), snapshot(2027, 1, 2, 101, 0, 0, 0));

    assertEquals(SponsorshipStatus.CONTRACT_EXPIRED, expired.getStatus());
    assertEquals(3, expired.getOffers().size());
    assertTrue(expired.isStateChanged());
    assertNotEquals(offers.getOffers().get(0).getId(), expired.getOffers().get(0).getId());
    SponsorshipResult renewed = this.service.acceptOffer(
        expired.getState(),
        snapshot(2027, 1, 2, 101, 0, 0, 0),
        expired.getOffers().get(0).getId());
    assertFalse(renewed.isFirstContract());
  }

  @Test
  void keepsContractsIsolatedByClub() {
    SponsorshipSnapshot firstClub = snapshot(2026, 1, 1, 101, 0, 0, 0);
    SponsorshipResult firstOffers = this.service.ensureOffers(ModState.empty(), firstClub);
    SponsorshipResult firstContract = this.service.acceptOffer(
        firstOffers.getState(), firstClub, firstOffers.getOffers().get(0).getId());

    SponsorshipSnapshot secondClub = snapshot(2026, 1, 1, 202, 0, 0, 0);
    SponsorshipResult secondOffers = this.service.ensureOffers(
        firstContract.getState(), secondClub);

    assertEquals(3, secondOffers.getOffers().size());
    assertTrue(secondOffers.getState().getModule(SponsorshipService.MODULE_ID)
        .toString().contains("club-101"));
    assertTrue(secondOffers.getState().getModule(SponsorshipService.MODULE_ID)
        .toString().contains("club-202"));
  }

  @Test
  void rejectsAnOfferThatIsNotInThePendingRound() {
    SponsorshipSnapshot snapshot = snapshot(2026, 1, 1, 101, 0, 0, 0);
    assertThrows(
        IllegalArgumentException.class,
        () -> this.service.acceptOffer(ModState.empty(), snapshot, "missing"));
  }

  @Test
  void rejectsAClubWithoutAStableIdentifier() {
    assertThrows(
        IllegalArgumentException.class,
        () -> snapshot(2026, 1, 1, -1, 0, 0, 0));
  }

  @Test
  void rejectsUnsafeContractAmounts() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new SponsorOffer(
            "unsafe", "Sponsor", 12, 0, 1_000_000_001,
            SponsorGoal.TITLE, 1, 0));
  }

  @Test
  void formatsOfferTermsForTheSelectionDialog() {
    List<SponsorOffer> offers = this.service.ensureOffers(
        ModState.empty(), snapshot(2026, 1, 1, 101, 0, 0, 0)).getOffers();

    String label = SponsorshipFormatter.offerLabel(offers.get(0));

    assertTrue(label.contains("/m\u00eas"));
    assertTrue(label.contains("12 meses"));
    assertTrue(label.contains("luvas"));
    assertTrue(label.contains("b\u00f4nus"));
  }

  private SponsorshipSnapshot snapshot(
      int year,
      int month,
      int season,
      int clubId,
      int matches,
      int wins,
      int titles) {
    return new SponsorshipSnapshot(
        year,
        month,
        season,
        clubId,
        1,
        3,
        6_000_000,
        matches,
        wins,
        titles);
  }
}
