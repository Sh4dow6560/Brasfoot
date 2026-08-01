package bf22.intermediary;

import java.io.Serializable;
import java.util.Calendar;
import mod.recovered.model.Stadium;

public class C0668 implements Serializable {
   private static final long serialVersionUID = 1L;
   private Stadium dH = null;
   private Calendar dI = null;
   private int[] dJ = new int[4];

   public Stadium ev() {
      return this.dH;
   }

   public void a(Stadium stadium) {
      this.dH = stadium;
   }

   public Calendar ew() {
      return this.dI;
   }

   public void c(Calendar calendar) {
      this.dI = calendar;
   }

   public void ex() {
      for (int var1 = 0; var1 < this.dJ.length; var1++) {
         if (this.dJ[var1] > 0) {
            this.dH.f(var1, this.dJ[var1]);
            this.dJ[var1] = 0;
         }
      }
   }

   public void c(int[] is) {
      this.dJ = is;
   }
}
