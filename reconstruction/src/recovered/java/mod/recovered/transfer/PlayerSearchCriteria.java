package mod.recovered.transfer;

import bf22.intermediary.*;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import mod.recovered.model.Player;

public class PlayerSearchCriteria {
   private String nome = null;
   private int md = -1;
   private int me = -1;
   private int mf = -1;
   private int mg = -1;
   private int mh = -1;
   private int mi = -1;
   private int mj = -1;
   private int mk = -1;
   private int ml = -1;
   private int mm = -1;
   private int mn = -1;
   private int mo = -1;
   private int mp = -1;
   private int mq = -1;
   private int mr = -1;
   private int ms = -1;
   private int mt = -1;
   private int mu = -1;
   private int mv = -1;
   private int mw = -1;
   private int mx = -1;
   private int my = -1;
   private int mz = -1;
   private int mA = -1;
   private int mB = -1;
   private int mC = -1;
   private int mD = -1;
   private int mE = -1;
   private int mF = -1;
   private int mG = -1;
   private int mH = -1;
   private int mI = -1;
   private int mJ = -1;
   private int mK = -1;
   private boolean mL = false;
   private boolean mM = false;
   private boolean mN = false;
   private boolean mO = false;
   private int[][] mP = new int[][]{{1, 10}, {11, 30}, {31, 50}, {51, 70}, {71, 100}};
   private int[][] mQ = new int[][]{{16, 25}, {26, 36}, {37, 60}};
   private int[][] mR = new int[][]{
      {1, 100999}, {101000, 500999}, {501000, 1000000}, {1000001, 3000000}, {3000001, 5000000}, {5000001, 10000000}, {10000000, 1000000000}
   };
   private ArrayList mS = new ArrayList();

   public ArrayList D(boolean bl) {
      ArrayList var2 = new ArrayList();
      if (this.ml >= 0) {
         this.mS.clear();

         for (int var3 = 0; var3 < GamePersistence.careerState.N().size(); var3++) {
            this.mS.add(((CountryCompetitions)GamePersistence.careerState.N().get(var3)).jc());
         }
      }

      for (int var4 = 0; var4 < GamePersistence.careerState.O().size(); var4++) {
         if (this.i((Player)GamePersistence.careerState.O().get(var4))) {
            var2.add((Player)GamePersistence.careerState.O().get(var4));
         }
      }

      if (bl) {
         for (int var5 = 0; var5 < GamePersistence.careerState.bN().size(); var5++) {
            if (this.i((Player)GamePersistence.careerState.bN().get(var5))) {
               var2.add((Player)GamePersistence.careerState.bN().get(var5));
            }
         }
      }

      return var2;
   }

   public void b(String string, int i, int j) {
      if (string.equals("gol")) {
         this.mq = 0;
         this.mr = i;
         this.ms = j;
      } else if (string.equals("des")) {
         this.mC = 0;
         this.mD = i;
         this.mE = j;
      } else if (string.equals("vel")) {
         this.mt = 0;
         this.mu = i;
         this.mv = j;
      } else if (string.equals("fin")) {
         this.mF = 0;
         this.mG = i;
         this.mH = j;
      } else if (string.equals("arm")) {
         this.mw = 0;
         this.mx = i;
         this.my = j;
      } else if (string.equals("tec")) {
         this.mI = 0;
         this.mJ = i;
         this.mK = j;
      } else if (string.equals("pas")) {
         this.mz = 0;
         this.mA = i;
         this.mB = j;
      }
   }

