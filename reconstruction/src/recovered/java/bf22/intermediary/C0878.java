package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class C0878 extends AbstractTableModel implements TableModelListener {
   private String[] Nt;
   private static ArrayList vp = new ArrayList();
   private static int SE = 0;
   private static int VO = 0;
   private static int VP = 0;
   private static int VQ = 0;
   public static Comparator KZ = new C0879();
   public static Comparator VR = new C0880();
   public static Comparator VS = new C0881();
   public static Comparator VT = new C0882();
   public static Comparator VU = new C0883();

   public C0878() {
      if (C0732.da() != null && C0732.da().wI() != null) {
         if (C0732.da().wK()) {
            vp = C0732.da().wI().getJogadores();
            Collections.sort(vp, VR);
         } else {
            vp = C0732.da().wI().getJuniores();
            Collections.sort(vp, VR);
         }
      }

      this.Nt = new String[]{"", "", "Nome", "Posicao", "Pais", "idade", "Carac.", "Lado"};
   }

   public void Z(int i, int j) {
      if (((C0914)vp.get(i)).getStatus() == 0) {
         if (j < 15) {
            ((C0914)vp.get(i)).setStatus(1);
         }
      } else if (((C0914)vp.get(i)).getStatus() == 1) {
         ((C0914)vp.get(i)).setStatus(0);
      }
   }

   public void xg() {
   }

   public void xh() {
   }

   public void et(int i) {
      C0732.da().a((C0914)vp.get(i));
   }

   public void eI(int i) {
      try {
         vp.remove(i);
      } catch (Exception var3) {
      }
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return vp.size();
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }

   @Override
   public Object getValueAt(int i, int j) {
      if (vp.size() == 0) {
         return null;
      }

      C0914 var3 = (C0914)vp.get(i);
      if (j == 0) {
         return var3.getStatus();
      }

      if (j == 1) {
         if (var3.isTopMundial()) {
            return 2;
         } else {
            return var3.isEstrela() ? 1 : 0;
         }
      } else if (j == 2) {
         return var3.getNome();
      } else if (j == 3) {
         return GameConstants.rH[var3.getPosicao()];
      } else if (j == 4) {
         return Integer.toString(var3.getPais());
      } else if (j == 5) {
         return var3.getIdade();
      } else if (j == 6) {
         return GameConstants.qN[var3.getCr1()] + "/" + GameConstants.qN[var3.getCr2()];
      } else {
         return j == 7 ? GameConstants.rK[var3.getLado()] : null;
      }
   }

   public void i(int i, boolean bl) {
      if (i == 0) {
         Collections.sort(vp, VT);
         if (VO == 0) {
            VO = -1;
         } else if (VO == -1) {
            VO = 0;
         }
      } else if (i == 2) {
         Collections.sort(vp, VS);
         if (VP == 0) {
            VP = -1;
         } else if (VP == -1) {
            VP = 0;
         }
      } else if (i == 3) {
         Collections.sort(vp, KZ);
         if (bl) {
            SE = -1;
         } else if (SE == 0) {
            SE = -1;
         } else if (SE == -1) {
            SE = 0;
         }
      } else if (i == 5) {
         Collections.sort(vp, VU);
         if (VQ == 0) {
            VQ = -1;
         } else if (VQ == -1) {
            VQ = 0;
         }
      }
   }

   @Override
   public String getColumnName(int i) {
      return this.Nt[i];
   }

   @Override
   public void tableChanged(TableModelEvent tableModelEvent) {
   }

   static int vG() {
      return SE;
   }

   static int xi() {
      return VP;
   }

   static int xj() {
      return VO;
   }

   static int xk() {
      return VQ;
   }
}
