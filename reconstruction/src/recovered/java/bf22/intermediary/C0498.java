package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0498 extends JPanel {
   private JDialog ub;
   private C0692 vt = null;
   private C0924 vu = null;
   private int w;
   private JLabel Az = new JLabel();
   private ArrayList AE = new ArrayList();
   private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
   private ImageIcon AL = this.AJ;
   private Player MF = null;
   private JButton vm;
   private JComboBox vv;
   private JComboBox MG;
   private JComboBox ue;
   private JLabel Ds;
   private JLabel vf;
   private JLayeredPane MH;

   public C0498(JDialog jDialog, C0924 c0924, C0692 c0692, int i) {
      this.ub = jDialog;
      this.vu = c0924;
      this.vt = c0692;
      this.w = i;
      this.mJ();
      this.AE.clear();

      for (int var5 = 0; var5 <= 25; var5++) {
         C0795 var6 = new C0795();
         this.AE.add(var6);
      }

      this.mH();
      if (i == 1) {
         this.vf.setText("Time do Ano");
      }

      if (this.vt == null) {
         this.vt = (C0692)C0745.SR.N().get(0);
      }

      if (this.vu == null) {
         this.vu = (C0924)this.vt.eb().get(0);
      }

      this.mW();
   }

   public void mH() {
      this.vm.addActionListener(new C0499(this));
   }

   public void mW() {
      int var1 = 0;

      for (int var2 = 0; var2 < C0745.SR.N().size(); var2++) {
         this.ue.addItem(((C0692)C0745.SR.N().get(var2)).jp());
         if (this.vt == C0745.SR.N().get(var2)) {
            var1 = var2;
         }
      }

      C0037 var4 = new C0037();
      this.ue.setRenderer(var4);
      this.ue.setMaximumRowCount(12);
      this.ue.setSelectedIndex(var1);

      for (int var3 = 0; var3 < this.vt.eb().size(); var3++) {
         this.vv.addItem(Integer.toString(var3 + 1) + "ª divisão");
      }

      if (this.w == 0) {
         for (int var5 = 0; var5 < this.vu.yi().zb() - 1; var5++) {
            this.MG.addItem(Integer.toString(var5 + 1) + " ª rodada");
         }
      } else {
         for (int var6 = 0; var6 < C0745.SR.H(); var6++) {
            this.MG.addItem(Integer.toString(var6 + C0745.SR.op()));
         }
      }

      if (this.vu != null && this.vu.yi().getDivisao() < this.vv.getItemCount()) {
         this.vv.setSelectedIndex(this.vu.yi().getDivisao() - 1);
      }

      this.vv.addActionListener(new C0500(this));
      this.ue.addActionListener(new C0501(this));
      this.MG.addActionListener(new C0502(this));
      if (this.w == 0) {
         if (this.vu != null && this.vu.yi().zb() - 2 < this.MG.getItemCount()) {
            this.MG.setSelectedIndex(this.vu.yi().zb() - 2);
         }
      } else if (C0745.SR.H() - 1 < this.MG.getItemCount()) {
         this.MG.setSelectedIndex(C0745.SR.H() - 1);
      }
   }

   private void sy() {
      this.MF = null;

      for (int var1 = 0; var1 <= 25; var1++) {
         ((C0795)this.AE.get(var1)).vg();
      }

      int[] var4 = new int[]{1, 9, 3, 5, 2, 11, 13, 14, 16, 22, 24};
      if (this.w == 0) {
         int var2 = this.MG.getSelectedIndex();
         if (var2 < this.vu.zN().size() && var2 >= 0) {
            for (int var3 = 0; var3 < ((C0706)this.vu.zN().get(var2)).lV().size(); var3++) {
               ((C0795)this.AE.get(var4[var3])).a((Player)((C0706)this.vu.zN().get(var2)).lV().get(var3));
               if (((C0706)this.vu.zN().get(var2)).lW().get(var3) != null) {
                  ((C0795)this.AE.get(var4[var3])).h(((Club)((C0706)this.vu.zN().get(var2)).lW().get(var3)).kS());
                  ((C0795)this.AE.get(var4[var3])).n((Club)((C0706)this.vu.zN().get(var2)).lW().get(var3));
               } else {
                  ((C0795)this.AE.get(var4[var3])).h(this.AL);
               }
            }
         }
      } else {
         int var5 = this.MG.getSelectedIndex();
         if (var5 < this.vu.zM().size() && var5 >= 0) {
            this.MF = (Player)this.vu.zM().get(var5);
         }

         if (var5 < this.vu.zI().size() && var5 >= 0) {
            for (int var6 = 0; var6 < ((C0706)this.vu.zI().get(var5)).lV().size(); var6++) {
               ((C0795)this.AE.get(var4[var6])).a((Player)((C0706)this.vu.zI().get(var5)).lV().get(var6));
               if (((C0706)this.vu.zI().get(var5)).lW().get(var6) != null) {
                  ((C0795)this.AE.get(var4[var6])).h(((Club)((C0706)this.vu.zI().get(var5)).lW().get(var6)).kS());
                  ((C0795)this.AE.get(var4[var6])).n((Club)((C0706)this.vu.zI().get(var5)).lW().get(var6));
               } else {
                  ((C0795)this.AE.get(var4[var6])).h(this.AL);
               }
            }
         }
      }

      this.b(-1, this.MF);
   }

   private void b(int i, Player player) {
      this.g(((C0795)this.AE.get(0)).a(this.AE, i, this.AL, true, 1, player));
   }

   public void g(ImageIcon imageIcon) {
      this.Az.setIcon(null);
      this.Az.setIcon(imageIcon);
      this.MH.add(this.Az, new C0775(-45, 0, -1, -1));
      this.MH.setLayer(this.Az, JLayeredPane.POPUP_LAYER);
   }

   private void mX() {
      if (this.vv.getSelectedIndex() < this.vt.eb().size()) {
         this.vu = (C0924)this.vt.eb().get(this.vv.getSelectedIndex());
      }

      if (this.w == 0) {
         this.MG.removeAllItems();

         for (int var1 = 0; var1 < this.vu.yi().zb() - 1; var1++) {
            this.MG.addItem(Integer.toString(var1 + 1) + " ª rodada");
         }

         if (this.vu != null && this.vu.yi().zb() - 2 < this.MG.getItemCount()) {
            this.MG.setSelectedIndex(this.vu.yi().zb() - 2);
         }
      } else if (C0745.SR.H() - 1 < this.MG.getItemCount()) {
         this.MG.setSelectedIndex(C0745.SR.H() - 1);
      }
   }

   private void mU() {
      this.vt = (C0692)C0745.SR.N().get(this.ue.getSelectedIndex());
      this.vv.removeAllItems();

      for (int var1 = 0; var1 < this.vt.eb().size(); var1++) {
         this.vv.addItem(Integer.toString(var1 + 1) + "ª divisão");
      }

      this.vv.setSelectedIndex(0);
      this.mX();
   }

   private void mJ() {
      this.MH = new JLayeredPane();
      this.Ds = new JLabel();
      this.vf = new JLabel();
      this.vm = new JButton();
      this.ue = new JComboBox();
      this.vv = new JComboBox();
      this.MG = new JComboBox();
      this.setBackground(new Color(44, 53, 49));
      this.setLayout(new C0807());
      this.MH.setLayout(new C0807());
      this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/campo_diminuido.jpg")));
      this.Ds.setAlignmentY(0.0F);
      this.Ds.setRequestFocusEnabled(false);
      this.MH.add(this.Ds, new C0775(5, 0, 400, 566));
      this.add(this.MH, new C0775(10, 80, 390, 566));
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Time da Rodada");
      this.add(this.vf, new C0775(10, 15, -1, -1));
      this.vm.setText("X");
      this.add(this.vm, new C0775(303, 10, 50, -1));
      this.ue.addActionListener(new C0503(this));
      this.add(this.ue, new C0775(10, 50, 120, -1));
      this.add(this.vv, new C0775(140, 50, 110, -1));
      this.add(this.MG, new C0775(260, 50, 100, -1));
   }

   private void b(ActionEvent actionEvent) {
   }
}
