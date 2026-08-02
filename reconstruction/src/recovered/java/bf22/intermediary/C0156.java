package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;

public class C0156 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private ArrayList DW = new ArrayList();
   private JButton vm;
   private JButton DX;
   private JButton DY;
   private JLabel ug;
   private JLabel uh;
   private JPanel vd;
   private JScrollPane ut;
   private JLabel DZ;
   private JLabel Ea;
   private JLabel Eb;
   private JLabel Ec;
   private JTable Ed;

   public C0156(JDialog jDialog, Club club) {
      this.uk = club;
      this.ub = jDialog;
      this.mJ();
      this.mH();
      this.ug.setIcon(club.kU());
      this.pp();
      this.pq();
      this.po();
      this.ug.setText("Finanças - " + String.valueOf(GamePersistence.careerState.getSeasonNumber() + GamePersistence.careerState.getSeasonYearOffset()));
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void po() {
      String var1 = "Total de salários por mês: ";
      if (!GamePersistence.careerState.isSalarioMensal()) {
         var1 = "Total de salários por semana: ";
      }

      this.Ec.setText(var1 + ClubFinances.c(this.uk.kK()));
      this.DZ.setText("Dinheiro em caixa: " + ClubFinances.c(this.uk.kb()));
      this.Ea.setText("Valor já emprestado: " + ClubFinances.c(this.uk.getFinances().eN()));
      this.Eb.setText("Juros mensais: " + ClubFinances.c(this.uk.getFinances().eQ()));
   }

   private void pp() {
      ClubFinances var1 = this.uk.getFinances();
      if (var1 != null) {
         C0815 var2 = new C0815();
         var2.ar(true);
         var2.D("Receitas");
         var2.as(true);
         this.DW.add(var2);
         C0815 var3 = new C0815();
         var3.D("Ingressos:");
         var3.g(var1.eE());
         this.DW.add(var3);
         C0815 var4 = new C0815();
         var4.D("Venda de Jogadores:");
         var4.g(var1.eG());
         this.DW.add(var4);
         C0815 var5 = new C0815();
         var5.D("Prêmios:");
         var5.g(var1.eF());
         this.DW.add(var5);
         C0815 var6 = new C0815();
         var6.D("Patrocinio/Sócio torcedor:");
         var6.g(var1.eH());
         this.DW.add(var6);
         C0815 var7 = new C0815();
         var7.D("Multas/outros:");
         var7.g(var1.eR());
         this.DW.add(var7);
         C0815 var8 = new C0815();
         var8.D("Total de receitas:");
         var8.as(true);
         var8.g(var1.ez());
         this.DW.add(var8);
         C0815 var9 = new C0815();
         var9.ar(true);
         var9.D("Despesas");
         var9.as(true);
         this.DW.add(var9);
         C0815 var10 = new C0815();
         var10.D("Compras de jogadores:");
         var10.g(var1.eJ());
         this.DW.add(var10);
         C0815 var11 = new C0815();
         var11.D("Estádio:");
         var11.g(var1.eI());
         this.DW.add(var11);
         C0815 var12 = new C0815();
         var12.D("Salários:");
         var12.g(var1.eO());
         this.DW.add(var12);
         C0815 var13 = new C0815();
         var13.D("Juros de empréstimo:");
         var13.g(var1.eK());
         this.DW.add(var13);
         C0815 var14 = new C0815();
         var14.D("Multa de rescisão:");
         var14.g(var1.eM());
         this.DW.add(var14);
         C0815 var15 = new C0815();
         var15.D("Diversos:");
         var15.g(var1.eL());
         this.DW.add(var15);
         C0815 var16 = new C0815();
         var16.D("Total de despesas:");
         var16.as(true);
         var16.g(var1.eB());
         this.DW.add(var16);
         C0815 var17 = new C0815();
         var17.D("Saldo:");
         var17.as(true);
         var17.g(var1.eC());
         this.DW.add(var17);
      }
   }

   private void mH() {
      this.vm.addActionListener(new C0157(this));
      this.DY.addActionListener(new C0158(this));
      this.DX.addActionListener(new C0159(this));
   }

   private void df(int i) {
      if (i == 1) {
         if (!this.uk.getFinances().m(this.uk)) {
            this.uh.setText("Empréstimo bancário - limite máximo alcançado");
         }
      } else if (i == -1) {
         this.uk.getFinances().l(this.uk);
      }

      this.po();
   }

   private void pq() {
      C0664 var1 = new C0664(this.DW);
      this.Ed.setModel(var1);
      this.Ed.setTableHeader(null);
      int[] var2 = new int[]{100, 100};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Ed.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Ed.setAutoResizeMode(3);
      this.Ed.setRowHeight(20);
      this.Ed.setShowGrid(false);
      this.Ed.setDefaultRenderer(C0815.class, new C0635());
      this.Ed.setAutoCreateRowSorter(false);
      this.Ed.setIntercellSpacing(new Dimension(0, 0));
      this.Ed.setCellSelectionEnabled(false);
      this.Ed.setSelectionMode(0);
      this.Ed.setRowSelectionAllowed(false);
      this.Ed.setSelectionBackground(Color.YELLOW);
      this.Ed.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.ug = new JLabel();
      this.vm = new JButton();
      this.ut = new JScrollPane();
      this.Ed = new JTable();
      this.vd = new JPanel();
      this.uh = new JLabel();
      this.Ea = new JLabel();
      this.Eb = new JLabel();
      this.DY = new JButton();
      this.DX = new JButton();
      this.Ec = new JLabel();
      this.DZ = new JLabel();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Finanças");
      this.vm.setText("X");
      this.ut.setViewportView(this.Ed);
      this.vd.setBackground(new Color(104, 120, 100));
      this.uh.setFont(new Font("Tahoma", 1, 12));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("Empréstimo bancário");
      this.Ea.setForeground(new Color(255, 255, 255));
      this.Ea.setText("Valor já emprestado:");
      this.Eb.setForeground(new Color(255, 255, 255));
      this.Eb.setText("Juros mensais:");
      this.DY.setText("Pegar 500 mil");
      this.DX.setText("Pagar 500 mil");
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
                              .addGap(25, 25, 25)
                              .addComponent(this.DY, -2, 145, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.DX, -2, 145, -2)
                              .addGap(0, 0, 32767)
                        )
                        .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.uh, -1, -1, 32767))
                        .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.Ea, -1, -1, 32767))
                        .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.Eb, -1, -1, 32767))
                  )
                  .addGap(25, 25, 25)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap(14, 32767)
                  .addComponent(this.uh)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.Ea)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.Eb)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.DY).addComponent(this.DX))
                  .addGap(18, 18, 18)
            )
      );
      this.Ec.setForeground(new Color(255, 255, 255));
      this.Ec.setText("Saláro mensal:");
      this.DZ.setForeground(new Color(255, 255, 255));
      this.DZ.setText("Dinheiro em caixa:");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(
                     var2.createParallelGroup(Alignment.TRAILING)
                        .addComponent(this.DZ, -1, -1, 32767)
                        .addComponent(this.Ec, Alignment.LEADING, -1, -1, 32767)
                        .addComponent(this.vd, -1, -1, 32767)
                        .addGroup(var2.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.ut, -2, 354, -2))
                        .addGroup(var2.createSequentialGroup().addComponent(this.ug, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.vm, -2, 49, -2))
                  )
                  .addGap(24, 24, 24)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.ut, -2, 347, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.Ec)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.DZ)
                  .addGap(18, 18, 18)
                  .addComponent(this.vd, -2, -1, -2)
                  .addContainerGap(18, 32767)
            )
      );
   }
}
