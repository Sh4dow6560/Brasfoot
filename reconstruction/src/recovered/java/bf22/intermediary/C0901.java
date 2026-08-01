package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mod.recovered.model.Player;

public class C0901 extends JFrame {

   static void a(bf22.intermediary.C0901 arg0) {}

   static void a(bf22.intermediary.C0901 arg0, bf22.intermediary.C0914 arg1) {}

   static void a(bf22.intermediary.C0901 arg0, boolean arg1) {}

   static javax.swing.JButton b(bf22.intermediary.C0901 arg0) {
      return null;
   }

   static javax.swing.JButton c(bf22.intermediary.C0901 arg0) {
      return null;
   }

   static javax.swing.JLabel d(bf22.intermediary.C0901 arg0) {
      return null;
   }

   static boolean e(bf22.intermediary.C0901 arg0) {
      return false;
   }

   static bf22.intermediary.C0915 f(bf22.intermediary.C0901 arg0) {
      return null;
   }

   static javax.swing.JTable g(bf22.intermediary.C0901 arg0) {
      return null;
   }

   static void h(bf22.intermediary.C0901 arg0) {}

   static void i(bf22.intermediary.C0901 arg0) {}

   static void j(bf22.intermediary.C0901 arg0) {}

   static void k(bf22.intermediary.C0901 arg0) {}

   static void l(bf22.intermediary.C0901 arg0) {}

   static javax.swing.JLabel m(bf22.intermediary.C0901 arg0) {
      return null;
   }
   private C0915 Uu = null;
   private C0914 Uv = null;
   private boolean Uc = true;
   public JDialog Uw;
   private boolean Ux = true;
   private boolean Uy = true;
   private boolean Uz = false;
   private C0871 UA;
   Comparator UB = new C0902(this);
   private JButton afR;
   private JButton UC;
   private JButton UD;
   private JButton UE;
   private JButton UF;
   private JButton Kc;
   private JButton UG;
   private JButton UH;
   private JButton UI;
   private JButton UJ;
   private JButton UK;
   private JButton BZ;
   private JButton UL;
   private JButton UM;
   private JButton UN;
   private JButton UO;
   private JComboBox Nq;
   private JPanel vd;
   private JPanel we;
   private JPanel wf;
   private JScrollPane ut;
   private JScrollPane wi;
   private JTextField Ej;
   private JTextField Ek;
   private JLabel afS;
   private JLabel UR;
   private JLabel US;
   private JLabel UT;
   private JLabel UU;
   private JLabel Fq;
   private JLabel UV;
   private JLabel UW;
   private JLabel MM;
   private JLabel UX;
   private JLabel UY;
   private JLabel UZ;
   private JLabel Va;
   private JLabel Vb;
   private JLabel Gk;
   private JLabel MQ;
   private JLabel Vc;
   private JLabel Vd;
   private JLabel Ve;
   private JLabel MR;
   private JLabel MS;
   private JLabel Vf;
   private JTable UQ;
   public JTable Vg;

   public C0901() {
      this.Uu = (C0915)C0732.cZ().get(0);
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/aicons/ball.png"));
      this.setIconImage(var1.getImage());
      this.setTitle("Editor Brasfoot");
      this.pack();
      GraphicsConfiguration var2 = this.getGraphicsConfiguration();
      Rectangle var3 = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      this.setMaximizedBounds(new Rectangle(0, 0, var3.width, var3.height));
      this.setExtendedState((this.getExtendedState() & 6) == 6 ? 0 : 6);
      Color var4 = Color.decode("#007700");
      this.getContentPane().setBackground(var4);
      this.mJ();
      this.Ay();
      this.Ej.setText("");
      this.Ek.setText("");
      this.afS.setText("");
      this.mW();
      this.wx();
      this.wF();
   }

   private void mW() {
      this.Nq.removeAllItems();

      for (int var1 = 0; var1 < GameConstants.rH.length; var1++) {
         this.Nq.addItem(GameConstants.rH[var1]);
      }

      this.Nq.setSelectedIndex(0);
   }

   public static String k(int i, boolean bl) {
      String var2 = null;
      var2 = new C0679().k(i, bl);
      if (var2 != null && var2.length() != 0) {
         var2.isEmpty();
      }

      return var2;
   }

