package main.java;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import main.java.jsData.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import static main.java.Config.API_KEY;
import static main.java.Config.URL;
import static main.java.ApiManager.*;

public class CallSuprema {

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder
            .setPrettyPrinting()
            .serializeNulls()
            .enableComplexMapKeySerialization()
            .create();

    JsonObject parsedJson = JsonParser.parseString(ApiManager.makeApiCall(URL)).getAsJsonObject();
    String jsonBello = gson.toJson(parsedJson);
    JsonElement element = gson.fromJson(jsonBello,JsonElement.class);
    JsonArray jsonArray_allPlayers= parsedJson.getAsJsonArray("allPlayers");
    //Json array del primo player in game che sarebbe "vodka gaming" in teoria
    JsonObject jArrayToObject = (JsonObject)jsonArray_allPlayers.get(0);
    JsonArray jsonArray_items = jArrayToObject.getAsJsonArray("items");
    //JsonObject allPlayerArray =(JsonObject)jsonArray_allPlayers.getAsJsonObject();


    Map<String,Object> userData = new Gson().fromJson(jsonBello,new TypeToken<HashMap<String,Object>>(){}.getType());
    ArrayList arrayListJson = gson.fromJson(jsonArray_allPlayers,ArrayList.class);
    //AllPlayer classAllPlayer = gson.fromJson(allPlayerArray,AllPlayer.class);
    Type userListType = new TypeToken<ArrayList<Item>>(){}.getType();

    //Convert to java
    Map activePlayerMap = (Map)userData.get("activePlayer");
    Map playerAbilities = (Map)activePlayerMap.get("abilities");
    Map playerQ = (Map)playerAbilities.get("Q");
    Map playerW = (Map)playerAbilities.get("W");
    Map playerE = (Map)playerAbilities.get("E");
    Map playerR = (Map)playerAbilities.get("R");
    Map activePlayerMap_championStats = (Map)activePlayerMap.get("championStats");
    String sChampName = String.valueOf(jArrayToObject.get("championName").getAsString());
    String sSummonerName = String.valueOf(jArrayToObject.get("summonerName").getAsString());
    //To json again
    String activePlayerJson = gson.toJson(activePlayerMap);
    String activePlayerJson_championStats = gson.toJson(activePlayerMap_championStats);
    String playerQJson = gson.toJson(playerQ);
    String playerWJson = gson.toJson(playerW);
    String playerEJson = gson.toJson(playerE);
    String playerRjson = gson.toJson(playerR);
    String playerAbilitiesJson = gson.toJson(playerAbilities);

    //Inside Class
    ChampionStats classChampionStats = gson.fromJson(activePlayerJson_championStats,ChampionStats.class);
    ActivePlayer classActivePlayer = gson.fromJson(activePlayerJson,ActivePlayer.class);
    ArrayList<Item> classItem = gson.fromJson(jsonArray_items, userListType);
    Q classPlayerQ = gson.fromJson(playerQJson, Q.class);
    W classPlayerW = gson.fromJson(playerWJson, W.class);
    E classPlayerE = gson.fromJson(playerEJson, E.class);
    R classPlayerR = gson.fromJson(playerRjson, R.class);
    Abilities classPlayerAbilities = gson.fromJson(playerAbilitiesJson, Abilities.class);

    Champion cCurrentChampion = Champion.named(sChampName).get();


    public CallSuprema() throws IOException {
    }
}

