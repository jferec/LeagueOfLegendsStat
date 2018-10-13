package io.vertx.starter.model;

import java.util.ArrayList;

public class Matchlist {

  private ArrayList<MatchReference> matches;
  private int totalGames;
  private int startIndex;
  private int endIndex;

  public ArrayList<MatchReference> getMatches() {
    return matches;
  }

  public int getTotalGames() {
    return totalGames;
  }

  public int getStartIndex() {
    return startIndex;
  }

  public int getEndIndex() {
    return endIndex;
  }
}
