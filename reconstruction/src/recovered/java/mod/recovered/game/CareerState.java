package mod.recovered.game;

import mod.recovered.stadium.StadiumExpansionProject;
import mod.recovered.competition.AfcChampionsLeague;
import mod.recovered.competition.AfricaCupOfNations;
import mod.recovered.competition.AfricaWorldCupQualifiers;
import mod.recovered.competition.AsiaWorldCupQualifiers;
import mod.recovered.competition.AsianCup;
import mod.recovered.competition.CafChampionsLeague;
import mod.recovered.competition.ClubWorldCup;
import mod.recovered.competition.ConcacafChampionsLeague;
import mod.recovered.competition.ConcacafGoldCup;
import mod.recovered.competition.ConcacafNationsLeague;
import mod.recovered.competition.ConcacafWorldCupQualifiers;
import mod.recovered.competition.CopaAmerica;
import mod.recovered.competition.CopaLibertadores;
import mod.recovered.competition.CopaSudamericana;
import mod.recovered.competition.EuropeWorldCupQualifiers;
import mod.recovered.competition.EuropeanChampionship;
import mod.recovered.competition.EuropeanSuperCup;
import mod.recovered.competition.Finalissima;
import mod.recovered.competition.FriendlyMatches;
import mod.recovered.competition.FriendlyTournament;
import mod.recovered.competition.NationalCup;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.NationalSuperCup;
import mod.recovered.competition.OceaniaWorldCupQualifiers;
import mod.recovered.competition.OfcChampionsLeague;
import mod.recovered.competition.OfcNationsCup;
import mod.recovered.competition.RegionalCup;
import mod.recovered.competition.SouthAmericaWorldCupQualifiers;
import mod.recovered.competition.SouthAmericanRecopa;
import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.UefaChampionsLeague;
import mod.recovered.competition.UefaConferenceLeague;
import mod.recovered.competition.UefaEuropaLeague;
import mod.recovered.competition.UefaNationsLeague;
import mod.recovered.competition.WorldCup;
import mod.recovered.transfer.AiSquadManager;
import mod.recovered.transfer.PlayerTransferRecord;
import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JOptionPane;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;
import mod.recovered.save.SavedGameInfo;

public class CareerState implements Serializable {
   private static final long serialVersionUID = 1L;
   private SavedGameInfo savedGameInfo = new SavedGameInfo();
   private int seasonNumber = 1;
   private int firstSeasonYear = 2022;
   private int currentScheduleIndex = 1;
   private ArrayList ag = new ArrayList();
   private ArrayList ah = new ArrayList();
   private ArrayList ai = new ArrayList();
   private ArrayList aj = new ArrayList();
   private ArrayList ak = new ArrayList();
   private ArrayList al = new ArrayList();
   private ArrayList am = new ArrayList();
   private ArrayList an = null;
   private ArrayList ao = new ArrayList();
   private ArrayList ap = new ArrayList();
   private ArrayList aq = new ArrayList();
   private ArrayList ar = new ArrayList();
   private ArrayList scheduleDays = new ArrayList();
   private ArrayList at = new ArrayList();
   private ArrayList au = new ArrayList();
   private ArrayList av = new ArrayList();
   private ArrayList stadiumExpansionProjects = new ArrayList();
   private ArrayList ax = new ArrayList();
   private ArrayList ay = new ArrayList();
   private ArrayList az = new ArrayList();
   private ClubWorldCup aA = null;
   private UefaChampionsLeague aB = null;
   private CopaLibertadores aC = null;
   private CafChampionsLeague aD = null;
   private AfcChampionsLeague aE = null;
   private ConcacafChampionsLeague aF = null;
   private OfcChampionsLeague aG = null;
   private FriendlyMatches aH = new FriendlyMatches();
   private FriendlyTournament Gy = new FriendlyTournament();
   private SouthAmericanRecopa aI = null;
   private EuropeanSuperCup aJ = null;
   private WorldCup aK = null;
   private UefaNationsLeague GC = null;
   private ConcacafNationsLeague GI = null;
   private Finalissima IX = null;
   private SouthAmericaWorldCupQualifiers aL = null;
   private EuropeWorldCupQualifiers aM = null;
   private AfricaWorldCupQualifiers aN = null;
   private AsiaWorldCupQualifiers aO = null;
   private OceaniaWorldCupQualifiers aP = null;
   private ConcacafWorldCupQualifiers aQ = null;
   private CopaAmerica aR = null;
   private EuropeanChampionship aS = null;
   private AfricaCupOfNations aT = null;
   private AsianCup aU = null;
   private ConcacafGoldCup aV = null;
   private OfcNationsCup aW = null;
   private UefaEuropaLeague aX = null;
   private UefaConferenceLeague IY = null;
   private CopaSudamericana aY = null;
   private RegionalCup[] aZ = new RegionalCup[4];
   private boolean[] jogaRegionaisTodos = new boolean[]{false, false, true, false};
   private boolean jogaRegionais = true;
   private boolean jogaEstadual = true;
   private boolean usaGrupoPadraoEstadual = true;
   private boolean jogaIntClubes = true;
   private boolean ba = false;
   private boolean bb = false;
   private boolean salarioMensal = true;
   private boolean habilidadeIndividual = true;
   private boolean jogaIntano1 = true;
   private boolean gruposIntPadrao = true;
   private boolean jogaSelecoesAll = true;
   private boolean[] verJint = new boolean[]{
      true, true, false, false, false, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true
   };
   private boolean bc = false;
   private boolean bd = true;
   private int be = -1;
   private int bf = -1;
   private int bg = -1;
   private int bh = 0;
   private int autoSalvar = 0;
   private int velocidade = 3;
   private int velocidadeNH = 4;
   private int verDecisaoPenNaoHumano = 0;
   private int verMudancaTecnicos = 1;
   private int verJanelaSubs = 1;
   private int avisoTerminoContrato = 0;
   private boolean ignoraEstadual = true;
   private boolean autoRenovaContrato = true;
   private boolean usaCorPlacar = true;
   private int corPlacar = 0;
   private boolean usaSons = true;
   private boolean negritoCasa = true;
   private boolean usaCoresLista = true;
   private transient Color[] coresLista = null;
   private boolean verEstaduaisAgrupados = false;
   private boolean ignoraLigas = true;
   private boolean bi = false;
   private boolean verLeiloes = false;
   private String saveName = null;
   public boolean bk = false;
   private int bl = 1;
   private int bm = 3;
   private int bn = 3;
   private int IZ = 4;
   private int bo = 2;
   private int bp = 2;
   private int bq = 4;
   private int br = 2;
   private int Ja = 2;
   private int Jb = 1;
   public boolean bs = true;
   private int bt = -1;
   private ArrayList bu = new ArrayList();
   private static transient Club X = null;
   private static transient Match bv = null;
   private transient ArrayList bw = new ArrayList();
   public transient ArrayList bx = null;
   public transient ArrayList by = null;
   public transient ArrayList bz = null;
   public transient ArrayList bA = null;
   public transient ArrayList bB = null;
   public transient ArrayList bC;
   public transient int[] bD;
   public transient int[] bE;
   public transient ArrayList bF;
   public transient ArrayList bG;
   public transient boolean bH = false;
   public transient boolean bI = false;
   public transient int bJ = 0;
   public transient boolean bK = false;
   public transient boolean bL = false;
   public transient boolean bM = false;
   public transient boolean bN = false;
   public transient boolean Jc = false;
   public static Comparator bO = new CoachPerformanceComparator();
   private String[] bP = new String[]{"#949449", "#B3B364", "#C0C081", "#D1D1A3", "#DEDE9E"};

   public CareerState() {
      if (GamePersistence.getOptions() != null) {
         this.setVerJint(GamePersistence.getOptions().getVerJint());
         this.setJogaIntano1(GamePersistence.getOptions().isJogaIntano1());
         this.setGruposIntPadrao(GamePersistence.getOptions().isGruposIntPadrao());
         this.setJogaIntClubes(GamePersistence.getOptions().isJogaIntClubes());
         this.setJogaSelecoesAll(GamePersistence.getOptions().isJogaSelecoesAll());
         this.setJogaEstadual(GamePersistence.getOptions().isJogaEstadual());
         this.setJogaRegionais(GamePersistence.getOptions().isJogaRegionais());
         this.setSalarioMensal(GamePersistence.getOptions().isSalarioMensal());
         this.setHabilidadeIndividual(GamePersistence.getOptions().isHabilidadeIndividual());
         this.setIgnoraEstadual(GamePersistence.getOptions().isIgnoraEstadual());
         this.setUsaGrupoPadraoEstadual(GamePersistence.getOptions().isUsaGrupoPadraoEstadual());
         this.setAutoSalvar(GamePersistence.getOptions().getAutoSalvar());
         this.setVelocidade(GamePersistence.getOptions().getVelocidade());
         this.setVelocidadeNH(GamePersistence.getOptions().getVelocidadeNH());
         this.setVerDecisaoPenNaoHumano(GamePersistence.getOptions().getVerDecisaoPenNaoHumano());
         this.setVerMudancaTecnicos(GamePersistence.getOptions().getVerMudancaTecnicos());
         this.setVerJanelaSubs(GamePersistence.getOptions().getVerJanelaSubs());
         this.setAvisoTerminoContrato(GamePersistence.getOptions().getAvisoTerminoContrato());
         this.setIgnoraLigas(GamePersistence.getOptions().isIgnoraLigas());
         this.setAutoRenovaContrato(GamePersistence.getOptions().isAutoRenovaContrato());
         this.setUsaCorPlacar(GamePersistence.getOptions().isUsaCorPlacar());
         this.setCorPlacar(GamePersistence.getOptions().getCorPlacar());
         this.setUsaSons(GamePersistence.getOptions().isUsaSons());
         this.setUsaCoresLista(GamePersistence.getOptions().isUsaCoresLista());
         this.setCoresLista(GamePersistence.getOptions().getCoresLista());
         this.setNegritoCasa(GamePersistence.getOptions().isNegritoCasa());
         this.setVerEstaduaisAgrupados(GamePersistence.getOptions().isVerEstaduaisAgrupados());
         this.setUsarGruposReaisCopa(GamePersistence.getOptions().isUsarGruposReaisCopa());
         this.setJogaRegionaisTodos(GamePersistence.getOptions().getJogaRegionaisTodos());
         this.setVerLeiloes(GamePersistence.getOptions().isVerLeiloes());
      }

      this.G();
   }

