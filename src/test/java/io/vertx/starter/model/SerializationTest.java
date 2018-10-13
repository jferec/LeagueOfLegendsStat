package io.vertx.starter.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.vertx.starter.model.timeline.MatchFrame;
import io.vertx.starter.model.timeline.MatchParticipantFrame;
import io.vertx.starter.model.timeline.MatchTimeline;
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
      throw new IllegalStateException("File failed to load");
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
      throw new IllegalStateException("File failed to load");
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
      throw new IllegalStateException("File failed to load");
    }
    matchlist = gson.fromJson(json, Matchlist.class);
    ArrayList<MatchReference> matches = matchlist.getMatches();
    Assertions.assertEquals(matches.size(), 100);
    Assertions.assertEquals(matchlist.getEndIndex() - matchlist.getStartIndex(), matches.size());
    MatchReference match = matches.get(0);
    Assertions.assertEquals(match.getGameId(), 2055163498);
    match = matches.get(90);
    Assertions.assertEquals(match.getTimestamp(), 1524731268836L);

  }

  @Test
  void testMatchParticipantFrameSerialization() {

    String json;
    MatchParticipantFrame matchParticipantFrame;
    try {
      json = loadTestJsonFromFile("participantframe.json");
    } catch (IOException e) {
      throw new IllegalStateException("File failed to load");
    }
    matchParticipantFrame = gson.fromJson(json, MatchParticipantFrame.class);
    Assertions.assertEquals(matchParticipantFrame.getCurrentGold(), 1391);
    Assertions.assertEquals(matchParticipantFrame.getTotalGold(), 5066);
    Assertions.assertEquals(matchParticipantFrame.getLevel(), 9);
    Assertions.assertEquals(matchParticipantFrame.getMinionsKilled(), 22);
    Assertions.assertEquals(matchParticipantFrame.getParticipantId(), 8);
    Assertions.assertEquals(matchParticipantFrame.getXp(), 5760);
    Assertions.assertEquals(matchParticipantFrame.getJungleMinionsKilled(), 31);

  }

  @Test
  void testMatchFrameSerialization() {

    String json;
    MatchFrame matchFrame;
    try {
      json = loadTestJsonFromFile("matchframe.json");
    } catch (IOException e) {
      throw new IllegalArgumentException("File failed to load");
    }
    matchFrame = gson.fromJson(json, MatchFrame.class);
    Assertions.assertEquals(matchFrame.getTimestamp(), 1380670);
    Assertions.assertNull(matchFrame.getParticipantFrames().get(0));
    Assertions.assertNotNull(matchFrame.getParticipantFrames().get(10));
    MatchParticipantFrame participantFrame = matchFrame.getParticipantFrames().get(2);
    Assertions.assertEquals(participantFrame.getXp(), 10391);
    Assertions.assertEquals(participantFrame.getMinionsKilled(), 170);
    Assertions.assertEquals(participantFrame.getTotalGold(), 9202);
    Assertions.assertEquals(participantFrame.getParticipantId(), 2);
    Assertions.assertEquals(participantFrame.getLevel(), 13);
    Assertions.assertEquals(participantFrame.getJungleMinionsKilled(), 11);

  }

  @Test
  void testMatchTimelineSerialization() {

    String json;
    MatchTimeline matchTimeline;
    try {
      json = loadTestJsonFromFile("matchtimeline.json");
    } catch (IOException e) {
      throw new IllegalArgumentException("File failed to load");
    }
    matchTimeline = gson.fromJson(json, MatchTimeline.class);
    Assertions.assertEquals(matchTimeline.getFrameInterval(), 60000);
    Assertions.assertEquals(matchTimeline.getFrames().size(), 38);
    Assertions.assertEquals(matchTimeline.getFrames().get(25).getParticipantFrames().size(), 10);
  }

  private String loadTestJsonFromFile(String fileName) throws IOException {
    return FileUtils
        .readFileToString(new File(String.format("src/main/resources/testJsons/%s", fileName)),
            "UTF-8");
  }
}
