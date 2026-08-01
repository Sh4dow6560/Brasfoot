package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class C0642 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0809 var7 = (C0809)object;
      if (object != null) {
         if (var7.sZ()) {
            ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aicons/escudo2.png"));
            if (!var7.sS()) {
               if (var7.sR()) {
                  if (j == 0) {
                     this.setHorizontalAlignment(4);
                     this.setIcon(var8);
                  } else if (j == 1) {
                     this.setText("x");
                  } else if (j == 2) {
                     this.setHorizontalAlignment(2);
                     this.setIcon(var8);
                  } else if (j == 3) {
                     this.setText(var7.sU());
                  } else if (j == 4 && var7.sX() != null) {
                     this.setHorizontalAlignment(4);
                     this.setIcon(var8);
                  } else if (j == 5 && var7.sX() != null) {
                     this.setText("x");
                  } else if (j == 6 && var7.sY() != null) {
                     this.setHorizontalAlignment(2);
                     this.setIcon(var8);
                  }
               } else {
                  MatteBorder var9 = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
                  this.setBorder(var9);
                  if (j == 0) {
                     this.setHorizontalAlignment(4);
                     this.setText(var7.sV());
                  } else if (j == 2) {
                     this.setHorizontalAlignment(2);
                     this.setText(var7.sW());
                  } else if (j == 4 && var7.sX() != null) {
                     this.setHorizontalAlignment(4);
                     this.setText(var7.sX());
                  } else if (j == 6 && var7.sY() != null) {
                     this.setHorizontalAlignment(2);
                     this.setText(var7.sY());
                  }
               }
            } else if (j == 0) {
               this.setText(var7.sT());
            }
         } else if (!var7.sS()) {
            if (var7.sR()) {
               if (j == 0) {
                  this.setHorizontalAlignment(4);
                  this.setIcon(var7.sP().getHomeClub().a(25, 25, true));
               } else if (j == 2) {
                  this.setHorizontalAlignment(2);
                  this.setIcon(var7.sP().getAwayClub().a(25, 25, true));
               } else if (j == 3) {
                  this.setText(var7.sU());
               }

               if (var7.sP().e()) {
                  if (j == 1) {
                     String var12 = "";
                     var12 = Integer.toString(var7.sP().getHomeGoals());
                     String var17 = "";
                     var17 = Integer.toString(var7.sP().getAwayGoals());
                     this.setText(var12 + "x" + var17);
                  }
               } else if (j == 1) {
                  this.setText("x");
               }

               if (var7.sQ() != null) {
                  if (j == 4) {
                     this.setHorizontalAlignment(4);
                     this.setIcon(var7.sQ().getHomeClub().a(25, 25, true));
                  } else if (j == 6) {
                     this.setHorizontalAlignment(2);
                     this.setIcon(var7.sQ().getAwayClub().a(25, 25, true));
                  }

                  if (var7.sQ().e()) {
                     if (j == 5) {
                        String var14 = "";
                        var14 = Integer.toString(var7.sQ().getHomeGoals());
                        String var19 = "";
                        var19 = Integer.toString(var7.sQ().getAwayGoals());
                        this.setText(var14 + "x" + var19);
                     }
                  } else if (j == 5) {
                     this.setText("x");
                  }
               }
            } else {
               MatteBorder var16 = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
               this.setBorder(var16);
               if (j == 0) {
                  this.setHorizontalAlignment(4);
                  this.setText(var7.sP().getHomeClub().getNome());
               } else if (j == 1 && var7.sP().e()) {
                  int[] var21 = var7.sP().hQ();
                  if (var21[0] >= 0 && var21[1] >= 0) {
                     String var10 = "P:" + Integer.toString(var21[0]);
                     String var11 = Integer.toString(var21[1]);
                     this.setText(var10 + " x " + var11);
                  }
               } else if (j == 2) {
                  this.setHorizontalAlignment(2);
                  this.setText(var7.sP().getAwayClub().getNome());
               }

               if (var7.sQ() != null) {
                  if (j == 4) {
                     this.setHorizontalAlignment(4);
                     this.setText(var7.sQ().getHomeClub().getNome());
                  } else if (j == 5 && var7.sQ().e()) {
                     int[] var22 = var7.sQ().hQ();
                     if (var22[0] >= 0 && var22[1] >= 0) {
                        String var23 = "P:" + Integer.toString(var22[0]);
                        String var24 = Integer.toString(var22[1]);
                        this.setText(var23 + " x " + var24);
                     }
                  } else if (j == 6) {
                     this.setHorizontalAlignment(2);
                     this.setText(var7.sQ().getAwayClub().getNome());
                  }
               }
            }
         } else if (j == 0) {
            this.setText(var7.sT());
         }
      }

      return this;
   }
}
