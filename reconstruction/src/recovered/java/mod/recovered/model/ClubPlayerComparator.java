package mod.recovered.model;

import java.util.Comparator;

final class ClubPlayerComparator implements Comparator<Player> {
  @Override
  public int compare(Player left, Player right) {
    int leftScore = left.getOverallStrength();
    int rightScore = right.getOverallStrength();
    int leftAge = left.getIdade();
    int rightAge = right.getIdade();
    return leftScore == rightScore ? rightAge - leftAge : rightScore - leftScore;
  }
}
