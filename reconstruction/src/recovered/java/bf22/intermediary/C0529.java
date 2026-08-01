package bf22.intermediary;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class C0529 implements DocumentListener {
   final bf22.intermediary.C0526 No;
   C0529(C0526 c0526) {
      this.No = c0526;
   }

   @Override
   public void changedUpdate(DocumentEvent documentEvent) {
      C0526.a(this.No);
   }

   @Override
   public void insertUpdate(DocumentEvent documentEvent) {
      C0526.a(this.No);
   }

   @Override
   public void removeUpdate(DocumentEvent documentEvent) {
      C0526.a(this.No);
   }
}
