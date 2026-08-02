package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.NationalLeague;
import mod.recovered.transfer.TransferNegotiation;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0452 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private Club ul = null;
   private Player yK = null;
   private ArrayList um = new ArrayList();
   private ArrayList uK = new ArrayList();
   private ArrayList Fj = new ArrayList();
   private boolean yp = false;
   public static Comparator KZ = new C0453();
   private JButton HR;
   private JButton FN;
   private JButton MJ;
   private JButton vm;
   private JButton HW;
   private JButton HY;
   private JButton Ic;
   private JButton Ie;
   private JButton MK;
   private JLabel a_;
   private JLabel ur;
   private JPanel we;
   private JPanel wf;
   private JPanel wg;
   private JPanel wh;
   private JProgressBar Hf;
   private JProgressBar Ig;
   private JScrollPane ut;
   private JScrollPane wi;
   private JScrollPane zf;
   private JScrollPane zg;
   private JTabbedPane ML;
   private JToolBar ve;
   private JLabel Fq;
   private JLabel MM;
   private JLabel MN;
   private JLabel MO;
   private JLabel MP;
   private JLabel MQ;
   private JLabel MR;
   private JLabel MS;
   private JLabel uu;
   private JLabel MT;
   private JTable zj;
   private JTable MU;
   private JTree uw;

   public C0452(JDialog jDialog, Club club, Club club2, boolean bl) {
      this.ub = jDialog;
      this.uk = club;
      this.ul = club2;
      this.yp = bl;
      this.mJ();
      this.qz();
      this.nE();
      this.mK();
      this.mH();
      this.mM();
      this.zf.setBorder(BorderFactory.createEmptyBorder());
      this.zg.setBorder(BorderFactory.createEmptyBorder());
      this.ML.setBorder(BorderFactory.createEmptyBorder());
      this.MP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconmoneys.png")));
      if (this.zj.getRowCount() > 0) {
         this.zj.setRowSelectionInterval(0, 0);
         this.yK = (Player)this.uK.get(0);
         this.sG();
         this.sF();
      }

      this.mY();
      if (bl) {
         this.MP.setVisible(false);
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.wf.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
      this.wh.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
      this.ve.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.zj);
      this.a(this.uw);
      this.a(this.ML);
      this.a(this.MJ);
      this.a(this.FN);
      this.a(this.MK);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
      jComponent.getActionMap().put("esc", new C0460(this));
   }

   private void pq() {
      C0651 var1 = new C0651(this.Fj);
      this.MU.setModel(var1);
      int[] var2 = new int[]{40, 80, 30, 20, 20, 20, 20, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.MU.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.MU.setAutoResizeMode(3);
      this.MU.setRowHeight(20);
      this.MU.setShowGrid(false);
      this.MU.setDefaultRenderer(C0729.class, new C0620());
      this.MU.setAutoCreateRowSorter(false);
      this.MU.getTableHeader().setReorderingAllowed(false);
      this.MU.setIntercellSpacing(new Dimension(0, 0));
      this.MU.setCellSelectionEnabled(false);
      this.MU.setSelectionMode(0);
      this.MU.setRowSelectionAllowed(true);
      this.MU.setSelectionBackground(Color.YELLOW);
      this.MU.setFillsViewportHeight(true);
   }

   private void qz() {
      this.HR.setToolTipText("Calendário");
      this.HW.setToolTipText("Academia de Juniores");
      this.Ie.setToolTipText("Galeria de troféus");
      this.HY.setToolTipText("Retrospecto do time");
      this.Ic.setToolTipText("Transferências");
   }

   public void mH() {
      this.vm.addActionListener(new C0461(this));
      this.HR.addActionListener(new C0462(this));
      this.HW.addActionListener(new C0463(this));
      this.Ic.addActionListener(new C0464(this));
      this.Ie.addActionListener(new C0465(this));
      this.HY.addActionListener(new C0466(this));
      this.MS.addMouseListener(new C0467(this));
      this.MJ.addActionListener(new C0454(this));
      this.FN.addActionListener(new C0455(this));
      this.MK.addActionListener(new C0456(this));
   }

   private void sz() {
      TransferNegotiation.l(false);
      int var1 = 0;
      var1 = TransferNegotiation.a(this.yK, this.ul);
      String[] var2 = new String[]{
         "Não foi possível emprestar",
         "Empréstimo realizado",
         "Jogador do seu time",
         "Seu time já pegou o limite de quatro emprestados",
         "Não deseja jogar no seu time",
         "Não está disponível para empréstimo",
         "Limite de 30 jogadores alcançado"
      };
      if (var1 == 1) {
         this.sH();
         this.zj.addNotify();
      }

      JOptionPane.showMessageDialog(this.ub, var2[var1], "Empréstimo", 2);
   }

   private void oM() {
      TransferNegotiation.l(false);
      int var1 = 0;
      var1 = TransferNegotiation.b(this.yK, this.ul);
      String[] var2 = new String[]{
         "Não está à venda",
         "Compra realizada",
         "Jogador do seu time",
         "Limite de 30 jogadores alcançado",
         "Não deseja se transferir para o seu time",
         "Sem dinheiro para comprar este jogador"
      };
      if (var1 == 1) {
         this.sH();
         this.zj.addNotify();
      }

      JOptionPane.showMessageDialog(this.ub, var2[var1], "Compra", 2);
   }

   private void sA() {
      if (!GamePersistence.isRegisteredVersion()) {
         JOptionPane.showMessageDialog(this.ub, "Apenas na versão registrada é possível fazer oferta em qualquer jogador.", "Oferta", 2);
      } else if (TransferNegotiation.d(this.sE(), this.ul)) {
         if (this.sE().fg() == this.ul) {
            JOptionPane.showMessageDialog(this.ub, "Jogador do time", "Proposta", 2);
         } else if (this.ul.getSeniorPlayers().size() >= 35) {
            JOptionPane.showMessageDialog(this.ub, "Limite de 32 jogadores alcançado", "Limite de jogadores", 2);
         } else if (this.sE() != null) {
            TransferNegotiation.l(false);
            JDialog var1 = new JDialog(this.ub);
            C0185 var2 = new C0185(var1, this.sE(), this.ul, false);
            var1.add(var2);
            var1.setSize(373, 300);
            var1.setPreferredSize(new Dimension(373, 300));
            var1.setModal(true);
            var1.setResizable(false);
            var1.setLocationRelativeTo(null);
            var1.setUndecorated(true);
            var1.setVisible(true);
            if (TransferNegotiation.cO()) {
               this.sH();
               this.zj.addNotify();
            }
         }
      } else {
         JOptionPane.showMessageDialog(this.ub, "O jogador não deseja jogar no seu time.", "Jogador recusou", 2);
      }
   }

   private void rw() {
      this.Ie.setCursor(new Cursor(3));
      MainWindow.v(this.uk);
      this.Ie.setCursor(new Cursor(12));
   }

   private void qP() {
      this.HY.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0447 var2 = new C0447(var1, this.uk);
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

   private void sB() {
      JDialog var1 = new JDialog(this.ub);
      C0369 var2 = new C0369(var1, this.uk.getCoach());
      var1.add(var2);
      var1.setSize(880, 663);
      var1.setPreferredSize(new Dimension(880, 663));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   private void sC() {
      this.Ic.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0401 var2 = new C0401(var1, this.uk, 0);
      var1.add(var2);
      var1.setSize(695, 500);
      var1.setPreferredSize(new Dimension(695, 500));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.Ic.setCursor(new Cursor(12));
   }

   public void qY() {
      this.HW.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0231 var2 = new C0231(var1, this.ul, this.uk);
      var1.add(var2);
      var1.setSize(763, 568);
      var1.setPreferredSize(new Dimension(763, 568));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HW.setCursor(new Cursor(12));
   }

   private void sD() {
      this.HR.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0012 var2 = new C0012(var1, this.uk);
      var1.add(var2);
      var1.setSize(820, 600);
      var1.setPreferredSize(new Dimension(820, 600));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HR.setCursor(new Cursor(12));
   }

   private void mM() {
      this.uw.getSelectionModel().setSelectionMode(1);
      this.uw.addTreeSelectionListener(new C0457(this));

      for (int var1 = 0; var1 < GamePersistence.careerState.P().size(); var1++) {
         if (!((Club)GamePersistence.careerState.P().get(var1)).kn()) {
            this.um.add((Club)GamePersistence.careerState.P().get(var1));
            Collections.sort(this.um, C1007.VS);
         }
      }

      DefaultMutableTreeNode var3 = new DefaultMutableTreeNode("Times");
      this.a(var3);
      this.uw.setModel(new DefaultTreeModel(var3));
      this.uw.setRootVisible(false);
      DefaultMutableTreeNode var2 = var3.getNextNode();

      do {
         if (var2.getLevel() == 1) {
            this.uw.expandPath(new TreePath(var2.getPath()));
         }

         var2 = var2.getNextNode();
      } while (var2 != null);
   }

   private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
      DefaultMutableTreeNode var2 = null;
      DefaultMutableTreeNode var3 = null;
      MutableTreeNode var4 = null;

      for (int var5 = 0; var5 < GamePersistence.careerState.N().size(); var5++) {
         var2 = new DefaultMutableTreeNode(((CountryCompetitions)GamePersistence.careerState.N().get(var5)).jp());
         defaultMutableTreeNode.add(var2);

         for (int var6 = 0; var6 < ((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().size(); var6++) {
            if (((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().get(var6)).yi().yK().size() > 0) {
               String var7 = ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().get(var6)).getNome();
               if (var7.length() > 39) {
                  var7 = var7.substring(0, 39) + "...";
               }

               var3 = new DefaultMutableTreeNode(var7);
               var2.add(var3);
               ArrayList var8 = new ArrayList();
               var8.addAll(((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().get(var6)).yi().yK());
               Collections.sort(var8, C1007.VS);

               for (int var9 = 0; var9 < var8.size(); var9++) {
                  var4 = new DefaultMutableTreeNode(var8.get(var9));
                  var3.add(var4);
               }
            }
         }

         if (((CountryCompetitions)GamePersistence.careerState.N().get(var5)).ek().size() > 0) {
            var3 = new DefaultMutableTreeNode("Regionais");
            var2.add(var3);
            ArrayList var18 = new ArrayList();
            var18.addAll(((CountryCompetitions)GamePersistence.careerState.N().get(var5)).ek());
            Collections.sort(var18, C1007.VS);

            for (int var19 = 0; var19 < var18.size(); var19++) {
               var4 = new DefaultMutableTreeNode(var18.get(var19));
               var3.add(var4);
            }
         }
      }

      if (this.um.size() > 0) {
         var2 = new DefaultMutableTreeNode("Internacionais");
         defaultMutableTreeNode.add(var2);

         for (int var17 = 0; var17 < this.um.size(); var17++) {
            var4 = new DefaultMutableTreeNode(this.um.get(var17));
            var2.add(var4);
         }
      }
   }

   public Player sE() {
      if (this.yK == null && this.uK.size() > 0) {
         this.yK = (Player)this.uK.get(0);
      }

      return this.yK;
   }

   private void sF() {
      int[] var1 = new int[6];
      if (this.yK != null) {
         this.MO.setText(this.yK.getNome() + " - " + GameConstants.rI[this.yK.getPosicao()]);
         ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aflags/" + this.yK.getPais() + ".png"));
         this.MO.setIcon(var2);
         var1 = this.yK.gw();
         String var3 = "";
         if (this.yK.fP() && this.yK.fo() > ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime()) {
            var3 = "Fim contusão: " + ScheduleDay.a(this.yK.fo());
         }

         String var4 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;" + Integer.toString(this.yK.getOverallStrength()) + "&nbsp;&nbsp;&nbsp;";
         if (GamePersistence.careerState.isHabilidadeIndividual()) {
            var4 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n&nbsp;&nbsp;&nbsp;&nbsp;";
         }

         String var5 = var4
            + "<b>Idade:</b>"
            + Integer.toString(this.yK.getIdade())
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n"
            + "<b>Jogos:"
            + "</b>&nbsp;"
            + Integer.toString(var1[0])
            + "&nbsp;&nbsp;&nbsp;"
            + "<b>Gols:"
            + "</b>"
            + Integer.toString(var1[1])
            + "&nbsp;&nbsp;&nbsp;"
            + "<b>"
            + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:"
            + "</b>&nbsp;"
            + ClubFinances.c(this.yK.fk())
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>"
            + "Salário:"
            + "</b>&nbsp;"
            + ClubFinances.c(this.yK.fj())
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
            + "<b>"
            + GameConstants.qM[this.yK.getCr1()]
            + "/"
            + GameConstants.qM[this.yK.getCr2()]
            + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
            + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
            + "<b>"
            + var3
            + "<b><br>\n</p>\n</body></html>\n";
         this.MN.setText(var5);
      }

      if (this.yK != null) {
         this.Fj.clear();
         int var6 = 0;

         for (int var7 = this.yK.gr().size() - 1; var7 >= 0; var7--) {
            this.Fj.add((C0729)this.yK.gr().get(var7));
            if (++var6 >= 10) {
               break;
            }
         }

         C0729 var8 = new C0729(true, var1);
         this.Fj.add(var8);
         if (this.yK.fL() > 0) {
            C0729 var9 = new C0729();
            var9.D(this.yK.fL());
            this.Fj.add(var9);
         }

         this.pq();
      }
   }

   public void s(Player player) {
      this.yK = player;
      this.sG();
      this.sF();
   }

   private void nE() {
      C0586 var1 = new C0586(this.uK, this);
      this.zj.setModel(var1);
      int[] var2 = new int[]{20, 20, 45, 120, 20, 20, 50, 50, 45, 35, 25, 25, 20, 20};
      int[] var3 = new int[]{20, 20, 20, 110, 20, 25, 25, 25, 25, 25, 25, 25, 50, 50, 60, 45, 25, 22, 20, 20};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = var3;
      }

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.zj.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.zj.setAutoResizeMode(3);
      this.zj.setRowHeight(20);
      this.zj.setShowGrid(false);
      this.zj.setDefaultRenderer(Player.class, new C0607());
      this.zj.setAutoCreateRowSorter(false);
      this.zj.getTableHeader().setReorderingAllowed(false);
      this.zj.setIntercellSpacing(new Dimension(0, 0));
      this.zj.setCellSelectionEnabled(false);
      this.zj.setSelectionMode(0);
      this.zj.setRowSelectionAllowed(true);
      this.zj.setSelectionBackground(Color.YELLOW);
      this.zj.setFillsViewportHeight(true);
      TableRowSorter var5 = new TableRowSorter<>(this.zj.getModel());
      this.zj.setRowSorter(var5);
      var5.setComparator(0, C1007.abe);
      var5.setComparator(2, C1007.cL);
      var5.setComparator(3, C1007.abk);
      var5.setComparator(4, C1007.aba);
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         var5.setComparator(5, C1007.aaJ);
         var5.setComparator(6, C1007.aaZ);
         var5.setComparator(7, C1007.aaW);
         var5.setComparator(9, C1007.abd);
         var5.setComparator(10, C1007.abc);
         var5.setComparator(11, C1007.VU);
      } else {
         var5.setComparator(5, C1007.aaK);
         var5.setComparator(6, C1007.aaM);
         var5.setComparator(7, C1007.aaL);
         var5.setComparator(8, C1007.aaN);
         var5.setComparator(9, C1007.aaP);
         var5.setComparator(10, C1007.aaO);
         var5.setComparator(11, C1007.aaQ);
         var5.setComparator(12, C1007.aaZ);
         var5.setComparator(13, C1007.aaW);
         var5.setComparator(15, C1007.abd);
         var5.setComparator(16, C1007.abc);
         var5.setComparator(17, C1007.VU);
      }

      this.zj.getSelectionModel().addListSelectionListener(new C0458(this));
      this.zj.addMouseListener(new C0459(this));
      if (this.zj.getRowCount() > 0) {
         this.zj.setRowSelectionInterval(0, 0);
      }
   }

   private void sG() {
      if (this.uk == this.ul || this.yp || this.yK.gl()) {
         this.MJ.setEnabled(false);
         this.FN.setEnabled(false);
         this.MK.setEnabled(false);
      } else if (this.yK != null) {
         this.MJ.setEnabled(this.yK.fz());
         this.FN.setEnabled(this.yK.ft());
         this.MK.setEnabled(true);
      }
   }

   private void sH() {
      this.uK.clear();
      this.uK.addAll(this.uk.getSeniorPlayers());
      ((C0586)this.zj.getModel()).fireTableDataChanged();
      Collections.sort(this.uK, KZ);
      if (this.zj.getRowCount() > 0) {
         this.zj.setRowSelectionInterval(0, 0);
         this.yK = (Player)this.uK.get(0);
         this.sG();
         this.sF();
      }

      this.MP.setText(ClubFinances.c(this.ul.kb()));
   }

   public void F(Club club) {
      this.uk = club;
      this.yK = null;
      this.mK();
      if (this.zj.getRowCount() > 0) {
         this.zj.setRowSelectionInterval(0, 0);
      }

      Collections.sort(this.uK, KZ);
      this.zj.addNotify();
   }

   public void mK() {
      this.uu.setText(this.uk.getNome());
      this.MP.setText(ClubFinances.c(this.ul.kb()));
      if (this.uk.getCoach() != null) {
         this.MS.setText(this.uk.getCoach().dS());
      } else {
         this.MS.setText("interino");
      }

      this.MR.setText(GameConstants.pZ[this.uk.getReputacao()]);
      this.Fq.setIcon(this.uk.kP());
      this.MQ.setText(C0696.valueOf("P" + this.uk.getPais()).getNome());
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/aflags/" + this.uk.getPais() + ".png"));
      this.MQ.setIcon(var1);
      if (this.uk.getPais() == 29) {
         this.MQ.setText(C0696.valueOf("P" + this.uk.getPais()).getNome() + " (" + GameConstants.rX[this.uk.getEstado()] + ")");
      } else {
         this.MM.setVisible(false);
      }

      this.Hf.setValue(this.uk.getCoach().lL());
      this.Ig.setValue(this.uk.getCoach().lM());
      long var2 = 0L;

      for (int var4 = 0; var4 < this.uk.getSeniorPlayers().size(); var4++) {
         ((Player)this.uk.getSeniorPlayers().get(var4)).a((ImageIcon)null);
         var2 += ((Player)this.uk.getSeniorPlayers().get(var4)).fk();
      }

      this.MT.setText("Valor do elenco: " + ClubFinances.a(var2, 0));
      this.uK.clear();
      this.uK.addAll(this.uk.getSeniorPlayers());
      ((C0586)this.zj.getModel()).fireTableDataChanged();
      Collections.sort(this.uK, KZ);
   }

   private void mJ() {
      this.we = new JPanel();
      this.MO = new JLabel();
      this.ML = new JTabbedPane();
      this.zf = new JScrollPane();
      this.MN = new JLabel();
      this.zg = new JScrollPane();
      this.MU = new JTable();
      this.wf = new JPanel();
      this.Fq = new JLabel();
      this.uu = new JLabel();
      this.MS = new JLabel();
      this.MR = new JLabel();
      this.MQ = new JLabel();
      this.MM = new JLabel();
      this.MT = new JLabel();
      this.wg = new JPanel();
      this.ve = new JToolBar();
      this.HW = new JButton();
      this.HR = new JButton();
      this.Ie = new JButton();
      this.HY = new JButton();
      this.Ic = new JButton();
      this.ut = new JScrollPane();
      this.zj = new JTable();
      this.MP = new JLabel();
      this.vm = new JButton();
      this.MJ = new JButton();
      this.FN = new JButton();
      this.MK = new JButton();
      this.wh = new JPanel();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.Hf = new JProgressBar();
      this.Ig = new JProgressBar();
      this.wi = new JScrollPane();
      this.uw = new JTree();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 2));
      this.MO.setFont(new Font("Tahoma", 0, 12));
      this.MO.setHorizontalAlignment(2);
      this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.MO.setText("Marquinhos Paraná - M");
      this.MN.setFont(new Font("Tahoma", 0, 12));
      this.MN.setText("");
      this.MN.setVerticalAlignment(1);
      this.zf.setViewportView(this.MN);
      this.ML.addTab("Info", this.zf);
      this.zg.setViewportView(this.MU);
      this.ML.addTab("Carreira", this.zg);
      GroupLayout var1 = new GroupLayout(this.we);
      this.we.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING).addComponent(this.MO, -1, 254, 32767).addComponent(this.ML, Alignment.TRAILING, -2, 0, 32767)
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap(-1, 32767)
                  .addComponent(this.MO)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ML, -2, 233, -2)
                  .addGap(208, 208, 208)
            )
      );
      this.ML.getAccessibleContext().setAccessibleName("Info");
      this.ML.getAccessibleContext().setAccessibleDescription("");
      this.wf.setBackground(new Color(44, 53, 49));
      this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.uu.setFont(new Font("Tahoma", 1, 14));
      this.uu.setForeground(new Color(255, 255, 255));
      this.uu.setText("Cruzeiro");
      this.MS.setForeground(new Color(255, 255, 255));
      this.MS.setText("Marcelo Oliveira");
      this.MR.setForeground(new Color(255, 255, 255));
      this.MR.setText("Continental");
      this.MQ.setForeground(new Color(255, 255, 255));
      this.MQ.setText("Brasil");
      this.MM.setForeground(new Color(255, 255, 255));
      this.MM.setHorizontalAlignment(0);
      this.MM.setText("");
      this.MT.setForeground(new Color(255, 255, 255));
      this.MT.setText("Valor elenco:");
      GroupLayout var2 = new GroupLayout(this.wf);
      this.wf.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.Fq, -2, 60, -2)
                  .addGap(18, 18, 18)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.MS, -1, 294, 32767)
                        .addComponent(this.uu, -1, -1, 32767)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addComponent(this.MR, -2, 73, -2)
                                          .addGap(18, 18, 18)
                                          .addComponent(this.MQ, -1, -1, 32767)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.MM, -2, 42, -2)
                                    )
                                    .addComponent(this.MT, -1, -1, 32767)
                              )
                              .addContainerGap()
                        )
                  )
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.uu)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.MS)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.MR).addComponent(this.MQ).addComponent(this.MM))
                        )
                        .addComponent(this.Fq, -2, 60, -2)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.MT)
                  .addContainerGap(19, 32767)
            )
      );
      this.wg.setBackground(new Color(36, 91, 45));
      this.ve.setBackground(new Color(44, 53, 49));
      this.ve.setRollover(true);
      this.ve.setBorderPainted(false);
      this.HW.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon09.png")));
      this.HW.setBorderPainted(false);
      this.HW.setFocusable(false);
      this.HW.setHorizontalTextPosition(0);
      this.HW.setOpaque(false);
      this.HW.setVerticalTextPosition(3);
      this.ve.add(this.HW);
      this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
      this.HR.setBorderPainted(false);
      this.HR.setFocusable(false);
      this.HR.setHorizontalTextPosition(0);
      this.HR.setOpaque(false);
      this.HR.setVerticalTextPosition(3);
      this.ve.add(this.HR);
      this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
      this.Ie.setBorderPainted(false);
      this.Ie.setFocusable(false);
      this.Ie.setHorizontalTextPosition(0);
      this.Ie.setOpaque(false);
      this.Ie.setVerticalTextPosition(3);
      this.ve.add(this.Ie);
      this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
      this.HY.setBorderPainted(false);
      this.HY.setFocusable(false);
      this.HY.setHorizontalTextPosition(0);
      this.HY.setMaximumSize(new Dimension(41, 41));
      this.HY.setOpaque(false);
      this.HY.setVerticalTextPosition(3);
      this.ve.add(this.HY);
      this.Ic.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon12.png")));
      this.Ic.setBorderPainted(false);
      this.Ic.setFocusable(false);
      this.Ic.setHorizontalTextPosition(0);
      this.Ic.setOpaque(false);
      this.Ic.setVerticalTextPosition(3);
      this.ve.add(this.Ic);
      GroupLayout var3 = new GroupLayout(this.wg);
      this.wg.setLayout(var3);
      var3.setHorizontalGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.ve, -1, -1, 32767));
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, var3.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.ve, -2, -1, -2))
      );
      this.ut.setViewportView(this.zj);
      this.MP.setForeground(new Color(255, 255, 255));
      this.MP.setText("Dinheiro em caixa:");
      this.vm.setText("Fechar");
      this.MJ.setText("Empréstimo");
      this.FN.setText("Comprar");
      this.MK.setText("Fazer oferta");
      this.wh.setBackground(new Color(44, 53, 49));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Confiança Diretoria:");
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Confiança Torcida:");
      this.Hf.setMinimum(1);
      this.Ig.setMinimum(1);
      GroupLayout var4 = new GroupLayout(this.wh);
      this.wh.setLayout(var4);
      var4.setHorizontalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var4.createParallelGroup(Alignment.LEADING).addComponent(this.a_, -2, 115, -2).addComponent(this.ur, -2, 123, -2))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var4.createParallelGroup(Alignment.LEADING).addComponent(this.Hf, -2, 115, -2).addComponent(this.Ig, -2, 115, -2))
                  .addContainerGap(13, 32767)
            )
      );
      var4.setVerticalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var4.createParallelGroup(Alignment.LEADING).addComponent(this.a_).addComponent(this.Hf, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var4.createParallelGroup(Alignment.LEADING).addComponent(this.ur).addComponent(this.Ig, -2, -1, -2))
                  .addContainerGap(18, 32767)
            )
      );
      DefaultMutableTreeNode var5 = new DefaultMutableTreeNode("Times");
      DefaultMutableTreeNode var6 = new DefaultMutableTreeNode("Brasil");
      DefaultMutableTreeNode var7 = new DefaultMutableTreeNode("1ª divisão");
      DefaultMutableTreeNode var8 = new DefaultMutableTreeNode("Cruzeiro");
      var7.add(var8);
      var8 = new DefaultMutableTreeNode("Atlético");
      var7.add(var8);
      var6.add(var7);
      var7 = new DefaultMutableTreeNode("2ª divisão");
      var8 = new DefaultMutableTreeNode("Barcelona");
      var7.add(var8);
      var8 = new DefaultMutableTreeNode("Real Madrid");
      var7.add(var8);
      var6.add(var7);
      var5.add(var6);
      var6 = new DefaultMutableTreeNode("Espanha");
      var7 = new DefaultMutableTreeNode("1ª Divisão");
      var8 = new DefaultMutableTreeNode("Sevilla");
      var7.add(var8);
      var8 = new DefaultMutableTreeNode("Gijon");
      var7.add(var8);
      var6.add(var7);
      var7 = new DefaultMutableTreeNode("2ª divisão");
      var8 = new DefaultMutableTreeNode("Sporting");
      var7.add(var8);
      var6.add(var7);
      var5.add(var6);
      var6 = new DefaultMutableTreeNode("Outros Times");
      var7 = new DefaultMutableTreeNode("Málaga");
      var6.add(var7);
      var7 = new DefaultMutableTreeNode("Alecrim");
      var6.add(var7);
      var5.add(var6);
      this.uw.setModel(new DefaultTreeModel(var5));
      this.wi.setViewportView(this.uw);
      GroupLayout var9 = new GroupLayout(this);
      this.setLayout(var9);
      var9.setHorizontalGroup(
         var9.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var9.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(
                     var9.createParallelGroup(Alignment.LEADING)
                        .addGroup(var9.createSequentialGroup().addComponent(this.MP, -1, -1, 32767).addGap(41, 41, 41))
                        .addGroup(
                           var9.createSequentialGroup()
                              .addGroup(var9.createParallelGroup(Alignment.LEADING).addComponent(this.wi).addComponent(this.we, -1, -1, 32767))
                              .addGap(22, 22, 22)
                        )
                  )
                  .addGroup(
                     var9.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var9.createSequentialGroup()
                              .addComponent(this.MJ, -2, 126, -2)
                              .addGap(21, 21, 21)
                              .addComponent(this.FN, -2, 120, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.MK, -2, 122, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 116, -2)
                        )
                        .addComponent(this.ut, Alignment.TRAILING)
                        .addGroup(
                           var9.createSequentialGroup()
                              .addComponent(this.wf, -2, -1, -2)
                              .addGap(18, 18, 18)
                              .addGroup(var9.createParallelGroup(Alignment.LEADING).addComponent(this.wh, -1, -1, 32767).addComponent(this.wg, -1, -1, 32767))
                        )
                  )
                  .addGap(29, 29, 29)
            )
      );
      var9.setVerticalGroup(
         var9.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var9.createSequentialGroup()
                  .addGap(13, 13, 13)
                  .addGroup(
                     var9.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var9.createSequentialGroup()
                              .addGroup(
                                 var9.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var9.createSequentialGroup()
                                          .addComponent(this.wh, -2, -1, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.wg, -2, -1, -2)
                                    )
                                    .addComponent(this.wf, -2, -1, -2)
                              )
                              .addGap(18, 18, 18)
                              .addComponent(this.ut, -1, 509, 32767)
                        )
                        .addGroup(
                           var9.createSequentialGroup()
                              .addComponent(this.wi, -2, 351, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.we, -2, 280, 32767)
                        )
                  )
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var9.createParallelGroup(Alignment.BASELINE)
                        .addComponent(this.MP, -2, 39, -2)
                        .addComponent(this.vm)
                        .addComponent(this.MJ)
                        .addComponent(this.FN)
                        .addComponent(this.MK)
                  )
                  .addContainerGap()
            )
      );
   }
}
