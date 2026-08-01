package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import mod.recovered.save.SavedGameInfo;

public class C0200 extends JPanel {
   private JDialog ub;
   private ArrayList GL = new ArrayList();
   private String[][] GM = new String[1][1];
   private String GN = null;
   private Timer GO = null;
   private JButton vb;
   private JButton vc;
   private JButton GP;
   private JLabel ug;
   private JScrollPane ut;
   private JTable GQ;
   private JLabel yA;
   private JLabel Fr;

   public C0200(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mK();
      this.nc();
      this.mH();
   }

   public void mH() {
      this.vb.addActionListener(new C0201(this));
      this.vc.addActionListener(new C0202(this));
      this.GP.addActionListener(new C0203(this));
   }

   private void pW() {
      if (this.GN != null) {
         this.yA.setText("carregando...");
         this.Fr.setText("aguarde...");
         if (this.GO == null) {
            this.GO = new Timer(10, new C0204(this));
            this.GO.setRepeats(false);
            this.GO.start();
         } else {
            this.GO.restart();
         }
      }
   }

   private void pX() {
      int var1 = -1;
      var1 = JOptionPane.showConfirmDialog(this.ub, "Deseja excluir o arquivo?", "Confirmação", 0);
      if (var1 == 0 && this.GN != null) {
         String var2 = C0732.cK + "/sav/" + this.GN + ".s22";
         Path var3 = Paths.get(var2);

         try {
            Files.deleteIfExists(var3);
         } catch (IOException var5) {
            var5.printStackTrace();
         }

         this.mK();
         this.nc();
      }
   }

   private void mK() {
      this.GM = null;
      this.GL.clear();
      File var1 = new File(System.getProperty("user.dir") + "/sav");
      File[] var2 = var1.listFiles(new C0205(this));

      for (int var3 = 0; var3 < var2.length; var3++) {
         if (var2[var3].isFile()) {
            String var4 = var2[var3].getName();
            var4 = var4.substring(0, var4.lastIndexOf("."));
            this.GL.add(var4);
         }
      }

      this.GM = new String[this.GL.size()][1];

      for (int var5 = 0; var5 < this.GM.length; var5++) {
         this.GM[var5][0] = (String)this.GL.get(var5);
      }
   }

   private void nc() {
      String[] var1 = new String[]{"Arquivo"};
      this.GQ.setSelectionMode(0);
      this.GQ.setRowSelectionAllowed(true);
      this.GQ.setSelectionBackground(Color.YELLOW);
      this.GQ.setFillsViewportHeight(true);
      this.GQ.setModel(new DefaultTableModel(this.GM, var1));
      this.GQ.getSelectionModel().addListSelectionListener(new C0206(this));
      if (this.GQ.getRowCount() > 0) {
         this.GQ.setRowSelectionInterval(0, 0);
      }
   }

   private void pY() {
      SavedGameInfo var1 = null;
      var1 = GamePersistence.af(this.GN);
      this.yA.setText("");
      this.Fr.setText("");
      if (var1 != null) {
         this.yA.setText(Integer.toString(var1.getSeasonYear()) + " - " + var1.getManagerName() + " (" + var1.getClubName() + ")");
         this.Fr.setText("Próx.: " + var1.getNextMatch());
      }
   }

   private void mJ() {
      this.ug = new JLabel();
      this.ut = new JScrollPane();
      this.GQ = new C0207(this);
      this.vb = new JButton();
      this.vc = new JButton();
      this.GP = new JButton();
      this.yA = new JLabel();
      this.Fr = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Carregar Jogo Salvo");
      this.ut.setViewportView(this.GQ);
      this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/loadt.png")));
      this.vb.setText("Carregar");
      this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/home.png")));
      this.vc.setText("Cancelar");
      this.GP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icondel.png")));
      this.GP.setText("Deletar");
      this.yA.setForeground(new Color(255, 255, 255));
      this.yA.setText("Técnico:");
      this.Fr.setForeground(new Color(255, 255, 255));
      this.Fr.setText("Técnico:");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.ut, -2, 0, 32767)
                        .addComponent(this.ug)
                        .addComponent(this.yA, -1, -1, 32767)
                        .addComponent(this.Fr, -1, -1, 32767)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.vb, -2, 115, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.vc, -2, 110, -2)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.GP, -2, 107, -2)
                        )
                  )
                  .addContainerGap(20, 32767)
            )
      );
      var1.linkSize(0, this.vb, this.vc, this.GP);
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -2, 186, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.yA)
                  .addGap(18, 18, 18)
                  .addComponent(this.Fr)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vb).addComponent(this.vc).addComponent(this.GP))
                  .addContainerGap(22, 32767)
            )
      );
      var1.linkSize(1, this.vb, this.vc, this.GP);
   }
}
