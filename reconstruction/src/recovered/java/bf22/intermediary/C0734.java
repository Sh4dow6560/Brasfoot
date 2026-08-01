package bf22.intermediary;

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
      if (C0745.SR.aG().size() == 0) {
         de();
      }

      C0745.SR.bC = new ArrayList();
      C0745.SR.bD = new int[C0696.jz()];
      C0745.SR.bE = new int[C0710.rX.length];
      C0687.w(false);
      Collections.sort(C0745.SR.bC, cN);
      C0745.SR.bF = new ArrayList();
      byte var0 = 10;

      for (int var1 = 0; var1 < C0745.SR.bD.length; var1++) {
         if (var1 != 3 && var1 != 11 && var1 != 97 && var1 != 104 && var1 != 72) {
            var0 = 10;
         } else {
            var0 = 16;
         }

         if (C0745.SR.bD[var1] >= var0) {
            C0681 var2 = new C0681();
            var2.setPais(var1);
            var2.aX(C0745.SR.bD[var1]);
            var2.v(false);
            C0745.SR.bF.add(var2);
         }
      }

      C0745.SR.bG = new ArrayList();
      ds();
   }

   public static void de() {
      C0745.SR.aG().clear();

      for (int var0 = 0; var0 < C0696.jz(); var0++) {
         C0692 var1 = new C0692(var0);
         C0745.SR.aG().add(var1);
      }
   }

   public static void w(ArrayList arrayList) {
      for (int var1 = 0; var1 < arrayList.size(); var1++) {
         if (((C0681)arrayList.get(var1)).iC()) {
            C0692 var2 = (C0692)C0745.SR.aG().get(((C0681)arrayList.get(var1)).getPais());
            var2.Ar();
            C0745.SR.a(var2);
         }
      }
   }

   public static void df() {
      for (int var0 = 0; var0 < C0745.SR.N().size(); var0++) {
         if (((C0692)C0745.SR.N().get(var0)).jc() == 29) {
            ((C0692)C0745.SR.N().get(var0)).ja();
         }
      }
   }

   public static void x(ArrayList arrayList) {
      byte var1 = 15;
      Integer var2 = -1;
      boolean var3 = false;
      int[] var4 = new int[C0696.jz()];

      for (int var5 = 0; var5 < C0745.SR.bC.size(); var5++) {
         var2 = ((C0915)C0745.SR.bC.get(var5)).getPais();
         if (var2 != null) {
            if (C0745.SR.t(var2)) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var4[((C0915)C0745.SR.bC.get(var5)).getPais()] < var1 || var3) {
               new Club((C0915)C0745.SR.bC.get(var5));
               var4[((C0915)C0745.SR.bC.get(var5)).getPais()]++;
            }
         }
      }
   }

   public static void dg() {
      x(C0745.SR.bF);

      for (int var0 = 0; var0 < C0696.jz(); var0++) {
         C0692 var1 = (C0692)C0745.SR.aG().get(var0);
         var1.iT();
      }

      C0745.SR.cb();
      C0745.SR.r(C0745.SR.op());
      C0693.g();
      C0693.u();
      w(C0745.SR.bF);
      if (C0745.SR.bk() || C0745.SR.X()) {
         int var2 = C0693.e(1);
         if (var2 > 0) {
            C0693.b(var2, 4, 1);
         }
      }

      C0693.q();
      new C0679(false);
      dj();

      for (int var3 = 0; var3 < C0745.SR.O().size(); var3++) {
         ((Player)C0745.SR.O().get(var3)).fh();
      }

      for (int var4 = 0; var4 < C0745.SR.Q().size(); var4++) {
         ((Player)C0745.SR.Q().get(var4)).fh();
      }

      for (int var5 = 0; var5 < C0745.SR.L().size(); var5++) {
         ((Coach)C0745.SR.L().get(var5)).fh();
      }

      C0745.SR.aU();
      C0745.SR.c(false);
      if (C0745.SR.op() == 2023) {
         C0745.SR.rU();
      }

      C0745.afQ.zj();
      if (C0745.SR.isJogaSelecoesAll()) {
         C0745.SR.ab();
         C0745.SR.ac();
      }

      if (C0745.SR.isJogaIntClubes()) {
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

      if (!C0745.SR.bk() && !C0745.SR.isJogaRegionais()) {
         df();
      }

      Collections.sort(C0745.SR.P(), C1007.VS);
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

      for (int var4 = 0; var4 < C0745.SR.P().size(); var4++) {
         if (((Club)C0745.SR.P().get(var4)).getPais() == 29) {
            int var5 = ((Club)C0745.SR.P().get(var4)).getEstado();
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
      boolean[] var8 = C0745.SR.getJogaRegionaisTodos();

      for (int var6 = 0; var6 < 4; var6++) {
         if (var8[var6] && var1[var6] >= 16) {
            C0745.SR.a(new C0928(var6, var7), var6);
            var0 = true;
         }
      }

      C0745.SR.setJogaRegionais(var0);
   }

   public static ArrayList di() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = new ArrayList();
      C0692 var2 = C0745.SR.o(29);
      if (var2 != null) {
         if (C0745.vM().isConviteRegionais() && C0745.SR.aN().size() == 1 && ((Club)C0745.SR.aN().get(0)).getPais() == 29) {
            var0.add((Club)C0745.SR.aN().get(0));
         }

         for (int var3 = 0; var3 < var2.eb().size(); var3++) {
            for (int var4 = 0; var4 < ((C0924)var2.eb().get(var3)).yi().yK().size(); var4++) {
               if (!var0.contains(((C0924)var2.eb().get(var3)).yi().yK().get(var4))) {
                  var0.add((Club)((C0924)var2.eb().get(var3)).yi().yK().get(var4));
               }
            }
         }

         if (C0745.SR.H() > 1 && C0745.SR.bx().size() > 0 && C0745.SR.bk() && var2.eb().size() == 4) {
            for (int var5 = 0; var5 < C0745.SR.bx().size(); var5++) {
               if (!var0.contains(var0.add(((C0779)C0745.SR.bx().get(var5)).vD()))) {
                  var0.add(((C0779)C0745.SR.bx().get(var5)).vD());
               }
            }
         }

         for (int var6 = 0; var6 < C0745.SR.P().size(); var6++) {
            if (((Club)C0745.SR.P().get(var6)).getPais() == 29 && !var0.contains(C0745.SR.P().get(var6)) && !var1.contains(C0745.SR.P().get(var6))) {
               var1.add((Club)C0745.SR.P().get(var6));
            }
         }

         Collections.shuffle(var1);
         var0.addAll(var1);
      }

      return var0;
   }

   private static void dj() {
      for (int var0 = 0; var0 < C0745.SR.P().size(); var0++) {
         ((Club)C0745.SR.P().get(var0)).bX(var0);
      }

      C0745.SR.w(C0745.SR.P().size());
   }

   private static void dk() {
      C0745.SR.a(new C0957());
      C0745.SR.aL().yq();
   }

   private static void dl() {
      C0745.SR.a(new C0961());
      C0745.SR.aQ().yq();
   }

   private static void dm() {
      C0745.SR.a(new C0959());
      C0745.SR.aP().yq();
   }

   private static void dn() {
      C0745.SR.a(new C0956());
      C0745.SR.aO().yq();
   }

   private static void method_kw_do() {
      C0745.SR.a(new C0930());
      C0745.SR.aH().yq();
   }

   private static void dp() {
      C0745.SR.a(new C0960());
      C0745.SR.aK().yq();
   }

   private static void yM() {
      C0745.SR.a(new C0932());
      C0745.SR.mj().yq();
      C0745.SR.mj().setNome("Conference League");
   }

   private static void dq() {
      C0745.SR.a(new C0958());
      C0745.SR.aI().setNome(C0679.getString("ligaC"));
      C0745.SR.aI().yq();
   }

   private static void dr() {
      C0745.SR.a(new C0954());
      C0745.SR.aF().setNome(C0679.getString("lib"));
      C0745.SR.aF().yq();
   }

   public static void ds() {
      C0745.SR.bG.clear();
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
         C0745.SR.bG.add((NationalLeagueConfig)nationalLeagueConfigs.leagues.get(var1));
      }
   }

   public static void a(NationalLeagueConfig[] nationalLeagueConfigs, int i) {
      NationalLeagueConfigs var2 = new NationalLeagueConfigs();

      for (int var3 = 1; var3 < nationalLeagueConfigs.length; var3++) {
         var2.leagues.add(nationalLeagueConfigs[var3]);
      }

      ArrayList var8 = new ArrayList();

      for (int var4 = 0; var4 < C0745.SR.bG.size(); var4++) {
         if (((NationalLeagueConfig)C0745.SR.bG.get(var4)).getPais() == i) {
            var8.add((NationalLeagueConfig)C0745.SR.bG.get(var4));
         }
      }

      for (int var9 = 0; var9 < var8.size(); var9++) {
         C0745.SR.bG.remove(var8.get(var9));
      }

      C0745.SR.bG.addAll(var2.leagues);
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
      C0745.SR.bG.add(var3);
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
