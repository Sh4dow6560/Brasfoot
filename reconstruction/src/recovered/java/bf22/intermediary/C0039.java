package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import mod.recovered.model.Club;

public class C0039 extends JPanel {
   private ArrayList yj = new ArrayList();
   private ArrayList yk = new ArrayList();
   private ArrayList yl = new ArrayList();
   private JDialog ub;
   private Club ym = null;
   private Club yn = null;
   private C0686 yo = null;
   private boolean yp = false;
   private JButton vm;
   private JButton yq;
   private JComboBox yr;
   private JComboBox ys;
   private JLabel ug;
   private JScrollPane ut;
   private JLabel yt;
   private JLabel yu;
   private JLabel yv;
   private JLabel yw;
   private JLabel yx;
   private JLabel yy;
   private JLabel yz;
   private JLabel yA;
   private JLabel yB;
   private JLabel yC;
   private JLabel yD;
   private JLabel yE;
   private JLabel yF;
   private JLabel yG;
   private JLabel yH;
   private JLabel yI;
   private JTable vN;

   public C0039(JDialog jDialog, Club club, Club club2, boolean bl) {
      this.ub = jDialog;
      this.ym = club;
      this.yn = club2;
      this.yp = bl;
      this.mJ();
      int var5 = 0;
      int var6 = 0;
      if (!bl) {
         for (int var7 = 0; var7 < C0745.SR.P().size(); var7++) {
            this.yr.addItem(((Club)C0745.SR.P().get(var7)).getNome());
            if (C0745.SR.P().get(var7) == club) {
               var5 = var7;
            }
         }
      } else {
         for (int var10 = 0; var10 < C0696.jz(); var10++) {
            int var8 = ((C0697)C0732.cY().get(var10)).getPais();
            C0692 var9 = C0745.SR.s(var8);
            if (var9.jl()) {
               this.yr.addItem(var9.jo());
               this.yl.add(var9.jo());
               if (var9.jo() == this.ym) {
                  var5 = var6;
               }

               var6++;
            }
         }
      }

      this.yr.setMaximumRowCount(20);
      this.ys.setMaximumRowCount(20);
      this.yr.setSelectedIndex(var5);
      this.R(true);
      this.mS();
      this.S(false);
      this.mH();
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   public void mH() {
      this.vm.addActionListener(new C0040(this));
      this.yq.addActionListener(new C0041(this));
      this.yr.addActionListener(new C0042(this));
   }

   private void R(boolean bl) {
      if (!bl) {
         if (!this.yp) {
            this.ym = (Club)C0745.SR.P().get(this.yr.getSelectedIndex());
         } else if (this.yl.size() > 0) {
            this.ym = (Club)this.yl.get(this.yr.getSelectedIndex());
         }
      }

      int var2 = -1;
      Object var3 = null;
      this.yk.clear();
      this.ys.removeAllItems();

      for (int var4 = 0; var4 < C0745.SR.bd().size(); var4++) {
         var3 = ((C0686)C0745.SR.bd().get(var4)).y(this.ym);
         if (var3 != null) {
            this.yk.add(var3);
         }
      }

      Collections.sort(this.yk, C1007.VS);

      for (int var6 = 0; var6 < this.yk.size(); var6++) {
         this.ys.addItem(((Club)this.yk.get(var6)).getNome());
         if (bl && this.yk.get(var6) == this.yn) {
            var2 = var6;
         }
      }

      if (var2 >= 0) {
         this.ys.setSelectedIndex(var2);
      }
   }

   private void S(boolean bl) {
      if (bl) {
         if (!this.yp) {
            this.ym = (Club)C0745.SR.P().get(this.yr.getSelectedIndex());
         } else {
            this.ym = (Club)this.yl.get(this.yr.getSelectedIndex());
         }

         if (this.ys.getItemCount() > 0 && this.ys.getSelectedIndex() < this.yk.size()) {
            this.yn = (Club)this.yk.get(this.ys.getSelectedIndex());
         }
      }

      if (this.ym != this.yn) {
         this.yo = null;

         for (int var2 = 0; var2 < C0745.SR.bd().size(); var2++) {
            if (((C0686)C0745.SR.bd().get(var2)).a(this.ym, this.yn)) {
               this.yo = (C0686)C0745.SR.bd().get(var2);
               break;
            }
         }

         this.yA.setText(this.ym.getNome());
         this.yB.setText(this.yn.getNome());
         this.yv.setIcon(this.ym.kP());
         this.yu.setIcon(this.yn.kP());
         if (this.yo != null) {
            if (this.yo != null) {
               this.yG.setText(this.yo.iN());
               this.yE.setText(this.yo.iO());
               this.yC.setText(this.yo.be(this.ym.lk()));
               this.yD.setText(this.yo.be(this.yn.lk()));
               this.yw.setText(this.yo.bf(this.ym.lk()));
               this.yx.setText(this.yo.bf(this.yn.lk()));
               String[] var4 = this.yo.bg(this.ym.lk());
               this.yy.setText(var4[0]);
               String[] var3 = this.yo.bg(this.yn.lk());
               this.yz.setText(var3[0]);
            }

            this.yj.clear();

            for (int var5 = 0; var5 < C0745.SR.R().size(); var5++) {
               for (int var6 = 0; var6 < ((C0693)C0745.SR.R().get(var5)).h().size(); var6++) {
                  if (((C0675)((C0693)C0745.SR.R().get(var5)).h().get(var6)).hc() == this.ym
                        && ((C0675)((C0693)C0745.SR.R().get(var5)).h().get(var6)).hd() == this.yn
                     || ((C0675)((C0693)C0745.SR.R().get(var5)).h().get(var6)).hd() == this.ym
                        && ((C0675)((C0693)C0745.SR.R().get(var5)).h().get(var6)).hc() == this.yn) {
                     this.yj.add((C0675)((C0693)C0745.SR.R().get(var5)).h().get(var6));
                  }
               }
            }

            this.vN.addNotify();
         } else {
            this.yj.clear();
            this.yG.setText("0 jogos");
            this.yE.setText("");
            this.yC.setText("");
            this.yD.setText("");
            this.yw.setText("");
            this.yx.setText("");
            this.yy.setText("");
            this.yz.setText("");
         }
      }
   }

   private void mS() {
      C0656 var1 = new C0656(this.yj);
      this.vN.setModel(var1);
      int[] var2 = new int[]{90, 120, 55, 120, 170};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vN.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vN.setAutoResizeMode(3);
      this.vN.setRowHeight(20);
      this.vN.setShowGrid(false);
      this.vN.setDefaultRenderer(C0675.class, new C0629());
      this.vN.setAutoCreateRowSorter(false);
      this.vN.getTableHeader().setReorderingAllowed(false);
      this.vN.setIntercellSpacing(new Dimension(0, 0));
      this.vN.setCellSelectionEnabled(false);
      this.vN.setSelectionMode(0);
      this.vN.setRowSelectionAllowed(true);
      this.vN.setSelectionBackground(Color.YELLOW);
      this.vN.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.yt = new JLabel();
      this.yr = new JComboBox();
      this.ug = new JLabel();
      this.ys = new JComboBox();
      this.yq = new JButton();
      this.vm = new JButton();
      this.yA = new JLabel();
      this.yB = new JLabel();
      this.yE = new JLabel();
      this.ut = new JScrollPane();
      this.vN = new JTable();
      this.yF = new JLabel();
      this.yu = new JLabel();
      this.yv = new JLabel();
      this.yx = new JLabel();
      this.yG = new JLabel();
      this.yC = new JLabel();
      this.yD = new JLabel();
      this.yH = new JLabel();
      this.yw = new JLabel();
      this.yy = new JLabel();
      this.yz = new JLabel();
      this.yI = new JLabel();
      this.yt.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setLayout(new C0807());
      this.add(this.yr, new C0775(110, 400, 170, -1));
      this.ug.setFont(new Font("Tahoma", 1, 11));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("x");
      this.add(this.ug, new C0775(300, 400, -1, -1));
      this.add(this.ys, new C0775(330, 400, 170, -1));
      this.yq.setText("mostrar");
      this.add(this.yq, new C0775(520, 400, -1, -1));
      this.vm.setText("x");
      this.add(this.vm, new C0775(540, 20, 60, 31));
      this.yA.setForeground(new Color(255, 255, 255));
      this.yA.setHorizontalAlignment(0);
      this.yA.setText("jLabel2");
      this.add(this.yA, new C0775(70, 20, 220, -1));
      this.yB.setForeground(new Color(255, 255, 255));
      this.yB.setHorizontalAlignment(0);
      this.yB.setText("jLabel3");
      this.add(this.yB, new C0775(312, 20, 190, -1));
      this.yE.setForeground(new Color(255, 255, 255));
      this.yE.setHorizontalAlignment(0);
      this.yE.setText("10 empates");
      this.add(this.yE, new C0775(250, 70, 90, -1));
      this.ut.setViewportView(this.vN);
      this.add(this.ut, new C0775(20, 230, 580, 128));
      this.yF.setFont(new Font("Tahoma", 1, 14));
      this.yF.setForeground(new Color(255, 255, 255));
      this.yF.setHorizontalAlignment(4);
      this.yF.setText("Maior vitória:");
      this.add(this.yF, new C0775(10, 150, 190, -1));
      this.yu.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.add(this.yu, new C0775(380, 40, -1, -1));
      this.yv.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.add(this.yv, new C0775(150, 40, -1, -1));
      this.yx.setForeground(new Color(255, 255, 255));
      this.yx.setHorizontalAlignment(2);
      this.yx.setText("");
      this.add(this.yx, new C0775(380, 120, 100, -1));
      this.yG.setForeground(new Color(255, 255, 255));
      this.yG.setHorizontalAlignment(0);
      this.yG.setText("");
      this.yG.setToolTipText("");
      this.add(this.yG, new C0775(240, 50, 100, -1));
      this.yC.setFont(new Font("Tahoma", 1, 14));
      this.yC.setForeground(new Color(255, 255, 255));
      this.yC.setHorizontalAlignment(4);
      this.yC.setText("");
      this.add(this.yC, new C0775(90, 100, 110, -1));
      this.yD.setFont(new Font("Tahoma", 1, 14));
      this.yD.setForeground(new Color(255, 255, 255));
      this.yD.setHorizontalAlignment(2);
      this.yD.setText("");
      this.add(this.yD, new C0775(380, 100, 110, -1));
      this.yH.setForeground(new Color(255, 255, 255));
      this.yH.setText("Jogos na temporada");
      this.add(this.yH, new C0775(250, 210, 151, -1));
      this.yw.setForeground(new Color(255, 255, 255));
      this.yw.setHorizontalAlignment(4);
      this.yw.setText("");
      this.add(this.yw, new C0775(80, 120, 120, -1));
      this.yy.setForeground(new Color(255, 255, 255));
      this.yy.setHorizontalAlignment(4);
      this.yy.setText("");
      this.add(this.yy, new C0775(10, 170, 190, -1));
      this.yz.setForeground(new Color(255, 255, 255));
      this.yz.setHorizontalAlignment(2);
      this.yz.setText("");
      this.add(this.yz, new C0775(380, 170, 220, -1));
      this.yI.setFont(new Font("Tahoma", 1, 14));
      this.yI.setForeground(new Color(255, 255, 255));
      this.yI.setHorizontalAlignment(2);
      this.yI.setText("Maior vitória:");
      this.add(this.yI, new C0775(380, 150, 190, -1));
   }
}
