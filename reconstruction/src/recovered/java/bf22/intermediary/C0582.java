package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0582 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static int SE = 1;
   private C0272 SN = null;
   public static Comparator KZ = new C0583();

   public C0582(Club club, C0272 c0272) {
      this.SN = c0272;
      this.vp = club.getSeniorPlayers();

      for (int var3 = 0; var3 < this.vp.size(); var3++) {
         ((Player)this.vp.get(var3)).a((ImageIcon)null);
      }

      Collections.sort(this.vp, C1007.abe);
      this.Nt = new String[]{"", "P", "", "Nome", "L", "F", "Energia", "Salário", "Passe", "G", "Car.", "Idade", "GC", "A", "NM"};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         this.Nt = new String[]{
            "", "P", "", "Nome", "L", "Gol", "Des", "Arm", "Fin", "Vel", "Tec", "Pas", "Energia", "Salário", "Valor", "G", "Car.", "Idade", "GC", "A", "NM"
         };
      }

      if (this.vp.size() > 0) {
         this.et(0);
      }
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.vp.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.vp.size() > 0 ? this.vp.get(i) : null;
   }

   public void et(int i) {
      this.SN.s((Player)this.vp.get(i));
   }

   public Object Y(int i, int j) {
      if (j != 0) {
         if (j == 1) {
            return GameConstants.rI[((Player)this.vp.get(i)).getPosicao()];
         }

         if (j != 2) {
            if (j == 3) {
               return ((Player)this.vp.get(i)).getNome();
            }

            if (j == 4) {
               return GameConstants.rK[((Player)this.vp.get(i)).getLado()];
            }

            if (j == 5) {
               return ((Player)this.vp.get(i)).getOverallStrength();
            }

            if (j == 6) {
               return ((Player)this.vp.get(i)).getEnergy();
            }

            if (j == 7) {
               return ClubFinances.a(((Player)this.vp.get(i)).getSalary(), 0);
            }

            if (j == 8) {
               return ClubFinances.a(((Player)this.vp.get(i)).getMarketValue(), 0);
            }

            if (j != 9) {
               if (j == 10) {
                  return GameConstants.qN[((Player)this.vp.get(i)).getCr1()] + "/" + GameConstants.qN[((Player)this.vp.get(i)).getCr2()];
               }

               if (j == 11) {
                  return ((Player)this.vp.get(i)).getIdade();
               }

               if (j == 12) {
                  return 0;
               }
            }
         }
      }

      return null;
   }

   @Override
   public String getColumnName(int i) {
      return this.Nt[i];
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }

   public ArrayList uH() {
      return this.vp;
   }

   static int vG() {
      return SE;
   }
}
