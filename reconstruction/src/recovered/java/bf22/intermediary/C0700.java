package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public abstract class C0700 {
   private static transient ArrayList mT = new ArrayList();

   public static void jO() {
      jS();
      jU();
      jR();
      jP();
      jT();
   }

   public static void jP() {
      for (int var0 = 0; var0 < C0745.SR.aG().size(); var0++) {
         if (((C0692)C0745.SR.aG().get(var0)).jn() != null) {
            if (!((C0692)C0745.SR.aG().get(var0)).jn().jZ()) {
               ((C0692)C0745.SR.aG().get(var0)).z(false);
            } else {
               for (int var1 = 2; var1 < ((C0692)C0745.SR.aG().get(var0)).jn().kc().size(); var1++) {
                  if (((Player)((C0692)C0745.SR.aG().get(var0)).jn().kc().get(var1)).fg() == null) {
                     ((C0692)C0745.SR.aG().get(var0)).jn().kc().remove(((Player)((C0692)C0745.SR.aG().get(var0)).jn().kc().get(var1)).fg());
                  }
               }
            }
         }
      }
   }

   public static void jQ() {
      C0745.SR.bn().clear();

      for (int var0 = 0; var0 < C0745.SR.L().size(); var0++) {
         if (((Coach)C0745.SR.L().get(var0)).fg() != null) {
            ((Coach)C0745.SR.L().get(var0)).lS();
         }
      }

      Coach var4 = null;

      for (int var1 = 0; var1 < C0745.SR.L().size(); var1++) {
         if (((Coach)C0745.SR.L().get(var1)).fg() != null && !((Coach)C0745.SR.L().get(var1)).jZ() && ((Coach)C0745.SR.L().get(var1)).lR() >= 1) {
            var4 = (Coach)C0745.SR.L().get(var1);
            int var2 = 0;

            for (int var3 = var4.lO().size() - 1; var3 >= 0; var3--) {
               if (((C0728)var4.lO().get(var3)).H() == C0745.SR.H() - 1) {
                  var2 = (int)(((C0728)var4.lO().get(var3)).cm() * 100.0F / ((C0728)var4.lO().get(var3)).w());
                  break;
               }
            }

            if (new Random().nextInt(90) + 1 > var2) {
               ((Coach)C0745.SR.L().get(var1)).fg().kE();
            }
         }
      }
   }

   public static void jR() {
      for (int var0 = 0; var0 < C0745.SR.P().size(); var0++) {
         if (!((Club)C0745.SR.P().get(var0)).jZ()) {
            ((Club)C0745.SR.P().get(var0)).ku();
         }
      }
   }

   public static void jS() {
      for (int var0 = 0; var0 < C0745.SR.N().size(); var0++) {
         for (int var1 = 0; var1 < ((C0692)C0745.SR.N().get(var0)).eb().size(); var1++) {
            for (int var2 = 0; var2 < ((C0924)((C0692)C0745.SR.N().get(var0)).eb().get(var1)).yi().yK().size(); var2++) {
               if (!((Club)((C0924)((C0692)C0745.SR.N().get(var0)).eb().get(var1)).yi().yK().get(var2)).jZ()) {
                  a((Club)((C0924)((C0692)C0745.SR.N().get(var0)).eb().get(var1)).yi().yK().get(var2), var2, true);
               }
            }
         }
      }
   }

   public static void b(C0955 c0955) {
      for (int var1 = 0; var1 < c0955.yK().size(); var1++) {
         if (!((Club)c0955.yK().get(var1)).jZ()) {
            a((Club)c0955.yK().get(var1), var1, true);
         }
      }
   }

   public static void jT() {
      boolean var0 = false;
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < C0745.SR.P().size(); var2++) {
         var0 = false;
         if (!((Club)C0745.SR.P().get(var2)).jZ()) {
            if (((Club)C0745.SR.P().get(var2)).gg() != 0 && ((Club)C0745.SR.P().get(var2)).getReputacao() < 5) {
               var0 = true;
            } else if (((Club)C0745.SR.P().get(var2)).gg() == 0 && ((Club)C0745.SR.P().get(var2)).getReputacao() < 4) {
               var0 = true;
            }
         }

         if (var0) {
            for (int var3 = 0; var3 < ((Club)C0745.SR.P().get(var2)).kc().size(); var3++) {
               if (((Player)((Club)C0745.SR.P().get(var2)).kc().get(var3)).fi() > 50
                  && ((Player)((Club)C0745.SR.P().get(var2)).kc().get(var3)).getIdade() < 31
                  && ((Player)((Club)C0745.SR.P().get(var2)).kc().get(var3)).ff()
                  && new Random().nextInt(100) > 25) {
                  var1.add((Player)((Club)C0745.SR.P().get(var2)).kc().get(var3));
               }
            }
         }
      }

      for (int var6 = 0; var6 < var1.size(); var6++) {
         C0730 var7 = new C0730((Player)var1.get(var6), ((Player)var1.get(var6)).fk(), false, true, 2);
         var7.a(false, false);
         if (var7.cK() != null) {
            ((Player)var1.get(var6)).a(var7.cK(), ((Player)var1.get(var6)).fk(), false, false, false);
         }

         if (var7.cK() == null) {
            C0730 var4 = new C0730((Player)var1.get(var6), ((Player)var1.get(var6)).fk(), false, true, 2);
            var4.k(false);
            if (var4.cK() != null) {
               ((Player)var1.get(var6)).a(var4.cK(), ((Player)var1.get(var6)).fk(), false, false, false);
            }
         }
      }
   }

   private static void jU() {
      for (int var0 = 0; var0 < C0745.SR.P().size(); var0++) {
         if (!((Club)C0745.SR.P().get(var0)).kn() && !((Club)C0745.SR.P().get(var0)).jZ()) {
            a((Club)C0745.SR.P().get(var0), var0, false);
         }
      }
   }

   private static void a(Club club, int i, boolean bl) {
      byte var3 = 0;
      if (i <= 1) {
         var3 = 1;
      } else if (i <= 5) {
         var3 = 2;
      } else if (i <= 10) {
         var3 = 3;
      } else {
         var3 = 4;
      }

      for (int var4 = 0; var4 < var3; var4++) {
         a(club, bl, true);
      }

      for (int var6 = 0; var6 < var3; var6++) {
         a(club, bl, false);
      }
   }

   private static void a(Club club, boolean bl, boolean bl2) {
      Player var3 = null;
      int[] var4 = club.J(true);
      int[] var5 = new int[]{4, 5, 5, 10, 8, 0};
      int[] var6 = new int[]{3, 4, 4, 8, 6, 0};
      int[] var7 = new int[]{3, 4, 4, 6, 4, 0};
      ArrayList var8 = new ArrayList();

      for (int var9 = 0; var9 <= 4; var9++) {
         var8.add(var9);
      }

      Collections.shuffle(var8);
      int var15 = -1;
      if (bl2) {
         for (int var10 = 0; var10 < var8.size(); var10++) {
            if (var4[(Integer)var8.get(var10)] >= var5[(Integer)var8.get(var10)]) {
               var15 = (Integer)var8.get(var10);
               break;
            }
         }

         if (var15 == -1) {
            for (int var16 = 0; var16 < var8.size(); var16++) {
               if (var4[(Integer)var8.get(var16)] >= var6[(Integer)var8.get(var16)]) {
                  var15 = (Integer)var8.get(var16);
                  break;
               }
            }
         }
      } else {
         for (int var17 = 0; var17 < var8.size(); var17++) {
            if (var4[(Integer)var8.get(var17)] > var7[(Integer)var8.get(var17)]) {
               var15 = (Integer)var8.get(var17);
               break;
            }
         }
      }

      boolean var18 = false;
      if (new Random().nextInt(100) > 10) {
         var18 = true;
      }

      if (var15 >= 0) {
         ArrayList var11 = new ArrayList();

         for (int var12 = 0; var12 < club.kc().size(); var12++) {
            if (((Player)club.kc().get(var12)).getPosicao() == var15
               && !((Player)club.kc().get(var12)).gl()
               && (!((Player)club.kc().get(var12)).ff() || ((Player)club.kc().get(var12)).ff() == var18)) {
               var11.add((Player)club.kc().get(var12));
            }
         }

         if (var11.size() > 0) {
            Collections.shuffle(var11);
            var3 = (Player)var11.get(0);
         }
      }

      if (var3 != null) {
         boolean var19 = true;
         boolean var20 = false;
         byte var13 = 0;
         if (bl) {
            if (var3.fi() < 40 && new Random().nextInt(100) > 90) {
               var19 = false;
            }
         } else {
            var19 = false;
            if (var3.ff() && new Random().nextInt(100) > 30) {
               var19 = true;
               var13 = 1;
               var20 = true;
            } else if (var3.fi() >= 90 && new Random().nextInt(100) > 30) {
               var19 = true;
               var13 = 1;
               var20 = true;
            } else if (var3.fi() >= 80 && var3.fi() < 90 && new Random().nextInt(100) > 35) {
               var19 = true;
               var13 = 1;
               var20 = true;
            } else if (var3.fi() >= 70 && var3.fi() < 80 && new Random().nextInt(100) > 45) {
               var19 = true;
               var13 = 1;
               var20 = true;
            } else if (var3.fi() >= 60 && var3.fi() < 70 && new Random().nextInt(100) > 75) {
               var19 = true;
               var13 = 1;
               var20 = true;
            } else if (var3.fi() < 60 && new Random().nextInt(100) > 95) {
               var19 = true;
               var13 = 1;
               var20 = true;
            }
         }

         C0730 var14 = new C0730(var3, var3.fk(), false, true, var13);
         if (var19) {
            var14.a(false, false);
         } else {
            var14.k(false);
         }

         if (var14.cK() != null) {
            var3.a(var14.cK(), var3.fk(), false, false, false);
         }
      }
   }
}
