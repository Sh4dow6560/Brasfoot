package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0310 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0310(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.getOptions().setIgnoraLigas(C0294.n(this.JH).isSelected());
      GamePersistence.saveOptions();
   }
}