   public void G() {
      this.bx = new ArrayList();
      this.by = new ArrayList();
      this.bz = new ArrayList();
      this.bA = new ArrayList();
      this.bB = new ArrayList();
   }

   public int getSeasonNumber() {
      return this.seasonNumber;
   }

   public void setSeasonNumber(int i) {
      this.seasonNumber = i;
   }

   public void advanceSeason() {
      this.seasonNumber++;
   }

   public int getCurrentScheduleIndex() {
      return this.currentScheduleIndex;
   }

   public void setCurrentScheduleIndex(int i) {
      this.currentScheduleIndex = i;
   }

   public ArrayList L() {
      return this.al;
   }

   public void a(ArrayList arrayList) {
      this.al = arrayList;
   }

   public ArrayList M() {
      return this.am;
   }

   public void b(ArrayList arrayList) {
      this.am = arrayList;
   }

   public ArrayList N() {
      return this.ao;
   }

   public void a(CountryCompetitions c0692) {
      this.ao.add(c0692);
   }

   public ArrayList O() {
      return this.ag;
   }

   public void c(ArrayList arrayList) {
      this.ag = arrayList;
   }

   public ArrayList P() {
      return this.aj;
   }

   public void d(ArrayList arrayList) {
      this.aj = arrayList;
   }

   public void c(Club club) {
      this.aj.add(club);
   }

   public void b(Player player) {
      this.ag.add(player);
   }

   public void c(Player player) {
      this.ah.add(player);
   }

   public void a(ScheduleDay c0693) {
      this.scheduleDays.add(c0693);
   }

   public ArrayList Q() {
      return this.ah;
   }

   public void e(ArrayList arrayList) {
      this.ah = arrayList;
   }

   public void a(Coach coach) {
      this.al.add(coach);
   }

   public void b(Coach coach) {
      this.am.add(coach);
   }

   public ArrayList getScheduleDays() {
      return this.scheduleDays;
   }

   public ArrayList getCurrentMatches() {
      return ((ScheduleDay)this.scheduleDays.get(this.currentScheduleIndex)).h();
   }

   public ArrayList getMatchesAtScheduleIndex(int i) {
      return i < this.scheduleDays.size() ? ((ScheduleDay)this.scheduleDays.get(i)).h() : null;
   }

   public String getCurrentDateText() {
      return ((ScheduleDay)this.scheduleDays.get(this.currentScheduleIndex)).f();
   }

   private static boolean U() {
      return true;
   }

   public void V() {
      if (!this.bk) {
         this.ap();
      } else {
         this.aa();
      }
   }

   public int getSeasonYearOffset() {
      return GamePersistence.careerState.getFirstSeasonYear() - 1;
   }

