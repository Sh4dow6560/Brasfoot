package bf22.intermediary;

class C0965 implements C0968 {
   private double Wa = 0.0;
   private double Wb = 0.0;

   @Override
   public double m(double d) {
      double var3 = -d + (this.Wa - 1.0) * Math.log(d) - this.Wb;
      return Math.exp(var3);
   }

   public void n(double d) {
      this.Wa = d;
   }

   public void o(double d) {
      this.Wb = d;
   }
}
