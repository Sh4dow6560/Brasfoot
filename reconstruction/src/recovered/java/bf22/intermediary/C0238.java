package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0238 extends JPanel {
   private JFrame Br = null;
   private JDialog FT;
   private int index = 0;
   private int FU = 0;
   private Club FV = null;
   private int FW = 0;
   private ArrayList FX = new ArrayList();
   public static ArrayList FY = new ArrayList();
   int FZ = 0;
   int Ga = -1;
   private static BufferedImage DH = null;
   private JLabel Gb;
   private JLabel Gc;
   private JLabel Gd;
   private JLabel Ge;
   private JTextField Gf;
   private JLabel ug;
   private JLabel uh;
   private JLabel ur;
   private JPanel vd;
   private JPanel we;
   private JPanel wf;
   private JLabel Gg;
   private JLabel Fq;
   private JLabel yA;
   private JLabel Gh;
   private JLabel Gi;
   private JLabel Gj;
   private JLabel Gk;
   private JLabel Gl;
   private JLabel Gm;

   public C0238(JFrame jFrame) {
      this.Br = jFrame;
      this.mJ();
      this.mH();
      this.index = 0;

      for (int var2 = 0; var2 < GamePersistence.careerState.aN().size(); var2++) {
         if (((Club)GamePersistence.careerState.aN().get(var2)).kb() > 0L && ((Club)GamePersistence.careerState.aN().get(var2)).kw() < 35) {
            this.FX.add((Club)GamePersistence.careerState.aN().get(var2));
         }
      }

      this.FV = (Club)this.FX.get(0);
      this.a((C0680)FY.get(0));
      this.pQ();
      this.mY();
      this.Gb.requestFocusInWindow();
   }

   private void mY() {
      this.a((JComponent)this);
      this.a(this.Gb);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0187(this));
   }

   public C0238(JDialog jDialog) {
      this.FT = jDialog;
      this.mJ();
      this.mH();
      this.index = 0;

      for (int var2 = 0; var2 < GamePersistence.careerState.aN().size(); var2++) {
         if (((Club)GamePersistence.careerState.aN().get(var2)).kb() > 0L && ((Club)GamePersistence.careerState.aN().get(var2)).kw() < 35) {
            this.FX.add((Club)GamePersistence.careerState.aN().get(var2));
         }
      }

      this.FV = (Club)this.FX.get(0);
      this.FV = (Club)this.FX.get(0);
      this.a((C0680)FY.get(0));
      this.pQ();
   }

   private void pQ() {
      this.Gg.setIcon(this.FV.kU());
      this.Gg.setText(this.FV.getCoach().dS() + " (" + this.FV.getNome() + ") " + "dinheiro em caixa: " + ClubFinances.c(this.FV.kb()));
   }

   private void a(C0680 c0680) {
      this.Gd.setVisible(false);
      this.Gl.setText("");
      this.Gc.setVisible(true);
      this.Ge.setVisible(true);
      this.Gf.setVisible(true);
      this.yA.setText("");
      this.Gf.setText("1");
      if (this.index == FY.size() - 1) {
         this.uh.setVisible(false);
         this.Gd.setVisible(false);
      } else {
         this.uh.setVisible(true);
         this.uh
            .setText("Próximo leilão: " + GameConstants.rI[((C0680)FY.get(this.index + 1)).iA().getPosicao()] + " - " + ((C0680)FY.get(this.index + 1)).iA().getNome());
      }

      Player var2 = c0680.iA();
      this.FW = (int)Math.round(var2.fk() * 0.5);
      this.Gi.setText("Lance mínimo: " + ClubFinances.c(this.FW));
      this.Gk.setText(var2.getClub().getNome() + " está leiloando o jogador:");
      this.Fq.setIcon(c0680.iA().getClub().kP());
      this.Gj.setText(" " + GameConstants.rI[c0680.iA().getPosicao()] + "(" + GameConstants.rK[c0680.iA().getLado()] + ") - " + c0680.iA().getNome());
      ImageIcon var3 = new ImageIcon(this.getClass().getResource("/aflags/" + c0680.iA().getPais() + ".png"));
      this.Gm.setIcon(var3);
      this.Gm.setText(C0696.bl(c0680.iA().getPais()));
      int[] var4 = new int[6];
      var4 = var2.gw();
      String var5 = "";
      if (var2.isInjured() && var2.getInjuryEndTimeMillis() > ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime()) {
         var5 = "Fim contusão: " + ScheduleDay.a(var2.getInjuryEndTimeMillis());
      }

      String var6 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;" + Integer.toString(var2.getOverallStrength()) + "&nbsp;&nbsp;&nbsp;";
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var6 = "<html>\n<body><p style=\\\"padding:5; font-size:13\\\">\n&nbsp;&nbsp;&nbsp;&nbsp;<b>Gol:</b>"
            + Integer.toString(var2.getGoalkeeping())
            + " <b>Des:</b> "
            + Integer.toString(var2.getTackling())
            + " <b>Arm:</b> "
            + Integer.toString(var2.getPlaymaking())
            + " <b>Fin:</b> "
            + Integer.toString(var2.getFinishing())
            + " <b>Vel:</b> "
            + Integer.toString(var2.getSpeed())
            + " <b>Téc:</b> "
            + Integer.toString(var2.getTechnique())
            + " <br><br><b>Pas:</b>"
            + Integer.toString(var2.getPassing())
            + "&nbsp;&nbsp;&nbsp;";
      }

      String var7 = var6
         + "<b>Idade:</b>"
         + Integer.toString(var2.getIdade())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n"
         + "<b>Jogos:"
         + "</b>&nbsp;"
         + Integer.toString(var4[0])
         + "&nbsp;&nbsp;&nbsp;"
         + "<b>Gols:"
         + "</b>"
         + Integer.toString(var4[1])
         + "&nbsp;&nbsp;&nbsp;"
         + "<b>"
         + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>"
         + "Salário:"
         + "</b>&nbsp;"
         + ClubFinances.c(var2.fj())
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b>Características :"
         + GameConstants.qM[var2.getCr1()]
         + "/"
         + GameConstants.qM[var2.getCr2()]
         + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n"
         + "<b>"
         + var5
         + "<b><br>\n</p>\n</body></html>\n";
      this.Gh.setText(var7);
   }

   private void mH() {
      C0188 var1 = new C0188(this);
      this.Gb.addMouseListener(var1);
      C0189 var2 = new C0189(this);
      this.Gc.addMouseListener(var2);
      C0190 var3 = new C0190(this);
      this.Ge.addMouseListener(var3);
      C0191 var4 = new C0191(this);
      this.Gd.addMouseListener(var4);
      this.Gf.getDocument().addDocumentListener(new C0192(this));
   }

   private void oK() {
      String var1 = this.Gf.getText().toString() + "000";
      if (!var1.equals("") && var1.matches("\\d+") && B(var1) && Integer.parseInt(var1) >= 0) {
         this.Gl.setText(ClubFinances.c(Integer.parseInt(var1)));
         if (Integer.parseInt(var1) > this.FV.kb()) {
            this.Gl.setText("Sem dinheiro para essa oferta");
         }
      } else {
         this.Gl.setText("valor inválido");
      }
   }

   public static boolean B(String string) {
      try {
         Integer.parseInt(string);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      } catch (NullPointerException var3) {
         return false;
      }
   }

   private void pR() {
      String var1 = this.Gf.getText().toString() + "000";
      if (!var1.equals("") && var1.matches("\\d+") && B(var1) && Integer.parseInt(var1) > 0) {
         int var2 = Integer.parseInt(var1);
         if (this.FV.kw() >= 35) {
            this.Gl.setText("Não há vagas no time");
         } else if (var2 < this.FV.kb()) {
            this.dg(var2);
         } else {
            this.Gl.setText("Oferta maior que seu dinheiro em caixa");
         }
      } else {
         this.Gl.setText("valor inválido");
      }
   }

   private void dg(int i) {
      if (i > this.FZ) {
         this.FZ = i;
         this.Ga = this.FU;
      }

      this.pS();
   }

   private void pS() {
      if (this.FU + 1 >= this.FX.size()) {
         this.pT();
      } else {
         this.FU++;
         this.FV = (Club)this.FX.get(this.FU);
         this.pQ();
      }
   }

   private void pT() {
      this.Gc.setVisible(false);
      this.Ge.setVisible(false);
      this.Gf.setVisible(false);
      this.Gl.setText("vendido ao:");
      int var1 = new Random().nextInt(100);
      double var2 = 0.45;
      if (var1 > 60) {
         var2 = 0.62;
      } else if (var1 > 80) {
         var2 = 0.82;
      }

      int var4 = (int)Math.round(this.FW * 2.5);
      int var5 = (int)Math.round(this.FW * var2);
      var5 = var5 + this.FZ + this.FW;
      if (this.FZ < this.FW) {
         this.FZ = var5;
         this.e(((C0680)FY.get(this.index)).iA(), ((C0680)FY.get(this.index)).iz());
      } else {
         Club var6 = null;
         if (this.Ga < this.FX.size()) {
            var6 = (Club)this.FX.get(this.Ga);
            if (this.FZ < var4 && var1 > 50 && ((C0680)FY.get(this.index)).iz() != null) {
               var6 = null;
               this.FZ = var5;
               this.e(((C0680)FY.get(this.index)).iA(), ((C0680)FY.get(this.index)).iz());
            } else {
               this.e(((C0680)FY.get(this.index)).iA(), var6);
            }
         } else {
            this.FZ = var5;
            this.e(((C0680)FY.get(this.index)).iA(), ((C0680)FY.get(this.index)).iz());
         }
      }

      if (this.index + 1 < FY.size()) {
         this.Gd.setVisible(true);
      }
   }

   private void e(Player player, Club club) {
      if (club == null) {
         this.yA.setText("não houve compradores");
      } else {
         this.yA.setText(club.getNome() + " por " + ClubFinances.c(this.FZ));
         player.a(club, this.FZ, false, false, false);
      }
   }

   private void pU() {
      this.pS();
   }

   private void pV() {
      this.index++;
      if (this.index < FY.size()) {
         this.FU = 0;
         this.FV = (Club)this.FX.get(0);
         this.FZ = 0;
         this.Ga = -1;
         this.a((C0680)FY.get(this.index));
         this.pQ();
      }
   }

   private void nx() {
      GamePersistence.careerState.ax();
   }

   private void mJ() {
      this.we = new JPanel();
      this.Fq = new JLabel();
      this.Gk = new JLabel();
      this.Gm = new JLabel();
      this.Gj = new JLabel();
      this.vd = new JPanel();
      this.Gh = new JLabel();
      this.wf = new JPanel();
      this.ur = new JLabel();
      this.Gl = new JLabel();
      this.Gf = new JTextField();
      this.yA = new JLabel();
      this.Gg = new JLabel();
      this.Ge = new JLabel();
      this.Gc = new JLabel();
      this.Gd = new JLabel();
      this.Gi = new JLabel();
      this.uh = new JLabel();
      this.Gb = new JLabel();
      this.ug = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.setLayout(new C0807());
      this.we.setBackground(new Color(71, 148, 50));
      this.we.setBorder(BorderFactory.createLineBorder(new Color(65, 130, 46), 2));
      this.we.setLayout(new C0807());
      this.we.add(this.Fq, new C0775(70, 90, 60, 60));
      this.Gk.setFont(new Font("Tahoma", 0, 18));
      this.Gk.setHorizontalAlignment(0);
      this.Gk.setForeground(new Color(255, 255, 51));
      this.Gk.setText("Cruzeiro está leiloando jogador");
      this.we.add(this.Gk, new C0775(150, 40, 550, 34));
      this.Gm.setHorizontalAlignment(4);
      this.Gm.setText("jLabel8");
      this.we.add(this.Gm, new C0775(470, 100, 150, -1));
      this.Gj.setBackground(new Color(255, 255, 255));
      this.Gj.setFont(new Font("Tahoma", 1, 12));
      this.Gj.setText("jLabel2");
      this.Gj.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.Gj.setOpaque(true);
      this.we.add(this.Gj, new C0775(250, 95, 379, 26));
      this.vd.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vd.setOpaque(false);
      this.vd.setLayout(new C0807());
      this.Gh.setFont(new Font("Tahoma", 0, 12));
      this.Gh
         .setText(
            "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>Força:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Idade:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>Jogos:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Gols:</b>23&nbsp;&nbsp;&nbsp;<b>Cartões:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:</b>&nbsp;5 milhões 300 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Salário:</b>&nbsp; 230 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Marcação/desarme<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Contrato até:</b>&nbsp; 20/12/2015<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>suspenso<br>\n</p>\n</body></html>\n"
         );
      this.Gh.setVerticalAlignment(1);
      this.vd.add(this.Gh, new C0775(10, 10, 410, 180));
      this.we.add(this.vd, new C0775(220, 120, 430, -1));
      this.wf.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.wf.setOpaque(false);
      this.wf.setLayout(new C0807());
      this.ur.setFont(new Font("Tahoma", 0, 12));
      this.ur.setText("Faça sua oferta em milhares de $ ");
      this.wf.add(this.ur, new C0775(20, 80, 240, -1));
      this.Gl.setFont(new Font("Tahoma", 1, 12));
      this.Gl.setHorizontalAlignment(0);
      this.Gl.setText("Sua oferta:");
      this.wf.add(this.Gl, new C0775(10, 160, 420, -1));
      this.wf.add(this.Gf, new C0775(130, 120, 160, 30));
      this.yA.setFont(new Font("Tahoma", 1, 14));
      this.yA.setForeground(new Color(255, 255, 51));
      this.yA.setHorizontalAlignment(0);
      this.yA.setText("jLabel6");
      this.wf.add(this.yA, new C0775(10, 180, 440, 20));
      this.Gg.setFont(new Font("Tahoma", 1, 14));
      this.Gg.setText("jLabel7");
      this.wf.add(this.Gg, new C0775(20, 50, 600, -1));
      this.Ge.setBackground(new Color(65, 130, 46));
      this.Ge.setForeground(new Color(255, 255, 102));
      this.Ge.setHorizontalAlignment(0);
      this.Ge.setText("Não Ofertar");
      this.Ge.setToolTipText("");
      this.Ge.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
      this.Ge.setOpaque(true);
      this.wf.add(this.Ge, new C0775(450, 120, 90, 30));
      this.Gc.setBackground(new Color(65, 130, 46));
      this.Gc.setForeground(new Color(255, 255, 102));
      this.Gc.setHorizontalAlignment(0);
      this.Gc.setText("Ofertar");
      this.Gc.setToolTipText("");
      this.Gc.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
      this.Gc.setOpaque(true);
      this.wf.add(this.Gc, new C0775(340, 120, 90, 30));
      this.Gd.setBackground(new Color(65, 130, 46));
      this.Gd.setForeground(new Color(255, 255, 102));
      this.Gd.setHorizontalAlignment(0);
      this.Gd.setText("Ver próximo leilão");
      this.Gd.setToolTipText("");
      this.Gd.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
      this.Gd.setOpaque(true);
      this.wf.add(this.Gd, new C0775(390, 70, 150, 40));
      this.Gi.setFont(new Font("Tahoma", 1, 14));
      this.Gi.setForeground(new Color(255, 255, 153));
      this.Gi.setHorizontalAlignment(0);
      this.Gi.setText("Lance inicial:");
      this.wf.add(this.Gi, new C0775(100, 20, 440, -1));
      this.we.add(this.wf, new C0775(120, 310, 640, 210));
      this.uh.setFont(new Font("Tahoma", 1, 12));
      this.uh.setText("Próximo jogador em leilão:");
      this.we.add(this.uh, new C0775(130, 530, 450, -1));
      this.Gb.setBackground(new Color(65, 130, 46));
      this.Gb.setForeground(new Color(255, 255, 102));
      this.Gb.setHorizontalAlignment(0);
      this.Gb.setText("Continuar Jogo >>");
      this.Gb.setToolTipText("");
      this.Gb.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
      this.Gb.setOpaque(true);
      this.we.add(this.Gb, new C0775(610, 540, 150, 40));
      this.add(this.we, new C0775(30, 60, 870, 610));
      this.ug.setBackground(new Color(65, 130, 46));
      this.ug.setFont(new Font("Tahoma", 1, 18));
      this.ug.setForeground(new Color(255, 255, 51));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Venda de jogador em leilão");
      this.ug.setOpaque(true);
      this.add(this.ug, new C0775(210, 30, 503, 30));
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      try {
         DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f02.jpg"));
      } catch (IOException var3) {
      }

      Dimension var2 = this.getSize();
      super.paintComponent(graphics);
      graphics.drawImage(DH, 0, 0, var2.width, var2.height, null);
   }

   public static void X(ArrayList arrayList) {
      FY = arrayList;
   }
}
