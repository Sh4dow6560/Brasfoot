package bf22.intermediary;

import bf22.intermediary.CompetitionResultsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0068 implements ActionListener {
   final bf22.intermediary.CompetitionResultsPanel wT;
   C0068(CompetitionResultsPanel c0065) {
      this.wT = c0065;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (CompetitionResultsPanel.e(this.wT).isEnabled()) {
         CompetitionResultsPanel.a(this.wT, CompetitionResultsPanel.d(this.wT) + 1, null, null);
      }
   }
}
