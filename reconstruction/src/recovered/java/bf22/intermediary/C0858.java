package bf22.intermediary;

import mod.recovered.geo.CountryInfo;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0858 extends JLabel implements ListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      String var6 = (String)object;
      if (bl) {
         this.setBackground(jList.getSelectionBackground());
         this.setForeground(jList.getSelectionForeground());
      } else {
         this.setBackground(jList.getBackground());
         this.setForeground(jList.getForeground());
      }

      ImageIcon var7 = ((CountryInfo)C0732.cY().get(C0732.h(var6))).jD();
      String var8 = ((CountryInfo)C0732.cY().get(C0732.h(var6))).getNome();
      this.setIcon(var7);
      this.setText(var8);
      return this;
   }
}
