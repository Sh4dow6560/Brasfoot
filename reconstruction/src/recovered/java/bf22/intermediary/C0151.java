package bf22.intermediary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Coach;

public class C0151 extends JPanel {
   private JFrame Br;
   private ArrayList DJ = new ArrayList();
   private ArrayList DK = new ArrayList();
   private ArrayList DL = new ArrayList();
   private C0692 DM = null;
   private static Timer Dk;
   private JButton DN;
   private JButton DO;
   private JButton DP;
   private JComboBox ue;
   private JScrollPane ut;
   private JScrollPane wi;
   private JScrollPane zf;
   private JLabel DQ;
   private JLabel DR;
   private JLabel BL;
   private JLabel vf;
   private JTable DS;
   private JTable DT;
   private JTable DU;

   public void oR() {
      Dk = new Timer();
      Dk.schedule(new C0152(this), 0L);
   }

   public C0151(JFrame jFrame) {
      this.Br = jFrame;
      this.mJ();
      this.DN.setVisible(false);
      C0745.SR.isJogaIntClubes();

      for (int var2 = 0; var2 < C0745.SR.N().size(); var2++) {
         this.ue.addItem(((C0692)C0745.SR.N().get(var2)).jp());
      }

      C0037 var3 = new C0037();
      var3.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var3);
      this.ue.setMaximumRowCount(12);
      this.ue.addActionListener(new C0153(this));
      this.mH();
      this.ue.setSelectedIndex(0);
      this.pk();
      if (C0745.SR.isJogaEstadual() || C0745.SR.isJogaRegionais()) {
         this.pj();
      }

      if (C0745.SR.isJogaIntClubes()) {
         this.pi();
      }

