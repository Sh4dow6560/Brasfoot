package bf22.intermediary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mod.recovered.model.Club;

public class C0108 extends JPanel {
   private JDialog ub;
   private Club zu;
   private JButton ud;
   private JButton zn;
   private JLabel ug;
   private JLabel uh;
   private JLabel vx;
   private JLabel zv;
   private JLabel zw;
   private JLabel zx;

   public C0108(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.zu = club;
      this.mJ();
      this.zx.setText(club.getNome());
      this.zw.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      this.zv.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      this.zw.setBackground(club.kC());
      this.zv.setBackground(club.kB());
      this.nI();
      this.mH();
   }

   private void nI() {
      this.zx.setForeground(this.zw.getBackground());
      this.zx.setBackground(this.zv.getBackground());
   }

   private void a(Object object) {
      JLabel var2 = (JLabel)object;
      Color var3 = var2.getBackground();
      Color var4 = this.getBackground();
      Color var5 = JColorChooser.showDialog(var2, "", var3);
      if (!var4.equals(var5)) {
         var2.setBackground(var5);
         this.nI();
      }
   }

   public void mH() {
      this.zn.addActionListener(new C0109(this));
      this.ud.addActionListener(new C0110(this));
      this.zw.addMouseListener(new C0111(this));
      this.zv.addMouseListener(new C0112(this));
   }

   private void nH() {
      this.zu.d(this.zw.getBackground());
      this.zu.c(this.zv.getBackground());
   }

   private void mJ() {
      this.zn = new JButton();
      this.ug = new JLabel();
      this.zw = new JLabel();
      this.zv = new JLabel();
      this.uh = new JLabel();
      this.ud = new JButton();
      this.vx = new JLabel();
      this.zx = new JLabel();
      this.setBackground(new Color(241, 241, 227));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setLayout(new C0807());
      this.zn.setText("salvar");
      this.add(this.zn, new C0775(30, 250, 108, 30));
      this.ug.setFont(new Font("Tahoma", 0, 14));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Cores do Time");
      this.add(this.ug, new C0775(30, 20, 250, -1));
      this.zw.setBackground(new Color(255, 0, 102));
      this.zw.setMinimumSize(new Dimension(20, 20));
      this.zw.setCursor(new Cursor(12));
      this.zw.setOpaque(true);
      this.zw.setPreferredSize(new Dimension(20, 20));
      this.add(this.zw, new C0775(70, 80, 69, 61));
      this.zv.setBackground(new Color(255, 0, 102));
      this.zv.setMinimumSize(new Dimension(20, 20));
      this.zv.setCursor(new Cursor(12));
      this.zv.setOpaque(true);
      this.zv.setPreferredSize(new Dimension(20, 20));
      this.add(this.zv, new C0775(170, 80, 69, 60));
      this.uh.setText("Cor de Fundo:");
      this.add(this.uh, new C0775(170, 60, -1, -1));
      this.ud.setText("cancelar");
      this.add(this.ud, new C0775(160, 250, 108, 30));
      this.vx.setText("Cor de Texto:");
      this.add(this.vx, new C0775(70, 60, -1, -1));
      this.zx.setBackground(new Color(255, 0, 102));
      this.zx.setFont(new Font("Arial", 0, 12));
      this.zx.setHorizontalAlignment(0);
      this.zx.setText("");
      this.zx.setMinimumSize(new Dimension(20, 20));
      this.zx.setOpaque(true);
      this.zx.setPreferredSize(new Dimension(20, 20));
      this.add(this.zx, new C0775(30, 160, 240, 60));
   }
}
