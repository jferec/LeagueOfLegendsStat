package io.vertx.starter.riot;

import static io.vertx.starter.utils.URLConstants.REGION;
import static io.vertx.starter.utils.URLConstants.SUMMONER_NAME;
import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.starter.model.Region;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.match.ParticipantStats;
import io.vertx.starter.model.match.deserializers.MatchSummaryDeserializer;
import io.vertx.starter.model.match.deserializers.ParticipantStatsDeserializer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RiotAPIClientImplTest {

  private static String URL_PARSING_FAILED = "URL parsing failed.";
  private static RiotAPIClient riotClient;
  private static Vertx v;
  private Map<String, String> params;

  @BeforeAll
  static void setUp() {
    v = Vertx.vertx();
    riotClient = new RiotAPIClientImpl(v);
  }

  @BeforeEach
  void setUpBeforeEach() {
    params = Maps.newHashMap();
    params.put(REGION, Region.NORTH_AMERICA.name());
  }

  @Test
  void getSummonerByAccountId() {

  }

  @Test
  void getSummonerBySummonerName() {

  }

  @Test
  void getSummonerBySummonerId() {
  }

  @Test
  void getMatchByMatchId() {
  }

  @Test
  void getMatchTimelineByMatchId() {
  }

  @Test
  void getMatchlistByAccountId() {
  }

  @Test
  void getLeaguesBySummonerId() {
  }
}