package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.FileNotFoundException;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;

public class C0450 extends JPanel {
   private JDialog ub;
   private String bj;
   private boolean Lz;
   private Timer GO = null;
   private JLabel ug;
   private JProgressBar Hf;

   public C0450(JDialog jDialog, String string, boolean bl) {
      this.ub = jDialog;
      this.bj = string;
      this.Lz = bl;
      this.mJ();
      if (bl) {
         this.ug.setText("Carregando...");
         this.setBackground(new Color(0, 51, 51));
         this.ub.setCursor(new Cursor(3));
      }

      this.mY();
      this.mG();
      C0400 var4 = new C0400(this);
      var4.start();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.Hf);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("esc", new C0399(this));
   }

   public void sh() {
      try {
         if (false) {
            throw new FileNotFoundException();
         }
         GamePersistence.saveCareer(GamePersistence.careerState.br());
      } catch (FileNotFoundException var2) {
         var2.printStackTrace();
      }

      this.ub.dispose();
   }

   private void mJ() {
      this.ug = new JLabel();
      this.Hf = new JProgressBar();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.ug.setFont(new Font("Tahoma", 1, 11));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Salvando jogo... isso poder demorar um pouco...");
      this.Hf.setForeground(new Color(0, 102, 0));
      this.Hf.setBorderPainted(false);
      this.Hf.setIndeterminate(true);
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(var1.createSequentialGroup().addGap(77, 77, 77).addComponent(this.Hf, -2, 226, -2).addContainerGap(64, 32767))
            .addGroup(var1.createSequentialGroup().addGap(26, 26, 26).addComponent(this.ug, -1, -1, 32767).addContainerGap())
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(23, 23, 23)
                  .addComponent(this.ug)
                  .addGap(18, 18, 18)
                  .addComponent(this.Hf, -2, 24, -2)
                  .addContainerGap(35, 32767)
            )
      );
   }
}
