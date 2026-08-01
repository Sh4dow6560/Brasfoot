package bf22.intermediary;

import mod.recovered.stadium.StadiumExpansionProject;
import mod.recovered.game.ScheduleDay;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Stadium;

public class C0176 extends JPanel {
   private JDialog ub;
   private C0171 Cn = null;
   private Stadium dH;
   private Club zu = null;
   private int[] Co = new int[]{18000, 80000, 9000, 700};
   private int[] Cp = new int[4];
   private int[] Cq = new int[4];
   private int[] Cr = new int[4];
   private boolean Cs = true;
   private int Ct = 0;
   private Calendar dI = Calendar.getInstance();
   private JButton ud;
   private JButton Cu;
   private JButton Cv;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JPanel vd;
   private JLabel Cw;
   private JLabel Cx;
   private JLabel Cy;
   private JLabel Cz;
   private JLabel zh;
   private JSpinner CA;
   private JSpinner CB;
   private JSpinner CC;
   private JSpinner CD;

   public C0176(JDialog jDialog, Stadium stadium, Club club, C0171 c0171) {
      this.ub = jDialog;
      this.dH = stadium;
      this.zu = club;
      this.Cn = c0171;
      if (GamePersistence.careerState.getSeasonNumber() >= 2) {
         this.Co = GameConstants.pa[1];
      } else if (GamePersistence.careerState.getSeasonNumber() >= 6) {
         this.Co = GameConstants.pa[2];
      } else if (GamePersistence.careerState.getSeasonNumber() >= 10) {
         this.Co = GameConstants.pa[3];
      }

      this.mJ();
      this.mH();
      this.Cq = stadium.dT();
      JSpinner[] var5 = new JSpinner[]{this.CA, this.CB, this.CC, this.CD};

      for (int var6 = 0; var6 < 4; var6++) {
         this.Cp[var6] = this.Co[var6] - this.Cq[var6];
         this.a(var5[var6], this.Cp[var6]);
      }

      String[] var10 = new String[]{"Geral", "Arquibancada", "Cadeira", "Camarote"};
      JLabel[] var7 = new JLabel[]{this.uh, this.ur, this.a_, this.us};
      JLabel[] var8 = new JLabel[]{this.Cw, this.Cx, this.Cy, this.Cz};

      for (int var9 = 0; var9 < 4; var9++) {
         var7[var9].setText(var10[var9] + "  (atual:" + Integer.toString(this.Cq[var9]) + ")");
         var8[var9].setText("Máximo mais: " + Integer.toString(this.Cp[var9]));
      }

      this.Cv.setVisible(false);
      this.zh.setText("");
   }

   private void a(JSpinner jSpinner, int i) {
      if (i <= 0) {
         jSpinner.setEnabled(false);
         jSpinner.setValue(0);
      } else {
         jSpinner.setModel(new SpinnerNumberModel(0, 0, i, 1));
      }
   }

   public void mH() {
      this.ud.addActionListener(new C0177(this));
      this.Cu.addActionListener(new C0178(this));
      this.Cv.addActionListener(new C0179(this));
   }

   private boolean oH() {
      this.Ct = 0;
      this.Cv.setVisible(false);
      int[] var1 = new int[]{(Integer)this.CA.getValue(), (Integer)this.CB.getValue(), (Integer)this.CC.getValue(), (Integer)this.CD.getValue()};
      this.Cr = var1;
      if (this.Cr[0] + this.Cr[1] + this.Cr[2] + this.Cr[3] == 0) {
         return false;
      }

      int var2 = 0;

      for (int var3 = 0; var3 < this.Cr.length; var3++) {
         this.Ct = this.Ct + this.I(var3, this.Cr[var3]);
         var2 += this.Cr[var3];
      }

      this.Ct += 100000;
      int var7 = this.cZ(var2);
      Calendar var4 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a();
      this.dI.set(var4.get(1), var4.get(2), var4.get(5));
      this.dI.add(5, var7);
      DateFormat var5 = DateFormat.getDateInstance();
      String var6 = var5.format(this.dI.getTime());
      this.zh.setText("<html> Custo da obra: " + ClubFinances.c(this.Ct) + "<br>Previsão de término: " + var6);
      this.Cv.setVisible(true);
      return true;
   }

   private void oI() {
      if (this.zu.kb() < this.Ct) {
         JOptionPane.showMessageDialog(this.ub, "Sem dinheiro para essa expansão", "Expansão", 2);
      } else {
         StadiumExpansionProject var1 = new StadiumExpansionProject();
         var1.setStadium(this.dH);
         var1.setCompletionDate(this.dI);
         var1.setSeatAdditions(this.Cr);
         GamePersistence.careerState.getStadiumExpansionProjects().add(var1);
         this.zu.w(this.Ct, 7);
         this.ub.dispose();
         this.Cn.oB();
      }
   }

