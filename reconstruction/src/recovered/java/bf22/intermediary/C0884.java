package bf22.intermediary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class C0884 {
   public static void iD() {
      File var0 = new File(C0732.cK + "/teams");
      File[] var1 = var0.listFiles(new C0885());

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].isFile()) {
            String var3 = var1[var2].getName();
            var3 = var3.substring(0, var3.lastIndexOf("."));
            e(var1[var2].getPath(), var3);
         }
      }
   }

   public static void e(String string, String string2) {
      new C0915();

      C0915 var2;
      try {
         FileInputStream var3 = new FileInputStream(string);
         ObjectInputStream var4 = new ObjectInputStream(var3);
         var2 = (C0915)var4.readObject();
         var4.close();
         var3.close();
      } catch (IOException var5) {
         var5.printStackTrace();
         return;
      } catch (ClassNotFoundException var6) {
         var6.printStackTrace();
         return;
      }

      if (var2.getVid() == 185) {
         var2.setFileRef(string2);
         C0732.cZ().add(var2);
      }
   }
}
