package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

class C0849 implements ActionListener {
   final bf22.intermediary.C0901 Vh;
   C0849(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0901.b(this.Vh).setIcon(new ImageIcon(this.getClass().getResource("/aicons/greencheck.png")));
      C0901.c(this.Vh).setIcon(null);
      C0901.d(this.Vh).setText("");
      if (!C0901.e(this.Vh)) {
         C0901.a(this.Vh, true);
         C0878 var2 = new C0878();
         C0732.da().wJ().setModel(var2);
         C0732.da().wH();
         if (C0901.f(this.Vh).getJogadores().size() > 0) {
            C0732.da().wJ().setRowSelectionInterval(0, 0);
         }

         this.Vh.wq();
         C0901.g(this.Vh).addNotify();
      }
   }
}
