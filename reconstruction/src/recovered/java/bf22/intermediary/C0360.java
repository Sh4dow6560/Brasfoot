package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public class C0360 extends JPanel {
   private JDialog ub = null;
   private Coach Es = null;
   private Club Em = null;
   private ArrayList Kh = new ArrayList();
   private ArrayList uK = new ArrayList();
   private int w = 0;
   private JButton Ki;
   private JButton HR;
   private JButton Kj;
   private JButton HY;
   private JButton aeN;
   private ButtonGroup Kl;
   private JLabel ug;
   private JLabel uh;
   private JLabel ur;
   private JPanel vd;
   private JScrollPane ut;
   private JScrollPane wi;
   private JToolBar ve;
   private JLabel Fs;
   private JLabel uu;
   private JTable zj;
   private JTable vn;

   public C0360(JDialog jDialog, ArrayList arrayList, Coach coach, int i) {
      this.ub = jDialog;
      this.Kh = arrayList;
      this.Es = coach;
      this.w = i;
      this.mJ();
      this.Fs.setText(this.Es.getName());
      this.Ay();
      this.mH();
      this.AP();
      if (this.Kh.size() > 0) {
         this.vn.setRowSelectionInterval(0, 0);
      }
   }

   private void AP() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      if (this.w == 0) {
         this.ug.setText("Convites para ser técnico");
         this.Ki.setText("Assumir time");
         this.uh.setText("Equipe atual");
      }
   }

   public void mH() {
      this.Ki.addActionListener(new C0361(this));
      this.Kj.addActionListener(new C0362(this));
      this.HR.addActionListener(new C0363(this));
      this.aeN.addActionListener(new C0364(this));
      this.HY.addActionListener(new C0365(this));
   }

   private void qP() {
      this.HY.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0447 var2 = new C0447(var1, this.Em);
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

   private void AA() {
      this.aeN.setCursor(new Cursor(3));
      MainWindow.a(0, null);
      this.aeN.setCursor(new Cursor(12));
   }

   private void sD() {
      this.HR.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0012 var2 = new C0012(var1, this.Em);
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

   private void rT() {
      if (this.w == 0) {
         if (this.Es.getClub() != null) {
            this.Es.getClub().kE();
         }

         GamePersistence.careerState.a(this.Em, this.Em.getCoach(), this.Es);
         this.ub.dispose();
      } else {
         CountryCompetitions var1 = GamePersistence.careerState.s(this.Em.getPais());
         if (var1 != null && this.Es != null) {
            var1.g(this.Es);
         } else {
            this.ub.dispose();
         }
      }
   }

   private void rW() {
      String var1 = "";
      Icon var2 = null;
      if (this.w == 0) {
         var1 = this.Em.getNome();
         var2 = this.Em.kU();
      } else {
         var1 = C0696.values()[this.Em.getPais()].getNome();
         var2 = new ImageIcon(this.getClass().getResource("/aflags/" + this.Em.getPais() + ".png"));
      }

      this.uu.setText(var1);
      this.uu.setIcon(var2);
      this.uK.clear();
      this.uK.addAll(this.Em.getSeniorPlayers());
      this.nE();
   }

   private void Ay() {
      C0612 var1 = new C0612(this.Kh);
      this.vn.setModel(var1);
      int[] var2 = new int[]{40, 200, 200};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vn.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vn.getColumnModel().getColumn(0).setMaxWidth(40);
      this.vn.getColumnModel().getColumn(1).setMaxWidth(200);
      this.vn.getColumnModel().getColumn(2).setMaxWidth(200);
      this.vn.setAutoResizeMode(3);
      this.vn.setRowHeight(20);
      this.vn.setShowGrid(false);
      this.vn.setDefaultRenderer(Club.class, new C0614(this.w));
      this.vn.setAutoCreateRowSorter(false);
      this.vn.getTableHeader().setReorderingAllowed(false);
      this.vn.setIntercellSpacing(new Dimension(0, 0));
      this.vn.setCellSelectionEnabled(false);
      this.vn.setSelectionMode(0);
      this.vn.setRowSelectionAllowed(true);
      this.vn.setSelectionBackground(Color.YELLOW);
      this.vn.setFillsViewportHeight(true);
      this.vn.setTableHeader(null);
      this.vn.getSelectionModel().addListSelectionListener(new C0366(this));
   }

   private void nE() {
      C0586 var1 = new C0586(this.uK);
      this.zj.setModel(var1);
      int[] var2 = new int[]{22, 22, 55, 140, 22, 22, 50, 50, 55, 30, 0, 0};
      int[] var3 = new int[]{20, 15, 20, 130, 20, 22, 22, 22, 22, 22, 22, 22, 50, 50, 50, 20, 30, 0, 0};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = var3;
         this.zj.getColumnModel().getColumn(18).setMinWidth(0);
         this.zj.getColumnModel().getColumn(18).setMaxWidth(0);
         this.zj.getColumnModel().getColumn(18).setWidth(0);
         this.zj.getColumnModel().getColumn(19).setMinWidth(0);
         this.zj.getColumnModel().getColumn(19).setMaxWidth(0);
         this.zj.getColumnModel().getColumn(19).setWidth(0);
      } else {
         try {
            this.zj.getColumnModel().getColumn(12).setMinWidth(0);
            this.zj.getColumnModel().getColumn(12).setMaxWidth(0);
            this.zj.getColumnModel().getColumn(12).setWidth(0);
            this.zj.getColumnModel().getColumn(13).setMinWidth(0);
            this.zj.getColumnModel().getColumn(13).setMaxWidth(0);
            this.zj.getColumnModel().getColumn(13).setWidth(0);
         } catch (Exception var5) {
         }
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
      TableRowSorter var6 = new TableRowSorter<>(this.zj.getModel());
      this.zj.setRowSorter(var6);
      var6.setComparator(0, C1007.abe);
      var6.setComparator(2, C1007.cL);
      var6.setComparator(3, C1007.abk);
      var6.setComparator(4, C1007.aba);
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         var6.setComparator(5, C1007.aaJ);
         var6.setComparator(6, C1007.aaZ);
         var6.setComparator(7, C1007.aaW);
         var6.setComparator(9, C1007.abd);
         var6.setComparator(10, C1007.VU);
      } else {
         var6.setComparator(5, C1007.aaK);
         var6.setComparator(6, C1007.aaM);
         var6.setComparator(7, C1007.aaL);
         var6.setComparator(8, C1007.aaN);
         var6.setComparator(9, C1007.aaP);
         var6.setComparator(10, C1007.aaO);
         var6.setComparator(11, C1007.aaQ);
         var6.setComparator(12, C1007.aaZ);
         var6.setComparator(13, C1007.aaW);
         var6.setComparator(15, C1007.abd);
         var6.setComparator(16, C1007.VU);
      }
   }

   private void mJ() {
      this.Kl = new ButtonGroup();
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.Fs = new JLabel();
      this.wi = new JScrollPane();
      this.vn = new JTable();
      this.Ki = new JButton();
      this.Kj = new JButton();
      this.ve = new JToolBar();
      this.HR = new JButton();
      this.aeN = new JButton();
      this.HY = new JButton();
      this.ur = new JLabel();
      this.uu = new JLabel();
      this.ut = new JScrollPane();
      this.zj = new JTable();
      this.uh = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setPreferredSize(new Dimension(774, 724));
      this.vd.setBackground(new Color(44, 53, 49));
      this.ug.setBackground(new Color(255, 255, 255));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Convites para ser técnico de seleção");
      this.ug.setToolTipText("");
      this.Fs.setBackground(new Color(255, 255, 255));
      this.Fs.setFont(new Font("Tahoma", 1, 11));
      this.Fs.setForeground(new Color(255, 255, 204));
      this.Fs.setHorizontalAlignment(0);
      this.Fs.setText("tecnico nome");
      this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.wi.setViewportView(this.vn);
      this.Ki.setFont(new Font("Tahoma", 0, 12));
      this.Ki.setForeground(new Color(0, 102, 0));
      this.Ki.setText("Assumir seleção");
      this.Kj.setFont(new Font("Tahoma", 0, 12));
      this.Kj.setForeground(new Color(0, 102, 0));
      this.Kj.setText("Rejeitar todos");
      this.ve.setBackground(new Color(0, 51, 51));
      this.ve.setRollover(true);
      this.ve.setBorderPainted(false);
      this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
      this.HR.setBorderPainted(false);
      this.HR.setFocusable(false);
      this.HR.setHorizontalTextPosition(0);
      this.HR.setOpaque(false);
      this.HR.setVerticalTextPosition(3);
      this.ve.add(this.HR);
      this.aeN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tabel.png")));
      this.aeN.setBorderPainted(false);
      this.aeN.setFocusable(false);
      this.aeN.setHorizontalTextPosition(0);
      this.aeN.setOpaque(false);
      this.aeN.setVerticalTextPosition(3);
      this.ve.add(this.aeN);
      this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
      this.HY.setBorderPainted(false);
      this.HY.setFocusable(false);
      this.HY.setHorizontalTextPosition(0);
      this.HY.setMaximumSize(new Dimension(31, 31));
      this.HY.setOpaque(false);
      this.HY.setVerticalTextPosition(3);
      this.ve.add(this.HY);
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setText("Comvites recebidos:");
      this.ur.setToolTipText("");
      this.uu.setForeground(new Color(255, 255, 255));
      this.uu.setHorizontalAlignment(2);
      this.uu.setText("\"Seleção\"");
      this.uu.setToolTipText("");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.ug, -1, -1, 32767))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(24, 24, 24)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.ur, Alignment.TRAILING, -1, -1, 32767)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.wi, -2, 424, -2)
                                          .addGap(18, 18, 18)
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.ve, -2, 234, -2)
                                                .addComponent(this.uu, -2, 246, -2)
                                                .addComponent(this.Kj, -2, 173, -2)
                                                .addComponent(this.Ki, -2, 173, -2)
                                          )
                                          .addGap(0, 1, 32767)
                                    )
                              )
                        )
                        .addGroup(var1.createSequentialGroup().addGap(226, 226, 226).addComponent(this.Fs, -2, 261, -2).addGap(0, 0, 32767))
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Fs)
                  .addGap(40, 40, 40)
                  .addComponent(this.ur)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.ve, -2, -1, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.uu)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.Ki, -2, 30, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.Kj, -2, 31, -2)
                        )
                        .addComponent(this.wi, -2, 287, -2)
                  )
                  .addContainerGap(22, 32767)
            )
      );
      this.zj.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.ut.setViewportView(this.zj);
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("Última convocação:");
      this.uh.setToolTipText("");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap(20, 32767)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, var2.createSequentialGroup().addComponent(this.vd, -2, -1, -2).addGap(29, 29, 29))
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.uh, -2, 729, -2).addComponent(this.ut, -2, 719, -2))
                              .addGap(20, 20, 20)
                        )
                  )
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(21, 21, 21)
                  .addComponent(this.vd, -2, -1, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.uh)
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -2, 206, -2)
                  .addContainerGap(24, 32767)
            )
      );
   }
}
