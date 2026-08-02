package mod.recovered.manager;

import mod.recovered.competition.NationalLeague;
import bf22.intermediary.*;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.LeagueStage;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class CoachJobMarket implements Serializable {
   private static final long serialVersionUID = 1L;
   private ArrayList Jg = new ArrayList();
   private ArrayList Jh = new ArrayList();
   private ArrayList Jj = new ArrayList();
   private ArrayList Jl = new ArrayList();

   public void L(ArrayList arrayList) {
      for (int var2 = 0; var2 < arrayList.size(); var2++) {
         if (!((Club)arrayList.get(var2)).isUserControlled()) {
            this.d(this.Jg, ((Club)arrayList.get(var2)).getPais());
            this.d(this.Jh, ((Club)arrayList.get(var2)).getPais());
         }
      }

      Collections.shuffle(this.Jh);
   }

   public void zi() {
      this.Jg.clear();
      this.Jh.clear();
      this.Jj.clear();
      this.Jl.clear();
   }

   public ArrayList a(Coach coach, boolean bl) {
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 < this.Jg.size(); var6++) {
         Club var7 = GamePersistence.careerState.s((Integer)this.Jg.get(var6)).jn();
         if (var7 != null && !var7.isUserControlled()) {
            var3.add(var7);
         }
      }

      Collections.shuffle(var3);
      if (var3.size() > 0) {
         var4.add(0);
         var4.add(1);
         var4.add(3);
         var4.add(2);
         var4.add(4);
         var4.add(5);
         int[][] var15 = new int[][]{{2, 1, 1, 1, 1}, {2, 2, 1, 1, 1}, {3, 2, 2, 1, 1}, {4, 3, 2, 2, 1}, {5, 4, 5, 3, 2}, {5, 4, 4, 3, 2}};
         int var16 = coach.getReputacao();
         if (coach.getClub() != null && coach.getClub().getReputacao() > var16) {
            var16 = coach.getClub().getReputacao();
         }

         int[] var8 = var15[var16];
         boolean var9 = false;

         for (int var10 = 0; var10 < 2; var10++) {
            int var11 = 0;

            for (int var12 = 0; var12 < var8.length; var12++) {
               if (var8[var12] >= 1) {
                  for (int var13 = 0; var13 < var3.size(); var13++) {
                     if (((Club)var3.get(var13)).getReputacao() == var8[var12]
                        && ((Club)var3.get(var13)).gg() == (Integer)var4.get(var11)
                        && !var5.contains(var3.get(var13))) {
                        if ((Integer)var4.get(var11) == 5 && !var9) {
                           var5.add((Club)var3.get(var13));
                           var9 = true;
                        } else if ((Integer)var4.get(var11) != 5) {
                           var5.add((Club)var3.get(var13));
                        }

                        if (var11 + 1 < var4.size()) {
                           var11++;
                        } else {
                           var11 = 0;
                        }
                        break;
                     }
                  }
               }
            }

            if (var5.size() < var8.length) {
               for (int var19 = 0; var19 < var8.length; var19++) {
                  if (var8[var19] >= 1 && var5.size() < var8.length) {
                     for (int var22 = 0; var22 < var3.size(); var22++) {
                        if (((Club)var3.get(var22)).getReputacao() == var8[var19] && !var5.contains(var3.get(var22))) {
                           if (((Club)var3.get(var22)).gg() == 5 && !var9) {
                              var5.add((Club)var3.get(var22));
                              var9 = true;
                              break;
                           }

                           if (((Club)var3.get(var22)).gg() != 5) {
                              var5.add((Club)var3.get(var22));
                           }
                           break;
                        }
                     }
                  }
               }
            }
         }

         int var17 = -1;
         Coach var18 = null;
         byte var20 = 0;
         if (var20 < GamePersistence.careerState.M().size()) {
            var17 = ((Coach)GamePersistence.careerState.M().get(var20)).lE();
            var18 = (Coach)GamePersistence.careerState.M().get(var20);
         }

         if (var17 >= 0) {
            boolean var21 = false;
            Club var23 = null;

            for (int var14 = 0; var14 < var3.size(); var14++) {
               if (((Club)var3.get(var14)).getPais() == var17 && !((Club)var3.get(var14)).isUserControlled() && !var5.contains(var3.get(var14))) {
                  var23 = (Club)var3.get(var14);
                  if (((Club)var3.get(var14)).getNivel() < 18) {
                     var21 = true;
                  } else if (var18 != null && var18.getClub() != null && var18.getClub().getReputacao() >= 3) {
                     var21 = true;
                  }
               }
            }

            if (var21) {
               if (var5.size() == 0) {
                  var5.add(var23);
               } else {
                  var5.set(var5.size() - 1, var23);
               }
            }
         }
      }

      return var5;
   }

   public void d(ArrayList arrayList, int i) {
      if (!arrayList.contains(i)) {
         arrayList.add(i);
      }
   }

   public void zj() {
      this.Jl.clear();
      int var1 = 0;
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < GamePersistence.careerState.N().size(); var3++) {
         for (int var4 = 0; var4 < ((CountryCompetitions)GamePersistence.careerState.N().get(var3)).eb().size(); var4++) {
            var2.clear();
            if (((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var3)).eb().get(var4)).yi().yK().size() > 0) {
               var1 = Math.round(((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var3)).eb().get(var4)).yi().yK().size() / 2);
            }

            for (int var5 = var1; var5 < ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var3)).eb().get(var4)).yi().yK().size(); var5++) {
               var2.add(((Club)((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var3)).eb().get(var4)).yi().yK().get(var5)).getClubId());
            }

            this.M(var2);
         }
      }

      Collections.shuffle(this.Jl);
   }

   private void M(ArrayList arrayList) {
      Collections.shuffle(arrayList);

      for (int var2 = 0; var2 <= 2; var2++) {
         if (var2 < arrayList.size()) {
            this.Jl.add((Integer)arrayList.get(var2));
         }
      }
   }

   public ArrayList b(Coach coach, boolean bl) {
      ArrayList var3 = new ArrayList();
      CountryCompetitions var4 = GamePersistence.careerState.o(coach.lE());
      CountryCompetitions var5 = GamePersistence.careerState.s(coach.bz());
      if (var5 != null) {
         var5.a(var3, coach, bl, true);
      }

      if (var4 != null && var4 != var5) {
         var4.a(var3, coach, bl, false);
      }

      boolean var6 = false;
      if (coach.isUserControlled() && (coach.lG() < 2 || coach.getReputacao() > 3)) {
         var6 = true;
      }

      if (var6) {
         ArrayList var7 = new ArrayList();
         if (GamePersistence.careerState.N().size() > 0) {
            for (int var8 = 0; var8 < GamePersistence.careerState.N().size(); var8++) {
               if (GamePersistence.careerState.N().get(var8) != var5 && GamePersistence.careerState.N().get(var8) != var4) {
                  var7.add((CountryCompetitions)GamePersistence.careerState.N().get(var8));
               }
            }

            if (var7.size() > 0) {
               Collections.shuffle(var7);

               for (int var9 = 0; var9 < var7.size(); var9++) {
                  ((CountryCompetitions)var7.get(var9)).a(var3, coach, bl, false);
                  if (var3.size() > 6) {
                     break;
                  }
               }
            }
         }
      }

      return var3;
   }

   public void zw() {
      for (int var2 = 0; var2 < GamePersistence.careerState.M().size(); var2++) {
         if (((Coach)GamePersistence.careerState.M().get(var2)).isUserControlled() && ((Coach)GamePersistence.careerState.M().get(var2)).getClub() != null) {
            ArrayList var1 = this.b((Coach)GamePersistence.careerState.M().get(var2), true);
            if (var1 != null && var1.size() > 0) {
               MainWindow.a(var1, (Coach)GamePersistence.careerState.M().get(var2), 0);
            }
         }
      }
   }

   public static ArrayList c(Coach coach, boolean bl) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      boolean var6 = false;
      boolean var7 = false;
      if (GamePersistence.careerState.ca() - 1 == GamePersistence.careerState.getSeasonNumber()) {
         var7 = true;
         LeagueStage[] var8 = new LeagueStage[6];
         if (GamePersistence.careerState.bK() != null) {
            var8[1] = GamePersistence.careerState.bK().yd();
         }

         if (GamePersistence.careerState.bM() != null) {
            var8[2] = GamePersistence.careerState.bM().yd();
         }

         if (GamePersistence.careerState.bQ() != null) {
            var8[3] = GamePersistence.careerState.bQ().yd();
         }

         if (GamePersistence.careerState.bS() != null) {
            var8[5] = GamePersistence.careerState.bS().yd();
         }

         for (int var9 = 0; var9 < var8.length; var9++) {
            if (var8[var9] != null) {
               for (int var10 = 0; var10 < var8[var9].yK().size(); var10++) {
                  if (!((Club)var8[var9].yK().get(var10)).isUserControlled()) {
                     var3.add((Club)var8[var9].yK().get(var10));
                  }
               }
            }
         }
      }

      if (GamePersistence.careerState.aY() != null && GamePersistence.careerState.aY().yd() != null) {
         for (int var17 = 0; var17 < GamePersistence.careerState.aY().yd().yK().size(); var17++) {
            if (!((Club)GamePersistence.careerState.aY().yd().yK().get(var17)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.aY().yd().yK().get(var17));
            }
         }

         var6 = true;
      }

      if (GamePersistence.careerState.ba() != null && GamePersistence.careerState.ba().yd() != null) {
         for (int var18 = 0; var18 < GamePersistence.careerState.ba().yd().yK().size(); var18++) {
            if (!((Club)GamePersistence.careerState.ba().yd().yK().get(var18)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.ba().yd().yK().get(var18));
            }
         }

         var5.add(0);
      }

      if (GamePersistence.careerState.aZ() != null && GamePersistence.careerState.aZ().yd() != null) {
         for (int var19 = 0; var19 < GamePersistence.careerState.aZ().yd().yK().size(); var19++) {
            if (!((Club)GamePersistence.careerState.aZ().yd().yK().get(var19)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.aZ().yd().yK().get(var19));
            }
         }

         var5.add(1);
      }

      if (GamePersistence.careerState.be() != null && GamePersistence.careerState.be().yd() != null) {
         for (int var20 = 0; var20 < GamePersistence.careerState.be().yd().yK().size(); var20++) {
            if (!((Club)GamePersistence.careerState.be().yd().yK().get(var20)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.be().yd().yK().get(var20));
            }
         }

         var5.add(2);
      }

      if (GamePersistence.careerState.bf() != null && GamePersistence.careerState.bf().yd() != null) {
         for (int var21 = 0; var21 < GamePersistence.careerState.bf().yd().yK().size(); var21++) {
            if (!((Club)GamePersistence.careerState.bf().yd().yK().get(var21)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.bf().yd().yK().get(var21));
            }
         }

         var5.add(3);
      }

      if (GamePersistence.careerState.bX() != null && GamePersistence.careerState.bX().yd() != null) {
         for (int var22 = 0; var22 < GamePersistence.careerState.bX().yd().yK().size(); var22++) {
            if (!((Club)GamePersistence.careerState.bX().yd().yK().get(var22)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.bX().yd().yK().get(var22));
            }
         }

         var5.add(5);
      }

      if (GamePersistence.careerState.bg() != null && GamePersistence.careerState.bg().yd() != null) {
         for (int var23 = 0; var23 < GamePersistence.careerState.bg().yd().yK().size(); var23++) {
            if (!((Club)GamePersistence.careerState.bg().yd().yK().get(var23)).isUserControlled()) {
               var3.add((Club)GamePersistence.careerState.bg().yd().yK().get(var23));
            }
         }

         var5.add(4);
      }

      if (var3.size() > 0) {
         Collections.shuffle(var3);
         int[][] var24 = new int[][]{{2, 1, 1, -1, -1}, {2, 2, 1, 1, 1}, {3, 2, 2, 1, 1}, {4, 3, 2, 2, 1}, {5, 4, 5, 3, 2}, {5, 4, 4, 3, 2}};
         int[][] var26 = new int[][]{{-1, -1, -1, -1, -1}, {2, 2, 1, 1, 1, 1}, {2, 2, 1, 1, 1, 1}, {4, 3, 2, 2, 2, 1}, {5, 4, 4, 3, 2, 1}, {5, 5, 4, 4, 3, 2}};
         int var28 = coach.getReputacao();
         if (coach.getClub() != null && coach.getClub().getReputacao() > var28) {
            var28 = coach.getClub().getReputacao();
         }

         int[] var11 = var24[var28];
         if (var7) {
            var11 = var26[var28];
            int[] var12 = new int[]{12, 7, 7, 8, 10, 10};
            int[] var13 = new int[6];
            CountryCompetitions var14 = GamePersistence.careerState.s(coach.lE());
            int var15 = var14.gg();
            if (coach.getClub() != null) {
               if (coach.getClub().gg() == 0) {
                  var12[0] = 12;
                  var12[0] = 7;
               } else if (coach.getClub().gg() == 1) {
                  var12[0] = 9;
                  var12[1] = 10;
               }
            }

            for (int var16 = 0; var16 < var3.size(); var16++) {
               if (var13[((Club)var3.get(var16)).gg()] < var12[((Club)var3.get(var16)).gg()] && !var4.contains(var3.get(var16))) {
                  var4.add((Club)var3.get(var16));
                  var13[((Club)var3.get(var16)).gg()]++;
               }

               if (var15 == ((Club)var3.get(var16)).gg() && ((Club)var3.get(var16)).getReputacao() >= 4 && !var4.contains(var3.get(var16))) {
                  var4.add((Club)var3.get(var16));
               }
            }

            if (var4.size() > 0) {
               var3 = var4;
            }
         }

         if (!var6 && !var7 && var5.size() > 0) {
            if (var3.size() > 0) {
               boolean var33 = false;

               for (int var36 = 0; var36 < 2; var36++) {
                  int var38 = 0;

                  for (int var40 = 0; var40 < var11.length; var40++) {
                     if (var11[var40] >= 1) {
                        for (int var41 = 0; var41 < var3.size(); var41++) {
                           if (((Club)var3.get(var41)).getReputacao() == var11[var40]
                              && ((Club)var3.get(var41)).gg() == (Integer)var5.get(var38)
                              && !var2.contains(var3.get(var41))) {
                              if ((Integer)var5.get(var38) == 5 && !var33) {
                                 var2.add((Club)var3.get(var41));
                                 var33 = true;
                              } else if ((Integer)var5.get(var38) != 5) {
                                 var2.add((Club)var3.get(var41));
                              }

                              if (var38 + 1 < var5.size()) {
                                 var38++;
                              } else {
                                 var38 = 0;
                              }
                              break;
                           }
                        }
                     }
                  }
               }

               if (var2.size() < var11.length) {
                  for (int var37 = 0; var37 < var11.length; var37++) {
                     if (var11[var37] >= 1 && var2.size() < var11.length) {
                        for (int var39 = 0; var39 < var3.size(); var39++) {
                           if (((Club)var3.get(var39)).getReputacao() == var11[var37] && !var2.contains(var3.get(var39))) {
                              if (((Club)var3.get(var39)).gg() == 5 && !var33) {
                                 var2.add((Club)var3.get(var39));
                                 var33 = true;
                                 break;
                              }

                              if (((Club)var3.get(var39)).gg() != 5) {
                                 var2.add((Club)var3.get(var39));
                              }
                              break;
                           }
                        }
                     }
                  }
               }
            }
         } else if (var3.size() > 0) {
            for (int var32 = 0; var32 < var11.length; var32++) {
               if (var11[var32] >= 1) {
                  for (int var35 = 0; var35 < var3.size(); var35++) {
                     if (((Club)var3.get(var35)).getReputacao() == var11[var32] && !var2.contains(var3.get(var35))) {
                        var2.add((Club)var3.get(var35));
                        break;
                     }
                  }
               }
            }
         }
      }

      int var25 = -1;
      Coach var27 = null;
      byte var29 = 0;
      if (var29 < GamePersistence.careerState.M().size()) {
         var25 = ((Coach)GamePersistence.careerState.M().get(var29)).lE();
         var27 = (Coach)GamePersistence.careerState.M().get(var29);
      }

      if (var25 >= 0) {
         boolean var30 = false;
         Club var31 = null;

         for (int var34 = 0; var34 < var3.size(); var34++) {
            if (((Club)var3.get(var34)).getPais() == var25 && !((Club)var3.get(var34)).isUserControlled() && !var2.contains(var3.get(var34))) {
               var31 = (Club)var3.get(var34);
               if (((Club)var3.get(var34)).getNivel() < 18) {
                  var30 = true;
               } else if (var27 != null && var27.getClub() != null && var27.getClub().getReputacao() >= 3) {
                  var30 = true;
               }
            }
         }

         if (var30) {
            if (var2.size() == 0) {
               var2.add(var31);
            } else {
               var2.set(var2.size() - 1, var31);
            }
         }
      }

      System.out.println("cria proposta selecao:" + var2.size());
      return var2;
   }

   public ArrayList Ap() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.Jl.size(); var2++) {
         Club var3 = GamePersistence.careerState.x((Integer)this.Jl.get(var2));
         if (var3 != null && !var3.isUserControlled()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public ArrayList Aq() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.Jh.size(); var2++) {
         Club var3 = GamePersistence.careerState.s((Integer)this.Jh.get(var2)).jn();
         if (var3 != null && !var3.isUserControlled()) {
            var1.add(var3);
         }
      }

      return var1;
   }
}
