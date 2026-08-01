package bf22.intermediary;

import java.util.ArrayList;
import mod.recovered.model.Club;

public class C0797 {
   private ArrayList cE = new ArrayList();

   public boolean em(int i) {
      for (int var2 = 0; var2 < this.cE.size(); var2++) {
         if (((Club)this.cE.get(var2)).getPais() == i) {
            return true;
         }
      }

      return false;
   }

   public void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
      this.a(arrayList, 0);
      this.a(arrayList2, this.ab(arrayList2));
      this.a(arrayList3, this.ab(arrayList3));
      this.a(arrayList4, this.ab(arrayList4));
   }

   public void e(ArrayList arrayList, ArrayList arrayList2) {
      this.a(arrayList, 0);
      this.a(arrayList2, this.ab(arrayList2));
   }

   public void f(ArrayList arrayList, ArrayList arrayList2) {
      this.a(arrayList, 0);
      this.a(arrayList2, 0);
   }

   public int ab(ArrayList arrayList) {
      for (int var2 = 0; var2 < arrayList.size(); var2++) {
         if (!this.em(((Club)arrayList.get(var2)).getPais())) {
            return var2;
         }
      }

      return 0;
   }

   public void a(C0797[] c0797s) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var5 = 0; var5 < c0797s.length; var5++) {
         for (int var6 = 0; var6 < c0797s[var5].cZ().size(); var6++) {
            boolean var4 = false;

            for (int var7 = 0; var7 < c0797s[var5].cZ().size(); var7++) {
               if (c0797s[var5].cZ().get(var6) != c0797s[var5].cZ().get(var7)
                  && ((Club)c0797s[var5].cZ().get(var6)).getPais() == ((Club)c0797s[var5].cZ().get(var7)).getPais()) {
                  var2.add(var5);
                  var3.add(var6);
                  var4 = true;
                  break;
               }
            }

            if (var4) {
               break;
            }
         }
      }

      if (var2.size() > 0 && var2.size() == var3.size()) {
         for (int var8 = 0; var8 < var2.size(); var8++) {
            this.a(c0797s, (Integer)var2.get(var8), (Integer)var3.get(var8));
         }
      }
   }

   private void a(C0797[] c0797s, int i, int j) {
      int var4 = ((Club)c0797s[i].cZ().get(j)).getPais();

      for (int var5 = 0; var5 < c0797s.length; var5++) {
         if (c0797s[i] != c0797s[var5] && !c0797s[var5].em(var4) && !c0797s[i].em(((Club)c0797s[var5].cZ().get(j)).getPais())) {
            this.a(c0797s[i], c0797s[var5], j);
            break;
         }
      }
   }

   private void a(C0797 c0797, C0797 c07972, int i) {
      Club var4 = (Club)c0797.cZ().get(i);
      Club var5 = (Club)c07972.cZ().get(i);
      c0797.e(var5, i);
      c07972.e(var4, i);
   }

   private void e(Club club, int i) {
      this.cE.set(i, club);
   }

   private void a(ArrayList arrayList, int i) {
      this.cE.add((Club)arrayList.get(i));
      arrayList.remove(i);
   }

   public ArrayList cZ() {
      return this.cE;
   }
}
