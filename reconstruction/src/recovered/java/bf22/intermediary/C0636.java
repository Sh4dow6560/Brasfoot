package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0636 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0790 var7 = (C0790)object;
      if (var7 != null && var7.dX(j) != null) {
         this.setText(
            "<html>\n<body><p style=\\\"vertical-align: bottom; padding:5; font-size:10\\\"><center><img src=\"file:"
               + var7.dY(j)
               + "\" >"
               + "<center>"
               + var7.dX(j)
               + " ["
               + Integer.toString(var7.dZ(j))
               + "]"
               + "</center>"
               + "<br><center>"
               + "\n</p>\n</body></html>\n"
         );
      }

      return this;
   }
}
