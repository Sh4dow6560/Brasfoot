package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0950 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private ArrayList YE = new ArrayList();
   private ArrayList YF = new ArrayList();
   private Club agf = null;

   public C0950() {
      this.F(9, 1);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.agf = null;
      this.YE.clear();
      this.YF.clear();
   }

   public void ya() {
      this.YE.clear();
      this.YF.clear();
      byte var1 = 10;
      C0692.a(false, 1, var1, this.YE, true, null);
      if (this.YE.size() == 10) {
         for (int var2 = 0; var2 < this.YE.size(); var2++) {
            this.YF.add(((C0692)this.YE.get(var2)).jo());
            ((C0692)this.YE.get(var2)).z(true);
         }

         Collections.shuffle(this.YF);
         LeagueLoadOptions var4 = new LeagueLoadOptions();
         var4.nTimes = 10;
         var4.nGrupos = 0;
         var4.doisTurnos = true;
         var4.jogosDentroGrupo = true;
         var4.var0 = 9100;
         C0955 var3 = new C0955(var4, this.YF, 0, null, null, null, 9, null, false, null, true, this);
         this.YD = var3;
         var3.setNome(this.getNome());
      } else if (this.YE.size() == 9) {
         for (int var5 = 0; var5 < this.YE.size(); var5++) {
            this.YF.add(((C0692)this.YE.get(var5)).jo());
            ((C0692)this.YE.get(var5)).z(true);
         }

         Collections.shuffle(this.YF);
         LeagueLoadOptions var6 = new LeagueLoadOptions();
         var6.nTimes = 9;
         var6.nGrupos = 0;
         var6.doisTurnos = true;
         var6.jogosDentroGrupo = true;
         var6.var0 = 9100;
         C0955 var7 = new C0955(var6, this.YF, 0, null, null, null, 9, null, false, null, true, this);
         this.YD = var7;
         var7.setNome(this.getNome());
      }

      C0745.afQ.L(this.YF);
   }

   public void Bm() {
      for (int var1 = 0; var1 <= 5; var1++) {
         C0745.SR.aY().a(this, C0745.SR.s(((Club)this.YD.yK().get(var1)).getPais()));
      }

      this.agf = (Club)this.YD.yK().get(6);
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"5º A. Sul", "1º Oceania"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (C0745.SR.bQ().Bo() != null) {
         C0678[] var2 = new C0678[]{C0745.SR.bQ().Bo()};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      C0678[] var2 = new C0678[]{this.YD};
      var1.add(new C0830(var2, "Fase de Grupos"));
      C0678[] var3 = new C0678[]{C0745.SR.bQ().Bo()};
      var1.add(new C0830(var3, "Torneio Repescagem"));
      return var1;
   }

   public C0955 yd() {
      return this.YD;
   }

   public Club Br() {
      return this.agf;
   }
}
