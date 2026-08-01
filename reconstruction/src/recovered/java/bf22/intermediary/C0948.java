package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0948 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private C0962 afV = null;
   private int age = 7;

   public C0948() {
      this.F(9, 0);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.afV = null;
      this.YD = null;
   }

   public void fF(int i) {
      this.age = i;
      if (i == 7) {
         this.setNome(C0679.getString("eliEU"));
         this.F(9, 0);
      } else {
         this.setNome("Classificatório Eurocopa");
         this.F(9, 70);
      }

      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < C0745.SR.aG().size(); var4++) {
         if (((C0692)C0745.SR.aG().get(var4)).jo() != null && ((C0692)C0745.SR.aG().get(var4)).gg() == 0) {
            var2.add((C0692)C0745.SR.aG().get(var4));
         }

         ((C0692)C0745.SR.aG().get(var4)).z(true);
      }

      Collections.sort(var2, C0692.cN);

      for (int var13 = 0; var13 < var2.size(); var13++) {
         var3.add(((C0692)var2.get(var13)).jo());
      }

      ArrayList var14 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();

      for (int var10 = 0; var10 <= 9; var10++) {
         var14.add((Club)var3.get(var10));
      }

      for (int var15 = 10; var15 <= 19; var15++) {
         var5.add((Club)var3.get(var15));
      }

      for (int var16 = 20; var16 <= 29; var16++) {
         var6.add((Club)var3.get(var16));
      }

      for (int var17 = 30; var17 <= 39; var17++) {
         var7.add((Club)var3.get(var17));
      }

      for (int var18 = 40; var18 <= 49; var18++) {
         var8.add((Club)var3.get(var18));
      }

      for (int var19 = 50; var19 <= 54; var19++) {
         var9.add((Club)var3.get(var19));
      }

      Collections.shuffle(var14);
      Collections.shuffle(var5);
      Collections.shuffle(var6);
      Collections.shuffle(var7);
      Collections.shuffle(var8);
      Collections.shuffle(var9);
      ArrayList var20 = new ArrayList();

      for (int var11 = 0; var11 <= 9; var11++) {
         var20.add((Club)var14.get(var11));
         var20.add((Club)var5.get(var11));
         var20.add((Club)var6.get(var11));
         var20.add((Club)var7.get(var11));
         var20.add((Club)var8.get(var11));
         if (var11 > 4) {
            var20.add((Club)var9.get(var11 - 5));
         }
      }

      LeagueLoadOptions var21 = new LeagueLoadOptions();
      var21.nTimes = 55;
      var21.nGrupos = 10;
      var21.doisTurnos = true;
      var21.gruposNumeroDiferenteTimes = true;
      var21.numeroDefinidoTimesPorGrupo[0] = 5;
      var21.numeroDefinidoTimesPorGrupo[1] = 5;
      var21.numeroDefinidoTimesPorGrupo[2] = 5;
      var21.numeroDefinidoTimesPorGrupo[3] = 5;
      var21.numeroDefinidoTimesPorGrupo[4] = 5;
      var21.numeroDefinidoTimesPorGrupo[5] = 6;
      var21.numeroDefinidoTimesPorGrupo[6] = 6;
      var21.numeroDefinidoTimesPorGrupo[7] = 6;
      var21.numeroDefinidoTimesPorGrupo[8] = 6;
      var21.numeroDefinidoTimesPorGrupo[9] = 6;
      C0955 var12 = new C0955(var21, var20, 0, null, null, null, 9, null, false, null, true, this);
      var12.fb(9001);
      this.YD = var12;
      var12.setNome(this.getNome());
      C0745.afQ.L(var20);
   }

   public void Bk() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      if (this.age == 7) {
         for (int var3 = 0; var3 < this.YD.yQ().size(); var3++) {
            var1.add((Club)((C0673)this.YD.yQ().get(var3)).gR().get(1));
         }

         for (int var5 = 0; var5 < this.YD.yQ().size(); var5++) {
            var2.add((Club)((C0673)this.YD.yQ().get(var5)).gR().get(2));
         }

         C0955.r(this.YD);
         Collections.sort(var2, C1007.abn);

         for (int var6 = 0; var6 <= 1; var6++) {
            var1.add((Club)var2.get(var6));
         }
      } else {
         for (int var7 = 0; var7 < this.YD.yQ().size(); var7++) {
            var2.add((Club)((C0673)this.YD.yQ().get(var7)).gR().get(2));
         }

         C0955.r(this.YD);
         Collections.sort(var2, C1007.abn);

         for (int var8 = 0; var8 <= 7; var8++) {
            var1.add((Club)var2.get(var8));
         }
      }

      boolean[] var9 = new boolean[]{true, true, true, true, true, true, true};
      this.afV = new C0962(null, var1.size(), this.b(), 1, var9, this, 9002);
      C0929 var4 = new C0929();
      var4.a(this.afV, var1, 0, var9[0], 0, 0, this.b(), false);
   }

   public void az(ArrayList arrayList) {
      if (this.age == 7) {
         for (int var2 = 0; var2 < this.YD.yQ().size(); var2++) {
            C0745.SR.aY().a(this, C0745.SR.s(((Club)((C0673)this.YD.yQ().get(var2)).gR().get(0)).getPais()));
         }

         for (int var3 = 0; var3 < arrayList.size(); var3++) {
            C0745.SR.aY().a(this, C0745.SR.s(((Club)arrayList.get(var3)).getPais()));
         }
      } else {
         for (int var4 = 0; var4 < this.YD.yQ().size(); var4++) {
            C0745.SR.ba().a(this, C0745.SR.s(((Club)((C0673)this.YD.yQ().get(var4)).gR().get(0)).getPais()));
            C0745.SR.ba().a(this, C0745.SR.s(((Club)((C0673)this.YD.yQ().get(var4)).gR().get(1)).getPais()));
         }

         for (int var5 = 0; var5 < arrayList.size(); var5++) {
            C0745.SR.ba().a(this, C0745.SR.s(((Club)arrayList.get(var5)).getPais()));
         }
      }
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"Sorteio 1", "Sorteio 2", "Sorteio 3", "Sorteio 4", "Sorteio 5", "Sorteio 6", "Sorteio 7", "Sorteio 8"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (this.afV != null) {
         C0678[] var2 = new C0678[]{this.afV};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      C0678[] var2 = new C0678[]{this.YD};
      var1.add(new C0830(var2, "Fase de Grupos"));
      C0678[] var3 = new C0678[]{this.afV};
      var1.add(new C0830(var3, "Play-offs"));
      return var1;
   }
}
