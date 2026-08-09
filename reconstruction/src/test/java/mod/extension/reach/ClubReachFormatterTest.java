package mod.extension.reach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class ClubReachFormatterTest {
  @Test
  void formatsTheDashboardWithAudienceAndMonthlyChanges() {
    ClubReachService service = new ClubReachService();
    ClubReachSnapshot january = snapshot(2026, 1, 0, 0, 0, 0);
    ClubReachResult initialized = service.evaluate(ModState.empty(), january);
    ClubReachResult updated = service.evaluate(
        initialized.getState(), snapshot(2026, 2, 5, 4, 0, 1));

    String dashboard = ClubReachFormatter.dashboard("Clube Teste", updated);

    assertTrue(dashboard.contains("Clube Teste"));
    assertTrue(dashboard.contains("Reputacao mundial"));
    assertTrue(dashboard.contains("Torcida internacional"));
    assertTrue(dashboard.contains("Seguidores nas redes"));
    assertTrue(dashboard.contains("Socios-torcedores"));
    assertTrue(dashboard.contains("4V, 0D em 5 jogos"));
    assertTrue(dashboard.contains("Titulos: 1"));
  }

  private ClubReachSnapshot snapshot(
      int year, int month, int matches, int wins, int losses, int titles) {
    return new ClubReachSnapshot(
        year, month, 1, 101, 1, 3, 80, 40_000,
        matches, wins, losses, titles);
  }
}
