package mod.recovered.manager;

import bf22.intermediary.*;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class CoachChangeRecord implements Serializable {
   private static final long serialVersionUID = 1L;
   private Calendar p = Calendar.getInstance();
   private int bW = -1;
   private Coach di = null;
   private Coach dj = null;
   private int dk = 0;
   transient String dl = null;

   public Coach dO() {
      return this.di;
   }

   public void c(Coach coach) {
      this.di = coach;
   }

   public Coach dP() {
      return this.dj;
   }

   public void d(Coach coach) {
      this.dj = coach;
   }

   public int dQ() {
      return this.dk;
   }

   public void M(int i) {
      this.dk = i;
   }

   public String f() {
      DateFormat var1 = DateFormat.getDateInstance();
      return var1.format(this.a().getTime());
   }

   public int ct() {
      return this.bW;
   }

   public void C(int i) {
      this.bW = i;
   }

   public String dR() {
      if (this.dl == null && this.bW >= 0) {
         Club var1 = GamePersistence.SR.x(this.bW);
         if (var1 != null) {
            this.dl = var1.getNome();
         }
      }

      return this.dl;
   }

   public Calendar a() {
      return this.p;
   }

   public void b(Calendar calendar) {
      this.p = calendar;
   }
}
