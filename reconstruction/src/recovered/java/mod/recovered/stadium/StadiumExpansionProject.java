package mod.recovered.stadium;

import bf22.intermediary.*;
import java.io.Serializable;
import java.util.Calendar;
import mod.recovered.model.Stadium;

public class StadiumExpansionProject implements Serializable {
   private static final long serialVersionUID = 1L;
   private Stadium stadium = null;
   private Calendar completionDate = null;
   private int[] seatAdditions = new int[4];

   public Stadium getStadium() {
      return this.stadium;
   }

   public void setStadium(Stadium stadium) {
      this.stadium = stadium;
   }

   public Calendar getCompletionDate() {
      return this.completionDate;
   }

   public void setCompletionDate(Calendar calendar) {
      this.completionDate = calendar;
   }

   public void applyExpansion() {
      for (int var1 = 0; var1 < this.seatAdditions.length; var1++) {
         if (this.seatAdditions[var1] > 0) {
            this.stadium.f(var1, this.seatAdditions[var1]);
            this.seatAdditions[var1] = 0;
         }
      }
   }

   public void setSeatAdditions(int[] is) {
      this.seatAdditions = is;
   }
}
