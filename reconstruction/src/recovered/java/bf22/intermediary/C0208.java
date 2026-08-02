package bf22.intermediary;

import mod.recovered.match.MatchEvent;
import mod.recovered.competition.CopaLibertadores;
import mod.recovered.competition.CopaSudamericana;
import mod.recovered.competition.NationalSuperCup;
import mod.recovered.competition.UefaChampionsLeague;
import mod.recovered.competition.UefaEuropaLeague;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0208 extends JPanel {
   private static JFrame Br;
   private static C0208 GS;
   private static ArrayList vK = new ArrayList();
   private static int GT = 0;
   public Timer GO = null;
   private static int d = 1;
   private static int dB = 1;
   private boolean GU = false;
   private int GV = -1;
   private int GW = -1;
   private Color GX = new Color(51, 102, 0);
   private static ArrayList zD = new ArrayList();
   private static ArrayList zE = new ArrayList();
   private static ArrayList GY = new ArrayList();
   private static boolean GZ = true;
   private int Ha = 720;
   private static Competition Hb = null;
   private static int Hc = -1;
   private AudioInputStream[] Hd = new AudioInputStream[7];
   private static Clip[] He = new Clip[7];
   private JLabel uh;
   private JProgressBar Hf;
   private JScrollPane ut;
   private JLabel Hg;
   private JLabel xI;
   private JLabel Hh;
   private JLabel Hi;
   private JLabel Hj;
   private JLabel Hk;
   private JLabel Hl;
   private JLabel Hm;
   private JLabel Hn;
   private JLabel Ho;
   private JLabel Hp;
   private JPanel Hq;
   private JPanel Hr;
   private JTable Hs;
   private JLabel zM;
   private JLabel Ht;

   public C0208(JFrame jFrame, int i) {
      Br = jFrame;
      GS = this;
      this.Ha = i;
      this.mJ();
      this.Hf.setStringPainted(false);
      this.Hf.setForeground(this.GX);
      this.Hf.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      this.Hf.setMaximum(45);
      this.nc();
      this.mY();
   }

   private void mY() {
      try {
         this.a(this.Hr);
         this.a(this.ut);
         this.a(this.Hs);
      } catch (Exception var2) {
      }
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(112, 0), "f1");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(113, 0), "f2");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(114, 0), "f3");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 0), "f4");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(116, 0), "f5");
      if (GamePersistence.isRegisteredVersion()) {
         jComponent.getInputMap().put(KeyStroke.getKeyStroke(116, 0), "f6");
      }

      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0209(this));
      jComponent.getActionMap().put("f1", new C0211(this));
      jComponent.getActionMap().put("f2", new C0212(this));
      jComponent.getActionMap().put("f3", new C0266(this));
      jComponent.getActionMap().put("f4", new C0267(this));
      jComponent.getActionMap().put("f5", new C0268(this));
      jComponent.getActionMap().put("f6", new C0269(this));
   }

   private void setVelocidade(int i) {
      if (i < GameConstants.rz.length) {
         d = GameConstants.rz[i];
      }
   }

   public void Y(ArrayList arrayList) {
      GT = 0;
      vK.clear();
      dB = 1;
      this.GU = false;
      GZ = true;

      for (int var2 = 0; var2 < arrayList.size(); var2++) {
         boolean var3 = true;

         for (int var4 = 0; var4 < GamePersistence.careerState.getCurrentMatches().size(); var4++) {
            if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition() == arrayList.get(var2)) {
               if (var3) {
                  if (var2 == 0) {
                     this.a(((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition(), ((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetitionStage());
                  }

                  if (var2 != -1) {
                     C0827 var5 = new C0827();
                     var5.L(this.a(((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition(), (Match)GamePersistence.careerState.getCurrentMatches().get(var4), ((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetitionStage()));
                     vK.add(var5);
                  }

                  var3 = false;
               }

               C0827 var13 = new C0827();
               var13.n((Match)GamePersistence.careerState.getCurrentMatches().get(var4));
               var13.tW();
               if (var13.tR().getHomeClub() != null) {
                  var13.tR().getHomeClub().Q(var13.tR().getHomePlayersOnField());
                  var13.tR().getHomeClub().O(var13.tR().getHomePlayersOnField());
               }

               if (var13.tR().getAwayClub() != null) {
                  var13.tR().getAwayClub().Q(var13.tR().getAwayPlayersOnField());
                  var13.tR().getAwayClub().O(var13.tR().getAwayPlayersOnField());
               }

               if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition().b() == 7) {
                  Object var6 = null;
                  var13.p(var13.tR().ik());
               } else if (var13.tR().getStadium() == null) {
                  if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition().b() == 4) {
                     if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition() instanceof UefaChampionsLeague) {
                        var13.p(UefaChampionsLeague.yD());
                     } else if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition() instanceof CopaLibertadores) {
                        var13.p(CopaLibertadores.yD());
                     }
                  } else if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition().b() == 6) {
                     if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition() instanceof CopaSudamericana) {
                        var13.p(CopaSudamericana.yD());
                     } else if (((Match)GamePersistence.careerState.getCurrentMatches().get(var4)).getCompetition() instanceof UefaEuropaLeague) {
                        var13.p(UefaEuropaLeague.yD());
                     }
                  }
               }

               vK.add(var13);
            }
         }
      }

      boolean var8 = false;
      this.GW = -1;
      int var9 = 0;

      for (int var10 = 0; var10 < vK.size(); var10++) {
         if (((C0827)vK.get(var10)).ei()) {
            var8 = true;
            this.GW = var10;
            break;
         }
      }

      for (int var11 = 0; var11 < vK.size(); var11++) {
         if (((C0827)vK.get(var11)).ei()) {
            var9++;
         }
      }

      if (var8 && this.GW >= 0) {
         this.pZ();
      } else {
         this.Hr.setVisible(false);
      }

      int var12 = GamePersistence.careerState.getVelocidade();
      if (!var8) {
         var12 = GamePersistence.careerState.getVelocidadeNH();
      }

      if (var8) {
         d = GameConstants.rz[var12];
      } else {
         d = GameConstants.rA[var12];
      }

      if (GamePersistence.careerState.bD()) {
         d = 1;
      }

      GS.Hs.addNotify();
      if (this.GW >= 20) {
         JViewport var14 = (JViewport)GS.Hs.getParent();
         Rectangle var15 = GS.Hs.getCellRect(this.GW + 8, 0, true);
         Point var7 = var14.getViewPosition();
         var15.setLocation(var15.x - var7.x, var15.y - var7.y);
         GS.Hs.scrollRectToVisible(var15);
      }

      Hc = this.GW;
      this.qf();
      this.oR();
   }

   public void pZ() {
      this.Hr.setVisible(true);
      this.Hp.setBackground(((C0827)vK.get(this.GW)).tR().getHomeClub().kB());
      this.Hp.setForeground(((C0827)vK.get(this.GW)).tR().getHomeClub().kC());
      this.Hp.setText(((C0827)vK.get(this.GW)).tR().getHomeClub().getNome() + " ");
      this.Ho.setBackground(((C0827)vK.get(this.GW)).tR().getAwayClub().kB());
      this.Ho.setForeground(((C0827)vK.get(this.GW)).tR().getAwayClub().kC());
      this.Ho.setText(" " + ((C0827)vK.get(this.GW)).tR().getAwayClub().getNome());
      this.Hh.setIcon(((C0827)vK.get(this.GW)).tR().getHomeClub().kP());
      this.Hi.setIcon(((C0827)vK.get(this.GW)).tR().getAwayClub().kP());
      if (((C0827)vK.get(this.GW)).tR().getStadium() != null) {
         this.Hl.setText(((C0827)vK.get(this.GW)).tR().getStadium().dS());
         this.Hm.setText(Integer.toString(((C0827)vK.get(this.GW)).hU()));
      } else if (((C0827)vK.get(this.GW)).ik() != null) {
         this.Hl.setText(((C0827)vK.get(this.GW)).ik());
         this.Hm.setText("");
      } else {
         this.Hl.setText("");
         this.Hm.setText("");
      }

      this.Hj.setText("");
      this.Hk.setText("");
      this.Hj.setIcon(null);
      this.Hk.setIcon(null);
      this.Hn.setText("0 x 0");
      this.xI.setText("");
      if (((C0827)vK.get(this.GW)).tR().getCompetition() != null) {
         this.Ht.setText(this.a(((C0827)vK.get(this.GW)).tR().getCompetition(), ((C0827)vK.get(this.GW)).tR(), ((C0827)vK.get(this.GW)).tR().getCompetitionStage()));
      } else {
         this.Ht.setText("");
      }
   }

   private String a(Competition c0713, Match c0675, CompetitionStage c0678) {
      String var4 = "";
      if (c0713.b() == 3 && GamePersistence.careerState.isVerEstaduaisAgrupados()) {
         var4 = GameConstants.rZ[c0713.el()] + " - " + c0713.is() + " - " + c0675.hJ()[1];
      } else if (c0713.b() == 3) {
         var4 = c0713.is() + " - " + c0675.hJ()[1];
      } else if (c0713.b() == 1) {
         var4 = c0713.is() + " - " + c0675.hJ()[1];
         if (c0678 != null && c0678 instanceof KnockoutStage) {
            if (((KnockoutStage)c0678).zf() == 1099) {
               var4 = "Mata Mata Ascenso - " + c0675.hJ()[1];
            } else if (((KnockoutStage)c0678).zf() == 1098) {
               var4 = "Playoff rebaixamento - " + c0675.hJ()[1];
            }
         }
      } else if (c0713.b() == 10) {
         var4 = c0713.getNome() + " - " + c0675.hJ()[1];
      } else if (c0713.b() == 7 && c0713.el() != 7) {
         var4 = c0713.getNome() + " - " + c0675.hJ()[1];
      } else if (c0713.b() == 9) {
         if (c0713.el() < GameConstants.sa.length) {
            var4 = GameConstants.sa[c0713.el()] + " - " + c0675.hJ()[1];
         } else if (c0713.el() == 70) {
            var4 = "Classificatório Eurocopa - " + c0675.hJ()[1];
         }

         if (c0678 != null && c0678 instanceof LeagueStage && ((LeagueStage)c0678).ze() == 7701) {
            var4 = "Torneio Repescagem";
         }
      } else if (c0713 instanceof NationalSuperCup) {
         var4 = "Supercopa " + CountryInfo.bt(((NationalSuperCup)c0713).getPais());
      } else if (c0713.b() == 8) {
         var4 = c0713.getNome();
      } else {
         var4 = c0675.hJ()[1];
      }

      return var4;
   }

   private void a(Competition c0713, CompetitionStage c0678) {
      String var3 = "";
      if (c0713 != null) {
         if (c0713.b() == 3) {
            if (GamePersistence.careerState.isVerEstaduaisAgrupados()) {
               var3 = "Campeonatos estaduais";
            } else {
               var3 = "Campeonato " + GameConstants.rZ[c0713.el()];
            }
         } else if (c0713.b() == 1) {
            if (c0713.iq() != null) {
               var3 = "Campeonato " + CountryInfo.bs(c0713.iq().jc());
            }
         } else if (c0713.b() == 10) {
            var3 = "Regional";
         } else if (c0713.b() == 7 && c0713.el() != 7) {
            var3 = "Copas de Seleções";
         } else if (c0713.b() == 7 && c0713.el() == 7) {
            var3 = "Copas do Mundo";
         } else if (c0713.b() == 11) {
            var3 = "Supercopa Nacional";
         } else if (c0713.b() == 8) {
            var3 = "Recopa";
         } else if (c0713.b() == 9) {
            var3 = "Eliminatórias";
            if (c0678 != null && c0678 instanceof LeagueStage && ((LeagueStage)c0678).ze() == 7701) {
               var3 = "Eliminatórias - Repescagem";
            }
         } else {
            var3 = c0713.getNome();
         }
      }

      this.Hg.setText(var3);
   }

   public void oR() {
      if (this.GO == null) {
         this.GO = new Timer(d, new C0270(this));
         this.GO.setRepeats(false);
         this.GO.start();
      } else {
         this.GO.restart();
      }
   }

   public void qa() {
      boolean var1 = false;
      GT++;
      if (dB == 1) {
         if (GT > 48) {
            this.qg();
         }
      } else if (dB == 2 && GT >= 51) {
         var1 = true;
      }

      if (qj() < 45) {
         this.uh.setText(Integer.toString(qj()) + "'" + " - " + Integer.toString(dB) + "º tempo");
         this.Hf.setValue(qj());
      } else {
         this.uh.setText("Acréscimos");
      }

      if (var1) {
         this.uh.setText("Fim de jogo");
         this.qc();
      } else {
         this.aa(false);
      }
   }

   public static void qb() {
      try {
         for (int var0 = 0; var0 < He.length; var0++) {
            if (He[var0] != null) {
               He[var0].close();
               He[var0] = null;
            }
         }
      } catch (Exception var1) {
      }
   }

   private void qc() {
      if (!this.GU) {
         this.GU = true;
         this.dk(1);
         this.qe();
         this.qd();
         if (GY.size() > 0) {
            for (int var1 = 0; var1 < GY.size(); var1++) {
               this.g((Match)GY.get(var1));
            }
         }

         C0737.dJ();
      }
   }

   private void g(Match c0675) {
      if (!c0675.getHomeClub().isUserControlled() && !c0675.getAwayClub().isUserControlled()) {
         ArrayList var5 = new ArrayList();
         var5.addAll(c0675.getHomePlayersOnField());
         Collections.sort(var5, C1007.abg);
         zD = var5;
         ArrayList var3 = new ArrayList();
         var3.addAll(c0675.getAwayPlayersOnField());
         Collections.sort(var3, C1007.abg);
         zE = var3;
      } else {
         if (c0675.getHomeClub().isUserControlled()) {
            this.a(c0675, c0675.getHomeClub());
         } else {
            ArrayList var2 = new ArrayList();
            var2.addAll(c0675.getHomePlayersOnField());
            Collections.sort(var2, C1007.abg);
            zD = var2;
         }

         if (c0675.getAwayClub().isUserControlled()) {
            this.a(c0675, c0675.getAwayClub());
         } else {
            ArrayList var4 = new ArrayList();
            var4.addAll(c0675.getAwayPlayersOnField());
            Collections.sort(var4, C1007.abg);
            zE = var4;
         }
      }

      JDialog var6 = new JDialog(Br);
      C0113 var7 = new C0113(var6, c0675);
      var6.add(var7);
      var6.setSize(469, 602);
      var6.setPreferredSize(new Dimension(469, 602));
      var6.setModal(true);
      var6.setResizable(false);
      var6.setLocationRelativeTo(null);
      var6.setUndecorated(true);
      var6.setVisible(true);
   }

   private void a(Match c0675, Club club) {
      JDialog var3 = new JDialog(Br);
      C0003 var4 = new C0003(var3, club, c0675);
      var3.add(var4);
      var3.setSize(500, 519);
      var3.setPreferredSize(new Dimension(500, 519));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
   }

   private void qd() {
      GY.clear();

      for (int var1 = 0; var1 < vK.size(); var1++) {
         if (((C0827)vK.get(var1)).tR() != null && ((C0827)vK.get(var1)).tR().hS() && ((C0827)vK.get(var1)).tR().hk()) {
            if (!((C0827)vK.get(var1)).tR().getHomeClub().isUserControlled() && !((C0827)vK.get(var1)).tR().getAwayClub().isUserControlled()) {
               if (GamePersistence.careerState.getVerDecisaoPenNaoHumano() == 1) {
                  GY.add(((C0827)vK.get(var1)).tR());
               }
            } else {
               GY.add(((C0827)vK.get(var1)).tR());
            }
         }
      }
   }

   public void qe() {
      for (int var1 = 0; var1 < vK.size(); var1++) {
         boolean var2 = false;
         if (((C0827)vK.get(var1)).tR() != null && ((C0827)vK.get(var1)).tR().getHomeGoals() != ((C0827)vK.get(var1)).tT()) {
            var2 = true;
         }

         if (var2) {
            ((C0827)vK.get(var1)).tR().recalculateScoreFromEvents();
         }
      }
   }

   public File dj(int i) {
      return GamePersistence.getSoundFile(i);
   }

   private void qf() {
      if (GamePersistence.careerState.isUsaSons()) {
         for (int var1 = 0; var1 < this.Hd.length; var1++) {
            File var2 = this.dj(var1);
            if (var2 != null) {
               try {
                  this.Hd[var1] = AudioSystem.getAudioInputStream(var2);
               } catch (Exception var4) {
               }
            }
         }
      }
   }

   public void dk(int i) {
      if (GamePersistence.careerState.isUsaSons()) {
         Object var2 = null;
         if (i < this.Hd.length && this.Hd[i] != null) {
            if (He[i] == null) {
               try {
                  He[i] = AudioSystem.getClip();
                  He[i].open(this.Hd[i]);
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }

            if (He[i] != null) {
               try {
                  He[i].stop();
                  He[i].setFramePosition(0);
                  He[i].start();
               } catch (Exception var4) {
               }
            }
         }
      }
   }

   public void dl(int i) {
      if (GamePersistence.careerState.isUsaSons()) {
         AudioInputStream var2 = null;
         Clip var3 = null;

         try {
            File var4 = this.dj(i);
            if (var4 != null) {
               var2 = AudioSystem.getAudioInputStream(var4);
            }
         } catch (UnsupportedAudioFileException var7) {
            var7.printStackTrace();
         } catch (IOException var8) {
            var8.printStackTrace();
         }

         try {
            if (var2 != null) {
               var3 = AudioSystem.getClip();
               var3.open(var2);
               var3.start();
            }
         } catch (LineUnavailableException var5) {
            var5.printStackTrace();
         } catch (IOException var6) {
            var6.printStackTrace();
         }
      }
   }

   public boolean dm(int i) {
      if (!GamePersistence.careerState.isUsaSons()) {
         return false;
      }

      AudioInputStream var2 = null;

      try {
         File var3 = this.dj(i);
         if (var3 != null) {
            var2 = AudioSystem.getAudioInputStream(var3);
         }
      } catch (UnsupportedAudioFileException var6) {
         var6.printStackTrace();
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      try {
         if (var2 != null) {
            Clip var8 = AudioSystem.getClip();
            var8.open(var2);
            var8.start();
            var8.close();
         }
      } catch (LineUnavailableException var4) {
         var4.printStackTrace();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      return true;
   }

   public void qg() {
      GT = 0;
      dB = 2;
      if (GamePersistence.careerState.getVerJanelaSubs() == 1) {
         this.dk(0);
         this.uh.setText("Intervalo");

         for (int var1 = 0; var1 < vK.size(); var1++) {
            if (((C0827)vK.get(var1)).ei()) {
               this.e(var1, true);
            }
         }
      }

      for (int var2 = 0; var2 < vK.size(); var2++) {
         if (((C0827)vK.get(var2)).ei()) {
            ((C0827)vK.get(var2)).tR().m(2, 0);
         }
      }

      this.Hj.setText("");
      this.Hj.setIcon(null);
      this.Hk.setIcon(null);
      this.Hk.setText("");
   }

   public void aa(boolean bl) {
      if (!bl) {
         for (int var2 = 0; var2 < vK.size(); var2++) {
            if (((C0827)vK.get(var2)).ei()) {
               int[] var3 = ((C0827)vK.get(var2)).tR().ib();
               if (var3[dB] <= GT) {
                  ((C0827)vK.get(var2)).tR().q(GT, dB);
               }

               if (var2 == this.GW) {
                  this.xI.setText(((C0827)vK.get(var2)).tR().ha());
               }
            }
         }
      }

      for (int var4 = 0; var4 < vK.size(); var4++) {
         if (((C0827)vK.get(var4)).tR() != null) {
            for (int var5 = 0; var5 < ((C0827)vK.get(var4)).tR().getEvents().size(); var5++) {
               if (!((MatchEvent)((C0827)vK.get(var4)).tR().getEvents().get(var5)).isDone()
                  && ((MatchEvent)((C0827)vK.get(var4)).tR().getEvents().get(var5)).getPeriod() == dB
                  && ((MatchEvent)((C0827)vK.get(var4)).tR().getEvents().get(var5)).getMinute() <= GT) {
                  this.a((C0827)vK.get(var4), ((C0827)vK.get(var4)).tR(), (MatchEvent)((C0827)vK.get(var4)).tR().getEvents().get(var5), var4);
               }
            }
         }
      }

      if (GS.GV >= 0) {
         GZ = false;
         GS.e(GS.GV, false);
         GZ = true;
         GS.GV = -1;
      }

      GS.Hs.addNotify();
      if (GZ) {
         GS.oR();
      }
   }

   public void a(C0827 c0827, Match c0675, MatchEvent c0667, int i) {
      if (c0667.getType() == 8) {
         c0667.setDone(true);
      }

      if (!c0667.isDone()) {
         c0667.setDone(true);
         byte var5 = 0;
         if (c0667.getClub() == c0675.getHomeClub()) {
            var5 = 1;
         } else if (c0667.getClub() == c0675.getAwayClub()) {
            var5 = 2;
         }

         if (var5 > 0) {
            c0827.a(c0667);
            if (c0667.getType() == 1) {
               if (c0667.getSubtype() == 3 && c0827.ei()) {
                  this.dk(4);
                  if (!c0667.getClub().isUserControlled()) {
                     this.b(c0827, c0667);
                  } else {
                     this.a(c0827, c0667);
                  }

                  c0667.setConfirmed(true);
               } else {
                  c0827.dJ(var5);
                  if (c0827.ei()) {
                     if (c0667.getClub().isUserControlled()) {
                        this.dk(2);
                     } else {
                        this.dk(3);
                     }
                  }
               }
            } else if (c0667.getType() != 3 && c0667.getType() != 4) {
               if (c0667.getType() == 5) {
                  if (c0827.ei()) {
                     this.dk(6);
                  }

                  if (c0667.getClub().isUserControlled()) {
                     GS.e(i, false);
                  }
               }
            } else {
               if (c0827.ei()) {
                  this.dk(5);
               }

               if (c0667.getClub().isUserControlled()) {
                  GS.e(i, false);
               }
            }
         }

         GS.Hs.addNotify();
         if (this.Hr.isVisible() && this.GW >= 0 && this.GW == i) {
            this.Hn.setText(c0827.tT() + " x " + c0827.tU());
            if (var5 == 1) {
               this.Hj.setText(c0827.tV().getDisplayHtml());
               this.Hj.setIcon(c0827.tV().getIcon());
            } else {
               this.Hk.setText(c0827.tV().getDisplayHtml());
               this.Hk.setIcon(c0827.tV().getIcon());
            }
         }
      }
   }

   private void a(C0827 c0827, MatchEvent c0667) {
      ArrayList var3;
      if (c0667.getClub() == c0827.tR().getHomeClub()) {
         var3 = c0827.tR().getHomePlayersOnField();
      } else {
         var3 = c0827.tR().getAwayPlayersOnField();
      }

      JDialog var4 = new JDialog(Br);
      C0379 var5 = new C0379(var4, c0667, var3);
      var4.add(var5);
      var4.setSize(400, 350);
      var4.setPreferredSize(new Dimension(400, 350));
      var4.setModal(true);
      var4.setResizable(false);
      var4.setLocationRelativeTo(null);
      var4.setUndecorated(true);
      var4.setVisible(true);
      this.b(c0827, c0667);
   }

   private void b(C0827 c0827, MatchEvent c0667) {
      JDialog var3 = new JDialog(Br);
      C0373 var4 = new C0373(var3, c0827, c0667, c0667.getPrimaryPlayer(), this);
      var3.add(var4);
      var3.setSize(402, 202);
      var3.setPreferredSize(new Dimension(402, 202));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
   }

   public String h(Match c0675) {
      String var2 = null;
      int var3 = -1;
      var3 = c0675.getCompetition().b();
      if (var3 == 3) {
         var2 = c0675.getCompetition().getNome() + " " + c0675.getCompetition().ip();
      }

      return var2;
   }

   public void nc() {
      C0578 var1 = new C0578(this);
      this.Hs.setModel(var1);
      int[] var2 = new int[]{250, 200, 40, 40, 200, 300};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Hs.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Hs.setAutoResizeMode(3);
      this.Hs.setRowHeight(25);
      this.Hs.setTableHeader(null);
      this.Hs.setShowGrid(false);
      this.Hs.setDefaultRenderer(C0827.class, new C0599());
      this.Hs.setIntercellSpacing(new Dimension(5, 5));
      this.Hs.setAutoCreateRowSorter(false);
      this.Hs.setCellSelectionEnabled(false);
      this.Hs.setRowSelectionAllowed(false);
      this.Hs.setBackground(GameConstants.ot);
      this.Hs.setSelectionBackground(new Color(51, 102, 0));
      this.Hs.setFillsViewportHeight(true);
      this.mH();
   }

   private void qh() {
      if (Hc >= 0) {
         this.GV = Hc;
      }
   }

   private void mH() {
      this.Hs.addMouseListener(new C0271(this));
      C0210 var1 = new C0210(this);
      this.Hn.addMouseListener(var1);
      this.Ho.addMouseListener(var1);
      this.Hp.addMouseListener(var1);
      this.Hl.addMouseListener(var1);
      this.Hm.addMouseListener(var1);
      this.xI.addMouseListener(var1);
      this.Hh.addMouseListener(var1);
      this.Hi.addMouseListener(var1);
   }

   private void e(int i, boolean bl) {
      JDialog var3 = new JDialog(Br);
      C0137 var4 = new C0137(var3, (C0827)vK.get(i), bl);
      var3.add(var4);
      var3.setSize(966, 726);
      var3.setPreferredSize(new Dimension(1024, 663));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
   }

   public ArrayList qi() {
      return vK;
   }

   public static int qj() {
      return GT;
   }

   public static int en() {
      return dB;
   }

   public static ArrayList qk() {
      return zD;
   }

   public static ArrayList ql() {
      return zE;
   }

   public static void a(int i, ArrayList arrayList) {
      if (i == 1) {
         zD = arrayList;
      } else {
         zE = arrayList;
      }
   }

   public static Competition qm() {
      return Hb;
   }

   public static void v(Competition c0713) {
      Hb = c0713;
   }

   public static boolean qn() {
      return GZ;
   }

   public static void ab(boolean bl) {
      GZ = bl;
   }

   private void mJ() {
      this.Hq = new JPanel();
      this.Hg = new JLabel();
      this.Hf = new JProgressBar();
      this.uh = new JLabel();
      this.Hr = new JPanel();
      this.xI = new JLabel();
      this.Hn = new JLabel();
      this.Hh = new JLabel();
      this.Hi = new JLabel();
      this.Ho = new JLabel();
      this.Hp = new JLabel();
      this.Hk = new JLabel();
      this.Hm = new JLabel();
      this.Hj = new JLabel();
      this.Hl = new JLabel();
      this.Ht = new JLabel();
      this.zM = new JLabel();
      this.ut = new JScrollPane();
      this.Hs = new JTable();
      this.setBackground(GameConstants.ou);
      this.setPreferredSize(new Dimension(1024, 710));
      this.Hq.setBackground(GameConstants.ou);
      this.zM.setBackground(GameConstants.ou);
      this.zM.setOpaque(true);
      this.Hq.setOpaque(true);
      this.Hq.setPreferredSize(new Dimension(1024, 40));
      this.Hg.setFont(new Font("Tahoma", 1, 14));
      this.Hg.setForeground(new Color(255, 255, 153));
      this.Hg.setText("Informação da rodada");
      this.uh.setFont(new Font("Tahoma", 1, 12));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("Tempo");
      GroupLayout var1 = new GroupLayout(this.Hq);
      this.Hq.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.Hg, -2, 566, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, 92, 32767)
                  .addComponent(this.Hf, -2, 115, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.uh, -2, 160, -2)
                  .addGap(71, 71, 71)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addComponent(this.Hf, Alignment.LEADING, -1, -1, 32767)
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.TRAILING).addComponent(this.Hg, Alignment.LEADING).addComponent(this.uh, Alignment.LEADING)
                              )
                              .addGap(0, 3, 32767)
                        )
                  )
                  .addContainerGap()
            )
      );
      this.Hr.setBackground(new Color(0, 0, 0));
      this.Hr.setPreferredSize(new Dimension(1024, 40));
      this.Hr.setLayout(new C0807());
      this.xI.setForeground(new Color(255, 255, 255));
      this.xI.setHorizontalAlignment(0);
      this.xI.setText("Posse de bola");
      this.Hr.add(this.xI, new C0775(800, 4, 190, 120));
      this.Hn.setFont(new Font("Tahoma", 1, 24));
      this.Hn.setForeground(new Color(255, 255, 255));
      this.Hn.setHorizontalAlignment(0);
      this.Hn.setText("3 x  1");
      this.Hr.add(this.Hn, new C0775(430, 40, 100, -1));
      this.Hh.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.Hr.add(this.Hh, new C0775(170, 20, -1, -1));
      this.Hi.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.Hr.add(this.Hi, new C0775(725, 20, -1, -1));
      this.Ho.setFont(new Font("Tahoma", 1, 12));
      this.Ho.setForeground(new Color(255, 255, 255));
      this.Ho.setText("Tempo");
      this.Ho.setOpaque(true);
      this.Hr.add(this.Ho, new C0775(537, 40, 180, 30));
      this.Hp.setBackground(new Color(153, 153, 0));
      this.Hp.setFont(new Font("Tahoma", 1, 12));
      this.Hp.setForeground(new Color(255, 255, 255));
      this.Hp.setHorizontalAlignment(4);
      this.Hp.setText("Informação da rodada");
      this.Hp.setOpaque(true);
      this.Hr.add(this.Hp, new C0775(235, 40, 190, 30));
      this.Hk.setFont(new Font("Tahoma", 0, 12));
      this.Hk.setForeground(new Color(255, 255, 204));
      this.Hk.setHorizontalAlignment(2);
      this.Hr.add(this.Hk, new C0775(530, 90, 280, 30));
      this.Hm.setFont(new Font("Tahoma", 1, 12));
      this.Hm.setForeground(new Color(255, 255, 255));
      this.Hm.setHorizontalAlignment(4);
      this.Hm.setText("Informação da rodada");
      this.Hr.add(this.Hm, new C0775(10, 60, 150, -1));
      this.Hj.setFont(new Font("Tahoma", 0, 12));
      this.Hj.setForeground(new Color(255, 255, 204));
      this.Hj.setHorizontalAlignment(4);
      this.Hr.add(this.Hj, new C0775(110, 90, 300, 30));
      this.Hl.setFont(new Font("Tahoma", 1, 12));
      this.Hl.setForeground(new Color(255, 255, 255));
      this.Hl.setHorizontalAlignment(4);
      this.Hl.setText("Informação da rodada");
      this.Hr.add(this.Hl, new C0775(10, 40, 150, -1));
      this.Ht.setForeground(new Color(255, 255, 255));
      this.Ht.setHorizontalAlignment(0);
      this.Ht.setText("semifinal");
      this.Hr.add(this.Ht, new C0775(240, 10, 480, -1));
      this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/panelh.png")));
      this.zM.setToolTipText("");
      this.Hr.add(this.zM, new C0775(0, 0, 1008, 130));
      this.ut.setBackground(new Color(0, 51, 0));
      this.ut.setBorder(BorderFactory.createCompoundBorder());
      this.ut.setViewportView(this.Hs);
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addComponent(this.Hq, -2, -1, -2)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.Hr, -2, 1008, -2)
                        .addGroup(var2.createSequentialGroup().addComponent(this.ut).addGap(3, 3, 3))
                  )
                  .addGap(10, 10, 10)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addComponent(this.Hq, -2, -1, -2)
                  .addGap(0, 0, 0)
                  .addComponent(this.Hr, -2, 130, -2)
                  .addGap(20, 20, 20)
                  .addComponent(this.ut, -1, 438, 32767)
                  .addGap(20, 20, 20)
            )
      );
   }
}
