package io.vertx.starter.model.timeline;

/**
 * Missing position, teamScore and dominionScore
 */
public class MatchParticipantFrame {

  private int participantId;
  private int totalGold;
  private int level;
  private int currentGold;
  private int minionsKilled;
  private int xp;

  public int getXp() {
    return xp;
  }

  private int jungleMinionsKilled;

  public int getParticipantId() {
    return participantId;
  }

  public int getTotalGold() {
    return totalGold;
  }

  public int getLevel() {
    return level;
  }

  public int getCurrentGold() {
    return currentGold;
  }

  public int getMinionsKilled() {
    return minionsKilled;
  }

  public int getJungleMinionsKilled() {
    return jungleMinionsKilled;
  }
}
