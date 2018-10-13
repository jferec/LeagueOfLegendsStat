package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public class Summoner {

  @SerializedName("id")
  private long summonerId;
  @SerializedName("currentPlatformId")
  private Region region;
  private long accountId;
  private int profileIconId;
  private String name;
  private long summonerLevel;
  private long revisionDate;
  private String matchHistoryUri;

  public String getMatchHistoryUri() {
    return matchHistoryUri;
  }

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

