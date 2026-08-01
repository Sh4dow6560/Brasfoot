package bf22.intermediary;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;
import mod.recovered.team.LineupPreset;

public class C0489 extends JPanel {
   private JDialog ub;
   private Club zu;
   private C0132 AG;
   private JButton vb;
   private JButton vc;
   private JButton GP;
   private JComboBox Bf;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JTextField Ej;

   public C0489(C0132 c0132, JDialog jDialog, Club club) {
      this.zu = club;
      this.ub = jDialog;
      this.AG = c0132;
      this.mJ();
      this.mH();
      this.su();
   }

   public void su() {
      for (int var1 = 0; var1 < this.zu.kV().size(); var1++) {
         int[] var2 = new int[]{-1, 0, 0};

         for (int var3 = 0; var3 < ((LineupPreset)this.zu.kV().get(var1)).getPositions().size(); var3++) {
            if ((Integer)((LineupPreset)this.zu.kV().get(var1)).getPositions().get(var3) <= 9) {
               var2[0]++;
            } else if ((Integer)((LineupPreset)this.zu.kV().get(var1)).getPositions().get(var3) <= 17) {
               var2[1]++;
            } else if ((Integer)((LineupPreset)this.zu.kV().get(var1)).getPositions().get(var3) <= 25) {
               var2[2]++;
            }
         }

         this.Bf
            .addItem(
               ((LineupPreset)this.zu.kV().get(var1)).getName()
                  + " ("
                  + Integer.toString(var2[0])
                  + "-"
                  + Integer.toString(var2[1])
                  + "-"
                  + Integer.toString(var2[2])
                  + ")"
            );
      }
   }

   public void mH() {
      this.GP.addActionListener(new C0490(this));
      this.vb.addActionListener(new C0491(this));
      this.vc.addActionListener(new C0492(this));
   }

   private void sv() {
      if (this.Bf.getItemCount() > 0) {
         int var1 = this.Bf.getSelectedIndex();
         LineupPreset var2 = (LineupPreset)this.zu.kV().get(var1);
         this.zu.kV().remove(var2);
         this.Bf.removeAllItems();
         this.su();
      }
   }

   private void sw() {
      if (this.Bf.getItemCount() > 0) {
         int var1 = this.Bf.getSelectedIndex();
         LineupPreset var2 = (LineupPreset)this.zu.kV().get(var1);
         if (var2 != null) {
            this.AG.a(var2, true);
            this.ub.dispose();
         }
      }
   }

   private void sx() {
      if (!this.Ej.getText().isEmpty()) {
         LineupPreset var1 = new LineupPreset();
         int[] var2 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

         for (int var3 = 0; var3 < 37; var3++) {
            if (((C0795)C0132.oa().get(var3)).x() != null) {
               var1.getPlayers().add(((C0795)C0132.oa().get(var3)).x());
               var1.getPositions().add(var3);
            } else if (((C0795)C0132.oa().get(var3)).vf() != null) {
               var1.getPlayers().add(null);
               var1.getPositions().add(var3);
            }
         }

         int[] var8 = new int[]{-1, 0, 0};
         int var4 = 0;

         for (int var5 = 0; var5 < var1.getPositions().size(); var5++) {
            if (var4 < var2.length) {
               var2[var4] = (Integer)var1.getPositions().get(var5);
               var4++;
            }

            if ((Integer)var1.getPositions().get(var5) <= 9) {
               var8[0]++;
            } else if ((Integer)var1.getPositions().get(var5) <= 17) {
               var8[1]++;
            } else if ((Integer)var1.getPositions().get(var5) <= 25) {
               var8[2]++;
            }
         }

         int[] var9 = new int[]{1, 2, 6, 8, 9, 11, 13, 14, 15, 16, 23};
         int[] var6 = new int[]{1, 2, 6, 8, 9, 10, 11, 13, 15, 17, 20};
         String var7 = Integer.toString(var8[0]) + "-" + Integer.toString(var8[1]) + "-" + Integer.toString(var8[2]);
         if (Arrays.equals(var9, var2)) {
            var7 = "4-2-3-1";
         } else if (Arrays.equals(var6, var2)) {
            var7 = "4-2-3-1 Alas";
         }

         var1.setName(this.Ej.getText().toString());
         this.Bf.addItem(this.Ej.getText().toString() + " (" + var7 + ")");
         this.zu.kV().add(var1);
      }
   }

   private void mJ() {
      this.ug = new JLabel();
      this.Bf = new JComboBox();
      this.vb = new JButton();
      this.vc = new JButton();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.Ej = new JTextField();
      this.GP = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Táticas salvas:");
      this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/loadt.png")));
      this.vb.setText("Carregar");
      this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icondel.png")));
      this.vc.setText("Apagar");
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("Salvar tática atual");
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setText("Nome:");
      this.GP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconadd.png")));
      this.GP.setText("salvar");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(29, 29, 29)
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                           var1.createParallelGroup(Alignment.LEADING, false)
                              .addComponent(this.ug, -2, 160, -2)
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.vb, -2, 117, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.vc, -2, 117, -2)
                              )
                              .addComponent(this.Bf, Alignment.TRAILING, -2, 256, -2)
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.a_, -2, 42, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(this.Ej)
                              )
                              .addComponent(this.uh, -2, 247, -2)
                        )
                        .addComponent(this.GP, -2, 103, -2)
                  )
                  .addContainerGap(30, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(23, 23, 23)
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Bf, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.LEADING, false).addComponent(this.vb, -1, -1, 32767).addComponent(this.vc, -1, -1, 32767))
                  .addGap(23, 23, 23)
                  .addComponent(this.uh)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.a_).addComponent(this.Ej, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.GP)
                  .addContainerGap(21, 32767)
            )
      );
   }
}
