package bf22.intermediary;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class C0192 implements DocumentListener {
   final bf22.intermediary.C0238 Gn;
   C0192(C0238 c0238) {
      this.Gn = c0238;
   }

   @Override
   public void changedUpdate(DocumentEvent documentEvent) {
      C0238.e(this.Gn);
   }

   @Override
   public void insertUpdate(DocumentEvent documentEvent) {
      C0238.e(this.Gn);
   }

   @Override
   public void removeUpdate(DocumentEvent documentEvent) {
      C0238.e(this.Gn);
   }
}
