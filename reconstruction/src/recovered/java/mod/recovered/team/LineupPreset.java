package mod.recovered.team;

import java.io.Serializable;
import java.util.ArrayList;

public class LineupPreset implements Serializable {
  private static final long serialVersionUID = 1L;

  private String name;
  private ArrayList players = new ArrayList();
  private ArrayList positions = new ArrayList();

  public void clear() {
    players.clear();
    positions.clear();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList getPlayers() {
    return players;
  }

  public ArrayList getPositions() {
    return positions;
  }
}
