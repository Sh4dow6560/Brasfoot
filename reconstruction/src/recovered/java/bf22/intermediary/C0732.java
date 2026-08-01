package bf22.intermediary;

import mod.recovered.geo.CountryInfo;
import mod.recovered.ui.MainWindow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

public abstract class C0732 {
   private static JFrame cC = null;
   private static JFrame cD = null;
   private static ArrayList cE = new ArrayList();
   private static ArrayList cF = new ArrayList();
   private static C0901 cG = null;
   private static final String cH = "AAAAAAACEEEEIIIIDNOOOOO×ØUUUUYIßaaaaaaaceeeeiiiionooooo÷ouuuuyþyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF";
   private static final String cI = "abcdefghijklmnopqrstuvxzyw0123456789";
   private static final String cJ = "fitbzvengwpkycmuqhldxjrasofitbzvengw";
   public static String cK = System.getProperty("user.dir");
   public static Comparator cL = new C0733();

   public static String f(String string) {
      char[] var1 = new char[string.length()];

      for (int var3 = 0; var3 < string.length(); var3++) {
         char var2 = string.charAt(var3);
         if (var2 >= 192 && var2 <= 383) {
            var2 = "AAAAAAACEEEEIIIIDNOOOOO×ØUUUUYIßaaaaaaaceeeeiiiionooooo÷ouuuuyþyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF"
               .charAt(var2 - 192);
         }

         var1[var3] = var2;
      }

      return new String(var1);
   }

   public static void cU() {
      for (int var0 = 0; var0 < C0696.jz(); var0++) {
         CountryInfo var1 = new CountryInfo();
         var1.setPais(var0);
         var1.setNome(C0696.valueOf("P" + var0).getNome());
         var1.s(f(C0696.valueOf("P" + var0).getNome()));
         var1.r(C0696.valueOf("P" + var0).jA());
         var1.bn(C0696.valueOf("P" + var0).gg());
         var1.bo(var0);
         cF.add(var1);
      }

      Collections.sort(cF, cL);
   }

   public static void g(String string) {
      try {
         LookAndFeelInfo[] var4;
         int var3 = (var4 = UIManager.getInstalledLookAndFeels()).length;

         for (int var2 = 0; var2 < var3; var2++) {
            LookAndFeelInfo var1 = var4[var2];
            if (string.equals(var1.getName())) {
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
   }

   public static void cV() {
      cE.clear();
      C0884.iD();

      for (int var0 = 0; var0 < cZ().size(); var0++) {
         ((C0915)cZ().get(var0)).setNomep(f(C0696.valueOf("P" + Integer.toString(((C0915)cZ().get(var0)).getPais())).getNome()));
      }
   }

   public static void cW() {
      cG = new C0901();
      cG.setVisible(true);
      C0878 var0 = new C0878();
      cG.wJ().setModel(var0);
      cG.wH();
      cG.Vg.setRowSelectionInterval(0, 0);
      if (cG.wI().getJogadores().size() > 0) {
         cG.wJ().setRowSelectionInterval(0, 0);
      }
   }

   public static int G(int i) {
      for (int var1 = 0; var1 < cF.size(); var1++) {
         if (i == ((CountryInfo)cF.get(var1)).getPais()) {
            return var1;
         }
      }

      return 0;
   }

   public static int h(String string) {
      for (int var1 = 0; var1 < cF.size(); var1++) {
         if (string.equals(((CountryInfo)cF.get(var1)).getNome())) {
            return var1;
         }
      }

      return 0;
   }

   public static void a(C0915 c0915) {
      c0915.setNomep(f(C0696.valueOf("P" + Integer.toString(c0915.getPais())).getNome()));
   }

   public static void cX() {
      MainWindow.cX();
   }

   public static int H(int i) {
      return i >= 0 && i < cF.size() ? ((CountryInfo)cF.get(i)).getPais() : 29;
   }

   public static ArrayList cY() {
      return cF;
   }

   public static ArrayList cZ() {
      return cE;
   }

   public static C0901 da() {
      return cG;
   }

   public static JFrame db() {
      return cC;
   }

   public static void a(JFrame jFrame) {
      cC = jFrame;
   }

   public static JFrame dc() {
      return cD;
   }

   public static void b(JFrame jFrame) {
      cD = jFrame;
   }
}