   public void Bb() {
      boolean var1 = false;
      if (this.Uc) {
         if (C0732.da().wI().getJogadores().size() >= 30) {
            var1 = true;
         }
      } else if (C0732.da().wI().getJuniores().size() >= 15) {
         var1 = true;
      }

      if (!var1) {
         boolean var2 = true;
         if (new Random().nextInt(5) == 0) {
            var2 = false;
         }

         String var3 = k(this.Uu.getPais(), var2);
         if (var3 != null && !var3.isEmpty() && var3.length() > 1) {
            int[] var4 = Player.at(this.Nq.getSelectedIndex());
            C0914 var5 = new C0914();
            var5.setNome(var3);
            var5.setEstrela(false);
            var5.setTopMundial(false);
            var5.setPais(this.Uu.getPais());
            var5.setPosicao(this.Nq.getSelectedIndex());
            if (this.Uc) {
               var5.setIdade(new Random().nextInt(20) + 18);
            } else {
               var5.setIdade(new Random().nextInt(4) + 16);
            }

            var5.setStatus(0);
            var5.setCr1(var4[0]);
            var5.setCr2(var4[1]);
            var5.setLado(new Random().nextInt(2));
            var5.setHash(new Random().nextInt(4) + 7);
            if (this.Uc) {
               C0732.da().wI().getJogadores().add(var5);
               ((C0878)C0732.da().wJ().getModel()).i(3, true);
               C0732.da().wG();
            } else {
               C0732.da().wI().getJuniores().add(var5);
               ((C0878)C0732.da().wJ().getModel()).i(3, true);
               C0732.da().wG();
            }

            this.an(var3);
            this.afS.setText("Criado: " + var3);
            C0732.da().wo();
         }
      }
   }

   private void b(C0915 c0915) {
      int var2 = 0;
      int var3 = 0;

      for (int var4 = 0; var4 < c0915.getJogadores().size(); var4++) {
         if (((C0914)c0915.getJogadores().get(var4)).getPosicao() == 0) {
            var2++;
         } else {
            var3++;
         }
      }

      if (var2 >= 1 && var3 >= 11) {
         c0915.setValid(true);
      } else {
         c0915.setValid(false);
      }

      c0915.setVid(185);
   }

