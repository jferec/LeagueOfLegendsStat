package io.vertx.starter.model.league;

/**
 * Dropped leagueId
 */
public class League {
  private Rank rank;
  private Tier tier;
  private int leaguePoints;
  private String queueType;
  private int wins;

  public Rank getRank() {
    return rank;
  }

  public Tier getTier() {
    return tier;
  }

  public int getLeaguePoints() {
    return leaguePoints;
  }

  public String getQueueType() {
    return queueType;
  }

  public int getWins() {
    return wins;
  }

  public MiniSeries getMiniSeries() {
    return miniSeries;
  }

  public boolean isHotStreak() {
    return hotStreak;
  }

  public boolean isVeteran() {
    return veteran;
  }

  public int getLosses() {
    return losses;
  }

  public boolean isFreshBlood() {
    return freshBlood;
  }

  public String getPlayerOrTeamName() {
    return playerOrTeamName;
  }

  public boolean isInactive() {
    return inactive;
  }

  public String getPlayerOrTeamId() {
    return playerOrTeamId;
  }

  public String getLeagueName() {
    return leagueName;
  }

  private MiniSeries miniSeries;
  private boolean hotStreak;
  private boolean veteran;
  private int losses;
  private boolean freshBlood;
  private String playerOrTeamName;
  private boolean inactive;
  private String playerOrTeamId;
  private String leagueName;
}
