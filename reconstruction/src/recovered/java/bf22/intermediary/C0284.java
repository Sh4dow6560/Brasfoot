package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;

class C0284 extends AbstractAction {
   final bf22.intermediary.C0272 Iz;
   C0284(C0272 c0272) {
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
      }
   }
}
