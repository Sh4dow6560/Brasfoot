package bf22.intermediary;

import mod.recovered.match.MatchEvent;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.match.MatchEngine;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import mod.recovered.model.Club;

public class C0404 extends JPanel {
   private JDialog ub;
   private ArrayList um = new ArrayList();
   private Club LF = null;
   private Club LG = null;
   private Club uk = null;
   private JButton BZ;
   private JButton LH;
   private JButton LI;
   private JButton LJ;
   private JButton LK;
   private JButton LL;
   private JButton LM;
   private JButton LN;
   private JButton LO;
   private JCheckBox LP;
   private JCheckBox LQ;
   private JComboBox Bf;
   private JComboBox LR;
   private JComboBox LS;
   private JComboBox LT;
   private JComboBox Bg;
   private JComboBox Bh;
   private JComboBox Bi;
   private JComboBox LU;
   private JComboBox LV;
   private JComboBox LW;
   private JComboBox LX;
   private JComboBox LY;
   private JPanel vd;
   private JScrollPane ut;
   private JScrollPane wi;
   private JScrollPane zf;
   private JScrollPane zg;
   private JLabel yA;
   private JLabel yB;
   private JLabel Fr;
   private JLabel GJ;
   private JLabel LZ;
   private JLabel Hn;
   private JTree uw;

   public C0404(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
      this.mM();
      this.mW();
      this.og();
   }

   public void og() {
      this.Bf.addActionListener(new C0405(this));
      this.Bg.addActionListener(new C0411(this));
      this.Bh.addActionListener(new C0412(this));
      this.Bi.addActionListener(new C0413(this));
   }

