package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import mod.recovered.model.Club;

public class C0703 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int ae;
   private int w;
   private int dz;
   private int T = 0;
   private int bX = 0;
   private int d = 0;
   private int nK = 0;
   private int nL = 0;
   private int nM = 0;
   private int nN = -1;
   private int divisao = -1;
   private int nO = -1;
   private transient boolean nP = false;
   private transient boolean nQ = false;
   private transient boolean nR = false;

   public C0703() {
   }

   public C0703(Competition c0713, Club club, int i) {
      this.ae = GamePersistence.SR.H();
      this.w = c0713.b();
      this.dz = i;
      if (c0713 instanceof C0924) {
         this.divisao = ((C0924)c0713).ip();
      } else if (c0713 instanceof C0951) {
         this.divisao = ((C0951)c0713).ip();
      }
   }

   public int H() {
      return this.ae;
   }

   public int w() {
      return this.T;
   }

   public void cl() {
      this.T++;
   }

   public int cm() {
      return this.bX;
   }

   public void cn() {
      this.bX++;
   }

   public int co() {
      return this.d;
   }

   public void cp() {
      this.d++;
   }

   public int ls() {
      return this.nK;
   }

   public void ca(int i) {
      this.nK += i;
   }

   public int lt() {
      return this.nL;
   }

   public void cb(int i) {
      this.nL += i;
   }

   public int lu() {
      return this.nM;
   }

   public void cc(int i) {
      this.nM = i;
   }

   public int lv() {
      return this.nN;
   }

   public void cd(int i) {
      this.nN = i;
   }

   public String d(CountryCompetitions c0692) {
      String var2 = "";
      String var3 = "Campeão";
      String var4 = "Vice-campeão";
      String var5 = "";
      String var6 = "";
      ArrayList var7 = new ArrayList();
      if (this.w == 2) {
         if (c0692 != null) {
            if (c0692.jq() != null && c0692.jq().yf() != null) {
               var7.addAll(Arrays.asList(c0692.jq().b((CompetitionStage)null)));
            } else if (c0692.jc() == 29 && GamePersistence.vM().isNovoFormatoCopa()) {
               var7.addAll(Arrays.asList(GameConstants.pt));
            } else if (c0692.jq() != null) {
               var7.addAll(Arrays.asList(c0692.jq().yh()));
            }
         }
      } else if (this.w == 4) {
         if (this.dz == 0 || this.dz == 1 || this.dz == 3 || this.dz == 2) {
            var7.addAll(Arrays.asList(GameConstants.pA));
         } else if (this.dz == 4) {
            var7.addAll(Arrays.asList(GameConstants.pB));
         } else if (this.dz == 5) {
            var7.addAll(Arrays.asList(GameConstants.pC));
         }
      } else if (this.w != 6 && this.w != 12) {
         var7.addAll(Arrays.asList(GameConstants.py));
      } else if (this.dz == 0) {
         var7.addAll(Arrays.asList(GameConstants.pz));
      } else {
         var7.addAll(Arrays.asList(GameConstants.pA));
      }

      Collections.reverse(var7);
      if (this.w == 9) {
         return this.divisao == 1 ? "Classificado" : "Não classificado";
      }

      if (this.nN >= 0) {
         this.nR = true;
         if (this.nN == 1090) {
            this.nR = false;
            return var6 + "Venceu playoff";
         }

         if (this.nN == 1091) {
            return var6 + "Perdeu playoff";
         }

         if (this.nN == 1001) {
            return var6 + "Fase de grupos";
         }

         if (this.nN == 4101) {
            return var6 + GameConstants.pR[0];
         }

         if (this.nN == 4102) {
            return var6 + GameConstants.pS[0];
         }

         if (this.nN == 4103) {
            return var6 + GameConstants.pT[0];
         }

         if (this.nN == 6000) {
            return var6 + GameConstants.pM[0];
         }

         if (this.nN == 6001) {
            return var6 + GameConstants.pN[0];
         }

         if (this.nN == 6002) {
            return var6 + GameConstants.pO[0];
         }

         if (this.nN == 6003) {
            return var6 + GameConstants.pP[0];
         }

         if (this.nN == 6006) {
            return var6 + GameConstants.abY[0];
         }

         if (this.nN == 6004) {
            return var6 + GameConstants.pQ[0];
         }

         if (this.nN == 6100) {
            return var6 + GameConstants.pW[0];
         }

         if (this.nN == 4000) {
            return var6 + GameConstants.pG[0];
         }

         if (this.nN == 4001) {
            return var6 + GameConstants.pI[0];
         }

         if (this.nN == 4002) {
            return var6 + GameConstants.pJ[0];
         }

         if (this.nN == 4003) {
            return var6 + GameConstants.pK[0];
         }

         if (this.nN == 4004) {
            return var6 + GameConstants.pL[0];
         }

         if (this.nN == 12001) {
            return var6 + GameConstants.abZ[0];
         }

         if (this.nN == 12002) {
            return var6 + GameConstants.aca[0];
         }

         if (this.nN == 12003) {
            return var6 + GameConstants.acb[0];
         }

         if (this.nN == 12004) {
            return var6 + GameConstants.acc[0];
         }

         if (this.nN == 12006) {
            return var6 + GameConstants.abY[0];
         }

         if (this.nN == 0) {
            if (this.nM == 1) {
               this.nP = true;
               this.nR = false;
               return var3;
            }

            if (this.nM == 2) {
               this.nQ = true;
               this.nR = false;
               return var4;
            }

            if (this.w == 7 || this.w == 14) {
               if (this.nM == 3) {
                  this.nR = false;
                  return "3º";
               }

               if (this.nM == 4) {
                  this.nR = false;
                  return "4º";
               }
            }
         } else if (this.nN >= 1 && this.nN < var7.size()) {
            return (String)var7.get(this.nN);
         }
      } else {
         if (this.lu() > 0) {
            if (this.nM == 1) {
               this.nP = true;
               return var3;
            }

            if (this.nM == 2) {
               this.nQ = true;
               return var4;
            }

            if (this.w == 7) {
               this.nR = true;
               return "Fase grupos";
            }

            return Integer.toString(this.lu()) + " º";
         }

         if (this.ae < GamePersistence.SR.H()) {
            if (this.w == 1) {
               this.nR = true;
               return "1ª fase";
            }

            if (this.w == 14) {
               String[] var8 = new String[]{"A", "A", "B", "C", "D"};
               String var9 = "Grupos";
               if (this.divisao >= 0 && this.divisao < var8.length) {
                  var9 = "Liga " + var8[this.divisao];
               }

               return var9;
            }

            if (this.w == 7) {
               this.nR = true;
               return "Fase grupos";
            }
         }
      }

      return var2;
   }

   public int b() {
      return this.w;
   }

   public int el() {
      return this.dz;
   }

   public int getDivisao() {
      return this.divisao;
   }

   public int lw() {
      return this.nO;
   }

   public void ce(int i) {
      this.nO = i;
   }

   public boolean lx() {
      return this.nP;
   }

   public boolean ly() {
      return this.nQ;
   }

   public boolean lz() {
      return this.nR;
   }

   public void setDivisao(int i) {
      this.divisao = i;
   }
}
