package io.vertx.starter.model.timeline;

import java.util.Map;

/**
 * Missing List<MatchEvent>
 */
public class MatchFrame {

  private long timestamp;
  private Map<Integer, MatchParticipantFrame> participantFrames;

  public long getTimestamp() {
    return timestamp;
  }

  public Map<Integer, MatchParticipantFrame> getParticipantFrames() {
    return participantFrames;
  }
}
