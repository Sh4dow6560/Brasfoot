package bf22.intermediary;

public class C0761 {
   public static final String PB = ",";
   public static final String PC = ".";
   public static final char PD = '-';
   public static final char PE = '(';
   public static final char PF = ')';
   public static final String PG = "k";
   public static final String PH = "m";
   public static final String PJ = "b";
   public static final int PK = 0;
   public static final int PL = 1;
   public static final int PM = 2;
   public static final int PN = 3;
   public static final int PO = 0;
   public static final int PP = 1;
   public static final int PQ = 2;
   public static final int PR = -1;
   private String PS = ".";
   private boolean PT = true;
   private String PU = ",";
   private String PV = ".";
   private boolean PW = false;
   private String PX = "$";
   private int PY = 0;
   private int PZ = 0;
   private boolean Qa = false;
   private int Qb = 0;
   private boolean Qc = false;
   private boolean Qd = false;
   private boolean Qe = false;

   private C0761() {
   }

   public static C0761 ud() {
      return new C0761();
   }

   public static C0761 ue() {
      return b("$", true);
   }

   public static C0761 N(String string) {
      return b(string, true);
   }

   public static C0761 b(String string, boolean bl) {
      C0761 var2 = new C0761();
      var2.ay(true);
      var2.setCurrencySymbol(string);
      if (!bl) {
         var2.Q(",");
         var2.R(".");
      }

      var2.dM(2);
      return var2;
   }

   public static C0761 uf() {
      C0761 var0 = new C0761();
      var0.ax(false);
      var0.dM(0);
      return var0;
   }

   public static C0761 ug() {
      C0761 var0 = new C0761();
      var0.az(true);
      var0.dM(2);
      var0.ax(false);
      return var0;
   }

   public String format(String string) {
      return this.k(this.O(string));
   }

   public double O(String string) {
      return c(string, this.PS);
   }

   public static double b(String string, String string2) {
      return c(string, string2);
   }

   public static double parseDouble(String string) {
      return b(string, ".");
   }

   public void P(String string) {
      this.PS = string == null ? "." : string;
   }

   public void dK(int i) {
      this.PZ = i;
   }

   public void aw(boolean bl) {
      this.Qa = bl;
   }

   public void ax(boolean bl) {
      this.PT = bl;
   }

   public void Q(String string) {
      this.PV = string;
   }

   public void R(String string) {
      this.PU = string;
   }

   public void ay(boolean bl) {
      this.PW = bl;
   }

   public void setCurrencySymbol(String string) {
      this.PX = string;
   }

   public void dL(int i) {
      this.PY = i;
   }

   public void az(boolean bl) {
      this.Qe = bl;
   }

   public void dM(int i) {
      this.Qc = i != -1;
      this.Qb = i < 0 ? 0 : i;
   }

   public void aA(boolean bl) {
      this.Qd = bl;
   }

   private String S(String string) {
      String var2 = string;
      int var3 = var2.indexOf(".");
      String var4 = "";
      if (var3 != -1) {
         var4 = this.PV + var2.substring(var3 + 1, var2.length());
         var2 = var2.substring(0, var3);
      }

      int var5 = var2.length();

      for (int var6 = var5; var6 > 0; var6--) {
         var4 = var2.charAt(var6 - 1) + var4;
         if (var6 != 1 && (var5 - var6 + 1) % 3 == 0) {
            var4 = this.PU + var4;
         }
      }

      return var4;
   }

   protected String k(double d) {
      if (this.Qe) {
         d *= 100.0;
      }

      String var3 = this.Qc ? toFixed(Math.abs(this.l(d)), this.Qb) : Double.toString(d);
      var3 = this.PT ? this.S(var3) : var3.replaceAll("\\.", this.PV);
      String var4 = "";
      String var5 = "";
      String var6 = "";
      String var7 = "";
      String var8 = "";
      String var9 = "";
      String var10 = "";
      String var11 = "";
      String var12 = "" + (this.PZ == 2 ? 40 : 45);
      String var13 = "" + (this.PZ == 2 ? 41 : 45);
      if (this.PY == 0) {
         if (d < 0.0) {
            if (this.PZ == 0 || this.PZ == 2) {
               var7 = var12;
            }

            if (this.PZ == 1 || this.PZ == 2) {
               var8 = var13;
            }
         }

         if (this.PW) {
            var4 = this.PX;
         }
      } else if (this.PY == 1) {
         if (d < 0.0) {
            if (this.PZ == 0 || this.PZ == 2) {
               var5 = var12;
            }

            if (this.PZ == 1 || this.PZ == 2) {
               var10 = var13;
            }
         }

         if (this.PW) {
            var6 = this.PX;
         }
      } else if (this.PY == 2) {
         if (d < 0.0) {
            if (this.PZ == 0 || this.PZ == 2) {
               var5 = var12;
            }

            if (this.PZ == 1 || this.PZ == 2) {
               var10 = var13;
            }
         }

         if (this.PW) {
            var9 = this.PX;
         }
      } else if (this.PY == 3) {
         if (d < 0.0) {
            if (this.PZ == 0 || this.PZ == 2) {
               var7 = var12;
            }

            if (this.PZ == 1 || this.PZ == 2) {
               var8 = var13;
            }
         }

         if (this.PW) {
            var11 = this.PX;
         }
      }

      var3 = var4 + var5 + var6 + var7 + var3 + var8 + var9 + var10 + var11 + (this.Qe ? "%" : "");
      if (this.Qa && d < 0.0) {
         var3 = "<font color='red'>" + var3 + "</font>";
      }

      return var3;
   }

   private double l(double d) {
      double var3 = Math.pow(10.0, this.Qb);
      double var5 = d * var3;
      if (this.Qd) {
         var5 = var5 >= 0.0 ? Math.floor(var5) : Math.ceil(var5);
      } else {
         var5 = Math.round(var5);
      }

      return var5 / var3;
   }

   private static native String toFixed(double d, int i);

   private static double c(String string, String string2) {
      String var2 = string;
      boolean var3 = false;
      if (var2.indexOf(37) != -1) {
         var2 = var2.replaceAll("\\%", "");
         var3 = true;
      }

      var2 = var2.toLowerCase().replaceAll("b", "000000000");
      var2 = var2.replaceAll("m", "000000");
      var2 = var2.replaceAll("k", "000");
      String var4 = "[^\\" + string2 + "\\d\\-\\+\\(\\)eE]";
      var2 = var2.replaceAll(var4, "");
      int var5 = var2.indexOf(string2);
      if (var5 != -1) {
         var2 = var2.substring(0, var5) + "." + var2.substring(var5 + string2.length()).replaceAll("\\" + string2, "");
      }

      if (var2.charAt(var2.length() - 1) == '-') {
         var2 = var2.substring(0, var2.length() - 1);
         var2 = '-' + var2;
      } else if (var2.charAt(0) == '(' && var2.charAt(var2.length() - 1) == ')') {
         var2 = var2.substring(1, var2.length() - 1);
         var2 = '-' + var2;
      }

      Double var6;
      try {
         var6 = new Double(var2);
         if (var6.isInfinite() || var6.isNaN()) {
            var6 = new Double(0.0);
         }
      } catch (NumberFormatException var8) {
         var6 = new Double(0.0);
      }

      return var3 ? var6 / 100.0 : var6;
   }
}
