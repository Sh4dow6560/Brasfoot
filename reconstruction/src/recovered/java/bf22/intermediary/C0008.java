package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0008 extends JPanel {
   private JDialog ub;
   private C0692 vt = null;
   private C0924 vu = null;
   private JButton vm;
   private JComboBox vv;
   private JComboBox ue;
   private JLabel ug;
   private JLabel vw;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;
   private JLabel vz;
   private JLabel vA;
   private C0800 vB;
   private C0800 vC;
   private C0800 vD;
   private C0800 vE;
   private C0800 vF;
   private C0800 vG;
   private C0800 vH;
   private C0800 vI;

   public C0008(JDialog jDialog, C0924 c0924, C0692 c0692) {
      this.ub = jDialog;
      this.vu = c0924;
      this.vt = c0692;
      this.mK();
      this.mJ();
      this.mH();
      this.mW();
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   private void mK() {
      this.vu.zL();
      this.vB = new C0800(this.vu.fj(0));
      this.vC = new C0800(this.vu.fj(1));
      this.vD = new C0800(this.vu.fj(2));
      this.vE = new C0800(this.vu.fj(3));
      this.vF = new C0800(this.vu.fj(6));
      this.vG = new C0800(this.vu.fj(5));
      this.vH = new C0800(this.vu.zG());
      this.vI = new C0800(this.vu.fj(4));
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
      var4.setPreferredSize(new Dimension(12, 25));
      this.ue.setRenderer(var4);
      this.ue.setMaximumRowCount(12);
      this.ue.setSelectedIndex(var1);

      for (int var3 = 0; var3 < this.vt.eb().size(); var3++) {
         this.vv.addItem(Integer.toString(var3 + 1) + "ª divisão");
      }

      if (this.vu != null && this.vu.yi().getDivisao() < this.vv.getItemCount()) {
         this.vv.setSelectedIndex(this.vu.yi().getDivisao() - 1);
      }

      this.vv.addActionListener(new C0009(this));
      this.ue.addActionListener(new C0010(this));
   }

   private void mU() {
      this.vt = (C0692)C0745.SR.N().get(this.ue.getSelectedIndex());
      this.vv.removeAllItems();

      for (int var1 = 0; var1 < this.vt.eb().size(); var1++) {
         this.vv.addItem(Integer.toString(var1 + 1) + "ª divisão");
      }

      this.vv.setSelectedIndex(0);
   }

   private void mX() {
      if (this.vv.getSelectedIndex() < this.vt.eb().size()) {
         this.vu = (C0924)this.vt.eb().get(this.vv.getSelectedIndex());
      }

      this.vu.zL();
      this.vB.ac(this.vu.fj(0));
      this.vC.ac(this.vu.fj(1));
      this.vD.ac(this.vu.fj(2));
      this.vE.ac(this.vu.fj(3));
      this.vF.ac(this.vu.fj(6));
      this.vG.ac(this.vu.fj(5));
      this.vH.ac(this.vu.zG());
      this.vI.ac(this.vu.fj(4));
   }

   public void mH() {
      this.vm.addActionListener(new C0011(this));
   }

   private void mJ() {
      this.ug = new JLabel();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.vx = new JLabel();
      this.vy = new JLabel();
      this.vz = new JLabel();
      this.vA = new JLabel();
      this.vw = new JLabel();
      this.vm = new JButton();
      this.vv = new JComboBox();
      this.ue = new JComboBox();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setBackground(new Color(104, 120, 100));
      this.setLayout(new C0807());
      this.ug.setBackground(new Color(0, 0, 0));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Goleiro");
      this.ug.setOpaque(true);
      this.add(this.ug, new C0775(10, 12, 325, 22));
      this.add(this.vB, new C0775(10, 40, 325, 180));
      this.add(this.vC, new C0775(10, 266, 325, 180));
      this.uh.setBackground(new Color(0, 0, 0));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(0);
      this.uh.setText("Lateral Direito");
      this.uh.setOpaque(true);
      this.add(this.uh, new C0775(10, 238, 325, 22));
      this.add(this.vD, new C0775(10, 485, 325, 180));
      this.a_.setBackground(new Color(0, 0, 0));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(0);
      this.a_.setText("Zagueiro");
      this.a_.setOpaque(true);
      this.add(this.a_, new C0775(10, 457, 325, 22));
      this.add(this.vE, new C0775(345, 485, 325, 180));
      this.ur.setBackground(new Color(0, 0, 0));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(0);
      this.ur.setText("Meia Ofensivo");
      this.ur.setOpaque(true);
      this.add(this.ur, new C0775(345, 457, 325, 22));
      this.add(this.vF, new C0775(345, 266, 325, 180));
      this.us.setBackground(new Color(0, 0, 0));
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setHorizontalAlignment(0);
      this.us.setText("Volante");
      this.us.setOpaque(true);
      this.add(this.us, new C0775(345, 238, 325, 22));
      this.add(this.vG, new C0775(345, 40, 325, 180));
      this.vx.setBackground(new Color(0, 0, 0));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(0);
      this.vx.setText("Lateral Esquerdo");
      this.vx.setOpaque(true);
      this.add(this.vx, new C0775(345, 12, 325, 22));
      this.vy.setBackground(new Color(255, 204, 0));
      this.vy.setHorizontalAlignment(0);
      this.vy.setText("Bola de Ouro");
      this.vy.setOpaque(true);
      this.add(this.vy, new C0775(680, 457, 325, 22));
      this.add(this.vH, new C0775(680, 485, 325, 180));
      this.add(this.vI, new C0775(680, 266, 325, 180));
      this.vz.setBackground(new Color(0, 0, 0));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(0);
      this.vz.setText("Atacante");
      this.vz.setOpaque(true);
      this.add(this.vz, new C0775(680, 238, 325, 22));
      this.add(this.vA, new C0775(688, 12, 317, -1));
      this.vw.setIcon(new ImageIcon(this.getClass().getResource("/aicons/bolaouro.png")));
      this.add(this.vw, new C0775(770, 20, 150, 120));
      this.vm.setText("X");
      this.add(this.vm, new C0775(950, 20, 50, -1));
      this.add(this.vv, new C0775(770, 190, 160, -1));
      this.add(this.ue, new C0775(770, 160, 160, -1));
   }
}
