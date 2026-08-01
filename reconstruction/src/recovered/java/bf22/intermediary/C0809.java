package bf22.intermediary;

import mod.recovered.match.Match;
import java.util.ArrayList;

public class C0809 {
   private Match NB = null;
   private Match NC = null;
   private boolean ND = false;
   private boolean NE = false;
   private boolean NF = false;
   private String NG = "";
   private String NH = "";
   private String NI = "";
   private String NJ = "";
   private String NK = null;
   private String NL = null;
   private int w = 0;

   public Match sP() {
      return this.NB;
   }

   public void l(Match c0675) {
      this.NB = c0675;
   }

   public Match sQ() {
      return this.NC;
   }

   public void m(Match c0675) {
      this.NC = c0675;
   }

   public boolean sR() {
      return this.ND;
   }

   public void ah(boolean bl) {
      this.ND = bl;
   }

   public boolean sS() {
      return this.NE;
   }

   public void ai(boolean bl) {
      this.NE = bl;
   }

   public String sT() {
      return this.NG;
   }

   public void D(String string) {
      this.NG = string;
   }

   public String sU() {
      return this.NH;
   }

   public void E(String string) {
      this.NH = string;
   }

   public String sV() {
      return this.NI;
   }

   public void F(String string) {
      this.NI = string;
   }

   public String sW() {
      return this.NJ;
   }

   public void G(String string) {
      this.NJ = string;
   }

   public String sX() {
      return this.NK;
   }

   public void H(String string) {
      this.NK = string;
   }

   public String sY() {
      return this.NL;
   }

   public void I(String string) {
      this.NL = string;
   }

   public boolean sZ() {
      return this.NF;
   }

   public void aj(boolean bl) {
      this.NF = bl;
   }

   public static ArrayList a(int i, boolean bl, String string, String string2, ArrayList arrayList, boolean bl2) {
      int var6 = 1;
      String var7 = "Time ";
      if (string2 != "") {
         var7 = "Vencedor " + string2;
      }

      ArrayList var8 = new ArrayList();

      for (int var9 = 0; var9 < i; var9++) {
         C0809 var10 = new C0809();
         var10.ai(true);
         var10.aj(true);
         var8.add(var10);
         C0809 var11 = new C0809();
         var11.ah(true);
         var11.E(string + Integer.toString(var9 + 1));
         var11.aj(true);
         if (bl2 && var9 == 0) {
            var11.E("Decisão");
         } else if (bl2 && var9 == 1) {
            var11.E("Decisão 3º lugar");
         }

         if (i == 1) {
            var11.E(string);
         }

         var8.add(var11);
         String var12 = var7 + var6;
         String var13 = var7 + (var6 + 1);
         if (arrayList != null) {
            if (var6 - 1 < arrayList.size()) {
               var12 = (String)arrayList.get(var6 - 1);
            }

            if (var6 < arrayList.size()) {
               var13 = (String)arrayList.get(var6);
            }
         }

         C0809 var14 = new C0809();
         var14.F(var12);
         var14.G(var13);
         var14.aj(true);
         var8.add(var14);
         if (bl) {
            var11.H(var13);
            var11.I(var12);
            var14.H(var13);
            var14.I(var12);
         }

         var6 += 2;
      }

      return var8;
   }

   public int b() {
      return this.w;
   }

   public void a(int i) {
      this.w = i;
   }
}
