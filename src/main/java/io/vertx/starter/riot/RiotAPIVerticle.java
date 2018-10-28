package io.vertx.starter.riot;

import static io.vertx.starter.utils.URLConstants.ACCOUNT_ID;
import static io.vertx.starter.utils.URLConstants.REGION;
import static io.vertx.starter.utils.URLConstants.SUMMONER_ID;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Launcher;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.starter.MainVerticle;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.league.League;
import java.util.Set;

public class RiotAPIVerticle extends AbstractVerticle {

  private Vertx vertx = Vertx.vertx();
  private RiotAPIClient riotAPIClient = new RiotAPIClientImpl(vertx);

  public static void main(final String[] args) {
    Launcher.executeCommand("run", RiotAPIVerticle.class.getName());
  }

  @Override
  public void start(Future<Void> startFuture) {
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);
    router.get("/summonerByAccountId/:" + REGION + "/:" + ACCOUNT_ID).handler(this::getHandler);

    server
        .requestHandler(router::accept)
        .listen(8080);
    System.out.println("Started successfully");
  }

  private void getHandler(RoutingContext rc) {
    Future<Summoner> summonerByAccountId = riotAPIClient.getSummonerByAccountId(rc.pathParams());
    summonerByAccountId.setHandler(ar -> {
      if (ar.succeeded()) {
        rc.response().end(summonerByAccountId.result().getName());
      }
      else {
        rc.response().end("error");
      }
    });
  }

}
