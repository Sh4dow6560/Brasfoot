package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0304 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0304(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.vM().setUsaCorPlacar(C0294.h(this.JH).isSelected());
      GamePersistence.vJ();
   }
}
