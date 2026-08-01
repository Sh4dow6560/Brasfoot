package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0680 {
   Club gD = null;
   Player gE = null;

   public C0680() {
      this.ix();
      if (this.gE != null) {
         this.iy();
      }
   }

   private void ix() {
      ArrayList var1 = new ArrayList();
      var1.addAll(C0745.SR.P());
      Collections.shuffle(var1);

      for (int var2 = 0; var2 < var1.size(); var2++) {
         if (!((Club)var1.get(var2)).jZ() && ((Club)var1.get(var2)).kw() >= 21) {
            Player var3 = ((Club)var1.get(var2)).kv();
            if (var3 != null) {
               this.gE = var3;
               break;
            }
         }
      }
   }

   private void iy() {
      C0730 var1 = new C0730(this.gE, this.gE.fk(), true, false, 0);
      var1.a(false, false);
      this.gD = var1.cK();
   }

   public Club iz() {
      return this.gD;
   }

   public Player iA() {
      return this.gE;
   }
}
