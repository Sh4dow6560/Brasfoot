package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.util.Random;
import javax.swing.JProgressBar;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public abstract class C0677 {
   public static void a(boolean bl, Player player, Club club) {
      int var3 = 5;
      if (club.kn()) {
         if (club.getDivisao() < 1) {
            var3 = (byte)5;
         } else if (club.getDivisao() == 1) {
            var3 = (byte)22;
         } else if (club.getDivisao() == 2) {
            var3 = (byte)17;
         } else if (club.getDivisao() == 3) {
            var3 = (byte)14;
         } else {
            var3 = (byte)7;
         }

         if (club.gg() == 0) {
            var3 += 5;
         }
      } else {
         if (club.getReputation() == 5) {
            var3 = (byte)20;
         } else if (club.getReputation() == 4) {
            var3 = (byte)15;
         } else if (club.getReputation() == 3) {
            var3 = (byte)12;
         } else if (club.getReputation() == 2) {
            var3 = (byte)7;
         } else {
            var3 = (byte)5;
         }

         if (club.gg() == 0) {
            var3 += 5;
         }
      }

      var3 += new Random().nextInt(5);
      int var4 = player.fE();
      if (var4 > 100) {
         var4 = 100;
      }

      double var5 = var4 / 100.0;
      int var7 = (int)Math.round(var3 * var5);
      int var8 = player.fH() + var7;
      if (player.fH() >= 9) {
         var8 += new Random().nextInt(10);
      }

      player.setOverallStrength(var8);
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         byte var9 = 1;
         if (club.kn()) {
            switch (club.getDivisao()) {
               case 1:
                  var9 = 7;
                  break;
               case 2:
                  var9 = 3;
                  break;
               case 3:
                  var9 = 1;
            }
         } else {
            switch (club.getReputation()) {
               case 1:
                  var9 = 1;
                  break;
               case 2:
                  var9 = 1;
                  break;
               case 3:
                  var9 = 1;
                  break;
               case 4:
                  var9 = 4;
                  break;
               case 5:
                  var9 = 7;
            }
         }

         int var10 = var8 - 5;
         if (var10 < 5) {
            var10 = 5;
         }

         player.j(var10, var9);
      }

      player.setYouthPlayer(false);
      player.ar(GamePersistence.careerState.getSeasonNumber());
      player.d(0.0);
      player.renewContract(180L, true);
      player.fK();
      player.fJ();
      if (player.isStarPlayer()) {
         if (new Random().nextInt(3) == 1) {
            player.setStarPlayer(true);
         } else {
            player.setStarPlayer(false);
         }
      } else if (player.isWorldClassPlayer()) {
         player.setStarPlayer(true);
         player.setWorldClassPlayer(false);
      } else if (new Random().nextInt(200) == 1) {
         player.setStarPlayer(true);
      }

      if (player.isStarPlayer() && player.fH() < 8) {
         player.aq(8);
      }

      club.getYouthPlayers().remove(player);
      club.getYouthPlayers().remove(player);
      if (bl) {
         GamePersistence.careerState.bA.remove(player);
      }

      if (!club.getSeniorPlayers().contains(player)) {
         club.getSeniorPlayers().add(player);
      }

      if (!GamePersistence.careerState.O().contains(player)) {
         GamePersistence.careerState.O().add(player);
      }

      if (bl) {
         GamePersistence.careerState.bB.add(player);
      } else {
         GamePersistence.careerState.Q().remove(player);
      }

      player.b((JProgressBar)null);
   }

   public static void r(int i, int j) {
      int[] var2 = new int[]{3, 4, 4, 5, 4};

      for (int var3 = 0; var3 < var2.length; var3++) {
         for (int var4 = 0; var4 < var2[var3]; var4++) {
            Player var5 = new Player(i);
            a(j, var5, var3);
         }
      }
   }

   private static void a(int i, Player player, int j) {
      int var3 = 15;
      player.setPosicao(j);
      if (i <= 15) {
         var3 = i;
      } else {
         switch (i) {
            case 16:
               var3 = 17;
               break;
            case 17:
               var3 = 18;
               break;
            case 18:
               var3 = 19;
               break;
            case 19:
               var3 = 21;
               break;
            case 20:
               var3 = 25;
               break;
            case 21:
               var3 = 26;
               break;
            case 22:
               var3 = 27;
               break;
            case 23:
               var3 = 28;
               break;
            case 24:
               var3 = 29;
               break;
            case 25:
               var3 = 30;
               break;
            default:
               var3 = 0;
         }
      }

      var3 = var3 - 5 + new Random().nextInt(8);
      player.setOverallStrength(var3);
      player.setYouthPlayer(false);
      player.ar(GamePersistence.careerState.getSeasonNumber());
      player.d(0.0);
      player.renewContract(180L, true);
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         int var9 = 1;
         byte var4 = 1;
         if (i <= 15) {
            var9 = i;
         } else {
            switch (i) {
               case 16:
                  var9 = 17;
                  break;
               case 17:
                  var9 = 18;
                  break;
               case 18:
                  var9 = 19;
                  break;
               case 19:
                  var9 = 21;
                  break;
               case 20:
                  var9 = 25;
                  break;
               case 21:
                  var9 = 26;
                  break;
               case 22:
                  var9 = 27;
                  break;
               case 23:
                  var9 = 28;
                  break;
               case 24:
                  var9 = 29;
                  break;
               case 25:
                  var9 = 30;
                  break;
               default:
                  var9 = 0;
            }
         }

         if (i >= 20) {
            var4 = 7;
         } else if (i >= 19) {
            var4 = 4;
         } else if (i >= 17) {
            var4 = 1;
         } else {
            var4 = 1;
         }

         int var5 = var9;
         byte var6 = var4;
         if (var5 > 4) {
            var5 -= 4;
         }

         player.j(var5, var6);
      }

      int[] var12 = Player.at(j);
      player.setCr1(var12[0]);
      player.setCr2(var12[1]);
      player.aq(new Random().nextInt(4) + 7);
      player.setIdade(new Random().nextInt(12) + 18);
      player.setLado(new Random().nextInt(2));
      player.setStatus(0);
      player.fG();
      player.fK();
      player.fJ();
   }

   public static void in() {
      Double[] var0 = new Double[]{58.0, 18.0, 3.0};
      Double var1 = 2.0 * var0[2];
      C0670.m(C0698.getNome());
      C0670.eS();
      Double[] var10000 = new Double[]{82.0, 22.0};
      var10000 = new Double[]{70.0, 10.0};
      var10000 = new Double[]{40.0, 20.0};
      byte var5 = 0;
      byte var6 = 1;
      byte var7 = 0;
      int[] var8 = new int[2];
      int[] var9 = new int[2];
      C0684.eT();
      Double var10 = 2.0 * var6;
      Double var11 = 4.0 * var6;
      C0734.dv();
      int var12 = (int)Math.round(var6 / var0[1]);
      int var13 = (int)Math.round(var6 / var0[2]);

      for (int var14 = 0; var14 < var6; var14++) {
         if (var7 == 3) {
            var8[var5]++;
            var9[var5]++;
         }

         if (var7 == 2) {
            var9[var5]++;
         }

         if (var5 == 0) {
            var5 = 1;
         } else {
            var5 = 0;
         }
      }

      if (C0734.du() < 8) {
         C0137.pg();
      }

      Double var17 = 123.0;
      if (var17 < var1) {
         throw new IllegalArgumentException("The upper limit, " + var17 + "must be equal to or greater than the location parameter, " + var1);
      }

      if (var11 <= 0.0) {
         throw new IllegalArgumentException("The scale parameter, " + var11 + "must be greater than zero");
      }

      if (var10 <= 0.0) {
         throw new IllegalArgumentException("The shape parameter, " + var10 + "must be greater than zero");
      }

      double var15 = 0.0;
      if (var11 > 0.0) {
         var15 = (var17 - var1) / var11;
      }

      C0671.a(var15);
      if (var15 == C0827.tX()) {
         C0691.x(true);
      }
   }
}
