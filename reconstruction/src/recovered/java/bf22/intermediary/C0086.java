package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

class C0086 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0086(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      new ImageIcon(this.getClass().getResource("/aicons/alpha2.png"));
      this.Bq.oj();
   }
}
