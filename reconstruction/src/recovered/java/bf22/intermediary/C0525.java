package bf22.intermediary;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class C0525 implements DocumentListener {
   final bf22.intermediary.C0475 Nj;
   C0525(C0475 c0475) {
      this.Nj = c0475;
   }

   @Override
   public void changedUpdate(DocumentEvent documentEvent) {
      C0475.d(this.Nj);
   }

   @Override
   public void insertUpdate(DocumentEvent documentEvent) {
      C0475.d(this.Nj);
   }

   @Override
   public void removeUpdate(DocumentEvent documentEvent) {
      C0475.d(this.Nj);
   }
}
