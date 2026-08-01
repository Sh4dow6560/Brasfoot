package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0627 extends JLabel implements ListCellRenderer {
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

      if (object != null) {
         C0830 var6 = (C0830)object;
         String var7 = var6.tZ();
         this.setText(var7);
      }

      return this;
   }
}
