package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0804 extends JPanel {
   private JLabel uF;

   public C0804(String string) {
      this.mJ();
      this.uF.setText(string);
      if (GamePersistence.vM().getCorTema() == 2) {
         this.uF.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
      }
   }

   private void mJ() {
      this.uF = new JLabel();
      this.setBackground(new Color(0, 0, 0));
      this.setPreferredSize(new Dimension(470, 25));
      this.setLayout(new C0807());
      this.uF.setBackground(new Color(0, 0, 0));
      this.uF.setFont(new Font("Arial", 1, 12));
      this.uF.setForeground(new Color(239, 239, 239));
      this.uF.setHorizontalAlignment(0);
      this.uF.setText("Grupo A");
      this.uF.setOpaque(true);
      this.add(this.uF, new C0775(0, 0, 470, 25));
   }
}
