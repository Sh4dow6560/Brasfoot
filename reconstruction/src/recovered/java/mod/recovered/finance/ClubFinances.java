package mod.recovered.finance;

import java.io.Serializable;
import mod.recovered.model.Club;

public class ClubFinances implements Serializable {
   private static final long serialVersionUID = 1L;
   private long legacyBalance;
   private int ticketRevenue;
   private int prizeRevenue;
   private long playerSaleRevenue;
   private int sponsorshipRevenue;
   private int otherRevenue;
   private int stadiumExpenses;
   private long playerPurchaseExpenses;
   private long salaryExpenses;
   private int loanInterestExpenses;
   private int miscellaneousExpenses;
   private int contractTerminationExpenses;
   private int outstandingLoanPrincipal;
   private int monthlyLoanInterest;
   private static String[] compactAmountSuffixes = new String[]{" mil", "M", "B", "T"};

   public static void ey() {
   }

   public long getTotalRevenue() {
      return this.ticketRevenue
         + this.prizeRevenue
         + this.playerSaleRevenue
         + this.sponsorshipRevenue
         + this.otherRevenue;
   }

   public void resetPeriodTotals() {
      this.ticketRevenue = 0;
      this.playerSaleRevenue = 0L;
      this.prizeRevenue = 0;
      this.sponsorshipRevenue = 0;
      this.stadiumExpenses = 0;
      this.salaryExpenses = 0L;
      this.loanInterestExpenses = 0;
      this.miscellaneousExpenses = 0;
      this.contractTerminationExpenses = 0;
      this.playerPurchaseExpenses = 0L;
   }

   public long getTotalExpenses() {
      return this.stadiumExpenses
         + this.playerPurchaseExpenses
         + this.salaryExpenses
         + this.loanInterestExpenses
         + this.miscellaneousExpenses
         + this.contractTerminationExpenses;
   }

   public long getNetResult() {
      long totalRevenue = this.getTotalRevenue();
      long totalExpenses = this.getTotalExpenses();
      return totalRevenue - totalExpenses;
   }

   public void recordRevenue(int amount, int category) {
      if (category == 1) {
         this.playerSaleRevenue += amount;
      } else if (category == 3) {
         this.prizeRevenue += amount;
      } else if (category == 5) {
         this.ticketRevenue += amount;
      } else if (category == 6) {
         this.sponsorshipRevenue += amount;
      } else if (category == 9) {
         this.otherRevenue += amount;
      }
   }

   public void recordSalaryExpense(long amount) {
      this.salaryExpenses += amount;
   }

   public void recordExpense(int amount, int category) {
      if (category == 1) {
         this.playerPurchaseExpenses += amount;
      } else if (category == 4) {
         this.loanInterestExpenses += amount;
      } else if (category == 7) {
         this.stadiumExpenses += amount;
      } else if (category == 8) {
         this.contractTerminationExpenses += amount;
      } else {
         this.miscellaneousExpenses += amount;
      }
   }

   public static String formatAmount(long amount) {
      String digits = String.valueOf(amount);
      String[] units = new String[]{
         "mil",
         "milh\u00e3o",
         "milh\u00f5es",
         "bilh\u00e3o",
         "bilh\u00f5es"
      };
      String majorPart = "";
      String minorPart = "";
      if (amount < 0L) {
         return "-" + formatAmount(Math.abs(amount));
      }

      if (amount == 0L) {
         return "0 " + units[0];
      }

      if (amount <= 999L) {
         return digits;
      }

      if (amount <= 9999L) {
         return digits.substring(0, 1) + " " + units[0];
      }

      if (amount <= 99999L) {
         return digits.substring(0, 2) + " " + units[0];
      }

      if (amount <= 999999L) {
         return digits.substring(0, 3) + " " + units[0];
      }

      if (amount <= 1999999L) {
         majorPart = digits.substring(0, 1) + " " + units[1];
         minorPart = digits.substring(1, 4) + " " + units[0];
      } else if (amount <= 9999999L) {
         majorPart = digits.substring(0, 1) + " " + units[2];
         minorPart = digits.substring(1, 4) + " " + units[0];
      } else if (amount <= 99999999L) {
         majorPart = digits.substring(0, 2) + " " + units[2];
         minorPart = digits.substring(2, 5) + " " + units[0];
      } else if (amount <= 999999999L) {
         majorPart = digits.substring(0, 3) + " " + units[2];
         minorPart = digits.substring(3, 6) + " " + units[0];
      } else if (amount <= 1999999999L) {
         majorPart = digits.substring(0, 1) + " " + units[3];
         minorPart = digits.substring(1, 4) + " " + units[2];
      } else if (amount <= 9999999999L) {
         majorPart = digits.substring(0, 1) + " " + units[4];
         minorPart = digits.substring(1, 4) + " " + units[2];
      } else {
         if (amount > 99999999999L) {
            return formatCompactAmount(amount, 0);
         }

         majorPart = digits.substring(0, 2) + " " + units[4];
         minorPart = digits.substring(2, 5) + " " + units[2];
      }

      if (minorPart.length() >= 3 && minorPart.substring(0, 3).equals("000")) {
         minorPart = "";
      }

      if (minorPart.length() >= 3 && minorPart.substring(0, 2).equals("00")) {
         minorPart = minorPart.substring(2, 3) + " " + units[0];
      }

      if (minorPart.length() >= 3 && minorPart.substring(0, 1).equals("0")) {
         minorPart = minorPart.substring(1, 3) + " " + units[0];
      }

      return majorPart + " " + minorPart;
   }

