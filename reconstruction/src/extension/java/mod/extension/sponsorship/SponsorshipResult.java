package mod.extension.sponsorship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mod.extension.state.ModState;

public final class SponsorshipResult {
  private final ModState state;
  private final SponsorshipStatus status;
  private final List<SponsorOffer> offers;
  private final SponsorContract contract;
  private final int signingBonus;
  private final int monthlyPayment;
  private final int goalBonus;
  private final boolean firstContract;
  private final boolean stateChanged;

  SponsorshipResult(
      ModState state,
      SponsorshipStatus status,
      List<SponsorOffer> offers,
      SponsorContract contract,
      int signingBonus,
      int monthlyPayment,
      int goalBonus,
      boolean firstContract,
      boolean stateChanged) {
    this.state = state;
    this.status = status;
    this.offers = Collections.unmodifiableList(new ArrayList<SponsorOffer>(offers));
    this.contract = contract;
    this.signingBonus = signingBonus;
    this.monthlyPayment = monthlyPayment;
    this.goalBonus = goalBonus;
    this.firstContract = firstContract;
    this.stateChanged = stateChanged;
  }

  public static SponsorshipResult disabled(ModState state) {
    return new SponsorshipResult(
        state,
        SponsorshipStatus.DISABLED,
        Collections.<SponsorOffer>emptyList(),
        null,
        0,
        0,
        0,
        false,
        false);
  }

  public ModState getState() {
    return this.state;
  }

  public SponsorshipStatus getStatus() {
    return this.status;
  }

  public List<SponsorOffer> getOffers() {
    return this.offers;
  }

  public SponsorContract getContract() {
    return this.contract;
  }

  public int getSigningBonus() {
    return this.signingBonus;
  }

  public int getMonthlyPayment() {
    return this.monthlyPayment;
  }

  public int getGoalBonus() {
    return this.goalBonus;
  }

  public boolean isFirstContract() {
    return this.firstContract;
  }

  public int getTotalPayment() {
    return Math.addExact(this.monthlyPayment, this.goalBonus);
  }

  public boolean isStateChanged() {
    return this.stateChanged;
  }
}
