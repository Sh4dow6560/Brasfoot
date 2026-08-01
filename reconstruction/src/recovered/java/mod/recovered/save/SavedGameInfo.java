package mod.recovered.save;

import java.io.Serializable;

public class SavedGameInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  private String managerName = null;
  private String clubName = null;
  private Integer seasonYear = null;
  private String nextMatch = null;

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  public String getClubName() {
    return clubName;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
  }

  public Integer getSeasonYear() {
    return seasonYear;
  }

  public void setSeasonYear(Integer seasonYear) {
    this.seasonYear = seasonYear;
  }

  public String getNextMatch() {
    return nextMatch;
  }

  public void setNextMatch(String nextMatch) {
    this.nextMatch = nextMatch;
  }
}
