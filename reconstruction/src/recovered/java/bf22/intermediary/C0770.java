package bf22.intermediary;

import mod.recovered.match.Match;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0770 extends JPanel {
   C0435 QS = null;
   Match zz = null;
   private MouseAdapter QT;
   private JLabel Lm;
   private JLabel zO;
   private JLabel zP;
   private JLabel QU;

   public C0770(C0826 c0826, C0435 c0435) {
      this.QS = c0435;
      this.zz = c0826.tR();
      if (c0826.tR() != null) {
         this.mJ();
         this.mH();
         this.b(c0826);
      } else {
         this.ui();
         this.QU.setText(c0826.sT());
      }
   }

   private void mH() {
      this.QT = new C0771(this);
      this.zO.addMouseListener(this.QT);
      this.zP.addMouseListener(this.QT);
      this.Lm.addMouseListener(this.QT);
   }

   private void us() {
      this.QS.a(this, this.zz);
   }

   public void e(Color color) {
      this.setBackground(color);
   }

   private void b(C0826 c0826) {
      this.zO.setText(c0826.tR().hc().getNome());
      this.zO.setIcon(c0826.tR().hc().kU());
      this.zP.setText(c0826.tR().hd().getNome());
      this.zP.setIcon(c0826.tR().hd().kU());
      this.Lm.setText(c0826.tR().hu() + " x " + c0826.tR().hw() + " ");
   }

   private void mJ() {
      this.zO = new JLabel();
      this.Lm = new JLabel();
      this.zP = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(295, 25));
      this.setLayout(new C0807());
      this.zO.setFont(new Font("Arial", 0, 12));
      this.zO.setHorizontalAlignment(4);
      this.zO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.zO.setText("");
      this.zO.setHorizontalTextPosition(2);
      this.add(this.zO, new C0775(0, 0, 128, 25));
      this.Lm.setBackground(new Color(0, 0, 0));
      this.Lm.setFont(new Font("Arial", 0, 12));
      this.Lm.setHorizontalAlignment(0);
      this.Lm.setText("0 x 0");
      this.add(this.Lm, new C0775(129, 0, 40, 25));
      this.zP.setFont(new Font("Arial", 0, 12));
      this.zP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.zP.setText("");
      this.add(this.zP, new C0775(169, 0, 128, 25));
   }

   private void ui() {
      this.QU = new JLabel();
      this.setBackground(new Color(0, 102, 153));
      this.setPreferredSize(new Dimension(295, 25));
      this.setLayout(new C0807());
      this.QU.setFont(new Font("Arial", 1, 12));
      this.QU.setForeground(new Color(255, 255, 255));
      this.QU.setHorizontalAlignment(0);
      this.QU.setText("");
      this.add(this.QU, new C0775(-3, 0, 300, 25));
   }

   public Match tR() {
      return this.zz;
   }
}
