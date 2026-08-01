package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0307 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0307(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.getOptions().setNegritoCasa(C0294.j(this.JH).isSelected());
      GamePersistence.saveOptions();
   }
}
