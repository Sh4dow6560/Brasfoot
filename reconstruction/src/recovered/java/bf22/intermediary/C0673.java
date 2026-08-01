package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class C0673 implements Serializable {
   private static final long serialVersionUID = 1L;
   private ArrayList fs = new ArrayList();

   public ArrayList gR() {
      return this.fs;
   }

   public void E(ArrayList arrayList) {
      this.fs = arrayList;
   }

   public void dv(int i) {
      for (int var2 = 0; var2 < this.fs.size(); var2++) {
         System.out.println(i + " " + ((Club)this.fs.get(var2)).getNome());
      }
   }
}
