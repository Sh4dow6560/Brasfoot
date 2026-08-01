package bf22.intermediary;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class C0136 implements DocumentListener {
   final bf22.intermediary.C0185 Da;
   C0136(C0185 c0185) {
      this.Da = c0185;
   }

   @Override
   public void changedUpdate(DocumentEvent documentEvent) {
      C0185.c(this.Da);
   }

   @Override
   public void insertUpdate(DocumentEvent documentEvent) {
      C0185.c(this.Da);
   }

   @Override
   public void removeUpdate(DocumentEvent documentEvent) {
      C0185.c(this.Da);
   }
}
