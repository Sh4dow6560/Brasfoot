package mod.recovered.save;

import bf22.intermediary.*;
import mod.recovered.game.CareerState;
import mod.recovered.manager.CoachJobMarket;
import mod.recovered.ui.MainWindow;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;
import mod.recovered.config.GameOptions;
import mod.recovered.save.SavedGameInfo;

public class GamePersistence {
   static PrintWriter SQ;
   public static CareerState SR = null;
   public static CoachJobMarket afQ = null;
   private static GameOptions SS = null;
   private static int ST = 0;
   public static int SU = 64;
   private static final File[] SV = new File[7];

   public GamePersistence() {
      vI();
      if (SS == null) {
         SS = new GameOptions();
      }

      SR = new CareerState();
      afQ = new CoachJobMarket();
   }

   public static void vH() {
      String[] var0 = new String[]{"intervalo", "fimjogo", "gol1", "goladv", "penalty", "expulsao", "contusao"};

      for (int var1 = 0; var1 < var0.length; var1++) {
         File var2 = new File(System.getProperty("user.dir") + "/sons/" + var0[var1] + ".wav");
         if (var2.exists() && !var2.isDirectory()) {
            SV[var1] = var2;
         }
      }
   }

   public static File dj(int i) {
      String[] var1 = new String[]{"intervalo", "fimjogo", "gol1", "goladv", "penalty", "expulsao", "contusao"};
      if (SV[i] == null) {
         File var2 = new File(System.getProperty("user.dir") + "/sons/" + var1[i] + ".wav");
         if (var2.exists() && !var2.isDirectory()) {
            SV[i] = var2;
            return var2;
         } else {
            return SV[i];
         }
      } else {
         return SV[i];
      }
   }

   public static void ad(String string) {
      C0990.Ag();
      C0990.Ai();
      if (string != null) {
         try {
            FileOutputStream var1 = new FileOutputStream(System.getProperty("user.dir") + "/sav/" + string + ".info");
            ObjectOutputStream var2 = new ObjectOutputStream(var1);
            var2.writeObject(SR.bs());
            var2.flush();
            var2.close();
            var1.close();
         } catch (IOException var3) {
            var3.printStackTrace();
         }
      }
   }

   public static void ae(String string) {
      if (string != null) {
         boolean var1 = false;
         C0990.Ag();
         C0990.Ai();

         try {
            FileOutputStream var2 = new FileOutputStream(System.getProperty("user.dir") + "/sav/" + string + ".info");
            ObjectOutputStream var3 = new ObjectOutputStream(var2);
            var3.writeObject(SR.bs());
            var3.flush();
            var3.close();
            var2.close();
         } catch (IOException var11) {
            var11.printStackTrace();
         }

         try {
            Kryo var12 = new Kryo();
            var12.setRegistrationRequired(false);
            FileOutputStream var14 = new FileOutputStream(System.getProperty("user.dir") + "/sav/" + string + ".s22");
            Output var4 = new Output(var14);
            var12.writeClassAndObject(var4, SR);
            var12.writeClassAndObject(var4, afQ);
            var4.close();
            var1 = true;
         } catch (Exception var10) {
            var10.printStackTrace();
         }

         if (var1) {
            String var13 = System.getProperty("user.dir") + "/sav/" + string + ".s22";
            Path var15 = Paths.get(var13);
            String var16 = System.getProperty("user.dir") + "/sav/" + string + ".sbck";
            Path var5 = Paths.get(var16);
            File var6 = new File(System.getProperty("user.dir") + "/sav/" + string + ".s22");
            boolean var7 = var6.exists();
            if (var7) {
               try {
                  Files.copy(var15, var5, StandardCopyOption.REPLACE_EXISTING);
               } catch (IOException var9) {
                  var9.printStackTrace();
               }
            }
         }
      }
   }

   public static boolean c(String string, boolean bl) {
      vI();
      if (SS == null) {
         SS = new GameOptions();
      }

      String var2 = ".s22";
      if (bl) {
         var2 = ".sbck";
      }

      Kryo var3 = new Kryo();
      if (string != null) {
         try {
            Input var4 = new Input(new FileInputStream(System.getProperty("user.dir") + "/sav/" + string + var2));
            var3.setRegistrationRequired(false);
            SR = (CareerState)var3.readClassAndObject(var4);
            afQ = (CoachJobMarket)var3.readClassAndObject(var4);
            var4.close();
         } catch (Exception var6) {
            var6.printStackTrace();
            if (!bl) {
               c(string, true);
            } else {
               vK();
            }

            return false;
         }
      }

      if (C0732.db() == null) {
         C0990.Ah();
         C0990.Af();
         C0990.Aj();
         SR.bs = true;
         SR.G();
         new C0679(false);
         SR.i(true);
         new MainWindow(false);
         SR.cb();
         SR.ap();
         if (C0732.dc() != null) {
            C0732.dc().dispose();
         }
      }

      return true;
   }

   public static void vI() {
      File var0 = new File(System.getProperty("user.dir") + "/options.bcf");
      if (var0.exists() && !var0.isDirectory()) {
         try {
            FileInputStream var1 = new FileInputStream(System.getProperty("user.dir") + "/options.bcf");
            ObjectInputStream var2 = new ObjectInputStream(var1);
            SS = (GameOptions)var2.readObject();
            var2.close();
            var1.close();
         } catch (IOException var3) {
            var3.printStackTrace();
            return;
         } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
            return;
         }
      } else {
         SS = new GameOptions();
      }
   }

   public static void vJ() {
      try {
         FileOutputStream var0 = new FileOutputStream(System.getProperty("user.dir") + "/options.bcf");
         ObjectOutputStream var1 = new ObjectOutputStream(var0);
         var1.writeObject(SS);
         var1.close();
         var0.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public static SavedGameInfo af(String string) {
      SavedGameInfo var1 = null;
      if (string != null) {
         try {
            FileInputStream var2 = new FileInputStream(System.getProperty("user.dir") + "/sav/" + string + ".info");
            ObjectInputStream var3 = new ObjectInputStream(var2);
            var1 = (SavedGameInfo)var3.readObject();
            var3.close();
            var2.close();
         } catch (IOException var4) {
            var4.printStackTrace();
            return var1;
         } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
            return var1;
         }
      }

      return var1;
   }

   public static SavedGameInfo ag(String string) {
      SavedGameInfo var1 = null;
      if (string != null) {
         try {
            FileInputStream var2 = new FileInputStream(System.getProperty("user.dir") + "/sav/" + string + ".sb19");
            ObjectInputStream var3 = new ObjectInputStream(var2);
            var1 = (SavedGameInfo)var3.readObject();
            var3.close();
            var2.close();
         } catch (IOException var4) {
            var4.printStackTrace();
            return var1;
         } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
            return var1;
         }
      }

      return var1;
   }

   public static void vK() {
      JOptionPane.showMessageDialog(null, "Arquivo inválido: save corrompido ou é de uma versão/build anterior.", "Arquivo inválido", 0);
   }

   public static boolean vL() {
      return ST >= 1920;
   }

   public static GameOptions vM() {
      if (SS == null) {
         SS = new GameOptions();
      }

      return SS;
   }

   public static void ey(int i) {
      ST = i;
   }

   public static void a(CareerState c0723) {
      SR = c0723;
   }
}
