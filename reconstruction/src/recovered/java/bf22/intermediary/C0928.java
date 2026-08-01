package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0928 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private Club ZA = null;
   private Integer aad = -1;

   public C0955 yd() {
      return this.YD;
   }

   public C0928() {
   }

   public C0928(Integer integer, ArrayList arrayList) {
      this.aad = integer;
      this.setNome(C0710.pY[integer]);
      this.F(10, integer);
      this.an(arrayList);
   }

   public void am(ArrayList arrayList) {
      this.YD = null;
      this.an(arrayList);
      this.mw();
   }

   public void an(ArrayList arrayList) {
      this.YF.clear();
      this.YD = null;
      Integer[][] var2 = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < arrayList.size(); var5++) {
         int var6 = ((Club)arrayList.get(var5)).getEstado();
         if (Arrays.asList(var2[this.aad]).contains(var6)) {
            var3.add((Club)arrayList.get(var5));
         }
      }

      if (var3.size() >= 16) {
         for (int var9 = 0; var9 < 16; var9++) {
            var4.add((Club)var3.get(var9));
         }

         Collections.sort(var4, C1007.abm);
         ArrayList var10 = C1007.ad(4, 4);

         for (int var11 = 0; var11 < var10.size(); var11++) {
            this.YF.add((Club)var4.get((Integer)var10.get(var11)));
         }

         boolean[] var12 = new boolean[]{true, true, true, false, false, false, false};
         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 16;
         var7.nGrupos = 4;
         var7.numeroTimesMataMata = 2;
         var7.doisTurnos = true;
         var7.duasVoltasMataMata = var12;
         C0955 var8 = new C0955(var7, this.YF, 0, null, null, null, 10, null, false, null, true, this);
         this.YD = var8;
         var8.setNome(this.getNome());
      }
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"1º Grupo A", "2º Grupo B", "1º Grupo D", "2º Grupo C", "1º Grupo B", "2º Grupo A", "1º Grupo C", "2º Grupo D"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   @Override
   public void mr() {
      this.YD.za();
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
      if (this.YD.yX() > 0) {
         ArrayList var1 = new ArrayList();
         String var2 = "Primeira Fase";
         if (this.YD.yQ().size() > 0) {
            var2 = "Fase de Grupos";
         }

         C0678[] var3 = new C0678[]{this.YD};
         var1.add(new C0830(var3, var2));
         C0678[] var4 = new C0678[]{this.YD.yY()};
         var1.add(new C0830(var4, "Fase Final"));
         return var1;
      } else {
         return null;
      }
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String[] var2 = new String[]{"tr_riosaopaulo", "tr_sulminas", "tr_copanordeste", "tr_copaverde", ""};
      if (C0710.w(var2[this.aad])) {
         var1[0] = var2[this.aad];
      } else {
         var1[0] = "tr_nacionalgenerico";
      }

      var1[1] = this.getNome();
      return var1;
   }
}
