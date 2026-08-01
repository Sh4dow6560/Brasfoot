package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class C1007 {
   public static Comparator aaE = new C1008();
   public static Comparator aaF = new C1019();
   public static Comparator aaG = new C1030();
   public static Comparator aaH = new C0999();
   public static Comparator aaI = new C1002();
   public static Comparator aaJ = new C1003();
   public static Comparator aaK = new C1004();
   public static Comparator aaL = new C1005();
   public static Comparator aaM = new C1006();
   public static Comparator aaN = new C1009();
   public static Comparator aaO = new C1010();
   public static Comparator aaP = new C1011();
   public static Comparator aaQ = new C1012();
   public static Comparator aaR = new C1013();
   public static Comparator aaS = new C1014();
   public static Comparator aaT = new C1015();
   public static Comparator aaU = new C1016();
   public static Comparator aaV = new C1017();
   public static Comparator aaW = new C1018();
   public static Comparator aaX = new C1020();
   public static Comparator aaY = new C1021();
   public static Comparator cL = new C1022();
   public static Comparator aaZ = new C1023();
   public static Comparator aba = new C1024();
   public static Comparator abb = new C1025();
   public static Comparator abc = new C1026();
   public static Comparator aab = new C1027();
   public static Comparator VU = new C1028();
   public static Comparator abd = new C1029();
   public static Comparator abe = new C1031();
   public static Comparator abf = new C1032();
   public static Comparator abg = new C0991();
   public static Comparator abh = new C0992();
   public static Comparator abi = new C0993();
   public static Comparator cN = new C0994();
   public static Comparator VS = new C0995();
   public static Comparator abj = new C0996();
   public static Comparator abk = new C0997();
   public static Comparator abl = new C0998();
   public static Comparator abm = new C1000();
   public static Comparator abn = new C1001();

   public static ArrayList ac(int i, int j) {
      ArrayList var2 = new ArrayList();

      for (int var3 = i; var3 <= j; var3++) {
         var2.add(var3);
      }

      Collections.shuffle(var2);
      return var2;
   }

   public static ArrayList Ak() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = ac(0, 5);
      ArrayList var2 = ac(6, 11);
      ArrayList var3 = ac(12, 17);
      ArrayList var4 = ac(18, 23);

      for (int var5 = 0; var5 < 4; var5++) {
         for (int var6 = 0; var6 < 6; var6++) {
            var0.add((Integer)var1.get(var6));
            var0.add((Integer)var2.get(var6));
            var0.add((Integer)var3.get(var6));
            var0.add((Integer)var4.get(var6));
         }
      }

      return var0;
   }

   public static ArrayList Al() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = ac(0, 1);
      ArrayList var2 = ac(2, 3);
      ArrayList var3 = ac(4, 5);
      ArrayList var4 = ac(6, 7);
      ArrayList var5 = ac(8, 9);

      for (int var6 = 0; var6 < 2; var6++) {
         var0.add((Integer)var1.get(var6));
         var0.add((Integer)var2.get(var6));
         var0.add((Integer)var3.get(var6));
         var0.add((Integer)var4.get(var6));
         var0.add((Integer)var5.get(var6));
      }

      return var0;
   }

   public static ArrayList Am() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = ac(0, 1);
      ArrayList var2 = ac(2, 3);
      ArrayList var3 = ac(4, 5);
      ArrayList var4 = ac(6, 7);
      ArrayList var5 = ac(8, 9);
      ArrayList var6 = ac(10, 11);

      for (int var7 = 0; var7 < 2; var7++) {
         var0.add((Integer)var1.get(var7));
         var0.add((Integer)var2.get(var7));
         var0.add((Integer)var3.get(var7));
         var0.add((Integer)var4.get(var7));
         var0.add((Integer)var5.get(var7));
         var0.add((Integer)var6.get(var7));
      }

      return var0;
   }

   public static ArrayList An() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = ac(0, 4);
      ArrayList var2 = ac(5, 9);
      ArrayList var3 = ac(10, 14);
      ArrayList var4 = ac(15, 19);
      ArrayList var5 = ac(20, 24);
      ArrayList var6 = ac(25, 29);

      for (int var7 = 0; var7 < 5; var7++) {
         var0.add((Integer)var1.get(var7));
         var0.add((Integer)var2.get(var7));
         var0.add((Integer)var3.get(var7));
         var0.add((Integer)var4.get(var7));
         var0.add((Integer)var5.get(var7));
         var0.add((Integer)var6.get(var7));
      }

      return var0;
   }

   public static ArrayList Ao() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = ac(0, 8);
      ArrayList var2 = ac(9, 17);
      ArrayList var3 = ac(18, 26);
      ArrayList var4 = ac(27, 35);
      ArrayList var5 = ac(36, 44);
      ArrayList var6 = ac(45, 53);

      for (int var7 = 0; var7 < 9; var7++) {
         var0.add((Integer)var1.get(var7));
         var0.add((Integer)var2.get(var7));
         var0.add((Integer)var3.get(var7));
         var0.add((Integer)var4.get(var7));
         var0.add((Integer)var5.get(var7));
         var0.add((Integer)var6.get(var7));
      }

      return var0;
   }

   public static ArrayList ad(int i, int j) {
      int var2 = i - 1;
      ArrayList var3 = new ArrayList();
      ArrayList var4 = null;
      ArrayList var5 = null;
      ArrayList var6 = null;
      ArrayList var7 = null;
      var4 = ac(0, var2);
      var6 = ac(i, i + var2);
      var5 = ac(2 * i, 2 * i + var2);
      var7 = ac(3 * i, 3 * i + var2);

      for (int var8 = 0; var8 < i; var8++) {
         var3.add((Integer)var4.get(var8));
         var3.add((Integer)var5.get(var8));
         var3.add((Integer)var6.get(var8));
         var3.add((Integer)var7.get(var8));
      }

      return var3;
   }
}
