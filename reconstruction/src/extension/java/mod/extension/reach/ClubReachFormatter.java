package mod.extension.reach;

import java.text.NumberFormat;
import java.util.Locale;

public final class ClubReachFormatter {
  private ClubReachFormatter() {
  }

  public static String dashboard(String clubName, ClubReachResult result) {
    if (clubName == null) {
      throw new NullPointerException("clubName");
    }
    if (result == null) {
      throw new NullPointerException("result");
    }
    if (result.getStatus() == ClubReachStatus.DISABLED || result.getMetrics() == null) {
      return clubName + "\nRecurso de torcida e alcance mundial desativado.";
    }

    ClubReachMetrics metrics = result.getMetrics();
    StringBuilder text = new StringBuilder();
    text.append(clubName).append('\n')
        .append("Reputacao mundial: ")
        .append(metrics.getGlobalReputation())
        .append("/1000 (")
        .append(levelLabel(metrics.getLevel()))
        .append(")")
        .append(signedSuffix(result.getGlobalReputationDelta()))
        .append('\n')
        .append("Torcida local: ")
        .append(number(metrics.getLocalSupporters()))
        .append(signedSuffix(result.getLocalSupporterDelta()))
        .append('\n')
        .append("Torcida internacional: ")
        .append(number(metrics.getInternationalSupporters()))
        .append(signedSuffix(result.getInternationalSupporterDelta()))
        .append('\n')
        .append("Seguidores nas redes: ")
        .append(number(metrics.getSocialFollowers()))
        .append(signedSuffix(result.getSocialFollowerDelta()))
        .append('\n')
        .append("Socios-torcedores: ")
        .append(number(metrics.getSupporterMembers()))
        .append(signedSuffix(result.getSupporterMemberDelta()))
        .append('\n')
        .append("Engajamento: ")
        .append(metrics.getEngagement())
        .append("% | Sentimento: ")
        .append(metrics.getSentiment())
        .append('%');
    if (result.getMonthlyMatches() > 0 || result.getMonthlyTitles() > 0) {
      text.append('\n')
          .append("Ultimo periodo: ")
          .append(result.getMonthlyWins())
          .append("V, ")
          .append(result.getMonthlyLosses())
          .append("D em ")
          .append(result.getMonthlyMatches())
          .append(" jogos");
      if (result.getMonthlyTitles() > 0) {
        text.append(" | Titulos: ").append(result.getMonthlyTitles());
      }
    }
    return text.toString();
  }

  static String levelLabel(ReachLevel level) {
    if (level == ReachLevel.LOCAL) {
      return "local";
    }
    if (level == ReachLevel.REGIONAL) {
      return "regional";
    }
    if (level == ReachLevel.NATIONAL) {
      return "nacional";
    }
    if (level == ReachLevel.CONTINENTAL) {
      return "continental";
    }
    return "mundial";
  }

  private static String signedSuffix(long value) {
    if (value == 0L) {
      return "";
    }
    return " (" + (value > 0L ? "+" : "") + number(value) + ")";
  }

  private static String number(long value) {
    return NumberFormat.getIntegerInstance(new Locale("pt", "BR")).format(value);
  }
}
