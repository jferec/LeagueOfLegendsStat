package io.vertx.starter.riot;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.starter.model.Matchlist;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.timeline.MatchTimeline;
import java.util.Map;
import java.util.Set;

public class RiotAPIClientImpl implements RiotAPIClient {

  private WebClient webClient;

  public RiotAPIClientImpl(Vertx v) {
    webClient = WebClient.create(v);
  }


  @Override
  public Summoner getSummonerByAccountId(Map<String, String> params) {
    return null;
  }

  @Override
  public Summoner getSummonerBySummonerName(Map<String, String> params) {
    return null;
  }

  @Override
  public Summoner getSummonerBySummonerId(Map<String, String> params) {
    return null;
  }

  @Override
  public MatchSummary getMatchByMatchId(Map<String, String> params) {
    return null;
  }

  @Override
  public MatchTimeline getMatchTimelineByMatchId(Map<String, String> params) {
    return null;
  }

  @Override
  public Matchlist getMatchlistByAccountId(Map<String, String> params) {
    return null;
  }

  @Override
  public Set<League> getLeaguesBySummonerId(Map<String, String> params) {
    return null;
  }
}
