package bf22.intermediary;

import mod.recovered.transfer.PlayerSearchCriteria;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0043 extends JPanel {
   private JDialog ub;
   private Club hy;
   private ArrayList uK = new ArrayList();
   private ArrayList vp = new ArrayList();
   private String pU = "Qualquer";
   private int pais = -1;
   private Player yK = null;
   private Player yL = null;
   private int yM = 2;
   private int yN = 16;
   private int yO = 3;
   private int yP = 27;
   private boolean yQ = false;
   private int yR = 3;
   private boolean yS = false;
   private int yT = 35;
   private int yU = 275;
   private JButton yV;
   private JButton yW;
   private JButton yX;
   private JButton vm;
   private JButton yY;
   private JButton yZ;
   private JButton za;
   private JLabel ug;
   private JLabel zb;
   private JLabel zc;
   private JLabel zd;
   private JLabel ze;
   private JScrollPane zf;
   private JScrollPane zg;
   private JLabel zh;
   private C0762 zi;
   private JTable zj;
   private JTable zk;

   public C0043(JDialog jDialog, Club club, boolean bl) {
      this.ub = jDialog;
      this.hy = club;
      this.pais = club.getPais();
      this.yQ = bl;
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         this.yR = 4;
      }

      if (this.yR == 4) {
         this.yU = 220;
         this.yT = 55;
      }

      this.mJ();
      this.mK();
      this.mH();
      this.nE();
      this.nF();
      if (this.yS) {
         this.yP = 27;
      }

      int var4 = C0732.G(this.pais) + 1;
      this.zi.BD.addItem(((CountryInfo)C0732.cY().get(var4 - 1)).getNome());
      if (var4 < this.zi.BD.getItemCount()) {
         this.zi.BD.setSelectedIndex(var4);
      }

      this.ug.setText("Convocar jogadores para seleção - " + club.getNome());
      if (!this.jk()) {
         C0677.r(this.pais, this.hy.getNivel());
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mK() {
      this.zi.mK();
   }

   public boolean jk() {
      int var1 = 0;
      int var2 = 0;

      for (int var3 = 0; var3 < GamePersistence.careerState.O().size(); var3++) {
         if (((Player)GamePersistence.careerState.O().get(var3)).getPais() == this.pais) {
            if (((Player)GamePersistence.careerState.O().get(var3)).getPosicao() == 0) {
               var2++;
            } else {
               var1++;
            }
         }
      }

      for (int var4 = 0; var4 < GamePersistence.careerState.bN().size(); var4++) {
         if (((Player)GamePersistence.careerState.bN().get(var4)).getPais() == this.pais) {
            if (((Player)GamePersistence.careerState.bN().get(var4)).getPosicao() == 0) {
               var2++;
            } else {
               var1++;
            }
         }
      }

      return var1 >= 16 && var2 >= 2;
   }

   private void nx() {
      CountryCompetitions var1 = GamePersistence.careerState.s(this.pais);
      var1.jj();
      if (!var1.jl()) {
         this.yM = 1;
         this.yN = 10;
      }

      int[] var2 = this.nC();
      if (var2[0] >= this.yM && var2[1] >= this.yN) {
         this.ub.dispose();
      } else {
         JOptionPane.showMessageDialog(this.ub, "Convoque 2 goleiros e 15 na linha, ou clique em convocação automática", "Mínimo de jogadores", 2);
      }
   }

   public void mH() {
      this.vm.addActionListener(new C0044(this));
      this.yY.addActionListener(new C0045(this));
      this.yV.addActionListener(new C0046(this));
      this.yZ.addActionListener(new C0047(this));
      this.yW.addActionListener(new C0048(this));
      this.yX.addActionListener(new C0049(this));
      this.za.addActionListener(new C0050(this));
   }

   private void ny() {
      this.hy.kc().clear();
      ((C0657)this.zk.getModel()).fireTableDataChanged();
      this.nC();
      this.zk.addNotify();
   }

   private void nz() {
      CountryCompetitions var1 = GamePersistence.careerState.s(this.pais);
      var1.z(false);
      this.nF();
      this.uK.clear();
      this.zj.addNotify();
   }

   private void nA() {
      if (this.zj.getSelectedRowCount() > 0) {
         int[] var1 = this.nC();
         boolean var2 = true;
         int var3 = this.zj.convertRowIndexToModel(this.zj.getSelectedRow());
         this.yK = ((C0657)this.zj.getModel()).ev(var3);
         if (this.yK.getPosicao() == 0) {
            if (var1[0] >= this.yO) {
               var2 = false;
            }
         } else if (var1[1] >= this.yP) {
            var2 = false;
         }

         if (var2) {
            if (!this.hy.kc().contains(this.yK)) {
               this.hy.kc().add(this.yK);
               Collections.sort(this.hy.kc(), C1007.abe);
               this.uK.remove(this.yK);
               ((C0657)this.zj.getModel()).fireTableDataChanged();
               if (this.zj.getRowCount() > 0) {
                  this.zj.setRowSelectionInterval(0, 0);
               }

               this.zj.addNotify();
               this.zk.addNotify();
               int[] var4 = this.nC();
               this.zd.setText(Integer.toString(var4[0]));
               this.ze.setText(Integer.toString(var4[1]));
            }
         } else {
            JOptionPane.showMessageDialog(
               this.ub,
               "Máximo:" + Integer.toString(this.yO) + " goleiros\n" + "Máximo:" + Integer.toString(this.yP) + " na linha\n",
               "Limite de jogadores atingido",
               2
            );
         }
      }
   }

   private void nB() {
      if (this.zk.getSelectedRowCount() > 0) {
         int var1 = this.zk.convertRowIndexToModel(this.zk.getSelectedRow());
         this.yL = ((C0657)this.zk.getModel()).ev(var1);
         this.hy.kc().remove(this.yL);
         this.uK.add(0, this.yL);
         ((C0657)this.zk.getModel()).fireTableDataChanged();
         if (this.zk.getRowCount() > 0) {
            this.zk.setRowSelectionInterval(0, 0);
         }

         this.zj.addNotify();
         this.zk.addNotify();
         int[] var2 = this.nC();
         this.zd.setText(Integer.toString(var2[0]));
         this.ze.setText(Integer.toString(var2[1]));
         ((C0657)this.zj.getModel()).fireTableDataChanged();
      }
   }

   private int[] nC() {
      int[] var1 = new int[2];

      for (int var2 = 0; var2 < this.hy.kc().size(); var2++) {
         if (((Player)this.hy.kc().get(var2)).getPosicao() == 0) {
            var1[0]++;
         } else {
            var1[1]++;
         }
      }

      return var1;
   }

   private void nD() {
      PlayerSearchCriteria var1 = new PlayerSearchCriteria();
      var1.setNome(this.zi.uf.getText());
      var1.bv(this.zi.Nq.getSelectedIndex() - 1);
      var1.bw(this.zi.Qx.getSelectedIndex() - 1);
      if (this.yR == 4) {
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
      var1.bC(this.pais);
      var1.bD(this.zi.Qu.getSelectedIndex() - 1);
      var1.E(this.zi.Qs.isSelected());
      var1.F(this.zi.Qt.isSelected());
      this.vp.clear();
      this.uK.clear();
      this.vp = var1.D(true);
      int var5 = 0;

      for (int var6 = 0; var6 < this.vp.size(); var6++) {
         if (!this.hy.kc().contains(this.vp.get(var6))) {
            this.uK.add((Player)this.vp.get(var6));
            var5++;
         }
      }

      ((C0657)this.zj.getModel()).fireTableDataChanged();
      if (this.uK.size() == 0) {
         this.zh.setText("Nenhum jogador encontrado");
      } else if (this.uK.size() == 1) {
         this.zh.setText("1 jogador encontrado");
      } else {
         this.zh.setText(Integer.toString(this.uK.size()) + " jogadores encontrados");
      }

      this.zj.addNotify();
   }

   public void s(Player player) {
   }

   private void nE() {
      C0657 var1 = new C0657(this.uK, this, 1);
      this.zj.setModel(var1);
      int[] var2 = new int[]{20, 120, 100, 20, 25, 55, 25};
      int[] var3 = new int[]{20, 90, 85, 25, 25, 25, 25, 25, 25, 25, 25, 50, 20};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = var3;
      }

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.zj.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.zj.setAutoResizeMode(3);
      this.zj.setRowHeight(20);
      this.zj.setShowGrid(false);
      this.zj.setDefaultRenderer(Player.class, new C0630());
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
      var5.setComparator(1, C1007.abk);
      var5.setComparator(2, C1007.abl);
      var5.setComparator(3, C1007.aba);
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         var5.setComparator(4, C1007.aaJ);
         var5.setComparator(6, C1007.VU);
      } else {
         var5.setComparator(4, C1007.aaK);
         var5.setComparator(5, C1007.aaM);
         var5.setComparator(6, C1007.aaL);
         var5.setComparator(7, C1007.aaN);
         var5.setComparator(8, C1007.aaP);
         var5.setComparator(9, C1007.aaO);
         var5.setComparator(10, C1007.aaQ);
         var5.setComparator(11, C1007.VU);
      }
   }

   private void nF() {
      C0657 var1 = new C0657(this.hy.kc(), this, 2);
      this.zk.setModel(var1);
      int[] var2 = new int[]{25, 120, 120, 20, 20, 45, 25};
      int[] var3 = new int[]{20, 90, 90, 20};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = var3;
      }

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.zk.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.zk.setAutoResizeMode(3);
      this.zk.setRowHeight(20);
      this.zk.setShowGrid(false);
      this.zk.setDefaultRenderer(Player.class, new C0630());
      this.zk.setAutoCreateRowSorter(false);
      this.zk.getTableHeader().setReorderingAllowed(false);
      this.zk.setIntercellSpacing(new Dimension(0, 0));
      this.zk.setCellSelectionEnabled(false);
      this.zk.setSelectionMode(0);
      this.zk.setRowSelectionAllowed(true);
      this.zk.setSelectionBackground(Color.YELLOW);
      TableRowSorter var6 = new TableRowSorter<>(this.zk.getModel());
      this.zk.setRowSorter(var6);
      var6.setComparator(0, C1007.abe);
      var6.setComparator(1, C1007.abk);
      var6.setComparator(2, C1007.abl);
      var6.setComparator(3, C1007.aba);
      this.zk.setFillsViewportHeight(true);
      if (this.zk.getRowCount() > 0) {
         this.zk.setRowSelectionInterval(0, 0);
      }

      int[] var5 = this.nC();
      this.zd.setText(Integer.toString(var5[0]));
      this.ze.setText(Integer.toString(var5[1]));
   }

   private void mJ() {
      this.ug = new JLabel();
      this.zf = new JScrollPane();
      this.zj = new JTable();
      this.zg = new JScrollPane();
      this.zk = new JTable();
      this.yW = new JButton();
      this.yX = new JButton();
      this.yV = new JButton();
      this.yZ = new JButton();
      this.zb = new JLabel();
      this.zd = new JLabel();
      this.ze = new JLabel();
      this.vm = new JButton();
      this.zc = new JLabel();
      this.za = new JButton();
      this.zh = new JLabel();
      this.yY = new JButton();
      this.zi = new C0762(null, this.yR);
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setMinimumSize(new Dimension(800, 700));
      this.setPreferredSize(new Dimension(800, 700));
      this.setLayout(new C0807());
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 153));
      this.ug.setHorizontalAlignment(2);
      this.ug.setText("");
      this.add(this.ug, new C0775(20, 15, 510, -1));
      this.zf.setViewportView(this.zj);
      this.add(this.zf, new C0775(10, 366, 470, 320));
      this.zg.setViewportView(this.zk);
      this.add(this.zg, new C0775(545, 365, 380, 289));
      this.yW.setText("Convocação automática");
      this.add(this.yW, new C0775(745, 660, 180, -1));
      this.yX.setText("Desconvocar todos");
      this.add(this.yX, new C0775(545, 660, 170, -1));
      this.yV.setText(">>");
      this.add(this.yV, new C0775(490, 365, -1, -1));
      this.yZ.setText("<<");
      this.add(this.yZ, new C0775(490, 395, -1, -1));
      this.zb.setForeground(new Color(255, 255, 255));
      this.zb.setText("Convocados:");
      this.add(this.zb, new C0775(550, 340, -1, -1));
      this.zd.setForeground(new Color(255, 255, 255));
      this.zd.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconG.png")));
      this.zd.setText("12");
      this.add(this.zd, new C0775(630, 340, -1, -1));
      this.ze.setForeground(new Color(255, 255, 255));
      this.ze.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_greensmall.png")));
      this.ze.setText("20");
      this.add(this.ze, new C0775(680, 340, -1, -1));
      this.vm.setForeground(new Color(51, 102, 0));
      this.vm.setText("Continuar >>");
      this.add(this.vm, new C0775(760, 320, 160, 30));
      this.zc.setForeground(new Color(255, 255, 255));
      this.zc.setHorizontalAlignment(4);
      this.zc.setText("(mínimo 2 gol. e 15 de linha) ");
      this.add(this.zc, new C0775(570, 10, 190, 20));
      this.za.setText("Resetar filtros");
      this.za.setToolTipText("");
      this.add(this.za, new C0775(790, 10, 130, -1));
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setText("");
      this.add(this.zh, new C0775(20, 330, 250, 20));
      this.yY.setForeground(new Color(0, 102, 0));
      this.yY.setText("Procurar");
      this.add(this.yY, new C0775(340, 320, 143, 30));
      this.add(this.zi, new C0775(20, this.yT, 900, this.yU));
   }
}
