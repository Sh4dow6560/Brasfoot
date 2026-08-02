package bf22.intermediary;

import mod.recovered.match.MatchEvent;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import mod.recovered.model.Player;

public class C0373 extends JPanel {
   private JDialog ub = null;
   private C0827 Db = null;
   private MatchEvent JO = null;
   private Player ef = null;
   private Player JP = null;
   private Timer zC;
   private int JQ = 0;
   private int JR = 0;
   private boolean JS = false;
   private C0208 JT = null;
   private JLabel zM;
   private JLabel JU;
   private JLabel vf;

   public C0373(JDialog jDialog, C0827 c0827, MatchEvent c0667, Player player, C0208 c0208) {
      this.ub = jDialog;
      this.JT = c0208;
      this.Db = c0827;
      this.JO = c0667;
      this.ef = player;
      if (c0827.tR().getHomeClub() == c0667.getClub()) {
         this.JQ = 1;
         this.JR = 2;
         this.JS = c0827.tR().getHomeClub().isUserControlled();
      } else if (c0827.tR().getAwayClub() == c0667.getClub()) {
         this.JQ = 2;
         this.JR = 1;
         this.JS = c0827.tR().getAwayClub().isUserControlled();
      }

      this.JP = c0827.tR().aT(this.JR);
      this.mJ();
      this.vf.setIcon(c0667.getClub().kU());
      this.JU.setText("<html><center>" + c0667.getClub().getNome() + " tem um penalty" + "</center></html>");
      this.zC = new Timer();
      this.zC.scheduleAtFixedRate(new C0374(this), 2000L, 2000L);
      this.a((JComponent)this);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0375(this));
   }

   public void py() {
      int var1 = new Random().nextInt(6);
      String var2 = "";
      if (var1 == 0) {
         var2 = this.ef.getNome() + " " + "prepara para bater.";
      } else if (var1 == 1) {
         var2 = this.ef.getNome() + " " + "ajeita com carinho.";
      } else if (var1 == 2) {
         var2 = this.ef.getNome() + " " + "caminha em direção a marca.";
      } else if (var1 == 3) {
         var2 = this.ef.getNome() + " " + "parece confiante pra bater.";
      } else if (var1 == 4) {
         var2 = this.ef.getNome() + " " + "corre em direção à bola.";
      } else {
         var2 = this.ef.getNome() + " " + "coloca a bola na marca.";
      }

      this.JU.setText("<html><center>" + var2 + "</center></html>");
      this.zC = new Timer();
      this.zC.scheduleAtFixedRate(new C0376(this), 2000L, 2000L);
   }

   private void rJ() {
      int var1 = new Random().nextInt(5);
      String var2 = "";
      if (var1 == 0) {
         var2 = "Chuta forte e...";
      } else if (var1 == 1) {
         var2 = "Enfia um bicudo na bola e...";
      } else if (var1 == 2) {
         var2 = "Bate com força e...";
      } else if (var1 == 3) {
         var2 = "Manda uma bomba e...";
      } else {
         var2 = "Tenta uma cavadinha e...";
      }

      this.JU.setText("<html><center>" + var2 + "</center></html>");
      this.zC = new Timer();
      this.zC.scheduleAtFixedRate(new C0377(this), 2000L, 2000L);
   }

   private void nO() {
      byte var1 = 70;
      int var2 = 30;
      if (this.ef.getCr1() == 9 || this.ef.getCr2() == 9 || this.ef.gm()) {
         var1 += 10;
         var2 -= 10;
      }

      if (this.ef.ff()) {
         var1 += 5;
         var2 -= 5;
      }

      if (this.JP != null) {
         if (this.JP.getCr1() == 1 || this.JP.getCr2() == 1) {
            var1 -= 10;
            var2 += 10;
         }

         if (this.JP.gm()) {
            var1 -= 10;
            var2 += 10;
         }

         if (this.JP.ff()) {
            var1 -= 5;
            var2 += 5;
         }
      }

      boolean var3 = false;
      int var4 = new Random().nextInt(100) + 1;
      if (var4 <= var1) {
         var3 = true;
      }

      String var5 = "";
      if (var3) {
         int var6 = new Random().nextInt(7);
         if (var6 == 0) {
            var5 = "Gol!!!!";
         } else if (var6 == 1) {
            var5 = "Um chute forte e a bola estufa as redes! Gol!!!";
         } else if (var6 == 2) {
            var5 = "Goleiro de um lado e bola do outro! Gol!!!";
         } else if (var6 == 3) {
            var5 = "A torcida vibra, é gol!!!";
         } else if (var6 == 4) {
            var5 = "Cobrança perfeita! Belo gol!!!";
         } else if (var6 == 5) {
            var5 = "No canto, sem chances para o goleiro!!!";
         } else if (var6 == 6) {
            var5 = this.ef.getNome() + " " + "bateu com perfeição! Gol!!!";
         } else {
            var5 = "Gol!!!!";
         }

         this.Db.dJ(this.JQ);
         this.Db.a(this.JO);

         try {
            this.Db.tR().getMatchEngine().eG(this.JQ - 1);
         } catch (Exception var8) {
         }

         if (this.JQ == 1) {
            this.Db.tR().incrementHomeGoals();
         } else {
            this.Db.tR().incrementAwayGoals();
         }

         this.Db.tR().getShots()[this.JQ - 1]++;
         this.Db.tR().getShotsOnTarget()[this.JQ - 1]++;
         this.ef.gB().z();
         if (this.JS && this.JT != null) {
            this.JT.dk(2);
         } else {
            this.JT.dk(3);
         }
      } else {
         this.Db.tR().getShots()[this.JQ - 1]++;
         this.ef.gB().tF();
         int var11 = new Random().nextInt(7);
         if (var11 == 0) {
            var5 = "Grande defesa de " + this.JP.getNome();
         } else if (var11 == 1) {
            var5 = "Carimbou a trave!";
         } else if (var11 == 2) {
            var5 = "Pra fora, longe do gol";
         } else if (var11 == 3) {
            var5 = "Grande defesa do goleiro!";
         } else if (var11 == 4) {
            var5 = "O batedor escorrega! Incrível! Perdeu!";
         } else if (var11 == 5) {
            var5 = "Bate na trave, no goleiro e vai fora!";
         } else if (var11 == 6) {
            var5 = "Bateu bisonhamente! Foi na arquibancada!";
         } else {
            var5 = "Perdeu!!!!";
         }

         if (var11 != 2 && var11 != 6) {
            this.Db.tR().getShotsOnTarget()[this.JQ - 1]++;
         } else {
            this.Db.tR().getShotsOffTarget()[this.JQ - 1]++;
         }

         this.JO.setType(7);
         if (var11 == 0 || var11 == 3 || var11 == 5) {
            this.JO.setSecondaryPlayer(this.JP);
            this.JP.gB().tJ();
         }

         this.Db.a(this.JO);
         if (this.JS) {
            this.JT.dk(3);
         } else {
            this.JT.dk(2);
         }
      }

      this.JU.setText("<html><center>" + var5 + "</center></html>");
      this.zC = new Timer();
      this.zC.scheduleAtFixedRate(new C0378(this), 2000L, 2000L);
   }

   private void rK() {
      this.ub.dispose();
   }

   private void mJ() {
      this.vf = new JLabel();
      this.JU = new JLabel();
      this.zM = new JLabel();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setLayout(new C0807());
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 153));
      this.vf.setHorizontalAlignment(0);
      this.vf.setText("Penalty");
      this.add(this.vf, new C0775(20, 30, 360, -1));
      this.JU.setFont(new Font("Tahoma", 1, 14));
      this.JU.setForeground(new Color(255, 255, 255));
      this.JU.setHorizontalAlignment(0);
      this.JU.setText("Prepara-se");
      this.add(this.JU, new C0775(40, 100, 330, 50));
      this.zM.setForeground(new Color(255, 255, 255));
      this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/penalty1.jpg")));
      this.add(this.zM, new C0775(0, 0, -1, -1));
   }
}
