package io.vertx.starter.riot;


import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.starter.model.Matchlist;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.timeline.MatchTimeline;
import io.vertx.starter.utils.URLParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RiotAPIURLs {

  private static final String RIOT_API_HOST_URL = "https://{region}.api.riotgames.com";
  private static final String GET_SUMMONER_BY_ACCOUNT_ID = "/lol/summoner/v3/summoners/by-account/{accountId}";
  private static final String GET_SUMMONER_BY_SUMMONER_NAME = "/lol/summoner/v3/summoners/by-name/{summonerName}";
  private static final String GET_SUMMONER_BY_SUMMONER_ID = "/lol/summoner/v3/summoners/{summonerId}";
  private static final String GET_MATCH_BY_MATCH_ID = "/lol/match/v3/matches/{matchId}";
  private static final String GET_MATCH_TIMELINE_BY_MATCH_ID = "/lol/match/v3/matchlists/by-account/{accountId}";
  private static final String GET_MATCHLIST_BY_ACCOUNT_ID = "/lol/match/v3/timelines/by-match/{matchId}";
  private static final String GET_LEAGUE_POSITIONS_BY_SUMMONER_ID = "/lol/league/v3/positions/by-summoner/{summonerId}";

  public static String getSummonerByAccountIdPath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_SUMMONER_BY_ACCOUNT_ID, params);
  }

  public static String getSummonerBySummonerNamePath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_SUMMONER_BY_SUMMONER_NAME, params);
  }

  public static String getSummonerBySummonerIdPath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_SUMMONER_BY_SUMMONER_ID, params);
  }

  public static String getMatchByMatchIdPath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_MATCH_BY_MATCH_ID, params);
  }

  public static String getMatchTimelineByMatchIdPath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_MATCH_TIMELINE_BY_MATCH_ID, params);
  }

  public static String getMatchlistByAccountIdPath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_MATCHLIST_BY_ACCOUNT_ID, params);
  }

  public static String getLeaguesBySummonerIdPath(Map<String, String> params) {
    return URLParser.putParamsToURL(RIOT_API_HOST_URL + GET_LEAGUE_POSITIONS_BY_SUMMONER_ID, params);
  }
}
