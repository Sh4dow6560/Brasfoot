package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0447 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private JPanel xb = null;
   private CountryCompetitions Lu = null;
   private ArrayList Lv = new ArrayList();
   private int xh = 0;
   private int xi = 0;
   private ArrayList Lw = new ArrayList();
   private JButton vm;
   private JLabel ug;
   private JScrollPane ut;
   private JTable Lx;

   public C0447(JDialog jDialog, Club club) {
      this.uk = club;
      this.ub = jDialog;
      this.Lu = GamePersistence.careerState.s(club.getPais());
      this.mJ();
      if (club != null) {
         this.ug.setIcon(club.x(30, 30));
         this.ug.setText("Retrospecto - " + club.getNome());
      }

      this.mH();
      this.sg();
      this.mG();
      JViewport var3 = this.ut.getViewport();
      var3.setView(this.xb);
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
      this.ut.setBorder(BorderFactory.createEmptyBorder());
   }

   private String h(int i, int j, int k) {
      String var4 = "";
      var4 = GameConstants.tz[i];
      Competition var5 = null;
      int var6 = this.uk.getPais();
      if (i == 9) {
         if (j == 70) {
            var4 = "Classificatório Eurocopa";
         } else {
            var4 = GameConstants.tz[i];
         }
      } else if (i == 1 && j == 1098) {
         var4 = GameConstants.abX[0];
      } else if (i == 1) {
         var4 = CountryInfo.bu(var6) + " (" + Integer.toString(k) + "ª div.)";
      } else if (i == 2) {
         var4 = "Copa " + CountryInfo.bq(var6) + " " + C0696.bl(var6);
      } else if (i == 3) {
         if (j >= 0 && j < GameConstants.rZ.length) {
            var4 = GameConstants.rZ[j] + " (" + Integer.toString(k) + "ª div.)";
         } else {
            var4 = var4 + " (" + Integer.toString(k) + "ª div.)";
         }
      } else if (i == 4 || i == 6 || i == 12) {
         var5 = GamePersistence.careerState.c(i, j);
      } else if (i == 10) {
         var4 = GameConstants.pY[j];
      } else if (i == 7) {
         var4 = GameConstants.aeF[j];
      }

      return var5 != null ? var5.getNome() : var4;
   }

   private void nt() {
      this.Lw.clear();
      this.xb = new JPanel(new C0807());
      this.xh = 0;
      this.xi = 0;
      this.a(0, null);
   }

   private void a(int i, C0786 c0786) {
      byte var4 = 0;
      C0805 var3;
      if (i == 1) {
         var3 = new C0805(1, c0786, this);
      } else if (i == 2) {
         var3 = new C0805(2, c0786, this);
         var4 = 5;
      } else {
         var3 = new C0805(0, null, this);
      }

      this.xb.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xb.add(var3, new C0775(0, this.xh, 690, 25));
      this.Lw.add(var3);
      this.xh = this.xh + 26 + var4;
   }

   public void a(C0805 c0805) {
      for (int var2 = 1; var2 < this.Lw.size(); var2++) {
         if (c0805 != this.Lw.get(var2)) {
            ((C0805)this.Lw.get(var2)).aI(false);
         }
      }

      c0805.aI(true);
   }

   private void sg() {
      this.Lv.clear();
      this.nt();
      ArrayList var1 = new ArrayList();
      int var2 = this.uk.getClubId();

      for (int var3 = 0; var3 < GamePersistence.careerState.L().size(); var3++) {
         for (int var4 = 0; var4 < ((Coach)GamePersistence.careerState.L().get(var3)).lO().size(); var4++) {
            if (((C0728)((Coach)GamePersistence.careerState.L().get(var3)).lO().get(var4)).ct() == var2) {
               var1.add(new C0449(this, ((C0728)((Coach)GamePersistence.careerState.L().get(var3)).lO().get(var4)).H(), ((Coach)GamePersistence.careerState.L().get(var3)).dS()));
            }
         }
      }

      int var12 = 0;
      boolean var14 = false;
      int[] var5 = new int[6];
      String var6 = "";

      for (int var7 = this.uk.le().size() - 1; var7 >= 0; var7--) {
         var12 = ((C0703)this.uk.le().get(var7)).H();
         C0786 var8 = new C0786();
         var8.k(((C0703)this.uk.le().get(var7)).H());
         var8.M(this.h(((C0703)this.uk.le().get(var7)).b(), ((C0703)this.uk.le().get(var7)).el(), ((C0703)this.uk.le().get(var7)).getDivisao()));
         var8.h(((C0703)this.uk.le().get(var7)).w());
         var5[0] += var8.w();
         var8.dS(((C0703)this.uk.le().get(var7)).cm());
         var5[1] += var8.cm();
         var8.dT(((C0703)this.uk.le().get(var7)).co());
         var5[2] += var8.co();
         var8.dU(((C0703)this.uk.le().get(var7)).ls());
         var5[4] += var8.ls();
         var8.dV(((C0703)this.uk.le().get(var7)).lt());
         var5[5] += var8.lt();
         var8.U(((C0703)this.uk.le().get(var7)).d(this.Lu));
         var8.ce(((C0703)this.uk.le().get(var7)).lw());
         var8.aD(((C0703)this.uk.le().get(var7)).lz());
         var8.aB(((C0703)this.uk.le().get(var7)).lx());
         var8.aC(((C0703)this.uk.le().get(var7)).ly());
         this.Lv.add(var8);
         var6 = "";
         this.a(1, var8);
         if (var7 - 1 < 0) {
            var14 = true;
         }

         if (!var14 && var12 != ((C0703)this.uk.le().get(var7 - 1)).H()) {
            var14 = true;
         }

         if (var14) {
            C0786 var9 = new C0786();
            var9.ar(true);
            var9.k(((C0703)this.uk.le().get(var7)).H());
            var9.h(var5[0]);
            var9.dS(var5[1]);
            var9.dT(var5[2]);
            var9.dU(var5[4]);
            var9.dV(var5[5]);
            this.Lv.add(var9);
            var14 = false;
            var5[0] = 0;
            var5[1] = 0;
            var5[2] = 0;
            var5[3] = 0;
            var5[4] = 0;
            var5[5] = 0;
            String var10 = null;

            for (int var11 = 0; var11 < var1.size(); var11++) {
               if (((C0449)var1.get(var11)).ae == ((C0703)this.uk.le().get(var7)).H()) {
                  if (var10 == null) {
                     var10 = ((C0449)var1.get(var11)).nome;
                  } else {
                     var10 = var10 + ", " + ((C0449)var1.get(var11)).nome;
                  }
               }
            }

            var9.T(var10);
            this.a(2, var9);
         }
      }
   }

   private void mH() {
      this.vm.addActionListener(new C0448(this));
   }

   private void mS() {
      C0576 var1 = new C0576(this.Lv);
      this.Lx.setModel(var1);
      int[] var2 = new int[]{40, 120, 120, 30, 30, 30, 30, 30, 30, 200};
      int[] var3 = new int[]{40, 220, 220, 30, 30, 30, 30, 30, 30, 400};

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.Lx.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      for (int var5 = 0; var5 < var3.length; var5++) {
         this.Lx.getColumnModel().getColumn(var5).setMaxWidth(var3[var5]);
      }

      this.Lx.setAutoResizeMode(3);
      this.Lx.setRowHeight(20);
      this.Lx.setShowGrid(false);
      this.Lx.setDefaultRenderer(C0786.class, new C0597());
      this.Lx.setAutoCreateRowSorter(false);
      this.Lx.getTableHeader().setReorderingAllowed(false);
      this.Lx.setIntercellSpacing(new Dimension(0, 0));
      this.Lx.setCellSelectionEnabled(false);
      this.Lx.setSelectionMode(0);
      this.Lx.setRowSelectionAllowed(true);
      this.Lx.setSelectionBackground(Color.YELLOW);
      this.Lx.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.ug = new JLabel();
      this.ut = new JScrollPane();
      this.Lx = new JTable();
      this.vm = new JButton();
      this.setBackground(new Color(0, 68, 105));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setPreferredSize(new Dimension(797, 740));
      this.setLayout(new C0807());
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Retrospecto");
      this.add(this.ug, new C0775(23, 20, -1, -1));
      this.ut.setBackground(new Color(204, 204, 204));
      this.ut.setHorizontalScrollBarPolicy(31);
      this.ut.setViewportView(this.Lx);
      this.add(this.ut, new C0775(23, 58, 690, 600));
      this.vm.setText("X");
      this.add(this.vm, new C0775(660, 10, 50, -1));
   }
}
