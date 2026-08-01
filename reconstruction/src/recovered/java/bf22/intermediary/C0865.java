package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0865 extends JPanel {
   private C0915 Vn = C0732.da().wI();
   private boolean Ud = true;
   private ArrayList Ue = new ArrayList();
   private static final String Uf = "Nome do time inválido";
   private static final String Vo = "Nome do tecnico inválido";
   private static final String Vp = "Nome do estádio inválido";
   private static final String Vq = "Nome do arquivo inválido";
   private static final String Vr = "O estádio deve ter entre mil e 120 mil lugares";
   private static final String Vs = "Arquivo já existe, escolha outro nome";
   private JButton uC;
   private JButton Fu;
   private JComboBox Vt;
   private JComboBox Vu;
   private JComboBox Vv;
   private JComboBox ue;
   private JComboBox Vw = new JComboBox();
   private JTextField Vx;
   private JTextField uf;
   private JTextField IA = new JTextField();
   private JTextField Vy;
   private JTextField Vz;
   private JLabel VA = new JLabel();
   private JPanel VB;
   private JLabel VC;
   private JLabel zv;
   private JLabel VD;
   private JLabel zw;
   private JLabel VE;
   private JLabel Cg;
   private JLabel VF;
   private JLabel MM;
   private JLabel Vb;
   private JLabel uF;
   private JLabel MQ;
   private JLabel MR;
   private JLabel Fs;
   private JLabel QU = new JLabel();

   public C0865() {
      if (C0732.da().wN()) {
         this.QU.setText("Adicionar Time");
         this.Ud = true;
         this.IA.setEnabled(true);
      } else {
         this.QU.setText("Editar Time");
         this.Ud = false;
         this.IA.setEnabled(false);
      }

      this.mJ();
   }

   private void mJ() {
      this.VB = new JPanel();
      this.uF = new JLabel();
      this.uf = new JTextField();
      this.Fs = new JLabel();
      this.Vy = new JTextField();
      this.Cg = new JLabel();
      this.Vx = new JTextField();
      this.VF = new JLabel();
      this.Vb = new JLabel();
      this.Vu = new JComboBox();
      this.MR = new JLabel();
      this.Vv = new JComboBox();
      this.VC = new JLabel();
      this.MQ = new JLabel();
      this.ue = new JComboBox();
      this.MM = new JLabel();
      this.Vt = new JComboBox();
      this.zv = new JLabel();
      this.VE = new JLabel();
      this.zw = new JLabel();
      this.VD = new JLabel();
      this.IA = new JTextField();
      this.VA = new JLabel();
      this.Fu = new JButton();
      this.uC = new JButton();
      this.Vz = new JTextField();
      this.setBackground(new Color(51, 71, 21));
      this.setPreferredSize(new Dimension(455, 435));
      this.VB.setBackground(new Color(51, 102, 0));
      this.QU.setFont(new Font("Tahoma", 1, 14));
      this.QU.setForeground(new Color(255, 255, 255));
      this.QU.setHorizontalAlignment(0);
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(4);
      this.uF.setText("Nome:");
      this.Fs.setForeground(new Color(255, 255, 255));
      this.Fs.setHorizontalAlignment(4);
      this.Fs.setText("Nome do Técnico:");
      this.Cg.setForeground(new Color(255, 255, 255));
      this.Cg.setHorizontalAlignment(4);
      this.Cg.setText("Nome do Estádio:");
      this.VF.setForeground(new Color(255, 255, 255));
      this.VF.setHorizontalAlignment(4);
      this.VF.setText("Capacidade:");
      this.Vb.setForeground(new Color(255, 255, 255));
      this.Vb.setHorizontalAlignment(4);
      this.Vb.setText("Nível inicial:");
      this.MR.setForeground(new Color(255, 255, 255));
      this.MR.setHorizontalAlignment(4);
      this.MR.setText("Reputação:");
      this.VC.setForeground(new Color(255, 255, 255));
      this.VC.setHorizontalAlignment(2);
      this.VC.setText("lugares");
      this.MQ.setForeground(new Color(255, 255, 255));
      this.MQ.setHorizontalAlignment(4);
      this.MQ.setText("Pais do time:");
      this.MM.setForeground(new Color(255, 255, 255));
      this.MM.setHorizontalAlignment(4);
      this.MM.setText("Estado:");
      this.zv.setForeground(new Color(255, 255, 255));
      this.zv.setHorizontalAlignment(4);
      this.zv.setText("Cor de Texto:");
      this.VE.setBackground(new Color(0, 102, 102));
      this.VE.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.VE.setOpaque(true);
      this.zw.setForeground(new Color(255, 255, 255));
      this.zw.setHorizontalAlignment(4);
      this.zw.setText("Cor de Fundo:");
      this.VD.setBackground(new Color(0, 102, 102));
      this.VD.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.VD.setOpaque(true);
      this.VA.setForeground(new Color(255, 255, 255));
      this.VA.setHorizontalAlignment(4);
      this.VA.setText("Nome do Arquivo:");
      this.Fu.setText("OK");
      this.uC.setText("Cancelar");
      this.Vw.setMaximumRowCount(15);
      this.Vw.setMinimumSize(new Dimension(28, 25));
      this.Vw.setPreferredSize(new Dimension(28, 25));
      GroupLayout var1 = new GroupLayout(this.VB);
      this.VB.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.QU, -1, -1, 32767)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(this.zv, -2, 84, -2)
                                    .addGroup(
                                       var1.createParallelGroup(Alignment.TRAILING, false)
                                          .addComponent(this.uF, -1, -1, 32767)
                                          .addComponent(this.VF, -2, 84, -2)
                                          .addComponent(this.Cg, -1, -1, 32767)
                                          .addComponent(this.Vb, -2, 84, -2)
                                          .addComponent(this.MQ, -2, 84, -2)
                                          .addComponent(this.Fs, -1, -1, 32767)
                                          .addComponent(this.VA, -1, 100, 32767)
                                    )
                              )
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addGroup(
                                                   var1.createSequentialGroup()
                                                      .addComponent(this.ue, -2, 153, -2)
                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                      .addComponent(this.MM, -2, 60, -2)
                                                )
                                                .addGroup(
                                                   var1.createParallelGroup(Alignment.TRAILING)
                                                      .addGroup(
                                                         Alignment.LEADING,
                                                         var1.createSequentialGroup()
                                                            .addComponent(this.Vz, -2, 150, -2)
                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                            .addComponent(this.VC, -2, 84, -2)
                                                      )
                                                      .addComponent(this.Vx, -2, 323, -2)
                                                )
                                                .addGroup(
                                                   var1.createSequentialGroup()
                                                      .addComponent(this.VE, -2, 43, -2)
                                                      .addGap(26, 26, 26)
                                                      .addComponent(this.zw, -2, 84, -2)
                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                      .addComponent(this.VD, -2, 42, -2)
                                                )
                                                .addComponent(this.IA, -2, 323, -2)
                                                .addComponent(this.Vy, -2, 157, -2)
                                          )
                                          .addGap(0, 0, 32767)
                                    )
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.TRAILING)
                                                .addComponent(this.Vt, -2, 96, -2)
                                                .addGroup(
                                                   var1.createParallelGroup(Alignment.LEADING)
                                                      .addComponent(this.uf, -2, 323, -2)
                                                      .addGroup(
                                                         var1.createSequentialGroup()
                                                            .addComponent(this.Vu, -2, 67, -2)
                                                            .addPreferredGap(ComponentPlacement.RELATED)
                                                            .addComponent(this.MR, -2, 84, -2)
                                                            .addPreferredGap(ComponentPlacement.RELATED)
                                                            .addComponent(this.Vv, -2, 150, -2)
                                                      )
                                                )
                                                .addComponent(this.Vw, -2, 153, -2)
                                          )
                                          .addContainerGap(41, 32767)
                                    )
                              )
                        )
                  )
            )
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap(-1, 32767)
                  .addComponent(this.Fu, -2, 92, -2)
                  .addGap(36, 36, 36)
                  .addComponent(this.uC, -2, 91, -2)
                  .addGap(114, 114, 114)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.QU)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uf, -2, -1, -2).addComponent(this.uF))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Vy, -2, -1, -2).addComponent(this.Fs).addComponent(this.Vw, -2, -1, -2)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Vx, -2, -1, -2).addComponent(this.Cg))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.VF).addComponent(this.Vz, -2, -1, -2).addComponent(this.VC))
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(this.Vu, -2, -1, -2)
                        .addComponent(this.Vb)
                        .addComponent(this.MR)
                        .addComponent(this.Vv, -2, -1, -2)
                  )
                  .addGap(14, 14, 14)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.MQ)
                        .addGroup(
                           var1.createParallelGroup(Alignment.BASELINE)
                              .addComponent(this.MM)
                              .addComponent(this.ue, -2, -1, -2)
                              .addComponent(this.Vt, -2, -1, -2)
                        )
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.zv)
                        .addComponent(this.zw)
                        .addComponent(this.VE, -1, 25, 32767)
                        .addComponent(this.VD, -1, -1, 32767)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.IA, -2, -1, -2).addComponent(this.VA))
                  .addGap(14, 14, 14)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uC).addComponent(this.Fu))
                  .addContainerGap(-1, 32767)
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.VB, -2, -1, -2).addContainerGap(-1, 32767))
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.VB, -2, -1, -2).addContainerGap(-1, 32767))
      );
      this.mH();
      this.mK();
   }

   public void mH() {
      this.Fu.addActionListener(new C0866(this));
      this.uC.addActionListener(new C0867(this));
   }

   public void mK() {
      if (!this.Ud) {
         this.uf.setText(this.Vn.getNome());
      } else {
         this.uf.setText("");
      }

      if (!this.Ud) {
         this.Vy.setText(this.Vn.getTecnico());
      } else {
         this.Vy.setText("");
      }

      if (!this.Ud) {
         this.Vx.setText(this.Vn.getEstadio());
      } else {
         this.Vx.setText("");
      }

      if (!this.Ud) {
         this.Vz.setText(Integer.toString(this.Vn.getCapacidade()));
      } else {
         this.Vz.setText("");
      }

      for (int var1 = 1; var1 <= 25; var1++) {
         this.Vu.addItem(var1);
      }

      if (!this.Ud) {
         if (this.Vn.getNivel() < 1) {
            this.Vn.setNivel(1);
         }

         if (this.Vn.getNivel() > 25) {
            this.Vn.setNivel(25);
         }

         this.Vu.setSelectedItem(this.Vn.getNivel());
      } else {
         this.Vu.setSelectedItem(15);
      }

      for (int var5 = 0; var5 < GameConstants.pZ.length; var5++) {
         this.Vv.addItem(GameConstants.pZ[var5]);
      }

      if (!this.Ud) {
         this.Vv.setSelectedIndex(this.Vn.getReputacao());
      } else {
         this.Vv.setSelectedIndex(3);
      }

      for (int var6 = 0; var6 < C0696.jz(); var6++) {
         this.Vw.addItem(((CountryInfo)C0732.cY().get(var6)).getNome());
      }

      C0858 var7 = new C0858();
      var7.setPreferredSize(new Dimension(10, 25));
      this.Vw.setRenderer(var7);
      this.Vw.setMaximumRowCount(10);

      for (int var2 = 0; var2 < C0696.jz(); var2++) {
         this.ue.addItem(((CountryInfo)C0732.cY().get(var2)).getNome());
      }

      if (!this.Ud) {
         this.Vw.setSelectedIndex(C0732.G(this.Vn.getTecNac()));
      } else {
         this.Vw.setSelectedIndex(C0732.G(29));
      }

      C0858 var8 = new C0858();
      var8.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var8);
      this.ue.setMaximumRowCount(10);
      if (!this.Ud) {
         this.ue.setSelectedIndex(C0732.G(this.Vn.getPais()));
      } else {
         this.ue.setSelectedIndex(C0732.G(29));
      }

      C0643 var3 = new C0643();
      var3.setPreferredSize(new Dimension(10, 20));
      this.Vt.setRenderer(var3);
      this.Vt.setMaximumRowCount(10);

      for (int var4 = 0; var4 < GameConstants.rX.length; var4++) {
         this.Vt.addItem(var4);
      }

      if (C0732.H(this.ue.getSelectedIndex()) == 29) {
         this.Vt.setVisible(true);
         this.MM.setVisible(true);
         if (!this.Ud) {
            this.Vt.setSelectedIndex(this.Vn.getEstado());
         } else {
            this.Vt.setSelectedIndex(18);
         }
      } else {
         this.Vt.setVisible(false);
         this.MM.setVisible(false);
      }

      this.ue.addActionListener(new C0868(this));
      if (!this.Ud) {
         this.IA.setDisabledTextColor(Color.green);
         this.IA.setText(this.Vn.getFileRef());
         this.IA.setEditable(false);
      } else {
         this.IA.setText("");
         this.IA.setEnabled(true);
         this.IA.setEditable(true);
      }

      this.VE.setCursor(new Cursor(12));
      this.VD.setCursor(new Cursor(12));
      if (!this.Ud) {
         this.VE.setBackground(this.Vn.getCorT());
         this.VD.setBackground(this.Vn.getCorF());
      } else {
         this.VE.setBackground(Color.BLACK);
         this.VD.setBackground(Color.WHITE);
      }

      this.VE.addMouseListener(new C0869(this));
      this.VD.addMouseListener(new C0870(this));
   }

   public void xc() {
      boolean var1 = false;
      if (this.uf.getText().toString().equals("") || this.uf.getText().toString().length() <= 2 || this.uf.getText().toString().length() >= 30) {
         this.Ue.add("Nome do time inválido");
      } else if (!this.uf.getText().toString().equals(this.Vn.getNome())) {
         var1 = true;
         this.Vn.setNome(this.uf.getText().toString());
      }

      if (this.Vy.getText().toString().equals("") || this.Vy.getText().toString().length() <= 2 || this.Vy.getText().toString().length() >= 50) {
         this.Ue.add("Nome do tecnico inválido");
      } else if (!this.Vy.getText().toString().equals(this.Vn.getTecnico())) {
         var1 = true;
         this.Vn.setTecnico(this.Vy.getText().toString());
      }

      if (this.Vx.getText().toString().equals("") || this.Vx.getText().toString().length() <= 2 || this.Vx.getText().toString().length() >= 50) {
         this.Ue.add("Nome do estádio inválido");
      } else if (!this.Vx.getText().toString().equals(this.Vn.getEstadio())) {
         var1 = true;
         this.Vn.setEstadio(this.Vx.getText().toString());
      }

      String var2 = this.Vz.getText().toString();
      if (!var2.equals("") && var2.matches("\\d+")) {
         int var3 = Integer.parseInt(var2);
         if (var3 >= 1000 && var3 <= 120000) {
            this.Vn.setCapacidade(var3);
            var1 = true;
         } else {
            this.Ue.add("O estádio deve ter entre mil e 120 mil lugares");
         }
      } else {
         this.Ue.add("O estádio deve ter entre mil e 120 mil lugares");
      }

      if ((Integer)this.Vu.getSelectedItem() != this.Vn.getNivel()) {
         this.Vn.setNivel((Integer)this.Vu.getSelectedItem());
         var1 = true;
      }

      if (this.Vv.getSelectedIndex() != this.Vn.getReputacao()) {
         this.Vn.setReputacao(this.Vv.getSelectedIndex());
         var1 = true;
      }

      if (this.ue.getSelectedIndex() != C0732.G(this.Vn.getPais())) {
         this.Vn.setPais(C0732.H(this.ue.getSelectedIndex()));
         C0732.a(this.Vn);
         var1 = true;
      }

      if (this.Vw.getSelectedIndex() != C0732.G(this.Vn.getTecNac())) {
         this.Vn.setTecNac(C0732.H(this.Vw.getSelectedIndex()));
         var1 = true;
      }

      if (C0732.H(this.ue.getSelectedIndex()) == 29 && this.Vt.getSelectedIndex() != this.Vn.getEstado()) {
         this.Vn.setEstado(this.Vt.getSelectedIndex());
         var1 = true;
      }

      if (this.VE.getBackground() != this.Vn.getCorT()) {
         this.Vn.setCorT(this.VE.getBackground());
         var1 = true;
      }

      if (this.VD.getBackground() != this.Vn.getCorF()) {
         this.Vn.setCorF(this.VD.getBackground());
         var1 = true;
      }

      if (var1) {
         C0732.da().wE();
      }
   }

   public void xd() {
      boolean var1 = true;
      if (this.uf.getText().toString().equals("") || this.uf.getText().toString().length() < 2 || this.uf.getText().toString().length() > 25) {
         var1 = false;
         this.Ue.add("Nome do time inválido");
      }

      if (this.Vy.getText().toString().equals("") || this.Vy.getText().toString().length() < 2 || this.Vy.getText().toString().length() > 30) {
         var1 = false;
         this.Ue.add("Nome do tecnico inválido");
      }

      if (this.Vx.getText().toString().equals("") || this.Vx.getText().toString().length() < 2 || this.Vx.getText().toString().length() > 30) {
         var1 = false;
         this.Ue.add("Nome do estádio inválido");
      }

      String var2 = this.Vz.getText().toString();
      int var3 = 1000;
      if (!var2.equals("") && var2.matches("\\d+")) {
         var3 = Integer.parseInt(var2);
         if (var3 < 1000 || var3 > 120000) {
            var1 = false;
            this.Ue.add("O estádio deve ter entre mil e 120 mil lugares");
         }
      } else {
         var1 = false;
         this.Ue.add("O estádio deve ter entre mil e 120 mil lugares");
      }

      String var4 = null;
      if (!this.IA.getText().toString().equals("") && this.IA.getText().toString().length() >= 2 && this.IA.getText().toString().length() <= 30) {
         var4 = this.IA.getText().toString();
      } else {
         this.Ue.add("Nome do arquivo inválido");
         var1 = false;
      }

      File var5 = new File(System.getProperty("user.dir") + "/teams/" + var4 + ".b18");
      if (var5.exists() && !var5.isDirectory()) {
         var1 = false;
         this.Ue.add("Arquivo já existe, escolha outro nome");
      }

      if (var1) {
         C0915 var6 = new C0915();
         var6.setNome(this.uf.getText().toString());
         var6.setTecnico(this.Vy.getText().toString());
         var6.setTecNac(C0732.H(this.Vw.getSelectedIndex()));
         var6.setEstadio(this.Vx.getText().toString());
         var6.setPais(C0732.H(this.ue.getSelectedIndex()));
         var6.setCapacidade(var3);
         var6.setNivel((Integer)this.Vu.getSelectedItem());
         var6.setReputacao(this.Vv.getSelectedIndex());
         var6.setId(0);
         if (var6.getPais() == 29) {
            var6.setEstado(this.Vt.getSelectedIndex());
         }

         var6.setCorF(this.VD.getBackground());
         var6.setCorT(this.VE.getBackground());
         var6.setFileRef(this.IA.getText());
         C0732.cZ().add(0, var6);
         C0732.a(var6);
         C0732.da().ah(var6.getNome());
      }
   }
}
