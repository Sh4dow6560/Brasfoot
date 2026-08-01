package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0305 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0305(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.getOptions().setUsaSons(C0294.i(this.JH).isSelected());
      GamePersistence.saveOptions();
   }
}
