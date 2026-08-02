package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public class C0799 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int RU = 0;
   private int RV = 0;
   private String RW = "";
   private String RX = "";
   private String data = "";
   boolean RY = false;
   boolean RZ = false;
   String Sa = "";
   String Sb = "";
   int oq = -1;
   int Sc = -1;
   int Sd = -1;
   boolean Se;

   public C0799() {
   }

   public C0799(boolean bl, int i, Club club, Player player, Coach coach, int j, int k, String string, String string2) {
      this.a(coach, j, k, string, string2);
      if (player != null) {
         this.Sa = player.getNome();
         this.oq = (int)Math.round(player.getSalary() * 0.1);
         this.RZ = bl;
         this.Sc = i;
      }
   }

   public C0799(Coach coach, int i, int j, String string, String string2) {
      this.a(coach, i, j, string, string2);
   }

   private void a(Coach coach, int i, int j, String string, String string2) {
      this.RU = i;
      this.RV = j;
      this.RW = string;
      this.RX = string2;
      this.data = GamePersistence.careerState.getCurrentDateText();
      if (coach != null) {
         if (coach.lQ() == null) {
            coach.T(new ArrayList());
         }

         coach.lQ().add(this);
      }
   }

   public int vm() {
      return this.RU;
   }

   public void en(int i) {
      this.RU = i;
   }

   public int vn() {
      return this.RV;
   }

   public void eo(int i) {
      this.RV = i;
   }

   public boolean vo() {
      return this.RY;
   }

   public void aF(boolean bl) {
      this.RY = bl;
   }

   public String getData() {
      return this.data;
   }

   public String vp() {
      return this.RW;
   }

   public String vq() {
      return this.RX;
   }

   public boolean vr() {
      return this.RZ;
   }

   public void aG(boolean bl) {
      this.RZ = bl;
   }

   public String vs() {
      return this.Sa;
   }

   public void X(String string) {
      this.Sa = string;
   }

   public int lY() {
      return this.oq;
   }

   public void cq(int i) {
      this.oq = i;
   }

   public int vt() {
      return this.Sc;
   }

   public void ep(int i) {
      this.Sc = i;
   }

   public int vu() {
      return this.Sd;
   }

   public void eq(int i) {
      this.Sd = i;
   }

   public boolean vv() {
      return this.Se;
   }

   public void aH(boolean bl) {
      this.Se = bl;
   }

   public String vw() {
      return this.Sb;
   }

   public void Y(String string) {
      this.Sb = string;
   }
}
