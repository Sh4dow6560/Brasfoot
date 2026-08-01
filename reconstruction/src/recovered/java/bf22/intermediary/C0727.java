package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public class C0727 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int ae;
   private int bQ = -1;
   private int bR = -1;
   private String bS = null;
   private int bT = -1;
   private int V;
   private int bU = -1;
   private int bV = -1;

   public C0727() {
   }

   public C0727(C0713 c0713, C0678 c0678, Club club, Club club2) {
      this.ae = C0745.SR.H();
      if (club != null) {
         this.bQ = club.lk();
      }

      if (club != null && club.ka() != null) {
         this.bU = club.ka().lT();
      }

      if (club2 != null) {
         this.bR = club2.lk();
      }

      if (club2 != null && club2.ka() != null) {
         this.bV = club2.ka().lT();
      }

      int var5 = 0;
      C0720 var6 = null;
      var6 = c0713.mu();
      c0713.mn().add(this);
      if (c0713 != null) {
         c0713.mr();
         var5 = c0713.b();
      }

      if (var6 != null) {
         Player var7 = var6.x();
         this.V = var6.y();
         if (var7 != null) {
            this.bS = var7.getNome();
         }

         if (var7 != null && var7.fg() != null) {
            this.bT = var7.fg().lk();
         }

         if (c0678 != null && c0678.b() == 1 && c0678.ip() == 1) {
            var6.x().a(true);
         }
      }

      if (club != null && club.jZ() && c0713 != null) {
         C0685.a(club, c0713, var5);
      }

      if (var5 == 1 && c0713 instanceof C0924) {
         ((C0924)c0713).BQ();
      }
   }

   public int H() {
      return this.ae;
   }

   public Club ce() {
      return this.bQ >= 0 ? C0745.SR.x(this.bQ) : null;
   }

   public Club cf() {
      return this.bR >= 0 ? C0745.SR.x(this.bR) : null;
   }

   public String cg() {
      return this.bS;
   }

   public Club ch() {
      return this.bT >= 0 ? C0745.SR.x(this.bT) : null;
   }

   public int y() {
      return this.V;
   }

   public Coach ci() {
      return this.bU == -1 ? null : C0745.SR.y(this.bU);
   }

   public Coach cj() {
      return this.bV == -1 ? null : C0745.SR.y(this.bV);
   }
}
