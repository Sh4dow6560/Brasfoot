package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.ToolTipManager;
import mod.recovered.model.Club;
import mod.recovered.model.Player;
import mod.recovered.team.LineupPreset;

public class C0132 extends JPanel {
   private JLabel Ay;
   private JLabel Az = new JLabel();
   private JLabel AA = new JLabel();
   private JLabel AB = new JLabel();
   private JLabel AC;
   private ImageIcon AD;
   private ArrayList AE = new ArrayList();
   private ArrayList AF = new ArrayList();
   private Club zu;
   private Match bv;
   private static C0132 AG;
   private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
   private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag.png"));
   private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat.png"));
   private ImageIcon AK = new ImageIcon(this.getClass().getResource("/aicons/camisar.png"));
   private ImageIcon AL = this.AJ;
   private ImageIcon AM = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
   private ImageIcon AN = new ImageIcon(this.getClass().getResource("/aicons/camisar40.png"));
   private ArrayList AO = new ArrayList();
   private int AP = -1;
   private int AQ = -1;
   private boolean AR = false;
   private boolean AS = false;
   private JDialog ub;
   private int AT = 0;
   private int AU = -1;
   private boolean AV = false;
   final JPopupMenu AW = new JPopupMenu();
   private boolean AX = false;
   private boolean AY = false;
   JMenuItem AZ = new JMenuItem("Falso 9");
   private JRadioButton Ba;
   private JRadioButton Bb;
   private JRadioButton Bc;
   private JCheckBox Bd;
   private JCheckBox Be;
   private JButton vb;
   private JComboBox Bf;
   private JComboBox Bg;
   private JComboBox Bh;
   private JComboBox Bi;
   private JLabel ug;
   private JLabel Bj;
   private JLabel vw;
   private JLabel zc;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel vy;
   private JLabel vA;
   private JPanel vd;
   private JPanel we;
   private JLabel Bk;
   private JLabel Bl;
   private JLabel Bm;
   private JButton Bn;
   private JButton Bo;
   private C0757 Bp;

