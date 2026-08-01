package bf22.intermediary;

import mod.recovered.competition.NationalCup;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.NationalSuperCup;
import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.Competition;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class C0625 extends JLabel implements ListCellRenderer {
   private int w = 0;

   public C0625(int i) {
      this.w = i;
   }

   public C0625() {
   }

   @Override
   public Component getListCellRendererComponent(JList jList, Object object, int i, boolean bl, boolean bl2) {
      this.setIcon(null);
      if (bl) {
         this.setBackground(Color.YELLOW);
         this.setForeground(jList.getSelectionForeground());
      } else {
         this.setBackground(jList.getBackground());
         this.setForeground(jList.getForeground());
      }

      if (object != null && object instanceof StateChampionship) {
         StateChampionship var11 = (StateChampionship)object;
         this.setIcon(new ImageIcon(this.getClass().getResource("/aesticons/" + var11.yk() + ".png")));
         String var14 = var11.getNome();
         this.setText(var14);
      } else if (object != null && object instanceof NationalCup) {
         NationalCup var10 = (NationalCup)object;
         String var13 = var10.getNome();
         this.setText(var13);
         this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + var10.yg().jc() + ".png")));
      } else if (object != null && object instanceof NationalLeague) {
         NationalLeague var9 = (NationalLeague)object;
         String var12 = var9.getNome();
         this.setText(var12);
         this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + var9.zO() + ".png")));
      } else if (object != null && object instanceof NationalSuperCup) {
         String var8 = "Supercopa";
         this.setText(var8);
         this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_ligas.png")));
      } else if (object != null) {
         Competition var6 = (Competition)object;
         String var7 = var6.getNome();
         this.setText(var7);
         this.setIcon(var6.es());
         if (this.w == 1 && var6.b() == 15) {
            this.setText("Torneio Amistoso");
         }
      }

      return this;
   }
}