      if (C0745.SR.bD()) {
         this.oR();
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   private void pi() {
      C0713[] var1 = C0745.SR.bB();

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2] != null) {
            C0727 var3 = var1[var2].mo();
            if (var3 != null) {
               String var4 = var1[var2].getNome();
               this.a(this.DK, var3, var4, -1);
            }
         }
      }

      this.a(this.DT, this.DK);
   }

   private void pj() {
      this.DL.clear();
      if (C0745.SR.isJogaRegionais()) {
         for (int var1 = 0; var1 < C0745.SR.bV().length; var1++) {
            if (C0745.SR.bV()[var1] != null) {
               int var2 = 100 + var1;
               String var3 = C0710.pY[var1];
               this.a(this.DL, C0745.SR.bV()[var1].mo(), var3, var2);
            }
         }
      }

      if (C0745.SR.isJogaEstadual()) {
         for (int var5 = 0; var5 < C0745.SR.aE().size(); var5++) {
            for (int var6 = 0; var6 < ((C0741)C0745.SR.aE().get(var5)).eb().size(); var6++) {
               int var7 = ((C0741)C0745.SR.aE().get(var5)).getEstado();
               String var4 = ((C0951)((C0741)C0745.SR.aE().get(var5)).eb().get(var6)).is();
               this.a(this.DL, ((C0951)((C0741)C0745.SR.aE().get(var5)).eb().get(var6)).mo(), var4, var7);
            }
         }
      }

      this.a(this.DS, this.DL);
   }

   private void pk() {
      this.DJ.clear();
      this.DM = (C0692)C0745.SR.N().get(this.ue.getSelectedIndex());

      for (int var1 = 0; var1 < this.DM.eb().size(); var1++) {
         this.a(this.DJ, ((C0924)this.DM.eb().get(var1)).mo(), ((C0924)this.DM.eb().get(var1)).is(), -1);
      }

      this.a(this.DJ, this.DM.jq().mo(), this.DM.jq().getNome(), -1);
      this.a(this.DU, this.DJ);
   }

   private void a(ArrayList arrayList, C0727 c0727, String string, int i) {
      try {
         if (i >= 0 && i < 100) {
            C0777 var5 = new C0777();
            var5.setEstado(i);
            arrayList.add(var5);
         }

         C0777 var11 = new C0777();
         var11.D(string);
         var11.ao(true);
         arrayList.add(var11);
         C0777 var6 = new C0777();
         var6.D("C:");
         var6.dO(1);
         var6.k(c0727.ce());
         if (c0727.ci() != null) {
            var6.Z(c0727.ci().dS());
         }

         arrayList.add(var6);
         C0777 var7 = new C0777();
         var7.D("V:");
         var7.dO(2);
         var7.k(c0727.cf());
         if (c0727.cj() != null) {
            var7.Z(c0727.cj().dS());
         }

         arrayList.add(var7);
         C0777 var8 = new C0777();
         var8.D("A:");
         var8.dO(3);
         var8.Z(Integer.toString(c0727.y()));
         var8.k(c0727.ch());
         var8.aa(c0727.cg());
         arrayList.add(var8);
         C0777 var9 = new C0777();
         var9.D("");
         arrayList.add(var9);
      } catch (Exception var10) {
      }
   }

   private void mH() {
      this.DO.addActionListener(new C0154(this));
      this.DP.addActionListener(new C0155(this));
   }

   public static void pl() {
      int var0 = -1;
      var0 = JOptionPane.showConfirmDialog(null, "Deseja marcar amistosos?", "Amistosos de início de temporada", 0);
      if (var0 == 0) {
         for (int var1 = 0; var1 < C0745.SR.M().size(); var1++) {
            if (((Coach)C0745.SR.M().get(var1)).fg() != null) {
               C0685.w(((Coach)C0745.SR.M().get(var1)).fg());
            }
         }

         for (int var3 = 0; var3 < C0745.SR.M().size(); var3++) {
            if (((Coach)C0745.SR.M().get(var3)).jo() != null) {
               C0685.x(((Coach)C0745.SR.M().get(var3)).jo());
            }
         }
      }
   }

   public static void AC() {
      int var0 = -1;
      var0 = JOptionPane.showConfirmDialog(null, "Deseja criar um torneio Amistoso de início de temporada? ", "Torneio Amistoso", 0);
      if (var0 == 0) {
         C0685.aY(10);
      } else {
         C0745.SR.az();
         C0745.SR.V();
      }
   }

   public void pm() {
      C0685.a(null, this.DM, 1);
   }

   public void pn() {
      this.DO.setCursor(new Cursor(3));
      if (C0745.SR.getAutoSalvar() == 3) {
         C0745.SR.j(true);
      }

      C0745.SR.V();
   }

   private void a(JTable jTable, ArrayList arrayList) {
      C0663 var3 = new C0663(arrayList);
      jTable.setModel(var3);
      jTable.setTableHeader(null);
      int[] var4 = new int[]{30, 160, 145};

      for (int var5 = 0; var5 < var4.length; var5++) {
         jTable.getColumnModel().getColumn(var5).setPreferredWidth(var4[var5]);
      }

      jTable.getColumnModel().getColumn(0).setMaxWidth(25);
      jTable.setAutoResizeMode(3);
      jTable.setRowHeight(20);
      jTable.setShowGrid(false);
      jTable.setDefaultRenderer(C0777.class, new C0776());
      jTable.setAutoCreateRowSorter(false);
      jTable.setIntercellSpacing(new Dimension(0, 0));
      jTable.setCellSelectionEnabled(false);
      jTable.setSelectionMode(0);
      jTable.setRowSelectionAllowed(true);
      jTable.setSelectionBackground(Color.YELLOW);
      jTable.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ut = new JScrollPane();
      this.DU = new JTable();
      this.ue = new JComboBox();
      this.BL = new JLabel();
      this.wi = new JScrollPane();
      this.DT = new JTable();
      this.DR = new JLabel();
      this.zf = new JScrollPane();
      this.DS = new JTable();
      this.DQ = new JLabel();
      this.DP = new JButton();
      this.DN = new JButton();
      this.DO = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Fim da temporada");
      this.ut.setViewportView(this.DU);
      this.BL.setForeground(new Color(255, 255, 153));
      this.BL.setText("Nacionais");
      this.wi.setViewportView(this.DT);
      this.DR.setForeground(new Color(255, 255, 153));
      this.DR.setText("Internacionais");
      this.zf.setViewportView(this.DS);
      this.DQ.setForeground(new Color(255, 255, 153));
      this.DQ.setText("Regionais/estaduais");
      this.DP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/bolaouro_s3.png")));
      this.DP.setText("Time do Ano");
      this.DN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/build.png")));
      this.DN.setText("Marcar amistosos");
      this.DO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
      this.DO.setText("Iniciar novo ano >>");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(29, 29, 29)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.DP, -2, 132, -2)
                              .addGap(266, 266, 266)
                              .addComponent(this.DN, -2, 191, -2)
                              .addGap(133, 133, 133)
                              .addComponent(this.DO, -2, 199, -2)
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.TRAILING, false)
                                    .addGroup(
                                       Alignment.LEADING,
                                       var1.createSequentialGroup()
                                          .addComponent(this.BL)
                                          .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                          .addComponent(this.ue, -2, 169, -2)
                                    )
                                    .addComponent(this.vf, Alignment.LEADING)
                                    .addComponent(this.ut, Alignment.LEADING, -2, 315, -2)
                              )
                              .addGap(18, 18, 18)
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.wi, -2, 315, -2).addComponent(this.DR, -2, 229, -2))
                              .addGap(18, 18, 18)
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.DQ, -2, 152, -2).addComponent(this.zf, -2, 307, -2))
                        )
                  )
                  .addContainerGap(22, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addComponent(this.vf)
                  .addGap(30, 30, 30)
                  .addGroup(
                     var1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(this.ue, -2, -1, -2)
                        .addComponent(this.BL)
                        .addComponent(this.DR)
                        .addComponent(this.DQ)
                  )
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.ut)
                        .addGroup(var1.createSequentialGroup().addComponent(this.zf, -1, 549, 32767).addGap(2, 2, 2))
                        .addComponent(this.wi, -1, 551, 32767)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.BASELINE).addComponent(this.DP, -2, 35, -2).addComponent(this.DN).addComponent(this.DO, -2, 33, -2)
                  )
                  .addGap(24, 24, 24)
            )
      );
   }
}
