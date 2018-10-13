package io.vertx.starter.utils;

import static io.vertx.starter.riot.RiotAPI.GET_SUMMONER_BY_SUMMONER_NAME;
import static io.vertx.starter.riot.RiotAPI.RIOT_API_HOST_URL;

import io.vertx.starter.model.Region;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class URLParserTest {

  @Test
  void testCorrectParams() {
    Map<String, String> params = new HashMap<>();
    params.put(URLConstants.REGION, Region.EUROPE_WEST.getName());
    Assertions.assertEquals("https://euw1.api.riotgames.com",
        URLParser.putParamsToURL(RIOT_API_HOST_URL, params));
    params.put(URLConstants.REGION, Region.NORTH_AMERICA.getName());
    params.put(URLConstants.SUMMONER_NAME, "dyrus");
    Assertions.assertEquals("https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/dyrus",
        URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_SUMMONER_BY_SUMMONER_NAME, params));

  }

  @Test
  void testIllegalParams() {
    Map<String, String> params = new HashMap<>();
    params.put(URLConstants.REGION, Region.NORTH_AMERICA.getName());
    params.put("abcdefgh", "illegalParam");
    Assertions.assertEquals(URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_SUMMONER_BY_SUMMONER_NAME, params), null);
  }

  @Test
  void testToManyParams() {
    Map<String, String> params = new HashMap<>();
    params.put(URLConstants.REGION, Region.NORTH_AMERICA.getName());
    params.put(URLConstants.ACCOUNT_ID, "someRandomAccountId");
    params.put(URLConstants.SUMMONER_ID, "someRandomSummonerId");
    Assertions.assertEquals(URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_SUMMONER_BY_SUMMONER_NAME, params), null);
  }

}