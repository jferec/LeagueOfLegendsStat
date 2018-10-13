package io.vertx.starter.model.match.deserializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.vertx.starter.model.match.ParticipantStats;
import java.lang.reflect.Type;

public class ParticipantStatsDeserializer implements JsonDeserializer<ParticipantStats> {

  private static Gson gson = new GsonBuilder().create();

  @Override
  public ParticipantStats deserialize(JsonElement jsonElement, Type type,
      JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

    JsonObject object = jsonElement.getAsJsonObject();
    ParticipantStats participantStats = gson
        .fromJson(object, ParticipantStats.class);

    try {
      participantStats.setItems(
          new int[]{object.get("item0").getAsInt(), object.get("item1").getAsInt(),
              object.get("item2").getAsInt(), object.get("item3").getAsInt(),
              object.get("item4").getAsInt(), object.get("item5").getAsInt()});
      if (object.get("perk0") != null) {
        participantStats.setPerks(
            new int[]{object.get("perk0").getAsInt(), object.get("perk1").getAsInt(),
                object.get("perk2").getAsInt(), object.get("perk3").getAsInt(),
                object.get("perk4").getAsInt(), object.get("perk5").getAsInt()}
        );
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    return participantStats;
  }
}
