package mod.extension.infrastructure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class InfrastructureFormatterTest {
  @Test
  void rendersFacilityLevelsMaintenanceAndUpgradeTerms() {
    StadiumInfrastructureService service = new StadiumInfrastructureService();
    InfrastructureSnapshot snapshot = new InfrastructureSnapshot(
        2026, 1, 1, 101, 1, 3, 40_000, 1, 0, 100_000_000L);
    InfrastructureResult result = service.inspect(ModState.empty(), snapshot);
    InfrastructureUpgradeOffer offer = service.quoteUpgrade(
        result.getState(), snapshot, FacilityType.PITCH);

    String dashboard = InfrastructureFormatter.dashboard(
        "Clube Teste", "Estadio Teste", 40_000, 100_000_000L, result);
    String terms = InfrastructureFormatter.upgradeOffer(offer);

    assertTrue(dashboard.contains("Gramado: n\u00edvel 3/5"));
    assertTrue(dashboard.contains("qualidade 76/100"));
    assertTrue(dashboard.contains("Manuten\u00e7\u00e3o mensal"));
    assertTrue(terms.contains("N\u00edvel 3 -> 4"));
    assertTrue(terms.contains("Conclus\u00e3o prevista: 05/2026"));
  }
}
