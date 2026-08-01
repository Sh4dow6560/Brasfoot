package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0805 extends JPanel {
   C0447 Sv = null;
   private JPanel vd;
   private JLabel Sw;
   private JLabel Si;
   private JLabel Sj;
   private JLabel wm;
   private JLabel Sk;
   private JLabel Sl;
   private JLabel yE;
   private JLabel Sx;
   private JLabel So;

   public C0805(int i, C0786 c0786, C0447 c0447) {
      this.Sv = c0447;
      if (i == 1) {
         this.mJ();
         if (c0786 != null) {
            this.b(c0786);
         }
      }

      if (i == 2) {
         this.vy();
         if (c0786 != null) {
            this.a(c0786);
         }
      } else if (i == 0) {
         this.ui();
      }
   }

   private void us() {
      this.Sv.a(this);
   }

   public void aI(boolean bl) {
      if (bl) {
         this.setBackground(new Color(211, 191, 22));
      } else {
         this.setBackground(new Color(228, 227, 227));
      }
   }

   private void a(C0786 c0786) {
      this.wm.setText("Total em " + c0786.uD() + ":");
      this.yE.setText(Integer.toString(c0786.w()));
      this.So.setText(Integer.toString(c0786.cm()));
      this.Sj.setText(Integer.toString(c0786.uF()));
      this.Si.setText(Integer.toString(c0786.co()));
      this.Sl.setText(Integer.toString(c0786.ls()));
      this.Sk.setText(Integer.toString(c0786.lt()));
   }

   private void b(C0786 c0786) {
      this.Sw.setText(c0786.uD());
      this.Sx.setText(c0786.tZ());
      this.wm.setText(c0786.uG());
      this.yE.setText(Integer.toString(c0786.w()));
      this.So.setText(Integer.toString(c0786.cm()));
      this.Sj.setText(Integer.toString(c0786.uF()));
      this.Si.setText(Integer.toString(c0786.co()));
      this.Sl.setText(Integer.toString(c0786.ls()));
      this.Sk.setText(Integer.toString(c0786.lt()));
      if (c0786.lw() == 1) {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_sobe.png")));
      } else if (c0786.lw() == 0) {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_desce.png")));
      } else if (c0786.lx()) {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_ch.png")));
      } else if (c0786.ly()) {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_vice.png")));
      } else if (c0786.lz()) {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_eli.png")));
      } else if (c0786.ly()) {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_vice.png")));
      } else {
         this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_nulo.png")));
      }
   }

   private void mJ() {
      this.wm = new JLabel();
      this.Sw = new JLabel();
      this.Si = new JLabel();
      this.yE = new JLabel();
      this.So = new JLabel();
      this.Sj = new JLabel();
      this.Sk = new JLabel();
      this.Sl = new JLabel();
      this.Sx = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(680, 25));
      this.setLayout(new C0807());
      this.wm.setFont(new Font("Arial", 1, 12));
      this.wm.setText("");
      this.add(this.wm, new C0775(250, 0, 180, 25));
      this.Sw.setFont(new Font("Arial", 1, 12));
      this.Sw.setHorizontalAlignment(0);
      this.Sw.setText("2022");
      this.add(this.Sw, new C0775(0, 0, 50, 25));
      this.Si.setFont(new Font("Arial", 1, 12));
      this.Si.setHorizontalAlignment(0);
      this.Si.setText("100");
      this.Si.setToolTipText("");
      this.add(this.Si, new C0775(550, 0, 30, 25));
      this.yE.setFont(new Font("Arial", 1, 12));
      this.yE.setHorizontalAlignment(0);
      this.yE.setText("100");
      this.yE.setToolTipText("");
      this.add(this.yE, new C0775(450, 0, 30, 25));
      this.So.setFont(new Font("Arial", 1, 12));
      this.So.setHorizontalAlignment(0);
      this.So.setText("100");
      this.So.setToolTipText("");
      this.add(this.So, new C0775(490, 0, 30, 25));
      this.Sj.setFont(new Font("Arial", 1, 12));
      this.Sj.setHorizontalAlignment(0);
      this.Sj.setText("100");
      this.Sj.setToolTipText("");
      this.add(this.Sj, new C0775(520, 0, 30, 25));
      this.Sk.setBackground(new Color(233, 239, 240));
      this.Sk.setFont(new Font("Arial", 1, 12));
      this.Sk.setHorizontalAlignment(0);
      this.Sk.setText("100");
      this.Sk.setToolTipText("");
      this.Sk.setOpaque(true);
      this.add(this.Sk, new C0775(620, 0, 30, 25));
      this.Sl.setBackground(new Color(239, 231, 227));
      this.Sl.setFont(new Font("Arial", 1, 12));
      this.Sl.setHorizontalAlignment(0);
      this.Sl.setText("100");
      this.Sl.setToolTipText("");
      this.Sl.setOpaque(true);
      this.add(this.Sl, new C0775(580, 0, 30, 25));
      this.Sx.setFont(new Font("Arial", 1, 12));
      this.Sx.setText("");
      this.add(this.Sx, new C0775(60, 0, 170, 25));
   }

   private void ui() {
      this.vd = new JPanel();
      this.Sw = new JLabel();
      this.Sx = new JLabel();
      this.wm = new JLabel();
      this.yE = new JLabel();
      this.So = new JLabel();
      this.Sj = new JLabel();
      this.Si = new JLabel();
      this.Sl = new JLabel();
      this.Sk = new JLabel();
      this.setBackground(new Color(0, 0, 0));
      this.setPreferredSize(new Dimension(480, 25));
      this.setLayout(new C0807());
      this.vd.setBackground(new Color(0, 0, 0));
      this.vd.setPreferredSize(new Dimension(690, 25));
      this.vd.setLayout(new C0807());
      this.Sw.setFont(new Font("Arial", 1, 12));
      this.Sw.setForeground(new Color(239, 239, 239));
      this.Sw.setHorizontalAlignment(0);
      this.Sw.setText("Ano");
      this.vd.add(this.Sw, new C0775(0, 0, 50, 25));
      this.Sx.setFont(new Font("Arial", 1, 12));
      this.Sx.setForeground(new Color(239, 239, 239));
      this.Sx.setText("Competição");
      this.vd.add(this.Sx, new C0775(60, 0, 170, 25));
      this.wm.setFont(new Font("Arial", 1, 12));
      this.wm.setForeground(new Color(239, 239, 239));
      this.wm.setText("Colocação");
      this.vd.add(this.wm, new C0775(250, 0, 180, 25));
      this.yE.setFont(new Font("Arial", 1, 12));
      this.yE.setForeground(new Color(239, 239, 239));
      this.yE.setHorizontalAlignment(0);
      this.yE.setText("J");
      this.yE.setToolTipText("");
      this.vd.add(this.yE, new C0775(450, 0, 30, 25));
      this.So.setFont(new Font("Arial", 1, 12));
      this.So.setForeground(new Color(239, 239, 239));
      this.So.setHorizontalAlignment(0);
      this.So.setText("V");
      this.So.setToolTipText("");
      this.vd.add(this.So, new C0775(490, 0, 30, 25));
      this.Sj.setFont(new Font("Arial", 1, 12));
      this.Sj.setForeground(new Color(239, 239, 239));
      this.Sj.setHorizontalAlignment(0);
      this.Sj.setText("E");
      this.Sj.setToolTipText("");
      this.vd.add(this.Sj, new C0775(520, 0, 30, 25));
      this.Si.setFont(new Font("Arial", 1, 12));
      this.Si.setForeground(new Color(239, 239, 239));
      this.Si.setHorizontalAlignment(0);
      this.Si.setText("D");
      this.Si.setToolTipText("");
      this.vd.add(this.Si, new C0775(550, 0, 30, 25));
      this.Sl.setFont(new Font("Arial", 1, 12));
      this.Sl.setForeground(new Color(239, 239, 239));
      this.Sl.setHorizontalAlignment(0);
      this.Sl.setText("GP");
      this.Sl.setToolTipText("");
      this.vd.add(this.Sl, new C0775(580, 0, 30, 25));
      this.Sk.setFont(new Font("Arial", 1, 12));
      this.Sk.setForeground(new Color(239, 239, 239));
      this.Sk.setHorizontalAlignment(0);
      this.Sk.setText("GC");
      this.Sk.setToolTipText("");
      this.vd.add(this.Sk, new C0775(620, 0, 30, 25));
      this.add(this.vd, new C0775(0, 0, -1, -1));
   }

   private void vy() {
      this.wm = new JLabel();
      this.Si = new JLabel();
      this.yE = new JLabel();
      this.So = new JLabel();
      this.Sj = new JLabel();
      this.Sk = new JLabel();
      this.Sl = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(670, 25));
      this.setLayout(new C0807());
      this.wm.setFont(new Font("Arial", 1, 12));
      this.wm.setHorizontalAlignment(4);
      this.wm.setText("Total:");
      this.add(this.wm, new C0775(250, 0, 180, 25));
      this.Si.setFont(new Font("Arial", 1, 12));
      this.Si.setHorizontalAlignment(0);
      this.Si.setText("100");
      this.Si.setToolTipText("");
      this.add(this.Si, new C0775(550, 0, 30, 25));
      this.yE.setFont(new Font("Arial", 1, 12));
      this.yE.setHorizontalAlignment(0);
      this.yE.setText("100");
      this.yE.setToolTipText("");
      this.add(this.yE, new C0775(450, 0, 30, 25));
      this.So.setFont(new Font("Arial", 1, 12));
      this.So.setHorizontalAlignment(0);
      this.So.setText("100");
      this.So.setToolTipText("");
      this.add(this.So, new C0775(490, 0, 30, 25));
      this.Sj.setFont(new Font("Arial", 1, 12));
      this.Sj.setHorizontalAlignment(0);
      this.Sj.setText("100");
      this.Sj.setToolTipText("");
      this.add(this.Sj, new C0775(520, 0, 30, 25));
      this.Sk.setBackground(new Color(233, 239, 240));
      this.Sk.setFont(new Font("Arial", 1, 12));
      this.Sk.setHorizontalAlignment(0);
      this.Sk.setText("100");
      this.Sk.setToolTipText("");
      this.Sk.setOpaque(true);
      this.add(this.Sk, new C0775(620, 0, 30, 25));
      this.Sl.setBackground(new Color(239, 231, 227));
      this.Sl.setFont(new Font("Arial", 1, 12));
      this.Sl.setHorizontalAlignment(0);
      this.Sl.setText("100");
      this.Sl.setToolTipText("");
      this.Sl.setOpaque(true);
      this.add(this.Sl, new C0775(580, 0, 30, 25));
   }
}
