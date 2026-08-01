package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0949 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 agb = null;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private C0962 afT = null;
   private Club agf = null;

   public C0949() {
      this.F(9, 5);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.agb = null;
      this.agf = null;
      this.afT = null;
      this.YF.clear();
   }

   public void Bj() {
      this.YF.clear();
      ArrayList var1 = new ArrayList();
      int[] var2 = new int[]{214, 91, 163, 188, 69, 215, 143, 148, 93, 184, 197};
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2.length; var4++) {
         C0692 var5 = C0745.SR.s(var2[var4]);
         var3.add(var5.jo());
         var5.z(true);
      }

      Collections.sort(var3, C1007.cN);

      for (int var6 = 0; var6 <= 6; var6++) {
         this.YF.add((Club)var3.get(var6));
      }

      for (int var7 = 7; var7 < var3.size(); var7++) {
         var1.add((Club)var3.get(var7));
      }

      LeagueLoadOptions var8 = new LeagueLoadOptions();
      var8.nTimes = 4;
      var8.nGrupos = 0;
      var8.doisTurnos = true;
      C0955 var9 = new C0955(var8, var1, 0, null, null, null, 9, null, false, null, true, this);
      this.agb = var9;
      var9.setNome(this.getNome());
      var9.fb(9500);
      C0745.afQ.L(var1);
      C0745.afQ.L(this.YF);
   }

   public void yt() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.YD.yQ().size(); var2++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var2)).gR().get(0));
         var1.add((Club)((C0673)this.YD.yQ().get(var2)).gR().get(1));
      }

      boolean[] var4 = new boolean[]{true, true, true, false, false, false, false};
      this.afT = new C0962(null, var1.size(), this.b(), 0, var4, this, 9502);
      C0929 var3 = new C0929();
      var3.a(this.afT, var1, 0, var4[0], 0, 0, this.b(), false);
   }

   public void Bq() {
      this.YF.add((Club)this.agb.yK().get(0));
      LeagueLoadOptions var1 = new LeagueLoadOptions();
      var1.nTimes = 8;
      var1.nGrupos = 2;
      var1.doisTurnos = true;
      C0955 var2 = new C0955(var1, this.YF, 0, null, null, null, 9, null, false, null, true, this);
      this.YD = var2;
      var2.setNome(this.getNome());
      var2.fb(9501);
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"5º A. Sul", "1º Oceania"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   public void p(ArrayList arrayList, ArrayList arrayList2) {
      C0745.SR.aY().a(this, C0745.SR.s(((Club)arrayList.get(0)).getPais()));
      this.agf = (Club)arrayList2.get(0);
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
      if (this.YD == null) {
         C0678[] var2 = new C0678[]{this.agb};
         var1 = var2;
      } else if (this.afT != null) {
         C0678[] var3 = new C0678[]{this.afT};
         var1 = var3;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      C0678[] var2 = new C0678[]{this.agb};
      var1.add(new C0830(var2, "Fase Preliminar"));
      C0678[] var3 = new C0678[]{this.YD};
      var1.add(new C0830(var3, "Fase de Grupos"));
      C0678[] var4 = new C0678[]{this.afT};
      var1.add(new C0830(var4, "Fase Final"));
      C0678[] var5 = new C0678[]{C0745.SR.bQ().Bo()};
      var1.add(new C0830(var5, "Torneio Repescagem"));
      return var1;
   }

   public Club Br() {
      return this.agf;
   }
}
