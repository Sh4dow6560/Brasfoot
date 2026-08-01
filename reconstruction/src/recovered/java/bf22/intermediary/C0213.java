package bf22.intermediary;

import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0213 extends JPanel {
   private JFrame Br;
   private JButton ud;
   private JButton vb;
   private JLabel ug;
   private JLabel Bj;
   private JLabel vw;
   private JLabel zb;
   private JLabel zc;
   private JLabel zd;
   private JLabel ze;
   private JLabel Ef;
   private JLabel Eg;
   private JLabel Eh;
   private JLabel Ei;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;
   private JLabel vz;
   private JLabel vA;
   private JPanel vd;
   private JPanel we;
   private JSeparator BE;
   private JTextField Ej;
   private JTextField Ek;

   public C0213(JFrame jFrame) {
      this.mJ();
      this.mH();
   }

   private void pr() {
      try {
         Desktop.getDesktop().browse(new URI("http://www.brasfoot.com"));
      } catch (URISyntaxException | IOException var2) {
      }
   }

   private void pb() {
      C0388 var1 = new C0388();
      var1.pack();
      var1.setSize(529, 321);
      var1.setLocationRelativeTo(null);
      var1.setVisible(true);
      MainWindow.db().setVisible(false);
   }

   private boolean ps() {
      if (this.Ej.getText().isEmpty()) {
         return false;
      }

      if (this.Ek.getText().isEmpty()) {
         return false;
      }

      if (this.Ej.getText().toString().length() < 3) {
         return false;
      }

      C0698.t(null);
      C0698.u("");
      C0734.n(false);
      if (!this.Ej.getText().isEmpty() && this.Ej.getText().toString().length() > 1 && this.Ej.getText().toString().length() < 100) {
         C0698.t(this.Ej.getText().toString());
      }

      String var1 = this.Ek.getText();
      var1.trim();
      var1 = var1.replaceAll("\\s+", "");
      String var2 = "";

      for (int var3 = 0; var3 < var1.length(); var3++) {
         if (var3 < 8) {
            var2 = var2 + var1.charAt(var3);
         }
      }

      if (!var2.isEmpty() && var2.length() > 1 && var2.length() >= 7 && this.B(var2)) {
         C0698.u(var2);
      }

      C0677.in();
      if (C0734.dt()) {
         C0217.pu();
         C0217.pv();
         this.pb();
      }

      return false;
   }

   public boolean B(String string) {
      try {
         Integer.parseInt(string);
         return true;
      } catch (NumberFormatException var3) {
         return false;
      } catch (NullPointerException var4) {
         return false;
      }
   }

   public void mH() {
      this.Ef.addMouseListener(new C0214(this));
      this.ud.addActionListener(new C0215(this));
      this.vb.addActionListener(new C0216(this));
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.BE = new JSeparator();
      this.uh = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.vx = new JLabel();
      this.vy = new JLabel();
      this.vz = new JLabel();
      this.vA = new JLabel();
      this.Bj = new JLabel();
      this.vw = new JLabel();
      this.zb = new JLabel();
      this.zc = new JLabel();
      this.zd = new JLabel();
      this.ze = new JLabel();
      this.Ef = new JLabel();
      this.Eg = new JLabel();
      this.we = new JPanel();
      this.a_ = new JLabel();
      this.Ei = new JLabel();
      this.Ej = new JTextField();
      this.Ek = new JTextField();
      this.vb = new JButton();
      this.Eh = new JLabel();
      this.ud = new JButton();
      this.setBackground(new Color(84, 127, 59));
      this.vd.setBackground(new Color(42, 64, 29));
      this.ug.setFont(new Font("Tahoma", 1, 18));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText(C0679.getString("fix_title"));
      this.uh.setFont(new Font("Tahoma", 0, 12));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText(C0679.getString("fix_l1"));
      this.ur.setFont(new Font("Tahoma", 0, 12));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setText("<html>" + C0679.getString("fix_l2") + "</html>");
      this.us.setFont(new Font("Tahoma", 0, 12));
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setText("Registrando seu Brasfoot você ganhará as opções extras:");
      this.vx.setFont(new Font("Tahoma", 0, 12));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setText(" - Acesso à área de sócios do site (com novas ligas, camisas, escudos, fórum de debates e muito mais!) ");
      this.vy.setFont(new Font("Tahoma", 0, 12));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setText("- Poderá jogar com mais de um técnico humano");
      this.vz.setFont(new Font("Tahoma", 0, 12));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setText("- Poderá escolher um time de qualquer divisão para iniciar o jogo");
      this.vA.setFont(new Font("Tahoma", 0, 12));
      this.vA.setForeground(new Color(255, 255, 255));
      this.vA.setText("- Jogar regionais e estaduais; inclusive escolher o sistema de disputa dos estaduais");
      this.Bj.setFont(new Font("Tahoma", 0, 12));
      this.Bj.setForeground(new Color(255, 255, 255));
      this.Bj.setText("- Jogar campeonatos de seleções: Copa do Mundo, Eurocopa, Copa América etc");
      this.vw.setFont(new Font("Tahoma", 0, 12));
      this.vw.setForeground(new Color(255, 255, 255));
      this.vw.setText("- Jogar a Copa Sul-Americana (ou Liga UEFA)");
      this.zb.setFont(new Font("Tahoma", 0, 12));
      this.zb.setForeground(new Color(255, 255, 255));
      this.zb.setText("- Escolher o sistema de disputa do campeonato nacional");
      this.zc.setFont(new Font("Tahoma", 0, 12));
      this.zc.setForeground(new Color(255, 255, 255));
      this.zc.setText("- Fazer proposta de compra para qualquer jogador, mesmo se ele não estiver a venda");
      this.zd.setFont(new Font("Tahoma", 0, 12));
      this.zd.setForeground(new Color(255, 255, 255));
      this.zd.setText("- Velocidades de jogo Hiper-rápido para jogos humanos e Ultrasonico para jogos não humanos");
      this.ze.setFont(new Font("Tahoma", 0, 12));
      this.ze.setForeground(new Color(255, 255, 255));
      this.ze.setText("Para fazer o registro acesse o site do jogo:");
      this.Ef.setFont(new Font("Tahoma", 1, 12));
      this.Ef.setForeground(new Color(255, 255, 102));
      this.Ef.setText("www.brasfoot.com");
      this.Eg.setFont(new Font("Tahoma", 0, 12));
      this.Eg.setForeground(new Color(255, 255, 255));
      this.Eg
         .setText(
            "<html>O registro pode ser feito por depósito bancário, boleto bancário ou cartão de crédito em transferências seguras. Após o registro você receberá por email o nome e código para ser digitado abaixo. </html>"
         );
      this.we.setBackground(new Color(0, 0, 0));
      this.we.setBorder(BorderFactory.createLineBorder(new Color(42, 50, 15)));
      this.we.setOpaque(false);
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setText(C0679.getString("fix_nom"));
      this.Ei.setForeground(new Color(255, 255, 255));
      this.Ei.setText(C0679.getString("fix_nom2"));
      this.vb.setFont(new Font("Tahoma", 0, 12));
      this.vb.setText(C0679.getString("fix_nom3"));
      GroupLayout var1 = new GroupLayout(this.we);
      this.we.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(111, 111, 111)
                  .addGroup(var1.createParallelGroup(Alignment.TRAILING).addComponent(this.Ei).addComponent(this.a_))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.LEADING, false).addComponent(this.Ej).addComponent(this.Ek, -1, 341, 32767))
                  .addGap(28, 28, 28)
                  .addComponent(this.vb, -2, 133, -2)
                  .addContainerGap(139, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(19, 19, 19)
                              .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.a_).addComponent(this.Ej, -2, -1, -2))
                              .addGap(18, 18, 18)
                              .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Ek, -2, -1, -2).addComponent(this.Ei))
                        )
                        .addGroup(var1.createSequentialGroup().addGap(29, 29, 29).addComponent(this.vb, -2, 35, -2))
                  )
                  .addContainerGap(31, 32767)
            )
      );
      this.Eh.setFont(new Font("Tahoma", 1, 12));
      this.Eh.setForeground(new Color(255, 255, 153));
      this.Eh.setText("Após o registro será enviado o seu código pessoal, você deve digitá-lo abaixo:");
      this.ud.setText("X");
      GroupLayout var2 = new GroupLayout(this.vd);
      this.vd.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(var2.createSequentialGroup().addComponent(this.Eh, -1, -1, 32767).addContainerGap(-1, 32767))
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.ur, -2, 693, -2)
                                    .addComponent(this.us, -2, 619, -2)
                                    .addComponent(this.vx, -2, 619, -2)
                                    .addComponent(this.vy, -2, 619, -2)
                                    .addComponent(this.vz, -2, 619, -2)
                                    .addComponent(this.vA, -2, 619, -2)
                                    .addComponent(this.Bj, -2, 619, -2)
                                    .addComponent(this.vw, -2, 619, -2)
                                    .addComponent(this.zb, -2, 619, -2)
                                    .addComponent(this.zc, -2, 619, -2)
                                    .addComponent(this.zd, -2, 619, -2)
                                    .addComponent(this.uh, -2, 619, -2)
                                    .addComponent(this.we, -2, -1, -2)
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addComponent(this.ze, -2, 253, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.Ef, -2, 250, -2)
                                    )
                                    .addComponent(this.Eg, -2, 709, -2)
                              )
                              .addContainerGap(44, 32767)
                        )
                  )
            )
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap(-1, 32767)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addComponent(this.ug, -2, 616, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.ud, -2, 47, -2)
                              .addGap(68, 68, 68)
                        )
                        .addGroup(Alignment.TRAILING, var2.createSequentialGroup().addComponent(this.BE, -2, 209, -2).addGap(332, 332, 332))
                  )
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.ug, -2, 29, -2).addComponent(this.ud))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.BE, -2, 10, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uh)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ur, -2, 85, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.us)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vx)
                  .addGap(4, 4, 4)
                  .addComponent(this.vy)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vz)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vA)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Bj)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vw)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.zb)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.zc)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.zd)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.ze).addComponent(this.Ef))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Eg, -2, 59, -2)
                  .addGap(13, 13, 13)
                  .addComponent(this.Eh)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.we, -2, -1, -2)
                  .addContainerGap(18, 32767)
            )
      );
      GroupLayout var3 = new GroupLayout(this);
      this.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(var3.createSequentialGroup().addGap(28, 28, 28).addComponent(this.vd, -2, -1, -2).addContainerGap(20, 32767))
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(var3.createSequentialGroup().addGap(27, 27, 27).addComponent(this.vd, -2, -1, -2).addContainerGap(24, 32767))
      );
   }
}
