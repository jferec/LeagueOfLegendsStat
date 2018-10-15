package io.vertx.starter.riot;

import io.vertx.starter.model.Matchlist;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.timeline.MatchTimeline;
import java.util.Set;

public interface RiotAPIClient {

  public Summoner getSummonerByAccountId(int accountId);

  public Summoner getSummonerBySummonerName(String name);

  public Summoner getSummonerBySummonerId(int summonerId);

  public MatchSummary getMatchByMatchId(int matchId);

  public MatchTimeline getMatchTimelineByMatchId(int matchId);

  public Matchlist getMatchlistByAccountId(int accountId);

  public Set<League> getLeaguesBySummonerId(int summonerId);

}
