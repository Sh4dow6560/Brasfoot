package bf22.intermediary;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mod.recovered.model.Club;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class C0682 {
   public static void iD() {
      File var0 = new File(System.getProperty("user.dir") + "/teams2");
      File[] var1 = var0.listFiles(new C0683());

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].isFile()) {
            String var3 = var1[var2].getName();
            var3 = var3.substring(0, var3.lastIndexOf("."));

            try {
               a(var1[var2].getPath(), var3);
            } catch (ParserConfigurationException var5) {
               var5.printStackTrace();
            } catch (SAXException var6) {
               var6.printStackTrace();
            } catch (IOException var7) {
               var7.printStackTrace();
            }
         }
      }
   }

   public static void a(String string, String string2) throws ParserConfigurationException, SAXException, IOException {
      String var2 = null;
      String var3 = null;
      int var4 = 0;
      int var5 = 0;
      String var6 = null;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      Color var12 = null;
      Color var13 = null;
      Boolean var14 = false;
      int var15 = 0;
      int var16 = 0;
      DocumentBuilderFactory var17 = DocumentBuilderFactory.newInstance();
      DocumentBuilder var18 = var17.newDocumentBuilder();
      Document var19 = var18.parse(string);
      Element var20 = var19.getDocumentElement();
      var2 = a(var20, "n");
      var4 = Integer.parseInt(a(var20, "p"));
      var5 = Integer.parseInt(a(var20, "nv"));
      var6 = a(var20, "e");
      var7 = Integer.parseInt(a(var20, "ec"));
      var3 = a(var20, "t");
      var8 = Integer.parseInt(a(var20, "es"));
      var9 = Integer.parseInt(a(var20, "r"));
      var10 = Integer.parseInt(a(var20, "cb"));
      var11 = Integer.parseInt(a(var20, "id"));
      var12 = Color.decode("#" + a(var20, "cf"));
      var13 = Color.decode("#" + a(var20, "ct"));
      String var21 = string2;
      if (var2 != "0" && var3 != "0" && var21 != null) {
         var14 = true;
      }

      if (var14) {
         NodeList var22 = var20.getElementsByTagName("jog");
         ArrayList var23 = new ArrayList();
         if (var22.getLength() > 0) {
            for (int var24 = 0; var24 < var22.getLength(); var24++) {
               Element var25 = (Element)var22.item(var24);
               if (a(var25, "no") != "0") {
                  C0689 var26 = new C0689();
                  var26.dm = a(var25, "no");
                  var26.em = Integer.parseInt(a(var25, "i"));
                  var26.hk = Integer.parseInt(a(var25, "t"));
                  var26.hl = Integer.parseInt(a(var25, "s"));
                  var26.en = Integer.parseInt(a(var25, "p"));
                  var26.pais = Integer.parseInt(a(var25, "pa"));
                  var26.er = Integer.parseInt(a(var25, "l"));
                  var26.hn = Integer.parseInt(a(var25, "c1"));
                  var26.ho = Integer.parseInt(a(var25, "c2"));
                  var26.hp = Integer.parseInt(a(var25, "ju"));
                  var26.es = Integer.parseInt(a(var25, "tl"));
                  var23.add(var26);
               }
            }

            if (var23.size() > 0) {
               for (int var39 = 0; var39 < var23.size(); var39++) {
                  if (((C0689)var23.get(var39)).hp == 0) {
                     if (((C0689)var23.get(var39)).en == 0) {
                        var16++;
                     } else {
                        var15++;
                     }
                  }
               }
            }
         }

         if (var16 <= 0 || var15 < 12) {
            var14 = false;
         }

         if (var14) {
            new Club(var2, string2, var11, var4, var8, var5, var3, var9, var12, var13, var6, var7, var23, false);
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
