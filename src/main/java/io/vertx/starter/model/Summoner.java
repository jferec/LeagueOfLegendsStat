package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public class Summoner {

  @SerializedName("id")
  private long summonerId;
  private long accountId;
  private Region region;
  private int profileIconId;
  private String name;
  private long summonerLevel;
  private long revisionDate;

  public long getSummonerId() {
    return summonerId;
  }

  public long getAccountId() {
    return accountId;
  }

  public Region getRegion() {
    return region;
  }

  public int getProfileIconId() {
    return profileIconId;
  }

  public String getName() {
    return name;
  }

  public long getSummonerLevel() {
    return summonerLevel;
  }

  public long getRevisionDate() {
    return revisionDate;
  }
}

