package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import java.io.Serializable;
import java.util.ArrayList;

public class C0951 extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0741 YK = null;
   private LeagueStage YL = null;
   private int divisao = 0;
   private int nRebaixados = 0;

   public C0951() {
   }

   public C0951(C0741 c0741, int i) {
      this.YK = c0741;
      this.divisao = i;
      this.F(3, c0741.getEstado());
      if (i == 1) {
         this.setNome(GameConstants.rZ[c0741.getEstado()]);
      } else {
         this.setNome(GameConstants.rZ[c0741.getEstado()] + " - " + i + "ª divisão");
      }
   }

   public LeagueStage yi() {
      return this.YL;
   }

   public void q(LeagueStage c0955) {
      this.YL = c0955;
   }

   public C0741 yj() {
      return this.YK;
   }

   public int yk() {
      return this.YK.getEstado();
   }

   @Override
   public void mr() {
      this.YL.za();
   }

   @Override
   public C0741 ir() {
      return this.YK;
   }

   @Override
   public int ip() {
      return this.divisao;
   }

   @Override
   public String is() {
      return this.YL.is();
   }

   public static ArrayList eX(int i) {
      ArrayList var1 = new ArrayList();
      String[] var2 = null;
      if (i == 7) {
         String[] var3 = new String[]{"1º Grupo A", "2º Grupo A", "1º Grupo B", "2º Grupo B", "1º Grupo C", "2º Grupo C", "1º Grupo D", "2º Grupo D"};
         var2 = var3;
      } else if (i == 1) {
         String[] var4 = new String[]{"1º Grupo A", "2º Grupo A", "1º Grupo B", "2º Grupo B", "1º Grupo C", "2º Grupo C", "1º Grupo D", "2º Grupo D"};
         var2 = var4;
      } else if (i == 0) {
         String[] var5 = new String[]{"1º", "2º"};
         var2 = var5;
      } else if (i == 2 || i == 4 || i == 7 || i == 9) {
         String[] var9 = new String[]{"1º", "4º", "2º", "3º"};
         var2 = var9;
      } else if (i == 3 || i == 5) {
         String[] var8 = new String[]{"2º", "7º", "4º", "5º", "1º", "8º", "6º", "3º"};
         var2 = var8;
      } else if (i == 6) {
         String[] var6 = new String[]{"2º no geral", "7º no geral", "4º no geral", "5º no geral", "1º no geral", "8º no geral", "6º no geral", "3º no geral"};
         var2 = var6;
      } else if (i == 8) {
         String[] var7 = new String[]{"Campeão 1º turno", "Campeão 2º turno"};
         var2 = var7;
      }

      if (i == 318) {
         String[] var10 = new String[]{"1º Grupo C", "4º Grupo C", "2º Grupo C", "3º Grupo C"};
         var2 = var10;
      }

      if (i == 319) {
         String[] var11 = new String[]{"5º Grupo C", "1º Grupo D", "6º Grupo C", "2º Grupo D"};
         var2 = var11;
      }

      if (i == 1802 || i == 1803) {
         String[] var12 = new String[]{"2º Grupo C", "1º Grupo B", "2º Grupo B", "1º Grupo C"};
         var2 = var12;
      }

      if (i == 14 || i == 14) {
         String[] var13 = new String[]{"1º Grupo A", "2º Grupo B", "1º Grupo B", "2º Grupo A"};
         var2 = var13;
      }

      for (int var14 = 0; var14 < var2.length; var14++) {
         var1.add(var2[var14]);
      }

      return var1;
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.YL};
      if (this.YL.yZ()) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.YL.yY()};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      if (this.YL.yX() > 0) {
         ArrayList var1 = new ArrayList();
         String var2 = "Primeira Fase";
         if (this.YL.yQ().size() > 0) {
            var2 = "Fase de Grupos";
         }

         CompetitionStage[] var3 = new CompetitionStage[]{this.yi()};
         var1.add(new C0830(var3, var2));
         CompetitionStage[] var4 = new CompetitionStage[]{this.yi().yY()};
         var1.add(new C0830(var4, "Fase Final"));
         return var1;
      } else {
         return null;
      }
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String var2 = "tr_estadual_" + GameConstants.rX[this.YK.getEstado()] + "_d" + Integer.toString(this.divisao);
      String var3 = "tr_estadualgenerico";
      if (GameConstants.w(var2)) {
         var1[0] = var2;
      } else if (this.divisao == 1) {
         var2 = "tr_estadual_" + GameConstants.rX[this.YK.getEstado()];
         if (GameConstants.w(var2)) {
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

   public int getnRebaixados() {
      return this.nRebaixados;
   }

   public void setnRebaixados(int i) {
      this.nRebaixados = i;
   }

   public int[] t(LeagueStage c0955) {
      int[] var2 = new int[3];
      if (c0955 == this.YL) {
         var2[0] = this.YK.K(this.divisao);
      }

      return var2;
   }
}
