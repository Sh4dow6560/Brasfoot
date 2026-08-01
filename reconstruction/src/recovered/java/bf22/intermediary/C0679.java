package bf22.intermediary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

public class C0679 {
   private static ArrayList gy = null;
   private static ArrayList gz = null;
   private InputStream gA = this.getClass().getResourceAsStream("/arquivos/default_lang.xml");
   private InputStream gB = this.getClass().getResourceAsStream("/arquivos/ok_bra.txt");
   private static Properties gC = null;

   public C0679(boolean bl) {
      if (bl) {
         this.a(this.it());
      } else {
         this.iu();
      }
   }

   public C0679() {
   }

   public void a(Properties properties) {
      gC = properties;
   }

   public Properties it() {
      Properties var1 = new Properties();

      try {
         var1.loadFromXML(this.gA);
      } catch (FileNotFoundException var3) {
         var3.printStackTrace();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      return var1;
   }

   public void iu() {
      BufferedReader var1 = new BufferedReader(new InputStreamReader(this.gB));

      String var2;
      try {
         while ((var2 = var1.readLine()) != null) {
            C0745.SR.aX().add(var2);
         }
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   public static void iv() {
      String var0 = "E:/Dropbox/JavaProjetos/names/";

      for (int var1 = 0; var1 < C0696.jz(); var1++) {
         String var2 = ((C0697)C0732.cY().get(var1)).jE() + ".txt";
         File var3 = new File(var0 + var2);

         try {
            var3.createNewFile();
         } catch (IOException var5) {
            var5.printStackTrace();
         }
      }
   }

   public static String getString(String string) {
      return gC.getProperty(string);
   }

   public static void iw() {
      InputStream var0 = C0679.class.getClass().getResourceAsStream("/arquivos/default_lang.xml");

      try {
         Properties var1 = new Properties();
         var1.loadFromXML(var0);
         Enumeration var2 = var1.keys();

         while (var2.hasMoreElements()) {
            String var3 = (String)var2.nextElement();
            String var4 = var1.getProperty(var3);
         }
      } catch (FileNotFoundException var5) {
         var5.printStackTrace();
      } catch (IOException var6) {
         var6.printStackTrace();
      }
   }

   public void s(int i, int j) {
      Object var3 = null;
      Object var4 = null;
      int var5 = C0732.G(i);
      String var6 = ((C0697)C0732.cY().get(var5)).jE();
      String var7 = "/arquivos/names/" + var6 + ".txt";
      String var8 = "/arquivos/surnames/" + var6 + ".txt";
      if (j == 1) {
         var7 = var8;
      }

      InputStream var9 = this.getClass().getResourceAsStream(var7);
      BufferedReader var10 = null;
      if (var9 != null) {
         try {
            var10 = new BufferedReader(new InputStreamReader(var9, "UTF-8"));
         } catch (UnsupportedEncodingException var14) {
            var14.printStackTrace();
         }
      }

      int var12 = 0;

      String var11;
      try {
         while ((var11 = var10.readLine()) != null) {
            var12++;
            if (!var11.isEmpty() & !var11.contains(".") & !var11.contains("/") & !var11.contains("(") & !var11.matches(".*\\d+.*")) {
               System.out.println(var12 + ":" + var11);
            }

            System.out.println(var11);
         }
      } catch (IOException var15) {
         var15.printStackTrace();
      }
   }

   public ArrayList a(String string, int i, int j) {
      if (i == 221) {
         i = 85;
      } else if (i == 222) {
         i = 72;
      } else if (i == 223) {
         i = 85;
      }

      if (gy == null || gy.size() < 221) {
         gy = new ArrayList(221);

         for (int var4 = 0; var4 < 222; var4++) {
            gy.add(new ArrayList());
         }
      }

      if (gz == null || gz.size() < 221) {
         gz = new ArrayList(221);

         for (int var11 = 0; var11 < 222; var11++) {
            gz.add(new ArrayList());
         }
      }

      if (gy.get(i) == null) {
         ArrayList var12 = new ArrayList();
         gy.set(i, var12);
      }

      if (gz.get(i) == null) {
         ArrayList var13 = new ArrayList();
         gy.set(i, var13);
      }

      ArrayList var14 = (ArrayList)gy.get(i);
      if (j == 1) {
         var14 = (ArrayList)gz.get(i);
      }

      if (var14 != null && var14.size() == 0) {
         InputStream var5 = this.getClass().getResourceAsStream(string);
         BufferedReader var6 = null;
         if (var5 == null) {
            return null;
         }

         try {
            var6 = new BufferedReader(new InputStreamReader(var5, "UTF-8"));
         } catch (UnsupportedEncodingException var9) {
            var9.printStackTrace();
         }

         String var7;
         try {
            while ((var7 = var6.readLine()) != null) {
               if (!var7.isEmpty() & !var7.contains(".") & !var7.matches(".*\\d+.*")) {
                  var14.add(var7);
               }
            }
         } catch (IOException var10) {
            var10.printStackTrace();
         }
      }

      return var14;
   }

   public String au(int i) {
      String var2 = null;
      String var3 = null;
      ArrayList var4 = null;
      int var5 = C0732.G(i);
      String var6 = ((C0697)C0732.cY().get(var5)).jE();
      String var7 = "/arquivos/names/" + var6 + ".txt";
      String var8 = "/arquivos/surnames/" + var6 + ".txt";
      var4 = this.a(var7, i, 0);
      if (var4 != null && var4.size() > 0) {
         int var9 = new Random().nextInt(var4.size());
         int var10 = 0;
         if (var4.size() >= 1000 && new Random().nextInt(2) == 0) {
            var9 = new Random().nextInt(500);
         }

         if (var9 == 0) {
            var9 = 1;
         }

         var2 = (String)var4.get(var9);
         var10 = q(var2);
         if (var10 == 1) {
            var4 = this.a(var8, i, 1);
            if (var4 != null && var4.size() > 2) {
               int var11 = new Random().nextInt(var4.size());
               if (var11 == 0) {
                  var11 = 1;
               }

               var3 = (String)var4.get(var11);
               if (!var2.equals(var3)) {
                  var2 = var2 + " " + var3;
               }
            }
         } else if (var10 == 2) {
            boolean var18 = false;
            if (new Random().nextInt(2) == 0) {
               var18 = true;
            }

            if (var2.length() <= 12 && var18 && var4 != null && var4.size() > 2) {
               int var12 = new Random().nextInt(var4.size());
               if (var12 == 0) {
                  var12 = 1;
               }

               var3 = (String)var4.get(var12);
               if (!var2.equals(var3) && var3.length() <= 6) {
                  var2 = var2 + " " + var3;
               }
            }
         }
      }

      return var2;
   }

   public String k(int i, boolean bl) {
      String var3 = null;
      String var4 = null;
      ArrayList var5 = null;
      int var6 = C0732.G(i);
      String var7 = ((C0697)C0732.cY().get(var6)).jE();
      String var8 = "/arquivos/names/" + var7 + ".txt";
      String var9 = "/arquivos/surnames/" + var7 + ".txt";
      var5 = this.a(var8, i, 0);
      if (var5 != null && var5.size() > 0) {
         int var10 = new Random().nextInt(var5.size());
         int var11 = 0;
         if (var5.size() >= 1000 && new Random().nextInt(2) == 0) {
            var10 = new Random().nextInt(500);
         }

         if (var10 == 0) {
            var10 = 1;
         }

         var3 = (String)var5.get(var10);
         var11 = q(var3);
         if (var11 == 1) {
            if (bl) {
               var5 = this.a(var9, i, 1);
               if (var5 != null && var5.size() > 2) {
                  int var12 = new Random().nextInt(var5.size());
                  if (var12 == 0) {
                     var12 = 1;
                  }

                  var4 = (String)var5.get(var12);
                  if (!var3.equals(var4)) {
                     var3 = var3 + " " + var4;
                  }
               }
            }
         } else if (var11 == 2) {
            boolean var19 = false;
            if (new Random().nextInt(2) == 0) {
               var19 = true;
            }

            if (!bl) {
               var19 = false;
            }

            if (var3.length() <= 12 && var19 && var5 != null && var5.size() > 2) {
               int var13 = new Random().nextInt(var5.size());
               if (var13 == 0) {
                  var13 = 1;
               }

               var4 = (String)var5.get(var13);
               if (!var3.equals(var4) && var4.length() <= 6) {
                  var3 = var3 + " " + var4;
               }
            }
         }
      }

      return var3;
   }

   public static int q(String string) {
      if (string != null && !string.isEmpty()) {
         String[] var1 = string.split("\\s+");
         return var1.length;
      } else {
         return 0;
      }
   }
}
