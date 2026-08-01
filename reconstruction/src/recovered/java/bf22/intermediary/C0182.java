package bf22.intermediary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mod.recovered.config.StateLeagueConfig;

public class C0182 extends JPanel {
   private ArrayList du = new ArrayList();
   private int dr;
   private int gF;
   private StateLeagueConfig[] CP = new StateLeagueConfig[5];
   private int[] CQ = new int[5];
   private JDialog ub = null;
   private boolean CR = false;
   private JCheckBox CS;
   private JButton vb;
   private JButton vc;
   private JLabel BH;
   private JLabel BI;
   private JLabel BJ;
   private JLabel BK;
   private JLabel vf;
   private C0180 CT;
   private C0180 CU;
   private C0180 CV;
   private C0180 CW;

   public C0182(int i, int j, JDialog jDialog) {
      this.dr = i;
      this.ub = jDialog;
      this.mJ();
      this.CS.setSelected(C0745.SR.isUsaGrupoPadraoEstadual());
      this.CS.addActionListener(new C0183(this));
      this.vb.addActionListener(new C0184(this));
      this.vc.setVisible(false);
      this.gF = j;
      String var4 = "Campeonato " + C0710.rZ[i] + " - " + Integer.toString(this.gF) + " times";
      ImageIcon var5 = new ImageIcon(this.getClass().getResource("/aesticons/" + i + ".png"));
      this.vf.setText(var4);
      this.vf.setIcon(var5);
      C0741.ef();

      for (int var6 = 0; var6 < C0741.eg().size(); var6++) {
         if (((StateLeagueConfig)C0741.eg().get(var6)).getId() == i) {
            this.du.add((StateLeagueConfig)C0741.eg().get(var6));
         }
      }

      for (int var8 = 0; var8 <= 4; var8++) {
         this.CP[var8] = null;
      }

      if (this.du.size() > 0) {
         for (int var9 = 1; var9 <= 4; var9++) {
            for (int var7 = 0; var7 < this.du.size(); var7++) {
               if (((StateLeagueConfig)this.du.get(var7)).getDivisao() == var9) {
                  this.CP[var9] = (StateLeagueConfig)this.du.get(var7);
               }
            }
         }
      }

      for (int var10 = 1; var10 <= 4; var10++) {
         if (this.CP[var10] == null) {
            StateLeagueConfig var12 = new StateLeagueConfig(i, var10);
            C0741.eg().add(var12);
            this.CP[var10] = var12;
         }
      }

      this.du.clear();

      for (int var11 = 1; var11 <= 4; var11++) {
         this.CQ[var11] = this.CP[var11].getnTimes();
      }

      this.CT.a(this.CP[1]);
      this.CU.a(this.CP[2]);
      this.CV.a(this.CP[3]);
      this.CW.a(this.CP[4]);
      this.oJ();
   }

   public void oJ() {
      if (this.gF >= this.CQ[1]) {
         this.CT.db(1);
      } else {
         this.CT.db(2);
      }

      if (this.gF >= this.CQ[1] + this.CQ[2]) {
         this.CU.db(1);
      } else {
         this.CU.db(3);
      }

      if (this.gF >= this.CQ[1] + this.CQ[2] + this.CQ[3]) {
         this.CV.db(1);
      } else {
         this.CV.db(3);
      }

      if (this.gF >= this.CQ[1] + this.CQ[2] + this.CQ[3] + this.CQ[4]) {
         this.CW.db(1);
      } else {
         this.CW.db(3);
      }
   }

   public void J(int i, int j) {
      this.CQ[i] = j;
   }

   public void nH() {
      this.CR = false;
      this.CT.nH();
      this.CU.nH();
      this.CV.nH();
      this.CW.nH();
      if (!this.CR) {
         C0741.P(this.dr);
         this.ub.dispose();
      }
   }

   public void Z(boolean bl) {
      this.CR = bl;
   }

   public int getEstado() {
      return this.dr;
   }

   private void mJ() {
      this.vf = new JLabel();
      this.BH = new JLabel();
      this.BI = new JLabel();
      this.BJ = new JLabel();
      this.BK = new JLabel();
      this.vb = new JButton();
      this.vc = new JButton();
      this.CS = new JCheckBox();
      this.CW = new C0180(4, this);
      this.CT = new C0180(1, this);
      this.CU = new C0180(2, this);
      this.CV = new C0180(3, this);
      this.setBackground(new Color(226, 228, 228));
      this.setToolTipText("");
      this.setLayout(new C0807());
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(36, 104, 43));
      this.vf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.vf.setText("Configurar Ligas - Brasil - 120 times");
      this.add(this.vf, new C0775(36, 11, 380, -1));
      this.BH.setBackground(new Color(255, 255, 255));
      this.BH.setForeground(new Color(36, 104, 43));
      this.BH.setText("1ª divisão");
      this.add(this.BH, new C0775(36, 43, -1, -1));
      this.BI.setBackground(new Color(255, 255, 255));
      this.BI.setForeground(new Color(36, 104, 43));
      this.BI.setText("2ª divisão");
      this.add(this.BI, new C0775(40, 160, -1, -1));
      this.BJ.setBackground(new Color(255, 255, 255));
      this.BJ.setForeground(new Color(36, 104, 43));
      this.BJ.setText("3ª divisão");
      this.add(this.BJ, new C0775(40, 290, -1, -1));
      this.BK.setBackground(new Color(255, 255, 255));
      this.BK.setForeground(new Color(36, 104, 43));
      this.BK.setText("4ª divisão");
      this.add(this.BK, new C0775(40, 430, -1, -1));
      this.vb.setFont(new Font("Tahoma", 0, 12));
      this.vb.setText("Salvar");
      this.vb.setToolTipText("");
      this.add(this.vb, new C0775(510, 560, 121, 30));
      this.vc.setFont(new Font("Tahoma", 0, 12));
      this.vc.setText("Resetar tudo");
      this.vc.setToolTipText("");
      this.vc.setCursor(new Cursor(12));
      this.add(this.vc, new C0775(370, 560, 120, 30));
      this.CS.setText("Usar grupos reais se possível");
      this.add(this.CS, new C0775(430, 10, 200, -1));
      this.add(this.CW, new C0775(40, 450, 590, 90));
      this.add(this.CT, new C0775(40, 60, 590, 90));
      this.add(this.CU, new C0775(40, 180, 590, 90));
      this.add(this.CV, new C0775(40, 320, 590, 90));
   }
}
