package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0339 extends AbstractAction {
   final bf22.intermediary.C0272 Iz;
   C0339(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0745.SR.isHabilidadeIndividual()) {
         C0272.a(this.Iz, 2);
      } else {
         C0272.a(this.Iz, 1);
      }
   }
}
