package mod.extension.board;

public enum JobSecurity {
  SECURE,
  STABLE,
  UNDER_PRESSURE,
  CRITICAL;

  static JobSecurity fromScore(int score) {
    if (score >= 75) {
      return SECURE;
    }
    if (score >= 50) {
      return STABLE;
    }
    if (score >= 25) {
      return UNDER_PRESSURE;
    }
    return CRITICAL;
  }
}