   private void dA(int i) {
      long var2 = 0L;
      long var4 = 0L;
      var2 = System.currentTimeMillis();
      int[] var6 = new int[2];
      int[] var7 = new int[2];
      int[] var8 = new int[2];
      int[] var9 = new int[2];
      int[] var10 = new int[2];
      int[] var11 = new int[2];
      int[] var12 = new int[2];
      int[] var13 = new int[2];
      int[] var14 = new int[2];
      int var15 = 0;
      int var16 = -1;
      if (this.Bf.getSelectedIndex() > 0) {
         var16 = this.Bf.getSelectedIndex();
      }

      int var17 = -1;
      if (this.LW.getSelectedIndex() > 0) {
         var17 = this.LW.getSelectedIndex();
      }

      for (int var18 = 0; var18 < i; var18++) {
         Match var19 = new Match(this.LF, this.LG, this.LQ.isSelected());
         Club.a(var19.hc(), var19, 1, var16, false);
         Club.a(var19.hd(), var19, 2, var17, false);
         MatchEngine var20 = new MatchEngine(var19);
         var19.a(var20);
         int[] var21 = new int[]{new Random().nextInt(3), new Random().nextInt(5) + 1};

         for (int var22 = 0; var22 < 45 + var21[0]; var22++) {
            MatchEvent var23 = null;
            var23 = var20.vO();
            if (var23 != null) {
               var23.setMinute(var22);
               var23.setPeriod(1);
               var19.hE().add(var23);
            }
         }

         for (int var28 = 0; var28 < 45 + var21[1]; var28++) {
            MatchEvent var43 = null;
            var43 = var20.vO();
            if (var43 != null) {
               var43.setMinute(var28);
               var43.setPeriod(2);
               var19.hE().add(var43);
            }
         }

         var7[0] += var20.vX()[0];
         var7[1] += var20.vX()[1];
         if (var20.vX()[0] > var20.vX()[1]) {
            var6[0]++;
         } else if (var20.vX()[1] > var20.vX()[0]) {
            var6[1]++;
         } else {
            var15++;
         }

         if (var20.vX()[0] > var14[0]) {
            var14[0] = var20.vX()[0];
         }

         if (var20.vX()[1] > var14[1]) {
            var14[1] = var20.vX()[1];
         }

         var8[0] += var20.vY()[0];
         var8[1] += var20.vY()[1];
         var9[0] += var20.hY()[0];
         var9[1] += var20.hY()[1];
         var10[0] += var20.wf()[0];
         var10[1] += var20.wf()[1];
         var11[0] += var20.we()[0];
         var11[1] += var20.we()[1];
         var12[0] += var20.wg()[0];
         var12[1] += var20.wg()[1];
         var13[0] += var20.wh()[0];
         var13[1] += var20.wh()[1];
         if (var18 == i - 1) {
            int[] var29 = var20.vX();
            this.GJ.setText(var19.hc().getNome() + Integer.toString(var29[0]) + " x " + Integer.toString(var29[1]) + var19.hd().getNome());
            String var45 = "<html>";
            var45 = var45 + "<br>Placar:" + Integer.toString(var20.vX()[0]) + " x " + Integer.toString(var20.vX()[1]);
            var45 = var45 + "<br>Venceu meio: " + Integer.toString(var20.hY()[0]) + "/" + Integer.toString(var20.hY()[1]);
            var45 = var45 + "<br>Avancos no meio: " + Integer.toString(var20.wf()[0]) + "/" + Integer.toString(var20.wf()[1]);
            var45 = var45 + "<br>Desarmes no meio: " + Integer.toString(var20.wg()[0]) + "/" + Integer.toString(var20.wg()[1]);
            var45 = var45 + "<br>Avancos Ataque:" + Integer.toString(var20.we()[0]) + "/" + Integer.toString(var20.we()[1]);
            var45 = var45 + "<br>Desarmes defesa:" + Integer.toString(var20.wh()[0]) + "/" + Integer.toString(var20.wh()[1]);
            var45 = var45 + "<br>Chutes totais:" + Integer.toString(var20.vY()[0]) + "/" + Integer.toString(var20.vY()[1]);
            var45 = var45 + "</html>";
            this.yA.setText(var45);
            String var24 = "<html>";

            for (int var25 = 0; var25 < var19.hE().size(); var25++) {
               var24 = var24
                  + ((MatchEvent)var19.hE().get(var25)).getPrimaryPlayer().getNome()
                  + " "
                  + GameConstants.rI[((MatchEvent)var19.hE().get(var25)).getPrimaryPlayer().getPosicao()]
                  + " "
                  + Integer.toString(((MatchEvent)var19.hE().get(var25)).getMinute())
                  + "' - "
                  + Integer.toString(((MatchEvent)var19.hE().get(var25)).getPeriod())
                  + "º "
                  + ((MatchEvent)var19.hE().get(var25)).getClub().getNome()
                  + "<br>";
            }

            var24 = var24 + "</html>";
            this.yB.setText(var24);
         }

         String var30 = "<html>";
         var30 = var30 + "<br>Vitórias:" + Integer.toString(var6[0]) + "/" + Integer.toString(var6[1]);
         var30 = var30 + "<br>Empates:" + Integer.toString(var15);
         var30 = var30
            + "<br>Gols:"
            + Integer.toString(var7[0])
            + "("
            + GameConstants.D(var7[0], var8[0])
            + "%)/"
            + Integer.toString(var7[1])
            + "("
            + GameConstants.D(var7[1], var8[1])
            + "%)";
         var30 = var30 + "<br>Chutes:" + Integer.toString(var8[0]) + "/" + Integer.toString(var8[1]);
         var30 = var30 + "<br>Venceu meio:" + Integer.toString(var9[0]) + "/" + Integer.toString(var9[1]);
         var30 = var30 + "<br>Avanco meio:" + Integer.toString(var10[0]) + "/" + Integer.toString(var10[1]);
         var30 = var30 + "<br>Avanco ataque:" + Integer.toString(var11[0]) + "/" + Integer.toString(var11[1]);
         var30 = var30 + "<br>Desarme meio:" + Integer.toString(var12[0]) + "/" + Integer.toString(var12[1]);
         var30 = var30 + "<br>Desarme defesa:" + Integer.toString(var13[0]) + "/" + Integer.toString(var13[1]);
         var30 = var30 + "<br>Maior n gols:" + Integer.toString(var14[0]) + "/" + Integer.toString(var14[1]);
         var30 = var30 + "</html>";
         this.Fr.setText(var30);
      }

      var4 = System.currentTimeMillis() - var2;
   }

