package bf22.intermediary;

import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import mod.recovered.model.Club;

public class C0512 extends JPanel {
   private Club ul = null;
   private Club zY = null;
   private ArrayList afC = new ArrayList();
   private ArrayList um = new ArrayList();
   private int nTimes = 8;
   private int[] afD = new int[]{8, 4, 6};
   private JButton yV;
   private JButton afE;
   private JButton uC;
   private JButton Bw;
   private JButton yZ;
   private JButton afF;
   private JCheckBox CS;
   private JComboBox afG;
   private JTextField Nr;
   private JTextField afH;
   private JLabel ug;
   private JLabel a_;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;
   private JLabel vz;
   private JScrollPane ut;
   private JScrollPane wi;
   private JLabel zh;
   private JLabel uu;
   private JPanel uv;
   private JTable vn;
   private JTree uw;

   public C0512(JFrame jFrame) {
      this.ul = (Club)GamePersistence.SR.aN().get(0);
      this.afC.add(this.ul);
      this.mJ();
      this.mW();
      this.Ay();
      this.mH();
      this.mM();
      this.zh.setText("");
      this.pO();
      this.AT();
   }

   private void Ay() {
      C0612 var1 = new C0612(this.afC);
      this.vn.setModel(var1);
      int[] var2 = new int[]{40, 300, 100};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vn.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vn.getColumnModel().getColumn(0).setMaxWidth(40);
      this.vn.getColumnModel().getColumn(1).setMaxWidth(300);
      this.vn.getColumnModel().getColumn(2).setMaxWidth(100);
      this.vn.setAutoResizeMode(3);
      this.vn.setRowHeight(20);
      this.vn.setShowGrid(false);
      this.vn.setDefaultRenderer(Club.class, new C0614(2));
      this.vn.setAutoCreateRowSorter(false);
      this.vn.setIntercellSpacing(new Dimension(0, 0));
      this.vn.setCellSelectionEnabled(false);
      this.vn.setSelectionMode(0);
      this.vn.setRowSelectionAllowed(true);
      this.vn.setSelectionBackground(Color.YELLOW);
      this.vn.setFillsViewportHeight(true);
      this.vn.setTableHeader(null);
   }

   public void mH() {
      this.CS.addActionListener(new C0513(this));
      this.Bw.addActionListener(new C0516(this));
      this.uC.addActionListener(new C0517(this));
      this.yZ.addActionListener(new C0518(this));
      this.yV.addActionListener(new C0519(this));
      this.afF.addActionListener(new C0520(this));
      this.afE.addActionListener(new C0521(this));
   }

   private void fz(int i) {
      int var2 = this.vn.getSelectedRow();
      if (var2 >= 0) {
         if (i == -1) {
            if (var2 - 1 >= 0) {
               Collections.swap(this.afC, var2, var2 - 1);
               this.vn.setRowSelectionInterval(var2 - 1, var2 - 1);
            }
         } else if (i == 0 && var2 + 1 < this.afC.size()) {
            Collections.swap(this.afC, var2, var2 + 1);
            this.vn.setRowSelectionInterval(var2 + 1, var2 + 1);
         }
      }

      this.pO();
      this.vn.addNotify();
   }

   private void nA() {
      if (this.zY != null && this.afC.size() < this.nTimes && !this.afC.contains(this.zY)) {
         this.afC.add(this.zY);
         this.vn.addNotify();
         this.pO();
      }
   }

   private void pO() {
      this.vz.setText("Participantes:" + this.afC.size() + "/" + this.nTimes);

      for (int var1 = 0; var1 < this.afC.size(); var1++) {
         if (var1 < this.nTimes) {
            if (this.nTimes != 4 && this.nTimes != 8) {
               ((Club)this.afC.get(var1)).fr(0);
            } else if (var1 < 4) {
               ((Club)this.afC.get(var1)).fr(0);
            } else {
               ((Club)this.afC.get(var1)).fr(1);
            }

            if (this.CS.isSelected()) {
               ((Club)this.afC.get(var1)).fr(2);
            }
         } else {
            ((Club)this.afC.get(var1)).fr(-1);
         }
      }

      this.vn.addNotify();
   }

   private void nB() {
      if (this.vn.getSelectedRow() >= 0 && this.vn.getSelectedRow() < this.afC.size() && this.afC.get(this.vn.getSelectedRow()) != this.ul) {
         this.afC.remove(this.afC.get(this.vn.getSelectedRow()));
         this.vn.addNotify();
         this.pO();
      }
   }

