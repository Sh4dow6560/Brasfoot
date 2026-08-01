package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import mod.recovered.config.NationalLeagueConfig;
import mod.recovered.config.NationalLeagueConfigs;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public abstract class C0734 {
   private static boolean cM = false;
   public static Comparator cN = new C0735();
   private static int cO = 0;

   public static void dd() {
      if (GamePersistence.SR.aG().size() == 0) {
         de();
      }

      GamePersistence.SR.bC = new ArrayList();
      GamePersistence.SR.bD = new int[C0696.jz()];
      GamePersistence.SR.bE = new int[GameConstants.rX.length];
      C0687.w(false);
      Collections.sort(GamePersistence.SR.bC, cN);
      GamePersistence.SR.bF = new ArrayList();
      byte var0 = 10;

      for (int var1 = 0; var1 < GamePersistence.SR.bD.length; var1++) {
         if (var1 != 3 && var1 != 11 && var1 != 97 && var1 != 104 && var1 != 72) {
            var0 = 10;
         } else {
            var0 = 16;
         }

         if (GamePersistence.SR.bD[var1] >= var0) {
            C0681 var2 = new C0681();
            var2.setPais(var1);
            var2.aX(GamePersistence.SR.bD[var1]);
            var2.v(false);
            GamePersistence.SR.bF.add(var2);
         }
      }

      GamePersistence.SR.bG = new ArrayList();
      ds();
   }

   public static void de() {
      GamePersistence.SR.aG().clear();

      for (int var0 = 0; var0 < C0696.jz(); var0++) {
         CountryCompetitions var1 = new CountryCompetitions(var0);
         GamePersistence.SR.aG().add(var1);
      }
   }

   public static void w(ArrayList arrayList) {
      for (int var1 = 0; var1 < arrayList.size(); var1++) {
         if (((C0681)arrayList.get(var1)).iC()) {
            CountryCompetitions var2 = (CountryCompetitions)GamePersistence.SR.aG().get(((C0681)arrayList.get(var1)).getPais());
            var2.Ar();
            GamePersistence.SR.a(var2);
         }
      }
   }

   public static void df() {
      for (int var0 = 0; var0 < GamePersistence.SR.N().size(); var0++) {
         if (((CountryCompetitions)GamePersistence.SR.N().get(var0)).jc() == 29) {
            ((CountryCompetitions)GamePersistence.SR.N().get(var0)).ja();
         }
      }
   }

   public static void x(ArrayList arrayList) {
      byte var1 = 15;
      Integer var2 = -1;
      boolean var3 = false;
      int[] var4 = new int[C0696.jz()];

      for (int var5 = 0; var5 < GamePersistence.SR.bC.size(); var5++) {
         var2 = ((C0915)GamePersistence.SR.bC.get(var5)).getPais();
         if (var2 != null) {
            if (GamePersistence.SR.t(var2)) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var4[((C0915)GamePersistence.SR.bC.get(var5)).getPais()] < var1 || var3) {
               new Club((C0915)GamePersistence.SR.bC.get(var5));
               var4[((C0915)GamePersistence.SR.bC.get(var5)).getPais()]++;
            }
         }
      }
   }

   public static void dg() {
      x(GamePersistence.SR.bF);

      for (int var0 = 0; var0 < C0696.jz(); var0++) {
         CountryCompetitions var1 = (CountryCompetitions)GamePersistence.SR.aG().get(var0);
         var1.iT();
      }

      GamePersistence.SR.cb();
      GamePersistence.SR.r(GamePersistence.SR.op());
      C0693.g();
      C0693.u();
      w(GamePersistence.SR.bF);
      if (GamePersistence.SR.bk() || GamePersistence.SR.X()) {
         int var2 = C0693.e(1);
         if (var2 > 0) {
            C0693.b(var2, 4, 1);
         }
      }

      C0693.q();
      new C0679(false);
      dj();

      for (int var3 = 0; var3 < GamePersistence.SR.O().size(); var3++) {
         ((Player)GamePersistence.SR.O().get(var3)).fh();
      }

      for (int var4 = 0; var4 < GamePersistence.SR.Q().size(); var4++) {
         ((Player)GamePersistence.SR.Q().get(var4)).fh();
      }

      for (int var5 = 0; var5 < GamePersistence.SR.L().size(); var5++) {
         ((Coach)GamePersistence.SR.L().get(var5)).fh();
      }

      GamePersistence.SR.aU();
      GamePersistence.SR.c(false);
      if (GamePersistence.SR.op() == 2023) {
         GamePersistence.SR.rU();
      }

      GamePersistence.afQ.zj();
      if (GamePersistence.SR.isJogaSelecoesAll()) {
         GamePersistence.SR.ab();
         GamePersistence.SR.ac();
      }

      if (GamePersistence.SR.isJogaIntClubes()) {
         dm();
         dr();
         dq();
         dk();
         dn();
         dl();
         int var6 = C0693.d(4);
         if (var6 > 0) {
            C0693.b(var6, 1, 0);
         }

         method_kw_do();
         dp();
         yM();
      }

      if (!GamePersistence.SR.bk() && !GamePersistence.SR.isJogaRegionais()) {
         df();
      }

      Collections.sort(GamePersistence.SR.P(), C1007.VS);
   }

   public static void dh() {
      boolean var0 = false;
      int[] var1 = new int[4];
      String[] var10000 = new String[]{
         "AC",
         "AL",
         "AM",
         "AP",
         "BA",
         "CE",
         "DF",
         "ES",
         "GO",
         "MA",
         "MG",
         "MS",
         "MT",
         "PA",
         "PB",
         "PE",
         "PI",
         "PR",
         "RJ",
         "RN",
         "RO",
         "RR",
         "RS",
         "SC",
         "SE",
         "SP",
         "TO"
      };
      Integer[][] var3 = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};

      for (int var4 = 0; var4 < GamePersistence.SR.P().size(); var4++) {
         if (((Club)GamePersistence.SR.P().get(var4)).getPais() == 29) {
            int var5 = ((Club)GamePersistence.SR.P().get(var4)).getEstado();
            if (Arrays.asList(var3[0]).contains(var5)) {
               var1[0]++;
            } else if (Arrays.asList(var3[1]).contains(var5)) {
               var1[1]++;
            } else if (Arrays.asList(var3[2]).contains(var5)) {
               var1[2]++;
            } else if (Arrays.asList(var3[3]).contains(var5)) {
               var1[3]++;
            }
         }
      }

      new ArrayList();
      ArrayList var7 = di();
      boolean[] var8 = GamePersistence.SR.getJogaRegionaisTodos();

      for (int var6 = 0; var6 < 4; var6++) {
         if (var8[var6] && var1[var6] >= 16) {
            GamePersistence.SR.a(new C0928(var6, var7), var6);
            var0 = true;
         }
      }

      GamePersistence.SR.setJogaRegionais(var0);
   }

   public static ArrayList di() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = new ArrayList();
      CountryCompetitions var2 = GamePersistence.SR.o(29);
      if (var2 != null) {
         if (GamePersistence.vM().isConviteRegionais() && GamePersistence.SR.aN().size() == 1 && ((Club)GamePersistence.SR.aN().get(0)).getPais() == 29) {
            var0.add((Club)GamePersistence.SR.aN().get(0));
         }

         for (int var3 = 0; var3 < var2.eb().size(); var3++) {
            for (int var4 = 0; var4 < ((C0924)var2.eb().get(var3)).yi().yK().size(); var4++) {
               if (!var0.contains(((C0924)var2.eb().get(var3)).yi().yK().get(var4))) {
                  var0.add((Club)((C0924)var2.eb().get(var3)).yi().yK().get(var4));
               }
            }
         }

         if (GamePersistence.SR.H() > 1 && GamePersistence.SR.bx().size() > 0 && GamePersistence.SR.bk() && var2.eb().size() == 4) {
            for (int var5 = 0; var5 < GamePersistence.SR.bx().size(); var5++) {
               if (!var0.contains(var0.add(((C0779)GamePersistence.SR.bx().get(var5)).vD()))) {
                  var0.add(((C0779)GamePersistence.SR.bx().get(var5)).vD());
               }
            }
         }

         for (int var6 = 0; var6 < GamePersistence.SR.P().size(); var6++) {
            if (((Club)GamePersistence.SR.P().get(var6)).getPais() == 29 && !var0.contains(GamePersistence.SR.P().get(var6)) && !var1.contains(GamePersistence.SR.P().get(var6))) {
               var1.add((Club)GamePersistence.SR.P().get(var6));
            }
         }

         Collections.shuffle(var1);
         var0.addAll(var1);
      }

      return var0;
   }

   private static void dj() {
      for (int var0 = 0; var0 < GamePersistence.SR.P().size(); var0++) {
         ((Club)GamePersistence.SR.P().get(var0)).bX(var0);
      }

      GamePersistence.SR.w(GamePersistence.SR.P().size());
   }

   private static void dk() {
      GamePersistence.SR.a(new C0957());
      GamePersistence.SR.aL().yq();
   }

   private static void dl() {
      GamePersistence.SR.a(new C0961());
      GamePersistence.SR.aQ().yq();
   }

   private static void dm() {
      GamePersistence.SR.a(new C0959());
      GamePersistence.SR.aP().yq();
   }

   private static void dn() {
      GamePersistence.SR.a(new C0956());
      GamePersistence.SR.aO().yq();
   }

   private static void method_kw_do() {
      GamePersistence.SR.a(new C0930());
      GamePersistence.SR.aH().yq();
   }

   private static void dp() {
      GamePersistence.SR.a(new C0960());
      GamePersistence.SR.aK().yq();
   }

   private static void yM() {
      GamePersistence.SR.a(new C0932());
      GamePersistence.SR.mj().yq();
      GamePersistence.SR.mj().setNome("Conference League");
   }

   private static void dq() {
      GamePersistence.SR.a(new C0958());
      GamePersistence.SR.aI().setNome(C0679.getString("ligaC"));
      GamePersistence.SR.aI().yq();
   }

   private static void dr() {
      GamePersistence.SR.a(new C0954());
      GamePersistence.SR.aF().setNome(C0679.getString("lib"));
      GamePersistence.SR.aF().yq();
   }

   public static void ds() {
      GamePersistence.SR.bG.clear();
      File var0 = new File(System.getProperty("user.dir") + "/conf_ligas_nacionais");
      File[] var1 = var0.listFiles(new C0736());
      if (var1 != null) {
         for (int var2 = 0; var2 < var1.length; var2++) {
            if (var1[var2].isFile()) {
               new NationalLeagueConfigs();

               NationalLeagueConfigs var3;
               try {
                  FileInputStream var4 = new FileInputStream(var1[var2].getPath());
                  ObjectInputStream var5 = new ObjectInputStream(var4);
                  var3 = (NationalLeagueConfigs)var5.readObject();
                  var5.close();
                  var4.close();
               } catch (IOException var6) {
                  var6.printStackTrace();
                  return;
               } catch (ClassNotFoundException var7) {
                  var7.printStackTrace();
                  return;
               }

               a(var3);
            }
         }
      }
   }

   public static void a(NationalLeagueConfigs nationalLeagueConfigs) {
      for (int var1 = 0; var1 < nationalLeagueConfigs.leagues.size(); var1++) {
         GamePersistence.SR.bG.add((NationalLeagueConfig)nationalLeagueConfigs.leagues.get(var1));
      }
   }

   public static void a(NationalLeagueConfig[] nationalLeagueConfigs, int i) {
      NationalLeagueConfigs var2 = new NationalLeagueConfigs();

      for (int var3 = 1; var3 < nationalLeagueConfigs.length; var3++) {
         var2.leagues.add(nationalLeagueConfigs[var3]);
      }

      ArrayList var8 = new ArrayList();

      for (int var4 = 0; var4 < GamePersistence.SR.bG.size(); var4++) {
         if (((NationalLeagueConfig)GamePersistence.SR.bG.get(var4)).getPais() == i) {
            var8.add((NationalLeagueConfig)GamePersistence.SR.bG.get(var4));
         }
      }

      for (int var9 = 0; var9 < var8.size(); var9++) {
         GamePersistence.SR.bG.remove(var8.get(var9));
      }

      GamePersistence.SR.bG.addAll(var2.leagues);
      String var10 = C0696.valueOf("P" + Integer.toString(i)).jA() + ".cfg";

      try {
         FileOutputStream var5 = new FileOutputStream(System.getProperty("user.dir") + "/conf_ligas_nacionais/" + var10);
         ObjectOutputStream var6 = new ObjectOutputStream(var5);
         var6.writeObject(var2);
         var6.close();
         var5.close();
      } catch (IOException var7) {
         var7.printStackTrace();
      }
   }

   public static void c(int i, int j, int k) {
      NationalLeagueConfig var3 = new NationalLeagueConfig();
      if (i == 1) {
         var3.setnTimes(10);
         var3.setnRebaixados(2);
      } else if (i == 2) {
         var3.setnTimes(20);
         var3.setnRebaixados(4);
      }

      var3.setPais(j);
      var3.setDivisao(k);
      GamePersistence.SR.bG.add(var3);
   }

   public static boolean dt() {
      return cM;
   }

   public static void n(boolean bl) {
      cM = bl;
   }

   public static int du() {
      return cO;
   }

   public static void dv() {
      cO++;
   }
}
