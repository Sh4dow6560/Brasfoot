package bf22.intermediary;

import javax.swing.JSlider;

public class C0781 extends JSlider {
   public C0781() {
      this.uu();
   }

   public C0781(int i, int j) {
      super(i, j);
      this.uu();
   }

   private void uu() {
      this.setOrientation(0);
   }

   @Override
   public void updateUI() {
      this.setUI(new C0766(this));
      this.updateLabelUIs();
   }

   @Override
   public int getValue() {
      return super.getValue();
   }

   @Override
   public void setValue(int i) {
      int var2 = this.getValue();
      if (var2 != i) {
         int var3 = this.getExtent();
         int var4 = Math.min(Math.max(this.getMinimum(), i), var2 + var3);
         int var5 = var3 + var2 - var4;
         this.getModel().setRangeProperties(var4, var5, this.getMinimum(), this.getMaximum(), this.getValueIsAdjusting());
      }
   }

   public int uv() {
      return this.getValue() + this.getExtent();
   }

   public void dP(int i) {
      int var2 = this.getValue();
      int var3 = Math.min(Math.max(0, i - var2), this.getMaximum() - var2);
      this.setExtent(var3);
   }
}
