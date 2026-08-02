package mod.recovered.geo;

import bf22.intermediary.*;
import javax.swing.ImageIcon;

public class CountryInfo {
   private String nome;
   private String lZ;
   private int pais;
   private ImageIcon ma = null;
   private String mb;
   private int lV;

   public String getNome() {
      return this.nome;
   }

   public void setNome(String string) {
      this.nome = string;
   }

   public int getPais() {
      return this.pais;
   }

   public void setPais(int i) {
      this.pais = i;
   }

   public ImageIcon jD() {
      return this.ma;
   }

   public void d(ImageIcon imageIcon) {
      this.ma = imageIcon;
   }

   public String jE() {
      return this.mb;
   }

   public void r(String string) {
      this.mb = string;
   }

   public int gg() {
      return this.lV;
   }

   public void bn(int i) {
      this.lV = i;
   }

   public String jF() {
      return this.lZ;
   }

   public void s(String string) {
      this.lZ = string;
   }

   public void bo(int i) {
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aflags/" + i + ".png"));
      this.d(var2);
   }

   public static String bp(int i) {
      String var1 = null;
      switch (i) {
         case 3:
            var1 = "Alemão";
            break;
         case 10:
            var1 = "Argelino";
            break;
         case 11:
            var1 = "Argentino";
            break;
         case 12:
            var1 = "Armenio";
            break;
         case 14:
            var1 = "Australiano";
            break;
         case 15:
            var1 = "Austríaco";
            break;
         case 21:
            var1 = "Belga";
            break;
         case 26:
            var1 = "Boliviano";
            break;
         case 29:
            var1 = "Brasileiro";
            break;
         case 31:
            var1 = "Bulgaro";
            break;
         case 42:
            var1 = "Chileno";
            break;
         case 43:
            var1 = "Chinês";
            break;
         case 46:
            var1 = "Colombiano";
            break;
         case 49:
            var1 = "Sul-Coreano";
            break;
         case 52:
            var1 = "Croata";
            break;
         case 54:
            var1 = "Dinamarquês";
            break;
         case 57:
            var1 = "Egípcio";
            break;
         case 60:
            var1 = "Equatoriano";
            break;
         case 62:
            var1 = "Escocês";
            break;
         case 63:
            var1 = "Eslovaco";
            break;
         case 64:
            var1 = "Esloveno";
            break;
         case 65:
            var1 = "Espanhol";
            break;
         case 70:
            var1 = "Finlandês";
            break;
         case 72:
            var1 = "Francês";
            break;
         case 78:
            var1 = "Grego";
            break;
         case 85:
            var1 = "Holandês";
            break;
         case 88:
            var1 = "Hungaro";
            break;
         case 97:
            var1 = "Inglês";
            break;
         case 98:
            var1 = "Iraniano";
            break;
         case 100:
            var1 = "Irlandês";
            break;
         case 104:
            var1 = "Italiano";
            break;
         case 107:
            var1 = "Japonês";
            break;
         case 129:
            var1 = "Marroquino";
            break;
         case 131:
            var1 = "Mexicano";
            break;
         case 150:
            var1 = "Paraguaio";
            break;
         case 151:
            var1 = "Peruano";
            break;
         case 152:
            var1 = "Polonês";
            break;
         case 154:
            var1 = "Português";
            break;
         case 160:
            var1 = "Romeno";
            break;
         case 162:
            var1 = "Russo";
            break;
         case 171:
            var1 = "Sérvio";
            break;
         case 179:
            var1 = "Sueco";
            break;
         case 180:
            var1 = "Suiço";
            break;
         case 183:
            var1 = "Tailandês";
            break;
         case 192:
            var1 = "Turco";
            break;
         case 193:
            var1 = "Ucraniano";
            break;
         case 195:
            var1 = "Uruguaio";
            break;
         case 198:
            var1 = "Venezuelano";
      }

      return var1;
   }

   public static String bq(int i) {
      int[][] var1 = new int[][]{
         {29, 1},
         {107, 1},
         {131, 1},
         {154, 2},
         {0, 1},
         {5, 2},
         {6, 2},
         {8, 2},
         {16, 1},
         {17, 2},
         {18, 1},
         {19, 2},
         {20, 2},
         {22, 1},
         {23, 1},
         {24, 2},
         {28, 2},
         {30, 2},
         {33, 1},
         {34, 1},
         {35, 2},
         {36, 2},
         {37, 1},
         {38, 1},
         {39, 1},
         {40, 1},
         {41, 1},
         {42, 1},
         {44, 1},
         {45, 1},
         {47, 1},
         {53, 2},
         {55, 1},
         {57, 1},
         {58, 2},
         {59, 3},
         {60, 1},
         {68, 3},
         {69, 2},
         {73, 1},
         {75, 2},
         {77, 2},
         {84, 1},
         {86, 2},
         {87, 2},
         {89, 1},
         {98, 2},
         {99, 2},
         {103, 2},
         {105, 2},
         {107, 1},
         {109, 1},
         {110, 2},
         {112, 1},
         {113, 1},
         {115, 1},
         {118, 2},
         {120, 2},
         {121, 2},
         {123, 2},
         {125, 1},
         {127, 1},
         {128, 2},
         {129, 1},
         {131, 1},
         {133, 2},
         {135, 2},
         {138, 1},
         {140, 1},
         {144, 2},
         {145, 1},
         {147, 1},
         {149, 1},
         {150, 1},
         {151, 1},
         {153, 2},
         {155, 1},
         {161, 2},
         {164, 2},
         {165, 2},
         {166, 2},
         {167, 2},
         {168, 2},
         {169, 1},
         {170, 2},
         {172, 1},
         {173, 2},
         {176, 2},
         {178, 2},
         {181, 1},
         {182, 1},
         {184, 1},
         {185, 2},
         {187, 1},
         {188, 1},
         {189, 2},
         {191, 1},
         {194, 2},
         {195, 1},
         {196, 1},
         {197, 2},
         {199, 1},
         {201, 1},
         {206, 2},
         {207, 1},
         {208, 2},
         {209, 1},
         {210, 2},
         {212, 2},
         {216, 2},
         {217, 2},
         {218, 2}
      };
      String[] var2 = new String[]{"da", "do", "de", "dos"};

      for (int var3 = 0; var3 < var1.length; var3++) {
         if (var1[var3][0] == i) {
            return var2[var1[var3][1]];
         }
      }

      return "da";
   }

   public static String br(int i) {
      String var1 = bp(i);
      if (var1 == null) {
         var1 = bq(i) + " " + C0696.values()[i].getNome();
      }

      return "Campeonato " + var1;
   }

   public static String bs(int i) {
      String var1 = bp(i);
      if (var1 == null) {
         var1 = C0696.values()[i].getNome();
      }

      return var1;
   }

   public static String bt(int i) {
      return bq(i) + " " + C0696.values()[i].getNome();
   }

   public static String bu(int i) {
      String var1 = bp(i);
      if (var1 == null) {
         var1 = C0696.values()[i].getNome();
      }

      return var1;
   }
}
