package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0475 extends JPanel {
   private JDialog ub;
   private C0794 Nc;
   private Player uz;
   private ArrayList Nd;
   private ArrayList Ne;
   private int index = 0;
   private JButton zK;
   private JButton Nf;
   private JButton Ng;
   private JTextField uE;
   private JLabel ug;
   private JPanel vd;
   private JPanel we;
   private JPanel wf;
   private JLabel MN;
   private JLabel MO;
   private JLabel Nh;
   private JLabel uH;
   private JLabel zO;
   private JLabel zP;
   private JLabel Ni;

   public C0475(JDialog jDialog, C0794 c0794) {
      this.ub = jDialog;
      this.Nc = c0794;
      this.uz = c0794.x();
      this.mJ();
      this.mK();
      this.mH();
      if (c0794.vc()) {
         this.sJ();
      } else {
         this.sK();
      }

      this.uH.setText("");
   }

   private void sJ() {
      this.uE.setVisible(false);
      this.Nf.setVisible(false);
      this.Ng.setVisible(false);
      this.uH.setVisible(false);
      this.zP.setVisible(false);
      if (this.Nc.ve() != null) {
         this.Ni.setIcon(this.Nc.ve().x(30, 30));
         this.Ni.setText("<html>Comprador: " + this.Nc.ve().getNome() + " vendido por " + ClubFinances.c(this.Nc.vd()) + "</html>");
      } else {
         this.Ni.setText("Não houve compradores - tente com um preço menor...");
      }
   }

   private void sK() {
      this.Nd = new ArrayList();
      this.Ne = new ArrayList();

      for (int var1 = 0; var1 < C0745.SR.aN().size(); var1++) {
         if (C0745.SR.aN().get(var1) != this.uz.fg() && ((Club)C0745.SR.aN().get(var1)).kb() > this.Nc.lY()) {
            this.Nd.add((Club)C0745.SR.aN().get(var1));
         }
      }

      this.sL();
   }

   private void sL() {
      this.zP.setText(((Club)this.Nd.get(this.index)).ka().dS() + ", dinheiro em caixa:" + ClubFinances.c(((Club)this.Nd.get(this.index)).kb()));
      this.zP.setIcon(((Club)this.Nd.get(this.index)).kU());
   }

   private void mK() {
      int[] var1 = new int[6];
      this.MO.setText("<html><b>" + this.uz.getNome() + " - " + C0710.rI[this.uz.getPosicao()] + "</b></html>");
      this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + this.uz.getPais() + ".png")));
      this.Nh.setText(ClubFinances.c(this.uz.fl()));
      this.zO.setText(this.uz.fg().getNome());
      this.zO.setIcon(this.uz.fg().kU());
      var1 = this.uz.gw();
      String var2 = "";
      if (this.uz.fP()) {
         var2 = "Fim contusão: " + C0693.a(this.uz.fo());
      }

      String var3 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;" + Integer.toString(this.uz.fi()) + "&nbsp;&nbsp;&nbsp;";
      if (C0745.SR.isHabilidadeIndividual()) {
         var3 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n&nbsp;&nbsp;&nbsp;&nbsp;<b>Gol:</b>"
            + Integer.toString(this.uz.gK())
            + " <b>Des:</b>"
            + Integer.toString(this.uz.gN())
            + " <b>Arm:</b>"
            + Integer.toString(this.uz.gO())
            + " <b>Fin:</b>"
            + Integer.toString(this.uz.gP())
            + " <b>Vel:</b>"
            + Integer.toString(this.uz.gJ())
            + " <b>Téc:</b>"
            + Integer.toString(this.uz.gL())
            + " <b>Pas:</b>"
            + Integer.toString(this.uz.gM())
            + "&nbsp;&nbsp;&nbsp;";
      }

      String var4 = var3
         + "<b>Idade:</b>"
         + Integer.toString(this.uz.getIdade())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n"
         + "<b>Jogos:"
         + "</b>&nbsp;"
         + Integer.toString(var1[0])
         + "&nbsp;&nbsp;&nbsp;"
         + "<b>Gols:"
         + "</b>"
         + Integer.toString(var1[1])
         + "&nbsp;&nbsp;&nbsp;"
         + "<b>"
         + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:"
         + "</b>&nbsp;"
         + ClubFinances.c(this.uz.fk())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>"
         + "Salário:"
         + "</b>&nbsp;"
         + ClubFinances.c(this.uz.fj())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b>"
         + C0710.qM[this.uz.getCr1()]
         + "/"
         + C0710.qM[this.uz.getCr2()]
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b>"
         + var2
         + "<b><br>\n</p>\n</body></html>\n";
      this.MN.setText(var4);
   }

   public void mH() {
      this.zK.addActionListener(new C0476(this));
      this.Nf.addActionListener(new C0477(this));
      this.Ng.addActionListener(new C0524(this));
      this.uE.getDocument().addDocumentListener(new C0525(this));
   }

   public static boolean B(String string) {
      try {
         Integer.parseInt(string);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      } catch (NullPointerException var3) {
         return false;
      }
   }

   private void oK() {
      String var1 = this.uE.getText().toString() + "000";
      if (!var1.equals("") && var1.matches("\\d+") && B(var1) && Integer.parseInt(var1) >= 0) {
         this.uH.setText(ClubFinances.c(Integer.parseInt(var1)));
      } else {
         this.uH.setText("valor inválido");
      }
   }

   private void pR() {
      int var1 = 0;
      String var2 = this.uE.getText().toString() + "000";
      if (!var2.equals("") && var2.matches("\\d+") && B(var2) && Integer.parseInt(var2) >= 0) {
         var1 = Integer.parseInt(var2);
         if (((Club)this.Nd.get(this.index)).kb() >= var1) {
            this.dC(var1);
         } else {
            this.uH.setText("lance maior que valor em caixa");
         }
      } else {
         this.uH.setText("valor inválido");
      }
   }

   private void sM() {
      this.dC(0);
   }

   private void dC(int i) {
      this.Ne.add(i);
      if (this.index + 1 < this.Nd.size()) {
         this.index++;
         this.sL();
      } else {
         this.nO();
      }
   }

   private void nO() {
      int var1 = 0;
      int var2 = 0;
      Club var3 = null;
      int var4 = 0;
      if (this.Ne.size() > 0) {
         var2 = (Integer)this.Ne.get(0);

         for (int var5 = 0; var5 < this.Ne.size(); var5++) {
            if ((Integer)this.Ne.get(var5) > var2) {
               var1 = var5;
            }
         }

         if (var1 < this.Nd.size()) {
            var3 = (Club)this.Nd.get(var1);
            var4 = (Integer)this.Ne.get(var1);
         }
      }

      if (var4 > 0) {
         if (this.Nc.ve() == null) {
            this.Nc.I(var3);
            this.Nc.ei(var4);
         } else if (var4 > this.Nc.vd()) {
            this.Nc.I(var3);
            this.Nc.ei(var4);
         }
      }

      this.sJ();
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.wf = new JPanel();
      this.MO = new JLabel();
      this.MN = new JLabel();
      this.we = new JPanel();
      this.zO = new JLabel();
      this.zP = new JLabel();
      this.Nh = new JLabel();
      this.Ni = new JLabel();
      this.uE = new JTextField();
      this.uH = new JLabel();
      this.Nf = new JButton();
      this.zK = new JButton();
      this.Ng = new JButton();
      this.setBackground(new Color(42, 64, 29));
      this.setLayout(new C0807());
      this.vd.setBackground(new Color(84, 127, 59));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(2);
      this.ug.setText("Venda de jogador em leilão");
      this.MO.setFont(new Font("Tahoma", 0, 12));
      this.MO.setHorizontalAlignment(2);
      this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
      this.MO.setText("Marquinhos Paraná - M");
      this.MN.setFont(new Font("Tahoma", 0, 11));
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
      this.we.setOpaque(false);
      GroupLayout var2 = new GroupLayout(this.we);
      this.we.setLayout(var2);
      var2.setHorizontalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 367, 32767));
      var2.setVerticalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 112, 32767));
      this.zO.setForeground(new Color(255, 255, 255));
      this.zO.setHorizontalAlignment(2);
      this.zO.setText("Time 1 está vendendo o jogador");
      this.zP.setForeground(new Color(255, 255, 255));
      this.zP.setText("Dinheiro em caixa:");
      this.Nh.setFont(new Font("Tahoma", 1, 11));
      this.Nh.setForeground(new Color(255, 255, 255));
      this.Nh.setText("Lance mínimo:");
      this.Ni.setForeground(new Color(255, 255, 255));
      this.Ni.setHorizontalAlignment(2);
      this.Ni.setText("<html>Faça sua oferta em milhares de $, por exemplo: 300 equivale à 300 mil, 1200 à 1 milhão e duzentos etc</html>");
      this.uH.setForeground(new Color(255, 255, 255));
      this.uH.setHorizontalAlignment(2);
      this.uH.setText("Preço inicial:");
      this.Nf.setText("Ofertar");
      this.zK.setText("continuar >>");
      this.Ng.setText("Pular");
      GroupLayout var3 = new GroupLayout(this.vd);
      this.vd.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var3.createSequentialGroup()
                  .addGap(101, 101, 101)
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var3.createSequentialGroup()
                              .addGroup(
                                 var3.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.Nh, -2, 314, -2)
                                    .addGroup(
                                       var3.createParallelGroup(Alignment.TRAILING, false)
                                          .addGroup(
                                             var3.createSequentialGroup()
                                                .addComponent(this.ug, -2, 198, -2)
                                                .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                                .addComponent(this.zK)
                                          )
                                          .addComponent(this.wf, Alignment.LEADING, -2, -1, -2)
                                    )
                                    .addComponent(this.Ng, Alignment.TRAILING, -2, 77, -2)
                              )
                              .addContainerGap(-1, 32767)
                        )
                        .addGroup(
                           var3.createSequentialGroup()
                              .addGroup(
                                 var3.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.zO, -2, 196, -2)
                                    .addGroup(
                                       var3.createSequentialGroup()
                                          .addGroup(
                                             var3.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.zP, -2, 411, -2)
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addComponent(this.uE, -2, 178, -2)
                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                      .addComponent(this.Nf, -2, 79, -2)
                                                )
                                                .addComponent(this.uH, -2, 313, -2)
                                          )
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.we, -2, -1, -2)
                                    )
                                    .addComponent(this.Ni, -2, 355, -2)
                              )
                              .addGap(0, 0, 32767)
                        )
                  )
            )
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var3.createSequentialGroup()
                  .addGap(23, 23, 23)
                  .addGroup(var3.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.zK))
                  .addGap(3, 3, 3)
                  .addComponent(this.zO)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Nh)
                  .addGap(8, 8, 8)
                  .addComponent(this.wf, -2, -1, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.Ni, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var3.createSequentialGroup()
                              .addGroup(
                                 var3.createParallelGroup(Alignment.BASELINE).addComponent(this.uE, -2, -1, -2).addComponent(this.Nf).addComponent(this.Ng)
                              )
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.uH)
                              .addGap(25, 25, 25)
                              .addComponent(this.zP)
                        )
                        .addComponent(this.we, -2, -1, -2)
                  )
                  .addContainerGap(-1, 32767)
            )
      );
      this.add(this.vd, new C0775(30, 20, 550, -1));
   }
}
