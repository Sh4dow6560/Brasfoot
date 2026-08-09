package mod.extension.board;

public final class BoardReportFormatter {
  public static final int MESSAGE_TITLE_INDEX = 36;
  public static final int MESSAGE_BODY_INDEX = 91;

  private BoardReportFormatter() {
  }

  public static String format(BoardEvaluation evaluation, String formattedFinancialNet) {
    if (evaluation == null) {
      throw new NullPointerException("evaluation");
    }
    if (evaluation.getOutcome() == BoardOutcome.INITIALIZED) {
      return "Metas definidas: vit\u00f3rias m\u00ednimas de "
          + evaluation.getTargetWinRate()
          + "% e confian\u00e7a da torcida de "
          + evaluation.getTargetFanApproval()
          + "%. A situa\u00e7\u00e3o financeira deve permanecer equilibrada. Seguran\u00e7a: "
          + securityLabel(evaluation.getJobSecurity())
          + ".";
    }

    return "Resultado: "
        + outcomeLabel(evaluation.getOutcome())
        + ". Campanha: "
        + evaluation.getMonthlyWins()
        + "V, "
        + evaluation.getMonthlyLosses()
        + "D em "
        + evaluation.getMonthlyMatches()
        + " jogos ("
        + evaluation.getMonthlyWinRate()
        + "%, meta "
        + evaluation.getTargetWinRate()
        + "%). Saldo: "
        + formattedFinancialNet
        + ". Confian\u00e7a da diretoria: "
        + signed(evaluation.getApprovalDelta())
        + ". Seguran\u00e7a: "
        + securityLabel(evaluation.getJobSecurity())
        + ".";
  }

  private static String signed(int value) {
    return value > 0 ? "+" + value : Integer.toString(value);
  }

  private static String outcomeLabel(BoardOutcome outcome) {
    if (outcome == BoardOutcome.EXCEEDED) {
      return "metas superadas";
    }
    if (outcome == BoardOutcome.ON_TRACK) {
      return "dentro das metas";
    }
    if (outcome == BoardOutcome.AT_RISK) {
      return "aten\u00e7\u00e3o necess\u00e1ria";
    }
    if (outcome == BoardOutcome.FAILED) {
      return "metas n\u00e3o cumpridas";
    }
    if (outcome == BoardOutcome.UNCHANGED) {
      return "avalia\u00e7\u00e3o j\u00e1 realizada";
    }
    return outcome.name();
  }

  private static String securityLabel(JobSecurity security) {
    if (security == JobSecurity.SECURE) {
      return "seguro";
    }
    if (security == JobSecurity.STABLE) {
      return "est\u00e1vel";
    }
    if (security == JobSecurity.UNDER_PRESSURE) {
      return "sob press\u00e3o";
    }
    return "cr\u00edtica";
  }
}
