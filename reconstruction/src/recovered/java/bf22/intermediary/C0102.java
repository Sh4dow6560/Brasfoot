package bf22.intermediary;

import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Collections;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0102 extends JPanel {
   private JFrame Br;
   private CountryCompetitions Bs;
   private Club zu;
   private Club Bt;
   private JComboBox[] Bu = null;
   private JLabel[] Bv = null;
   private static int count = 1;
   private JButton Bw;
   private JButton Bx;
   private JCheckBox By;
   private JComboBox Bz;
   private JComboBox BA;
   private JComboBox BB;
   private JComboBox BC;
   private JComboBox BD;
   private JComboBox ue;
   private JTextField uf;
   private JLabel ug;
   private JLabel a_;
   private JSeparator BE;
   private JSeparator BF;
   private JSeparator BG;
   private JLabel BH;
   private JLabel BI;
   private JLabel BJ;
   private JLabel BK;
   private JLabel BL;
   private JLabel BM;
   private JLabel uF;
   private JLabel vf;
   private JLabel BN;
   private JLabel BO;

   public C0102(JFrame jFrame) {
      this.Br = jFrame;
      this.mJ();
      JComboBox[] var2 = new JComboBox[]{this.Bz, this.BA, this.BB, this.BC};
      this.Bu = var2;
      JLabel[] var3 = new JLabel[]{this.BH, this.BI, this.BJ, this.BK};
      this.Bv = var3;

      for (int var4 = 0; var4 < GamePersistence.SR.N().size(); var4++) {
         this.ue.addItem(((CountryCompetitions)GamePersistence.SR.N().get(var4)).jp());
      }

      C0037 var8 = new C0037();
      var8.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var8);
      this.ue.setMaximumRowCount(12);
      this.Bs = (CountryCompetitions)GamePersistence.SR.N().get(0);

      for (int var5 = 0; var5 < C0696.jz(); var5++) {
         this.BD.addItem(((CountryInfo)C0732.cY().get(var5)).getNome());
      }

      C0037 var9 = new C0037();
      var9.setPreferredSize(new Dimension(10, 25));
      this.BD.setRenderer(var9);
      this.BD.setMaximumRowCount(12);
      this.BD.setSelectedIndex(C0732.G(29));
      this.ue.addActionListener(new C0103(this));

      for (int var6 = 0; var6 < this.Bu.length; var6++) {
         C0038 var7 = new C0038();
         var7.setPreferredSize(new Dimension(10, 25));
         this.Bu[var6].setRenderer(var7);
         this.Bu[var6].setMaximumRowCount(24);
      }

      this.ot();
      this.By.addActionListener(new C0104(this));
      this.Bu[0].addActionListener(new C0105(this));
      this.Bu[1].addActionListener(new C0106(this));
      this.Bu[2].addActionListener(new C0160(this));
      this.Bu[3].addActionListener(new C0161(this));
      this.Bw.addActionListener(new C0162(this));
      this.Bx.addActionListener(new C0163(this));
      if (GamePersistence.vL()) {
         this.ug.setText("");
      } else {
         this.By.setSelected(false);
         this.By.setEnabled(false);
      }
   }

   private void ol() {
      if (this.By.isSelected()) {
         this.BN.setText("Aleatório");
         this.BN.setIcon(null);
         this.Bt = null;
         byte var1 = 0;
         if (this.Bu[0].getItemCount() > 0) {
            var1 = 1;
         }

         if (this.Bu[1].getItemCount() > 0) {
            var1 = 2;
         }

         if (this.Bu[2].getItemCount() > 0) {
            var1 = 3;
         }

         if (this.Bu[3].getItemCount() > 0) {
            var1 = 4;
         }

         int var2 = new Random().nextInt(var1);
         int var3 = new Random().nextInt(this.Bu[var2].getItemCount());
         this.Bt = (Club)this.Bu[var2].getItemAt(var3);
      } else {
         this.ou();
      }
   }

   private void om() {
      if (!GamePersistence.vL()) {
         JOptionPane.showMessageDialog(null, "Somente na versão registrada é possível jogarcom mais de um técnico humano.", "Técnicos humanos", 2);
      } else {
         String var1 = this.oo();
         if (var1 == null) {
            this.or();
            count++;
            this.vf.setText("Adicionar técnico humano " + Integer.toString(count));
            this.uf.setText("");
            this.ot();
         } else {
            JOptionPane.showMessageDialog(null, var1, "", 0);
         }
      }
   }

   public void on() {
      this.uf.requestFocusInWindow();
   }

   public String oo() {
      String var1 = null;
      if (this.uf.getText().toString().isEmpty()) {
         var1 = "Digite um nome para o técnico";
      } else if (this.uf.getText().toString().length() < 2) {
         var1 = "Nome do técnico muito curto";
      } else if (this.uf.getText().toString().length() > 35) {
         var1 = "Nome do técnico muito longo";
      } else if (this.zu == null) {
         var1 = "Selecione um time";
      }

      return var1;
   }

   public void pl() {
      int var1 = -1;
      var1 = JOptionPane.showConfirmDialog(null, "Deseja criar um torneio Amistoso de início de temporada? ", "Torneio Amistoso", 0);
      if (var1 == 0) {
         MainWindow.aY(10);
      } else {
         this.AB();
      }
   }

   public void AB() {
      this.Bw.setCursor(new Cursor(3));
      GamePersistence.SR.az();
      GamePersistence.SR.V();
   }

   public void oq() {
      String var1 = this.oo();
      GamePersistence.SR.i(true);
      if (count >= 100000) {
         if (var1 == null) {
            this.or();
         }

         if (GamePersistence.SR.isJogaRegionais()) {
            C0734.dh();
         }

         this.pl();
      } else if (var1 == null) {
         this.or();
         this.Bw.setCursor(new Cursor(3));
         if (GamePersistence.SR.isJogaRegionais()) {
            C0734.dh();
         }

         this.pl();
      } else {
         JOptionPane.showMessageDialog(null, var1, "", 0);
      }
   }

   public void or() {
      if (this.By.isSelected() && this.Bt != null) {
         this.Bt.b(this.uf.getText().toString(), C0732.H(this.BD.getSelectedIndex()));
      } else {
         this.zu.b(this.uf.getText().toString(), C0732.H(this.BD.getSelectedIndex()));
      }
   }

   public void os() {
      this.Bs = (CountryCompetitions)GamePersistence.SR.N().get(this.ue.getSelectedIndex());
      this.ot();
   }

   public void cW(int i) {
      this.zu = (Club)this.Bu[i].getSelectedItem();
      this.ou();
      this.Bu[i].setEnabled(true);

      for (int var2 = 0; var2 < this.Bv.length; var2++) {
         this.Bv[var2].setForeground(new Color(255, 255, 255));
      }

      this.Bv[i].setForeground(new Color(255, 255, 0));
      this.on();
   }

   private void ot() {
      this.zu = null;

      for (int var1 = 0; var1 < this.Bv.length; var1++) {
         this.Bv[var1].setVisible(false);
         this.Bu[var1].setVisible(false);
         this.Bu[var1].removeAllItems();
      }

      for (int var2 = 0; var2 < this.Bs.eb().size(); var2++) {
         this.cX(var2);
      }

      if (GamePersistence.vL()) {
         if (this.Bu[0].getItemCount() > 0) {
            this.cW(0);
         } else if (this.Bu[1].getItemCount() > 0) {
            this.cW(1);
         } else if (this.Bu[2].getItemCount() > 0) {
            this.cW(2);
         } else if (this.Bu[3].getItemCount() > 0) {
            this.cW(3);
         }
      } else {
         for (int var3 = 0; var3 < this.Bu.length; var3++) {
            this.Bu[var3].setEnabled(false);
         }

         if (this.Bu[3].getItemCount() > 0) {
            this.cW(3);
         } else if (this.Bu[2].getItemCount() > 0) {
            this.cW(2);
         } else if (this.Bu[1].getItemCount() > 0) {
            this.cW(1);
         } else if (this.Bu[0].getItemCount() > 0) {
            this.cW(0);
         }
      }

      if (this.zu == null) {
         this.BN.setText("");
         this.BN.setIcon(null);
      }

      this.on();
   }

   public void ou() {
      this.By.setSelected(false);
      if (this.zu != null) {
         this.BN.setText(this.zu.getNome());
         this.BN.setIcon(this.zu.x(25, 25));
      }
   }

   private void cX(int i) {
      this.Bv[i].setVisible(true);
      this.Bu[i].setVisible(true);
      this.Bu[i].setEnabled(true);
      Collections.sort(((NationalLeague)this.Bs.eb().get(i)).yi().yK(), C1007.VS);
      int var2 = 0;
      boolean var3 = true;
      if (i == 3 && this.Bs.jc() == 29 && GamePersistence.SR.isJogaEstadual() && GamePersistence.SR.bk()) {
         var3 = false;
      }

      if (var3) {
         for (int var4 = 0; var4 < ((NationalLeague)this.Bs.eb().get(i)).yi().yK().size(); var4++) {
            if (!((Club)((NationalLeague)this.Bs.eb().get(i)).yi().yK().get(var4)).jZ()) {
               this.Bu[i].addItem(((NationalLeague)this.Bs.eb().get(i)).yi().yK().get(var4));
               var2++;
            }
         }

         if (i == 3) {
            this.Bv[3].setText("4ª divisão");
         }
      } else {
         this.Bv[3].setText("Jogando estaduais:");
         Collections.sort(this.Bs.jg(), C1007.VS);

         for (int var5 = 0; var5 < this.Bs.jg().size(); var5++) {
            if (!((Club)this.Bs.jg().get(var5)).jZ() && ((Club)this.Bs.jg().get(var5)).getDivisao() == 0 && ((Club)this.Bs.jg().get(var5)).kg()) {
               this.Bu[i].addItem(this.Bs.jg().get(var5));
               var2++;
            }
         }
      }

      if (var2 == 0) {
         this.Bv[i].setVisible(false);
         this.Bu[i].setVisible(false);
      }
   }

   private void mJ() {
      this.a_ = new JLabel();
      this.vf = new JLabel();
      this.BO = new JLabel();
      this.ue = new JComboBox();
      this.BE = new JSeparator();
      this.Bz = new JComboBox();
      this.BH = new JLabel();
      this.BI = new JLabel();
      this.BA = new JComboBox();
      this.BB = new JComboBox();
      this.BJ = new JLabel();
      this.BC = new JComboBox();
      this.BK = new JLabel();
      this.BF = new JSeparator();
      this.uF = new JLabel();
      this.uf = new JTextField();
      this.BL = new JLabel();
      this.BD = new JComboBox();
      this.BG = new JSeparator();
      this.Bw = new JButton();
      this.Bx = new JButton();
      this.ug = new JLabel();
      this.BM = new JLabel();
      this.BN = new JLabel();
      this.By = new JCheckBox();
      this.setBackground(GameConstants.os);
      this.a_.setFont(new Font("Tahoma", 1, 24));
      this.a_.setForeground(new Color(255, 255, 102));
      this.a_.setHorizontalAlignment(0);
      this.a_.setText("Brasfoot");
      this.vf.setFont(new Font("Tahoma", 1, 18));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setHorizontalAlignment(0);
      this.vf.setText("Adicionar técnico humano");
      this.BO.setFont(new Font("Tahoma", 1, 14));
      this.BO.setForeground(new Color(255, 255, 153));
      this.BO.setHorizontalAlignment(4);
      this.BO.setText("Treinar time do país:");
      this.BH.setFont(new Font("Tahoma", 0, 14));
      this.BH.setForeground(new Color(255, 255, 0));
      this.BH.setHorizontalAlignment(4);
      this.BH.setText("1ª divisão:");
      this.BI.setFont(new Font("Tahoma", 0, 14));
      this.BI.setForeground(new Color(255, 255, 255));
      this.BI.setHorizontalAlignment(4);
      this.BI.setText("2ª divisão:");
      this.BJ.setFont(new Font("Tahoma", 0, 14));
      this.BJ.setForeground(new Color(255, 255, 255));
      this.BJ.setHorizontalAlignment(4);
      this.BJ.setText("3ª divisão:");
      this.BK.setFont(new Font("Tahoma", 0, 14));
      this.BK.setForeground(new Color(255, 255, 255));
      this.BK.setHorizontalAlignment(4);
      this.BK.setText("4ª divisão:");
      this.uF.setFont(new Font("Tahoma", 0, 14));
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(4);
      this.uF.setText("Nome:");
      this.BL.setFont(new Font("Tahoma", 0, 14));
      this.BL.setForeground(new Color(255, 255, 255));
      this.BL.setHorizontalAlignment(4);
      this.BL.setText("Nacionalidade:");
      this.Bw.setText("Iniciar Jogo >>");
      this.Bw.setToolTipText("");
      this.Bx.setText("Adicionar e incluir outro");
      this.Bx.setToolTipText("");
      this.ug.setFont(new Font("Tahoma", 0, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.ug
         .setText(
            "<html>\nVersão não registrada do Brasfoot. Sem o registro você só pode iniciar da última divisão.<br> Na versão registrada, pode iniciar com qualquer time de qualquer divisão.\n<br><b>Registre sua cópia em www.brasfoot.com</b>\n</html>  "
         );
      this.BM.setFont(new Font("Tahoma", 0, 14));
      this.BM.setForeground(new Color(255, 255, 255));
      this.BM.setHorizontalAlignment(4);
      this.BM.setText("Time selecionado:");
      this.BN.setFont(new Font("Tahoma", 0, 14));
      this.BN.setForeground(new Color(255, 255, 255));
      this.BN.setHorizontalAlignment(2);
      this.BN.setText("Time selecionado:");
      this.By.setBackground(GameConstants.os);
      this.By.setFont(new Font("Tahoma", 0, 14));
      this.By.setForeground(new Color(255, 255, 255));
      this.By.setText("Escolher um time aleatório");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addComponent(this.vf, -1, -1, 32767)
            .addComponent(this.ug)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addComponent(this.BF, -2, 308, -2)
                        .addGroup(
                           var1.createParallelGroup(Alignment.LEADING)
                              .addGroup(var1.createSequentialGroup().addGap(261, 261, 261).addComponent(this.a_))
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addGroup(
                                       var1.createParallelGroup(Alignment.TRAILING)
                                          .addComponent(this.BE, -2, 308, -2)
                                          .addGroup(
                                             var1.createSequentialGroup()
                                                .addComponent(this.BO, -2, 246, -2)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(this.ue, -2, 154, -2)
                                          )
                                    )
                              )
                              .addGroup(
                                 Alignment.TRAILING,
                                 var1.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addGroup(
                                       var1.createParallelGroup(Alignment.LEADING)
                                          .addGroup(
                                             Alignment.TRAILING,
                                             var1.createSequentialGroup()
                                                .addComponent(this.BM, -2, 214, -2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(this.BN, -2, 154, -2)
                                          )
                                          .addGroup(
                                             var1.createSequentialGroup()
                                                .addGroup(
                                                   var1.createParallelGroup(Alignment.TRAILING)
                                                      .addComponent(this.By)
                                                      .addGroup(
                                                         var1.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(
                                                               var1.createSequentialGroup()
                                                                  .addComponent(this.BI, -2, 246, -2)
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(this.BA, -2, 154, -2)
                                                            )
                                                            .addGroup(
                                                               var1.createSequentialGroup()
                                                                  .addComponent(this.BH, -2, 246, -2)
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(this.Bz, -2, 154, -2)
                                                            )
                                                            .addGroup(
                                                               var1.createSequentialGroup()
                                                                  .addComponent(this.BJ, -2, 246, -2)
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(this.BB, -2, 154, -2)
                                                            )
                                                            .addGroup(
                                                               var1.createSequentialGroup()
                                                                  .addComponent(this.BK, -2, 246, -2)
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(this.BC, -2, 154, -2)
                                                            )
                                                            .addGroup(
                                                               var1.createSequentialGroup()
                                                                  .addGap(6, 6, 6)
                                                                  .addGroup(
                                                                     var1.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(
                                                                           var1.createSequentialGroup()
                                                                              .addComponent(this.BL, -2, 198, -2)
                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                              .addComponent(this.BD, -2, 202, -2)
                                                                        )
                                                                        .addGroup(
                                                                           var1.createSequentialGroup()
                                                                              .addComponent(this.uF, -2, 198, -2)
                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                              .addComponent(this.uf, -2, 202, -2)
                                                                        )
                                                                  )
                                                            )
                                                      )
                                                )
                                                .addGap(31, 31, 31)
                                          )
                                    )
                              )
                        )
                        .addGroup(
                           var1.createParallelGroup(Alignment.LEADING, false)
                              .addGroup(var1.createSequentialGroup().addComponent(this.Bx).addGap(18, 18, 18).addComponent(this.Bw, -1, -1, 32767))
                              .addComponent(this.BG, -2, 308, -2)
                        )
                  )
                  .addContainerGap(156, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(this.a_)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vf)
                  .addGap(41, 41, 41)
                  .addGroup(var1.createParallelGroup(Alignment.CENTER).addComponent(this.BO).addComponent(this.ue, -2, -1, -2))
                  .addGap(18, 18, 18)
                  .addComponent(this.BE, -2, 10, -2)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Bz, -2, -1, -2).addComponent(this.BH))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.BA, -2, -1, -2).addComponent(this.BI))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.BB, -2, -1, -2).addComponent(this.BJ))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.BC, -2, -1, -2).addComponent(this.BK))
                  .addGap(18, 18, 18)
                  .addComponent(this.By)
                  .addGap(7, 7, 7)
                  .addComponent(this.BF, -2, 10, -2)
                  .addGap(4, 4, 4)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uf, -2, -1, -2).addComponent(this.uF))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.BL).addComponent(this.BD, -2, 20, -2))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.BN).addComponent(this.BM))
                  .addGap(18, 18, 18)
                  .addComponent(this.BG, -2, 10, -2)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Bw, -2, 32, -2).addComponent(this.Bx, -2, 32, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ug, -1, 78, 32767)
                  .addContainerGap()
            )
      );
      this.ug
         .getAccessibleContext()
         .setAccessibleName(
            "<html> Versão não registrada do Brasfoot. Sem o registro você só pode iniciar da última divisão.<br> Na versão registrada, pode iniciar com qualquer time de qualquer divisão. </html>  "
         );
   }
}
