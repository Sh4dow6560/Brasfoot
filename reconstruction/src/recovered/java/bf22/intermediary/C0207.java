package bf22.intermediary;

import javax.swing.JTable;

class C0207 extends JTable {
   final bf22.intermediary.C0200 GR;
   C0207(C0200 c0200) {
      this.GR = c0200;
   }

   @Override
   public boolean isCellEditable(int i, int j) {
      return false;
   }
}
