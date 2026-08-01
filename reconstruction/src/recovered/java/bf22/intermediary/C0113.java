package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0113 extends JPanel {
   private JDialog ub;
   private C0675 zz;
   private int[] zA = new int[2];
   private int[] zB = new int[3];
   private Timer zC;
   private ArrayList zD = new ArrayList();
   private ArrayList zE = new ArrayList();
   private int zF = 0;
   private int zG = 0;
   private int zH = 1;
   private int zI = -1;
   ArrayList zJ = new ArrayList();
   private JButton zK;
   private JScrollPane ut;
   private JLabel yt;
   private JLabel zL;
   private JLabel zM;
   private JLabel zN;
   private JLabel zO;
   private JLabel zP;
   private JLabel zQ;
   private JLabel zR;
   private JTable zS;

   public C0113(JDialog jDialog, C0675 c0675) {
      this.ub = jDialog;
      this.zz = c0675;
      this.mJ();
      this.zK.setVisible(false);
      this.zO.setText(c0675.hc().getNome());
      this.zO.setForeground(c0675.hc().kC());
      this.zO.setBackground(c0675.hc().kB());
      this.zP.setText(c0675.hd().getNome());
      this.zP.setForeground(c0675.hd().kC());
      this.zP.setBackground(c0675.hd().kB());
      if (c0675.hc().kP() != null) {
         this.yt.setIcon(c0675.hc().kP());
      }

      if (c0675.hd().kP() != null) {
         this.zL.setIcon(c0675.hd().kP());
      }

      this.nP();
      this.zD.addAll(C0208.qk());
      this.zE.addAll(C0208.ql());
      this.mS();
      this.zQ.setVisible(false);
      this.mH();
      this.a((JComponent)this);
      this.nJ();
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0114(this));
   }

   public void mH() {
      this.zK.addActionListener(new C0115(this));
   }

   public void nJ() {
      this.zC = new Timer();
      this.zC.schedule(new C0116(this), 1000L);
   }

   public void nK() {
      this.zC = new Timer();
      this.zC.schedule(new C0117(this), 1500L);
   }

   public void nL() {
      ArrayList var1;
      if (this.zH == 1) {
         var1 = this.zD;
         if (this.zF >= var1.size()) {
            this.zF = 0;
         }
      } else {
         var1 = this.zE;
         if (this.zG >= var1.size()) {
            this.zG = 0;
         }
      }

      C0772 var2 = new C0772();
      if (this.zH == 1) {
         var2.a((Player)var1.get(this.zF));
         this.b(1, (Player)var1.get(this.zF), -1);
      } else {
         var2.a((Player)var1.get(this.zG));
         this.b(2, (Player)var1.get(this.zG), -1);
      }

      var2.dO(this.zH);
      this.zJ.add(var2);
      this.zS.addNotify();
      this.nN();
      this.nK();
   }

   private void b(int i, Player player, int j) {
      Club var4 = null;
      this.zQ.setVisible(true);
      if (i == 1) {
         var4 = this.zz.hc();
      } else {
         var4 = this.zz.hd();
      }

      this.zQ.setForeground(var4.kC());
      this.zQ.setBackground(var4.kB());
      if (j == -1) {
         String var5 = "";
         if (player != null) {
            var5 = player.getNome();
         }

         this.zQ.setText(var5 + " vai pra bola...");
      } else if (j == 0) {
         this.zQ.setText("Perdeu!");
      } else if (j == 1) {
         this.zQ.setText("Gol!!!");
      }
   }

   private void nM() {
      byte var2 = 0;
      byte var3 = 70;
      byte var4 = 30;
      int var5 = new Random().nextInt(100) + 1;
      if (var5 <= var3) {
         var2 = 1;
      }

      C0772 var1 = (C0772)this.zJ.get(this.zJ.size() - 1);
      var1.dN(var2);
      if (this.zH == 1) {
         this.zF++;
         if (var2 == 1) {
            this.zA[0]++;
         }

         this.zB[1]++;
         this.b(1, null, var2);
      } else if (this.zH == 2) {
         this.zG++;
         if (var2 == 1) {
            this.zA[1]++;
         }

         this.zB[2]++;
         this.b(2, null, var2);
      }

      this.nP();
      this.zS.addNotify();
      this.nN();
      if (this.cP(var2)) {
         this.nO();
      } else {
         if (this.zH == 1) {
            this.zH = 2;
         } else if (this.zH == 2) {
            this.zH = 1;
         }

         this.nJ();
      }
   }

   private void nN() {
      if (this.zJ.size() > 17) {
         try {
            int var1 = this.zS.getRowCount() - 1;
            byte var2 = 0;
            boolean var3 = true;
            Rectangle var4 = this.zS.getCellRect(var1, var2, var3);
            this.zS.scrollRectToVisible(var4);
         } catch (Exception var5) {
         }
      }
   }

   private void nO() {
      if (this.zI == 1) {
         this.zz.u(this.zz.hc());
      } else if (this.zI == 2) {
         this.zz.u(this.zz.hd());
      }

      this.zz.i(this.zA);
      if (this.zz.hR() != null) {
         this.zQ.setText(this.zz.hR().getNome() + " venceu");
      }

      this.zQ.setForeground(this.zz.hR().kC());
      this.zQ.setBackground(this.zz.hR().kB());
      this.zQ.setVisible(true);
      this.zK.setVisible(true);
   }

   private boolean cP(int i) {
      if (this.zH == 1 && this.zB[1] <= 5) {
         if (i == 1 && this.zA[0] > 5 - this.zB[2] + this.zA[1]) {
            this.zI = 1;
            return true;
         }

         if (5 - this.zB[1] + this.zA[0] < this.zA[1]) {
            this.zI = 2;
            return true;
         }
      } else if (this.zH == 2 && this.zB[2] <= 5) {
         if (i == 1 && 5 - this.zB[1] + this.zA[0] < this.zA[1]) {
            this.zI = 2;
            return true;
         }

         if (this.zA[0] > 5 - this.zB[2] + this.zA[1]) {
            this.zI = 1;
            return true;
         }
      } else if (this.zH == 2 && this.zB[2] > 5) {
         if (this.zA[0] > this.zA[1]) {
            this.zI = 1;
            return true;
         }

         if (this.zA[0] < this.zA[1]) {
            this.zI = 2;
            return true;
         }
      }

      return false;
   }

   private void mS() {
      C0660 var1 = new C0660(this.zJ);
      this.zS.setModel(var1);
      this.zS.setTableHeader(null);
      int[] var2 = new int[]{30, 100, 100, 30};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.zS.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.zS.setAutoResizeMode(3);
      this.zS.setRowHeight(20);
      this.zS.setShowGrid(false);
      this.zS.setDefaultRenderer(C0772.class, new C0632());
      this.zS.setAutoCreateRowSorter(false);
      this.zS.setIntercellSpacing(new Dimension(0, 0));
      this.zS.setCellSelectionEnabled(false);
      this.zS.setSelectionMode(0);
      this.zS.setRowSelectionAllowed(false);
      this.zS.setSelectionBackground(Color.YELLOW);
      this.zS.setFillsViewportHeight(true);
   }

   private void nP() {
      this.zN.setText(Integer.toString(this.zA[0]));
      this.zR.setText(Integer.toString(this.zA[1]));
   }

   private void mJ() {
      this.zL = new JLabel();
      this.yt = new JLabel();
      this.zO = new JLabel();
      this.zP = new JLabel();
      this.zR = new JLabel();
      this.zN = new JLabel();
      this.zQ = new JLabel();
      this.zK = new JButton();
      this.ut = new JScrollPane();
      this.zS = new JTable();
      this.zM = new JLabel();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setMaximumSize(new Dimension(469, 520));
      this.setMinimumSize(new Dimension(469, 520));
      this.setPreferredSize(new Dimension(469, 520));
      this.setLayout(new C0807());
      this.add(this.zL, new C0775(340, 40, 60, 60));
      this.add(this.yt, new C0775(50, 40, 60, 60));
      this.zO.setBackground(new Color(0, 51, 204));
      this.zO.setFont(new Font("Tahoma", 1, 14));
      this.zO.setForeground(new Color(255, 255, 255));
      this.zO.setHorizontalAlignment(0);
      this.zO.setText("Time1");
      this.zO.setOpaque(true);
      this.add(this.zO, new C0775(50, 110, 160, 30));
      this.zP.setBackground(new Color(153, 0, 0));
      this.zP.setFont(new Font("Tahoma", 1, 14));
      this.zP.setHorizontalAlignment(0);
      this.zP.setText("Time 2");
      this.zP.setOpaque(true);
      this.add(this.zP, new C0775(250, 110, 160, 30));
      this.zR.setFont(new Font("Tahoma", 0, 36));
      this.zR.setForeground(new Color(255, 255, 255));
      this.zR.setHorizontalAlignment(0);
      this.zR.setText("2");
      this.zR.setHorizontalTextPosition(0);
      this.add(this.zR, new C0775(255, 55, 40, 40));
      this.zN.setFont(new Font("Tahoma", 0, 36));
      this.zN.setForeground(new Color(255, 255, 255));
      this.zN.setHorizontalAlignment(0);
      this.zN.setText("1");
      this.zN.setHorizontalTextPosition(0);
      this.add(this.zN, new C0775(150, 55, 40, 40));
      this.zQ.setFont(new Font("Tahoma", 0, 14));
      this.zQ.setHorizontalAlignment(0);
      this.zQ.setText("Time 1 venceru");
      this.zQ.setToolTipText("");
      this.zQ.setOpaque(true);
      this.add(this.zQ, new C0775(50, 145, 360, 30));
      this.zK.setText("continuar");
      this.add(this.zK, new C0775(160, 560, 150, 30));
      this.ut.setViewportView(this.zS);
      this.add(this.ut, new C0775(50, 180, 360, 370));
      this.zM.setForeground(new Color(255, 255, 255));
      this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/penaltyd.jpg")));
      this.add(this.zM, new C0775(0, 0, -1, -1));
   }
}
