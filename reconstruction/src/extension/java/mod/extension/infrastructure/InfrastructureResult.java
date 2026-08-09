package mod.extension.infrastructure;

import mod.extension.state.ModState;

public final class InfrastructureResult {
  private final ModState state;
  private final InfrastructureStatus status;
  private final InfrastructureSnapshot snapshot;
  private final InfrastructureProfile profile;
  private final InfrastructureProject activeProject;
  private final FacilityType completedFacility;
  private final int expenseDue;
  private final int homeMatches;
  private final boolean maintenancePaid;
  private final boolean stateChanged;

  InfrastructureResult(
      ModState state,
      InfrastructureStatus status,
      InfrastructureSnapshot snapshot,
      InfrastructureProfile profile,
      InfrastructureProject activeProject,
      FacilityType completedFacility,
      int expenseDue,
      int homeMatches,
      boolean maintenancePaid,
      boolean stateChanged) {
    this.state = state;
    this.status = status;
    this.snapshot = snapshot;
    this.profile = profile;
    this.activeProject = activeProject;
    this.completedFacility = completedFacility;
    this.expenseDue = expenseDue;
    this.homeMatches = homeMatches;
    this.maintenancePaid = maintenancePaid;
    this.stateChanged = stateChanged;
  }

  public static InfrastructureResult disabled(
      ModState state, InfrastructureSnapshot snapshot) {
    return new InfrastructureResult(
        state,
        InfrastructureStatus.DISABLED,
        snapshot,
        null,
        null,
        null,
        0,
        0,
        false,
        false);
  }

  public ModState getState() {
    return this.state;
  }

  public InfrastructureStatus getStatus() {
    return this.status;
  }

  public InfrastructureSnapshot getSnapshot() {
    return this.snapshot;
  }

  public InfrastructureProfile getProfile() {
    return this.profile;
  }

  public InfrastructureProject getActiveProject() {
    return this.activeProject;
  }

  public FacilityType getCompletedFacility() {
    return this.completedFacility;
  }

  public int getExpenseDue() {
    return this.expenseDue;
  }

  public int getHomeMatches() {
    return this.homeMatches;
  }

  public boolean isMaintenancePaid() {
    return this.maintenancePaid;
  }

  public boolean isStateChanged() {
    return this.stateChanged;
  }
}
