package mod.recovered.ui;

import bf22.intermediary.CompetitionResultsPanel;
import mod.recovered.competition.NationalLeague;
import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public class MainWindow {
   private static JScrollPane gH;
   private static C0751 gI;
   private static JFrame cC = new JFrame();
   private static boolean gJ = false;
   private static C0419 gK;
   private static C0102 gL;
   private static C0208 gM;
   private static C0272 gN;
   private static C0213 gO;
   private static C0435 gP;
   private static C0151 gQ;
   private static C0238 gR;
   private static C0512 Jn;
   private static int gS = 0;
   private static int gT = 0;
   private static JDialog gU = null;

   public MainWindow(boolean bl) {
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aicons/ball.png"));
      cC.setIconImage(var2.getImage());
      cC.setTitle("Brasfoot");
      gI = new C0751(null, 0);
      GraphicsConfiguration var3 = cC.getGraphicsConfiguration();
      Rectangle var4 = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      cC.setMaximizedBounds(new Rectangle(0, 0, var4.width, var4.height));
      System.out.println("screen size:" + var4.width + "  " + var4.height);
      Dimension var5 = Toolkit.getDefaultToolkit().getScreenSize();
      int var6 = (int)var5.getWidth();
      int var7 = (int)var5.getHeight();
      System.out.println("screen size:" + var6 + "  " + var7);
      gS = var4.width;
      gT = var4.height;
      cC.setExtendedState((cC.getExtendedState() & 6) == 6 ? 0 : 6);
      cC.setUndecorated(true);
      cC.setDefaultCloseOperation(3);
      cC.setLayout(new BorderLayout());
      if (gS <= 1020 || gT <= 700) {
         gJ = true;
      }

      if (bl) {
         gK = new C0419(cC);
         gI.add(gK, "Center");
         gI.setBackground(new Color(36, 91, 45));
         if (gJ) {
            gH = new JScrollPane();
            cC.add(gH, "Center");
            gH.setViewportView(gI);
         } else {
            cC.add(gI, "Center");
         }
      }

      C0732.a(cC);
      cC.pack();
      cC.setVisible(true);
   }

   public static JPanel aY(int i) {
      gI = null;
      if (i == 8) {
         gI = new C0751(null, 0);
      } else {
         gI = new C0751(null, 0);
      }

      gI.setBackground(new Color(36, 91, 45));
      if (i == 0) {
         gK = new C0419(cC);
         gI.add(gK, "Center");
         gI.setBackground(new Color(36, 91, 45));
      } else if (i == 1) {
         gL = new C0102(cC);
         gI.add(gL, "Center");
      } else if (i == 2) {
         gM = null;
         gP = null;
         gN = new C0272(cC);
         gN.setPreferredSize(new Dimension(gS, gT));
         gI.add(gN, "Center");
      } else if (i == 3) {
         gK = new C0419(cC);
         gI.add(gK, "Center");
      } else if (i == 4) {
         gM = null;
         gM = new C0208(cC, gT);
         gM.setPreferredSize(new Dimension(1024, gT));
         gI.add(gM, "Center");
      } else if (i == 5) {
         gP = null;
         gP = new C0435(cC);
         gP.setPreferredSize(new Dimension(1024, 748));
         gI.add(gP, "Center");
      } else if (i == 6) {
         gQ = null;
         gQ = new C0151(cC);
         gQ.setPreferredSize(new Dimension(1024, 718));
         gI.add(gQ, "Center");
      } else if (i == 7) {
         gO = new C0213(cC);
         gO.setPreferredSize(new Dimension(941, 718));
         gI.add(gO, "Center");
      } else if (i == 8) {
         gR = new C0238(cC);
         gR.setPreferredSize(new Dimension(941, 718));
         gI.add(gR, "Center");
      } else if (i == 10) {
         Jn = new C0512(cC);
         Jn.setPreferredSize(new Dimension(742, 577));
         gI.add(Jn, "Center");
      }

      aZ(i);
      if (i == 4) {
         return gM;
      } else {
         return i == 5 ? gP : null;
      }
   }

   private static void aZ(int i) {
      cC.getContentPane().removeAll();
      if (gJ) {
         gH = new JScrollPane();
         cC.add(gH, "Center");
         gH.setViewportView(gI);
      } else {
         cC.add(gI, "Center");
      }

      cC.revalidate();
      cC.repaint();
      if (i == 1 && gL != null) {
         gL.on();
      }

      if (i == 2 && gN != null) {
         gN.on();
      }

      if (i == 5 && gP != null) {
         gP.on();
      }

      cC.setVisible(true);
   }

   public static C0419 iE() {
      return gK;
   }

   public static C0272 iF() {
      return gN;
   }

   public static JFrame db() {
      return cC;
   }

   public static void a(Club club, Competition c0713, int i) {
      JDialog var3 = new JDialog(cC);
      C0196 var4 = new C0196(var3, club, c0713, i);
      var3.add(var4);
      var3.setSize(306, 413);
      var3.setPreferredSize(new Dimension(306, 413));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
   }

   public static void a(ArrayList arrayList, Coach coach, int i) {
      JDialog var3 = new JDialog(cC);
      C0360 var4 = new C0360(var3, arrayList, coach, i);
      var3.add(var4);
      var3.setSize(774, 724);
      var3.setPreferredSize(new Dimension(774, 724));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
   }

   public static void l(Coach coach) {
      JDialog var1 = new JDialog(cC);
      C0350 var2 = new C0350(var1, coach);
      var1.add(var2);
      var1.setSize(711, 670);
      var1.setPreferredSize(new Dimension(711, 670));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void K(ArrayList arrayList) {
      JDialog var1 = new JDialog(cC);
      C0118 var2 = new C0118(var1, arrayList);
      var1.add(var2);
      var1.setSize(608, 304);
      var1.setPreferredSize(new Dimension(608, 304));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void a(Coach coach, Coach coach2, Club club, int i) {
      JDialog var4 = new JDialog(cC);
      C0225 var5 = new C0225(var4, coach, coach2, club, i);
      var4.add(var5);
      var4.setSize(475, 282);
      var4.setPreferredSize(new Dimension(475, 282));
      var4.setModal(true);
      var4.setResizable(false);
      var4.setLocationRelativeTo(null);
      var4.setUndecorated(true);
      var4.setVisible(true);
   }

   public static void cX() {
      JDialog var0 = new JDialog();
      C0200 var1 = new C0200(var0);
      var0.add(var1);
      var0.setSize(407, 354);
      var0.setPreferredSize(new Dimension(407, 354));
      var0.setModal(true);
      var0.setResizable(false);
      var0.setLocationRelativeTo(null);
      var0.setUndecorated(true);
      var0.setVisible(true);
   }

   public static void a(String string, boolean bl) {
      JDialog var2 = new JDialog();
      gU = var2;
      C0450 var3 = new C0450(var2, string, bl);
      var2.add(var3);
      var2.setSize(353, 103);
      var2.setPreferredSize(new Dimension(353, 103));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public static void iG() {
      JDialog var0 = new JDialog(cC);
      C0404 var1 = new C0404(var0);
      var0.add(var1);
      var0.setSize(799, 664);
      var0.setPreferredSize(new Dimension(799, 664));
      var0.setModal(true);
      var0.setResizable(false);
      var0.setLocationRelativeTo(null);
      var0.setUndecorated(true);
      var0.setVisible(true);
   }

   public static void a(Club club, boolean bl) {
      JDialog var2 = new JDialog(cC);
      C0043 var3 = new C0043(var2, club, bl);
      var2.add(var3);
      var2.setSize(948, 706);
      var2.setPreferredSize(new Dimension(948, 706));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public static void a(Player player, JDialog jDialog) {
      JDialog var2 = new JDialog(cC);
      C0223 var3 = new C0223(var2, player);
      var2.add(var3);
      var2.setSize(786, 600);
      var2.setPreferredSize(new Dimension(786, 600));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public static void v(Club club) {
      JDialog var1 = new JDialog(cC);
      C0221 var2 = new C0221(var1, club);
      var1.add(var2);
      short var3 = 886;
      short var4 = 762;
      int var5 = var2.pG();
      if (var5 < 5) {
         var4 = 219;
      } else if (var5 < 9) {
         var4 = 399;
      } else if (var5 < 13) {
         var4 = 579;
      }

      var1.setSize(var3, var4);
      var1.setPreferredSize(new Dimension(var3, var4));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void a(int i, Competition c0713) {
      JDialog var2 = new JDialog(cC);
      C0078 var3 = new C0078(var2, c0713);
      var2.add(var3);
      var2.setSize(833, 735);
      var2.setPreferredSize(new Dimension(833, 735));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public static void b(int i, Competition c0713) {
      JDialog var2 = new JDialog(cC);
      CompetitionResultsPanel var3 = new CompetitionResultsPanel(var2, i, c0713);
      var2.add(var3);
      int var4 = gT;
      if (var4 > 800) {
         var4 = 800;
      }

      var2.setSize(883, var4);
      var2.setPreferredSize(new Dimension(883, var4));
      var2.setModal(true);
      var2.setResizable(false);
      var2.setLocationRelativeTo(null);
      var2.setUndecorated(true);
      var2.setVisible(true);
   }

   public static void e(Coach coach) {
      JDialog var1 = new JDialog(cC);
      C0219 var2 = new C0219(var1, coach);
      var1.add(var2);
      var1.setSize(971, 646);
      var1.setPreferredSize(new Dimension(971, 646));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void a(NationalLeague c0924, CountryCompetitions c0692, int i) {
      JDialog var3 = new JDialog(cC);
      C0498 var4 = new C0498(var3, c0924, c0692, i);
      var3.add(var4);
      var3.setSize(372, 657);
      var3.setPreferredSize(new Dimension(372, 657));
      var3.setModal(true);
      var3.setResizable(false);
      var3.setLocationRelativeTo(null);
      var3.setUndecorated(true);
      var3.setVisible(true);
   }

   public static void a(JTable jTable) {
      JDialog var1 = new JDialog(cC);
      C0294 var2 = new C0294(var1, jTable);
      var1.add(var2);
      var1.setSize(867, 620);
      var1.setPreferredSize(new Dimension(867, 620));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void w(Club club) {
      JDialog var1 = new JDialog(cC);
      C0398 var2 = new C0398(var1, club);
      var1.add(var2);
      var1.setSize(565, 575);
      var1.setPreferredSize(new Dimension(565, 575));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void x(Club club) {
      JDialog var1 = new JDialog(cC);
      C0186 var2 = new C0186(var1, club);
      var1.add(var2);
      var1.setSize(565, 575);
      var1.setPreferredSize(new Dimension(565, 575));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   public static void a(Club club, Club club2, boolean bl) {
      GraphicsConfiguration var3 = cC.getGraphicsConfiguration();
      Rectangle var4 = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      cC.setMaximizedBounds(new Rectangle(0, 0, var4.width, var4.height));
      gS = var4.width;
      gT = var4.height;
      short var5 = 1024;
      short var6 = 718;
      if (gS >= 1366) {
         var5 = 1200;
      }

      if (gT >= 768) {
         var6 = 740;
      }

      JDialog var7 = new JDialog(cC);
      C0452 var8 = new C0452(var7, club, club2, bl);
      var7.add(var8);
      var7.setSize(var5, var6);
      var7.setPreferredSize(new Dimension(var5, var6));
      var7.setModal(true);
      var7.setResizable(false);
      var7.setLocationRelativeTo(null);
      var7.setUndecorated(true);
      var7.setVisible(true);
   }

   public static JDialog iH() {
      return gU;
   }

   public static boolean iI() {
      return gJ;
   }
}
