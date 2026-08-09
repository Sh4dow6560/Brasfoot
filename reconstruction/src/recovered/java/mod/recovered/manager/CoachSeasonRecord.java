package mod.recovered.manager;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import mod.recovered.model.Club;

public class CoachSeasonRecord implements Serializable {
   private static final long serialVersionUID = 1L;
   private int seasonNumber;
   private int clubId = -1;
   private int matchCount;
   private int winCount;
   private int lossCount;
   private int careerScore;
   private int titleCount;

   public CoachSeasonRecord() {
   }

   public CoachSeasonRecord(Club club) {
      this.seasonNumber = GamePersistence.careerState.getSeasonNumber();
      if (club != null) {
         this.clubId = club.getClubId();
      }
   }

   public String getClubName() {
      Object var1 = null;
      if (var1 == null) {
         for (int var2 = 0; var2 < GamePersistence.careerState.P().size(); var2++) {
            if (((Club)GamePersistence.careerState.P().get(var2)).getClubId() == this.clubId) {
               return ((Club)GamePersistence.careerState.P().get(var2)).getNome();
            }
         }
      }

      if (var1 == null) {
         for (int var3 = 0; var3 < GamePersistence.careerState.aG().size(); var3++) {
            if (((CountryCompetitions)GamePersistence.careerState.aG().get(var3)).jn() != null && ((CountryCompetitions)GamePersistence.careerState.aG().get(var3)).jn().getClubId() == this.clubId) {
               return ((CountryCompetitions)GamePersistence.careerState.aG().get(var3)).jn().getNome();
            }
         }
      }

      return (String)var1;
   }

   public int getSeasonNumber() {
      return this.seasonNumber;
   }

   public void setSeasonNumber(int i) {
      this.seasonNumber = i;
   }

   public int getMatchCount() {
      return this.matchCount;
   }

   public void incrementMatchCount() {
      this.matchCount++;
   }

   public int getWinCount() {
      return this.winCount;
   }

   public void incrementWinCount() {
      this.winCount++;
   }

   public int getLossCount() {
      return this.lossCount;
   }

   public void incrementLossCount() {
      this.lossCount++;
   }

   public int getCareerScore() {
      return this.careerScore;
   }

   public void addCareerScore(int i) {
      this.careerScore += i;
   }

   public int getTitleCount() {
      return this.titleCount;
   }

   public void incrementTitleCount() {
      this.titleCount++;
   }

   public int getClubId() {
      return this.clubId;
   }

   public void setClubId(int i) {
      this.clubId = i;
   }
}
