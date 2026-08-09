package mod.extension.sponsorship;

import java.awt.Component;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

final class SponsorOfferDialog {
  private SponsorOfferDialog() {
  }

  static String choose(Component parent, String clubName, List<SponsorOffer> offers) {
    if (offers.isEmpty()) {
      return null;
    }
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    ButtonGroup group = new ButtonGroup();
    JRadioButton[] choices = new JRadioButton[offers.size()];
    for (int index = 0; index < offers.size(); index++) {
      JRadioButton choice = new JRadioButton(
          SponsorshipFormatter.offerHtml(offers.get(index)));
      choice.setBorder(BorderFactory.createEmptyBorder(4, 0, 8, 0));
      choice.setSelected(index == 0);
      group.add(choice);
      panel.add(choice);
      choices[index] = choice;
    }
    int result = JOptionPane.showConfirmDialog(
        parent,
        panel,
        "Patroc\u00ednio - " + clubName,
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    if (result != JOptionPane.OK_OPTION) {
      return null;
    }
    for (int index = 0; index < choices.length; index++) {
      if (choices[index].isSelected()) {
        return offers.get(index).getId();
      }
    }
    return null;
  }
}
