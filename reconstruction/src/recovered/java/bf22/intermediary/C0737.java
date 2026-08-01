package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.util.ArrayList;
import javax.swing.JPanel;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public abstract class C0737 {
   private static ArrayList cP = new ArrayList();
   private static ArrayList cQ = new ArrayList();
   private static JPanel cR = null;
   private static ArrayList cS = new ArrayList();
   private static C0741 cT = null;
   private static int cU = -1;
   private static int cV = -1;
   private static Competition cW = null;

   public static boolean dw() {
      boolean var0 = false;
      int var1 = -1;
      int var2 = -1;
      boolean[] var3 = GamePersistence.careerState.getVerJint();

      for (int var4 = 0; var4 < GamePersistence.careerState.getCurrentMatches().size(); var4++) {
         if (var1 == -1) {
            var1 = ((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition().b();
            var2 = ((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition().el();
         }

         if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getHomeClub().jZ() || ((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getAwayClub().jZ()) {
            var0 = true;
            break;
         }
      }

      if (!var0) {
         if (var1 == 0) {
            return false;
         }

         int var5 = GamePersistence.careerState.ae(var1, var2);
         if (var5 < var3.length) {
            return var3[var5];
         }
      }

      return true;
   }

   public static boolean b(Competition c0713) {
      int var1 = c0713.b();
      int var2 = c0713.gg();
      boolean[] var3 = GamePersistence.careerState.getVerJint();

      for (int var4 = 0; var4 < GamePersistence.careerState.getCurrentMatches().size(); var4++) {
         if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition() == c0713 && (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getHomeClub().jZ() || ((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getAwayClub().jZ())) {
            return true;
         }
      }

      if (var1 == 0) {
         return false;
      }

      int var5 = GamePersistence.careerState.ae(var1, var2);
      return var5 < var3.length ? var3[var5] : true;
   }

   public static void dx() {
      cS.clear();
      cU = -1;
      cV = -1;
      cW = null;
      cP.clear();
      cP.addAll(((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).t());
      if (cP.size() > 0) {
         if (GamePersistence.careerState.bs) {
            cR = MainWindow.aY(4);
         }

         if (((Competition)cP.get(0)).b() == 1) {
            dI();
         } else if (((Competition)cP.get(0)).b() == 2) {
            dF();
         } else if (((Competition)cP.get(0)).b() == 3) {
            dE();
         } else if (((Competition)cP.get(0)).b() == 7) {
            dA();
         } else if (((Competition)cP.get(0)).b() == 8) {
            dz();
         } else if (((Competition)cP.get(0)).b() == 9) {
            dC();
         } else if (((Competition)cP.get(0)).b() == 10) {
            dD();
         } else if (((Competition)cP.get(0)).b() == 11) {
            dB();
         } else {
            dy();
         }
      }
   }

   public static void dy() {
      int var0 = 0;

      for (int var1 = 0; var1 < cP.size(); var1++) {
         cQ.clear();
         if (b((Competition)cP.get(var1))) {
            cQ.add((Competition)cP.get(var1));
            if (cQ.size() > 0) {
               C0747 var2 = new C0747();
               var2.ub().addAll(cQ);
               var2.av(true);
               cS.add(var2);
               cU = var0++;
            }
         }
      }

      dJ();
   }

   public static void dz() {
      cQ.clear();

      for (int var0 = 0; var0 < cP.size(); var0++) {
         cQ.add((Competition)cP.get(var0));
      }

      ((C0208)cR).Y(cQ);
   }

   public static void dA() {
      cQ.clear();

      for (int var0 = 0; var0 < cP.size(); var0++) {
         cQ.add((Competition)cP.get(var0));
      }

      ((C0208)cR).Y(cQ);
   }

   public static void dB() {
      cQ.clear();

      for (int var0 = 0; var0 < cP.size(); var0++) {
         cQ.add((Competition)cP.get(var0));
      }

      ((C0208)cR).Y(cQ);
   }

   public static void dC() {
      cQ.clear();

      for (int var0 = 0; var0 < cP.size(); var0++) {
         cQ.add((Competition)cP.get(var0));
      }

      ((C0208)cR).Y(cQ);
   }

   public static void dD() {
      for (int var0 = 0; var0 < GamePersistence.careerState.bV().length; var0++) {
         for (int var1 = 0; var1 < cP.size(); var1++) {
            if (cP.get(var1) == GamePersistence.careerState.bV()[var0] && !cQ.contains(cP.get(var1))) {
               cQ.add((Competition)cP.get(var1));
            }
         }
      }

      ((C0208)cR).Y(cQ);
   }

   public static void dE() {
      cQ.clear();
      if (GamePersistence.careerState.isVerEstaduaisAgrupados()) {
         for (int var0 = 0; var0 < GamePersistence.careerState.aE().size(); var0++) {
            for (int var1 = 0; var1 < cP.size(); var1++) {
               if (((Competition)cP.get(var1)).ir() == GamePersistence.careerState.aE().get(var0)) {
                  cQ.add((Competition)cP.get(var1));
               }
            }
         }

         ((C0208)cR).Y(cQ);
      } else {
         for (int var5 = 0; var5 < GamePersistence.careerState.aE().size(); var5++) {
            if (((C0741)GamePersistence.careerState.aE().get(var5)).ei() && ((C0741)GamePersistence.careerState.aE().get(var5)).ej()) {
               cQ.clear();
               cU = ((C0741)GamePersistence.careerState.aE().get(var5)).getEstado();

               for (int var7 = 0; var7 < cP.size(); var7++) {
                  if (((Competition)cP.get(var7)).ir() == GamePersistence.careerState.aE().get(var5)) {
                     cQ.add((Competition)cP.get(var7));
                  }
               }

               if (cQ.size() > 0) {
                  C0747 var8 = new C0747();
                  var8.ub().addAll(cQ);
                  var8.av(true);
                  cS.add(var8);
               }
            }
         }

         if (cQ.size() == 0) {
            int[] var6 = new int[]{GamePersistence.careerState.by(), 25, 18, 22, 17, 10};
            boolean var9 = false;

            for (int var2 = 0; var2 < var6.length; var2++) {
               for (int var3 = GamePersistence.careerState.aE().size() - 1; var3 >= 0; var3--) {
                  if (((C0741)GamePersistence.careerState.aE().get(var3)).getEstado() == var6[var2] && ((C0741)GamePersistence.careerState.aE().get(var3)).ej()) {
                     cU = ((C0741)GamePersistence.careerState.aE().get(var3)).getEstado();
                     var9 = true;
                     cQ.clear();

                     for (int var4 = 0; var4 < cP.size(); var4++) {
                        if (((Competition)cP.get(var4)).ir() == GamePersistence.careerState.aE().get(var3)) {
                           cQ.add((Competition)cP.get(var4));
                        }
                     }

                     if (cQ.size() > 0) {
                        C0747 var10 = new C0747();
                        var10.ub().addAll(cQ);
                        var10.av(true);
                        cS.add(var10);
                     }
                  }
               }

               if (var9) {
                  break;
               }
            }
         }

         dJ();
      }
   }

   public static void dF() {
      boolean var0 = false;
      cQ.clear();
      if (var0) {
         for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
            for (int var2 = 0; var2 < cP.size(); var2++) {
               if (((Competition)cP.get(var2)).iq() == GamePersistence.careerState.N().get(var1)) {
                  cQ.add((Competition)cP.get(var2));
               }
            }
         }

         ((C0208)cR).Y(cQ);
      }

      if (!var0) {
         for (int var5 = 0; var5 < GamePersistence.careerState.N().size(); var5++) {
            boolean var7 = false;
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var5)).ju() && ((CountryCompetitions)GamePersistence.careerState.N().get(var5)).jv()) {
               var7 = true;
            }

            if (var7) {
               cQ.clear();

               for (int var3 = 0; var3 < cP.size(); var3++) {
                  cW = (Competition)cP.get(var3);
                  if (cP.get(var3) == ((CountryCompetitions)GamePersistence.careerState.N().get(var5)).jq()) {
                     cQ.add((Competition)cP.get(var3));
                  }
               }

               if (cQ.size() > 0) {
                  C0747 var10 = new C0747();
                  var10.ub().addAll(cQ);
                  var10.av(true);
                  cS.add(var10);
               }
            }
         }

         if (cQ.size() == 0) {
            int var6 = GamePersistence.careerState.bA();
            boolean var8 = false;

            for (int var11 = GamePersistence.careerState.N().size() - 1; var11 >= 0; var11--) {
               if (((CountryCompetitions)GamePersistence.careerState.N().get(var11)).jc() == var6 && ((CountryCompetitions)GamePersistence.careerState.N().get(var11)).jv()) {
                  var8 = true;
                  cQ.clear();

                  for (int var4 = 0; var4 < cP.size(); var4++) {
                     cW = (Competition)cP.get(var4);
                     if (cP.get(var4) == ((CountryCompetitions)GamePersistence.careerState.N().get(var11)).jq()) {
                        cQ.add((Competition)cP.get(var4));
                     }
                  }

                  if (cQ.size() > 0) {
                     C0747 var12 = new C0747();
                     var12.ub().addAll(cQ);
                     var12.av(true);
                     cS.add(var12);
                  }
                  break;
               }
            }
         }

         dJ();
      }
   }

   public static boolean dG() {
      for (int var0 = 0; var0 < ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).j().size(); var0++) {
         LeagueStage var1 = null;
         Competition var2 = null;
         if (((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).j().get(var0) instanceof LeagueStage) {
            var1 = (LeagueStage)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).j().get(var0);
         } else if (((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).j().get(var0) instanceof KnockoutStage) {
            var1 = (LeagueStage)((KnockoutStage)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).j().get(var0)).zy();
            if (var1 == null) {
               var2 = ((KnockoutStage)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).j().get(var0)).yT();
               if (var2 instanceof NationalLeague) {
                  var1 = ((NationalLeague)var2).yi();
               }
            }
         }

         if (var1 != null && var1.ei()) {
            return true;
         }
      }

      return false;
   }

   public static boolean d(int i, int j) {
      boolean var2 = false;
      String[] var10000 = new String[]{
         "AC",
         "AL",
         "AM",
         "AP",
         "BA",
         "CE",
         "DF",
         "ES",
         "GO",
         "MA",
         "MG",
         "MS",
         "MT",
         "PA",
         "PB",
         "PE",
         "PI",
         "PR",
         "RJ",
         "RN",
         "RO",
         "RR",
         "RS",
         "SC",
         "SE",
         "SP",
         "TO"
      };
      Integer[][] var4 = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};

      for (int var5 = 0; var5 < var4[j].length; var5++) {
         if (var4[j][var5] == i) {
            var2 = true;
         }
      }

      return var2;
   }

   public static boolean dH() {
      boolean var0 = false;

      for (int var1 = 0; var1 < GamePersistence.careerState.bV().length; var1++) {
         if (GamePersistence.careerState.bV()[var1] != null) {
            for (int var2 = 0; var2 < GamePersistence.careerState.M().size(); var2++) {
               Club var3 = ((Coach)GamePersistence.careerState.M().get(var2)).fg();
               if (var3 != null && var3.getPais() == 29 && d(var3.getEstado(), var1)) {
                  var0 = true;
               } else if (var3 == null
                  && !GamePersistence.careerState.isIgnoraEstadual()
                  && ((Coach)GamePersistence.careerState.M().get(var2)).lF() != null
                  && ((Coach)GamePersistence.careerState.M().get(var2)).lF().getPais() == 29
                  && d(((Coach)GamePersistence.careerState.M().get(var2)).lF().getEstado(), var1)) {
                  var0 = true;
               }
            }
         }
      }

      return var0;
   }

   public static boolean J(int i) {
      boolean var1 = false;
      boolean var2 = true;

      for (int var3 = 0; var3 < GamePersistence.careerState.M().size(); var3++) {
         Club var4 = ((Coach)GamePersistence.careerState.M().get(var3)).fg();
         if (var4 != null && var4.getPais() == 29) {
            var1 = true;
            if (var4.getEstado() != 18) {
               var2 = false;
            }
         } else if (var4 == null && ((Coach)GamePersistence.careerState.M().get(var3)).lF() != null && ((Coach)GamePersistence.careerState.M().get(var3)).lF().getPais() == 29) {
            var1 = true;
            if (((Coach)GamePersistence.careerState.M().get(var3)).lF().getEstado() != 18) {
               var2 = false;
            }
         }
      }

      return var1;
   }

   public static void dI() {
      boolean var0 = false;
      cQ.clear();
      if (var0) {
         for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
            for (int var2 = 0; var2 < cP.size(); var2++) {
               if (((Competition)cP.get(var2)).iq() == GamePersistence.careerState.N().get(var1)) {
                  cQ.add((Competition)cP.get(var2));
               }
            }
         }

         ((C0208)cR).Y(cQ);
      }

      if (!var0) {
         for (int var6 = 0; var6 < GamePersistence.careerState.N().size(); var6++) {
            boolean var8 = false;
            if ((((CountryCompetitions)GamePersistence.careerState.N().get(var6)).ei() || ((CountryCompetitions)GamePersistence.careerState.N().get(var6)).jr()) && ((CountryCompetitions)GamePersistence.careerState.N().get(var6)).ej()) {
               var8 = true;
            }

            if (var8) {
               cU = ((CountryCompetitions)GamePersistence.careerState.N().get(var6)).jc();
               cQ.clear();

               for (int var3 = 0; var3 < cP.size(); var3++) {
                  if (((Competition)cP.get(var3)).iq() == GamePersistence.careerState.N().get(var6)) {
                     cQ.add((Competition)cP.get(var3));
                  }
               }

               if (cQ.size() > 0) {
                  C0747 var10 = new C0747();
                  var10.ub().addAll(cQ);
                  var10.av(true);
                  cS.add(var10);
               }
            }
         }

         if (cQ.size() == 0) {
            int[] var7 = new int[]{GamePersistence.careerState.bz()};
            boolean var9 = false;

            for (int var11 = 0; var11 < var7.length; var11++) {
               for (int var4 = GamePersistence.careerState.N().size() - 1; var4 >= 0; var4--) {
                  if (((CountryCompetitions)GamePersistence.careerState.N().get(var4)).jc() == var7[var11] && ((CountryCompetitions)GamePersistence.careerState.N().get(var4)).ej()) {
                     cU = ((CountryCompetitions)GamePersistence.careerState.N().get(var4)).jc();
                     var9 = true;
                     cQ.clear();

                     for (int var5 = 0; var5 < cP.size(); var5++) {
                        if (((Competition)cP.get(var5)).iq() == GamePersistence.careerState.N().get(var4)) {
                           cQ.add((Competition)cP.get(var5));
                        }
                     }

                     if (cQ.size() > 0) {
                        C0747 var12 = new C0747();
                        var12.ub().addAll(cQ);
                        var12.av(true);
                        cS.add(var12);
                     }
                  }
               }

               if (var9) {
                  break;
               }
            }
         }

         dJ();
      }
   }

   public static void dJ() {
      int var0 = dK();
      if (var0 >= 0) {
         ((C0747)cS.get(var0)).av(false);
         ((C0208)cR).Y(((C0747)cS.get(var0)).ub());
      } else {
         ((C0208)cR).GO = null;
         cR = null;
         GamePersistence.careerState.at();
      }
   }

   public static int dK() {
      for (int var0 = 0; var0 < cS.size(); var0++) {
         if (((C0747)cS.get(var0)).uc()) {
            return var0;
         }
      }

      return -1;
   }

   public static int dL() {
      return cU;
   }

   public static int dM() {
      return cV;
   }

   public static void L(int i) {
      cV = i;
   }

   public static Competition dN() {
      return cW;
   }
}
