package mod.recovered.competition;

import mod.recovered.game.ScheduleDay;
import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class FriendlyMatches extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private static int ci = 0;

   public FriendlyMatches() {
      this.F(0, 0);
      this.setNome("Amistoso");
   }

   public static boolean d(Club club, int i) {
      new ArrayList();
      ArrayList var2 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(i)).h();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if (((Match)var2.get(var3)).hc() == club || ((Match)var2.get(var3)).hd() == club) {
            return true;
         }
      }

      return false;
   }

   public static ArrayList L(Club club) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = ScheduleDay.b(100);

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if (((ScheduleDay)GamePersistence.careerState.getScheduleDays().get((Integer)var2.get(var3))).a().after(GamePersistence.careerState.getCurrentDate()) && !d(club, (Integer)var2.get(var3))) {
            var1.add((Integer)var2.get(var3));
         }
      }

      return var1;
   }

   public static ArrayList M(Club club) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = ScheduleDay.b(200);

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if (((ScheduleDay)GamePersistence.careerState.getScheduleDays().get((Integer)var2.get(var3))).a().after(GamePersistence.careerState.getCurrentDate()) && !d(club, (Integer)var2.get(var3))) {
            var1.add((Integer)var2.get(var3));
         }
      }

      return var1;
   }

   public static int a(Club club, Club club2, int i, int j) {
      ci = 0;
      int[] var4 = new int[]{0, 0, 10000, 50000, 150000, 250000};
      int[] var5 = new int[]{0, 0, 20000, 80000, 200000, 450000};
      int[] var6 = new int[]{0, 0, 30000, 100000, 250000, 500000};
      if (d(club2, j)) {
         return 2;
      }

      if (club2.jZ()) {
         return 1;
      }

      if (i == 0) {
         if (club2.getReputacao() == 5 && club.getReputacao() < 4) {
            ci = 300000;
            return 3;
         }

         if (club2.getReputacao() == 5 && club.getReputacao() < 3) {
            return 0;
         }

         if (club2.getReputacao() == 4 && club.getReputacao() < 2) {
            ci = 200000;
            return 3;
         }

         if (club2.getReputacao() == 4 && club.getReputacao() <= 1) {
            return 0;
         }

         if (club.getPais() == club2.getPais()) {
            ci = var4[club2.getReputacao()];
         } else {
            ci = var5[club2.getReputacao()];
         }
      } else {
         if (club2.getReputacao() == 5 && club.getReputacao() != 5) {
            return 0;
         }

         if (club2.getReputacao() == 4 && club.getReputacao() < 2) {
            return 0;
         }

         if (club.getPais() == club2.getPais()) {
            ci = var5[club2.getReputacao()];
         } else {
            ci = var6[club2.getReputacao()];
         }
      }

      return ci > 0 ? 3 : 1;
   }

   public static void b(Club club, Club club2, int i, int j) {
      Club var4 = club;
      Club var5 = club2;
      if (i == 0) {
         var4 = club2;
         var5 = club;
      }

      new Match(null, 0, var4, var5, j, GamePersistence.careerState.bv(), var4.ev());
   }

   public static int xY() {
      return ci;
   }
}
