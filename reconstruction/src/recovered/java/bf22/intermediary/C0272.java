package bf22.intermediary;

import mod.recovered.transfer.PlayerLoan;
import mod.recovered.game.ScheduleDay;
import mod.recovered.transfer.TransferNegotiation;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.game.CareerState;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar.Separator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public class C0272 extends JPanel {
   private Club zu = null;
   private Player uz = null;
   private Club Hv = null;
   private Match bv = null;
   private int AT = 0;
   private boolean Hw = false;
   private JPopupMenu Hx = new JPopupMenu();
   private JPopupMenu afi = new JPopupMenu();
   final JPopupMenu Hy = new JPopupMenu();
   final JPopupMenu Hz = new JPopupMenu();
   final JPopupMenu HA = new JPopupMenu();
   final JPopupMenu HB = new JPopupMenu();
   JMenuItem HC = new JMenuItem("Propor contrato");
   JMenuItem HD = new JMenuItem("Vender Jogador");
   JMenuItem HE = new JMenuItem("Aposentar Jogador");
   JMenuItem HF = new JMenuItem("Escolher número");
   JMenuItem HG = new JMenuItem("Histórico do jogador");
   JMenuItem HH = new JMenuItem("Cancelar empréstimo");
   JMenuItem HI = new JMenuItem("Comprar jogador");
   JMenuItem HJ = new JMenuItem("Pôr para empréstimo");
   private JFrame Br;
   private int tR = 0;
   private boolean yp = false;
   private boolean HK = false;
   private static boolean afj = false;
   private static boolean afk = false;
   private static double HL = 0.1;
   private static Color HM = null;
   private static boolean HN = false;
   private static Competition HO = null;
   private static boolean HP = false;
   private static int HQ = 0;
   private JButton HR;
   private JButton HS;
   private JButton HT;
   private JButton HU;
   private JButton HV;
   private JButton HW;
   private JButton HX;
   private JButton yY;
   private JButton HY;
   private JButton afl;
   private JButton HZ;
   private JButton Ia;
   private JButton Ib;
   private JButton Ic;
   private JButton Id;
   private JButton Ie;
   private C0818 If;
   private JLabel ug;
   private JLabel Bj;
   private JLabel vw;
   private JLabel zb;
   private JLabel ze;
   private JLabel Ef;
   private JLabel Eg;
   private JLabel Eh;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JLabel vz;
   private JPanel wf;
   private JProgressBar Hf;
   private JProgressBar Ig;
   private Separator Ih;
   private Separator Ii;
   private Separator Ij;
   private Separator Ik;
   private Separator Il;
   private Separator OD;
   private Separator Im;
   private Separator In;
   private Separator Io;
   private Separator Ip;
   private Separator Iq;
   private Separator Ir;
   private Separator Is;
   private Separator It;
   private Separator Iu;
   private JToolBar ve;
   private JToolBar Iv;
   private JLabel Fq;
   private JLabel yt;
   private JLabel Iw;
   private JScrollPane Ix;
   private JTable Iy;

   public Club qp() {
      return this.zu;
   }

   public static double qq() {
      return HL;
   }

   public C0272(JFrame jFrame) {
      this.Br = jFrame;
      this.zu = CareerState.B();
      UIManager.put("ProgressBar.selectionForeground", this.zu.kC());
      UIManager.put("ProgressBar.selectionBackground", Color.black);
      this.bv = CareerState.bl();
      this.tR = this.bv.getCompetition().b();
      HM = this.zu.kB();
      if (this.bv != null) {
         if (this.bv.getHomeClub() == this.zu) {
            this.Hv = this.bv.getAwayClub();
            this.AT = 0;
         } else {
            this.Hv = this.bv.getHomeClub();
            this.AT = 1;
         }

         if (this.tR == 7) {
            this.HK = true;
            this.yp = true;
         }

         this.Hw = this.bv.ic();
      }

      this.zu.getCoach().jo();
      if (this.zu.getCoach().jo() == this.zu) {
         this.yp = true;
      }

      if (this.yp) {
         for (int var2 = 0; var2 < this.zu.getSeniorPlayers().size(); var2++) {
            ((Player)this.zu.getSeniorPlayers().get(var2)).b((JProgressBar)null);
         }
      }

      HN = this.yp;
      this.ry();
      this.mJ();
      this.rz();
      Float var3 = 0.2F;
      this.qs();
      this.qz();
      if (!this.yp) {
         this.qr();
      }

      if (this.yp) {
         this.Ie.setVisible(false);
         this.HY.setVisible(false);
         this.Ic.setVisible(false);
      }

      this.qv();
      this.qA();
      this.qB();
      this.AL();
      this.AM();
      this.rb();
      this.qD();
      this.mH();
      if (!GamePersistence.careerState.isHabilidadeIndividual() || this.yp) {
         this.Id.setVisible(false);
      }

      if (this.yp) {
         this.Iw.setVisible(false);
         this.ze.setVisible(false);
         this.HW.setVisible(false);
         this.HV.setVisible(false);
         this.ur.setVisible(false);
         this.us.setVisible(false);
         this.Hf.setVisible(false);
         this.Ig.setVisible(false);
      }

      this.mY();
      if (GamePersistence.isRegisteredVersion()) {
         this.Eh.setVisible(false);
      }

      if (!HP) {
         if (HQ > 10) {
            HP = true;
            C0726.ml();
         } else {
            HQ++;
         }
      }
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.Iy);
      this.a(this.HU);
      this.a(this.ve);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "enter");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "enter");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(113, 0), "f2");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(114, 0), "f3");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 0), "f4");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(117, 0), "f6");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(116, 0), "ctrlt");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(118, 0), "f7");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(119, 0), "f8");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(120, 0), "f9");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(121, 0), "f10");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(122, 0), "f11");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(84, 128, false), "ctrlt");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(70, 128, false), "ctrlf");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("enter", new C0273(this));
      jComponent.getActionMap().put("f2", new C0284(this));
      jComponent.getActionMap().put("ctrlt", new C0243(this));
      jComponent.getActionMap().put("ctrlf", new C0254(this));
      jComponent.getActionMap().put("f3", new C0265(this));
      jComponent.getActionMap().put("f4", new C0329(this));
      jComponent.getActionMap().put("f6", new C0338(this));
      jComponent.getActionMap().put("f7", new C0339(this));
      jComponent.getActionMap().put("f8", new C0340(this));
      jComponent.getActionMap().put("f9", new C0274(this));
      jComponent.getActionMap().put("f10", new C0275(this));
      jComponent.getActionMap().put("f11", new C0276(this));
   }

   public boolean ac(boolean bl) {
      ArrayList var2 = null;
      var2 = new ArrayList();
      if (bl) {
         int var3 = this.zu.kr();
         if (var3 <= 0) {
            return false;
         }
      }

      int var11 = -1;
      if (!bl) {
         for (int var4 = 0; var4 < this.zu.getSeniorPlayers().size(); var4++) {
            if (!((Player)this.zu.getSeniorPlayers().get(var4)).isOnLoan()) {
               var2.add((Player)this.zu.getSeniorPlayers().get(var4));
            }
         }

         Collections.shuffle(var2);
         var11 = new Random().nextInt(var2.size());
      } else {
         for (int var13 = 0; var13 < this.zu.getSeniorPlayers().size(); var13++) {
            if (!((Player)this.zu.getSeniorPlayers().get(var13)).isOnLoan() && ((Player)this.zu.getSeniorPlayers().get(var13)).isAvailableForLoan()) {
               var2.add((Player)this.zu.getSeniorPlayers().get(var13));
            }
         }

         Collections.shuffle(var2);
         var11 = new Random().nextInt(var2.size());
      }

      Player var14 = null;
      var14 = (Player)var2.get(var11);
      if (var14 != null) {
         TransferNegotiation var5 = new TransferNegotiation(var14, var14.getMarketValue(), true, true, 0);
         Club var6 = var5.findDestination(true, bl);
         int var7 = (int)(var14.getMarketValue() + Math.round(var14.getMarketValue() * 0.3));
         if (var6 != null) {
            JDialog var8 = new JDialog(this.Br);
            C0536 var9 = new C0536(var8, var14, var6, var7, bl);
            var8.add(var9);
            var8.setSize(403, 440);
            var8.setPreferredSize(new Dimension(403, 440));
            var8.setModal(true);
            var8.setResizable(false);
            var8.setLocationRelativeTo(null);
            var8.setUndecorated(true);
            var8.setVisible(true);
            if (C0536.sO()) {
               this.qI();
               this.qJ();
               this.pK();
               this.qH();
            }
         }
      }

      return true;
   }

   private void qr() {
      for (int var1 = 0; var1 < this.zu.getSeniorPlayers().size(); var1++) {
         ((Player)this.zu.getSeniorPlayers().get(var1)).aB(((Player)this.zu.getSeniorPlayers().get(var1)).getContractDaysRemaining());
      }

      if (GamePersistence.careerState.isAutoRenovaContrato()) {
         for (int var2 = 0; var2 < this.zu.getSeniorPlayers().size(); var2++) {
            if (((Player)this.zu.getSeniorPlayers().get(var2)).getContractDaysRemaining() <= 0) {
               ((Player)this.zu.getSeniorPlayers().get(var2)).renewContract(180L, true);
            }
         }
      }

      if (GamePersistence.careerState.getAvisoTerminoContrato() == 1 && !GamePersistence.careerState.isAutoRenovaContrato()) {
         for (int var4 = 0; var4 < this.zu.getSeniorPlayers().size(); var4++) {
            if (((Player)this.zu.getSeniorPlayers().get(var4)).getContractDaysRemaining() <= 0) {
               new C0799(this.zu.getCoach(), 17, 67, ((Player)this.zu.getSeniorPlayers().get(var4)).getNome(), "");
            }
         }
      } else if (GamePersistence.careerState.getAvisoTerminoContrato() == 2) {
         for (int var3 = 0; var3 < this.zu.getSeniorPlayers().size(); var3++) {
            if (!((Player)this.zu.getSeniorPlayers().get(var3)).gQ() && ((Player)this.zu.getSeniorPlayers().get(var3)).getContractDaysRemaining() < 31) {
               ((Player)this.zu.getSeniorPlayers().get(var3)).r(true);
               new C0799(this.zu.getCoach(), 16, 66, ((Player)this.zu.getSeniorPlayers().get(var3)).getNome(), "");
            }
         }
      }
   }

   private void qs() {
      HL = 0.1;
      if (new Random().nextInt(100) > 80) {
         HL = 0.15;
      }
   }

   public void s(Player player) {
      this.uz = player;
      this.qt();
   }

   private void qt() {
      if (this.uz != null && this.bv != null) {
         Competition var1 = this.bv.getCompetition();
         w(var1);
         this.If.a(this.uz, this.bv, var1, this.yp);
         new ImageIcon(this.getClass().getResource("/aflags/" + this.uz.getPais() + ".png"));
         String var3 = "";
         String var4 = this.uz.getContractEndDateLabel();
         String var5 = "Contrato até:";
         if (this.uz.isOnLoan()) {
            var5 = "Emprestado até:";
         }

         if (this.uz.isInjured() && this.uz.getInjuryEndTimeMillis() > ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime()) {
            var3 = "Fim contusão: " + ScheduleDay.a(this.uz.getInjuryEndTimeMillis());
         }

         int[] var6 = this.uz.e(this.bv.getCompetition());
         int[] var7 = new int[6];
         var7 = this.uz.gw();
         if (var6 == null) {
            var6 = new int[2];
         }

         String var8 = "";
         if (this.uz.c(var1)) {
            String var9 = "";
            if (var6[0] >= 3) {
               var9 = "3 cartões amarelos";
            }

            if (var6[1] == 1) {
               var9 = "1 jogo";
            } else if (var6[1] > 1) {
               var9 = Integer.toString(var6[1]) + " jogos";
            }

            var8 = "Suspenso " + var9;
         }

         String var12 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;" + Integer.toString(this.uz.getOverallStrength()) + "&nbsp;&nbsp;&nbsp;";
         if (GamePersistence.careerState.isHabilidadeIndividual()) {
            var12 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\"><b>Goleiro:</b> "
               + Integer.toString(this.uz.getGoalkeeping())
               + " <b>Desarme:</b> "
               + Integer.toString(this.uz.getTackling())
               + " <b>Passe:</b> "
               + Integer.toString(this.uz.getPassing())
               + " <br><br><b>Armação:</b> "
               + Integer.toString(this.uz.getPlaymaking())
               + " <b>Finalização:</b> "
               + Integer.toString(this.uz.getFinishing())
               + "<br><br><b>Velocidade:</b> "
               + Integer.toString(this.uz.getSpeed())
               + " <b>Técnica:</b> "
               + Integer.toString(this.uz.getTechnique());
         }

         if (this.yp) {
            var5 = "";
            var4 = "";
         }

         String var10 = var12
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n"
            + "<b>Jogos:"
            + "</b>&nbsp;"
            + Integer.toString(var7[0])
            + "&nbsp;&nbsp;&nbsp;"
            + "<b>Gols:"
            + "</b>"
            + Integer.toString(var7[1])
            + "&nbsp;&nbsp;&nbsp;"
            + "<b><br><br>"
            + "<b>Assistências:"
            + "</b>"
            + Integer.toString(var7[5])
            + "&nbsp;&nbsp;&nbsp;"
            + "<b>"
            + "&nbsp;&nbsp;&nbsp;"
            + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Valor:"
            + "</b>&nbsp;"
            + ClubFinances.formatAmount(this.uz.getMarketValue())
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>"
            + "Salário:"
            + "</b>&nbsp;"
            + ClubFinances.formatAmount(this.uz.getSalary())
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n"
            + "<b>"
            + var3
            + " "
            + var8
            + "<br><b>"
            + var5
            + " "
            + var4
            + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
            + "<b><br>\n</p>\n</body></html>\n";
         this.If.h(2, true);
         this.If.h(3, true);
         this.If.h(4, true);
         this.HC.setEnabled(true);
         this.HD.setEnabled(true);
         if (this.uz.getIdade() > 32) {
            this.If.h(4, true);
            this.HE.setEnabled(true);
         } else {
            this.If.h(4, false);
            this.HE.setEnabled(false);
         }

         if (!this.uz.isOnLoan() && !this.yp) {
            this.HH.setEnabled(false);
            this.HI.setEnabled(false);
            this.HJ.setEnabled(true);
            if (this.uz.isAvailableForLoan()) {
               this.HJ.setText("Não pôr para empréstimo");
            } else {
               this.HJ.setText("Pôr para empréstimo");
            }
         } else {
            this.If.h(1, false);
            this.If.h(2, false);
            this.If.h(3, false);
            this.If.h(4, false);
            this.HC.setEnabled(false);
            this.HD.setEnabled(false);
            this.HE.setEnabled(false);
            this.HH.setEnabled(true);
            this.HI.setEnabled(true);
            this.HJ.setEnabled(false);
         }

         if (this.yp) {
            this.HH.setEnabled(false);
            this.HI.setEnabled(false);
         }

         if (this.uz.isTransferListed()) {
            this.If.h(1, true);
            this.If.g(1, true);
         } else {
            this.If.h(1, false);
            this.If.g(1, false);
         }
      }
   }

   private void qu() {
      this.setBackground(this.zu.kB());
      UIManager.put("ProgressBar.selectionForeground", this.zu.kC());
      UIManager.put("ProgressBar.selectionBackground", Color.black);
      HM = this.zu.kB();
      this.wf.setBackground(this.zu.kB());
      this.Hf.setForeground(this.zu.kB());
      this.Ig.setForeground(this.zu.kB());
      this.Hf.setBorder(BorderFactory.createLineBorder(this.zu.kC(), 1));
      this.Ig.setBorder(BorderFactory.createLineBorder(this.zu.kC(), 1));
      this.Iv.setBackground(this.qp().kB());
      this.a_.setForeground(this.zu.kC());
      this.uh.setForeground(this.zu.kC());
      this.ur.setForeground(this.zu.kC());
      this.us.setForeground(this.zu.kC());
      this.vz.setForeground(this.zu.kB());
      this.vz.setBackground(this.zu.kC());
      this.vw.setForeground(this.zu.kC());
      this.Bj.setForeground(this.zu.kC());
      this.ug.setForeground(this.zu.kC());
      this.Ef.setForeground(this.zu.kC());
      this.Iw.setForeground(this.zu.kC());
      this.ze.setForeground(this.zu.kC());
      this.Eh.setForeground(this.zu.kC());
      this.If.setBorder(BorderFactory.createLineBorder(this.zu.kC()));
      this.If.oJ();
      this.Hf.setValue(this.zu.getCoach().lL());
      this.Ig.setValue(this.zu.getCoach().lM());
   }

   public void qv() {
      this.qu();
      this.ur.setFont(new Font("Tahoma", 1, 11));
      this.us.setFont(new Font("Tahoma", 1, 11));
      if (this.bv.getCompetition() != null) {
         String var1 = "";
         if (this.bv.getCompetitionStage() instanceof LeagueStage && ((LeagueStage)this.bv.getCompetitionStage()).zb() > 1) {
            int var2 = 0;
            var2 = ((LeagueStage)this.bv.getCompetitionStage()).Q(this.zu);
            if (var2 > 0) {
               var1 = " - " + Integer.toString(var2) + "º lugar";
            }
         }

         this.Bj.setText(this.bv.hI());
         if (this.bv.getCompetition() != null && this.bv.getCompetitionStage() != null && this.bv.getCompetition().b() == 1 && this.bv.getCompetitionStage() instanceof KnockoutStage) {
            if (((KnockoutStage)this.bv.getCompetitionStage()).zf() == 1099) {
               this.Bj.setText("Mata Mata Ascenso - " + this.bv.hJ()[1]);
            } else if (((KnockoutStage)this.bv.getCompetitionStage()).zf() == 1098) {
               this.Bj.setText("Playoff rebaixamento - " + this.bv.hJ()[1]);
            }
         }

         this.uh.setText(this.bv.getCompetition().getNome() + var1);
      } else {
         this.uh.setText("");
         this.Bj.setText("");
      }

      this.ug.setText(this.zu.getNome());
      this.a_.setText(this.zu.getCoach().dS());
      this.ze.setText("Mensagens");
      this.Hf.setValue(this.zu.getCoach().lL());
      this.Ig.setValue(this.zu.getCoach().lM());
      this.Eg.setText(GamePersistence.careerState.getCurrentDateText());
      if (!this.yp) {
         this.Fq.setIcon(this.zu.kP());
      } else {
         this.Fq.setIcon(this.zu.K(true));
      }

      this.vw.setIcon(null);
      String var4 = "";
      if (this.Hw) {
         var4 = " - clássico";
      }

      if (this.Hv != null) {
         String var6 = "";
         if (this.bv.getCompetitionStage() instanceof LeagueStage && ((LeagueStage)this.bv.getCompetitionStage()).zb() > 1) {
            int var3 = 0;
            var3 = ((LeagueStage)this.bv.getCompetitionStage()).Q(this.Hv);
            if (var3 > 0) {
               var6 = "(" + Integer.toString(var3) + "º)";
            }
         }

         String var8 = " - Casa";
         if (this.AT == 1) {
            var8 = " - Fora";
         }

         if (!this.yp) {
            this.yt.setIcon(this.Hv.kP());
         } else {
            this.yt.setIcon(this.Hv.K(true));
         }

         if (this.bv.getStadium() == null) {
            if (!this.yp) {
               var8 = " (campo neutro)";
            } else {
               var8 = "";
            }
         }

         this.vw.setText(this.Hv.getNome() + " " + var6);
         this.vz.setText("Próximo Jogo" + var8 + var4);
      }

      this.qy();
      this.qw();
      this.qJ();
   }

   private void qw() {
      int var1 = 0;
      this.ze.setText("");
      if (this.zu.getCoach().lQ() != null) {
         for (int var2 = 0; var2 < this.zu.getCoach().lQ().size(); var2++) {
            if (!((C0799)this.zu.getCoach().lQ().get(var2)).vo()) {
               var1++;
            }
         }

         String var3 = "Sem novas mensagens";
         if (var1 == 1) {
            var3 = "1 mensagens não lida";
         } else if (var1 > 1) {
            var3 = Integer.toString(var1) + " mensagens não lidas";
         }

         var3 = Integer.toString(var1);
         this.ze.setText(var3);
      }
   }

   private void qx() {
      this.Iw.setText(ClubFinances.formatAmount(this.zu.getCashBalance()));
   }

   private void qy() {
      if (GamePersistence.careerState.getSavedGameInfo() != null) {
         String var1;
         if (this.AT == 0) {
            var1 = "C - ";
         } else {
            var1 = "F - ";
         }

         GamePersistence.careerState.getSavedGameInfo().setClubName(this.zu.getCoach().dS());
         GamePersistence.careerState.getSavedGameInfo().setManagerName(this.zu.getNome());
         GamePersistence.careerState.getSavedGameInfo().setSeasonYear(GamePersistence.careerState.getSeasonNumber() + GamePersistence.careerState.getSeasonYearOffset());
         GamePersistence.careerState.getSavedGameInfo().setNextMatch(var1 + this.Hv.getNome() + " - " + this.Bj.getText());
      }
   }

   public void pK() {
      if (!this.yp) {
         this.Ef.setText(Integer.toString(this.zu.getSeniorPlayers().size()) + "/" + Integer.toString(35));
      } else {
         this.Ef.setText(Integer.toString(this.zu.getSeniorPlayers().size()));
      }
   }

   public void qz() {
      this.Iw.setCursor(new Cursor(12));
   }

   public void qA() {
      C0582 var1 = new C0582(this.zu, this);
      this.Iy.setModel(var1);
      int[] var2 = new int[]{20, 20, 20, 110, 20, 20, 60, 50, 50, 20, 45, 22, 20, 20, 25};
      int[] var3 = new int[]{20, 20, 20, 110, 20, 20, 20, 20, 20, 20, 20, 20, 60, 50, 50, 20, 45, 22, 20, 20, 25};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = var3;
      }

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.Iy.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.Iy.getColumnModel().getColumn(0).setMaxWidth(20);
      this.Iy.getColumnModel().getColumn(1).setMaxWidth(20);
      this.Iy.getColumnModel().getColumn(2).setMaxWidth(40);

      for (int var5 = 3; var5 < var2.length; var5++) {
         this.Iy.getColumnModel().getColumn(var5).setMaxWidth(var2[var5] + 15);
      }

      this.Iy.setAutoResizeMode(3);
      this.Iy.setRowHeight(20);
      this.Iy.setShowGrid(false);
      this.Iy.setDefaultRenderer(Player.class, new C0600());
      this.Iy.setAutoCreateRowSorter(false);
      this.Iy.getTableHeader().setReorderingAllowed(false);
      this.Iy.setRowHeight(20);
      this.Iy.setCellSelectionEnabled(false);
      this.Iy.setSelectionMode(0);
      this.Iy.setRowSelectionAllowed(true);
      this.Iy.setSelectionBackground(Color.YELLOW);
      this.Iy.setFillsViewportHeight(true);
      if (this.Iy.getRowCount() > 0) {
         this.Iy.setRowSelectionInterval(0, 0);
      }

      TableRowSorter var6 = new TableRowSorter<>(this.Iy.getModel());
      this.Iy.setRowSorter(var6);
      var6.setComparator(0, C1007.aaR);
      var6.setComparator(1, C1007.abe);
      var6.setComparator(3, C1007.abk);
      var6.setComparator(4, C1007.aba);
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         var6.setComparator(5, C1007.aaJ);
         var6.setComparator(6, C1007.aaS);
         var6.setComparator(7, C1007.aaZ);
         var6.setComparator(8, C1007.aaW);
         var6.setComparator(9, C1007.abb);
         var6.setComparator(11, C1007.VU);
         var6.setComparator(12, C1007.abd);
         var6.setComparator(13, C1007.abc);
         var6.setComparator(14, C1007.aab);
      } else {
         var6.setComparator(5, C1007.aaK);
         var6.setComparator(6, C1007.aaM);
         var6.setComparator(7, C1007.aaL);
         var6.setComparator(8, C1007.aaN);
         var6.setComparator(9, C1007.aaP);
         var6.setComparator(10, C1007.aaO);
         var6.setComparator(11, C1007.aaQ);
         var6.setComparator(12, C1007.aaS);
         var6.setComparator(13, C1007.aaZ);
         var6.setComparator(14, C1007.aaW);
         var6.setComparator(15, C1007.abb);
         var6.setComparator(17, C1007.VU);
         var6.setComparator(18, C1007.abd);
         var6.setComparator(19, C1007.abc);
         var6.setComparator(20, C1007.aab);
      }
   }

   private void qB() {
      this.Iy.getSelectionModel().addListSelectionListener(new C0277(this));
      this.Iy.addMouseListener(new C0278(this));
   }

   public void qC() {
      this.setCursor(new Cursor(3));
      MainWindow.a(this.uz, null);
      this.setCursor(new Cursor(12));
   }

   public void qD() {
      this.HC.addActionListener(new C0279(this));
      this.HB.add(this.HC);
      this.HB.addSeparator();
      this.HD.addActionListener(new C0280(this));
      this.HB.add(this.HD);
      this.HE.addActionListener(new C0281(this));
      this.HB.add(this.HE);
      this.HB.addSeparator();
      this.HF.addActionListener(new C0282(this));
      this.HB.add(this.HF);
      this.HB.addSeparator();
      this.HG.addActionListener(new C0283(this));
      this.HB.add(this.HG);
      this.HB.addSeparator();
      this.HH.addActionListener(new C0285(this));
      this.HB.add(this.HH);
      this.HI.addActionListener(new C0286(this));
      this.HB.add(this.HI);
      this.HB.addSeparator();
      this.HJ.addActionListener(new C0287(this));
      this.HB.add(this.HJ);
      this.Iy.setComponentPopupMenu(this.HB);
   }

   private void qE() {
      if (this.uz.isAvailableForLoan()) {
         this.uz.setAvailableForLoan(false);
         this.qt();
      } else {
         ArrayList var1 = GamePersistence.careerState.f(this.zu);
         int var2 = 0;
         if (var1 != null) {
            var2 = var1.size();
         }

         if (var2 + this.zu.kr() < 10) {
            this.uz.setAvailableForLoan(true);
            this.qt();
         } else {
            JOptionPane.showMessageDialog(null, "Limite de jogadores emprestáveis é de " + Integer.toString(10), "Limite de emprestados", 2);
         }
      }
   }

   private void qF() {
      if (this.uz != null && this.uz.isOnLoan() && this.zu.getCashBalance() >= this.uz.getMarketValue()) {
         int var1 = -1;
         var1 = JOptionPane.showConfirmDialog(this, "Deseja comprar o jogador " + this.uz.getNome() + "?", "Confirmar", 0);
         if (var1 == 0) {
            Club var2 = null;
            Object var3 = null;

            for (int var4 = 0; var4 < GamePersistence.careerState.bt().size(); var4++) {
               if (((PlayerLoan)GamePersistence.careerState.bt().get(var4)).getPlayer() == this.uz) {
                  var2 = ((PlayerLoan)GamePersistence.careerState.bt().get(var4)).getOriginalClub();
                  var3 = (PlayerLoan)GamePersistence.careerState.bt().get(var4);
                  break;
               }
            }

            GamePersistence.careerState.d(this.uz);
            this.uz.returnFromLoan(var2);
            this.uz.moveToClub(this.zu, this.uz.getMarketValue(), false, false, false);
            this.qJ();
            this.qI();
            this.qH();
         }
      }
   }

   private void qG() {
      PlayerLoan var1 = GamePersistence.careerState.e(this.uz);
      if (var1 != null) {
         int var2 = -1;
         var2 = JOptionPane.showConfirmDialog(this, "Deseja cancelar o empréstimo do jogador " + this.uz.getNome() + "?", "Confirmar", 0);
         if (var2 == 0) {
            if (var1.returnToOriginalClub()) {
               GamePersistence.careerState.d(var1.getPlayer());
               this.pK();
               this.qI();
               this.qH();
            } else {
               JOptionPane.showMessageDialog(this.Br, "Não há vagas no time de origem", "", 2);
            }
         }
      }
   }

   private void qH() {
      this.qt();
      this.Iy.addNotify();
   }

   private void qI() {
      ((C0582)this.Iy.getModel()).fireTableDataChanged();
      if (this.Iy.getRowCount() > 0) {
         this.Iy.setRowSelectionInterval(0, 0);
      } else {
         this.uz = null;
      }
   }

   private void qJ() {
      this.pK();
      this.qx();
      this.qL();
      Collections.sort(this.zu.getSeniorPlayers(), C1007.abe);
   }

   private void qK() {
      for (int var1 = 0; var1 < this.zu.getSeniorPlayers().size(); var1++) {
         ((Player)this.zu.getSeniorPlayers().get(var1)).b((JProgressBar)null);
      }
   }

   private void qL() {
      for (int var1 = 0; var1 < this.zu.getSeniorPlayers().size(); var1++) {
         if (this.tR != 0) {
            ((Player)this.zu.getSeniorPlayers().get(var1)).ax(((Player)this.zu.getSeniorPlayers().get(var1)).d(this.bv.getCompetition()));
         }
      }
   }

   private void qM() {
      JDialog var1 = new JDialog(this.Br);
      C0164 var2 = new C0164(var1, this.zu);
      var1.add(var2);
      var1.setSize(570, 433);
      var1.setPreferredSize(new Dimension(570, 433));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.pack();
      var1.setVisible(true);
      this.Iy.addNotify();
   }

   private void AI() {
      MainWindow.l(this.zu.getCoach());
      if (afk) {
         this.Hx = new JPopupMenu();
         this.AL();
         this.afi = new JPopupMenu();
         this.AM();
         afk = false;
      }
   }

   private void AJ() {
      boolean var1 = true;
      if (GamePersistence.careerState.isJogaSelecoesAll()) {
         for (int var3 = 0; var3 < GamePersistence.careerState.M().size(); var3++) {
            if (!var1) {
               if (((Coach)GamePersistence.careerState.M().get(var3)).isUserControlled() && ((Coach)GamePersistence.careerState.M().get(var3)).jo() == null) {
                  ArrayList var2 = GamePersistence.coachJobMarket.a((Coach)GamePersistence.careerState.M().get(var3), var1);
                  if (!GamePersistence.careerState.bD() && var2 != null && var2.size() > 0) {
                     MainWindow.a(var2, (Coach)GamePersistence.careerState.M().get(var3), 1);
                  }
               }
            } else if (((Coach)GamePersistence.careerState.M().get(var3)).isUserControlled()) {
               ArrayList var4 = GamePersistence.coachJobMarket.a((Coach)GamePersistence.careerState.M().get(var3), var1);
               if (!GamePersistence.careerState.bD() && var4 != null && var4.size() > 0) {
                  MainWindow.a(var4, (Coach)GamePersistence.careerState.M().get(var3), 1);
               }
            }
         }
      }
   }

   public void mH() {
      this.HX.addActionListener(new C0288(this));
      this.HR.addActionListener(new C0289(this));
      this.afl.addActionListener(new C0290(this));
      this.Ia.addActionListener(new C0291(this));
      this.HZ.addActionListener(new C0240(this));
      this.HV.addActionListener(new C0241(this));
      this.HU.addActionListener(new C0242(this));
      this.HW.addActionListener(new C0244(this));
      this.Ib.addActionListener(new C0245(this));
      this.HS.addActionListener(new C0246(this));
      this.yY.addActionListener(new C0247(this));
      this.Id.addActionListener(new C0248(this));
      this.Iw.addMouseListener(new C0249(this));
      this.ze.addMouseListener(new C0250(this));
      this.zb.addMouseListener(new C0251(this));
      this.vw.addMouseListener(new C0252(this));
      this.yt.addMouseListener(new C0253(this));
      this.HT.addActionListener(new C0255(this));
      this.Ie.addActionListener(new C0256(this));
      this.HY.addActionListener(new C0257(this));
      this.Ic.addActionListener(new C0258(this));
   }

   public void AK() {
      for (int var1 = 0; var1 < GamePersistence.careerState.aG().size(); var1++) {
         int var2 = ((CountryCompetitions)GamePersistence.careerState.aG().get(var1)).As().AW();
         if (var2 > 0) {
            System.out.println(((CountryCompetitions)GamePersistence.careerState.aG().get(var1)).jp() + ":" + var2);
         }
      }
   }

   private void qN() {
      long var1 = 0L;
      long var3 = 0L;
      var1 = System.currentTimeMillis();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 < 5; var6++) {
         C0680 var7 = new C0680();
         String var8 = "";
         if (var7.iA() != null) {
            var8 = var7.iA().getNome();
         }

         String var9 = "";
         if (var7.iz() != null) {
            var9 = var7.iz().getNome();
         }

         System.out.println("Leilao: " + var8 + " " + var9);
         if (var7.iA() != null) {
            var5.add(var7);
         }
      }

      var3 = System.currentTimeMillis() - var1;
      C0238.X(var5);
      JDialog var12 = new JDialog(this.Br);
      C0238 var13 = new C0238(var12);
      var12.add(var13);
      var12.setSize(941, 718);
      var12.setPreferredSize(new Dimension(941, 718));
      var12.setModal(true);
      var12.setResizable(false);
      var12.setLocationRelativeTo(null);
      var12.setUndecorated(true);
      var12.setVisible(true);
   }

   private void qO() {
      this.HY.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.Br);
      C0125 var2 = new C0125(var1, this.zu);
      var1.add(var2);
      var1.setSize(737, 600);
      var1.setPreferredSize(new Dimension(737, 600));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HY.setCursor(new Cursor(12));
      if (C0125.nX()) {
         this.qI();
         this.qJ();
         this.qH();
      }
   }

   private void qP() {
      this.HY.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.Br);
      C0447 var2 = new C0447(var1, this.zu);
      var1.add(var2);
      var1.setSize(740, 684);
      var1.setPreferredSize(new Dimension(740, 684));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HY.setCursor(new Cursor(12));
   }

   private void qQ() {
      Color var1 = this.zu.kB();
      Color var2 = this.zu.kC();
      JDialog var3 = new JDialog(this.Br);
      C0108 var4 = new C0108(var3, this.zu);
      var3.add(var4);
      var3.setSize(308, 315);
      var3.setPreferredSize(new Dimension(308, 315));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
      if (var1 != this.zu.kB() || var2 != this.zu.kC()) {
         this.qK();
         this.qu();
         this.Iy.addNotify();
      }
   }

   public void qR() {
      this.uz.setTransferListed(false);
      this.uz.resetAskingPriceToMarketValue();
      this.Iy.addNotify();
      this.If.g(1, false);
   }

   public void qS() {
      JDialog var1 = new JDialog(this.Br);
      C0343 var2 = new C0343(var1, this.uz);
      var1.add(var2);
      var1.setSize(357, 330);
      var1.setPreferredSize(new Dimension(357, 330));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.Iy.addNotify();
      this.qt();
   }

   private void qT() {
      Club var1 = this.zu;
      if (this.yp) {
         var1 = this.zu.getCoach().getClub();
      }

      if (var1 != null) {
         this.Iw.setCursor(new Cursor(3));
         JDialog var2 = new JDialog(this.Br);
         C0156 var3 = new C0156(var2, var1);
         var2.add(var3);
         var2.setSize(398, 637);
         var2.setPreferredSize(new Dimension(398, 637));
         var2.setModal(true);
         var2.setResizable(false);
         var2.setLocationRelativeTo(null);
         var2.setUndecorated(true);
         var2.setVisible(true);
         this.Iw.setCursor(new Cursor(12));
         this.qx();
      }
   }

   private void qU() {
      Club var1 = this.zu;
      if (this.yp) {
         var1 = this.zu.getCoach().getClub();
      }

      if (var1 != null) {
         JDialog var2 = new JDialog(this.Br);
         C0468 var3 = new C0468(var2, var1);
         var2.add(var3);
         var2.setSize(409, 252);
         var2.setPreferredSize(new Dimension(409, 252));
         var2.setModal(true);
         var2.setResizable(false);
         var2.setLocationRelativeTo(null);
         var2.setUndecorated(true);
         var2.setVisible(true);
      }
   }

   private void dn(int i) {
      int var2 = this.zu.getSeniorPlayers().size();
      JDialog var3 = new JDialog(this.Br);
      C0395 var4 = new C0395(var3, this.zu, this.yp, i);
      short var5 = 820;
      short var6 = 620;
      if (i == 2) {
         var5 = 840;
         var6 = 670;
      }

      var3.add(var4);
      var3.setSize(var5, var6);
      var3.setPreferredSize(new Dimension(var5, var6));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
      if (var2 != this.zu.getSeniorPlayers().size()) {
         this.qI();
         this.qJ();
         this.qH();
      }
   }

   public void on() {
      this.Iy.requestFocusInWindow();
   }

   private void qV() {
      Competition var1 = this.bv.getCompetition();
      MainWindow.a(this.tR, var1);
   }

   public void qW() {
      if (this.uz != null) {
         JDialog var1 = new JDialog(this.Br);
         C0532 var2 = new C0532(var1, this.zu, this.uz);
         var1.add(var2);
         var1.setSize(402, 374);
         var1.setPreferredSize(new Dimension(402, 374));
         var1.setModal(true);
         var1.setResizable(false);
         var1.setLocationRelativeTo(null);
         var1.setUndecorated(true);
         var1.setVisible(true);
         if (C0532.nX()) {
            this.qI();
            this.qJ();
            this.qH();
         }
      }
   }

   public void qX() {
      if (this.uz != null) {
         JDialog var1 = new JDialog(this.Br);
         C0526 var2 = new C0526(var1, this.uz);
         var1.add(var2);
         var1.setSize(395, 420);
         var1.setPreferredSize(new Dimension(395, 420));
         var1.setModal(true);
         var1.setResizable(false);
         var1.setLocationRelativeTo(null);
         var1.setUndecorated(true);
         var1.setVisible(true);
         if (C0526.sN()) {
            this.qI();
            this.qJ();
            this.pK();
            this.qH();
         } else if (this.uz.isTransferListed()) {
            this.If.h(1, true);
            this.If.g(1, true);
            this.Iy.addNotify();
         }
      }
   }

   public void qY() {
      JDialog var1 = new JDialog(this.Br);
      C0231 var2 = new C0231(var1, this.zu, this.zu);
      var1.add(var2);
      var1.setSize(763, 568);
      var1.setPreferredSize(new Dimension(763, 568));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      if (C0231.nX()) {
         this.qI();
         this.qJ();
         this.qH();
      }

      UIManager.put("ProgressBar.selectionForeground", this.zu.kC());
      UIManager.put("ProgressBar.selectionBackground", Color.black);
   }

   public void qZ() {
      this.HU.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.Br);
      C0132 var2 = new C0132(var1, this.zu, CareerState.bl(), this.yp);
      if (!MainWindow.iI()) {
         var1.add(var2);
      } else {
         JScrollPane var3 = new JScrollPane();
         var3.setViewportView(var2);
         var1.add(var3);
      }

      var1.setSize(1024, 748);
      var1.setPreferredSize(new Dimension(1024, 748));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HU.setCursor(new Cursor(12));
   }

   public void ra() {
      if (!this.yp) {
         JDialog var1 = new JDialog(this.Br);
         C0171 var2 = new C0171(var1, this.zu.getStadium(), this.tR, this.zu);
         var1.add(var2);
         var1.setSize(598, 328);
         var1.setPreferredSize(new Dimension(598, 328));
         var1.setModal(true);
         var1.setResizable(false);
         var1.setLocationRelativeTo(null);
         var1.setUndecorated(true);
         var1.setVisible(true);
         this.qx();
      }
   }

   public void AL() {
      JMenuItem var1 = new JMenuItem("Jogos do seu time");
      var1.addActionListener(new C0259(this));
      var1.setAccelerator(KeyStroke.getKeyStroke(115, 0));
      this.Hx.add(var1);
      this.Hx.addSeparator();
      JMenuItem var2 = new JMenuItem("Jogos Amistosos");
      var2.addActionListener(new C0260(this));
      var2.setAccelerator(KeyStroke.getKeyStroke(120, 0));
      this.Hx.add(var2);
      this.Hx.addSeparator();
      JMenuItem var3 = new JMenuItem("Central de Empregos");
      var3.addActionListener(new C0261(this));
      this.Hx.add(var3);
      if (this.HK || afj) {
         var3.setEnabled(false);
      }
   }

   public void AM() {
      JMenuItem var1 = new JMenuItem("Jogos Amistosos Seleção");
      var1.addActionListener(new C0262(this));
      this.afi.add(var1);
      this.afi.addSeparator();
      JMenuItem var2 = new JMenuItem("Calendário da seleção");
      var2.addActionListener(new C0263(this));
      this.afi.add(var2);
      this.afi.addSeparator();
      if (this.qp().getCoach().jo() == null) {
         var1.setEnabled(false);
         var2.setEnabled(false);
      }

      JMenuItem var3 = new JMenuItem("Convocar Seleção");
      var3.addActionListener(new C0264(this));
      this.afi.add(var3);
      this.afi.addSeparator();
      JMenuItem var4 = new JMenuItem("Pedir demissão da seleção");
      var4.addActionListener(new C0319(this));
      this.afi.add(var4);
      if (this.qp().getCoach().jo() == null || this.HK) {
         var3.setEnabled(false);
         var4.setEnabled(false);
      }

      if (this.qp().getCoach().jo() != null) {
         this.afl.setVisible(true);
         this.afl.setIcon(this.qp().getCoach().jo().K(true));
      } else {
         this.afl.setVisible(false);
      }
   }

   public void rb() {
      JMenuItem var1 = new JMenuItem("Salvar jogo");
      var1.addActionListener(new C0320(this));
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aicons/save1.png"));
      var1.setIcon(var2);
      var1.setAccelerator(KeyStroke.getKeyStroke(113, 0));
      this.Hy.add(var1);
      this.Hy.addSeparator();
      JMenuItem var3 = new JMenuItem("Preferências");
      var3.addActionListener(new C0321(this));
      ImageIcon var4 = new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png"));
      var3.setIcon(var4);
      var3.setAccelerator(KeyStroke.getKeyStroke(114, 0));
      this.Hy.add(var3);
      this.Hy.addSeparator();
      JMenuItem var5 = new JMenuItem("Pedir demissão");
      var5.addActionListener(new C0322(this));
      ImageIcon var6 = new ImageIcon(this.getClass().getResource("/aicons/iconfire.png"));
      var5.setIcon(var6);
      this.Hy.add(var5);
      this.Hy.addSeparator();
      JMenuItem var7 = new JMenuItem("Sair do jogo");
      var7.addActionListener(new C0323(this));
      this.Hy.add(var7);
      this.Hy.addSeparator();
      JMenuItem var8 = new JMenuItem("Sobre o Brasfoot");
      var8.addActionListener(new C0324(this));
      this.Hy.add(var8);
      JMenuItem var9 = new JMenuItem("Ranking de técnicos");
      var9.addActionListener(new C0325(this));
      this.Hz.add(var9);
      this.Hz.addSeparator();
      JMenuItem var10 = new JMenuItem("Adicionar/remover técnicos");
      var10.addActionListener(new C0326(this));
      this.Hz.add(var10);
      this.Hz.addSeparator();
      JMenuItem var11 = new JMenuItem("Últimas trocas de técnicos");
      var11.addActionListener(new C0327(this));
      this.Hz.add(var11);
      this.Hz.addSeparator();
      JMenuItem var12 = new JMenuItem("Troféus do Técnico");
      var12.addActionListener(new C0328(this));
      this.Hz.add(var12);
      JMenuItem var13 = new JMenuItem("Campeões");
      var13.addActionListener(new C0330(this));
      var13.setAccelerator(KeyStroke.getKeyStroke(121, 0));
      this.HA.add(var13);
      this.HA.addSeparator();
      JMenuItem var14 = new JMenuItem("Ranking Clubes");
      var14.addActionListener(new C0331(this));
      this.HA.add(var14);
      this.HA.addSeparator();
      if (GamePersistence.careerState.isJogaSelecoesAll()) {
         JMenuItem var15 = new JMenuItem("Ranking Seleções");
         var15.addActionListener(new C0332(this));
         this.HA.add(var15);
         this.HA.addSeparator();
      }

      JMenuItem var21 = new JMenuItem("Artilheiros");
      var21.addActionListener(new C0333(this));
      var21.setAccelerator(KeyStroke.getKeyStroke(122, 0));
      this.HA.add(var21);
      this.HA.addSeparator();
      JMenuItem var16 = new JMenuItem("Líderes de Assistências");
      var16.addActionListener(new C0334(this));
      this.HA.add(var16);
      this.HA.addSeparator();
      if (!this.yp) {
         JMenuItem var17 = new JMenuItem("Galeria de Troféus");
         var17.addActionListener(new C0335(this));
         this.HA.add(var17);
         this.HA.addSeparator();
      }

      if (!this.yp) {
         JMenuItem var22 = new JMenuItem("Time da Rodada");
         var22.addActionListener(new C0336(this));
         this.HA.add(var22);
         this.HA.addSeparator();
         JMenuItem var18 = new JMenuItem("Time do Ano");
         var18.addActionListener(new C0337(this));
         this.HA.add(var18);
         this.HA.addSeparator();
         JMenuItem var19 = new JMenuItem("Bola de Ouro");
         var19.addActionListener(new C0473(this));
         this.HA.add(var19);
         this.HA.addSeparator();
         JMenuItem var20 = new JMenuItem("Transferências de Jogadores");
         var20.addActionListener(new C0474(this));
         this.HA.add(var20);
         this.HA.addSeparator();
      }

      JMenuItem var23 = new JMenuItem("Histórico de confrontos");
      var23.addActionListener(new C0541(this));
      this.HA.add(var23);
   }

   private void rc() {
      Club var1 = this.zu.getCoach().jo();
      if (var1 != null) {
         MainWindow.a(var1, false);
         this.qA();
         if (this.Iy.getRowCount() > 0) {
            this.Iy.setRowSelectionInterval(0, 0);
         }

         this.pK();
         this.qH();
      }
   }

   private void rd() {
      MainWindow.cX();
   }

   public void G(Club club) {
      int var2 = this.zu.getSeniorPlayers().size();
      Club var3 = this.zu;
      if (this.yp) {
         var3 = this.zu.getCoach().getClub();
      } else if (club != null) {
         var3 = club;
      }

      if (var3 != null) {
         MainWindow.a(var3, this.zu, this.yp);
      }

      if (var2 != this.zu.getSeniorPlayers().size()) {
         this.qI();
         this.qJ();
         this.qH();
      }
   }

   public void ad(boolean bl) {
      Club var2 = null;
      if (!bl) {
         var2 = this.zu.getCoach().getClub();
      } else {
         var2 = this.zu.getCoach().jo();
      }

      if (var2 != null) {
         JDialog var3 = new JDialog(this.Br);
         C0012 var4 = new C0012(var3, var2);
         var3.add(var4);
         var3.setSize(820, 600);
         var3.setPreferredSize(new Dimension(820, 600));
         var3.setModal(true);
         var3.setResizable(false);
         var3.setLocationRelativeTo(null);
         var3.setUndecorated(true);
         var3.setVisible(true);
      }
   }

   public void re() {
      Club var1 = this.zu.getCoach().getClub();
      if (var1 != null) {
         MainWindow.w(this.zu.getCoach().getClub());
      }

      this.qx();
   }

   public void rf() {
      Club var1 = this.zu.getCoach().jo();
      if (var1 != null) {
         MainWindow.x(var1);
      }
   }

   public void rg() {
      JDialog var1 = new JDialog(this.Br);
      C0008 var2 = new C0008(var1, this.zu.kF(), GamePersistence.careerState.o(this.zu.getPais()));
      var1.add(var2);
      var1.setSize(1020, 680);
      var1.setPreferredSize(new Dimension(1020, 680));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void method_kw_do(int i) {
      MainWindow.a(this.zu.kF(), GamePersistence.careerState.o(this.zu.getPais()), i);
   }

   public void rh() {
      Club var1 = this.zu;
      JDialog var2 = new JDialog(this.Br);
      C0039 var3 = new C0039(var2, var1, this.Hv, this.yp);
      var2.add(var3);
      var2.setSize(617, 456);
      var2.setPreferredSize(new Dimension(617, 456));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public void dp(int i) {
      JDialog var2 = new JDialog(this.Br);
      C0401 var3 = new C0401(var2, this.zu, i);
      var2.add(var3);
      var2.setSize(695, 500);
      var2.setPreferredSize(new Dimension(695, 500));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public void ri() {
      JDialog var1 = new JDialog(this.Br);
      C0427 var2 = new C0427(var1, this.zu);
      var1.add(var2);
      var1.setSize(825, 602);
      var1.setPreferredSize(new Dimension(825, 602));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void AN() {
      JDialog var1 = new JDialog(this.Br);
      C0545 var2 = new C0545(var1, this.zu);
      var1.add(var2);
      var1.setSize(432, 666);
      var1.setPreferredSize(new Dimension(432, 666));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void rj() {
      JDialog var1 = new JDialog(this.Br);
      C0564 var2 = new C0564(var1, this.zu);
      var1.add(var2);
      var1.setSize(596, 608);
      var1.setPreferredSize(new Dimension(596, 608));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void rk() {
      JDialog var1 = new JDialog(this.Br);
      C0554 var2 = new C0554(var1);
      var1.add(var2);
      var1.setSize(758, 616);
      var1.setPreferredSize(new Dimension(758, 616));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void rl() {
      JDialog var1 = new JDialog(this.Br);
      C0018 var2 = new C0018(var1);
      var1.add(var2);
      var1.setSize(848, 628);
      var1.setPreferredSize(new Dimension(848, 628));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void rm() {
      JDialog var1 = new JDialog(this.Br);
      C0120 var2 = new C0120(var1, this.zu.getCoach().lQ(), this.zu);
      var1.add(var2);
      var1.setSize(894, 391);
      var1.setPreferredSize(new Dimension(894, 391));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.qw();
   }

   public void rn() {
      JDialog var1 = new JDialog(this.Br);
      C0493 var2 = new C0493(var1);
      var1.add(var2);
      var1.setSize(487, 422);
      var1.setPreferredSize(new Dimension(487, 422));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public void ro() {
      JDialog var1 = new JDialog(this.Br);
      C0369 var2 = new C0369(var1, this.zu.getCoach());
      var1.add(var2);
      var1.setSize(880, 663);
      var1.setPreferredSize(new Dimension(880, 663));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public boolean rp() {
      GamePersistence.careerState.ad();
      JDialog var1 = new JDialog(this.Br);
      C0539 var2 = new C0539(var1);
      var1.add(var2);
      var1.setSize(496, 185);
      var1.setPreferredSize(new Dimension(496, 185));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      return true;
   }

   public void rq() {
      System.exit(0);
   }

   public void rr() {
      if (this.yp) {
         this.rs();
      } else {
         int var1 = -1;
         var1 = JOptionPane.showConfirmDialog(this.Br, "Deseja realmente ser demitido?", "Confirmação", 0);
         if (var1 == 0) {
            Coach var2 = this.zu.getCoach();
            Coach var3 = this.zu.kE();
            if (var3 == null) {
               JOptionPane.showMessageDialog(
                  null, "A diretoria ainda não achou um técnico a sua altura. Tente se demitir em outro momento.", "Demissão recusada", 2
               );
            } else {
               MainWindow.a(var2, var3, this.zu, 0);
               GamePersistence.careerState.g(true);
               GamePersistence.careerState.ap();
            }
         }
      }
   }

   public void rs() {
      int var1 = -1;
      var1 = JOptionPane.showConfirmDialog(this.Br, "Deseja realmente ser demitido da seleção?", "Confirmação", 0);
      if (var1 == 0) {
         int var2 = -1;
         if (this.zu.getCoach().jo() != null) {
            var2 = this.zu.getCoach().jo().getPais();
         }

         CountryCompetitions var3 = GamePersistence.careerState.s(var2);
         if (var3 != null) {
            Coach var4 = this.zu.getCoach();
            Coach var5 = var3.ji();
            var3.z(false);
            var4.z(null);
            var3.jo().h(null);
            var3.jo().k(false);
            var3.g(var5);
            afk = false;
            afj = false;
            this.afi = new JPopupMenu();
            this.AM();
            if (this.yp) {
               MainWindow.a(var4, var5, this.zu, 0);
               GamePersistence.careerState.ap();
            }
         }
      }
   }

   public void rt() {
      if (GamePersistence.careerState.getSaveName() == null) {
         JDialog var1 = new JDialog(this.Br);
         C0341 var2 = new C0341(var1);
         var1.add(var2);
         var1.setSize(494, 192);
         var1.setPreferredSize(new Dimension(494, 192));
         var1.setModal(true);
         var1.setResizable(false);
         var1.setLocationRelativeTo(null);
         var1.setVisible(true);
      }
   }

   public void ru() {
      if (GamePersistence.careerState.getSaveName() == null) {
         this.rt();
      }

      if (GamePersistence.careerState.getSaveName() != null) {
         this.Br.setCursor(new Cursor(3));
         MainWindow.a("", false);
         this.Br.setCursor(new Cursor(12));
      }
   }

   public void rv() {
      MainWindow.a(this.Iy);
   }

   private void rw() {
      MainWindow.v(this.zu);
   }

   private void rx() {
      if (this.zu.getCoach() != null) {
         MainWindow.e(this.zu.getCoach());
      }
   }

   private void ry() {
   }

   private void rz() {
      this.ve.setBorder(BorderFactory.createEmptyBorder());
      this.HT.setToolTipText("Cores da tela");
      this.Ie.setToolTipText("Galeria de troféus");
      this.HY.setToolTipText("Retrospecto do time");
      this.Ic.setToolTipText("Jogadores emprestados");
   }

   public static Color rA() {
      return HM;
   }

   public boolean rB() {
      return this.yp;
   }

   public static boolean rC() {
      return HN;
   }

   public static void ae(boolean bl) {
      HN = bl;
   }

   public static Competition rD() {
      return HO;
   }

   public static void w(Competition c0713) {
      HO = c0713;
   }

   public static void aQ(boolean bl) {
      afj = bl;
   }

   public static void aR(boolean bl) {
      afk = bl;
   }

   private void mJ() {
      this.wf = new JPanel();
      this.ur = new JLabel();
      this.Hf = new JProgressBar();
      this.us = new JLabel();
      this.Ig = new JProgressBar();
      this.a_ = new JLabel();
      this.vz = new JLabel();
      this.yt = new JLabel();
      this.zb = new JLabel();
      this.vw = new JLabel();
      this.Bj = new JLabel();
      this.uh = new JLabel();
      this.Fq = new JLabel();
      this.ug = new JLabel();
      this.Iw = new JLabel();
      this.ze = new JLabel();
      this.Ix = new JScrollPane();
      this.Iy = new JTable();
      this.ve = new JToolBar();
      this.Io = new Separator();
      this.Ih = new Separator();
      this.HR = new JButton();
      this.Is = new Separator();
      this.Ij = new Separator();
      this.afl = new JButton();
      this.OD = new Separator();
      this.HS = new JButton();
      this.In = new Separator();
      this.HV = new JButton();
      this.Ik = new Separator();
      this.HW = new JButton();
      this.Iu = new Separator();
      this.Ib = new JButton();
      this.Il = new Separator();
      this.Id = new JButton();
      this.Im = new Separator();
      this.yY = new JButton();
      this.It = new Separator();
      this.Ia = new JButton();
      this.Ip = new Separator();
      this.HZ = new JButton();
      this.Iq = new Separator();
      this.HX = new JButton();
      this.Ir = new Separator();
      this.Eh = new JLabel();
      this.Ii = new Separator();
      this.Eg = new JLabel();
      this.HU = new JButton();
      this.If = new C0818(this);
      this.Ef = new JLabel();
      this.Iv = new JToolBar();
      this.HT = new JButton();
      this.Ie = new JButton();
      this.HY = new JButton();
      this.Ic = new JButton();
      this.setBackground(new Color(0, 51, 51));
      this.wf.setBackground(new Color(226, 226, 217));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Confiança diretoria:");
      this.Hf.setToolTipText("");
      this.Hf.setValue(30);
      this.Hf.setStringPainted(true);
      this.us.setHorizontalAlignment(2);
      this.us.setText("Confiança torcida:");
      this.Ig.setForeground(new Color(0, 51, 51));
      this.Ig.setValue(55);
      this.Ig.setStringPainted(true);
      this.a_.setFont(new Font("Tahoma", 1, 11));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Emmanuel dos Santos");
      this.vz.setBackground(new Color(0, 0, 0));
      this.vz.setFont(new Font("Tahoma", 1, 11));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(2);
      this.vz.setText("Próximo jogo");
      this.vz.setOpaque(true);
      this.yt.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.zb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconretrospecto.png")));
      this.zb.setCursor(new Cursor(12));
      this.vw.setFont(new Font("Tahoma", 0, 12));
      this.vw.setText("Red Bull Bragantino");
      this.Bj.setFont(new Font("Tahoma", 0, 12));
      this.Bj.setText("1ª divisão - 9º colocado");
      this.uh.setFont(new Font("Tahoma", 0, 12));
      this.uh.setText("1ª divisão - 9º colocado");
      this.Fq.setBackground(new Color(232, 236, 235));
      this.Fq.setHorizontalAlignment(0);
      this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setText("Borussia Dortmund");
      this.Iw.setHorizontalAlignment(2);
      this.Iw.setIcon(new ImageIcon(this.getClass().getResource("/aicons/n03.png")));
      this.Iw.setText("5 milhões 200 mil");
      this.Iw.setCursor(new Cursor(12));
      this.ze.setHorizontalAlignment(2);
      this.ze.setIcon(new ImageIcon(this.getClass().getResource("/aicons/n04.png")));
      this.ze.setText("5");
      this.ze.setCursor(new Cursor(12));
      GroupLayout var1 = new GroupLayout(this.wf);
      this.wf.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(6, 6, 6)
                  .addComponent(this.Fq, -2, 60, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.ug, -1, -1, 32767).addComponent(this.a_, -1, -1, 32767))
            )
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.Iw, -1, -1, 32767)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ze, -2, 49, -2)
            )
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.yt, -2, 60, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.Bj, -1, -1, 32767)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.vw, -1, -1, 32767)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.zb)
                                    )
                              )
                        )
                        .addComponent(this.uh, Alignment.LEADING, -1, -1, 32767)
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING, false).addComponent(this.Hf, -2, 1, 32767).addComponent(this.ur, -1, 119, 32767)
                              )
                              .addGap(18, 18, 18)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(var1.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.us, -2, 123, -2))
                                    .addComponent(this.Ig, -2, 1, 32767)
                              )
                        )
                        .addComponent(this.vz, Alignment.LEADING, -2, 260, -2)
                  )
                  .addGap(20, 20, 20)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(16, 16, 16)
                              .addComponent(this.ug, -2, 23, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.a_)
                        )
                        .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.Fq, -2, 60, -2))
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Iw, -2, 21, -2).addComponent(this.ze, -2, 23, -2))
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.uh)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ur).addComponent(this.us))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Hf, -2, -1, -2).addComponent(this.Ig, -2, -1, -2))
                  .addGap(18, 18, 18)
                  .addComponent(this.vz, -2, 27, -2)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(10, 10, 10).addComponent(this.yt, -2, 60, -2))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(var1.createParallelGroup(Alignment.TRAILING).addComponent(this.vw, -2, 19, -2).addComponent(this.zb, -2, 39, -2))
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.Bj)
                        )
                  )
                  .addGap(13, 13, 13)
            )
      );
      this.Iy.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.Ix.setViewportView(this.Iy);
      this.ve.setBackground(new Color(0, 0, 0));
      this.ve.setFloatable(false);
      this.ve.setRollover(true);
      this.ve.setFont(new Font("Tahoma", 0, 12));
      this.ve.add(this.Io);
      this.ve.add(this.Ih);
      this.HR.setForeground(new Color(255, 255, 255));
      this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
      this.HR.setText("Agenda");
      this.HR.setBorderPainted(false);
      this.HR.setContentAreaFilled(false);
      this.HR.setFocusable(false);
      this.HR.setHorizontalTextPosition(0);
      this.HR.setVerticalTextPosition(3);
      this.HR.addActionListener(new C0542(this));
      this.ve.add(this.HR);
      this.ve.add(this.Is);
      this.Ij.setMaximumSize(new Dimension(12, 32767));
      this.ve.add(this.Ij);
      this.afl.setForeground(new Color(255, 255, 255));
      this.afl.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon04.png")));
      this.afl.setText("Seleção");
      this.afl.setBorderPainted(false);
      this.afl.setContentAreaFilled(false);
      this.afl.setFocusable(false);
      this.afl.setHorizontalTextPosition(0);
      this.afl.setVerticalTextPosition(3);
      this.ve.add(this.afl);
      this.OD.setMaximumSize(new Dimension(12, 32767));
      this.ve.add(this.OD);
      this.HS.setForeground(new Color(255, 255, 255));
      this.HS.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon04.png")));
      this.HS.setText("Tabelas");
      this.HS.setBorderPainted(false);
      this.HS.setContentAreaFilled(false);
      this.HS.setFocusable(false);
      this.HS.setHorizontalTextPosition(0);
      this.HS.setVerticalTextPosition(3);
      this.ve.add(this.HS);
      this.ve.add(this.In);
      this.HV.setForeground(new Color(255, 255, 255));
      this.HV.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon05.png")));
      this.HV.setText("Estádio");
      this.HV.setBorderPainted(false);
      this.HV.setContentAreaFilled(false);
      this.HV.setFocusable(false);
      this.HV.setHorizontalTextPosition(0);
      this.HV.setVerticalTextPosition(3);
      this.ve.add(this.HV);
      this.ve.add(this.Ik);
      this.HW.setForeground(new Color(255, 255, 255));
      this.HW.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon09.png")));
      this.HW.setText("Juniores");
      this.HW.setBorderPainted(false);
      this.HW.setContentAreaFilled(false);
      this.HW.setFocusable(false);
      this.HW.setHorizontalTextPosition(0);
      this.HW.setVerticalTextPosition(3);
      this.ve.add(this.HW);
      this.ve.add(this.Iu);
      this.Ib.setForeground(new Color(255, 255, 255));
      this.Ib.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon06.png")));
      this.Ib.setText("Times");
      this.Ib.setBorderPainted(false);
      this.Ib.setContentAreaFilled(false);
      this.Ib.setFocusable(false);
      this.Ib.setHorizontalTextPosition(0);
      this.Ib.setVerticalTextPosition(3);
      this.ve.add(this.Ib);
      this.ve.add(this.Il);
      this.Id.setForeground(new Color(255, 255, 255));
      this.Id.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon03.png")));
      this.Id.setText("Treino");
      this.Id.setBorderPainted(false);
      this.Id.setContentAreaFilled(false);
      this.Id.setFocusable(false);
      this.Id.setHorizontalTextPosition(0);
      this.Id.setVerticalTextPosition(3);
      this.ve.add(this.Id);
      this.ve.add(this.Im);
      this.yY.setForeground(new Color(255, 255, 255));
      this.yY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon07.png")));
      this.yY.setText("Procura");
      this.yY.setBorderPainted(false);
      this.yY.setContentAreaFilled(false);
      this.yY.setFocusable(false);
      this.yY.setHorizontalTextPosition(0);
      this.yY.setVerticalTextPosition(3);
      this.ve.add(this.yY);
      this.ve.add(this.It);
      this.Ia.setForeground(new Color(255, 255, 255));
      this.Ia.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon08.png")));
      this.Ia.setText("Técnicos");
      this.Ia.setBorderPainted(false);
      this.Ia.setContentAreaFilled(false);
      this.Ia.setFocusable(false);
      this.Ia.setHorizontalTextPosition(0);
      this.Ia.setVerticalTextPosition(3);
      this.ve.add(this.Ia);
      this.ve.add(this.Ip);
      this.HZ.setForeground(new Color(255, 255, 255));
      this.HZ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconhistoria.png")));
      this.HZ.setText("História");
      this.HZ.setBorderPainted(false);
      this.HZ.setContentAreaFilled(false);
      this.HZ.setFocusable(false);
      this.HZ.setHorizontalTextPosition(0);
      this.HZ.setVerticalTextPosition(3);
      this.ve.add(this.HZ);
      this.ve.add(this.Iq);
      this.HX.setForeground(new Color(255, 255, 255));
      this.HX.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon01.png")));
      this.HX.setText("Opções");
      this.HX.setBorderPainted(false);
      this.HX.setContentAreaFilled(false);
      this.HX.setFocusable(false);
      this.HX.setHorizontalTextPosition(0);
      this.HX.setVerticalTextPosition(3);
      this.ve.add(this.HX);
      this.ve.add(this.Ir);
      this.Eh.setFont(new Font("Tahoma", 1, 11));
      this.Eh.setForeground(new Color(255, 255, 255));
      this.Eh.setText("Registre sua cópia, clique aqui - www.brasfoot.com");
      this.ve.add(this.Eh);
      this.ve.add(this.Ii);
      this.Eg.setFont(new Font("Tahoma", 1, 11));
      this.Eg.setForeground(new Color(255, 255, 255));
      this.Eg.setText("12/04/1972");
      this.ve.add(this.Eg);
      this.HU.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tactics.png")));
      this.HU.setText("Escalar Time");
      this.HU.addActionListener(new C0543(this));
      this.If.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.Ef.setForeground(new Color(255, 255, 255));
      this.Ef.setHorizontalAlignment(4);
      this.Ef.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_small_player.png")));
      this.Ef.setText("25");
      this.Ef.setCursor(new Cursor(12));
      this.Iv.setBackground(new Color(204, 204, 0));
      this.Iv.setRollover(true);
      this.Iv.setBorderPainted(false);
      this.HT.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcolorpicker.png")));
      this.HT.setBorderPainted(false);
      this.HT.setFocusable(false);
      this.HT.setHorizontalTextPosition(0);
      this.HT.setOpaque(false);
      this.HT.setVerticalTextPosition(3);
      this.Iv.add(this.HT);
      this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
      this.Ie.setBorderPainted(false);
      this.Ie.setFocusable(false);
      this.Ie.setHorizontalTextPosition(0);
      this.Ie.setOpaque(false);
      this.Ie.setVerticalTextPosition(3);
      this.Iv.add(this.Ie);
      this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
      this.HY.setBorderPainted(false);
      this.HY.setFocusable(false);
      this.HY.setHorizontalTextPosition(0);
      this.HY.setMaximumSize(new Dimension(41, 41));
      this.HY.setOpaque(false);
      this.HY.setVerticalTextPosition(3);
      this.Iv.add(this.HY);
      this.Ic.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconemprestados.png")));
      this.Ic.setBorderPainted(false);
      this.Ic.setFocusable(false);
      this.Ic.setHorizontalTextPosition(0);
      this.Ic.setOpaque(false);
      this.Ic.setVerticalTextPosition(3);
      this.Iv.add(this.Ic);
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addComponent(this.ve, -1, 1024, 32767)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createParallelGroup(Alignment.LEADING, false)
                              .addGroup(
                                 var2.createSequentialGroup()
                                    .addComponent(this.Iv, -2, -1, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.Ef, -2, 53, -2)
                              )
                              .addComponent(this.HU, -1, 290, 32767)
                              .addComponent(this.If, -1, -1, 32767)
                        )
                        .addComponent(this.wf, Alignment.TRAILING, -2, -1, -2)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.Ix)
                  .addContainerGap()
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addComponent(this.ve, -2, 65, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.wf, -2, -1, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.HU, -2, 36, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.If, -2, 236, -2)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.Iv, -2, -1, -2).addComponent(this.Ef))
                        )
                        .addComponent(this.Ix)
                  )
                  .addGap(22, 22, 22)
            )
      );
   }

   private void a(ActionEvent actionEvent) {
   }

   private void c(ActionEvent actionEvent) {
   }
}
