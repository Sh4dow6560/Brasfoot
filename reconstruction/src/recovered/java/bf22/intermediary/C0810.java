package bf22.intermediary;

import java.awt.Color;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class C0810 {
   private Club club = null;
   private String info;
   private boolean NM;
   private Color NN = null;
   private int[] NO;
   private String NP = "";
   private int NQ = 0;
   private boolean NR = false;
   private Club NS = null;
   private boolean NT = false;
   private int w = 0;

   public C0810() {
   }

   public C0810(boolean bl, String string) {
      this.NT = bl;
      this.NP = string;
   }

   public C0810(Club club) {
      this.NS = club;
   }

   public Club getClub() {
      return this.club;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public String getInfo() {
      return this.info;
   }

   public void setInfo(String string) {
      this.info = string;
   }

   public Color getCorF() {
      return this.NN;
   }

   public void setCorF(Color color) {
      this.NN = color;
   }

   public int[] ta() {
      return this.NO;
   }

   public void l(int[] is) {
      this.NO = is;
   }

   public boolean tb() {
      return this.NM;
   }

   public void ak(boolean bl) {
      this.NM = bl;
   }

   public String tc() {
      return this.NP;
   }

   public void J(String string) {
      this.NP = string;
   }

   public int td() {
      return this.NQ;
   }

   public void dF(int i) {
      this.NQ = i;
   }

   public static ArrayList a(int i, int j, ArrayList arrayList, ArrayList arrayList2) {
      ArrayList var4 = new ArrayList();
      int[] var5 = new int[8];
      int var6 = 0;
      int var7 = 0;

      for (int var8 = 0; var8 < i; var8++) {
         C0810 var9 = new C0810();
         if (arrayList2 != null && var7 < arrayList2.size()) {
            var9.setInfo("Grupo " + (String)arrayList2.get(var7));
         } else {
            var9.setInfo("Grupo " + Integer.toString(var8 + 1));
         }

         var7++;
         var9.ak(true);
         var4.add(var9);
         C0810 var10 = new C0810();
         var10.setInfo("topo");
         var4.add(var10);

         for (int var11 = 0; var11 < j; var11++) {
            C0810 var12 = new C0810();
            var12.setClub(null);
            if (arrayList != null && var6 < arrayList.size()) {
               var12.setInfo((String)arrayList.get(var6));
            } else {
               var12.setInfo("Time " + Integer.toString(var11 + 1));
            }

            var12.l(var5);
            var12.al(true);
            var4.add(var12);
            var6++;
         }
      }

      return var4;
   }

   public boolean te() {
      return this.NR;
   }

   public void al(boolean bl) {
      this.NR = bl;
   }

   public Club tf() {
      return this.NS;
   }

   public void H(Club club) {
      this.NS = club;
   }

   public boolean tg() {
      return this.NT;
   }

   public void am(boolean bl) {
      this.NT = bl;
   }

   public int b() {
      return this.w;
   }

   public void a(int i) {
      this.w = i;
   }
}
