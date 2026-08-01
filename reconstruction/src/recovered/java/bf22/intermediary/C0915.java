package bf22.intermediary;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class C0915 implements Serializable {
   private static final long serialVersionUID = 16L;
   private boolean valid = false;
   private int id = 0;
   private int a;
   private int b;
   private int c;
   private String d;
   private String e;
   private String f;
   private int g;
   private String h;
   private int i;
   private transient Color j;
   private transient Color k;
   private ArrayList l = new ArrayList();
   private ArrayList m = new ArrayList();
   private int n;
   private int o;
   private int tid;
   private int sid;
   private int aid;
   private int vid;
   private transient String nomep;
   private transient boolean mark = false;
   private String cor1 = "";
   private String cor2 = "";

   public String getCor1() {
      return this.cor1;
   }

   public String getCor2() {
      return this.cor2;
   }

   public boolean isValid() {
      return this.valid;
   }

   public void setValid(boolean bl) {
      this.valid = bl;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int i) {
      this.id = i;
   }

   public int getPais() {
      return this.a;
   }

   public void setPais(int i) {
      this.a = i;
   }

   public int getEstado() {
      return this.b;
   }

   public void setEstado(int i) {
      this.b = i;
   }

   public int getNivel() {
      return this.c;
   }

   public void setNivel(int i) {
      this.c = i;
   }

   public String getFileRef() {
      return this.d;
   }

   public boolean semEscudo() {
      File var1 = new File(System.getProperty("user.dir") + "/teams/escudos/" + this.d + ".png");
      return !var1.exists() || var1.isDirectory();
   }

   public boolean semCamisa() {
      File var1 = new File(System.getProperty("user.dir") + "/teams/camisas/" + this.d + ".png");
      return !var1.exists() || var1.isDirectory();
   }

   public boolean hasDuplicado() {
      boolean var1 = false;
      int var2 = 0;

      for (int var3 = 0; var3 < this.l.size(); var3++) {
         var2 = 0;

         for (int var4 = 0; var4 < this.l.size(); var4++) {
            if (((C0914)this.l.get(var3)).getNome().equals(((C0914)this.l.get(var4)).getNome())) {
               var2++;
            }
         }

         if (var2 > 1) {
            var1 = true;
            break;
         }
      }

      return var1;
   }

   public void setFileRef(String string) {
      this.d = string;
   }

   public String getNome() {
      return this.e;
   }

   public void setNome(String string) {
      this.e = string;
   }

   public String getEstadio() {
      return this.f;
   }

   public void setEstadio(String string) {
      this.f = string;
   }

   public int getCapacidade() {
      return this.g;
   }

   public void setCapacidade(int i) {
      this.g = i;
   }

   public String getTecnico() {
      return this.h;
   }

   public void setTecnico(String string) {
      this.h = string;
   }

   public int getTecNac() {
      return this.i;
   }

   public void setTecNac(int i) {
      this.i = i;
   }

   public ArrayList getJogadores() {
      return this.l;
   }

   public void setJogadores(ArrayList arrayList) {
      this.l = arrayList;
   }

   public ArrayList getJuniores() {
      return this.m;
   }

   public void setJuniores(ArrayList arrayList) {
      this.m = arrayList;
   }

   public int getReputacao() {
      return this.n;
   }

   public void setReputacao(int i) {
      this.n = i;
   }

   public int getCorBase() {
      return this.o;
   }

   public void setCorBase(int i) {
      this.o = i;
   }

   public int getNumeroTitulares() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.getJogadores().size(); var2++) {
         if (((C0914)this.getJogadores().get(var2)).getStatus() == 1) {
            var1++;
         }
      }

      return var1;
   }

   public int getNumeroTitularesJuniores() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.getJuniores().size(); var2++) {
         if (((C0914)this.getJuniores().get(var2)).getStatus() == 1) {
            var1++;
         }
      }

      return var1;
   }

   public int getTid() {
      return this.tid;
   }

   public void setTid(int i) {
      this.tid = i;
   }

   public int getSid() {
      return this.sid;
   }

   public void setSid(int i) {
      this.sid = i;
   }

   public int getAid() {
      return this.aid;
   }

   public void setAid(int i) {
      this.aid = i;
   }

   public String getNomep() {
      return this.nomep;
   }

   public void setNomep(String string) {
      this.nomep = string;
   }

   public boolean isMark() {
      return this.mark;
   }

   public void setMark(boolean bl) {
      this.mark = bl;
   }

   public int getVid() {
      return this.vid;
   }

   public void setVid(int i) {
      this.vid = i;
   }

   public void setCor1(String string) {
      this.cor1 = string;
   }

   public void setCor2(String string) {
      this.cor2 = string;
   }

   public Color getCorF() {
      if (this.j == null) {
         this.j = new Color(
            Integer.valueOf(this.cor1.substring(1, 3), 16), Integer.valueOf(this.cor1.substring(3, 5), 16), Integer.valueOf(this.cor1.substring(5, 7), 16)
         );
      }

      return this.j;
   }

   public void setCorF(Color color) {
      String var2 = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
      this.cor1 = var2;
      this.j = color;
   }

   public Color getCorT() {
      if (this.k == null) {
         this.k = new Color(
            Integer.valueOf(this.cor2.substring(1, 3), 16), Integer.valueOf(this.cor2.substring(3, 5), 16), Integer.valueOf(this.cor2.substring(5, 7), 16)
         );
      }

      return this.k;
   }

   public void setCorT(Color color) {
      String var2 = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
      this.cor2 = var2;
      this.k = color;
   }
}
