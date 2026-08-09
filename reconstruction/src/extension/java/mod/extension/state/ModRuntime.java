package mod.extension.state;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import mod.extension.board.BoardEvaluation;
import mod.extension.board.BoardObjectivesService;
import mod.extension.board.BoardSnapshot;
import mod.extension.infrastructure.FacilityType;
import mod.extension.infrastructure.InfrastructureResult;
import mod.extension.infrastructure.InfrastructureSnapshot;
import mod.extension.infrastructure.InfrastructureUpgradeOffer;
import mod.extension.infrastructure.StadiumInfrastructureService;
import mod.extension.negotiation.AdvancedNegotiationService;
import mod.extension.negotiation.LoanAgreement;
import mod.extension.negotiation.LoanTerms;
import mod.extension.negotiation.NegotiationMonthResult;
import mod.extension.negotiation.NegotiationRegistration;
import mod.extension.negotiation.PurchaseTerms;
import mod.extension.negotiation.PurchaseAgreement;
import mod.extension.reach.ClubReachResult;
import mod.extension.reach.ClubReachService;
import mod.extension.reach.ClubReachSnapshot;
import mod.extension.sponsorship.SponsorshipResult;
import mod.extension.sponsorship.SponsorshipService;
import mod.extension.sponsorship.SponsorshipSnapshot;
import mod.extension.sponsorship.SponsorshipTransition;

public final class ModRuntime {
  private static final ModStateStore STORE = new ModStateStore();
  private static final BoardObjectivesService BOARD_OBJECTIVES =
      new BoardObjectivesService();
  private static final SponsorshipService SPONSORSHIPS =
      new SponsorshipService();
  private static final ClubReachService CLUB_REACH = new ClubReachService();
  private static final StadiumInfrastructureService STADIUM_INFRASTRUCTURE =
      new StadiumInfrastructureService();
  private static final AdvancedNegotiationService ADVANCED_NEGOTIATIONS =
      new AdvancedNegotiationService();

  private static ModState state = ModState.empty();
  private static FeatureRegistry features = FeatureRegistry.from(state);
  private static ModStateStore.LoadResult baseline;
  private static Path currentSave;
  private static String warning;

  private ModRuntime() {
  }

  public static synchronized void startNewCareer() {
    state = ModState.empty();
    features = FeatureRegistry.from(state);
    baseline = null;
    currentSave = null;
    warning = null;
  }

  public static synchronized ModStateStore.LoadStatus attach(Path saveFile)
      throws IOException {
    ModStateStore.LoadResult loaded = STORE.load(saveFile);
    state = loaded.getState();
    features = FeatureRegistry.from(state);
    baseline = loaded;
    currentSave = normalize(saveFile);
    warning = loaded.getWarning();
    return loaded.getStatus();
  }

  public static synchronized boolean persist(Path saveFile) throws IOException {
    Path target = normalize(saveFile);
    ModStateStore.LoadResult targetBaseline;
    if (baseline != null && target.equals(currentSave)) {
      targetBaseline = baseline;
    } else {
      targetBaseline = STORE.load(target);
    }
    if (!targetBaseline.isWritable()) {
      warning = targetBaseline.getWarning() == null
          ? "Mod state sidecar is not writable" : targetBaseline.getWarning();
      return false;
    }

    ModState rebased = state.atRevision(targetBaseline.getState().getRevision());
    ModStateStore.LoadResult saved = STORE.save(target, targetBaseline, rebased);
    state = saved.getState();
    features = FeatureRegistry.from(state);
    baseline = saved;
    currentSave = target;
    warning = null;
    return true;
  }

  public static synchronized boolean isFeatureEnabled(Feature feature) {
    return features.isEnabled(feature);
  }

  public static synchronized void setFeatureEnabled(Feature feature, boolean enabled) {
    features.setEnabled(feature, enabled);
    state = features.applyTo(state);
  }

  public static synchronized BoardEvaluation evaluateBoardObjectives(
      BoardSnapshot snapshot) {
    if (!features.isEnabled(Feature.BOARD_OBJECTIVES)) {
      return BoardEvaluation.disabled(state, snapshot);
    }
    BoardEvaluation evaluation = BOARD_OBJECTIVES.evaluate(state, snapshot);
    state = evaluation.getState();
    features = FeatureRegistry.from(state);
    return evaluation;
  }

  public static synchronized SponsorshipResult ensureSponsorshipOffers(
      SponsorshipSnapshot snapshot) {
    if (!features.isEnabled(Feature.SPONSORSHIPS)) {
      return SponsorshipResult.disabled(state);
    }
    SponsorshipResult result = SPONSORSHIPS.ensureOffers(state, snapshot);
    applySponsorshipResult(result);
    return result;
  }

  public static synchronized SponsorshipTransition prepareSponsorshipSeason(
      SponsorshipSnapshot snapshot) {
    if (!features.isEnabled(Feature.SPONSORSHIPS)) {
      return new SponsorshipTransition(state, false);
    }
    SponsorshipTransition transition = SPONSORSHIPS.prepareSeason(state, snapshot);
    state = transition.getState();
    features = FeatureRegistry.from(state);
    return transition;
  }

  public static synchronized SponsorshipResult acceptSponsorshipOffer(
      SponsorshipSnapshot snapshot, String offerId) {
    if (!features.isEnabled(Feature.SPONSORSHIPS)) {
      return SponsorshipResult.disabled(state);
    }
    SponsorshipResult result = SPONSORSHIPS.acceptOffer(state, snapshot, offerId);
    applySponsorshipResult(result);
    return result;
  }

