package io.vertx.starter.riot;

public class RiotAPIs {

  public static final String RIOT_API_HOST_URL = "https://{region}.api.riotgames.com";
  public static final String GET_SUMMONER_BY_ACCOUNT_ID = "/lol/summoner/v3/summoners/by-account/{accountId}";
  public static final String GET_SUMMONER_BY_SUMMONER_NAME = "/lol/summoner/v3/summoners/by-name/{summonerName}";
  public static final String GET_SUMMONER_BY_SUMMONER_ID = "/lol/summoner/v3/summoners/{summonerId}";
  public static final String GET_MATCH_BY_MATCH_ID = "/lol/match/v3/matches/{matchId}";
  public static final String GET_MATCH_TIMELINE_BY_MATCH_ID = "/lol/match/v3/matchlists/by-account/{accountId}";
  public static final String GET_MATCHLIST_BY_ACCOUNT_ID = "/lol/match/v3/timelines/by-match/{matchId}";
  public static final String GET_LEAGUE_POSITIONS_BY_SUMMONER_ID = "/lol/league/v3/positions/by-summoner/{summonerId}";

}
