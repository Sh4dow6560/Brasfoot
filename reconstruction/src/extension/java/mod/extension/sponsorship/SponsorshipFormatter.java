package mod.extension.sponsorship;

import java.text.NumberFormat;
import java.util.Locale;

public final class SponsorshipFormatter {
  private SponsorshipFormatter() {
  }

  public static String offerLabel(SponsorOffer offer) {
    return offer.getSponsorName()
        + " | "
        + money(offer.getMonthlyPayment())
        + "/m\u00eas | "
        + offer.getDurationMonths()
        + " meses | luvas "
        + money(offer.getSigningBonus())
        + " | "
        + goalLabel(offer)
        + ": "
        + money(offer.getGoalBonus());
  }

  public static String contractMessage(SponsorContract contract) {
    SponsorOffer offer = contract.getOffer();
    return offer.getSponsorName()
        + " assinou por "
        + offer.getDurationMonths()
        + " meses. Parcela mensal: "
        + money(offer.getMonthlyPayment())
        + "; luvas: "
        + money(offer.getSigningBonus())
        + "; "
        + goalLabel(offer)
        + ": "
        + money(offer.getGoalBonus())
        + ".";
  }

  static String offerHtml(SponsorOffer offer) {
    return "<html><b>"
        + offer.getSponsorName()
        + "</b><br>Parcela: "
        + money(offer.getMonthlyPayment())
        + "/m\u00eas &nbsp; Dura\u00e7\u00e3o: "
        + offer.getDurationMonths()
        + " meses<br>Luvas: "
        + money(offer.getSigningBonus())
        + " &nbsp; "
        + goalLabel(offer)
        + ": "
        + money(offer.getGoalBonus())
        + "</html>";
  }

  public static String bonusMessage(SponsorContract contract, int amount) {
    return contract.getOffer().getSponsorName()
        + " pagou "
        + money(amount)
        + " pelo cumprimento da meta: "
        + goalLabel(contract.getOffer())
        + ".";
  }

  static String goalLabel(SponsorOffer offer) {
    if (offer.getGoal() == SponsorGoal.WIN_RATE) {
      return "b\u00f4nus por " + offer.getGoalTarget() + "% de vit\u00f3rias";
    }
    if (offer.getGoal() == SponsorGoal.SEASON_WINS) {
      return "b\u00f4nus por " + offer.getGoalTarget() + " vit\u00f3rias na temporada";
    }
    return "b\u00f4nus por t\u00edtulo";
  }

  static String money(long amount) {
    NumberFormat format = NumberFormat.getIntegerInstance(new Locale("pt", "BR"));
    format.setGroupingUsed(true);
    return "R$ " + format.format(amount);
  }
}
