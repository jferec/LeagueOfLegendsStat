package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public class Summoner {

  @SerializedName(value = "id", alternate = {"summonerId"})
  private long summonerId;
  @SerializedName("currentPlatformId")
  private Region region;
  private long accountId;
  private int profileIconId;
  @SerializedName(value = "name", alternate = {"summonerName"})
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

