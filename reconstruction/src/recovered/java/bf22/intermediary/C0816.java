package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class C0816 extends JPanel {
   private JSeparator BE;
   private JSeparator BF;
   private JLabel Ot;
   private JLabel Ou;
   private JLabel Ov;
   private JLabel Ow;

   public C0816() {
      this.mJ();
      this.at(false);
   }

   private void at(boolean bl) {
      this.BE.setVisible(bl);
      this.BF.setVisible(bl);
      this.Ow.setVisible(bl);
      this.Ou.setVisible(bl);
      this.Ot.setVisible(bl);
      this.Ov.setVisible(bl);
   }

   public void a(String string, String string2, int i, ImageIcon imageIcon) {
      this.Ov.setText(string);
      this.Ow.setIcon(imageIcon);
      this.Ot.setText(string2);
      this.Ou.setText(Integer.toString(i));
      this.at(true);
      if (i < 100) {
         this.Ou.setFont(new Font("Tahoma", 1, 14));
      }
   }

   private void mJ() {
      this.Ou = new JLabel();
      this.Ow = new JLabel();
      this.Ov = new JLabel();
      this.BE = new JSeparator();
      this.BF = new JSeparator();
      this.Ot = new JLabel();
      this.setBackground(new Color(255, 255, 255));
      this.setPreferredSize(new Dimension(595, 110));
      this.setLayout(new C0807());
      this.Ou.setBackground(new Color(52, 78, 130));
      this.Ou.setFont(new Font("Tahoma", 0, 14));
      this.Ou.setForeground(new Color(255, 255, 255));
      this.Ou.setHorizontalAlignment(0);
      this.Ou.setText("199");
      this.Ou.setOpaque(true);
      this.add(this.Ou, new C0775(172, 145, 28, 20));
      this.Ow.setBackground(new Color(232, 236, 235));
      this.Ow.setHorizontalAlignment(0);
      this.Ow.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trgen.png")));
      this.add(this.Ow, new C0775(0, 40, 87, -1));
      this.Ov.setBackground(new Color(255, 255, 255));
      this.Ov.setFont(new Font("Tahoma", 1, 12));
      this.Ov.setForeground(new Color(36, 104, 43));
      this.Ov.setText("Brasileiro - 1ª divisão");
      this.add(this.Ov, new C0775(10, 10, 190, -1));
      this.add(this.BE, new C0775(0, 30, 200, -1));
      this.BF.setOrientation(1);
      this.BF.setPreferredSize(new Dimension(1, 0));
      this.add(this.BF, new C0775(90, 30, -1, 139));
      this.Ot.setHorizontalAlignment(2);
      this.Ot.setText("");
      this.Ot.setVerticalAlignment(1);
      this.add(this.Ot, new C0775(95, 35, 105, 130));
   }
}
