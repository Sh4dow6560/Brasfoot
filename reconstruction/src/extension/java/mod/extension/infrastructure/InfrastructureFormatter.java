package mod.extension.infrastructure;

import java.text.NumberFormat;
import java.util.Locale;

public final class InfrastructureFormatter {
  private InfrastructureFormatter() {
  }

  public static String dashboard(
      String clubName,
      String stadiumName,
      int capacity,
      long cashBalance,
      InfrastructureResult result) {
    if (clubName == null || stadiumName == null || result == null) {
      throw new NullPointerException("Infrastructure dashboard value");
    }
    if (result.getStatus() == InfrastructureStatus.DISABLED
        || result.getProfile() == null) {
      return clubName + "\nRecurso de est\u00e1dio e infraestrutura desativado.";
    }

    InfrastructureProfile profile = result.getProfile();
    StringBuilder text = new StringBuilder();
    text.append(clubName).append('\n')
        .append(stadiumName).append(" | ")
        .append(number(capacity)).append(" lugares\n\n")
        .append("Gramado: n\u00edvel ").append(profile.getPitchLevel())
        .append("/5 | qualidade ").append(profile.getPitchQuality())
        .append("/100 (").append(pitchLabel(profile.getPitchQuality())).append(")\n")
        .append("Centro de treinamento: n\u00edvel ")
        .append(profile.getTrainingLevel()).append("/5\n")
        .append("Departamento m\u00e9dico: n\u00edvel ")
        .append(profile.getMedicalLevel()).append("/5\n")
        .append("Categorias de base: n\u00edvel ")
        .append(profile.getYouthLevel()).append("/5\n")
        .append("Estrutura comercial: n\u00edvel ")
        .append(profile.getCommercialLevel()).append("/5\n\n")
        .append("Manuten\u00e7\u00e3o mensal: ")
        .append(money(profile.getMonthlyMaintenance())).append('\n')
        .append("Caixa dispon\u00edvel: ").append(money(cashBalance));

    InfrastructureProject project = result.getActiveProject();
    if (project != null) {
      text.append("\n\nObra em andamento: ")
          .append(project.getFacilityType().getLabel())
          .append(" para o n\u00edvel ").append(project.getTargetLevel())
          .append("\nConclus\u00e3o prevista: ")
          .append(period(project.getCompletionPeriod()));
    }
    if (profile.getMaintenanceFailures() > 0) {
      text.append("\nManuten\u00e7\u00f5es n\u00e3o pagas: ")
          .append(profile.getMaintenanceFailures());
    }
    return text.toString();
  }

  public static String upgradeOffer(InfrastructureUpgradeOffer offer) {
    if (offer == null) {
      throw new NullPointerException("offer");
    }
    return offer.getFacilityType().getLabel()
        + "\nN\u00edvel " + offer.getCurrentLevel() + " -> " + offer.getTargetLevel()
        + "\nInvestimento: " + money(offer.getCost())
        + "\nPrazo: " + offer.getDurationMonths() + " meses"
        + "\nConclus\u00e3o prevista: " + period(offer.getCompletionPeriod());
  }

  static String pitchLabel(int quality) {
    if (quality >= 85) {
      return "excelente";
    }
    if (quality >= 65) {
      return "bom";
    }
    if (quality >= 45) {
      return "regular";
    }
    return "ruim";
  }

  static String period(int period) {
    int year = period / 100;
    int month = period % 100;
    return (month < 10 ? "0" : "") + month + "/" + year;
  }

  private static String money(long amount) {
    return "R$ " + number(amount);
  }

  private static String number(long value) {
    return NumberFormat.getIntegerInstance(new Locale("pt", "BR")).format(value);
  }
}
