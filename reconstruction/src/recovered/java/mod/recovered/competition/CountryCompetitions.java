package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.geo.CountryInfo;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.config.NationalLeagueConfig;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;
import mod.recovered.model.Stadium;

public class CountryCompetitions implements Serializable {
   private static final long serialVersionUID = 1L;
   private ArrayList ds = new ArrayList();
   private int pais;
   private ArrayList dt = new ArrayList();
   private int dw = 0;
   private C0942 hu;
   private boolean[] duasVoltasMataMata = new boolean[]{true, true, true, true, true, true, true};
   private ArrayList hv = new ArrayList();
   private ArrayList hw = new ArrayList();
   private Club hy = null;
   private boolean hz = false;
   private int hr = 0;
   private int hA = 12;
   private String hB = "";
   private boolean hC = false;
   private transient ArrayList hD = new ArrayList();
   private transient ArrayList hE = null;
   public static Comparator hF = new CountryPlayerComparator();
   public static Comparator cN = new CountryRankingComparator();

   public CountryCompetitions() {
   }

   public CountryCompetitions(int i) {
      this.hB = C0696.valueOf("P" + i).getNome();
      this.pais = i;
      this.hr = new Random().nextInt(50000);
   }

   public void iT() {
      for (int var1 = 0; var1 < GamePersistence.SR.P().size(); var1++) {
         if (((Club)GamePersistence.SR.P().get(var1)).getPais() == this.pais) {
            this.hv.add((Club)GamePersistence.SR.P().get(var1));
         }
      }
   }

   public void K() {
      for (int var1 = 0; var1 < this.ds.size(); var1++) {
         C0924 var2 = null;
         if (var1 + 1 < this.ds.size()) {
            var2 = (C0924)this.ds.get(var1 + 1);
         }

         ((C0924)this.ds.get(var1)).a(var2);
      }
   }

   public boolean fa(int i) {
      return i >= this.ds.size();
   }

   public C0924 fo(int i) {
      Object var2 = null;
      return i < this.ds.size() ? (C0924)this.ds.get(i) : null;
   }

   public C0924 fp(int i) {
      if (i > 1) {
         Object var2 = null;
         int var3 = i - 2;
         if (var3 < this.ds.size()) {
            return (C0924)this.ds.get(var3);
         }
      }

      return null;
   }

   public void Ar() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      var1.addAll(this.hv);

      for (int var3 = 0; var3 < var1.size(); var3++) {
         ((Club)var1.get(var3)).l(true);
      }

      Collections.sort(var1, C1007.cN);
      var2.addAll(var1);
      NationalLeagueConfig var13 = null;
      LeagueLoadOptions var4 = null;
      boolean var5 = false;
      ArrayList var6 = new ArrayList();
      byte var7 = 4;

      for (int var8 = 1; var8 <= var7; var8++) {
         var5 = false;
         var13 = t(this.pais, var8);
         var4 = new LeagueLoadOptions();
         var6.clear();
         int var9 = 0;
         if (var13 == null) {
            var5 = true;
         } else if (var13.getnTimes() > var1.size()) {
            var5 = true;
         }

         if (var5) {
            var4.nTimes = 20;
            var9 = 2;
            if (var1.size() >= 20) {
               var4.nTimes = 20;
               var9 = 4;
            } else if (var1.size() >= 18) {
               var4.nTimes = 18;
            } else if (var1.size() >= 16) {
               var4.nTimes = 16;
            } else if (var1.size() >= 14) {
               var4.nTimes = 14;
            } else if (var1.size() >= 12) {
               var4.nTimes = 12;
            } else if (var1.size() >= 10) {
               var4.nTimes = 10;
            }

            var4.nomeLiga = CountryInfo.br(this.pais);
         } else {
            var4.nTimes = var13.getnTimes();
            var4.doisTurnos = var13.isDoisTurnos();
            var4.nGrupos = var13.getnGrupos();
            var4.jogosDentroGrupo = var13.isJogosDentroGrupo();
            var4.numeroTimesMataMata = var13.getNumeroTimesMataMata();
            var9 = var13.getnRebaixados();
            var4.duasVoltasMataMata = var13.getDuasVoltasMataMata();
            var4.desempateEstadual = var13.getDesempate();
            var4.classificaPeloGeral = var13.isClassificaPeloGeral();
            var4.melhoresTerceiros = var13.isMelhoresTerceiros();
            var4.numeroTurnos = var13.getFormula();
            if (var4.nTimes <= 10 && var9 > 2) {
               var9 = 2;
            }

            if (var13.getNome2() != null) {
               var4.nomeLiga = var13.getNome2();
            } else {
               var4.nomeLiga = CountryInfo.br(this.pais);
            }

            var4.nomeDivisao = var13.getNomeDivisao();
         }

         if (var1.size() >= var4.nTimes) {
            if (var8 == 4 && this.pais == 29 && GamePersistence.SR.isJogaEstadual()) {
               GamePersistence.SR.e(true);
            } else {
               for (int var10 = 0; var10 < var4.nTimes; var10++) {
                  var6.add((Club)var1.get(var10));
               }
            }

            C0924 var19 = new C0924(this, this.ds.size() + 1);
            if (!var5) {
               var19.aS(var13.isRebaixadoPeloGrupo());
               var19.setRebaixadosDireto(var13.getRebaixadosDireto());
               var19.setVagasSobemPeloMataMata(var13.getVagasSobemPeloMataMata());
               var19.a(var13.getDuasVoltasplayoffReb());
               var19.b(var13.getDuasVoltasMataMataSobe());
               if (var13.getVersaoArquivo() != 22 || var13.getRebaixadosDireto() == 0 || var13.getRebaixadosDireto() > var9) {
                  var19.setRebaixadosDireto(var9);
               }
            } else {
               var19.setRebaixadosDireto(var9);
            }

            var19.setnRebaixados(var9);
            LeagueStage var11 = new LeagueStage(var4, var6, 0, null, null, this, 1, null, false, null, false, var19);
            var19.q(var11);
            this.ds.add(var19);

            for (int var12 = 0; var12 < var6.size(); var12++) {
               var1.remove(var6.get(var12));
            }
         }
      }

