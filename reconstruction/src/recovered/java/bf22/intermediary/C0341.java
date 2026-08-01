package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0341 extends JPanel {
   private JDialog ub;
   private JButton zn;
   private JTextField IA;
   private JLabel ug;
   private JPanel vd;

   public C0341(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
   }

   public void mH() {
      this.zn.addActionListener(new C0342(this));
   }

   private void nH() {
      String var1 = this.IA.getText().toString();
      int var2 = -1;
      boolean var3 = false;
      File var4 = new File(System.getProperty("user.dir") + "/sav/" + var1 + ".s22");
      if (var1.isEmpty() || var1.length() > 15 || var1.length() == 0) {
         String var5 = "";
         if (var1.length() > 15) {
            var5 = ": muito extenso";
         }

         JOptionPane.showMessageDialog(this.ub, "Arquivo inválido" + var5, "Erro", 0);
      } else if (var4.exists()) {
         var2 = JOptionPane.showConfirmDialog(this.ub, "Um arquivo com esse nome já existe, sobrescrever?", "Arquivo já existe", 0);
         if (var2 == 0) {
            var3 = true;
         } else {
            var3 = false;
         }
      } else {
         var3 = true;
      }

      if (var3) {
         this.zn.setCursor(new Cursor(3));
         this.ub.setCursor(new Cursor(3));
         GamePersistence.SR.d(var1);
         this.ub.dispose();
      }
   }

   private boolean C(String string) {
      File var2 = new File(System.getProperty("user.dir") + "/sav/" + string + ".sav");
      return var2.exists() && !var2.isDirectory();
   }

   private void mJ() {
      this.ug = new JLabel();
      this.vd = new JPanel();
      this.IA = new JTextField();
      this.zn = new JButton();
      this.setBackground(new Color(204, 204, 204));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Escolha um nome de arquivo para salvar o jogo:");
      this.vd.setBackground(new Color(204, 204, 204));
      this.IA.setFont(new Font("Tahoma", 0, 12));
      this.zn.setText("Salvar");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(54, 54, 54)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.IA, -2, 313, -2)
                        .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addComponent(this.zn, -2, 127, -2).addGap(78, 78, 78))
                  )
                  .addContainerGap(56, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.IA, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, 38, 32767)
                  .addComponent(this.zn, -2, 31, -2)
                  .addGap(23, 23, 23)
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(var2.createParallelGroup(Alignment.LEADING, false).addComponent(this.vd, -1, -1, 32767).addComponent(this.ug, -1, -1, 32767))
                  .addContainerGap(19, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.vd, -2, -1, -2)
                  .addContainerGap(22, 32767)
            )
      );
   }
}