   private void W() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < GamePersistence.careerState.bo().size(); var2++) {
         if (((PlayerTransferRecord)GamePersistence.careerState.bo().get(var2)).getY() + 10 < this.getSeasonYearOffset()) {
            var1.add((PlayerTransferRecord)GamePersistence.careerState.bo().get(var2));
         }
      }

      for (int var3 = 0; var3 < var1.size(); var3++) {
         GamePersistence.careerState.bo().remove(var1.get(var3));
      }
   }

   public boolean X() {
      return GamePersistence.careerState.isJogaRegionais();
   }

   private void Y() {
      CountryCompetitions var1 = null;

      for (int var2 = 0; var2 < GamePersistence.careerState.N().size(); var2++) {
         if (((CountryCompetitions)GamePersistence.careerState.N().get(var2)).jc() == 29) {
            var1 = (CountryCompetitions)GamePersistence.careerState.N().get(var2);
         }
      }

      if (var1 != null) {
         var1.y(true);
      }
   }

   private void Z() {
      if (this.ar != null && this.ar.size() != 0) {
         for (int var6 = 0; var6 < GamePersistence.careerState.bW().size(); var6++) {
            ((NationalSuperCup)GamePersistence.careerState.bW().get(var6)).Ab();
            ((NationalSuperCup)GamePersistence.careerState.bW().get(var6)).mw();
         }
      } else {
         for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
            Object var2 = null;
            Object var3 = null;
            var2 = ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).jq().cv(GamePersistence.careerState.getSeasonNumber() - 1);
            Club[] var4 = ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).bk(GamePersistence.careerState.getSeasonNumber() - 1);
            if (var4 != null) {
               if (var2 != var4[0]) {
                  var3 = var4[0];
               } else {
                  var3 = var4[1];
               }
            }

            NationalSuperCup var5 = new NationalSuperCup(((CountryCompetitions)GamePersistence.careerState.N().get(var1)).jc());
            GamePersistence.careerState.ar.add(var5);
            var5.Ab();
         }
      }
   }

   private void aa() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aN().size(); var1++) {
         ((Club)GamePersistence.careerState.aN().get(var1)).kI();
      }

      if (this.jogaIntClubes) {
         this.ai();
      }

      if (this.jogaSelecoesAll) {
         this.jw();
      }

      this.ah();
      this.ag();
      this.iZ();
      if (this.jogaIntClubes) {
         this.ae();
      }

      this.Y();
      this.Z();
      this.am();
      this.ak();
      if (GamePersistence.careerState.jogaRegionais) {
         this.aj();
      }

      if (GamePersistence.careerState.bk() || GamePersistence.careerState.X()) {
         int var3 = ScheduleDay.e(1);
         if (var3 > 0) {
            ScheduleDay.b(var3, 4, 1);
         }
      }

      ScheduleDay.q();
      this.af();
      if (GamePersistence.careerState.getSeasonNumber() >= 5) {
         this.W();
      }

      GamePersistence.coachJobMarket.zi();
      GamePersistence.coachJobMarket.zj();
      AiSquadManager.jO();
      AiSquadManager.jQ();
      if (GamePersistence.careerState.isJogaSelecoesAll()) {
         this.ac();
      }

      GamePersistence.careerState.yn().xZ();
      this.yn().clear();
      boolean var4 = false;
      if (this.bs && !GamePersistence.careerState.bD()) {
         for (int var2 = 0; var2 < GamePersistence.careerState.M().size(); var2++) {
            if (((Coach)GamePersistence.careerState.M().get(var2)).getClub() != null) {
               var4 = true;
               break;
            }
         }

         if (var4) {
            C0151.pl();
         }
      }

      if (GamePersistence.careerState.yL()) {
         this.iY();
      }

      this.bk = false;
      if (var4) {
         C0151.AC();
      } else {
         GamePersistence.careerState.az();
         this.V();
      }
   }

   public void iX() {
      int var1 = -1;
      var1 = JOptionPane.showConfirmDialog(null, "Deseja criar um torneio Amistoso de início de temporada? ", "Torneio Amistoso", 0);
      if (var1 == 0) {
         MainWindow.aY(10);
      } else {
         this.bk = false;
         this.V();
      }
   }

   private void iY() {
      String var1 = "Torneio Amistoso";
      String var2 = "Juazeiro";
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 <= 7; var4++) {
         var3.add((Club)GamePersistence.careerState.P().get(var4));
      }

      if (GamePersistence.careerState.yn() != null) {
         GamePersistence.careerState.yn().a(var3, 0, var1, var2, false);
      }
   }

   public void a(String string) {
      Club var2 = null;
      Object var3 = null;
      int var4 = 0;

      for (int var5 = 0; var5 < GamePersistence.careerState.O().size(); var5++) {
         var4 = 0;
         var3 = (Player)GamePersistence.careerState.O().get(var5);

         for (int var6 = 0; var6 < GamePersistence.careerState.P().size(); var6++) {
            var2 = (Club)GamePersistence.careerState.P().get(var6);

            for (int var7 = 0; var7 < var2.getSeniorPlayers().size(); var7++) {
               if (((Player)var2.getSeniorPlayers().get(var7)).equals(var3)) {
                  var4++;
               }
            }
         }
      }
   }

   public void b(String string) {
      Object var2 = null;
      Object var3 = null;
      boolean var4 = false;

      for (int var5 = 0; var5 < GamePersistence.careerState.O().size(); var5++) {
         var4 = false;
         var3 = (Player)GamePersistence.careerState.O().get(var5);

         for (int var6 = 0; var6 < GamePersistence.careerState.P().size(); var6++) {
            Collections.frequency(((Club)GamePersistence.careerState.P().get(var6)).getSeniorPlayers(), var3);
         }
      }
   }

   public void ab() {
      SouthAmericaWorldCupQualifiers var1 = new SouthAmericaWorldCupQualifiers();
      this.a(var1);
      EuropeWorldCupQualifiers var2 = new EuropeWorldCupQualifiers();
      this.a(var2);
      AfricaWorldCupQualifiers var3 = new AfricaWorldCupQualifiers();
      this.a(var3);
      ConcacafWorldCupQualifiers var4 = new ConcacafWorldCupQualifiers();
      this.a(var4);
      AsiaWorldCupQualifiers var5 = new AsiaWorldCupQualifiers();
      this.a(var5);
      OceaniaWorldCupQualifiers var6 = new OceaniaWorldCupQualifiers();
      this.a(var6);
      OfcNationsCup var7 = new OfcNationsCup();
      this.a(var7);
      ConcacafGoldCup var8 = new ConcacafGoldCup();
      this.a(var8);
      AsianCup var9 = new AsianCup();
      this.a(var9);
      AfricaCupOfNations var10 = new AfricaCupOfNations();
      this.a(var10);
      CopaAmerica var11 = new CopaAmerica();
      this.a(var11);
      EuropeanChampionship var12 = new EuropeanChampionship();
      this.a(var12);
      WorldCup var13 = new WorldCup();
      this.a(var13);
      Finalissima var14 = new Finalissima();
      this.a(var14);
      UefaNationsLeague var15 = new UefaNationsLeague();
      this.a(var15);
      ConcacafNationsLeague var16 = new ConcacafNationsLeague();
      this.a(var16);
      var1.setNome(C0679.getString("eliAS"));
      var2.setNome(C0679.getString("eliEU"));
      var3.setNome(C0679.getString("eliAfr"));
      var5.setNome(C0679.getString("eliAsia"));
      var4.setNome(C0679.getString("eliConcacaf"));
      var6.setNome(C0679.getString("eliOce"));
      var12.setNome(C0679.getString("cro"));
      var11.setNome(C0679.getString("cam"));
      var13.setNome(C0679.getString("ncm"));
      var10.setNome(C0679.getString("nCAfr"));
      var9.setNome(C0679.getString("nCAsi"));
      var8.setNome(C0679.getString("nCOuro"));
      var7.setNome(C0679.getString("nCopaOFC"));
      var14.setNome("Finalíssima");
      var15.setNome("Liga Nações Europa");
      var16.setNome("Liga Nações Concacaf");
   }

   public void ac() {
      GamePersistence.careerState.ad();
      if (this.aK != null) {
         this.aK.xZ();
         this.aK.mw();
      }

      if (this.aS != null) {
         this.aS.xZ();
         this.aS.mw();
      }

      if (this.aR != null) {
         this.aR.xZ();
         this.aR.mw();
      }

      if (this.aT != null) {
         this.aT.xZ();
         this.aT.mw();
      }

      if (this.aU != null) {
         this.aU.xZ();
         this.aU.mw();
      }

      if (this.aV != null) {
         this.aV.xZ();
         this.aV.mw();
      }

      if (this.aW != null) {
         this.aW.xZ();
         this.aW.mw();
      }

      if (this.IX != null) {
         this.IX.mw();
      }

      if (this.GC != null) {
         this.GC.mw();
         this.GC.xZ();
      }

      if (this.GI != null) {
         this.GI.mw();
         this.GI.xZ();
      }

      if (this.aL != null) {
         this.aL.xZ();
      }

      if (this.aM != null) {
         this.aM.xZ();
      }

      if (this.aN != null) {
         this.aN.xZ();
      }

      if (this.aQ != null) {
         this.aQ.xZ();
      }

      if (this.aO != null) {
         this.aO.xZ();
      }

      if (this.aP != null) {
         this.aP.xZ();
      }

      if (this.aL != null) {
         this.aL.mw();
      }

      if (this.aM != null) {
         this.aM.mw();
      }

      if (this.aN != null) {
         this.aN.mw();
      }

      if (this.aQ != null) {
         this.aQ.mw();
      }

      if (this.aO != null) {
         this.aO.mw();
      }

      if (this.aP != null) {
         this.aP.mw();
      }

      if (this.bl == this.seasonNumber) {
         if (this.aK != null) {
            this.aK.ya();
         } else {
            WorldCup var1 = new WorldCup();
            this.a(var1);
            this.aK.ya();
         }

         this.bl += 4;
      }

      if (this.bm - 1 == this.seasonNumber) {
         if (this.aM != null) {
            this.aM.fF(0);
         } else {
            EuropeWorldCupQualifiers var2 = new EuropeWorldCupQualifiers();
            this.a(var2);
            var2.setNome(C0679.getString("eliEU"));
            this.aM.fF(0);
         }
      }

      if (this.bl - 1 == this.seasonNumber) {
         if (this.aL != null) {
            this.aL.ya();
         } else {
            SouthAmericaWorldCupQualifiers var3 = new SouthAmericaWorldCupQualifiers();
            this.a(var3);
            var3.setNome(C0679.getString("eliAS"));
            this.aL.ya();
         }

         if (this.aM != null) {
            this.aM.fF(7);
         } else {
            EuropeWorldCupQualifiers var4 = new EuropeWorldCupQualifiers();
            this.a(var4);
            var4.setNome(C0679.getString("eliEU"));
            this.aM.fF(7);
         }

         if (this.aN != null) {
            this.aN.Bj();
         } else {
            AfricaWorldCupQualifiers var5 = new AfricaWorldCupQualifiers();
            this.a(var5);
            var5.setNome(C0679.getString("eliAfr"));
            this.aN.Bj();
         }

         if (this.aQ != null) {
            this.aQ.Bj();
         } else {
            ConcacafWorldCupQualifiers var6 = new ConcacafWorldCupQualifiers();
            this.a(var6);
            var6.setNome(C0679.getString("eliConcacaf"));
            this.aQ.Bj();
         }

         if (this.aO != null) {
            this.aO.Bj();
         } else {
            AsiaWorldCupQualifiers var7 = new AsiaWorldCupQualifiers();
            this.a(var7);
            var7.setNome(C0679.getString("eliAsia"));
            this.aO.Bj();
         }

         if (this.aP != null) {
            this.aP.Bj();
         } else {
            OceaniaWorldCupQualifiers var8 = new OceaniaWorldCupQualifiers();
            this.a(var8);
            var8.setNome(C0679.getString("eliOce"));
            this.aP.Bj();
         }
      }

      if (this.bm == this.seasonNumber) {
         if (this.aS != null) {
            this.aS.ya();
         } else {
            EuropeanChampionship var9 = new EuropeanChampionship();
            this.a(var9);
            var9.setNome(C0679.getString("cro"));
            this.aS.ya();
         }

         this.bm += 4;
      } else if (this.aS != null) {
         this.aS.p((LeagueStage)null);
      }

      if (this.bn == this.seasonNumber) {
         if (this.aR != null) {
            this.aR.ya();
         } else {
            CopaAmerica var10 = new CopaAmerica();
            this.a(var10);
            var10.setNome(C0679.getString("cam"));
            this.aR.ya();
         }

         if (this.seasonNumber == 1) {
            this.bn += 4;
         } else {
            this.bn += 4;
         }
      } else if (this.aR != null) {
         this.aR.p((LeagueStage)null);
      }

      if (this.bo == this.seasonNumber) {
         if (this.aT != null) {
            this.aT.ya();
         } else {
            this.a(new AfricaCupOfNations());
            this.aT.ya();
         }

         this.bo += 4;
      } else if (this.aT != null) {
         this.aT.p((LeagueStage)null);
      }

      if (this.bp == this.seasonNumber) {
         if (this.aU != null) {
            this.aU.ya();
         } else {
            this.a(new AsianCup());
            this.aU.ya();
         }

         this.bp += 4;
      } else if (this.aU != null) {
         this.aU.p((LeagueStage)null);
      }

      if (this.br == this.seasonNumber) {
         if (this.aV != null) {
            this.aV.ya();
         } else {
            this.a(new ConcacafGoldCup());
            this.aV.ya();
         }

         this.br += 2;
      } else if (this.aV != null) {
         this.aV.p((LeagueStage)null);
      }

      if (this.bq == this.seasonNumber) {
         if (this.aW != null) {
            this.aW.ya();
         } else {
            this.a(new OfcNationsCup());
            this.aW.ya();
         }

         this.bq += 4;
      } else if (this.aW != null) {
         this.aW.p((LeagueStage)null);
      }

      if (this.IZ == this.seasonNumber) {
         if (this.IX != null) {
            this.IX.Bs();
         }

         this.IZ += 4;
      }

      if (this.Ja == this.seasonNumber) {
         if (this.GC != null) {
            this.GC.Ar();
         }

         this.Ja += 2;
      }

      if (this.Jb == this.seasonNumber) {
         if (this.GI != null) {
            this.GI.Ar();
         }

         this.Jb += 2;
      }
   }

   public void ad() {
      for (int var1 = 0; var1 < this.ap.size(); var1++) {
         ((CountryCompetitions)this.ap.get(var1)).jm();
         ((CountryCompetitions)this.ap.get(var1)).jj();
      }
   }

   public void ae() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aG().size(); var1++) {
         ((CountryCompetitions)GamePersistence.careerState.aG().get(var1)).jy();
      }

      this.aP().yq();
      this.aF().yq();
      this.aI().yq();
      this.aO().yq();
      this.aL().yq();
      this.aQ().yq();
      this.aH().yq();
      this.aK().yq();
      this.mj().yq();
      this.aH().mw();
      this.aF().mw();
      this.aI().mw();
      this.aO().mw();
      this.aL().mw();
      this.aQ().mw();
      this.aP().mw();
      this.aH().mw();
      this.aK().mw();
      this.mj().mw();
      this.aR().mw();
      if (GamePersistence.careerState.aW() != null) {
         this.aW().mw();
      }

      if (GamePersistence.careerState.aV() != null) {
         this.aV().mw();
      }

      if (this.aY() != null) {
         this.aY().mw();
      }

      if (this.ba() != null) {
         this.ba().mw();
      }

      if (this.aZ() != null) {
         this.aZ().mw();
      }

      if (this.aT != null) {
         this.aT.xZ();
         this.aT.mw();
      }

      if (this.aU != null) {
         this.aU.xZ();
         this.aU.mw();
      }

      if (this.aV != null) {
         this.aV.xZ();
         this.aV.mw();
      }

      if (this.aW != null) {
         this.aW.xZ();
         this.aW.mw();
      }

      int var3 = ScheduleDay.d(4);
      if (var3 > 0) {
         ScheduleDay.b(var3, 1, 0);
      }

      if (GamePersistence.careerState.aV() != null) {
         GamePersistence.careerState.aV().zR();
      } else {
         SouthAmericanRecopa var2 = new SouthAmericanRecopa();
         GamePersistence.careerState.a(var2);
         var2.zR();
      }

      if (GamePersistence.careerState.aW() != null) {
         GamePersistence.careerState.aW().zR();
      } else {
         EuropeanSuperCup var4 = new EuropeanSuperCup();
         GamePersistence.careerState.a(var4);
         var4.zR();
      }

      if (GamePersistence.careerState.aV() != null) {
         GamePersistence.careerState.aV().mw();
      }

      if (GamePersistence.careerState.aW() != null) {
         GamePersistence.careerState.aW().mw();
      }
   }

   public void c(String string) {
      Object var2 = null;
      Object var3 = null;
      boolean var4 = false;

      for (int var5 = 0; var5 < GamePersistence.careerState.Q().size(); var5++) {
         var4 = false;
         var3 = (Player)GamePersistence.careerState.Q().get(var5);

         for (int var6 = 0; var6 < GamePersistence.careerState.P().size(); var6++) {
            Collections.frequency(((Club)GamePersistence.careerState.P().get(var6)).getYouthPlayers(), var3);
         }
      }
   }

   private void af() {
      this.by.clear();
      this.bz.clear();
      this.bA.clear();
      this.bB.clear();

      for (int var1 = 0; var1 < this.ai.size(); var1++) {
         ((Player)this.ai.get(var1)).gc();
      }

      for (int var2 = 0; var2 < this.ag.size(); var2++) {
         ((Player)this.O().get(var2)).gd();
      }

      for (int var3 = 0; var3 < this.bz.size(); var3++) {
         this.ag.remove(this.bz.get(var3));
      }

      for (int var4 = 0; var4 < this.by.size(); var4++) {
         this.ag.add((Player)this.by.get(var4));
      }

      this.by.clear();
      this.bz.clear();

      for (int var5 = 0; var5 < this.ah.size(); var5++) {
         ((Player)this.Q().get(var5)).gf();
      }

      this.c(true);

      for (int var6 = 0; var6 < this.bB.size(); var6++) {
         this.ah.remove(this.bB.get(var6));
      }

      for (int var7 = 0; var7 < this.bA.size(); var7++) {
         if (!this.ah.contains(this.bA.get(var7))) {
            this.ah.add((Player)this.bA.get(var7));
         }
      }

      this.bA.clear();
      this.bB.clear();

      for (int var8 = 0; var8 < GamePersistence.careerState.O().size(); var8++) {
         ((Player)GamePersistence.careerState.O().get(var8)).fK();
         ((Player)GamePersistence.careerState.O().get(var8)).fJ();
      }
   }

   public void c(boolean bl) {
      int var2 = 0;
      if (!bl) {
         int[] var3 = new int[]{0, 1, 2, 3, 3, 4};
         int[] var4 = new int[]{0, 1, 2, 3, 4};

         for (int var5 = 0; var5 < this.aj.size(); var5++) {
            if (((Club)this.aj.get(var5)).kn() && ((Club)this.aj.get(var5)).getReputacao() >= 3) {
               if (((Club)this.aj.get(var5)).kx() < 12) {
                  for (int var10 = 0; var10 < var3.length; var10++) {
                     Player.a((Club)this.aj.get(var5), var3[var10], null, 0, null, bl);
                  }
               }
            } else if (((Club)this.aj.get(var5)).kx() < 5) {
               for (int var6 = 0; var6 < var4.length; var6++) {
                  Player.a((Club)this.aj.get(var5), var4[var6], null, 0, null, bl);
               }
            }
         }
      } else {
         for (int var8 = 0; var8 < this.aj.size(); var8++) {
            if (((Club)this.aj.get(var8)).kx() < 15) {
               if (((Club)this.aj.get(var8)).kn()) {
                  var2 = 2 + new Random().nextInt(3);
               } else {
                  var2 = new Random().nextInt(3);
                  if (((Club)this.aj.get(var8)).getNivel() >= 20) {
                     var2++;
                  }
               }

               if (var2 + ((Club)this.aj.get(var8)).kx() >= 20) {
                  var2 = 20 - ((Club)this.aj.get(var8)).kx() - 2;
               }

               if (var2 > 0) {
                  for (int var9 = 0; var9 <= var2; var9++) {
                     Player.a((Club)this.aj.get(var8), -1, null, 0, null, bl);
                  }
               }
            }
         }
      }
   }

   private void iZ() {
      for (int var1 = 0; var1 < this.al.size(); var1++) {
         ((Coach)this.al.get(var1)).kk();
      }
   }

   private void ag() {
      for (int var1 = 0; var1 < this.aj.size(); var1++) {
         ((Club)this.aj.get(var1)).km().clear();
         ((Club)this.aj.get(var1)).kk();
         if (!((Club)this.aj.get(var1)).isUserControlled()) {
            ((Club)this.aj.get(var1)).kp();
            ((Club)this.aj.get(var1)).kA();
            ((Club)this.aj.get(var1)).kz();
         }

         if (((Club)this.aj.get(var1)).getCoach() != null) {
            ((Club)this.aj.get(var1)).getCoach().cj(50);
            ((Club)this.aj.get(var1)).getCoach().ck(50);
         }
      }

      for (int var2 = 0; var2 < GamePersistence.careerState.aN().size(); var2++) {
         ((Club)GamePersistence.careerState.aN().get(var2)).kG();
      }
   }

   private void ah() {
      this.advanceSeason();

      for (int var1 = 0; var1 < this.scheduleDays.size(); var1++) {
         ((ScheduleDay)this.scheduleDays.get(var1)).clear();
      }

      this.scheduleDays.clear();
      this.r(GamePersistence.careerState.getFirstSeasonYear() + (this.seasonNumber - 1));
      ScheduleDay.g();
   }

   private void ai() {
      if (GamePersistence.careerState.aK() != null && GamePersistence.careerState.aI() != null) {
         Club var1 = GamePersistence.careerState.aK().cS();
         GamePersistence.careerState.aI().T(var1);
         GamePersistence.careerState.aK().N(var1);
      }

      if (GamePersistence.careerState.aF() != null && GamePersistence.careerState.aH() != null) {
         Club var2 = GamePersistence.careerState.aH().cS();
         GamePersistence.careerState.aF().O(var2);
         GamePersistence.careerState.aH().N(var2);
      }

      if (GamePersistence.careerState.aK() != null && GamePersistence.careerState.mj() != null) {
         Club var3 = GamePersistence.careerState.mj().cS();
         GamePersistence.careerState.aK().ab(var3);
      }
   }

   private void jw() {
      if (this.IX != null && this.aS != null) {
         Club var1 = this.aS.cS();
         if (var1 != null) {
            this.IX.Z(var1);
         }
      }

      if (this.IX != null && this.aR != null) {
         Club var2 = this.aR.cS();
         if (var2 != null) {
            this.IX.aa(var2);
         }
      }
   }

   private void aj() {
      new ArrayList();
      ArrayList var1 = C0734.di();

      for (int var2 = 0; var2 < this.aZ.length; var2++) {
         if (this.aZ[var2] != null) {
            this.aZ[var2].am(var1);
         }
      }
   }

   private void ak() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aE().size(); var1++) {
         ((C0741)GamePersistence.careerState.aE().get(var1)).ee();
      }

      for (int var3 = 0; var3 < GamePersistence.careerState.aE().size(); var3++) {
         for (int var2 = 0; var2 < ((C0741)GamePersistence.careerState.aE().get(var3)).eb().size(); var2++) {
            ((StateChampionship)((C0741)GamePersistence.careerState.aE().get(var3)).eb().get(var2)).yi().aN(false);
         }
      }
   }

   public void al() {
      for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
         for (int var2 = 0; var2 < ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).eb().size(); var2++) {
            ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var1)).eb().get(var2)).fi(var2);
         }
      }

      for (int var3 = 0; var3 < GamePersistence.careerState.O().size(); var3++) {
         ((Player)GamePersistence.careerState.O().get(var3)).ay(0);
      }

      for (int var4 = 0; var4 < GamePersistence.careerState.N().size(); var4++) {
         for (int var5 = 0; var5 < ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var4)).eb().get(0)).zM().size(); var5++) {
            ((Player)((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var4)).eb().get(0)).zM().get(var5)).fd();
         }
      }
   }

   private void am() {
      for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
         ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).ee();
         ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).jq().mw();
      }

      for (int var6 = 0; var6 < GamePersistence.careerState.N().size(); var6++) {
         for (int var2 = 0; var2 < ((CountryCompetitions)GamePersistence.careerState.N().get(var6)).eb().size(); var2++) {
            ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var6)).eb().get(var2)).yi().aN(false);
            ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var6)).eb().get(var2)).aT(false);
         }
      }

      for (int var7 = 0; var7 < GamePersistence.careerState.N().size(); var7++) {
         boolean var8 = true;
         if (((CountryCompetitions)GamePersistence.careerState.N().get(var7)).jc() == 29 && GamePersistence.careerState.bk()) {
            var8 = false;
         } else if (((CountryCompetitions)GamePersistence.careerState.N().get(var7)).jc() == 29 && GamePersistence.careerState.X()) {
            var8 = false;
         }

         if (!var8) {
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var7)).jc() == 29) {
               ((CountryCompetitions)GamePersistence.careerState.N().get(var7)).a((NationalCup)null);
            }
         } else {
            ArrayList var3 = new ArrayList();

            for (int var4 = 0; var4 < ((CountryCompetitions)GamePersistence.careerState.N().get(var7)).eb().size(); var4++) {
               for (int var5 = 0; var5 < ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var7)).eb().get(var4)).yi().yK().size(); var5++) {
                  var3.add((Club)((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var7)).eb().get(var4)).yi().yK().get(var5));
               }
            }

            ArrayList var9 = new ArrayList();
            var9.addAll(((CountryCompetitions)GamePersistence.careerState.N().get(var7)).jg());
            Collections.sort(var9, C1007.cN);

            for (int var10 = 0; var10 < var9.size(); var10++) {
               if (!var3.contains(var9.get(var10))) {
                  var3.add((Club)var9.get(var10));
               }
            }

            ((CountryCompetitions)GamePersistence.careerState.N().get(var7)).a(var3, false, "atualizaLigasNacionais");
         }
      }
   }

   public static void an() {
      new ArrayList();
      ArrayList var0 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.currentScheduleIndex)).j();

      for (int var1 = 0; var1 < var0.size(); var1++) {
         if (var0.get(var1) instanceof LeagueStage && ((CompetitionStage)var0.get(var1)).b() == 1 && ((LeagueStage)var0.get(var1)).vl() != null) {
            ((LeagueStage)var0.get(var1)).vl().a((LeagueStage)var0.get(var1));
         }
      }
   }

   public int ao() {
      return ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).t().size() > 0 ? ((Competition)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).t().get(0)).b() : -1;
   }

   public void ap() {
      this.bH = false;
      if (GamePersistence.careerState.bD() && GamePersistence.careerState.getSeasonNumber() == 10) {
         GamePersistence.careerState.h(false);
      }

      if (ay()) {
         if (this.bs) {
            MainWindow.aY(2);
            if (!this.bL) {
               if (GamePersistence.careerState.autoSalvar == 1) {
                  if (this.bJ >= 3) {
                     try {
                        new java.io.ByteArrayInputStream(new byte[0]).close();
                        MainWindow.iF().ru();
                     } catch (IOException var4) {
                        var4.printStackTrace();
                     }

                     this.bJ = 0;
                  } else {
                     this.bJ++;
                  }
               } else if (GamePersistence.careerState.autoSalvar == 2) {
                  try {
                     new java.io.ByteArrayInputStream(new byte[0]).close();
                        MainWindow.iF().ru();
                  } catch (IOException var3) {
                     var3.printStackTrace();
                  }
               } else if (GamePersistence.careerState.autoSalvar == 3 && this.bF()) {
                  this.bM = false;

                  try {
                     new java.io.ByteArrayInputStream(new byte[0]).close();
                        MainWindow.iF().ru();
                  } catch (IOException var2) {
                     var2.printStackTrace();
                  }
               }
            }

            if (!this.bL && !MainWindow.iF().rB()) {
               if (new Random().nextInt(100) == 1) {
                  MainWindow.iF().ac(false);
               } else if (new Random().nextInt(2) == 1) {
                  MainWindow.iF().ac(true);
               }
            }
         }
      } else {
         if (GamePersistence.careerState.isIgnoraLigas() && this.ao() == 1 && !C0737.dG() && !this.bI) {
            this.bH = true;
         }

         if (this.bI) {
            this.bI = false;
         }

         if (GamePersistence.careerState.isIgnoraEstadual() && this.ao() == 3) {
            if (!C0737.J(3)) {
               this.bH = true;
            }
         } else if (GamePersistence.careerState.isIgnoraEstadual() && this.ao() == 10 && !C0737.J(10)) {
            this.bH = true;
         }

         if (!this.bH && this.ao() == 10 && this.aq() && !C0737.dH()) {
            this.bH = true;
         } else if (!this.bH && this.ao() == 10 && !this.ar() && GamePersistence.getOptions().getRegionaisSemHumanos() == 0) {
            this.bH = true;
         }

         Club.prepareAiLineupsForCurrentSchedule();
         Match.he();
         if (this.bs && !this.bH && C0737.dw()) {
            C0737.dx();
         } else {
            this.at();
         }
      }

      if (this.bL) {
         this.bL = false;
      }
   }

   private boolean aq() {
      int var1 = 0;

      for (int var2 = 0; var2 < GamePersistence.careerState.aZ.length; var2++) {
         if (GamePersistence.careerState.aZ[var2] != null) {
            var1++;
         }
      }

      return var1 < 4 && var1 > 0;
   }

   private boolean ar() {
      for (int var1 = 0; var1 < GamePersistence.careerState.M().size(); var1++) {
         if (GamePersistence.careerState.M().get(var1) != null) {
            Club var2 = ((Coach)GamePersistence.careerState.M().get(var1)).getClub();
            if (var2 != null) {
               for (int var3 = 0; var3 < GamePersistence.careerState.aZ.length; var3++) {
                  if (GamePersistence.careerState.aZ[var3] != null
                     && GamePersistence.careerState.aZ[var3].yd() != null
                     && GamePersistence.careerState.aZ[var3].yd().yK() != null
                     && GamePersistence.careerState.aZ[var3].yd().yK().contains(var2)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public void as() {
      new ArrayList();
      ArrayList var1 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).h();
      int var2 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).b();

      for (int var3 = 0; var3 < var1.size(); var3++) {
         ((Match)var1.get(var3)).a(true);
         ((Match)var1.get(var3)).hg();
         ((Match)var1.get(var3)).hi();
         ((Match)var1.get(var3)).hf();
         ((Match)var1.get(var3)).hh();
         ((Match)var1.get(var3)).getHomeClub().setLineupReady(false);
         ((Match)var1.get(var3)).getAwayClub().setLineupReady(false);
         ((Match)var1.get(var3)).a(null);
      }

      for (int var6 = 0; var6 < GamePersistence.careerState.O().size(); var6++) {
         ((Player)GamePersistence.careerState.O().get(var6)).recoverEnergyDaily();
      }

      for (int var7 = 0; var7 < GamePersistence.careerState.Q().size(); var7++) {
         ((Player)GamePersistence.careerState.Q().get(var7)).setEnergy(100);
      }

      if (var2 == 7 || var2 == 9) {
         for (int var8 = 0; var8 < GamePersistence.careerState.aG().size(); var8++) {
            Club var4 = ((CountryCompetitions)GamePersistence.careerState.aG().get(var8)).jn();
            if (var4 != null) {
               for (int var5 = 0; var5 < var4.getSeniorPlayers().size(); var5++) {
                  if (((Player)var4.getSeniorPlayers().get(var5)).getClub() == null) {
                     ((Player)var4.getSeniorPlayers().get(var5)).recoverEnergyDaily();
                  }
               }
            }
         }
      }

      Collections.sort(GamePersistence.careerState.L(), bO);
   }

   public void at() {
      this.as();
      an();
      this.aM();
      this.aC();
      this.aB();
      this.q(0);
      if (this.bs && !this.bH) {
         MainWindow.aY(5);
      } else {
         this.ax();
      }
   }

   private void au() {
      ArrayList var1 = new ArrayList();
      if (this.av != null && GamePersistence.careerState.av.size() > 0) {
         for (int var2 = 0; var2 < GamePersistence.careerState.av.size(); var2++) {
            if (((C0825)this.av.get(var2)).tM()) {
               boolean var3 = false;
               Coach var4 = null;
               if (((C0825)this.av.get(var2)).x().getClub() != null && ((C0825)this.av.get(var2)).x().getClub().isUserControlled()) {
                  var3 = true;
                  var4 = ((C0825)this.av.get(var2)).x().getClub().getCoach();
               }

               if (((C0825)this.av.get(var2)).tN()) {
                  var1.add((C0825)GamePersistence.careerState.av.get(var2));
                  if (((C0825)this.av.get(var2)).tP() != null && ((C0825)this.av.get(var2)).tP().isUserControlled()) {
                     new C0799(((C0825)this.av.get(var2)).tP().getCoach(), 29, 83, "", ((C0825)this.av.get(var2)).x().getNome());
                  } else if (var3) {
                     new C0799(var4, 29, 84, "", ((C0825)this.av.get(var2)).x().getNome());
                  }
               } else if (((C0825)this.av.get(var2)).tP() != null && ((C0825)this.av.get(var2)).tP().isUserControlled() && !((C0825)this.av.get(var2)).tQ()) {
                  new C0799(((C0825)this.av.get(var2)).tP().getCoach(), 28, 82, "", ((C0825)this.av.get(var2)).x().getNome());
                  ((C0825)this.av.get(var2)).au(true);
               }
            }
         }
      }

      if (var1.size() > 0) {
         for (int var5 = 0; var5 < var1.size(); var5++) {
            GamePersistence.careerState.av.remove(var1.get(var5));
         }
      }
   }

   public void d(Player player) {
      int var2 = -1;
      if (this.av != null && GamePersistence.careerState.av.size() > 0) {
         for (int var3 = 0; var3 < GamePersistence.careerState.av.size(); var3++) {
            if (((C0825)GamePersistence.careerState.av.get(var3)).x() == player) {
               var2 = var3;
               break;
            }
         }
      }

      if (var2 >= 0) {
         GamePersistence.careerState.av.remove(var2);
      }
   }

   private void av() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aN().size(); var1++) {
         for (int var2 = 0; var2 < ((Club)GamePersistence.careerState.aN().get(var1)).getSeniorPlayers().size(); var2++) {
            if (((Player)((Club)GamePersistence.careerState.aN().get(var1)).getSeniorPlayers().get(var2)).ft()) {
               new C0794((Player)((Club)GamePersistence.careerState.aN().get(var1)).getSeniorPlayers().get(var2), ((Player)((Club)GamePersistence.careerState.aN().get(var1)).getSeniorPlayers().get(var2)).fl(), true, true);
            }
         }
      }
   }

   private void processCompletedStadiumExpansions() {
      ArrayList var1 = new ArrayList();
      if (this.stadiumExpansionProjects != null && GamePersistence.careerState.stadiumExpansionProjects.size() > 0) {
         for (int var2 = 0; var2 < GamePersistence.careerState.stadiumExpansionProjects.size(); var2++) {
            if (((StadiumExpansionProject)GamePersistence.careerState.stadiumExpansionProjects.get(var2)).getCompletionDate().before(GamePersistence.careerState.getCurrentDate())) {
               ((StadiumExpansionProject)GamePersistence.careerState.stadiumExpansionProjects.get(var2)).applyExpansion();
               var1.add((StadiumExpansionProject)GamePersistence.careerState.stadiumExpansionProjects.get(var2));
            }
         }
      }

      if (var1.size() > 0) {
         for (int var3 = 0; var3 < var1.size(); var3++) {
            GamePersistence.careerState.stadiumExpansionProjects.remove(var1.get(var3));
         }
      }
   }

   public void ax() {
      int var1 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).i();
      if (var1 == 1 || var1 == 3) {
         this.n(var1);
      }

      int var2 = this.az();
      if (this.av != null && GamePersistence.careerState.av.size() > 0) {
         this.au();
      }

      if (new Random().nextInt(100) > 50) {
         this.av();
      }

      if (this.stadiumExpansionProjects != null && GamePersistence.careerState.stadiumExpansionProjects.size() > 0) {
         this.processCompletedStadiumExpansions();
      }

      this.q(1);
      if (var2 == 0) {
         this.bk = true;
      }

      if (this.bs) {
         if (this.bk) {
            GamePersistence.coachJobMarket.zw();
            this.al();
            MainWindow.aY(6);
         } else {
            GamePersistence.careerState.ap();
         }
      } else if (this.bk) {
         this.al();
      }
   }

   private static boolean ay() {
      new ArrayList();
      ArrayList var0 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.currentScheduleIndex)).h();

      for (int var1 = 0; var1 < var0.size(); var1++) {
         if (((Match)var0.get(var1)).getHomeClub().isUserControlled() && !((Match)var0.get(var1)).getHomeClub().isLineupReady()) {
            a(((Match)var0.get(var1)).getHomeClub(), (Match)var0.get(var1));
            return true;
         }

         if (((Match)var0.get(var1)).getAwayClub().isUserControlled() && !((Match)var0.get(var1)).getAwayClub().isLineupReady()) {
            a(((Match)var0.get(var1)).getAwayClub(), (Match)var0.get(var1));
            return true;
         }
      }

      return false;
   }

   public static Club B() {
      return X;
   }

   public static void a(Club club, Match c0675) {
      X = club;
      bv = c0675;
   }

   public int az() {
      for (int var1 = GamePersistence.careerState.currentScheduleIndex; var1 < GamePersistence.careerState.getScheduleDays().size(); var1++) {
         if (!((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var1)).e() && ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var1)).b() > 0 && ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var1)).h().size() > 0) {
            GamePersistence.careerState.setCurrentScheduleIndex(var1);
            return var1;
         }
      }

      return 0;
   }

   private static void aA() {
   }

   private void aB() {
      new ArrayList();
      ArrayList var1 = ((ScheduleDay)this.scheduleDays.get(this.currentScheduleIndex)).t();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         ((Competition)var1.get(var2)).mx();
      }
   }

   private void aC() {
      new ArrayList();
      ArrayList var1 = ((ScheduleDay)this.scheduleDays.get(this.currentScheduleIndex)).j();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         if (var1.get(var2) instanceof LeagueStage) {
            ((LeagueStage)var1.get(var2)).pO();
         } else if (var1.get(var2) instanceof KnockoutStage) {
            ((KnockoutStage)var1.get(var2)).pO();
         }
      }
   }

   private void n(int i) {
      for (int var3 = 0; var3 < this.am.size(); var3++) {
         if (((Coach)this.am.get(var3)).isUserControlled() && ((Coach)this.am.get(var3)).getClub() == null) {
            ArrayList var2 = GamePersistence.coachJobMarket.b((Coach)this.am.get(var3), false);
            if (!GamePersistence.careerState.bD() && var2 != null && var2.size() > 0) {
               MainWindow.a(var2, (Coach)this.am.get(var3), 0);
            }
         }
      }

      ArrayList var5 = new ArrayList();
      if (i == 1) {
         for (int var4 = 0; var4 < this.ao.size(); var4++) {
            ((CountryCompetitions)this.ao.get(var4)).A(var5);
         }
      } else if (i == 3) {
         for (int var6 = 0; var6 < this.aq.size(); var6++) {
            ((C0741)this.aq.get(var6)).A(var5);
         }
      }

      if (var5.size() > 0 && GamePersistence.careerState.bs && !GamePersistence.careerState.bD() && GamePersistence.careerState.getVerMudancaTecnicos() == 1) {
         MainWindow.K(var5);
      }

      boolean var7 = false;
   }

   public boolean isJogaEstadual() {
      return this.jogaEstadual;
   }

   public void setJogaEstadual(boolean bl) {
      this.jogaEstadual = bl;
   }

   public ArrayList aE() {
      return this.aq;
   }

   public CopaLibertadores aF() {
      return this.aC;
   }

   public void a(CopaLibertadores c0954) {
      this.aC = c0954;
   }

   public CountryCompetitions o(int i) {
      for (int var2 = 0; var2 < this.ao.size(); var2++) {
         if (((CountryCompetitions)this.ao.get(var2)).jc() == i) {
            return (CountryCompetitions)this.ao.get(var2);
         }
      }

      return null;
   }

   public C0741 p(int i) {
      for (int var2 = 0; var2 < this.aq.size(); var2++) {
         if (((C0741)this.aq.get(var2)).getEstado() == i) {
            return (C0741)this.aq.get(var2);
         }
      }

      return null;
   }

   public ArrayList aG() {
      return this.ap;
   }

   public CopaSudamericana aH() {
      return this.aY;
   }

   public void a(CopaSudamericana c0930) {
      this.aY = c0930;
   }

   public boolean isJogaIntClubes() {
      return this.jogaIntClubes;
   }

   public void setJogaIntClubes(boolean bl) {
      this.jogaIntClubes = bl;
   }

   public UefaChampionsLeague aI() {
      return this.aB;
   }

   public void a(UefaChampionsLeague c0958) {
      this.aB = c0958;
   }

   public boolean aJ() {
      return this.bb;
   }

   public void d(boolean bl) {
      this.bb = bl;
   }

   public UefaEuropaLeague aK() {
      return this.aX;
   }

   public void a(UefaEuropaLeague c0960) {
      this.aX = c0960;
   }

   public AfcChampionsLeague aL() {
      return this.aE;
   }

   public void a(AfcChampionsLeague c0957) {
      this.aE = c0957;
   }

   public void aM() {
      for (int var1 = 0; var1 <= this.currentScheduleIndex; var1++) {
         ((ScheduleDay)this.scheduleDays.get(var1)).a(true);
      }
   }

   public void q(int i) {
      if (i == 0) {
         for (int var2 = 0; var2 <= this.currentScheduleIndex; var2++) {
            if (((ScheduleDay)this.scheduleDays.get(var2)).r().size() > 0) {
               ((ScheduleDay)this.scheduleDays.get(var2)).f(0);
            }
         }
      } else {
         for (int var3 = 0; var3 <= this.currentScheduleIndex; var3++) {
            if (((ScheduleDay)this.scheduleDays.get(var3)).s().size() > 0) {
               ((ScheduleDay)this.scheduleDays.get(var3)).f(1);
            }
         }
      }
   }

   public ArrayList aN() {
      return this.ak;
   }

   public void d(Club club) {
      this.ak.add(club);
   }

   public CafChampionsLeague aO() {
      return this.aD;
   }

   public void a(CafChampionsLeague c0956) {
      this.aD = c0956;
   }

   public ConcacafChampionsLeague aP() {
      return this.aF;
   }

   public OfcChampionsLeague aQ() {
      return this.aG;
   }

   public void a(OfcChampionsLeague c0961) {
      this.aG = c0961;
   }

   public void a(ConcacafChampionsLeague c0959) {
      this.aF = c0959;
   }

   public ClubWorldCup aR() {
      if (this.aA == null && GamePersistence.careerState.isJogaIntClubes()) {
         this.aA = new ClubWorldCup();
      }

      return this.aA;
   }

   public void a(ClubWorldCup c0923) {
      this.aA = c0923;
   }

   public void r(int i) {
      Calendar var2 = Calendar.getInstance();
      DateFormat var3 = DateFormat.getDateInstance();
      int var4 = 0;
      boolean var5 = false;
      int var6 = 0;
      var2.set(i, 0, 1, 0, 0, 0);

      while (var2.get(1) == i) {
         ScheduleDay var7 = new ScheduleDay();
         var7.a(var2.get(1), var2.get(2), var2.get(5));
         GamePersistence.careerState.a(var7);
         if (var2.get(2) == 0 && var2.get(7) == 1) {
            if (++var4 == 1) {
               GamePersistence.careerState.setCurrentScheduleIndex(var6);
            }
         }

         var6++;
         var2.add(5, 1);
      }

      this.aS();
   }

   private void aS() {
      ArrayList var1 = ScheduleDay.d();
      ArrayList var2 = ScheduleDay.c(1);
      ArrayList var3;
      if (this.salarioMensal) {
         var3 = var1;
      } else {
         var3 = var2;
      }

      for (int var4 = 0; var4 < var3.size(); var4++) {
         ScheduleDay.b((Integer)var3.get(var4), 2, 0);
      }

      for (int var6 = 0; var6 < var1.size(); var6++) {
         ScheduleDay.b((Integer)var1.get(var6), 5, 0);
      }

      var3 = var2;

      for (int var7 = 0; var7 < var3.size(); var7++) {
         ScheduleDay.b((Integer)var3.get(var7), 3, 0);
      }
   }

   public boolean isUsaGrupoPadraoEstadual() {
      return this.usaGrupoPadraoEstadual;
   }

   public void setUsaGrupoPadraoEstadual(boolean bl) {
      this.usaGrupoPadraoEstadual = bl;
   }

   public void aT() {
      if (GamePersistence.careerState.isHabilidadeIndividual() && GamePersistence.careerState.bO() == 3) {
         for (int var1 = 0; var1 < this.aj.size(); var1++) {
            ((Club)this.aj.get(var1)).lj();
         }
      }

      for (int var2 = 0; var2 < this.ag.size(); var2++) {
         ((Player)this.ag.get(var2)).fV();
      }

      for (int var3 = 0; var3 < this.ah.size(); var3++) {
         ((Player)this.ah.get(var3)).fY();
      }

      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         if (GamePersistence.careerState.bO() == 3) {
            GamePersistence.careerState.A(0);
         } else {
            GamePersistence.careerState.bP();
         }
      }
   }

   public void aU() {
      for (int var1 = 0; var1 < this.O().size(); var1++) {
         ((Player)this.O().get(var1)).fI();
      }

      for (int var2 = 0; var2 < this.Q().size(); var2++) {
         ((Player)this.Q().get(var2)).fI();
      }

      for (int var3 = 0; var3 < this.aj.size(); var3++) {
         ((Club)this.aj.get(var3)).kp();
         ((Club)this.aj.get(var3)).kH();
      }
   }

   public SouthAmericanRecopa aV() {
      return this.aI;
   }

   public void a(SouthAmericanRecopa c0927) {
      this.aI = c0927;
   }

   public EuropeanSuperCup aW() {
      return this.aJ;
   }

   public void a(EuropeanSuperCup c0926) {
      this.aJ = c0926;
   }

   public boolean isSalarioMensal() {
      return this.salarioMensal;
   }

   public void setSalarioMensal(boolean bl) {
      this.salarioMensal = bl;
   }

   public ArrayList aX() {
      if (this.bx == null) {
         this.bx = new ArrayList();
      }

      return this.bx;
   }

   public WorldCup aY() {
      return this.aK;
   }

   public void a(WorldCup c0953) {
      this.aK = c0953;
   }

   public CopaAmerica aZ() {
      return this.aR;
   }

   public void a(CopaAmerica c0940) {
      this.aR = c0940;
   }

   public EuropeanChampionship ba() {
      return this.aS;
   }

   public void a(EuropeanChampionship c0952) {
      this.aS = c0952;
   }

   public CountryCompetitions s(int i) {
      for (int var2 = 0; var2 < this.ap.size(); var2++) {
         if (((CountryCompetitions)this.ap.get(var2)).jc() == i) {
            return (CountryCompetitions)this.ap.get(var2);
         }
      }

      return null;
   }

   public Calendar getCurrentDate() {
      return ((ScheduleDay)this.scheduleDays.get(this.currentScheduleIndex)).a();
   }

   public long getCurrentTimeMillis() {
      return ((ScheduleDay)this.scheduleDays.get(this.currentScheduleIndex)).a().getTime().getTime();
   }

   public ArrayList bd() {
      return this.ax;
   }

   public AfricaCupOfNations be() {
      return this.aT;
   }

   public void a(AfricaCupOfNations c0939) {
      this.aT = c0939;
   }

   public AsianCup bf() {
      return this.aU;
   }

   public void a(AsianCup c0941) {
      this.aU = c0941;
   }

   public ConcacafGoldCup bg() {
      return this.aV;
   }

   public void a(ConcacafGoldCup c0944) {
      this.aV = c0944;
   }

   public Coach bh() {
      for (int var1 = 0; var1 < this.al.size(); var1++) {
         if (((Coach)this.al.get(var1)).getClub() == null && !((Coach)this.al.get(var1)).isUserControlled()) {
            return (Coach)this.al.get(var1);
         }
      }

      return null;
   }

   public Coach a(Club club, int i) {
      ArrayList var3 = new ArrayList();
      int var4 = 0;
      int var5 = 0;

      for (int var6 = 0; var6 < this.al.size(); var6++) {
         if (i == -1) {
            var4 = 0;
            var5 = 5;
         } else if (i == 0) {
            var4 = club.getReputacao();
            var5 = club.getReputacao();
         } else if (i == 1) {
            var4 = club.getReputacao() - 1;
            var5 = club.getReputacao();
         } else if (i == 2) {
            var4 = club.getReputacao() - 2;
            var5 = club.getReputacao() + 1;
         }

         if (((Coach)this.al.get(var6)).getClub() == null
            && !((Coach)this.al.get(var6)).isUserControlled()
            && ((Coach)this.al.get(var6)).getClub() != club
            && (((Coach)this.al.get(var6)).bz() == club.getPais() || ((Coach)this.al.get(var6)).lE() == club.getPais())
            && ((Coach)this.al.get(var6)).getReputacao() >= var4
            && ((Coach)this.al.get(var6)).getReputacao() <= var5) {
            var3.add((Coach)this.al.get(var6));
         }
      }

      if (var3.size() > 0) {
         int var7 = new Random().nextInt(100);
         if (var7 < 50) {
            Collections.sort(var3, bO);
         } else {
            Collections.shuffle(var3);
         }
      }

      return var3.size() > 0 ? (Coach)var3.get(0) : null;
   }

   public void a(Coach coach, Coach coach2) {
      Club var3 = coach.getClub();
      Club var4 = coach2.getClub();
      coach.i(coach2);
      coach2.i(coach);
      coach.E(var4);
      coach2.E(var3);
   }

   public void a(Club club, Coach coach, Coach coach2) {
      if (coach != null) {
         coach.i(coach2);
      }

      if (coach2 != null) {
         coach2.E(club);
      }
   }

   public boolean t(int i) {
      for (int var2 = 0; var2 < this.bF.size(); var2++) {
         if (((C0681)this.bF.get(var2)).getPais() == i && ((C0681)this.bF.get(var2)).iC()) {
            return true;
         }
      }

      return false;
   }

   public void bi() {
      for (int var1 = 0; var1 < this.bF.size(); var1++) {
         ((C0681)this.bF.get(var1)).v(true);
      }
   }

   public boolean bj() {
      for (int var1 = 0; var1 < this.bF.size(); var1++) {
         if (((C0681)this.bF.get(var1)).iC()) {
            return true;
         }
      }

      return false;
   }

   public boolean isJogaIntano1() {
      return this.jogaIntano1;
   }

   public void setJogaIntano1(boolean bl) {
      this.jogaIntano1 = bl;
   }

   public boolean isGruposIntPadrao() {
      return this.gruposIntPadrao;
   }

   public void setGruposIntPadrao(boolean bl) {
      this.gruposIntPadrao = bl;
   }

   public boolean[] getVerJint() {
      return this.verJint;
   }

   public void setVerJint(boolean[] bls) {
      this.verJint = bls;
   }

   public void setVerJint(boolean bl, int i) {
      this.verJint[i] = bl;
   }

   public boolean isJogaSelecoesAll() {
      return this.jogaSelecoesAll;
   }

   public void setJogaSelecoesAll(boolean bl) {
      this.jogaSelecoesAll = bl;
   }

   public boolean bk() {
      return this.bc;
   }

   public void e(boolean bl) {
      this.bc = bl;
   }

   public static Match bl() {
      return bv;
   }

   public boolean bm() {
      return this.bd;
   }

   public void f(boolean bl) {
      this.bd = bl;
   }

   public boolean isNegritoCasa() {
      return this.negritoCasa;
   }

   public void setNegritoCasa(boolean bl) {
      this.negritoCasa = bl;
   }

   public ArrayList bn() {
      return this.at;
   }

   public ArrayList bo() {
      return this.au;
   }

   public int getAutoSalvar() {
      return this.autoSalvar;
   }

   public void setAutoSalvar(int i) {
      this.autoSalvar = i;
   }

   public int getVelocidade() {
      return this.velocidade;
   }

   public void setVelocidade(int i) {
      this.velocidade = i;
   }

   public int getVelocidadeNH() {
      return this.velocidadeNH;
   }

   public void setVelocidadeNH(int i) {
      this.velocidadeNH = i;
   }

   public int getAvisoTerminoContrato() {
      return this.avisoTerminoContrato;
   }

   public void setAvisoTerminoContrato(int i) {
      this.avisoTerminoContrato = i;
   }

   public int getVerDecisaoPenNaoHumano() {
      return this.verDecisaoPenNaoHumano;
   }

   public void setVerDecisaoPenNaoHumano(int i) {
      this.verDecisaoPenNaoHumano = i;
   }

   public int getVerMudancaTecnicos() {
      return this.verMudancaTecnicos;
   }

   public void setVerMudancaTecnicos(int i) {
      this.verMudancaTecnicos = i;
   }

   public int getVerJanelaSubs() {
      return this.verJanelaSubs;
   }

   public void setVerJanelaSubs(int i) {
      this.verJanelaSubs = i;
   }

   public boolean isAutoRenovaContrato() {
      return this.autoRenovaContrato;
   }

   public void setAutoRenovaContrato(boolean bl) {
      this.autoRenovaContrato = bl;
   }

   public boolean isUsaCorPlacar() {
      return this.usaCorPlacar;
   }

   public void setUsaCorPlacar(boolean bl) {
      this.usaCorPlacar = bl;
   }

   public int getCorPlacar() {
      return this.corPlacar;
   }

   public void setCorPlacar(int i) {
      this.corPlacar = i;
   }

   public boolean isUsaSons() {
      return this.usaSons;
   }

   public void setUsaSons(boolean bl) {
      this.usaSons = bl;
   }

   public boolean isUsaCoresLista() {
      return this.usaCoresLista;
   }

   public void setUsaCoresLista(boolean bl) {
      this.usaCoresLista = bl;
   }

   public boolean isVerEstaduaisAgrupados() {
      return this.verEstaduaisAgrupados;
   }

   public void setVerEstaduaisAgrupados(boolean bl) {
      this.verEstaduaisAgrupados = bl;
   }

   public String[] bp() {
      return this.bP;
   }

   public void bq() {
      for (int var1 = 0; var1 < this.bP.length; var1++) {
         this.bP[var1] = String.format("#%02x%02x%02x", this.coresLista[0].getRed(), this.coresLista[var1].getGreen(), this.coresLista[var1].getBlue());
      }
   }

   public Color[] getCoresLista() {
      if (this.coresLista != null) {
         return this.coresLista;
      }

      this.coresLista = new Color[5];

      for (int var1 = 0; var1 < this.coresLista.length; var1++) {
         this.coresLista[var1] = new Color(
            Integer.valueOf(this.bP[var1].substring(1, 3), 16),
            Integer.valueOf(this.bP[var1].substring(3, 5), 16),
            Integer.valueOf(this.bP[var1].substring(5, 7), 16)
         );
      }

      return this.coresLista;
   }

   public void setCoresLista(Color[] colors) {
      this.coresLista = colors;
      this.bq();
   }

   public String getSaveName() {
      return this.saveName;
   }

   public void setSaveName(String string) {
      this.saveName = string;
   }

   public SavedGameInfo getSavedGameInfo() {
      if (this.savedGameInfo == null) {
         this.savedGameInfo = new SavedGameInfo();
      }

      return this.savedGameInfo;
   }

   public void setSavedGameInfo(SavedGameInfo savedGameInfo) {
      this.savedGameInfo = savedGameInfo;
   }

   public ArrayList bt() {
      return this.av;
   }

   public ArrayList bu() {
      if (this.an == null) {
         this.an = new ArrayList();
      }

      return this.an;
   }

   public FriendlyMatches bv() {
      return this.aH;
   }

   public ArrayList getStadiumExpansionProjects() {
      if (this.stadiumExpansionProjects == null) {
         this.stadiumExpansionProjects = new ArrayList();
      }

      return this.stadiumExpansionProjects;
   }

   public ArrayList bx() {
      return this.ay;
   }

   public int by() {
      return this.be;
   }

   public void u(int i) {
      this.be = i;
   }

   public int bz() {
      return this.bf;
   }

   public int bA() {
      byte var1 = -1;
      if (GamePersistence.careerState.M().size() > 0) {
         Coach var2 = (Coach)GamePersistence.careerState.M().get(0);
         return var2.getClub() != null ? var2.getClub().getPais() : var2.bz();
      } else {
         return var1;
      }
   }

   public void v(int i) {
      this.bf = i;
   }

   public void setIgnoraLigas(boolean bl) {
      this.ignoraLigas = bl;
   }

   public boolean isIgnoraLigas() {
      return this.ignoraLigas;
   }

   public Competition[] bB() {
      return new Competition[]{
         this.aK,
         this.aS,
         this.aR,
         this.aT,
         this.aU,
         this.aV,
         this.aW,
         this.aA,
         this.aB,
         this.aC,
         this.aD,
         this.aE,
         this.aF,
         this.aG,
         this.aX,
         this.aY,
         this.aI,
         this.aJ,
         this.IY
      };
   }

   public boolean isIgnoraEstadual() {
      return this.ignoraEstadual;
   }

   public void setIgnoraEstadual(boolean bl) {
      this.ignoraEstadual = bl;
   }

   public boolean bC() {
      return this.bI;
   }

   public void g(boolean bl) {
      this.bI = bl;
   }

   public boolean bD() {
      return this.bK;
   }

   public void h(boolean bl) {
      this.bK = bl;
   }

   public boolean bE() {
      return this.bL;
   }

   public void i(boolean bl) {
      this.bL = bl;
   }

   public boolean bF() {
      return this.bM;
   }

   public void j(boolean bl) {
      this.bM = bl;
   }

   public void f(ArrayList arrayList) {
      this.ak = arrayList;
   }

   public ArrayList bG() {
      return this.bF;
   }

   public void g(ArrayList arrayList) {
      this.bF = arrayList;
   }

   public void h(ArrayList arrayList) {
      this.an = arrayList;
   }

   public void i(ArrayList arrayList) {
      this.ao = arrayList;
   }

   public void j(ArrayList arrayList) {
      this.ap = arrayList;
   }

   public void k(ArrayList arrayList) {
      this.aq = arrayList;
   }

   public void l(ArrayList arrayList) {
      this.av = arrayList;
   }

   public void m(ArrayList arrayList) {
      this.ax = arrayList;
   }

   public void n(ArrayList arrayList) {
      this.scheduleDays = arrayList;
   }

   public void o(ArrayList arrayList) {
      this.at = arrayList;
   }

   public void p(ArrayList arrayList) {
      this.au = arrayList;
   }

   public void setStadiumExpansionProjects(ArrayList arrayList) {
      this.stadiumExpansionProjects = arrayList;
   }

   public void r(ArrayList arrayList) {
      this.ay = arrayList;
   }

   public int bH() {
      return this.bg;
   }

   public void bI() {
      this.bg++;
   }

   public void w(int i) {
      this.bg = i;
   }

   public Club x(int i) {
      Object var2 = null;

      for (int var3 = 0; var3 < GamePersistence.careerState.P().size(); var3++) {
         if (((Club)GamePersistence.careerState.P().get(var3)).getClubId() == i) {
            return (Club)GamePersistence.careerState.P().get(var3);
         }
      }

      if (var2 == null) {
         for (int var4 = 0; var4 < GamePersistence.careerState.aG().size(); var4++) {
            if (((CountryCompetitions)GamePersistence.careerState.aG().get(var4)).jn() != null && ((CountryCompetitions)GamePersistence.careerState.aG().get(var4)).jn().getClubId() == i) {
               return ((CountryCompetitions)GamePersistence.careerState.aG().get(var4)).jn();
            }
         }
      }

      return (Club)var2;
   }

   public Coach y(int i) {
      Object var2 = null;

      for (int var3 = 0; var3 < GamePersistence.careerState.L().size(); var3++) {
         if (((Coach)GamePersistence.careerState.L().get(var3)).lT() == i) {
            return (Coach)GamePersistence.careerState.L().get(var3);
         }
      }

      return (Coach)var2;
   }

   public static String z(int i) {
      Club var1 = null;

      for (int var2 = 0; var2 < GamePersistence.careerState.P().size(); var2++) {
         if (((Club)GamePersistence.careerState.P().get(var2)).getClubId() == i) {
            var1 = (Club)GamePersistence.careerState.P().get(var2);
            return var1.getNome();
         }
      }

      if (var1 == null) {
         for (int var5 = 0; var5 < GamePersistence.careerState.aG().size(); var5++) {
            if (((CountryCompetitions)GamePersistence.careerState.aG().get(var5)).jn() != null && ((CountryCompetitions)GamePersistence.careerState.aG().get(var5)).jn().getClubId() == i) {
               var1 = ((CountryCompetitions)GamePersistence.careerState.aG().get(var5)).jn();
               return var1.getNome();
            }
         }
      }

      return "";
   }

   public ArrayList bJ() {
      return this.az;
   }

   public void s(ArrayList arrayList) {
      this.az = arrayList;
   }

   public SouthAmericaWorldCupQualifiers bK() {
      return this.aL;
   }

   public void a(SouthAmericaWorldCupQualifiers c0950) {
      this.aL = c0950;
   }

   public EuropeWorldCupQualifiers bL() {
      return this.aM;
   }

   public void a(EuropeWorldCupQualifiers c0948) {
      this.aM = c0948;
   }

   public AfricaWorldCupQualifiers bM() {
      return this.aN;
   }

   public void a(AfricaWorldCupQualifiers c0945) {
      this.aN = c0945;
   }

   public ArrayList bN() {
      return this.ai;
   }

   public void t(ArrayList arrayList) {
      this.ai = arrayList;
   }

   public boolean isHabilidadeIndividual() {
      return this.habilidadeIndividual;
   }

   public void setHabilidadeIndividual(boolean bl) {
      this.habilidadeIndividual = bl;
   }

   public int bO() {
      return this.bh;
   }

   public void bP() {
      this.bh++;
   }

   public void A(int i) {
      this.bh = i;
   }

   public boolean isUsarGruposReaisCopa() {
      return this.bi;
   }

   public void setUsarGruposReaisCopa(boolean bl) {
      this.bi = bl;
   }

   public AsiaWorldCupQualifiers bQ() {
      return this.aO;
   }

   public void a(AsiaWorldCupQualifiers c0946) {
      this.aO = c0946;
   }

   public ConcacafWorldCupQualifiers bR() {
      return this.aQ;
   }

   public void a(ConcacafWorldCupQualifiers c0947) {
      this.aQ = c0947;
   }

   public OceaniaWorldCupQualifiers bS() {
      return this.aP;
   }

   public void a(OceaniaWorldCupQualifiers c0949) {
      this.aP = c0949;
   }

   public boolean isJogaRegionais() {
      return this.jogaRegionais;
   }

   public void setJogaRegionais(boolean bl) {
      this.jogaRegionais = bl;
   }

   public int bT() {
      return this.bl;
   }

   public int bU() {
      this.bt++;
      return this.bt;
   }

   public RegionalCup[] bV() {
      return this.aZ;
   }

   public void a(RegionalCup c0928, int i) {
      this.aZ[i] = c0928;
   }

   public boolean[] getJogaRegionaisTodos() {
      return this.jogaRegionaisTodos;
   }

   public void setJogaRegionaisTodos(boolean[] bls) {
      this.jogaRegionaisTodos = bls;
   }

   public ArrayList bW() {
      return this.ar;
   }

   public void u(ArrayList arrayList) {
      this.ar = arrayList;
   }

   public OfcNationsCup bX() {
      return this.aW;
   }

   public void a(OfcNationsCup c0943) {
      this.aW = c0943;
   }

   public ArrayList bY() {
      return this.bu;
   }

   public int bZ() {
      return this.bn;
   }

   public int ca() {
      return this.br;
   }

   public Competition c(int i, int j) {
      Competition[] var3 = new Competition[]{this.aB, this.aC, this.aD, this.aE, this.aF, this.aG};
      Competition[] var4 = new Competition[]{this.aX, this.aY};
      Competition[] var5 = new Competition[]{this.IY};
      if (i == 4 && j < var3.length) {
         return var3[j];
      } else if (i == 6 && j < var4.length) {
         return var4[j];
      } else {
         return i == 12 && j < var5.length ? var5[j] : null;
      }
   }

   public void cb() {
      if (this.bw == null) {
         this.bw = new ArrayList();
      }

      for (int var1 = 0; var1 < this.aj.size(); var1++) {
         this.bw.add(((Club)this.aj.get(var1)).getStadium());
      }

      Collections.sort(this.bw, C1007.aaT);
   }

   public ArrayList cc() {
      return this.bw;
   }

   public ArrayList e(Club club) {
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < this.av.size(); var3++) {
         if (((C0825)this.av.get(var3)).x().getClub() != null && ((C0825)this.av.get(var3)).x().getClub() == club) {
            var2.add((C0825)this.av.get(var3));
         }
      }

      return var2;
   }

   public ArrayList f(Club club) {
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < this.av.size(); var3++) {
         if (((C0825)this.av.get(var3)).tP() == club) {
            var2.add((C0825)this.av.get(var3));
         }
      }

      return var2;
   }

   public C0825 e(Player player) {
      for (int var2 = 0; var2 < this.av.size(); var2++) {
         if (((C0825)this.av.get(var2)).x() == player) {
            return (C0825)this.av.get(var2);
         }
      }

      return null;
   }

   public boolean isVerLeiloes() {
      return this.verLeiloes;
   }

   public void setVerLeiloes(boolean bl) {
      this.verLeiloes = bl;
   }

   public boolean cd() {
      for (int var1 = 0; var1 < this.ak.size(); var1++) {
         if (((Club)this.ak.get(var1)).getCoach() != null && ((Club)this.ak.get(var1)).kb() > 0L && ((Club)this.ak.get(var1)).kw() < 35) {
            return true;
         }
      }

      return false;
   }

   public UefaConferenceLeague mj() {
      return this.IY;
   }

   public void a(UefaConferenceLeague c0932) {
      this.IY = c0932;
   }

   public int getFirstSeasonYear() {
      return this.firstSeasonYear;
   }

   public void setFirstSeasonYear(int i) {
      this.firstSeasonYear = i;
   }

   public void rU() {
      this.bl = 4;
      this.bm = 2;
      this.bn = 2;
      this.IZ = 3;
      this.bo = 1;
      this.bp = 1;
      this.bq = 3;
      this.br = 1;
      this.Ja = 1;
      this.Jb = 1;
   }

   public UefaNationsLeague sq() {
      return this.GC;
   }

   public void a(UefaNationsLeague c0935) {
      this.GC = c0935;
   }

   public Finalissima yl() {
      return this.IX;
   }

   public void a(Finalissima c0933) {
      this.IX = c0933;
   }

   public ConcacafNationsLeague ym() {
      return this.GI;
   }

   public void a(ConcacafNationsLeague c0936) {
      this.GI = c0936;
   }

   public FriendlyTournament yn() {
      return this.Gy;
   }

   public void a(FriendlyTournament c0934) {
      this.Gy = c0934;
   }

   public boolean yL() {
      return this.Jc;
   }

   public void aO(boolean bl) {
      this.Jc = bl;
   }

   public int ae(int i, int j) {
      int var3 = 0;
      if (i == 2) {
         var3 = 8;
      } else if (i == 3) {
         var3 = 9;
      } else if (i == 4) {
         var3 = j;
      } else if (i == 6) {
         if (j == 0) {
            var3 = 6;
         } else if (j == 1) {
            var3 = 7;
         }
      } else if (i == 12) {
         var3 = 14;
      } else if (i == 10) {
         var3 = 10;
      } else if (i == 8) {
         var3 = 12;
      } else if (i == 11) {
         var3 = 13;
      } else if (i == 15) {
         var3 = 15;
      } else if (i == 7) {
         if (j == 7) {
            var3 = 11;
         } else {
            var3 = 16;
         }
      } else if (i == 9) {
         var3 = 17;
      } else if (i == 14) {
         var3 = 18;
      } else if (i == 5) {
         var3 = 19;
      } else if (i == 13) {
         var3 = 20;
      }

      return var3;
   }
}
