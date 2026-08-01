package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0544 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0544(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.getOptions().setIgnoraEstadual(C0294.o(this.JH).isSelected());
      GamePersistence.saveOptions();
   }
}
