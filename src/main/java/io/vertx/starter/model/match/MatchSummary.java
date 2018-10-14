package io.vertx.starter.model.match;

import java.util.List;
import java.util.Map;

public class MatchSummary {

  private int seasonId;
  private int queueId;
  private long gameId;
  private String version;
  private String gameMode;
  private String gameType;
  private int mapId;
  List<TeamStats> teams;
  private Map<Integer, Participant> participantsMap;

  public Map<Integer, Participant> getParticipantsMap() {
    return participantsMap;
  }

  public void setParticipantsMap(
      Map<Integer, Participant> participantsMap) {
    this.participantsMap = participantsMap;
  }

}
