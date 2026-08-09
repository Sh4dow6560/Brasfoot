package bf22.intermediary;

import mod.recovered.transfer.PlayerLoan;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0125 extends JPanel {
   private Club zu = null;
   private Club Af = null;
   private Player yK = null;
   private JDialog ub;
   private static boolean Ag = false;
   private JPanel xb = null;
   private JPanel Ah = null;
   private ArrayList Ai = new ArrayList();
   private ArrayList Aj = new ArrayList();
   private int xh = 0;
   private int xi = 0;
   private int Ak = 0;
   private int Al = 0;
   private JButton Am;
   private JLabel uh;
   private JLabel a_;
   private JScrollPane ut;
   private JScrollPane wi;
   private JLabel An;
   private JLabel Ao;
   private JTable Ap;
   private JTable Aq;

   public C0125(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.Af = club;
      Ag = false;
      this.mJ();
      this.mH();
      this.nS();
      this.nT();
      this.nW();
      this.mG();
   }

   private void nt() {
      this.Ai.clear();
      this.xb = new JPanel(new C0807());
      this.xh = 0;
      this.xi = 0;
   }

   private void nR() {
      this.Aj.clear();
      this.Ah = new JPanel(new C0807());
      this.Ak = 0;
      this.Al = 0;
   }

   public void nS() {
      this.nt();
      this.nU();
      ArrayList var1 = GamePersistence.careerState.e(this.Af);

      for (int var2 = 0; var2 < var1.size(); var2++) {
         this.Ai.add((PlayerLoan)var1.get(var2));
         this.a((PlayerLoan)var1.get(var2));
      }

      JViewport var3 = this.ut.getViewport();
      var3.setView(this.xb);
   }

   public void nT() {
      this.nR();
      this.nV();
      ArrayList var1 = GamePersistence.careerState.f(this.Af);

      for (int var2 = 0; var2 < var1.size(); var2++) {
         this.Aj.add((PlayerLoan)var1.get(var2));
         this.b((PlayerLoan)var1.get(var2));
      }

      JViewport var3 = this.wi.getViewport();
      var3.setView(this.Ah);
   }

   private void nU() {
      C0754 var1 = new C0754(2, this, null);
      this.xb.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xb.add(var1, new C0775(0, this.xh, 690, 36));
      this.xh += 36;
   }

   private void a(PlayerLoan c0825) {
      byte var2 = 0;
      C0754 var3 = new C0754(1, this, c0825);
      this.xb.add(var3, new C0775(0, this.xh, 690, 36));
      this.xh = this.xh + 36 + var2;
   }

   private void nV() {
      C0754 var1 = new C0754(3, this, null);
      this.Ah.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.Ah.add(var1, new C0775(0, this.Ak, 690, 36));
      this.Ak += 36;
   }

   private void b(PlayerLoan c0825) {
      C0754 var2 = new C0754(4, this, c0825);
      this.Ah.add(var2, new C0775(0, this.Ak, 690, 36));
      this.Ak += 36;
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
      this.ut.setBorder(BorderFactory.createEmptyBorder());
      this.wi.setBorder(BorderFactory.createEmptyBorder());
   }

   public void mH() {
      this.Am.addActionListener(new C0126(this));
   }

   public void a(PlayerLoan c0825, int i) {
      if (c0825.returnToOriginalClub()) {
         Ag = true;
         GamePersistence.careerState.removePlayerLoan(c0825.getPlayer());
         if (i == 1) {
            this.nS();
         } else {
            this.nT();
         }

         this.nW();
      } else {
         JOptionPane.showMessageDialog(this.ub, "Não há vagas no time de origem", "", 2);
      }
   }

   private void nW() {
      this.An.setText("vagas disponíveis: " + Integer.toString(this.Ai.size()) + "/" + Integer.toString(4));
      this.Ao.setText("limite de empréstimos: " + Integer.toString(this.Aj.size()) + "/" + Integer.toString(10));
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.Ap = new JTable();
      this.uh = new JLabel();
      this.wi = new JScrollPane();
      this.Aq = new JTable();
      this.a_ = new JLabel();
      this.Ao = new JLabel();
      this.Am = new JButton();
      this.An = new JLabel();
      this.setBackground(new Color(0, 68, 105));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setPreferredSize(new Dimension(797, 740));
      this.setLayout(new C0807());
      this.ut.setBackground(new Color(204, 204, 204));
      this.ut.setHorizontalScrollBarPolicy(31);
      this.ut.setViewportView(this.Ap);
      this.add(this.ut, new C0775(23, 48, 690, 180));
      this.uh.setFont(new Font("Tahoma", 1, 14));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("Seus jogadores emprestados em outros times");
      this.add(this.uh, new C0775(28, 267, 380, -1));
      this.wi.setBackground(new Color(204, 204, 204));
      this.wi.setHorizontalScrollBarPolicy(31);
      this.wi.setViewportView(this.Aq);
      this.add(this.wi, new C0775(23, 290, 690, 280));
      this.a_.setFont(new Font("Tahoma", 1, 14));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setText("Jogadores emprestados no seu time");
      this.add(this.a_, new C0775(28, 25, 360, -1));
      this.Ao.setFont(new Font("Tahoma", 1, 12));
      this.Ao.setForeground(new Color(255, 255, 153));
      this.Ao.setHorizontalAlignment(4);
      this.Ao.setText("limite de empréstimos: 0/10");
      this.add(this.Ao, new C0775(520, 270, 190, -1));
      this.Am.setText("X");
      this.add(this.Am, new C0775(660, 10, 50, -1));
      this.An.setFont(new Font("Tahoma", 1, 12));
      this.An.setForeground(new Color(255, 255, 153));
      this.An.setText("vagas disponíveis: 0/4");
      this.add(this.An, new C0775(510, 28, 140, -1));
   }

   public static boolean nX() {
      return Ag;
   }
}
