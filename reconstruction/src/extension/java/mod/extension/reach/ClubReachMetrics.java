package mod.extension.reach;

public final class ClubReachMetrics {
  private final long localSupporters;
  private final long internationalSupporters;
  private final long socialFollowers;
  private final long supporterMembers;
  private final int globalReputation;
  private final int engagement;
  private final int sentiment;

  public ClubReachMetrics(
      long localSupporters,
      long internationalSupporters,
      long socialFollowers,
      long supporterMembers,
      int globalReputation,
      int engagement,
      int sentiment) {
    if (localSupporters < 0L || internationalSupporters < 0L
        || socialFollowers < 0L || supporterMembers < 0L) {
      throw new IllegalArgumentException("Club reach audiences must not be negative");
    }
    if (globalReputation < 0 || globalReputation > 1000
        || engagement < 0 || engagement > 100 || sentiment < 0 || sentiment > 100) {
      throw new IllegalArgumentException("Club reach scores are outside the supported range");
    }
    this.localSupporters = localSupporters;
    this.internationalSupporters = internationalSupporters;
    this.socialFollowers = socialFollowers;
    this.supporterMembers = supporterMembers;
    this.globalReputation = globalReputation;
    this.engagement = engagement;
    this.sentiment = sentiment;
  }

  public long getLocalSupporters() {
    return this.localSupporters;
  }

  public long getInternationalSupporters() {
    return this.internationalSupporters;
  }

  public long getSocialFollowers() {
    return this.socialFollowers;
  }

  public long getSupporterMembers() {
    return this.supporterMembers;
  }

  public int getGlobalReputation() {
    return this.globalReputation;
  }

  public int getEngagement() {
    return this.engagement;
  }

  public int getSentiment() {
    return this.sentiment;
  }

  public ReachLevel getLevel() {
    return ReachLevel.fromScore(this.globalReputation);
  }
}
