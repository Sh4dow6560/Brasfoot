package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class C0887 extends AbstractTableModel {
   private String[] Nt;
   private static ArrayList cE;
   private static int VV = 0;
   private static int VP = 0;
   private static int VW = 0;
   private static int VX = 0;
   private static int VY = 0;
   private static int VZ = 0;
   public static Comparator cN = new C0888();
   public static Comparator cL = new C0859();
   public static Comparator VS = new C0860();

   public C0887() {
      cE = C0732.cZ();
      this.Nt = new String[]{"Time", "Pais", "Nivel"};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return cE.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return cE.size() > 0 ? cE.get(i) : null;
   }

   @Override
   public String getColumnName(int i) {
      return this.Nt[i];
   }

   public void removeRow(int i) {
      cE.remove(i);
   }

   public void ai(String string) {
      boolean var2 = false;
      if (VX > cE.size()) {
         VX = 0;
      }

      for (int var3 = VX; var3 < cE.size(); var3++) {
         if (string.length() <= ((C0915)cE.get(var3)).getNome().length()
            && string.equalsIgnoreCase(C0670.f(((C0915)cE.get(var3)).getNome()).substring(0, string.length()))) {
            int var4 = C0732.da().wO().convertRowIndexToView(var3);
            C0732.da().wO().changeSelection(var4, 0, true, true);
            C0732.da().wO().setRowSelectionInterval(var4, var4);
            VX = var3 + 1;
            var2 = true;
            break;
         }
      }

      if (!var2) {
         VX = 0;
      }
   }

   public void aj(String string) {
      boolean var2 = false;
      if (VX > cE.size()) {
         VX = 0;
      }

      for (int var3 = VX; var3 < cE.size(); var3++) {
         if (string.length() <= ((C0915)cE.get(var3)).getNome().length()
            && string.equalsIgnoreCase(C0670.f(((C0915)cE.get(var3)).getNome()).substring(0, string.length()))) {
            C0732.da().wS().xe().changeSelection(var3, 0, true, true);
            C0732.da().wS().xe().setRowSelectionInterval(var3, var3);
            VX = var3 + 1;
            var2 = true;
            break;
         }
      }

      if (!var2) {
         VX = 0;
      }
   }

   public void ak(String string) {
      boolean var2 = false;
      if (VY > cE.size()) {
         VY = 0;
      }

      for (int var3 = VY; var3 < cE.size(); var3++) {
         if (VZ > ((C0915)cE.get(var3)).getJogadores().size()) {
            VZ = 0;
         }

         for (int var4 = VZ; var4 < ((C0915)cE.get(var3)).getJogadores().size(); var4++) {
            if (string.length() <= ((C0914)((C0915)cE.get(var3)).getJogadores().get(var4)).getNome().length()
               && string.equalsIgnoreCase(C0670.f(((C0914)((C0915)cE.get(var3)).getJogadores().get(var4)).getNome()).substring(0, string.length()))) {
               int var5 = C0732.da().wO().convertRowIndexToView(var3);
               C0732.da().wO().changeSelection(var5, 0, true, true);
               C0732.da().wO().setRowSelectionInterval(var5, var5);
               C0732.da().wJ().changeSelection(var4, 0, true, true);
               C0732.da().wJ().setRowSelectionInterval(var4, var4);
               VZ = var4 + 1;
               VY = var3;
               if (var4 + 1 > ((C0915)cE.get(var3)).getJogadores().size()) {
                  VY = var3 + 1;
                  VZ = 0;
               }

               var2 = true;
               break;
            }
         }

         if (var2) {
            break;
         }

         VZ = 0;
         VY++;
      }

      if (!var2) {
         VY = 0;
      }
   }

   public void eJ(int i) {
      C0732.da().wS().e((C0915)cE.get(i));
   }

   public void et(int i) {
      C0732.da().d((C0915)cE.get(i));
      C0732.da().wE();
      C0878 var2 = new C0878();
      C0732.da().wJ().setModel(var2);
      C0732.da().wH();
      if (C0732.da().wI().getJogadores().size() > 0) {
         C0732.da().wJ().setRowSelectionInterval(0, 0);
      } else {
         C0732.da().a((C0914)null);
      }

      C0732.da().wQ().setIcon(new ImageIcon(this.getClass().getResource("/aicons/greencheck.png")));
      C0732.da().wP().setIcon(null);
   }

   public void eK(int i) {
      if (i == 0) {
         Collections.sort(cE, VS);
         if (VP == 0) {
            VP = -1;
         } else if (VP == -1) {
            VP = 0;
         }
      }

      if (i == 1) {
         Collections.sort(cE, cL);
         if (VV == 0) {
            VV = -1;
         } else if (VV == -1) {
            VV = 0;
         }
      } else if (i == 2) {
         Collections.sort(cE, cN);
         if (VW == 0) {
            VW = -1;
         } else if (VW == -1) {
            VW = 0;
         }
      }
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i).getClass();
   }

   public static void eL(int i) {
      VX = i;
   }

   static int vG() {
      return VW;
   }

   static int xi() {
      return VV;
   }

   static int xj() {
      return VP;
   }
}
