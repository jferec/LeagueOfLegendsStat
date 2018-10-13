package io.vertx.starter.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MatchReferenceTest {

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
      json = FileUtils
          .readFileToString(new File("src/main/resources/testJsons/matchreference.json"), "UTF-8");
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
}
