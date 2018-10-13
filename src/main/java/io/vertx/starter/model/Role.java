package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public enum Role {

  @SerializedName("DUO")
  DUO,
  @SerializedName("NONE")
  NONE,
  @SerializedName("SOLO")
  SOLO,
  @SerializedName("DUO_CARRY")
  DUO_CARRY,
  @SerializedName("DUO_SUPPORT")
  DUO_SUPPORT

}