   public static ArrayList oa() {
      return AG.AE;
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.Bp);
      this.a(this.vd);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "st");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0081(this));
   }

   public C0132(JDialog jDialog, Club club, Match c0675, boolean bl) {
      this.ub = jDialog;
      this.zu = club;
      this.AV = bl;
      if (this.zu.ke() == null) {
         this.zu.kA();
      }

      if (this.zu.kd() == null) {
         this.zu.kz();
      }

      this.bv = c0675;
      AG = this;
      if (this.bv.hc() == this.zu) {
         this.AT = 0;
      } else {
         this.AT = 1;
      }

      this.mJ();
      this.Bf.setMaximumRowCount(14);
      this.Be.setSelected(GamePersistence.careerState.bm());
      ImageIcon var5 = new ImageIcon(this.getClass().getResource("/aicons/alpha.png"));
      this.Ay = new JLabel();
      this.Ay.setIcon(var5);
      this.Bp.add(this.Ay, new C0775(0, 0, 480, 679));
      this.Bp.setLayer(this.Ay, JLayeredPane.PALETTE_LAYER);
      this.od();
      ToolTipManager.sharedInstance().registerComponent(this.Bp);
      if (!bl && this.bv.hy() != null && this.bv.hy().b() == 0) {
         this.AX = true;
         this.Bd.setVisible(true);
      } else {
         this.AX = false;
         this.Bd.setVisible(false);
      }

      this.U(this.AX);
      this.lA();
      if (this.Be.isSelected() && this.zu.kX() != null) {
         this.a(this.zu.kX(), false);
      }

      this.X(false);
      this.ok();
      this.og();
      this.oc();
      this.mY();
      this.ob();
   }

   private void ob() {
      if (this.bv.dX() < GameConstants.pb.length) {
         this.Bm.setText(GameConstants.pb[this.bv.dX()]);
         this.Bl.setIcon(new ImageIcon(this.getClass().getResource("/aicons/" + GameConstants.pc[this.bv.dX()] + ".png")));
      }
   }

   private void oc() {
      JMenuItem var1 = new JMenuItem("Batedor de faltas");
      var1.addActionListener(new C0092(this));
      this.AW.add(var1);
      this.AW.addSeparator();
      JMenuItem var2 = new JMenuItem("Capitão");
      var2.addActionListener(new C0095(this));
      this.AW.add(var2);
      this.AW.addSeparator();
      JMenuItem var3 = new JMenuItem("Batedor de escanteios");
      var3.addActionListener(new C0096(this));
      this.AW.add(var3);
      this.AW.addSeparator();
      this.AZ.addActionListener(new C0097(this));
      this.AW.add(this.AZ);
   }

   public void od() {
      String[] var1 = GameConstants.rB;
      String[] var2 = GameConstants.rC;
      String[] var3 = GameConstants.rD;
      String[] var4 = GameConstants.rE;

      for (int var5 = 0; var5 < var2.length; var5++) {
         this.Bg.addItem(var2[var5]);
      }

      this.Bg.setSelectedIndex(this.zu.kj()[1]);

      for (int var12 = 0; var12 < var4.length; var12++) {
         this.Bh.addItem(var4[var12]);
      }

      this.Bh.setSelectedIndex(this.zu.kj()[2]);

      for (int var13 = 0; var13 < var3.length; var13++) {
         this.Bi.addItem(var3[var13]);
      }

      this.Bi.setSelectedIndex(this.zu.kj()[3]);

      for (int var14 = 0; var14 < var1.length; var14++) {
         this.Bf.addItem(var1[var14]);
      }

      if (this.bv != null) {
         Club var15 = null;
         boolean var6 = false;
         if (this.bv.hc() == this.zu) {
            var15 = this.bv.hd();
            var6 = true;
         } else {
            var15 = this.bv.hc();
         }

         this.Bk.setIcon(var15.kU());
         this.Bk.setText(var15.getNome());
         var15.kM();
         boolean var7 = false;
         ImageIcon[] var8 = var15.kN();
         if (var8[0] == null && var8[1] == null && var8[2] == null) {
            var7 = true;
         }

         int[] var9 = new int[]{0, 1, 2};
         int[] var10 = new int[]{1, 0, 2};
         int[] var11;
         if (!var6) {
            var11 = var9;
         } else {
            var11 = var10;
         }

         if (!var7) {
            if (var8[var11[0]] != null) {
               this.Bj.setIcon(C0795.i(var8[var11[0]]));
            } else if (var8[var11[1]] != null) {
               this.Bj.setIcon(C0795.i(var8[var11[1]]));
            } else if (var8[var11[2]] != null) {
               this.Bj.setIcon(C0795.i(var8[var11[2]]));
            }
         } else if (!var6) {
            this.Bj.setIcon(this.AM);
         } else {
            this.Bj.setIcon(this.AN);
         }
      }

      boolean var17 = false;
      ImageIcon[] var18 = new ImageIcon[]{this.zu.bU(1), this.zu.bU(2), this.zu.bU(3)};
      if (var18[0] == null && var18[1] == null && var18[2] == null) {
         var17 = true;
      }

      if (var17) {
         this.Bc.setIcon(this.AM);
         this.Ba.setIcon(this.AN);
         this.Bb.setVisible(false);
         if (this.zu.kW() == 0) {
            this.AL = this.AJ;
         } else {
            this.AL = this.AK;
         }
      } else {
         if (var18[0] != null) {
            this.Bc.setIcon(C0795.i(var18[0]));
         } else {
            this.Bc.setIcon(this.AM);
         }

         if (var18[1] != null) {
            this.Ba.setIcon(C0795.i(var18[1]));
         } else {
            this.Bc.setIcon(this.AN);
         }

         if (var18[2] != null) {
            this.Bb.setIcon(C0795.i(var18[2]));
         } else {
            this.Bb.setVisible(false);
         }

         this.AL = this.zu.kS();
      }
   }

   public void oe() {
      for (int var1 = 37; var1 < this.AE.size(); var1++) {
         ((C0795)this.AE.get(var1)).vg();
      }

      int var3 = 37;
      if (!this.AX) {
         for (int var2 = 0; var2 < this.AF.size(); var2++) {
            if (!this.t((Player)this.AF.get(var2))) {
               ((C0795)this.AE.get(var3)).a((Player)this.AF.get(var2));
               ((C0795)this.AE.get(var3)).h(this.AL);
               var3++;
            }
         }
      } else {
         for (int var4 = 0; var4 < this.AF.size(); var4++) {
            if (((Player)this.AF.get(var4)).fC() == this.AY && !this.t((Player)this.AF.get(var4))) {
               ((C0795)this.AE.get(var3)).a((Player)this.AF.get(var4));
               ((C0795)this.AE.get(var3)).h(this.AL);
               var3++;
            }
         }
      }

      this.cT(-1);
   }

   public void U(boolean bl) {
      this.AF.clear();
      if (!this.AV) {
         for (int var2 = 0; var2 < this.zu.kc().size(); var2++) {
            if (((Player)this.zu.kc().get(var2)).a(this.bv, this.AV)) {
               this.AF.add((Player)this.zu.kc().get(var2));
            }
         }
      } else {
         for (int var3 = 0; var3 < this.zu.kc().size(); var3++) {
            if (((Player)this.zu.kc().get(var3)).a(this.bv, this.AV)) {
               this.AF.add((Player)this.zu.kc().get(var3));
            }
         }
      }

      if (bl) {
         for (int var4 = 0; var4 < this.zu.ky().size(); var4++) {
            this.AF.add((Player)this.zu.ky().get(var4));
         }
      }
   }

   public ImageIcon a(int i, Player player) {
      if (i == 1) {
         return this.AI;
      }

      if (i > 1) {
         if (player != null && player.getPosicao() == 0) {
            return this.AI;
         } else {
            return player != null ? this.AL : this.AH;
         }
      } else {
         return player != null ? this.AL : this.AH;
      }
   }

   public void V(boolean bl) {
      for (int var2 = 0; var2 <= 91; var2++) {
         C0795 var3 = new C0795();
         this.AE.add(var3);
      }

      this.of();
      this.cS(-1);
   }

   private void W(boolean bl) {
      if (bl) {
         LineupPreset var2 = this.zu.kX();
         if (var2 == null) {
            var2 = new LineupPreset();
            this.zu.a(var2);
         }

         var2.clear();

         for (int var3 = 0; var3 < 37; var3++) {
            if (((C0795)this.AE.get(var3)).x() != null) {
               var2.getPlayers().add(((C0795)this.AE.get(var3)).x());
               var2.getPositions().add(var3);
            } else if (((C0795)this.AE.get(var3)).vf() != null) {
               var2.getPlayers().add(null);
               var2.getPositions().add(var3);
            }
         }
      }
   }

   public void a(LineupPreset lineupPreset, boolean bl) {
      this.AO.clear();

      for (int var3 = 0; var3 < 91; var3++) {
         if (var3 < this.AE.size()) {
            ((C0795)this.AE.get(var3)).vg();
         }
      }

      for (int var4 = 0; var4 < lineupPreset.getPlayers().size(); var4++) {
         if (lineupPreset.getPlayers().get(var4) != null) {
            if (this.AF.contains(lineupPreset.getPlayers().get(var4))) {
               if ((Integer)lineupPreset.getPositions().get(var4) < this.AE.size()) {
                  ((C0795)this.AE.get((Integer)lineupPreset.getPositions().get(var4))).a((Player)lineupPreset.getPlayers().get(var4));
                  ((C0795)this.AE.get((Integer)lineupPreset.getPositions().get(var4))).h(this.AL);
                  this.AO.add((Player)lineupPreset.getPlayers().get(var4));
               }
            } else if ((Integer)lineupPreset.getPositions().get(var4) < this.AE.size()) {
               ((C0795)this.AE.get((Integer)lineupPreset.getPositions().get(var4))).a((Player)null);
               ((C0795)this.AE.get((Integer)lineupPreset.getPositions().get(var4))).h(this.AH);
            }
         } else if ((Integer)lineupPreset.getPositions().get(var4) < this.AE.size()) {
            ((C0795)this.AE.get((Integer)lineupPreset.getPositions().get(var4))).a((Player)null);
            ((C0795)this.AE.get((Integer)lineupPreset.getPositions().get(var4))).h(this.AH);
         }
      }

      this.cS(-1);
      this.oe();
   }

   private void of() {
      for (int var1 = 0; var1 <= 36; var1++) {
         ((C0795)this.AE.get(var1)).vg();
      }

      for (int var2 = 0; var2 <= 10; var2++) {
         ((C0795)this.AE.get(GameConstants.sJ[4][var2])).ej(var2);
      }

      for (int var3 = 26; var3 <= 36; var3++) {
         ((C0795)this.AE.get(var3)).ej(var3);
      }
   }

   private void cR(int i) {
      for (int var2 = 0; var2 <= 36; var2++) {
         ((C0795)this.AE.get(var2)).vg();
      }

      for (int var3 = 0; var3 <= 10; var3++) {
         ((C0795)this.AE.get(GameConstants.sJ[i][var3])).ej(var3);
      }

      for (int var4 = 26; var4 <= 36; var4++) {
         ((C0795)this.AE.get(var4)).ej(var4);
      }

      this.cS(-1);
   }

   private void cS(int i) {
      this.a(this.Az, ((C0795)this.AE.get(0)).a(this.AE, i, this.AL, false, -1, this.zu, 0), false);
      this.a(this.AA, ((C0795)this.AE.get(0)).a(this.AE, i, this.AL, false, -1, this.zu, 1), true);
   }

   private void cT(int i) {
      this.e(((C0795)this.AE.get(0)).a(this.AE, i, this.AL));
   }

   public void a(JLabel jLabel, ImageIcon imageIcon, boolean bl) {
      jLabel.setIcon(null);
      jLabel.setIcon(imageIcon);
      short var4 = 0;
      byte var5 = 0;
      if (bl) {
         var4 = 440;
         var5 = 30;
      }

      this.Bp.add(jLabel, new C0775(var4, var5, -1, -1));
      this.Bp.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
   }

   public void e(ImageIcon imageIcon) {
      this.AB.setIcon(null);
      this.AB.setIcon(imageIcon);
      this.Bp.add(this.AB, new C0775(C0795.vi(), C0795.vj(), -1, -1));
      this.Bp.setLayer(this.AB, JLayeredPane.POPUP_LAYER);
   }

   public void f(ImageIcon imageIcon) {
      this.Az.setIcon(imageIcon);
   }

   private void lA() {
      this.AO.clear();
      this.AE.clear();
      this.V(false);
      this.oe();
   }

   private void cU(int i) {
      if (i == 0) {
         this.lA();
      } else {
         for (int var2 = 0; var2 < this.AE.size(); var2++) {
            ((C0795)this.AE.get(var2)).vg();
         }

         this.AO.clear();
         this.AE.clear();

         for (int var6 = 0; var6 <= 91; var6++) {
            C0795 var3 = new C0795();
            this.AE.add(var3);
         }

         ArrayList var7 = new ArrayList();
         var7.addAll(this.AF);
         Collections.sort(var7, C1007.abh);

         for (int var8 = 0; var8 < 11; var8++) {
            int var4 = GameConstants.sJ[i][var8];
            Player var5 = Club.a(var7, var4, false, false);
            if (var5 != null) {
               ((C0795)this.AE.get(var4)).h(this.AL);
               ((C0795)this.AE.get(var4)).a(var5);
               var7.remove(var5);
               this.AO.add(var5);
            }
         }

         int var9 = 26;

         for (int var11 = 0; var11 < GameConstants.sI.length; var11++) {
            Player var14 = Club.a(var7, GameConstants.sI[var11], true, false);
            if (var14 != null) {
               ((C0795)this.AE.get(var9)).h(this.AL);
               ((C0795)this.AE.get(var9)).a(var14);
               var7.remove(var14);
               this.AO.add(var14);
               var9++;
            }
         }

         for (int var12 = 26; var12 <= 36; var12++) {
            if (((C0795)this.AE.get(var12)).vf() == null) {
               ((C0795)this.AE.get(var12)).ej(var12);
            }
         }

         var9 = 37;

         for (int var13 = 0; var13 < this.AF.size(); var13++) {
            if (!this.AO.contains(this.AF.get(var13))) {
               ((C0795)this.AE.get(var9)).a((Player)this.AF.get(var13));
               ((C0795)this.AE.get(var9)).h(this.AL);
               var9++;
            }
         }

         this.cS(-1);
         this.cT(-1);
      }
   }

   public void og() {
      this.Bf.addActionListener(new C0098(this));
      this.Bg.addActionListener(new C0099(this));
      this.Bh.addActionListener(new C0100(this));
      this.Bi.addActionListener(new C0101(this));
      this.Bd.addActionListener(new C0082(this));
      this.Bn.addActionListener(new C0083(this));
      this.Bo.addActionListener(new C0084(this));
      this.Be.addActionListener(new C0085(this));
      this.vb.addActionListener(new C0086(this));
      this.Bc.addActionListener(new C0087(this));
      this.Ba.addActionListener(new C0088(this));
      this.Bb.addActionListener(new C0089(this));
   }

   public void oh() {
      int var1 = 0;

      for (int var2 = 1; var2 <= 25; var2++) {
         if (((C0795)this.AE.get(var2)).x() != null) {
            var1++;
         }
      }

      if (var1 != 11) {
         JOptionPane.showMessageDialog(this.ub, "Selecione 11 jogadores", "", 0);
      } else {
         this.W(true);
         this.oi();
      }
   }

   public boolean t(Player player) {
      for (int var2 = 1; var2 <= 36; var2++) {
         if (((C0795)this.AE.get(var2)).x() != null && ((C0795)this.AE.get(var2)).x() == player) {
            return true;
         }
      }

      return false;
   }

   public void oi() {
      this.zu.kY().clear();
      if (this.AT == 0) {
         this.bv.hl().clear();
         this.bv.hp().clear();
         this.bv.hn().clear();
      } else if (this.AT == 1) {
         this.bv.hm().clear();
         this.bv.hq().clear();
         this.bv.ho().clear();
      }

      for (int var1 = 1; var1 <= 25; var1++) {
         if (((C0795)this.AE.get(var1)).x() != null) {
            ((C0795)this.AE.get(var1)).x().as(var1);
            ((C0795)this.AE.get(var1)).x().b(true);
            this.zu.kY().add(((C0795)this.AE.get(var1)).x());
            if (this.AT == 0) {
               this.bv.hl().add(((C0795)this.AE.get(var1)).x());
               this.bv.hp().add(((C0795)this.AE.get(var1)).x());
            } else if (this.AT == 1) {
               this.bv.hm().add(((C0795)this.AE.get(var1)).x());
               this.bv.hq().add(((C0795)this.AE.get(var1)).x());
            }
         }
      }

      this.zu.kZ().clear();

      for (int var2 = 26; var2 <= 36; var2++) {
         if (((C0795)this.AE.get(var2)).x() != null) {
            ((C0795)this.AE.get(var2)).x().as(var2);
            ((C0795)this.AE.get(var2)).x().b(true);
            this.zu.kZ().add(((C0795)this.AE.get(var2)).x());
            if (this.AT == 0) {
               this.bv.hn().add(((C0795)this.AE.get(var2)).x());
            } else if (this.AT == 1) {
               this.bv.ho().add(((C0795)this.AE.get(var2)).x());
            }
         }
      }

      this.zu.I(true);
      if (GamePersistence.careerState.getAutoSalvar() > 0) {
         MainWindow.iF().rt();
      }

      this.ub.dispose();
      GamePersistence.careerState.ap();
   }

   public void oj() {
      JDialog var1 = new JDialog(this.ub);
      C0489 var2 = new C0489(this, var1, this.zu);
      var1.add(var2);
      var1.setSize(315, 343);
      var1.setPreferredSize(new Dimension(325, 273));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.pack();
      var1.setVisible(true);
   }

   private void d(MouseEvent mouseEvent) {
      this.AU = -1;
      if (C0795.V(mouseEvent.getX(), mouseEvent.getY())) {
         this.AU = C0795.S(mouseEvent.getX(), mouseEvent.getY());
         if (this.AU >= 14 && this.AU != 17) {
            this.AZ.setEnabled(true);
            if (((C0795)this.AE.get(this.AU)).x() == this.zu.lr()) {
               this.AZ.setText("Não usar falso 9");
            } else {
               this.AZ.setText("Falso 9");
            }
         } else {
            this.AZ.setEnabled(false);
         }

         if (this.AU > 0 && this.AU <= 25 && ((C0795)this.AE.get(this.AU)).x() != null) {
            this.AW.show(this.Bp, mouseEvent.getX(), mouseEvent.getY());
         }
      }
   }

   private void u(Player player) {
      this.zu.k(player);
      this.cS(-1);
   }

   private void v(Player player) {
      this.zu.n(player);
      this.cS(-1);
   }

   private void w(Player player) {
      if (this.zu.lr() == player) {
         this.zu.o(null);
      } else {
         this.zu.o(player);
      }

      this.cS(-1);
   }

   private void x(Player player) {
      this.zu.j(player);
      this.cS(-1);
   }

   public void ok() {
      this.Bp.addMouseListener(new C0090(this));
      this.Bp.addMouseMotionListener(new C0091(this));
      this.addMouseListener(new C0093(this));
      this.addMouseMotionListener(new C0094(this));
   }

   private void a(MouseEvent mouseEvent) {
      if (this.AC != null) {
         this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() - 25);
      }
   }

   private void b(MouseEvent mouseEvent) {
      if (C0795.V(mouseEvent.getX(), mouseEvent.getY())) {
         this.AR = true;
         this.AP = C0795.S(mouseEvent.getX(), mouseEvent.getY());
         if (this.AP > 0 && ((C0795)this.AE.get(this.AP)).vf() != null) {
            this.cS(this.AP);
            if (this.AP > 1 && this.AP <= 25) {
               this.X(true);
            }

            this.AC = null;
            this.AC = new JLabel();
            this.AC.setIcon(this.a(this.AP, ((C0795)this.AE.get(this.AP)).x()));
            this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() + -25);
            this.AC.setSize(this.AC.getWidth(), this.AC.getHeight());
            this.Bp.add(this.AC, new C0775(mouseEvent.getX() - 25, mouseEvent.getY() - 25, 50, 50));
            this.Bp.setLayer(this.AC, JLayeredPane.DRAG_LAYER);
         }
      } else if (C0795.X(mouseEvent.getX(), mouseEvent.getY())) {
         this.AS = true;
         this.AP = C0795.U(mouseEvent.getX(), mouseEvent.getY());
         if (this.AP > 0 && ((C0795)this.AE.get(this.AP)).vf() != null) {
            this.cT(this.AP);
            this.AC = null;
            this.AC = new JLabel();
            this.AC.setIcon(this.a(this.AP, ((C0795)this.AE.get(this.AP)).x()));
            this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() + -25);
            this.AC.setSize(this.AC.getWidth(), this.AC.getHeight());
            this.Bp.add(this.AC, new C0775(mouseEvent.getX() - 25, mouseEvent.getY() - 25, 50, 50));
            this.Bp.setLayer(this.AC, JLayeredPane.DRAG_LAYER);
         }
      }
   }

   private void c(MouseEvent mouseEvent) {
      this.X(false);
      if (this.AC != null) {
         this.AC.setVisible(false);
         this.AC = null;
      }

      if (C0795.V(mouseEvent.getX(), mouseEvent.getY())) {
         if (this.AS) {
            this.AR = true;
         }

         this.AQ = C0795.S(mouseEvent.getX(), mouseEvent.getY());
         if (this.AQ > 0 && this.AP > 0) {
            this.H(this.AP, this.AQ);
         }
      } else if (C0795.X(mouseEvent.getX(), mouseEvent.getY())) {
         if (this.AR) {
            this.AS = true;
         }

         this.AQ = C0795.U(mouseEvent.getX(), mouseEvent.getY());
         if (this.AQ > 0) {
            if (this.AP > 0) {
               this.H(this.AP, this.AQ);
            }
         } else if (this.AP > 1 && this.AP <= 36) {
            ((C0795)this.AE.get(this.AP)).x();
         }
      }

      if (this.AR) {
         this.cS(-1);
         this.AR = false;
      }

      if (this.AS) {
         this.cT(-1);
         this.AS = false;
      }
   }

   public void cV(int i) {
      C0795 var2 = new C0795();
      this.AE.add(var2);
      var2.vh();
      Collections.swap(this.AE, i, this.AE.size() - 1);
   }

   public void H(int i, int j) {
      boolean var3 = false;
      if (i < this.AE.size() && j < this.AE.size()) {
         if (i <= 36) {
            if (i > 1 && i <= 25 && j <= 25) {
               var3 = true;
            } else if (i != 1 && j >= 25) {
               if ((i > 25 || j > 25) && ((C0795)this.AE.get(i)).vf() != null && ((C0795)this.AE.get(j)).vf() != null) {
                  var3 = true;
               }
            } else if (((C0795)this.AE.get(i)).vf() != null && ((C0795)this.AE.get(j)).vf() != null) {
               var3 = true;
            }
         } else if (((C0795)this.AE.get(i)).vf() != null && ((C0795)this.AE.get(j)).vf() != null) {
            var3 = true;
         }
      }

      if (var3) {
         Collections.swap(this.AE, i, j);
         if (i > 36) {
            if (((C0795)this.AE.get(i)).x() == null) {
               this.AO.add(((C0795)this.AE.get(j)).x());
               this.AE.remove(i);
            }
         } else if (j > 36 && ((C0795)this.AE.get(j)).x() == null) {
            this.AO.add(((C0795)this.AE.get(i)).x());
            this.AE.remove(j);
         }
      }
   }

   public void X(boolean bl) {
      this.Ay.setVisible(bl);
   }

   private void mJ() {
      this.Bp = new C0757();
      this.Be = new JCheckBox();
      this.Bl = new JLabel();
      this.vd = new JPanel();
      this.Bn = new JButton();
      this.Bo = new JButton();
      this.vb = new JButton();
      this.ug = new JLabel();
      this.Bf = new JComboBox();
      this.uh = new JLabel();
      this.Bg = new JComboBox();
      this.Bh = new JComboBox();
      this.a_ = new JLabel();
      this.Bi = new JComboBox();
      this.ur = new JLabel();
      this.we = new JPanel();
      this.Bj = new JLabel();
      this.Bb = new JRadioButton();
      this.Ba = new JRadioButton();
      this.Bc = new JRadioButton();
      this.Bk = new JLabel();
      this.vw = new JLabel();
      this.Bm = new JLabel();
      this.zc = new JLabel();
      this.Bd = new JCheckBox();
      this.vy = new JLabel();
      this.vA = new JLabel();
      this.setBackground(new Color(153, 153, 153));
      this.setPreferredSize(new Dimension(1024, 684));
      this.setLayout(new C0807());
      this.Bp.setBackground(new Color(128, 141, 128));
      this.Bp.setMinimumSize(new Dimension(480, 679));
      this.Bp.setOpaque(true);
      this.Bp.setPreferredSize(new Dimension(1024, 748));
      this.Bp.setLayout(new C0807());
      this.Be.setBackground(new Color(51, 102, 0));
      this.Be.setForeground(new Color(255, 255, 255));
      this.Be.setText("escalação padrão");
      this.Be.setOpaque(false);
      this.Bp.add(this.Be, new C0775(290, 630, 140, 20));
      this.Bl.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campo.png")));
      this.Bl.setAlignmentY(0.0F);
      this.Bl.setRequestFocusEnabled(false);
      this.Bp.add(this.Bl, new C0775(0, 0, 434, 650));
      this.vd.setBackground(new Color(204, 204, 204));
      this.vd.setLayout(new C0807());
      this.Bn.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
      this.Bn.setText("Jogar >>");
      this.vd.add(this.Bn, new C0775(390, 60, 160, 31));
      this.Bo.setIcon(new ImageIcon(this.getClass().getResource("/aicons/home.png")));
      this.Bo.setText("<< Voltar ao time");
      this.vd.add(this.Bo, new C0775(200, 60, 160, 31));
      this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tactics.png")));
      this.vb.setText("táticas salvas");
      this.vd.add(this.vb, new C0775(10, 60, 160, 30));
      this.ug.setText("Seleção Automática:");
      this.vd.add(this.ug, new C0775(10, 10, 123, -1));
      this.vd.add(this.Bf, new C0775(10, 30, 123, -1));
      this.uh.setText("Estilo de jogo:");
      this.vd.add(this.uh, new C0775(150, 10, -1, -1));
      this.vd.add(this.Bg, new C0775(150, 30, 123, -1));
      this.vd.add(this.Bh, new C0775(288, 30, 123, -1));
      this.a_.setText("Marcação:");
      this.vd.add(this.a_, new C0775(290, 10, -1, -1));
      this.vd.add(this.Bi, new C0775(428, 30, 123, -1));
      this.ur.setText("Concentrar ataques:");
      this.vd.add(this.ur, new C0775(430, 10, -1, -1));
      this.Bp.add(this.vd, new C0775(450, 630, 560, 100));
      this.we.setBackground(new Color(204, 204, 204));
      this.we.setLayout(new C0807());
      this.Bj.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisat40.png")));
      this.we.add(this.Bj, new C0775(5, 10, -1, 48));
      this.Bb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisat40.png")));
      this.Bb.setOpaque(false);
      this.we.add(this.Bb, new C0775(385, 10, 40, 50));
      this.Ba.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisat40.png")));
      this.Ba.setOpaque(false);
      this.we.add(this.Ba, new C0775(345, 10, 40, 50));
      this.Bc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisat40.png")));
      this.Bc.setOpaque(false);
      this.we.add(this.Bc, new C0775(305, 10, 40, 50));
      this.Bk.setHorizontalAlignment(0);
      this.Bk.setText("");
      this.we.add(this.Bk, new C0775(45, 40, 120, -1));
      this.vw.setHorizontalAlignment(0);
      this.vw.setText("Adversário:");
      this.vw.setToolTipText("");
      this.we.add(this.vw, new C0775(45, 20, 110, -1));
      this.Bm.setHorizontalAlignment(0);
      this.Bm.setText("Péssima");
      this.Bm.setFocusable(false);
      this.we.add(this.Bm, new C0775(170, 40, 130, -1));
      this.zc.setHorizontalAlignment(0);
      this.zc.setText("Condição do gramado:");
      this.zc.setFocusable(false);
      this.we.add(this.zc, new C0775(170, 20, 130, -1));
      this.Bp.add(this.we, new C0775(10, 660, 430, 70));
      this.Bd.setBackground(new Color(51, 102, 0));
      this.Bd.setFont(new Font("Arial", 0, 12));
      this.Bd.setForeground(new Color(255, 255, 255));
      this.Bd.setText("ver juniores");
      this.Bd.setOpaque(false);
      this.Bp.add(this.Bd, new C0775(880, 185, 140, 20));
      this.vy.setBackground(new Color(51, 51, 51));
      this.vy.setFont(new Font("Arial", 0, 12));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setText("  Jogadores disponíveis");
      this.vy.setOpaque(true);
      this.Bp.add(this.vy, new C0775(435, 185, 590, 20));
      this.vA.setBackground(new Color(51, 102, 0));
      this.vA.setFont(new Font("Arial", 0, 12));
      this.vA.setForeground(new Color(255, 255, 255));
      this.vA.setText("  Banco de reservas");
      this.vA.setOpaque(true);
      this.Bp.add(this.vA, new C0775(435, 0, 590, 20));
      this.add(this.Bp, new C0775(0, 0, 1024, -1));
   }
}
