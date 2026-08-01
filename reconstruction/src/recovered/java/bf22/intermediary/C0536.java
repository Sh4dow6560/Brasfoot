package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0536 extends JPanel {
   private Player uz = null;
   private Club Nu = null;
   private static boolean Nv = false;
   private JDialog ub;
   private int Nw = 0;
   private boolean Nx = false;
   private JButton vb;
   private JButton vc;
   private JLabel ug;
   private JPanel vd;
   private JPanel wf;
   private JLabel MN;
   private JLabel MO;
   private JLabel uu;

   public C0536(JDialog jDialog, Player player, Club club, int i, boolean bl) {
      this.Nw = i;
      this.ub = jDialog;
      Nv = false;
      this.Nx = bl;
      this.uz = player;
      this.Nu = club;
      this.mJ();
      this.ag(bl);
      this.mH();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
   }

   public void mH() {
      this.vb.addActionListener(new C0537(this));
      this.vc.addActionListener(new C0538(this));
   }

   private void qX() {
      if (!this.Nx) {
         this.uz.a(this.Nu, this.Nw, false, false, false);
      } else {
         this.uz.q(this.Nu);
      }

      Nv = true;
      this.ub.dispose();
   }

   private void ag(boolean bl) {
      int[] var2 = new int[6];
      this.MO.setText("<html><b>" + this.uz.getNome() + " - " + GameConstants.rI[this.uz.getPosicao()] + "</b></html>");
      this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + this.uz.getPais() + ".png")));
      this.uu.setText(this.Nu.getNome() + " oferece: " + ClubFinances.c(this.Nw));
      this.uu.setIcon(this.Nu.kU());
      if (bl) {
         this.ug.setText("Proposta de empréstimo");
         this.uu.setText(this.Nu.getNome() + " quer emprestado:");
         this.vb.setText("Aceitar");
      }

      var2 = this.uz.gw();
      String var3 = "";
      if (this.uz.fP() && this.uz.fo() > ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime()) {
         var3 = "Fim contusão: " + ScheduleDay.a(this.uz.fo());
      }

      String var4 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;" + Integer.toString(this.uz.fi()) + "&nbsp;&nbsp;&nbsp;";
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var4 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\"><b>Gol:</b>"
            + Integer.toString(this.uz.gK())
            + " <b>Des:</b>"
            + Integer.toString(this.uz.gN())
            + " <b>Arm:</b>"
            + Integer.toString(this.uz.gO())
            + " <b>Fin:</b>"
            + Integer.toString(this.uz.gP())
            + "<br><br><b>Vel:</b>"
            + Integer.toString(this.uz.gJ())
            + " <b>Tec:</b>"
            + Integer.toString(this.uz.gL())
            + " <b>Pas:</b>"
            + Integer.toString(this.uz.gM())
            + "&nbsp;&nbsp;&nbsp;";
      }

      String var5 = var4
         + "<br><br><b>Idade:</b>"
         + Integer.toString(this.uz.getIdade())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n"
         + "<b>Jogos:"
         + "</b>&nbsp;"
         + Integer.toString(var2[0])
         + "&nbsp;&nbsp;&nbsp;"
         + "<b>Gols:"
         + "</b>"
         + Integer.toString(var2[1])
         + "&nbsp;&nbsp;&nbsp;"
         + "<b>"
         + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Valor:"
         + "</b>&nbsp;"
         + ClubFinances.c(this.uz.fk())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>"
         + "Salário:"
         + "</b>&nbsp;"
         + ClubFinances.c(this.uz.fj())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b>"
         + GameConstants.qM[this.uz.getCr1()]
         + "/"
         + GameConstants.qM[this.uz.getCr2()]
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b>"
         + var3
         + "<b><br>\n</p>\n</body></html>\n";
      this.MN.setText(var5);
   }

   private void mJ() {
      this.vd = new JPanel();
      this.wf = new JPanel();
      this.MO = new JLabel();
      this.MN = new JLabel();
      this.ug = new JLabel();
      this.uu = new JLabel();
      this.vb = new JButton();
      this.vc = new JButton();
      this.setBackground(new Color(42, 64, 29));
      this.vd.setBackground(new Color(84, 127, 59));
      this.MO.setFont(new Font("Tahoma", 0, 12));
      this.MO.setHorizontalAlignment(2);
      this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.MO.setText("Marquinhos Paraná - M");
      this.MN.setFont(new Font("Tahoma", 0, 12));
      this.MN
         .setText(
            "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Idade:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>Jogos:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Gols:</b>23&nbsp;&nbsp;&nbsp;<b>Cartões:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:</b>&nbsp;5 milhões 300 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Salário:</b>&nbsp; 230 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Marcação/desarme<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Contrato até:</b>&nbsp; 20/12/2015<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>suspenso<br>\n</p>\n</body></html>\n"
         );
      this.MN.setVerticalAlignment(1);
      GroupLayout var1 = new GroupLayout(this.wf);
      this.wf.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(10, 10, 10).addComponent(this.MN, -1, 325, 32767).addContainerGap())
                        .addGroup(var1.createSequentialGroup().addComponent(this.MO, -1, -1, 32767).addGap(25, 25, 25))
                  )
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addComponent(this.MO)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.MN)
                  .addGap(16, 16, 16)
            )
      );
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Oferta de compra");
      this.uu.setForeground(new Color(255, 255, 255));
      this.uu.setText("quer comprar o jogado:");
      this.vb.setText("Vender");
      this.vc.setText("Recusar proposta");
      GroupLayout var2 = new GroupLayout(this.vd);
      this.vd.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.wf, -1, -1, 32767)
                        .addComponent(this.ug, -1, -1, 32767)
                        .addComponent(this.uu, -1, -1, 32767)
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addComponent(this.vb, -2, 144, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vc, -2, 145, -2)
                        )
                  )
                  .addContainerGap(15, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.uu)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.wf, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, 16, 32767)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.vb).addComponent(this.vc))
                  .addContainerGap()
            )
      );
      GroupLayout var3 = new GroupLayout(this);
      this.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(var3.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(var3.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
      );
   }

   public static boolean sO() {
      return Nv;
   }
}
