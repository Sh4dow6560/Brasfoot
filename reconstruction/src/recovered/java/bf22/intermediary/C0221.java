package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mod.recovered.model.Club;

public class C0221 extends JPanel {
   private JDialog ub;
   private Club zY = null;
   private int EQ = 0;
   private C0816[] ER;
   private JButton vm;
   private C0816 ES;
   private C0816 ET;
   private C0816 EU;
   private C0816 EV;
   private C0816 EW;
   private C0816 EX;
   private C0816 EY;
   private C0816 EZ;
   private C0816 Fa;
   private C0816 Fb;
   private C0816 Fc;
   private C0816 Fd;
   private C0816 Fe;
   private C0816 Ff;
   private C0816 Fg;
   private C0816 Fh;
   private JLabel vf;

   public C0221(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.zY = club;
      this.mJ();
      this.mH();
      C0816[] var3 = new C0816[]{
         this.ES, this.Fa, this.Fb, this.Fc, this.Fd, this.Fe, this.Ff, this.Fg, this.Fh, this.ET, this.EU, this.EV, this.EW, this.EX, this.EY, this.EZ
      };
      this.ER = var3;
      this.vf.setText("Galeria de Troféus - " + club.getNome());
      this.vf.setIcon(club.kU());
      if (this.zY.cT().size() > 0) {
         this.py();
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void pD() {
      CountryCompetitions var1 = GamePersistence.careerState.o(29);
      this.zY.q((Competition)var1.eb().get(0));
      this.zY.q((Competition)var1.eb().get(1));
      this.zY.q((Competition)var1.eb().get(2));
      this.zY.q((Competition)var1.eb().get(3));
      C0741 var2 = null;

      for (int var3 = 0; var3 < GamePersistence.careerState.aE().size(); var3++) {
         if (((C0741)GamePersistence.careerState.aE().get(var3)).eb().size() > 1) {
            var2 = (C0741)GamePersistence.careerState.aE().get(var3);
            break;
         }
      }

      this.zY.q((Competition)var2.eb().get(0));
      this.zY.q((Competition)var2.eb().get(1));
   }

   private void py() {
      if (this.zY.lp()) {
         this.AD();
      } else {
         this.pE();
         this.pF();
         this.pB();
         this.pC();
      }
   }

   private void AD() {
      this.N(7, 7);
      this.N(7, this.zY.gg());
      if (this.zY.gg() == 0) {
         this.N(14, 0);
      } else if (this.zY.gg() == 4) {
         this.N(14, 4);
      }

      if (this.zY.gg() == 0 || this.zY.gg() == 1) {
         this.M(13, -1);
      }
   }

   private void pE() {
      this.M(5, -1);
   }

   private void pF() {
      int var1 = this.zY.gg();
      this.M(4, var1);
      this.M(6, var1);
      this.M(12, var1);
      this.M(8, var1);
   }

   private void pB() {
      this.N(1, 1);
      this.M(2, -1);
      this.M(11, -1);
      this.N(1, 2);
      this.N(1, 3);
      this.N(1, 4);
   }

   private void pC() {
      int var1 = this.zY.jV();
      this.M(10, var1);
      this.N(3, 1);
      this.N(3, 2);
      this.N(3, 3);
      this.N(3, 4);
   }

   public void M(int i, int j) {
      int var3 = 0;
      Competition var4 = null;
      ArrayList var5 = new ArrayList();
      int var6 = -1;

      for (int var7 = this.zY.cT().size() - 1; var7 >= 0; var7--) {
         if (((C0708)this.zY.cT().get(var7)).b() == i && ((C0708)this.zY.cT().get(var7)).H() != var6) {
            var3++;
            var5.add(((C0708)this.zY.cT().get(var7)).H() + GamePersistence.careerState.iU());
            var4 = ((C0708)this.zY.cT().get(var7)).gS();
            var6 = ((C0708)this.zY.cT().get(var7)).H();
         }
      }

      String var8 = this.W(var5);
      if (var3 > 0) {
         this.a(i, j, var3, var8, var4);
      }
   }

   public void N(int i, int j) {
      int var3 = 0;
      Competition var4 = null;
      ArrayList var5 = new ArrayList();
      int var6 = -1;

      for (int var7 = this.zY.cT().size() - 1; var7 >= 0; var7--) {
         if (((C0708)this.zY.cT().get(var7)).b() == i && ((C0708)this.zY.cT().get(var7)).el() == j && ((C0708)this.zY.cT().get(var7)).H() != var6) {
            var3++;
            var5.add(((C0708)this.zY.cT().get(var7)).H() + GamePersistence.careerState.iU());
            var4 = ((C0708)this.zY.cT().get(var7)).gS();
            var6 = ((C0708)this.zY.cT().get(var7)).H();
         }
      }

      String var8 = this.W(var5);
      if (var3 > 0) {
         this.a(i, j, var3, var8, var4);
      }
   }

   private String W(ArrayList arrayList) {
      String var2 = "";
      int var3 = 0;

      while (var3 < arrayList.size()) {
         var3++;
      }

      for (int var5 = 0; var5 < arrayList.size(); var5++) {
         String var4 = Integer.toString((Integer)arrayList.get(var5)) + ", ";
         if (var5 == arrayList.size() - 1 || var5 == 22) {
            var4 = Integer.toString((Integer)arrayList.get(var5));
         }

         var2 = var2 + var4;
         if (var5 == 22) {
            var2 = var2 + "...";
            break;
         }
      }

      return "<html>" + var2 + "</html>";
   }

   private void a(int i, int j, int k, String string, Competition c0713) {
      if (this.EQ < this.ER.length) {
         String[] var6 = c0713.mA();
         String var7 = var6[0];
         String var8 = var6[1];
         this.ER[this.EQ].a(var8, string, k, GameConstants.x(var7));
         this.EQ++;
      }
   }

   private void mH() {
      this.vm.addActionListener(new C0222(this));
   }

   private void mJ() {
      this.vf = new JLabel();
      this.vm = new JButton();
      this.Fc = new C0816();
      this.ES = new C0816();
      this.Fa = new C0816();
      this.Fb = new C0816();
      this.Fd = new C0816();
      this.Fe = new C0816();
      this.Ff = new C0816();
      this.Fg = new C0816();
      this.Fh = new C0816();
      this.ET = new C0816();
      this.EU = new C0816();
      this.EV = new C0816();
      this.EW = new C0816();
      this.EX = new C0816();
      this.EY = new C0816();
      this.EZ = new C0816();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setBackground(new Color(0, 0, 0));
      this.setLayout(new C0807());
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Galeria de Trofeus");
      this.add(this.vf, new C0775(20, 10, 303, -1));
      this.vm.setFont(new Font("Tahoma", 0, 12));
      this.vm.setText("X");
      this.vm.setToolTipText("");
      this.add(this.vm, new C0775(805, 5, 60, -1));
      this.add(this.Fc, new C0775(665, 40, 200, 164));
      this.add(this.ES, new C0775(20, 40, 200, 164));
      this.add(this.Fa, new C0775(235, 40, 200, 164));
      this.add(this.Fb, new C0775(450, 40, 200, 164));
      this.add(this.Fd, new C0775(20, 220, 200, 164));
      this.add(this.Fe, new C0775(235, 220, 200, 164));
      this.add(this.Ff, new C0775(450, 220, 200, 164));
      this.add(this.Fg, new C0775(665, 220, 200, 164));
      this.add(this.Fh, new C0775(20, 400, 200, 164));
      this.add(this.ET, new C0775(235, 400, 200, 164));
      this.add(this.EU, new C0775(450, 400, 200, 164));
      this.add(this.EV, new C0775(665, 400, 200, 164));
      this.add(this.EW, new C0775(20, 580, 200, 164));
      this.add(this.EX, new C0775(235, 580, 200, 164));
      this.add(this.EY, new C0775(450, 580, 200, 164));
      this.add(this.EZ, new C0775(665, 580, 200, 164));
   }

   public int pG() {
      return this.EQ;
   }
}
