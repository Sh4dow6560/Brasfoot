package bf22.intermediary;

import mod.recovered.transfer.PlayerSearchCriteria;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableRowSorter;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0395 extends JPanel {
   private JDialog ub;
   private ArrayList uK = new ArrayList();
   private ArrayList vp = new ArrayList();
   private String pU = "Qualquer";
   private Club Af = null;
   private Club zu = null;
   private int w;
   private boolean yp = false;
   private JButton yY;
   private JButton Kf;
   private JScrollPane ut;
   private JLabel zh;
   private C0762 zi;
   private JTable zj;

   public C0395(JDialog jDialog, Club club, boolean bl, int i) {
      this.ub = jDialog;
      this.Af = club;
      this.yp = bl;
      this.w = i;
      if (i == 1) {
         this.mJ();
      } else {
         this.rS();
      }

      if (i == 1) {
         this.nE();
      } else {
         this.nF();
      }

      this.mH();
      this.mK();
      this.mY();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void s(Player player) {
      this.zu = player.getClub();
   }

   private void mK() {
      this.zi.mK();
   }

   public void mH() {
      this.yY.addActionListener(new C0396(this));
      this.Kf.addActionListener(new C0397(this));
      this.zj.getSelectionModel().addListSelectionListener(new C0346(this));
      this.zj.addMouseListener(new C0347(this));
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.zj);
      this.a(this.yY);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0348(this));
      jComponent.getActionMap().put("esc", new C0349(this));
   }

   public void rQ() {
      if (this.zu != null && this.Af != null) {
         MainWindow.a(this.zu, this.Af, this.yp);
      }
   }

   private void rR() {
      this.zi.rR();
   }

   private void nD() {
      PlayerSearchCriteria var1 = new PlayerSearchCriteria();
      var1.setNome(this.zi.uf.getText());
      var1.bv(this.zi.Nq.getSelectedIndex() - 1);
      var1.bw(this.zi.Qx.getSelectedIndex() - 1);
      if (this.w == 1) {
         if (this.zi.QB.getValue() <= this.zi.QB.getMinimum() && this.zi.QB.uv() >= this.zi.QB.getMaximum()) {
            var1.bx(-1);
         } else {
            var1.bM(this.zi.QB.getValue());
            var1.bN(this.zi.QB.uv());
            var1.bx(0);
         }
      } else {
         String[] var2 = new String[]{"gol", "des", "vel", "fin", "arm", "tec", "pas"};
         C0781[] var3 = new C0781[]{this.zi.QN, this.zi.QL, this.zi.QQ, this.zi.QM, this.zi.QK, this.zi.QP, this.zi.QO};

         for (int var4 = 0; var4 < var3.length; var4++) {
            if (var3[var4].getValue() > var3[var4].getMinimum() || var3[var4].uv() < var3[var4].getMaximum()) {
               var1.b(var2[var4], var3[var4].getValue(), var3[var4].uv());
            }
         }
      }

      if (this.zi.QC.getValue() <= this.zi.QC.getMinimum() && this.zi.QC.uv() >= this.zi.QC.getMaximum()) {
         var1.by(-1);
      } else {
         var1.bO(this.zi.QC.getValue());
         var1.bP(this.zi.QC.uv());
         if (this.zi.QC.uv() == this.zi.QC.getMaximum()) {
            var1.bP(100);
         }

         var1.by(0);
      }

      var1.bz(this.zi.Qy.getSelectedIndex() - 1);
      var1.bA(this.zi.Qv.getSelectedIndex() - 1);
      var1.bB(this.zi.Qw.getSelectedIndex() - 1);
      if (this.zi.BD.getSelectedIndex() > 0) {
         String var5 = (String)this.zi.BD.getSelectedItem();
         int var7 = C0732.h(var5);
         var1.bC(((CountryInfo)C0732.cY().get(var7)).getPais());
      }

      var1.bD(this.zi.Qu.getSelectedIndex() - 1);
      var1.E(this.zi.Qs.isSelected());
      var1.F(this.zi.Qt.isSelected());
      var1.G(this.zi.Qr.isSelected());
      var1.H(this.zi.Qq.isSelected());
      this.vp.clear();
      this.uK.clear();
      this.zj.addNotify();
      this.vp = var1.D(false);
      int var6 = 0;

      for (int var8 = 0; var8 < this.vp.size(); var8++) {
         this.uK.add((Player)this.vp.get(var8));
         var6++;
      }

      if (this.uK.size() == 0) {
         this.zh.setText("Nenhum jogador encontrado");
      } else if (this.uK.size() == 1) {
         this.zh.setText("1 jogador encontrado");
      } else {
         this.zh.setText(Integer.toString(this.uK.size()) + " jogadores encontrados");
      }

      if (this.w == 1) {
         this.nE();
      } else {
         this.nF();
      }

      if (this.zj.getRowCount() > 0) {
         this.zj.setRowSelectionInterval(0, 0);
      }
   }

   private void nF() {
      C0569 var1 = new C0569(this.uK, this);
      this.zj.setModel(var1);
      int[] var2 = new int[]{20, 45, 120, 120, 20, 20, 50, 50, 45, 35, 25, 20, 20};
      int[] var3 = new int[]{20, 50, 110, 100, 20, 20, 20, 20, 20, 20, 20, 20, 50, 50, 45, 35, 25, 15, 15};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = var3;
      }

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.zj.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.zj.setAutoResizeMode(3);
      this.zj.setRowHeight(20);
      this.zj.setShowGrid(false);
      this.zj.setDefaultRenderer(Player.class, new C0640());
      this.zj.setAutoCreateRowSorter(false);
      this.zj.getTableHeader().setReorderingAllowed(false);
      this.zj.setIntercellSpacing(new Dimension(0, 0));
      this.zj.setCellSelectionEnabled(false);
      this.zj.setSelectionMode(0);
      this.zj.setRowSelectionAllowed(true);
      this.zj.setSelectionBackground(Color.YELLOW);
      this.zj.setFillsViewportHeight(true);
      TableRowSorter var5 = new TableRowSorter<>(this.zj.getModel());
      this.zj.setRowSorter(var5);
      var5.setComparator(0, C1007.abe);
      var5.setComparator(1, C1007.cL);
      var5.setComparator(2, C1007.abk);
      var5.setComparator(3, C1007.abl);
      var5.setComparator(4, C1007.aba);
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         var5.setComparator(5, C1007.aaJ);
         var5.setComparator(6, C1007.aaZ);
         var5.setComparator(7, C1007.aaW);
         var5.setComparator(9, C1007.abd);
         var5.setComparator(10, C1007.VU);
         var5.setComparator(11, C1007.aaX);
         var5.setComparator(12, C1007.aaY);
      } else {
         var5.setComparator(5, C1007.aaK);
         var5.setComparator(6, C1007.aaM);
         var5.setComparator(7, C1007.aaL);
         var5.setComparator(8, C1007.aaN);
         var5.setComparator(9, C1007.aaP);
         var5.setComparator(10, C1007.aaO);
         var5.setComparator(11, C1007.aaQ);
         var5.setComparator(12, C1007.aaZ);
         var5.setComparator(13, C1007.aaW);
         var5.setComparator(15, C1007.abd);
         var5.setComparator(16, C1007.VU);
         var5.setComparator(17, C1007.aaX);
         var5.setComparator(18, C1007.aaY);
      }
   }

   private void nE() {
      C0569 var1 = new C0569(this.uK, this);
      this.zj.setModel(var1);
      int[] var2 = new int[]{20, 45, 120, 120, 20, 20, 50, 50, 45, 35, 25, 20, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.zj.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.zj.setAutoResizeMode(3);
      this.zj.setRowHeight(20);
      this.zj.setShowGrid(false);
      this.zj.setDefaultRenderer(Player.class, new C0640());
      this.zj.setAutoCreateRowSorter(false);
      this.zj.getTableHeader().setReorderingAllowed(false);
      this.zj.setIntercellSpacing(new Dimension(0, 0));
      this.zj.setCellSelectionEnabled(false);
      this.zj.setSelectionMode(0);
      this.zj.setRowSelectionAllowed(true);
      this.zj.setSelectionBackground(Color.YELLOW);
      this.zj.setFillsViewportHeight(true);
      TableRowSorter var4 = new TableRowSorter<>(this.zj.getModel());
      this.zj.setRowSorter(var4);
      var4.setComparator(0, C1007.abe);
      var4.setComparator(1, C1007.cL);
      var4.setComparator(2, C1007.abk);
      var4.setComparator(3, C1007.abl);
      var4.setComparator(4, C1007.aba);
      var4.setComparator(5, C1007.aaJ);
      var4.setComparator(6, C1007.aaZ);
      var4.setComparator(7, C1007.aaW);
      var4.setComparator(9, C1007.abd);
      var4.setComparator(10, C1007.VU);
      var4.setComparator(11, C1007.aaX);
      var4.setComparator(12, C1007.aaY);
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.zj = new JTable();
      this.zh = new JLabel();
      this.Kf = new JButton();
      this.yY = new JButton();
      this.zi = new C0762(this.ub, this.w);
      this.setBackground(new Color(176, 161, 142));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setMinimumSize(new Dimension(800, 600));
      this.setPreferredSize(new Dimension(800, 600));
      this.setLayout(new C0807());
      this.ut.setViewportView(this.zj);
      this.add(this.ut, new C0775(10, 290, 800, 320));
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setText("");
      this.add(this.zh, new C0775(510, 260, 290, -1));
      this.Kf.setForeground(new Color(51, 102, 0));
      this.Kf.setText("Resetar filtros");
      this.add(this.Kf, new C0775(10, 250, 130, 30));
      this.yY.setForeground(new Color(51, 102, 0));
      this.yY.setText("Procurar");
      this.add(this.yY, new C0775(340, 250, 130, 30));
      this.add(this.zi, new C0775(10, 20, 800, 210));
   }

   private void rS() {
      this.ut = new JScrollPane();
      this.zj = new JTable();
      this.zh = new JLabel();
      this.Kf = new JButton();
      this.yY = new JButton();
      this.zi = new C0762(this.ub, this.w);
      this.setBackground(new Color(176, 161, 142));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setMinimumSize(new Dimension(800, 600));
      this.setPreferredSize(new Dimension(840, 670));
      this.setLayout(new C0807());
      this.ut.setViewportView(this.zj);
      this.add(this.ut, new C0775(10, 370, 815, 280));
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setText("");
      this.add(this.zh, new C0775(530, 330, 173, -1));
      this.Kf.setForeground(new Color(51, 102, 0));
      this.Kf.setText("Resetar");
      this.add(this.Kf, new C0775(10, 330, 105, 30));
      this.yY.setForeground(new Color(51, 102, 0));
      this.yY.setText("Procurar");
      this.add(this.yY, new C0775(340, 330, 105, 30));
      this.add(this.zi, new C0775(10, 10, 815, 300));
   }
}
