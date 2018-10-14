package io.vertx.starter.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.league.MiniSeries;
import io.vertx.starter.model.league.Rank;
import io.vertx.starter.model.league.Tier;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.match.Participant;
import io.vertx.starter.model.match.ParticipantStats;
import io.vertx.starter.model.match.deserializers.MatchSummaryDeserializer;
import io.vertx.starter.model.match.deserializers.ParticipantStatsDeserializer;
import io.vertx.starter.model.timeline.MatchFrame;
import io.vertx.starter.model.timeline.MatchParticipantFrame;
import io.vertx.starter.model.timeline.MatchTimeline;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SerializationTest {

  private static Gson gson;

  @BeforeAll
  static void setUp() {
    gson = new GsonBuilder()
        .registerTypeAdapter(ParticipantStats.class,
            new ParticipantStatsDeserializer())
        .registerTypeAdapter(MatchSummary.class,
            new MatchSummaryDeserializer())
        .create();
  }

  @Test
  void testMatchReferenceDeserialization() {

    MatchReference matchReference = loadObjectFromJson("matchreference.json", MatchReference.class);
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
  void testSummonerDeserialization() {

    Summoner uman = loadObjectFromJson("summoner.json", Summoner.class);
    Assertions.assertEquals(uman.getAccountId(), 23548296);
    Assertions.assertEquals(uman.getMatchHistoryUri(), null);
    Assertions.assertEquals(uman.getName(), "MurMakuun");
    Assertions.assertEquals(uman.getSummonerId(), 20411103);
    Assertions.assertEquals(uman.getRevisionDate(), 1539417890000L);
    Assertions.assertEquals(uman.getRegion(), null);
    Assertions.assertEquals(uman.getSummonerLevel(), 40);
    Assertions.assertEquals(uman.getProfileIconId(), 538);

  }

  @Test
  void testMatchlistDeserialization() {

    Matchlist matchlist = loadObjectFromJson("matchlist.json", Matchlist.class);
    ArrayList<MatchReference> matches = matchlist.getMatches();
    Assertions.assertEquals(matches.size(), 100);
    Assertions.assertEquals(matchlist.getEndIndex() - matchlist.getStartIndex(), matches.size());
    MatchReference match = matches.get(0);
    Assertions.assertEquals(match.getGameId(), 2055163498);
    match = matches.get(90);
    Assertions.assertEquals(match.getTimestamp(), 1524731268836L);

  }

  @Test
  void testMatchParticipantFrameDeserialization() {

    MatchParticipantFrame matchParticipantFrame = loadObjectFromJson("participantframe.json",
        MatchParticipantFrame.class);
    Assertions.assertEquals(matchParticipantFrame.getCurrentGold(), 1391);
    Assertions.assertEquals(matchParticipantFrame.getTotalGold(), 5066);
    Assertions.assertEquals(matchParticipantFrame.getLevel(), 9);
    Assertions.assertEquals(matchParticipantFrame.getMinionsKilled(), 22);
    Assertions.assertEquals(matchParticipantFrame.getParticipantId(), 8);
    Assertions.assertEquals(matchParticipantFrame.getXp(), 5760);
    Assertions.assertEquals(matchParticipantFrame.getJungleMinionsKilled(), 31);

  }

  @Test
  void testMatchFrameDeserialization() {

    MatchFrame matchFrame = loadObjectFromJson("matchframe.json", MatchFrame.class);
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
  void testMatchTimelineDeserialization() {

    MatchTimeline matchTimeline = loadObjectFromJson("matchtimeline.json", MatchTimeline.class);
    Assertions.assertEquals(matchTimeline.getFrameInterval(), 60000);
    Assertions.assertEquals(matchTimeline.getFrames().size(), 38);
    Assertions.assertEquals(matchTimeline.getFrames().get(25).getParticipantFrames().size(), 10);
  }

  @Test
  void testParticipantStatsDeserialization() {

    ParticipantStats participantStats = loadObjectFromJson("participantstats.json",
        ParticipantStats.class);
    Assertions.assertEquals(participantStats.getItems().length, 6);
    Assertions.assertEquals(participantStats.getChampLevel(), 13);
    Assertions.assertEquals(participantStats.getVisionScore(), 49);
    Assertions.assertEquals(participantStats.getLargestCriticalStrike(), 1000);
    Assertions.assertEquals(participantStats.getLargestMultiKill(), 1);
    Assertions.assertEquals(participantStats.getLargestKillingSpree(), 2);
    Assertions.assertEquals(participantStats.getMagicDamageDealtToChampions(), 5549);
    Assertions.assertEquals(participantStats.getQuadraKills(), 1);
    Assertions.assertEquals(participantStats.getTotalTimeCrowdControlDealt(), 182);
    Assertions.assertEquals(participantStats.getMagicalDamageTaken(), 13797);
    Assertions.assertEquals(participantStats.getLongestTimeSpentLiving(), 417);
    Assertions.assertEquals(participantStats.getNeutralMinionsKilledEnemyJungle(), 1);
    Assertions.assertEquals(participantStats.getNeutralMinionsKilledTeamJungle(), 1);
    Assertions.assertEquals(participantStats.isFirstTowerAssist(), true);
    Assertions.assertEquals(participantStats.getGoldEarned(), 9559);
    Assertions.assertEquals(participantStats.getDeaths(), 8);
    Assertions.assertArrayEquals(participantStats.getItems(),
        new int[]{3069, 3107, 2045, 2055, 3117, 3105});
    Assertions.assertEquals(participantStats.getWardsPlaced(), 22);
    Assertions.assertEquals(participantStats.getTurretKills(), 1);
    Assertions.assertEquals(participantStats.getTripleKills(), 1);
    Assertions.assertEquals(participantStats.getDamageSelfMitigated(), 20398);
    Assertions.assertEquals(participantStats.getGoldSpent(), 8325);
    Assertions.assertEquals(participantStats.getMagicDamageDealt(), 14548);
    Assertions.assertEquals(participantStats.getKills(), 1);
    Assertions.assertEquals(participantStats.getDoubleKills(), 3);
    Assertions.assertEquals(participantStats.isFirstInhibitorKill(), true);
    Assertions.assertEquals(participantStats.isFirstBloodAssist(), true);
    Assertions.assertEquals(participantStats.getTrueDamageTaken(), 770);
    Assertions.assertEquals(participantStats.isFirstBloodKill(), true);
    Assertions.assertEquals(participantStats.getAssists(), 14);
    Assertions.assertEquals(participantStats.getNeutralMinionsKilled(), 2);
    Assertions.assertEquals(participantStats.getVisionWardsBoughtInGame(), 3);
    Assertions.assertEquals(participantStats.getDamageDealtToTurrets(), 887);
    Assertions.assertEquals(participantStats.getPhysicalDamageDealtToChampions(), 2092);
    Assertions.assertEquals(participantStats.getPentaKills(), 5);
    Assertions.assertEquals(participantStats.getTrueDamageDealt(), 750);
    Assertions.assertEquals(participantStats.getTrueDamageDealtToChampions(), 10);
    Assertions.assertEquals(participantStats.getChampLevel(), 13);
    Assertions.assertEquals(participantStats.getParticipantId(), 1);
    Assertions.assertEquals(participantStats.isFirstInhibitorAssist(), true);
    Assertions.assertEquals(participantStats.getWardsKilled(), 4);
    Assertions.assertEquals(participantStats.isFirstTowerKill(), true);
    Assertions.assertEquals(participantStats.getTotalHeal(), 13051);
    Assertions.assertEquals(participantStats.getTotalMinionsKilled(), 7);
    Assertions.assertEquals(participantStats.getPhysicalDamageDealt(), 4926);
    Assertions.assertEquals(participantStats.getDamageDealtToObjectives(), 887);
    Assertions.assertEquals(participantStats.getSightWardsBoughtInGame(), 1);
    Assertions.assertEquals(participantStats.getTotalDamageDealtToChampions(), 7642);
    Assertions.assertEquals(participantStats.getTotalUnitsHealed(), 9);
    Assertions.assertEquals(participantStats.getInhibitorKills(), 2);
    Assertions.assertEquals(participantStats.getTotalDamageTaken(), 26979);
    Assertions.assertEquals(participantStats.getTotalDamageDealt(), 20224);
    Assertions.assertEquals(participantStats.getKillingSprees(), 10);
    Assertions.assertEquals(participantStats.getTimeCCingOthers(), 59);
    Assertions.assertEquals(participantStats.getPhysicalDamageTaken(), 12411);
    Assertions.assertEquals(participantStats.isWin(), true);
    Assertions.assertEquals(participantStats.getUnrealKills(), 1);

  }

  @Test
  void testMatchSummaryDeserialization() {

    MatchSummary matchSummary = loadObjectFromJson("match.json", MatchSummary.class);
    Map<Integer, Participant> participants = matchSummary.getParticipantsMap();
    Assertions.assertNotNull(participants);
    Participant participant = participants.get(1);
    Assertions.assertNotNull(participant);
    Assertions.assertEquals(participant.getChampionId(), 40);
    Assertions.assertEquals(participant.getSpell1Id(), 4);
    Assertions.assertEquals(participant.getSpell2Id(), 7);
    Assertions.assertEquals(participant.isBlueTeam(), true);
    Summoner summoner = participant.getSummoner();
    Assertions.assertNotNull(summoner);
    Assertions
        .assertEquals(summoner.getMatchHistoryUri(), "/v1/stats/player_history/EUN1/39630110");
    Assertions.assertEquals(summoner.getName(), "Goddèss0fLové");
    Assertions.assertEquals(summoner.getSummonerId(), 34858586);
    ParticipantStats participantStats = participant.getStats();
    Assertions.assertNotNull(participantStats);
    Assertions.assertEquals(participantStats.isWin(), true);
    Assertions.assertEquals(participantStats.getMagicalDamageTaken(), 13797);
    Assertions.assertEquals(participantStats.getTimeCCingOthers(), 59);
  }

  @Test
  void testMiniSeriesDeserialization() {
    MiniSeries miniSeries = loadObjectFromJson("miniseries.json", MiniSeries.class);
    Assertions.assertEquals(miniSeries.getLosses(), 1);
    Assertions.assertEquals(miniSeries.getWins(), 1);
    Assertions.assertEquals(miniSeries.getTarget(), 2);
    Assertions.assertEquals(miniSeries.getProgress(), "LWN");
  }

  @Test
  void testLeagueDeserialization() {
    League league = loadObjectFromJson("league.json", League.class);
    Assertions.assertEquals(league.getQueueType(), "RANKED_SOLO_5x5");
    Assertions.assertEquals(league.isHotStreak(), true);
    Assertions.assertNotNull(league.getMiniSeries());
    Assertions.assertEquals(league.getMiniSeries().getProgress(), "LNN");
    Assertions.assertEquals(league.getWins(), 160);
    Assertions.assertEquals(league.isVeteran(), true);
    Assertions.assertEquals(league.getLosses(), 141);
    Assertions.assertEquals(league.getPlayerOrTeamId(), "5908");
    Assertions.assertEquals(league.getLeagueName(), "Elise's Berserkers");
    Assertions.assertEquals(league.getPlayerOrTeamName(), "Dyrus");
    Assertions.assertEquals(league.isInactive(), true);
    Assertions.assertEquals(league.getRank(), Rank.IV);
    Assertions.assertEquals(league.isFreshBlood(), true);
    Assertions.assertEquals(league.getTier(), Tier.DIAMOND);
    Assertions.assertEquals(league.getLeaguePoints(), 87);
  }

  private <T> T loadObjectFromJson(String fileName, Class<T> t) {
    String json;
    try {
      json = FileUtils
          .readFileToString(new File(String.format("src/main/resources/testJsons/%s", fileName)),
              "UTF-8");
    } catch (IOException e) {
      throw new IllegalArgumentException("File failed to load");
    }
    return gson.fromJson(json, t);
  }
}
