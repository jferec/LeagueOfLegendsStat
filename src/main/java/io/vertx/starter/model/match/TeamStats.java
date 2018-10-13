package io.vertx.starter.model.match;

import java.util.ArrayList;

public class TeamStats {
  private boolean firstDragon;
  private boolean firstInhibitor;
  private ArrayList<TeamBan> bans;
  private int baronKills;
  private boolean firstRiftHerald;
  private boolean firstBaron;
  private boolean firstBlood;
  private int teamId;
  private boolean firstTower;
  private int inhibitorKills;

  public boolean isFirstDragon() {
    return firstDragon;
  }

  public boolean isFirstInhibitor() {
    return firstInhibitor;
  }

  public ArrayList<TeamBan> getBans() {
    return bans;
  }

  public int getBaronKills() {
    return baronKills;
  }

  public boolean isFirstRiftHerald() {
    return firstRiftHerald;
  }

  public boolean isFirstBaron() {
    return firstBaron;
  }

  public boolean isFirstBlood() {
    return firstBlood;
  }

  public int getTeamId() {
    return teamId;
  }

  public boolean isFirstTower() {
    return firstTower;
  }

  public int getInhibitorKills() {
    return inhibitorKills;
  }
}
