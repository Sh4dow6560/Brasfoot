package bf22.intermediary;

import bf22.intermediary.CareerInitializer;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0419 extends JPanel {
   private JFrame Br;
   private JButton Mb;
   private JButton Mc;
   private JButton Md;
   private JButton Me;
   private JButton Bw;
   private JButton Mf;
   private JButton Mg;
   private JCheckBox Mh;
   private JCheckBox afz;
   private JCheckBox Mi;
   private JCheckBox Mj;
   private JCheckBox Mk;
   private JComboBox afA;
   private ButtonGroup Ml;
   private ButtonGroup Mm;
   private JLabel ug;
   private JLabel a_;
   private JPanel vd;
   private JPanel we;
   private JPanel wf;
   private JPanel wg;
   private JScrollPane ut;
   private JLabel Mo;
   private JLabel Mp;
   private JLabel Mq;
   private JLabel Mr;
   private JLabel Ms;
   private JLabel afB;
   private JLabel Mt;
   private JLabel vf;
   private JRadioButton Mu;
   private JRadioButton Mv;
   private JRadioButton Mw;
   private JRadioButton Mx;
   private JScrollPane My;
   private JTable Mz;
   private JTable JG;

   public C0419(JFrame jFrame) {
      this.Br = jFrame;
      this.mJ();
      if (GamePersistence.careerState.bF.size() > 0) {
         this.sn();
      }

      this.so();
      this.mH();
      this.sm();
      this.mQ();
   }

   private void mQ() {
      this.afA.addItem("2022");
      this.afA.addItem("2023");
      if (GameConstants.am("anoinicio") == 1) {
         this.afA.setSelectedIndex(1);
      } else {
         this.afA.setSelectedIndex(0);
      }
   }

   private void sm() {
      if (!GamePersistence.isRegisteredVersion()) {
         this.Mi.setSelected(false);
         this.Mj.setSelected(false);
         this.Mh.setSelected(false);
         this.Mk.setEnabled(false);
         this.Mk.setSelected(false);
         this.Mi.setEnabled(false);
         this.Mj.setEnabled(false);
         this.Mh.setEnabled(false);
         this.Mk.setEnabled(false);
         this.Mc.setEnabled(false);
         this.Mb.setEnabled(false);
         GamePersistence.careerState.setJogaRegionais(false);
      } else {
         this.ug.setVisible(false);
      }
   }

   public void sn() {
      C0581 var1 = new C0581();
      this.JG.setModel(var1);
      this.JG.getColumnModel().getColumn(0).setPreferredWidth(25);
      this.JG.getColumnModel().getColumn(1).setPreferredWidth(120);
      this.JG.getColumnModel().getColumn(2).setPreferredWidth(70);
      this.JG.setAutoResizeMode(3);
      this.JG.setRowHeight(20);
      this.JG.setShowGrid(false);
      this.JG.setDefaultRenderer(Boolean.class, new C0602());
      this.JG.setDefaultRenderer(String.class, new C0602());
      this.JG.setDefaultRenderer(Integer.class, new C0602());
      this.JG.setDefaultRenderer(Icon.class, new C0602());
      this.JG.setDefaultRenderer(ImageIcon.class, new C0602());
      this.JG.setAutoCreateRowSorter(false);
      this.JG.setCellSelectionEnabled(false);
      this.JG.setSelectionMode(0);
      this.JG.setRowSelectionAllowed(true);
      this.JG.setSelectionBackground(Color.YELLOW);
      this.JG.setFillsViewportHeight(true);
      if (GamePersistence.careerState.bF.size() > 0) {
         this.JG.setRowSelectionInterval(0, 0);

         for (int var2 = 0; var2 < GamePersistence.careerState.bF.size(); var2++) {
            if (((C0681)GamePersistence.careerState.bF.get(var2)).getPais() == 29) {
               ((C0681)GamePersistence.careerState.bF.get(var2)).v(true);
               this.JG.setRowSelectionInterval(var2, var2);
               break;
            }
         }
      }

      this.JG.addMouseListener(new C0420(this));
   }

   public void so() {
      C0577 var1 = new C0577();
      this.Mz.setModel(var1);
      this.Mz.getColumnModel().getColumn(0).setPreferredWidth(170);
      this.Mz.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.Mz.setAutoResizeMode(3);
      this.Mz.setRowHeight(20);
      this.Mz.setShowGrid(false);
      this.Mz.setDefaultRenderer(Boolean.class, new C0598());
      this.Mz.setDefaultRenderer(String.class, new C0598());
      this.Mz.setDefaultRenderer(Integer.class, new C0598());
      this.Mz.setDefaultRenderer(Icon.class, new C0598());
      this.Mz.setDefaultRenderer(ImageIcon.class, new C0598());
      this.Mz.setAutoCreateRowSorter(false);
      this.Mz.setCellSelectionEnabled(false);
      this.Mz.setSelectionMode(0);
      this.Mz.setRowSelectionAllowed(true);
      this.Mz.setSelectionBackground(Color.YELLOW);
      this.Mz.setRowSelectionInterval(0, 0);
   }

   private void oq() {
      this.Bw.setCursor(new Cursor(3));
      if (this.afA.getSelectedIndex() == 1) {
         GamePersistence.careerState.setFirstSeasonYear(2023);
         GameConstants.f("anoinicio", 1);
      } else {
         GamePersistence.careerState.setFirstSeasonYear(2022);
         GameConstants.f("anoinicio", 0);
      }

      GamePersistence.careerState.setJogaEstadual(this.Mi.isSelected());
      GamePersistence.careerState.setJogaIntClubes(this.Mj.isSelected());
      GamePersistence.careerState.setJogaSelecoesAll(this.Mh.isSelected());
      if (GamePersistence.careerState.bj()) {
         CareerInitializer.initializeNewCareer();
         MainWindow.aY(1);
      } else {
         JOptionPane.showMessageDialog(null, "Selecione pelo menos uma liga", "", 0);
      }
   }

   public void mH() {
      this.Bw.addActionListener(new C0481(this));
      this.Mf.addActionListener(new C0482(this));
      this.Md.addActionListener(new C0483(this));
      this.Mb.addActionListener(new C0484(this));
      this.Mc.addActionListener(new C0485(this));
      this.Me.addActionListener(new C0486(this));
      this.Mj.setSelected(GamePersistence.careerState.isJogaIntClubes());
      this.Mj.addActionListener(new C0487(this));
      this.Mh.setSelected(GamePersistence.careerState.isJogaSelecoesAll());
      this.Mh.addActionListener(new C0488(this));
      this.Mi.setSelected(GamePersistence.careerState.isJogaEstadual());
      this.Mi.addActionListener(new C0421(this));
      this.Mk.setSelected(GamePersistence.careerState.isJogaRegionais());
      this.Mk.addActionListener(new C0422(this));
      this.Mm.add(this.Mw);
      this.Mm.add(this.Mx);
      this.Ml.add(this.Mv);
      this.Ml.add(this.Mu);
      if (GamePersistence.careerState.isSalarioMensal()) {
         this.Mw.setSelected(true);
         this.Mx.setSelected(false);
      } else {
         this.Mx.setSelected(true);
         this.Mw.setSelected(false);
      }

      this.Mw.addActionListener(new C0423(this));
      this.Mx.addActionListener(new C0424(this));
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         this.Mv.setSelected(true);
         this.Mu.setSelected(false);
      } else {
         this.Mv.setSelected(false);
         this.Mu.setSelected(true);
      }

      this.afz.setSelected(GamePersistence.careerState.isUsarGruposReaisCopa());
      this.afz.addActionListener(new C0478(this));
      this.Mv.addActionListener(new C0479(this));
      this.Mu.addActionListener(new C0480(this));
      this.Mg.addActionListener(new C0511(this));
   }

   private void sp() {
      C0388 var1 = new C0388();
      var1.pack();
      var1.setSize(529, 321);
      var1.setLocationRelativeTo(null);
      var1.setVisible(true);
      MainWindow.db().setVisible(false);
   }

   public void rv() {
      MainWindow.a(null);
   }

   public void AS() {
      this.Mc.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.Br);
      C0227 var2 = new C0227(var1);
      var1.add(var2);
      var1.setSize(400, 316);
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.pack();
      var1.setVisible(true);
      this.Mc.setCursor(new Cursor(12));
   }

   public void sr() {
      JDialog var1 = new JDialog(this.Br);
      C0318 var2 = new C0318(var1);
      var1.add(var2);
      var1.setSize(346, 257);
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.pack();
      var1.setVisible(true);
   }

   public void ss() {
      if (this.Mz.getSelectedRow() >= 0) {
         this.Mb.setCursor(new Cursor(3));
         int var1 = this.Mz.getSelectedRow();
         int var2 = GamePersistence.careerState.bE[this.Mz.getSelectedRow()];
         JDialog var3 = new JDialog(this.Br);
         C0182 var4 = new C0182(var1, var2, var3);
         var3.add(var4);
         var3.setSize(660, 612);
         var3.setModal(true);
         var3.setResizable(false);
         var3.setPreferredSize(new Dimension(680, 642));
         var3.setLocationRelativeTo(null);
         var3.pack();
         var3.setVisible(true);
         this.Mb.setCursor(new Cursor(12));
      }
   }

   public void st() {
      if (this.JG.getSelectedRow() >= 0) {
         this.Md.setCursor(new Cursor(3));
         int var1 = ((C0681)GamePersistence.careerState.bF.get(this.JG.getSelectedRow())).getPais();
         int var2 = ((C0681)GamePersistence.careerState.bF.get(this.JG.getSelectedRow())).iB();
         JDialog var3 = new JDialog(this.Br);
         C0193 var4 = new C0193(var1, var2, var3);
         var3.add(var4);
         var3.setSize(804, 727);
         var3.setModal(true);
         var3.setResizable(false);
         var3.setPreferredSize(new Dimension(804, 727));
         var3.setLocationRelativeTo(null);
         var3.setUndecorated(true);
         var3.pack();
         var3.setVisible(true);
         this.Md.setCursor(new Cursor(12));
      }
   }

   private void mJ() {
      this.Mm = new ButtonGroup();
      this.Ml = new ButtonGroup();
      this.vf = new JLabel();
      this.a_ = new JLabel();
      this.vd = new JPanel();
      this.ut = new JScrollPane();
      this.JG = new JTable();
      this.Mf = new JButton();
      this.Mo = new JLabel();
      this.Md = new JButton();
      this.wf = new JPanel();
      this.Mt = new JLabel();
      this.Mh = new JCheckBox();
      this.Mj = new JCheckBox();
      this.Mc = new JButton();
      this.afz = new JCheckBox();
      this.we = new JPanel();
      this.Mp = new JLabel();
      this.Mb = new JButton();
      this.My = new JScrollPane();
      this.Mz = new JTable();
      this.Mk = new JCheckBox();
      this.Me = new JButton();
      this.Mq = new JLabel();
      this.Mi = new JCheckBox();
      this.Mg = new JButton();
      this.Bw = new JButton();
      this.wg = new JPanel();
      this.Mr = new JLabel();
      this.Mw = new JRadioButton();
      this.Mx = new JRadioButton();
      this.Ms = new JLabel();
      this.Mu = new JRadioButton();
      this.Mv = new JRadioButton();
      this.afB = new JLabel();
      this.afA = new JComboBox();
      this.ug = new JLabel();
      this.setBackground(new Color(7, 55, 88));
      this.setAlignmentX(0.0F);
      this.setAlignmentY(0.0F);
      this.setPreferredSize(new Dimension(1024, 728));
      this.vf.setFont(new Font("Tahoma", 1, 18));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setHorizontalAlignment(0);
      this.vf.setText("Configurações iniciais");
      this.a_.setFont(new Font("Tahoma", 1, 24));
      this.a_.setForeground(new Color(230, 175, 75));
      this.a_.setHorizontalAlignment(0);
      this.a_.setText("Brasfoot");
      this.vd.setBackground(new Color(7, 55, 88));
      this.ut.setViewportView(this.JG);
      this.Mf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsellall.png")));
      this.Mo.setBackground(new Color(7, 28, 39));
      this.Mo.setFont(new Font("Tahoma", 1, 14));
      this.Mo.setForeground(new Color(255, 255, 153));
      this.Mo.setText(" Ligas Nacionais");
      this.Mo.setOpaque(true);
      this.Md.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
      this.Md.setText("configurar");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap(43, 32767)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(4, 4, 4)
                              .addComponent(this.ut, -2, 302, -2)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.Md).addComponent(this.Mf, -2, 43, -2))
                        )
                        .addComponent(this.Mo, -1, -1, 32767)
                  )
                  .addGap(36, 36, 36)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addComponent(this.Mo, -2, 28, -2)
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addComponent(this.Md).addGap(214, 214, 214).addComponent(this.Mf))
                        .addComponent(this.ut, -2, 284, -2)
                  )
                  .addContainerGap(22, 32767)
            )
      );
      this.wf.setBackground(new Color(7, 28, 39));
      this.Mt.setFont(new Font("Tahoma", 1, 14));
      this.Mt.setForeground(new Color(255, 255, 153));
      this.Mt.setText("Competições internacionais");
      this.Mh.setFont(new Font("Tahoma", 0, 14));
      this.Mh.setForeground(new Color(255, 255, 255));
      this.Mh.setText("Jogar competições de seleções");
      this.Mh.setOpaque(false);
      this.Mj.setFont(new Font("Tahoma", 0, 14));
      this.Mj.setForeground(new Color(255, 255, 255));
      this.Mj.setText("Jogar taças internacionais de clubes");
      this.Mj.setOpaque(false);
      this.Mc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
      this.Mc.setText("Preferências");
      this.afz.setFont(new Font("Tahoma", 0, 14));
      this.afz.setForeground(new Color(255, 255, 255));
      this.afz.setText("Usar grupos da Copa do Mundo 2022");
      this.afz.setOpaque(false);
      GroupLayout var2 = new GroupLayout(this.wf);
      this.wf.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(21, 21, 21)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(var2.createSequentialGroup().addComponent(this.Mj, -1, -1, 32767).addGap(123, 123, 123))
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.afz)
                                    .addComponent(this.Mh)
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addComponent(this.Mt, -2, 295, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.Mc)
                                    )
                              )
                              .addGap(0, 28, 32767)
                        )
                  )
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(var2.createSequentialGroup().addComponent(this.Mt).addGap(24, 24, 24))
                        .addGroup(Alignment.TRAILING, var2.createSequentialGroup().addComponent(this.Mc).addPreferredGap(ComponentPlacement.RELATED))
                  )
                  .addComponent(this.Mj)
                  .addGap(18, 18, 18)
                  .addComponent(this.Mh, -2, 39, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.afz, -2, 39, -2)
                  .addContainerGap(-1, 32767)
            )
      );
      this.we.setBackground(new Color(7, 55, 88));
      this.Mp.setBackground(new Color(7, 28, 39));
      this.Mp.setFont(new Font("Tahoma", 1, 14));
      this.Mp.setForeground(new Color(255, 255, 153));
      this.Mp.setText(" Estaduais");
      this.Mp.setOpaque(true);
      this.Mb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
      this.Mb.setText("configurar");
      this.My.setViewportView(this.Mz);
      this.Mk.setFont(new Font("Tahoma", 0, 14));
      this.Mk.setForeground(new Color(255, 255, 255));
      this.Mk.setText("Jogar regionais");
      this.Mk.setToolTipText("");
      this.Mk.setOpaque(false);
      this.Me.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
      this.Me.setText("configurar");
      this.Mq.setBackground(new Color(7, 28, 39));
      this.Mq.setFont(new Font("Tahoma", 1, 14));
      this.Mq.setForeground(new Color(255, 255, 153));
      this.Mq.setText("Regionais");
      this.Mq.setOpaque(true);
      this.Mi.setFont(new Font("Tahoma", 0, 14));
      this.Mi.setForeground(new Color(255, 255, 255));
      this.Mi.setText("Jogar estaduais");
      this.Mi.setOpaque(false);
      GroupLayout var3 = new GroupLayout(this.we);
      this.we.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addComponent(this.Mp, -1, -1, 32767)
            .addGroup(
               var3.createSequentialGroup()
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           Alignment.TRAILING,
                           var3.createSequentialGroup()
                              .addComponent(this.My, -2, 264, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.Mb)
                        )
                        .addComponent(this.Mq, -1, -1, 32767)
                        .addGroup(var3.createSequentialGroup().addComponent(this.Mi, -2, 254, -2).addGap(0, 0, 32767))
                        .addGroup(
                           var3.createSequentialGroup()
                              .addComponent(this.Mk, -2, 254, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.Me)
                        )
                  )
                  .addContainerGap()
            )
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var3.createSequentialGroup()
                  .addComponent(this.Mp, -2, 31, -2)
                  .addGap(18, 18, 18)
                  .addGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.Mb).addComponent(this.My, -2, 168, -2))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.Mi, -2, 25, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, 10, 32767)
                  .addComponent(this.Mq, -2, 26, -2)
                  .addGap(18, 18, 18)
                  .addGroup(var3.createParallelGroup(Alignment.BASELINE).addComponent(this.Mk, -2, 25, -2).addComponent(this.Me))
            )
      );
      this.Mg.setFont(new Font("Tahoma", 1, 12));
      this.Mg.setText("<< Voltar ao início");
      this.Bw.setFont(new Font("Tahoma", 1, 12));
      this.Bw.setText("Iniciar Jogo >>");
      this.wg.setBackground(new Color(7, 28, 39));
      this.Mr.setFont(new Font("Tahoma", 1, 14));
      this.Mr.setForeground(new Color(255, 255, 153));
      this.Mr.setText("Sistema de salários");
      this.Mm.add(this.Mw);
      this.Mw.setFont(new Font("Tahoma", 0, 14));
      this.Mw.setForeground(new Color(255, 255, 255));
      this.Mw.setText("Mensal");
      this.Mw.setOpaque(false);
      this.Mm.add(this.Mx);
      this.Mx.setFont(new Font("Tahoma", 0, 14));
      this.Mx.setForeground(new Color(255, 255, 255));
      this.Mx.setText("Semanal");
      this.Mx.setOpaque(false);
      this.Ms.setFont(new Font("Tahoma", 1, 14));
      this.Ms.setForeground(new Color(255, 255, 153));
      this.Ms.setText("Sistema de força dos jogadores");
      this.Ml.add(this.Mu);
      this.Mu.setFont(new Font("Tahoma", 0, 14));
      this.Mu.setForeground(new Color(255, 255, 255));
      this.Mu.setText("Modo clássico");
      this.Mu.setOpaque(false);
      this.Ml.add(this.Mv);
      this.Mv.setFont(new Font("Tahoma", 0, 14));
      this.Mv.setForeground(new Color(255, 255, 255));
      this.Mv.setText("Individual");
      this.Mv.setOpaque(false);
      this.afB.setFont(new Font("Tahoma", 1, 14));
      this.afB.setForeground(new Color(255, 255, 153));
      this.afB.setText("Temporada de início");
      GroupLayout var4 = new GroupLayout(this.wg);
      this.wg.setLayout(var4);
      var4.setHorizontalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addGap(40, 40, 40)
                  .addGroup(
                     var4.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.afB, -2, 254, -2)
                        .addComponent(this.Ms, -2, 254, -2)
                        .addGroup(var4.createSequentialGroup().addComponent(this.Mw).addGap(87, 87, 87).addComponent(this.Mx, -2, 117, -2))
                        .addComponent(this.Mr, -2, 254, -2)
                        .addGroup(var4.createSequentialGroup().addComponent(this.Mv, -2, 136, -2).addGap(18, 18, 18).addComponent(this.Mu, -2, 203, -2))
                        .addComponent(this.afA, -2, 119, -2)
                  )
                  .addContainerGap(23, 32767)
            )
      );
      var4.setVerticalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addGap(9, 9, 9)
                  .addComponent(this.Mr)
                  .addGap(18, 18, 18)
                  .addGroup(var4.createParallelGroup(Alignment.LEADING).addComponent(this.Mx).addComponent(this.Mw))
                  .addGap(18, 18, 18)
                  .addComponent(this.Ms)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var4.createParallelGroup(Alignment.BASELINE).addComponent(this.Mv).addComponent(this.Mu))
                  .addGap(18, 18, 18)
                  .addComponent(this.afB)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.afA, -1, 27, 32767)
                  .addContainerGap()
            )
      );
      this.ug.setForeground(new Color(255, 255, 153));
      this.ug
         .setText(
            "<html>Algumas opções só estão disponíveis no Brasfoot registrado. Como jogar estaduais, Libertadores, Liga dos Campeões, Copa do Mundo, Copa América, Eurocopa etc.</html>"
         );
      GroupLayout var5 = new GroupLayout(this);
      this.setLayout(var5);
      var5.setHorizontalGroup(
         var5.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var5.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.ug, -2, 0, 32767)
                        .addComponent(this.vd, -1, -1, 32767)
                        .addComponent(this.wf, Alignment.TRAILING, -2, -1, -2)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           Alignment.TRAILING,
                           var5.createSequentialGroup()
                              .addGap(21, 21, 21)
                              .addComponent(this.Mg, -2, 166, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.Bw, -2, 166, -2)
                              .addGap(15, 15, 15)
                        )
                        .addComponent(this.wg, -1, -1, 32767)
                        .addComponent(this.we, -1, -1, 32767)
                  )
                  .addContainerGap(59, 32767)
            )
            .addGroup(
               var5.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.a_, -1, 1004, 32767)
                        .addComponent(this.vf, Alignment.TRAILING, -1, -1, 32767)
                  )
                  .addContainerGap()
            )
      );
      var5.setVerticalGroup(
         var5.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var5.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.a_)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vf)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var5.createParallelGroup(Alignment.LEADING).addComponent(this.vd, -2, -1, -2).addComponent(this.we, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var5.createParallelGroup(Alignment.TRAILING).addComponent(this.wg, -1, -1, 32767).addComponent(this.wf, -1, -1, 32767))
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(var5.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.ug).addGap(31, 31, 31))
                        .addGroup(
                           Alignment.TRAILING,
                           var5.createSequentialGroup()
                              .addGap(11, 11, 11)
                              .addGroup(var5.createParallelGroup(Alignment.BASELINE).addComponent(this.Mg, -2, 32, -2).addComponent(this.Bw, -2, 32, -2))
                              .addGap(28, 28, 28)
                        )
                  )
            )
      );
   }
}