   private void mW() {
      String[] var1 = new String[]{"random", "5-4-1", "5-3-2", "4-5-1", "4-4-2", "4-4-2 def", "4-4-2 Ofen.", "4-3-3", "4-3-3 def", "3-5-2", "3-4-3"};
      String[] var2 = GameConstants.rC;
      String[] var3 = GameConstants.rD;
      String[] var4 = GameConstants.rE;

      for (int var5 = 0; var5 < var1.length; var5++) {
         this.Bf.addItem(var1[var5]);
      }

      for (int var6 = 0; var6 < var2.length; var6++) {
         this.Bg.addItem(var2[var6]);
      }

      this.Bg.setSelectedIndex(0);

      for (int var7 = 0; var7 < var4.length; var7++) {
         this.Bh.addItem(var4[var7]);
      }

      this.Bh.setSelectedIndex(0);

      for (int var8 = 0; var8 < var3.length; var8++) {
         this.Bi.addItem(var3[var8]);
      }

      this.Bi.setSelectedIndex(0);

      for (int var9 = 0; var9 < var1.length; var9++) {
         this.LW.addItem(var1[var9]);
      }

      for (int var10 = 0; var10 < var2.length; var10++) {
         this.LX.addItem(var2[var10]);
      }

      this.LX.setSelectedIndex(0);

      for (int var11 = 0; var11 < var4.length; var11++) {
         this.LY.addItem(var4[var11]);
      }

      this.LY.setSelectedIndex(0);

      for (int var12 = 0; var12 < var3.length; var12++) {
         this.LR.addItem(var3[var12]);
      }

      this.LR.setSelectedIndex(0);
   }

   public void mH() {
      this.BZ.addActionListener(new C0414(this));
      this.LH.addActionListener(new C0415(this));
      this.LN.addActionListener(new C0416(this));
      this.LO.addActionListener(new C0417(this));
      this.LI.addActionListener(new C0418(this));
      this.LJ.addActionListener(new C0406(this));
      this.LK.addActionListener(new C0407(this));
      this.LL.addActionListener(new C0408(this));
      this.LM.addActionListener(new C0409(this));
   }

   private void dB(int i) {
      if (i == 1) {
         this.LF.kj()[1] = this.Bg.getSelectedIndex();
         this.LF.kj()[2] = this.Bh.getSelectedIndex();
         this.LF.kj()[3] = this.Bi.getSelectedIndex();
      }

      if (i == 2) {
         this.LG.kj()[1] = this.LX.getSelectedIndex();
         this.LG.kj()[2] = this.LY.getSelectedIndex();
         this.LG.kj()[3] = this.LR.getSelectedIndex();
      }
   }

   private void sk() {
      this.LF = this.uk;
      this.LZ.setText(this.uk.getNome());
      this.LZ.setIcon(this.uk.kU());
   }

   private void sl() {
      this.LG = this.uk;
      this.Hn.setText(this.uk.getNome());
      this.Hn.setIcon(this.uk.kU());
   }

   private void mM() {
      this.uw.getSelectionModel().setSelectionMode(1);
      this.uw.addTreeSelectionListener(new C0410(this));

      for (int var1 = 0; var1 < GamePersistence.careerState.P().size(); var1++) {
         if (!((Club)GamePersistence.careerState.P().get(var1)).kn()) {
            this.um.add((Club)GamePersistence.careerState.P().get(var1));
            Collections.sort(this.um, C1007.VS);
         }
      }

      DefaultMutableTreeNode var2 = new DefaultMutableTreeNode("Times");
      this.a(var2);
      this.uw.setModel(new DefaultTreeModel(var2));
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
               var3 = new DefaultMutableTreeNode(((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().get(var6)).getNome());
               var2.add(var3);

               for (int var7 = 0; var7 < ((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().get(var6)).yi().yK().size(); var7++) {
                  var4 = new DefaultMutableTreeNode(((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(var5)).eb().get(var6)).yi().yK().get(var7));
                  var3.add(var4);
               }
            }
         }

         if (((CountryCompetitions)GamePersistence.careerState.N().get(var5)).ek().size() > 0) {
            var3 = new DefaultMutableTreeNode("Regionais");
            var2.add(var3);

            for (int var16 = 0; var16 < ((CountryCompetitions)GamePersistence.careerState.N().get(var5)).ek().size(); var16++) {
               var4 = new DefaultMutableTreeNode(((CountryCompetitions)GamePersistence.careerState.N().get(var5)).ek().get(var16));
               var3.add(var4);
            }
         }
      }

