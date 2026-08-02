package bf22.intermediary;

import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.config.StateLeagueConfig;
import mod.recovered.config.StateLeagueConfigs;
import mod.recovered.model.Club;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class C0741 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int dr = -1;
   public ArrayList ds = new ArrayList();
   private ArrayList dt = new ArrayList();
   private static transient ArrayList du = new ArrayList();
   private static transient ArrayList dv = new ArrayList();
   private int dw = 0;
   public static Comparator dx = new C0742();

   public C0741() {
   }

   public C0741(int i) {
      this.dr = i;
      GamePersistence.careerState.aE().add(this);
      this.dY();
   }

   private void dY() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < GamePersistence.careerState.P().size(); var2++) {
         if (((Club)GamePersistence.careerState.P().get(var2)).getPais() == 29 && ((Club)GamePersistence.careerState.P().get(var2)).getEstado() == this.dr) {
            var1.add((Club)GamePersistence.careerState.P().get(var2));
         }
      }

      Collections.sort(var1, C1007.cN);
      StateLeagueConfig var16 = null;
      boolean var3 = false;
      int var4 = var1.size();
      boolean var5 = false;
      boolean var6 = false;
      ArrayList var7 = new ArrayList();

      for (int var8 = 1; var8 <= 4; var8++) {
         var3 = false;
         var5 = false;
         var6 = false;
         if (var1.size() >= 6) {
            var16 = g(this.dr, var8);
            LeagueLoadOptions var9 = new LeagueLoadOptions();
            int var10 = 0;
            if (var16 == null) {
               var3 = true;
            } else if (GameConstants.sL[var16.getFormula()][0] > var4) {
               var3 = true;
            }

            if (!var3) {
               var9.nTimes = GameConstants.sL[var16.getFormula()][0];
               var9.nGrupos = GameConstants.sL[var16.getFormula()][1];
               var9.numeroTimesMataMata = GameConstants.sL[var16.getFormula()][2];
               if (GameConstants.sL[var16.getFormula()][3] == 1) {
                  var9.doisTurnos = true;
               } else {
                  var9.doisTurnos = false;
               }

               var9.duasVoltasMataMata = var16.getFinaisIdaVoltaFormatado();
               var16.getFormula();
               var10 = GameConstants.sL[var16.getFormula()][4];
               var9.desempateEstadual = var16.getDesempate();
               if (var16.getFormula() == 7 || var16.getFormula() == 10) {
                  var9.jogosDentroGrupo = false;
               }

               var9.var0 = var16.getFormula();
            } else {
               var9.nTimes = 6;
               var9.nGrupos = 0;
               var9.numeroTimesMataMata = 2;
               var9.doisTurnos = true;
               var10 = 2;
               var9.var0 = 0;
            }

            var7.clear();
            ArrayList var11 = new ArrayList();
            if (var9.var0 == 7 && var8 == 1 && this.dr == 25 && GamePersistence.careerState.isUsaGrupoPadraoEstadual()) {
               var11 = z(var1);
            }

            new ArrayList();
            if (var9.var0 == 7 && var8 == 1 && this.dr == 25 && var11.size() == 16) {
               for (int var23 = 0; var23 < var11.size(); var23++) {
                  var7.add((Club)var11.get(var23));
               }

               var6 = true;
               var11.clear();
            } else {
               for (int var13 = 0; var13 < var9.nTimes; var13++) {
                  if (var13 < var1.size()) {
                     var7.add((Club)var1.get(var13));
                  }
               }
            }

            LeagueStage var24 = null;
            StateChampionship var14 = new StateChampionship(this, this.ds.size() + 1);
            var14.setnRebaixados(var10);
            var24 = new LeagueStage(var9, var7, 0, null, null, null, 3, this, var5, null, var6, var14);
            this.ds.add(var14);
            var14.q(var24);

            for (int var15 = 0; var15 < var7.size(); var15++) {
               var1.remove(var7.get(var15));
            }
         }
      }

      for (int var21 = 0; var21 < var1.size(); var21++) {
         this.dt.add((Club)var1.get(var21));
      }
   }

   private static ArrayList z(ArrayList arrayList) {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < GameConstants.sO.length; var2++) {
         for (int var3 = 0; var3 < arrayList.size(); var3++) {
            if (((Club)arrayList.get(var3)).jY().equals(GameConstants.sO[var2]) && ((Club)arrayList.get(var3)).getEstado() == 25) {
               var1.add((Club)arrayList.get(var3));
            }
         }
      }

      return var1;
   }

   public static void dZ() {
      ef();
      int[] var0 = new int[27];
      int var1 = -1;

      for (int var2 = 0; var2 < GamePersistence.careerState.P().size(); var2++) {
         if (((Club)GamePersistence.careerState.P().get(var2)).getPais() == 29) {
            var1 = ((Club)GamePersistence.careerState.P().get(var2)).getEstado();
            if (var1 >= 0 && var1 <= 26) {
               var0[var1]++;
            }
         }
      }

      for (int var4 = 0; var4 < var0.length; var4++) {
         if (var0[var4] >= 6) {
            new C0741(var4);
         }
      }
   }

   public static void ds() {
      du.clear();
      File var0 = new File(System.getProperty("user.dir") + "/conf_estadual");
      File[] var1 = var0.listFiles(new C0743());

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].isFile()) {
            try {
               DocumentBuilderFactory var3 = DocumentBuilderFactory.newInstance();
               DocumentBuilder var4 = var3.newDocumentBuilder();
               Document var5 = var4.parse(var1[var2].getPath());
               Node var6 = var5.getFirstChild();
               NodeList var7 = var6.getChildNodes();

               for (int var8 = 0; var8 < var7.getLength(); var8++) {
                  Node var9 = var7.item(var8);
                  Element var10 = (Element)var9;
                  j(var10.getTextContent());
               }
            } catch (Exception var11) {
               var11.printStackTrace();
            }
         }
      }
   }

   public static void j(String string) {
      string = string.trim();
      if (string != null && !string.isEmpty()) {
         String var1 = string;
         String[] var2 = var1.split(",");
         if (var2.length == 8) {
            int[] var3 = new int[var2.length];

            for (int var4 = 0; var4 < var3.length; var4++) {
               var3[var4] = Integer.parseInt(var2[var4]);
            }

            dv.add(new StateLeagueConfig(var3));
         }
      }
   }

   public static StateLeagueConfig g(int i, int j) {
      for (int var2 = 0; var2 < dv.size(); var2++) {
         if (((StateLeagueConfig)dv.get(var2)).getId() == i && ((StateLeagueConfig)dv.get(var2)).getDivisao() == j) {
            return (StateLeagueConfig)dv.get(var2);
         }
      }

      return null;
   }

   public String ea() {
      return GameConstants.rZ[this.dr];
   }

   public ArrayList eb() {
      return this.ds;
   }

   public int ec() {
      return this.dw;
   }

   public void ed() {
      this.dw++;
   }

   public int getEstado() {
      return this.dr;
   }

   public void ee() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      boolean var3 = false;
      ((StateChampionship)this.ds.get(0)).yi().ah(0, ((StateChampionship)this.ds.get(0)).getnRebaixados());

      for (int var4 = 1; var4 < this.ds.size(); var4++) {
         ((StateChampionship)this.ds.get(var4)).yi().ah(((StateChampionship)this.ds.get(var4 - 1)).getnRebaixados(), ((StateChampionship)this.ds.get(var4)).getnRebaixados());
      }

      for (int var7 = 0; var7 < this.ds.size(); var7++) {
         if (var7 + 1 < this.ds.size()) {
            var2.clear();
            var1.clear();

            for (int var8 = 0; var8 < ((StateChampionship)this.ds.get(var7)).yi().yU().size(); var8++) {
               var2.add((Club)((StateChampionship)this.ds.get(var7)).yi().yU().get(var8));
            }

            for (int var9 = 0; var9 < ((StateChampionship)this.ds.get(var7 + 1)).yi().yW().size(); var9++) {
               var1.add((Club)((StateChampionship)this.ds.get(var7 + 1)).yi().yW().get(var9));
            }

            if (var2.size() == var1.size()) {
               for (int var10 = 0; var10 < var2.size(); var10++) {
                  ((StateChampionship)this.ds.get(var7)).yi().yK().remove(var2.get(var10));
                  ((StateChampionship)this.ds.get(var7 + 1)).yi().yK().add((Club)var2.get(var10));
               }

               for (int var11 = 0; var11 < var1.size(); var11++) {
                  ((StateChampionship)this.ds.get(var7 + 1)).yi().yK().remove(var1.get(var11));
                  ((StateChampionship)this.ds.get(var7)).yi().yK().add((Club)var1.get(var11));
               }
            }
         } else {
            var2.clear();
            var1.clear();
            int var5 = ((StateChampionship)this.ds.get(var7)).getnRebaixados();
            if (this.dt.size() < var5) {
               var5 = this.dt.size();
            }

            if (var5 > 0) {
               for (int var6 = 0; var6 < ((StateChampionship)this.ds.get(var7)).yi().yU().size(); var6++) {
                  if (var6 < var5) {
                     var2.add((Club)((StateChampionship)this.ds.get(var7)).yi().yU().get(var6));
                  }
               }

               for (int var12 = 0; var12 < var5; var12++) {
                  var1.add((Club)this.dt.get(var12));
               }

               if (var2.size() == var1.size()) {
                  for (int var13 = 0; var13 < var2.size(); var13++) {
                     ((StateChampionship)this.ds.get(var7)).yi().yK().remove(var2.get(var13));
                     this.dt.add((Club)var2.get(var13));
                  }

                  for (int var14 = 0; var14 < var1.size(); var14++) {
                     this.dt.remove(var1.get(var14));
                     ((StateChampionship)this.ds.get(var7)).yi().yK().add((Club)var1.get(var14));
                  }
               }
            }
         }
      }
   }

   public static void P(int i) {
      StateLeagueConfigs var1 = new StateLeagueConfigs();

      for (int var2 = 0; var2 < dv.size(); var2++) {
         if (((StateLeagueConfig)dv.get(var2)).getId() == i) {
            var1.leagues.add((StateLeagueConfig)dv.get(var2));
         }
      }

      try {
         FileOutputStream var5 = new FileOutputStream(System.getProperty("user.dir") + "/conf_estadual/" + GameConstants.rX[i] + ".ces");
         ObjectOutputStream var3 = new ObjectOutputStream(var5);
         var3.writeObject(var1);
         var3.close();
         var5.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   public static void ef() {
      dv.clear();
      File var0 = new File(System.getProperty("user.dir") + "/conf_estadual");
      File[] var1 = var0.listFiles(new C0744());

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].isFile()) {
            new StateLeagueConfigs();

            StateLeagueConfigs var3;
            try {
               FileInputStream var4 = new FileInputStream(var1[var2].getPath());
               ObjectInputStream var5 = new ObjectInputStream(var4);
               var3 = (StateLeagueConfigs)var5.readObject();
               var5.close();
               var4.close();
            } catch (IOException var6) {
               var6.printStackTrace();
               return;
            } catch (ClassNotFoundException var7) {
               var7.printStackTrace();
               return;
            }

            a(var3);
         }
      }
   }

   public static void a(StateLeagueConfigs stateLeagueConfigs) {
      for (int var1 = 0; var1 < stateLeagueConfigs.leagues.size(); var1++) {
         dv.add((StateLeagueConfig)stateLeagueConfigs.leagues.get(var1));
      }
   }

   public static ArrayList eg() {
      return dv;
   }

   public static ArrayList eh() {
      short var0 = 128;
      ArrayList var1 = new ArrayList();
      Collections.sort(GamePersistence.careerState.bx(), dx);
      int var2 = 0;
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      a(GameConstants.se, var1);
      a(GameConstants.sf, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      var2 = var1.size();
      if (var2 < var0) {
         a(GameConstants.se, var1);
         a(GameConstants.sf, var1);
         a(GameConstants.sb, var1);
         a(GameConstants.sc, var1);
         a(GameConstants.sd, var1);
      }

      if (var2 < var0) {
         a(GameConstants.se, var1);
         a(GameConstants.sf, var1);
         a(GameConstants.sb, var1);
         a(GameConstants.sc, var1);
         a(GameConstants.sd, var1);
         a(GameConstants.se, var1);
         a(GameConstants.sf, var1);
         a(GameConstants.sb, var1);
         a(GameConstants.sc, var1);
         a(GameConstants.sd, var1);
         a(GameConstants.se, var1);
         a(GameConstants.sf, var1);
         a(GameConstants.sb, var1);
         a(GameConstants.sc, var1);
         a(GameConstants.sd, var1);
      }

      return var1;
   }

   public static void a(int[] is, ArrayList arrayList) {
      for (int var2 = 0; var2 < is.length; var2++) {
         for (int var3 = 0; var3 < GamePersistence.careerState.bx().size(); var3++) {
            if (((C0779)GamePersistence.careerState.bx().get(var3)).getEstado() == is[var2] && !arrayList.contains(((C0779)GamePersistence.careerState.bx().get(var3)).vD())) {
               arrayList.add(((C0779)GamePersistence.careerState.bx().get(var3)).vD());
               break;
            }
         }
      }
   }

   public static ArrayList Q(int i) {
      ArrayList var1 = new ArrayList();
      Collections.sort(GamePersistence.careerState.bx(), dx);
      ArrayList var2 = new ArrayList();
      if (GamePersistence.careerState.bY().size() > 0) {
         for (int var3 = 0; var3 < GamePersistence.careerState.bY().size(); var3++) {
            if (((Club)GamePersistence.careerState.bY().get(var3)).getDivisao() == 0 && !((Club)GamePersistence.careerState.bY().get(var3)).ko()) {
               var1.add((Club)GamePersistence.careerState.bY().get(var3));
               var2.add((Club)GamePersistence.careerState.bY().get(var3));
            }
         }
      }

      int var6 = 0;
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      a(GameConstants.se, var1);
      a(GameConstants.sf, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      a(GameConstants.se, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sb, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sc, var1);
      a(GameConstants.sd, var1);
      a(GameConstants.se, var1);
      var6 = var1.size();
      if (var6 < i) {
         CountryCompetitions var4 = GamePersistence.careerState.o(29);
         if (var4 != null) {
            for (int var5 = 0; var5 < var4.jg().size(); var5++) {
               if (var6 < i && ((Club)var4.jg().get(var5)).getDivisao() == 0 && !var1.contains(var4.jg().get(var5))) {
                  var1.add((Club)var4.jg().get(var5));
                  var6++;
               }
            }
         }
      }

      if (var1.size() > i) {
         ArrayList var8 = new ArrayList();
         var8.addAll(var1);
         var1.clear();

         for (int var10 = 0; var10 < i; var10++) {
            var1.add((Club)var8.get(var10));
         }
      }

      if (i == 68) {
         var1.removeAll(var2);
         Collections.sort(var1, C1007.aaU);

         for (int var9 = 0; var9 < var2.size(); var9++) {
            var1.add(var9, (Club)var2.get(var9));
         }
      } else if (i == 64) {
         Collections.sort(var1, C1007.aaV);
      }

      return var1;
   }

   public void A(ArrayList arrayList) {
      for (int var2 = 0; var2 < this.ds.size(); var2++) {
         ((StateChampionship)this.ds.get(var2)).yi().A(arrayList);
      }
   }

   public boolean ei() {
      for (int var1 = 0; var1 < this.ds.size(); var1++) {
         for (int var2 = 0; var2 < ((StateChampionship)this.ds.get(var1)).yi().yK().size(); var2++) {
            if (((Club)((StateChampionship)this.ds.get(var1)).yi().yK().get(var2)).isUserControlled()) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean j(Club club) {
      for (int var2 = 0; var2 < this.ds.size(); var2++) {
         for (int var3 = 0; var3 < ((StateChampionship)this.ds.get(var2)).yi().yK().size(); var3++) {
            if (((StateChampionship)this.ds.get(var2)).yi().yK().get(var3) == club) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean ej() {
      for (int var1 = 0; var1 < GamePersistence.careerState.getCurrentMatches().size(); var1++) {
         if (this.ds.contains(((Match)GamePersistence.careerState.getCurrentMatches().get(var1)).getCompetition())) {
            return true;
         }
      }

      return false;
   }

   public ArrayList ek() {
      return this.dt;
   }

   public int K(int i) {
      int var2 = i - 2;
      return i > 1 && var2 < this.ds.size() ? ((StateChampionship)this.ds.get(var2)).getnRebaixados() : 0;
   }
}
