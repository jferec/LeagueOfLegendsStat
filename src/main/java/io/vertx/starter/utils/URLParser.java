package io.vertx.starter.utils;

import io.vertx.starter.model.Region;
import java.util.Map;

public class URLParser {

  public static String putParamsToURL(String url, Map<String, String> params) {
    StringBuilder sb = new StringBuilder(url);
    for (int i = 0; i < params.size(); i++) {
      int start = sb.indexOf("{") + 1;
      int end = sb.indexOf("}");
      if (start < 0 || end < 0) {
        throw new IllegalArgumentException("Wrong url or params");
      }
      sb.replace(start - 1, end + 1, params.get(sb.substring(start, end)));
    }
    return sb.toString();
  }
}
