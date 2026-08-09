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
   private Calendar date = Calendar.getInstance();
   private int clubId = -1;
   private Coach outgoingCoach = null;
   private Coach incomingCoach = null;
   private int dk = 0;
   transient String clubName = null;

   public Coach getOutgoingCoach() {
      return this.outgoingCoach;
   }

   public void setOutgoingCoach(Coach coach) {
      this.outgoingCoach = coach;
   }

   public Coach getIncomingCoach() {
      return this.incomingCoach;
   }

   public void setIncomingCoach(Coach coach) {
      this.incomingCoach = coach;
   }

   public int dQ() {
      return this.dk;
   }

   public void M(int i) {
      this.dk = i;
   }

   public String getDateText() {
      DateFormat var1 = DateFormat.getDateInstance();
      return var1.format(this.getDate().getTime());
   }

   public int getClubId() {
      return this.clubId;
   }

   public void setClubId(int i) {
      this.clubId = i;
   }

   public String getClubName() {
      if (this.clubName == null && this.clubId >= 0) {
         Club var1 = GamePersistence.careerState.findClubById(this.clubId);
         if (var1 != null) {
            this.clubName = var1.getNome();
         }
      }

      return this.clubName;
   }

   public Calendar getDate() {
      return this.date;
   }

   public void setDate(Calendar calendar) {
      this.date = calendar;
   }
}
