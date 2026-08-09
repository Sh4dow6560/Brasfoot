package bf22.intermediary;

import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mod.recovered.model.Club;

class C0974 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0974(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      Club var2 = (Club)((NationalLeague)((CountryCompetitions)GamePersistence.careerState.N().get(0)).eb().get(0)).yi().yK().get(0);
      var2.k(true);
      var2.getCoach().setUserControlled(true);
      GamePersistence.careerState.M().add(var2.getCoach());
      GamePersistence.careerState.aN().add(var2);
      C0971.a(this.Xb, var2);
   }
}
