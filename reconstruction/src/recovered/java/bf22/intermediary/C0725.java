package bf22.intermediary;

import mod.recovered.competition.AfcChampionsLeague;
import mod.recovered.competition.CafChampionsLeague;
import mod.recovered.competition.ConcacafChampionsLeague;
import mod.recovered.competition.CopaLibertadores;
import mod.recovered.competition.CopaSudamericana;
import mod.recovered.competition.OfcChampionsLeague;
import mod.recovered.competition.UefaChampionsLeague;
import mod.recovered.competition.UefaEuropaLeague;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

public class C0725 {
   public static void main(String[] strings) {
      try {
         LookAndFeelInfo[] var4;
         int var3 = (var4 = UIManager.getInstalledLookAndFeels()).length;

         for (int var2 = 0; var2 < var3; var2++) {
            LookAndFeelInfo var1 = var4[var2];
            if ("Metal".equals(var1.getName())) {
               UIManager.setLookAndFeel(var1.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException var5) {
         Logger.getLogger(C0725.class.getName()).log(Level.SEVERE, null, var5);
      } catch (InstantiationException var6) {
         Logger.getLogger(C0725.class.getName()).log(Level.SEVERE, null, var6);
      } catch (IllegalAccessException var7) {
         Logger.getLogger(C0725.class.getName()).log(Level.SEVERE, null, var7);
      } catch (UnsupportedLookAndFeelException var8) {
         Logger.getLogger(C0725.class.getName()).log(Level.SEVERE, null, var8);
      }

      System.out.println(Runtime.getRuntime().maxMemory());
      System.out.println(Runtime.getRuntime().totalMemory());
      System.out.println(Runtime.getRuntime().freeMemory());
      new C0679(true);
      C0732.cU();
      mh();
      mg();
   }

   public static void mg() {
      Preferences var0 = Preferences.userRoot();
      var0 = var0.node("systemacxy");
      String var1 = var0.get("n", "nf");
      int var2 = var0.getInt("nr", -1);
      C0670.n(var1);
      C0670.eT();
      var2 = a(var2, var1);
      int var3 = C0670.eX();
      if (var2 == var3) {
         GamePersistence.setRegistrationScore(new Random().nextInt(300) + 150);
      } else {
         GamePersistence.setRegistrationScore(new Random().nextInt(50) + 30);
      }
   }

   private static int a(int i, String string) {
      char var2 = string.charAt(0);
      int var3 = var2 * 31348;
      return i + var3;
   }

   public static void mh() {
      long var0 = 0L;
      long var2 = 0L;
      new GamePersistence();
      GamePersistence.careerState.bs = false;
      new C0971().wT();
      GamePersistence.preloadSoundFiles();
      C0734.dd();
      GamePersistence.careerState.bi();
   }

   public static void mi() {
      new C0971().wT();
   }

   private static void mk() {
      int[] var0 = new int[]{7, 0, 2, 5, 3, 4, 6, 1};
      int[] var1 = new int[32];
      int var2 = 0;
      byte var3 = 0;

      for (int var4 = 0; var4 < 4; var4++) {
         for (int var5 = 0; var5 < 8; var5++) {
            var1[var2] = var0[var5] + var3;
            var2++;
         }

         var3 += 8;
      }

      System.out.println(Arrays.toString(var1));
   }

   private static void dk() {
      GamePersistence.careerState.a(new AfcChampionsLeague());
      GamePersistence.careerState.aL().yq();
   }

   private static void dl() {
      GamePersistence.careerState.a(new OfcChampionsLeague());
      GamePersistence.careerState.aQ().yq();
   }

   private static void dm() {
      GamePersistence.careerState.a(new ConcacafChampionsLeague());
      GamePersistence.careerState.aP().yq();
   }

   private static void dn() {
      GamePersistence.careerState.a(new CafChampionsLeague());
      GamePersistence.careerState.aO().yq();
   }

   private static void method_kw_do() {
      GamePersistence.careerState.a(new CopaSudamericana());
      GamePersistence.careerState.aH().yq();
   }

   private static void dp() {
      GamePersistence.careerState.a(new UefaEuropaLeague());
      GamePersistence.careerState.aK().yq();
   }

   private static void dq() {
      GamePersistence.careerState.a(new UefaChampionsLeague());
      GamePersistence.careerState.aI().setNome(C0679.getString("ligaC"));
      GamePersistence.careerState.aI().yq();
   }

   private static void dr() {
      GamePersistence.careerState.a(new CopaLibertadores());
      GamePersistence.careerState.aF().setNome(C0679.getString("lib"));
      GamePersistence.careerState.aF().yq();
   }

   public static void u() {
      int var0 = 0;
      var0 = 0;
      ArrayList var1 = C0693.b(100);

      for (int var2 = 0; var2 < var1.size(); var2++) {
         System.out
            .println(
               "Amistoso C:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var2))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var2))).a().get(7)]
                  + " "
                  + var1.get(var2)
            );
      }

      var0 = 0;
      var1 = C0693.b(200);

      for (int var26 = 0; var26 < var1.size(); var26++) {
         System.out
            .println(
               "Amistoso S:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var26))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var26))).a().get(7)]
                  + " "
                  + var1.get(var26)
            );
      }

      var0 = 0;
      var1 = C0693.b(10);

      for (int var27 = 0; var27 < var1.size(); var27++) {
         System.out
            .println(
               "Regional:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var27))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var27))).a().get(7)]
                  + " "
                  + var1.get(var27)
            );
      }

      var0 = 0;
      var1 = C0693.b(3);

      for (int var28 = 0; var28 < var1.size(); var28++) {
         System.out
            .println(
               "Estadual:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var28))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var28))).a().get(7)]
                  + " "
                  + var1.get(var28)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(1);

      for (int var29 = 0; var29 < var1.size(); var29++) {
         System.out
            .println(
               "Nacional:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var29))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var29))).a().get(7)]
                  + " "
                  + var1.get(var29)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(4);

      for (int var30 = 0; var30 < var1.size(); var30++) {
         System.out
            .println(
               "Int1:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var30))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var30))).a().get(7)]
                  + " "
                  + var1.get(var30)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(2);

      for (int var31 = 0; var31 < var1.size(); var31++) {
         System.out
            .println(
               "Copa:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var31))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var31))).a().get(7)]
                  + " "
                  + var1.get(var31)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(7);

      for (int var32 = 0; var32 < var1.size(); var32++) {
         System.out
            .println(
               "Selecoes:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var32))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var32))).a().get(7)]
                  + " "
                  + var1.get(var32)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(6);

      for (int var33 = 0; var33 < var1.size(); var33++) {
         System.out
            .println(
               "INT2:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var33))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var33))).a().get(7)]
                  + " "
                  + var1.get(var33)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(8);

      for (int var34 = 0; var34 < var1.size(); var34++) {
         System.out
            .println(
               "Recopa:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var34))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var34))).a().get(7)]
                  + " "
                  + var1.get(var34)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(5);

      for (int var35 = 0; var35 < var1.size(); var35++) {
         System.out
            .println(
               "Mundial:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var35))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var35))).a().get(7)]
                  + " "
                  + var1.get(var35)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = C0693.b(9);

      for (int var36 = 0; var36 < var1.size(); var36++) {
         System.out
            .println(
               "Elimin:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var36))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var36))).a().get(7)]
                  + " "
                  + var1.get(var36)
            );
      }
   }
}
