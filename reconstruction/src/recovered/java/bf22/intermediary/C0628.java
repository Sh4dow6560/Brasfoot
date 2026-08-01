package bf22.intermediary;

import mod.recovered.competition.NationalSuperCup;
import mod.recovered.competition.Competition;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0628 extends JLabel implements ListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      this.setIcon(null);
      if (bl) {
         this.setBackground(Color.YELLOW);
         this.setForeground(jList.getSelectionForeground());
      } else {
         this.setBackground(jList.getBackground());
         this.setForeground(jList.getForeground());
      }

      if (object != null && object instanceof NationalSuperCup) {
         NationalSuperCup var8 = (NationalSuperCup)object;
         String var9 = var8.getNome();
         this.setText(var9);
         this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + var8.getPais() + ".png")));
      } else if (object != null) {
         Competition var6 = (Competition)object;
         String var7 = var6.getNome();
         this.setText(var7);
         this.setIcon(var6.es());
      }

      return this;
   }
}
