package bf22.intermediary;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import mod.recovered.model.Club;

public class C0038 extends JLabel implements ListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      if (object != null && object instanceof Club) {
         Club var6 = (Club)object;
         String var7 = var6.getNome();
         if (bl) {
            this.setBackground(jList.getSelectionBackground());
            this.setForeground(jList.getSelectionForeground());
         } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
         }

         this.setIcon(var6.kU());
         this.setText(var7);
      }

      return this;
   }
}
