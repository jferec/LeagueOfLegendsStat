package io.vertx.starter.model;

public enum Region {
  EUROPE_WEST("euw1"),
  NORTH_AMERICA("na1"),
  JAPAN("jp1"),
  BRAZIL("BR1"),
  OCEANIA("OC1"),
  RUSSIA("RU"),
  KOREA("KR"),
  TURKEY("TR"),
  LATIN_AMERICA_SOUTH("LA1"),
  LATIN_AMERICA_NORTH("LA2");

  private String name;

  Region(String region) {
    this.name = region;
  }
}
