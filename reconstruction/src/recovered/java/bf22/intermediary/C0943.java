package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0943 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private ArrayList YE = new ArrayList();
   private ArrayList YF = new ArrayList();
   private C0692 YG = null;
   private int YH = 0;

   public C0943() {
      this.F(7, 5);
      this.O(true);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.YE.clear();
      this.YF.clear();
   }

   public void ya() {
      this.YE.clear();
      this.YF.clear();
      this.YD = null;
      int var1 = 7;
      this.YH++;
      this.YG = this.yb();
      if (this.YG != null && this.YG.jl()) {
         this.YE.add(this.YG);
      } else {
         var1++;
      }

      C0692.a(false, 5, var1, this.YE, false, null);
      if (this.YE.size() >= 8) {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < this.YE.size(); var3++) {
            var2.add(((C0692)this.YE.get(var3)).jo());
            ((C0692)this.YE.get(var3)).z(true);
         }

         Collections.sort(this.YF, C1007.cN);
         ArrayList var7 = C1007.ad(2, 4);

         for (int var4 = 0; var4 < var7.size(); var4++) {
            this.YF.add((Club)var2.get((Integer)var7.get(var4)));
         }

         boolean[] var8 = new boolean[7];
         LeagueLoadOptions var5 = new LeagueLoadOptions();
         var5.nTimes = 8;
         var5.nGrupos = 2;
         var5.numeroTimesMataMata = 2;
         var5.doisTurnos = false;
         var5.duasVoltasMataMata = var8;
         var5.melhoresTerceiros = false;
         C0955 var6 = new C0955(var5, this.YF, 0, null, null, null, 7, null, false, null, true, this);
         this.YD = var6;
         var6.setNome(this.getNome());
         C0745.afQ.L(this.YF);
      }
   }

   @Override
   public int cy(int i) {
      int var2 = this.YH - 1;
      var2 %= 10;
      int var3 = 45000;
      int[] var4 = new int[]{42000, 35000, 32698, 30134, 25600, 24990, 22215, 20065};
      int[] var5 = new int[]{15000, 12000, 12698, 9500, 15600, 14990, 17215, 18065};
      if (this.YG != null && this.YG.jc() != 143) {
         var4 = var5;
      }

      if (i <= 7) {
         var3 = var4[i];
      } else if (i - 8 < var4.length) {
         var3 = var4[i - 8];
      }

      return var3;
   }

   @Override
   public String cx(int i) {
      int var2 = this.YH - 1;
      var2 %= 10;
      String[][] var3 = new String[][]{
         {"Auckland", "Wellington", "Dunedin", "Napier", "Auckland", "Wellington", "Hamilton", "Napier"},
         {"Porto Moresby", "Lae", "Arawa", "Mount Hagen", "Porto Moresby", "Lae", "Arawa", "Mount Hagen"},
         {"Honiara", "Gizo", "Auki", "Kira Kira", "Honiara", "Gizo", "Auki", "Kira Kira"},
         {"Port Vila", "Luganville", "Norsup", "Port-Olry", "Port Vila", "Luganville", "Norsup", "Port-Olry"},
         {"Auckland", "Wellington", "Dunedin", "Napier", "Auckland", "Wellington", "Rotorua", "Napier"},
         {"Porto Moresby", "Lae", "Arawa", "Mount Hagen", "Porto Moresby", "Lae", "Arawa", "Mount Hagen"},
         {"Honiara", "Gizo", "Auki", "Kira Kira", "Honiara", "Gizo", "Auki", "Kira Kira"},
         {"Auckland", "Wellington", "Dunedin", "Napier", "Auckland", "Wellington", "Rotorua", "Napier"},
         {"Porto Moresby", "Lae", "Arawa", "Mount Hagen", "Porto Moresby", "Lae", "Arawa", "Mount Hagen"},
         {"Honiara", "Gizo", "Auki", "Kira Kira", "Honiara", "Gizo", "Auki", "Kira Kira"}
      };
      String var4 = null;
      int var5 = i;
      if (i > 7) {
         var5 = i - 8;
      }

      if (var5 < var3[var2].length) {
         var4 = var3[var2][var5];
      }

      return var4;
   }

   public C0692 yb() {
      int var1 = this.YH - 1;
      var1 %= 10;
      int[] var2 = new int[]{143, 148, 93, 184, 143, 148, 93, 184, 143, 148};
      return var1 >= 0 && var1 < var2.length ? C0745.SR.s(var2[var1]) : null;
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"1º Grupo A", "2º Grupo B", "1º Grupo D", "2º Grupo C", "1º Grupo B", "2º Grupo A", "1º Grupo C", "2º Grupo D"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   public C0955 yd() {
      return this.YD;
   }

   public void p(C0955 c0955) {
      this.YD = c0955;
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (this.YD.yZ()) {
         C0678[] var2 = new C0678[]{this.YD.yY()};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      C0678[] var2 = new C0678[]{this.YD};
      var1.add(new C0830(var2, "Fase de Grupos"));
      C0678[] var3 = new C0678[]{this.YD.yY()};
      var1.add(new C0830(var3, "Fase Final"));
      return var1;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_copaofc";
      var1[1] = this.getNome();
      return var1;
   }

   public int ye() {
      return this.YH;
   }

   @Override
   public void mr() {
      this.YD.za();
   }
}
