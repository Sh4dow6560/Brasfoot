package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionSeasonResult;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0219 extends JPanel {
   private JDialog ub;
   private Coach Es = null;
   private int Et = 0;
   private ArrayList Eu = new ArrayList();
   private ArrayList Ev = new ArrayList();
   private ArrayList Ew = new ArrayList();
   private ArrayList Ex = new ArrayList();
   private JLabel[] Ey;
   private JButton vm;
   private C0817 Ez;
   private C0817 EA;
   private C0817 EB;
   private JLabel vf;
   private JLabel EC;
   private JLabel xJ;
   private JLabel ED;
   private JLabel EE;
   private JLabel EF;
   private JLabel EG;
   private JLabel EH;
   private JLabel EI;
   private JLabel EJ;
   private JLabel EK;
   private JLabel EL;
   private JLabel EM;
   private JLabel EN;
   private JLabel EO;

   public C0219(JDialog jDialog, Coach coach) {
      this.ub = jDialog;
      this.Es = coach;
      this.mJ();
      this.vf.setText(coach.dS());
      JLabel[] var3 = new JLabel[]{this.xJ, this.ED, this.EH, this.EI, this.EJ, this.EK, this.EL, this.EM, this.EN, this.EO, this.EE, this.EF, this.EG};
      this.Ey = var3;

      for (int var4 = 0; var4 < this.Ey.length; var4++) {
         this.Ey[var4].setVisible(false);
      }

      this.mH();
      this.py();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 1));
   }

   private void py() {
      this.pA();
      this.pB();
      this.pC();
      this.pz();
   }

   private void pz() {
      for (int var1 = 0; var1 < this.Ex.size(); var1++) {
         if (var1 < this.Ey.length) {
            this.Ey[var1].setVisible(true);
            this.Ey[var1].setIcon(GameConstants.a(GameConstants.x((String)this.Ex.get(var1)), 43, 60));
         }

         this.Et++;
      }
   }

   private void pA() {
      this.d(GamePersistence.SR.aY(), 7);
      this.d(GamePersistence.SR.sq(), 0);
      this.d(GamePersistence.SR.ym(), 4);
      this.d(GamePersistence.SR.ba(), 0);
      this.d(GamePersistence.SR.aZ(), 1);
      this.d(GamePersistence.SR.be(), 2);
      this.d(GamePersistence.SR.bf(), 3);
      this.d(GamePersistence.SR.bg(), 4);
      this.d(GamePersistence.SR.bX(), 5);
      this.d(GamePersistence.SR.yl(), 7);
      this.a(5, -1, this.Eu);
      this.a(4, -1, this.Eu);
      this.a(6, -1, this.Eu);
      this.a(12, -1, this.Eu);
      this.a(8, -1, this.Eu);
      this.EA.a("Internacionais", this.Eu);
   }

   private void pB() {
      this.b(1, 1, this.Ev);
      this.a(2, -1, this.Ev);
      this.a(11, -1, this.Ev);
      this.b(1, 2, this.Ev);
      this.b(1, 3, this.Ev);
      this.b(1, 4, this.Ev);
      this.EB.a("Nacionais", this.Ev);
   }

   private void pC() {
      this.a(10, -1, this.Ew);
      this.b(3, 1, this.Ew);
      this.b(3, 2, this.Ew);
      this.b(3, 3, this.Ew);
      this.b(3, 4, this.Ew);
      String var1 = "Estaduais e regionais";
      if (!GamePersistence.SR.isJogaRegionais()) {
         var1 = "Estaduais";
      }

      this.Ez.a(var1, this.Ew);
   }

   private void d(Competition c0713, int i) {
      if (c0713 != null) {
         for (int var3 = 0; var3 < c0713.mn().size(); var3++) {
            if (((CompetitionSeasonResult)c0713.mn().get(var3)).ci() == this.Es) {
               this.a(((CompetitionSeasonResult)c0713.mn().get(var3)).H(), 7, i, c0713, ((CompetitionSeasonResult)c0713.mn().get(var3)).ce(), this.Eu);
            }
         }
      }
   }

   public void a(int i, int j, ArrayList arrayList) {
      Competition var4 = null;
      Club var5 = null;
      int var6 = 0;

      for (int var7 = this.Es.cT().size() - 1; var7 >= 0; var7--) {
         if (((C0708)this.Es.cT().get(var7)).b() == i) {
            var4 = ((C0708)this.Es.cT().get(var7)).gS();
            var5 = GamePersistence.SR.x(((C0708)this.Es.cT().get(var7)).ct());
            var6 = ((C0708)this.Es.cT().get(var7)).H();
            this.a(var6, i, j, var4, var5, arrayList);
         }
      }
   }

   public void b(int i, int j, ArrayList arrayList) {
      Competition var4 = null;
      Club var5 = null;
      int var6 = 0;

      for (int var7 = this.Es.cT().size() - 1; var7 >= 0; var7--) {
         if (((C0708)this.Es.cT().get(var7)).b() == i && ((C0708)this.Es.cT().get(var7)).el() == j) {
            var4 = ((C0708)this.Es.cT().get(var7)).gS();
            var5 = GamePersistence.SR.x(((C0708)this.Es.cT().get(var7)).ct());
            var6 = ((C0708)this.Es.cT().get(var7)).H();
            this.a(var6, i, j, var4, var5, arrayList);
         }
      }
   }

   private void a(int i, int j, int k, Competition c0713, Club club, ArrayList arrayList) {
      String[] var7 = c0713.mA();
      String var8 = var7[0];
      String var9 = var7[1];
      C0778 var10 = new C0778();
      var10.k(i);
      var10.ab(var9);
      var10.k(club);
      var10.j(GameConstants.a(GameConstants.x(var8), 18, 18));
      arrayList.add(var10);
      if (!var8.equals("tr_nacionalgenerico") && !var8.equals("tr_supercopa_generico") && !var8.equals("tr_estadualgenerico") && !this.Ex.contains(var8)) {
         this.Ex.add(var8);
      }
   }

   private void mH() {
      this.vm.addActionListener(new C0220(this));
   }

   private void mJ() {
      this.vf = new JLabel();
      this.vm = new JButton();
      this.Ez = new C0817();
      this.EA = new C0817();
      this.EB = new C0817();
      this.EC = new JLabel();
      this.EG = new JLabel();
      this.xJ = new JLabel();
      this.ED = new JLabel();
      this.EH = new JLabel();
      this.EI = new JLabel();
      this.EJ = new JLabel();
      this.EK = new JLabel();
      this.EL = new JLabel();
      this.EM = new JLabel();
      this.EN = new JLabel();
      this.EO = new JLabel();
      this.EE = new JLabel();
      this.EF = new JLabel();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setBackground(new Color(0, 68, 105));
      this.setLayout(new C0807());
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 204));
      this.vf.setText("Galeria de Trofeus Técnico");
      this.add(this.vf, new C0775(30, 60, 200, -1));
      this.vm.setFont(new Font("Tahoma", 0, 12));
      this.vm.setText("X");
      this.vm.setToolTipText("");
      this.add(this.vm, new C0775(910, 20, 50, -1));
      this.add(this.Ez, new C0775(650, 100, 310, 520));
      this.add(this.EA, new C0775(10, 100, 310, 520));
      this.add(this.EB, new C0775(330, 100, 310, 520));
      this.EC.setFont(new Font("Tahoma", 1, 14));
      this.EC.setForeground(new Color(255, 255, 255));
      this.EC.setText("Galeria de Trofeus Técnico");
      this.add(this.EC, new C0775(30, 30, 200, -1));
      this.EG.setForeground(new Color(255, 255, 255));
      this.EG.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EG.setToolTipText("");
      this.add(this.EG, new C0775(850, 20, -1, -1));
      this.xJ.setForeground(new Color(255, 255, 255));
      this.xJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.xJ.setToolTipText("");
      this.add(this.xJ, new C0775(240, 20, -1, -1));
      this.ED.setForeground(new Color(255, 255, 255));
      this.ED.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.ED.setToolTipText("");
      this.add(this.ED, new C0775(290, 20, -1, -1));
      this.EH.setForeground(new Color(255, 255, 255));
      this.EH.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EH.setToolTipText("");
      this.add(this.EH, new C0775(340, 20, -1, -1));
      this.EI.setForeground(new Color(255, 255, 255));
      this.EI.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EI.setToolTipText("");
      this.add(this.EI, new C0775(390, 20, -1, -1));
      this.EJ.setForeground(new Color(255, 255, 255));
      this.EJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EJ.setToolTipText("");
      this.add(this.EJ, new C0775(440, 20, -1, -1));
      this.EK.setForeground(new Color(255, 255, 255));
      this.EK.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EK.setToolTipText("");
      this.add(this.EK, new C0775(490, 20, -1, -1));
      this.EL.setForeground(new Color(255, 255, 255));
      this.EL.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EL.setToolTipText("");
      this.add(this.EL, new C0775(540, 20, -1, -1));
      this.EM.setForeground(new Color(255, 255, 255));
      this.EM.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EM.setToolTipText("");
      this.add(this.EM, new C0775(590, 20, -1, -1));
      this.EN.setForeground(new Color(255, 255, 255));
      this.EN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EN.setToolTipText("");
      this.add(this.EN, new C0775(640, 20, -1, -1));
      this.EO.setForeground(new Color(255, 255, 255));
      this.EO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EO.setToolTipText("");
      this.add(this.EO, new C0775(690, 20, -1, -1));
      this.EE.setForeground(new Color(255, 255, 255));
      this.EE.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EE.setToolTipText("");
      this.add(this.EE, new C0775(750, 20, -1, -1));
      this.EF.setForeground(new Color(255, 255, 255));
      this.EF.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.EF.setToolTipText("");
      this.add(this.EF, new C0775(800, 20, -1, -1));
   }
}
