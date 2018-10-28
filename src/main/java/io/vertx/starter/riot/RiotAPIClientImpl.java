package io.vertx.starter.riot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.starter.model.Matchlist;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.match.ParticipantStats;
import io.vertx.starter.model.match.deserializers.MatchSummaryDeserializer;
import io.vertx.starter.model.match.deserializers.ParticipantStatsDeserializer;
import io.vertx.starter.model.timeline.MatchTimeline;
import io.vertx.starter.utils.URLConstants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RiotAPIClientImpl implements RiotAPIClient {

  private static String URL_PARSING_FAILED = "URL parsing failed.";
  private WebClient webClient;
  private Gson gson;

  public RiotAPIClientImpl(Vertx v) {
    webClient = WebClient.create(v);
    gson = new GsonBuilder()
        .registerTypeAdapter(ParticipantStats.class,
            new ParticipantStatsDeserializer())
        .registerTypeAdapter(MatchSummary.class,
            new MatchSummaryDeserializer())
        .create();
  }

  @Override
  public Future<Summoner> getSummonerByAccountId(Map<String, String> params) {
    String url = RiotAPIURLs.getSummonerByAccountIdPath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<Summoner> request = Future.future();
    sendRequestWithJsonObjectResponse(request, url, Summoner.class);
    return request;
  }

  @Override
  public Future<Summoner> getSummonerBySummonerName(Map<String, String> params) {
    String url = RiotAPIURLs.getSummonerBySummonerNamePath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<Summoner> request = Future.future();
    sendRequestWithJsonObjectResponse(request, url, Summoner.class);
    return request;
  }

  @Override
  public Future<Summoner> getSummonerBySummonerId(Map<String, String> params) {
    String url = RiotAPIURLs.getSummonerBySummonerIdPath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<Summoner> request = Future.future();
    sendRequestWithJsonObjectResponse(request, url, Summoner.class);
    return request;
  }

  @Override
  public Future<MatchSummary> getMatchByMatchId(Map<String, String> params) {
    String url = RiotAPIURLs.getMatchByMatchIdPath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<MatchSummary> request = Future.future();
    sendRequestWithJsonObjectResponse(request, url, MatchSummary.class);
    return request;
  }

  @Override
  public Future<MatchTimeline> getMatchTimelineByMatchId(Map<String, String> params) {
    String url = RiotAPIURLs.getMatchTimelineByMatchIdPath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<MatchTimeline> request = Future.future();
    sendRequestWithJsonObjectResponse(request, url, MatchTimeline.class);
    return request;
  }

  @Override
  public Future<Matchlist> getMatchlistByAccountId(Map<String, String> params) {
    String url = RiotAPIURLs.getMatchlistByAccountIdPath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<Matchlist> request = Future.future();
    sendRequestWithJsonObjectResponse(request, url, Matchlist.class);
    return request;
  }

  @Override
  public Future<Set<League>> getLeaguesBySummonerId(Map<String, String> params) {
    String url = RiotAPIURLs.getLeaguesBySummonerIdPath(params);
    if (url == null) {
      return Future.failedFuture(URL_PARSING_FAILED);
    }
    Future<Set<League>> request = Future.future();
    sendRequestWithJsonArrayResponse(request, url, League.class);
    return request;
  }

  private <T> void sendRequestWithJsonObjectResponse(Future<T> future, String url, Class<T> clazz) {
    webClient.getAbs(url).putHeader(URLConstants.X_RIOT_TOKEN, URLConstants.X_RIOT_TOKEN_VALUE)
        .send(ar -> handleJsonObjectResponse(ar, clazz, future));
  }

  private <T> void sendRequestWithJsonArrayResponse(Future<Set<T>> future, String url,
      Class<T> clazz) {
    webClient.getAbs(url).putHeader(URLConstants.X_RIOT_TOKEN, URLConstants.X_RIOT_TOKEN_VALUE)
        .send(ar -> handleJsonArrayResponse(ar, clazz, future));
  }

  //You can't get class from type in runtime
  private <T> void handleJsonObjectResponse(AsyncResult<HttpResponse<Buffer>> ar, Class<T> clazz,
      Future<T> future) {
    if (ar.succeeded()) {
      switch (ar.result().statusCode()) {
        case 200:
          JsonObject object = ar.result().bodyAsJsonObject();
          T result = gson.fromJson(object.toString(), clazz);
          future.complete(result);
          break;
        default:
          future.fail("Not found.");
      }
    } else {
      future.fail("Error with completing the request.");
    }
  }

  private <T> void handleJsonArrayResponse(AsyncResult<HttpResponse<Buffer>> ar, Class<T> clazz,
      Future<Set<T>> future) {
    if (ar.succeeded()) {
      switch (ar.result().statusCode()) {
        case 200:
          JsonArray array = ar.result().bodyAsJsonArray();
          Set<T> results = new HashSet<>();
          for (int i = 0; i < array.size(); i++) {
            JsonObject object = array.getJsonObject(i);
            T result = gson.fromJson(object.toString(), clazz);
            results.add(result);
          }
          future.complete(results);
          break;
        default:
          future.fail("Not found.");
      }
    } else {
      future.fail("Error with completing the request.");
    }
  }
}