   public static String U(int i) {
      return null;
   }

   public static String formatCompactAmount(double amount, int suffixIndex) {
      double scaled = (long)amount / 100L / 10.0;
      boolean wholeNumber = scaled * 10.0 % 10.0 == 0.0;
      return scaled < 1000.0
         ? (!(scaled > 99.9) && !wholeNumber && (wholeNumber || !(scaled > 9.99))
               ? String.valueOf(scaled)
               : (int)scaled * 10 / 10)
            + compactAmountSuffixes[suffixIndex]
         : formatCompactAmount(scaled, suffixIndex + 1);
   }

   public long getLegacyBalance() {
      return this.legacyBalance;
   }

   public int getTicketRevenue() {
      return this.ticketRevenue;
   }

   public int getPrizeRevenue() {
      return this.prizeRevenue;
   }

   public long getPlayerSaleRevenue() {
      return this.playerSaleRevenue;
   }

   public int getSponsorshipRevenue() {
      return this.sponsorshipRevenue;
   }

   public int getStadiumExpenses() {
      return this.stadiumExpenses;
   }

   public long getPlayerPurchaseExpenses() {
      return this.playerPurchaseExpenses;
   }

   public int getLoanInterestExpenses() {
      return this.loanInterestExpenses;
   }

   public int getMiscellaneousExpenses() {
      return this.miscellaneousExpenses;
   }

   public int getContractTerminationExpenses() {
      return this.contractTerminationExpenses;
   }

   public int getOutstandingLoanPrincipal() {
      return this.outstandingLoanPrincipal;
   }

   public long getSalaryExpenses() {
      return this.salaryExpenses;
   }

   public void setOutstandingLoanPrincipal(int principal) {
      this.outstandingLoanPrincipal = principal;
   }

   public boolean repayLoanInstallment(Club club) {
      if (this.outstandingLoanPrincipal > 0 && club.getCashBalance() >= 500000L) {
         this.outstandingLoanPrincipal -= 500000;
         club.debit(500000, -1);
         this.recalculateLoanInterest();
         return true;
      } else {
         return false;
      }
   }

   public boolean borrowLoanInstallment(Club club) {
      int[] limitsByDivision = new int[]{1000000, 5000000, 3000000, 2000000, 1500000};
      int limit;
      if (club.getDivisao() >= 1 && club.getDivisao() <= 4) {
         limit = limitsByDivision[club.getDivisao()];
      } else {
         limit = limitsByDivision[0];
      }

      if (this.outstandingLoanPrincipal < limit) {
         this.outstandingLoanPrincipal += 500000;
         club.credit(500000, -1);
         this.recalculateLoanInterest();
         return true;
      } else {
         return false;
      }
   }

   private void recalculateLoanInterest() {
      if (this.outstandingLoanPrincipal > 0) {
         this.monthlyLoanInterest = Math.round(this.outstandingLoanPrincipal * 3 / 100);
      } else {
         this.monthlyLoanInterest = 0;
      }
   }

   public int getMonthlyLoanInterest() {
      return this.monthlyLoanInterest;
   }

   public void setMonthlyLoanInterest(int interest) {
      this.monthlyLoanInterest = interest;
   }

   public int getOtherRevenue() {
      return this.otherRevenue;
   }

   public void setOtherRevenue(int revenue) {
      this.otherRevenue = revenue;
   }
}
