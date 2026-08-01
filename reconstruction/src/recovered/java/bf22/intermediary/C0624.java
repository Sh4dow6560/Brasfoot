package bf22.intermediary;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0624 extends JLabel implements ListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      if (object != null && object instanceof C0713) {
         C0713 var6 = (C0713)object;
         String var7 = var6.getNome();
         this.setText(var7);
         if (bl) {
            this.setBackground(jList.getSelectionBackground());
            this.setForeground(jList.getSelectionForeground());
         } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
         }
      } else {
         this.setText((String)object);
      }

      return this;
   }
}
