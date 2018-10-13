package io.vertx.starter.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SerializationTest {

  private static Gson gson;

  @BeforeAll
  static void setUp() {
    gson = new GsonBuilder().create();
  }

  @Test
  void testMatchReferenceSerialization() {

    String json;
    MatchReference matchReference;
    try {
      json = loadTestJsonFromFile("matchreference.json");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Test failed");
    }
    matchReference = gson.fromJson(json, MatchReference.class);
    Assertions.assertEquals(matchReference.getSeason(), 11);
    Assertions.assertEquals(matchReference.getChampion(), 41);
    Assertions.assertEquals(matchReference.getGameId(), 2869196931L);
    Assertions.assertEquals(matchReference.getTimestamp(), 1537268360924L);
    Assertions.assertEquals(matchReference.getRole(), "DUO_CARRY");
    Assertions.assertEquals(matchReference.getRegion(), Region.NORTH_AMERICA);
    Assertions.assertEquals(matchReference.getLane(), "TOP");
    Assertions.assertEquals(matchReference.getQueue(), 420);

  }

  @Test
  void testSummonerSerialization() {
    String json;
    Summoner uman;
    try {
      json = loadTestJsonFromFile("summoner.json");
    } catch (IOException e) {
      throw new IllegalStateException("Test failed");
    }
    uman = gson.fromJson(json, Summoner.class);
    Assertions.assertEquals(uman.getAccountId(), 23548296);
    Assertions.assertEquals(uman.getName(), "MurMakuun");
    Assertions.assertEquals(uman.getSummonerId(), 20411103);
    Assertions.assertEquals(uman.getRevisionDate(), 1539417890000L);
    Assertions.assertEquals(uman.getRegion(), null);
    Assertions.assertEquals(uman.getSummonerLevel(), 40);
    Assertions.assertEquals(uman.getProfileIconId(), 538);

  }

  @Test
  void testMatchlistSerialization() {
    String json;
    Matchlist matchlist;
    try {
      json = loadTestJsonFromFile("matchlist.json");
    } catch (IOException e) {
      throw new IllegalStateException("Test failed");
    }
    matchlist = gson.fromJson(json, Matchlist.class);
    ArrayList<MatchReference> matches = matchlist.getMatches();
    Assertions.assertEquals(matches.size(), 100);
    MatchReference match = matches.get(0);
    Assertions.assertEquals(match.getGameId(), 2055163498);
    match = matches.get(90);
    Assertions.assertEquals(match.getTimestamp(), 1524731268836L);
  }

  private String loadTestJsonFromFile(String fileName) throws IOException {
    return FileUtils
        .readFileToString(new File(String.format("src/main/resources/testJsons/%s", fileName)),
            "UTF-8");
  }
}
