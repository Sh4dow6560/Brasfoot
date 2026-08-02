package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0120 extends JPanel {
   private JDialog ub;
   private ArrayList oh = null;
   private C0799 zX = null;
   private Club zY = null;
   private JButton vm;
   private JButton zZ;
   private JButton Aa;
   private JLabel ug;
   private JPanel vd;
   private JScrollPane ut;
   private JLabel Ab;
   private JLabel Ac;
   private JTable Ad;

   public C0120(JDialog jDialog, ArrayList arrayList, Club club) {
      this.ub = jDialog;
      this.oh = arrayList;
      this.zY = club;
      this.oh = new ArrayList();
      if (arrayList != null) {
         this.oh.addAll(arrayList);
         Collections.reverse(this.oh);
      }

      this.mJ();
      this.mH();
      this.mS();
      this.T(false);
      if (this.Ad.getRowCount() > 0) {
         this.Ad.setRowSelectionInterval(0, 0);
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void T(boolean bl) {
      this.Aa.setVisible(bl);
      this.zZ.setVisible(bl);
      this.Ab.setVisible(bl);
   }

   public void mH() {
      this.vm.addActionListener(new C0121(this));
      this.Aa.addActionListener(new C0122(this));
      this.zZ.addActionListener(new C0123(this));
   }

   private void nQ() {
      boolean var1 = false;
      if (new Random().nextInt(100) > 50) {
         var1 = true;
      }

      if (var1 && this.zX != null && this.zY != null && this.zY.getCoach() != null) {
         new C0799(this.zY.getCoach(), 10, new Random().nextInt(4) + 16, this.zX.vs(), "");
      }
   }

   private void cQ(int i) {
      if (i == 1) {
         if (this.zX != null) {
            this.zX.aG(false);
            this.T(false);
            if (this.zX.vt() == 1 && this.zX.lY() > 0 && this.zY != null) {
               this.zY.credit(this.zX.lY(), 9);
               this.Ab.setVisible(true);
               this.Ab.setText("Multado!");
               this.nQ();
            }
         }
      } else if (i == 2 && this.zX != null) {
         this.zX.aG(false);
         this.T(false);
      }
   }

   private void mS() {
      C0661 var1 = new C0661(this.oh);
      this.Ad.setModel(var1);
      int[] var2 = new int[]{70, 220};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Ad.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Ad.getColumnModel().getColumn(0).setMaxWidth(70);
      this.Ad.setAutoResizeMode(3);
      this.Ad.setRowHeight(20);
      this.Ad.setShowGrid(false);
      this.Ad.setDefaultRenderer(C0799.class, new C0633());
      this.Ad.setAutoCreateRowSorter(false);
      this.Ad.getTableHeader().setReorderingAllowed(false);
      this.Ad.setIntercellSpacing(new Dimension(0, 0));
      this.Ad.setCellSelectionEnabled(false);
      this.Ad.setSelectionMode(0);
      this.Ad.setRowSelectionAllowed(true);
      this.Ad.setSelectionBackground(Color.YELLOW);
      this.Ad.setFillsViewportHeight(true);
      this.Ad.getSelectionModel().addListSelectionListener(new C0124(this));
   }

   private void a(C0799 c0799) {
      if (c0799 != null) {
         this.zX = c0799;
         this.T(false);
         c0799.aF(true);
         String var2 = "";
         if (c0799.vn() < C0711.tQ.length && c0799.vn() >= 0) {
            var2 = C0711.tQ[c0799.vn()];
         }

         String var3 = c0799.vq();
         String var4 = c0799.vp();
         if (c0799.vm() == 24 || c0799.vm() == 28 || c0799.vm() == 29 || c0799.vm() == 34) {
            var2 = var2.replace("$1", var3);
            var3 = "";
         } else if (c0799.vm() == 26) {
            var2 = var2.replace("$1", var3);
            if (var4 != null) {
               var2 = var2.replace("$2", var4);
            }

            var3 = "";
         }

         this.Ac.setText("<html>" + var2 + " " + var3 + "</html>");
         this.Ad.addNotify();
         this.Ab.setVisible(false);
         if (c0799.vr()) {
            this.T(true);
            this.Ab.setText("Deseja multar esse jogador em 10% do salário?");
         }
      }
   }

   private void mJ() {
      this.ug = new JLabel();
      this.ut = new JScrollPane();
      this.Ad = new JTable();
      this.vm = new JButton();
      this.vd = new JPanel();
      this.Ac = new JLabel();
      this.zZ = new JButton();
      this.Aa = new JButton();
      this.Ab = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aicons/messageicon.png")));
      this.ug.setText("Central de Mensagens");
      this.ut.setBackground(new Color(44, 53, 49));
      this.Ad.setBackground(new Color(44, 53, 49));
      this.Ad.setForeground(new Color(255, 255, 255));
      this.ut.setViewportView(this.Ad);
      this.vm.setText("X");
      this.Ac.setFont(new Font("Arial", 0, 12));
      this.Ac
         .setText(
            "<html><P valign=\"top\">A diretoria lhe deseja sorte. Esperamos muitas vitórias. Nesta janela iremos te comunicar sobre vários assuntos do clube. dfasdfasdf dsfafdsf</P></html>\n\n"
         );
      this.Ac.setVerticalAlignment(1);
      this.Ac.setMaximumSize(new Dimension(200, 14));
      this.Ac.setVerticalTextPosition(1);
      this.zZ.setText("Não Multar");
      this.Aa.setText("Multar");
      this.Ab.setFont(new Font("Tahoma", 1, 12));
      this.Ab.setHorizontalAlignment(4);
      this.Ab.setText("jLabel2");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addComponent(this.Ac, -2, 411, -2).addGap(0, 0, 32767))
                        .addComponent(this.Ab, Alignment.TRAILING, -1, -1, 32767)
                        .addGroup(
                           Alignment.TRAILING,
                           var1.createSequentialGroup()
                              .addGap(0, 0, 32767)
                              .addComponent(this.Aa, -2, 116, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.zZ, -2, 116, -2)
                        )
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.Ac, -2, 198, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.Ab)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.zZ).addComponent(this.Aa))
                  .addContainerGap()
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.ug, -2, 301, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 77, -2)
                        )
                        .addGroup(var2.createSequentialGroup().addComponent(this.ut, -2, 401, -2).addGap(18, 18, 18).addComponent(this.vd, -2, -1, -2))
                  )
                  .addContainerGap(20, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm))
                  .addGap(18, 18, 18)
                  .addGroup(var2.createParallelGroup(Alignment.LEADING, false).addComponent(this.ut, -1, 300, 32767).addComponent(this.vd, -1, -1, 32767))
                  .addContainerGap(27, 32767)
            )
      );
   }
}
