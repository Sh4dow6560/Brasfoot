package bf22.intermediary;

import mod.recovered.competition.CompetitionPlayerStats;
import mod.recovered.model.Club;

public class C0721 {
   private String nome = null;
   private Club X = null;
   private int g = 0;
   private int T = 0;

   public C0721(String string, Club club, int i, int j) {
      this.nome = string;
      this.X = club;
      this.g = i;
      this.T = j;
   }

   public C0721(CompetitionPlayerStats c0720) {
      if (c0720.x() != null) {
         this.nome = c0720.x().getNome();
         this.X = c0720.x().getClub();
         this.g = c0720.y();
         this.T = c0720.A();
      }
   }

   public String getNome() {
      return this.nome;
   }

   public Club B() {
      return this.X;
   }

   public void b(Club club) {
      this.X = club;
   }

   public int v() {
      return this.g;
   }

   public int w() {
      return this.T;
   }
}
