package main.java;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static main.java.HttpConnection.*;

public class CallSuprema {

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder
            .setPrettyPrinting()
            .enableComplexMapKeySerialization()
            .create();

    JsonObject parsedJson = JsonParser.parseString(json).getAsJsonObject();
    JsonArray jsonArray = parsedJson.getAsJsonArray("allPlayers");
    JsonObject jArrayToObject = (JsonObject)jsonArray.get(0);

    String jsonBello = gson.toJson(parsedJson);

    Map<String,Object> userData = new Gson().fromJson(jsonBello,new TypeToken<HashMap<String,Object>>(){}.getType());
    ArrayList arrayListJson = gson.fromJson(jsonArray,ArrayList.class);


    Map activePlayerMap = (Map)userData.get("activePlayer");
    Map activePlayerMap_championStats = (Map)activePlayerMap.get("championStats");

    String cChampName = String.valueOf(jArrayToObject.get("championName").getAsString());
    String activePlayerJson = gson.toJson(activePlayerMap);
    String activePlayerJson_championStats = gson.toJson(activePlayerMap_championStats);

}
