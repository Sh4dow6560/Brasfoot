package bf22.intermediary;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import mod.recovered.CrashLogHandler;

public class C0726 {
   public static void main(String[] strings) {
      Thread.setDefaultUncaughtExceptionHandler(new CrashLogHandler());

      try {
         LookAndFeelInfo[] var4;
         int var3 = (var4 = UIManager.getInstalledLookAndFeels()).length;

         for (int var2 = 0; var2 < var3; var2++) {
            LookAndFeelInfo var1 = var4[var2];
            if ("Nimbus".equals(var1.getName())) {
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

      mg();
      new C0679(true);
      C0732.cU();
      C0388 var9 = new C0388();
      var9.pack();
      var9.setSize(532, 300);
      var9.setLocationRelativeTo(null);
      var9.setVisible(true);
      C0745.vH();
      ml();
   }

   public static void ml() {
      Thread var0 = new Thread(new C0712());
      var0.start();
   }

   public static void mg() {
      Preferences var0 = Preferences.userRoot();
      var0 = var0.node("systemacxyz22");
      String var1 = var0.get("n", "nf");
      int var2 = var0.getInt("nr", -1);
      if (var1.length() > 2 && var2 > 0) {
         C0670.n(var1);
         if (C0670.k(var1)) {
            C0670.n("Brasfoot 2016");
         }

         C0670.eT();
         var2 = a(var2, var1);
         int var3 = C0670.eX();
         String var4 = System.getProperty("sun.arch.data.model");
         int var5 = Integer.parseInt(var4);
         int var6 = var0.getInt("vSave", var5);
         C0745.SU = var6;
         if (var2 == var3) {
            C0745.ey(new Random().nextInt(1080) + 1920);
         } else {
            C0745.ey(new Random().nextInt(800) + 600);
         }
      }
   }

   private static int a(int i, String string) {
      char var2 = string.charAt(0);
      int var3 = var2 * 31348;
      return i + var3;
   }
}
