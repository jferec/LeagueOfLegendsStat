package io.vertx.starter.model.match;

import com.google.gson.annotations.SerializedName;
import io.vertx.starter.model.Summoner;

/**
 * Skipping ParticipantTimeline
 */
public class Participant {

  private int participantId;
  private Summoner summoner;
  private ParticipantStats stats;
  private boolean isBlueTeam;
  private int spell1Id;
  private int spell2Id;
  private int championId;

  public Summoner getSummoner() {
    return summoner;
  }

  public void setSummoner(Summoner summoner) {
    this.summoner = summoner;
  }

  public ParticipantStats getStats() {
    return stats;
  }

  public void setStats(ParticipantStats stats) {
    this.stats = stats;
  }

  public int getParticipantId() {
    return participantId;
  }

  public boolean isBlueTeam() {
    return isBlueTeam;
  }

  public int getSpell1Id() {
    return spell1Id;
  }

  public int getSpell2Id() {
    return spell2Id;
  }

  public int getChampionId() {
    return championId;
  }

  public void setBlueTeam(boolean blueTeam) {
    isBlueTeam = blueTeam;
  }

}
