package bf22.intermediary;

import mod.recovered.stadium.StadiumExpansionProject;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import mod.recovered.model.Club;
import mod.recovered.model.Stadium;

public class C0171 extends JPanel {
   private JDialog ub = null;
   private Stadium dH = null;
   private int w = 0;
   private Club zY = null;
   int[] BX = new int[]{10, 25, 35, 50};
   private JButton BY;
   private JButton BZ;
   private JButton Ca;
   private JCheckBox Cb;
   private JLabel Cc;
   private JLabel Cd;
   private JLabel Ce;
   private JLabel Cf;
   private JLabel Cg;
   private JLabel zM;
   private JLabel zh;
   private JLabel Ch;
   private JSpinner Ci;
   private JSpinner Cj;
   private JSpinner Ck;
   private JSpinner Cl;

   public C0171(JDialog jDialog, Stadium stadium, int i, Club club) {
      this.ub = jDialog;
      this.dH = stadium;
      this.w = i;
      this.zY = club;
      this.mJ();
      this.mH();
      this.oA();
   }

   private void oA() {
      this.BX = Stadium.a(this.w, this.zY);
      int[] var1 = this.dH.dT();
      int var2 = this.dH.dW();
      String var3 = "G:"
         + Integer.toString(this.BX[0])
         + ";"
         + " A:"
         + Integer.toString(this.BX[1])
         + ";"
         + " Cd:"
         + Integer.toString(this.BX[2])
         + ";"
         + " Cm:"
         + Integer.toString(this.BX[3]);
      this.Ch.setText(var3);
      this.Cg.setText(this.dH.dS() + " - " + Integer.toString(var2) + " lugares");
      this.Cf.setText(Integer.toString(var1[0]));
      this.Cc.setText(Integer.toString(var1[1]));
      this.Cd.setText(Integer.toString(var1[2]));
      this.Ce.setText(Integer.toString(var1[3]));
      this.Cb.setSelected(this.dH.dV());
      if (!this.dH.dV()) {
         this.oE();
      } else {
         this.oD();
      }

      this.Y(!this.dH.dV());
      this.zh.setText("");
      this.oB();
   }

   public void oB() {
      if (GamePersistence.careerState.getStadiumExpansionProjects() != null && GamePersistence.careerState.getStadiumExpansionProjects().size() > 0) {
         for (int var1 = 0; var1 < GamePersistence.careerState.getStadiumExpansionProjects().size(); var1++) {
            if (((StadiumExpansionProject)GamePersistence.careerState.getStadiumExpansionProjects().get(var1)).getStadium() == this.dH) {
               this.BY.setVisible(false);
               DateFormat var2 = DateFormat.getDateInstance();
               String var3 = var2.format(((StadiumExpansionProject)GamePersistence.careerState.getStadiumExpansionProjects().get(var1)).getCompletionDate().getTime());
               this.zh.setText("Expansão com término em: " + var3);
               break;
            }
         }
      }
   }

   public void mH() {
      this.BZ.addActionListener(new C0172(this));
      this.BY.addActionListener(new C0173(this));
      this.Cb.addActionListener(new C0174(this));
      this.Ca.addActionListener(new C0175(this));
   }

   private void oC() {
      this.dH.o(this.Cb.isSelected());
      this.Y(!this.dH.dV());
      if (this.dH.dV()) {
         this.oD();
      } else {
         this.oE();
      }
   }

   private void oD() {
      this.Cl.setModel(new SpinnerNumberModel(this.BX[0], 1, 200, 1));
      this.Ci.setModel(new SpinnerNumberModel(this.BX[1], 1, 300, 1));
      this.Cj.setModel(new SpinnerNumberModel(this.BX[2], 1, 500, 1));
      this.Ck.setModel(new SpinnerNumberModel(this.BX[3], 1, 1000, 1));
   }

   private void oE() {
      int[] var1 = this.dH.dU();
      this.Cl.setModel(new SpinnerNumberModel(var1[0], 1, 200, 1));
      this.Ci.setModel(new SpinnerNumberModel(var1[1], 1, 300, 1));
      this.Cj.setModel(new SpinnerNumberModel(var1[2], 1, 500, 1));
      this.Ck.setModel(new SpinnerNumberModel(var1[3], 1, 1000, 1));
   }

