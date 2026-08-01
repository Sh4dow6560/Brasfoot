package bf22.intermediary;

import mod.recovered.competition.NationalCup;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0626 extends JLabel implements ListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      if (object != null) {
         this.setIcon(null);
         if (bl) {
            this.setBackground(Color.YELLOW);
            this.setForeground(jList.getSelectionForeground());
         } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
         }

         if (object != null && object instanceof C0741) {
            C0741 var10 = (C0741)object;
            this.setIcon(new ImageIcon(this.getClass().getResource("/aesticons/" + var10.getEstado() + ".png")));
            String var11 = GameConstants.rY[var10.getEstado()];
            this.setText(var11);
         } else if (object != null && object instanceof NationalCup) {
            NationalCup var9 = (NationalCup)object;
            if (C0435.sf() == 1) {
               this.setText(var9.yg().jf());
            } else {
               this.setText(var9.getNome());
            }

            this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + var9.yg().jc() + ".png")));
         } else if (object != null && object instanceof CountryCompetitions) {
            CountryCompetitions var8 = (CountryCompetitions)object;
            if (C0435.sf() == 1) {
               this.setText(var8.jf());
            } else {
               this.setText(var8.jq().getNome());
            }

            this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + var8.jc() + ".png")));
         } else if (object != null) {
            Competition var6 = (Competition)object;
            String var7 = var6.getNome();
            this.setText(var7);
            this.setIcon(var6.es());
         }
      }

      return this;
   }
}