      if (this.um.size() > 0) {
         var2 = new DefaultMutableTreeNode("Internacionais");
         defaultMutableTreeNode.add(var2);

         for (int var15 = 0; var15 < this.um.size(); var15++) {
            var4 = new DefaultMutableTreeNode(this.um.get(var15));
            var2.add(var4);
         }
      }
   }

   public void F(Club club) {
      this.uk = club;
   }

   private void mJ() {
      this.BZ = new JButton();
      this.LH = new JButton();
      this.LI = new JButton();
      this.vd = new JPanel();
      this.GJ = new JLabel();
      this.ut = new JScrollPane();
      this.yB = new JLabel();
      this.wi = new JScrollPane();
      this.yA = new JLabel();
      this.zf = new JScrollPane();
      this.Fr = new JLabel();
      this.LJ = new JButton();
      this.LK = new JButton();
      this.LL = new JButton();
      this.LM = new JButton();
      this.LZ = new JLabel();
      this.Hn = new JLabel();
      this.Bf = new JComboBox();
      this.Bg = new JComboBox();
      this.Bh = new JComboBox();
      this.Bi = new JComboBox();
      this.LU = new JComboBox();
      this.LV = new JComboBox();
      this.LP = new JCheckBox();
      this.LN = new JButton();
      this.LW = new JComboBox();
      this.LX = new JComboBox();
      this.LY = new JComboBox();
      this.LR = new JComboBox();
      this.LS = new JComboBox();
      this.LT = new JComboBox();
      this.LO = new JButton();
      this.LQ = new JCheckBox();
      this.zg = new JScrollPane();
      this.uw = new JTree();
      this.setBackground(new Color(84, 127, 59));
      this.BZ.setText("sair");
      this.LH.setText("set 1");
      this.LI.setText("set 2");
      this.GJ.setFont(new Font("Tahoma", 1, 11));
      this.GJ.setText("t1 x t2");
      this.yB.setText("jLabel1");
      this.yB.setVerticalAlignment(1);
      this.ut.setViewportView(this.yB);
      this.yA.setForeground(new Color(0, 51, 51));
      this.yA.setText("jLabel2");
      this.yA.setVerticalAlignment(1);
      this.wi.setViewportView(this.yA);
      this.Fr.setForeground(new Color(0, 51, 51));
      this.Fr.setText("jLabel2");
      this.Fr.setVerticalAlignment(1);
      this.zf.setViewportView(this.Fr);
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.GJ, -1, -1, 32767)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(var1.createParallelGroup(Alignment.LEADING, false).addComponent(this.wi, -1, 183, 32767).addComponent(this.zf))
                              .addGap(18, 18, 18)
                              .addComponent(this.ut, -2, 216, -2)
                              .addGap(0, 0, 32767)
                        )
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.GJ, -2, 28, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup().addComponent(this.wi, -2, 142, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.zf)
                        )
                        .addGroup(var1.createSequentialGroup().addComponent(this.ut, -2, 329, -2).addGap(0, 8, 32767))
                  )
                  .addContainerGap()
            )
      );
      this.LJ.setText("r1");
      this.LK.setText("r10");
      this.LL.setText("r100");
      this.LM.setText("r1000");
      this.LZ.setForeground(new Color(255, 255, 255));
      this.LZ.setText("jLabel1");
      this.Hn.setForeground(new Color(255, 255, 255));
      this.Hn.setText("jLabel1");
      this.LP.setText("jogo fora");
      this.LN.setText("sT1");
      this.LO.setText("sT1");
      this.LQ.setText("campo neutro");
      this.zg.setViewportView(this.uw);
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(var2.createSequentialGroup().addComponent(this.LH, -2, 89, -2).addGap(37, 37, 37).addComponent(this.LI, -2, 89, -2))
                        .addGroup(var2.createSequentialGroup().addComponent(this.LZ, -2, 111, -2).addGap(18, 18, 18).addComponent(this.Hn, -1, -1, 32767))
                        .addGroup(
                           var2.createParallelGroup(Alignment.TRAILING, false)
                              .addComponent(this.LQ, Alignment.LEADING, -1, -1, 32767)
                              .addComponent(this.LP, Alignment.LEADING, -1, 189, 32767)
                        )
                        .addComponent(this.zg)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(var2.createSequentialGroup().addComponent(this.LN).addGap(0, 0, 32767))
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addComponent(this.LJ, -2, 66, -2)
                                          .addGap(18, 18, 18)
                                          .addComponent(this.LK, -2, 66, -2)
                                          .addGap(18, 18, 18)
                                          .addComponent(this.LL, -2, 65, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.LM, -2, 75, -2)
                                    )
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.TRAILING, false)
                                                .addComponent(this.Bg, Alignment.LEADING, 0, 123, 32767)
                                                .addComponent(this.Bf, Alignment.LEADING, 0, -1, 32767)
                                          )
                                          .addGap(18, 18, 18)
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.LEADING).addComponent(this.Bh, -2, 123, -2).addComponent(this.Bi, -2, 123, -2)
                                          )
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.LEADING).addComponent(this.LU, -2, 123, -2).addComponent(this.LV, -2, 123, -2)
                                          )
                                    )
                              )
                              .addContainerGap(-1, 32767)
                        )
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(this.vd, -1, -1, 32767)
                                    .addGroup(
                                       Alignment.LEADING,
                                       var2.createSequentialGroup()
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.LEADING)
                                                .addGroup(
                                                   var2.createParallelGroup(Alignment.TRAILING, false)
                                                      .addComponent(this.LX, Alignment.LEADING, 0, -1, 32767)
                                                      .addComponent(this.LW, Alignment.LEADING, -2, 123, -2)
                                                )
                                                .addComponent(this.LO)
                                          )
                                          .addGap(18, 18, 18)
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.LEADING)
                                                .addGroup(
                                                   var2.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.BZ, -2, 112, -2).addGap(25, 25, 25)
                                                )
                                                .addGroup(
                                                   var2.createSequentialGroup()
                                                      .addGroup(
                                                         var2.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(this.LY, -2, 123, -2)
                                                            .addComponent(this.LR, -2, 123, -2)
                                                      )
                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                      .addGroup(
                                                         var2.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(this.LS, -2, 123, -2)
                                                            .addComponent(this.LT, -2, 123, -2)
                                                      )
                                                      .addGap(0, 144, 32767)
                                                )
                                          )
                                    )
                              )
                              .addGap(15, 15, 15)
                        )
                  )
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap(-1, 32767)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addComponent(this.zg, -2, 346, -2)
                              .addGap(18, 18, 18)
                              .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.LH).addComponent(this.LI))
                        )
                        .addComponent(this.vd, Alignment.TRAILING, -2, -1, -2)
                  )
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGap(18, 18, 18)
                              .addGroup(
                                 var2.createParallelGroup(Alignment.BASELINE)
                                    .addComponent(this.LJ)
                                    .addComponent(this.LK)
                                    .addComponent(this.LL)
                                    .addComponent(this.LM)
                              )
                        )
                        .addGroup(var2.createSequentialGroup().addGap(6, 6, 6).addComponent(this.LZ))
                        .addGroup(var2.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.Hn))
                  )
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(var2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.LP))
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGap(11, 11, 11)
                              .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.Bh, -2, -1, -2).addComponent(this.LU, -2, -1, -2))
                        )
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGap(7, 7, 7)
                              .addComponent(this.Bf, -2, -1, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addGroup(
                                 var2.createParallelGroup(Alignment.BASELINE)
                                    .addComponent(this.Bg, -2, -1, -2)
                                    .addComponent(this.Bi, -2, -1, -2)
                                    .addComponent(this.LV, -2, -1, -2)
                              )
                        )
                  )
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addGroup(var2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED).addComponent(this.LN))
                                    .addGroup(var2.createSequentialGroup().addGap(1, 1, 1).addComponent(this.LQ))
                              )
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addGap(4, 4, 4)
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.BASELINE).addComponent(this.LS, -2, -1, -2).addComponent(this.LY, -2, -1, -2)
                                          )
                                    )
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addComponent(this.LW, -2, -1, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addGroup(
                                             var2.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(this.LX, -2, -1, -2)
                                                .addComponent(this.LT, -2, -1, -2)
                                                .addComponent(this.LR, -2, -1, -2)
                                          )
                                    )
                              )
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.LO)
                              .addGap(24, 24, 24)
                        )
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.BZ).addContainerGap()
                        )
                  )
            )
      );
   }
}
