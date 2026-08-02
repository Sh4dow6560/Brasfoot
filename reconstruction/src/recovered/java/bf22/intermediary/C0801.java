package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0801 extends JPanel {
   private JLabel Sg;
   private JLabel Sh;
   private JLabel Si;
   private JLabel Sj;
   private JLabel Sk;
   private JLabel Sl;
   private JLabel yE;
   private JLabel uF;
   private JLabel Sm;
   private JLabel Sn;
   private JLabel So;

   public C0801(C0810 c0810) {
      this.mJ();
      this.Sg.setText(c0810.tc());
      if (c0810.getClub() != null) {
         this.uF.setText(c0810.getClub().getNome());
         this.uF.setIcon(c0810.getClub().kU());
         if (c0810.b() == 4 || c0810.b() == 6 || c0810.b() == 12) {
            this.uF.setToolTipText(C0696.bl(c0810.getClub().getPais()));
         }
      }

      int[] var2 = c0810.ta();
      this.Sm.setText(Integer.toString(var2[0]));
      this.yE.setText(Integer.toString(var2[1]));
      this.So.setText(Integer.toString(var2[2]));
      this.Sj.setText(Integer.toString(var2[3]));
      this.Si.setText(Integer.toString(var2[4]));
      this.Sl.setText(Integer.toString(var2[5]));
      this.Sk.setText(Integer.toString(var2[6]));
      this.Sn.setText(Integer.toString(var2[7]));
      if (c0810.td() == 1) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verde.png")));
      } else if (c0810.td() == 3) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verm.png")));
      } else if (c0810.td() == 4) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/azul.png")));
      } else if (c0810.td() == 5) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/azul2.png")));
      } else if (c0810.td() == 2) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/amarelo.png")));
      } else if (c0810.td() == 6) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/amarelo2.png")));
      } else if (c0810.td() == 301) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/vermazul.png")));
      } else if (c0810.td() == 302) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/vermazulclaro.png")));
      } else if (c0810.td() == 306) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/vermamarelo.png")));
      } else if (c0810.td() == 101) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verdeazul.png")));
      } else if (c0810.td() == 102) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verdeazulclaro.png")));
      } else if (c0810.td() == 106) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verdeamarelo.png")));
      } else if (c0810.td() == 12000) {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/rosa.png")));
      } else {
         this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cinza.png")));
      }
   }

   private void mJ() {
      this.Sh = new JLabel();
      this.uF = new JLabel();
      this.Sg = new JLabel();
      this.Si = new JLabel();
      this.Sn = new JLabel();
      this.yE = new JLabel();
      this.So = new JLabel();
      this.Sj = new JLabel();
      this.Sm = new JLabel();
      this.Sl = new JLabel();
      this.Sk = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(470, 25));
      this.setLayout(new C0807());
      this.add(this.Sh, new C0775(25, 0, 5, 25));
      this.uF.setFont(new Font("Arial", 1, 12));
      this.uF.setText("Internacional de Limeira");
      this.add(this.uF, new C0775(40, 0, 170, 25));
      this.Sg.setFont(new Font("Arial", 1, 12));
      this.Sg.setHorizontalAlignment(0);
      this.Sg.setText("10");
      this.add(this.Sg, new C0775(0, 0, 20, 25));
      this.Si.setFont(new Font("Arial", 1, 12));
      this.Si.setHorizontalAlignment(0);
      this.Si.setText("0");
      this.Si.setToolTipText("");
      this.add(this.Si, new C0775(330, 0, 30, 25));
      this.Sn.setFont(new Font("Arial", 1, 12));
      this.Sn.setHorizontalAlignment(0);
      this.Sn.setText("0");
      this.Sn.setToolTipText("");
      this.add(this.Sn, new C0775(435, 0, 30, 25));
      this.yE.setFont(new Font("Arial", 1, 12));
      this.yE.setHorizontalAlignment(0);
      this.yE.setText("0");
      this.yE.setToolTipText("");
      this.add(this.yE, new C0775(240, 0, 30, 25));
      this.So.setFont(new Font("Arial", 1, 12));
      this.So.setHorizontalAlignment(0);
      this.So.setText("0");
      this.So.setToolTipText("");
      this.add(this.So, new C0775(270, 0, 30, 25));
      this.Sj.setFont(new Font("Arial", 1, 12));
      this.Sj.setHorizontalAlignment(0);
      this.Sj.setText("0");
      this.Sj.setToolTipText("");
      this.add(this.Sj, new C0775(300, 0, 30, 25));
      this.Sm.setFont(new Font("Arial", 1, 12));
      this.Sm.setHorizontalAlignment(0);
      this.Sm.setText("0");
      this.Sm.setToolTipText("");
      this.Sm.setOpaque(true);
      this.add(this.Sm, new C0775(210, 0, 30, 25));
      this.Sl.setFont(new Font("Arial", 1, 12));
      this.Sl.setHorizontalAlignment(0);
      this.Sl.setText("0");
      this.Sl.setToolTipText("");
      this.Sl.setOpaque(true);
      this.add(this.Sl, new C0775(365, 0, 30, 25));
      this.Sk.setFont(new Font("Arial", 1, 12));
      this.Sk.setHorizontalAlignment(0);
      this.Sk.setText("0");
      this.Sk.setToolTipText("");
      this.add(this.Sk, new C0775(400, 0, 30, 25));
   }
}
