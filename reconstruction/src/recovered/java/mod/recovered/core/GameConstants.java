package mod.recovered.core;

import bf22.intermediary.*;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class GameConstants {
   public static final Color or = new Color(12, 54, 77);
   public static final Color os = new Color(7, 28, 39);
   public static final Color ot = new Color(27, 70, 38);
   public static final Color ou = new Color(27, 50, 24);
   public static final int Kd = 2029;
   public static final int Kk = 2129;
   public static final int Ko = 2229;
   public static final int Kp = 2329;
   public static final int Kq = 2429;
   public static final int Kr = 2529;
   public static final int Ks = 2629;
   public static final int Kt = 2729;
   public static final int Ku = 1099;
   public static final int Kv = 1098;
   public static final int Kw = 1020;
   public static final int Kx = 1022;
   public static final int ox = 1068;
   public static final int oy = 1403;
   public static final int Ky = 7700;
   public static final int Mn = 7701;
   public static final int Na = 9193;
   public static final int Nb = 9495;
   public static final int UP = 9400;
   public static final int Zh = 9401;
   public static final int aah = 9402;
   public static final int abo = 9001;
   public static final int abp = 9002;
   public static final int abq = 9500;
   public static final int abr = 9501;
   public static final int abs = 9502;
   public static final int abt = 9100;
   public static final int abu = 9200;
   public static final int abv = 9201;
   public static final int abw = 9202;
   public static final int abx = 9300;
   public static final int aby = 9301;
   public static final int abz = 9302;
   public static final int abA = 9303;
   public static final int oz = 4000;
   public static final int oA = 4001;
   public static final int oB = 4002;
   public static final int oC = 4003;
   public static final int oD = 4004;
   public static final int oE = 4005;
   public static final int oF = 6000;
   public static final int oG = 6001;
   public static final int oH = 6002;
   public static final int oI = 6003;
   public static final int oJ = 6004;
   public static final int oK = 6005;
   public static final int abB = 6006;
   public static final int abC = 12001;
   public static final int abD = 12002;
   public static final int abE = 12003;
   public static final int abF = 12004;
   public static final int abG = 12005;
   public static final int abH = 12006;
   public static final int abI = 14001;
   public static final int abJ = 14002;
   public static final int abK = 14003;
   public static final int abL = 14004;
   public static final int abM = 14005;
   public static final int abN = 14006;
   public static final int abO = 14401;
   public static final int abP = 14402;
   public static final int abQ = 14403;
   public static final int abR = 14404;
   public static final int abS = 14405;
   public static final int oL = 4101;
   public static final int oM = 4102;
   public static final int oN = 4103;
   public static final int oO = 4104;
   public static final int oP = 500000;
   public static final int oQ = 1000000;
   public static final int oR = 300000;
   public static final int oS = 500000;
   public static final int oT = 6100;
   public static final int oU = 6105;
   public static final int oV = 0;
   public static final int oW = 1;
   public static final int abT = 1090;
   public static final int abU = 1091;
   public static final int abV = 51;
   public static final int oX = 1001;
   public static final int[][] oY = new int[][]{new int[3], {19, 4, 156}, {134, 15, 20}};
   public static final int[][] oZ = new int[][]{{148, 148, 73}, {179, 179, 100}, {192, 192, 129}, {209, 209, 163}, {222, 222, 188}};
   public static final int[][] pa = new int[][]{
      {18000, 80000, 9000, 700}, {20000, 100000, 10000, 800}, {22000, 110000, 10000, 900}, {25000, 120000, 10000, 1200}
   };
   public static final String[] pb = new String[]{"Excelente", "Muito Boa", "Ruim", "Precária"};
   public static final String[] pc = new String[]{"campo2", "campo", "campo3", "campo4"};
   public static final String[] pd = new String[]{"campo_diminuido2", "campo_diminuido", "campo_diminuido3", "campo_diminuido4"};
   public static final String[][] pe = new String[][]{
      {"flarj", "botafogorj_bra"},
      {"flarj", "vasco"},
      {"flarj", "flurj"},
      {"flurj", "vasco"},
      {"vasco", "botafogorj_bra"},
      {"botafogorj_bra", "flurj"},
      {"santos", "corinthians_bra"},
      {"santos", "palmeiras"},
      {"santos", "saopaulo_bra"},
      {"corinthians_bra", "palmeiras"},
      {"corinthians_bra", "saopaulo_bra"},
      {"palmeiras", "saopaulo_bra"},
      {"atleticomg_bra", "cruzeiro_bra"},
      {"gremio", "internacional_bra"},
      {"bahia", "vitoria"},
      {"atleticopr_bra", "coritiba_bra"},
      {"atleticogo_bra", "goias"},
      {"sport", "nautico"},
      {"sport", "santa"},
      {"nautico", "santa"},
      {"paysandu", "remo"},
      {"fortaleza", "ceara_bra"},
      {"guaranisp_bra", "pontepreta_bra"},
      {"csa_bra", "crb_bra"},
      {"abcrn_bra", "americarn"},
      {"bocajuniors_arg", "riverplate_arg"},
      {"racing_arg", "independiente_arg"},
      {"barcelona_esp", "realmadrid_esp"},
      {"americacali_col", "nacional_col"},
      {"cerroporteno_par", "olimpia_par"},
      {"nacional_uru", "penarol_uru"},
      {"caracas_ven", "deptachira_ven"},
      {"universidadchile_chi", "colocolo_chi"},
      {"parissaintgermain_fr", "olympiquemarseile_fra"},
      {"figueirense", "avai_bra"}
   };
   public static final int pf = 1;
   public static final int pg = 4;
   public static final int ph = 5;
   public static final int pi = 2;
   public static final int pj = 6;
   public static final int pk = 3;
   public static final int pl = 301;
   public static final int pm = 302;
   public static final int pn = 306;
   public static final int po = 101;
   public static final int pp = 102;
   public static final int pq = 106;
   public static final int abW = 12000;
   public static final String[] pr = new String[]{"branco", "verde", "amarelo", "verm", "azul", "azul2", "amarelo2"};
   public static final String[] ps = new String[]{"Preliminar 1", "Preliminar 2", "Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"};
   public static final String[] pt = new String[]{"Primeira fase", "Segunda fase", "Terceira fase", "Oitavas", "Quartas", "Semifinal", "Final"};
   public static final String[] pu = new String[]{"chave ", "jogo ", "Pré-Oit ", "Oit - ", "Qua - ", "Semi - ", "Decisão"};
   public static final String[] pv = new String[]{"jogo", "jogo", "jogo ", "sorteio", "Oit - ", "Qua - ", "Semi - ", "Decisão"};
   public static final String[] pw = new String[]{"Rodada 1", "Rodada 2", "Rodada 3", "Rodada 4", "Rodada 5", "Rodada 6"};
   public static final String[] px = new String[]{"Fase Preliminar", "Primeira Fase", "Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"};
   public static final String[] py = new String[]{"Primeira Fase", "Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"};
   public static final String[] pz = new String[]{"Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"};
   public static final String[] pA = new String[]{"Oitavas", "Quartas", "Semifinal", "Final"};
   public static final String[] pB = new String[]{"Quartas", "Semifinal", "Final"};
   public static final String[] pC = new String[]{"Semifinal", "Final"};
   public static final String[] pD = new String[]{"Decisão"};
   public static final String[] pE = new String[]{"Fase Preliminar"};
   public static final String[] pF = new String[]{"Semifinal", "Final e decisão terceiro lugar"};
   public static final String[] pG = new String[]{"Pré-Preliminar"};
   public static final String[] pH = new String[]{"Pré-Preliminar R1", "Pré-Preliminar R2"};
   public static final String[] pI = new String[]{"Preliminar 1"};
   public static final String[] pJ = new String[]{"Preliminar 2"};
   public static final String[] pK = new String[]{"Preliminar 3"};
   public static final String[] pL = new String[]{"Preliminar 4"};
   public static final String[] pM = new String[]{"Pré-qualificatório"};
   public static final String[] pN = new String[]{"Qualificatório 1"};
   public static final String[] pO = new String[]{"Qualificatório 2"};
   public static final String[] pP = new String[]{"Qualificatório 3"};
   public static final String[] pQ = new String[]{"Qualificatório 4"};
   public static final String[] pR = new String[]{"Preliminar Fase 1"};
   public static final String[] pS = new String[]{"Preliminar Fase 2"};
   public static final String[] pT = new String[]{"Preliminar Fase 3"};
   public static final String[] abX = new String[]{"Play off rebaixamento"};
   public static final String pU = "Qualquer";
   public static final String pV = "Internacional";
   public static final String[] pW = new String[]{"Preliminar"};
   public static final String[] pX = new String[]{"Decisão da Vaga"};
   public static final String[] abY = new String[]{"Pré-Oitavas"};
   public static final String[] abZ = new String[]{"Qualificatório 1"};
   public static final String[] aca = new String[]{"Qualificatório 2"};
   public static final String[] acb = new String[]{"Qualificatório 3"};
   public static final String[] acc = new String[]{"Qualificatório 4"};
   public static final String[] pY = new String[]{"Rio-SP", "Sul-Minas", "Copa do Nordeste", "Copa Verde"};
   public static final String[] pZ = new String[]{"Municipal", "Estadual", "Regional", "Nacional", "Continental", "Mundial"};
   public static final int qa = 0;
   public static final int qb = 1;
   public static final int qc = 2;
   public static final int qd = 3;
   public static final int qe = 4;
   public static final int qf = 5;
   public static final int[] qg = new int[]{1, 40, 30, 20, 5};
   public static final int[] qh = new int[]{1, 10, 20, 40, 50, 55};
   public static final int[] qi = new int[]{20, 30, 45, 85, 100, 100};
   public static final int qj = 10;
   public static final int[] qk = new int[]{255, 255, 255};
   public static final int[] ql = new int[3];
   public static final int[] qm = new int[]{215, 0, 0};
   public static final int[] qn = new int[]{153, 0, 0};
   public static final int[] qo = new int[]{241, 10, 33};
   public static final int[] qp = new int[]{255, 51, 51};
   public static final int[] qq = new int[]{0, 0, 98};
   public static final int[] qr = new int[]{38, 57, 106};
   public static final int[] qs = new int[]{5, 49, 122};
   public static final int[] qt = new int[]{51, 99, 156};
   public static final int[] qu = new int[]{8, 81, 164};
   public static final int[] qv = new int[]{51, 168, 205};
   public static final int[] qw = new int[]{51, 51, 0};
   public static final int[] qx = new int[]{106, 104, 113};
   public static final int[] qy = new int[]{20, 92, 20};
   public static final int[] qz = new int[]{2, 108, 62};
   public static final int[] qA = new int[]{237, 202, 63};
   public static final int[] qB = new int[]{225, 225, 0};
   public static final int[] qC = new int[]{255, 255, 128};
   public static final int qD = 8;
   public static final String qE = "Fase Preliminar";
   public static final String qF = "Fase de Grupos";
   public static final String acd = "Fase Intermediária";
   public static final String qG = "Primeira Fase";
   public static final String qH = "Segunda Fase";
   public static final String qI = "Fase Final";
   public static final String ace = "Final";
   public static final String qJ = "Repescagem";
   public static final String acf = "Play-offs";
   public static final String acg = "Pré-repescagem";
   public static final String ach = "Torneio Repescagem";
   public static final String aci = "Mata-mata vagas ascenso";
   public static final String acj = "Playoff";
   public static final String ack = "Tabela Liga";
   public static final int[][][] qK = new int[][][]{
      {{5, 15, 20, 30}, {3, 12, 15, 25}},
      {{3, 12, 15, 30}, {10, 15, 25, 80}, {7, 13, 20, 70}, {5, 12, 17, 40}, {3, 12, 15, 30}},
      {{3, 12, 15, 30}, {3, 12, 15, 30}, {3, 12, 15, 30}, {7, 13, 20, 70}, {10, 15, 25, 80}, {10, 15, 25, 80}},
      {{3, 5, 12, 20}, {3, 12, 15, 30}, {3, 12, 15, 30}, {5, 12, 20, 50}, {10, 15, 25, 70}, {10, 15, 25, 70}},
      {{30, 45, 65, 200}, {20, 35, 55, 150}},
      {new int[4]},
      {{20, 25, 45, 150}, {20, 25, 40, 120}},
      {new int[4]},
      {{20, 25, 45, 150}, {20, 25, 40, 120}}
   };
   public static final int qL = 20;
   public static final String[] qM = new String[]{
      "Colocação",
      "Defesa Penalty",
      "Reflexo",
      "Saída Gol",
      "Armação",
      "Cabeceio",
      "Cruzamento",
      "Desarme",
      "Drible",
      "Finalização",
      "Marcação",
      "Passe",
      "Resistência",
      "Velocidade"
   };
   public static final String[] qN = new String[]{"Col", "DPe", "Ref", "SGo", "Arm", "Cab", "Cru", "Des", "Dri", "Fin", "Mar", "Pas", "Res", "Vel"};
   public static final int qO = 3;
   public static final int acl = 4;
   public static final int acm = 2;
   public static final int acn = 9;
   public static final int qP = 11;
   public static final int aco = 12;
   public static final int acp = 14;
   public static final int acq = 15;
   public static final int acr = 16;
   public static final int acs = 25;
   public static final int qQ = 21;
   public static final int qR = 26;
   public static final int qS = 31;
   public static final int act = 27;
   public static final int qT = 29;
   public static final int acu = 36;
   public static final int acv = 39;
   public static final int acw = 40;
   public static final int qU = 42;
   public static final int acx = 44;
   public static final int qV = 46;
   public static final int acy = 49;
   public static final int qW = 52;
   public static final int acz = 54;
   public static final int qX = 60;
   public static final int acA = 62;
   public static final int acB = 63;
   public static final int acC = 64;
   public static final int qY = 65;
   public static final int acD = 66;
   public static final int acE = 70;
   public static final int qZ = 72;
   public static final int acF = 75;
   public static final int acG = 76;
   public static final int acH = 216;
   public static final int acI = 78;
   public static final int acJ = 85;
   public static final int acK = 88;
   public static final int acL = 98;
   public static final int acM = 92;
   public static final int acN = 100;
   public static final int acO = 101;
   public static final int acP = 102;
   public static final int acQ = 103;
   public static final int ra = 97;
   public static final int rb = 104;
   public static final int acR = 107;
   public static final int acS = 110;
   public static final int acT = 114;
   public static final int acU = 118;
   public static final int acV = 119;
   public static final int acW = 120;
   public static final int acX = 122;
   public static final int acY = 129;
   public static final int acZ = 134;
   public static final int ada = 128;
   public static final int adb = 135;
   public static final int adc = 105;
   public static final int add = 142;
   public static final int ade = 145;
   public static final int rc = 150;
   public static final int rd = 151;
   public static final int re = 152;
   public static final int rf = 154;
   public static final int adf = 159;
   public static final int adg = 160;
   public static final int rg = 162;
   public static final int adh = 164;
   public static final int adi = 169;
   public static final int adj = 171;
   public static final int adk = 179;
   public static final int adl = 180;
   public static final int adm = 190;
   public static final int rh = 192;
   public static final int adn = 193;
   public static final int ri = 195;
   public static final int rj = 198;
   public static final int ado = 6;
   public static final int adp = 7;
   public static final int adq = 8;
   public static final int adr = 13;
   public static final int ads = 17;
   public static final int adt = 20;
   public static final int adu = 22;
   public static final int adv = 24;
   public static final int adw = 221;
   public static final int adx = 38;
   public static final int ady = 51;
   public static final int adz = 53;
   public static final int adA = 56;
   public static final int adB = 58;
   public static final int adC = 68;
   public static final int adD = 77;
   public static final int adE = 79;
   public static final int adF = 80;
   public static final int adG = 84;
   public static final int adH = 86;
   public static final int adI = 90;
   public static final int adJ = 91;
   public static final int adK = 94;
   public static final int adL = 106;
   public static final int adM = 131;
   public static final int adN = 139;
   public static final int adO = 147;
   public static final int adP = 153;
   public static final int adQ = 158;
   public static final int adR = 165;
   public static final int adS = 166;
   public static final int adT = 168;
   public static final int adU = 181;
   public static final int adV = 189;
   public static final int adW = 211;
   public static final int adX = 212;
   public static final int adY = 213;
   public static final int adZ = 217;
   public static final int aea = 219;
   public static final int aeb = 220;
   public static final int aec = 222;
   public static final int aed = 223;
   public static final int aee = 69;
   public static final int aef = 91;
   public static final int aeg = 93;
   public static final int aeh = 143;
   public static final int aei = 148;
   public static final int aej = 163;
   public static final int aek = 184;
   public static final int ael = 197;
   public static final int aem = 203;
   public static final int aen = 204;
   public static final int aeo = 206;
   public static final int aep = 207;
   public static final int aeq = 208;
   public static final int aer = 210;
   public static final int aes = 214;
   public static final int aet = 215;
   public static final int aeu = 218;
   public static final int aev = 188;
   public static final int rk = 0;
   public static final int rl = 1;
   public static final int rm = 2;
   public static final int rn = 3;
   public static final int ro = 4;
   public static final int rp = 5;
   public static final int rq = 6;
   public static final int rr = 7;
   public static final int rs = 8;
   public static final int rt = 9;
   public static final int ru = 10;
   public static final int rv = 11;
   public static final int rw = 12;
   public static final int rx = 13;
   public static final int ry = 1;
   public static final int[] rz = new int[]{2000, 1200, 700, 450, 220, 100};
   public static final int[] rA = new int[]{1200, 700, 300, 100, 70, 30};
   public static final String[] rB = new String[]{
      "Selecione opção",
      "Resetar tudo",
      "5-4-1",
      "5-3-2",
      "4-5-1",
      "4-4-2",
      "4-4-2 def",
      "4-4-2 Ofen.",
      "4-3-3",
      "4-3-3 def",
      "3-5-2",
      "3-4-3",
      "4-2-3-1",
      "4-2-3-1 Alas"
   };
   public static final String[] rC = new String[]{"Equilibrado", "Ataque total", "Contra-ataque"};
   public static final String[] rD = new String[]{"Pelo meio", "Pelas laterais"};
   public static final String[] rE = new String[]{"Leve", "Pesada", "Muito pesada"};
   public static final String[] rF = new String[]{"", "Dom", "Seg", "ter", "qua", "qui", "sex", "sab"};
   public static final int rG = 4;
   public static final String[] rH = new String[]{
      C0679.getString("gk"), C0679.getString("lat"), C0679.getString("zag"), C0679.getString("meia"), C0679.getString("ata")
   };
   public static final String[] rI = new String[]{"G", "L", "Z", "M", "A"};
   public static final int rJ = 0;
   public static final int LE = 1;
   public static final String[] rK = new String[]{"D", "E"};
   public static final String[] rL = new String[]{"Direito", "Esquerdo"};
   public static final int aew = 1;
   public static final int H = 2;
   public static final int aex = 3;
   public static final int J = 4;
   public static final int aey = 5;
   public static final int L = 6;
   public static final int ht = 12;
   public static final int M = 7;
   public static final int aez = 8;
   public static final int rN = 9;
   public static final int aeA = 10;
   public static final int Q = 11;
   public static final int hx = 13;
   public static final int ov = 14;
   public static final int aeB = 15;
   public static final int rO = 14;
   public static final int rP = 0;
   public static final int rQ = 1;
   public static final int rR = 2;
   public static final int rS = 3;
   public static final int rT = 4;
   public static final int rU = 5;
   public static final int rV = 7;
   public static final int aeC = -1;
   public static final int aeD = 70;
   public static final int[] rW = new int[]{3, 72, 104, 97, 65};
   public static final String aeE = "Classificatório Eurocopa";
   public static final String[] aeF = new String[]{"Eurocopa", "Copa América", "Copa África", "Copa Ásia", "Copa Ouro", "Copa OFC", "", "Copa do Mundo"};
   public static final String[] rX = new String[]{
      "AC",
      "AL",
      "AM",
      "AP",
      "BA",
      "CE",
      "DF",
      "ES",
      "GO",
      "MA",
      "MG",
      "MS",
      "MT",
      "PA",
      "PB",
      "PE",
      "PI",
      "PR",
      "RJ",
      "RN",
      "RO",
      "RR",
      "RS",
      "SC",
      "SE",
      "SP",
      "TO"
   };
   public static final String[] rY = new String[]{
      "Acre",
      "Alagoas",
      "Amazonas",
      "Amapá",
      "Bahia",
      "Ceará",
      "Distrito Federal",
      "Espírito Santo",
      "Goiás",
      "Maranhão",
      "Minas Gerais",
      "Mato Grosso Sul",
      "Mato Grosso",
      "Pará",
      "Paraíba",
      "Pernambuco",
      "Piauí",
      "Paraná",
      "Rio de Janeiro",
      "Rio Grande Norte",
      "Rondonia",
      "Roraima",
      "Rio Grande Sul",
      "Santa Catarina",
      "Sergipe",
      "São Paulo",
      "Tocantins"
   };
   public static final String[] rZ = new String[]{
      "Acreano",
      "Alagoano",
      "Amazonense",
      "Amapaense",
      "Baiano",
      "Cearense",
      "Brasiliense",
      "Capixaba",
      "Goiano",
      "Maranhense",
      "Mineiro",
      "Sul-matogrossense",
      "Matogrossense",
      "Paraense",
      "Paraibano",
      "Pernambucano",
      "Piauiense",
      "Paranaense",
      "Carioca",
      "Potiguar",
      "Rondonense",
      "Roraimense",
      "Gaúcho",
      "Catarinense",
      "Sergipano",
      "Paulista",
      "Tocantinense"
   };
   public static final String[] sa = new String[]{"Europa", "América do Sul", "África", "Ásia", "Concacaf", "Oceania"};
   public static final String url = "http://www.cyberfoot.org/fixtures.html";
   public static final int[] sb = new int[]{25, 18, 10, 22};
   public static final int[] sc = new int[]{17, 23, 4, 15, 5};
   public static final int[] sd = new int[]{8, 1, 13, 11, 9, 19, 14};
   public static final int[] se = new int[]{24, 0, 16, 12, 2, 6};
   public static final int[] sf = new int[]{7, 26, 20, 3, 21};
   public static final String[] sg = new String[]{
      "você solicitou a demissão.",
      "você estava levando o clube para o abismo financeiro.",
      "a pressão da torcida estava grande pelos maus resultados.",
      "seus resultados não agradaram nem a torcida nem a diretoria."
   };
   public static final String[] sh = new String[]{"", "Crise financeira", "Pressão torcida", "Maus resultados"};
   public static final int si = 120000;
   public static final boolean[] sj = new boolean[]{true, true, true, true, true, true};
   public static final int sk = 20;
   public static final int sl = 35;
   public static final int sn = 32;
   public static final int sm = 4;
   public static final int so = 10;
   public static final int sp = 15;
   public static final int sq = 30;
   public static final int[][] sr = new int[][]{
      new int[6],
      {5000000, 3500000, 2000000, 1500000, 1000000, 500000},
      {2500000, 2000000, 1000000, 500000, 250000, 100000},
      {1500000, 1000000, 500000, 300000, 150000, 75000},
      {750000, 500000, 300000, 200000, 100000, 50000}
   };
   public static final int[] ss = new int[]{1000000, 2000000, 4000000, 5000000, 7000000, 15000000, 20000000, 25000000};
   public static final int[][] st = new int[][]{
      new int[6],
      {100000, 100000, 400000, 500000, 700000, 700000, 700000, 700000},
      {100000, 100000, 400000, 500000, 700000, 700000, 700000, 700000},
      {100000, 100000, 400000, 500000, 700000, 700000, 700000, 700000},
      {100000, 100000, 400000, 500000, 700000, 700000, 700000, 700000}
   };
   public static final int[] su = new int[]{700000, 500000, 300000, 100000};
   public static final int[] sv = new int[]{100000, 100000, 400000};
   public static final int[][] sw = new int[][]{
      {2000000, 5000000, 7000000, 25000000, 30000000, 0},
      {2000000, 3500000, 5000000, 20000000, 40000000, 0},
      {500000, 1500000, 2000000, 4000000, 40000000, 0},
      {500000, 1500000, 2000000, 4000000, 40000000, 0},
      {500000, 1500000, 2000000, 4000000, 40000000, 0},
      {200000, 500000, 1000000, 2000000, 20000000, 0}
   };
   public static final int[] sx = new int[]{2000000, 5000000, 7000000};
   public static final int[][] sy = new int[][]{{500000, 700000, 2000000, 2500000, 7000000, 0}, {500000, 1000000, 1500000, 5000000, 5000000, 0}};
   public static final int[] sz = new int[]{1000000, 1500000};
   public static final int[] sA = new int[]{1000000, 500000};
   public static final int[][] aeG = new int[][]{{500000, 700000, 2000000, 2500000, 7000000, 0}, {500000, 1000000, 1500000, 5000000, 5000000, 0}};
   public static final int[][] sB = new int[][]{{3, 12, 15, 25}, {10, 15, 25, 80}, {7, 13, 20, 70}, {5, 12, 17, 40}, {3, 12, 15, 30}, {3, 12, 15, 30}};
   public static final long[][] initialCashByDivision = new long[][]{
      {3500000L, 2000000L}, {15000000L, 12000000L}, {12000000L, 10000000L}, {10000000L, 7000000L}, {3500000L, 3000000L}
   };
   public static final int[][] sponsorshipRevenueByDivision = new int[][]{{3500000, 3500000}, {6000000, 6000000}, {4500000, 4500000}, {2500000, 2500000}, {2000000, 2000000}};
   public static final int[][] sE = new int[][]{
      {0, -1, -1},
      {0, -1, -1},
      {1, 1, -1},
      {2, 1, -1},
      {2, -1, -1},
      {2, 0, -1},
      {2, 1, -1},
      {2, -1, -1},
      {2, 0, -1},
      {1, 0, -1},
      {1, 1, 1},
      {3, 1, 0},
      {3, -1, 0},
      {3, 0, 0},
      {3, 1, 1},
      {3, -1, 1},
      {3, 0, 1},
      {1, 1, 0},
      {4, 1, 2},
      {4, 1, -1},
      {4, -1, -1},
      {4, 0, -1},
      {4, 1, -1},
      {4, -1, -1},
      {4, 0, -1},
      {4, 0, 2}
   };
   public static final int[][] sF = new int[][]{
      {-1, -1, -1},
      {1, -1, -1},
      {3, 6, -1},
      {2, 3, -1},
      {2, -1, -1},
      {2, 1, -1},
      {2, 3, -1},
      {2, -1, -1},
      {2, 1, -1},
      {1, 4, -1},
      {6, 9, -1},
      {5, 6, -1},
      {5, -1, -1},
      {5, 4, -1},
      {8, 9, -1},
      {8, -1, -1},
      {8, 7, -1},
      {4, 7, -1},
      {12, -1, -1},
      {11, 12, -1},
      {11, -1, -1},
      {11, 10, -1},
      {11, 12, -1},
      {11, -1, -1},
      {11, 10, -1},
      {10, -1, -1}
   };
   public static final int[] sG = new int[]{0, 3, 6, 3, 3, 3, 3, 2, 3, 2, 3, 6, 3};
   public static final int[][] sH = new int[][]{{0, 2, 1, 3, 4}, {1, 3, 2, 4, 0}, {2, 1, 3, 4, 0}, {3, 1, 2, 4, 0}, {4, 3, 1, 2, 0}};
   public static final int[] sI = new int[]{1, 1, 2, 4, 4, 12, 15, 15, 20, 20, 23};
   public static final int[][] sJ = new int[][]{
      {1, 20, 11, 13, 14, 16, 2, 9, 6, 4, 8},
      {1, 20, 11, 13, 14, 16, 2, 9, 6, 4, 8},
      {1, 22, 24, 12, 14, 16, 2, 9, 6, 4, 8},
      {1, 23, 11, 13, 15, 2, 9, 6, 8, 10, 17},
      {1, 22, 24, 11, 13, 14, 16, 2, 9, 3, 5},
      {1, 19, 21, 11, 12, 13, 15, 2, 9, 6, 8},
      {1, 22, 24, 12, 14, 15, 16, 2, 9, 6, 8},
      {1, 22, 23, 24, 12, 14, 16, 2, 9, 6, 8},
      {1, 19, 20, 21, 11, 13, 15, 2, 9, 6, 8},
      {1, 22, 24, 11, 13, 15, 4, 6, 8, 10, 17},
      {1, 18, 25, 23, 11, 13, 4, 6, 8, 10, 17},
      {1, 23, 14, 16, 15, 13, 11, 2, 9, 6, 8},
      {1, 20, 10, 17, 15, 13, 11, 2, 9, 6, 8}
   };
   public static final String[] sK = new String[]{"5-4-1", "5-4-1", "5-3-2", "4-5-1", "4-4-2", "4-4-2", "4-4-2", "4-3-3", "4-3-3", "3-5-2", "3-4-3"};
   public static final int[][] sL = new int[][]{
      {6, 0, 2, 1, 2},
      {8, 0, 4, 1, 2},
      {10, 0, 4, 0, 2},
      {11, 0, 4, 0, 2},
      {12, 0, 4, 0, 2},
      {12, 0, 8, 0, 2},
      {14, 0, 8, 0, 2},
      {16, 4, 2, 0, 2},
      {16, 0, 4, 0, 2},
      {16, 0, 8, 0, 2},
      {20, 4, 2, 0, 4}
   };
   public static final String[] aeH = new String[]{"Europa", "América do Sul", "África", "Ásia", "Concacaf", "Oceania"};
   public static final int sM = 7;
   public static final int ui = 10;
   public static final String[] sN = new String[]{
      "6 times - padrão",
      "8 times - 4 classificados",
      "10 times - 4 classificados",
      "11 times - 4 classificados",
      "12 times - 4 classificados",
      "12 times - 8 classificados",
      "14 times - 8 classificados",
      "16 times - 4 grupos - SP 2021",
      "16 times - 4 classificados",
      "16 times - 8 classificados",
      "20 times - 4 grupos"
   };
   public static final String[] sO = new String[]{
      "corinthians_bra",
      "santoandre_sp",
      "interlimeirasp_bra",
      "botafogosp_bra",
      "saopaulo_bra",
      "ferroviaria_sp",
      "pontepreta_bra",
      "saobento_bra",
      "bragantino_bra",
      "palmeiras",
      "ituano_sp",
      "novorinzontino_sp",
      "miirassol_sp",
      "santos",
      "guaranisp_bra",
      "saocaetano_bra"
   };
   public static final String[] sP = new String[]{
      "liverpool_uru",
      "univcatolicaquito_equ",
      "cesarvallejo_per",
      "caracas_ven",
      "royalpari_bol",
      "guarani_par",
      "libertad_par",
      "gremio",
      "ayacucho_per",
      "wanderers_uru",
      "bolivar_bol",
      "universidadchile_chi",
      "sanlorenzo_ar",
      "santos",
      "deportivolara_ven",
      "junior_col",
      "unionespanola_chi",
      "independiente_equ",
      "nacional_col"
   };
   public static final String[] sQ = new String[]{
      "palmeiras",
      "defensayjusticia_ar",
      "universitario_per",
      "olimpia_par",
      "internacional_bra",
      "deptachira_ven",
      "alwaysready_bol",
      "bocajuniors_arg",
      "barcelona_equ",
      "thestrongest_bol",
      "riverplate_arg",
      "santafe_col",
      "flurj",
      "saopaulo_bra",
      "racing_arg",
      "sportingcristal_per",
      "rentistas_uru",
      "nacional_uru",
      "universidadcatolica_chi",
      "argentinojnrs_arg",
      "flarj",
      "ldu_equ",
      "velezsarsfield_arg",
      "unionlacalera_chi",
      "cerroporteno_par",
      "atleticomg_bra",
      "americacali_col",
      "deplaguaira_ven"
   };
   public static final int[][] sR = new int[][]{
      {9, 17, 9, 17, 9, 17, 9, 17},
      {4, 7, 6, 8, 3, 5, 9, 2},
      {2, 10, 2, 10, 2, 10, 2, 10},
      {17, 16, 13, 25, 9, 17, 9, 17},
      {12, 15, 11, 13, 14, 16, 17, 10},
      {10, 14, 11, 2, 18, 10, 2, 18},
      {16, 25, 15, 21, 18, 14, 10, 18},
      {15, 14, 16, 19, 20, 21, 18, 25},
      {14, 15, 16, 19, 20, 21, 25, 18},
      {25, 21, 24, 20, 23, 18, 22, 19},
      {23, 20, 24, 22, 21, 19, 18, 25},
      {22, 19, 23, 20, 18, 24, 21, 25}
   };
   public static final int[][] sS = new int[][]{{10, 13}, {14, 17}, {3, 8}, {2, 3}, {8, 9}, {19, 24}, {1, 1}};
   public static final String[] sT = new String[]{"", "gol", "Amarelo", "Vermelho", "Ama-Ver", "Contusao", "Substituição", "Penalty Perdido"};
   public static final String[] sU = new String[]{"", "normal", "contra", "penalty", "falta", "olimpico", "escanteio"};
   public static final int sV = 1;
   public static final int sW = 2;
   public static final int sX = 3;
   public static final int sY = 4;
   public static final int sZ = 5;
   public static final int ta = 6;
   public static final int tb = 7;
   public static final int td = 8;
   public static final int te = 1;
   public static final int tf = 2;
   public static final int tg = 3;
   public static final int th = 4;
   public static final int ti = 5;
   public static final int tj = 6;
   public static final int tk = 30;
   public static final int tl = 1;
   public static final int tm = 2;
   public static final int tn = 3;
   public static final int field_kw_to = 4;
   public static final int tp = 5;
   public static final int tq = 6;
   public static final int tr = 7;
   public static final int ts = 8;
   public static final int tt = 9;
   public static final String tu = "/teams/escudos/";
   public static final String tv = "/teams/escudosMini/";
   public static final String[] tw = new String[]{"/teams/camisas/", "/teams/camisas2/", "/teams/camisas3/"};
   public static final String tx = "/selecoes/escudos/";
   public static final String[] ty = new String[]{"/selecoes/camisas/", "/selecoes/camisas2/", "/selecoes/camisas3/"};
   public static final String[] tz = new String[]{
      "Amistoso",
      "Nacional",
      "Copa Nacional",
      "Estadual",
      "Internacional 1",
      "Mundial",
      "Internacional 2",
      "Seleções",
      "Recopa",
      "Eliminatórias",
      "Regionais",
      "Supercopa",
      "Conference League",
      "Finalíssima",
      "Liga Nações",
      "Torneio Amistoso"
   };
   public static final String[] tA = new String[]{
      C0679.getString("ligaC"),
      C0679.getString("lib"),
      C0679.getString("ligaCaf"),
      C0679.getString("ligaAfc"),
      C0679.getString("ligaConcacaf"),
      C0679.getString("ligaOfc")
   };
   public static final String[] tB = new String[]{C0679.getString("ligaE"), C0679.getString("csa"), "", "", "", "", ""};
   public static final String[] tC = new String[]{C0679.getString("recopaE"), C0679.getString("recopaS"), "", "", "", "", ""};
   public static final String[] aeI = new String[]{"Conference League", "", "", "", "", ""};
   public static final String[] tD = new String[]{
      C0679.getString("cro"),
      C0679.getString("cam"),
      C0679.getString("cafr"),
      C0679.getString("casi"),
      C0679.getString("nCOuro"),
      C0679.getString("nCopaOFC"),
      "",
      C0679.getString("ncm")
   };
   public static final int[] tE = new int[]{727312, 412438, 219869, 319352, 530593, 157171};
   public static boolean[] tF = new boolean[]{true, true, true, true, true, true, false, false};
   public static boolean[] tG = new boolean[]{true, false, true, true, true, false, false, false};
   public static final int[] tH = new int[]{16, 22, 26, 31, 40, 42};
   public static Random tI = new Random();
   public static final int tJ = 0;
   public static final int tK = 1;
   public static final int tL = 2;
   public static final int tM = 3;
   public static final int tN = 4;
   public static final int tO = 5;

   public static final int ct(int i) {
      return C0696.values()[i].gg();
   }

   public static final String y(int i, int j) {
      if (i == 4) {
         return tA[ct(j)];
      } else if (i == 6) {
         return tB[ct(j)];
      } else {
         return i == 12 ? aeI[ct(j)] : tz[i];
      }
   }

   public static final String z(int i, int j) {
      if (i == 1 || i == 3) {
         return tz[i] + " " + Integer.toString(j) + "ª D";
      } else if (i == 4) {
         return tA[j];
      } else if (i == 6) {
         return tB[j];
      } else if (i == 7) {
         return tD[j];
      } else {
         return i == 8 ? tC[j] : tz[i];
      }
   }

   public static int A(int i, int j) {
      float var2 = (float)i / j;
      return Math.round(var2 * 100.0F);
   }

   public static int B(int i, int j) {
      C(i, j);
      return 36126 + j;
   }

   public static void C(int i, int j) {
      for (int var2 = 0; var2 < tH.length; var2++) {
         if (tH[var2] == j) {
            C0983.i(var2, j, i);
            break;
         }
      }
   }

   public static float D(int i, int j) {
      float var2 = (float)i / j;
      return var2 * 100.0F;
   }

   public static Color E(int i, int j) {
      String var2 = "#687864";
      String[] var3 = new String[]{"#004469", "#687864", "#000000", "#6E0000", "#990099"};
      String[] var4 = new String[]{"#003249", "#2C3531", "#303233", "#520202", "#6E016E"};
      String[] var5 = new String[]{"#0570a1", "#687864", "#474a4c", "#a93737", "#990099"};
      if (j == 1) {
         var2 = var3[i];
      } else if (j == 2) {
         var2 = var4[i];
      } else if (j == 3) {
         var2 = var5[i];
      }

      return new Color(Integer.valueOf(var2.substring(1, 3), 16), Integer.valueOf(var2.substring(3, 5), 16), Integer.valueOf(var2.substring(5, 7), 16));
   }

   public static boolean w(String string) {
      File var1 = new File(System.getProperty("user.dir") + "/trofeus/" + string + ".png");
      return var1.exists() && !var1.isDirectory();
   }

   public static ImageIcon x(String string) {
      BufferedImage var1 = null;
      File var2 = new File(System.getProperty("user.dir") + "/trofeus/" + string + ".png");
      if (var2.exists() && !var2.isDirectory()) {
         try {
            var1 = ImageIO.read(new File(System.getProperty("user.dir") + "/trofeus/" + string + ".png"));
         } catch (IOException var4) {
            var4.printStackTrace();
         }

         return var1 != null ? new ImageIcon(var1) : mf();
      } else {
         return mf();
      }
   }

   public static ImageIcon mf() {
      return new ImageIcon(GameConstants.class.getResource("/aicons/trgen.png"));
   }

   public static ImageIcon a(ImageIcon imageIcon, int i, int j) {
      ImageIcon var3 = imageIcon;
      if (var3 != null) {
         BufferedImage var4 = new BufferedImage(var3.getIconWidth(), var3.getIconHeight(), 2);
         Graphics2D var5 = var4.createGraphics();
         var3.paintIcon(null, var5, 0, 0);
         var5.dispose();
         BufferedImage var6 = new BufferedImage(i, j, 2);
         Graphics2D var7 = var6.createGraphics();
         var7.drawImage(var4, 0, 0, i, j, null);
         var7.setComposite(AlphaComposite.Src);
         return new ImageIcon(var6);
      } else {
         return null;
      }
   }

   public static int cu(int i) {
      if (tI == null) {
         tI = new Random();
      }

      return tI.nextInt(i);
   }

   public static boolean fs(int i) {
      return i == 7 || i == 9 || i == 13 || i == 14;
   }

   public static int am(String string) {
      Preferences var1 = Preferences.userRoot();
      var1 = var1.node("bfoptions");
      return var1.getInt(string, -1);
   }

   public static void f(String string, int i) {
      Preferences var2 = Preferences.userRoot();
      var2 = var2.node("bfoptions");
      var2.putInt(string, i);
   }
}
