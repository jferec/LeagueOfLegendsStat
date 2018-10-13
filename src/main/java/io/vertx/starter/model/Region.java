package io.vertx.starter.model;

import com.google.gson.annotations.SerializedName;

public enum Region {

  @SerializedName("EUW")
  EUROPE_WEST("euw1"),
  @SerializedName("NA1")
  NORTH_AMERICA("na1"),
  @SerializedName("JP1")
  JAPAN("jp1"),
  @SerializedName("BR1")
  BRAZIL("br1"),
  @SerializedName("OC1")
  OCEANIA("oc1"),
  @SerializedName("RU")
  RUSSIA("ru"),
  @SerializedName("KR")
  KOREA("kr"),
  @SerializedName("TR")
  TURKEY("tr"),
  @SerializedName("LA1")
  LATIN_AMERICA_SOUTH("la1"),
  @SerializedName("LA2")
  LATIN_AMERICA_NORTH("la2");

  private String name;

  Region(String region) {
    this.name = region;
  }

  public String getName() {
    return name;
  }
}
