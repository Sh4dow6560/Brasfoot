package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0418 implements ActionListener {
   final bf22.intermediary.C0404 Ma;
   C0418(C0404 c0404) {
      this.Ma = c0404;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0404.b(this.Ma) != null) {
         C0404.d(this.Ma);
      }
   }
}