   private boolean i(Player player) {
      if (this.md >= 0 && player.getPosicao() != this.md) {
         return false;
      }

      if (this.me >= 0 && player.getLado() != this.me) {
         return false;
      }

      if (this.mf < 0 || player.getOverallStrength() >= this.mm && player.getOverallStrength() <= this.mn) {
         if (this.mg < 0 || player.getIdade() >= this.mo && player.getIdade() <= this.mp) {
            if (this.mq < 0 || player.getGoalkeeping() >= this.mr && player.getGoalkeeping() <= this.ms) {
               if (this.mw < 0 || player.getPlaymaking() >= this.mx && player.getPlaymaking() <= this.my) {
                  if (this.mI < 0 || player.getTechnique() >= this.mJ && player.getTechnique() <= this.mK) {
                     if (this.mt < 0 || player.getSpeed() >= this.mu && player.getSpeed() <= this.mv) {
                        if (this.mF < 0 || player.getFinishing() >= this.mG && player.getFinishing() <= this.mH) {
                           if (this.mC < 0 || player.getTackling() >= this.mD && player.getTackling() <= this.mE) {
                              if (this.mz < 0 || player.getPassing() >= this.mA && player.getPassing() <= this.mB) {
                                 if (this.mh < 0 || player.getMarketValue() >= this.mR[this.mh][0] && player.getMarketValue() <= this.mR[this.mh][1]) {
                                    if (this.mi >= 0 && player.getCr1() != this.mi) {
                                       return false;
                                    } else if (this.mj >= 0 && player.getCr2() != this.mj) {
                                       return false;
                                    } else if (this.mk >= 0 && player.getPais() != this.mk) {
                                       return false;
                                    } else if (this.ml >= 0
                                       && player.getClub() != null
                                       && this.ml < this.mS.size()
                                       && player.getClub().getPais() != (Integer)this.mS.get(this.ml)) {
                                       return false;
                                    } else if (this.mL && !player.isStarPlayer()) {
                                       return false;
                                    } else if (this.mM && !player.isWorldClassPlayer()) {
                                       return false;
                                    } else if (this.mN && !player.isAvailableForLoan()) {
                                       return false;
                                    } else {
                                       return this.mO && !player.isTransferListed()
                                          ? false
                                          : this.nome == null
                                             || this.nome.isEmpty()
                                             || this.nome.length() <= 0
                                             || this.nome.length() <= player.getNome().length()
                                                && this.nome.equalsIgnoreCase(C0670.f(player.getNome()).substring(0, this.nome.length()));
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void setNome(String string) {
      if (string != null && !string.isEmpty()) {
         string = C0670.f(string);
      }

      this.nome = string;
   }

   public void bv(int i) {
      this.md = i;
   }

   public void bw(int i) {
      this.me = i;
   }

   public void bx(int i) {
      this.mf = i;
   }

   public void by(int i) {
      this.mg = i;
   }

   public void bz(int i) {
      this.mh = i;
   }

   public void bA(int i) {
      this.mi = i;
   }

   public void bB(int i) {
      this.mj = i;
   }

   public void bC(int i) {
      this.mk = i;
   }

   public void bD(int i) {
      this.ml = i;
   }

   public void E(boolean bl) {
      this.mL = bl;
   }

   public void F(boolean bl) {
      this.mM = bl;
   }

   public void G(boolean bl) {
      this.mN = bl;
   }

   public void H(boolean bl) {
      this.mO = bl;
   }

   public static int bE(int i) {
      return C0983.eT(i);
   }

   public int jH() {
      return this.mq;
   }

   public void bF(int i) {
      this.mq = i;
   }

   public int jI() {
      return this.mt;
   }

   public void bG(int i) {
      this.mt = i;
   }

   public int jJ() {
      return this.mw;
   }

   public void bH(int i) {
      this.mw = i;
   }

   public int jK() {
      return this.mz;
   }

   public void bI(int i) {
      this.mz = i;
   }

   public int jL() {
      return this.mC;
   }

   public void bJ(int i) {
      this.mC = i;
   }

   public int jM() {
      return this.mF;
   }

   public void bK(int i) {
      this.mF = i;
   }

   public int jN() {
      return this.mI;
   }

   public void bL(int i) {
      this.mI = i;
   }

   public void bM(int i) {
      this.mm = i;
   }

   public void bN(int i) {
      this.mn = i;
   }

   public void bO(int i) {
      this.mo = i;
   }

   public void bP(int i) {
      this.mp = i;
   }
}
