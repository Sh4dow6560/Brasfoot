package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0876 implements ActionListener {
   final bf22.intermediary.C0871 VN;
   C0876(C0871 c0871) {
      this.VN = c0871;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0871.b(this.VN).getSelectedRow() >= 0) {
         if (C0871.d(this.VN).getJogadores().size() >= 30) {
            C0871.c(this.VN).setText("O time de destino não tem vaga");
         } else {
            if (C0732.da().wL() != null && C0732.da().wK() && C0732.da().wI() != C0871.d(this.VN)) {
               C0871.d(this.VN).getJogadores().add(C0732.da().wL());
               C0732.da().wI().getJogadores().remove(C0732.da().wL());
            } else {
               C0871.c(this.VN).setText("Não foi possível transferir");
            }

            C0732.da().a((C0914)null);
            C0732.da().wJ().setRowSelectionInterval(0, 0);
            C0732.da().wJ().addNotify();
            C0732.da().Uw.dispose();
            C0732.da().c(C0871.d(this.VN));
         }
      }
   }
}
