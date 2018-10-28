package io.vertx.starter.riot;

import io.vertx.starter.model.Matchlist;
import io.vertx.starter.model.Region;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.timeline.MatchTimeline;
import java.util.Map;
import java.util.Set;
import io.vertx.core.Future;

public interface RiotAPIClient {

  public Future<Summoner> getSummonerByAccountId(Map<String, String> params);

  public Future<Summoner> getSummonerBySummonerName(Map<String, String> params);

  public Future<Summoner> getSummonerBySummonerId(Map<String, String> params);

  public Future<MatchSummary> getMatchByMatchId(Map<String, String> params);

  public Future<MatchTimeline> getMatchTimelineByMatchId(Map<String, String> params);

  public Future<Matchlist> getMatchlistByAccountId(Map<String, String> params);

  public Future<Set<League>> getLeaguesBySummonerId(Map<String, String> params);

}
