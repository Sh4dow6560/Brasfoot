package bf22.intermediary;

import bf22.intermediary.CompetitionResultsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0066 implements ActionListener {
   final bf22.intermediary.CompetitionResultsPanel wT;
   C0066(CompetitionResultsPanel c0065) {
      this.wT = c0065;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (CompetitionResultsPanel.a(this.wT).getSelectedIndex() >= 0) {
         CompetitionResultsPanel.a(this.wT, CompetitionResultsPanel.a(this.wT).getSelectedIndex());
      }
   }
}
