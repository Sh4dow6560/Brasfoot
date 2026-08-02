package mod.recovered.transfer;

import bf22.intermediary.C0670;
import bf22.intermediary.C0983;
import java.util.ArrayList;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.model.Player;
import mod.recovered.save.GamePersistence;

public class PlayerSearchCriteria {
   private String namePrefix = null;
   private int position = -1;
   private int side = -1;
   private int overallStrengthFilterIndex = -1;
   private int ageFilterIndex = -1;
   private int marketValueRangeIndex = -1;
   private int primaryCharacteristic = -1;
   private int secondaryCharacteristic = -1;
   private int countryId = -1;
   private int loadedCountryIndex = -1;
   private int minOverallStrength = -1;
   private int maxOverallStrength = -1;
   private int minAge = -1;
   private int maxAge = -1;
   private int goalkeepingFilterIndex = -1;
   private int minGoalkeeping = -1;
   private int maxGoalkeeping = -1;
   private int speedFilterIndex = -1;
   private int minSpeed = -1;
   private int maxSpeed = -1;
   private int playmakingFilterIndex = -1;
   private int minPlaymaking = -1;
   private int maxPlaymaking = -1;
   private int passingFilterIndex = -1;
   private int minPassing = -1;
   private int maxPassing = -1;
   private int tacklingFilterIndex = -1;
   private int minTackling = -1;
   private int maxTackling = -1;
   private int finishingFilterIndex = -1;
   private int minFinishing = -1;
   private int maxFinishing = -1;
   private int techniqueFilterIndex = -1;
   private int minTechnique = -1;
   private int maxTechnique = -1;
   private boolean requireStarPlayer = false;
   private boolean requireWorldClassPlayer = false;
   private boolean requireAvailableForLoan = false;
   private boolean requireTransferListed = false;
   private int[][] overallStrengthRanges = new int[][]{
      {1, 10}, {11, 30}, {31, 50}, {51, 70}, {71, 100}
   };
   private int[][] ageRanges = new int[][]{{16, 25}, {26, 36}, {37, 60}};
   private int[][] marketValueRanges = new int[][]{
      {1, 100999},
      {101000, 500999},
      {501000, 1000000},
      {1000001, 3000000},
      {3000001, 5000000},
      {5000001, 10000000},
      {10000000, 1000000000}
   };
   private ArrayList loadedCountryIds = new ArrayList();

   public ArrayList findPlayers(boolean includeGeneratedPlayers) {
      ArrayList players = new ArrayList();
      if (this.loadedCountryIndex >= 0) {
         this.loadedCountryIds.clear();

         for (int index = 0; index < GamePersistence.careerState.N().size(); index++) {
            this.loadedCountryIds.add(
               ((CountryCompetitions)GamePersistence.careerState.N().get(index)).jc()
            );
         }
      }

      for (int index = 0; index < GamePersistence.careerState.O().size(); index++) {
         Player player = (Player)GamePersistence.careerState.O().get(index);
         if (this.matches(player)) {
            players.add(player);
         }
      }

      if (includeGeneratedPlayers) {
         for (int index = 0; index < GamePersistence.careerState.bN().size(); index++) {
            Player player = (Player)GamePersistence.careerState.bN().get(index);
            if (this.matches(player)) {
               players.add(player);
            }
         }
      }

      return players;
   }

   public void setAttributeRange(String attribute, int minimum, int maximum) {
      if (attribute.equals("gol")) {
         this.goalkeepingFilterIndex = 0;
         this.minGoalkeeping = minimum;
         this.maxGoalkeeping = maximum;
      } else if (attribute.equals("des")) {
         this.tacklingFilterIndex = 0;
         this.minTackling = minimum;
         this.maxTackling = maximum;
      } else if (attribute.equals("vel")) {
         this.speedFilterIndex = 0;
         this.minSpeed = minimum;
         this.maxSpeed = maximum;
      } else if (attribute.equals("fin")) {
         this.finishingFilterIndex = 0;
         this.minFinishing = minimum;
         this.maxFinishing = maximum;
      } else if (attribute.equals("arm")) {
         this.playmakingFilterIndex = 0;
         this.minPlaymaking = minimum;
         this.maxPlaymaking = maximum;
      } else if (attribute.equals("tec")) {
         this.techniqueFilterIndex = 0;
         this.minTechnique = minimum;
         this.maxTechnique = maximum;
      } else if (attribute.equals("pas")) {
         this.passingFilterIndex = 0;
         this.minPassing = minimum;
         this.maxPassing = maximum;
      }
   }

