package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0942 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0692 KR;
   private C0962 YI = null;
   private int nTimes = -1;
   private ArrayList afU = new ArrayList();

   public C0942() {
   }

   public C0942(C0692 c0692) {
      this.KR = c0692;
      this.F(2, c0692.gg());
      this.setNome("Copa " + C0697.bq(c0692.jc()) + " " + c0692.jf());
      this.nTimes = this.nTimes;
   }

   public void a(C0942 c0942, ArrayList arrayList, boolean[] bls) {
      int var4 = arrayList.size();
      if (var4 >= 8) {
         short var5 = 0;
         ArrayList var6 = new ArrayList();
         ArrayList var7 = new ArrayList();
         ArrayList var8 = new ArrayList();
         if (var4 >= 128) {
            var5 = 128;
         } else if (var4 >= 64) {
            var5 = 64;
         } else if (var4 >= 32) {
            var5 = 32;
         } else if (var4 >= 16) {
            var5 = 16;
         } else if (var4 >= 8) {
            var5 = 8;
         }

         this.nTimes = var5;

         for (int var9 = 0; var9 < var5 / 2; var9++) {
            var7.add((Club)arrayList.get(var9));
            var8.add((Club)arrayList.get(var5 / 2 + var9));
         }

         Collections.shuffle(var7);
         Collections.shuffle(var8);

         for (int var11 = 0; var11 < var7.size(); var11++) {
            var6.add((Club)var8.get(var11));
            var6.add((Club)var7.get(var11));
         }

         C0962 var12 = new C0962(null, var6.size(), 2, 0, bls, c0942, -1);
         this.b(var12);
         C0929 var10 = new C0929();
         var10.a(var12, var6, 0, true, 0, 0, 2, false);
      }
   }

   public void b(C0942 c0942, ArrayList arrayList, boolean[] bls) {
      ArrayList var4 = new ArrayList();
      var4.addAll(arrayList);
      if (this.afU.size() < 12) {
         this.afU.clear();
         if (C0745.SR.isJogaIntClubes() && C0745.SR.aF() != null) {
            if (C0745.SR.aF().yy() != null) {
               for (int var5 = 0; var5 < C0745.SR.aF().yy().size(); var5++) {
                  if (((Club)C0745.SR.aF().yy().get(var5)).getPais() == 29) {
                     this.afU.add((Club)C0745.SR.aF().yy().get(var5));
                  }
               }
            }

            if (C0745.SR.aF().yB() != null) {
               for (int var13 = 0; var13 < C0745.SR.aF().yB().size(); var13++) {
                  if (((Club)C0745.SR.aF().yB().get(var13)).getPais() == 29) {
                     this.afU.add((Club)C0745.SR.aF().yB().get(var13));
                  }
               }
            }
         }

         for (int var14 = 0; var14 <= 12; var14++) {
            if (!this.afU.contains(var4.get(var14))) {
               this.afU.add((Club)var4.get(var14));
            }
         }

         this.Bg();
         this.Bf();
      } else {
         this.Bg();
         this.Bf();
      }

      if (this.afU.size() == 12) {
         for (int var15 = 0; var15 <= 11; var15++) {
            var4.remove(this.afU.get(var15));
         }

         this.Bh();
         ArrayList var16 = new ArrayList();
         C0806[] var6 = new C0806[8];
         int[] var7 = new int[]{10, 10, 10, 10, 10, 10, 10, 10};
         int var8 = 0;

         for (int var9 = 0; var9 < var6.length; var9++) {
            var6[var9] = new C0806();

            while (var7[var9] > 0) {
               if (!var6[var9].contains(var4.get(var8))) {
                  var6[var9].add((Club)var4.get(var8));
                  ((Club)var4.get(var8)).bW(var9);
                  var8++;
                  var7[var9]--;
               }
            }

            Collections.shuffle(var6[var9]);
         }

         boolean var17 = true;

         for (int var10 = 0; var10 < var6.length; var10++) {
            if (var6[var10] != null && var6[var10].size() != 10) {
               var17 = false;
               break;
            }
         }

         if (var17) {
            for (int var18 = 0; var18 < 10; var18++) {
               var16.add((Club)var6[4].get(var18));
               var16.add((Club)var6[0].get(var18));
               var16.add((Club)var6[7].get(var18));
               var16.add((Club)var6[3].get(var18));
               var16.add((Club)var6[5].get(var18));
               var16.add((Club)var6[1].get(var18));
               var16.add((Club)var6[6].get(var18));
               var16.add((Club)var6[2].get(var18));
            }

            boolean[] var19 = new boolean[]{false, false, true, true, true, true, true, true};
            C0962 var11 = new C0962(null, var16.size(), 2, 0, var19, c0942, 2029);
            this.b(var11);
            C0929 var12 = new C0929();
            var12.a(var11, var16, 0, false, 0, 0, 2, false);
            var12.fb(2129);
         } else {
            this.a(c0942, arrayList, bls);
         }
      } else {
         this.a(c0942, arrayList, bls);
      }
   }

   public void ad(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      Collections.sort(arrayList, C1007.abm);

      for (int var5 = 0; var5 <= 19; var5++) {
         var3.add((Club)arrayList.get(var5));
      }

      for (int var6 = 20; var6 <= 39; var6++) {
         var4.add((Club)arrayList.get(var6));
      }

      Collections.shuffle(var3);
      Collections.shuffle(var4);

      for (int var7 = 0; var7 < var3.size(); var7++) {
         var2.add((Club)var4.get(var7));
         var2.add((Club)var3.get(var7));
      }

      C0929 var8 = new C0929();
      var8.a(this.YI, var2, 1, false, 0, 0, 2, false);
      var8.fb(2229);
      this.YI.BH();
   }

   public void ao(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      var2.addAll(arrayList);
      var2.addAll(this.afU);
      if (var2.size() == 32) {
         Collections.sort(var2, C1007.abm);
         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();

         for (int var6 = 0; var6 <= 15; var6++) {
            var4.add((Club)var2.get(var6));
         }

         for (int var7 = 16; var7 <= 31; var7++) {
            var5.add((Club)var2.get(var7));
         }

         Collections.shuffle(var4);
         Collections.shuffle(var5);

         for (int var8 = 0; var8 < var4.size(); var8++) {
            var3.add((Club)var4.get(var8));
            var3.add((Club)var5.get(var8));
         }

         C0929 var9 = new C0929();
         var9.a(this.YI, var3, 2, true, 0, 0, 2, false);
         var9.fb(2329);
         this.YI.BH();
      }
   }

   public void as(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      C0929 var2 = new C0929();
      var2.a(this.YI, arrayList, 3, true, 0, 0, 2, false);
      var2.fb(2429);
      this.YI.BH();
   }

   public void at(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      C0929 var2 = new C0929();
      var2.a(this.YI, arrayList, 4, true, 0, 0, 2, false);
      var2.fb(2529);
      this.YI.BH();
   }

   public void au(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      C0929 var2 = new C0929();
      var2.a(this.YI, arrayList, 5, true, 0, 0, 2, false);
      var2.fb(2629);
      this.YI.BH();
   }

   public void av(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      C0929 var2 = new C0929();
      var2.a(this.YI, arrayList, 6, true, 0, 0, 2, false);
      var2.fb(2729);
      this.YI.BH();
   }

   private void Bf() {
      if (this.afU.size() > 12) {
         ArrayList var1 = new ArrayList();

         for (int var2 = 0; var2 <= 11; var2++) {
            var1.add((Club)this.afU.get(var2));
         }

         this.afU.clear();

         for (int var3 = 0; var3 <= 11; var3++) {
            this.afU.add((Club)var1.get(var3));
         }
      }
   }

   private void Bg() {
      if (C0745.SR.isJogaRegionais()) {
         Object var1 = null;
         Object var2 = null;
         if (C0745.SR.bV()[2] != null) {
            var1 = C0745.SR.bV()[2].cS();
            this.afU.remove(var1);
            this.afU.add(0, var1);
         }

         if (C0745.SR.bV()[3] != null) {
            var2 = C0745.SR.bV()[3].cS();
            this.afU.remove(var2);
            this.afU.add(0, var2);
         }
      }
   }

   public void Bh() {
      String var1 = "";
      if (this.afU.size() == 12) {
         for (int var2 = 0; var2 < this.afU.size(); var2++) {
            String var3 = ((Club)this.afU.get(var2)).getNome() + ", ";
            if (var2 == 10) {
               var3 = ((Club)this.afU.get(var2)).getNome();
            } else if (var2 == 11) {
               var3 = " e " + ((Club)this.afU.get(var2)).getNome() + ".";
            }

            var1 = var1 + var3;
         }

         for (int var4 = 0; var4 < C0745.SR.M().size(); var4++) {
            if (((Coach)C0745.SR.M().get(var4)).fg() != null && ((Coach)C0745.SR.M().get(var4)).fg().getPais() == 29) {
               new C0799((Coach)C0745.SR.M().get(var4), 23, 75, "", var1);
            }
         }
      }
   }

   public void Bi() {
      this.afU.clear();
   }

   public void W(Club club) {
      if (!this.afU.contains(club)) {
         this.afU.add(club);
      }
   }

   public C0962 yf() {
      return this.YI;
   }

   public void b(C0962 c0962) {
      this.YI = c0962;
   }

   public int iW() {
      return this.KR.iW();
   }

   public C0692 yg() {
      return this.KR;
   }

   @Override
   public void mr() {
      this.YI.z(this);
   }

   @Override
   public C0678[] mB() {
      return new C0678[]{this.YI};
   }

   @Override
   public ArrayList mC() {
      return null;
   }

   @Override
   public String[] b(C0678 c0678) {
      return this.YI.zf() == 2029 && C0745.vM().isNovoFormatoCopa() ? C0710.pt : this.YI.zB();
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String var2 = "tr_copa_" + C0696.valueOf("P" + Integer.toString(this.KR.jc())).jA();
      String var3 = "tr_copa";
      if (C0710.w(var2)) {
         var1[0] = var2;
      } else {
         var1[0] = var3;
      }

      var1[1] = this.getNome();
      return var1;
   }

   public int getnTimes() {
      return this.nTimes;
   }

   public String[] yh() {
      if (this.nTimes == 128) {
         return C0710.px;
      } else if (this.nTimes == 64) {
         return C0710.py;
      } else if (this.nTimes == 32) {
         return C0710.pz;
      } else if (this.nTimes == 16) {
         return C0710.pA;
      } else if (this.nTimes == 8) {
         return C0710.pB;
      } else if (this.nTimes == 4) {
         return C0710.pC;
      } else {
         return this.nTimes == 2 ? C0710.pD : C0710.ps;
      }
   }
}
