package bf22.intermediary;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class C0889 {
   private static String TZ = "E:/java/Brasfoot2017_editor/teams";
   private static String Ua = "E:/java/Brasfoot2017_editor/teams";

   public static void wj() {
      String var0 = ".b16";
      byte var1 = 18;
      File var2 = new File(TZ);
      File[] var3 = var2.listFiles(new C0890());

      for (int var4 = 0; var4 < var3.length; var4++) {
         if (var3[var4].isFile()) {
            String var5 = var3[var4].getName();
            var5 = var5.substring(0, var5.lastIndexOf("."));
            a(var3[var4].getPath(), var5, false, 18);
         }
      }
   }

   public static void a(String string, String string2, boolean bl, int i) {
      String var4 = ".b18";
      new C0915();

      C0915 var5;
      try {
         FileInputStream var6 = new FileInputStream(string);
         ObjectInputStream var7 = new ObjectInputStream(var6);
         var5 = (C0915)var7.readObject();
         var7.close();
         var6.close();
      } catch (IOException var9) {
         var9.printStackTrace();
         return;
      } catch (ClassNotFoundException var10) {
         var10.printStackTrace();
         return;
      }

      var5.setVid(i);
      var5.setId(0);

      try {
         FileOutputStream var11 = new FileOutputStream(Ua + "/" + string2 + ".b18");
         ObjectOutputStream var12 = new ObjectOutputStream(var11);
         var12.writeObject(var5);
         var12.close();
         var11.close();
      } catch (IOException var8) {
         var8.printStackTrace();
      }
   }

   public static void iD() {
      File var0 = new File(TZ);
      File[] var1 = var0.listFiles(new C0891());

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].isFile()) {
            String var3 = var1[var2].getName();
            var3 = var3.substring(0, var3.lastIndexOf("."));

            try {
               a(var1[var2].getPath(), var3);
            } catch (ParserConfigurationException var5) {
               System.out.println("O parser não foi configurado corretamente.");
               var5.printStackTrace();
            } catch (SAXException var6) {
               System.out.println("Problema ao fazer o parse do arquivo.");
               var6.printStackTrace();
            } catch (IOException var7) {
               System.out.println("O arquivo não pode ser lido.");
               var7.printStackTrace();
            }
         }
      }

      System.out.printf("salvos");
   }

   public static void a(String string, String string2) throws ParserConfigurationException, SAXException, IOException {
      DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
      DocumentBuilder var3 = var2.newDocumentBuilder();
      Document var4 = var3.parse(string);
      Element var5 = var4.getDocumentElement();
      C0915 var6 = new C0915();
      var6.setId(0);
      var6.setPais(Integer.parseInt(a(var5, "p")));
      var6.setEstado(Integer.parseInt(a(var5, "es")));
      var6.setNivel(Integer.parseInt(a(var5, "nv")));
      var6.setFileRef(string2);
      var6.setNome(a(var5, "n"));
      var6.setEstadio(a(var5, "e"));
      var6.setNivel(Integer.parseInt(a(var5, "nv")));
      var6.setCapacidade(Integer.parseInt(a(var5, "ec")));
      var6.setTecnico(a(var5, "t"));
      var6.setCorF(Color.decode("#" + a(var5, "cf")));
      var6.setCorT(Color.decode("#" + a(var5, "ct")));
      var6.setReputacao(Integer.parseInt(a(var5, "r")));
      var6.setCorBase(Integer.parseInt(a(var5, "cb")));
      boolean var7 = false;
      if (var6.getNome() != "0" && var6.getTecnico() != "0" && var6.getFileRef() != null) {
         var7 = true;
      }

      int var8 = 0;
      int var9 = 0;
      if (var7) {
         NodeList var10 = var5.getElementsByTagName("jog");
         ArrayList var11 = new ArrayList();
         ArrayList var12 = new ArrayList();
         if (var10.getLength() > 0) {
            for (int var13 = 0; var13 < var10.getLength(); var13++) {
               Element var14 = (Element)var10.item(var13);
               if (a(var14, "no") != "0") {
                  C0914 var15 = new C0914();
                  var15.setNome(a(var14, "no"));
                  if (Integer.parseInt(a(var14, "s")) == 1) {
                     var15.setEstrela(true);
                  }

                  var15.setPais(Integer.parseInt(a(var14, "pa")));
                  var15.setIdade(Integer.parseInt(a(var14, "i")));
                  var15.setPosicao(Integer.parseInt(a(var14, "p")));
                  var15.setStatus(Integer.parseInt(a(var14, "t")));
                  var15.setLado(Integer.parseInt(a(var14, "l")));
                  var15.setCr1(Integer.parseInt(a(var14, "c1")));
                  var15.setCr2(Integer.parseInt(a(var14, "c2")));
                  var15.setHash(Integer.parseInt(a(var14, "tl")));
                  if (Integer.parseInt(a(var14, "ju")) == 0) {
                     var11.add(var15);
                     if (var15.getPosicao() != 0) {
                        var8++;
                     } else {
                        var9++;
                     }
                  } else {
                     var12.add(var15);
                  }
               }
            }
         }

         if (var9 >= 1 && var8 >= 11) {
            var6.setValid(true);
         }

         var6.setJogadores(var11);
         var6.setJuniores(var12);

         try {
            FileOutputStream var17 = new FileOutputStream(Ua + "/" + string2 + ".b16");
            ObjectOutputStream var18 = new ObjectOutputStream(var17);
            var18.writeObject(var6);
            var18.close();
            var17.close();
         } catch (IOException var16) {
            var16.printStackTrace();
         }
      }
   }

   public static String a(Element element, String string) {
      if (element.getElementsByTagName(string).getLength() == 0) {
         return "0";
      }

      if (element.getElementsByTagName(string).item(0).getChildNodes().getLength() == 0) {
         return "0";
      }

      NodeList var2 = element.getElementsByTagName(string);
      if (var2 == null) {
         return "0";
      }

      Element var3 = (Element)var2.item(0);
      if (var3 == null) {
         return "0";
      }

      Node var4 = var3.getFirstChild();
      return var4.getNodeValue();
   }
}
