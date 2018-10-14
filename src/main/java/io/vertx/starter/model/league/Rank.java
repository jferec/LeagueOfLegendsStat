package io.vertx.starter.model.league;

import com.google.gson.annotations.SerializedName;

public enum Rank {
  @SerializedName("I")
  I("I"),
  @SerializedName("II")
  II("II"),
  @SerializedName("III")
  III("III"),
  @SerializedName("IV")
  IV("IV"),
  @SerializedName("V")
  V("V");

  private String rank;

  Rank(String rank) {
    this.rank = rank;
  }

  public String getRank() {
    return rank;
  }
}
