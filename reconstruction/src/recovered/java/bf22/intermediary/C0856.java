package bf22.intermediary;

import java.util.Comparator;

class C0856 implements Comparator<Integer> {
   final bf22.intermediary.C0855 Vm;
   C0856(C0855 c0855) {
      this.Vm = c0855;
   }

   public int compare(Integer integer, Integer integer2) {
      return integer != integer2 ? integer2 - integer : 0;
   }
}
