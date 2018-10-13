package io.vertx.starter.model.timeline;

import java.util.ArrayList;

public class MatchTimeline {
  private long frameInterval;
  private ArrayList<MatchFrame> frames;

  public long getFrameInterval() {
    return frameInterval;
  }

  public ArrayList<MatchFrame> getFrames() {
    return frames;
  }
}
