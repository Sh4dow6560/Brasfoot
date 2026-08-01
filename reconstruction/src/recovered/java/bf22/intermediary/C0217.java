package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0217 extends JPanel {
   private JDialog ub;
   private Club Em = null;
   private ArrayList En = new ArrayList();
   private int Eo = 0;
   private int Ep = 0;
   private JButton vm;
   private JScrollPane ut;
   private JLabel vf;
   private JTable Eq;

   public C0217(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.Em = club;
      this.mJ();
      this.pw();
      this.px();
      this.mH();
      this.vf.setText("Galeria de Troféus - " + club.getNome());
      this.vf.setIcon(club.kU());
      this.setBackground(club.kB());
      this.vf.setForeground(club.kC());
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   public int[] pt() {
      return new int[]{this.En.size(), this.Ep};
   }

   private void mH() {
      this.vm.addActionListener(new C0218(this));
   }

   public static void pu() {
      C0745.ey(1920);
   }

   public static void pv() {
   }

   private void pw() {
      C0665 var1 = new C0665(this.En);
      this.Eq.setModel(var1);
      this.Eq.setTableHeader(null);
      this.Eo = var1.getColumnCount();

      for (int var2 = 0; var2 < var1.getColumnCount(); var2++) {
         this.Eq.getColumnModel().getColumn(var2).setPreferredWidth(150);
      }

      this.Eq.setAutoResizeMode(3);
      this.Eq.setRowHeight(170);
      this.Eq.setShowGrid(false);
      this.Eq.setDefaultRenderer(C0790.class, new C0636());
      this.Eq.setAutoCreateRowSorter(false);
      this.Eq.setIntercellSpacing(new Dimension(0, 0));
      this.Eq.setCellSelectionEnabled(false);
      this.Eq.setRowSelectionAllowed(false);
      this.Eq.setFillsViewportHeight(true);
   }

   private void px() {
      this.En.clear();
      int[] var1 = new int[12];
      if (this.Em.cT().size() > 0) {
         for (int var2 = 0; var2 < this.Em.cT().size(); var2++) {
            if (((C0708)this.Em.cT().get(var2)).b() > 0 && ((C0708)this.Em.cT().get(var2)).b() < var1.length) {
               var1[((C0708)this.Em.cT().get(var2)).b()]++;
            }
         }

         for (int var5 = 1; var5 < var1.length; var5++) {
            if (var1[var5] > 0) {
               if (var5 != 5 && var5 != 2 && var5 != 11) {
                  int[] var3 = new int[8];

                  for (int var4 = 0; var4 < this.Em.cT().size(); var4++) {
                     if (((C0708)this.Em.cT().get(var4)).b() == var5
                        && ((C0708)this.Em.cT().get(var4)).el() >= 0
                        && ((C0708)this.Em.cT().get(var4)).el() < var3.length) {
                        var3[((C0708)this.Em.cT().get(var4)).el()]++;
                     }
                  }

                  for (int var6 = 0; var6 < var3.length; var6++) {
                     if (var3[var6] > 0) {
                        this.g(var5, var6, var3[var6]);
                     }
                  }
               } else {
                  this.g(var5, -1, var1[var5]);
               }
            }
         }
      }

      this.Eq.addNotify();
   }

   private String a(C0708 c0708) {
      String[][] var2 = new String[][]{
         {"", ""},
         {"tr_nacional", "tr_nacionalgenerico"},
         {"tr_copa"},
         {"tr_estadualgenerico", "tr_estadualgenerico"},
         {"tr_ligacampeoes", "tr_libertadores", "tr_ligacaf", "tr_ligaafc", "tr_ligaconcacaf", "tr_ligaofc"},
         {"tr_mundial"},
         {"tr_ligaeuropa", "tr_sulamericana"},
         {""},
         {"tr_recopaeuropa", "tr_recopasulamaericana"},
         {"tr_recopaeuropa", "tr_recopasulamaericana"},
         {"tr_riosaopaulo", "tr_sulminas", "tr_copanordeste", "tr_copaverde", "tr_nacionalgenerico"},
         {"tr_supercopa"}
      };
      int var3 = c0708.b();
      int var4 = c0708.el();
      String var5 = "";
      if (var3 == 1) {
         if (var4 == 1) {
            int var11 = -1;
            if (c0708.ct() >= 0) {
               var11 = C0745.SR.x(c0708.ct()).getPais();
            }

            String var14 = var2[1][0] + "_" + C0696.valueOf("P" + Integer.toString(var11)).jA();
            return this.w(var14) ? var14 : var2[1][0];
         } else {
            return var2[1][1];
         }
      } else if (var3 == 2) {
         int var10 = -1;
         if (c0708.ct() >= 0) {
            var10 = C0745.SR.x(c0708.ct()).getPais();
         }

         String var13 = var2[2][0] + "_" + C0696.valueOf("P" + Integer.toString(var10)).jA();
         return this.w(var13) ? var13 : var2[2][0];
      } else if (var3 == 11) {
         int var9 = -1;
         if (c0708.ct() >= 0) {
            var9 = C0745.SR.x(c0708.ct()).getPais();
         }

         String var12 = var2[11][0] + "_" + C0696.valueOf("P" + Integer.toString(var9)).jA();
         return this.w(var12) ? var12 : var2[11][0];
      } else if (var3 == 3) {
         if (var4 == 1) {
            int var8 = -1;
            if (c0708.ct() >= 0) {
               var8 = C0745.SR.x(c0708.ct()).getEstado();
            }

            String var7 = "tr_estadual_" + C0710.rX[var8];
            return this.w(var7) ? var7 : var2[3][0];
         } else {
            return var2[3][1];
         }
      } else if (var3 == 4 || var3 == 6 || var3 == 8) {
         return var2[var3][var4];
      } else if (var3 == 10) {
         String var6 = var2[var3][var4];
         return this.w(var6) ? var6 : var2[10][4];
      } else {
         return var2[var3][0];
      }
   }

   private boolean w(String string) {
      File var2 = new File(System.getProperty("user.dir") + "/trofeus/" + string + ".png");
      return var2.exists() && !var2.isDirectory();
   }

   private void b(C0708 c0708) {
      if (this.En.size() == 0) {
         C0790 var2 = new C0790();
         this.En.add(var2);
         this.Ep = 0;
      } else if (this.Ep >= this.Eo) {
         C0790 var6 = new C0790();
         this.En.add(var6);
         this.Ep = 0;
      }

      int var7 = this.En.size() - 1;
      C0790 var3 = (C0790)this.En.get(var7);
      var3.d(c0708.gS().getNome(), this.Ep);
      String var4 = System.getProperty("user.dir") + "/trofeus/" + this.a(c0708) + ".png";
      var3.e(var4, this.Ep);
      int var5 = 0;
      if (c0708.b() != 1 && c0708.b() != 3) {
         var5 = this.L(c0708.b(), -1);
      } else {
         var5 = this.L(c0708.b(), c0708.el());
      }

      var3.R(var5, this.Ep);
      this.Ep++;
   }

   private int L(int i, int j) {
      int var3 = 0;

      for (int var4 = 0; var4 < this.Em.cT().size(); var4++) {
         if (j >= 0) {
            if (((C0708)this.Em.cT().get(var4)).ct() >= 0 && ((C0708)this.Em.cT().get(var4)).b() == i && ((C0708)this.Em.cT().get(var4)).el() == j) {
               var3++;
            }
         } else if (((C0708)this.Em.cT().get(var4)).ct() >= 0 && ((C0708)this.Em.cT().get(var4)).b() == i) {
            var3++;
         }
      }

      return var3;
   }

   private void g(int i, int j, int k) {
      boolean var4 = true;
      if (i != 1 && i != 3) {
         int[] var9 = new int[C0696.jz()];

         for (int var10 = 0; var10 < this.Em.cT().size(); var10++) {
            if (((C0708)this.Em.cT().get(var10)).ct() >= 0 && ((C0708)this.Em.cT().get(var10)).b() == i && var4) {
               this.b((C0708)this.Em.cT().get(var10));
               var4 = false;
               break;
            }
         }
      } else {
         int[] var5 = new int[C0696.jz()];

         for (int var6 = 0; var6 < this.Em.cT().size(); var6++) {
            if (((C0708)this.Em.cT().get(var6)).ct() >= 0 && ((C0708)this.Em.cT().get(var6)).b() == i && ((C0708)this.Em.cT().get(var6)).el() == j && var4) {
               this.b((C0708)this.Em.cT().get(var6));
               var4 = false;
               break;
            }
         }
      }
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ut = new JScrollPane();
      this.Eq = new JTable();
      this.vm = new JButton();
      this.setBackground(new Color(204, 204, 204));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setText("Galeria de Trofeus");
      this.ut.setViewportView(this.Eq);
      this.vm.setText("X");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.ut, -1, 647, 32767)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.vf)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 51, -2)
                        )
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vf).addComponent(this.vm))
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -1, 301, 32767)
                  .addContainerGap()
            )
      );
   }
}
