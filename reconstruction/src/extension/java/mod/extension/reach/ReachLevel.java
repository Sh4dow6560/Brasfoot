package mod.extension.reach;

public enum ReachLevel {
  LOCAL,
  REGIONAL,
  NATIONAL,
  CONTINENTAL,
  GLOBAL;

  public static ReachLevel fromScore(int score) {
    if (score < 0 || score > 1000) {
      throw new IllegalArgumentException("Global reputation must be between 0 and 1000");
    }
    if (score < 200) {
      return LOCAL;
    }
    if (score < 350) {
      return REGIONAL;
    }
    if (score < 550) {
      return NATIONAL;
    }
    if (score < 750) {
      return CONTINENTAL;
    }
    return GLOBAL;
  }
}
