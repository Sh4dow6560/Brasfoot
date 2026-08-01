package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Timer;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public class C0435 extends JPanel {
   private JFrame Br;
   private ArrayList cP = new ArrayList();
   private ArrayList cQ = new ArrayList();
   private ArrayList KM = new ArrayList();
   private ArrayList KN = new ArrayList();
   private ArrayList vK = new ArrayList();
   private ArrayList KO = new ArrayList();
   private ArrayList KP = new ArrayList();
   private ArrayList KQ = new ArrayList();
   private int w;
   private CountryCompetitions KR = null;
   private Match KS = null;
   private static int KT = 0;
   private static Timer Dk;
   private JPanel xb = null;
   private int xh = 0;
   private int xi = 0;
   private ArrayList KU = new ArrayList();
   private int KV = -1;
   private Color KW = new Color(211, 191, 22);
   private Color KX = new Color(228, 227, 227);
   private Match KY = null;
   public static Comparator KZ = new C0436();
   private JButton HS;
   private JButton La;
   private JButton zK;
   private JButton Lb;
   private JButton Lc;
   private JComboBox va;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JPanel vd;
   private JScrollPane ut;
   private JScrollPane wi;
   private JScrollPane zf;
   private JScrollPane zg;
   private JLabel Ld;
   private JLabel Le;
   private JLabel Lf;
   private JLabel Lg;
   private JLabel Fq;
   private JLabel yu;
   private JLabel Cg;
   private JLabel Lh;
   private JLabel Li;
   private JLabel Lj;
   private JLabel Lk;
   private JLabel Ll;
   private JLabel Lm;
   private JLabel Ln;
   private JLabel Lo;
   private JLabel Dy;
   private JLabel Dz;
   private JLabel Lp;
   private JLabel Lq;
   private JLabel zO;
   private JLabel zP;
   private JTable DG;
   private JTable Lr;
   private JTable Ls;

   public void oR() {
      Dk = new Timer();
      Dk.schedule(new C0439(this), 0L);
   }

   public C0435(JFrame jFrame) {
      this.Br = jFrame;
      this.mJ();
      this.rY();
      this.rX();
      this.mH();
      this.rZ();
      this.ut.setBorder(BorderFactory.createEmptyBorder());
      this.zf.setBorder(BorderFactory.createEmptyBorder());
      this.zg.setBorder(BorderFactory.createEmptyBorder());
      this.mY();
      this.sd();
      if (GamePersistence.careerState.bD()) {
         this.oR();
      }
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.zK);
      this.a(this.wi);
      this.a(this.va);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0440(this));
   }

   private void b(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(38, 0), "upLinha");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("upLinha", new C0441(this));
   }

   private void c(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(40, 0), "downLinha");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("downLinha", new C0442(this));
   }

   private void nt() {
      this.KU.clear();
      this.xb = new JPanel(new C0807());
      this.xh = 0;
      this.xi = 0;
      this.a(this.xb);
      this.b(this.xb);
      this.c(this.xb);
   }

   private void a(C0826 c0826) {
      byte var3 = 0;
      C0770 var2 = new C0770(c0826, this);
      this.xb.add(var2, new C0775(0, this.xh, 295, 26));
      if (c0826.tR() != null) {
         this.KU.add(var2);
      }

      this.xh = this.xh + 27 + var3;
   }

   public void on() {
      this.zK.requestFocusInWindow();
   }

   private void rX() {
      C0575 var1 = new C0575(this.KP);
      this.Lr.setModel(var1);
      this.Lr.setTableHeader(null);
      int[] var2 = new int[]{180, 20, 25};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Lr.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Lr.setAutoResizeMode(3);
      this.Lr.setRowHeight(20);
      this.Lr.setShowGrid(false);
      this.Lr.setDefaultRenderer(C0814.class, new C0596());
      this.Lr.setAutoCreateRowSorter(false);
      this.Lr.setCellSelectionEnabled(false);
      this.Lr.setRowSelectionAllowed(false);
      this.Lr.setBackground(this.getBackground());
      this.Lr.setFillsViewportHeight(true);
      C0575 var5 = new C0575(this.KQ);
      this.Ls.setModel(var5);
      this.Ls.setTableHeader(null);

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.Ls.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.Ls.setAutoResizeMode(3);
      this.Ls.setRowHeight(20);
      this.Ls.setShowGrid(false);
      this.Ls.setDefaultRenderer(C0814.class, new C0596());
      this.Ls.setAutoCreateRowSorter(false);
      this.Ls.setCellSelectionEnabled(false);
      this.Ls.setRowSelectionAllowed(false);
      this.Ls.setBackground(this.getBackground());
      this.Ls.setFillsViewportHeight(true);
   }

   private void rY() {
      C0662 var1 = new C0662(this.KO);
      this.DG.setModel(var1);
      this.DG.setTableHeader(null);
      int[] var2 = new int[]{20, 180, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.DG.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.DG.setAutoResizeMode(3);
      this.DG.setRowHeight(20);
      this.DG.setShowGrid(false);
      this.DG.setDefaultRenderer(C0667.class, new C0634(true));
      this.DG.setAutoCreateRowSorter(false);
      this.DG.setCellSelectionEnabled(false);
      this.DG.setRowSelectionAllowed(false);
      this.DG.setBackground(this.getBackground());
      this.DG.setFillsViewportHeight(true);
   }

   private void nx() {
      this.zK.setCursor(new Cursor(3));
      if (GamePersistence.careerState.isUsaSons()) {
         C0208.qb();
      }

      boolean var1 = false;
      C0272.aQ(false);
      if (GamePersistence.careerState.isVerLeiloes() && this.KS != null && (this.w == 1 || this.w == 3 || this.w == 10)) {
         ArrayList var2 = new ArrayList();
         int var3 = new Random().nextInt(4);

         for (int var4 = 0; var4 < var3; var4++) {
            C0680 var5 = new C0680();
            if (var5.iA() != null) {
               var2.add(var5);
            }
         }

         C0238.X(var2);
         if (var2.size() > 0 && GamePersistence.careerState.cd()) {
            var1 = true;
         }
      }

      if (var1) {
         MainWindow.aY(8);
      } else {
         GamePersistence.careerState.ax();
      }
   }

   private void mH() {
      this.va.addActionListener(new C0443(this));
      this.zK.addActionListener(new C0444(this));
      this.HS.addActionListener(new C0445(this));
      this.La.addActionListener(new C0446(this));
      this.Lc.addActionListener(new C0437(this));
      this.Lb.addActionListener(new C0438(this));
   }

   private void qV() {
      Competition var1 = null;
      if (this.KY != null) {
         var1 = this.KY.hy();
      }

      this.HS.setCursor(new Cursor(3));
      MainWindow.a(this.w, var1);
      this.HS.setCursor(new Cursor(12));
   }

   public void rr() {
      Club var1 = null;
      if (GamePersistence.careerState.aN().size() > 0) {
         var1 = (Club)GamePersistence.careerState.aN().get(0);
      }

      if (var1 != null && var1.jZ()) {
         String var2 = var1.ka().dS();
         int var3 = -1;
         var3 = JOptionPane.showConfirmDialog(this.Br, var2 + " deseja ser demitido do " + var1.getNome(), "Pedido de demissão", 0);
         if (var3 == 0) {
            Coach var4 = var1.ka();
            Coach var5 = var1.kE();
            MainWindow.a(var4, var5, var1, 0);
         }
      }
   }

   private void cC(int i) {
      if (this.KN.size() > 0) {
         if (this.w == 1) {
            this.e((CountryCompetitions)this.KN.get(i));
         }
      } else if (this.KM.size() > 0) {
         if (this.w == 3) {
            this.a((C0741)this.KM.get(i));
         }
      } else if (this.cQ.size() > 0) {
         this.x((Competition)this.cQ.get(i));
      }

      this.f(0, true);
   }

   private void rZ() {
      C0626 var1 = new C0626();
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(24);
      this.w = 0;
      this.cP.clear();
      this.cP.addAll(((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).t());
      KT = 0;
      if (this.cP.size() > 0) {
         if (((Competition)this.cP.get(0)).b() == 1) {
            this.pB();
            KT = 1;
            this.w = 1;
         } else if (((Competition)this.cP.get(0)).b() == 3) {
            this.sb();
            this.w = 3;
         } else {
            this.w = ((Competition)this.cP.get(0)).b();
            this.sa();
         }
      }
   }

   private void sa() {
      this.cQ.clear();

      for (int var1 = 0; var1 < this.cP.size(); var1++) {
         this.va.addItem(this.cP.get(var1));
         this.cQ.add((Competition)this.cP.get(var1));
      }

      int var5 = 0;
      int var2 = C0737.dL();
      if (var2 >= 0 && var2 < this.cQ.size()) {
         var5 = var2;
      }

      if (this.w == 2) {
         for (int var3 = 0; var3 < this.cQ.size(); var3++) {
            if (this.cQ.get(var3) == C0737.dN()) {
               var5 = var3;
               break;
            }
         }
      }

      if (this.w == 4) {
         for (int var6 = 0; var6 < this.cQ.size(); var6++) {
            if (((Competition)this.cQ.get(var6)).gg() == C0737.dL()) {
               var5 = var6;
               break;
            }
         }
      }

      try {
         this.va.setSelectedIndex(var5);
      } catch (Exception var4) {
      }

      this.x((Competition)this.cQ.get(var5));
   }

   public void x(Competition c0713) {
      this.nt();
      boolean var2 = true;
      byte var3 = 0;
      byte var4 = 0;

      for (int var5 = 0; var5 < GamePersistence.careerState.getCurrentMatches().size(); var5++) {
         if (((Match)GamePersistence.careerState.getCurrentMatches().get(var5)).hy() == c0713) {
            var3 = -1;
            if (var3 != var4) {
               var2 = true;
            }

            if (var2) {
               C0826 var6 = new C0826();
               var6.D(((Match)GamePersistence.careerState.getCurrentMatches().get(var5)).ij());
               this.a(var6);
               var2 = false;
               var4 = var3;
            }

            C0826 var9 = new C0826();
            var9.n((Match)GamePersistence.careerState.getCurrentMatches().get(var5));
            this.a(var9);
         }
      }

      JViewport var8 = this.wi.getViewport();
      var8.setView(this.xb);
   }

   private void sb() {
      this.KM.clear();

      for (int var1 = 0; var1 < GamePersistence.careerState.aE().size(); var1++) {
         for (int var2 = 0; var2 < this.cP.size(); var2++) {
            if (((Competition)this.cP.get(var2)).ir() == GamePersistence.careerState.aE().get(var1) && !this.cQ.contains(GamePersistence.careerState.aE().get(var1))) {
               this.va.addItem(GamePersistence.careerState.aE().get(var1));
               this.KM.add((C0741)GamePersistence.careerState.aE().get(var1));
            }
         }
      }

      int var4 = C0737.dL();
      int var5 = this.KM.size() - 1;
      if (var4 >= 0) {
         for (int var3 = 0; var3 < this.KM.size(); var3++) {
            if (((C0741)this.KM.get(var3)).getEstado() == var4) {
               var5 = var3;
               break;
            }
         }
      }

      this.va.setSelectedIndex(var5);
      this.a((C0741)this.KM.get(var5));
   }

   private void pB() {
      this.KN.clear();

      for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
         for (int var2 = 0; var2 < this.cP.size(); var2++) {
            if (((Competition)this.cP.get(var2)).iq() == GamePersistence.careerState.N().get(var1) && !this.KN.contains(GamePersistence.careerState.N().get(var1))) {
               try {
                  this.va.addItem(GamePersistence.careerState.N().get(var1));
               } catch (Exception var5) {
               }

               this.KN.add((CountryCompetitions)GamePersistence.careerState.N().get(var1));
            }
         }
      }

      int var6 = C0737.dL();
      int var7 = this.KN.size() - 1;
      if (var6 >= 0) {
         for (int var3 = 0; var3 < this.KN.size(); var3++) {
            if (((CountryCompetitions)this.KN.get(var3)).jc() == var6) {
               var7 = var3;
               this.KR = (CountryCompetitions)this.KN.get(var3);
               break;
            }
         }
      }

      try {
         this.va.setSelectedIndex(var7);
      } catch (Exception var4) {
      }

      this.e((CountryCompetitions)this.KN.get(var7));
   }

   public void a(C0741 c0741) {
      this.nt();
      boolean var2 = true;
      int var3 = 0;
      int var4 = 0;
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 < GamePersistence.careerState.getCurrentMatches().size(); var6++) {
         if (((Match)GamePersistence.careerState.getCurrentMatches().get(var6)).hy() instanceof StateChampionship && ((StateChampionship)((Match)GamePersistence.careerState.getCurrentMatches().get(var6)).hy()).yj() == c0741) {
            var5.add((Match)GamePersistence.careerState.getCurrentMatches().get(var6));
         }
      }

      for (int var9 = 0; var9 < var5.size(); var9++) {
         var3 = ((Match)var5.get(var9)).hy().ip();
         if (var3 != var4) {
            var2 = true;
         }

         if (var2) {
            C0826 var7 = new C0826();
            var7.D(((Match)var5.get(var9)).ij());
            this.a(var7);
            var2 = false;
            var4 = var3;
         }

         C0826 var11 = new C0826();
         var11.n((Match)var5.get(var9));
         this.a(var11);
      }

      JViewport var10 = this.wi.getViewport();
      var10.setView(this.xb);
   }

   private int sc() {
      for (int var1 = 0; var1 < this.vK.size(); var1++) {
         if (((C0831)this.vK.get(var1)).tR() != null && (((C0831)this.vK.get(var1)).tR().hc().jZ() || ((C0831)this.vK.get(var1)).tR().hd().jZ())) {
            return var1;
         }
      }

      return -1;
   }

   public void dz(int i) {
      int var2 = 0;
      if (i == 0) {
         var2 = this.KV + 1;
      } else {
         var2 = this.KV - 1;
      }

      if (var2 < 0) {
         var2 = 0;
      }

      if (var2 >= this.KU.size()) {
         var2 = this.KU.size() - 1;
      }

      this.f(var2, true);
      this.se();
   }

   public void f(int i, boolean bl) {
      for (int var3 = i; var3 < this.KU.size(); var3++) {
         if (((C0770)this.KU.get(var3)).tR() != null) {
            if (bl) {
               this.i(((C0770)this.KU.get(var3)).tR());
            }

            if (this.KV >= 0 && this.KV < this.KU.size()) {
               ((C0770)this.KU.get(this.KV)).e(this.KX);
            }

            ((C0770)this.KU.get(var3)).e(this.KW);
            this.KV = var3;
            break;
         }
      }
   }

   public void a(C0770 c0770, Match c0675) {
      this.xb.requestFocusInWindow();
      if (this.KV >= 0 && this.KV < this.KU.size()) {
         ((C0770)this.KU.get(this.KV)).e(this.KX);
      }

      for (int var3 = 0; var3 < this.KU.size(); var3++) {
         if (c0770 == this.KU.get(var3)) {
            this.KV = var3;
            break;
         }
      }

      if (c0675 != null) {
         this.i(c0675);
      }

      c0770.e(this.KW);
   }

   public void e(CountryCompetitions c0692) {
      this.nt();
      boolean var2 = true;
      int var3 = 0;
      int var4 = 0;

      for (int var5 = 0; var5 < GamePersistence.careerState.getCurrentMatches().size(); var5++) {
         if (((Match)GamePersistence.careerState.getCurrentMatches().get(var5)).hy().iq() == c0692) {
            var3 = ((Match)GamePersistence.careerState.getCurrentMatches().get(var5)).hy().ip();
            if (var3 != var4) {
               var2 = true;
            }

            if (var2) {
               var2 = false;
               var4 = var3;
               C0826 var6 = new C0826();
               var6.D(((Match)GamePersistence.careerState.getCurrentMatches().get(var5)).ij());
               this.a(var6);
            }

            C0826 var9 = new C0826();
            var9.n((Match)GamePersistence.careerState.getCurrentMatches().get(var5));
            this.a(var9);
         }
      }

      JViewport var8 = this.wi.getViewport();
      var8.setView(this.xb);
   }

   public void sd() {
      for (int var1 = 0; var1 < GamePersistence.careerState.getCurrentMatches().size(); var1++) {
         if (((Match)GamePersistence.careerState.getCurrentMatches().get(var1)).hc().jZ() || ((Match)GamePersistence.careerState.getCurrentMatches().get(var1)).hd().jZ()) {
            this.KS = (Match)GamePersistence.careerState.getCurrentMatches().get(var1);
            break;
         }
      }

      if (this.KS != null) {
         int var3 = -1;

         for (int var2 = 0; var2 < this.cQ.size(); var2++) {
            if (this.cQ.get(var2) == this.KS.hy()) {
               var3 = var2;
               break;
            }
         }

         if (var3 >= 0 && var3 < this.va.getItemCount()) {
            this.va.setSelectedIndex(var3);
         }

         this.i(this.KS);
      } else {
         this.i(((C0770)this.KU.get(0)).tR());
      }

      for (int var4 = 0; var4 < this.KU.size(); var4++) {
         if (((C0770)this.KU.get(var4)).tR() != null && ((C0770)this.KU.get(var4)).tR() == this.KS) {
            this.f(var4, false);
            this.se();
            break;
         }

         this.f(0, false);
      }
   }

   private void se() {
      Point var1 = this.wi.getViewport().getViewPosition();
      var1.y = this.KV * 26;
      this.wi.getViewport().setViewPosition(var1);
   }

   public void i(Match c0675) {
      if (c0675 != null && c0675 != this.KY) {
         this.KY = c0675;
         this.zO.setForeground(c0675.hc().kC());
         this.zO.setBackground(c0675.hc().kB());
         this.zP.setForeground(c0675.hd().kC());
         this.zP.setBackground(c0675.hd().kB());
         if (c0675.ev() != null) {
            this.Cg.setText(c0675.ev().dS());
            this.Dz.setText(ClubFinances.a(c0675.hN(), 0));
            this.Dy.setText(Integer.toString(c0675.hU()));
            this.Dy.setToolTipText(c0675.hV());
         } else if (c0675.il() != null) {
            this.Cg.setText(c0675.il().dS());
            this.Dz.setText(ClubFinances.a(c0675.hN(), 0));
            this.Dy.setText(Integer.toString(c0675.hU()));
            this.Dy.setToolTipText(c0675.hV());
         } else {
            if (c0675.ik() != null) {
               this.Cg.setText(c0675.ik());
            } else if (c0675.hc().lp()) {
               this.Cg.setText(c0675.hc().getNome());
            }

            this.Dz.setText("n/i");
            this.Dy.setText("n/i");
         }

         int[] var2 = c0675.hQ();
         if (var2[0] >= 0 && var2[1] >= 0) {
            this.Ll.setText("P:" + Integer.toString(var2[0]) + "x" + Integer.toString(var2[1]));
         } else {
            this.Ll.setText("");
         }

         this.Lm.setText(c0675.hu() + " x " + c0675.hw());
         this.zO.setText(c0675.hc().getNome() + " ");
         this.zP.setText(" " + c0675.hd().getNome());
         if (c0675.hc().jY() != null) {
            this.Fq.setIcon(c0675.hc().kP());
         } else {
            this.Fq.setIcon(c0675.hc().K(true));
         }

         if (c0675.hd().jY() != null) {
            this.yu.setIcon(c0675.hd().kP());
         } else {
            this.yu.setIcon(c0675.hd().K(true));
         }

         this.k(c0675);
         this.a(c0675, 1);
         this.a(c0675, 2);
         this.Lr.addNotify();
         this.Ls.addNotify();
         this.j(c0675);
      }
   }

   private void j(Match c0675) {
      this.KO.clear();
      ArrayList var2 = null;
      ArrayList var3 = null;
      Object var4 = null;
      ArrayList var5 = null;

      for (int var6 = 0; var6 < c0675.hE().size(); var6++) {
         ((C0667)c0675.hE().get(var6)).p(true);
      }

      for (int var7 = 0; var7 < c0675.hE().size(); var7++) {
         if (((C0667)c0675.hE().get(var7)).b() == 1) {
            if (var2 == null) {
               var2 = new ArrayList();
            }

            var2.add((C0667)c0675.hE().get(var7));
         } else if (((C0667)c0675.hE().get(var7)).b() >= 2 && ((C0667)c0675.hE().get(var7)).b() <= 4) {
            if (var3 == null) {
               var3 = new ArrayList();
            }

            var3.add((C0667)c0675.hE().get(var7));
         } else if (((C0667)c0675.hE().get(var7)).b() == 5) {
            if (var5 == null) {
               var5 = new ArrayList();
            }

            var5.add((C0667)c0675.hE().get(var7));
         }
      }

      if (var2 != null) {
         this.KO.add(new C0667(91, true));
         this.KO.addAll(var2);
      }

      if (var3 != null) {
         this.KO.add(new C0667(92, true));
         this.KO.addAll(var3);
      }

      if (var5 != null) {
         this.KO.add(new C0667(95, true));
         this.KO.addAll(var5);
      }

      this.DG.addNotify();
   }

   private void k(Match c0675) {
      this.Ln.setText(Integer.toString(c0675.hz()[0]));
      this.Lo.setText(Integer.toString(c0675.hz()[1]));
      this.Lp.setText(Integer.toString(c0675.hA()[0]));
      this.Lq.setText(Integer.toString(c0675.hA()[1]));
      this.Lh.setText(Integer.toString(c0675.hZ()[0]) + "(" + Integer.toString(c0675.ia()[0]) + ")");
      this.Li.setText(Integer.toString(c0675.hZ()[1]) + "(" + Integer.toString(c0675.ia()[1]) + ")");
      this.Le.setText(Integer.toString(c0675.hB()[0]));
      this.Lf.setText(Integer.toString(c0675.hB()[1]));
      this.Lj.setText(Integer.toString(c0675.hC()[0]));
      this.Lk.setText(Integer.toString(c0675.hC()[1]));
   }

   private void a(Match c0675, int i) {
      ArrayList var3;
      ArrayList var4;
      Club var5;
      if (i == 1) {
         var3 = this.KP;
         var4 = c0675.hl();
         var5 = c0675.hc();
      } else {
         var3 = this.KQ;
         var4 = c0675.hm();
         var5 = c0675.hd();
      }

      var3.clear();

      for (int var6 = 0; var6 < var4.size(); var6++) {
         C0814 var7 = new C0814();
         var7.h((Player)var4.get(var6));
         var3.add(var7);
      }

      Collections.sort(var3, KZ);
      C0814 var11 = new C0814();
      var11.an(true);
      var3.add(var11);
      C0814 var12 = new C0814();
      var12.ao(true);
      var3.add(var12);

      for (int var8 = 0; var8 < c0675.hE().size(); var8++) {
         if (((C0667)c0675.hE().get(var8)).b() == 6 && ((C0667)c0675.hE().get(var8)).cu() == var5) {
            C0814 var9 = new C0814();
            var9.h(((C0667)c0675.hE().get(var8)).ep());
            var9.ap(true);
            var9.K(((C0667)c0675.hE().get(var8)).eq());
            var3.add(var9);
            C0814 var10 = new C0814();
            var10.h(((C0667)c0675.hE().get(var8)).eo());
            var10.aq(true);
            var3.add(var10);
         }
      }
   }

   private int a(ArrayList arrayList, Player player) {
      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         if (((C0814)arrayList.get(var3)).fb().equals(player)) {
            return var3;
         }
      }

      return -1;
   }

   public static String h(Match c0675) {
      String var1 = null;
      if (c0675.hy().b() == 3) {
         var1 = c0675.hy().getNome() + " " + c0675.hy().ip();
      }

      return var1;
   }

   public static int sf() {
      return KT;
   }

   private void mJ() {
      this.va = new JComboBox();
      this.wi = new JScrollPane();
      this.zf = new JScrollPane();
      this.Lr = new JTable();
      this.zg = new JScrollPane();
      this.Ls = new JTable();
      this.zK = new JButton();
      this.Ll = new JLabel();
      this.Lm = new JLabel();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.Lo = new JLabel();
      this.Ln = new JLabel();
      this.Lp = new JLabel();
      this.Lq = new JLabel();
      this.Li = new JLabel();
      this.Lh = new JLabel();
      this.Lf = new JLabel();
      this.Le = new JLabel();
      this.Lg = new JLabel();
      this.Lk = new JLabel();
      this.Lj = new JLabel();
      this.ut = new JScrollPane();
      this.DG = new JTable();
      this.zO = new JLabel();
      this.Cg = new JLabel();
      this.zP = new JLabel();
      this.Dz = new JLabel();
      this.Dy = new JLabel();
      this.Fq = new JLabel();
      this.yu = new JLabel();
      this.Lb = new JButton();
      this.La = new JButton();
      this.HS = new JButton();
      this.Lc = new JButton();
      this.Ld = new JLabel();
      this.setBackground(new Color(12, 54, 77));
      this.setPreferredSize(new Dimension(1024, 735));
      this.setLayout(new C0807());
      this.add(this.va, new C0775(19, 20, 300, 30));
      this.wi.setHorizontalScrollBarPolicy(31);
      this.add(this.wi, new C0775(19, 60, 300, 585));
      this.zf.setViewportView(this.Lr);
      this.add(this.zf, new C0775(330, 150, 230, 490));
      this.zg.setViewportView(this.Ls);
      this.add(this.zg, new C0775(778, 150, 230, 490));
      this.zK.setText("Continuar >>");
      this.add(this.zK, new C0775(870, 670, 140, 40));
      this.Ll.setForeground(new Color(255, 255, 255));
      this.Ll.setHorizontalAlignment(0);
      this.Ll.setText("");
      this.add(this.Ll, new C0775(610, 70, 120, -1));
      this.Lm.setFont(new Font("Tahoma", 1, 24));
      this.Lm.setForeground(new Color(255, 255, 255));
      this.Lm.setHorizontalAlignment(0);
      this.Lm.setText("0 x 0");
      this.add(this.Lm, new C0775(550, 30, 250, -1));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(0);
      this.uh.setText("finalizações");
      this.add(this.uh, new C0775(610, 542, 110, -1));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(0);
      this.a_.setText("erros passes");
      this.add(this.a_, new C0775(620, 620, 90, -1));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(0);
      this.ur.setText("posse de bola");
      this.add(this.ur, new C0775(620, 514, 90, -1));
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setHorizontalAlignment(0);
      this.us.setText("no gol (fora)");
      this.add(this.us, new C0775(610, 568, 100, -1));
      this.Lo.setForeground(new Color(255, 255, 255));
      this.Lo.setText("58%");
      this.Lo.setToolTipText("");
      this.add(this.Lo, new C0775(722, 514, 30, -1));
      this.Ln.setForeground(new Color(255, 255, 255));
      this.Ln.setHorizontalAlignment(0);
      this.Ln.setText("58%");
      this.Ln.setToolTipText("");
      this.add(this.Ln, new C0775(580, 513, -1, -1));
      this.Lp.setForeground(new Color(255, 255, 255));
      this.Lp.setHorizontalAlignment(0);
      this.Lp.setText("12");
      this.Lp.setToolTipText("");
      this.add(this.Lp, new C0775(580, 542, 20, -1));
      this.Lq.setForeground(new Color(255, 255, 255));
      this.Lq.setHorizontalAlignment(0);
      this.Lq.setText("12");
      this.Lq.setToolTipText("");
      this.add(this.Lq, new C0775(722, 542, 30, -1));
      this.Li.setForeground(new Color(255, 255, 255));
      this.Li.setHorizontalAlignment(0);
      this.Li.setText("12(10)");
      this.Li.setToolTipText("");
      this.add(this.Li, new C0775(720, 568, -1, -1));
      this.Lh.setForeground(new Color(255, 255, 255));
      this.Lh.setText("12(10)");
      this.Lh.setToolTipText("");
      this.add(this.Lh, new C0775(576, 568, -1, -1));
      this.Lf.setForeground(new Color(255, 255, 255));
      this.Lf.setHorizontalAlignment(0);
      this.Lf.setText("1");
      this.Lf.setToolTipText("");
      this.add(this.Lf, new C0775(720, 596, 30, -1));
      this.Le.setForeground(new Color(255, 255, 255));
      this.Le.setHorizontalAlignment(0);
      this.Le.setText("2");
      this.Le.setToolTipText("");
      this.add(this.Le, new C0775(580, 596, 20, -1));
      this.Lg.setForeground(new Color(255, 255, 255));
      this.Lg.setHorizontalAlignment(0);
      this.Lg.setText("desarmes");
      this.add(this.Lg, new C0775(610, 596, 110, -1));
      this.Lk.setForeground(new Color(255, 255, 255));
      this.Lk.setHorizontalAlignment(0);
      this.Lk.setText("12");
      this.Lk.setToolTipText("");
      this.add(this.Lk, new C0775(722, 620, 30, -1));
      this.Lj.setForeground(new Color(255, 255, 255));
      this.Lj.setHorizontalAlignment(0);
      this.Lj.setText("12");
      this.Lj.setToolTipText("");
      this.add(this.Lj, new C0775(580, 620, 20, -1));
      this.ut.setBorder(null);
      this.ut.setViewportView(this.DG);
      this.add(this.ut, new C0775(570, 180, 196, 320));
      this.zO.setBackground(new Color(0, 51, 204));
      this.zO.setFont(new Font("Tahoma", 1, 14));
      this.zO.setForeground(new Color(255, 255, 255));
      this.zO.setHorizontalAlignment(4);
      this.zO.setText("");
      this.zO.setOpaque(true);
      this.add(this.zO, new C0775(330, 120, 230, 30));
      this.Cg.setForeground(new Color(255, 255, 255));
      this.Cg.setText("");
      this.add(this.Cg, new C0775(620, 120, 130, -1));
      this.zP.setBackground(new Color(153, 0, 0));
      this.zP.setFont(new Font("Tahoma", 1, 14));
      this.zP.setForeground(new Color(255, 255, 255));
      this.zP.setHorizontalAlignment(2);
      this.zP.setText("");
      this.zP.setOpaque(true);
      this.add(this.zP, new C0775(778, 120, 230, 30));
      this.Dz.setForeground(new Color(255, 255, 255));
      this.Dz.setText("");
      this.add(this.Dz, new C0775(690, 150, 60, -1));
      this.Dy.setForeground(new Color(255, 255, 255));
      this.Dy.setText("120 236");
      this.add(this.Dy, new C0775(620, 150, 50, -1));
      this.Fq.setHorizontalAlignment(4);
      this.add(this.Fq, new C0775(450, 20, 60, 60));
      this.add(this.yu, new C0775(830, 20, 60, 60));
      this.Lb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconfire.png")));
      this.add(this.Lb, new C0775(210, 670, 50, 40));
      this.La.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
      this.add(this.La, new C0775(30, 670, 50, 40));
      this.HS.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon04.png")));
      this.add(this.HS, new C0775(90, 670, 50, 40));
      this.Lc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_green.png")));
      this.add(this.Lc, new C0775(150, 670, 50, 40));
      this.Ld.setHorizontalAlignment(4);
      this.Ld.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/results04.png")));
      this.Ld.setMaximumSize(new Dimension(60, 60));
      this.Ld.setMinimumSize(new Dimension(60, 60));
      this.Ld.setPreferredSize(new Dimension(60, 60));
      this.add(this.Ld, new C0775(0, 0, 1024, 750));
   }
}
