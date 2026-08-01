package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0229 extends JPanel {
   private JDialog ub = null;
   private JLabel Az = new JLabel();
   private JLabel FG = new JLabel();
   private C0827 Db = null;
   private ArrayList AE = new ArrayList();
   private ArrayList Dc = new ArrayList();
   private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
   private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag40.png"));
   private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
   private ImageIcon AK = new ImageIcon(this.getClass().getResource("/aicons/camisar40.png"));
   private ImageIcon AL = this.AJ;
   private ImageIcon Dd = this.AK;
   private JButton vm;
   private JScrollPane ut;
   private JLabel Ds;
   private JLabel FH;
   private JLabel Cg;
   private JLabel Dy;
   private JLabel Dz;
   private JLabel xI;
   private JLabel DB;
   private JLabel DC;
   private JLabel zO;
   private JLabel zP;
   private JLayeredPane FI;
   private JLayeredPane FJ;
   private JTable DG;

   public C0229(JDialog jDialog, C0827 c0827) {
      this.ub = jDialog;
      this.Db = c0827;
      this.mJ();
      this.mK();
      this.nc();
      this.vm.addActionListener(new C0230(this));
      this.oS();
      this.ob();
      this.oY();
      this.DB.setText(this.V(this.AE));
      this.DC.setText(this.V(this.Dc));
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

   private void ob() {
      if (this.Db.tR().dX() < C0710.pb.length) {
         this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/" + C0710.pd[this.Db.tR().dX()] + ".jpg")));
      }

      if (this.Db.tR().dX() < C0710.pb.length) {
         this.FH.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/" + C0710.pd[this.Db.tR().dX()] + ".jpg")));
      }
   }

   private void nc() {
      for (int var1 = 0; var1 < this.Db.tR().hE().size(); var1++) {
         ((C0667)this.Db.tR().hE().get(var1)).p(true);
      }

      C0662 var4 = new C0662(this.Db.tR().hE());
      this.DG.setModel(var4);
      this.DG.setTableHeader(null);
      int[] var2 = new int[]{20, 180, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.DG.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.DG.setAutoResizeMode(3);
      this.DG.setRowHeight(20);
      this.DG.setShowGrid(false);
      this.DG.setDefaultRenderer(C0667.class, new C0634(false));
      this.DG.setAutoCreateRowSorter(false);
      this.DG.setCellSelectionEnabled(false);
      this.DG.setRowSelectionAllowed(false);
      this.DG.setBackground(this.getBackground());
      this.DG.setFillsViewportHeight(true);
   }

   private void mK() {
      this.zO.setForeground(this.Db.tR().hc().kC());
      this.zO.setBackground(this.Db.tR().hc().kB());
      this.zP.setForeground(this.Db.tR().hd().kC());
      this.zP.setBackground(this.Db.tR().hd().kB());
      if (this.Db.tR().ev() != null) {
         this.Cg.setText(this.Db.tR().ev().dS());
         this.Dy.setText(Integer.toString(this.Db.tR().hU()));
         this.Dy.setToolTipText(this.Db.tR().hV());
         this.Dz.setText(ClubFinances.c(this.Db.tR().hN()));
      } else {
         if (this.Db.ik() != null) {
            this.Cg.setText(this.Db.ik());
         } else {
            this.Cg.setText("");
         }

         this.Dy.setText("n/i");
         this.Dz.setText("n/i");
      }

      this.zO.setText(this.Db.tR().hc().getNome() + " " + Integer.toString(this.Db.tR().hu()) + " ");
      this.zP.setText(" " + Integer.toString(this.Db.tR().hw()) + " " + this.Db.tR().hd().getNome());
      this.zO.setIcon(this.Db.tR().hc().kU());
      this.zP.setIcon(this.Db.tR().hd().kU());
      this.xI.setText(this.Db.tR().ha());
   }

   private void oY() {
      for (int var1 = 0; var1 <= 36; var1++) {
         C0795 var2 = new C0795();
         this.AE.add(var2);
      }

      for (int var3 = 0; var3 <= 36; var3++) {
         C0795 var5 = new C0795();
         this.Dc.add(var5);
      }

      int[][] var4 = this.Db.tR().id();

      for (int var6 = 0; var6 < this.Db.tR().hl().size(); var6++) {
         if (this.Db.tR().hl().get(var6) != null && var4[0][var6] > 0) {
            ((C0795)this.AE.get(var4[0][var6])).a((Player)this.Db.tR().hl().get(var6));
            ((C0795)this.AE.get(var4[0][var6])).h(this.AL);
         }
      }

      for (int var7 = 0; var7 < this.Db.tR().hm().size(); var7++) {
         if (this.Db.tR().hm().get(var7) != null && var4[1][var7] > 0) {
            ((C0795)this.Dc.get(var4[1][var7])).a((Player)this.Db.tR().hm().get(var7));
            ((C0795)this.Dc.get(var4[1][var7])).h(this.Dd);
         }
      }

      this.cS(-1);
   }

   private void oS() {
      this.Db.tR().hc().bV(0);
      this.AL = this.Db.tR().hc().kS();
      this.Db.tR().hd().bV(1);
      this.Dd = this.Db.tR().hd().kS();
   }

   private void cS(int i) {
      this.a(1, this.Az, ((C0795)this.AE.get(0)).a(this.AE, i, this.AL, true, 1, null));
      this.a(2, this.FG, ((C0795)this.Dc.get(0)).a(this.Dc, i, this.Dd, true, 2, null));
   }

   public void a(int i, JLabel jLabel, ImageIcon imageIcon) {
      jLabel.setIcon(null);
      jLabel.setIcon(imageIcon);
      byte var4 = -45;
      byte var5 = 0;
      if (i == 1) {
         this.FI.add(jLabel, new C0775(var4, var5, -1, -1));
         this.FI.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
      } else {
         this.FJ.add(jLabel, new C0775(var4, var5, -1, -1));
         this.FJ.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
      }
   }

   private void mJ() {
      this.vm = new JButton();
      this.FI = new JLayeredPane();
      this.Ds = new JLabel();
      this.FJ = new JLayeredPane();
      this.FH = new JLabel();
      this.zO = new JLabel();
      this.zP = new JLabel();
      this.DB = new JLabel();
      this.DC = new JLabel();
      this.Dz = new JLabel();
      this.Dy = new JLabel();
      this.Cg = new JLabel();
      this.ut = new JScrollPane();
      this.DG = new JTable();
      this.xI = new JLabel();
      this.setBackground(new Color(0, 51, 0));
      this.setLayout(new C0807());
      this.vm.setText("X");
      this.add(this.vm, new C0775(870, 10, 50, -1));
      this.FI.setLayout(new C0807());
      this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/campo_diminuido.jpg")));
      this.Ds.setAlignmentY(0.0F);
      this.Ds.setRequestFocusEnabled(false);
      this.FI.add(this.Ds, new C0775(0, 0, 340, -1));
      this.add(this.FI, new C0775(20, 60, 390, 566));
      this.FJ.setLayout(new C0807());
      this.FH.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/campo_diminuido.jpg")));
      this.FH.setAlignmentY(0.0F);
      this.FH.setRequestFocusEnabled(false);
      this.FJ.add(this.FH, new C0775(0, 0, -1, -1));
      this.add(this.FJ, new C0775(590, 60, 360, 566));
      this.zO.setBackground(new Color(0, 51, 204));
      this.zO.setFont(new Font("Tahoma", 1, 14));
      this.zO.setForeground(new Color(255, 255, 255));
      this.zO.setHorizontalAlignment(4);
      this.zO.setText("");
      this.zO.setOpaque(true);
      this.add(this.zO, new C0775(110, 30, 250, 30));
      this.zP.setBackground(new Color(153, 0, 0));
      this.zP.setFont(new Font("Tahoma", 1, 14));
      this.zP.setHorizontalTextPosition(2);
      this.zP.setText("");
      this.zP.setOpaque(true);
      this.add(this.zP, new C0775(590, 30, 250, 30));
      this.DB.setForeground(new Color(255, 255, 153));
      this.DB.setText("");
      this.add(this.DB, new C0775(20, 40, 60, -1));
      this.DC.setForeground(new Color(255, 255, 153));
      this.DC.setHorizontalAlignment(4);
      this.DC.setText("");
      this.add(this.DC, new C0775(850, 40, 60, -1));
      this.Dz.setForeground(new Color(255, 255, 255));
      this.Dz.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconmoney2.png")));
      this.Dz.setText("Moisés Lucarelli");
      this.add(this.Dz, new C0775(400, 60, 150, -1));
      this.Dy.setForeground(new Color(255, 255, 255));
      this.Dy.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconPub.png")));
      this.Dy.setText("Moisés Lucarelli");
      this.add(this.Dy, new C0775(400, 40, 150, -1));
      this.Cg.setForeground(new Color(255, 255, 255));
      this.Cg.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio_iconSmall.png")));
      this.Cg.setText("Moisés Lucarelli");
      this.add(this.Cg, new C0775(400, 20, 150, -1));
      this.ut.setViewportView(this.DG);
      this.add(this.ut, new C0775(370, 80, 210, 400));
      this.xI.setForeground(new Color(255, 255, 255));
      this.xI.setHorizontalAlignment(0);
      this.xI.setText("Posse de bola");
      this.add(this.xI, new C0775(370, 490, 210, 120));
   }
}
