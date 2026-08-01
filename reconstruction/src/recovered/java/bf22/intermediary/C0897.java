package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mod.recovered.model.Player;

class C0897 implements ActionListener {
   final bf22.intermediary.C0893 Ut;
   C0897(C0893 c0893) {
      this.Ut = c0893;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0893.d(this.Ut).removeAllItems();
      C0893.e(this.Ut).removeAllItems();
      int[] var2 = Player.at(C0893.f(this.Ut).getSelectedIndex());
      C0893.eH(C0893.f(this.Ut).getSelectedIndex());
      if (C0893.f(this.Ut).getSelectedIndex() == 0) {
         for (int var3 = 0; var3 <= 3; var3++) {
            C0893.d(this.Ut).addItem(C0710.qM[var3]);
            C0893.e(this.Ut).addItem(C0710.qM[var3]);
         }

         C0893.d(this.Ut).setSelectedIndex(var2[0]);
         C0893.e(this.Ut).setSelectedIndex(var2[1]);
      } else {
         for (int var4 = 4; var4 < C0710.qM.length; var4++) {
            C0893.d(this.Ut).addItem(C0710.qM[var4]);
            C0893.e(this.Ut).addItem(C0710.qM[var4]);
         }

         C0893.d(this.Ut).setSelectedIndex(var2[0] - 4);
         C0893.e(this.Ut).setSelectedIndex(var2[1] - 4);
      }
   }
}
