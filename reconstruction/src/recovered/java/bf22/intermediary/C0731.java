package bf22.intermediary;

import java.util.ArrayList;
import mod.recovered.model.Club;

public class C0731 {
   private double cy = 0.0;
   private int V;
   private int W;
   private C0675 cz = null;
   private ArrayList cA = new ArrayList();
   private Club cB = null;

   public C0731() {
   }

   public C0731(double d, int i, int j, C0675 c0675, Club club, ArrayList arrayList) {
      this.cy = d;
      this.V = i;
      this.W = j;
      this.cz = c0675;
      this.cB = club;
      this.cA = arrayList;
   }

   public String cQ() {
      return this.cy > 0.0 ? String.format("%.1f", this.cy) : "--";
   }

   public int y() {
      return this.V;
   }

   public int A() {
      return this.W;
   }

   public C0675 cR() {
      return this.cz;
   }

   public Club cS() {
      return this.cB;
   }

   public ArrayList cT() {
      return this.cA;
   }
}
