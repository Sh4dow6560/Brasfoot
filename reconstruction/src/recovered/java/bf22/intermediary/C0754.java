package bf22.intermediary;

import mod.recovered.transfer.PlayerLoan;
import mod.recovered.game.ScheduleDay;
import mod.recovered.core.GameConstants;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class C0754 extends JPanel {
   C0125 Qj = null;
   PlayerLoan Qk;
   int w = -1;
   private JButton Ql;
   private JButton Qm;
   private JLabel Qn;
   private JLabel uF;
   private JLabel zO;

   public C0754(int i, C0125 c0125, PlayerLoan c0825) {
      this.Qj = c0125;
      this.Qk = c0825;
      this.w = i;
      if (i == 1) {
         this.mJ();
         this.uF.setText(GameConstants.rI[c0825.getPlayer().getPosicao()] + " - " + c0825.getPlayer().getNome());
         this.Qn.setText(ScheduleDay.a(c0825.getEndTimeMillis()));
         if (c0825.getOriginalClub() != null) {
            this.zO.setText(c0825.getOriginalClub().getNome());
            this.zO.setIcon(c0825.getOriginalClub().kU());
         }

         this.mH();
      } else if (i == 4) {
         this.ui();
         this.mJ();
         this.uF.setText(GameConstants.rI[c0825.getPlayer().getPosicao()] + " - " + c0825.getPlayer().getNome());
         this.Qn.setText(ScheduleDay.a(c0825.getEndTimeMillis()));
         if (c0825.getPlayer().getClub() != null) {
            this.zO.setText(c0825.getPlayer().getClub().getNome());
            this.zO.setIcon(c0825.getPlayer().getClub().kU());
         }

         this.mH();
      } else if (i == 2 || i == 3) {
         this.ui();
         if (i == 3) {
            this.zO.setText("Jogando no time");
         }
      }
   }

   private void mH() {
      this.Ql.addActionListener(new C0755(this));
      this.Qm.addActionListener(new C0756(this));
   }

   private void uh() {
      this.setCursor(new Cursor(3));
      MainWindow.a(this.Qk.getPlayer(), null);
      this.setCursor(new Cursor(12));
   }

   private void qG() {
      int var1 = -1;
      var1 = JOptionPane.showConfirmDialog(this.Qj, "Deseja cancelar o empréstimo do jogador " + this.Qk.getPlayer().getNome() + "?", "Confirmar", 0);
      if (var1 == 0) {
         this.Qj.a(this.Qk, this.w);
      }
   }

   private void mJ() {
      this.Qn = new JLabel();
      this.uF = new JLabel();
      this.Qm = new JButton();
      this.Ql = new JButton();
      this.zO = new JLabel();
      this.setBackground(new Color(228, 227, 227));
      this.setPreferredSize(new Dimension(690, 36));
      this.setLayout(new C0807());
      this.Qn.setFont(new Font("Arial", 1, 12));
      this.Qn.setText("Fase Qualificatória R1");
      this.add(this.Qn, new C0775(380, 0, 160, 40));
      this.uF.setFont(new Font("Arial", 1, 12));
      this.uF.setText("João da Silva");
      this.add(this.uF, new C0775(10, 0, 150, 40));
      this.Qm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_eli.png")));
      this.add(this.Qm, new C0775(615, 5, -1, 25));
      this.Ql.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon22small.png")));
      this.add(this.Ql, new C0775(550, 5, -1, 25));
      this.zO.setFont(new Font("Arial", 1, 12));
      this.zO.setText("Fase Qualificatória R1");
      this.add(this.zO, new C0775(170, 0, 190, 40));
   }

   private void ui() {
      this.Qn = new JLabel();
      this.uF = new JLabel();
      this.zO = new JLabel();
      this.setBackground(new Color(0, 0, 0));
      this.setPreferredSize(new Dimension(690, 36));
      this.setLayout(new C0807());
      this.Qn.setFont(new Font("Arial", 1, 12));
      this.Qn.setForeground(new Color(255, 255, 255));
      this.Qn.setText("Data fim do empréstimo");
      this.add(this.Qn, new C0775(380, 0, 160, 40));
      this.uF.setFont(new Font("Arial", 1, 12));
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setText("Jogador");
      this.add(this.uF, new C0775(10, 0, 150, 40));
      this.zO.setFont(new Font("Arial", 1, 12));
      this.zO.setForeground(new Color(255, 255, 255));
      this.zO.setText("Time a que pertence");
      this.add(this.zO, new C0775(170, 0, 190, 40));
   }
}