   private int cZ(int i) {
      if (i < 1000) {
         return 15;
      } else if (i < 10000) {
         return 20;
      } else {
         return i < 30000 ? 30 : 40;
      }
   }

   private int I(int i, int j) {
      int[][] var3 = new int[][]{{80, 160, 240, 500, 700}, {120, 380, 640, 700, 1400}, {300, 600, 750, 800, 1200}, {1500, 3500, 4000, 6000, 6400}};
      boolean var4 = false;
      int[][] var5 = new int[][]{
         {1000, 2500, 3500, 10000, 18000}, {5000, 15000, 30000, 60000, 80000}, {1000, 2000, 3000, 5000, 9000}, {100, 200, 500, 600, 700}
      };
      int var6 = this.Cq[i] + j;
      int var7 = 4;

      for (int var8 = 0; var8 < var5[i].length; var8++) {
         if (var6 <= var5[i][var8]) {
            var7 = var8;
            break;
         }
      }

      return var3[i][var7] * j;
   }

   private void mJ() {
      this.ug = new JLabel();
      this.vd = new JPanel();
      this.CC = new JSpinner();
      this.CA = new JSpinner();
      this.CB = new JSpinner();
      this.CD = new JSpinner();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.vx = new JLabel();
      this.Cw = new JLabel();
      this.Cy = new JLabel();
      this.Cx = new JLabel();
      this.Cz = new JLabel();
      this.zh = new JLabel();
      this.Cu = new JButton();
      this.ud = new JButton();
      this.Cv = new JButton();
      this.setBackground(new Color(42, 64, 29));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Expansão do estádio");
      this.vd.setBackground(new Color(204, 204, 204));
      this.vx.setFont(new Font("Tahoma", 1, 11));
      this.vx.setHorizontalAlignment(0);
      this.vx.setText("Digite o número de lugares para construir:");
      this.vx.setToolTipText("");
      this.zh.setForeground(new Color(0, 102, 0));
      this.zh.setHorizontalAlignment(0);
      this.zh.setText("Custo total:");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           Alignment.TRAILING,
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.Cw, -1, -1, 32767)
                                                .addComponent(this.Cx, -1, -1, 32767)
                                                .addGroup(var1.createSequentialGroup().addComponent(this.CA, -2, 104, -2).addGap(0, 64, 32767))
                                                .addComponent(this.uh, -1, -1, 32767)
                                                .addComponent(this.ur, -1, -1, 32767)
                                          )
                                          .addGap(18, 18, 18)
                                    )
                                    .addGroup(
                                       var1.createSequentialGroup().addComponent(this.CB, -2, 104, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    )
                              )
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addComponent(this.CC, -2, 104, -2).addGap(62, 62, 62))
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.Cz, -1, -1, 32767)
                                                .addComponent(this.a_, -1, -1, 32767)
                                                .addGroup(var1.createSequentialGroup().addComponent(this.CD, -2, 104, -2).addGap(0, 0, 32767))
                                                .addComponent(this.us, -1, -1, 32767)
                                          )
                                          .addContainerGap()
                                    )
                                    .addGroup(var1.createSequentialGroup().addComponent(this.Cy, -1, -1, 32767).addContainerGap())
                              )
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.zh, -1, -1, 32767)
                                    .addComponent(this.vx, Alignment.TRAILING, -1, -1, 32767)
                              )
                              .addContainerGap()
                        )
                  )
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.vx)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.a_).addComponent(this.uh))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.CC, -2, -1, -2).addComponent(this.CA, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Cw).addComponent(this.Cy))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ur).addComponent(this.us))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.CB, -2, -1, -2).addComponent(this.CD, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Cx).addComponent(this.Cz))
                  .addPreferredGap(ComponentPlacement.RELATED, 13, 32767)
                  .addComponent(this.zh, -2, 36, -2)
            )
      );
      this.Cu.setText("Pedir Orçamento");
      this.ud.setText("X");
      this.Cv.setText("Iniciar construção");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(84, 84, 84)
                  .addComponent(this.ug, -2, 245, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.ud, -2, 59, -2)
                  .addContainerGap(30, 32767)
            )
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap(-1, 32767)
                  .addGroup(
                     var2.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(this.vd, -2, -1, -2)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.Cv, -2, 160, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.Cu, -2, 160, -2)
                        )
                  )
                  .addGap(34, 34, 34)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(13, 13, 13)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.ud, -2, 27, -2).addComponent(this.ug, -2, 36, -2))
                  .addGap(18, 18, 18)
                  .addComponent(this.vd, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.Cv).addComponent(this.Cu))
                  .addContainerGap(32, 32767)
            )
      );
   }
}
