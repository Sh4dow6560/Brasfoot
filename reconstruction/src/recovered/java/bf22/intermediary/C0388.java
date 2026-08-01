package bf22.intermediary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0388 extends JFrame {
   private JLabel uh;
   private JPanel vd;
   private JLabel afs;
   private JLabel zM;
   private JLabel aft;
   private JLabel afu;
   private JLabel afv;
   private JLabel afw;
   private JLabel afx;

   public C0388() {
      try {
         ImageIcon var1 = new ImageIcon(this.getClass().getResource("/aicons/icon16.png"));
         this.setIconImage(var1.getImage());
      } catch (Exception var2) {
      }

      this.setTitle("Brasfoot");
      this.setUndecorated(true);
      this.mJ();
      this.afu.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/iconreg.png")));
      this.afu.setCursor(new Cursor(12));
      this.aft.setCursor(new Cursor(12));
      this.afs.setCursor(new Cursor(12));
      this.afx.setCursor(new Cursor(12));
      this.afw.setCursor(new Cursor(12));
      this.mH();
      if (C0745.vL()) {
         this.rO();
      }

      this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/tela_inicial.jpg")));
   }

   public void mH() {
      this.aft.addMouseListener(new C0389(this));
      this.afs.addMouseListener(new C0390(this));
      this.afu.addMouseListener(new C0391(this));
      this.afx.addMouseListener(new C0392(this));
      this.afw.addMouseListener(new C0393(this));
   }

   private void pW() {
      C0732.b(this);
      C0732.g("Metal");
      C0685.cX();
   }

   private void rN() {
      C0732.b(this);
      C0732.g("Metal");
      C0732.cV();
      C0732.cW();
      this.setVisible(false);
   }

   private void rO() {
      this.afu.setVisible(false);
      this.uh.setVisible(false);
   }

   private void mi() {
      new C0745();
      C0734.dd();
      C0732.g("Metal");
      if (C0732.db() == null) {
         new C0685(true);
      } else {
         C0685.aY(0);
      }

      this.dispose();
   }

   private void rP() {
      if (C0732.db() == null) {
         new C0685(false);
         C0685.aY(7);
      } else {
         C0685.aY(7);
      }

      this.dispose();
   }

   private void mJ() {
      this.vd = new JPanel();
      this.afu = new JLabel();
      this.afv = new JLabel();
      this.afx = new JLabel();
      this.aft = new JLabel();
      this.afs = new JLabel();
      this.uh = new JLabel();
      this.afw = new JLabel();
      this.zM = new JLabel();
      this.setDefaultCloseOperation(3);
      this.getContentPane().setLayout(new C0807());
      this.vd.setLayout(new C0807());
      this.afu.setFont(new Font("Tahoma", 0, 19));
      this.afu.setForeground(new Color(255, 255, 255));
      this.afu.setText("REGISTRAR JOGO");
      this.vd.add(this.afu, new C0775(10, 210, 230, 80));
      this.afv.setFont(new Font("Tahoma", 1, 12));
      this.afv.setForeground(new Color(255, 255, 255));
      this.vd.add(this.afv, new C0775(60, 200, 80, 60));
      this.afx.setFont(new Font("Tahoma", 1, 12));
      this.afx.setForeground(new Color(255, 255, 255));
      this.vd.add(this.afx, new C0775(210, 110, 140, 90));
      this.aft.setFont(new Font("Tahoma", 1, 12));
      this.aft.setForeground(new Color(255, 255, 255));
      this.vd.add(this.aft, new C0775(30, 110, 140, 90));
      this.afs.setFont(new Font("Tahoma", 1, 12));
      this.afs.setForeground(new Color(255, 255, 255));
      this.vd.add(this.afs, new C0775(370, 110, 140, 90));
      this.uh.setFont(new Font("Tahoma", 0, 12));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(4);
      this.uh.setText("versão não registrada");
      this.vd.add(this.uh, new C0775(310, 30, 150, 20));
      this.afw.setFont(new Font("Tahoma", 1, 12));
      this.afw.setForeground(new Color(255, 255, 255));
      this.vd.add(this.afw, new C0775(420, 260, 80, 30));
      this.zM.setMaximumSize(new Dimension(306, 413));
      this.zM.setMinimumSize(new Dimension(306, 413));
      this.vd.add(this.zM, new C0775(0, 0, 532, 300));
      this.getContentPane().add(this.vd, new C0775(0, 0, 530, 300));
      this.pack();
   }
}