      this.iV();
      boolean var17 = true;
      if (this.pais == 29 && GamePersistence.SR.bk()) {
         var17 = false;
      } else if (this.pais == 29 && GamePersistence.SR.isJogaRegionais()) {
         var17 = false;
      } else if (this.pais == 29 && GamePersistence.vM().isNovoFormatoCopa()) {
         var17 = false;
      } else if (this.pais == 29 && !GamePersistence.SR.isJogaEstadual() && !GamePersistence.SR.isJogaRegionais()) {
         var17 = false;
      }

      if (var17) {
         this.a(var2, false, "criaLigas");
      }

      if (this.pais == 29 && GamePersistence.SR.isJogaEstadual()) {
         C0741.dZ();
      }
   }

   public static NationalLeagueConfig t(int i, int j) {
      for (int var2 = 0; var2 < GamePersistence.SR.bG.size(); var2++) {
         if (((NationalLeagueConfig)GamePersistence.SR.bG.get(var2)).getPais() == i && ((NationalLeagueConfig)GamePersistence.SR.bG.get(var2)).getDivisao() == j) {
            return (NationalLeagueConfig)GamePersistence.SR.bG.get(var2);
         }
      }

      return null;
   }

   private void iV() {
      for (int var1 = 0; var1 < GamePersistence.SR.P().size(); var1++) {
         if (((Club)GamePersistence.SR.P().get(var1)).getPais() == this.pais && ((Club)GamePersistence.SR.P().get(var1)).getDivisao() == 0) {
            this.dt.add((Club)GamePersistence.SR.P().get(var1));
            ((Club)GamePersistence.SR.P().get(var1)).setDivisao(0);
         }
      }

      Collections.sort(this.dt, C1007.abm);
   }

   public int iW() {
      int var1 = this.hv.size();
      byte var2 = 0;
      if (var1 >= 128) {
         var2 = 7;
      } else if (var1 >= 64) {
         var2 = 6;
      } else if (var1 >= 32) {
         var2 = 5;
      } else if (var1 >= 16) {
         var2 = 4;
      } else if (var1 >= 8) {
         var2 = 3;
      }

      return var2 - 1;
   }

   public void y(boolean bl) {
      ArrayList var2 = new ArrayList();
      if (this.ds.size() >= 1) {
         Club var3 = null;
         Object var4 = null;
         Object var5 = null;
         var2.addAll(((C0924)this.ds.get(0)).yi().yV());
         if (this.ds.size() > 1) {
            ArrayList var6 = ((C0924)this.ds.get(1)).yi().yV();
            var2.addAll(var6);
            if (var6.size() > 0) {
               var3 = (Club)var6.get(0);
            }
         }

         if (var2.size() < 12) {
            var2.addAll(this.ek());
         }

         if (bl && var3 != null) {
            var2.remove(var3);
            var2.add(0, var3);
         }

         Club[] var10 = this.bk(GamePersistence.SR.H() - 1);
         if (var10 != null) {
            var2.remove(var10[0]);
            var2.add(0, var10[0]);
         }

         if (GamePersistence.SR.aH() != null && GamePersistence.SR.aH().yz() != null && GamePersistence.SR.aH().yz().getPais() == this.pais) {
            var5 = GamePersistence.SR.aH().yz();
            var2.remove(var5);
            var2.add(0, var5);
         }

         if (GamePersistence.SR.aF() != null && GamePersistence.SR.aF().yz() != null && GamePersistence.SR.aF().yz().getPais() == this.pais) {
            var4 = GamePersistence.SR.aF().yz();
            var2.remove(var4);
            var2.add(0, var4);
         }
      }

      this.hu.Bi();
      if (var2.size() >= 12) {
         for (int var7 = 0; var7 <= 11; var7++) {
            this.hu.W((Club)var2.get(var7));
         }
      }
   }

   public void ja() {
      this.a(this.hv, false, "CriaCopaAno1PosLib");
   }

   public void a(ArrayList arrayList, boolean bl, String string) {
      int var4 = arrayList.size();
      if (this.pais == 29 && var4 >= 91 && GamePersistence.vM().isNovoFormatoCopa() && !bl) {
         if (this.hu == null) {
            this.hu = new C0942(this);
         }

         this.hu.b(this.hu, arrayList, this.duasVoltasMataMata);
      } else if (var4 >= 8) {
         if (this.hu == null) {
            this.hu = new C0942(this);
         }

         this.hu.a(this.hu, arrayList, this.duasVoltasMataMata);
      }
   }

   public int ec() {
      return this.dw;
   }

   public void jb() {
      this.dw++;
   }

   public ArrayList eb() {
      return this.ds;
   }

   public int jc() {
      return this.pais;
   }

   public void bj(int i) {
      this.pais = i;
   }

   public Club[] bk(int i) {
      Club[] var2 = new Club[2];
      if (this.hu != null) {
         for (int var3 = 0; var3 < this.hu.mn().size(); var3++) {
            if (((CompetitionSeasonResult)this.hu.mn().get(var3)).H() == i) {
               var2[0] = ((CompetitionSeasonResult)this.hu.mn().get(var3)).ce();
               var2[1] = ((CompetitionSeasonResult)this.hu.mn().get(var3)).cf();
               return var2;
            }
         }
      }

      return null;
   }

   public void jd() {
      if (this.hD.size() == 0) {
         if (this.ds.size() >= 1) {
            this.hD.addAll(((C0924)this.ds.get(0)).yi().yV());
            if (this.ds.size() > 1) {
               this.hD.addAll(((C0924)this.ds.get(1)).yi().yV());
            }
         } else {
            this.hD = this.je();
         }
      }
   }

   public void a(int i, ArrayList arrayList, ArrayList arrayList2, boolean bl) {
      this.jd();
      if (bl) {
         Club[] var5 = this.bk(GamePersistence.SR.H() - 1);
         if (var5 != null && !arrayList2.contains(var5[0])) {
            arrayList.add(var5[0]);
            arrayList2.add(var5[0]);
            i--;
         }
      }

      if (i > 0) {
         for (int var6 = 0; var6 < this.hD.size(); var6++) {
            if (i > 0 && !arrayList2.contains(this.hD.get(var6))) {
               arrayList.add((Club)this.hD.get(var6));
               arrayList2.add((Club)this.hD.get(var6));
               i--;
            }

            if (i == 0) {
               break;
            }
         }
      }
   }

   private ArrayList je() {
      int[] var1 = new int[]{85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35};
      int var2 = 0;
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < this.hv.size(); var5++) {
         var3.add((Club)this.hv.get(var5));
         ((Club)this.hv.get(var5)).bR(new Random().nextInt(1000) + 1);
      }

      Collections.sort(var3, C1007.cN);

      for (int var8 = 0; var8 < var3.size(); var8++) {
         if (var8 < var1.length) {
            var2 = var1[var8];
         } else {
            var2 = 20;
         }

         int var6 = new Random().nextInt(100) + 1;
         if (var6 <= var2) {
            var4.add((Club)var3.get(var8));
         }
      }

      for (int var9 = 0; var9 < var3.size(); var9++) {
         if (!var4.contains(var3.get(var9))) {
            var4.add((Club)var3.get(var9));
         }
      }

      return var4;
   }

   public int gg() {
      return C0696.valueOf("P" + Integer.toString(this.pais)).gg();
   }

   public String jf() {
      return C0696.valueOf("P" + Integer.toString(this.pais)).getNome();
   }

   public ArrayList jg() {
      return this.hv;
   }

   public ArrayList jh() {
      return this.hw;
   }

   public void ee() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      boolean var3 = false;
      if (this.ds.size() > 0) {
         ((C0924)this.ds.get(0)).yi().ah(0, ((C0924)this.ds.get(0)).getnRebaixados());
      }

      for (int var4 = 1; var4 < this.ds.size(); var4++) {
         ((C0924)this.ds.get(var4)).yi().ah(((C0924)this.ds.get(var4 - 1)).getnRebaixados(), ((C0924)this.ds.get(var4)).getnRebaixados());
      }

      for (int var7 = 0; var7 < this.ds.size(); var7++) {
         if (var7 + 1 < this.ds.size()) {
            var2.clear();
            var1.clear();
            if (var3) {
               System.out.println("====divisao " + (var7 + 1));
            }

            for (int var10 = 0; var10 < ((C0924)this.ds.get(var7)).yi().yK().size(); var10++) {
               if (var3) {
                  System.out.println(var10 + " " + ((Club)((C0924)this.ds.get(var7)).yi().yK().get(var10)).getNome());
               }
            }

            for (int var11 = 0; var11 < ((C0924)this.ds.get(var7)).yi().yU().size(); var11++) {
               var2.add((Club)((C0924)this.ds.get(var7)).yi().yU().get(var11));
            }

            for (int var12 = 0; var12 < ((C0924)this.ds.get(var7 + 1)).yi().yW().size(); var12++) {
               var1.add((Club)((C0924)this.ds.get(var7 + 1)).yi().yW().get(var12));
            }

            if (var3) {
               for (int var13 = 0; var13 < var2.size(); var13++) {
                  System.out.println("<<desce " + ((Club)var2.get(var13)).getNome());
               }
            }

            if (var3) {
               for (int var14 = 0; var14 < var1.size(); var14++) {
                  System.out.println("<<sobe " + ((Club)var1.get(var14)).getNome());
               }
            }

            if (GamePersistence.SR.bk() && var7 == 2 && this.jc() == 29) {
               GamePersistence.SR.bY().clear();
            }

            if (var2.size() == var1.size()) {
               new ArrayList();

               for (int var19 = 0; var19 < var2.size(); var19++) {
                  if (!((C0924)this.ds.get(var7)).ac((Club)var2.get(var19))) {
                     ((Club)var2.get(var19)).b((Competition)this.ds.get(var7), 0);
                     ((Club)var1.get(var19)).b((Competition)this.ds.get(var7 + 1), 1);
                     ((C0924)this.ds.get(var7)).yi().yK().remove(var2.get(var19));
                     ((C0924)this.ds.get(var7 + 1)).yi().yK().add((Club)var2.get(var19));
                     ((C0924)this.ds.get(var7 + 1)).yi().yK().remove(var1.get(var19));
                     ((C0924)this.ds.get(var7)).yi().yK().add((Club)var1.get(var19));
                     if (GamePersistence.SR.bk() && var7 == 2 && this.jc() == 29) {
                        GamePersistence.SR.bY().add((Club)var2.get(var19));
                     }
                  }
               }
            }
         } else {
            if (var3) {
               System.out.println("====divisao ultima " + var7);
            }

            for (int var5 = 0; var5 < ((C0924)this.ds.get(var7)).yi().yK().size(); var5++) {
               if (var3) {
                  System.out.println(var5 + " " + ((Club)((C0924)this.ds.get(var7)).yi().yK().get(var5)).getNome());
               }
            }

            var2.clear();
            var1.clear();
            int var9 = ((C0924)this.ds.get(var7)).getnRebaixados();
            if (this.dt.size() < var9) {
               var9 = this.dt.size();
            }

            if (var9 > 0) {
               for (int var6 = 0; var6 < ((C0924)this.ds.get(var7)).yi().yU().size(); var6++) {
                  if (var6 < var9) {
                     var2.add((Club)((C0924)this.ds.get(var7)).yi().yU().get(var6));
                  }
               }

               if (var3) {
                  for (int var15 = 0; var15 < var2.size(); var15++) {
                     System.out.println("<<desce " + ((Club)var2.get(var15)).getNome());
                  }
               }

               for (int var16 = 0; var16 < var9; var16++) {
                  var1.add((Club)this.dt.get(var16));
               }

               if (var3) {
                  for (int var17 = 0; var17 < var1.size(); var17++) {
                     System.out.println("<<sobe " + ((Club)var1.get(var17)).getNome());
                  }
               }

               if (var2.size() == var1.size()) {
                  Collections.reverse(var1);

                  for (int var18 = 0; var18 < var2.size(); var18++) {
                     if (!((C0924)this.ds.get(var7)).ac((Club)var2.get(var18))) {
                        ((Club)var2.get(var18)).b((Competition)this.ds.get(var7), 0);
                        ((C0924)this.ds.get(var7)).yi().yK().remove(var2.get(var18));
                        this.dt.add((Club)var2.get(var18));
                        ((Club)var2.get(var18)).setDivisao(0);
                        this.dt.remove(var1.get(var18));
                        ((C0924)this.ds.get(var7)).yi().yK().add((Club)var1.get(var18));
                     }
                  }
               }
            }
         }

         ((C0924)this.ds.get(var7)).yi().yI();
      }

      if (this.pais == 29 && GamePersistence.SR.bk()) {
         ((C0924)this.ds.get(this.ds.size() - 1)).yi().yJ();
      }

      for (int var8 = 0; var8 < this.ds.size(); var8++) {
         ((C0924)this.ds.get(var8)).BJ();
      }
   }

   public Coach ji() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      int var7 = this.jc();

      for (int var8 = 0; var8 < GamePersistence.SR.L().size(); var8++) {
         if (!((Coach)GamePersistence.SR.L().get(var8)).jZ() && ((Coach)GamePersistence.SR.L().get(var8)).jo() == null) {
            if (((Coach)GamePersistence.SR.L().get(var8)).lE() == var7 && ((Coach)GamePersistence.SR.L().get(var8)).getReputacao() == 5) {
               var1.add((Coach)GamePersistence.SR.L().get(var8));
            }

            if (((Coach)GamePersistence.SR.L().get(var8)).lE() == var7 && ((Coach)GamePersistence.SR.L().get(var8)).getReputacao() == 4) {
               var2.add((Coach)GamePersistence.SR.L().get(var8));
            }

            if (((Coach)GamePersistence.SR.L().get(var8)).lE() == var7 && ((Coach)GamePersistence.SR.L().get(var8)).getReputacao() == 3) {
               var3.add((Coach)GamePersistence.SR.L().get(var8));
            }

            if (((Coach)GamePersistence.SR.L().get(var8)).getReputacao() == 5) {
               var4.add((Coach)GamePersistence.SR.L().get(var8));
            }

            if (((Coach)GamePersistence.SR.L().get(var8)).getReputacao() == 4) {
               var5.add((Coach)GamePersistence.SR.L().get(var8));
            }

            if (((Coach)GamePersistence.SR.L().get(var8)).getReputacao() == 3) {
               var6.add((Coach)GamePersistence.SR.L().get(var8));
            }
         }
      }

      if (var1.size() > 0) {
         return (Coach)var1.get(0);
      } else if (var2.size() > 0) {
         return (Coach)var2.get(0);
      } else if (var4.size() > 0) {
         return (Coach)var4.get(0);
      } else if (var5.size() > 0) {
         return (Coach)var5.get(0);
      } else if (var3.size() > 0) {
         return (Coach)var3.get(0);
      } else {
         return var6.size() > 0 ? (Coach)var6.get(0) : null;
      }
   }

   public void z(boolean bl) {
      this.jo().kc().clear();
      if ((bl || this.jo().ka() == null) && !this.jo().jZ()) {
         Coach var2 = this.ji();
         if (var2 != null) {
            this.g(var2);
         }
      }

      if (!this.hz && !this.jk()) {
         C0677.r(this.pais, this.hA);
      }

      int[] var10 = new int[]{3, 4, 4, 5, 4, 3};
      int[] var3 = new int[]{0, 2, 2, 2, 2, 2};
      int[] var4 = new int[]{0, 2, 2, 3, 2, 1};
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();

      for (int var7 = 0; var7 < GamePersistence.SR.O().size(); var7++) {
         if (((Player)GamePersistence.SR.O().get(var7)).getPais() == this.pais && ((Player)GamePersistence.SR.O().get(var7)).fg() != null) {
            var5.add((Player)GamePersistence.SR.O().get(var7));
         }
      }

      for (int var11 = 0; var11 < GamePersistence.SR.bN().size(); var11++) {
         if (((Player)GamePersistence.SR.bN().get(var11)).getPais() == this.pais) {
            var5.add((Player)GamePersistence.SR.bN().get(var11));
         }
      }

      Collections.sort(var5, hF);

      for (int var12 = 0; var12 < var5.size(); var12++) {
         if (((Player)var5.get(var12)).getPosicao() == 0) {
            if (var10[0] > 0) {
               var6.add((Player)var5.get(var12));
               var10[0]--;
            }
         } else if (((Player)var5.get(var12)).getPosicao() >= 3 || ((Player)var5.get(var12)).getLado() != 0) {
            if (((Player)var5.get(var12)).getPosicao() < 3 && ((Player)var5.get(var12)).getLado() == 1) {
               if (var4[((Player)var5.get(var12)).getPosicao()] > 0) {
                  var6.add((Player)var5.get(var12));
                  var4[((Player)var5.get(var12)).getPosicao()]--;
                  var10[((Player)var5.get(var12)).getPosicao()]--;
               }
            } else if (((Player)var5.get(var12)).getPosicao() == 3 && ((Player)var5.get(var12)).getLado() == 0 && ((Player)var5.get(var12)).fF() == 1) {
               if (var3[3] > 0) {
                  var6.add((Player)var5.get(var12));
                  var3[3]--;
                  var10[3]--;
               }
            } else if (((Player)var5.get(var12)).getPosicao() == 3 && ((Player)var5.get(var12)).getLado() == 1 && ((Player)var5.get(var12)).fF() == 1) {
               if (var4[3] > 0) {
                  var6.add((Player)var5.get(var12));
                  var4[3]--;
                  var10[3]--;
               }
            } else if (((Player)var5.get(var12)).getPosicao() != 3 || ((Player)var5.get(var12)).getLado() != 0 || ((Player)var5.get(var12)).fF() != 0) {
               if (((Player)var5.get(var12)).getPosicao() == 3 && ((Player)var5.get(var12)).getLado() == 1 && ((Player)var5.get(var12)).fF() == 0) {
                  if (var4[5] > 0) {
                     var6.add((Player)var5.get(var12));
                     var4[5]--;
                     var10[5]--;
                  }
               } else if (((Player)var5.get(var12)).getPosicao() != 4 || ((Player)var5.get(var12)).getLado() != 0) {
                  if (((Player)var5.get(var12)).getPosicao() == 4 && ((Player)var5.get(var12)).getLado() == 1 && var4[4] > 0) {
                     var6.add((Player)var5.get(var12));
                     var4[4]--;
                     var10[4]--;
                  }
               } else if (var3[4] > 0) {
                  var6.add((Player)var5.get(var12));
                  var3[4]--;
                  var10[4]--;
               }
            } else if (var3[5] > 0) {
               var6.add((Player)var5.get(var12));
               var3[5]--;
               var10[5]--;
            }
         } else if (var3[((Player)var5.get(var12)).getPosicao()] > 0) {
            var6.add((Player)var5.get(var12));
            var3[((Player)var5.get(var12)).getPosicao()]--;
            var10[((Player)var5.get(var12)).getPosicao()]--;
         }
      }

      if (var5.size() < 23) {
         for (int var13 = 0; var13 <= 5; var13++) {
            int var8 = 0;
            if (var13 < 5) {
               var8 = var13;
            } else {
               var8 = 3;
            }

            if (var10[var13] > 0) {
               for (int var9 = 0; var9 < var5.size(); var9++) {
                  if (((Player)var5.get(var9)).getPosicao() == var8 && !var6.contains(var5.get(var9))) {
                     var6.add((Player)var5.get(var9));
                  }
               }
            }
         }
      }

      if (var5.size() < 23) {
         for (int var14 = 0; var14 < var5.size(); var14++) {
            if (!var6.contains(var5.get(var14))) {
               var6.add((Player)var5.get(var14));
            }
         }
      }

      Collections.sort(var6, C1007.abe);
      this.hy.N(var6);
      this.hy.o(null);
      this.hy.n((Player)null);
      this.hy.kA();
      this.hy.kz();
   }

   public void jj() {
      int var1 = 0;
      int var2 = 0;
      int[] var3 = new int[5];

      for (int var4 = 0; var4 < GamePersistence.SR.O().size(); var4++) {
         if (((Player)GamePersistence.SR.O().get(var4)).getPais() == this.pais) {
            if (((Player)GamePersistence.SR.O().get(var4)).getPosicao() == 0) {
               var2++;
            } else {
               var1++;
            }

            var3[((Player)GamePersistence.SR.O().get(var4)).getPosicao()]++;
         }
      }

      if (var1 >= 15 && var2 >= 2) {
         this.hz = true;
      } else {
         this.hz = false;
      }
   }

   public boolean jk() {
      int var1 = 0;
      int var2 = 0;

      for (int var3 = 0; var3 < GamePersistence.SR.O().size(); var3++) {
         if (((Player)GamePersistence.SR.O().get(var3)).getPais() == this.pais) {
            if (((Player)GamePersistence.SR.O().get(var3)).getPosicao() == 0) {
               var2++;
            } else {
               var1++;
            }
         }
      }

      for (int var4 = 0; var4 < GamePersistence.SR.bN().size(); var4++) {
         if (((Player)GamePersistence.SR.bN().get(var4)).getPais() == this.pais) {
            if (((Player)GamePersistence.SR.bN().get(var4)).getPosicao() == 0) {
               var2++;
            } else {
               var1++;
            }
         }
      }

      return var1 >= 16 && var2 >= 2;
   }

   public boolean jl() {
      return this.hz;
   }

   public void A(boolean bl) {
      this.hz = bl;
   }

   public static void a(boolean bl, int i, int j, ArrayList arrayList, boolean bl2, CountryCompetitions c0692) {
      ArrayList var6 = new ArrayList();
      boolean var7 = false;
      if (var7) {
         for (int var8 = 0; var8 < GamePersistence.SR.aG().size(); var8++) {
            if (((CountryCompetitions)GamePersistence.SR.aG().get(var8)).gg() == i && ((CountryCompetitions)GamePersistence.SR.aG().get(var8)).hz) {
               var6.add((CountryCompetitions)GamePersistence.SR.aG().get(var8));
            }
         }
      } else {
         for (int var22 = 0; var22 < GamePersistence.SR.aG().size(); var22++) {
            if (((CountryCompetitions)GamePersistence.SR.aG().get(var22)).gg() == i) {
               var6.add((CountryCompetitions)GamePersistence.SR.aG().get(var22));
            }
         }
      }

      Collections.sort(var6, cN);
      int[] var23 = new int[]{95, 80, 70, 50, 30, 20, 10, 5};
      int[] var9 = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 50};
      int[] var10 = new int[]{100, 95, 30, 10, 5};
      int[] var11 = new int[]{80, 80, 70, 70, 70, 50};
      int[] var12 = new int[]{90, 50, 30, 10, 5};
      int[] var13 = new int[]{100, 90, 80, 60, 30};
      int[] var14 = new int[]{99, 95, 30, 10, 5};
      int[] var15 = new int[]{100, 95, 80, 50, 30, 20, 10, 5};
      if (!bl) {
         int[] var16 = new int[]{100, 100, 90, 70, 60, 20, 10, 5};
         int[] var17 = new int[]{100, 50, 30, 10, 5};
         int[] var18 = new int[]{100, 100, 100, 98, 60, 40};
         int[] var19 = new int[]{100, 100, 90, 65, 60};
         int[] var20 = new int[]{100, 100, 100, 100, 100, 95, 80};
         int[] var21 = new int[]{100, 90, 90, 10, 5};
         var23 = var16;
         var10 = var17;
         var11 = var18;
         var12 = var19;
         var13 = var20;
         var14 = var21;
      }

      if (i == 0) {
         var15 = var23;
      } else if (i == 1) {
         var15 = var10;
      } else if (i == 2) {
         var15 = var11;
      } else if (i == 3) {
         var15 = var12;
      } else if (i == 4) {
         var15 = var13;
      } else if (i == 5) {
         var15 = var14;
      }

      if (bl2) {
         if (i == 4) {
            int[] var24 = new int[]{100, 100, 100, 95, 75, 70, 70, 70, 70};
            var9 = var24;
         } else if (i == 3) {
            int[] var25 = new int[]{100, 100, 70, 70, 70, 70, 70, 70, 70};
            var9 = var25;
         }

         var15 = var9;
         var6.remove(GamePersistence.SR.aY().eY(1));
      }

      if (i == 3 && j == 1) {
      }

      int var26 = 0;
      int var27 = 0;
      int var29 = 0;
      int var30 = 0;
      boolean var31 = false;
      if (var31) {
         System.out.println("-----probs");
      }

      for (int var32 = 0; var32 < var6.size(); var32++) {
         if (j > 0) {
            var27 = new Random().nextInt(100) + 1;
            if (var32 > 0 && ((CountryCompetitions)var6.get(var32)).getNivel() < var29) {
               if (++var26 >= var15.length) {
                  var26 = var15.length - 1;
               }
            }

            if (var6.get(var32) != c0692 && var27 <= var15[var26] && !arrayList.contains(var6.get(var32))) {
               arrayList.add((CountryCompetitions)var6.get(var32));
               j--;
               var30++;
               if (var31) {
                  System.out
                     .println(
                        "-sim "
                           + var30
                           + " "
                           + ((CountryCompetitions)var6.get(var32)).jf()
                           + "(n:"
                           + ((CountryCompetitions)var6.get(var32)).hA
                           + ") "
                           + var26
                           + " rand="
                           + var27
                           + " prob"
                           + var15[var26]
                           + " "
                           + "randdopais:"
                           + ((CountryCompetitions)var6.get(var32)).hr
                     );
               }
            } else if (var31) {
               System.out
                  .println(
                     "-não "
                        + ((CountryCompetitions)var6.get(var32)).jf()
                        + "(n:"
                        + ((CountryCompetitions)var6.get(var32)).hA
                        + ") "
                        + var26
                        + " rand="
                        + var27
                        + " prob"
                        + var15[var26]
                        + " "
                        + "randdopais:"
                        + ((CountryCompetitions)var6.get(var32)).hr
                  );
            }

            var29 = ((CountryCompetitions)var6.get(var32)).hA;
         }
      }

      for (int var33 = 0; var33 < var6.size(); var33++) {
         if (j > 0 && var6.get(var33) != c0692 && !arrayList.contains(var6.get(var33))) {
            arrayList.add((CountryCompetitions)var6.get(var33));
            j--;
         }
      }

      if (var31) {
         System.out.println("nos grupos-----");

         for (int var34 = 0; var34 < arrayList.size(); var34++) {
            System.out.println(((CountryCompetitions)arrayList.get(var34)).jf() + " " + ((CountryCompetitions)arrayList.get(var34)).hA + " " + ((CountryCompetitions)arrayList.get(var34)).hr);
         }
      }
   }

   public int getNivel() {
      return this.hA;
   }

   public void jm() {
      this.hA = C0696.valueOf("P" + Integer.toString(this.pais)).getNivel();
   }

   public Club jn() {
      return this.hy;
   }

   public Club jo() {
      if (this.hy == null) {
         Club var1 = new Club(this.jf(), null, -1, this.jc(), -1, this.getNivel(), null, this.jt(), null, null, null, -1, null, true);
         this.hy = var1;
         var1.bX(GamePersistence.SR.bH());
         GamePersistence.SR.bI();
         int[] var2 = C0696.valueOf("P" + Integer.toString(this.jc())).jB();
         int[] var3 = C0696.valueOf("P" + Integer.toString(this.jc())).jC();
         this.hy.d(new Color(var2[0], var2[1], var2[2]));
         this.hy.c(new Color(var3[0], var3[1], var3[2]));
         this.hy.ln();
         this.hy.lo();
      }

      return this.hy;
   }

   public void z(Club club) {
      this.hy = club;
   }

   public void a(ArrayList arrayList, Coach coach, boolean bl, boolean bl2) {
      int[][] var5 = new int[][]{{0, 0, 1, 2, -1, -1}, {1, 1, 2, 3, -1, -1}, {2, 2, 3, -1, -1, -1}, {2, 3, 3, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
      int[][] var6 = new int[][]{{0, -1, -1, 2, -1, -1}, {1, -1, 2, -1, -1, -1}, {2, -1, -1, -1, -1, -1}, {2, 3, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
      int[][] var7 = new int[][]{{0, -1, -1, -1, -1, -1}, {1, -1, -1, -1, -1, -1}, {2, -1, -1, -1, -1, -1}, {2, 3, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
      int[][] var8 = new int[][]{{0, 1, -1, -1, -1, -1}, {1, 2, -1, -1, -1, -1}, {2, 8, -1, -1, -1, -1}, {3, 8, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
      int[][] var9 = new int[][]{{0, -1, -1, -1, -1, -1}, {1, -1, -1, -1, -1, -1}, {8, 8, -1, -1, -1, -1}, {8, 8, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
      int var10 = -1;
      if (coach.fg() == null) {
         var10 = coach.lG();
      } else {
         var10 = coach.fg().getDivisao() - 1;
      }

      if (var10 < 0) {
         var10 = this.ds.size() - 1;
      }

      if (var10 > this.ds.size() - 1) {
         var10 = this.ds.size() - 1;
      }

      if (var10 >= 0) {
         int[] var11 = var5[var10];
         int var12 = new Random().nextInt(1000);
         if (var12 > 700) {
            var11 = var6[var10];
         } else if (var12 > 500) {
            var11 = var7[var10];
         }

         if (!bl2) {
            var11 = var8[var10];
            if (var12 > 500) {
               var11 = var9[var10];
            }
         }

         for (int var13 = 0; var13 < var11.length; var13++) {
            if (var11[var13] == 8) {
               var11[var13] = this.ds.size() - 1;
            }

            if (var11[var13] >= 0 && var11[var13] < this.ds.size()) {
               if (((C0924)this.ds.get(var11[var13])).yi().yK().size() > 0) {
                  ((C0924)this.ds.get(var11[var13])).yi().b(arrayList, coach, bl);
               } else if (!coach.jZ()) {
                  this.a(arrayList, coach, bl);
               }
            }
         }
      }
   }

   public void a(ArrayList arrayList, Coach coach, boolean bl) {
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < this.ek().size(); var5++) {
         if (!((Club)this.ek().get(var5)).jZ() && this.ek().get(var5) != coach.lF()) {
            var4.add((Club)this.ek().get(var5));
         }
      }

      Collections.shuffle(var4);
      byte var6 = 0;
      if (var6 < var4.size() && !arrayList.contains(var4.get(var6))) {
         arrayList.add((Club)var4.get(var6));
      }
   }

   public void A(ArrayList arrayList) {
      for (int var2 = 0; var2 < this.ds.size(); var2++) {
         ((C0924)this.ds.get(var2)).yi().A(arrayList);
      }
   }

   public String jp() {
      return this.hB;
   }

   public ArrayList ek() {
      return this.dt;
   }

   public C0942 jq() {
      return this.hu;
   }

   public boolean jr() {
      return this.hC;
   }

   public void B(boolean bl) {
      this.hC = bl;
   }

   public int js() {
      return this.ds.size();
   }

   public int jt() {
      if (this.hA >= 20) {
         return 5;
      } else if (this.hA >= 19) {
         return 4;
      } else if (this.hA >= 17) {
         return 3;
      } else {
         return this.hA >= 15 ? 2 : 1;
      }
   }

   private void f(Coach coach) {
      int var2 = -1;
      var2 = coach.jo().getPais();
      CountryCompetitions var3 = GamePersistence.SR.s(var2);
      if (var3 != null) {
         Coach var4 = coach;
         Coach var5 = var3.ji();
         var4.z(null);
         var3.jo().h(null);
         var3.jo().k(false);
         if (var5 != null) {
            var3.g(var5);
         }

         var3.z(false);
      }
   }

   public void g(Coach coach) {
      if (this.jo().ka() != null) {
         this.jo().ka().z(null);
      }

      if (coach.jo() != null) {
         this.f(coach);
      }

      this.jo().h(coach);
      coach.z(this.jo());
      this.jo().k(coach.jZ());
   }

   public void a(C0942 c0942) {
      if (c0942 == null && this.hu == null) {
         this.hu = new C0942(this);
      }
   }

   public boolean ju() {
      for (int var1 = 0; var1 < GamePersistence.SR.S().size(); var1++) {
         if (((Match)GamePersistence.SR.S().get(var1)).hy() == this.hu && (((Match)GamePersistence.SR.S().get(var1)).hc().jZ() || ((Match)GamePersistence.SR.S().get(var1)).hd().jZ())) {
            return true;
         }
      }

      return false;
   }

   public boolean ei() {
      for (int var1 = 0; var1 < this.ds.size(); var1++) {
         for (int var2 = 0; var2 < ((C0924)this.ds.get(var1)).yi().yK().size(); var2++) {
            if (((Club)((C0924)this.ds.get(var1)).yi().yK().get(var2)).jZ()) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean jv() {
      for (int var1 = 0; var1 < GamePersistence.SR.S().size(); var1++) {
         if (((Match)GamePersistence.SR.S().get(var1)).hy() == this.hu) {
            return true;
         }
      }

      return false;
   }

   public boolean ej() {
      for (int var1 = 0; var1 < GamePersistence.SR.S().size(); var1++) {
         if (this.ds.contains(((Match)GamePersistence.SR.S().get(var1)).hy())) {
            return true;
         }
      }

      return false;
   }

   public void jx() {
      for (int var1 = 0; var1 < this.ds.size(); var1++) {
         ((C0924)this.ds.get(var1)).zJ();
         ((C0924)this.ds.get(var1)).zK();
      }
   }

   public void a(LeagueStage c0955) {
      for (int var2 = 0; var2 < this.ds.size(); var2++) {
         if (((C0924)this.ds.get(var2)).yi() == c0955) {
            ((C0924)this.ds.get(var2)).zH();
         }
      }
   }

   public void jy() {
      this.hD.clear();
   }

   public int K(int i) {
      int var2 = i - 2;
      return i > 1 && var2 < this.ds.size() ? ((C0924)this.ds.get(var2)).getnRebaixados() : 0;
   }

   public int fq(int i) {
      int var2 = i - 2;
      return i > 1 && var2 < this.ds.size() ? ((C0924)this.ds.get(var2)).BL() : 0;
   }

   public Stadium C(boolean bl) {
      int var2 = 6;
      if (this.hE == null && GamePersistence.SR.cc() != null) {
         this.hE = new ArrayList();

         for (int var3 = 0; var3 < GamePersistence.SR.cc().size(); var3++) {
            if (((Stadium)GamePersistence.SR.cc().get(var3)).getPais() == this.pais) {
               this.hE.add((Stadium)GamePersistence.SR.cc().get(var3));
               if (--var2 == 0) {
                  break;
               }
            }
         }
      }

      if (this.hE != null && this.hE.size() > 0) {
         if (!bl) {
            if (this.hE != null && this.hE.size() > 0) {
               return (Stadium)this.hE.get(new Random().nextInt(this.hE.size()));
            }
         } else {
            int var4 = new Random().nextInt(2);
            if (var4 < this.hE.size()) {
               return (Stadium)this.hE.get(var4);
            }

            this.hE.get(0);
         }
      }

      return null;
   }

   public C0792 As() {
      C0792 var1 = new C0792();
      int var2 = this.jc();
      if (this.gg() == 0) {
         GamePersistence.SR.aI().a(var2, var1);
         GamePersistence.SR.aK().a(var2, var1);
         GamePersistence.SR.mj().a(var2, var1);
      } else if (this.gg() == 1) {
         GamePersistence.SR.aF().a(var2, var1);
         GamePersistence.SR.aH().a(var2, var1);
      } else if (this.gg() == 2) {
         GamePersistence.SR.aO().a(var2, var1);
      } else if (this.gg() == 3) {
         GamePersistence.SR.aL().a(var2, var1);
      } else if (this.gg() == 4) {
         GamePersistence.SR.aP().a(var2, var1);
      } else if (this.gg() == 5) {
         GamePersistence.SR.aQ().a(var2, var1);
      }

      return var1;
   }
}
