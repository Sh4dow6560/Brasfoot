package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class C0294 extends JPanel {
   private JDialog ub;
   private JTable IG = null;
   private String[] IH = new String[]{"Resultados", "Partidas"};
   private String[][] II = new String[][]{
      {"Não usar auto-save", "A cada 3 jogos", "A cada jogo", "Início do ano"},
      {"Lento", "Normal", "Rápido", "Bem rápido", "Super rápido", "Ultra rápido"},
      {"Lento", "Normal", "Rápido", "Bem rápido", "Super rápido", "Ultra rápido"},
      {"Não", "Sim"},
      {"Não", "Sim"},
      {"Não", "Sim"},
      {"Não", "Após término", "Faltando 1 mês"}
   };
   private int IJ = 4;
   private int IK = 4;
   private ArrayList afm = new ArrayList();
   private ArrayList afn = new ArrayList();
   private JButton yV;
   private JButton IM;
   private JButton vm;
   private JButton yZ;
   private JCheckBox IN;
   private JCheckBox IO;
   private JCheckBox IP;
   private JCheckBox IQ;
   private JCheckBox IR;
   private JCheckBox IS;
   private JCheckBox IL;
   private JCheckBox IT;
   private JCheckBox IU;
   private JCheckBox IV;
   private JComboBox IW;
   private JComboBox Ji;
   private JComboBox Jk;
   private JComboBox Jm;
   private JComboBox Jo;
   private JComboBox Jp;
   private JComboBox Jq;
   private JLabel Jr;
   private JLabel Js;
   private JLabel Jt;
   private JLabel Ju;
   private JLabel Jv;
   private JLabel ug;
   private JLabel Bj;
   private JLabel vw;
   private JLabel Ef;
   private JLabel Eg;
   private JLabel Eh;
   private JLabel JD;
   private JLabel a_;
   private JLabel afo;
   private JLabel afp;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;
   private JLabel vz;
   private JLabel vA;
   private JPanel vd;
   private JPanel we;
   private JScrollPane ut;
   private JScrollPane wi;
   private JScrollPane zf;
   private JTable JG;
   private JTable afq;
   private JTable afr;

   public C0294(JDialog jDialog, JTable jTable) {
      this.ub = jDialog;
      this.IG = jTable;
      if (C0745.vL()) {
         this.IJ = 5;
         this.IK = 5;
      }

      this.mJ();
      this.mK();
      this.nc();
      this.AO();
      this.b(this.afq, this.afm);
      this.b(this.afr, this.afn);
      this.mH();
      this.mG();
   }

   private void AO() {
      for (int var1 = 0; var1 < C0745.SR.getVerJint().length; var1++) {
         if (C0745.SR.getVerJint()[var1]) {
            this.afm.add(this.fy(var1));
         } else {
            this.afn.add(this.fy(var1));
         }
      }
   }

   private void fx(int i) {
      C0780 var2 = null;
      if (i == 0) {
         if (this.afq.getSelectedRowCount() > 0) {
            int var3 = this.afq.convertRowIndexToModel(this.afq.getSelectedRow());
            var2 = (C0780)this.afm.get(var3);
         }
      } else if (this.afr.getSelectedRowCount() > 0) {
         int var4 = this.afr.convertRowIndexToModel(this.afr.getSelectedRow());
         var2 = (C0780)this.afn.get(var4);
      }

      if (var2 != null && i == 0) {
         this.afm.remove(var2);
         this.afn.add(var2);
         C0745.vM().setVerJint(false, var2.getIndex());
      } else if (var2 != null) {
         this.afm.add(var2);
         this.afn.remove(var2);
         C0745.vM().setVerJint(true, var2.getIndex());
      }

      this.afq.addNotify();
      this.afr.addNotify();
      C0745.vJ();
   }

   public C0780 fy(int i) {
      byte var2 = 0;
      byte var3 = -1;
      String var4 = "";
      if (i == 11) {
         var2 = 7;
         var3 = 7;
         var4 = "Copa do Mundo";
      } else if (i == 16) {
         var2 = 7;
         var3 = -1;
         var4 = "Copa de Seleções";
      } else if (i == 17) {
         var2 = 9;
         var4 = "Eliminatórias";
      } else if (i == 18) {
         var2 = 14;
         var4 = "Liga de Nações";
      } else if (i == 20) {
         var2 = 13;
         var4 = "Finalíssima";
      } else if (i == 0) {
         var2 = 4;
         var3 = 0;
         var4 = "Liga Camp. Europa";
      } else if (i == 1) {
         var2 = 4;
         var3 = 1;
         var4 = "Libertadores";
      } else if (i == 2) {
         var2 = 4;
         var3 = 2;
         var4 = "Liga Camp. África";
      } else if (i == 3) {
         var2 = 4;
         var3 = 3;
         var4 = "Liga Camp. Ásia";
      } else if (i == 4) {
         var2 = 4;
         var3 = 4;
         var4 = "Liga Camp. Concacaf";
      } else if (i == 5) {
         var2 = 4;
         var3 = 5;
         var4 = "Liga Camp. Oceania";
      } else if (i == 6) {
         var2 = 6;
         var3 = 0;
         var4 = "Liga Europa";
      } else if (i == 7) {
         var2 = 6;
         var3 = 1;
         var4 = "Copa Sul-Americana";
      } else if (i == 14) {
         var2 = 12;
         var3 = 0;
         var4 = "Conference League";
      } else if (i == 19) {
         var2 = 5;
         var4 = "Mundial clubes";
      } else if (i == 12) {
         var2 = 8;
         var4 = "Recopa";
      } else if (i == 8) {
         var2 = 2;
         var4 = "Copa Nacional";
      } else if (i == 9) {
         var2 = 3;
         var4 = "Estadual";
      } else if (i == 10) {
         var2 = 10;
         var4 = "Regional";
      } else if (i == 13) {
         var2 = 11;
         var4 = "Super Copa";
      } else if (i == 15) {
         var2 = 15;
         var4 = "Torneio amistoso";
      }

      return new C0780(var2, var3, var4, i);
   }

   public void mH() {
      this.vm.addActionListener(new C0295(this));
      this.IM.addActionListener(new C0306(this));
      this.IS.addActionListener(new C0311(this));
      this.yV.addActionListener(new C0312(this));
      this.yZ.addActionListener(new C0313(this));
   }

   private void rG() {
      if (this.IS.isSelected()) {
         C0745.vM().setRegionaisSemHumanos(0);
      } else {
         C0745.vM().setRegionaisSemHumanos(1);
      }
   }

   private void b(JTable jTable, ArrayList arrayList) {
      C0613 var3 = new C0613(arrayList);
      jTable.setModel(var3);
      jTable.getColumnModel().getColumn(0).setPreferredWidth(200);
      jTable.getColumnModel().getColumn(0).setMaxWidth(200);
      jTable.setAutoResizeMode(3);
      jTable.setRowHeight(20);
      jTable.setShowGrid(false);
      jTable.setDefaultRenderer(C0780.class, new C0615());
      jTable.setAutoCreateRowSorter(false);
      jTable.getTableHeader().setReorderingAllowed(false);
      jTable.setIntercellSpacing(new Dimension(0, 0));
      jTable.setCellSelectionEnabled(false);
      jTable.setSelectionMode(0);
      jTable.setRowSelectionAllowed(true);
      jTable.setSelectionBackground(Color.YELLOW);
      jTable.setFillsViewportHeight(true);
      jTable.setTableHeader(null);
   }

   private void nc() {
      C0566 var1 = new C0566();
      this.JG.setModel(var1);
      this.JG.getColumnModel().getColumn(0).setPreferredWidth(25);
      this.JG.getColumnModel().getColumn(1).setPreferredWidth(120);
      this.JG.getColumnModel().getColumn(2).setPreferredWidth(70);
      this.JG.setAutoResizeMode(3);
      this.JG.setRowHeight(20);
      this.JG.setShowGrid(false);
      this.JG.setDefaultRenderer(C0692.class, new C0638());
      this.JG.setAutoCreateRowSorter(false);
      this.JG.setCellSelectionEnabled(false);
      this.JG.setSelectionMode(0);
      this.JG.setRowSelectionAllowed(true);
      this.JG.setSelectionBackground(Color.YELLOW);
      this.JG.setFillsViewportHeight(true);
      this.JG.addMouseListener(new C0314(this));
   }

   private void qQ() {
      JDialog var1 = new JDialog(this.ub);
      C0051 var2 = new C0051(var1);
      var1.add(var2);
      var1.setSize(229, 363);
      var1.setPreferredSize(new Dimension(229, 363));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      if (this.IG != null) {
         this.IG.addNotify();
      }
   }

   private void mK() {
      JComboBox[] var1 = new JComboBox[]{this.Jk, this.Jp, this.Jq, this.Ji, this.Jo, this.Jm, this.IW};
      boolean[] var2 = C0745.SR.getVerJint();
      if (C0745.vM().getRegionaisSemHumanos() == 0) {
         this.IS.setSelected(true);
      } else {
         this.IS.setSelected(false);
      }

      for (int var3 = 0; var3 < var1.length; var3++) {
         for (int var4 = 0; var4 < this.II[var3].length; var4++) {
            var1[var3].setName("comb" + Integer.toString(var3));
            if (var3 == 1 && var4 <= this.IJ) {
               var1[var3].addItem(this.II[var3][var4]);
            } else if (var3 == 2 && var4 <= this.IK) {
               var1[var3].addItem(this.II[var3][var4]);
            } else if (var3 == 0 || var3 > 2) {
               var1[var3].addItem(this.II[var3][var4]);
            }
         }

         var1[var3].addActionListener(new C0315(this));
      }

      var1[0].setSelectedIndex(C0745.SR.getAutoSalvar());
      int var5 = C0745.SR.getVelocidade();
      int var6 = C0745.SR.getVelocidadeNH();
      if (var5 > this.IJ) {
         var5 = this.IJ;
      }

      if (var6 >= this.IK) {
         var6 = this.IK;
      }

      var1[1].setSelectedIndex(var5);
      var1[2].setSelectedIndex(var6);
      var1[3].setSelectedIndex(C0745.SR.getVerDecisaoPenNaoHumano());
      var1[4].setSelectedIndex(C0745.SR.getVerMudancaTecnicos());
      var1[5].setSelectedIndex(C0745.SR.getVerJanelaSubs());
      var1[6].setSelectedIndex(C0745.SR.getAvisoTerminoContrato());
      this.IL.setSelected(C0745.SR.isVerLeiloes());
      this.IN.setSelected(C0745.SR.isAutoRenovaContrato());
      this.IO.setSelected(C0745.SR.isUsaCorPlacar());
      this.IV.setSelected(C0745.SR.isUsaSons());
      this.IU.setSelected(C0745.SR.isNegritoCasa());
      this.IP.setSelected(C0745.SR.isUsaCoresLista());
      this.IQ.setSelected(C0745.SR.isVerEstaduaisAgrupados());
      this.IT.setSelected(C0745.SR.isIgnoraLigas());
      this.IR.setSelected(C0745.SR.isIgnoraEstadual());
      this.du(C0745.SR.getCorPlacar());
      this.setCorTema(C0745.vM().getCorTema());
      this.Ef.addMouseListener(new C0316(this));
      this.Eg.addMouseListener(new C0317(this));
      this.Eh.addMouseListener(new C0296(this));
      this.Jr.addMouseListener(new C0297(this));
      this.Js.addMouseListener(new C0298(this));
      this.Jt.addMouseListener(new C0299(this));
      this.Ju.addMouseListener(new C0300(this));
      this.Jv.addMouseListener(new C0301(this));
      this.IL.addActionListener(new C0302(this));
      this.IN.addActionListener(new C0303(this));
      this.IO.addActionListener(new C0304(this));
      this.IV.addActionListener(new C0305(this));
      this.IU.addActionListener(new C0307(this));
      this.IP.addActionListener(new C0308(this));
      this.IQ.addActionListener(new C0309(this));
      this.IT.addActionListener(new C0310(this));
      this.IR.addActionListener(new C0544(this));
   }

   private void db(int i) {
      C0745.vM().setCorPlacar(i);
      C0745.vJ();
      this.du(i);
   }

   private void dt(int i) {
      C0745.vM().setCorTema(i);
      C0745.vJ();
      this.setCorTema(i);
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   private void rH() {
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png"));
      this.Ef.setIcon(var1);
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aiconsc/cor2.png"));
      this.Eg.setIcon(var2);
      ImageIcon var3 = new ImageIcon(this.getClass().getResource("/aiconsc/cor3.png"));
      this.Eh.setIcon(var3);
   }

   private void rI() {
      this.Jr.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/corTema0.png")));
      this.Js.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/corTema1.png")));
      this.Jt.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/corTema2.png")));
      this.Ju.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/corTema3.png")));
      this.Jv.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/corTema4.png")));
   }

   private void du(int i) {
      this.rH();
      JLabel[] var2 = new JLabel[]{this.Ef, this.Eg, this.Eh};
      String[] var3 = new String[]{"cor0s", "cor2s", "cor3s"};
      ImageIcon var4 = new ImageIcon(this.getClass().getResource("/aiconsc/" + var3[i] + ".png"));
      var2[i].setIcon(var4);
   }

   private void setCorTema(int i) {
      this.rI();
      JLabel[] var2 = new JLabel[]{this.Jr, this.Js, this.Jt, this.Ju, this.Jv};
      String[] var3 = new String[]{"corTema0s", "corTema1s", "corTema2s", "corTema3s", "corTema4s"};
      ImageIcon var4 = new ImageIcon(this.getClass().getResource("/aiconsc/" + var3[i] + ".png"));
      var2[i].setIcon(var4);
   }

   private void c(Object object) {
      JComboBox var2 = (JComboBox)object;
      if ("comb0".equals(var2.getName())) {
         C0745.vM().setAutoSalvar(var2.getSelectedIndex());
      } else if ("comb1".equals(var2.getName())) {
         C0745.vM().setVelocidade(var2.getSelectedIndex());
      } else if ("comb2".equals(var2.getName())) {
         C0745.vM().setVelocidadeNH(var2.getSelectedIndex());
      } else if ("comb3".equals(var2.getName())) {
         C0745.vM().setVerDecisaoPenNaoHumano(var2.getSelectedIndex());
      } else if ("comb4".equals(var2.getName())) {
         C0745.vM().setVerMudancaTecnicos(var2.getSelectedIndex());
      } else if ("comb5".equals(var2.getName())) {
         C0745.vM().setVerJanelaSubs(var2.getSelectedIndex());
      } else if ("comb6".equals(var2.getName())) {
         C0745.vM().setAvisoTerminoContrato(var2.getSelectedIndex());
      }

      C0745.vJ();
   }

   private void nH() {
      JComboBox[] var10000 = new JComboBox[]{this.Jk, this.Jp, this.Jq, this.Ji, this.Jo, this.Jm, this.IW};
      C0745.vJ();
   }

   private void mJ() {
      this.vd = new JPanel();
      this.a_ = new JLabel();
      this.Jk = new JComboBox();
      this.ur = new JLabel();
      this.Jp = new JComboBox();
      this.us = new JLabel();
      this.Jq = new JComboBox();
      this.vx = new JLabel();
      this.Ji = new JComboBox();
      this.vy = new JLabel();
      this.Jo = new JComboBox();
      this.vz = new JLabel();
      this.Jm = new JComboBox();
      this.vA = new JLabel();
      this.IW = new JComboBox();
      this.IN = new JCheckBox();
      this.IO = new JCheckBox();
      this.IV = new JCheckBox();
      this.IU = new JCheckBox();
      this.IP = new JCheckBox();
      this.IM = new JButton();
      this.Ef = new JLabel();
      this.Eg = new JLabel();
      this.Eh = new JLabel();
      this.JD = new JLabel();
      this.Jr = new JLabel();
      this.Js = new JLabel();
      this.Jt = new JLabel();
      this.Ju = new JLabel();
      this.Jv = new JLabel();
      this.IL = new JCheckBox();
      this.vm = new JButton();
      this.we = new JPanel();
      this.Bj = new JLabel();
      this.ut = new JScrollPane();
      this.afr = new JTable();
      this.vw = new JLabel();
      this.IQ = new JCheckBox();
      this.IR = new JCheckBox();
      this.IT = new JCheckBox();
      this.IS = new JCheckBox();
      this.wi = new JScrollPane();
      this.JG = new JTable();
      this.afo = new JLabel();
      this.zf = new JScrollPane();
      this.afq = new JTable();
      this.afp = new JLabel();
      this.yZ = new JButton();
      this.yV = new JButton();
      this.ug = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setPreferredSize(new Dimension(800, 567));
      this.setLayout(new C0807());
      this.vd.setBackground(new Color(224, 220, 220));
      this.vd.setLayout(new C0807());
      this.a_.setHorizontalAlignment(4);
      this.a_.setText("Salvar automaticamente:");
      this.vd.add(this.a_, new C0775(10, 23, 204, -1));
      this.vd.add(this.Jk, new C0775(224, 20, 148, -1));
      this.ur.setHorizontalAlignment(4);
      this.ur.setText("Velocidade do Jogo:");
      this.vd.add(this.ur, new C0775(10, 54, 204, -1));
      this.vd.add(this.Jp, new C0775(224, 51, 148, -1));
      this.us.setHorizontalAlignment(4);
      this.us.setText("Velocidade sem jogos humanos:");
      this.vd.add(this.us, new C0775(10, 85, 204, -1));
      this.vd.add(this.Jq, new C0775(224, 82, 148, -1));
      this.vx.setHorizontalAlignment(4);
      this.vx.setText("Disputas de pênaltis sem humanos:");
      this.vd.add(this.vx, new C0775(10, 123, 204, -1));
      this.vd.add(this.Ji, new C0775(224, 120, 148, -1));
      this.vy.setHorizontalAlignment(4);
      this.vy.setText("Mudanças de técnicos:");
      this.vd.add(this.vy, new C0775(10, 154, 204, -1));
      this.vd.add(this.Jo, new C0775(224, 151, 148, -1));
      this.vz.setHorizontalAlignment(4);
      this.vz.setText("Janela de substituição no intervalo:");
      this.vd.add(this.vz, new C0775(10, 192, 204, -1));
      this.vd.add(this.Jm, new C0775(224, 189, 148, -1));
      this.vA.setHorizontalAlignment(4);
      this.vA.setText("Aviso de término de contrato:");
      this.vd.add(this.vA, new C0775(10, 223, 204, -1));
      this.vd.add(this.IW, new C0775(224, 220, 148, -1));
      this.IN.setFont(new Font("Tahoma", 0, 12));
      this.IN.setText("Atualizar automaticamente contratos encerrados");
      this.IN.setOpaque(false);
      this.vd.add(this.IN, new C0775(20, 290, 350, -1));
      this.IO.setFont(new Font("Tahoma", 0, 12));
      this.IO.setText("Cor nos placares humanos:");
      this.IO.setOpaque(false);
      this.vd.add(this.IO, new C0775(20, 330, 200, -1));
      this.IV.setFont(new Font("Tahoma", 0, 12));
      this.IV.setText("Sons nos eventos dos jogos");
      this.IV.setOpaque(false);
      this.vd.add(this.IV, new C0775(20, 370, 265, -1));
      this.IU.setFont(new Font("Tahoma", 0, 12));
      this.IU.setText("Destaque nos eventos do time da casa");
      this.IU.setOpaque(false);
      this.vd.add(this.IU, new C0775(20, 410, 265, -1));
      this.IP.setFont(new Font("Tahoma", 0, 12));
      this.IP.setText("Usar cores na lista de jogadores");
      this.IP.setOpaque(false);
      this.vd.add(this.IP, new C0775(22, 512, 230, -1));
      this.IM.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcor.png")));
      this.IM.setText("cores");
      this.vd.add(this.IM, new C0775(260, 510, -1, -1));
      this.Ef.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png")));
      this.vd.add(this.Ef, new C0775(240, 330, -1, -1));
      this.Eg.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor2.png")));
      this.vd.add(this.Eg, new C0775(280, 330, -1, -1));
      this.Eh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor3s.png")));
      this.vd.add(this.Eh, new C0775(320, 330, -1, -1));
      this.JD.setFont(new Font("Tahoma", 0, 12));
      this.JD.setText("Tema de cores das janelas:");
      this.vd.add(this.JD, new C0775(22, 445, 320, -1));
      this.Jr.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png")));
      this.vd.add(this.Jr, new C0775(60, 467, -1, -1));
      this.Js.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png")));
      this.vd.add(this.Js, new C0775(100, 467, -1, -1));
      this.Jt.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png")));
      this.vd.add(this.Jt, new C0775(140, 467, -1, -1));
      this.Ju.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png")));
      this.vd.add(this.Ju, new C0775(180, 467, -1, -1));
      this.Jv.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cor0.png")));
      this.vd.add(this.Jv, new C0775(220, 467, -1, -1));
      this.IL.setFont(new Font("Tahoma", 0, 12));
      this.IL.setText("Ver leilão de jogadores");
      this.IL.setOpaque(false);
      this.vd.add(this.IL, new C0775(20, 255, 320, -1));
      this.add(this.vd, new C0775(20, 43, 380, 560));
      this.vm.setText("X");
      this.add(this.vm, new C0775(789, 10, 60, -1));
      this.we.setBackground(new Color(224, 220, 220));
      this.we.setLayout(new C0807());
      this.Bj.setFont(new Font("Tahoma", 1, 11));
      this.Bj.setText("Visualizar partidas das ligas mesmo sem times humanos:");
      this.we.add(this.Bj, new C0775(10, 10, -1, -1));
      this.afr.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.ut.setViewportView(this.afr);
      this.we.add(this.ut, new C0775(260, 340, 170, 210));
      this.vw.setFont(new Font("Tahoma", 1, 11));
      this.vw.setHorizontalAlignment(0);
      this.vw.setText("Ver só resultados");
      this.vw.setToolTipText("");
      this.we.add(this.vw, new C0775(240, 320, 170, -1));
      this.IQ.setText("Ver todos os estaduais agrupados");
      this.IQ.setOpaque(false);
      this.we.add(this.IQ, new C0775(10, 260, 304, -1));
      this.IR.setText("Fora do Brasil não mostrar estaduais/regionais");
      this.IR.setOpaque(false);
      this.we.add(this.IR, new C0775(10, 220, 362, -1));
      this.IT.setSelected(true);
      this.IT.setText("Não mostrar rodadas das ligas nacionais não-humanas");
      this.IT.setOpaque(false);
      this.we.add(this.IT, new C0775(10, 200, 362, -1));
      this.IS.setText("Não mostrar regionais que não tiveram humanos");
      this.IS.setOpaque(false);
      this.we.add(this.IS, new C0775(10, 240, 362, -1));
      this.JG.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.wi.setViewportView(this.JG);
      this.we.add(this.wi, new C0775(10, 40, 415, 151));
      this.afo.setFont(new Font("Tahoma", 1, 12));
      this.afo.setText("Competições sem times humanos:");
      this.we.add(this.afo, new C0775(110, 290, -1, -1));
      this.afq.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.zf.setViewportView(this.afq);
      this.we.add(this.zf, new C0775(10, 340, 170, 210));
      this.afp.setFont(new Font("Tahoma", 1, 11));
      this.afp.setHorizontalAlignment(0);
      this.afp.setText("Ver partidas");
      this.we.add(this.afp, new C0775(10, 320, 160, -1));
      this.yZ.setFont(new Font("Tahoma", 1, 11));
      this.yZ.setText("<<");
      this.we.add(this.yZ, new C0775(190, 440, 60, 30));
      this.yV.setFont(new Font("Tahoma", 1, 11));
      this.yV.setText(">>");
      this.we.add(this.yV, new C0775(190, 380, 60, 30));
      this.add(this.we, new C0775(412, 43, 440, 560));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Opções");
      this.add(this.ug, new C0775(29, 14, 240, -1));
   }
}