   private void oF() {
      if (!this.dH.dV()) {
         int[] var1 = new int[]{(Integer)this.Cl.getValue(), (Integer)this.Ci.getValue(), (Integer)this.Cj.getValue(), (Integer)this.Ck.getValue()};
         this.dH.b(var1);
      }
   }

   private void Y(boolean bl) {
      JSpinner[] var2 = new JSpinner[]{this.Cl, this.Ci, this.Cj, this.Ck};

      for (int var3 = 0; var3 < var2.length; var3++) {
         var2[var3].setEnabled(bl);
      }

      this.Ca.setEnabled(bl);
   }

   public void oG() {
      JDialog var1 = new JDialog(this.ub);
      C0176 var2 = new C0176(var1, this.dH, this.zY, this);
      var1.add(var2);
      var1.setSize(438, 360);
      var1.setPreferredSize(new Dimension(438, 360));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
   }

   private void mJ() {
      this.Ch = new JLabel();
      this.Cb = new JCheckBox();
      this.Ck = new JSpinner();
      this.Cl = new JSpinner();
      this.Ci = new JSpinner();
      this.Cj = new JSpinner();
      this.Ca = new JButton();
      this.Ce = new JLabel();
      this.Cc = new JLabel();
      this.Cf = new JLabel();
      this.Cd = new JLabel();
      this.zh = new JLabel();
      this.Cg = new JLabel();
      this.BY = new JButton();
      this.BZ = new JButton();
      this.zM = new JLabel();
      this.setLayout(new C0807());
      this.Ch.setForeground(new Color(255, 255, 255));
      this.Ch.setText("jLabel1");
      this.add(this.Ch, new C0775(450, 277, -1, -1));
      this.Cb.setForeground(new Color(255, 255, 255));
      this.Cb.setText("Usar sempre os preços sugeridos");
      this.Cb.setOpaque(false);
      this.add(this.Cb, new C0775(330, 294, -1, -1));
      this.add(this.Ck, new C0775(460, 210, 50, 20));
      this.Cl.setModel(new SpinnerNumberModel(1, 1, 1500, 1));
      this.add(this.Cl, new C0775(460, 122, 50, 20));
      this.add(this.Ci, new C0775(460, 150, 50, 20));
      this.add(this.Cj, new C0775(460, 180, 50, 20));
      this.Ca.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconpreco2.png")));
      this.add(this.Ca, new C0775(530, 230, 30, 20));
      this.Ce.setFont(new Font("Tahoma", 1, 14));
      this.Ce.setForeground(new Color(255, 255, 255));
      this.Ce.setText("10000");
      this.add(this.Ce, new C0775(165, 204, -1, -1));
      this.Cc.setFont(new Font("Tahoma", 1, 14));
      this.Cc.setForeground(new Color(255, 255, 255));
      this.Cc.setText("10000");
      this.add(this.Cc, new C0775(165, 150, -1, -1));
      this.Cf.setFont(new Font("Tahoma", 1, 14));
      this.Cf.setForeground(new Color(255, 255, 255));
      this.Cf.setText("10000");
      this.add(this.Cf, new C0775(165, 122, -1, -1));
      this.Cd.setFont(new Font("Tahoma", 1, 14));
      this.Cd.setForeground(new Color(255, 255, 255));
      this.Cd.setText("10000");
      this.add(this.Cd, new C0775(165, 177, -1, -1));
      this.zh.setFont(new Font("Tahoma", 0, 12));
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setText("Nome do estádio - C. 200 mil");
      this.add(this.zh, new C0775(40, 270, 270, -1));
      this.Cg.setFont(new Font("Tahoma", 1, 14));
      this.Cg.setForeground(new Color(255, 255, 102));
      this.Cg.setText("Nome do estádio - C. 200 mil");
      this.add(this.Cg, new C0775(30, 20, 500, -1));
      this.BY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/build.png")));
      this.BY.setText("Expandir estádio");
      this.add(this.BY, new C0775(60, 290, 170, 30));
      this.BZ.setFont(new Font("Tahoma", 1, 12));
      this.BZ.setText("X");
      this.add(this.BZ, new C0775(520, 10, 60, 30));
      this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio.jpg")));
      this.zM.setText("jLabel2");
      this.add(this.zM, new C0775(0, 0, 600, 330));
   }
}
