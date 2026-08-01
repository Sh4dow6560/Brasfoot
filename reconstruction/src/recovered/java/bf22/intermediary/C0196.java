package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mod.recovered.model.Club;

public class C0196 extends JPanel {
   private JDialog ub = null;
   private Competition aeJ = null;
   private JLabel ug;
   private JLabel uh;
   private JLabel zM;
   private JLabel Sx;
   private JLabel Fs;
   private JLabel uu;
   private JLabel Ow;

   public C0196(JDialog jDialog, Club club, Competition c0713, int i) {
      this.ub = jDialog;
      this.aeJ = c0713;
      this.mJ();
      this.mH();
      this.uu.setText(club.getNome());
      this.uu.setIcon(club.kU());
      if (club.ka() != null) {
         this.Fs.setText(club.ka().dS());
      }

      this.Sx.setText(c0713.getNome());
      this.nq();
   }

   private void nq() {
      String[] var1 = this.aeJ.mA();
      ImageIcon var2 = GameConstants.a(GameConstants.x(var1[0]), 60, 82);
      this.Ow.setIcon(var2);
   }

   public void mH() {
      this.uh.addMouseListener(new C0394(this));
   }

   private void mJ() {
      this.uh = new JLabel();
      this.ug = new JLabel();
      this.uu = new JLabel();
      this.Sx = new JLabel();
      this.Ow = new JLabel();
      this.Fs = new JLabel();
      this.zM = new JLabel();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setLayout(new C0807());
      this.uh.setBackground(new Color(51, 51, 51));
      this.uh.setFont(new Font("Tahoma", 1, 12));
      this.uh.setForeground(new Color(255, 255, 204));
      this.uh.setHorizontalAlignment(0);
      this.uh.setText("X");
      this.uh.setOpaque(true);
      this.add(this.uh, new C0775(250, 30, 40, 40));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("É campeão!");
      this.add(this.ug, new C0775(611, 21, 375, -1));
      this.uu.setFont(new Font("Tahoma", 0, 12));
      this.uu.setForeground(new Color(255, 255, 255));
      this.uu.setHorizontalAlignment(0);
      this.uu.setText("Nome:");
      this.add(this.uu, new C0775(40, 140, 221, -1));
      this.Sx.setFont(new Font("Tahoma", 0, 14));
      this.Sx.setForeground(new Color(255, 255, 255));
      this.Sx.setHorizontalAlignment(0);
      this.Sx.setText("Nacionalidade:");
      this.add(this.Sx, new C0775(20, 90, 260, -1));
      this.Ow.setForeground(new Color(255, 255, 255));
      this.Ow.setHorizontalAlignment(0);
      this.Ow.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.Ow.setToolTipText("");
      this.Ow.setVerticalAlignment(3);
      this.Ow.setMaximumSize(new Dimension(50, 82));
      this.Ow.setMinimumSize(new Dimension(50, 82));
      this.Ow.setName("");
      this.Ow.setPreferredSize(new Dimension(50, 82));
      this.Ow.setRequestFocusEnabled(false);
      this.add(this.Ow, new C0775(130, 210, -1, 100));
      this.Fs.setFont(new Font("Tahoma", 0, 12));
      this.Fs.setForeground(new Color(255, 255, 255));
      this.Fs.setHorizontalAlignment(0);
      this.Fs.setText("Nome:");
      this.add(this.Fs, new C0775(40, 170, 221, -1));
      this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campeao.png")));
      this.zM.setMaximumSize(new Dimension(306, 413));
      this.zM.setMinimumSize(new Dimension(306, 413));
      this.add(this.zM, new C0775(0, 0, 310, 410));
   }
}
