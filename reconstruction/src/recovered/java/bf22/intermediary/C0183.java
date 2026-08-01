package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0183 implements ActionListener {
   final bf22.intermediary.C0182 CX;
   C0183(C0182 c0182) {
      this.CX = c0182;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.SR.setUsaGrupoPadraoEstadual(C0182.a(this.CX).isSelected());
      GamePersistence.vM().setUsaGrupoPadraoEstadual(C0182.a(this.CX).isSelected());
      GamePersistence.vJ();
   }
}
