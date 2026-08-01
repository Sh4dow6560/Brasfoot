package bf22.intermediary;

import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import mod.recovered.config.NationalLeagueConfig;

public class C0193 extends JPanel {
   private ArrayList du = new ArrayList();
   private int pais;
   private int gF;
   private NationalLeagueConfig[] Go = new NationalLeagueConfig[5];
   private int[] CQ = new int[5];
   private JDialog ub = null;
   private JButton uC;
   private JCheckBox Gp;
   private JButton vb;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JScrollPane ut;
   private JLabel vf;
   private C0197 Gq;
   private C0197 Gr;
   private C0197 Gs;
   private C0197 Gt;

   public C0193(int i, int j, JDialog jDialog) {
      this.pais = i;
      this.ub = jDialog;
      this.mJ();
      this.vb.addActionListener(new C0194(this));
      this.uC.addActionListener(new C0195(this));
      this.gF = j;
      ImageIcon var4 = new ImageIcon(this.getClass().getResource("/aflags/" + i + ".png"));
      String var5 = "Configurar Ligas - " + C0696.valueOf("P" + i).getNome() + " - " + Integer.toString(this.gF) + " times";
      this.vf.setText(var5);
      this.vf.setIcon(var4);

      for (int var6 = 0; var6 < GamePersistence.SR.bG.size(); var6++) {
         if (((NationalLeagueConfig)GamePersistence.SR.bG.get(var6)).getPais() == i) {
            this.du.add((NationalLeagueConfig)GamePersistence.SR.bG.get(var6));
         }
      }

      for (int var8 = 0; var8 <= 4; var8++) {
         this.Go[var8] = null;
      }

      if (this.du.size() > 0) {
         for (int var9 = 1; var9 <= 4; var9++) {
            for (int var7 = 0; var7 < this.du.size(); var7++) {
               if (((NationalLeagueConfig)this.du.get(var7)).getDivisao() == var9) {
                  this.Go[var9] = (NationalLeagueConfig)this.du.get(var7);
               }
            }
         }
      }

      for (int var10 = 1; var10 <= 4; var10++) {
         if (this.Go[var10] == null) {
            NationalLeagueConfig var12 = new NationalLeagueConfig();
            var12.setnTimes(20);
            var12.setnRebaixados(4);
            var12.setPais(i);
            var12.setDivisao(var10);
            var12.setFormula(0);
            var12.setNome2(CountryInfo.br(i));
            GamePersistence.SR.bG.add(var12);
            this.Go[var10] = var12;
            var12.setRebaixadosDireto(4);
            var12.setVagasSobemPeloMataMata(0);
            var12.setVersaoArquivo(22);
         }
      }

      this.du.clear();

      for (int var11 = 1; var11 <= 4; var11++) {
         this.CQ[var11] = this.Go[var11].getnTimes();
      }

      if (this.pais != 29) {
         this.Gp.setVisible(false);
      } else {
         this.Gp.setVisible(true);
         if (GamePersistence.vM().isNovoFormatoCopa()) {
            this.Gp.setSelected(true);
         } else {
            this.Gp.setSelected(false);
         }
      }

      this.Gq.a(this.Go[1], this.Go[2]);
      this.Gr.a(this.Go[2], this.Go[3]);
      this.Gs.a(this.Go[3], this.Go[4]);
      this.Gt.a(this.Go[4], null);
      this.oJ();
   }

   public void nH() {
      this.Gq.nH();
      this.Gr.nH();
      this.Gs.nH();
      this.Gt.nH();
      C0734.a(this.Go, this.pais);
      if (this.pais == 29) {
         GamePersistence.vM().setNovoFormatoCopa(this.Gp.isSelected());
         GamePersistence.vJ();
      }

      this.ub.dispose();
   }

   public void oJ() {
      if (this.gF >= this.CQ[1]) {
         this.Gq.db(1);
      } else {
         this.Gq.db(2);
      }

      if (this.gF >= this.CQ[1] + this.CQ[2]) {
         this.Gr.db(1);
      } else {
         this.Gr.db(3);
      }

      if (this.gF >= this.CQ[1] + this.CQ[2] + this.CQ[3]) {
         this.Gs.db(1);
      } else {
         this.Gs.db(3);
      }

      if (this.gF >= this.CQ[1] + this.CQ[2] + this.CQ[3] + this.CQ[4]) {
         this.Gt.db(1);
      } else {
         this.Gt.db(3);
      }
   }

   public void J(int i, int j) {
      this.CQ[i] = j;
   }

   public void af(int i, int j) {
      if (i == 1) {
         this.Gr.fv(j);
         this.Gr.aP(false);
      } else if (i == 2) {
         this.Gs.fv(j);
         this.Gs.aP(false);
      } else if (i == 3) {
         this.Gt.fv(j);
         this.Gt.aP(false);
      }
   }

   private void mJ() {
      this.vf = new JLabel();
      this.vb = new JButton();
      this.uC = new JButton();
      this.Gp = new JCheckBox();
      this.Gq = new C0197(1, this);
      this.Gr = new C0197(2, this);
      this.Gs = new C0197(3, this);
      this.Gt = new C0197(4, this);
      this.ug = new JLabel();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.ut = new JScrollPane();
      this.setBackground(new Color(204, 204, 204));
      this.setToolTipText("");
      this.setLayout(new C0807());
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(0, 75, 106));
      this.vf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.vf.setText("Configurar Ligas - Brasil - 120 times");
      this.add(this.vf, new C0775(50, 10, 310, -1));
      this.vb.setFont(new Font("Tahoma", 0, 12));
      this.vb.setText("Salvar");
      this.vb.setToolTipText("");
      this.add(this.vb, new C0775(610, 10, 170, 30));
      this.uC.setFont(new Font("Tahoma", 0, 12));
      this.uC.setText("Cancelar alterações");
      this.uC.setToolTipText("");
      this.add(this.uC, new C0775(390, 10, 170, 30));
      this.Gp.setBackground(new Color(0, 0, 0));
      this.Gp.setForeground(new Color(0, 75, 106));
      this.Gp.setText("Usar novo formato na Copa BRA");
      this.Gp.setHorizontalAlignment(2);
      this.Gp.setOpaque(false);
      this.add(this.Gp, new C0775(70, 30, 262, 20));
      this.add(this.Gt, new C0775(50, 550, 730, 160));
      this.add(this.Gq, new C0775(50, 50, 731, 147));
      this.add(this.Gr, new C0775(50, 210, 730, 160));
      this.add(this.Gs, new C0775(50, 380, 730, 160));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(0, 75, 106));
      this.ug.setText("4");
      this.ug.setToolTipText("");
      this.add(this.ug, new C0775(30, 570, -1, 20));
      this.uh.setFont(new Font("Tahoma", 1, 14));
      this.uh.setForeground(new Color(0, 75, 106));
      this.uh.setText("1");
      this.uh.setToolTipText("");
      this.add(this.uh, new C0775(30, 60, -1, 20));
      this.a_.setFont(new Font("Tahoma", 1, 14));
      this.a_.setForeground(new Color(0, 75, 106));
      this.a_.setText("2");
      this.a_.setToolTipText("");
      this.add(this.a_, new C0775(30, 230, -1, 20));
      this.ur.setFont(new Font("Tahoma", 1, 14));
      this.ur.setForeground(new Color(0, 75, 106));
      this.ur.setText("3");
      this.ur.setToolTipText("");
      this.add(this.ur, new C0775(30, 400, -1, 20));
      this.add(this.ut, new C0775(-30, -10, -1, -1));
   }
}
