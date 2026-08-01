package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

class C0084 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0084(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      new ImageIcon(this.getClass().getResource("/aicons/alpha3.png"));
      C0132.b(this.Bq, true);
      C0132.i(this.Bq).dispose();
   }
}
