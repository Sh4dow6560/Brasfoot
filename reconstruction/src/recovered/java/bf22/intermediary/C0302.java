package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0302 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0302(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.vM().setVerLeiloes(C0294.f(this.JH).isSelected());
      GamePersistence.vJ();
   }
}