   private void mW() {
      this.afG.addItem("2 grupos de 4, semi e final");
      this.afG.addItem("1 grupo de 4, final");
      this.afG.addItem("1 grupo de 6");
      this.afG.setSelectedIndex(0);
      this.afG.addActionListener(new C0522(this));
   }

   private void AT() {
      this.nTimes = this.afD[this.afG.getSelectedIndex()];
      this.pO();
      this.zh.setText("");
      this.vn.addNotify();
   }

   private void pn() {
      if (this.afC.size() == this.afD[this.afG.getSelectedIndex()]) {
         this.AU();
      } else {
         this.zh.setText("Adicione pelo menos " + this.afD[this.afG.getSelectedIndex()] + " times");
      }
   }

   private void AU() {
      String var1 = "Torneio Amistoso";
      String var2 = "Juazeiro";
      if (!this.Nr.getText().toString().isEmpty() && this.Nr.getText().toString().length() < 50) {
         var1 = this.Nr.getText();
      }

      if (!this.afH.getText().toString().isEmpty() && this.afH.getText().toString().length() < 50) {
         var2 = this.afH.getText();
      }

      if (GamePersistence.SR.yn() != null) {
         GamePersistence.SR.yn().a(this.afC, this.afG.getSelectedIndex(), var1, var2, this.CS.isSelected());
      }

      this.Bw.setCursor(new Cursor(3));
      GamePersistence.SR.az();
      GamePersistence.SR.V();
   }

   private void AV() {
      this.Bw.setCursor(new Cursor(3));
      GamePersistence.SR.az();
      GamePersistence.SR.V();
   }

   private void mM() {
      this.uw.getSelectionModel().setSelectionMode(1);
      this.uw.addTreeSelectionListener(new C0523(this));

      for (int var1 = 0; var1 < GamePersistence.SR.P().size(); var1++) {
         if (!((Club)GamePersistence.SR.P().get(var1)).kn()) {
            this.um.add((Club)GamePersistence.SR.P().get(var1));
            Collections.sort(this.um, C1007.VS);
         }
      }

      DefaultMutableTreeNode var2 = new DefaultMutableTreeNode("Times");
      this.a(var2);
      this.uw.setModel(new DefaultTreeModel(var2));
   }

   private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
      DefaultMutableTreeNode var2 = null;
      DefaultMutableTreeNode var3 = null;
      MutableTreeNode var4 = null;

