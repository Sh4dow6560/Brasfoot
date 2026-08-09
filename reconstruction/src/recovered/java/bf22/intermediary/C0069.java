package bf22.intermediary;

import bf22.intermediary.CompetitionResultsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0069 implements ActionListener {
   final bf22.intermediary.CompetitionResultsPanel wT;
   C0069(CompetitionResultsPanel c0065) {
      this.wT = c0065;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      CompetitionResultsPanel.f(this.wT).getSelectedIndex();
   }
}
