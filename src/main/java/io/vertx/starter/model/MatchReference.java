package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public class MatchReference {

  private String lane;
  private long gameId;
  private int champion;
  private int season;
  private int queue;
  private String role;
  private long timestamp;
  @SerializedName("platformId")
  private Region region;

  public String getLane() {
    return lane;
  }

  public long getGameId() {
    return gameId;
  }

  public int getChampion() {
    return champion;
  }

  public Region getRegion() {
    return region;
  }

  public int getSeason() {
    return season;
  }

  public int getQueue() {
    return queue;
  }

  public String getRole() {
    return role;
  }

  public long getTimestamp() {
    return timestamp;
  }
}
