package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Player;

public class C0893 extends JPanel {
   private C0914 Ub = C0732.da().wL();
   private boolean Uc = C0732.da().wK();
   private boolean Ud = true;
   private ArrayList Ue = new ArrayList();
   private static final String Uf = "Nome inválido";
   private static final String Ug = "Nome muito curto";
   private static final String Uh = "Nome muito longo";
   private static final String Ui = "Limite de jogadores alcançado";
   private static final String Uj = "Reputação não permite Top Mundial neste time";
   private static int Uk = 0;
   private JButton uC;
   private JButton Fu;
   private JCheckBox Qs;
   private JCheckBox Ul = new JCheckBox();
   private JComboBox Qv;
   private JComboBox Qw;
   private JComboBox ue;
   private JComboBox Nq;
   private JTextField uf;
   private JComboBox Qx;
   private JLabel ug = new JLabel();
   private JLabel Um;
   private JLabel Un;
   private JLabel Uo;
   private JLabel Up;
   private JLabel Uq;
   private JLabel uF;
   private JLabel MQ;
   private JLabel Ur;
   private JSlider Us;
   private JPanel vd;
   private JCheckBox Qt;

   public C0893() {
      if (C0732.da().wM()) {
         this.ug.setText("Adicionar Jogador");
         this.Ud = true;
      } else {
         this.ug.setText("Editar Jogador");
         this.Ud = false;
         this.Ul.setVisible(false);
      }

      this.mJ();
      this.mY();
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.uf);
      this.a(this.Nq);
      this.a(this.Qx);
      this.a(this.ue);
      this.a(this.Qv);
      this.a(this.Qw);
      this.a(this.Us);
      this.a(this.Qs);
      this.a(this.Qt);
      this.a(this.Ul);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0894(this));
      jComponent.getActionMap().put("esc", new C0895(this));
   }

   private void mJ() {
      this.vd = new JPanel();
      this.uF = new JLabel();
      this.uf = new JTextField();
      this.Ur = new JLabel();
      this.ue = new JComboBox();
      this.Uq = new JLabel();
      this.Qx = new JComboBox();
      this.MQ = new JLabel();
      this.Nq = new JComboBox();
      this.Um = new JLabel();
      this.Qv = new JComboBox();
      this.Un = new JLabel();
      this.Qw = new JComboBox();
      this.Uo = new JLabel();
      this.Us = new JSlider();
      this.Up = new JLabel();
      this.Fu = new JButton();
      this.uC = new JButton();
      this.Qs = new JCheckBox();
      this.Qt = new JCheckBox();
      this.Qt.setBackground(new Color(51, 153, 0));
      this.Qt.setForeground(new Color(255, 255, 255));
      this.Qt.setText("Top Mundial");
      this.setBackground(new Color(51, 102, 0));
      this.vd.setBackground(new Color(51, 153, 0));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(4);
      this.uF.setText("Nome:");
      this.Ur.setForeground(new Color(255, 255, 255));
      this.Ur.setHorizontalAlignment(4);
      this.Ur.setText("Posição:");
      this.Uq.setForeground(new Color(255, 255, 255));
      this.Uq.setHorizontalAlignment(4);
      this.Uq.setText("Lado:");
      this.MQ.setForeground(new Color(255, 255, 255));
      this.MQ.setHorizontalAlignment(4);
      this.MQ.setText("Pais:");
      this.Um.setForeground(new Color(255, 255, 255));
      this.Um.setHorizontalAlignment(4);
      this.Um.setText("Caract:");
      this.Un.setForeground(new Color(255, 255, 255));
      this.Un.setHorizontalAlignment(4);
      this.Un.setText("Caract:");
      this.Uo.setForeground(new Color(255, 255, 255));
      this.Uo.setHorizontalAlignment(4);
      this.Uo.setText("Idade:");
      this.Up.setForeground(new Color(255, 255, 255));
      this.Up.setHorizontalAlignment(2);
      this.Up.setText("25");
      this.Fu.setText("OK");
      this.uC.setText("Cancelar");
      this.Qs.setBackground(new Color(51, 153, 0));
      this.Qs.setForeground(new Color(255, 255, 255));
      this.Qs.setText("Estrela");
      this.Ul.setBackground(new Color(51, 153, 0));
      this.Ul.setForeground(new Color(255, 255, 153));
      this.Ul.setText("Continuar adicionando");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(119, 119, 119)
                              .addGroup(var1.createParallelGroup(Alignment.TRAILING).addComponent(this.Qs, -2, 91, -2).addComponent(this.Fu, -2, 92, -2))
                              .addGap(18, 18, 18)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.uC, -2, 91, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.Ul)
                                    )
                                    .addComponent(this.Qt, -2, 121, -2)
                              )
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.ug, -2, 448, -2)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.Uo, -2, 100, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.Us, -2, -1, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.Up, -2, 41, -2)
                                    )
                              )
                        )
                  )
                  .addContainerGap(-1, 32767)
            )
            .addGroup(
               var1.createParallelGroup(Alignment.LEADING)
                  .addGroup(
                     var1.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                           var1.createParallelGroup(Alignment.LEADING)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING, false)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.Ur, -2, 100, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.Nq, -2, 98, -2)
                                          .addGap(23, 23, 23)
                                          .addComponent(this.Uq, -2, 71, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.Qx, 0, -1, 32767)
                                    )
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.MQ, -2, 100, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.ue, -2, 123, -2)
                                    )
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.uF, -2, 100, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.uf, -2, 302, -2)
                                    )
                              )
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(this.Um, -2, 87, -2)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(this.Qv, -2, 96, -2)
                                    .addGap(18, 18, 18)
                                    .addComponent(this.Un, -2, 71, -2)
                                    .addGap(18, 18, 18)
                                    .addComponent(this.Qw, -2, 96, -2)
                              )
                        )
                        .addContainerGap(46, 32767)
                  )
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED, 152, 32767)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.Uo, Alignment.TRAILING)
                        .addComponent(this.Us, Alignment.TRAILING, -2, -1, -2)
                        .addComponent(this.Up, Alignment.TRAILING)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Qs).addComponent(this.Qt))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Fu).addComponent(this.uC).addComponent(this.Ul))
                  .addGap(26, 26, 26)
            )
            .addGroup(
               var1.createParallelGroup(Alignment.LEADING)
                  .addGroup(
                     var1.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uf, -2, -1, -2).addComponent(this.uF))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(
                           var1.createParallelGroup(Alignment.BASELINE)
                              .addComponent(this.Ur)
                              .addComponent(this.Uq)
                              .addComponent(this.Qx, -2, -1, -2)
                              .addComponent(this.Nq, -2, -1, -2)
                        )
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ue, -2, -1, -2).addComponent(this.MQ))
                        .addGap(18, 18, 18)
                        .addGroup(
                           var1.createParallelGroup(Alignment.BASELINE)
                              .addComponent(this.Um)
                              .addComponent(this.Qv, -2, -1, -2)
                              .addComponent(this.Un)
                              .addComponent(this.Qw, -2, -1, -2)
                        )
                        .addContainerGap(144, 32767)
                  )
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, -1, -2).addContainerGap(12, 32767))
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
      );
      this.mK();
      this.mH();
   }

   public void mK() {
      if (this.Ud) {
         this.Ul.setSelected(C0732.da().wR());
         this.Ul.addItemListener(new C0896(this));
      }

      this.Qv.setMaximumRowCount(10);
      this.Qw.setMaximumRowCount(10);

      for (int var1 = 0; var1 < C0696.jz(); var1++) {
         this.ue.addItem(((CountryInfo)C0732.cY().get(var1)).getNome());
      }

      C0858 var3 = new C0858();
      var3.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var3);
      this.ue.setMaximumRowCount(10);
      if (!this.Ud) {
         this.ue.setSelectedIndex(C0732.G(this.Ub.getPais()));
      } else {
         this.ue.setSelectedIndex(C0732.G(C0732.da().wI().getPais()));
      }

      for (int var2 = 0; var2 < GameConstants.rH.length; var2++) {
         this.Nq.addItem(GameConstants.rH[var2]);
      }

      if (!this.Ud) {
         this.Nq.setSelectedIndex(this.Ub.getPosicao());
      } else {
         this.Nq.setSelectedIndex(Uk);
      }

      this.Nq.addActionListener(new C0897(this));

      for (int var4 = 0; var4 < GameConstants.rK.length; var4++) {
         this.Qx.addItem(GameConstants.rK[var4]);
      }

      if (!this.Ud) {
         this.Qx.setSelectedIndex(this.Ub.getLado());
      }

      if (this.Nq.getSelectedIndex() == 0) {
         for (int var5 = 0; var5 <= 3; var5++) {
            this.Qv.addItem(GameConstants.qM[var5]);
            this.Qw.addItem(GameConstants.qM[var5]);
         }

         if (!this.Ud) {
            this.Qv.setSelectedIndex(this.Ub.getCr1());
            this.Qw.setSelectedIndex(this.Ub.getCr2());
         }
      } else {
         for (int var6 = 4; var6 < GameConstants.qM.length; var6++) {
            this.Qv.addItem(GameConstants.qM[var6]);
            this.Qw.addItem(GameConstants.qM[var6]);
         }

         if (!this.Ud) {
            this.Qv.setSelectedIndex(this.Ub.getCr1() - 4);
            this.Qw.setSelectedIndex(this.Ub.getCr2() - 4);
         }
      }

      if (this.Ud) {
         int[] var7 = Player.at(this.Nq.getSelectedIndex());
         if (this.Nq.getSelectedIndex() == 0) {
            this.Qv.setSelectedIndex(var7[0]);
            this.Qw.setSelectedIndex(var7[1]);
         } else {
            this.Qv.setSelectedIndex(var7[0] - 4);
            this.Qw.setSelectedIndex(var7[1] - 4);
         }
      }

      if (!this.Ud) {
         this.Us.setValue(this.Ub.getIdade());
      } else {
         this.Us.setValue(20);
      }

      if (this.Uc) {
         this.Us.setMinimum(16);
         this.Us.setMaximum(48);
      } else {
         this.Us.setMinimum(16);
         this.Us.setMaximum(20);
      }

      this.Us.addChangeListener(new C0898(this));
      this.Up.setText(Integer.toString(this.Us.getValue()));
      if (!this.Ud) {
         this.uf.setText(this.Ub.getNome());
      } else {
         this.uf.setText("");
      }

      if (!this.Ud) {
         this.Qs.setSelected(this.Ub.isEstrela());
      } else {
         this.Qs.setSelected(false);
      }

      if (!this.Ud) {
         this.Qt.setSelected(this.Ub.isTopMundial());
      } else {
         this.Qt.setSelected(false);
      }
   }

   public void wk() {
      boolean var1 = false;
      if (this.uf.getText().toString().equals("")) {
         this.Ue.add("Nome inválido");
      } else if (this.uf.getText().toString().length() < 2) {
         this.Ue.add("Nome muito curto");
      } else if (this.uf.getText().toString().length() > 30) {
         this.Ue.add("Nome muito longo");
      } else if (!this.uf.getText().toString().equals(this.Ub.getNome())) {
         var1 = true;
         this.Ub.setNome(this.uf.getText().toString());
      }

      if (this.Nq.getSelectedIndex() != this.Ub.getPosicao()) {
         this.Ub.setPosicao(this.Nq.getSelectedIndex());
         var1 = true;
      }

      byte var2 = 0;
      if (this.Nq.getSelectedIndex() != 0) {
         var2 = 4;
      }

      if (this.Qv.getSelectedIndex() + var2 != this.Ub.getCr1()) {
         this.Ub.setCr1(this.Qv.getSelectedIndex() + var2);
         var1 = true;
      }

      if (this.Qw.getSelectedIndex() + var2 != this.Ub.getCr2()) {
         this.Ub.setCr2(this.Qw.getSelectedIndex() + var2);
         var1 = true;
      }

      if (this.Us.getValue() != this.Ub.getIdade()) {
         this.Ub.setIdade(this.Us.getValue());
         var1 = true;
      }

      if (this.Qs.isSelected() != this.Ub.isEstrela()) {
         this.Ub.setEstrela(this.Qs.isSelected());
         var1 = true;
      }

      if (this.Qt.isSelected() != this.Ub.isTopMundial()) {
         if (this.Qt.isSelected() && C0732.da().wI().getReputacao() < 4) {
            this.Ue.add("Reputação não permite Top Mundial neste time");
         } else {
            this.Ub.setTopMundial(this.Qt.isSelected());
            var1 = true;
         }
      }

      if (this.ue.getSelectedIndex() != C0732.G(this.Ub.getPais())) {
         this.Ub.setPais(C0732.H(this.ue.getSelectedIndex()));
         var1 = true;
      }

      if (this.Qx.getSelectedIndex() != this.Ub.getLado()) {
         this.Ub.setLado(this.Qx.getSelectedIndex());
         var1 = true;
      }

      if (var1) {
         C0732.da().wo();
      }
   }

   private void wl() {
      this.Ue.clear();
      if (!this.Ud) {
         this.wk();
      } else {
         this.wn();
      }

      if (this.Ue.size() == 0) {
         if (!this.Ud) {
            C0732.da().Uw.dispose();
         } else if (this.Ul.isSelected()) {
            if (this.Uc) {
               C0732.da().Uw.dispose();
               if (C0732.da().wI().getJogadores().size() < 30) {
                  C0732.da().wp();
               }
            } else {
               C0732.da().Uw.dispose();
               if (C0732.da().wI().getJuniores().size() < 15) {
                  C0732.da().wp();
               }
            }
         } else {
            C0732.da().Uw.dispose();
         }
      } else {
         JOptionPane.showMessageDialog(null, this.Ue.get(0), "", 0);
      }
   }

   public void mH() {
      this.Fu.addActionListener(new C0899(this));
      this.uC.addActionListener(new C0900(this));
   }

   private void wm() {
      C0732.da().Uw.dispose();
   }

   public void wn() {
      boolean var1 = true;
      if (this.uf.getText().toString().equals("")) {
         var1 = false;
         this.Ue.add("Nome inválido");
      } else if (this.uf.getText().toString().length() < 2) {
         var1 = false;
         this.Ue.add("Nome muito curto");
      } else if (this.uf.getText().toString().length() > 30) {
         var1 = false;
         this.Ue.add("Nome muito longo");
      } else if (this.Qt.isSelected() && C0732.da().wI().getReputacao() < 4) {
         this.Ue.add("Reputação não permite Top Mundial neste time");
         var1 = false;
      }

      if (var1) {
         C0914 var2 = new C0914();
         var2.setNome(this.uf.getText().toString());
         var2.setIdade(this.Us.getValue());
         var2.setEstrela(this.Qs.isSelected());
         var2.setPais(C0732.H(this.ue.getSelectedIndex()));
         var2.setPosicao(this.Nq.getSelectedIndex());
         var2.setStatus(0);
         if (var2.getPosicao() == 0) {
            var2.setCr1(this.Qv.getSelectedIndex());
            var2.setCr2(this.Qw.getSelectedIndex());
         } else {
            var2.setCr1(this.Qv.getSelectedIndex() + 4);
            var2.setCr2(this.Qw.getSelectedIndex() + 4);
         }

         var2.setLado(this.Qx.getSelectedIndex());
         var2.setHash(new Random().nextInt(10) + 1);
         if (this.Uc) {
            if (C0732.da().wI().getJogadores().size() < 30) {
               C0732.da().wI().getJogadores().add(var2);
               ((C0878)C0732.da().wJ().getModel()).i(3, true);
               C0732.da().wG();
            } else {
               this.Ue.add("Limite de jogadores alcançado");
            }
         } else if (C0732.da().wI().getJuniores().size() < 15) {
            C0732.da().wI().getJuniores().add(var2);
            ((C0878)C0732.da().wJ().getModel()).i(3, true);
            C0732.da().wG();
         } else {
            this.Ue.add("Limite de jogadores alcançado");
         }

         C0732.da().wo();
      }
   }
}
