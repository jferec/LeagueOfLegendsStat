package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public class MatchReference {

  private String lane;
  private long gameId;
  private int champion;
  @SerializedName("platformId")
  private Region region;
  private int season;
  private int queue;
  private String role;
  private long timestamp;

}
