package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0600 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      if (!bl) {
         super.setBackground(Color.WHITE);
      }

      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      Player var7 = (Player)object;
      if (GamePersistence.SR.isUsaCoresLista()) {
         Color[] var8 = GamePersistence.SR.getCoresLista();
         if (!bl) {
            super.setBackground(var8[var7.getPosicao()]);
         }
      }

      if (j == 0) {
         this.setHorizontalAlignment(0);
         if (var7.fn() > 0) {
            this.setText(Integer.toString(var7.fn()));
            if (!bl) {
               if (var7.fg() != null) {
                  this.setForeground(var7.fg().kC());
               }

               if (var7.fg() != null) {
                  this.setBackground(var7.fg().kB());
               }
            }
         }
      }

      if (j == 1) {
         this.setHorizontalAlignment(0);
         this.setText(GameConstants.rI[var7.getPosicao()]);
      }

      if (j == 2) {
         this.setHorizontalAlignment(2);
         this.setIcon(var7.fS());
      }

      if (j == 3) {
         this.setHorizontalAlignment(2);
         this.setText(var7.getNome());
         if (var7.gl() && !C0272.rC()) {
            this.setText("<html><b>" + var7.getNome() + "</b></html>");
         }

         if (var7.fz() && !C0272.rC()) {
            this.setText("<html><b>" + var7.getNome() + "</b></html>");
            super.setForeground(new Color(13, 37, 124));
         }

         if (var7.gG() < 0 && !C0272.rC()) {
            super.setForeground(new Color(127, 4, 30));
            this.setText("<html><b>&nbsp;" + var7.getNome() + "</b></html>");
         }

         if (C0272.rD() != null && var7.c(C0272.rD())) {
            super.setForeground(new Color(173, 79, 3));
         }

         if (var7.gm()) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrelared.png")));
         } else if (var7.ff()) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrela.png")));
         }
      }

      if (j == 4) {
         this.setHorizontalAlignment(0);
         this.setText(GameConstants.rK[var7.getLado()]);
      }

      if (!GamePersistence.SR.isHabilidadeIndividual()) {
         if (j == 5) {
            this.setText(Integer.toString(var7.fi()));
         } else {
            if (j == 6) {
               return var7.a(C0272.rA());
            }

            if (j == 7) {
               if (!C0272.rC() && var7.gG() < 30) {
                  super.setForeground(new Color(127, 4, 30));
                  this.setText("<html><b>&nbsp;" + ClubFinances.a(var7.fj(), 0) + "</b></html>");
               } else {
                  this.setText("  " + ClubFinances.a(var7.fj(), 0));
               }
            } else if (j == 8) {
               this.setText(ClubFinances.a(var7.fk(), 0));
               if (var7.ft()) {
                  super.setForeground(new Color(29, 163, 51));
               }
            } else if (j == 9) {
               this.setText(Integer.toString(var7.gA()));
            } else if (j == 10) {
               String var10 = "";
               String var9 = "";
               if (var7.getCr1() < GameConstants.qN.length) {
                  var10 = GameConstants.qN[var7.getCr1()];
               }

               if (var7.getCr2() < GameConstants.qN.length) {
                  var9 = GameConstants.qN[var7.getCr2()];
               }

               this.setText(var10 + "/" + var9);
            } else if (j == 11) {
               this.setText(Integer.toString(var7.getIdade()));
               if (var7.getIdade() > 32) {
                  super.setForeground(new Color(127, 4, 30));
               } else {
                  super.setForeground(new Color(13, 37, 124));
               }
            } else if (j == 12) {
               this.setText(Integer.toString(var7.gy()));
            } else if (j == 13) {
               this.setText(Integer.toString(var7.gs()));
            } else if (j == 14) {
               String var11 = var7.gn();
               Double var13 = var7.F();
               if (var13 < 5.0 && var13 >= 2.0) {
                  super.setForeground(new Color(120, 7, 31));
               } else if (var13 > 7.0) {
                  super.setForeground(new Color(56, 121, 12));
               }

               this.setText(var11);
            }
         }
      } else if (j == 5) {
         this.setText(Integer.toString(var7.gK()));
      } else if (j == 6) {
         this.setText(Integer.toString(var7.gN()));
      } else if (j == 7) {
         this.setText(Integer.toString(var7.gO()));
      } else if (j == 8) {
         this.setText(Integer.toString(var7.gP()));
      } else if (j == 9) {
         this.setText(Integer.toString(var7.gJ()));
      } else if (j == 10) {
         this.setText(Integer.toString(var7.gL()));
      } else if (j == 11) {
         this.setText(Integer.toString(var7.gM()));
      } else {
         if (j == 12) {
            return var7.a(C0272.rA());
         }

         if (j == 13) {
            if (!C0272.rC() && var7.gG() < 30) {
               super.setForeground(new Color(127, 4, 30));
               this.setText("<html><b>&nbsp;" + ClubFinances.a(var7.fj(), 0) + "</b></html>");
            } else {
               this.setText("  " + ClubFinances.a(var7.fj(), 0));
            }
         } else if (j == 14) {
            this.setText(ClubFinances.a(var7.fk(), 0));
            if (var7.ft()) {
               super.setForeground(new Color(29, 163, 51));
            }
         } else if (j == 15) {
            this.setText(Integer.toString(var7.gA()));
         } else if (j == 16) {
            this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
         } else if (j == 17) {
            this.setText(Integer.toString(var7.getIdade()));
            if (var7.getIdade() > 32) {
               super.setForeground(new Color(127, 4, 30));
            } else {
               super.setForeground(new Color(13, 37, 124));
            }
         } else if (j == 18) {
            this.setText(Integer.toString(var7.gy()));
         } else if (j == 19) {
            this.setText(Integer.toString(var7.fi()));
            this.setText(Integer.toString(var7.gs()));
         } else if (j == 20) {
            String var12 = var7.gn();
            Double var14 = var7.F();
            if (var14 < 5.0 && var14 >= 2.0) {
               super.setForeground(new Color(120, 7, 31));
            } else if (var14 > 7.0) {
               super.setForeground(new Color(56, 121, 12));
            }

            this.setText(var12);
         }
      }

      return this;
   }
}
