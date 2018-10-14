package io.vertx.starter.model.league;

import com.google.gson.annotations.SerializedName;

public enum Tier {
  @SerializedName("UNRANKED")
  UNRANKED("UNRANKED"),
  @SerializedName("BRONZE")
  BRONZE("BRONZE"),
  @SerializedName("SILVER")
  SILVER("SILVER"),
  @SerializedName("GOLD")
  GOLD("GOLD"),
  @SerializedName("PLATINUM")
  PLATINUM("PLATINUM"),
  @SerializedName("DIAMOND")
  DIAMOND("DIAMOND"),
  @SerializedName("MASTER")
  MASTER("MASTER"),
  @SerializedName("CHALLENGER")
  CHALLENGER("CHALLENGER");


  private String name;

  Tier(String tier) {
    this.name = tier;
  }
}
