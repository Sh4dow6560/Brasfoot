package bf22.intermediary;

import mod.recovered.match.MatchEvent;
import mod.recovered.transfer.PlayerSearchCriteria;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ToolTipManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0137 extends JPanel {
   private JLabel Ay;
   private JLabel Az = new JLabel();
   private JLabel AA = new JLabel();
   private JLabel AC;
   private ImageIcon AD;
   private JDialog ub = null;
   private C0827 Db = null;
   private ArrayList AE = new ArrayList();
   private ArrayList Dc = new ArrayList();
   private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
   private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag40.png"));
   private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
   private ImageIcon AK = new ImageIcon(this.getClass().getResource("/aicons/camisar40.png"));
   private ImageIcon AL = this.AJ;
   private ImageIcon Dd = this.AK;
   private int AP = -1;
   private int AQ = -1;
   private boolean AR = false;
   private boolean AS = false;
   private boolean De = false;
   private boolean Df = false;
   private int ed = C0208.qj();
   private int dB = C0208.en();
   private boolean Dg = false;
   private int AU = -1;
   private Player Dh = null;
   final JPopupMenu AW = new JPopupMenu();
   private int Di = 1;
   private Club zu = null;
   private boolean Dj = false;
   private static Timer Dk;
   JMenuItem AZ = new JMenuItem("Falso 9");
   private JLabel Dl;
   private JButton Dm;
   private JComboBox Dn;
   private JComboBox Do;
   private JComboBox Dp;
   private JLabel ug;
   private JLabel vy;
   private JLabel vz;
   private JLabel vA;
   private JPanel vd;
   private JPanel we;
   private JScrollPane ut;
   private JLabel Dq;
   private JLabel Dr;
   private JLabel Ds;
   private JLabel Dt;
   private JLabel Cg;
   private JLabel Du;
   private JLabel Dv;
   private JLabel Dw;
   private JLabel Dx;
   private JLabel Dy;
   private JLabel Dz;
   private JLabel xI;
   private JLabel DA;
   private JLabel DB;
   private JLabel DC;
   private JLabel DD;
   private JLabel DE;
   private JLabel zO;
   private JLabel zP;
   private C0759 DF;
   private JTable DG;
   private static BufferedImage DH = null;

   public C0137(JDialog jDialog, C0827 c0827, boolean bl) {
      this.ub = jDialog;
      this.Db = c0827;
      this.Dg = bl;
      this.De = c0827.tR().getHomeClub().isUserControlled();
      this.Df = c0827.tR().getAwayClub().isUserControlled();
      this.zu = c0827.tR().getHomeClub();
      if (c0827.tR().getAwayClub().isUserControlled() && !c0827.tR().getHomeClub().isUserControlled()) {
         this.zu = c0827.tR().getAwayClub();
         this.Di = 2;
      }

      this.mJ();
      this.mK();
      this.nc();
      this.pe();
      this.mH();
      this.oX();
      ToolTipManager.sharedInstance().registerComponent(this.DF);
      this.oS();
      this.oY();
      this.DB.setText(this.V(this.AE));
      this.DC.setText(this.V(this.Dc));
      this.ok();
      if (this.zu.isUserControlled()) {
         this.Dj = true;
      }

      this.oP();
      this.oc();
      this.mY();
      if (GamePersistence.careerState.bD()) {
         this.oR();
      }

      this.ob();
      this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
      this.oO();
      this.oN();
   }

   private void oN() {
      if (this.Di == 1) {
         this.DF.aa(this.AE);
      } else {
         this.DF.aa(this.Dc);
      }
   }

   private void oO() {
      if (this.Di == 1) {
         this.zO.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(37, 37, 37)));
         this.zP.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY));
      } else {
         this.zP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(37, 37, 37)));
         this.zO.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY));
      }
   }

   private void ob() {
      if (this.Db.tR().dX() < GameConstants.pb.length) {
         this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aicons/" + GameConstants.pc[this.Db.tR().dX()] + ".png")));
      }
   }

   private void oP() {
      this.DA.setText("Substituições restantes: " + Integer.toString(this.Db.tR().aR(this.Di - 1)));
   }

   private void oQ() {
      this.pb();
   }

   public void oR() {
      Dk = new Timer();
      Dk.schedule(new C0138(this), 0L);
   }

   private void dc(int i) {
      if (this.zu.isUserControlled()) {
         this.pc();
      }

      this.Di = i;
      if (i == 1) {
         this.zu = this.Db.tR().getHomeClub();
      } else {
         this.zu = this.Db.tR().getAwayClub();
      }

      this.cS(-1);
      this.pd();
      if (this.zu.isUserControlled()) {
         this.Dj = true;
      } else {
         this.Dj = false;
      }

      this.pf();
      this.oP();
      this.oO();
      this.oN();
   }

   private void mY() {
      this.a(this.Dm);
      this.a(this.Ds);
      this.a(this.Do);
      this.a(this.Dp);
      this.a(this.Dn);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "st");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("esc", new C0143(this));
      jComponent.getActionMap().put("st", new C0144(this));
   }

   private void nc() {
      C0662 var1 = new C0662(this.Db.tR().getEvents());
      this.DG.setModel(var1);
      this.DG.setTableHeader(null);
      int[] var2 = new int[]{20, 180, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.DG.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.DG.setAutoResizeMode(3);
      this.DG.setRowHeight(20);
      this.DG.setShowGrid(false);
      this.DG.setDefaultRenderer(MatchEvent.class, new C0634(false));
      this.DG.setAutoCreateRowSorter(false);
      this.DG.setCellSelectionEnabled(false);
      this.DG.setRowSelectionAllowed(false);
      this.DG.setBackground(this.getBackground());
      this.DG.setFillsViewportHeight(true);
   }

   private void oS() {
      if (this.De) {
         this.AL = this.Db.tR().getHomeClub().kS();
      } else {
         this.Db.tR().getHomeClub().bV(0);
         this.AL = this.Db.tR().getHomeClub().kS();
      }

      if (this.Df) {
         this.Dd = this.Db.tR().getAwayClub().kS();
      } else {
         this.Db.tR().getAwayClub().bV(1);
         this.Dd = this.Db.tR().getAwayClub().kS();
      }
   }

   private void oc() {
      JMenuItem var1 = new JMenuItem("Batedor de faltas");
      var1.addActionListener(new C0145(this));
      this.AW.add(var1);
      this.AW.addSeparator();
      JMenuItem var2 = new JMenuItem("Capitão");
      var2.addActionListener(new C0146(this));
      this.AW.add(var2);
      this.AW.addSeparator();
      JMenuItem var3 = new JMenuItem("Batedor de escanteios");
      var3.addActionListener(new C0147(this));
      this.AW.add(var3);
      this.AW.addSeparator();
      this.AZ.addActionListener(new C0148(this));
      this.AW.add(this.AZ);
   }

   private void d(MouseEvent mouseEvent) {
      if (this.Dj) {
         this.AU = -1;
         ArrayList var2 = this.AE;
         if (this.Di == 2) {
            var2 = this.Dc;
         }

         C0759 var3 = this.DF;
         if (C0795.W(mouseEvent.getX(), mouseEvent.getY())) {
            this.AU = C0795.T(mouseEvent.getX(), mouseEvent.getY());
            if (this.AU >= 14 && this.AU != 17) {
               this.AZ.setEnabled(true);
               if (((C0795)var2.get(this.AU)).x() == this.zu.lr()) {
                  this.AZ.setText("Não usar falso 9");
               } else {
                  this.AZ.setText("Falso 9");
               }
            } else {
               this.AZ.setEnabled(false);
            }

            if (this.AU > 0 && this.AU <= 25 && ((C0795)var2.get(this.AU)).x() != null) {
               this.Dh = ((C0795)var2.get(this.AU)).x();
               this.AW.show(var3, mouseEvent.getX(), mouseEvent.getY());
            }
         }
      }
   }

   private void oT() {
      this.zu.k(this.Dh);
      this.cS(-1);
   }

   private void oU() {
      this.zu.j(this.Dh);
      this.cS(-1);
   }

   private void oV() {
      this.zu.n(this.Dh);
      this.cS(-1);
   }

   private void oW() {
      if (this.zu.lr() == this.Dh) {
         this.zu.o(null);
      } else {
         this.zu.o(this.Dh);
      }

      this.cS(-1);
   }

   public void ok() {
      this.DF.addMouseListener(new C0149(this));
      this.DF.addMouseMotionListener(new C0150(this));
   }

   private void a(MouseEvent mouseEvent, int i) {
      if (this.Dj) {
         if (this.AC == null) {
            return;
         }

         this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() - 25);
      }
   }

   public void X(boolean bl) {
      this.Ay.setVisible(bl);
   }

   public ImageIcon a(int i, Player player) {
      if (i == 1) {
         return this.AI;
      }

      if (i > 1) {
         if (player != null && player.getPosicao() == 0) {
            return this.AI;
         } else if (player != null) {
            return this.Di == 1 ? this.AL : this.Dd;
         } else {
            return this.AH;
         }
      } else if (player != null) {
         return this.Di == 1 ? this.AL : this.Dd;
      } else {
         return this.AH;
      }
   }

   private void b(MouseEvent mouseEvent) {
      if (this.Dj) {
         ArrayList var2 = this.AE;
         if (this.Di == 2) {
            var2 = this.Dc;
         }

         if (C0795.W(mouseEvent.getX(), mouseEvent.getY())) {
            this.AR = true;
            this.AP = C0795.T(mouseEvent.getX(), mouseEvent.getY());
            if (this.AP > 0 && ((C0795)var2.get(this.AP)).vf() != null) {
               this.cS(this.AP);
               if (this.AP > 1 && this.AP <= 25) {
                  this.X(true);
               }

               this.AC = null;
               this.AC = new JLabel();
               this.AC.setIcon(this.a(this.AP, ((C0795)var2.get(this.AP)).x()));
               this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() + -25);
               this.AC.setSize(this.AC.getWidth(), this.AC.getHeight());
               this.DF.add(this.AC, new C0775(mouseEvent.getX() - 25, mouseEvent.getY() - 25, 50, 50));
               this.DF.setLayer(this.AC, JLayeredPane.DRAG_LAYER);
            }
         }
      }
   }

   private void b(MouseEvent mouseEvent, int i) {
      if (this.Dj) {
         this.X(false);
         if (this.AC != null) {
            this.AC.setVisible(false);
            this.AC = null;
         }

         if (C0795.W(mouseEvent.getX(), mouseEvent.getY())) {
            if (this.AS) {
               this.AR = true;
            }

            this.AQ = C0795.T(mouseEvent.getX(), mouseEvent.getY());
            if (this.AQ > 0 && this.AP > 0) {
               this.H(this.AP, this.AQ);
            }
         }

         if (this.AR) {
            this.cS(-1);
            this.AR = false;
         }
      }
   }

   public void H(int i, int j) {
      boolean var3 = false;
      boolean var4 = false;
      ArrayList var5 = this.AE;
      if (this.Di == 2) {
         var5 = this.Dc;
      }

      if (i > 1 && i <= 25 && j <= 25) {
         var3 = true;
      } else if (i == 1 && j < 25) {
         if (((C0795)var5.get(i)).vf() != null && ((C0795)var5.get(j)).vf() != null) {
            var3 = true;
         }
      } else if (i <= 25 && j > 25) {
         if (((C0795)var5.get(i)).vf() != null && ((C0795)var5.get(j)).vf() != null) {
            var4 = true;
         }
      } else if (i > 25 && j <= 25 && ((C0795)var5.get(i)).vf() != null && ((C0795)var5.get(j)).vf() != null) {
         var4 = true;
      }

      if (var4) {
         this.K(i, j);
      } else if (var3) {
         Collections.swap(var5, i, j);
         if (((C0795)var5.get(i)).x() != null) {
            ((C0795)var5.get(i)).x().setTacticalPosition(i);
         }

         if (((C0795)var5.get(j)).x() != null) {
            ((C0795)var5.get(j)).x().setTacticalPosition(j);
         }
      }
   }

   private void K(int i, int j) {
      MatchEvent var3 = null;
      ArrayList var4 = this.AE;
      if (this.Di == 2) {
         var4 = this.Dc;
      }

      if (this.Db.tR().aR(this.Di - 1) > 0 && ((C0795)var4.get(i)).x() != null && ((C0795)var4.get(j)).x() != null) {
         int var5 = i;
         int var6 = j;
         if (i < j) {
            var5 = j;
            var6 = i;
         }

         int var7 = this.ed;
         if (this.Dg) {
            var7 = 1;
         }

         var3 = this.Db.tR().a(this.Di - 1, ((C0795)var4.get(var6)).x(), ((C0795)var4.get(var5)).x(), this.dB, var7, -1);
         if (var3 != null) {
            var3.setDone(true);
         }

         this.DG.addNotify();
         ((C0795)var4.get(var6)).a(((C0795)var4.get(var5)).x());
         ((C0795)var4.get(var5)).h(null);
         ((C0795)var4.get(var5)).a((Player)null);
         this.oP();
      }
   }

   private String V(ArrayList arrayList) {
      int[] var2 = new int[]{-1, 0, 0};

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         if (((C0795)arrayList.get(var3)).x() != null) {
            if (var3 <= 9) {
               var2[0]++;
            } else if (var3 <= 17) {
               var2[1]++;
            } else if (var3 <= 25) {
               var2[2]++;
            }
         }
      }

      return String.valueOf(var2[0]) + "-" + var2[1] + "-" + var2[2];
   }

   private void oX() {
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/aicons/alpha.png"));
      this.Ay = new JLabel();
      this.Ay.setIcon(var1);
      this.DF.add(this.Ay, new C0775(200, 0, 434, 650));
      this.DF.setLayer(this.Ay, JLayeredPane.PALETTE_LAYER);
      this.X(false);
   }

   private void cS(int i) {
      if (this.Di == 1) {
         this.a(this.Az, ((C0795)this.AE.get(0)).a(this.AE, i, this.AL, false, 1, this.Db.tR().getHomeClub(), 2), false);
         this.a(this.AA, ((C0795)this.AE.get(0)).a(this.AE, i, this.AL, false, 1, this.Db.tR().getHomeClub(), 3), true);
      } else {
         this.a(this.Az, ((C0795)this.AE.get(0)).a(this.Dc, i, this.Dd, false, 2, this.Db.tR().getAwayClub(), 2), false);
         this.a(this.AA, ((C0795)this.AE.get(0)).a(this.Dc, i, this.Dd, false, 2, this.Db.tR().getAwayClub(), 3), true);
      }
   }

   public void a(JLabel jLabel, ImageIcon imageIcon, boolean bl) {
      jLabel.setIcon(null);
      jLabel.setIcon(imageIcon);
      short var4 = 200;
      byte var5 = 10;
      if (bl) {
         var4 = 0;
         var5 = 0;
      }

      this.DF.add(jLabel, new C0775(var4, var5, -1, -1));
      this.DF.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
   }

   private void oY() {
      for (int var1 = 0; var1 <= 36; var1++) {
         C0795 var2 = new C0795();
         this.AE.add(var2);
      }

      for (int var7 = 0; var7 <= 36; var7++) {
         C0795 var13 = new C0795();
         this.Dc.add(var13);
      }

      if (!this.Db.tR().getHomeClub().isUserControlled() && !this.Db.tR().getAwayClub().isUserControlled()) {
         for (int var12 = 1; var12 <= 2; var12++) {
            ArrayList var16 = this.dd(var12);
            ArrayList var3 = this.AE;
            if (var12 == 2) {
               var3 = this.Dc;
            }

            for (int var4 = 0; var4 < var16.size(); var4++) {
               if (var16.get(var4) != null && ((Player)var16.get(var4)).getTacticalPosition() >= 1 && ((Player)var16.get(var4)).getTacticalPosition() <= 25) {
                  ((C0795)var3.get(((Player)var16.get(var4)).getTacticalPosition())).a((Player)var16.get(var4));
                  ((C0795)var3.get(((Player)var16.get(var4)).getTacticalPosition())).h(this.AL);
               }
            }

            int var17 = 26;
            ArrayList var5 = this.de(var12);

            for (int var6 = 0; var6 < var5.size(); var6++) {
               if (var17 <= 36 && var5.get(var6) != null && !var16.contains(var5.get(var6))) {
                  ((C0795)var3.get(var17)).a((Player)var5.get(var6));
                  ((C0795)var3.get(var17)).h(this.AL);
                  var17++;
               }
            }
         }
      } else {
         for (int var8 = 0; var8 < this.Db.tR().getHomePlayersOnField().size(); var8++) {
            if (this.Db.tR().getHomePlayersOnField().get(var8) != null && ((Player)this.Db.tR().getHomePlayersOnField().get(var8)).getTacticalPosition() >= 1 && ((Player)this.Db.tR().getHomePlayersOnField().get(var8)).getTacticalPosition() <= 25) {
               ((C0795)this.AE.get(((Player)this.Db.tR().getHomePlayersOnField().get(var8)).getTacticalPosition())).a((Player)this.Db.tR().getHomePlayersOnField().get(var8));
               ((C0795)this.AE.get(((Player)this.Db.tR().getHomePlayersOnField().get(var8)).getTacticalPosition())).h(this.AL);
            }
         }

         for (int var9 = 0; var9 < this.Db.tR().getAwayPlayersOnField().size(); var9++) {
            if (this.Db.tR().getAwayPlayersOnField().get(var9) != null && ((Player)this.Db.tR().getAwayPlayersOnField().get(var9)).getTacticalPosition() >= 1 && ((Player)this.Db.tR().getAwayPlayersOnField().get(var9)).getTacticalPosition() <= 25) {
               ((C0795)this.Dc.get(((Player)this.Db.tR().getAwayPlayersOnField().get(var9)).getTacticalPosition())).a((Player)this.Db.tR().getAwayPlayersOnField().get(var9));
               ((C0795)this.Dc.get(((Player)this.Db.tR().getAwayPlayersOnField().get(var9)).getTacticalPosition())).h(this.Dd);
            }
         }

         int var10 = 26;

         for (int var14 = 0; var14 < this.Db.tR().getHomeBench().size(); var14++) {
            if (var10 <= 36 && this.Db.tR().getHomeBench().get(var14) != null && !this.Db.tR().getHomePlayersOnField().contains(this.Db.tR().getHomeBench().get(var14))) {
               ((C0795)this.AE.get(var10)).a((Player)this.Db.tR().getHomeBench().get(var14));
               ((C0795)this.AE.get(var10)).h(this.AL);
               var10++;
            }
         }

         var10 = 26;

         for (int var15 = 0; var15 < this.Db.tR().getAwayBench().size(); var15++) {
            if (var10 <= 36 && this.Db.tR().getAwayBench().get(var15) != null && !this.Db.tR().getAwayPlayersOnField().contains(this.Db.tR().getAwayBench().get(var15))) {
               ((C0795)this.Dc.get(var10)).a((Player)this.Db.tR().getAwayBench().get(var15));
               ((C0795)this.Dc.get(var10)).h(this.Dd);
               var10++;
            }
         }
      }

      this.cS(-1);
   }

   private ArrayList dd(int i) {
      Club var2 = this.Db.tR().getHomeClub();
      if (i == 2) {
         var2 = this.Db.tR().getAwayClub();
      }

      ArrayList var3 = new ArrayList();
      if (i == 1) {
         var3.addAll(this.Db.tR().getHomeStartingLineup());
      } else if (i == 2) {
         var3.addAll(this.Db.tR().getAwayStartingLineup());
      }

      for (int var4 = 0; var4 < this.Db.tR().getEvents().size(); var4++) {
         if (((MatchEvent)this.Db.tR().getEvents().get(var4)).isDone()
            && ((MatchEvent)this.Db.tR().getEvents().get(var4)).getType() == 6
            && ((MatchEvent)this.Db.tR().getEvents().get(var4)).getClub() == var2) {
            var3.remove(((MatchEvent)this.Db.tR().getEvents().get(var4)).getPrimaryPlayer());
            var3.add(((MatchEvent)this.Db.tR().getEvents().get(var4)).getSecondaryPlayer());
         }
      }

      for (int var5 = 0; var5 < this.Db.tR().getEvents().size(); var5++) {
         if (((MatchEvent)this.Db.tR().getEvents().get(var5)).isDone()
            && ((MatchEvent)this.Db.tR().getEvents().get(var5)).getClub() == var2
            && (((MatchEvent)this.Db.tR().getEvents().get(var5)).getType() == 3 || ((MatchEvent)this.Db.tR().getEvents().get(var5)).getType() == 4)) {
            var3.remove(((MatchEvent)this.Db.tR().getEvents().get(var5)).getPrimaryPlayer());
            var3.add(((MatchEvent)this.Db.tR().getEvents().get(var5)).getSecondaryPlayer());
         }
      }

      return var3;
   }

   private ArrayList de(int i) {
      Club var2 = this.Db.tR().getHomeClub();
      if (i == 2) {
         var2 = this.Db.tR().getAwayClub();
      }

      ArrayList var3 = new ArrayList();
      if (i == 1) {
         var3.addAll(this.Db.tR().getHomeBench());
         var3.addAll(this.Db.tR().ie());
      } else if (i == 2) {
         var3.addAll(this.Db.tR().getAwayBench());
         var3.addAll(this.Db.tR().method_kw_if());
      }

      for (int var4 = 0; var4 < this.Db.tR().getEvents().size(); var4++) {
         if (((MatchEvent)this.Db.tR().getEvents().get(var4)).isDone()
            && ((MatchEvent)this.Db.tR().getEvents().get(var4)).getType() == 6
            && ((MatchEvent)this.Db.tR().getEvents().get(var4)).getClub() == var2) {
            var3.remove(((MatchEvent)this.Db.tR().getEvents().get(var4)).getSecondaryPlayer());
         }
      }

      Collections.sort(var3, C1007.abf);
      return var3;
   }

   private void oZ() {
      this.Dm.addActionListener(new C0139(this));
   }

   private void mH() {
      this.Dm.addActionListener(new C0140(this));
      C0141 var1 = new C0141(this);
      C0142 var2 = new C0142(this);
      this.zO.addMouseListener(var1);
      this.Dw.addMouseListener(var1);
      this.zP.addMouseListener(var2);
      this.Dx.addMouseListener(var2);
   }

   private void pa() {
      this.ub.dispose();
   }

   private void pb() {
      this.pc();
      this.ub.dispose();
   }

   private void pc() {
      if (this.zu.isUserControlled()) {
         this.zu.kj()[1] = this.Do.getSelectedIndex();
         this.zu.kj()[2] = this.Dp.getSelectedIndex();
         this.zu.kj()[3] = this.Dn.getSelectedIndex();
      }
   }

   private void mK() {
      this.zO.setForeground(this.Db.tR().getHomeClub().kC());
      this.zO.setBackground(this.Db.tR().getHomeClub().kB());
      this.zP.setForeground(this.Db.tR().getAwayClub().kC());
      this.zP.setBackground(this.Db.tR().getAwayClub().kB());
      this.Dw.setForeground(Color.WHITE);
      this.Dw.setBackground(Color.BLACK);
      this.Dx.setForeground(Color.WHITE);
      this.Dx.setBackground(Color.BLACK);
      this.Dv.setText(Integer.toString(this.ed) + "'");
      this.DE.setText(Integer.toString(this.dB) + "º");
      if (this.Dg) {
         this.Dv.setText("I");
         this.DE.setText("");
      }

      this.Cg.setText("");
      if (this.Db.tR().getStadium() != null) {
         this.Cg.setText(this.Db.tR().getStadium().dS());
         this.Dy.setText(Integer.toString(this.Db.tR().hU()));
         this.Dy.setToolTipText(this.Db.tR().hV());
         this.Dz.setText(ClubFinances.a(this.Db.tR().hN(), 0));
      } else if (this.Db.tR().il() != null) {
         this.Cg.setText(this.Db.tR().il().dS());
         this.Dz.setText(ClubFinances.a(this.Db.tR().hN(), 0));
         this.Dy.setText(Integer.toString(this.Db.tR().hU()));
         this.Dy.setToolTipText(this.Db.tR().hV());
      } else {
         if (this.Db.ik() != null) {
            this.Cg.setText(this.Db.ik());
         } else if (this.Db.tR().getHomeClub().lp()) {
            this.Cg.setText(this.Db.tR().getHomeClub().getNome());
         }

         this.Dy.setText("n/i");
         this.Dz.setText("n/i");
      }

      int[] var1 = new int[]{-1, -1};
      if (this.Db.tR().getCompetitionStage() instanceof KnockoutStage && ((KnockoutStage)this.Db.tR().getCompetitionStage()).zr() == 2) {
         var1 = ((KnockoutStage)this.Db.tR().getCompetitionStage()).o(this.Db.tR());
      }

      String[] var2 = new String[]{"", ""};
      if (var1[0] >= 0 && var1[1] >= 0) {
         var2[0] = " (" + Integer.toString(var1[0]) + ") ";
         var2[1] = " (" + Integer.toString(var1[1]) + ") ";
         this.Dl.setText("Primeiro jogo:" + Integer.toString(var1[0]) + " x " + Integer.toString(var1[1]));
      }

      this.zO.setText("  " + this.Db.tR().getHomeClub().getNome());
      this.zP.setText("  " + this.Db.tR().getAwayClub().getNome());
      this.Dw.setText(Integer.toString(this.Db.tT()));
      this.Dx.setText(Integer.toString(this.Db.tU()));
      this.zO.setIcon(this.Db.tR().getHomeClub().kU());
      this.zP.setIcon(this.Db.tR().getAwayClub().kU());
      if (this.Db.ei()) {
         this.xI.setText(this.Db.tR().ha());
      } else {
         this.xI.setText("");
      }
   }

   private void pd() {
      if (this.zu.getCoach() != null) {
         this.DD.setText("Tec:" + this.zu.getCoach().dS());
      } else {
         this.DD.setText("");
      }
   }

   public void pe() {
      for (int var1 = 0; var1 < GameConstants.rC.length; var1++) {
         this.Do.addItem(GameConstants.rC[var1]);
      }

      this.Do.setSelectedIndex(this.zu.kj()[1]);

      for (int var2 = 0; var2 < GameConstants.rE.length; var2++) {
         this.Dp.addItem(GameConstants.rE[var2]);
      }

      this.Dp.setSelectedIndex(this.zu.kj()[2]);

      for (int var3 = 0; var3 < GameConstants.rD.length; var3++) {
         this.Dn.addItem(GameConstants.rD[var3]);
      }

      this.Dn.setSelectedIndex(this.zu.kj()[3]);
      this.pf();
   }

   private void pf() {
      if (this.zu.isUserControlled()) {
         this.Dt.setVisible(false);
         this.Du.setVisible(false);
         this.Dr.setVisible(false);
         this.Do.setVisible(true);
         this.Dp.setVisible(true);
         this.Dn.setVisible(true);
         this.Do.setEnabled(true);
         this.Dp.setEnabled(true);
         this.Dn.setEnabled(true);
         this.Do.setSelectedIndex(this.zu.kj()[1]);
         this.Dp.setSelectedIndex(this.zu.kj()[2]);
         this.Dn.setSelectedIndex(this.zu.kj()[3]);
      } else {
         this.Dt.setVisible(true);
         this.Du.setVisible(true);
         this.Dr.setVisible(true);
         this.Do.setEnabled(false);
         this.Dp.setEnabled(false);
         this.Dn.setEnabled(false);
         this.Do.setVisible(false);
         this.Dp.setVisible(false);
         this.Dn.setVisible(false);
         this.Dt.setText(GameConstants.rC[this.zu.kj()[1]]);
         this.Du.setText(GameConstants.rE[this.zu.kj()[2]]);
         this.Dr.setText(GameConstants.rD[this.zu.kj()[3]]);
      }
   }

   public static void pg() {
      int[] var0 = new int[6];
      String var1 = "";
      boolean var2 = false;

      for (int var3 = 0; var3 < var0.length; var3++) {
         int var4 = PlayerSearchCriteria.bE(var3);
         String var5 = Integer.toString(var4);
         String var6 = Character.toString(var5.charAt(var5.length() - 3));
         if (GameConstants.tG[var3]) {
            var1 = var1 + Character.toString(var5.charAt(var5.length() - 3));
         }

         var0[var3] = Integer.parseInt(var6);
      }

      if (C0734.du() < 8) {
         C0644.ac(var1);
      }
   }

   private void mJ() {
      this.vd = new JPanel();
      this.Dw = new JLabel();
      this.Dx = new JLabel();
      this.zO = new JLabel();
      this.zP = new JLabel();
      this.DF = new C0759(this.AE);
      this.DD = new JLabel();
      this.Ds = new JLabel();
      this.Dq = new JLabel();
      this.ut = new JScrollPane();
      this.DG = new JTable();
      this.Dm = new JButton();
      this.DC = new JLabel();
      this.DB = new JLabel();
      this.Do = new JComboBox();
      this.vy = new JLabel();
      this.Dp = new JComboBox();
      this.vz = new JLabel();
      this.Dn = new JComboBox();
      this.vA = new JLabel();
      this.xI = new JLabel();
      this.we = new JPanel();
      this.Dv = new JLabel();
      this.DE = new JLabel();
      this.Dz = new JLabel();
      this.Cg = new JLabel();
      this.Dy = new JLabel();
      this.DA = new JLabel();
      this.Dt = new JLabel();
      this.Du = new JLabel();
      this.Dr = new JLabel();
      this.Dl = new JLabel();
      this.ug = new JLabel();
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(var1.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      var1.setVerticalGroup(var1.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      this.setBackground(new Color(0, 51, 0));
      this.setLayout(new C0807());
      this.Dw.setFont(new Font("Arial", 0, 18));
      this.Dw.setForeground(new Color(255, 255, 255));
      this.Dw.setHorizontalAlignment(0);
      this.Dw.setText("0");
      this.Dw.setOpaque(true);
      this.add(this.Dw, new C0775(890, 10, 40, 30));
      this.Dx.setFont(new Font("Arial", 0, 18));
      this.Dx.setForeground(new Color(255, 255, 255));
      this.Dx.setHorizontalAlignment(0);
      this.Dx.setText("0");
      this.Dx.setOpaque(true);
      this.add(this.Dx, new C0775(890, 90, 40, 30));
      this.zO.setBackground(new Color(0, 51, 204));
      this.zO.setFont(new Font("Tahoma", 1, 14));
      this.zO.setForeground(new Color(255, 255, 255));
      this.zO.setHorizontalAlignment(2);
      this.zO.setText("");
      this.zO.setOpaque(true);
      this.add(this.zO, new C0775(640, 10, 250, 30));
      this.zP.setBackground(new Color(153, 0, 0));
      this.zP.setFont(new Font("Tahoma", 1, 14));
      this.zP.setHorizontalAlignment(2);
      this.zP.setText("");
      this.zP.setOpaque(true);
      this.add(this.zP, new C0775(640, 90, 250, 30));
      this.DF.setLayout(new C0807());
      this.DD.setForeground(new Color(255, 255, 255));
      this.DD.setHorizontalAlignment(4);
      this.DD.setText("");
      this.DF.add(this.DD, new C0775(450, 630, 170, 20));
      this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campo.png")));
      this.Ds.setAlignmentY(0.0F);
      this.Ds.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.Ds.setRequestFocusEnabled(false);
      this.DF.add(this.Ds, new C0775(200, 0, 430, 650));
      this.Dq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campobanco1.png")));
      this.Dq.setText("labCampo");
      this.DF.add(this.Dq, new C0775(0, 0, 210, 650));
      this.add(this.DF, new C0775(10, 10, 630, 650));
      this.ut.setViewportView(this.DG);
      this.add(this.ut, new C0775(660, 230, 270, 300));
      this.Dm.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
      this.Dm.setText("Voltar ao jogo");
      this.add(this.Dm, new C0775(710, 680, 190, 30));
      this.DC.setForeground(new Color(255, 255, 153));
      this.DC.setHorizontalAlignment(2);
      this.DC.setText("4-4-2");
      this.add(this.DC, new C0775(650, 122, 60, -1));
      this.DB.setForeground(new Color(255, 255, 153));
      this.DB.setText("4-4-2");
      this.add(this.DB, new C0775(650, 45, 60, -1));
      this.add(this.Do, new C0775(220, 690, 130, -1));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setText("Estilo de jogo:");
      this.add(this.vy, new C0775(220, 670, -1, -1));
      this.add(this.Dp, new C0775(365, 690, 130, -1));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setText("Marcação:");
      this.add(this.vz, new C0775(365, 670, -1, -1));
      this.add(this.Dn, new C0775(510, 690, 130, -1));
      this.vA.setForeground(new Color(255, 255, 255));
      this.vA.setText("Concentrar ataques:");
      this.add(this.vA, new C0775(510, 670, -1, -1));
      this.xI.setForeground(new Color(255, 255, 255));
      this.xI.setHorizontalAlignment(0);
      this.xI.setText("Posse de bola");
      this.add(this.xI, new C0775(690, 540, 210, 120));
      this.we.setBackground(new Color(0, 0, 0));
      this.we.setPreferredSize(new Dimension(65, 50));
      this.Dv.setFont(new Font("Tahoma", 1, 18));
      this.Dv.setForeground(new Color(255, 255, 255));
      this.Dv.setHorizontalAlignment(0);
      this.Dv.setText("46'");
      this.DE.setForeground(new Color(255, 255, 255));
      this.DE.setHorizontalAlignment(0);
      this.DE.setText("1º");
      GroupLayout var2 = new GroupLayout(this.we);
      this.we.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addComponent(this.DE, Alignment.TRAILING, -1, -1, 32767)
            .addComponent(this.Dv, Alignment.TRAILING, -1, 50, 32767)
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addComponent(this.Dv, -2, 30, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.DE)
                  .addGap(0, 10, 32767)
            )
      );
      this.add(this.we, new C0775(660, 160, 50, 60));
      this.Dz.setForeground(new Color(255, 255, 255));
      this.Dz.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconmoney2.png")));
      this.Dz.setText("256 mil");
      this.add(this.Dz, new C0775(820, 200, 100, -1));
      this.Cg.setForeground(new Color(255, 255, 255));
      this.Cg.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio_iconSmall.png")));
      this.Cg.setText("Moisés Lucarelli");
      this.add(this.Cg, new C0775(720, 170, 150, -1));
      this.Dy.setForeground(new Color(255, 255, 255));
      this.Dy.setIcon(new ImageIcon(this.getClass().getResource("/aicons/n02.png")));
      this.Dy.setText("120 000");
      this.Dy.setToolTipText("");
      this.add(this.Dy, new C0775(720, 200, 80, -1));
      this.DA.setForeground(new Color(255, 255, 153));
      this.DA.setText("Substituições restantes: 5");
      this.add(this.DA, new C0775(10, 670, 200, -1));
      this.Dt.setForeground(new Color(255, 255, 204));
      this.Dt.setText("jLabel2");
      this.add(this.Dt, new C0775(220, 690, 130, -1));
      this.Du.setForeground(new Color(255, 255, 204));
      this.Du.setText("jLabel2");
      this.add(this.Du, new C0775(365, 690, 130, -1));
      this.Dr.setForeground(new Color(255, 255, 204));
      this.Dr.setText("jLabel2");
      this.add(this.Dr, new C0775(510, 690, 130, -1));
      this.Dl.setForeground(new Color(255, 255, 255));
      this.Dl.setHorizontalAlignment(0);
      this.add(this.Dl, new C0775(664, 140, 260, -1));
      this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/fundosemi.png")));
      this.ug.setToolTipText("");
      this.add(this.ug, new C0775(710, 160, 220, 60));
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      try {
         DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f02.jpg"));
      } catch (IOException var3) {
      }

      Dimension var2 = this.getSize();
      super.paintComponent(graphics);
      graphics.drawImage(DH, 0, 0, var2.width, var2.height, null);
   }
}
