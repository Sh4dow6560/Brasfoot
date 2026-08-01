package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0929 implements Serializable {
   private static final long serialVersionUID = 1L;
   C0962 aae;
   private int oj;
   private int w;
   private int aaf;
   boolean gj;
   boolean aag = false;
   private ArrayList as = new ArrayList();
   private ArrayList aai = new ArrayList();
   private ArrayList aaj = new ArrayList();
   private ArrayList aak = new ArrayList();
   private transient ArrayList aal = new ArrayList();
   int aam;
   int aan;
   int var0 = -1;

   public void a(C0962 c0962, ArrayList arrayList, int i, boolean bl, int j, int k, int l, boolean bl2) {
      this.b(c0962, arrayList, i, bl, j, k, l, bl2);
   }

   public void b(C0962 c0962, ArrayList arrayList, int i, boolean bl, int j, int k, int l, boolean bl2) {
      this.w = l;
      this.e(c0962);
      this.fk(arrayList.size());
      this.oj = i;
      this.aag = bl2;
      this.s(bl);
      this.fl(this.c(this.w, this.oj, true));
      this.fm(k);
      C0713 var9 = null;
      var9 = c0962.yT();
      new ArrayList();
      boolean var11 = false;
      if (c0962 != null && c0962.zf() == 14006) {
         var11 = true;
      }

      ArrayList var10 = C0693.a(l, var11);

      for (byte var12 = 0; var12 < arrayList.size(); var12 += 2) {
         this.aai.add(new C0675(c0962, i, (Club)arrayList.get(var12), (Club)arrayList.get(var12 + 1), (Integer)var10.get(0), var9, null));
      }

      this.eZ((Integer)var10.get(0));
      if (bl) {
         for (byte var15 = 0; var15 < arrayList.size(); var15 += 2) {
            this.aaj.add(new C0675(c0962, i, (Club)arrayList.get(var15 + 1), (Club)arrayList.get(var15), (Integer)var10.get(1), var9, null));
         }

         this.eZ((Integer)var10.get(1));
      }

      c0962.zp().add(this);
      if (this.aai.size() == 1 && this.aae != null) {
         C0713 var16 = this.aae.yT();
         if (var16 != null && var16.mq()) {
            ArrayList var13 = this.aae.zt();
            if (var13.size() == 2) {
               this.aai.add(new C0675(c0962, i, (Club)var13.get(0), (Club)var13.get(1), (Integer)var10.get(0), var9, null));
            }
         }
      }
   }

   public C0962 zT() {
      return this.aae;
   }

   public int[] o(C0675 c0675) {
      int[] var2 = new int[]{-1, -1};
      if (this.aaj != null && this.aaj.size() > 0) {
         for (int var3 = 0; var3 < this.aaj.size(); var3++) {
            if (this.aaj.get(var3) == c0675) {
               var2[0] = ((C0675)this.aai.get(var3)).hw();
               var2[1] = ((C0675)this.aai.get(var3)).hu();
               break;
            }
         }
      }

      return var2;
   }

   private int c(int i, int j, boolean bl) {
      int var4 = 0;
      if (i == 2) {
         int var5 = this.aae.zq();
         int var6 = C0710.ss.length - 1 - var5;
         j += var6;
         if (j < C0710.ss.length) {
            var4 = C0710.ss[j];
         }
      } else if (i == 4) {
         int var8 = this.aae.yT().gg();
         if (var8 < 0) {
            var8 = 1;
         }

         if (this.aae.zf() >= 4101 && this.aae.zf() <= 4103) {
            var4 = 500000;
         } else if (this.aae.zf() >= 4000 && this.aae.zf() <= 4004) {
            var4 = 1000000;
         } else if (j < C0710.sw[0].length) {
            var4 = C0710.sw[var8][j];
         }
      } else if (i == 5) {
         if (j < C0710.sx.length) {
            var4 = C0710.sx[j];
         }
      } else if (i == 6) {
         int var9 = this.aae.yT().gg();
         if (var9 < 0 || var9 > 1) {
            var9 = 1;
         }

         if (this.aae.zf() == 6100) {
            var4 = 300000;
         } else if (this.aae.zf() >= 6000 && this.aae.zf() <= 6004) {
            var4 = 500000;
         } else if (j < C0710.sy[0].length) {
            var4 = C0710.sy[var9][j];
         }
      } else if (i == 8) {
         var4 = C0710.sz[0];
      } else if (i == 10) {
         if (j < C0710.sv.length) {
            var4 = C0710.sv[j];
         }
      } else if (i == 11) {
         var4 = C0710.sA[0];
      } else if (i == 12) {
         int var10 = this.aae.yT().gg();
         if (var10 < 0 || var10 > 1) {
            var10 = 1;
         }

         if (this.aae.zf() == 6100) {
            var4 = 300000;
         } else if (this.aae.zf() >= 6000 && this.aae.zf() <= 6004) {
            var4 = 500000;
         } else if (j < C0710.aeG[0].length) {
            var4 = C0710.aeG[var10][j];
         }
      }

      return var4;
   }

   public void e(C0962 c0962) {
      this.aae = c0962;
   }

   public int lU() {
      return this.oj;
   }

   public void co(int i) {
      this.oj = i;
   }

   public int zU() {
      return this.aaf;
   }

   public void fk(int i) {
      this.aaf = i;
   }

   public boolean hO() {
      return this.gj;
   }

   public void s(boolean bl) {
      this.gj = bl;
   }

   public ArrayList zV() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.aai.size(); var2++) {
         var1.add(((C0675)this.aai.get(var2)).hc());
         var1.add(((C0675)this.aai.get(var2)).hd());
      }

      return var1;
   }

   public ArrayList zW() {
      return this.aai;
   }

   public void ap(ArrayList arrayList) {
      this.aai = arrayList;
   }

   public ArrayList zX() {
      return this.aaj;
   }

   public void aq(ArrayList arrayList) {
      this.aaj = arrayList;
   }

   public ArrayList zY() {
      return this.aak;
   }

   public void ar(ArrayList arrayList) {
      this.aak = arrayList;
   }

   public void fl(int i) {
      this.aam = i;
   }

   public void fm(int i) {
      this.aan = i;
   }

   private void eZ(int i) {
      this.as.add(i);
   }

   public void b(boolean bl, boolean bl2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      byte var9 = 0;
      int var10 = 0;
      int var11 = 0;

      for (int var12 = 0; var12 < this.aai.size(); var12++) {
         var3 = 0;
         var4 = 0;
         var5 = 0;
         var6 = 0;
         var7 = 0;
         var8 = 0;
         var9 = 0;
         var10 = 0;
         var11 = 0;
         var3 = ((C0675)this.aai.get(var12)).hu();
         var4 = ((C0675)this.aai.get(var12)).hw();
         var10 = var3;
         var11 = var4;
         if (var3 > var4) {
            var7++;
         } else if (var4 > var3) {
            var8++;
         }

         if (this.gj) {
            var5 = ((C0675)this.aaj.get(var12)).hw();
            var6 = ((C0675)this.aaj.get(var12)).hu();
            if (var5 > var6) {
               var7++;
            } else if (var6 > var5) {
               var8++;
            }

            var10 += var5;
            var11 += var6;
         }

         if (var7 > var8) {
            var9 = 1;
         } else if (var8 > var7) {
            var9 = 2;
         }

         if (var9 == 0) {
            if (var10 > var11) {
               var9 = 1;
            } else if (var11 > var10) {
               var9 = 2;
            }
         }

         if (var9 == 0 && this.gj && this.aag) {
            if (var5 > var4) {
               var9 = 1;
            } else if (var4 > var5) {
               var9 = 2;
            }
         }

         if (var9 == 0 && this.ze() == 2129) {
            var9 = 2;
         } else if (var9 == 0) {
            C0675 var13 = (C0675)this.aai.get(var12);
            if (this.gj) {
               var13 = (C0675)this.aaj.get(var12);
            }

            if (var13.hP() && var13.hR() != null) {
               if (var13.hR() == ((C0675)this.aai.get(var12)).hc()) {
                  var9 = 1;
               } else {
                  var9 = 2;
               }
            } else if (((C0675)this.aai.get(var12)).hc().lf() < ((C0675)this.aai.get(var12)).hc().lf()) {
               var9 = 1;
            } else {
               var9 = 2;
            }
         }

         if (var9 == 1) {
            this.aak.add(((C0675)this.aai.get(var12)).hc());
            this.aal.add(((C0675)this.aai.get(var12)).hd());
            C0675 var34 = (C0675)this.aai.get(var12);
            if (this.gj) {
               var34 = (C0675)this.aaj.get(var12);
            }

            this.a(var34, ((C0675)this.aai.get(var12)).hc().ka(), 1);
            this.a(var34, ((C0675)this.aai.get(var12)).hd().ka(), 2);
            this.V(((C0675)this.aai.get(var12)).hc());
            if (this.aae.zf() == 90 || this.aae.zf() == 91 || this.aae.zf() == 92 || this.aae.zf() == 93 || this.aae.zf() == 94 || this.aae.zf() == 95) {
               C0745.SR.aY().a(this.aae.yT(), C0745.SR.s(((C0675)this.aai.get(var12)).hc().getPais()));
            }
         } else {
            this.aak.add(((C0675)this.aai.get(var12)).hd());
            this.aal.add(((C0675)this.aai.get(var12)).hc());
            C0675 var35 = (C0675)this.aai.get(var12);
            if (this.gj) {
               var35 = (C0675)this.aaj.get(var12);
            }

            this.a(var35, ((C0675)this.aai.get(var12)).hc().ka(), 2);
            this.a(var35, ((C0675)this.aai.get(var12)).hd().ka(), 1);
            this.V(((C0675)this.aai.get(var12)).hd());
            if (this.aae.zf() == 90 || this.aae.zf() == 91 || this.aae.zf() == 92 || this.aae.zf() == 93 || this.aae.zf() == 94 || this.aae.zf() == 95) {
               C0745.SR.aY().a(this.aae.yT(), C0745.SR.s(((C0675)this.aai.get(var12)).hd().getPais()));
            }
         }
      }

      if (bl2) {
         if (this.aae.zf() == 1099) {
            ((C0924)this.aae.yT()).BO();
         } else if (this.aae.zf() == 1098) {
            ((C0924)this.aae.yT()).r(this.aak, this.aal);
         } else if (this.aae.zf() != 91) {
            if (this.aae.zf() == 1068) {
               ((C0924)this.aae.yT()).n(this.aak, this.aal);
            } else if (this.aae.zf() == 9502) {
               C0745.SR.bS().p(this.aak, this.aal);
            } else if (this.aae.zf() == 9401) {
               C0745.SR.bR().ay(this.aak);
            } else if (this.aae.zf() == 9200) {
               C0745.SR.bM().aw(this.aak);
            } else if (this.aae.zf() == 9202) {
               C0745.SR.bM().p(this.aak, this.aal);
            } else if (this.aae.zf() == 9300) {
               C0745.SR.bQ().aw(this.aak);
            } else if (this.aae.zf() == 9002) {
               C0745.SR.bL().az(this.aak);
            } else if (this.aae.zf() == 9303) {
               C0745.SR.bQ().ax(this.aak);
            } else if (this.aae.zf() == 4000) {
               C0745.SR.aI().aj(this.aak);
            } else if (this.aae.zf() == 4001) {
               C0745.SR.aI().g(this.aak, this.aal);
            } else if (this.aae.zf() == 4002) {
               C0745.SR.aI().h(this.aak, this.aal);
            } else if (this.aae.zf() == 4003) {
               C0745.SR.aI().j(this.aak, this.aal);
            } else if (this.aae.zf() == 4004) {
               C0745.SR.aI().k(this.aak, this.aal);
            } else if (this.aae.zf() == 6001) {
               C0745.SR.aK().g(this.aak, this.aal);
            } else if (this.aae.zf() == 6002) {
               C0745.SR.aK().m(this.aak, this.aal);
            } else if (this.aae.zf() == 6006) {
               C0745.SR.aK().l(this.aak, this.aal);
            } else if (this.aae.zf() == 6004) {
               C0745.SR.aK().m(this.aak, this.aal);
            } else if (this.aae.zf() == 4101) {
               C0745.SR.aF().g(this.aak, this.aal);
            } else if (this.aae.zf() == 4102) {
               C0745.SR.aF().h(this.aak, this.aal);
            } else if (this.aae.zf() == 4103) {
               C0745.SR.aF().i(this.aak, this.aal);
            } else if (this.aae.zf() == 12001) {
               C0745.SR.mj().g(this.aak, this.aal);
            } else if (this.aae.zf() == 12002) {
               C0745.SR.mj().h(this.aak, this.aal);
            } else if (this.aae.zf() == 12003) {
               C0745.SR.mj().j(this.aak, this.aal);
            } else if (this.aae.zf() == 12004) {
               C0745.SR.mj().m(this.aak, this.aal);
            } else if (this.aae.zf() == 12006) {
               C0745.SR.mj().l(this.aak, this.aal);
            } else if (this.aae.zf() == 6100) {
               C0745.SR.aH().o(this.aak, this.aal);
            } else if (this.aae.zf() == 14006) {
               C0745.SR.sq().aA(this.aal);
            } else if (this.aae.zf() == 2029 && this.var0 != 2729) {
               C0942 var33 = (C0942)this.aae.yT();
               if (this.var0 == 2129) {
                  var33.ad(this.aak);
               } else if (this.var0 == 2229) {
                  var33.ao(this.aak);
               } else if (this.var0 == 2329) {
                  var33.as(this.aak);
               } else if (this.var0 == 2429) {
                  var33.at(this.aak);
               } else if (this.var0 == 2529) {
                  var33.au(this.aak);
               } else if (this.var0 == 2629) {
                  var33.av(this.aak);
               }
            } else if (this.aae.zf() != 1802 && this.aae.zf() != 1803) {
               if (this.aae.zf() == 150) {
                  C0745.SR.aR().al(this.aak);
               } else if (bl) {
                  C0713 var32 = this.aae.yT();
                  C0678 var36 = this.aae.zy();
                  Club var14 = null;
                  Club var15 = null;
                  if (this.aak.get(0) == ((C0675)this.aai.get(0)).hc()) {
                     boolean var26 = true;
                     var14 = ((C0675)this.aai.get(0)).hc();
                     var15 = ((C0675)this.aai.get(0)).hd();
                  } else {
                     var9 = 2;
                     var14 = ((C0675)this.aai.get(0)).hd();
                     var15 = ((C0675)this.aai.get(0)).hc();
                  }

                  new C0727(var32, var36, var14, var15);
                  if (C0710.fs(var32.b())) {
                     var14.ka();
                  }
               }
            }
         }
      }
   }

   private void V(Club club) {
      this.fl(this.c(this.w, this.oj, false));
      if (club != null && this.aam > 0 && club.jZ()) {
         club.v(this.aam, 3);
         C0962 var2 = this.zT();
         if (club.ka() != null && club.ka().jZ() && var2 != null) {
            new C0799(club.ka(), 26, 79, var2.getNome(), ClubFinances.c(this.aam));
         }
      }
   }

   private void a(C0675 c0675, Coach coach, int i) {
      if (c0675 != null && coach != null && c0675.hy() != null && c0675.hy().b() != 7 && c0675.hy().b() != 9) {
         coach.a(c0675, true, i);
      }
   }

   public boolean zZ() {
      return this.aag;
   }

   public int ze() {
      return this.var0;
   }

   public void fb(int i) {
      this.var0 = i;
   }

   public boolean ad(Club club) {
      for (int var2 = 0; var2 < this.aai.size(); var2++) {
         if (((C0675)this.aai.get(var2)).hc() == club || ((C0675)this.aai.get(var2)).hd() == club) {
            return true;
         }
      }

      return false;
   }
}
