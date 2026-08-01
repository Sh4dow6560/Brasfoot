package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import mod.recovered.model.Club;

public final class C0938 {
   public static void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, boolean bl) {
      CountryCompetitions var4 = null;

      for (int var5 = 0; var5 < arrayList.size(); var5++) {
         var4 = (CountryCompetitions)GamePersistence.SR.aG().get(((C0793)arrayList.get(var5)).uW());
         if (((C0793)arrayList.get(var5)).uY()) {
            bl = true;
         }

         var4.a(((C0793)arrayList.get(var5)).uX(), arrayList2, arrayList3, bl);
      }
   }

   public static void a(ArrayList arrayList, ArrayList arrayList2, int i, ArrayList arrayList3) {
      if (arrayList.size() < i) {
         ArrayList var4 = new ArrayList();

         for (int var5 = 0; var5 < arrayList2.size() && arrayList.size() < i; var5++) {
            var4.clear();
            var4.add(new C0793("mesmo pais", ((C0793)arrayList2.get(var5)).uW(), 1));
            a(var4, arrayList, arrayList3, false);
         }
      }
   }

   public static void a(int i, int j, ArrayList arrayList, ArrayList arrayList2, int k, C0792 c0792) {
      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      boolean var9 = false;

      for (int var10 = 0; var10 < arrayList.size(); var10++) {
         if (((C0793)arrayList.get(var10)).uW() == k) {
            var6 += ((C0793)arrayList.get(var10)).uX();
            if (((C0793)arrayList.get(var10)).uY()) {
               var8 = true;
            }
         }
      }

      if (arrayList2 != null) {
         for (int var12 = 0; var12 < arrayList2.size(); var12++) {
            if (((C0793)arrayList2.get(var12)).uW() == k) {
               var7 += ((C0793)arrayList2.get(var12)).uX();
               if (((C0793)arrayList2.get(var12)).uY()) {
                  var9 = true;
               }
            }
         }
      }

      if (i == 1 && j == 1) {
         Club var13 = GamePersistence.SR.aF().cS();
         Club var11 = GamePersistence.SR.aH().cS();
         if (var13 != null && var13 == var11 && k == var13.getPais()) {
            var6++;
         }
      }

      if (var8) {
         var6--;
      }

      if (var9) {
         var7--;
      }

      if (j == 1) {
         c0792.ea(var6);
         c0792.eb(var7);
         if (var8) {
            c0792.ee(1);
         }

         if (var9) {
            c0792.ef(1);
         }
      } else if (j == 2) {
         c0792.ec(var6);
         c0792.ed(var7);
         if (var8) {
            c0792.eg(1);
         }

         if (var9) {
            c0792.eh(1);
         }
      } else if (j == 3) {
         c0792.fA(var6);
         c0792.fB(var7);
         if (var8) {
            c0792.fC(1);
         }

         if (var9) {
            c0792.fD(1);
         }
      }
   }
}
