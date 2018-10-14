package io.vertx.starter.model.match.deserializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.vertx.starter.model.Summoner;
import io.vertx.starter.model.match.MatchSummary;
import io.vertx.starter.model.match.Participant;
import io.vertx.starter.model.match.ParticipantStats;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MatchSummaryDeserializer implements JsonDeserializer<MatchSummary> {

  private static Gson gson = new GsonBuilder().create();

  @Override
  public MatchSummary deserialize(JsonElement jsonElement, Type type,
      JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    JsonObject matchObject = jsonElement.getAsJsonObject();
    MatchSummary matchSummary = gson.fromJson(matchObject, MatchSummary.class);
    JsonArray participantsArray = matchObject.getAsJsonArray("participants");
    JsonArray participantsStatsArray = matchObject.getAsJsonArray("participantIdentities");
    Map<Integer, Summoner> summoners = new HashMap<>();
    Map<Integer, Participant> participantsMap = new HashMap<>();
    for (JsonElement je : participantsStatsArray) {
      JsonObject participantIdentObject = je.getAsJsonObject();
      summoners.put(participantIdentObject.get("participantId").getAsInt(),
          gson.fromJson(participantIdentObject.getAsJsonObject("player"), Summoner.class));
    }
    for (JsonElement je : participantsArray) {
      JsonObject participantObject = je.getAsJsonObject();
      Participant participant = gson.fromJson(participantObject, Participant.class);
      ParticipantStats participantStats = gson
          .fromJson(participantObject.getAsJsonObject("stats"), ParticipantStats.class);
      participant.setStats(participantStats);
      int participantId = participantStats.getParticipantId();
      participant.setSummoner(summoners.get(participantId));
      participant.setBlueTeam(participantObject.get("teamId").getAsInt() == 100);
      participantsMap.put(participantId, participant);
    }
    matchSummary.setParticipantsMap(participantsMap);
    return matchSummary;
  }
}
