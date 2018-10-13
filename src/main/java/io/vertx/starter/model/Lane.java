package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public enum Lane {

  @SerializedName("TOP")
  TOP,
  @SerializedName("JUNGLE")
  JUNGLE,
  @SerializedName(value = "MIDDLE", alternate = {"MID"})
  MIDDLE,
  @SerializedName(value = "BOTTOM", alternate = {"BOT"})
  BOTTOM;

}