  public static synchronized SponsorshipResult processSponsorshipMonth(
      SponsorshipSnapshot snapshot) {
    if (!features.isEnabled(Feature.SPONSORSHIPS)) {
      return SponsorshipResult.disabled(state);
    }
    SponsorshipResult result = SPONSORSHIPS.processMonthly(state, snapshot);
    applySponsorshipResult(result);
    return result;
  }

  public static synchronized ClubReachResult evaluateClubReach(
      ClubReachSnapshot snapshot) {
    if (!features.isEnabled(Feature.CLUB_REACH)) {
      return ClubReachResult.disabled(state, snapshot);
    }
    ClubReachResult result = CLUB_REACH.evaluate(state, snapshot);
    state = result.getState();
    features = FeatureRegistry.from(state);
    return result;
  }

  public static synchronized InfrastructureResult inspectInfrastructure(
      InfrastructureSnapshot snapshot) {
    if (!features.isEnabled(Feature.STADIUM_INFRASTRUCTURE)) {
      return InfrastructureResult.disabled(state, snapshot);
    }
    InfrastructureResult result = STADIUM_INFRASTRUCTURE.inspect(state, snapshot);
    applyInfrastructureResult(result);
    return result;
  }

  public static synchronized InfrastructureResult processInfrastructureMonth(
      InfrastructureSnapshot snapshot) {
    if (!features.isEnabled(Feature.STADIUM_INFRASTRUCTURE)) {
      return InfrastructureResult.disabled(state, snapshot);
    }
    InfrastructureResult result =
        STADIUM_INFRASTRUCTURE.processMonthly(state, snapshot);
    applyInfrastructureResult(result);
    return result;
  }

  public static synchronized InfrastructureUpgradeOffer quoteInfrastructureUpgrade(
      InfrastructureSnapshot snapshot, FacilityType facilityType) {
    if (!features.isEnabled(Feature.STADIUM_INFRASTRUCTURE)) {
      return null;
    }
    return STADIUM_INFRASTRUCTURE.quoteUpgrade(state, snapshot, facilityType);
  }

  public static synchronized InfrastructureResult startInfrastructureUpgrade(
      InfrastructureSnapshot snapshot, FacilityType facilityType) {
    if (!features.isEnabled(Feature.STADIUM_INFRASTRUCTURE)) {
      return InfrastructureResult.disabled(state, snapshot);
    }
    InfrastructureResult result =
        STADIUM_INFRASTRUCTURE.startUpgrade(state, snapshot, facilityType);
    applyInfrastructureResult(result);
    return result;
  }

  public static synchronized NegotiationRegistration registerPurchaseAgreement(
      int period,
      int playerId,
      String playerName,
      int sellerClubId,
      int buyerClubId,
      PurchaseTerms terms) {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return NegotiationRegistration.disabled(state);
    }
    NegotiationRegistration result = ADVANCED_NEGOTIATIONS.registerPurchase(
        state,
        period,
        playerId,
        playerName,
        sellerClubId,
        buyerClubId,
        terms);
    applyNegotiationState(result.getState());
    return result;
  }

  public static synchronized NegotiationRegistration registerLoanAgreement(
      int period,
      int playerId,
      String playerName,
      int originalClubId,
      int borrowerClubId,
      int playerSalary,
      LoanTerms terms) {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return NegotiationRegistration.disabled(state);
    }
    NegotiationRegistration result = ADVANCED_NEGOTIATIONS.registerLoan(
        state,
        period,
        playerId,
        playerName,
        originalClubId,
        borrowerClubId,
        playerSalary,
        terms);
    applyNegotiationState(result.getState());
    return result;
  }

  public static synchronized NegotiationMonthResult processNegotiationMonth(
      int period) {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return NegotiationMonthResult.disabled(state);
    }
    NegotiationMonthResult result =
        ADVANCED_NEGOTIATIONS.processMonthly(state, period);
    applyNegotiationState(result.getState());
    return result;
  }

  public static synchronized LoanAgreement findLoanAgreement(int playerId) {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return null;
    }
    return ADVANCED_NEGOTIATIONS.findLoanAgreement(state, playerId);
  }

  public static synchronized List<PurchaseAgreement> getPurchaseAgreements() {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return Collections.emptyList();
    }
    return ADVANCED_NEGOTIATIONS.getPurchaseAgreements(state);
  }

  public static synchronized List<LoanAgreement> getLoanAgreements() {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return Collections.emptyList();
    }
    return ADVANCED_NEGOTIATIONS.getLoanAgreements(state);
  }

  public static synchronized NegotiationRegistration closeLoanAgreement(
      int period, int playerId, String reason) {
    if (!features.isEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return NegotiationRegistration.disabled(state);
    }
    NegotiationRegistration result =
        ADVANCED_NEGOTIATIONS.closeLoan(state, period, playerId, reason);
    applyNegotiationState(result.getState());
    return result;
  }

  public static synchronized ModState getState() {
    return state;
  }

  public static synchronized FeatureRegistry getFeatures() {
    return new FeatureRegistry(features.snapshot());
  }

  public static synchronized String getWarning() {
    return warning;
  }

  private static void applySponsorshipResult(SponsorshipResult result) {
    state = result.getState();
    features = FeatureRegistry.from(state);
  }

  private static void applyInfrastructureResult(InfrastructureResult result) {
    state = result.getState();
    features = FeatureRegistry.from(state);
  }

  private static void applyNegotiationState(ModState updated) {
    state = updated;
    features = FeatureRegistry.from(state);
  }

  private static Path normalize(Path path) {
    if (path == null) {
      throw new NullPointerException("saveFile");
    }
    return path.toAbsolutePath().normalize();
  }
}
