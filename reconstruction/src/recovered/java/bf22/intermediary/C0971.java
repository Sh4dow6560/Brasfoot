package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import mod.recovered.model.Club;

public class C0971 {

   static void a(bf22.intermediary.C0971 arg0) {}

   static void a(bf22.intermediary.C0971 arg0, mod.recovered.model.Club arg1) {}

   static javax.swing.JWindow b(bf22.intermediary.C0971 arg0) {
      return null;
   }
   private JWindow WW;
   private JFrame WX;
   private JPanel WY;
   private BufferedImage WZ = null;
   private JLabel Xa;

   public void wT() {
      this.xs();
      this.xt();
      this.xu();
      this.xv();
      this.xw();
      this.xx();
      this.xy();
      this.xz();
      this.xb();
      this.xA();
      this.xB();
      this.xC();
      this.xD();
      this.xE();
      this.xa();
   }

   private void xr() {
      this.WW = new JWindow();
      Rectangle var1 = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      this.WW.setSize(var1.width, var1.height);
      this.WW.setVisible(true);
   }

   private void xs() {
      this.WX = new JFrame("Brasfoot");
      this.WX.setLayout(new BorderLayout());
      this.WX.setDefaultCloseOperation(3);
   }

   private void xa() {
      this.WX.setUndecorated(true);
      this.WX.pack();
      GraphicsConfiguration var1 = this.WX.getGraphicsConfiguration();
      Rectangle var2 = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      this.WX.setMaximizedBounds(new Rectangle(0, 0, var2.width, var2.height));
      this.WX.setVisible(true);
   }

   private void xt() {
      this.WY = new JPanel();
      this.WX.add(this.WY);
   }

   private void xu() {
      try {
         if (this.getClass().getResource("/arquivos/2016.jpg") != null) {
            this.WZ = ImageIO.read(this.getClass().getResource("/arquivos/2016.jpg"));
         }
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      this.Xa = new JLabel();
      if (this.WZ != null) {
         this.Xa.setIcon(new ImageIcon(this.WZ));
         this.Xa.setLayout(new FlowLayout());
      } else {
         BufferedImage var1 = new BufferedImage(256, 256, 1);
         this.Xa.setIcon(new ImageIcon(var1));
         this.Xa.setLayout(new FlowLayout());
      }

      this.WY.add(this.Xa);
   }

   private void xv() {
      JButton var1 = new JButton("Passa Dia");
      var1.addActionListener(new C0972(this));
      this.Xa.add(var1);
   }

   private void Bc() {
      String var1 = "Torneio Teste";
      String var2 = "Sertãozinho";
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 <= 7; var4++) {
         var3.add((Club)GamePersistence.careerState.P().get(var4));
      }

      if (GamePersistence.careerState.yn() != null) {
         GamePersistence.careerState.yn().a(var3, 0, var1, var2, false);
      }
   }

   private void xw() {
      JButton var1 = new JButton("Processa teste");
      var1.addActionListener(new C0975(this));
      this.Xa.add(var1);
   }

   private void xx() {
      JButton var1 = new JButton("save");
      var1.addActionListener(new C0976(this, var1));
      this.Xa.add(var1);
   }

   private void xy() {
      JButton var1 = new JButton("load");
      var1.addActionListener(new C0977(this));
      this.Xa.add(var1);
   }

   private void xz() {
      JButton var1 = new JButton("conversor");
      var1.addActionListener(new C0978(this));
      this.Xa.add(var1);
   }

   private void xb() {
      JButton var1 = new JButton("Inicializa Jogo");
      var1.addActionListener(new C0979(this));
      this.Xa.add(var1);
   }

   private void xA() {
      JButton var1 = new JButton("i");
      var1.addActionListener(new C0980(this));
      this.WY.add(var1);
   }

   private void xB() {
      JButton var1 = new JButton("e");
      var1.addActionListener(new C0981(this));
      this.WY.add(var1);
   }

   private void xC() {
      JButton var1 = new JButton("r");
      var1.addActionListener(new C0982(this));
      this.WY.add(var1);
   }

   private void xD() {
      JButton var1 = new JButton("Sair");
      var1.addActionListener(new C0973(this));
      this.WY.add(var1);
   }

   private void K(Club club) {
      if (GamePersistence.careerState.getSavedGameInfo() != null) {
         GamePersistence.careerState.getSavedGameInfo().setClubName(club.getCoach().dS());
         GamePersistence.careerState.getSavedGameInfo().setManagerName(club.getNome());
         GamePersistence.careerState.getSavedGameInfo().setSeasonYear(GamePersistence.careerState.getSeasonNumber() + GamePersistence.careerState.getSeasonYearOffset());
         GamePersistence.careerState.getSavedGameInfo().setNextMatch("");
      }
   }

   private void xE() {
      JButton var1 = new JButton("Add Hum");
      var1.addActionListener(new C0974(this));
      this.WY.add(var1);
   }

   public static void c(JFrame jFrame) {
      Dimension var1 = Toolkit.getDefaultToolkit().getScreenSize();
      int var2 = (int)((var1.getWidth() - jFrame.getWidth()) / 2.0);
      int var3 = (int)((var1.getHeight() - jFrame.getHeight()) / 2.0);
      jFrame.setLocation(var2, var3);
   }
}
