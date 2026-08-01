package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class C0342 implements ActionListener {
   final bf22.intermediary.C0341 IB;
   C0342(C0341 c0341) {
      this.IB = c0341;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      try {
         if (false) {
            throw new IOException();
         }
         C0341.a(this.IB);
      } catch (IOException var3) {
         var3.printStackTrace();
      }
   }
}
