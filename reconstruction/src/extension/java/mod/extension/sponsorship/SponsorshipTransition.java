package mod.extension.sponsorship;

import mod.extension.state.ModState;

public final class SponsorshipTransition {
  private final ModState state;
  private final boolean legacyRevenueReplacementDue;

  public SponsorshipTransition(ModState state, boolean legacyRevenueReplacementDue) {
    this.state = state;
    this.legacyRevenueReplacementDue = legacyRevenueReplacementDue;
  }

  public ModState getState() {
    return this.state;
  }

  public boolean isLegacyRevenueReplacementDue() {
    return this.legacyRevenueReplacementDue;
  }
}
