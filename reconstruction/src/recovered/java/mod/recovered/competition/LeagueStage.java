package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class LeagueStage extends CompetitionStage implements Serializable {
   private static final long serialVersionUID = 1L;
   private Competition YY = null;
   private CountryCompetitions RT = null;
   private C0741 YZ = null;
   private int divisao = 0;
   private ArrayList Za = new ArrayList();
   private ArrayList Zb = new ArrayList();
   private KnockoutStage Zc = null;
   private Club NS = null;
   private int Zd = 0;
   private boolean[] duasVoltasMataMata = new boolean[]{true, true, true, true, true, true, true};
   private ArrayList as = new ArrayList();
   private int Ze;
   private int Zf = 1;
   private int var0 = -1;
   private int Zg = -1;
   private boolean Zi = false;
   private boolean pulaDuasDatas = false;
   private int Zj = 0;
   private String nomeLiga = null;
   private String nomeDivisao = null;
   public boolean jogosDentroGrupo = true;
   public boolean doisTurnos = true;
   public int nTimes = 0;
   public int desempateEstadual = 0;
   public boolean melhoresTerceiros = false;
   private int numeroTurnos = 0;
   private int Zk = 0;
   public static transient LeagueStage Zl = null;
   private transient ArrayList wK = new ArrayList();
   private transient ArrayList xc = new ArrayList();
   private int[] Zm = new int[]{0, 1};
   private int[] Zn = new int[]{1, 0};
   private int[] Zo = new int[]{0, 3, 1, 2};
   private int[] Zp = new int[]{3, 0, 2, 1};
   private int[] Zq = new int[]{0, 3, 2, 1};
   private int[] Zr = new int[]{3, 0, 1, 2};
   private int[] Zs = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
   private int[] Zt = new int[]{1, 0, 3, 2, 5, 4, 7, 6};
   private int[] Zu = new int[]{1, 6, 3, 4, 0, 7, 2, 5};
   private int[] Zv = new int[]{6, 1, 4, 3, 7, 0, 5, 2};
   private int[] Zw = new int[]{0, 3, 4, 7, 8, 11, 12, 15, 2, 1, 6, 5, 10, 9, 14, 13};
   private int[] Zx = new int[]{3, 0, 7, 4, 11, 8, 15, 12, 1, 2, 5, 6, 9, 10, 13, 14};
   private int[] Zy = new int[]{7, 0, 2, 5, 3, 4, 6, 1, 15, 8, 10, 13, 11, 12, 14, 9, 23, 16, 18, 21, 19, 20, 22, 17, 31, 24, 26, 29, 27, 28, 30, 25};
   private int[] Zz = new int[]{31, 0, 25, 6, 24, 7, 27, 4, 23, 8, 22, 9, 29, 2, 21, 10, 26, 5, 20, 11, 19, 12, 28, 3, 18, 13, 17, 14, 16, 15, 30, 1};

   public LeagueStage() {
   }

   public LeagueStage(
      LeagueLoadOptions leagueLoadOptions,
      ArrayList arrayList,
      int i,
      LeagueStage c0955,
      LeagueStage c09552,
      CountryCompetitions c0692,
      int j,
      C0741 c0741,
      boolean bl,
      LeagueStage c09553,
      boolean bl2,
      Competition c0713
   ) {
      this.YY = c0713;
      this.a(j);
      this.var0 = leagueLoadOptions.var0;
      this.Zi = leagueLoadOptions.classificaPeloGeral;
      this.pulaDuasDatas = leagueLoadOptions.pulaDuasDatas;
      this.Zd = leagueLoadOptions.numeroTimesMataMata;
      this.duasVoltasMataMata = leagueLoadOptions.duasVoltasMataMata;
      this.Zj = leagueLoadOptions.nGrupos;
      this.jogosDentroGrupo = leagueLoadOptions.jogosDentroGrupo;
      this.doisTurnos = leagueLoadOptions.doisTurnos;
      this.nTimes = leagueLoadOptions.nTimes;
      this.desempateEstadual = leagueLoadOptions.desempateEstadual;
      this.melhoresTerceiros = leagueLoadOptions.melhoresTerceiros;
      this.nomeLiga = leagueLoadOptions.nomeLiga;
      this.nomeDivisao = leagueLoadOptions.nomeDivisao;
      this.numeroTurnos = leagueLoadOptions.numeroTurnos;
      if (arrayList.size() > 0) {
         for (int var13 = i; var13 < this.nTimes + i; var13++) {
            this.Zb.add((Club)arrayList.get(var13));
         }
      }

      if (c0692 != null) {
         if (c09553 == null) {
            c0692.jb();
            this.divisao = c0692.ec();
         } else {
            this.divisao = c09553.getDivisao();
         }

         this.RT = c0692;
         this.setNome("Nacional");
      }

      if (this.Zd == 1020) {
         if (this.Zj > 1) {
            this.Zd = 4;
         } else {
            this.Zd = 8;
         }

         this.var0 = 1020;
      }

      if (this.nTimes == 68) {
         this.var0 = 1068;
         if (arrayList.size() == 68) {
            this.a(c0713, arrayList);
         }
      } else if (arrayList.size() > 0) {
         if (this.Zj <= 1) {
            this.a(this.Zb, this.doisTurnos, false, null);
         } else if (leagueLoadOptions.gruposNumeroDiferenteTimes) {
            this.a(this.Zj, leagueLoadOptions.numeroDefinidoTimesPorGrupo);
         } else {
            this.j(this.Zj, bl2);
         }
      }

      this.yH();
      if (c0692 != null) {
         this.yI();
      }

      if (c0741 != null) {
         this.YZ = c0741;
         if (c09553 == null && this.var0 != 1801 && this.var0 != 1802 && this.var0 != 1803 && this.var0 != 1804 && this.var0 != 1805) {
            this.YZ.ed();
         }

         this.divisao = c0741.ec();
         this.setNome(c0741.ea());
      }
   }

   private void a(Competition c0713, ArrayList arrayList) {
      ArrayList var3 = new ArrayList();

      for (int var4 = 67; var4 > 59; var4--) {
         var3.add((Club)arrayList.get(var4));
      }

      boolean[] var7 = new boolean[]{true, true, true, true, true, true, true};
      KnockoutStage var5 = new KnockoutStage(this, 8, this.b(), 1, var7, this.YY, 1068);
      ((C0924)c0713).d(var5);
      KnockoutRound var6 = new KnockoutRound();
      var6.a(var5, var3, 0, true, 0, 0, this.b(), false);
      var6.fb(1068);
   }

   public void aN(boolean bl) {
      if (this.var0 == 1020) {
         ((C0924)this.YY).zF();
      }

      this.NS = null;
      this.Za.clear();
      this.Zc = null;
      this.as.clear();
      this.Zf = 1;
      this.wK.clear();
      this.xc.clear();
      this.YY.mw();
      if (this.RT != null) {
         this.RT.jx();
      }

      if (bl) {
         this.Zb.clear();
      }

      if (this.var0 == 1068) {
         this.aS(false);
         if (this.Zb.size() > 0) {
            this.a(this.YY, this.Zb);
         }
      } else if (this.Zb.size() > 0) {
         if (this.Zj <= 1) {
            this.a(this.Zb, this.doisTurnos, false, null);
         } else {
            this.j(this.Zj, false);
         }
      }
   }

   public void ai(ArrayList arrayList) {
      this.Zb.removeAll(arrayList);
      Collections.sort(this.Zb, C1007.aaV);
      this.j(8, true);
      this.Zb.addAll(arrayList);
      this.yH();
   }

   private void a(int i, int[] is) {
      int var3 = 0;

      for (int var4 = 0; var4 < i; var4++) {
         ArrayList var5 = new ArrayList();

         for (int var6 = 0; var6 < is[var4]; var6++) {
            var5.add((Club)this.Zb.get(var3));
            var3++;
         }

         C0673 var7 = new C0673();
         var7.E(var5);
         this.Za.add(var7);
         this.a(var5, this.doisTurnos, false, null);
      }
   }

   private void j(int i, boolean bl) {
      int var3 = i;
      int var4 = this.Zb.size();
      int var5 = var4 / var3;
      Club[][] var6 = new Club[var3][var5];
      int var7 = 0;
      if (!bl) {
         for (int var8 = 0; var8 < var5; var8++) {
            for (int var9 = 0; var9 < var3; var9++) {
               var6[var9][var8] = (Club)this.Zb.get(var7);
               var7++;
            }
         }
      } else {
         for (int var11 = 0; var11 < var3; var11++) {
            for (int var13 = 0; var13 < var5; var13++) {
               var6[var11][var13] = (Club)this.Zb.get(var7);
               var7++;
            }
         }
      }

      for (int var12 = 0; var12 < var3; var12++) {
         ArrayList var14 = new ArrayList();

         for (int var10 = 0; var10 < var5; var10++) {
            var14.add(var6[var12][var10]);
         }

         C0673 var15 = new C0673();
         var15.E(var14);
         this.Za.add(var15);
         if (this.jogosDentroGrupo) {
            if (this.b() != 7) {
               this.a(var14, this.doisTurnos, false, null);
            } else if (this.b() == 7) {
               this.a(var14, this.doisTurnos, false, null);
            }
         }
      }

      if ((this.b() != 7 || GamePersistence.SR.H() != 1) && !this.jogosDentroGrupo) {
         this.a(this.Zb, this.doisTurnos, true, this.Za);
      }
   }

   private void a(ArrayList arrayList, boolean bl, boolean bl2, ArrayList arrayList2) {
      Club[][][] var5 = null;
      Competition var6 = null;
      var6 = this.YY;
      if (!bl2) {
         if (arrayList.size() == 4 && this.var0 == 7700) {
            var5 = C0738.v(arrayList);
         } else if (arrayList.size() == 3 && this.doisTurnos) {
            var5 = C0738.a(this, arrayList);
         } else if (arrayList.size() == 3) {
            var5 = C0738.g(this, arrayList);
         } else if (arrayList.size() == 5 && !this.doisTurnos) {
            var5 = C0738.y(arrayList);
         } else if (arrayList.size() == 5) {
            var5 = C0738.b(this, arrayList);
         } else if (arrayList.size() == 6 && this.doisTurnos) {
            var5 = C0738.h(this, arrayList);
         } else if (arrayList.size() == 9) {
            var5 = C0738.a(this, arrayList, true);
         } else if (arrayList.size() == 11) {
            var5 = C0738.c(this, arrayList);
         } else if (arrayList.size() == 19) {
            var5 = C0738.e(this, arrayList);
         } else if (arrayList.size() == 25) {
            var5 = C0738.d(this, arrayList);
         } else {
            if (this.b() == 1) {
               if (arrayList.size() != 30 && arrayList.size() != 26 && arrayList.size() != 28 && arrayList.size() != 36) {
                  bl = true;
               } else {
                  bl = false;
               }
            }

            if (this.b() == 1 && this.Zj == 0) {
               this.aS(false);
            }

            byte var7 = 2;
            if (this.b() == 1) {
               if (arrayList.size() == 20 && this.var0 == 1020) {
                  var7 = 1;
               } else if (arrayList.size() == 8 && this.Zj == 0) {
                  var7 = 4;
               } else if (arrayList.size() == 10 && this.Zj == 0) {
                  var7 = 4;
                  if (this.numeroTurnos == 2) {
                     var7 = 2;
                  } else if (this.numeroTurnos == 3) {
                     var7 = 3;
                  }
               } else if (arrayList.size() == 12 && this.Zj == 0) {
                  var7 = 3;
                  if (this.numeroTurnos == 2) {
                     var7 = 2;
                  }
               } else if (arrayList.size() == 14 && this.Zj == 0) {
                  var7 = 3;
                  if (this.numeroTurnos == 2) {
                     var7 = 2;
                  }
               } else if (bl) {
                  var7 = 2;
               } else {
                  var7 = 1;
               }
            } else if (bl) {
               var7 = 2;
            } else {
               var7 = 1;
            }

            var5 = C0738.a(this, arrayList, var7);
         }
      } else if (this.var0 == 7) {
         var5 = C0738.a(arrayList, arrayList2);
      } else if (this.var0 == 10) {
         var5 = C0738.b(arrayList, arrayList2);
      }

      int var13 = arrayList.size() / 2;
      new ArrayList();
      ArrayList var8 = C0693.a(this.b(), this.pulaDuasDatas);

      for (int var9 = 0; var9 < var5.length; var9++) {
         for (int var10 = 0; var10 < var13; var10++) {
            if (var5[var9][var10][0] != null && var5[var9][var10][3] != null) {
               new Match(this, var9, var5[var9][var10][0], var5[var9][var10][3], (Integer)var8.get(var9), var6, null);
            }
         }

         if (!this.yF().contains(var8.get(var9))) {
            this.eZ((Integer)var8.get(var9));
         }
      }
   }

   private void eZ(int i) {
      this.as.add(i);
   }

   public ArrayList yF() {
      return this.as;
   }

   public int yG() {
      return this.Ze;
   }

   public void yH() {
      this.Ze = this.yF().size();
   }

   public void yI() {
      for (int var1 = 0; var1 < this.Zb.size(); var1++) {
         ((Club)this.Zb.get(var1)).setDivisao(this.divisao);
      }
   }

   public void yJ() {
      for (int var1 = 0; var1 < this.Zb.size(); var1++) {
         ((Club)this.Zb.get(var1)).setDivisao(0);
         this.RT.ek().add((Club)this.Zb.get(var1));
      }

      this.Zb.clear();
   }

   public ArrayList yK() {
      return this.Zb;
   }

   public int getDivisao() {
      return this.divisao;
   }

   private void yN() {
      for (int var1 = 0; var1 < this.yQ().size(); var1++) {
         GamePersistence.SR.aY().a(this.YY, GamePersistence.SR.s(((Club)((C0673)this.yQ().get(var1)).gR().get(0)).getPais()));
      }

      ArrayList var4 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < this.yQ().size(); var3++) {
         var4.add((Club)((C0673)this.yQ().get(var3)).gR().get(1));
      }

      Collections.sort(var4, C1007.abn);
      if (var4.size() >= 8) {
         for (int var5 = 0; var5 < 8; var5++) {
            var2.add((Club)var4.get(var5));
         }
      }

      Collections.shuffle(var2);
      this.Zc = new KnockoutStage(this, 8, this.b(), 1, this.duasVoltasMataMata, this.YY, -1);
      KnockoutRound var6 = new KnockoutRound();
      var6.a(this.Zc, var2, 0, this.duasVoltasMataMata[0], 0, 0, this.b(), false);
      this.Zc.fc(90);
   }

   private void yO() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      int[] var4 = null;

      for (int var5 = 0; var5 < this.yQ().size(); var5++) {
         for (int var6 = 0; var6 < this.Zd; var6++) {
            var1.add((Club)((C0673)this.yQ().get(var5)).gR().get(var6));
         }
      }

      if (this.Zj == 10 && this.var0 == 1403) {
         for (int var9 = 0; var9 < this.yQ().size(); var9++) {
            if (((C0673)this.yQ().get(var9)).gR().size() >= 2) {
               var2.add((Club)((C0673)this.yQ().get(var9)).gR().get(1));
            }
         }
      } else if (this.Zj != 17) {
         for (int var7 = 0; var7 < this.yQ().size(); var7++) {
            if (((C0673)this.yQ().get(var7)).gR().size() >= 3) {
               var2.add((Club)((C0673)this.yQ().get(var7)).gR().get(2));
            }
         }
      } else {
         for (int var8 = 0; var8 < this.yQ().size(); var8++) {
            if (((C0673)this.yQ().get(var8)).gR().size() >= 3) {
               var2.add((Club)((C0673)this.yQ().get(var8)).gR().get(1));
            }
         }
      }

      if (this.divisao == 4) {
         Collections.sort(var1, C1007.abn);
      }

      Collections.sort(var2, C1007.abn);
      byte var10 = 0;
      if (this.Zj == 10 && this.var0 == 1403) {
         var10 = 6;
      } else if (this.Zj == 3) {
         var10 = 2;
      } else if (this.Zj == 6) {
         var10 = 4;
      } else if (this.Zj == 12) {
         var10 = 8;
      } else if (this.Zj == 17) {
         var10 = 15;
      }

      if (var2.size() >= var10) {
         for (int var11 = 0; var11 < var10; var11++) {
            var1.add((Club)var2.get(var11));
         }
      }

      if (var1.size() == 32) {
         var4 = this.Zz;
      } else if (var1.size() == 16) {
         var4 = this.Zw;
      } else if (var1.size() == 8) {
         var4 = this.Zu;
         if (this.duasVoltasMataMata[0]) {
            var4 = this.Zv;
         }
      }

      if (var4 != null) {
         for (int var12 = 0; var12 < var1.size(); var12++) {
            var3.add((Club)var1.get(var4[var12]));
         }

         this.Zc = new KnockoutStage(this, var3.size(), this.b(), 0, this.duasVoltasMataMata, this.YY, -1);
         KnockoutRound var13 = new KnockoutRound();
         var13.a(this.Zc, var3, 0, this.duasVoltasMataMata[0], 0, 0, this.b(), false);
      }
   }

   private void yP() {
      boolean var1 = false;
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      int[] var4 = null;
      if (this.yQ().size() > 0 && !this.Zi) {
         boolean var13 = false;
         boolean var6 = false;
         if (this.b() == 4) {
            if (this.yT().gg() == 1 || this.yT().gg() == 2 || this.yT().gg() == 3) {
               var13 = true;
            } else if (this.yT().gg() == 0) {
               var6 = true;
            }
         }

         if ((this.b() == 4 || this.b() == 6) && this.yT().gg() == 1) {
            var1 = true;
         }

         if (this.b() == 6 && this.yT().gg() == 0) {
            var6 = true;
         }

         if (var6 || var13) {
            ArrayList var16 = new ArrayList();
            ArrayList var17 = new ArrayList();

            for (int var9 = 0; var9 < this.yQ().size(); var9++) {
               var16.add((Club)((C0673)this.yQ().get(var9)).gR().get(0));
               var17.add((Club)((C0673)this.yQ().get(var9)).gR().get(1));
            }

            if (var13) {
               Collections.sort(var16, C1007.abn);
               Collections.sort(var17, C1007.abn);
            } else {
               Collections.shuffle(var16);
               Collections.shuffle(var17);
            }

            int[] var18 = new int[]{0, 7, 3, 4, 1, 6, 2, 5};
            int[] var10 = new int[]{7, 0, 4, 3, 6, 1, 5, 2};

            for (int var11 = 0; var11 < var16.size(); var11++) {
               var3.add((Club)var17.get(var10[var11]));
               var3.add((Club)var16.get(var18[var11]));
            }
         } else {
            for (int var7 = 0; var7 < this.yQ().size(); var7++) {
               for (int var8 = 0; var8 < this.Zd; var8++) {
                  var2.add((Club)((C0673)this.yQ().get(var7)).gR().get(var8));
               }
            }

            if (this.var0 != 7 && this.var0 != 10) {
               if (var2.size() == 32) {
                  var4 = this.Zy;
               } else if (var2.size() == 16) {
                  var4 = this.Zw;
                  if (this.duasVoltasMataMata[0]) {
                     var4 = this.Zx;
                  }
               } else if (var2.size() == 8) {
                  var4 = this.Zu;
                  if (this.duasVoltasMataMata[0]) {
                     var4 = this.Zv;
                  }
               } else if (var2.size() == 4) {
                  var4 = this.Zq;
                  if (this.duasVoltasMataMata[0]) {
                     var4 = this.Zr;
                  }
               } else if (var2.size() == 2) {
                  var4 = this.Zm;
                  if (this.duasVoltasMataMata[0]) {
                     var4 = this.Zn;
                  }
               } else {
                  var3 = var2;
               }
            } else {
               var4 = this.Zs;
               if (this.duasVoltasMataMata[0]) {
                  var4 = this.Zt;
               }
            }

            if (var4 != null) {
               for (int var15 = 0; var15 < var2.size(); var15++) {
                  var3.add((Club)var2.get(var4[var15]));
               }
            }
         }
      } else {
         for (int var5 = 0; var5 < this.Zd; var5++) {
            var2.add((Club)this.Zb.get(var5));
         }

         if (var2.size() == 16) {
            var4 = this.Zw;
         } else if (var2.size() == 8) {
            var4 = this.Zu;
            if (this.duasVoltasMataMata[0]) {
               var4 = this.Zv;
            }
         } else if (var2.size() == 4) {
            var4 = this.Zo;
            if (this.duasVoltasMataMata[0]) {
               var4 = this.Zp;
            }
         } else if (var2.size() == 2) {
            var4 = this.Zm;
            if (this.duasVoltasMataMata[0]) {
               var4 = this.Zn;
            }
         } else {
            var3 = var2;
         }

         if (var4 != null) {
            for (int var12 = 0; var12 < var2.size(); var12++) {
               var3.add((Club)var2.get(var4[var12]));
            }
         }
      }

      if (this.var0 == 1020) {
         ((C0924)this.YY).a(var3, this, this.var0);
      } else {
         this.Zc = new KnockoutStage(this, var3.size(), this.b(), 0, this.duasVoltasMataMata, this.YY, -1);
         KnockoutRound var14 = new KnockoutRound();
         var14.a(this.Zc, var3, 0, this.duasVoltasMataMata[0], 0, 0, this.b(), var1);
         if (this.var0 == 1802) {
            this.Zc.fc(1802);
         } else if (this.var0 == 1803) {
            this.Zc.fc(1803);
         }
      }
   }

   public void pO() {
      new ArrayList();
      ArrayList var1 = ((C0693)GamePersistence.SR.R().get(GamePersistence.SR.J())).h();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         if (((Match)var1.get(var2)).ht() == this) {
            ((Match)var1.get(var2)).hc().a((Match)var1.get(var2), this);
            ((Match)var1.get(var2)).hd().a((Match)var1.get(var2), this);
         }
      }

      Zl = this;
      Collections.sort(this.Zb, C1007.abn);

      for (int var3 = 0; var3 < this.yQ().size(); var3++) {
         Collections.sort(((C0673)this.yQ().get(var3)).gR(), C1007.abn);
      }

      this.Zf++;
      if (this.b() == 1 && this.Zd == 0 && this.Zf == this.zk()) {
         GamePersistence.afQ.zj();
         C0700.b(this);
      }

      if (this.Zf > this.Ze) {
         if (this.b() == 1 && this.Zd > 0) {
            C0700.b(this);
         }

         if (this.Zd > 0) {
            for (int var4 = 0; var4 < this.Zb.size(); var4++) {
               ((Club)this.Zb.get(var4)).bW(var4);
            }
         }

         if (this.var0 == 14001) {
            GamePersistence.SR.sq().yt();
         } else if (this.var0 == 14401) {
            GamePersistence.SR.ym().yt();
         } else if (this.var0 == 14003) {
            GamePersistence.SR.sq().BB();
         } else if (this.var0 != 14002 && this.var0 != 14004 && this.var0 != 14402 && this.var0 != 14403) {
            if (this.var0 == 4005) {
               GamePersistence.SR.aI().yt();
            } else if (this.var0 == 6005) {
               GamePersistence.SR.aK().Be();
            } else if (this.var0 == 4104) {
               GamePersistence.SR.aF().yt();
            } else if (this.var0 == 12005) {
               GamePersistence.SR.mj().Be();
            } else if (this.var0 == 6105) {
               GamePersistence.SR.aH().yt();
            } else if (this.var0 == 7700) {
               GamePersistence.SR.aY().yt();
            } else if (this.var0 == 7701) {
               GamePersistence.SR.bQ().Bn();
            } else if (this.var0 == 9001) {
               GamePersistence.SR.bL().Bk();
            } else if (this.var0 == 9400) {
               GamePersistence.SR.bR().Bp();
            } else if (this.var0 == 9402) {
               GamePersistence.SR.bR().Bm();
            } else if (this.var0 == 9500) {
               GamePersistence.SR.bS().Bq();
            } else if (this.var0 == 9501) {
               GamePersistence.SR.bS().yt();
            } else if (this.var0 == 9100) {
               GamePersistence.SR.bK().Bm();
            } else if (this.Zd == 0 && this.var0 == 90) {
               this.yN();
            } else if (this.var0 == 9201) {
               GamePersistence.SR.bM().Bk();
            } else if (this.var0 == 9301) {
               GamePersistence.SR.bQ().yt();
            } else if (this.var0 == 9302) {
               GamePersistence.SR.bQ().Bm();
            } else if (this.Zd > 0 && this.melhoresTerceiros) {
               this.yO();
            } else if (this.Zd > 0) {
               this.yP();
            } else {
               new CompetitionSeasonResult(this.YY, this, (Club)this.Zb.get(0), (Club)this.Zb.get(1));
            }
         }
      }
   }

   public ArrayList yQ() {
      return this.Za;
   }

   public int yR() {
      int var1 = 0;
      if (this.Zd > 0) {
         byte var2 = 1;
         int var3 = 0;
         if (this.Zj != 0 && !this.Zi) {
            var3 = this.Zd * this.Zj;
            if (this.melhoresTerceiros) {
               if (this.Zj == 3) {
                  var3 += 2;
               } else if (this.Zj == 6) {
                  var3 += 4;
               } else if (this.Zj == 12) {
                  var3 += 8;
               } else if (this.Zj == 17) {
                  var3 += 15;
               }
            }
         } else {
            var3 = this.Zd;
         }

         if (var3 == 128) {
            var2 = 7;
         } else if (var3 == 64) {
            var2 = 6;
         } else if (var3 == 32) {
            var2 = 5;
         } else if (var3 == 16) {
            var2 = 4;
         } else if (var3 == 8) {
            var2 = 3;
         } else if (var3 == 4) {
            var2 = 2;
         } else if (var3 == 2) {
            var2 = 1;
         }

         var1 = var2 - 1;
      }

      return var1;
   }

   public Club[] yS() {
      Club[] var1 = new Club[2];

      for (int var2 = 0; var2 < this.YY.mn().size(); var2++) {
         if (((CompetitionSeasonResult)this.YY.mn().get(var2)).H() == GamePersistence.SR.H()) {
            var1[0] = ((CompetitionSeasonResult)this.YY.mn().get(var2)).ce();
            var1[1] = ((CompetitionSeasonResult)this.YY.mn().get(var2)).cf();
            return var1;
         }
      }

      return null;
   }

   public Club cS() {
      Object var1 = null;

      for (int var2 = 0; var2 < this.YY.mn().size(); var2++) {
         if (((CompetitionSeasonResult)this.YY.mn().get(var2)).H() == GamePersistence.SR.H()) {
            return ((CompetitionSeasonResult)this.YY.mn().get(var2)).ce();
         }
      }

      return null;
   }

   public Club cv(int i) {
      Object var2 = null;

      for (int var3 = 0; var3 < this.YY.mn().size(); var3++) {
         if (((CompetitionSeasonResult)this.YY.mn().get(var3)).H() == i) {
            return ((CompetitionSeasonResult)this.YY.mn().get(var3)).ce();
         }
      }

      return null;
   }

   public Competition yT() {
      return this.YY;
   }

   public ArrayList yU() {
      return this.xc;
   }

   public ArrayList l(int i, boolean bl) {
      ArrayList var3 = new ArrayList();
      if (this.Zd == 0) {
         if (this.Zb.size() > 0) {
            for (int var4 = 0; var4 < i; var4++) {
               var3.add((Club)this.Zb.get(var4));
            }
         }
      } else if (this.ze() == 1020) {
         LeagueStage var9 = ((C0924)this.YY).zP();
         KnockoutStage var5 = var9.yY();
         if (i > var3.size()) {
            var3.add((Club)((KnockoutRound)var5.zp().get(0)).zY().get(0));
         }

         if (i > var3.size()) {
            for (int var6 = 0; var6 < ((KnockoutRound)var5.zp().get(0)).zV().size(); var6++) {
               if (!var3.contains(((KnockoutRound)var5.zp().get(0)).zV().get(var6))) {
                  var3.add((Club)((KnockoutRound)var5.zp().get(0)).zV().get(var6));
               }
            }
         }

         Zl = var9;
         if (i > var3.size()) {
            ArrayList var16 = new ArrayList();

            for (int var7 = 0; var7 < var9.yQ().size(); var7++) {
               var16.add((Club)((C0673)var9.yQ().get(var7)).gR().get(1));
            }

            Collections.sort(var16, C1007.abn);
            var3.addAll(var16);
         }

         if (var3.size() < i) {
            ArrayList var17 = new ArrayList();

            for (int var19 = 0; var19 < var9.yQ().size(); var19++) {
               for (int var8 = 0; var8 < ((C0673)var9.yQ().get(var19)).gR().size(); var8++) {
                  if (!var3.contains(((C0673)var9.yQ().get(var19)).gR().get(var8))) {
                     var17.add((Club)((C0673)var9.yQ().get(var19)).gR().get(var8));
                  }
               }
            }

            Collections.sort(var17, C1007.abn);
            int var20 = i - var3.size();

            for (int var22 = 0; var22 < var17.size(); var22++) {
               if (var20 > 0) {
                  var3.add((Club)var17.get(var22));
                  var20--;
               }
            }
         }
      } else if (this.Zc != null && i > 0) {
         for (int var11 = this.Zc.zp().size() - 1; var11 >= 0; var11--) {
            for (int var14 = 0; var14 < ((KnockoutRound)this.Zc.zp().get(var11)).zY().size(); var14++) {
               if (i > var3.size() && !var3.contains(((KnockoutRound)this.Zc.zp().get(var11)).zY().get(var14))) {
                  var3.add((Club)((KnockoutRound)this.Zc.zp().get(var11)).zY().get(var14));
               }
            }
         }

         if (i > var3.size()) {
            for (int var12 = 0; var12 < i; var12++) {
               if (i > var3.size() && !var3.contains(this.Zb.get(var12))) {
                  var3.add((Club)this.Zb.get(var12));
               }
            }
         }
      } else {
         for (int var10 = 0; var10 < i; var10++) {
            if (i > var3.size() && !var3.contains(this.Zb.get(var10))) {
               var3.add((Club)this.Zb.get(var10));
            }
         }
      }

      if (bl && this.YY != null && this.YY instanceof C0924 && this.RT != null) {
         KnockoutStage var13 = ((C0924)this.YY).BR();
         if (var13 != null) {
            ArrayList var15 = new ArrayList();
            byte var18 = -1;
            if (var13.zp().size() == 1) {
               var18 = 0;
            } else if (var13.zp().size() == 2) {
               var18 = 1;
            }

            if (var18 >= 0 && var18 < var13.zp().size()) {
               var15.addAll(((KnockoutRound)var13.zp().get(var18)).zY());
            }

            int var21 = var3.size() - var15.size();

            for (int var23 = 0; var23 < var21; var23++) {
               var15.add((Club)var3.get(var23));
            }

            Collections.reverse(var15);
            var3.clear();
            var3.addAll(var15);
         }
      }

      return var3;
   }

   public ArrayList fG(int i) {
      ArrayList var2 = new ArrayList();
      if (this.Zd == 0) {
         if (this.Zb.size() > 0) {
            for (int var3 = this.Zb.size() - 1; var3 >= this.Zb.size() - i; var3--) {
               var2.add((Club)this.Zb.get(var3));
            }
         }
      } else if (this.zc() && this.Za != null && this.Za.size() != 0) {
         if (this.ze() == 1020 || this.zc()) {
            if (i == 4) {
               i = 2;
            } else {
               i = 1;
            }
         }

         for (int var7 = 0; var7 < this.Za.size(); var7++) {
            for (int var4 = ((C0673)this.Za.get(var7)).gR().size() - 1; var4 >= ((C0673)this.Za.get(var7)).gR().size() - i; var4--) {
               var2.add((Club)((C0673)this.Za.get(var7)).gR().get(var4));
            }
         }
      } else if (this.Zj >= 12 && this.Zc != null) {
         for (int var6 = this.Zb.size() - 1; var6 >= this.Zb.size() - i; var6--) {
            if (!this.Zc.U((Club)this.Zb.get(var6))) {
               var2.add((Club)this.Zb.get(var6));
            }
         }
      } else {
         for (int var5 = this.Zb.size() - 1; var5 >= this.Zb.size() - i; var5--) {
            var2.add((Club)this.Zb.get(var5));
         }
      }

      return var2;
   }

   public void ah(int i, int j) {
      this.xc = new ArrayList();
      this.wK = new ArrayList();
      this.wK.addAll(this.l(i, true));
      this.xc.addAll(this.fG(j));
   }

   public ArrayList yV() {
      ArrayList var1 = new ArrayList();
      KnockoutStage var2 = this.Zc;
      LeagueStage var3 = null;
      if (this.ze() == 1020) {
         var3 = ((C0924)this.YY).zP();
         if (var3 != null) {
            var2 = var3.yY();
         }
      }

      if (var2 != null) {
         for (int var4 = var2.zp().size() - 1; var4 >= 0; var4--) {
            for (int var5 = 0; var5 < ((KnockoutRound)var2.zp().get(var4)).zY().size(); var5++) {
               if (!var1.contains(((KnockoutRound)var2.zp().get(var4)).zY().get(var5))) {
                  var1.add((Club)((KnockoutRound)var2.zp().get(var4)).zY().get(var5));
               }
            }
         }
      }

      if (var3 != null) {
         for (int var6 = 0; var6 < var3.yK().size(); var6++) {
            if (!var1.contains(var3.yK().get(var6))) {
               var1.add((Club)var3.yK().get(var6));
            }
         }
      }

      for (int var7 = 0; var7 < this.Zb.size(); var7++) {
         if (!var1.contains(this.Zb.get(var7))) {
            var1.add((Club)this.Zb.get(var7));
         }
      }

      return var1;
   }

   public ArrayList yW() {
      return this.wK;
   }

   public int yX() {
      return this.Zd;
   }

   public KnockoutStage yY() {
      return this.Zc;
   }

   public void b(ArrayList arrayList, Coach coach, boolean bl) {
      ArrayList var4 = new ArrayList();
      int var5 = 0;
      int var6 = 0;
      if (bl) {
         var5 = 2;
         var6 = 6;
      } else {
         var5 = this.Zb.size() - 6;
         var6 = this.Zb.size();
      }

      if (var6 > this.Zb.size()) {
         var6 = this.Zb.size();
      }

      for (int var7 = var5; var7 < var6; var7++) {
         if (!((Club)this.Zb.get(var7)).jZ() && this.Zb.get(var7) != coach.lF()) {
            var4.add((Club)this.Zb.get(var7));
         }
      }

      Collections.shuffle(var4);

      for (int var10 = 0; var10 < var4.size(); var10++) {
         if (!arrayList.contains(var4.get(var10))) {
            arrayList.add((Club)var4.get(var10));
            break;
         }
      }
   }

   public boolean yZ() {
      return this.Zc != null;
   }

   public int P(Club club) {
      if (this.Zc != null) {
         return -1;
      }

      for (int var2 = 0; var2 < this.Zb.size(); var2++) {
         if (this.Zb.get(var2) == club) {
            return var2 + 1;
         }
      }

      return -1;
   }

   public int Q(Club club) {
      if (this.Zc != null) {
         return -1;
      }

      if (this.Zj == 0) {
         for (int var2 = 0; var2 < this.Zb.size(); var2++) {
            if (this.Zb.get(var2) == club) {
               return var2 + 1;
            }
         }
      } else {
         for (int var4 = 0; var4 < this.Za.size(); var4++) {
            for (int var3 = 0; var3 < ((C0673)this.Za.get(var4)).gR().size(); var3++) {
               if (((C0673)this.Za.get(var4)).gR().get(var3) == club) {
                  return var3 + 1;
               }
            }
         }
      }

      return -1;
   }

   public int R(Club club) {
      for (int var2 = 0; var2 < this.Zb.size(); var2++) {
         if (this.Zb.get(var2) == club) {
            return var2;
         }
      }

      return -1;
   }

   public int getnTimes() {
      return this.nTimes;
   }

   public boolean ei() {
      for (int var1 = 0; var1 < this.Zb.size(); var1++) {
         if (((Club)this.Zb.get(var1)).jZ()) {
            return true;
         }
      }

      return false;
   }

   public void f(KnockoutStage c0962) {
      Competition var2 = this.YY;
      int var3 = 0;
      int var4 = 1;
      ArrayList var5 = new ArrayList();

      for (int var6 = c0962.zp().size() - 1; var6 >= 0; var6--) {
         for (int var7 = 0; var7 < ((KnockoutRound)c0962.zp().get(var6)).zW().size(); var7++) {
            Club var8 = null;
            Club var9 = null;
            if (((KnockoutRound)c0962.zp().get(var6)).zY().contains(((Match)((KnockoutRound)c0962.zp().get(var6)).zW().get(var7)).hc())) {
               var8 = ((Match)((KnockoutRound)c0962.zp().get(var6)).zW().get(var7)).hc();
               var9 = ((Match)((KnockoutRound)c0962.zp().get(var6)).zW().get(var7)).hd();
            } else if (((KnockoutRound)c0962.zp().get(var6)).zY().contains(((Match)((KnockoutRound)c0962.zp().get(var6)).zW().get(var7)).hd())) {
               var8 = ((Match)((KnockoutRound)c0962.zp().get(var6)).zW().get(var7)).hd();
               var9 = ((Match)((KnockoutRound)c0962.zp().get(var6)).zW().get(var7)).hc();
            }

            if (!var5.contains(var8)) {
               var5.add(var8);
               var8.a(var2, var4, var3);
               var4++;
            }

            if (!var5.contains(var9)) {
               var5.add(var9);
               var9.a(var2, var4, var3);
               var4++;
            }
         }

         var3++;
      }

      ArrayList var10 = new ArrayList();
      var10.addAll(((KnockoutRound)this.Zc.zp().get(0)).zV());

      for (int var11 = 0; var11 < this.Zb.size(); var11++) {
         if (!var5.contains(this.Zb.get(var11)) && !var10.contains(this.Zb.get(var11))) {
            short var12 = -1;
            if (this.b() == 4 || this.b() == 6 || this.b() == 12) {
               var12 = 1001;
            }

            ((Club)this.Zb.get(var11)).a(var2, var4, var12);
            var4++;
         }
      }
   }

   public void za() {
      Competition var1 = this.YY;
      boolean var2 = false;
      if (this.YZ != null) {
         var2 = true;
      }

      ArrayList var3 = new ArrayList();
      if (this.Zc == null) {
         for (int var4 = 0; var4 < this.Zb.size(); var4++) {
            ((Club)this.Zb.get(var4)).a(var1, var4 + 1, -1);
            if (var2 && ((Club)this.Zb.get(var4)).getDivisao() == 0 && GamePersistence.SR.bx() != null && this.YZ != null) {
               GamePersistence.SR.bx().add(new C0779(this.YZ.getEstado(), this.divisao, (Club)this.Zb.get(var4), var4 + 1));
            }
         }
      } else {
         int var10 = 0;
         int var5 = 1;

         for (int var6 = this.Zc.zp().size() - 1; var6 >= 0; var6--) {
            for (int var7 = 0; var7 < ((KnockoutRound)this.Zc.zp().get(var6)).zW().size(); var7++) {
               Club var8 = null;
               Club var9 = null;
               if (((KnockoutRound)this.Zc.zp().get(var6)).zY().contains(((Match)((KnockoutRound)this.Zc.zp().get(var6)).zW().get(var7)).hc())) {
                  var8 = ((Match)((KnockoutRound)this.Zc.zp().get(var6)).zW().get(var7)).hc();
                  var9 = ((Match)((KnockoutRound)this.Zc.zp().get(var6)).zW().get(var7)).hd();
               } else if (((KnockoutRound)this.Zc.zp().get(var6)).zY().contains(((Match)((KnockoutRound)this.Zc.zp().get(var6)).zW().get(var7)).hd())) {
                  var8 = ((Match)((KnockoutRound)this.Zc.zp().get(var6)).zW().get(var7)).hd();
                  var9 = ((Match)((KnockoutRound)this.Zc.zp().get(var6)).zW().get(var7)).hc();
               }

               if (!var3.contains(var8)) {
                  var3.add(var8);
                  var8.a(var1, var5, var10);
                  if (var2 && var8.getDivisao() == 0 && GamePersistence.SR.bx() != null && this.YZ != null) {
                     GamePersistence.SR.bx().add(new C0779(this.YZ.getEstado(), this.divisao, var8, var5));
                  }

                  var5++;
               }

               if (!var3.contains(var9)) {
                  var3.add(var9);
                  var9.a(var1, var5, var10);
                  if (var2 && var9.getDivisao() == 0 && GamePersistence.SR.bx() != null && this.YZ != null) {
                     GamePersistence.SR.bx().add(new C0779(this.YZ.getEstado(), this.divisao, var9, var5));
                  }

                  var5++;
               }
            }

            var10++;
         }

         for (int var11 = 0; var11 < this.Zb.size(); var11++) {
            if (!var3.contains(this.Zb.get(var11))) {
               short var12 = -1;
               if (this.b() == 4 || this.b() == 6 || this.b() == 12) {
                  var12 = 1001;
               }

               ((Club)this.Zb.get(var11)).a(var1, var5, var12);
               if (var2 && ((Club)this.Zb.get(var11)).getDivisao() == 0 && this.YZ != null) {
                  GamePersistence.SR.bx().add(new C0779(this.YZ.getEstado(), this.divisao, (Club)this.Zb.get(var11), var5));
               }

               var5++;
            }
         }
      }
   }

   @Override
   public C0741 ir() {
      return this.YZ;
   }

   @Override
   public CountryCompetitions iq() {
      return this.YY.iq();
   }

   @Override
   public int ip() {
      return this.divisao;
   }

   @Override
   public String io() {
      return this.Zf + "ª rodada";
   }

   @Override
   public String getNome() {
      String var1 = super.getNome();
      String var2 = "";
      if (this.divisao > 0 && this.b() != 1) {
         var2 = " - " + this.divisao + "ª D";
      }

      if (this.nomeLiga != null) {
         var1 = this.nomeLiga;
      }

      var1 = var1.replace("Campeonato do", "");
      var1 = var1.replace("Campeonato de", "");
      var1 = var1.replace("Campeonato da", "");
      var1 = var1.replace("Campeonato", "");
      if (this.nomeDivisao != null && this.nomeDivisao.length() > 0) {
         var2 = " - " + this.nomeDivisao;
      }

      String var3 = var1 + var2;
      if (var3.length() > 39) {
         var3 = var3.substring(0, 39) + "...";
      }

      return var3;
   }

   @Override
   public String is() {
      String var1 = "";
      if (this.divisao > 0) {
         var1 = this.divisao + "ª Divisão";
      }

      if (this.nomeDivisao != null && this.nomeDivisao.length() > 0) {
         var1 = this.nomeDivisao;
      } else if (this.b() != 3) {
         var1 = this.nomeLiga;
      }

      if (var1.length() > 39) {
         var1 = var1.substring(0, 39) + "...";
      }

      return var1;
   }

   public int zb() {
      return this.Zf;
   }

   public boolean[] getDuasVoltasMataMata() {
      return this.duasVoltasMataMata;
   }

   public boolean zc() {
      return this.YY != null && this.YY instanceof C0924 ? ((C0924)this.YY).zc() : false;
   }

   public void aS(boolean bl) {
      if (this.YY != null && this.YY instanceof C0924) {
         ((C0924)this.YY).aS(bl);
      }
   }

   public int zd() {
      return this.desempateEstadual;
   }

   public void A(ArrayList arrayList) {
      for (int var2 = 0; var2 < this.yK().size(); var2++) {
         if (((Club)this.yK().get(var2)).ka() != null && ((Club)this.yK().get(var2)).ka().lL() < 10) {
            if (((Club)this.yK().get(var2)).jZ()) {
               int var3 = 2;
               if (((Club)this.yK().get(var2)).kb() < 0L) {
                  var3 = 1;
               } else {
                  var3 = new Random().nextInt(2) + 2;
               }

               Coach var4 = ((Club)this.yK().get(var2)).ka();
               Coach var5 = ((Club)this.yK().get(var2)).kE();
               MainWindow.a(var4, var5, (Club)this.yK().get(var2), var3);
               arrayList.add(new C0813((Club)this.yK().get(var2), var4, var5, var3));
            } else if (var2 > 5) {
               Coach var7 = ((Club)this.yK().get(var2)).ka();
               Coach var8 = ((Club)this.yK().get(var2)).kE();
               int var9 = new Random().nextInt(3) + 1;
               arrayList.add(new C0813((Club)this.yK().get(var2), var7, var8, var9));
            }
         }
      }
   }

   public int ze() {
      return this.var0;
   }

   public int zf() {
      return this.Zg;
   }

   public void fb(int i) {
      this.var0 = i;
   }

   public void fc(int i) {
      this.Zg = i;
   }

   public boolean zg() {
      if (this.YZ != null) {
         if (this.divisao == this.YZ.eb().size()) {
            return true;
         }
      } else if (this.RT != null && this.divisao == this.RT.eb().size()) {
         return true;
      }

      return false;
   }

   public int zh() {
      if (this.YZ != null) {
         return this.YZ.ek().size();
      } else {
         return this.RT != null ? this.RT.ek().size() : 0;
      }
   }

   public int[] Bv() {
      int[] var1 = new int[3];
      if (this.YZ != null) {
         if (this.divisao >= 2 && this.divisao - 2 >= 0 && this.divisao - 2 < this.YZ.eb().size()) {
            var1[0] = ((C0951)this.YZ.eb().get(this.divisao - 2)).getnRebaixados();
         }
      } else if (this.RT != null && this.divisao >= 2 && this.divisao - 2 >= 0 && this.divisao - 2 < this.RT.eb().size()) {
         var1[0] = ((C0924)this.RT.eb().get(this.divisao - 2)).getnRebaixados();
      }

      System.out.println(this.YY);
      return var1;
   }

   public int getnRebaixados() {
      if (this.YZ != null) {
         return ((C0951)this.YZ.eb().get(this.divisao - 1)).getnRebaixados();
      } else {
         return this.RT != null ? ((C0924)this.RT.eb().get(this.divisao - 1)).getnRebaixados() : 0;
      }
   }

   public int Bw() {
      return this.RT != null
         ? ((C0924)this.RT.eb().get(this.divisao - 1)).getnRebaixados() - ((C0924)this.RT.eb().get(this.divisao - 1)).getRebaixadosDireto()
         : 0;
   }

   public Club fd(int i) {
      if (this.RT != null) {
         if (this.RT.gg() == 1) {
            if (i == 1) {
               return GamePersistence.SR.aF().cS();
            }

            if (i == 2) {
               return GamePersistence.SR.aH().cS();
            }
         } else if (this.RT.gg() == 0) {
            if (i == 1) {
               return GamePersistence.SR.aI().cS();
            }

            if (i == 2) {
               return GamePersistence.SR.aK().cS();
            }
         } else {
            if (this.RT.gg() == 2) {
               return GamePersistence.SR.aO().cS();
            }

            if (this.RT.gg() == 3) {
               return GamePersistence.SR.aL().cS();
            }

            if (this.RT.gg() == 4) {
               return GamePersistence.SR.aP().cS();
            }

            if (this.RT.gg() == 5) {
               return GamePersistence.SR.aQ().cS();
            }
         }
      }

      return null;
   }

   public CountryCompetitions vl() {
      return this.RT;
   }

   public int zk() {
      int var1 = 0;
      if (this.Zj == 0) {
         var1 = (this.Zb.size() - 1) * 2;
      } else {
         var1 = Math.round(this.Zb.size() / this.Zj) * 2 - 1;
      }

      int var2 = Math.round(var1 / 2);
      return this.Zf > var2 ? Math.round(this.Zf / 2) : 0;
   }

   public void setDivisao(int i) {
      this.divisao = i;
   }

   public Club tf() {
      return this.NS;
   }

   public boolean zl() {
      return this.Zi;
   }

   public static void r(LeagueStage c0955) {
      Zl = c0955;
   }

   public void c(KnockoutStage c0962) {
      this.Zc = c0962;
   }

   public void Bx() {
      for (int var1 = 0; var1 < this.Za.size(); var1++) {
         ((C0673)this.Za.get(var1)).dv(var1);
      }
   }
}
