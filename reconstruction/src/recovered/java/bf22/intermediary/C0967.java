package bf22.intermediary;

class C0967 implements C0985 {
   public double Ws = 0.0;
   public double Wt = 0.0;
   public double Wu = 0.0;
   public double Wv = 0.0;

   @Override
   public double m(double d) {
      return this.Wv - C0987.a(this.Ws, this.Wt, this.Wu, d);
   }
}
