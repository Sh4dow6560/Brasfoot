package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0924 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YL = null;
   private C0955 ZU = null;
   private C0962 ZV = null;
   private ArrayList ZW = new ArrayList();
   private ArrayList ZX = new ArrayList();
   private ArrayList ZY = new ArrayList();
   private transient ArrayList ZZ = new ArrayList();
   private ArrayList aaa = new ArrayList();
   private int divisao = 0;
   private C0692 KR = null;
   private boolean agz = false;
   private int nRebaixados = 0;
   private boolean[] duasVoltasplayoffReb = new boolean[3];
   private boolean[] duasVoltasMataMataSobe = new boolean[3];
   private int vagasSobemPeloMataMata = 0;
   private int rebaixadosDireto = 2;
   private C0962 agA = null;
   private C0962 agB = null;
   private boolean GU = false;
   public static Comparator aab = new C0925();

   @Override
   public void clear() {
      this.ZZ.clear();
      this.aaa.clear();
      this.ZW.clear();
   }

   public C0924() {
   }

   public C0924(C0692 c0692, int i) {
      this.F(1, i);
      this.divisao = i;
      this.KR = c0692;
   }

   public void zF() {
      this.ZU = null;
   }

   public void a(ArrayList arrayList, C0955 c0955, int i) {
      if (i == 1020 && arrayList.size() == 8) {
         LeagueLoadOptions var4 = new LeagueLoadOptions();
         var4.nTimes = 8;
         var4.nGrupos = 2;
         var4.numeroTimesMataMata = 1;
         var4.doisTurnos = true;
         C0955 var5 = new C0955(var4, arrayList, 0, null, null, c0955.vl(), 1, null, false, c0955, true, this);
         this.ZU = var5;
         var5.setNome(c0955.getNome());
         var5.fb(1022);
      }
   }

   public void n(ArrayList arrayList, ArrayList arrayList2) {
      this.YL.ai(arrayList2);
   }

   public C0722 D(Player player) {
      for (int var2 = 0; var2 < this.ZW.size(); var2++) {
         if (((C0722)this.ZW.get(var2)).x() == player) {
            return (C0722)this.ZW.get(var2);
         }
      }

      C0722 var3 = new C0722(this, player);
      this.ZW.add(var3);
      return var3;
   }

   public void E(Player player) {
      boolean var2 = true;
      if (player.getPosicao() == 0 && player.fT() != 1) {
         var2 = false;
      } else if (player.getPosicao() == 1 && player.getLado() == 0 && player.fT() != 9) {
         var2 = false;
      } else if (player.getPosicao() == 1 && player.getLado() == 1 && player.fT() != 2) {
         var2 = false;
      } else if (player.getPosicao() == 2) {
         if (player.fT() < 3 || player.fT() > 8) {
            var2 = false;
         }
      } else if (player.getPosicao() == 3) {
         if (player.fT() < 10 || player.fT() > 17) {
            var2 = false;
         }
      } else if (player.getPosicao() == 4 && player.fT() < 18) {
         var2 = false;
      }

      if (player.getPosicao() == 1 && player.getLado() == 0 && player.fT() == 17) {
         var2 = true;
      }

      if (player.getPosicao() == 1 && player.getLado() == 1 && player.fT() == 10) {
         var2 = true;
      }

      int[] var3 = new int[]{-1, 0, 5, 2, 2, 2, 2, 2, 2, 1, 3, 6, 6, 6, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
      if (var2) {
         C0722 var4 = this.D(player);
         var4.a(player.gk());
         if (var3[player.fT()] == 3 && player.fF() == 0) {
            var4.j(6);
         } else if (var3[player.fT()] == 3 && player.fF() == 1) {
            var4.j(3);
         } else if (var3[player.fT()] == 5 && player.getPosicao() == 3) {
            var4.j(3);
         } else if (var3[player.fT()] == 1 && player.getPosicao() == 3) {
            var4.j(3);
         } else {
            var4.j(var3[player.fT()]);
         }
      }
   }

   public void fi(int i) {
      this.zL();
      int[] var2 = new int[]{0, 1, 2, 2, 5, 6, 6, 3, 3, 4, 4};
      int var3 = this.yi().zk();
      C0706 var4 = new C0706();
      var4.k(C0745.SR.H());

      for (int var5 = 0; var5 < var2.length; var5++) {
         for (int var6 = 0; var6 < this.ZW.size(); var6++) {
            if (((C0722)this.ZW.get(var6)).E() == var2[var5] && ((C0722)this.ZW.get(var6)).D() >= var3 && !var4.lV().contains(((C0722)this.ZW.get(var6)).x())) {
               var4.lV().add(((C0722)this.ZW.get(var6)).x());
               var4.lW().add(((C0722)this.ZW.get(var6)).x().fg());
               break;
            }
         }
      }

      this.ZY.add(var4);
      Player var7 = null;

      for (int var9 = 0; var9 < this.ZW.size(); var9++) {
         if (((C0722)this.ZW.get(var9)).D() >= var3) {
            this.ZX.add(((C0722)this.ZW.get(var9)).x());
            if (i == 0) {
               var7 = ((C0722)this.ZW.get(var9)).x();
               if (var7 != null) {
                  var7.a(true);
               }
            }
            break;
         }
      }
   }

   public ArrayList fj(int i) {
      ArrayList var2 = new ArrayList();
      int var3 = this.yi().zk();
      int var4 = 0;

      for (int var5 = 0; var5 < this.ZW.size(); var5++) {
         if (((C0722)this.ZW.get(var5)).E() == i && ((C0722)this.ZW.get(var5)).D() >= var3) {
            if (var4 < 20) {
               var2.add((C0722)this.ZW.get(var5));
            }

            var4++;
         }

         if (var4 == 20) {
            break;
         }
      }

      return var2;
   }

   public ArrayList zG() {
      ArrayList var1 = new ArrayList();
      int var2 = this.yi().zk();
      int var3 = 0;

      for (int var4 = 0; var4 < this.ZW.size(); var4++) {
         if (((C0722)this.ZW.get(var4)).D() >= var2 && var3 < 20) {
            var1.add((C0722)this.ZW.get(var4));
            var3++;
         }

         if (var3 >= 20) {
            break;
         }
      }

      return var1;
   }

   public void F(Player player) {
      C0691 var2 = new C0691();
      var2.a(player);
      var2.j(player.gk());
      var2.bi(player.fT());
      if (this.ZZ == null) {
         this.ZZ = new ArrayList();
      }

      this.ZZ.add(var2);
   }

   public void zH() {
      Collections.sort(this.ZZ, aab);
      int[] var1 = new int[]{1, 9, 3, 3, 2, 11, 11, 14, 14, 18, 18};
      int[] var2 = new int[]{1, 9, 8, 8, 2, 13, 13, 16, 16, 25, 25};
      C0706 var3 = new C0706();
      var3.co(this.aaa.size() - 1);

      for (int var4 = 0; var4 <= 10; var4++) {
         for (int var5 = 0; var5 < this.ZZ.size(); var5++) {
            if (((C0691)this.ZZ.get(var5)).iR() >= var1[var4]
               && ((C0691)this.ZZ.get(var5)).iR() <= var2[var4]
               && !var3.lV().contains(((C0691)this.ZZ.get(var5)).x())) {
               var3.lV().add(((C0691)this.ZZ.get(var5)).x());
               var3.lW().add(((C0691)this.ZZ.get(var5)).x().fg());
               break;
            }
         }
      }

      this.aaa.add(var3);
      this.ZZ.clear();
   }

   public void BJ() {
      this.agA = null;
      this.agB = null;
   }

   public boolean BK() {
      int var1 = this.BN();
      return var1 > 0 && this.vagasSobemPeloMataMata > 0;
   }

   public int BL() {
      return this.nRebaixados > 0 ? this.nRebaixados - this.rebaixadosDireto : 0;
   }

   public boolean BM() {
      if (this.nRebaixados > 0 && this.nRebaixados != this.rebaixadosDireto) {
         if (this.divisao == 4 && this.KR != null && this.KR.jc() == 29 && C0745.SR.bk()) {
            this.setRebaixadosDireto(this.nRebaixados);
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public int BN() {
      return this.divisao > 1 ? this.KR.K(this.divisao) : 0;
   }

   public int[] t(C0955 c0955) {
      int[] var2 = new int[3];
      if (c0955 == this.YL) {
         var2[0] = this.KR.K(this.divisao);
         var2[2] = this.KR.fq(this.divisao);
      }

      if (var2[0] > 0) {
         var2[1] = this.vagasSobemPeloMataMata;
         var2[0] -= this.vagasSobemPeloMataMata;
      }

      return var2;
   }

   public boolean ac(Club club) {
      return this.agB != null && this.agB.zp().size() > 0 && ((C0929)this.agB.zp().get(0)).zY().contains(club);
   }

   public void BO() {
      this.aT(true);
      this.BP();
   }

   public void r(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         ((Club)arrayList.get(var3)).c(this, 1090, 1098);
      }

      for (int var4 = 0; var4 < arrayList2.size(); var4++) {
         ((Club)arrayList2.get(var4)).c(this, 1091, 1098);
      }
   }

   public void BP() {
      if (this.KR != null) {
         C0924 var1 = this.KR.fo(this.divisao);
         if (var1 != null && var1.BS()) {
            this.a(var1);
         } else if (this.KR.fa(this.divisao)) {
            this.a((C0924)null);
         }

         if (this.divisao > 1) {
            C0924 var2 = this.KR.fp(this.divisao);
            if (var2 != null && var2.BS()) {
               var2.a(this);
            }
         }
      }
   }

   public void a(C0924 c0924) {
      if (this.BM() && this.agB == null) {
         new ArrayList();
         ArrayList var3 = new ArrayList();
         ArrayList var4 = new ArrayList();
         ArrayList var2 = this.YL.fG(this.nRebaixados);
         if (this.YL.ze() == 1020) {
            for (int var5 = 0; var5 < var2.size(); var5++) {
               System.out.println(var2.size() + " lista rebaixamento: " + ((Club)var2.get(var5)).getNome());
            }
         }

         Collections.reverse(var2);
         int var7 = this.nRebaixados - this.rebaixadosDireto;
         if (c0924 != null) {
            var3 = c0924.yi().l(this.nRebaixados, true);
            Collections.reverse(var3);
         } else if (this.KR != null) {
            var3 = this.KR.ek();
         }

         for (int var6 = 0; var6 < var7; var6++) {
            if (var6 < var2.size() && var6 < var3.size()) {
               var4.add((Club)var2.get(var6));
               var4.add((Club)var3.get(var6));
            }
         }

         if (var4.size() > 0) {
            this.agB = new C0962(null, var4.size(), this.b(), 1, this.duasVoltasplayoffReb, this, 1098);
            C0929 var8 = new C0929();
            var8.a(this.agB, var4, 0, this.duasVoltasplayoffReb[0], 0, 0, this.b(), false);
         }
      }
   }

   public void BQ() {
      if (this.divisao > 1 && this.agA == null && this.BK()) {
         int var1 = this.BN();
         byte var2 = 4;
         int var3 = var1 - this.vagasSobemPeloMataMata;
         int var4 = var3 + var2;
         byte var5 = 0;
         ArrayList var6 = new ArrayList();
         ArrayList var7 = new ArrayList();
         var6.addAll(this.YL.l(var4, false));
         if (var6.size() >= var4) {
            for (int var8 = var3; var8 < var4; var8++) {
               var7.add((Club)var6.get(var8));
            }

            if (this.vagasSobemPeloMataMata == 2) {
               var5 = 1;
            }

            this.agA = new C0962(null, var7.size(), this.b(), var5, this.duasVoltasMataMataSobe, this, 1099);
            C0929 var9 = new C0929();
            var9.a(this.agA, var7, 0, this.duasVoltasMataMataSobe[0], 0, 0, this.b(), false);
         } else {
            this.aT(true);
            this.BP();
         }
      } else {
         this.aT(true);
         this.BP();
      }
   }

   @Override
   public String getNome() {
      return this.yi() != null ? this.yi().getNome() : "Nacional";
   }

   public ArrayList zI() {
      return this.ZY;
   }

   public void zJ() {
      this.ZW.clear();
   }

   public void zK() {
      this.aaa.clear();
   }

   public void zL() {
      Collections.sort(this.ZW, tZ);
   }

   public ArrayList zM() {
      return this.ZX;
   }

   public C0955 yi() {
      return this.YL;
   }

   public void q(C0955 c0955) {
      this.YL = c0955;
   }

   public ArrayList zN() {
      return this.aaa;
   }

   public C0692 yg() {
      return this.KR;
   }

   public int zO() {
      return this.KR != null ? this.KR.jc() : -1;
   }

   @Override
   public void mr() {
      if (this.YL.ze() == 1020 && this.ZU != null) {
         this.ZU.za();
      } else {
         this.YL.za();
      }
   }

   @Override
   public C0692 iq() {
      return this.KR;
   }

   @Override
   public int ip() {
      return this.divisao;
   }

   @Override
   public String P(boolean bl) {
      return this.YL.io();
   }

   @Override
   public String is() {
      return this.YL.is();
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YL};
      if (this.agB != null) {
         C0678[] var2 = new C0678[]{this.agB};
         var1 = var2;
      } else if (this.agA != null) {
         C0678[] var3 = new C0678[]{this.agA};
         var1 = var3;
      } else if (this.YL.ze() == 1068) {
         if (this.YL == null || this.YL.yQ().size() <= 0) {
            var1[0] = this.ZV;
         } else if (this.YL.yY() != null) {
            var1[0] = this.YL.yY();
         } else {
            var1[0] = this.YL;
         }
      } else if (this.YL.ze() == 1020) {
         if (this.ZU != null) {
            if (this.ZU.yY() != null) {
               var1[0] = this.ZU.yY();
            } else {
               var1[0] = this.ZU;
            }
         }
      } else if (this.YL.yZ()) {
         C0678[] var4 = new C0678[]{this.YL.yY()};
         var1 = var4;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      boolean var1 = false;
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.YL.ze() == 1068) {
         C0678[] var4 = new C0678[]{this.ZV};
         var3.add(new C0830(var4, "Fase Preliminar"));
         if (this.YL != null && this.YL.yQ().size() > 0) {
            C0678[] var5 = new C0678[]{this.YL};
            var3.add(new C0830(var5, "Fase de Grupos"));
         } else {
            var3.add(new C0830(null, "Fase de Grupos"));
         }

         C0678[] var12 = new C0678[]{this.yi().yY()};
         var3.add(new C0830(var12, "Fase Final"));
         var1 = true;
      } else if (this.YL.ze() == 1020) {
         C0678[] var7 = new C0678[]{this.YL};
         var3.add(new C0830(var7, "Primeira Fase"));
         C0678[] var13 = new C0678[]{this.ZU};
         var3.add(new C0830(var13, "Segunda Fase"));
         C0678[] var6 = new C0678[1];
         if (this.ZU != null) {
            var6[0] = this.ZU.yY();
         }

         var3.add(new C0830(var6, "Final"));
         var1 = true;
      } else if (this.YL.yX() > 0) {
         String var8 = "Primeira Fase";
         if (this.YL.yQ().size() > 0) {
            var8 = "Fase de Grupos";
         }

         C0678[] var14 = new C0678[]{this.yi()};
         var3.add(new C0830(var14, var8));
         C0678[] var16 = new C0678[]{this.yi().yY()};
         var3.add(new C0830(var16, "Fase Final"));
         var1 = true;
      }

      if (this.BK()) {
         C0678[] var9 = new C0678[]{this.agA};
         var3.add(new C0830(var9, "Mata-mata vagas ascenso"));
         var2 = true;
      }

      if (this.BM()) {
         C0678[] var10 = new C0678[]{this.agB};
         String var15 = "Playoff (" + String.valueOf(this.divisao) + "ª div x " + (this.divisao + 1) + "ª div)";
         if (this.divisao == 4) {
            var15 = "Playoff (" + String.valueOf(this.divisao) + "ª div x " + "sem div.";
         }

         var3.add(new C0830(var10, var15));
         var2 = true;
      }

      if (!var1 && var2) {
         C0678[] var11 = new C0678[]{this.yi()};
         var3.add(0, new C0830(var11, "Tabela Liga"));
         var1 = true;
      }

      return var1 ? var3 : null;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String var2 = "tr_nacional_" + C0696.valueOf("P" + Integer.toString(this.KR.jc())).jA() + "_d" + Integer.toString(this.divisao);
      String var3 = "tr_nacionalgenerico";
      if (C0710.w(var2)) {
         var1[0] = var2;
      } else if (this.divisao == 1) {
         var2 = "tr_nacional_" + C0696.valueOf("P" + Integer.toString(this.KR.jc())).jA();
         if (C0710.w(var2)) {
            var1[0] = var2;
         } else {
            var1[0] = var3;
         }
      } else {
         var1[0] = var3;
      }

      var1[1] = this.getNome();
      return var1;
   }

   public C0955 zP() {
      return this.ZU;
   }

   public C0962 zQ() {
      return this.ZV;
   }

   public void d(C0962 c0962) {
      this.ZV = c0962;
   }

   public boolean zc() {
      return this.agz;
   }

   public void aS(boolean bl) {
      this.agz = bl;
   }

   public int getnRebaixados() {
      return this.nRebaixados;
   }

   public void setnRebaixados(int i) {
      this.nRebaixados = i;
   }

   public int getRebaixadosDireto() {
      return this.rebaixadosDireto;
   }

   public void setRebaixadosDireto(int i) {
      this.rebaixadosDireto = i;
   }

   public int getVagasSobemPeloMataMata() {
      return this.vagasSobemPeloMataMata;
   }

   public void setVagasSobemPeloMataMata(int i) {
      this.vagasSobemPeloMataMata = i;
      if (this.vagasSobemPeloMataMata > 2) {
         this.vagasSobemPeloMataMata = 0;
      }

      if (this.vagasSobemPeloMataMata < 0) {
         this.vagasSobemPeloMataMata = 0;
      }
   }

   public boolean[] getDuasVoltasplayoffReb() {
      return this.duasVoltasplayoffReb;
   }

   public void a(boolean[] bls) {
      this.duasVoltasplayoffReb = bls;
   }

   public boolean[] getDuasVoltasMataMataSobe() {
      return this.duasVoltasMataMataSobe;
   }

   public void b(boolean[] bls) {
      this.duasVoltasMataMataSobe = bls;
   }

   public C0962 BR() {
      return this.agA;
   }

   public boolean BS() {
      return this.GU;
   }

   public void aT(boolean bl) {
      this.GU = bl;
   }
}
