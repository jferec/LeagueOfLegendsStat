package io.vertx.starter.riot;

import io.vertx.starter.model.Matchlist;
import io.vertx.starter.model.Region;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.timeline.MatchTimeline;
import java.util.Map;
import java.util.Set;

public interface RiotAPIClient {

  public Summoner getSummonerByAccountId(Map<String, String> params);

  public Summoner getSummonerBySummonerName(Map<String, String> params);

  public Summoner getSummonerBySummonerId(Map<String, String> params);

  public MatchSummary getMatchByMatchId(Map<String, String> params);

  public MatchTimeline getMatchTimelineByMatchId(Map<String, String> params);

  public Matchlist getMatchlistByAccountId(Map<String, String> params);

  public Set<League> getLeaguesBySummonerId(Map<String, String> params);

}