      for (int var5 = 0; var5 < GamePersistence.SR.N().size(); var5++) {
         var2 = new DefaultMutableTreeNode(((CountryCompetitions)GamePersistence.SR.N().get(var5)).jp());
         defaultMutableTreeNode.add(var2);

         for (int var6 = 0; var6 < ((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().size(); var6++) {
            if (((NationalLeague)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).yi().yK().size() > 0) {
               var3 = new DefaultMutableTreeNode(((NationalLeague)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).getNome());
               var2.add(var3);

               for (int var7 = 0; var7 < ((NationalLeague)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).yi().yK().size(); var7++) {
                  var4 = new DefaultMutableTreeNode(((NationalLeague)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).yi().yK().get(var7));
                  var3.add(var4);
               }
            }
         }

         if (((CountryCompetitions)GamePersistence.SR.N().get(var5)).ek().size() > 0) {
            var3 = new DefaultMutableTreeNode("Regionais");
            var2.add(var3);

            for (int var16 = 0; var16 < ((CountryCompetitions)GamePersistence.SR.N().get(var5)).ek().size(); var16++) {
               var4 = new DefaultMutableTreeNode(((CountryCompetitions)GamePersistence.SR.N().get(var5)).ek().get(var16));
               var3.add(var4);
            }
         }
      }

      if (this.um.size() > 0) {
         var2 = new DefaultMutableTreeNode("Internacionais");
         defaultMutableTreeNode.add(var2);

         for (int var15 = 0; var15 < this.um.size(); var15++) {
            var4 = new DefaultMutableTreeNode(this.um.get(var15));
            var2.add(var4);
         }
      }
   }

   private void mJ() {
      this.uu = new JLabel();
      this.uv = new JPanel();
      this.a_ = new JLabel();
      this.us = new JLabel();
      this.afG = new JComboBox();
      this.Bw = new JButton();
      this.ut = new JScrollPane();
      this.uw = new JTree();
      this.vx = new JLabel();
      this.Nr = new JTextField();
      this.vy = new JLabel();
      this.wi = new JScrollPane();
      this.vn = new JTable();
      this.yV = new JButton();
      this.yZ = new JButton();
      this.vz = new JLabel();
      this.zh = new JLabel();
      this.afH = new JTextField();
      this.afF = new JButton();
      this.CS = new JCheckBox();
      this.afE = new JButton();
      this.uC = new JButton();
      this.ug = new JLabel();
      this.setBackground(new Color(42, 64, 29));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.uu.setFont(new Font("Tahoma", 1, 12));
      this.uu.setForeground(new Color(255, 255, 102));
      this.uu.setText("Torneio Amistoso");
      this.uv.setBackground(new Color(84, 127, 59));
      this.a_.setFont(new Font("Tahoma", 0, 12));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Escolha os participantes:");
      this.us.setFont(new Font("Tahoma", 0, 12));
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setHorizontalAlignment(4);
      this.us.setText("Fórmula:");
      this.Bw.setFont(new Font("Tahoma", 0, 14));
      this.Bw.setText("Iniciar");
      DefaultMutableTreeNode var1 = new DefaultMutableTreeNode("Times");
      DefaultMutableTreeNode var2 = new DefaultMutableTreeNode("Brasil");
      DefaultMutableTreeNode var3 = new DefaultMutableTreeNode("1ª divisão");
      DefaultMutableTreeNode var4 = new DefaultMutableTreeNode("Cruzeiro");
      var3.add(var4);
      var4 = new DefaultMutableTreeNode("Atlético");
      var3.add(var4);
      var2.add(var3);
      var3 = new DefaultMutableTreeNode("2ª divisão");
      var4 = new DefaultMutableTreeNode("Barcelona");
      var3.add(var4);
      var4 = new DefaultMutableTreeNode("Real Madrid");
      var3.add(var4);
      var2.add(var3);
      var1.add(var2);
      var2 = new DefaultMutableTreeNode("Espanha");
      var3 = new DefaultMutableTreeNode("1ª Divisão");
      var4 = new DefaultMutableTreeNode("Sevilla");
      var3.add(var4);
      var4 = new DefaultMutableTreeNode("Gijon");
      var3.add(var4);
      var2.add(var3);
      var3 = new DefaultMutableTreeNode("2ª divisão");
      var4 = new DefaultMutableTreeNode("Sporting");
      var3.add(var4);
      var2.add(var3);
      var1.add(var2);
      var2 = new DefaultMutableTreeNode("Outros Times");
      var3 = new DefaultMutableTreeNode("Málaga");
      var2.add(var3);
      var3 = new DefaultMutableTreeNode("Alecrim");
      var2.add(var3);
      var1.add(var2);
      this.uw.setModel(new DefaultTreeModel(var1));
      this.ut.setViewportView(this.uw);
      this.vx.setFont(new Font("Tahoma", 0, 12));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(4);
      this.vx.setText("Nome do Torneio:");
      this.Nr.setText("Torneio Amistoso");
      this.Nr.addActionListener(new C0514(this));
      this.vy.setFont(new Font("Tahoma", 0, 12));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setHorizontalAlignment(4);
      this.vy.setText("Sede (escolha uma cidade):");
      this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.wi.setViewportView(this.vn);
      this.yV.setText(">>");
      this.yZ.setText("<<");
      this.vz.setFont(new Font("Tahoma", 0, 12));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(2);
      this.vz.setText("Participantes:");
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setHorizontalAlignment(0);
      this.zh.setText("\"\"");
      this.afH.setText("Juazeiro");
      this.afH.setToolTipText("");
      this.afH.addActionListener(new C0515(this));
      this.afF.setIcon(new ImageIcon(this.getClass().getResource("/aicons/uparray.png")));
      this.CS.setFont(new Font("Tahoma", 0, 12));
      this.CS.setForeground(new Color(255, 255, 255));
      this.CS.setText("Sortear grupos");
      this.CS.setOpaque(false);
      this.afE.setIcon(new ImageIcon(this.getClass().getResource("/aicons/downarray.png")));
      this.uC.setFont(new Font("Tahoma", 0, 14));
      this.uC.setText("Cancelar torneio");
      GroupLayout var5 = new GroupLayout(this.uv);
      this.uv.setLayout(var5);
      var5.setHorizontalGroup(
         var5.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var5.createSequentialGroup()
                  .addContainerGap(16, 32767)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.ut, Alignment.TRAILING, -2, 266, -2)
                        .addComponent(this.a_, Alignment.TRAILING, -2, 266, -2)
                        .addComponent(this.zh, Alignment.TRAILING, -2, 257, -2)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var5.createParallelGroup(Alignment.TRAILING)
                              .addGroup(var5.createParallelGroup(Alignment.LEADING).addComponent(this.yZ).addComponent(this.yV))
                              .addComponent(this.afF)
                        )
                        .addComponent(this.afE)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(var5.createSequentialGroup().addComponent(this.wi, -2, 279, -2).addGap(19, 24, 32767))
                        .addGroup(var5.createSequentialGroup().addComponent(this.vz, -1, -1, 32767).addContainerGap())
                        .addGroup(
                           Alignment.TRAILING,
                           var5.createSequentialGroup()
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.CS, -2, 145, -2)
                              .addGap(78, 78, 78)
                        )
                  )
            )
            .addGroup(
               var5.createSequentialGroup()
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(var5.createSequentialGroup().addGap(62, 62, 62).addComponent(this.vy, -2, 190, -2))
                        .addGroup(var5.createSequentialGroup().addContainerGap().addComponent(this.us, -2, 242, -2))
                        .addGroup(var5.createSequentialGroup().addContainerGap().addComponent(this.vx, -2, 242, -2))
                  )
                  .addGap(30, 30, 30)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.afG, 0, -1, 32767)
                        .addComponent(this.Nr)
                        .addComponent(this.afH, Alignment.TRAILING, -1, 243, 32767)
                  )
                  .addContainerGap(-1, 32767)
            )
            .addGroup(
               var5.createSequentialGroup()
                  .addGap(66, 66, 66)
                  .addComponent(this.uC, -2, 164, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.Bw, -2, 164, -2)
                  .addGap(122, 122, 122)
            )
      );
      var5.setVerticalGroup(
         var5.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var5.createSequentialGroup()
                  .addContainerGap(26, 32767)
                  .addGroup(var5.createParallelGroup(Alignment.BASELINE).addComponent(this.Nr, -2, -1, -2).addComponent(this.vx))
                  .addGap(18, 18, 18)
                  .addGroup(var5.createParallelGroup(Alignment.BASELINE).addComponent(this.afG, -2, -1, -2).addComponent(this.us))
                  .addGap(18, 18, 18)
                  .addGroup(var5.createParallelGroup(Alignment.BASELINE).addComponent(this.vy).addComponent(this.afH, -2, -1, -2))
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var5.createSequentialGroup()
                              .addGap(48, 48, 48)
                              .addComponent(this.yV)
                              .addGap(18, 18, 18)
                              .addComponent(this.yZ)
                              .addGap(44, 44, 44)
                              .addComponent(this.afF)
                              .addGap(18, 18, 18)
                              .addComponent(this.afE)
                        )
                        .addGroup(
                           var5.createSequentialGroup()
                              .addGap(20, 20, 20)
                              .addGroup(var5.createParallelGroup(Alignment.LEADING).addComponent(this.vz).addComponent(this.a_))
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addGroup(var5.createParallelGroup(Alignment.TRAILING).addComponent(this.ut, -2, 206, -2).addComponent(this.wi, -2, 206, -2))
                        )
                  )
                  .addPreferredGap(ComponentPlacement.RELATED, 18, 32767)
                  .addGroup(var5.createParallelGroup(Alignment.LEADING).addComponent(this.CS).addComponent(this.zh))
                  .addGap(18, 18, 18)
                  .addGroup(var5.createParallelGroup(Alignment.LEADING).addComponent(this.uC, -2, 39, -2).addComponent(this.Bw, -2, 39, -2))
                  .addGap(28, 28, 28)
            )
      );
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Realizado em centros de treinamento, não geram receita para os times.");
      GroupLayout var6 = new GroupLayout(this);
      this.setLayout(var6);
      var6.setHorizontalGroup(
         var6.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var6.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addGroup(
                     var6.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.uu, -2, 434, -2)
                        .addComponent(this.ug, -2, 646, -2)
                        .addComponent(this.uv, -2, -1, -2)
                  )
                  .addContainerGap(25, 32767)
            )
      );
      var6.setVerticalGroup(
         var6.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var6.createSequentialGroup()
                  .addGap(21, 21, 21)
                  .addComponent(this.uu)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ug)
                  .addGap(7, 7, 7)
                  .addComponent(this.uv, -2, -1, -2)
                  .addContainerGap(21, 32767)
            )
      );
   }

   private void d(ActionEvent actionEvent) {
   }

   private void e(ActionEvent actionEvent) {
   }
}
