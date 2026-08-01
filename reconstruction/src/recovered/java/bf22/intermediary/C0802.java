package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0802 extends JPanel {
   private JLabel Sp;
   private JLabel Sq;
   private JLabel Sr;
   private JLabel Ss;
   private JLabel St;
   private JLabel zR;
   private JLabel Su;

   public C0802(C0809 c0809, ArrayList arrayList) {
      Object var3 = null;
      if (arrayList.contains(c0809.sP().getHomeClub())) {
         var3 = c0809.sP().getHomeClub();
      } else {
         var3 = c0809.sP().getAwayClub();
      }

      if (c0809.sQ() != null) {
         this.mJ();
      } else {
         this.vx();
      }

      if (c0809.sP() != null) {
         this.Sp.setText(c0809.sP().getHomeClub().getNome());
         this.Sp.setIcon(c0809.sP().getHomeClub().kU());
         this.Sq.setText(c0809.sP().getAwayClub().getNome());
         this.Sq.setIcon(c0809.sP().getAwayClub().kU());
         if (c0809.b() == 4 || c0809.b() == 6 || c0809.b() == 12) {
            this.Sp.setToolTipText(C0696.bl(c0809.sP().getHomeClub().getPais()));
            this.Sq.setToolTipText(C0696.bl(c0809.sP().getAwayClub().getPais()));
         }

         if (c0809.sP().e()) {
            this.St.setText(c0809.sP().t(false));
         }
      }

      if (c0809.sQ() != null) {
         this.Sr.setText(c0809.sQ().getHomeClub().getNome());
         this.Sr.setIcon(c0809.sQ().getHomeClub().kU());
         this.Ss.setText(c0809.sQ().getAwayClub().getNome());
         this.Ss.setIcon(c0809.sQ().getAwayClub().kU());
         if (c0809.b() == 4 || c0809.b() == 6 || c0809.b() == 12) {
            this.Sr.setToolTipText(C0696.bl(c0809.sQ().getHomeClub().getPais()));
            this.Ss.setToolTipText(C0696.bl(c0809.sQ().getAwayClub().getPais()));
         }

         if (c0809.sQ().e()) {
            this.zR.setText(c0809.sQ().t(false));
         }
      }

      if (c0809.sQ() == null && c0809.sP().e()) {
         int[] var6 = c0809.sP().hQ();
         if (var6[0] >= 0 || var6[1] >= 0) {
            this.Su.setText("P:" + c0809.sP().u(false));
         }

         if (var3 == c0809.sP().getHomeClub()) {
            this.Sp.setFont(new Font("Arial", 1, 12));
         } else {
            this.Sq.setFont(new Font("Arial", 1, 12));
         }
      } else if (c0809.sQ() != null && c0809.sQ().e()) {
         int[] var4 = c0809.sQ().hQ();
         if (var4[0] >= 0 || var4[1] >= 0) {
            this.Su.setText("P:" + c0809.sQ().u(false));
         }

         if (var3 == c0809.sP().getHomeClub()) {
            this.Sp.setFont(new Font("Arial", 1, 12));
         } else {
            this.Sq.setFont(new Font("Arial", 1, 12));
         }

         if (var3 == c0809.sQ().getHomeClub()) {
            this.Sr.setFont(new Font("Arial", 1, 12));
         } else {
            this.Ss.setFont(new Font("Arial", 1, 12));
         }
      }
   }

   private void mJ() {
      this.Sq = new JLabel();
      this.Ss = new JLabel();
      this.Sp = new JLabel();
      this.Sr = new JLabel();
      this.zR = new JLabel();
      this.Su = new JLabel();
      this.St = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(480, 25));
      this.setLayout(new C0807());
      this.Sq.setFont(new Font("Arial", 0, 12));
      this.Sq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.Sq.setText("Jorge Wilstermann");
      this.add(this.Sq, new C0775(260, 0, 170, 25));
      this.Ss.setFont(new Font("Arial", 0, 12));
      this.Ss.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.Ss.setText("Mamelodi Sundowns");
      this.add(this.Ss, new C0775(260, 28, 164, 25));
      this.Sp.setFont(new Font("Arial", 0, 12));
      this.Sp.setHorizontalAlignment(4);
      this.Sp.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.Sp.setText("Mamelodi Sundowns");
      this.Sp.setHorizontalTextPosition(2);
      this.add(this.Sp, new C0775(10, 0, 180, 25));
      this.Sr.setFont(new Font("Arial", 0, 12));
      this.Sr.setHorizontalAlignment(4);
      this.Sr.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.Sr.setText("Jorge Wilstermann");
      this.Sr.setHorizontalTextPosition(2);
      this.add(this.Sr, new C0775(10, 28, 180, 25));
      this.zR.setFont(new Font("Arial", 0, 12));
      this.zR.setHorizontalAlignment(0);
      this.zR.setText("x");
      this.add(this.zR, new C0775(200, 30, 50, 20));
      this.Su.setFont(new Font("Arial", 0, 12));
      this.Su.setHorizontalAlignment(0);
      this.add(this.Su, new C0775(420, 33, 50, 15));
      this.St.setFont(new Font("Arial", 0, 12));
      this.St.setHorizontalAlignment(0);
      this.St.setText("x");
      this.add(this.St, new C0775(200, 2, 50, 20));
   }

   private void vx() {
      this.Sq = new JLabel();
      this.Sp = new JLabel();
      this.Su = new JLabel();
      this.St = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(480, 25));
      this.setLayout(new C0807());
      this.Sq.setFont(new Font("Arial", 0, 12));
      this.Sq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.Sq.setText("");
      this.add(this.Sq, new C0775(260, 0, 164, 25));
      this.Sp.setFont(new Font("Arial", 0, 12));
      this.Sp.setHorizontalAlignment(4);
      this.Sp.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.Sp.setText("");
      this.Sp.setHorizontalTextPosition(2);
      this.add(this.Sp, new C0775(10, 0, 180, 25));
      this.Su.setFont(new Font("Arial", 0, 12));
      this.Su.setHorizontalAlignment(0);
      this.add(this.Su, new C0775(420, 0, 50, 25));
      this.St.setFont(new Font("Arial", 0, 12));
      this.St.setHorizontalAlignment(0);
      this.St.setText("x");
      this.add(this.St, new C0775(200, 2, 50, 20));
   }
}