   private boolean matches(Player player) {
      if (this.position >= 0 && player.getPosicao() != this.position) {
         return false;
      }
      if (this.side >= 0 && player.getLado() != this.side) {
         return false;
      }
      if (this.overallStrengthFilterIndex >= 0
         && (player.getOverallStrength() < this.minOverallStrength
            || player.getOverallStrength() > this.maxOverallStrength)) {
         return false;
      }
      if (this.ageFilterIndex >= 0
         && (player.getIdade() < this.minAge || player.getIdade() > this.maxAge)) {
         return false;
      }
      if (this.goalkeepingFilterIndex >= 0
         && (player.getGoalkeeping() < this.minGoalkeeping
            || player.getGoalkeeping() > this.maxGoalkeeping)) {
         return false;
      }
      if (this.playmakingFilterIndex >= 0
         && (player.getPlaymaking() < this.minPlaymaking
            || player.getPlaymaking() > this.maxPlaymaking)) {
         return false;
      }
      if (this.techniqueFilterIndex >= 0
         && (player.getTechnique() < this.minTechnique
            || player.getTechnique() > this.maxTechnique)) {
         return false;
      }
      if (this.speedFilterIndex >= 0
         && (player.getSpeed() < this.minSpeed || player.getSpeed() > this.maxSpeed)) {
         return false;
      }
      if (this.finishingFilterIndex >= 0
         && (player.getFinishing() < this.minFinishing
            || player.getFinishing() > this.maxFinishing)) {
         return false;
      }
      if (this.tacklingFilterIndex >= 0
         && (player.getTackling() < this.minTackling
            || player.getTackling() > this.maxTackling)) {
         return false;
      }
      if (this.passingFilterIndex >= 0
         && (player.getPassing() < this.minPassing || player.getPassing() > this.maxPassing)) {
         return false;
      }
      if (this.marketValueRangeIndex >= 0
         && (player.getMarketValue() < this.marketValueRanges[this.marketValueRangeIndex][0]
            || player.getMarketValue() > this.marketValueRanges[this.marketValueRangeIndex][1])) {
         return false;
      }
      if (this.primaryCharacteristic >= 0
         && player.getCr1() != this.primaryCharacteristic) {
         return false;
      }
      if (this.secondaryCharacteristic >= 0
         && player.getCr2() != this.secondaryCharacteristic) {
         return false;
      }
      if (this.countryId >= 0 && player.getPais() != this.countryId) {
         return false;
      }
      if (this.loadedCountryIndex >= 0
         && player.getClub() != null
         && this.loadedCountryIndex < this.loadedCountryIds.size()
         && player.getClub().getPais()
            != (Integer)this.loadedCountryIds.get(this.loadedCountryIndex)) {
         return false;
      }
      if (this.requireStarPlayer && !player.isStarPlayer()) {
         return false;
      }
      if (this.requireWorldClassPlayer && !player.isWorldClassPlayer()) {
         return false;
      }
      if (this.requireAvailableForLoan && !player.isAvailableForLoan()) {
         return false;
      }
      if (this.requireTransferListed && !player.isTransferListed()) {
         return false;
      }
      return this.namePrefix == null
         || this.namePrefix.isEmpty()
         || this.namePrefix.length() <= 0
         || this.namePrefix.length() <= player.getNome().length()
            && this.namePrefix.equalsIgnoreCase(
               C0670.f(player.getNome()).substring(0, this.namePrefix.length())
            );
   }

   public void setNamePrefix(String namePrefix) {
      if (namePrefix != null && !namePrefix.isEmpty()) {
         namePrefix = C0670.f(namePrefix);
      }

      this.namePrefix = namePrefix;
   }

   public void setPosition(int position) {
      this.position = position;
   }

   public void setSide(int side) {
      this.side = side;
   }

   public void setOverallStrengthFilterIndex(int filterIndex) {
      this.overallStrengthFilterIndex = filterIndex;
   }

   public void setAgeFilterIndex(int filterIndex) {
      this.ageFilterIndex = filterIndex;
   }

   public void setMarketValueRangeIndex(int rangeIndex) {
      this.marketValueRangeIndex = rangeIndex;
   }

   public void setPrimaryCharacteristic(int characteristic) {
      this.primaryCharacteristic = characteristic;
   }

   public void setSecondaryCharacteristic(int characteristic) {
      this.secondaryCharacteristic = characteristic;
   }

   public void setCountryId(int countryId) {
      this.countryId = countryId;
   }

   public void setLoadedCountryIndex(int countryIndex) {
      this.loadedCountryIndex = countryIndex;
   }

   public void setRequireStarPlayer(boolean required) {
      this.requireStarPlayer = required;
   }

   public void setRequireWorldClassPlayer(boolean required) {
      this.requireWorldClassPlayer = required;
   }

   public void setRequireAvailableForLoan(boolean required) {
      this.requireAvailableForLoan = required;
   }

   public void setRequireTransferListed(boolean required) {
      this.requireTransferListed = required;
   }

   public static int getRegistrationValue(int index) {
      return C0983.eT(index);
   }

   public int getGoalkeepingFilterIndex() {
      return this.goalkeepingFilterIndex;
   }

   public void setGoalkeepingFilterIndex(int filterIndex) {
      this.goalkeepingFilterIndex = filterIndex;
   }

   public int getSpeedFilterIndex() {
      return this.speedFilterIndex;
   }

   public void setSpeedFilterIndex(int filterIndex) {
      this.speedFilterIndex = filterIndex;
   }

   public int getPlaymakingFilterIndex() {
      return this.playmakingFilterIndex;
   }

   public void setPlaymakingFilterIndex(int filterIndex) {
      this.playmakingFilterIndex = filterIndex;
   }

   public int getPassingFilterIndex() {
      return this.passingFilterIndex;
   }

   public void setPassingFilterIndex(int filterIndex) {
      this.passingFilterIndex = filterIndex;
   }

   public int getTacklingFilterIndex() {
      return this.tacklingFilterIndex;
   }

   public void setTacklingFilterIndex(int filterIndex) {
      this.tacklingFilterIndex = filterIndex;
   }

   public int getFinishingFilterIndex() {
      return this.finishingFilterIndex;
   }

   public void setFinishingFilterIndex(int filterIndex) {
      this.finishingFilterIndex = filterIndex;
   }

   public int getTechniqueFilterIndex() {
      return this.techniqueFilterIndex;
   }

   public void setTechniqueFilterIndex(int filterIndex) {
      this.techniqueFilterIndex = filterIndex;
   }

   public void setMinOverallStrength(int minimum) {
      this.minOverallStrength = minimum;
   }

   public void setMaxOverallStrength(int maximum) {
      this.maxOverallStrength = maximum;
   }

   public void setMinAge(int minimum) {
      this.minAge = minimum;
   }

   public void setMaxAge(int maximum) {
      this.maxAge = maximum;
   }
}
