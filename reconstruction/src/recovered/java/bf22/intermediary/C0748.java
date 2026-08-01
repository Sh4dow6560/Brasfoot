package bf22.intermediary;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C0748 extends JPanel {
   private JDialog ub;
   private JButton vm;
   private JComboBox va;
   private JLabel DQ;
   private JLabel DR;
   private JLabel BL;
   private JLabel Mt;

   public C0748(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
   }

   private void mH() {
      this.vm.addActionListener(new C0749(this));
   }

   private void mJ() {
      this.BL = new JLabel();
      this.Mt = new JLabel();
      this.DR = new JLabel();
      this.DQ = new JLabel();
      this.va = new JComboBox();
      this.vm = new JButton();
      this.setBackground(new Color(36, 91, 45));
      this.setLayout(new C0807());
      this.BL.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/nacionais_sel.png")));
      this.add(this.BL, new C0775(10, 0, 114, 31));
      this.Mt.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/selecoes_sel.png")));
      this.add(this.Mt, new C0775(350, 0, 114, 31));
      this.DR.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/inter_sel.png")));
      this.add(this.DR, new C0775(120, 0, 114, 31));
      this.DQ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/estaduais_sel.png")));
      this.add(this.DQ, new C0775(230, 0, 114, 31));
      this.add(this.va, new C0775(470, 10, 210, 30));
      this.vm.setText("X");
      this.add(this.vm, new C0775(700, 10, 40, 30));
   }
}
