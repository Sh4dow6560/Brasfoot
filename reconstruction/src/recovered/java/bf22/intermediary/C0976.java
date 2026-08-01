package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.prefs.Preferences;
import javax.swing.JButton;

class C0976 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   private final javax.swing.JButton Xc;
   C0976(C0971 c0971, JButton jButton) {
      this.Xb = c0971;
      this.Xc = jButton;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Xc.setText("save");
      int var2 = new Random().nextInt(1000);
      int var3 = 0;
      Preferences var4 = Preferences.userRoot().node(this.getClass().getName());
      var3 = var4.getInt("cont", 0);

      try {
         if (false) {
            throw new FileNotFoundException();
         }
         C0745.ae("teste20_" + var3);
      } catch (FileNotFoundException var6) {
         var6.printStackTrace();
      }

      var4.putInt("cont", var3++);
      System.out.println("---salvo");
   }
}
