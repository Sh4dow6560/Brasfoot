package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
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
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0350 extends JPanel {
   private JDialog ub = null;
   private Coach Es = null;
   private Club Em = null;
   private ArrayList aeL = new ArrayList();
   private int w = 0;
   private JButton HR;
   private JButton aeM;
   private JButton Kj;
   private JButton HY;
   private JButton aeN;
   private JButton uZ;
   private JButton Ib;
   private ButtonGroup Kl;
   private JLabel ug;
   private JPanel vd;
   private JScrollPane zf;
   private JToolBar ve;
   private JToolBar Iv;
   private JLabel zh;
   private JLabel uu;
   private JLabel zP;
   private JTable vn;

   public C0350(JDialog jDialog, Coach coach) {
      this.ub = jDialog;
      this.Es = coach;
      this.mJ();
      this.zP.setText("");
      this.zh.setText("");
      this.mH();
      this.mG();
      this.fu(0);
   }

   private ArrayList Ax() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      if (this.w == 0) {
         var1.addAll(GamePersistence.coachJobMarket.Ap());
         if (var1.size() == 0) {
            GamePersistence.coachJobMarket.zj();
            var1.addAll(GamePersistence.coachJobMarket.Ap());
         }
      } else {
         var1.addAll(GamePersistence.coachJobMarket.Aq());
      }

      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();

      for (int var8 = 0; var8 < var1.size(); var8++) {
         if (((Club)var1.get(var8)).getReputacao() == 1) {
            var3.add((Club)var1.get(var8));
         } else if (((Club)var1.get(var8)).getReputacao() == 2) {
            var4.add((Club)var1.get(var8));
         } else if (((Club)var1.get(var8)).getReputacao() == 3) {
            var5.add((Club)var1.get(var8));
         } else if (((Club)var1.get(var8)).getReputacao() == 4) {
            var6.add((Club)var1.get(var8));
         } else if (((Club)var1.get(var8)).getReputacao() == 5) {
            var7.add((Club)var1.get(var8));
         }
      }

      if (this.w == 0) {
         if (this.Es.getReputacao() == 5) {
            this.a(var2, var7, 1);
            this.a(var2, var6, 1);
            this.a(var2, var5, 2);
            this.a(var2, var4, 1);
            this.a(var2, var3, 1);
         } else if (this.Es.getReputacao() == 4) {
            this.a(var2, var6, 1);
            this.a(var2, var5, 1);
            this.a(var2, var4, 2);
            this.a(var2, var3, 1);
         } else if (this.Es.getReputacao() == 3) {
            this.a(var2, var5, 1);
            this.a(var2, var4, 2);
            this.a(var2, var3, 1);
         } else if (this.Es.getReputacao() == 2) {
            this.a(var2, var5, 2);
            this.a(var2, var4, 2);
            this.a(var2, var3, 1);
         } else {
            this.a(var2, var4, 2);
            this.a(var2, var3, 2);
         }
      } else if (this.Es.getReputacao() == 5) {
         this.a(var2, var7, 1);
         this.a(var2, var6, 2);
         this.a(var2, var5, 3);
         this.a(var2, var4, 3);
         this.a(var2, var3, 3);
      } else if (this.Es.getReputacao() == 4) {
         this.a(var2, var6, 2);
         this.a(var2, var5, 2);
         this.a(var2, var4, 3);
         this.a(var2, var3, 3);
      } else if (this.Es.getReputacao() == 3) {
         this.a(var2, var5, 2);
         this.a(var2, var4, 3);
         this.a(var2, var3, 3);
      } else if (this.Es.getReputacao() == 2) {
         this.a(var2, var5, 2);
         this.a(var2, var4, 3);
         this.a(var2, var3, 3);
      } else {
         this.a(var2, var4, 3);
         this.a(var2, var3, 3);
      }

      return var2;
   }

   public void a(ArrayList arrayList, ArrayList arrayList2, int i) {
      int[] var4 = new int[]{0, 1, 2, 3, 4, 5};
      if (this.w == 1) {
         for (int var6 = 0; var6 < var4.length; var6++) {
            int var5 = i;

            for (int var7 = 0; var7 < arrayList2.size(); var7++) {
               if (var4[var6] == ((Club)arrayList2.get(var7)).gg() && !arrayList.contains(arrayList2.get(var7))) {
                  arrayList.add((Club)arrayList2.get(var7));
                  var5--;
               }

               if (var5 <= 0) {
                  break;
               }
            }
         }
      } else {
         for (int var11 = 0; var11 < GamePersistence.careerState.N().size(); var11++) {
            int var12 = ((CountryCompetitions)GamePersistence.careerState.N().get(var11)).eb().size();
            int var8 = ((CountryCompetitions)GamePersistence.careerState.N().get(var11)).jc();

            for (int var9 = 0; var9 < var12; var9++) {
               for (int var10 = 0; var10 < arrayList2.size(); var10++) {
                  if (((Club)arrayList2.get(var10)).getPais() == var8 && ((Club)arrayList2.get(var10)).getDivisao() == var9 + 1) {
                     arrayList.add((Club)arrayList2.get(var10));
                  }
               }
            }
         }
      }
   }

   private void Ay() {
      C0612 var1 = new C0612(this.aeL);
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
      this.vn.setIntercellSpacing(new Dimension(0, 0));
      this.vn.setCellSelectionEnabled(false);
      this.vn.setSelectionMode(0);
      this.vn.setRowSelectionAllowed(true);
      this.vn.setSelectionBackground(Color.YELLOW);
      this.vn.setFillsViewportHeight(true);
      this.vn.setTableHeader(null);
      this.vn.getSelectionModel().addListSelectionListener(new C0351(this));
   }

   private void rW() {
      String var1 = "";
      ImageIcon var2 = null;
      if (this.Em != null) {
         if (this.w == 0) {
            var1 = this.Em.getNome();
            var2 = this.Em.kU();
         } else {
            var1 = C0696.values()[this.Em.getPais()].getNome();
            var2 = new ImageIcon(this.getClass().getResource("/aflags/" + this.Em.getPais() + ".png"));
         }
      }

      this.zP.setText(var1);
      this.zP.setIcon(var2);
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void Az() {
      if (this.Em != null) {
         if (this.w == 0) {
            if (this.Es.getClub() != null) {
               this.Es.getClub().kE();
            }

            GamePersistence.careerState.a(this.Em, this.Em.getCoach(), this.Es);
            C0272.aQ(true);
            this.ub.dispose();
            GamePersistence.careerState.g(true);
            GamePersistence.careerState.ap();
         } else {
            CountryCompetitions var1 = GamePersistence.careerState.s(this.Em.getPais());
            if (var1 != null && this.Es != null) {
               var1.g(this.Es);
               C0272.aR(true);
               C0272.aQ(true);
               this.ub.dispose();
            } else {
               this.ub.dispose();
            }
         }
      }
   }

   public void mH() {
      this.aeM.addActionListener(new C0352(this));
      this.Kj.addActionListener(new C0353(this));
      this.HR.addActionListener(new C0354(this));
      this.aeN.addActionListener(new C0355(this));
      this.HY.addActionListener(new C0356(this));
      this.Ib.addActionListener(new C0357(this));
      this.uZ.addActionListener(new C0358(this));
   }

   private void ft(int i) {
      this.fu(i);
   }

   private void fu(int i) {
      this.Em = null;
      this.w = i;
      this.aeL.clear();
      this.aeL.addAll(this.Ax());
      this.Ay();
      if (this.aeL.size() > 0) {
         this.vn.setRowSelectionInterval(0, 0);
      }

      if (i == 0) {
         this.a(this.Ib, this.uZ);
         this.aeM.setText("Assumir time");
      } else {
         this.a(this.uZ, this.Ib);
         this.aeM.setText("Assumir Seleção");
      }

      this.rW();
   }

   private void a(JButton jButton, JButton jButton2) {
      jButton.setFont(new Font("Tahoma", 1, 14));
      jButton.setForeground(new Color(255, 255, 153));
      jButton2.setFont(new Font("Tahoma", 0, 12));
      jButton2.setForeground(new Color(255, 255, 255));
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

   private void AA() {
      this.aeN.setCursor(new Cursor(3));
      MainWindow.a(0, null);
      this.aeN.setCursor(new Cursor(12));
   }

   private void mJ() {
      this.Kl = new ButtonGroup();
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.Kj = new JButton();
      this.ve = new JToolBar();
      this.HR = new JButton();
      this.HY = new JButton();
      this.aeN = new JButton();
      this.uu = new JLabel();
      this.zf = new JScrollPane();
      this.vn = new JTable();
      this.aeM = new JButton();
      this.Iv = new JToolBar();
      this.Ib = new JButton();
      this.uZ = new JButton();
      this.zh = new JLabel();
      this.zP = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vd.setBackground(new Color(44, 53, 49));
      this.ug.setBackground(new Color(255, 255, 255));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Central de Empregos");
      this.ug.setToolTipText("");
      this.Kj.setFont(new Font("Tahoma", 0, 12));
      this.Kj.setForeground(new Color(0, 102, 0));
      this.Kj.setText("X");
      this.ve.setBackground(new Color(0, 51, 51));
      this.ve.setRollover(true);
      this.ve.setBorderPainted(false);
      this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
      this.HR.setBorderPainted(false);
      this.HR.setFocusable(false);
      this.HR.setHorizontalTextPosition(0);
      this.HR.setMargin(new Insets(2, 2, 2, 7));
      this.HR.setOpaque(false);
      this.HR.setVerticalTextPosition(3);
      this.ve.add(this.HR);
      this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
      this.HY.setBorderPainted(false);
      this.HY.setFocusable(false);
      this.HY.setHorizontalTextPosition(0);
      this.HY.setMargin(new Insets(2, 0, 2, 7));
      this.HY.setMaximumSize(new Dimension(31, 31));
      this.HY.setOpaque(false);
      this.HY.setVerticalTextPosition(3);
      this.ve.add(this.HY);
      this.aeN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tabel.png")));
      this.aeN.setBorderPainted(false);
      this.aeN.setFocusable(false);
      this.aeN.setHorizontalTextPosition(0);
      this.aeN.setMargin(new Insets(2, 16, 2, 14));
      this.aeN.setMaximumSize(new Dimension(31, 31));
      this.aeN.setOpaque(false);
      this.aeN.setVerticalTextPosition(3);
      this.ve.add(this.aeN);
      this.uu.setForeground(new Color(255, 255, 255));
      this.uu.setHorizontalAlignment(0);
      this.uu.setText("(Você pode se candidatar a assumir times ou seleções da lista que buscam novos técnicos)");
      this.uu.setToolTipText("");
      this.zf.setViewportView(this.vn);
      this.aeM.setFont(new Font("Tahoma", 1, 12));
      this.aeM.setForeground(new Color(0, 51, 0));
      this.aeM.setText("Assumir seleção");
      this.Iv.setBackground(new Color(35, 28, 14));
      this.Iv.setFloatable(false);
      this.Iv.setRollover(true);
      this.Iv.setBorderPainted(false);
      this.Ib.setFont(new Font("Tahoma", 1, 14));
      this.Ib.setForeground(new Color(255, 255, 153));
      this.Ib.setText("Times");
      this.Ib.setBorderPainted(false);
      this.Ib.setContentAreaFilled(false);
      this.Ib.setFocusable(false);
      this.Ib.setHorizontalTextPosition(0);
      this.Ib.setMargin(new Insets(0, 0, 0, 0));
      this.Ib.setMaximumSize(new Dimension(79, 45));
      this.Ib.setMinimumSize(new Dimension(79, 45));
      this.Ib.setPreferredSize(new Dimension(79, 45));
      this.Ib.setVerticalTextPosition(3);
      this.Iv.add(this.Ib);
      this.uZ.setFont(new Font("Tahoma", 0, 12));
      this.uZ.setForeground(new Color(255, 255, 255));
      this.uZ.setText("Seleções");
      this.uZ.setBorderPainted(false);
      this.uZ.setContentAreaFilled(false);
      this.uZ.setFocusable(false);
      this.uZ.setHorizontalTextPosition(0);
      this.uZ.setMargin(new Insets(0, 0, 0, 0));
      this.uZ.setMaximumSize(new Dimension(79, 45));
      this.uZ.setMinimumSize(new Dimension(79, 45));
      this.uZ.setPreferredSize(new Dimension(79, 45));
      this.uZ.setVerticalTextPosition(3);
      this.Iv.add(this.uZ);
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setText("\"Seleção\"");
      this.zh.setToolTipText("");
      this.zP.setForeground(new Color(255, 255, 255));
      this.zP.setText("\"Seleção\"");
      this.zP.setToolTipText("");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.ug, -1, -1, 32767)
                                    .addGroup(var1.createSequentialGroup().addComponent(this.uu, -2, 593, -2).addGap(0, 0, 32767))
                              )
                              .addGap(18, 18, 18)
                              .addComponent(this.Kj, -2, 47, -2)
                              .addGap(11, 11, 11)
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(20, 20, 20)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.zh, -1, -1, 32767)
                                    .addGroup(var1.createSequentialGroup().addComponent(this.Iv, -2, 437, -2).addGap(0, 0, 32767))
                              )
                        )
                        .addGroup(
                           Alignment.TRAILING,
                           var1.createSequentialGroup()
                              .addGap(0, 0, 32767)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(this.aeM, -2, 173, -2)
                                    .addComponent(this.zP, Alignment.TRAILING, -1, -1, 32767)
                                    .addComponent(this.ve, Alignment.TRAILING, -1, 216, 32767)
                              )
                        )
                  )
                  .addContainerGap()
            )
            .addGroup(
               var1.createParallelGroup(Alignment.LEADING)
                  .addGroup(var1.createSequentialGroup().addGap(20, 20, 20).addComponent(this.zf, -2, 435, -2).addContainerGap(234, 32767))
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(19, 19, 19).addComponent(this.Kj, -2, 31, -2))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(this.ug)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.uu)
                        )
                  )
                  .addGap(14, 14, 14)
                  .addComponent(this.Iv, -2, 33, -2)
                  .addGap(12, 12, 12)
                  .addComponent(this.ve, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, 387, 32767)
                  .addComponent(this.zP)
                  .addGap(22, 22, 22)
                  .addComponent(this.aeM, -2, 30, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.zh)
                  .addContainerGap()
            )
            .addGroup(
               var1.createParallelGroup(Alignment.LEADING)
                  .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addContainerGap(107, 32767).addComponent(this.zf, -2, 500, -2).addGap(34, 34, 34))
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, 679, 32767).addContainerGap())
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, -1, -2).addContainerGap(14, 32767))
      );
   }
}
