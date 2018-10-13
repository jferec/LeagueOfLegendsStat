package io.vertx.starter.utils;

import io.vertx.starter.model.Region;
import java.util.Map;

public class URLParser {

  public static String putParamsToURL(String url, Map<String, String> params)
      throws IllegalArgumentException {
    StringBuilder sb = new StringBuilder(url);
    try {
      for (int i = 0; i < params.size(); i++) {
        int start = sb.indexOf("{") + 1;
        int end = sb.indexOf("}");
        if (start < 0 || end < 0) {
          throw new IllegalArgumentException("Wrong number of params");
        }
        String param = params.get(sb.substring(start, end));
        if (param == null) {
          throw new IllegalArgumentException("Wrong parameter provided");
        }
        sb.replace(start - 1, end + 1, param);
      }
      return sb.toString();
    } catch (IllegalArgumentException e) {
      return null;
    }
  }
}
