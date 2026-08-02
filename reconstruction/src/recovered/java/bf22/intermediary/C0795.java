package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0795 {
   private Player U = null;
   private ImageIcon RC = null;
   private Club cg = null;
   private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
   private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat.png"));
   private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag.png"));
   private static int RD = 435;
   private static int RE = 210;
   private static int RF = 580;
   private static int RG = 410;
   private static ArrayList RH = new ArrayList();
   private static ArrayList RI = new ArrayList();
   private static int[][] RJ = new int[][]{
      {-1, -1},
      {190, 565},
      {35, 425},
      {100, 485},
      {190, 485},
      {285, 485},
      {100, 405},
      {190, 405},
      {285, 405},
      {345, 425},
      {35, 265},
      {100, 315},
      {190, 315},
      {285, 315},
      {100, 205},
      {190, 205},
      {285, 205},
      {345, 265},
      {35, 55},
      {100, 115},
      {190, 115},
      {285, 115},
      {100, 35},
      {190, 30},
      {285, 35},
      {345, 55},
      {470, 30},
      {558, 30},
      {655, 30},
      {755, 30},
      {855, 30},
      {950, 30},
      {470, 105},
      {558, 105},
      {655, 105},
      {755, 105},
      {855, 105}
   };
   private static int[][] RK = new int[][]{
      {-1, -1},
      {190, 565},
      {35, 425},
      {100, 485},
      {190, 485},
      {285, 485},
      {100, 405},
      {190, 405},
      {285, 405},
      {345, 425},
      {35, 270},
      {100, 315},
      {190, 315},
      {285, 315},
      {100, 205},
      {190, 205},
      {285, 205},
      {345, 270},
      {35, 55},
      {100, 115},
      {190, 115},
      {285, 115},
      {100, 35},
      {190, 30},
      {285, 35},
      {345, 55},
      {20, 25},
      {115, 35},
      {20, 125},
      {115, 135},
      {20, 210},
      {115, 220},
      {20, 305},
      {115, 315},
      {20, 400},
      {115, 410},
      {20, 495}
   };
   private static int[][] RL = new int[][]{
      {-1, -1},
      {200, 489},
      {76, 376},
      {135, 422},
      {202, 421},
      {273, 421},
      {131, 356},
      {202, 356},
      {277, 356},
      {328, 377},
      {76, 243},
      {131, 276},
      {199, 276},
      {275, 276},
      {128, 188},
      {201, 188},
      {276, 188},
      {323, 247},
      {68, 62},
      {129, 107},
      {203, 107},
      {276, 107},
      {127, 37},
      {200, 37},
      {280, 37},
      {331, 64},
      {10, 480},
      {10, 400},
      {10, 320},
      {10, 240},
      {10, 160},
      {10, 84},
      {10, 1}
   };
   private static int[][] RM;

   public Player x() {
      return this.U;
   }

   public void a(Player player) {
      this.U = player;
   }

   public ImageIcon vf() {
      return this.RC;
   }

   public void h(ImageIcon imageIcon) {
      this.RC = imageIcon;
   }

   public static int S(int i, int j) {
      for (int var2 = 1; var2 <= 36; var2++) {
         if (i >= RJ[var2][0] && i <= RJ[var2][0] + 60 && j >= RJ[var2][1] && j <= RJ[var2][1] + 60) {
            return var2;
         }
      }

      return -1;
   }

   public static int T(int i, int j) {
      for (int var2 = 1; var2 <= 36; var2++) {
         int var3 = RK[var2][0];
         int var4 = RK[var2][1];
         if (var2 <= 25) {
            var3 += 200;
            var4 += 10;
         }

         if (i >= var3 && i <= var3 + 50 && j >= var4 && j <= var4 + 50) {
            return var2;
         }
      }

      return -1;
   }

   public static int U(int i, int j) {
      byte var2 = 37;

      for (int var3 = 0; var3 < RH.size(); var3++) {
         if (i >= (Integer)RH.get(var3) - 20 && i <= (Integer)RH.get(var3) + 70 && j >= (Integer)RI.get(var3) && j <= (Integer)RI.get(var3) + 80) {
            return var3 + var2;
         }
      }

      return -1;
   }

   public static boolean V(int i, int j) {
      return i >= 0 && i <= 434 && j >= 0 && j <= 640 ? true : i >= 440 && i <= 1020 && j >= 20 && j <= 180;
   }

   public static boolean W(int i, int j) {
      return i >= 200 && i <= 640 && j >= 0 && j <= 650 ? true : i >= 10 && i <= 200 && j >= 20 && j <= 650;
   }

   public static boolean X(int i, int j) {
      return i >= RD && i <= RD + RF && j >= 10 && j <= RE + RG;
   }

   public ImageIcon a(ArrayList arrayList, int i, ImageIcon imageIcon, boolean bl, int j, Club club, int k) {
      Image var9 = this.AH.getImage();
      Image var10 = imageIcon.getImage();
      ImageIcon var11 = new ImageIcon(this.getClass().getResource("/aeicons/ect.png"));
      Image var12 = var11.getImage();
      ImageIcon var13 = new ImageIcon(this.getClass().getResource("/aicons/kicker.png"));
      Image var14 = var13.getImage();
      ImageIcon var15 = new ImageIcon(this.getClass().getResource("/aicons/captain.png"));
      Image var16 = var15.getImage();
      ImageIcon var17 = new ImageIcon(this.getClass().getResource("/aicons/escanteiosicone.png"));
      Image var18 = var17.getImage();
      ImageIcon var19 = new ImageIcon(this.getClass().getResource("/aicons/falsonove.png"));
      Image var20 = var19.getImage();
      short var21 = 480;
      short var22 = 679;
      if (k == 1) {
         var21 = 580;
         var22 = 160;
      }

      if (k == 3) {
         var21 = 200;
         var22 = 650;
      }

      if (bl) {
         var21 = 390;
         var22 = 566;
      }

      BufferedImage var23 = new BufferedImage(var21, var22, 2);
      Graphics2D var24 = var23.createGraphics();
      byte var25 = 1;
      byte var26 = 25;
      if (k == 1 || k == 3) {
         var25 = 26;
         var26 = 36;
      }

      for (int var27 = var25; var27 <= var26; var27++) {
         if (((C0795)arrayList.get(var27)).vf() != null && var27 != i) {
            if (var27 == 1) {
               var9 = this.AI.getImage();
            } else if (var27 <= 25) {
               if (((C0795)arrayList.get(var27)).x() != null) {
                  var9 = var10;
               } else {
                  var9 = this.AH.getImage();
               }
            } else if (var27 > 25) {
               if (((C0795)arrayList.get(var27)).x() != null) {
                  if (((C0795)arrayList.get(var27)).x().getPosicao() == 0) {
                     var9 = this.AI.getImage();
                  } else {
                     var9 = var10;
                  }
               } else {
                  var9 = this.AH.getImage();
               }
            }

            int var28 = RJ[var27][0];
            int var29 = RJ[var27][1];
            if (k == 1) {
               var28 = RJ[var27][0] - 450;
               var29 = RJ[var27][1] - 30;
            }

            if (k == 2) {
               var28 = RJ[var27][0];
               var29 = RJ[var27][1];
            }

            if (k == 3) {
               var28 = RK[var27][0];
               var29 = RK[var27][1];
            }

            if (bl) {
               var28 = RK[var27][0];
               var29 = RK[var27][1];
            }

            var24.drawImage(var9, var28, var29, null);
            if (((C0795)arrayList.get(var27)).x() != null) {
               var24.setFont(new Font("Arial", 1, 11));
               var24.setFont(var24.getFont().deriveFont(11.0F));
               var24.drawImage(a(((C0795)arrayList.get(var27)).x(), 1, var27, ""), var28 - 52, var29 + 47, null);
               if (((C0795)arrayList.get(var27)).x().fP()) {
                  var24.drawImage(var12, var28 - 15, var29 + 30, null);
               }

               if (var27 < 26) {
                  if (club.ke() == ((C0795)arrayList.get(var27)).x()) {
                     var24.drawImage(var14, var28 - 10, var29, null);
                  }

                  byte var30 = 10;
                  if (club.ke() == club.kd()) {
                     var30 = 25;
                  }

                  if (club.kd() == ((C0795)arrayList.get(var27)).x()) {
                     var24.drawImage(var16, var28 - var30, var29, null);
                  }

                  if (club.lq() == ((C0795)arrayList.get(var27)).x()) {
                     var24.drawImage(var18, var28 + 40, var29 + 20, null);
                  }

                  if (var27 > 14 && var27 != 17 && club.lr() == ((C0795)arrayList.get(var27)).x()) {
                     var24.drawImage(var20, var28 + 40, var29 + 35, null);
                  }
               }

               byte var32 = 22;
               byte var31 = 20;
               if (((C0795)arrayList.get(var27)).x().fn() > 0) {
                  if (((C0795)arrayList.get(var27)).x().fn() > 9) {
                     var32 = 19;
                     var31 = 20;
                  }

                  var24.setColor(Color.WHITE);
                  var24.drawString(Integer.toString(((C0795)arrayList.get(var27)).x().fn()), var28 + var32, var29 + var31);
               }
            }
         }
      }

      var24.dispose();
      return new ImageIcon(var23);
   }

   public ImageIcon a(ArrayList arrayList, int i, ImageIcon imageIcon) {
      Image var5 = this.AH.getImage();
      Image var6 = imageIcon.getImage();
      BufferedImage var7 = new BufferedImage(RF, RG, 2);
      Graphics2D var8 = var7.createGraphics();
      RH.clear();
      RI.clear();
      byte var9 = 20;
      int var10 = 0;
      byte var11 = var9;
      byte var12 = 0;

      for (int var13 = 37; var13 < arrayList.size(); var13++) {
         if (((C0795)arrayList.get(var13)).vf() != null) {
            Image var4;
            if (((C0795)arrayList.get(var13)).x() != null && ((C0795)arrayList.get(var13)).x().getPosicao() == 0) {
               var4 = this.AI.getImage();
            } else {
               var4 = var6;
            }

            if (var13 != i) {
               var8.drawImage(var4, var11, var12, 45, 45, null);
            }

            if (((C0795)arrayList.get(var13)).x() != null) {
               var8.drawImage(a(((C0795)arrayList.get(var13)).x(), 2, var13, ""), var11 - 53, var12 + 42, null);
               var8.setFont(new Font("Arial", 1, 11));
               var8.setFont(var8.getFont().deriveFont(11.0F));
               var8.setColor(Color.BLACK);
               var8.drawString(GameConstants.rI[((C0795)arrayList.get(var13)).x().getPosicao()], var11, var12 + 39);
               var8.setColor(Color.WHITE);
               var8.drawString(GameConstants.rI[((C0795)arrayList.get(var13)).x().getPosicao()], var11, var12 + 38);
               byte var14 = 20;
               byte var15 = 20;
               if (((C0795)arrayList.get(var13)).x().fn() > 0) {
                  if (((C0795)arrayList.get(var13)).x().fn() > 9) {
                     var14 = 17;
                     var15 = 20;
                  }

                  var8.setColor(Color.WHITE);
                  var8.drawString(Integer.toString(((C0795)arrayList.get(var13)).x().fn()), var11 + var14, var12 + var15);
               }
            }

            RH.add(var11 + RD);
            RI.add(var12 + RE);
            var11 += 100;
            if (++var10 == 6) {
               var10 = 0;
               var11 = var9;
               var12 += 88;
            }
         }
      }

      int[][] var16 = new int[RH.size()][2];

      for (int var17 = 0; var17 < RH.size(); var17++) {
         var16[var17][0] = (Integer)RH.get(var17);
         var16[var17][1] = (Integer)RI.get(var17);
      }

      RM = var16;
      var8.dispose();
      return new ImageIcon(var7);
   }

   public static Image a(Player player, int i, int j, String string) {
      short var4;
      if (j > 25 && j <= 36) {
         var4 = 150;
      } else {
         var4 = 150;
      }

      if (player == null) {
         return null;
      }

      BufferedImage var5 = new BufferedImage(var4, 40, 2);
      Graphics2D var6 = var5.createGraphics();
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      Font var10 = new Font("Arial", 1, 11);
      FontMetrics var11 = null;
      Dimension var12 = new Dimension(var4, 40);
      var6.setFont(var10);
      if (var11 == null) {
         var11 = var6.getFontMetrics();
         var8 = var11.getAscent();
         var7 = var8 + var11.getDescent();
         var9 = var11.stringWidth(" ");
      }

      StringTokenizer var13 = new StringTokenizer("");
      boolean var14 = false;
      if (i == 1) {
         String var15 = "";
         if (j >= 1 && j <= 25) {
            var15 = GameConstants.rI[GameConstants.sE[j][0]];
            if (j == 10 || j == 17) {
               var15 = GameConstants.rI[3];
            }

            if (j >= 11) {
            }

            if (GameConstants.sE[j][0] != player.getPosicao()) {
               var14 = true;
               if ((j == 10 || j == 17) && (player.getPosicao() == 1 || player.getPosicao() == 3)) {
                  var14 = false;
               }

               if (var14) {
                  var15 = var15 + " (" + GameConstants.rI[player.getPosicao()] + ") ";
               }
            }
         } else {
            var15 = GameConstants.rI[player.getPosicao()];
         }

         var15 = var15 + " - ";
         if (!GamePersistence.careerState.isHabilidadeIndividual()) {
            var13 = new StringTokenizer(player.getNome() + " <br> " + var15 + "F:" + Integer.toString(player.getOverallStrength()) + " E:" + Integer.toString(player.fp()));
         } else {
            var13 = new StringTokenizer(player.getNome() + " <br> " + var15 + " E:" + Integer.toString(player.fp()));
         }
      } else if (i == 2) {
         if (!GamePersistence.careerState.isHabilidadeIndividual()) {
            var13 = new StringTokenizer(
               player.getNome() + " <br> " + "F:" + Integer.toString(player.getOverallStrength()) + " E:" + Integer.toString(player.fp()) + " L:" + GameConstants.rK[player.getLado()]
            );
         } else {
            var13 = new StringTokenizer(player.getNome() + " <br> " + " E:" + Integer.toString(player.fp()) + " L:" + GameConstants.rK[player.getLado()]);
         }
      } else if (i == 3) {
         String var25 = "";
         if (j >= 1 && j <= 25) {
            var25 = GameConstants.rI[GameConstants.sE[j][0]];
         }

         var13 = new StringTokenizer(var25 + " - " + player.getNome() + " <br> " + string);
      }

      int var26 = 0;
      int var17 = 0;
      int var20 = 0;
      String var21 = "";

      while (var13.hasMoreTokens()) {
         String var18 = var13.nextToken();
         if (var18.equals("<br>")) {
            a(var6, var21, var20, var11.stringWidth(var21), var17 + var8, var14, var4);
            var21 = "";
            var20 = 0;
            var26 = 0;
            var17 += var7;
         } else {
            int var22 = var11.stringWidth(var18);
            if (var26 + var9 + var22 > var12.width) {
               a(var6, var21, var20, var11.stringWidth(var21), var17 + var8, var14, var4);
               var21 = "";
               var20 = 0;
               var26 = 0;
               var17 += var7;
            }

            String var19;
            if (var26 != 0) {
               var19 = " ";
            } else {
               var19 = "";
            }

            var21 = var21 + var19 + var18;
            var26 = var26 + var9 + var22;
            var20++;
         }
      }

      a(var6, var21, var20, var11.stringWidth(var21), var17 + var8, var14, var4);
      var6.dispose();
      return var5;
   }

   public static void a(Graphics2D graphics2D, String string, int i, int j, int k, boolean bl, int l) {
      Dimension var7 = new Dimension(l, 40);
      graphics2D.setColor(Color.BLACK);
      graphics2D.drawString(string, (var7.width - j) / 2 + 1, k + 1);
      if (bl) {
         graphics2D.setColor(Color.YELLOW);
      } else {
         graphics2D.setColor(Color.WHITE);
      }

      graphics2D.drawString(string, (var7.width - j) / 2, k);
   }

   public void vg() {
      this.U = null;
      this.cg = null;
      this.RC = null;
   }

   public void ej(int i) {
      this.U = null;
      if (i <= 36) {
         this.RC = this.AH;
      }
   }

   public void vh() {
      this.RC = this.AH;
   }

   public static void a(int[][] is) {
      RM = is;
   }

   public static int vi() {
      return RD;
   }

   public static int vj() {
      return RE;
   }

   public static ImageIcon i(ImageIcon imageIcon) {
      Image var1 = imageIcon.getImage();
      BufferedImage var2 = new BufferedImage(40, 40, 2);
      Graphics2D var3 = var2.createGraphics();
      var3.drawImage(var1, 0, 0, 40, 40, null);
      var3.setComposite(AlphaComposite.Src);
      return new ImageIcon(var2);
   }

   public ImageIcon a(ArrayList arrayList, int i, ImageIcon imageIcon, boolean bl, int j, Player player) {
      Image var8 = this.AH.getImage();
      Image var9 = imageIcon.getImage();
      ImageIcon var10 = new ImageIcon(this.getClass().getResource("/aicons/bolaouro_s2.png"));
      Image var11 = var10.getImage();
      short var12 = 480;
      short var13 = 679;
      if (bl) {
         var12 = 390;
         var13 = 566;
      }

      BufferedImage var14 = new BufferedImage(var12, var13, 2);
      Graphics2D var15 = var14.createGraphics();

      for (int var16 = 1; var16 <= 25; var16++) {
         if (((C0795)arrayList.get(var16)).vf() != null && var16 != i) {
            if (var16 == 1) {
               var8 = this.AI.getImage();
            } else if (var16 <= 25) {
               if (((C0795)arrayList.get(var16)).x() != null) {
                  var8 = ((C0795)arrayList.get(var16)).vf().getImage();
               } else {
                  var8 = this.AH.getImage();
               }
            } else if (var16 > 25) {
               if (((C0795)arrayList.get(var16)).x() != null) {
                  if (((C0795)arrayList.get(var16)).x().getPosicao() == 0) {
                     var8 = this.AI.getImage();
                  } else {
                     var8 = var9;
                  }
               } else {
                  var8 = this.AH.getImage();
               }
            }

            int var17 = RJ[var16][0];
            int var18 = RJ[var16][1];
            if (bl) {
               var17 = RL[var16][0];
               var18 = RL[var16][1];
            }

            var15.drawImage(var8, var17, var18, null);
            if (((C0795)arrayList.get(var16)).x() != null) {
               String var19 = "";
               if (((C0795)arrayList.get(var16)).fg() != null) {
                  var19 = ((C0795)arrayList.get(var16)).fg().getNome();
               }

               var15.drawImage(a(((C0795)arrayList.get(var16)).x(), 3, var16, var19), var17 - 50, var18 + 47, null);
               if (((C0795)arrayList.get(var16)).x() == player) {
                  var15.drawImage(var11, var17 - 20, var18 + 20, null);
               }
            }
         }
      }

      var15.dispose();
      return new ImageIcon(var14);
   }

   public void n(Club club) {
      this.cg = club;
   }

   public Club fg() {
      return this.cg;
   }
}
