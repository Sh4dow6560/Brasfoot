package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class C0320 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0320(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      try {
         if (false) {
            throw new IOException();
         }
         this.Iz.ru();
      } catch (IOException var3) {
         var3.printStackTrace();
      }
   }
}