   public void wo() {
      this.b(this.Uu);

      try {
         FileOutputStream var1 = new FileOutputStream(C0732.cK + "/teams/" + this.Uu.getFileRef() + ".ban");
         ObjectOutputStream var2 = new ObjectOutputStream(var1);
         var2.writeObject(this.Uu);
         var2.close();
         var1.close();
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.Vg.addNotify();
      this.UQ.addNotify();
   }

   public void c(C0915 c0915) {
      this.b(this.Uu);
      this.b(c0915);

      try {
         FileOutputStream var2 = new FileOutputStream(C0732.cK + "/teams/" + this.Uu.getFileRef() + ".ban");
         ObjectOutputStream var3 = new ObjectOutputStream(var2);
         var3.writeObject(this.Uu);
         var3.close();
         var2.close();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      try {
         FileOutputStream var6 = new FileOutputStream(C0732.cK + "/teams/" + c0915.getFileRef() + ".ban");
         ObjectOutputStream var7 = new ObjectOutputStream(var6);
         var7.writeObject(c0915);
         var7.close();
         var6.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   public void wp() {
      boolean var1 = true;
      if (this.Uc && this.Uu.getJogadores().size() >= 30) {
         var1 = false;
      } else if (!this.Uc && this.Uu.getJuniores().size() >= 15) {
         var1 = false;
      }

      if (var1) {
         this.aK(true);
         C0893 var2 = new C0893();
         this.Uw = new JDialog();
         this.Uw.add(var2);
         this.Uw.setSize(514, 350);
         this.Uw.setModal(true);
         this.Uw.setResizable(false);
         this.Uw.setLocationRelativeTo(null);
         this.Uw.setUndecorated(true);
         this.Uw.setVisible(true);
      }
   }

   public void wq() {
      if (this.Uc) {
         if (this.Uu.getJogadores().size() > 0) {
            this.UZ.setText(Integer.toString(this.Uu.getJogadores().size()) + "/" + 30);
            this.UY.setText(Integer.toString(this.Uu.getNumeroTitulares()));
         } else {
            this.Uv = null;
            this.UZ.setText("0/30");
            this.UY.setText("0");
         }
      } else if (this.Uu.getJuniores().size() > 0) {
         this.UZ.setText(Integer.toString(this.Uu.getJuniores().size()) + "/" + 15);
         this.UY.setText(Integer.toString(this.Uu.getNumeroTitularesJuniores()));
      } else {
         this.Uv = null;
         this.UZ.setText("0/15");
         this.UY.setText("0");
      }
   }

   private void wr() {
      for (int var1 = 0; var1 < C0732.cZ().size(); var1++) {
         ((C0915)C0732.cZ().get(var1)).setMark(((C0915)C0732.cZ().get(var1)).hasDuplicado());
      }

      this.wv();
      this.Vg.addNotify();
   }

   private void ws() {
      if (!this.Ek.getText().isEmpty()) {
         String var1 = C0670.f(this.Ek.getText());
         ((C0887)this.Vg.getModel()).ak(var1);
      }
   }

   private void wt() {
      if (!this.Ej.getText().isEmpty()) {
         String var1 = C0670.f(this.Ej.getText());
         ((C0887)this.Vg.getModel()).ai(var1);
      }
   }

   private void wu() {
      for (int var1 = 0; var1 < C0732.cZ().size(); var1++) {
         ((C0915)C0732.cZ().get(var1)).setMark(((C0915)C0732.cZ().get(var1)).semEscudo());
      }

      this.wv();
      this.Vg.addNotify();
   }

   private void wv() {
      for (int var1 = 0; var1 < C0732.cZ().size(); var1++) {
         if (((C0915)C0732.cZ().get(var1)).isMark()) {
            this.Vg.changeSelection(var1, 0, true, true);
            this.Vg.setRowSelectionInterval(var1, var1);
            break;
         }
      }
   }

   private void ww() {
      for (int var1 = 0; var1 < C0732.cZ().size(); var1++) {
         ((C0915)C0732.cZ().get(var1)).setMark(((C0915)C0732.cZ().get(var1)).semCamisa());
      }

      this.wv();
      this.Vg.addNotify();
   }

   private void sp() {
      C0732.dc().setVisible(true);
      this.dispose();
   }

   private void wx() {
      this.Kc.addActionListener(new C0913(this));
      this.afR.addActionListener(new C0842(this));
      this.UO.addActionListener(new C0849(this));
      this.UN.addActionListener(new C0850(this));
      this.UK.addActionListener(new C0851(this));
      this.UJ.addActionListener(new C0852(this));
      this.UM.addActionListener(new C0853(this));
      this.UL.addActionListener(new C0854(this));
      this.UE.addActionListener(new C0903(this));
      this.Kc.addActionListener(new C0904(this));
      this.BZ.addActionListener(new C0905(this));
      this.UQ.getTableHeader().addMouseListener(new C0906(this));
      this.UI.addActionListener(new C0907(this));
      this.UF.addActionListener(new C0908(this));
      this.UD.addActionListener(new C0909(this));
      this.UC.addActionListener(new C0910(this));
      this.UG.addActionListener(new C0911(this));
      this.UH.addActionListener(new C0912(this));
      this.UQ.getSelectionModel().addListSelectionListener(new C0832(this));
      this.UQ.addMouseListener(new C0833(this));
      this.Vg.addMouseListener(new C0834(this));
      this.Gk.addMouseListener(new C0835(this));
      this.MR.addMouseListener(new C0836(this));
      this.MS.addMouseListener(new C0837(this));
      this.UV.addMouseListener(new C0838(this));
      this.UW.addMouseListener(new C0839(this));
      this.Vb.addMouseListener(new C0840(this));
      this.MM.addMouseListener(new C0841(this));
      this.MQ.addMouseListener(new C0843(this));
      JPopupMenu var1 = new JPopupMenu();
      JMenuItem var2 = new JMenuItem("Adicionar Jogador");
      var2.addActionListener(new C0844(this));
      var1.add(var2);
      var1.addSeparator();
      JMenuItem var3 = new JMenuItem("Editar Jogador");
      var3.addActionListener(new C0845(this));
      var1.add(var3);
      var1.addSeparator();
      JMenuItem var4 = new JMenuItem("Deletar Jogador");
      var4.addActionListener(new C0846(this));
      var1.add(var4);
      var1.addSeparator();
      JMenuItem var5 = new JMenuItem("Transferir Jogador");
      var5.addActionListener(new C0847(this));
      var1.add(var5);
      this.UQ.setComponentPopupMenu(var1);
   }

   public void wy() {
      this.aL(true);
      C0865 var1 = new C0865();
      this.Uw = new JDialog();
      this.Uw.add(var1);
      this.Uw.setSize(518, 398);
      this.Uw.setModal(true);
      this.Uw.setResizable(false);
      this.Uw.setLocationRelativeTo(null);
      this.Uw.setUndecorated(true);
      this.Uw.setVisible(true);
   }

   public void wz() {
      int var1 = -1;
      var1 = JOptionPane.showConfirmDialog(null, "Apagar o time? Isso pode ocasionar erros no jogo!", "Confirmar", 0);
      String var2 = C0732.cK + "/teams/" + this.Uu.getFileRef() + ".ban";
      if (var1 == 0) {
         Path var3 = Paths.get(var2);

         try {
            Files.deleteIfExists(var3);
         } catch (IOException var5) {
            var5.printStackTrace();
         }

         C0732.cZ().remove(this.Uu);
         this.ah(null);
      }
   }

   public void wA() {
      if (this.Uu != null) {
         this.aL(false);
         C0865 var1 = new C0865();
         this.Uw = new JDialog();
         this.Uw.add(var1);
         this.Uw.setSize(518, 398);
         this.Uw.setModal(true);
         this.Uw.setResizable(false);
         this.Uw.setLocationRelativeTo(null);
         this.Uw.setUndecorated(true);
         this.Uw.setVisible(true);
      }
   }

   public void wB() {
      if (this.UQ.getSelectedRow() >= 0) {
         int var1 = this.UQ.convertRowIndexToModel(this.UQ.getSelectedRow());
         ((C0878)this.UQ.getModel()).eI(var1);
         this.UQ.addNotify();
         this.wq();
         this.wo();
      }
   }

   public void wC() {
      if (this.Uv != null) {
         this.aK(false);
         C0893 var1 = new C0893();
         this.Uw = new JDialog();
         this.Uw.add(var1);
         this.Uw.setSize(500, 350);
         this.Uw.setModal(true);
         this.Uw.setResizable(false);
         this.Uw.setLocationRelativeTo(null);
         this.Uw.setUndecorated(true);
         this.Uw.setVisible(true);
      }
   }

   public void wD() {
      if (this.Uv != null) {
         this.aK(false);
         this.UA = new C0871();
         this.Uw = new JDialog();
         this.Uw.add(this.UA);
         this.Uw.setSize(368, 504);
         this.Uw.setModal(true);
         this.Uw.setResizable(false);
         this.Uw.setLocationRelativeTo(null);
         this.Uw.setUndecorated(true);
         this.Uw.setVisible(true);
      }
   }

   public void b(BufferedImage bufferedImage) {
      long var2 = 0L;
      long var4 = 0L;
      var2 = System.currentTimeMillis();
      int[] var6 = new int[10];
      int[][] var7 = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];

      for (int var8 = 0; var8 < bufferedImage.getWidth(); var8++) {
         for (int var9 = 0; var9 < bufferedImage.getHeight(); var9++) {
            int var10 = bufferedImage.getRGB(var8, var9);
            float[] var11 = new float[3];
            int var12 = var10 >> 16 & 0xFF;
            int var13 = var10 >> 8 & 0xFF;
            int var14 = var10 & 0xFF;
            double var15 = 0.2126 * var12 + 0.7152 * var13 + 0.0722 * var14;
            Color.RGBtoHSB(var12, var13, var14, var11);
            if (var15 < 128.0) {
               var6[0]++;
            } else {
               var6[1]++;
            }

            if (var11[1] < 0.1 && var11[2] > 0.9) {
               var6[8]++;
            } else if (var11[2] < 0.1) {
               var6[9]++;
            } else {
               float var17 = var11[0] * 360.0F;
               if (var17 >= 0.0F && var17 < 30.0F) {
                  var6[2]++;
               } else if (var17 >= 30.0F && var17 < 90.0F) {
                  var6[3]++;
               } else if (var17 >= 90.0F && var17 < 150.0F) {
                  var6[4]++;
               } else if (var17 >= 150.0F && var17 < 210.0F) {
                  var6[5]++;
               } else if (var17 >= 210.0F && var17 < 270.0F) {
                  var6[6]++;
               } else if (var17 >= 270.0F && var17 < 330.0F) {
                  var6[7]++;
               } else {
                  var6[2]++;
               }
            }
         }
      }

      var4 = System.currentTimeMillis() - var2;
   }

   public void wE() {
      Color var1 = this.Uu.getCorT();
      Color var2 = this.Uu.getCorF();
      this.Gk.setForeground(var1);
      this.Gk.setText(this.Uu.getNome());
      this.MR.setForeground(var1);
      this.MR.setText(GameConstants.pZ[this.Uu.getReputacao()]);
      ImageIcon var3 = new ImageIcon(this.getClass().getResource("/aflags/" + Integer.toString(this.Uu.getPais()) + ".png"));
      this.Vc.setIcon(var3);
      this.MQ.setForeground(var1);
      String var4 = C0696.valueOf("P" + this.Uu.getPais()).getNome();
      this.MQ.setText(var4);
      if (this.Uu.getPais() == 29) {
         this.MM.setVisible(true);
         this.UX.setVisible(true);
         this.MM.setForeground(var1);
         String var5 = GameConstants.rY[this.Uu.getEstado()];
         this.MM.setText(var5);
         ImageIcon var6 = new ImageIcon(this.getClass().getResource("/aesticons/" + Integer.toString(this.Uu.getEstado()) + ".png"));
         this.UX.setIcon(var6);
      } else {
         this.MM.setVisible(false);
         this.UX.setVisible(false);
      }

      this.UV.setForeground(var1);
      this.UV.setText(this.Uu.getEstadio());
      this.UW.setForeground(var1);
      this.UW.setText(Integer.toString(this.Uu.getCapacidade()) + " lugares");
      this.Vb.setForeground(var1);
      this.Vb.setText(Integer.toString(this.Uu.getNivel()));
      this.MS.setForeground(var1);
      this.MS.setText(this.Uu.getTecnico());
      this.we.setBackground(var2);
      this.UZ.setForeground(var1);
      this.wq();
      this.UY.setForeground(var1);
      this.afS.setForeground(var1);
      this.afS.setText("");
      BufferedImage var15 = null;
      File var16 = new File(C0732.cK + "/teams/escudos/" + this.Uu.getFileRef() + ".png");
      if (var16.exists() && !var16.isDirectory()) {
         try {
            var15 = ImageIO.read(new File(C0732.cK + "/teams/escudos/" + this.Uu.getFileRef() + ".png"));
         } catch (IOException var14) {
            var14.printStackTrace();
         }

         ImageIcon var7 = new ImageIcon(var15);
         this.Fq.setIcon(var7);
      } else {
         this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      }

      File var17 = new File(C0732.cK + "/teams/camisas/" + this.Uu.getFileRef() + ".png");
      if (var17.exists() && !var16.isDirectory()) {
         try {
            var15 = ImageIO.read(new File(C0732.cK + "/teams/camisas/" + this.Uu.getFileRef() + ".png"));
         } catch (IOException var13) {
            var13.printStackTrace();
         }

         this.b(var15);
         ImageIcon var8 = new ImageIcon(var15);
         this.UR.setIcon(var8);
      } else {
         this.UR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
      }

      File var18 = new File(C0732.cK + "/teams/camisas2/" + this.Uu.getFileRef() + ".png");
      if (var18.exists() && !var16.isDirectory()) {
         try {
            var15 = ImageIO.read(new File(C0732.cK + "/teams/camisas2/" + this.Uu.getFileRef() + ".png"));
         } catch (IOException var12) {
            var12.printStackTrace();
         }

         ImageIcon var9 = new ImageIcon(var15);
         this.US.setIcon(var9);
         this.b(var15);
      } else {
         this.US.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
      }

      File var19 = new File(C0732.cK + "/teams/camisas3/" + this.Uu.getFileRef() + ".png");
      if (var19.exists() && !var16.isDirectory()) {
         try {
            var15 = ImageIO.read(new File(C0732.cK + "/teams/camisas3/" + this.Uu.getFileRef() + ".png"));
         } catch (IOException var11) {
            var11.printStackTrace();
         }

         ImageIcon var10 = new ImageIcon(var15);
         this.UT.setIcon(var10);
      } else {
         this.UT.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
      }
   }

   private void wF() {
      this.Vg.getColumnModel().getColumn(0).setPreferredWidth(150);
      this.Vg.getColumnModel().getColumn(1).setPreferredWidth(150);
      this.Vg.getColumnModel().getColumn(2).setPreferredWidth(102);
      this.Vg.setAutoResizeMode(3);
      this.Vg.setShowGrid(false);
      this.Vg.setDefaultRenderer(C0915.class, new C0603());
      this.Vg.setAutoCreateRowSorter(false);
      this.Vg.getTableHeader().setCursor(new Cursor(12));
      this.Vg.setCellSelectionEnabled(false);
      this.Vg.setSelectionMode(2);
      this.Vg.getSelectionModel().addListSelectionListener(new C0848(this));
      this.Vg.setRowSelectionAllowed(true);
      this.Vg.setRowHeight(20);
      this.Vg.setIntercellSpacing(new Dimension(0, 0));
      this.Vg.getTableHeader().setReorderingAllowed(false);
      TableRowSorter var1 = new TableRowSorter<>(this.Vg.getModel());
      this.Vg.setRowSorter(var1);
      var1.setComparator(0, C1007.aaG);
      var1.setComparator(1, C1007.aaE);
      var1.setComparator(2, C1007.aaF);
   }

   public void ah(String string) {
      this.Uc = true;
      this.wO().addNotify();
      this.wO().setRowSelectionInterval(0, 0);
      int var2 = this.Vg.convertRowIndexToModel(this.Vg.getSelectedRow());
      ((C0887)this.Vg.getModel()).et(var2);
      ((C0887)this.Vg.getModel()).fireTableDataChanged();
      if (string != null) {
         C0887 var10000 = (C0887)this.Vg.getModel();
         C0887.eL(0);
         ((C0887)this.Vg.getModel()).ai(string);
      }
   }

   public void an(String string) {
      for (int var2 = 0; var2 < this.Uu.getJogadores().size(); var2++) {
         if (string.length() <= ((C0914)this.Uu.getJogadores().get(var2)).getNome().length()
            && string.equalsIgnoreCase(C0670.f(((C0914)this.Uu.getJogadores().get(var2)).getNome()).substring(0, string.length()))) {
            C0732.da().wJ().changeSelection(var2, 0, true, true);
            C0732.da().wJ().setRowSelectionInterval(var2, var2);
            break;
         }
      }
   }

   public void wG() {
      this.wJ().addNotify();
      this.wJ().setRowSelectionInterval(0, 0);
      int var1 = this.Vg.convertRowIndexToModel(this.Vg.getSelectedRow());
      ((C0887)this.Vg.getModel()).et(var1);
      this.wq();
   }

   public void wH() {
      this.UQ.getColumnModel().getColumn(0).setPreferredWidth(20);
      this.UQ.getColumnModel().getColumn(1).setPreferredWidth(20);
      this.UQ.getColumnModel().getColumn(2).setPreferredWidth(120);
      this.UQ.getColumnModel().getColumn(3).setPreferredWidth(70);
      this.UQ.getColumnModel().getColumn(4).setPreferredWidth(57);
      this.UQ.getColumnModel().getColumn(5).setPreferredWidth(40);
      this.UQ.getColumnModel().getColumn(6).setPreferredWidth(60);
      this.UQ.getColumnModel().getColumn(7).setPreferredWidth(60);
      this.UQ.setAutoResizeMode(3);
      this.UQ.setAutoCreateRowSorter(false);
      this.UQ.setShowGrid(false);
      this.UQ.setDefaultRenderer(String.class, new C0877());
      this.UQ.setDefaultRenderer(Integer.class, new C0877());
      this.UQ.setDefaultRenderer(Icon.class, new C0877());
      this.UQ.setDefaultRenderer(ImageIcon.class, new C0877());
      this.UQ.setDefaultRenderer(Boolean.class, new C0877());
      this.UQ.setSelectionBackground(Color.YELLOW);
      this.UQ.setCellSelectionEnabled(false);
      this.UQ.setSelectionMode(0);
      this.UQ.setRowSelectionAllowed(true);
      this.UQ.setRowHeight(20);
      this.UQ.setIntercellSpacing(new Dimension(0, 0));
      this.UQ.getTableHeader().setReorderingAllowed(false);
   }

   public C0915 wI() {
      return this.Uu;
   }

   public void d(C0915 c0915) {
      this.Uu = c0915;
   }

   public JTable wJ() {
      return this.UQ;
   }

   public void b(JTable jTable) {
      this.UQ = jTable;
   }

   public boolean wK() {
      return this.Uc;
   }

   public void aJ(boolean bl) {
      this.Uc = bl;
   }

   public C0914 wL() {
      return this.Uv;
   }

   public void a(C0914 c0914) {
      this.Uv = c0914;
   }

   public boolean wM() {
      return this.Ux;
   }

   public void aK(boolean bl) {
      this.Ux = bl;
   }

   public boolean wN() {
      return this.Uy;
   }

   public void aL(boolean bl) {
      this.Uy = bl;
   }

   public JTable wO() {
      return this.Vg;
   }

   public JButton wP() {
      return this.UN;
   }

   public JButton wQ() {
      return this.UO;
   }

   public boolean wR() {
      return this.Uz;
   }

   public void aM(boolean bl) {
      this.Uz = bl;
   }

   public C0871 wS() {
      return this.UA;
   }

   private void Ay() {
      C0887 var1 = new C0887();
      this.Vg = new C0862(this, var1);
      this.ut.setViewportView(this.Vg);
   }

   private void mJ() {
      this.vd = new JPanel();
      this.wf = new JPanel();
      this.Ve = new JLabel();
      this.Ej = new JTextField();
      this.UJ = new JButton();
      this.Vd = new JLabel();
      this.Ek = new JTextField();
      this.UK = new JButton();
      this.Va = new JLabel();
      this.UM = new JButton();
      this.UE = new JButton();
      this.UL = new JButton();
      this.ut = new JScrollPane();
      this.Vg = new JTable();
      this.UC = new JButton();
      this.UF = new JButton();
      this.UD = new JButton();
      this.Kc = new JButton();
      this.BZ = new JButton();
      this.we = new JPanel();
      this.wi = new JScrollPane();
      this.UQ = new JTable();
      this.Fq = new JLabel();
      this.UG = new JButton();
      this.UI = new JButton();
      this.UH = new JButton();
      this.UO = new JButton();
      this.UN = new JButton();
      this.UZ = new JLabel();
      this.UY = new JLabel();
      this.UT = new JLabel();
      this.UR = new JLabel();
      this.US = new JLabel();
      this.Gk = new JLabel();
      this.Vc = new JLabel();
      this.MQ = new JLabel();
      this.UX = new JLabel();
      this.MM = new JLabel();
      this.MR = new JLabel();
      this.Vf = new JLabel();
      this.UV = new JLabel();
      this.UU = new JLabel();
      this.MS = new JLabel();
      this.Vb = new JLabel();
      this.UW = new JLabel();
      this.afR = new JButton();
      this.Nq = new JComboBox();
      this.afS = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setBackground(new Color(0, 153, 51));
      this.vd.setBackground(new Color(0, 153, 0));
      this.wf.setBackground(new Color(0, 102, 51));
      this.Ve.setForeground(new Color(255, 255, 255));
      this.Ve.setHorizontalAlignment(4);
      this.Ve.setText("Procurar time:");
      this.Ej.setText("jTextField1");
      this.UJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
      this.UJ.setCursor(new Cursor(12));
      this.Vd.setForeground(new Color(255, 255, 255));
      this.Vd.setHorizontalAlignment(4);
      this.Vd.setText("Procurar jogador:");
      this.Ek.setText("jTextField1");
      this.UK.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
      this.UK.setToolTipText("");
      this.UK.setCursor(new Cursor(12));
      this.Va.setForeground(new Color(255, 255, 255));
      this.Va.setHorizontalAlignment(2);
      this.Va.setText("Mostrar times:");
      this.UM.setText("sem escudo");
      this.UM.setCursor(new Cursor(12));
      this.UE.setText("jogadores duplicados");
      this.UE.setCursor(new Cursor(12));
      this.UL.setText("sem camisas");
      this.UL.setCursor(new Cursor(12));
      GroupLayout var1 = new GroupLayout(this.wf);
      this.wf.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(var1.createParallelGroup(Alignment.TRAILING).addComponent(this.Vd, -2, 132, -2).addComponent(this.Ve, -2, 114, -2))
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.Ej, Alignment.TRAILING, -2, 182, -2)
                                    .addComponent(this.Ek, Alignment.TRAILING, -2, 182, -2)
                              )
                              .addGap(18, 18, 18)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.UJ, Alignment.TRAILING, -2, 59, -2)
                                    .addComponent(this.UK, Alignment.TRAILING, -2, 59, -2)
                              )
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.UM, -2, 125, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.UL, -2, 130, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                          .addComponent(this.UE)
                                    )
                                    .addGroup(var1.createSequentialGroup().addComponent(this.Va, -2, 132, -2).addGap(0, 0, 32767))
                              )
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
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.UK)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Ve).addComponent(this.Ej, -2, -1, -2))
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.UJ)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Vd).addComponent(this.Ek, -2, -1, -2))
                  )
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Va)
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.UM).addComponent(this.UE).addComponent(this.UL))
                  .addContainerGap()
            )
      );
      this.Vg
         .setModel(
            new DefaultTableModel(
               new Object[][]{new Object[4], new Object[4], new Object[4], new Object[4]}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}
            )
         );
      this.ut.setViewportView(this.Vg);
      this.UC.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconadd.png")));
      this.UC.setText("adicionar");
      this.UC.setCursor(new Cursor(12));
      this.UF.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconed.png")));
      this.UF.setText("editar");
      this.UF.setCursor(new Cursor(12));
      this.UD.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icondel.png")));
      this.UD.setText("deletar");
      this.UD.setCursor(new Cursor(12));
      this.Kc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/home.png")));
      this.Kc.setText("início");
      this.Kc.setCursor(new Cursor(12));
      this.BZ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/exit.png")));
      this.BZ.setText("sair jogo");
      this.BZ.setCursor(new Cursor(12));
      GroupLayout var2 = new GroupLayout(this.vd);
      this.vd.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(108, 108, 108)
                  .addComponent(this.Kc, -2, 101, -2)
                  .addGap(46, 46, 46)
                  .addComponent(this.BZ)
                  .addContainerGap(-1, 32767)
            )
            .addGroup(
               var2.createSequentialGroup()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.wf, -1, -1, 32767))
                        .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.ut))
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGap(31, 31, 31)
                              .addComponent(this.UC, -1, -1, 32767)
                              .addGap(18, 18, 18)
                              .addComponent(this.UF, -1, -1, 32767)
                              .addGap(18, 18, 18)
                              .addComponent(this.UD, -1, -1, 32767)
                              .addGap(20, 20, 20)
                        )
                  )
                  .addContainerGap()
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ut)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.UC).addComponent(this.UF).addComponent(this.UD))
                  .addGap(18, 18, 18)
                  .addComponent(this.wf, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.BZ).addComponent(this.Kc))
                  .addGap(26, 26, 26)
            )
      );
      this.we.setBackground(new Color(0, 102, 102));
      this.we.setToolTipText("");
      this.UQ
         .setModel(
            new DefaultTableModel(
               new Object[][]{new Object[4], new Object[4], new Object[4], new Object[4]}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}
            )
         );
      this.wi.setViewportView(this.UQ);
      this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      this.Fq.setCursor(new Cursor(12));
      this.Fq.setName("labescudo");
      this.UG.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ja.png")));
      this.UG.setCursor(new Cursor(12));
      this.UI.setIcon(new ImageIcon(this.getClass().getResource("/aicons/je.png")));
      this.UI.setCursor(new Cursor(12));
      this.UH.setIcon(new ImageIcon(this.getClass().getResource("/aicons/jd.png")));
      this.UH.setCursor(new Cursor(12));
      this.UO.setText("Principal");
      this.UO.setCursor(new Cursor(12));
      this.UN.setText("Juniores");
      this.UN.setCursor(new Cursor(12));
      this.UZ.setForeground(new Color(255, 255, 255));
      this.UZ.setHorizontalAlignment(4);
      this.UZ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_tot.png")));
      this.UZ.setText("25/30");
      this.UY.setForeground(new Color(255, 255, 255));
      this.UY.setHorizontalAlignment(4);
      this.UY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_greensmall.png")));
      this.UY.setText("25");
      this.UT.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
      this.UR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
      this.US.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
      this.Gk.setFont(new Font("Tahoma", 0, 14));
      this.Gk.setForeground(new Color(255, 255, 255));
      this.Gk.setText("Nome do Time");
      this.Vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/paisVazio.png")));
      this.MQ.setForeground(new Color(255, 255, 255));
      this.MQ.setText("pais");
      this.UX.setIcon(new ImageIcon(this.getClass().getResource("/aicons/paisVazio.png")));
      this.MM.setForeground(new Color(255, 255, 255));
      this.MM.setText("estado");
      this.MR.setForeground(new Color(255, 255, 255));
      this.MR.setText("reputação");
      this.Vf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio_icon16.png")));
      this.UV.setForeground(new Color(255, 255, 255));
      this.UV.setText("jLabel1");
      this.UU.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcoach16.png")));
      this.MS.setForeground(new Color(255, 255, 255));
      this.MS.setText("jLabel1");
      this.Vb.setFont(new Font("Tahoma", 0, 18));
      this.Vb.setForeground(new Color(255, 255, 255));
      this.Vb.setText("20");
      this.UW.setForeground(new Color(255, 255, 255));
      this.UW.setText("jLabel1");
      this.afR.setFont(new Font("Tahoma", 0, 12));
      this.afR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ja.png")));
      this.afR.setText("Criar aleatório");
      this.afR.setCursor(new Cursor(12));
      this.Nq.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
      this.afS.setForeground(new Color(255, 255, 255));
      this.afS.setHorizontalAlignment(0);
      this.afS.setText("Adicionado:");
      GroupLayout var3 = new GroupLayout(this.we);
      this.we.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var3.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.wi)
                        .addGroup(
                           var3.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addGroup(
                                 var3.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var3.createSequentialGroup()
                                          .addGroup(
                                             var3.createParallelGroup(Alignment.LEADING)
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addGap(8, 8, 8)
                                                      .addComponent(this.UU)
                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                      .addComponent(this.MS, -2, 105, -2)
                                                )
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addComponent(this.Vf)
                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                      .addGroup(
                                                         var3.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(this.UV, -2, 172, -2)
                                                            .addComponent(this.UW, -2, 172, -2)
                                                      )
                                                )
                                          )
                                          .addGap(50, 50, 50)
                                          .addComponent(this.UR)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addGroup(
                                             var3.createParallelGroup(Alignment.LEADING)
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addComponent(this.US)
                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                      .addComponent(this.UT)
                                                )
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addComponent(this.UO)
                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                      .addComponent(this.UN)
                                                )
                                          )
                                    )
                                    .addGroup(
                                       var3.createSequentialGroup()
                                          .addGroup(
                                             var3.createParallelGroup(Alignment.LEADING)
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addGroup(
                                                         var3.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(this.Gk)
                                                            .addGroup(
                                                               var3.createSequentialGroup()
                                                                  .addComponent(this.Vc)
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(this.MQ, -2, 147, -2)
                                                                  .addGap(18, 18, 18)
                                                                  .addComponent(this.UX)
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(this.MM, -2, 87, -2)
                                                            )
                                                      )
                                                      .addGap(18, 92, 32767)
                                                )
                                                .addGroup(
                                                   var3.createSequentialGroup()
                                                      .addComponent(this.MR, -2, 147, -2)
                                                      .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                                      .addComponent(this.Vb)
                                                      .addGap(28, 28, 28)
                                                )
                                          )
                                          .addComponent(this.Fq, -2, 75, -2)
                                    )
                              )
                        )
                        .addGroup(
                           Alignment.TRAILING,
                           var3.createSequentialGroup()
                              .addComponent(this.UZ)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.UY, -2, 41, -2)
                              .addGap(31, 31, 31)
                              .addComponent(this.UG, -2, 38, -2)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.UI, -2, 38, -2)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.UH, -2, 38, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.afR, -2, 137, -2)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.Nq, -2, -1, -2)
                        )
                        .addGroup(var3.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.afS, -2, 238, -2))
                  )
                  .addContainerGap()
            )
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var3.createSequentialGroup()
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.Fq, -2, 82, -2)
                        .addGroup(
                           var3.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(
                                 var3.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(this.UX)
                                    .addComponent(this.MM)
                                    .addGroup(
                                       var3.createSequentialGroup()
                                          .addComponent(this.Gk)
                                          .addGap(1, 1, 1)
                                          .addGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.MR).addComponent(this.Vb))
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.Vc).addComponent(this.MQ))
                                    )
                              )
                        )
                  )
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var3.createSequentialGroup()
                              .addGap(12, 12, 12)
                              .addGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.UT).addComponent(this.UR).addComponent(this.US))
                        )
                        .addGroup(
                           var3.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addGroup(
                                 var3.createParallelGroup(Alignment.LEADING)
                                    .addGroup(var3.createSequentialGroup().addComponent(this.Vf).addGap(29, 29, 29))
                                    .addGroup(
                                       var3.createSequentialGroup()
                                          .addComponent(this.UV)
                                          .addPreferredGap(ComponentPlacement.RELATED, 31, 32767)
                                          .addComponent(this.UW)
                                          .addGap(18, 18, 18)
                                    )
                              )
                              .addGroup(
                                 var3.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(this.UU)
                                    .addGroup(var3.createParallelGroup(Alignment.BASELINE).addComponent(this.MS).addComponent(this.UO).addComponent(this.UN))
                              )
                        )
                  )
                  .addPreferredGap(ComponentPlacement.RELATED, 18, 32767)
                  .addComponent(this.wi, -2, 451, -2)
                  .addGap(4, 4, 4)
                  .addGroup(
                     var3.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.UG, -1, -1, 32767)
                        .addGroup(var3.createParallelGroup(Alignment.BASELINE).addComponent(this.UZ, -2, 33, -2).addComponent(this.UY))
                        .addComponent(this.UI, -1, -1, 32767)
                        .addComponent(this.UH, -1, -1, 32767)
                        .addComponent(this.afR, -1, -1, 32767)
                        .addComponent(this.Nq)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.afS)
                  .addGap(8, 8, 8)
            )
      );
      GroupLayout var4 = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(var4);
      var4.setHorizontalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.vd, -2, -1, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.we, -2, -1, -2)
                  .addContainerGap(275, 32767)
            )
      );
      var4.setVerticalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var4.createParallelGroup(Alignment.LEADING, false).addComponent(this.vd, -1, -1, 32767).addComponent(this.we, -1, -1, 32767))
                  .addContainerGap(23, 32767)
            )
      );
      this.pack();
   }
}
