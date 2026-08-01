package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import mod.recovered.model.Club;

public class C0687 {
   private static transient int hj = 0;

   public static void w(boolean bl) {
      File var1 = new File(System.getProperty("user.dir") + "/teams");
      File[] var2 = var1.listFiles(new C0688());
      if (var2 != null) {
         for (int var3 = 0; var3 < var2.length; var3++) {
            if (var2[var3].isFile()) {
               String var4 = var2[var3].getName();
               var4 = var4.substring(0, var4.lastIndexOf("."));

               try {
                  a(var2[var3].getPath(), var4, bl);
               } catch (Exception var6) {
               }
            }
         }
      }
   }

   public static void a(String string, String string2, boolean bl) {
      new C0915();

      C0915 var3;
      try {
         FileInputStream var4 = new FileInputStream(string);
         ObjectInputStream var5 = new ObjectInputStream(var4);
         var3 = (C0915)var5.readObject();
         var5.close();
         var4.close();
      } catch (IOException var6) {
         var6.printStackTrace();
         return;
      } catch (ClassNotFoundException var7) {
         var7.printStackTrace();
         return;
      }

      try {
         if (bl) {
            new Club(var3);
         } else if (var3.getVid() == 185) {
            boolean var9 = false;
            if (var9) {
               if (var3.getPais() == 29 && hj < 24) {
                  var3.setPais(218);
                  hj++;
               } else if (var3.getPais() == 29 && hj < 48) {
                  var3.setPais(220);
                  hj++;
               }
            }

            var3.setFileRef(string2);
            if (var3.isValid()) {
               if (var3.getPais() >= 0 && var3.getPais() < GamePersistence.SR.bD.length) {
                  GamePersistence.SR.bD[var3.getPais()]++;
                  if (var3.getPais() == 29) {
                     GamePersistence.SR.bE[var3.getEstado()]++;
                  }
               }

               GamePersistence.SR.bC.add(var3);
            }
         }
      } catch (Exception var8) {
      }
   }
}
