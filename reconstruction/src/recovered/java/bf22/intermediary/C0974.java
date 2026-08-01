package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mod.recovered.model.Club;

class C0974 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0974(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      Club var2 = (Club)((C0924)((C0692)C0745.SR.N().get(0)).eb().get(0)).yi().yK().get(0);
      var2.k(true);
      var2.ka().k(true);
      C0745.SR.M().add(var2.ka());
      C0745.SR.aN().add(var2);
      C0971.a(this.Xb, var2);
   }
}
