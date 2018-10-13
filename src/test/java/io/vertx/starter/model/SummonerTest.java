package io.vertx.starter.model;

import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SummonerTest {

  private static Gson gson;

  @BeforeAll
  static void setUp() {
    gson = new GsonBuilder().create();
  }

  @Test
  void testSummonerSerialization() {
    String json;
    Summoner uman;
    try {
      json = FileUtils
          .readFileToString(new File("src/main/resources/testJsons/summoner.json"), "UTF-8");
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

}