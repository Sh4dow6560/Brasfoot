package mod.recovered.model;

import mod.recovered.match.MatchEvent;
import bf22.intermediary.C0674;
import mod.recovered.match.Match;
import bf22.intermediary.C0676;
import bf22.intermediary.C0677;
import bf22.intermediary.C0679;
import bf22.intermediary.C0689;
import mod.recovered.game.ScheduleDay;
import bf22.intermediary.C0696;
import mod.recovered.transfer.PlayerTransferRecord;
import mod.recovered.core.GameConstants;
import mod.recovered.competition.Competition;
import bf22.intermediary.C0719;
import mod.recovered.competition.CompetitionPlayerStats;
import mod.recovered.game.CareerState;
import bf22.intermediary.C0729;
import mod.recovered.save.GamePersistence;
import bf22.intermediary.C0799;
import bf22.intermediary.C0824;
import bf22.intermediary.C0825;
import bf22.intermediary.C0914;
import mod.recovered.competition.NationalLeague;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class Player implements Serializable {
   private static final long serialVersionUID = 1L;
   private int ei = -1;
   private int ej = -1;
   private String dm;
   private Boolean ek = false;
   private Boolean el = false;
   private int em;
   private int pais;
   private int en;
   private transient Club club = null;
   private int clubId = -1;
   private int ep = -1;
   private int overallStrength;
   private int er = 0;
   private int es;
   private int et;
   private int eu;
   private int ev;
   private int status = 0;
   private int ew = 0;
   private int ex;
   private int ey = 0;
   private int ez = 0;
   private int goalkeeping = 0;
   private int speed = 0;
   private int technique = 0;
   private int passing = 0;
   private int tackling = 0;
   private int playmaking = 0;
   private int finishing = 0;
   private double[] eH = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
   private long injuryEndTimeMillis = 0L;
   private long contractEndTimeMillis = 0L;
   private int energy = 100;
   private Boolean eL = false;
   private double eM = 0.0;
   private double eN = 0.0;
   private Boolean eO = false;
   private Boolean eP = false;
   private Boolean eQ = false;
   private int tacticalPosition = -1;
   private ArrayList eS = new ArrayList();
   private ArrayList eT = new ArrayList();
   private ArrayList eU = new ArrayList();
   private int eV = 0;
   private Boolean eW = false;
   private Boolean eX = false;
   private Boolean eY = false;
   private int eZ = 0;
   private int fa = 0;
   private Boolean youthPlayer = false;
   private int fc = 0;
   private int fd = 0;
   private double fe = 0.0;
   private int ff = 0;
   private transient int fg = 0;
   private int fh = 0;
   private int fi = 0;
   private transient ImageIcon fj = null;
   private transient JProgressBar fk = null;
   private transient ImageIcon fl = null;
   private transient ImageIcon fm = null;
   private transient int fn = 0;
   private transient C0824 fo = null;
   private transient int fp = 0;
   private transient int fq = 0;
   private transient double ab = 0.0;
   private transient boolean fr = false;

   public Player() {
   }

   public void fd() {
      this.fp++;
      if (!this.gm() && this.fp >= 2 && this.getClub() != null && this.em < 35) {
         if (this.getClub().gg() == 0) {
            if (this.getClub().getPais() == 1 || this.getClub().getPais() == 65 || this.getClub().getPais() == 97) {
               this.j(true);
            } else if ((this.getClub().getPais() == 104 || this.getClub().getPais() == 72 || this.getClub().getPais() == 154) && this.fp >= 3) {
               this.j(true);
            }
         } else if (this.getClub().getPais() == 29 && this.fp >= 4) {
            this.j(true);
         }
      }
   }

   public void fe() {
      this.fo = new C0824();
   }

   public Player(int i) {
      this.pais = i;
      this.dm = au(i);
      GamePersistence.careerState.bN().add(this);
   }

   public Player(C0689 c0689, Club club) {
      this.setPais(c0689.pais);
      this.setNome(c0689.dm);
      this.n(club);
      this.setPosicao(c0689.en);
      this.setLado(c0689.er);
      if (c0689.hm == 1) {
         this.el = true;
      }

      if (c0689.hl == 1) {
         this.a(true);
      } else {
         this.a(false);
      }

      this.aq(c0689.es);
      this.setStatus(c0689.hk);
      this.setCr1(c0689.hn);
      this.setCr2(c0689.ho);
      if (c0689.hp == 1) {
         this.h(true);
      } else {
         this.h(false);
      }

      this.setIdade(c0689.em);
      this.fG();
   }

   public String getNome() {
      return this.dm;
   }

   public void setNome(String string) {
      this.dm = string;
      if (string == null || string.equals("TESTE")) {
         this.dm = au(this.pais);
      }
   }

   public Boolean ff() {
      return this.ek;
   }

   public void a(Boolean boolean_) {
      this.ek = boolean_;
      if (this.el) {
         this.ek = true;
      }
   }

   public int getIdade() {
      return this.em;
   }

   public void setIdade(int i) {
      int var2 = i;
      if (this.youthPlayer) {
         if (var2 < 16 || var2 > 20) {
            var2 = 18;
         }
      } else if (var2 < 16 || var2 > 48) {
         var2 = 35;
      }

      this.em = var2;
   }

   public int getPais() {
      return this.pais;
   }

   public void setPais(int i) {
      this.pais = i;
   }

   public int getPosicao() {
      return this.en;
   }

   public void setPosicao(int i) {
      this.en = i;
   }

   public Club getClub() {
      Club var1 = this.club;
      if (var1 == null && this.clubId >= 0) {
         var1 = GamePersistence.careerState.x(this.clubId);
         this.club = var1;
         return var1;
      } else {
         return this.clubId == -1 ? null : var1;
      }
   }

   public void fh() {
      if (this.club != null) {
         this.clubId = this.club.getClubId();
      }
   }

   public void n(Club club) {
      this.club = club;
      if (club != null) {
         this.clubId = club.getClubId();
      } else {
         this.clubId = -1;
      }
   }

   public int getOverallStrength() {
      return this.overallStrength;
   }

   public void setOverallStrength(int i) {
      this.overallStrength = i;
   }

   public int getLado() {
      return this.er;
   }

   public void setLado(int i) {
      if (i == 0) {
         this.er = 0;
      } else {
         this.er = 1;
      }
   }

   public int fj() {
      return this.et;
   }

   public void ae(int i) {
      this.et = i;
   }

   public int fk() {
      return this.eu;
   }

   public void af(int i) {
      this.eu = i;
   }

   public int fl() {
      return this.ev;
   }

   public void ag(int i) {
      this.ev = i;
   }

   public void fm() {
      this.ev = this.eu;
   }

   public int getStatus() {
      return this.status;
   }

   public void setStatus(int i) {
      this.status = i;
   }

   public int fn() {
      return this.ew;
   }

   public void ah(int i) {
      this.ew = i;
   }

   public int getCr1() {
      return this.ey;
   }

   public void setCr1(int i) {
      this.ey = i;
   }

   public int getCr2() {
      return this.ez;
   }

   public void setCr2(int i) {
      this.ez = i;
   }

   public long getInjuryEndTimeMillis() {
      return this.injuryEndTimeMillis;
   }

   public void d(long l) {
      this.injuryEndTimeMillis = l;
   }

   public int getEnergy() {
      return this.energy;
   }

   public void setEnergy(int i) {
      this.energy = i;
   }

   public void decreaseEnergy(int i) {
      this.energy -= i;
      if (this.energy < 0) {
         this.energy = 1;
      }
   }

   public void increaseEnergy(int i) {
      this.energy += i;
      if (this.energy > 100) {
         this.energy = 100;
      }
   }

   public void reduceEnergyAfterMatch() {
      if (this.em <= 20) {
         this.decreaseEnergy(1);
      } else if (this.em <= 25) {
         this.decreaseEnergy(2);
      } else if (this.em <= 31) {
         this.decreaseEnergy(3);
      } else if (this.em <= 36) {
         this.decreaseEnergy(4);
      } else {
         this.decreaseEnergy(5);
      }
   }

   public void recoverEnergyDaily() {
      boolean var1 = false;
      if (this.getClub() != null) {
         var1 = this.getClub().isUserControlled();
      }

      if (this.eL) {
         if (var1) {
            if (this.em <= 20) {
               this.increaseEnergy(13);
            } else if (this.em <= 25) {
               this.increaseEnergy(24);
            } else if (this.em <= 31) {
               this.increaseEnergy(37);
            } else if (this.em <= 36) {
               this.increaseEnergy(40);
            } else {
               this.increaseEnergy(30);
            }
         } else if (this.em <= 20) {
            this.increaseEnergy(20);
         } else if (this.em <= 25) {
            this.increaseEnergy(30);
         } else if (this.em <= 31) {
            this.increaseEnergy(50);
         } else if (this.em <= 36) {
            this.increaseEnergy(52);
         } else {
            this.increaseEnergy(42);
         }
      } else if (this.em < 20) {
         this.increaseEnergy(30);
      } else if (this.em < 26) {
         this.increaseEnergy(30);
      } else if (this.em < 33) {
         this.increaseEnergy(35);
      } else if (this.em < 45) {
         this.increaseEnergy(35);
      } else {
         this.increaseEnergy(30);
      }
   }

   public Boolean fs() {
      return this.eL;
   }

   public void b(Boolean boolean_) {
      this.eL = boolean_;
   }

   public Boolean ft() {
      return this.eY;
   }

   public void c(Boolean boolean_) {
      this.eY = boolean_;
   }

   public double fu() {
      return this.eM;
   }

   public void d(double d) {
      this.eM = d;
   }

   public Boolean fv() {
      return this.eO;
   }

   public void d(Boolean boolean_) {
      this.eO = boolean_;
   }

   public Boolean fw() {
      return this.eP;
   }

   public void e(Boolean boolean_) {
      this.eP = boolean_;
   }

   public Boolean fx() {
      return this.eQ;
   }

   public void f(Boolean boolean_) {
      this.eQ = boolean_;
   }

   public int fy() {
      return this.eV;
   }

   public void al(int i) {
      this.eV = i;
   }

   public Boolean fz() {
      return this.eW;
   }

   public void g(Boolean boolean_) {
      this.eW = boolean_;
   }

   public int fA() {
      return this.eZ;
   }

   public void am(int i) {
      this.eZ = i;
   }

   public int fB() {
      return this.fa;
   }

   public void an(int i) {
      this.fa = i;
   }

   public Boolean isYouthPlayer() {
      return this.youthPlayer;
   }

   public void h(Boolean boolean_) {
      this.youthPlayer = boolean_;
   }

   public int fD() {
      return this.fc;
   }

   public void ao(int i) {
      this.fc = i;
   }

   public int fE() {
      return this.fd;
   }

   public void ap(int i) {
      this.fd = i;
   }

   public int fF() {
      return this.ex;
   }

   public void fG() {
      int var1 = this.ey;
      int var2 = this.ez;
      if (this.en == 0 || this.en == 2) {
         this.ex = 0;
      } else if (this.en == 1) {
         if (var1 == 13 || var1 == 6) {
            this.ex = 1;
         } else if (var1 == 7 || var1 == 10) {
            this.ex = 0;
         } else if (var2 == 13 || var1 == 6) {
            this.ex = 1;
         } else if (var2 == 7 || var2 == 10) {
            this.ex = 0;
         } else if (var1 != 8 && var1 != 9 && var1 != 11 && var1 != 4) {
            this.ex = 0;
         } else {
            this.ex = 1;
         }
      } else if (this.en == 3) {
         if (var1 == 11 || var1 == 9 || var1 == 8 || var1 == 4) {
            this.ex = 1;
         } else if (var1 == 7 || var1 == 10) {
            this.ex = 0;
         } else if (var2 == 11 || var2 == 9 || var2 == 8 || var2 == 4) {
            this.ex = 1;
         } else if (var2 != 7 && var2 != 10) {
            this.ex = 1;
         } else {
            this.ex = 0;
         }
      } else if (this.en == 4) {
         if (var1 == 7 || var1 == 10) {
            this.ex = 0;
         } else if (var1 != 8 && var1 != 13 && var1 != 6) {
            this.ex = 1;
         } else {
            this.ex = 2;
         }
      }
   }

   public int fH() {
      return this.es;
   }

   public void aq(int i) {
      this.es = i;
      if (this.ek && this.es > 8) {
         this.es = 10;
      }
   }

   public void fI() {
      if (this.getClub() != null) {
         int var1 = this.getClub().getDivisao();
         int var2 = this.getClub().getNivel();
         int var3 = this.getClub().getPais();
         int var4 = 1;
         byte var5 = 1;
         int var6 = 0;
         if (this.getClub().kn()) {
            switch (var1) {
               case 1:
                  var4 = 20;
                  var5 = 7;
                  break;
               case 2:
                  var4 = 15;
                  var5 = 3;
                  break;
               case 3:
                  var4 = 5;
                  var5 = 1;
            }
         } else {
            switch (this.getClub().getReputacao()) {
               case 1:
                  var4 = 5;
                  var5 = 1;
                  break;
               case 2:
                  var4 = 5;
                  var5 = 1;
                  break;
               case 3:
                  var4 = 5;
                  var5 = 1;
                  break;
               case 4:
                  var4 = 15;
                  var5 = 4;
                  break;
               case 5:
                  var4 = 22;
                  var5 = 7;
            }
         }

         if (var2 <= 15) {
            var6 = var2;
         } else {
            switch (var2) {
               case 16:
                  var6 = 17;
                  break;
               case 17:
                  var6 = 18;
                  break;
               case 18:
                  var6 = 19;
                  break;
               case 19:
                  var6 = 21;
                  break;
               case 20:
                  var6 = 25;
                  break;
               case 21:
                  var6 = 26;
                  break;
               case 22:
                  var6 = 27;
                  break;
               case 23:
                  var6 = 28;
                  break;
               case 24:
                  var6 = 29;
                  break;
               case 25:
                  var6 = 30;
                  break;
               default:
                  var6 = var2;
            }
         }

         int var7 = var6;
         byte var8 = var5;
         if (var7 > 4) {
            var7 -= 4;
         }

         var4 = var6 + var4;
         var4 += new Random().nextInt(3);
         if (this.status == 1) {
            var4 = var4 + 8 + new Random().nextInt(2);
         }

         if (this.ek || this.el) {
            var4 = var4 + 9 + new Random().nextInt(3);
         }

         if (this.youthPlayer) {
            var4 -= 23;
            if (var4 < 5) {
               var4 = 10;
            }

            this.ga();
            this.fZ();
         }

         if (C0696.fn(var3) <= 13) {
            if (var2 <= 5) {
               var4 = (int)Math.round(var4 * 0.4);
            } else if (var2 < 10) {
               var4 = (int)Math.round(var4 * 0.65);
            } else {
               var4 = (int)Math.round(var4 * 0.75);
            }
         } else if (var2 < 10) {
            if (var2 < 3) {
               var4 = (int)Math.round(var4 * 0.5);
            } else if (var2 < 5) {
               var4 = (int)Math.round(var4 * 0.6);
            } else if (var2 < 10) {
               var4 = (int)Math.round(var4 * 0.7);
            }
         }

         if (var4 > 100) {
            var4 = 100;
         }

         this.a(new Random().nextInt(30) + 210, true);
         this.setOverallStrength(var4);
         if (GamePersistence.careerState.isHabilidadeIndividual()) {
            this.j(var7, var8);
         }

         this.fK();
         this.fJ();
      }
   }

   public void j(int i, int j) {
      int var3 = Math.round(i / 3);
      if (this.en == 0) {
         this.goalkeeping = this.overallStrength + new Random().nextInt(2);
         this.speed = i + new Random().nextInt(7);
         this.technique = i + new Random().nextInt(4);
         this.passing = i + new Random().nextInt(4);
         this.tackling = j + new Random().nextInt(3);
         this.playmaking = j + new Random().nextInt(3);
         this.finishing = j + new Random().nextInt(3);
         if (this.ey == 0 || this.ey == 3) {
            this.technique = this.technique + 2 + new Random().nextInt(5);
         }

         if (this.ez == 0 || this.ez == 3) {
            this.technique = this.technique + new Random().nextInt(2);
         }

         if (this.ey == 2) {
            this.speed = this.speed + 2 + new Random().nextInt(5);
         }

         if (this.ez == 2) {
            this.speed = this.speed + new Random().nextInt(2);
         }

         if (this.ey == 1) {
            this.goalkeeping = this.goalkeeping + 1 + new Random().nextInt(3);
         }

         if (this.ez == 1) {
            this.goalkeeping = this.goalkeeping + new Random().nextInt(2);
         }
      } else if (this.en == 1) {
         if (this.ex == 0) {
            this.tackling = (int)Math.round(this.overallStrength * 0.8) + new Random().nextInt(6);
            this.finishing = j + new Random().nextInt(4);
            this.passing = i + new Random().nextInt(3);
            this.technique = i + new Random().nextInt(7);
            this.playmaking = j + new Random().nextInt(5);
            this.speed = i + j + new Random().nextInt(6);
         } else {
            this.playmaking = (int)Math.round(this.overallStrength * 0.5) + new Random().nextInt(5);
            this.finishing = i + j + new Random().nextInt(4);
            this.passing = i + var3 + new Random().nextInt(3);
            this.technique = i + var3 + new Random().nextInt(7);
            this.tackling = i + new Random().nextInt(4);
            this.speed = i + j + new Random().nextInt(4);
         }

         this.goalkeeping = 1 + new Random().nextInt(4);
         if (this.ey == 4 || this.ez == 4) {
            this.playmaking = this.playmaking + j + new Random().nextInt(5);
            this.passing = this.passing + j + new Random().nextInt(5);
         }

         if (this.ey == 5 || this.ez == 5) {
            this.finishing = this.finishing + 2 + new Random().nextInt(3);
            this.tackling = this.tackling + 2 + new Random().nextInt(3);
         }

         if (this.ey == 6 || this.ez == 6) {
            this.passing = this.passing + 2 + new Random().nextInt(3);
         }

         if (this.ey == 7 || this.ez == 7) {
            this.tackling = this.tackling + j + new Random().nextInt(3);
         }

         if (this.ey == 8 || this.ez == 8) {
            this.technique = this.technique + j + new Random().nextInt(3);
         }

         if (this.ey == 9 || this.ez == 9) {
            this.finishing = this.finishing + j + new Random().nextInt(3);
         }

         if (this.ey == 10 || this.ez == 10) {
            this.tackling = this.tackling + j + new Random().nextInt(5);
         }

         if (this.ey == 11 || this.ez == 11) {
            this.passing = this.passing + j + new Random().nextInt(2);
         }

         if (this.ey == 12 || this.ez == 12) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
         }

         if (this.ey == 13 || this.ez == 13) {
            this.speed = this.speed + i + new Random().nextInt(3);
         }
      } else if (this.en == 2) {
         this.tackling = (int)Math.round(this.overallStrength * 0.9) + new Random().nextInt(2);
         this.goalkeeping = 1 + new Random().nextInt(7);
         this.speed = i + j + new Random().nextInt(4);
         this.technique = i + j + new Random().nextInt(7);
         this.passing = i + j + new Random().nextInt(3);
         this.finishing = j + new Random().nextInt(6);
         this.playmaking = i + new Random().nextInt(5);
         if (this.ey == 4 || this.ez == 4) {
            this.playmaking = this.playmaking + j + new Random().nextInt(5);
            this.passing = this.passing + j + new Random().nextInt(5);
         }

         if (this.ey == 5 || this.ez == 5) {
            this.finishing = this.finishing + j + new Random().nextInt(6);
         }

         if (this.ey == 6 || this.ez == 6) {
            this.passing = this.passing + 2 + new Random().nextInt(3);
         }

         if (this.ey == 7 || this.ez == 7) {
            this.tackling = this.tackling + j + new Random().nextInt(3);
         }

         if (this.ey == 8 || this.ez == 8) {
            this.technique = this.technique + j + new Random().nextInt(3);
         }

         if (this.ey == 9 || this.ez == 9) {
            this.finishing = this.finishing + 3 + new Random().nextInt(3);
         }

         if (this.ey == 10 || this.ez == 10) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
         }

         if (this.ey == 11 || this.ez == 11) {
            this.passing = this.passing + j + new Random().nextInt(2);
         }

         if (this.ey == 12 || this.ez == 12) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
            this.finishing += 2;
         }

         if (this.ey == 13 || this.ez == 13) {
            this.speed = this.speed + i + new Random().nextInt(3);
         }
      } else if (this.en == 3) {
         if (this.ex == 0) {
            this.tackling = (int)Math.round(this.overallStrength * 0.7) + new Random().nextInt(6);
            this.finishing = i + new Random().nextInt(4);
            this.passing = i + new Random().nextInt(3);
            this.technique = i + new Random().nextInt(7);
            this.playmaking = i + new Random().nextInt(5);
            this.speed = i + j + new Random().nextInt(6);
         } else {
            this.playmaking = this.overallStrength + new Random().nextInt(2);
            this.finishing = i + var3 + new Random().nextInt(4);
            this.passing = i + j + new Random().nextInt(3);
            this.technique = i + var3 + new Random().nextInt(7);
            this.tackling = i + new Random().nextInt(4);
            this.speed = i + var3 + new Random().nextInt(4);
         }

         this.goalkeeping = 1 + new Random().nextInt(4);
         if (this.ey == 4 || this.ez == 4) {
            this.playmaking = this.playmaking + j + new Random().nextInt(5);
            this.passing = this.passing + j + new Random().nextInt(5);
         }

         if (this.ey == 5 || this.ez == 5) {
            this.finishing = this.finishing + 2 + new Random().nextInt(3);
            this.tackling = this.tackling + 2 + new Random().nextInt(3);
         }

         if (this.ey == 6 || this.ez == 6) {
            this.passing = this.passing + 2 + new Random().nextInt(3);
         }

         if (this.ey == 7 || this.ez == 7) {
            this.tackling = this.tackling + j + new Random().nextInt(3);
         }

         if (this.ey == 8 || this.ez == 8) {
            this.technique = this.technique + j + new Random().nextInt(3);
         }

         if (this.ey == 9 || this.ez == 9) {
            this.finishing = this.finishing + j + new Random().nextInt(3);
         }

         if (this.ey == 10 || this.ez == 10) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
         }

         if (this.ey == 11 || this.ez == 11) {
            this.passing = this.passing + j + new Random().nextInt(2);
         }

         if (this.ey == 12 || this.ez == 12) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
         }

         if (this.ey == 13 || this.ez == 13) {
            this.speed = this.speed + i + new Random().nextInt(3);
         }
      } else if (this.en == 4) {
         this.finishing = (int)Math.round(this.overallStrength * 0.8) + new Random().nextInt(2);
         this.goalkeeping = 1 + new Random().nextInt(6);
         this.speed = i + var3 + new Random().nextInt(4);
         this.technique = i + var3 + new Random().nextInt(7);
         this.passing = i + j + new Random().nextInt(3);
         this.tackling = j + new Random().nextInt(6);
         this.playmaking = j + i + new Random().nextInt(5);
         if (this.ey == 4 || this.ez == 4) {
            this.playmaking = this.playmaking + i + new Random().nextInt(5);
            this.passing = this.passing + j + new Random().nextInt(5);
         }

         if (this.ey == 5 || this.ez == 5) {
            this.finishing = this.finishing + 2 + new Random().nextInt(3);
         }

         if (this.ey == 6 || this.ez == 6) {
            this.passing = this.passing + 2 + new Random().nextInt(3);
         }

         if (this.ey == 7 || this.ez == 7) {
            this.tackling = this.tackling + j + new Random().nextInt(3);
         }

         if (this.ey == 8 || this.ez == 8) {
            this.technique = this.technique + j + new Random().nextInt(3);
         }

         if (this.ey == 9 || this.ez == 9) {
            this.finishing = this.finishing + 3 + new Random().nextInt(3);
         }

         if (this.ey == 10 || this.ez == 10) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
         }

         if (this.ey == 11 || this.ez == 11) {
            this.passing = this.passing + i + new Random().nextInt(2);
         }

         if (this.ey == 12 || this.ez == 12) {
            this.tackling = this.tackling + 3 + new Random().nextInt(3);
            this.finishing += 2;
         }

         if (this.ey == 13 || this.ez == 13) {
            this.speed = this.speed + i + new Random().nextInt(3);
         }
      }

      if (this.goalkeeping > 100) {
         this.goalkeeping = 100;
      }

      if (this.speed > 100) {
         this.speed = 100;
      }

      if (this.technique > 100) {
         this.technique = 100;
      }

      if (this.passing > 100) {
         this.passing = 100;
      }

      if (this.tackling > 100) {
         this.tackling = 100;
      }

      if (this.playmaking > 100) {
         this.playmaking = 100;
      }

      if (this.finishing > 100) {
         this.finishing = 100;
      }
   }

   public void fJ() {
      int var1 = 0;
      int var2 = 350;
      if (this.getClub() != null) {
         if (this.getClub().ki()) {
            int var9 = this.getClub().getDivisao();
            if (var9 == 1) {
               var2 = 750;
            } else if (var9 == 2) {
               var2 = 550;
            } else if (var9 == 3) {
               var2 = 500;
            } else if (var9 == 4 || var9 == 5) {
               var2 = 450;
            }
         } else {
            int var3 = this.getClub().getDivisao();
            if (var3 == 1) {
               var2 = 600;
            } else if (var3 == 2) {
               var2 = 500;
            } else if (var3 == 3) {
               var2 = 450;
            } else if (var3 == 4 || var3 == 5) {
               var2 = 400;
            }
         }

         if (this.getClub().getNivel() > 20) {
            var2 += 50;
         }
      }

      int var10 = this.en;
      if (var10 == 0) {
         var2 -= 70;
      } else if (var10 == 1) {
         var2 -= 30;
      } else if (var10 == 2) {
         var2 -= 40;
      } else if (var10 == 4) {
         var2 -= 50;
      }

      var2 = (int)Math.round(0.5 * var2);
      int var4 = this.overallStrength * 2 * var2;
      int var5 = (this.em - 32) * 300;
      int var6 = 0;
      if (this.ek || this.el) {
         var6 = this.overallStrength * 250;
      }

      if (this.em < 32) {
         var1 = var4 + var6;
      } else {
         var1 = var4 - var5 + var6;
      }

      if (var1 < 500) {
         var1 = 500;
      }

      if (this.el) {
         var1 = (int)Math.round(var1 * 1.4);
      }

      if (this.isYouthPlayer()) {
         var1 = (int)Math.round(var1 * 0.1);
      }

      if (GamePersistence.careerState.isSalarioMensal()) {
         this.et = var1 * 4;
      } else {
         this.et = var1;
      }
   }

   public void fK() {
      int var1 = 0;
      int var2 = 10;
      int var3 = 10;
      int var4 = 366;
      byte var5 = 0;
      int var6 = C0696.valueOf("P" + Integer.toString(this.pais)).gg();
      if (this.getClub() != null) {
         var2 = this.getClub().getNivel();
      } else {
         var2 = 10;
      }

      var3 = this.overallStrength * 2;
      var3 *= var3;
      if (var2 >= 21) {
         var4 = 750;
      } else if (var2 >= 20) {
         var4 = 600;
      } else if (var2 >= 18) {
         var4 = 500;
      } else if (var2 >= 12) {
         var4 = 400;
      } else {
         var4 = 366;
      }

      if (this.ek) {
         if (var2 >= 22 && var6 == 0) {
            var4 *= 3;
         } else if (var2 >= 21 && var6 == 0) {
            var4 *= 2;
         } else {
            var4 = (int)Math.round(1.7 * var4);
         }
      }

      if (this.gm()) {
         var4 = (int)Math.round(1.6 * var4);
      }

      if (this.en == 4) {
         var4 = (int)Math.round(1.3 * var4);
      }

      if (this.status == 1) {
         var4 = (int)Math.round(var4 + 0.2 * var4);
      }

      if (var6 == 0) {
         var5 = 28;
      } else {
         var5 = 20;
      }

      if (this.em < 16) {
         this.em = 16;
      }

      int var7 = 0;
      if (this.em < 20) {
         var7 = (32 - this.em) * 27;
      } else if (this.em <= 25) {
         var7 = (32 - this.em) * 22;
      } else if (this.em < 32) {
         var7 = (32 - this.em) * 15;
      } else if (this.em < 34) {
         var7 = (34 - this.em) * 10;
      } else {
         var7 -= (this.em - 34) * 50;
      }

      var4 += var7;
      if (var4 <= 0) {
         var4 = 60;
      }

      var1 = var3 * var4;
      if (this.youthPlayer) {
         var1 = (int)Math.round(var1 * 0.03) * this.es;
      } else if (this.ff > 0 && GamePersistence.careerState.getSeasonNumber() == this.ff) {
         var1 = (int)Math.round(var1 * 0.18);
         if (var1 > this.fl() && this.fl() > 0) {
            var1 = this.fl();
         }
      } else if (this.ff > 0 && GamePersistence.careerState.getSeasonNumber() - 1 == this.ff) {
         var1 = (int)Math.round(var1 * 0.35);
      } else if (this.ff > 0 && GamePersistence.careerState.getSeasonNumber() - 2 == this.ff) {
         var1 = (int)Math.round(var1 * 0.65);
      }

      if (this.youthPlayer && this.es == 10) {
         var1 = (int)Math.round(var1 * 1.5);
      }

      this.eu = var1;
   }

   public int fL() {
      return this.ff;
   }

   public void ar(int i) {
      this.ff = i;
   }

   public String fM() {
      return "P" + Integer.toString(this.pais);
   }

   public int fN() {
      return C0696.valueOf("P" + Integer.toString(this.pais)).gg();
   }

   public boolean fO() {
      int[] var4 = GameConstants.rW;
      int var3 = GameConstants.rW.length;

      for (int var2 = 0; var2 < var3; var2++) {
         int var1 = var4[var2];
         if (var1 == this.pais) {
            return true;
         }
      }

      return false;
   }

   public boolean a(Match c0675, boolean bl) {
      Competition var3 = c0675.getCompetition();
      boolean var4 = true;
      boolean var5 = true;
      if (var3 == null || var3.b() == 0) {
         var4 = false;
      }

      if (this.isInjured()) {
         return false;
      }

      if (var4 && this.c(var3)) {
         var5 = false;
      }

      return !bl && this.getClub() != null && this.getClub().isUserControlled() && this.contractEndTimeMillis < GamePersistence.careerState.getCurrentDate().getTime().getTime() ? false : var5;
   }

   public boolean d(Match c0675) {
      Competition var2 = c0675.getCompetition();
      boolean var3 = true;
      boolean var4 = true;
      if (var2 == null || var2.b() == 0) {
         var3 = false;
      }

      if (this.isInjured()) {
         return false;
      } else if (var3 && this.c(var2)) {
         return false;
      } else {
         return this.getContractDaysRemaining() < 0 ? false : var4;
      }
   }

   public boolean isInjured() {
      return this.injuryEndTimeMillis > 0L && this.injuryEndTimeMillis > GamePersistence.careerState.getCurrentDate().getTimeInMillis();
   }

   public String getContractEndDateLabel() {
      String var1 = "contrato vencido";
      return this.contractEndTimeMillis > GamePersistence.careerState.getCurrentDate().getTime().getTime() ? ScheduleDay.a(this.contractEndTimeMillis) : var1;
   }

   public int a(Date date, Date date2) {
      return (int)((date2.getTime() - date.getTime()) / 86400000L);
   }

   public int a(long l, long m) {
      if (m > l) {
         long var5 = (m - l) / 86400000L;
         return (int)var5;
      } else {
         return 0;
      }
   }

   public int getContractDaysRemaining() {
      return this.a(GamePersistence.careerState.getCurrentDate().getTime().getTime(), this.contractEndTimeMillis);
   }

   public ImageIcon fS() {
      ImageIcon var1 = null;
      ImageIcon var2 = null;
      boolean var3 = false;
      if (this.injuryEndTimeMillis > 0L && this.isInjured()) {
         var1 = new ImageIcon(this.getClass().getResource("/aicons/icontusao.png"));
         var3 = true;
      }

      Competition var4 = null;
      if (CareerState.bl() != null) {
         var4 = CareerState.bl().getCompetition();
      }

      if (var4 != null) {
         int[] var5 = this.e(var4);
         if (var5 != null) {
            if (var5[1] >= 1) {
               var2 = new ImageIcon(this.getClass().getResource("/aicons/icv.png"));
               var3 = true;
            } else if (var5[0] == 1) {
               var2 = new ImageIcon(this.getClass().getResource("/aicons/ica1.png"));
               var3 = true;
            } else if (var5[0] == 2) {
               var2 = new ImageIcon(this.getClass().getResource("/aicons/ica2.png"));
               var3 = true;
            } else if (var5[0] >= 3) {
               var2 = new ImageIcon(this.getClass().getResource("/aicons/ica3.png"));
               var3 = true;
            }
         }
      }

      if (var3) {
         if (var1 == null) {
            var1 = new ImageIcon(this.getClass().getResource("/aicons/whiteIcon.png"));
         }

         if (var2 == null) {
            var2 = new ImageIcon(this.getClass().getResource("/aicons/whiteIcon.png"));
         }

         Image var11 = var1.getImage();
         Image var6 = var2.getImage();
         int var7 = var11.getWidth(null) + var6.getWidth(null);
         byte var8 = 18;
         BufferedImage var9 = new BufferedImage(var7, var8, 3);
         Graphics2D var10 = var9.createGraphics();
         var10.drawImage(var11, 0, 0, null);
         var10.drawImage(var6, var11.getWidth(null), 0, null);
         var10.dispose();
         this.fj = new ImageIcon(var9);
      }

      return this.fj;
   }

   public boolean c(Competition c0713) {
      C0674 var2 = this.h(c0713);
      return var2 != null && var2.gT();
   }

   public int d(Competition c0713) {
      C0674 var2 = this.h(c0713);
      return var2 != null ? var2.y() : 0;
   }

   public int[] e(Competition c0713) {
      C0674 var2 = this.h(c0713);
      return var2 != null ? var2.gW() : null;
   }

   public void f(Competition c0713) {
      C0674 var2 = this.h(c0713);
      if (var2 != null) {
         var2.gU();
      }
   }

   public int getTacticalPosition() {
      return this.tacticalPosition;
   }

   public void setTacticalPosition(int i) {
      this.tacticalPosition = i;
   }

   public int getEnergyAdjustedStrength() {
      return Math.round(this.energy / 100 * this.overallStrength);
   }

   public void fV() {
      if (this.getClub() != null) {
         if (this.em < 32) {
            this.fW();
         } else {
            this.fX();
         }

         this.eL = false;
      }
   }

   private void e(double d) {
      boolean var3 = true;
      int var4 = 0;
      if (GamePersistence.careerState.bO() == 3) {
         var3 = false;
      }

      if (var3) {
         var4 = this.h(d);
      } else {
         this.c(d * 10.0, var4);
      }

      if (this.aE(var4) > 1.0 && this.aF(var4) > 1) {
         this.aH(var4);
         this.aD(var4);
      }
   }

   private void f(double d) {
      int var3 = this.getClub().bQ(this.getPosicao());
      boolean var4 = true;
      if (GamePersistence.careerState.bO() == 3) {
         var4 = false;
      }

      if (this.getClub().isUserControlled() != null && this.getClub().isUserControlled() && !this.getClub().ll() && this.getClub().lm() == 1) {
         var4 = false;
      }

      if (var4) {
         var3 = this.h(d);
      } else {
         this.c(d * 2.0, var3);
      }

      for (int var5 = 0; var5 <= 6; var5++) {
         if (this.b(this.aE(var5), this.aF(var5)) && this.aF(var5) < 100) {
            this.aG(var5);
            this.aD(var5);
         }
      }
   }

   private boolean b(double d, int i) {
      int var4 = 100;
      if (this.getClub().kn()) {
         int var5 = this.getClub().getDivisao();
         int[][] var6 = new int[][]{
            {30, 30, 30, 30, 30, 30},
            {80, 85, 90, 95, 100, 100},
            {50, 60, 60, 65, 80, 80},
            {40, 40, 40, 45, 70, 70},
            {25, 30, 30, 30, 50, 60},
            {30, 30, 30, 30, 30, 30}
         };
         if (this.getClub().getReputacao() < 0 || this.getClub().getReputacao() > 5) {
            this.getClub().setReputacao(1);
         }

         var4 = var6[this.getClub().getDivisao()][this.getClub().getReputacao()];
      } else if (this.getClub().getReputacao() == 5) {
         var4 = 100;
      } else if (this.getClub().getReputacao() == 4) {
         var4 = 100;
      } else if (this.getClub().getReputacao() == 3) {
         var4 = 70;
      } else if (this.getClub().getReputacao() == 2) {
         var4 = 40;
      } else if (this.getClub().getReputacao() == 1) {
         var4 = 30;
      } else {
         var4 = 20;
      }

      byte var8 = 100;
      if (this.getClub().gg() == 0) {
         if (this.getClub().getPais() == 3 || this.getClub().getPais() == 72 || this.getClub().getPais() == 104 || this.getClub().getPais() == 65 || this.getClub().getPais() == 97) {
            var8 = 95;
         } else if (this.getClub().getPais() == 154 || this.getClub().getPais() == 85) {
            var8 = 90;
         } else if (this.getClub().getPais() != 21 && this.getClub().getPais() != 162) {
            var8 = 70;
         } else {
            var8 = 80;
         }
      } else if (this.getClub().gg() == 1) {
         if (this.getClub().getPais() == 29 || this.getClub().getPais() == 11) {
            var8 = 90;
         } else if (this.getClub().getPais() == 195 || this.getClub().getPais() == 46) {
            var8 = 80;
         } else if (this.getClub().getPais() == 195 || this.getClub().getPais() == 46 || this.getClub().getPais() == 42) {
            var8 = 80;
         } else if (this.getClub().getPais() != 151 && this.getClub().getPais() != 150) {
            var8 = 60;
         } else {
            var8 = 70;
         }
      } else if (this.getClub().gg() == 2) {
         if (this.getClub().getPais() == 10 || this.getClub().getPais() == 129 || this.getClub().getPais() == 57) {
            var8 = 75;
         } else if (this.getClub().getPais() != 141 && this.getClub().getPais() != 169 && this.getClub().getPais() != 190) {
            var8 = 60;
         } else {
            var8 = 70;
         }
      } else if (this.getClub().gg() == 3) {
         if (this.getClub().getPais() == 107 || this.getClub().getPais() == 49) {
            var8 = 75;
         } else if (this.getClub().getPais() != 98 && this.getClub().getPais() != 9 && this.getClub().getPais() != 59 && this.getClub().getPais() != 43) {
            var8 = 60;
         } else {
            var8 = 70;
         }
      } else if (this.getClub().gg() == 4) {
         if (this.getClub().getPais() == 131) {
            var8 = 80;
         } else if (this.getClub().getPais() == 68) {
            var8 = 70;
         } else if (this.getClub().getPais() == 51) {
            var8 = 65;
         } else {
            var8 = 55;
         }
      } else if (this.getClub().gg() == 5) {
         if (this.getClub().getPais() == 143) {
            var8 = 60;
         } else {
            var8 = 45;
         }
      }

      if (var4 > var8) {
         var4 = var8;
      }

      if (this.fd >= 60) {
         int var9 = new Random().nextInt(5);
         if (this.es == 7) {
            var4 = var4 + 5 + var9;
         } else if (this.es == 8) {
            var4 = var4 + 15 + var9;
         } else if (this.es == 9) {
            var4 = var4 + 25 + var9;
         } else if (this.es == 10) {
            var4 = var4 + 30 + var9;
         }

         if (var4 > 100) {
            var4 = 100;
         }
      }

      return !(d > 1.0) || i >= 100 ? false : i < var4;
   }

   private void fW() {
      double var1 = 50.0;
      int var3 = 15;
      double var4 = 0.0;
      if (this.getClub() != null) {
         var3 = this.getClub().getNivel();
         if (!this.getClub().kn()) {
            var4 = 0.03;
            if (this.getClub().getReputacao() >= 4) {
               var3 = 20;
            } else if (this.getClub().getReputacao() == 3) {
               var3 = 18;
            } else {
               var3 = 12;
            }
         }
      }

      double var6 = 0.0;
      if (var3 >= 19) {
         if (this.em < 20) {
            var6 = 8.0 / var1;
         } else if (this.em < 23) {
            var6 = 6.0 / var1;
         } else if (this.em < 29) {
            var6 = 5.0 / var1;
         } else {
            var6 = 4.0 / var1;
         }
      } else if (var3 >= 15) {
         if (this.em < 18) {
            var6 = 6.0 / var1;
         } else if (this.em < 21) {
            var6 = 5.0 / var1;
         } else if (this.em < 29) {
            var6 = 4.0 / var1;
         } else {
            var6 = 3.0 / var1;
         }
      } else if (var3 >= 11) {
         if (this.em < 18) {
            var6 = 5.0 / var1;
         } else if (this.em < 21) {
            var6 = 4.0 / var1;
         } else if (this.em < 29) {
            var6 = 3.0 / var1;
         } else {
            var6 = 2.0 / var1;
         }
      } else if (this.em < 18) {
         var6 = 4.0 / var1;
      } else if (this.em < 21) {
         var6 = 3.0 / var1;
      } else if (this.em < 29) {
         var6 = 2.0 / var1;
      } else {
         var6 = 1.0 / var1;
      }

      if (this.eL) {
         var6 += 0.04;
      }

      if (this.overallStrength >= 30 && this.overallStrength <= 40) {
         var6 -= 0.02;
      } else if (this.overallStrength >= 41 && this.overallStrength <= 50) {
         var6 -= 0.03;
      } else if (this.overallStrength >= 51 && this.overallStrength <= 70) {
         var6 -= 0.04;
      } else if (this.overallStrength >= 71 && this.overallStrength <= 100) {
         var6 -= 0.05;
      }

      if (this.fd > 0) {
         if (this.fd < 50) {
            var6 -= 0.05;
         } else if (this.fd < 70) {
            var6 -= 0.02;
         }

         if (this.es >= 9) {
            var6 += 0.07;
         } else if (this.es >= 7) {
            var6 += 0.05;
         }
      }

      if (this.gm()) {
         var6 += 0.02;
      } else if (this.ff()) {
         var6 += 0.01;
      }

      if (this.getClub().gg() != 2 && this.getClub().gg() != 3) {
         if (this.getClub().gg() == 5) {
            if (var6 > 0.06) {
               var6 -= 0.04;
            }
         } else if (this.getClub().gg() == 4) {
            if (this.getClub().getPais() != 131 && var6 > 0.06) {
               var6 -= 0.03;
            }
         } else if (this.getClub().gg() == 1) {
            if ((this.getClub().getPais() != 29 || this.getClub().getPais() != 11 || this.getClub().getPais() != 42 || this.getClub().getPais() != 195) && var6 > 0.06) {
               var6 -= 0.02;
            }
         } else if (this.getClub().gg() == 0) {
            if (this.getClub().getPais() == 3 || this.getClub().getPais() == 72 || this.getClub().getPais() == 104 || this.getClub().getPais() == 65 || this.getClub().getPais() == 97) {
               var6 += 0.01;
            } else if (this.getClub().getPais() != 154 && this.getClub().getPais() != 85 && this.getClub().getPais() != 21) {
               if (var6 > 0.06) {
                  var6 -= 0.02;
               }
            } else if (var6 > 0.06) {
               var6 -= 0.01;
            }
         }
      } else if (var6 > 0.06) {
         var6 -= 0.02;
      }

      var6 += var4;
      if (var6 < 0.0) {
         var6 = 0.01;
      }

      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         this.f(var6);
      }

      this.eM += var6;
      int var8 = 100;
      if (this.getClub().kn()) {
         int[][] var9 = new int[][]{
            {30, 30, 30, 30, 30, 30},
            {80, 85, 90, 95, 100, 100},
            {50, 60, 60, 65, 80, 80},
            {40, 40, 40, 45, 70, 70},
            {25, 30, 30, 30, 50, 60},
            {30, 30, 30, 30, 30, 30}
         };
         if (this.getClub().getReputacao() < 0 || this.getClub().getReputacao() > 5) {
            this.getClub().setReputacao(1);
         }

         var8 = var9[this.getClub().getDivisao()][this.getClub().getReputacao()];
      } else if (this.getClub().getReputacao() == 5) {
         var8 = 100;
      } else if (this.getClub().getReputacao() == 4) {
         var8 = 100;
      } else if (this.getClub().getReputacao() == 3) {
         var8 = 65;
      } else if (this.getClub().getReputacao() == 2) {
         var8 = 40;
      } else if (this.getClub().getReputacao() == 1) {
         var8 = 30;
      } else {
         var8 = 20;
      }

      byte var14 = 100;
      if (this.getClub().gg() == 0) {
         if (this.getClub().getPais() == 3 || this.getClub().getPais() == 72 || this.getClub().getPais() == 104 || this.getClub().getPais() == 65 || this.getClub().getPais() == 97) {
            var14 = 95;
         } else if (this.getClub().getPais() == 154 || this.getClub().getPais() == 85) {
            var14 = 90;
         } else if (this.getClub().getPais() != 21 && this.getClub().getPais() != 162) {
            var14 = 70;
         } else {
            var14 = 80;
         }
      } else if (this.getClub().gg() == 1) {
         if (this.getClub().getPais() == 29 || this.getClub().getPais() == 11) {
            var14 = 90;
         } else if (this.getClub().getPais() == 195 || this.getClub().getPais() == 46) {
            var14 = 80;
         } else if (this.getClub().getPais() == 195 || this.getClub().getPais() == 46 || this.getClub().getPais() == 42) {
            var14 = 80;
         } else if (this.getClub().getPais() != 151 && this.getClub().getPais() != 150) {
            var14 = 60;
         } else {
            var14 = 70;
         }
      } else if (this.getClub().gg() == 2) {
         if (this.getClub().getPais() == 10 || this.getClub().getPais() == 129 || this.getClub().getPais() == 57) {
            var14 = 75;
         } else if (this.getClub().getPais() != 141 && this.getClub().getPais() != 169 && this.getClub().getPais() != 190) {
            var14 = 60;
         } else {
            var14 = 70;
         }
      } else if (this.getClub().gg() == 3) {
         if (this.getClub().getPais() == 107 || this.getClub().getPais() == 49) {
            var14 = 75;
         } else if (this.getClub().getPais() != 98 && this.getClub().getPais() != 9 && this.getClub().getPais() != 59 && this.getClub().getPais() != 43) {
            var14 = 60;
         } else {
            var14 = 70;
         }
      } else if (this.getClub().gg() == 4) {
         if (this.getClub().getPais() == 131) {
            var14 = 80;
         } else if (this.getClub().getPais() == 68) {
            var14 = 70;
         } else if (this.getClub().getPais() == 51) {
            var14 = 65;
         } else {
            var14 = 55;
         }
      } else if (this.getClub().gg() == 5) {
         if (this.getClub().getPais() == 143) {
            var14 = 60;
         } else {
            var14 = 45;
         }
      }

      if (var8 > var14) {
         var8 = var14;
      }

      if (this.fd >= 60) {
         int var10 = new Random().nextInt(5);
         if (this.es == 7) {
            var8 = var8 + 5 + var10;
         } else if (this.es == 8) {
            var8 = var8 + 15 + var10;
         } else if (this.es == 9) {
            var8 = var8 + 25 + var10;
         } else if (this.es == 10) {
            var8 = var8 + 30 + var10;
         }

         if (var8 > 100) {
            var8 = 100;
         }
      }

      if (this.eM > 1.0 && this.overallStrength < 100) {
         if (this.overallStrength < var8) {
            this.overallStrength++;
            this.eM--;
         } else {
            this.eM = 1.0;
         }
      }

      if (this.overallStrength > 100) {
         this.overallStrength = 100;
      }
   }

   private void fX() {
      int var1 = this.getClub().getDivisao();
      double var2 = 0.0;
      double var4 = 50.0;
      int var6 = this.getClub().getNivel();
      double var7 = 0.0;
      double var9 = this.em - 31;
      if (!this.getClub().kn()) {
         if (this.getClub().getReputacao() >= 4) {
            var1 = 1;
         } else if (this.getClub().getReputacao() >= 3) {
            var1 = 2;
         } else {
            var1 = 3;
         }
      }

      if (var6 >= 20) {
         var9 -= 2.0;
      }

      if (this.overallStrength >= 1 && this.overallStrength <= 50) {
         var2 = 0.7 * var9;
      } else if (this.overallStrength >= 51 && this.overallStrength <= 70) {
         var2 = 1.0 * var9;
      } else if (this.overallStrength >= 71 && this.overallStrength <= 100) {
         var2 = 1.2 * var9;
      }

      if (var2 > 0.0) {
         var7 = var2 / var4;
         byte var11 = 1;
         if (var1 == 1) {
            var11 = 35;
         } else if (var1 == 2) {
            var11 = 25;
         } else if (var1 == 3) {
            var11 = 10;
         }

         this.eM += var7;
         if (GamePersistence.careerState.isHabilidadeIndividual()) {
            this.e(var7);
         }

         if (this.eM > 1.0 && this.overallStrength > var11) {
            this.overallStrength--;
            this.eM--;
         }
      }

      if (this.overallStrength < 1) {
         this.overallStrength = 1;
      }
   }

   public void fY() {
      if (this.getClub() != null && this.em <= 20) {
         double var1 = 0.01;
         double var3 = 40.0;
         if (this.em <= 17) {
            var1 = 20.0 / var3;
         } else if (this.em == 18) {
            var1 = 15.0 / var3;
         } else if (this.em == 19) {
            var1 = 14.0 / var3;
         } else if (this.em == 20) {
            var1 = 5.0 / var3;
         }

         if (this.es <= 3) {
            var1 += 0.03;
         } else if (this.es <= 6) {
            var1 += 0.04;
         } else if (this.es <= 8) {
            var1 += 0.07;
         } else if (this.es == 9) {
            var1 += 0.1;
         } else if (this.es == 10) {
            var1 += 0.11;
         }

         this.fe += var1;
         if (this.fe > 1.0 && this.fd < 100) {
            this.fd++;
            this.fe--;
         }

         if (this.fd > 100) {
            this.fd = 100;
         }
      }
   }

   public void fZ() {
      int var1 = 0;
      int var2 = new Random().nextInt(100) + 1;
      if (var2 <= 15) {
         var1 = this.es;
      } else if (var2 <= 60) {
         var1 = this.es - 1;
      } else {
         var1 = this.es + 1;
      }

      if (var1 < 1) {
         var1 = 1;
      }

      if (var1 > 10) {
         var1 = 10;
      }

      this.fc = var1;
   }

   public void ga() {
      int var1 = 0;
      if (this.em == 16) {
         var1 = 15;
      } else if (this.em == 17) {
         var1 = 35;
      } else if (this.em == 18) {
         var1 = 55;
      } else if (this.em == 19) {
         var1 = 70;
      } else if (this.em == 20) {
         var1 = 75;
      }

      var1 += new Random().nextInt(5) + 1;
      var1 += this.es;
      if (var1 < 1) {
         var1 = 1;
      }

      if (var1 > 100) {
         var1 = 95;
      }

      this.fd = var1;
   }

   public void gb() {
      this.em++;
   }

   public void gc() {
      this.gb();
      if (this.em > 35) {
         this.em = new Random().nextInt(10) + 18;
         this.dm = au(this.pais);
         this.eT.clear();
         this.eS.clear();
         this.fi = 0;
         this.fh = 0;
      }

      this.eS.clear();
      this.eU.clear();
   }

   public void gd() {
      this.gb();
      this.eS.clear();
      this.eU.clear();
      if (this.dm == null || this.dm.equals("TESTE")) {
         this.dm = au(this.pais);
      }

      this.ge();
   }

   public void ge() {
      if (this.getClub() != null && !this.eX) {
         if (this.getClub().isUserControlled()) {
            this.eY = false;
         }

         boolean var1 = false;
         int var2 = GameConstants.cu(100) + 1;
         if (this.em > 32) {
            int var3 = this.em;
            if (this.ff()) {
               var3--;
            }

            if (this.gm()) {
               var3 -= 3;
            }

            if (this.en == 0) {
               var3 -= 3;
            }

            if (var3 < 32) {
               var1 = false;
            } else if (var3 == 32) {
               if (var2 > 99) {
                  var1 = true;
               }
            } else if (var3 <= 34) {
               if (var2 > 90) {
                  var1 = true;
               }
            } else if (var3 <= 35) {
               if (var2 > 55) {
                  var1 = true;
               }
            } else if (var3 <= 36) {
               if (var2 > 30) {
                  var1 = true;
               }
            } else if (var3 <= 38) {
               if (var2 > 15) {
                  var1 = true;
               }
            } else if (var3 <= 39) {
               if (var2 > 5) {
                  var1 = true;
               }
            } else if (var3 <= 40) {
               if (var2 > 3) {
                  var1 = true;
               }
            } else if (var3 <= 42) {
               if (var2 > 2) {
                  var1 = true;
               }
            } else if (var3 <= 48) {
               if (var2 > 1) {
                  var1 = true;
               }
            } else {
               var1 = true;
            }

            if (var1) {
               if (!this.getClub().isUserControlled()) {
                  this.a(null, -1, true);
               } else {
                  new C0799(this.getClub().getCoach(), 34, 89, "", this.getNome());
               }
            }
         }
      }
   }

   public boolean a(String string, int i, boolean bl) {
      boolean var4 = false;
      boolean var5 = false;
      Club var6 = this.getClub();
      if (var6 == null) {
         return false;
      }

      if (var6.kn()) {
         int var7 = var6.getDivisao();
         byte var8 = 0;
         if (var7 == 0) {
            var8 = 120;
         } else if (var7 == 1) {
            var8 = 25;
         } else if (var7 == 2) {
            var8 = 50;
         } else if (var7 == 3) {
            var8 = 60;
         } else if (var7 == 4) {
            var8 = 100;
         } else {
            var8 = 125;
         }

         if (this.ek) {
            var8 = 5;
         }

         if (this.gm()) {
            var8 = 2;
         }

         int var9 = new Random().nextInt(var8);
         if (var9 == 1) {
            var4 = true;
         }
      }

      int[] var12 = new int[]{2, 3, 3, 6, 4};
      int var14 = 0;
      var14 = var6.bS(this.en) - 1;
      if (!var6.isUserControlled()) {
         i = this.en;
         if (var14 < var12[this.en]) {
            var5 = true;
            i = this.en;
         }

         if (var6.kw() < 16) {
            var5 = true;
         }
      }

      boolean var16 = false;
      if (var6.kx() >= 20 && var6.isUserControlled()) {
         var5 = true;
      }

      byte var10 = 2;
      if (var6.getDivisao() > 2) {
         var10 = 5;
      }

      if (var6.getReputacao() < 3) {
         var10 = 5;
      }

      if (var6.isUserControlled()) {
         var10 = 0;
      }

      if (var6.kx() >= 20 - var10 && !var5) {
         var16 = true;
      }

      var6.getSeniorPlayers().remove(this);
      this.gr().clear();
      this.gH().clear();
      if (GamePersistence.careerState.getSeasonNumber() < 2 && this.fh > 0) {
         new C0719(this.getNome(), this.gy(), this.gz());
      } else if (GamePersistence.careerState.getSeasonNumber() < 10 && this.fh > 10) {
         new C0719(this.getNome(), this.gy(), this.gz());
      } else if (GamePersistence.careerState.getSeasonNumber() < 20 && this.fh > 30) {
         new C0719(this.getNome(), this.gy(), this.gz());
      } else if (this.fh > 50) {
         new C0719(this.getNome(), this.gy(), this.gz());
      }

      this.fi = 0;
      this.fh = 0;
      this.fn = 0;
      if (this.gl()) {
         this.eX = false;
      }

      this.n(null);
      if (bl) {
         GamePersistence.careerState.bz.add(this);
      } else {
         GamePersistence.careerState.O().remove(this);
      }

      if (!var16) {
         Player var11 = null;
         var11 = a(var6, i, null, 0, string, bl);
         if (var5 && var11 != null) {
            C0677.a(bl, var11, var6);
         }
      }

      if (var4) {
         Coach var18 = new Coach(this.dm);
         GamePersistence.careerState.a(var18);
         var18.b(this.getClub(), this);
      }

      return true;
   }

   public void gf() {
      this.em++;
      boolean var1 = false;
      if (this.dm == null || this.dm.equals("TESTE")) {
         this.dm = au(this.pais);
      }

      Club var2 = this.getClub();
      int var3 = 4;
      int[] var4 = new int[]{1, 4, 5, 6, 6, 6};
      if (var2 != null && this.em >= 20) {
         var3 = var4[var2.getReputacao()];
         int[] var5 = var2.J(true);
         int[] var6 = new int[]{3, 5, 5, 8, 6};
         if (this.es >= var3 && var5[this.en] < var6[this.en]) {
            var1 = true;
         }

         if (var1) {
            if (var2.kw() < 32) {
               C0677.a(true, this, var2);
               if (var2.kx() < 20) {
                  a(var2, -1, null, 0, null, true);
               }
            }
         } else if (!var2.isUserControlled()) {
            a(var2, -1, this, 0, null, true);
         }
      }
   }

   public static Player a(Club club, int i, Player player, int j, String string, Boolean boolean_) {
      Player var6;
      if (player == null) {
         C0689 var7 = new C0689();
         var6 = new Player(var7, club);
         if (boolean_) {
            GamePersistence.careerState.bA.add(var6);
         } else {
            GamePersistence.careerState.Q().add(var6);
         }

         if (!club.getYouthPlayers().contains(club)) {
            club.getYouthPlayers().add(var6);
         }
      } else {
         var6 = player;
      }

      var6.youthPlayer = true;
      var6.n(club);
      int var11 = new Random().nextInt(100) + 1;
      byte var8 = 1;
      if (club.getNivel() < 19 && club.getReputacao() <= 3) {
         if (club.getNivel() >= 15) {
            if (var11 <= 2) {
               var8 = 1;
            } else if (var11 <= 5) {
               var8 = 2;
            } else if (var11 <= 4) {
               var8 = 3;
            } else if (var11 <= 10) {
               var8 = 4;
            } else if (var11 <= 30) {
               var8 = 5;
            } else if (var11 <= 65) {
               var8 = 6;
            } else if (var11 <= 90) {
               var8 = 7;
            } else if (var11 <= 95) {
               var8 = 8;
            } else if (var11 <= 98) {
               var8 = 9;
            } else if (var11 <= 100) {
               var8 = 10;
            }
         } else if (var11 <= 4) {
            var8 = 1;
         } else if (var11 <= 8) {
            var8 = 2;
         } else if (var11 <= 15) {
            var8 = 3;
         } else if (var11 <= 25) {
            var8 = 4;
         } else if (var11 <= 50) {
            var8 = 5;
         } else if (var11 <= 75) {
            var8 = 6;
         } else if (var11 <= 95) {
            var8 = 7;
         } else if (var11 <= 98) {
            var8 = 8;
         } else if (var11 <= 99) {
            var8 = 9;
         } else if (var11 <= 100) {
            var8 = 10;
         }
      } else if (var11 <= 2) {
         var8 = 1;
      } else if (var11 <= 5) {
         var8 = 2;
      } else if (var11 <= 4) {
         var8 = 3;
      } else if (var11 <= 10) {
         var8 = 4;
      } else if (var11 <= 25) {
         var8 = 5;
      } else if (var11 <= 60) {
         var8 = 6;
      } else if (var11 <= 80) {
         var8 = 7;
      } else if (var11 <= 90) {
         var8 = 8;
      } else if (var11 <= 98) {
         var8 = 9;
      } else if (var11 <= 100) {
         var8 = 10;
      }

      var6.es = var8;
      if (var11 == 1) {
         var6.ek = true;
      } else {
         var6.ek = false;
      }

      var6.em = new Random().nextInt(4) + 16;
      var11 = new Random().nextInt(100) + 1;
      if (var11 <= 10) {
         var6.en = 0;
      } else if (var11 <= 30) {
         var6.en = 1;
      } else if (var11 <= 50) {
         var6.en = 2;
      } else if (var11 <= 80) {
         var6.en = 3;
      } else {
         var6.en = 4;
      }

      if (i >= 0) {
         var6.en = i;
      }

      int[] var9 = at(var6.en);
      var6.ey = var9[0];
      var6.ez = var9[1];
      var6.pais = club.getPais();
      if (var11 == 1 && club.getNivel() >= 18) {
         int var10 = new Random().nextInt(6);
         if (club.getPais() == 29) {
            if (var10 == 0) {
               var6.pais = 11;
            } else if (var10 == 1) {
               var6.pais = 43;
            } else if (var10 == 2) {
               var6.pais = 195;
            } else if (var10 == 3) {
               var6.pais = 150;
            } else if (var10 == 4) {
               var6.pais = 84;
            } else {
               var6.pais = new Random().nextInt(200);
            }
         } else if (club.getPais() == 3 || club.getPais() == 154 || club.getPais() == 85 || club.getPais() == 104 || club.getPais() == 72) {
            if (var10 == 0) {
               var6.pais = 3;
            } else if (var10 == 1) {
               var6.pais = 154;
            } else if (var10 == 2) {
               var6.pais = 85;
            } else if (var10 == 3) {
               var6.pais = 104;
            } else if (var10 == 4) {
               var6.pais = 174;
            } else {
               var6.pais = 72;
            }
         }
      }

      if (var6.pais != club.getPais()) {
         var6.es = new Random().nextInt(4) + 7;
      }

      if (string == null) {
         var6.dm = au(var6.pais);
      } else {
         var6.dm = string;
      }

      var6.er = new Random().nextInt(2);
      var6.status = 0;
      var6.fG();
      var6.ga();
      var6.fI();
      var6.fJ();
      var6.fZ();
      return var6;
   }

   public static int[] at(int i) {
      int[][][] var1 = new int[][][]{
         {{0, 3}, {0, 1}, {2, 0}, {1, 2}, {3, 1}, {0, 2}},
         {{6, 10}, {6, 13}, {10, 11}, {10, 13}, {10, 6}, {10, 9}, {6, 11}},
         {{7, 10}, {7, 12}, {7, 5}, {10, 13}, {7, 13}, {7, 10}, {7, 5}, {7, 13}, {7, 12}, {7, 9}, {7, 10}, {5, 12}},
         {
               {4, 11},
               {4, 9},
               {9, 11},
               {11, 9},
               {4, 8},
               {4, 13},
               {7, 10},
               {7, 11},
               {7, 5},
               {7, 13},
               {10, 13},
               {10, 11},
               {9, 4},
               {10, 12},
               {4, 11},
               {8, 11},
               {7, 9},
               {11, 13},
               {7, 11}
         },
         {{9, 5}, {13, 9}, {9, 5}, {8, 9}, {9, 13}, {9, 5}, {9, 8}, {5, 13}, {8, 11}, {9, 11}, {9, 12}, {13, 8}}
      };
      int[][] var2 = var1[i];
      int var3 = GameConstants.cu(var2.length);
      return new int[]{var2[var3][0], var2[var3][1]};
   }

   public static String au(int i) {
      String var1 = null;
      var1 = new C0679().au(i);
      if (var1 == null || var1.length() == 0 || var1.isEmpty()) {
         var1 = av(i);
      }

      return var1;
   }

   public static String av(int i) {
      if (GamePersistence.careerState.aX().size() == 0) {
         return null;
      }

      int var1 = i;
      int var2 = C0696.valueOf("P" + Integer.toString(i)).gg();
      short var3 = 0;
      short var4 = 0;
      String var5 = new String();
      if (var2 == 0) {
         if (var1 == 97 || var1 == 62 || var1 == 100 || var1 == 101 || var1 == 145) {
            var3 = 8710;
            var4 = 1980;
         } else if (var1 == 3 || var1 == 15) {
            var3 = 10870;
            var4 = 1155;
         } else if (var1 == 104) {
            var3 = 12025;
            var4 = 1700;
         } else if (var1 == 72) {
            var3 = 13726;
            var4 = 901;
         } else if (var1 == 85) {
            var3 = 14627;
            var4 = 1830;
         } else if (var1 == 154) {
            var3 = 16458;
            var4 = 3528;
         } else if (var1 == 142 || var1 == 70 || var1 == 15 || var1 == 179 || var1 == 54) {
            var3 = 19986;
            var4 = 1340;
         } else if (var1 == 162 || var1 == 193 || var1 == 12 || var1 == 25 || var1 == 54) {
            var3 = 21327;
            var4 = 1429;
         } else if (var1 == 159 || var1 == 152 || var1 == 88 || var1 == 160 || var1 == 63 || var1 == 64) {
            var3 = 22756;
            var4 = 1257;
         } else if (var1 == 52 || var1 == 27) {
            var3 = 24013;
            var4 = 1774;
         } else if (var1 == 78 || var1 == 44) {
            var3 = 25787;
            var4 = 784;
         } else if (var1 == 21) {
            var3 = 13726;
            var4 = 2732;
         } else if (var1 == 65) {
            var3 = 5939;
            var4 = 2771;
         } else {
            var3 = 19986;
            var4 = 5801;
         }
      } else if (var2 == 1) {
         if (var1 == 29) {
            var3 = 1;
            var4 = 5938;
         } else {
            var3 = 5939;
            var4 = 2771;
         }
      } else if (var2 == 2) {
         if (var1 != 57 && var1 != 10 && var1 != 129 && var1 != 116 && var1 != 178 && var1 != 190) {
            var3 = 26571;
            var4 = 2398;
         } else {
            var3 = 31211;
            var4 = 2554;
         }
      } else if (var2 == 3) {
         if (var1 == 48 || var1 == 49) {
            var3 = 29578;
            var4 = 560;
         } else if (var1 == 107) {
            var3 = 30138;
            var4 = 1072;
         } else if (var1 == 43) {
            var3 = 28970;
            var4 = 607;
         } else if (var1 == 14) {
            var3 = 8710;
            var4 = 1980;
         } else if (var1 != 9
            && var1 != 18
            && var1 != 59
            && var1 != 89
            && var1 != 99
            && var1 != 98
            && var1 != 108
            && var1 != 111
            && var1 != 115
            && var1 != 117
            && var1 != 144
            && var1 != 146
            && var1 != 103
            && var1 != 39
            && var1 != 190) {
            var3 = 28970;
            var4 = 4795;
         } else {
            var3 = 31211;
            var4 = 2554;
         }
      } else if (var2 == 4) {
         if (var1 != 68 && var1 != 38 && var1 != 106) {
            var3 = 5939;
            var4 = 2771;
         } else {
            var3 = 8710;
            var4 = 1980;
         }
      } else if (var2 == 5) {
         var3 = 8710;
         var4 = 1980;
      } else {
         var3 = 1;
         var4 = 20000;
      }

      int var6 = new Random().nextInt(var4) + var3;
      if (var6 < GamePersistence.careerState.aX().size()) {
         var5 = (String)GamePersistence.careerState.aX().get(var6);
      }

      return var5;
   }

   public int gg() {
      return C0696.valueOf("P" + Integer.toString(this.pais)).gg();
   }

   public int gh() {
      return this.getClub() != null ? this.getClub().gg() : -1;
   }

   public Player(C0914 c0914, boolean bl, Club club) {
      this.setPais(c0914.getPais());
      this.setNome(c0914.getNome());
      this.n(club);
      this.setPosicao(c0914.getPosicao());
      this.setLado(c0914.getLado());
      this.el = c0914.isTopMundial();
      this.a(c0914.isEstrela());
      this.aq(c0914.getHash());
      this.setStatus(c0914.getStatus());
      this.setCr1(c0914.getCr1());
      this.setCr2(c0914.getCr2());
      this.h(bl);
      this.setIdade(c0914.getIdade());
      this.fG();
   }

   public C0674 g(Competition c0713) {
      Object var2 = null;

      for (int var3 = 0; var3 < this.eS.size(); var3++) {
         if (((C0674)this.eS.get(var3)).gS() == c0713) {
            return (C0674)this.eS.get(var3);
         }
      }

      return (C0674)var2;
   }

   public C0674 h(Competition c0713) {
      if (this.eS == null) {
         return null;
      }

      for (int var2 = 0; var2 < this.eS.size(); var2++) {
         if (((C0674)this.eS.get(var2)).gS() == c0713) {
            return (C0674)this.eS.get(var2);
         }
      }

      C0674 var3 = new C0674(this, c0713);
      this.eS.add(var3);
      return var3;
   }

   public C0729 o(Club club) {
      if (this.eT != null) {
         for (int var2 = 0; var2 < this.eT.size(); var2++) {
            if (((C0729)this.eT.get(var2)).ct() == club.getClubId() && ((C0729)this.eT.get(var2)).H() == GamePersistence.careerState.getSeasonNumber()) {
               return (C0729)this.eT.get(var2);
            }
         }
      }

      return null;
   }

   public void p(Club club) {
      int var2 = 0;
      int var3 = new Random().nextInt(14);
      int var4 = 5 + new Random().nextInt(20);
      if (this.energy < 10) {
         var2 += 5;
      } else if (this.energy < 50) {
         var2++;
      }

      if (this.em <= 20) {
         var2 = var3;
      } else if (this.em <= 25) {
         var2 = var2 + var3 + 1;
      } else if (this.em <= 30) {
         var2 = var2 + var3 + 2;
      } else if (this.em <= 35) {
         var2 = var2 + var3 + 3;
      } else if (this.em <= 40) {
         var2 = var2 + var3 + var4;
      } else if (this.em <= 45) {
         var2 = var2 + var3 + var4;
      } else {
         var2 = var2 + var3 + 10 + var4;
      }

      if (this.em >= 35) {
         this.overallStrength -= 5;
         if (this.overallStrength < 0) {
            this.overallStrength = 1;
         }
      }

      int var5 = new Random().nextInt(100);
      if (var5 == 1) {
         var2 += 70;
      } else if (var5 < 4) {
         var2 += 40;
      } else if (var5 < 10) {
         var2 += 20;
      }

      if (this.getClub() != null && this.getClub().getCoach() != null && this.getClub().getCoach().isUserControlled() && var2 >= 8) {
         if (var2 < 15) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(3) + 23, this.getNome(), "");
         } else if (var2 < 22) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(2) + 26, this.getNome(), "");
         } else if (var2 < 29) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(2) + 28, this.getNome(), "");
         } else if (var2 < 43) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(4) + 30, this.getNome(), "");
         } else if (var2 < 55) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(2) + 34, this.getNome(), "");
         } else if (var2 < 70) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(4) + 36, this.getNome(), "");
         } else if (var2 >= 70) {
            new C0799(this.getClub().getCoach(), 3, new Random().nextInt(4) + 40, this.getNome(), "");
         }
      }

      if (var2 > 0) {
         long var6 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime();
         long var8 = var2;
         var8 *= 86400000L;
         this.injuryEndTimeMillis = var6 + var8;
      }

      this.b(5, club);
   }

   public boolean a(int i, Competition c0713, Club club) {
      if (this.isYouthPlayer()) {
         return false;
      }

      if (c0713 != null && c0713 != GamePersistence.careerState.bv()) {
         C0674 var4 = this.h(c0713);
         if (i == 2) {
            var4.cz();
         } else if (i == 3) {
            var4.cB();
         } else if (i == 4) {
            int var5 = new Random().nextInt(1000);
            byte var6 = 1;
            if (var5 >= 700) {
               if (var5 < 900) {
                  var6 = 2;
               } else if (var5 < 970) {
                  var6 = 3;
               } else if (var5 <= 990) {
                  var6 = 5;
               } else if (var5 <= 1000) {
                  var6 = 10;
               }
            }

            if (this.getClub() != null && this.getClub().getCoach() != null && this.getClub().getCoach().isUserControlled()) {
               if (var6 == 2) {
                  new C0799(this.getClub().getCoach(), 1, new Random().nextInt(6) + 10, this.getNome(), "");
               } else if (var6 > 1) {
                  byte var7 = 1;
                  int var8 = 5;
                  if (var6 == 3) {
                     var8 = new Random().nextInt(5) + 5;
                  } else if (var6 == 5) {
                     var8 = new Random().nextInt(3) + 2;
                  } else if (var6 == 10) {
                     var8 = new Random().nextInt(2) + 0;
                  }

                  new C0799(true, 1, this.getClub(), this, this.getClub().getCoach(), var7, var8, this.getNome(), "");
               }
            }

            for (int var9 = 0; var9 < var6; var9++) {
               var4.cA();
            }
         }
      }

      this.b(i, club);
      return true;
   }

   public boolean a(Competition c0713, Club club) {
      if (this.isYouthPlayer()) {
         return false;
      }

      if (c0713 != null) {
         C0674 var3 = this.h(c0713);
         var3.z();
         CompetitionPlayerStats var4 = c0713.p(this);
         var4.z();
      }

      this.b(1, club);
      this.fh++;
      return true;
   }

   public void b(Competition c0713, Club club) {
      if (!this.isYouthPlayer()) {
         if (c0713 != null) {
            C0674 var3 = this.h(c0713);
            var3.cl();
         }

         this.b(0, club);
         this.fi++;
      }
   }

   public void a(Competition c0713, double d) {
      if (!this.isYouthPlayer() && c0713 != null) {
         C0674 var4 = this.h(c0713);
         var4.i(d);
      }
   }

   public void a(int i, Club club, Competition c0713) {
      this.a(i, club, 0.0, c0713);
   }

   public void b(int i, Club club) {
      this.a(i, club, 0.0, null);
   }

   public void a(int i, Club club, double d) {
      this.a(i, club, d, null);
   }

   public void a(int i, Club club, double d, Competition c0713) {
      C0729 var6 = this.o(club);
      if (var6 == null) {
         var6 = new C0729(this, club);
         if (this.eT != null) {
            this.eT.add(var6);
         }
      }

      if (i == 2) {
         var6.cz();
      } else if (i == 4) {
         var6.cA();
      } else if (i == 3) {
         var6.cB();
      } else if (i == 1) {
         var6.z();
      } else if (i == 5) {
         var6.cy();
      } else if (i == 0) {
         var6.cl();
      } else if (i == 8) {
         var6.a(this, c0713);
      } else if (i == 100) {
         var6.b(d);
      }
   }

   public void a(Competition c0713, Match c0675, int i, int j, Club club) {
      int[] var6 = new int[]{1, 2, 7, 15, 23};
      byte var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 90;

      for (int var11 = 0; var11 < c0675.getEvents().size(); var11++) {
         if (((MatchEvent)c0675.getEvents().get(var11)).getPrimaryPlayer() == this) {
            if (((MatchEvent)c0675.getEvents().get(var11)).getPeriod() == 1) {
               var10 = ((MatchEvent)c0675.getEvents().get(var11)).getMinute();
            } else {
               var10 = 48 + ((MatchEvent)c0675.getEvents().get(var11)).getMinute();
            }
         }

         if (((MatchEvent)c0675.getEvents().get(var11)).getSecondaryPlayer() == this) {
            if (((MatchEvent)c0675.getEvents().get(var11)).getPeriod() == 1) {
               var10 = 48 + (50 - ((MatchEvent)c0675.getEvents().get(var11)).getMinute());
            } else {
               var10 = 50 - ((MatchEvent)c0675.getEvents().get(var11)).getMinute();
            }
         }
      }

      if (i == 0) {
         if (c0675.getHomeGoals() > c0675.getAwayGoals()) {
            var7 = 1;
         } else if (c0675.getHomeGoals() < c0675.getAwayGoals()) {
            var7 = 2;
         }

         var8 = c0675.getHomeGoals();
         var9 = c0675.getAwayGoals();
      } else {
         if (c0675.getAwayGoals() > c0675.getHomeGoals()) {
            var7 = 1;
         } else if (c0675.getAwayGoals() < c0675.getHomeGoals()) {
            var7 = 2;
         }

         var8 = c0675.getAwayGoals();
         var9 = c0675.getHomeGoals();
      }

      double var21 = 5.5;
      int var13 = this.tacticalPosition;
      if (var13 < 1) {
         var13 = var6[this.en];
         this.tacticalPosition = var13;
      }

      if (var7 == 0) {
         if (this.overallStrength <= 30) {
            var21 = 5.5;
         } else if (this.overallStrength <= 60) {
            var21 = 5.8;
         } else if (this.overallStrength <= 90) {
            var21 = 6.2;
         } else {
            var21 = 6.8;
         }
      } else if (var7 == 1) {
         if (this.overallStrength <= 30) {
            var21 = 6.0;
         } else if (this.overallStrength <= 60) {
            var21 = 6.0;
         } else if (this.overallStrength <= 90) {
            var21 = 6.7;
         } else {
            var21 = 7.2;
         }
      } else if (var7 == 2) {
         if (this.overallStrength <= 30) {
            var21 = 5.0;
         } else if (this.overallStrength <= 60) {
            var21 = 5.2;
         } else if (this.overallStrength <= 90) {
            var21 = 5.5;
         } else {
            var21 = 6.0;
         }
      }

      if (this.isOutOfPosition()) {
         var21 -= 1.5;
         if (this.getTacticalPosition() == 1) {
            var21 -= 1.5;
         }
      }

      Random var14 = new Random();
      if (var13 >= 10 && var13 <= 17) {
         int[] var15 = c0675.getPossessionPercentages();
         if (var15[i] > var15[j]) {
            if (var14.nextInt(3) == 1) {
               var21 += 0.3;
            } else {
               var21 += 0.8;
            }

            if (this.ex == 0) {
               var21 += 0.3;
            }

            if (this.getCr1() == 11 || this.getCr1() == 4) {
               var21 += 0.5;
            }
         } else if (var15[i] < var15[j]) {
            if (var14.nextInt(3) == 1) {
               var21 -= 0.3;
            } else {
               var21 -= 0.8;
            }

            if (this.ex == 0) {
               var21 -= 0.5;
            }
         }
      }

      if (this.gB().y() > 0) {
         var21 += this.gB().y() * 0.9;
      }

      if (this.gB().tx() > 0) {
         var21 -= this.gB().tx() * 1.5;
      }

      if (this.gB().ty() > 0) {
         var21 -= this.gB().tx() * 1.2;
      }

      if (this.gB().tz() > 0) {
         var21 -= this.gB().tz() * 0.2;
      }

      if (this.gB().tA() > 0) {
         var21 -= this.gB().tA() * 0.8;
      }

      if (this.gB().cD() > 0) {
         var21 += this.gB().cD() * 0.4;
      }

      if (var13 >= 1 && var13 <= 13) {
         int[] var23 = c0675.getTackles();
         if (var23[i] > var23[j]) {
            if (var14.nextInt(3) == 1) {
               var21 += 0.9;
            } else {
               var21 += 0.6;
            }

            if (var13 >= 2 && var13 <= 9 && var14.nextInt(3) == 1) {
               var21 += 0.6;
            }

            if (var13 >= 11 && var13 <= 13 && var14.nextInt(3) == 1) {
               var21 += 0.6;
            }
         } else if (var23[i] < var23[j]) {
            var21 -= 0.5;
            if (var13 >= 3 && var13 <= 8 && var14.nextInt(4) == 1) {
               var21 -= 0.6;
            }

            if (var13 >= 11 && var13 <= 13 && var14.nextInt(4) == 1) {
               var21 -= 0.6;
            }
         }
      }

      if (this.gB().tK() > 0) {
         var21 += this.gB().tK() * 0.3;
      }

      if (var13 == 1) {
         var21 -= 0.8;
         int[] var24 = c0675.getShots();
         int[] var16 = c0675.getShotsOnTarget();
         int var17 = var16[j];
         var21 += var17 * 0.2;
         if (this.gB().tI() > 0) {
            var21 += this.gB().tI() * 1.2;
         }

         if (var24[j] > 10) {
            var21 += 0.2;
         } else if (var24[j] > 15) {
            var21 += 0.2;
         } else if (var24[j] > 20) {
            var21 += 0.3;
         }

         if (var9 >= 5) {
            var21 -= 2.0;
         } else if (var9 >= 4) {
            var21 -= 1.5;
         } else if (var9 >= 2) {
            var21--;
         } else if (var9 >= 1) {
            var21 -= 0.5;
         } else if (var9 == 0) {
            var21++;
         }

         if (var17 == 0) {
            var21 -= 1.5;
         }
      }

      if (var13 >= 1 && var13 <= 13) {
         if (var9 == 0) {
            var21 += 0.5;
            if (var13 >= 2 && var13 <= 9) {
               var21 += 0.5;
            }

            if (var13 >= 11 && var13 <= 13 && var14.nextInt(3) == 1) {
               var21 += 0.5;
            }
         } else if (var9 > 1) {
            var21 -= 0.1 * var9;
         }

         if (var13 >= 2 && var13 <= 13 && var14.nextInt(3) == 1) {
            var21 -= 0.4;
         }
      }

      if (this.ek) {
         var21 += 0.4;
      }

      if (this.el) {
         var21 += 0.6;
      }

      if (var21 > 10.0) {
         var21 = 10.0;
      }

      if (var21 < 0.0) {
         var21 = 1.0;
      }

      if (var10 < 15) {
         var21 -= 2.5;
      } else if (var10 < 45) {
         var21 -= 1.5;
      }

      if (var21 < 2.0) {
         var21 = 2.0;
      }

      if (var10 < 20 && var21 <= 2.0) {
         var21 = 0.0;
      }

      this.eN = var21;
      this.eU.add(new C0676(c0675, this.eN));
      if (this.getClub() != null) {
         this.a(100, club, var21);
      }

      if (var21 > 0.0 && c0675.getCompetition() != null && c0675.getCompetition() instanceof NationalLeague) {
         ((NationalLeague)c0675.getCompetition()).E(this);
         ((NationalLeague)c0675.getCompetition()).F(this);
      }

      if (var21 > 0.0 && c0713 != null && c0713.b() > 0) {
         this.a(c0713, var21);
      }
   }

   public int gi() {
      return this.fg;
   }

   public void gj() {
      this.fg++;
   }

   public void aw(int i) {
      this.fg = i;
   }

   public double gk() {
      return this.eN;
   }

   public void g(double d) {
      this.eN = d;
   }

   public void a(long l, boolean bl) {
      long var4 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime();
      if (!bl) {
         var4 = this.contractEndTimeMillis;
      }

      long var6 = l * 86400000L;
      this.contractEndTimeMillis = var4 + var6;
      int var8 = (int)l;
      this.aB(var8);
      this.fr = false;
   }

   public Boolean gl() {
      return this.eX;
   }

   public void i(Boolean boolean_) {
      this.eX = boolean_;
   }

   public void c(Club club, int i) {
      Club var3 = this.getClub();
      this.n(club);
      this.ew = 0;
      this.eW = false;
      this.eY = false;
      var3.v(i, 1);
      club.w(i, 1);
      Calendar var4 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a();
      PlayerTransferRecord var5 = new PlayerTransferRecord();
      var5.a(this);
      var5.f(var4.get(5), var4.get(2), var4.get(1));
      var5.cs(var3.getClubId());
      var5.cr(club.getClubId());
      var5.cq(i);
      this.ag(i);
      GamePersistence.careerState.bo().add(var5);
      var3.getYouthPlayers().remove(this);
      club.getYouthPlayers().add(this);
      this.fk = null;
   }

   public void a(Club club, int i, boolean bl, boolean bl2, boolean bl3) {
      Club var6 = this.getClub();
      this.am(var6.getClubId());
      this.n(club);
      if (!var6.equals(club)) {
         this.ew = 0;
         this.eW = false;
         this.eY = false;
         if (bl2 && !bl3) {
            this.eX = true;
         }

         if (bl3) {
            this.eX = false;
            this.eW = false;
         }

         Calendar var7 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a();
         int var8 = 0;
         if (!bl2 && !bl3) {
            if (bl && this.contractEndTimeMillis > 0L && var7 != null) {
               double var9 = 0.0;
               int var11 = this.getContractDaysRemaining();
               if (var11 > 0) {
                  if (var11 <= 30) {
                     var9 = 0.12;
                  } else if (var11 <= 60) {
                     var9 = 0.2;
                  } else if (var11 <= 90) {
                     var9 = 0.22;
                  } else if (var11 <= 180) {
                     var9 = 0.25;
                  } else {
                     var9 = 0.3;
                  }
               }

               var8 = (int)Math.round(i * var9);
            }

            if (var8 > 0) {
               var6.getFinances();
            }

            if (var6.isUserControlled()) {
               var6.v(i, 1);
               if (var8 > 0) {
                  var6.w(var8, 8);
               }
            }

            if (club.isUserControlled()) {
               club.w(i, 1);
            }
         }

         if (!bl2) {
            this.a(180L, true);
         } else {
            this.a(365L, true);
         }

         this.fm();
         if (var6.ke() == this) {
            var6.kA();
         }

         if (var6.kd() == this) {
            var6.kz();
         }

         if (var6.isUserControlled() && club.isUserControlled()) {
            this.e(true);
         }

         PlayerTransferRecord var12 = new PlayerTransferRecord();
         var12.a(this);
         var12.f(var7.get(5), var7.get(2), var7.get(1));
         var12.cs(var6.getClubId());
         var12.cr(club.getClubId());
         var12.cq(i);
         GamePersistence.careerState.bo().add(var12);
         var6.getSeniorPlayers().remove(this);
         if (var6.getSeniorPlayers().contains(this)) {
            var6.getSeniorPlayers().remove(this);
         }

         club.getSeniorPlayers().add(this);
         if (club.isUserControlled() && var6.isUserControlled()) {
            var6.I(false);
         }

         this.fk = null;
      }
   }

   public Boolean gm() {
      return this.el;
   }

   public JProgressBar a(Color color) {
      if (this.fk == null) {
         this.fk = new JProgressBar(1, 100);
      }

      this.fk.setValue(this.energy);
      this.fk.setStringPainted(true);
      if (color != null) {
         this.fk.setForeground(color);
      } else if (this.getClub() != null) {
         this.fk.setForeground(this.getClub().kB());
      }

      return this.fk;
   }

   public void a(JProgressBar jProgressBar) {
      this.fk = jProgressBar;
   }

   public String gn() {
      String var1 = "";
      double var2 = 0.0;
      double var4 = 0.0;
      double var6 = 0.0;
      if (this.gv() != null) {
         for (int var8 = this.gv().size() - 1; var8 >= 0; var8--) {
            if (((C0676)this.gv().get(var8)).C() >= 2.0) {
               var2 += ((C0676)this.gv().get(var8)).C();
               var6++;
            }
         }
      }

      if (var6 > 0.0) {
         var4 = var2 / var6;
         var1 = String.format("%.2f", var4);
         this.ab = var4;
      } else if (var6 == 0.0) {
         var1 = "--";
         this.ab = 0.0;
      }

      return var1;
   }

   public JProgressBar go() {
      if (this.fk == null) {
         this.fk = new JProgressBar(1, 100);
      }

      this.fk.setValue(this.fd);
      this.fk.setStringPainted(true);
      this.fk.setForeground(new Color(36, 91, 45));
      return this.fk;
   }

   public void a(ImageIcon imageIcon) {
      this.fj = imageIcon;
   }

   public ImageIcon gp() {
      return this.fl;
   }

   public void b(ImageIcon imageIcon) {
      this.fl = imageIcon;
   }

   public ImageIcon gq() {
      return this.fm;
   }

   public void c(ImageIcon imageIcon) {
      this.fm = imageIcon;
   }

   public ArrayList gr() {
      return this.eT;
   }

   public int gs() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.eT.size(); var2++) {
         if (((C0729)this.eT.get(var2)).H() == GamePersistence.careerState.getSeasonNumber()) {
            var1 += ((C0729)this.eT.get(var2)).cD();
         }
      }

      return var1;
   }

   public int gt() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.eT.size(); var2++) {
         if (((C0729)this.eT.get(var2)).H() == GamePersistence.careerState.getSeasonNumber()) {
            var1 += ((C0729)this.eT.get(var2)).y();
         }
      }

      return var1;
   }

   public int gu() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.eT.size(); var2++) {
         if (((C0729)this.eT.get(var2)).H() == GamePersistence.careerState.getSeasonNumber()) {
            var1 += ((C0729)this.eT.get(var2)).w();
         }
      }

      return var1;
   }

   public int i(Competition c0713) {
      C0674 var2 = this.h(c0713);
      return var2 != null ? var2.w() : 0;
   }

   public int j(Competition c0713) {
      C0674 var2 = this.h(c0713);
      return var2 != null ? var2.cD() : 0;
   }

   public String k(Competition c0713) {
      String var2 = "";
      double var3 = 0.0;
      C0674 var5 = this.g(c0713);
      if (var5 != null) {
         var3 = this.g(c0713).F();
      }

      if (var3 > 0.0) {
         var2 = String.format("%.2f", var3);
         this.ab = var3;
      } else {
         var2 = "--";
         this.ab = 0.0;
      }

      return var2;
   }

   public double l(Competition c0713) {
      C0674 var2 = this.g(c0713);
      return var2 != null ? this.g(c0713).F() : 0.0;
   }

   public ArrayList gv() {
      return this.eU;
   }

   public void q(Club club) {
      new C0825(this, this.getClub());
      this.a(club, 0, false, true, false);
   }

   public void r(Club club) {
      this.a(club, 0, false, false, true);
   }

   public int[] gw() {
      int[] var1 = new int[6];
      if (this.gr() != null) {
         for (int var2 = this.gr().size() - 1; var2 >= 0; var2--) {
            var1[0] += ((C0729)this.gr().get(var2)).w();
            var1[1] += ((C0729)this.gr().get(var2)).y();
            var1[2] += ((C0729)this.gr().get(var2)).cv();
            var1[3] += ((C0729)this.gr().get(var2)).cw();
            var1[4] += ((C0729)this.gr().get(var2)).cx();
            var1[5] += ((C0729)this.gr().get(var2)).cD();
         }
      }

      return var1;
   }

   public String gx() {
      String var1 = "";
      int var2 = 0;
      double var3 = 0.0;
      double var5 = 0.0;
      if (this.gr() != null) {
         for (int var7 = this.gr().size() - 1; var7 >= 0; var7--) {
            var2 += ((C0729)this.gr().get(var7)).cF();
            var5 += ((C0729)this.gr().get(var7)).F();
         }
      }

      if (var2 > 0) {
         var3 = var5 / var2;
         var1 = String.format("%.2f", var3);
      } else if (var2 == 0) {
         var1 = "--";
      }

      return var1;
   }

   @Override
   public String toString() {
      String var1 = "";
      if (this.fn() > 0) {
         var1 = Integer.toString(this.fn()) + " - ";
      }

      return var1 + this.getNome();
   }

   public int gy() {
      return this.fh;
   }

   public int gz() {
      return this.fi;
   }

   public int gA() {
      return this.fn;
   }

   public void ax(int i) {
      this.fn = i;
   }

   public C0824 gB() {
      if (this.fo == null) {
         this.fo = new C0824();
      }

      return this.fo;
   }

   public void B(ArrayList arrayList) {
      this.eS = arrayList;
   }

   public void C(ArrayList arrayList) {
      this.eT = arrayList;
   }

   public void D(ArrayList arrayList) {
      this.eU = arrayList;
   }

   public void j(Boolean boolean_) {
      this.el = boolean_;
   }

   public void b(JProgressBar jProgressBar) {
      this.fk = jProgressBar;
   }

   public void ay(int i) {
      if (this.gm() && this.getIdade() > 34) {
         this.j(false);
      }

      this.fp = i;
   }

   public int gC() {
      return this.fp;
   }

   public int gD() {
      return this.ei;
   }

   public void az(int i) {
      this.ei = i;
   }

   public int gE() {
      return this.ep;
   }

   public void aA(int i) {
      this.ep = i;
   }

   public boolean isOutOfPosition() {
      boolean var1 = false;
      if (this.getTacticalPosition() <= 0) {
         return true;
      }

      if (this.getTacticalPosition() <= 25 && GameConstants.sE[this.getTacticalPosition()][0] != this.getPosicao()) {
         if (this.getTacticalPosition() != 10 && this.getTacticalPosition() != 17) {
            var1 = true;
         } else if (this.getPosicao() != 1 || this.getPosicao() == 3) {
            var1 = true;
         }
      }

      return var1;
   }

   public int gG() {
      return this.fq;
   }

   public void aB(int i) {
      this.fq = i;
   }

   public ArrayList gH() {
      return this.eS;
   }

   public int gI() {
      return this.ej;
   }

   public void aC(int i) {
      this.ej = i;
   }

   public int h(double d) {
      byte var3 = 0;
      byte var4 = -1;
      byte var5 = -1;
      double var6 = d * 0.4;
      double var8 = d * 0.3;
      if (this.en == 0) {
         var3 = 0;
      } else if (this.en == 1) {
         if (this.ex == 0) {
            var3 = 4;
            var4 = 5;
            var5 = 6;
         } else {
            var3 = 3;
            var4 = 6;
            var5 = 4;
         }
      } else if (this.en == 2) {
         var3 = 4;
         var4 = 3;
         var5 = 5;
      } else if (this.en == 3) {
         if (this.ex == 0) {
            var3 = 4;
            var4 = 5;
            var5 = 6;
         } else {
            var3 = 5;
            var4 = 6;
            var5 = 4;
         }
      } else if (this.en == 4) {
         var3 = 6;
         var4 = 5;
         var5 = 4;
      }

      this.c(d, var3);
      if (var4 >= 0) {
         this.c(var6, var4);
      }

      if (var5 >= 0) {
         this.c(var8, var5);
      }

      return var3;
   }

   public void c(double d, int i) {
      if (i == 4 || i == 0) {
         d *= 1.2;
      }

      this.eH[i] = this.eH[i] + d;
   }

   public void aD(int i) {
      this.eH[i]--;
   }

   public double aE(int i) {
      return this.eH[i];
   }

   public int aF(int i) {
      if (i == 0) {
         return this.getGoalkeeping();
      } else if (i == 1) {
         return this.getSpeed();
      } else if (i == 2) {
         return this.getTechnique();
      } else if (i == 3) {
         return this.getPassing();
      } else if (i == 4) {
         return this.getTackling();
      } else {
         return i == 5 ? this.getPlaymaking() : this.getFinishing();
      }
   }

   public void aG(int i) {
      if (i == 0) {
         this.goalkeeping++;
         if (this.goalkeeping > 100) {
            this.goalkeeping = 100;
         }
      } else if (i == 1) {
         this.speed++;
         if (this.speed > 100) {
            this.speed = 100;
         }
      } else if (i == 2) {
         this.technique++;
         if (this.technique > 100) {
            this.technique = 100;
         }
      } else if (i == 3) {
         this.passing++;
         if (this.passing > 100) {
            this.passing = 100;
         }
      } else if (i == 4) {
         this.tackling++;
         if (this.tackling > 100) {
            this.tackling = 100;
         }
      } else if (i == 5) {
         this.playmaking++;
         if (this.playmaking > 100) {
            this.playmaking = 100;
         }
      } else if (i == 6) {
         this.finishing++;
         if (this.finishing > 100) {
            this.finishing = 100;
         }
      }
   }

   public void aH(int i) {
      if (i == 0) {
         this.goalkeeping--;
      } else if (i == 1) {
         this.speed--;
      } else if (i == 2) {
         this.technique--;
      } else if (i == 3) {
         this.passing--;
      } else if (i == 4) {
         this.tackling--;
      } else if (i == 5) {
         this.playmaking--;
      } else if (i == 6) {
         this.finishing--;
      }
   }

   public int getSpeed() {
      return this.speed;
   }

   public void setSpeed(int i) {
      this.speed = i;
   }

   public int getGoalkeeping() {
      return this.goalkeeping;
   }

   public void setGoalkeeping(int i) {
      this.goalkeeping = i;
   }

   public int getTechnique() {
      return this.technique;
   }

   public void setTechnique(int i) {
      this.technique = i;
   }

   public int getPassing() {
      return this.passing;
   }

   public void setPassing(int i) {
      this.passing = i;
   }

   public int getTackling() {
      return this.tackling;
   }

   public void setTackling(int i) {
      this.tackling = i;
   }

   public int getPlaymaking() {
      return this.playmaking;
   }

   public void setPlaymaking(int i) {
      this.playmaking = i;
   }

   public int getFinishing() {
      return this.finishing;
   }

   public void setFinishing(int i) {
      this.finishing = i;
   }

   public double F() {
      return this.ab;
   }

   public void c(double d) {
      this.ab = d;
   }

   public boolean gQ() {
      return this.fr;
   }

   public void r(boolean bl) {
      this.fr = bl;
   }
}
