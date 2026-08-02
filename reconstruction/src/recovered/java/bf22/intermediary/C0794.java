package bf22.intermediary;

import mod.recovered.transfer.TransferNegotiation;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Dimension;
import javax.swing.JDialog;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0794 {
   private Player U;
   private int oq;
   private boolean Rz = false;
   private int RA;
   private Club RB;

   public C0794(Player player, int i, boolean bl, boolean bl2) {
      this.U = player;
      this.oq = i;
      int var5 = 0;
      if (!bl2) {
         for (int var6 = 0; var6 < GamePersistence.careerState.aN().size(); var6++) {
            if (GamePersistence.careerState.aN().get(var6) != player.getClub() && ((Club)GamePersistence.careerState.aN().get(var6)).kb() >= i) {
               var5++;
            }
         }
      }

      if (var5 == 0) {
         this.Rz = true;
      }

      if (this.uZ()) {
         this.iy();
      }

      if (!bl2) {
         this.vb();
      }

      this.va();
   }

   private boolean uZ() {
      double var1 = C0272.qq();
      if (var1 == 0.0) {
         var1 = 0.1;
      }

      int var3 = (int)Math.round(this.U.fk() * C0272.qq());
      return this.oq <= this.U.fk() + var3;
   }

   private void iy() {
      TransferNegotiation var1 = new TransferNegotiation(this.U, this.oq, true, false, 0);
      var1.a(false, false);
      this.RB = var1.cK();
      this.RA = var1.cL();
   }

   private void va() {
      if (this.RB != null) {
         this.U.moveToClub(this.RB, this.RA, true, false, false);
      }
   }

   private void vb() {
      JDialog var1 = new JDialog(MainWindow.db());
      C0475 var2 = new C0475(var1, this);
      var1.add(var2);
      var1.setSize(604, 550);
      var1.setPreferredSize(new Dimension(604, 550));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.pack();
      var1.setVisible(true);
   }

   public Player x() {
      return this.U;
   }

   public void a(Player player) {
      this.U = player;
   }

   public int lY() {
      return this.oq;
   }

   public void cq(int i) {
      this.oq = i;
   }

   public boolean vc() {
      return this.Rz;
   }

   public void aE(boolean bl) {
      this.Rz = bl;
   }

   public int vd() {
      return this.RA;
   }

   public Club ve() {
      return this.RB;
   }

   public void ei(int i) {
      this.RA = i;
   }

   public void I(Club club) {
      this.RB = club;
   }
}
