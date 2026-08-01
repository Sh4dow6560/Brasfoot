package bf22.intermediary;

import mod.recovered.competition.ClubWorldCup;
import mod.recovered.competition.Finalissima;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0693 implements Serializable {
   private static final long serialVersionUID = 1L;
   private Calendar p = Calendar.getInstance();
   private ArrayList q = new ArrayList();
   private ArrayList r = new ArrayList();
   private ArrayList s = new ArrayList();
   private ArrayList t = new ArrayList();
   private ArrayList u = new ArrayList();
   private boolean v = false;
   private int w = 0;
   static final int DOM = 1;
   static final int z = 2;
   static final int A = 3;
   static final int B = 4;
   static final int C = 5;
   static final int D = 6;
   static final int F = 7;
   static final int G = 1;
   static final int H = 2;
   static final int I = 3;
   static final int J = 4;
   static final int K = 5;
   static final int L = 6;
   static final int ht = 12;
   static final int M = 7;
   static final int N = 8;
   static final int O = 9;
   static final int P = 10;
   static final int Q = 11;
   static final int hx = 13;
   static final int ov = 14;
   static final int R = 100;
   static final int S = 200;
   static final int ow = 15;

   public void clear() {
      for (int var1 = 0; var1 < this.s.size(); var1++) {
         ((Match)this.s.get(var1)).clear();
      }

      for (int var2 = 0; var2 < this.u.size(); var2++) {
         ((Competition)this.u.get(var2)).clear();
      }

      this.s.clear();
      this.t.clear();
      this.u.clear();
   }

   public Calendar a() {
      return this.p;
   }

   public void a(int i, int j, int k) {
      this.p.set(i, j, k);
   }

   public int b() {
      return this.w;
   }

   public void a(int i) {
      this.w = i;
   }

   public static ArrayList b(int i) {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < GamePersistence.careerState.R().size(); var2++) {
         if (((C0693)GamePersistence.careerState.R().get(var2)).b() == i) {
            var1.add(var2);
         }
      }

      return var1;
   }

   public static ArrayList c(int i) {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < GamePersistence.careerState.R().size(); var2++) {
         if (((C0693)GamePersistence.careerState.R().get(var2)).a().get(7) == i) {
            var1.add(var2);
         }
      }

      return var1;
   }

   public int c() {
      return this.p.get(2);
   }

   public static ArrayList d() {
      ArrayList var0 = new ArrayList();

      for (int var1 = 0; var1 < GamePersistence.careerState.R().size(); var1++) {
         if (((C0693)GamePersistence.careerState.R().get(var1)).a().get(5) == 2) {
            var0.add(var1);
         }
      }

      return var0;
   }

   public static int d(int i) {
      for (int var1 = GamePersistence.careerState.R().size() - 1; var1 >= 0; var1--) {
         if (((C0693)GamePersistence.careerState.R().get(var1)).b() == i) {
            return var1;
         }
      }

      return -1;
   }

   public static int e(int i) {
      for (int var1 = 0; var1 < GamePersistence.careerState.R().size(); var1++) {
         if (((C0693)GamePersistence.careerState.R().get(var1)).b() == i) {
            return var1;
         }
      }

      return -1;
   }

   public static int a(int i, int j) {
      int var2 = 1;

      for (int var3 = 0; var3 < GamePersistence.careerState.R().size(); var3++) {
         if (((C0693)GamePersistence.careerState.R().get(var3)).b() == i && var2 == j) {
            return var3;
         }

         if (((C0693)GamePersistence.careerState.R().get(var3)).b() == i) {
            var2++;
         }
      }

      return -1;
   }

   public static ArrayList a(int i, boolean bl) {
      ArrayList var2 = new ArrayList();
      int var3 = 0;
      if (bl) {
         var3 = 2;
      }

      for (int var4 = 0; var4 < GamePersistence.careerState.R().size(); var4++) {
         if (((C0693)GamePersistence.careerState.R().get(var4)).b() == i && !((C0693)GamePersistence.careerState.R().get(var4)).e()) {
            if (var3 <= 0) {
               var2.add(var4);
            }

            if (var3 > 0) {
               var3--;
            }
         }
      }

      return var2;
   }

   public boolean e() {
      return this.v;
   }

   public void a(boolean bl) {
      this.v = bl;
   }

   public String f() {
      DateFormat var1 = DateFormat.getDateInstance();
      SimpleDateFormat var2 = new SimpleDateFormat("dd/MM/yyyy");
      return var2.format(this.a().getTime());
   }

   public static String a(Calendar calendar) {
      DateFormat var1 = DateFormat.getDateInstance();
      return var1.format(calendar.getTime());
   }

   public static String a(Date date) {
      DateFormat var1 = DateFormat.getDateInstance();
      return var1.format(date.getTime());
   }

   public static String a(long l) {
      DateFormat var2 = DateFormat.getDateInstance();
      return var2.format(l);
   }

   private static void b(int i, int j) {
      int var2 = 0;
      int var3 = 0;

      for (int var4 = GamePersistence.careerState.R().size() - 1; var4 > 0; var4--) {
         if (((C0693)GamePersistence.careerState.R().get(var4)).b() > 0) {
            var3 = var4;
            break;
         }
      }

      if (var3 < GamePersistence.careerState.J()) {
         var3 = GamePersistence.careerState.J();
      }

      for (int var5 = var3; var5 < GamePersistence.careerState.R().size(); var5++) {
         if (((C0693)GamePersistence.careerState.R().get(var5)).b() == 0 && ((C0693)GamePersistence.careerState.R().get(var5)).a().get(7) == i) {
            var2 = var5;
            break;
         }
      }

      if (var2 > 0) {
         ((C0693)GamePersistence.careerState.R().get(var2)).a(j);
      }
   }

   public static void g() {
      b(1, 100);
      b(2, 15);
      b(3, 15);
      b(4, 10);
      b(5, 10);
      b(6, 15);
      b(7, 10);
      b(1, 10);
      b(2, 10);
      b(3, 10);
      b(4, 10);
      b(5, 10);
      b(6, 15);
      b(7, 10);
      b(1, 15);
      b(2, 10);
      b(3, 100);
      b(4, 10);
      b(5, 100);
      b(6, 10);
      b(7, 100);
      b(1, 3);
      b(3, 3);
      b(5, 3);
      b(1, 3);
      b(3, 3);
      b(5, 3);
      b(7, 11);
      b(1, 3);
      b(3, 3);
      b(5, 3);
      b(7, 200);
      b(1, 3);
      b(3, 3);
      b(5, 3);
      b(1, 3);
      b(3, 3);
      b(5, 3);
      b(1, 3);
      b(3, 3);
      b(4, 4);
      b(5, 3);
      b(1, 3);
      b(3, 3);
      b(5, 4);
      b(1, 3);
      b(3, 3);
      b(5, 4);
      b(1, 3);
      b(3, 100);
      b(4, 4);
      b(5, 200);
      b(1, 1);
      b(2, 100);
      b(4, 4);
      b(6, 12);
      b(1, 1);
      b(2, 200);
      b(4, 4);
      b(1, 1);
      b(2, 9);
      b(4, 4);
      b(6, 9);
      b(1, 1);
      b(2, 14);
      b(4, 4);
      b(5, 14);
      b(6, 12);
      b(7, 200);
      b(1, 1);
      b(2, 14);
      b(3, 2);
      b(5, 4);
      b(6, 12);
      b(1, 1);
      b(4, 2);
      b(6, 12);
      b(1, 1);
      b(2, 9);
      b(4, 4);
      b(5, 6);
      b(1, 1);
      b(4, 4);
      b(5, 6);
      b(7, 200);
      b(1, 1);
      b(2, 9);
      b(4, 4);
      b(5, 12);
      b(6, 9);
      b(1, 1);
      b(3, 2);
      b(4, 4);
      b(5, 6);
      b(6, 14);
      b(1, 1);
      b(2, 14);
      b(3, 2);
      b(5, 6);
      b(6, 12);
      b(7, 14);
      b(1, 1);
      b(3, 100);
      b(4, 4);
      b(5, 6);
      b(1, 1);
      b(2, 9);
      b(4, 4);
      b(5, 6);
      b(7, 200);
      b(1, 1);
      b(2, 9);
      b(4, 2);
      b(5, 12);
      b(6, 9);
      b(1, 1);
      b(2, 12);
      b(3, 2);
      b(4, 4);
      b(5, 6);
      b(7, 200);
      b(1, 1);
      b(2, 9);
      b(3, 4);
      b(4, 6);
      b(5, 7);
      b(7, 7);
      b(2, 7);
      b(4, 7);
      b(6, 7);
      b(1, 7);
      b(4, 7);
      b(1, 7);
      b(4, 1);
      b(6, 12);
      b(1, 1);
      b(2, 13);
      b(3, 100);
      b(4, 4);
      b(5, 6);
      b(1, 1);
      b(2, 9);
      b(3, 2);
      b(5, 6);
      b(6, 12);
      b(7, 200);
      b(1, 1);
      b(2, 9);
      b(3, 2);
      b(5, 6);
      b(6, 12);
      b(7, 9);
      b(1, 1);
      b(2, 9);
      b(4, 4);
      b(5, 6);
      b(6, 9);
      b(7, 200);
      b(1, 1);
      b(2, 13);
      b(4, 4);
      b(5, 9);
      b(6, 12);
      b(7, 9);
      b(1, 1);
      b(2, 9);
      b(3, 100);
      b(4, 4);
      b(5, 1);
      b(6, 9);
      b(1, 1);
      b(2, 14);
      b(3, 2);
      b(4, 4);
      b(5, 6);
      b(6, 14);
      b(1, 1);
      b(2, 9);
      b(3, 2);
      b(4, 4);
      b(5, 6);
      b(6, 9);
      b(1, 1);
      b(2, 9);
      b(4, 2);
      b(5, 6);
      b(6, 12);
      b(7, 200);
      b(1, 1);
      b(2, 12);
      b(4, 2);
      b(5, 6);
      b(6, 12);
      b(1, 1);
      b(2, 12);
      b(4, 2);
      b(2, 14);
      b(6, 12);
      b(7, 14);
      b(1, 1);
      b(2, 9);
      b(4, 2);
      b(5, 6);
      b(6, 12);
      b(1, 1);
      b(2, 9);
      b(3, 8);
      b(4, 12);
      b(5, 1);
      b(6, 9);
      b(1, 1);
      b(3, 8);
      b(4, 6);
      b(5, 1);
      b(6, 12);
      b(7, 200);
      b(1, 1);
      b(2, 9);
      b(3, 100);
      b(4, 6);
      b(5, 1);
      b(6, 9);
      b(1, 1);
      b(2, 9);
      b(3, 100);
      b(4, 6);
      b(5, 1);
      b(6, 12);
      b(1, 1);
      b(2, 12);
      b(3, 1);
      b(4, 9);
      b(5, 1);
      b(6, 12);
      b(7, 1);
      b(1, 1);
      b(2, 1);
      b(3, 1);
      b(4, 1);
      b(5, 1);
      b(6, 1);
      b(7, 1);
      b(1, 1);
      b(2, 1);
      b(3, 1);
      b(4, 1);
      b(5, 1);
      b(6, 5);
      b(7, 5);
      b(2, 5);
   }

   public ArrayList h() {
      return this.s;
   }

   public int i() {
      return this.s.size() > 0 ? ((Match)this.s.get(0)).hy().b() : 0;
   }

   public void a(Match c0675) {
      this.s.add(c0675);
   }

   public ArrayList j() {
      return this.t;
   }

   public void a(CompetitionStage c0678) {
      if (!this.t.contains(c0678)) {
         this.t.add(c0678);
      }
   }

   public void a(Competition c0713) {
      if (!this.u.contains(c0713)) {
         this.u.add(c0713);
      }
   }

   public static void b(int i, int j, int k) {
      String var3 = null;
      if (j == 1) {
         var3 = "cw";
      } else if (j == 2) {
         var3 = "ds";
      } else if (j == 3) {
         var3 = "aj";
      } else if (j == 4) {
         var3 = "cD";
      } else if (j == 5) {
         var3 = "dJ";
      } else if (j == 6) {
         var3 = "cS";
      } else if (j == 7) {
         var3 = "cO";
      } else if (j == 8) {
         var3 = "cSempregado";
      } else if (j == 9) {
         var3 = "cPromocao";
      } else if (j == 10) {
         var3 = "criaMataMataAscenso";
      } else if (j == 11) {
         var3 = "criaplayOffRebaixamento";
      }

      if (k == 0) {
         C0693 var4 = (C0693)GamePersistence.careerState.R().get(i);
         var4.q.add(var3);
      } else {
         C0693 var5 = (C0693)GamePersistence.careerState.R().get(i);
         var5.r.add(var3);
      }
   }

   public void f(int i) {
      String var2 = "cw";
      String var3 = "ds";
      String var4 = "aj";
      String var5 = "cD";
      String var6 = "dJ";
      String var7 = "cS";
      String var8 = "cO";
      String var9 = "cSempregado";
      String var10 = "cPromocao";
      String var11 = "criaMataMataAscenso";
      String var12 = "criaplayOffRebaixamento";
      ArrayList var13;
      if (i == 0) {
         var13 = this.q;
      } else {
         var13 = this.r;
      }

      if (var13.size() > 0) {
         for (int var14 = 0; var14 < var13.size(); var14++) {
            if (var2.equals(var13.get(var14))) {
               this.p();
            } else if (var3.equals(var13.get(var14))) {
               this.n();
            } else if (var4.equals(var13.get(var14))) {
               GamePersistence.careerState.aT();
            } else if (var5.equals(var13.get(var14))) {
               if (GamePersistence.careerState.bk()) {
                  this.m();
               } else if (GamePersistence.careerState.X()) {
                  this.l();
               }
            } else if (var6.equals(var13.get(var14))) {
               this.o();
            } else if (var7.equals(var13.get(var14))) {
               this.b(false);
            } else if (var8.equals(var13.get(var14))) {
               this.k();
            } else if (var9.equals(var13.get(var14))) {
               this.b(true);
            } else if (var10.equals(var13.get(var14))) {
               GamePersistence.coachJobMarket.zw();
            } else {
               var12.equals(var13.get(var14));
            }
         }
      }

      var13.clear();
   }

   private void k() {
      if (GamePersistence.careerState.isJogaSelecoesAll()) {
         for (int var1 = 0; var1 < GamePersistence.careerState.M().size(); var1++) {
            if (((Coach)GamePersistence.careerState.M().get(var1)).jo() != null) {
               MainWindow.a(((Coach)GamePersistence.careerState.M().get(var1)).jo().ka().jo(), true);
            }
         }
      }
   }

   private void b(boolean bl) {
      if (GamePersistence.careerState.isJogaSelecoesAll()) {
         for (int var3 = 0; var3 < GamePersistence.careerState.M().size(); var3++) {
            if (!bl) {
               if (((Coach)GamePersistence.careerState.M().get(var3)).jZ() && ((Coach)GamePersistence.careerState.M().get(var3)).jo() == null) {
                  ArrayList var2 = GamePersistence.coachJobMarket.a((Coach)GamePersistence.careerState.M().get(var3), bl);
                  if (!GamePersistence.careerState.bD() && var2 != null && var2.size() > 0) {
                     MainWindow.a(var2, (Coach)GamePersistence.careerState.M().get(var3), 1);
                  }
               }
            } else if (((Coach)GamePersistence.careerState.M().get(var3)).jZ()) {
               ArrayList var4 = GamePersistence.coachJobMarket.a((Coach)GamePersistence.careerState.M().get(var3), bl);
               if (!GamePersistence.careerState.bD() && var4 != null && var4.size() > 0) {
                  MainWindow.a(var4, (Coach)GamePersistence.careerState.M().get(var3), 1);
               }
            }
         }
      }
   }

   public void l() {
      CountryCompetitions var1 = GamePersistence.careerState.o(29);
      if (var1 != null) {
         ArrayList var2 = new ArrayList();
         var2.addAll(var1.jg());
         Collections.sort(var2, C1007.cN);
         var1.a(var2, false, "criaCopaBRAposRegionais");
      }
   }

   public void m() {
      CountryCompetitions var1 = GamePersistence.careerState.o(29);
      if (var1 != null && GamePersistence.careerState.bk() && var1.eb().size() == 4) {
         LeagueStage var2 = ((NationalLeague)var1.eb().get(var1.eb().size() - 1)).yi();
         ArrayList var3 = null;
         if (var2 != null) {
            var2.aN(false);
            int var4 = ((NationalLeague)var1.eb().get(var1.eb().size() - 1)).yi().getnTimes();
            var3 = C0741.Q(var4);
            if (var3 != null && var4 == var3.size()) {
               var2.yK().addAll(var3);
               var1.ek().removeAll(var3);
               var2.aN(false);
               var2.setDivisao(4);
               var2.yI();
               var2.yH();
            }
         }

         ArrayList var10 = new ArrayList();
         int var5 = 0;

         for (int var6 = 0; var6 <= 2; var6++) {
            for (int var7 = 0; var7 < ((NationalLeague)var1.eb().get(var6)).yi().yK().size(); var7++) {
               var10.add((Club)((NationalLeague)var1.eb().get(var6)).yi().yK().get(var7));
               var5++;
            }
         }

         var3 = C0741.eh();

         for (int var11 = 0; var11 < var3.size(); var11++) {
            if (!var10.contains(var3.get(var11))) {
               var10.add((Club)var3.get(var11));
            }
         }

         var1.a(var10, false, "criaSerieDCopa");
      }

      GamePersistence.careerState.bx().clear();
   }

   public void n() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aN().size(); var1++) {
         if (((Club)GamePersistence.careerState.aN().get(var1)).bY(this.c())) {
            ((Club)GamePersistence.careerState.aN().get(var1)).kJ();
         }
      }
   }

   public void o() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aN().size(); var1++) {
         if (((Club)GamePersistence.careerState.aN().get(var1)).kL() != null && ((Club)GamePersistence.careerState.aN().get(var1)).kL().eQ() > 0) {
            ((Club)GamePersistence.careerState.aN().get(var1)).w(((Club)GamePersistence.careerState.aN().get(var1)).kL().eQ(), 4);
         }
      }
   }

   public void p() {
      ClubWorldCup var1 = GamePersistence.careerState.aR();
      var1.zC();
   }

   public void K() {
      for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
         ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).K();
      }
   }

   public static void q() {
      if (GamePersistence.careerState.isJogaSelecoesAll()) {
         if (GamePersistence.careerState.isJogaEstadual()) {
            int var0 = a(3, 4);
            if (var0 > 0) {
               b(var0, 6, 1);
            }
         }

         int var5 = a(1, 1);
         if (var5 > 0) {
            b(var5, 8, 1);
         }

         int var1 = e(7);
         if (var1 > 0) {
            b(var1, 6, 1);
         }

         int var2 = e(7);
         if (var2 > 0) {
            b(var2, 7, 1);
         }

         int var3 = a(1, 12);
         if (var3 > 0) {
            b(var3, 6, 1);
         }

         int var4 = a(1, 18);
         if (var4 > 0) {
            b(var4, 6, 1);
         }
      }

      int var6 = a(1, 20);
      if (var6 > 0) {
         b(var6, 9, 1);
      }
   }

   public ArrayList r() {
      return this.q;
   }

   public ArrayList s() {
      return this.r;
   }

   public ArrayList t() {
      return this.u;
   }

   public boolean a(Club club) {
      for (int var2 = 0; var2 < this.s.size(); var2++) {
         if (((Match)this.s.get(var2)).hc() == club || ((Match)this.s.get(var2)).hd() == club) {
            return true;
         }
      }

      return false;
   }

   public static void aD() {
      String var0 = "";

      for (int var1 = 0; var1 < GamePersistence.careerState.R().size(); var1++) {
         if (((C0693)GamePersistence.careerState.R().get(var1)).b() > 0) {
            if (var0.equals(((C0693)GamePersistence.careerState.R().get(var1)).f())) {
               System.out.println("erro de data: " + var1);
            }

            var0 = ((C0693)GamePersistence.careerState.R().get(var1)).f();
         }
      }
   }

   public static void u() {
      int var0 = 0;
      var0 = 0;
      ArrayList var1 = b(100);

      for (int var2 = 0; var2 < var1.size(); var2++) {
         System.out
            .println(
               "Amistoso Clube:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var2))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var2))).a().get(7)]
                  + " "
                  + var1.get(var2)
            );
      }

      var0 = 0;
      var1 = b(200);

      for (int var34 = 0; var34 < var1.size(); var34++) {
         System.out
            .println(
               "Amistoso Seleção:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var34))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var34))).a().get(7)]
                  + " "
                  + var1.get(var34)
            );
      }

      var0 = 0;
      var1 = b(3);

      for (int var35 = 0; var35 < var1.size(); var35++) {
         System.out
            .println(
               "Estadual:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var35))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var35))).a().get(7)]
                  + " "
                  + var1.get(var35)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(10);

      for (int var36 = 0; var36 < var1.size(); var36++) {
         System.out
            .println(
               "Regional:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var36))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var36))).a().get(7)]
                  + " "
                  + var1.get(var36)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(11);

      for (int var37 = 0; var37 < var1.size(); var37++) {
         System.out
            .println(
               "SuperCopa:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var37))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var37))).a().get(7)]
                  + " "
                  + var1.get(var37)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(1);

      for (int var38 = 0; var38 < var1.size(); var38++) {
         System.out
            .println(
               "Nacional:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var38))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var38))).a().get(7)]
                  + " "
                  + var1.get(var38)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(4);

      for (int var39 = 0; var39 < var1.size(); var39++) {
         System.out
            .println(
               "Int1:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var39))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var39))).a().get(7)]
                  + " "
                  + var1.get(var39)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(2);

      for (int var40 = 0; var40 < var1.size(); var40++) {
         System.out
            .println(
               "Copa:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var40))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var40))).a().get(7)]
                  + " "
                  + var1.get(var40)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(7);

      for (int var41 = 0; var41 < var1.size(); var41++) {
         System.out
            .println(
               "Selecoes:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var41))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var41))).a().get(7)]
                  + " "
                  + var1.get(var41)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(6);

      for (int var42 = 0; var42 < var1.size(); var42++) {
         System.out
            .println(
               "INT2:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var42))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var42))).a().get(7)]
                  + " "
                  + var1.get(var42)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(8);

      for (int var43 = 0; var43 < var1.size(); var43++) {
         System.out
            .println(
               "Recopa:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var43))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var43))).a().get(7)]
                  + " "
                  + var1.get(var43)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(12);

      for (int var44 = 0; var44 < var1.size(); var44++) {
         System.out
            .println(
               "INT3:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var44))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var44))).a().get(7)]
                  + " "
                  + var1.get(var44)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(5);

      for (int var45 = 0; var45 < var1.size(); var45++) {
         System.out
            .println(
               "Mundial:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var45))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var45))).a().get(7)]
                  + " "
                  + var1.get(var45)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(9);

      for (int var46 = 0; var46 < var1.size(); var46++) {
         System.out
            .println(
               "Elimin:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var46))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var46))).a().get(7)]
                  + " "
                  + var1.get(var46)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(13);

      for (int var47 = 0; var47 < var1.size(); var47++) {
         System.out
            .println(
               "Finalissima:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var47))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var47))).a().get(7)]
                  + " "
                  + var1.get(var47)
            );
      }

      var0 = 0;
      var1.clear();
      var1 = b(14);

      for (int var48 = 0; var48 < var1.size(); var48++) {
         System.out
            .println(
               "Liga Nacoes:"
                  + ++var0
                  + ") "
                  + ((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var48))).f()
                  + " "
                  + GameConstants.rF[((C0693)GamePersistence.careerState.R().get((Integer)var1.get(var48))).a().get(7)]
                  + " "
                  + var1.get(var48)
            );
      }
   }
}
