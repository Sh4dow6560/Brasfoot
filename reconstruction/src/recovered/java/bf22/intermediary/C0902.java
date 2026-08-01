package bf22.intermediary;

import java.util.Comparator;

class C0902 implements Comparator<Integer> {
   final bf22.intermediary.C0901 Vh;
   C0902(C0901 c0901) {
      this.Vh = c0901;
   }

   public int compare(Integer integer, Integer integer2) {
      return integer != integer2 ? integer2 - integer : 0;
   }
}
