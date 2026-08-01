package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0643 extends JLabel implements ListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      if (bl) {
         this.setBackground(jList.getSelectionBackground());
         this.setForeground(jList.getSelectionForeground());
      }

      int var6 = (Integer)object;
      this.setText(GameConstants.rX[var6]);
      ImageIcon var7 = new ImageIcon(this.getClass().getResource("/aesticons/" + Integer.toString(var6) + ".png"));
      this.setIcon(var7);
      return this;
   }
}
