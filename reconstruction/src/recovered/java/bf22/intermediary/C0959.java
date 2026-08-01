package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0959 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private Club ZA = null;
   private ArrayList YV = new ArrayList();

   public C0959() {
      this.setNome(C0679.getString("ligaConcacaf"));
      this.F(4, 4);
      this.yo();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("nic", 139, 1));
      this.YV.add(new C0793("mex", 131, 4));
      this.YV.add(new C0793("eua", 68, 3));
      this.YV.add(new C0793("can", 38, 1));
      this.YV.add(new C0793("cosr", 51, 2));
      this.YV.add(new C0793("hon", 86, 1));
      this.YV.add(new C0793("guat", 79, 2));
      this.YV.add(new C0793("pan", 147, 2));
      this.YV.add(new C0793("els", 58, 1));
      this.YV.add(new C0793("belize", 22, 1));
      this.YV.add(new C0793("triT", 189, 1));
      this.YV.add(new C0793("jam", 106, 1));
      this.YV.add(new C0793("haiti", 84, 1));
      this.YV.add(new C0793("cub", 53, 1));
      this.YV.add(new C0793("rep dom", 158, 1));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(4, 1, this.YV, null, i, c0792);
   }

   public void yq() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YF.clear();
      this.YD = null;
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      if (this.ZA != null) {
         this.YF.add(this.ZA);
      }

      var2.addAll(this.YF);
      C0938.a(this.YV, this.YF, var2, false);
      C0938.a(var1, this.YF, var2, false);
      if (this.YF.size() < 24) {
         C0938.a(this.YF, this.YV, 24, var2);
      }

      Collections.sort(this.YF, C1007.abm);
      ArrayList var3 = new ArrayList();
      if (this.YF.size() >= 24) {
         int[] var4 = new int[]{0, 15, 23, 4, 14, 22, 6, 13, 21, 2, 11, 20, 1, 12, 19, 5, 10, 18, 7, 9, 17, 3, 8, 16};

         for (int var5 = 0; var5 < var4.length; var5++) {
            var3.add((Club)this.YF.get(var4[var5]));
         }

         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 24;
         var7.nGrupos = 8;
         var7.numeroTimesMataMata = 1;
         var7.doisTurnos = true;
         var7.pulaDuasDatas = true;
         C0955 var6 = new C0955(var7, var3, 0, null, null, null, 4, null, false, null, true, this);
         this.YD = var6;
         var6.setNome(this.getNome());
      }
   }

   public ArrayList yy() {
      return this.YF;
   }

   public Club yz() {
      return this.ZA;
   }

   public void N(Club club) {
      this.ZA = club;
   }

   public C0955 yd() {
      return this.YD;
   }

   @Override
   public void mr() {
      this.YD.za();
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"1º G1", "1º G8", "1º G2", "1º G7", "1º G3", "1º G6", "1º G4", "1º G5"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
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
      var1[0] = "tr_ligaconcacaf";
      var1[1] = this.getNome();
      return var1;
   }
}
