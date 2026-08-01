package bf22.intermediary;

import mod.recovered.geo.CountryInfo;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0037 extends JLabel implements ListCellRenderer {
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

      if (object != null) {
         String var7 = "";
         ImageIcon var8 = null;
         if (object.equals("Internacional")) {
            var7 = "Internacional";
            var8 = new ImageIcon(this.getClass().getResource("/aicons/worldflag.png"));
         } else if (!object.equals("Qualquer")) {
            var8 = ((CountryInfo)C0732.cY().get(C0732.h(var6))).jD();
            var7 = ((CountryInfo)C0732.cY().get(C0732.h(var6))).getNome();
         } else {
            var7 = "Qualquer";
         }

         this.setIcon(var8);
         this.setText(var7);
      }

      return this;
   }
}
