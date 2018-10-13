package io.vertx.starter.model;

import com.google.common.collect.ImmutableMap;

public class GameConstants {

  static final ImmutableMap<Integer, String> SEASON_NAMES =
      new ImmutableMap.Builder<Integer, String>()
          .put(0, "PRESEASON 3")
          .put(1, "SEASON 3")
          .put(2, "PRESEASON 4")
          .put(3, "SEASON 2014")
          .put(4, "PRESEASON 2015")
          .put(5, "SEASON 2015")
          .put(6, "PRESEASON 2016")
          .put(7, "SEASON 2016")
          .put(8, "PRESEASON 2017")
          .put(9, "SEASON 2017")
          .put(10, "PRESEASON 2018")
          .put(11, "SEASON 2018")
          .build();

  static final ImmutableMap<Integer, String> QUEUE_NAMES =
      new ImmutableMap.Builder<Integer, String>()
          .put(420, "5v5 Ranked Solo")
          .put(440, "5v5 Ranked Flex")
          .put(470, "3v3 Ranked Flex")
          .build();

  static final ImmutableMap<String, Boolean> MATCH_WIN =
      new ImmutableMap.Builder<String, Boolean>()
          .put("Fail", false)
          .put("Win", true)
          .build();

  static final ImmutableMap<Integer, String> RESPONSE_ERRORS =
      new ImmutableMap.Builder<Integer, String>()
          .put(400, "Bad request")
          .put(401, "Unauthorized")
          .put(403, "Forbidden")
          .put(404, "Data not found")
          .put(405, "Method not allowed")
          .put(415, "Unsupported media type")
          .put(422, "Player exists, but hasn't played since match history collection began")
          .put(429, "Rate limit exceeded")
          .put(500, "Internal server error")
          .put(502, "Bad gateway")
          .put(503, "Service unavailable")
          .put(504, "Gateway timeout")
          .build();

}
