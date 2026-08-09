package mod.extension.sponsorship;

import bf22.intermediary.C0799;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Calendar;
import mod.extension.state.Feature;
import mod.extension.state.ModRuntime;
import mod.recovered.core.GameConstants;
import mod.recovered.finance.ClubFinances;
import mod.recovered.game.CareerState;
import mod.recovered.manager.CoachSeasonRecord;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.save.GamePersistence;

public final class SponsorshipBridge {
  public static final int CONTRACT_MESSAGE_TITLE_INDEX = 37;
  public static final int CONTRACT_MESSAGE_BODY_INDEX = 92;
  public static final int BONUS_MESSAGE_TITLE_INDEX = 38;
  public static final int BONUS_MESSAGE_BODY_INDEX = 93;

  private SponsorshipBridge() {
  }

  public static boolean replaceLegacySeasonRevenue(Club club) {
    if (!ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS)
        || club == null || !Boolean.TRUE.equals(club.isUserControlled())) {
      return false;
    }
    try {
      Calendar date = GamePersistence.careerState.getCurrentDate();
      Coach coach = club.getCoach();
      ensureContract(
          club,
          coach,
          date.get(Calendar.YEAR),
          date.get(Calendar.MONTH) + 1,
          null);
      return true;
    } catch (RuntimeException exception) {
      System.err.println("Sponsorship season start failed: " + exception.getMessage());
      return false;
    }
  }

  public static int processMonthly(int year, int month) {
    if (!ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS)) {
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null || career.M() == null) {
      return 0;
    }

    int payments = 0;
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      if (!Boolean.TRUE.equals(coach.isUserControlled()) || club == null) {
        continue;
      }
      try {
        ensureContract(club, coach, year, month, null);
        SponsorshipResult result = ModRuntime.processSponsorshipMonth(
            snapshot(club, coach, year, month));
        if (result.getStatus() == SponsorshipStatus.PAYMENT_DUE) {
          club.credit(result.getTotalPayment(), 6);
          if (result.getGoalBonus() > 0) {
            new C0799(
                coach,
                BONUS_MESSAGE_TITLE_INDEX,
                BONUS_MESSAGE_BODY_INDEX,
                "",
                SponsorshipFormatter.bonusMessage(
                    result.getContract(), result.getGoalBonus()));
          }
          payments++;
        }
      } catch (RuntimeException exception) {
        System.err.println("Sponsorship payment failed: " + exception.getMessage());
      }
    }
    return payments;
  }

  public static int openOffersForUserClubs(Component parent) {
    CareerState career = GamePersistence.careerState;
    if (!ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS)
        || career == null || career.M() == null) {
      return 0;
    }
    Calendar date = career.getCurrentDate();
    int accepted = 0;
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      if (Boolean.TRUE.equals(coach.isUserControlled()) && club != null
          && ensureContract(
              club,
              coach,
              date.get(Calendar.YEAR),
              date.get(Calendar.MONTH) + 1,
              parent)) {
        accepted++;
      }
    }
    return accepted;
  }

  private static boolean ensureContract(
      Club club, Coach coach, int year, int month, Component parent) {
    SponsorshipSnapshot snapshot = snapshot(club, coach, year, month);
    SponsorshipTransition transition = ModRuntime.prepareSponsorshipSeason(snapshot);
    if (transition.isLegacyRevenueReplacementDue()) {
      replaceRecordedLegacyRevenue(club, snapshot.getBaseAnnualRevenue());
    }
    SponsorshipResult available = ModRuntime.ensureSponsorshipOffers(snapshot);
    if (available.getOffers().isEmpty() || GraphicsEnvironment.isHeadless()) {
      return false;
    }
    String selected = SponsorOfferDialog.choose(
        parent, club.getNome(), available.getOffers());
    if (selected == null) {
      return false;
    }
    SponsorshipResult activated = ModRuntime.acceptSponsorshipOffer(snapshot, selected);
    if (activated.getSigningBonus() > 0) {
      club.credit(activated.getSigningBonus(), 6);
    }
    new C0799(
        coach,
        CONTRACT_MESSAGE_TITLE_INDEX,
        CONTRACT_MESSAGE_BODY_INDEX,
        "",
        SponsorshipFormatter.contractMessage(activated.getContract()));
    return true;
  }

  private static void replaceRecordedLegacyRevenue(Club club, int expectedLegacyRevenue) {
    ClubFinances finances = club.getFinances();
    if (finances == null || expectedLegacyRevenue <= 0) {
      return;
    }
    int recorded = Math.max(0, finances.getSponsorshipRevenue());
    int replacement = Math.min(recorded, expectedLegacyRevenue);
    if (replacement > 0) {
      club.credit(-replacement, 6);
    }
  }

  private static SponsorshipSnapshot snapshot(
      Club club, Coach coach, int year, int month) {
    CoachSeasonRecord season = coach.getOrCreateSeasonRecord(club);
    return new SponsorshipSnapshot(
        year,
        month,
        GamePersistence.careerState.getSeasonNumber(),
        club.getClubId(),
        club.getDivisao(),
        club.getReputation(),
        baseAnnualRevenue(club.getDivisao()),
        season.getMatchCount(),
        season.getWinCount(),
        season.getTitleCount());
  }

  private static int baseAnnualRevenue(int division) {
    if (division >= 0 && division < GameConstants.sponsorshipRevenueByDivision.length) {
      return GameConstants.sponsorshipRevenueByDivision[division][0];
    }
    return 1_200_000;
  }
}
