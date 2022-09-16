import Config.*;
import pojo.ItemStats.Stats;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import pojo.allGameData.*;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CallSuprema {

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder
            .setPrettyPrinting()
            .serializeNulls()
            .enableComplexMapKeySerialization()
            .create();

    Type itemsTypeToken = new TypeToken<ArrayList<Item>>(){}.getType();
    Type statsTypeToken = new TypeToken<ArrayList<Stats>>(){}.getType();
    //Type championTypeToken = new TypeToken<ArrayList<Root>>(){}.getType();

    JsonObject parsedJson = JsonParser.parseString(ApiManager.makeApiCall(Config.URL_LOCAL)).getAsJsonObject();
    Reader itemsReader = Files.newBufferedReader(Path.of(Config.FILE_PATH_ITEMS));
    Reader championReader = Files.newBufferedReader(Path.of(Config.FILE_PATH_CHAMPIONS));

    JsonArray  parsedAllPlayers = parsedJson.get("allPlayers").getAsJsonArray();
    JsonObject parsedItemsReader = JsonParser.parseReader(itemsReader).getAsJsonObject();
    JsonObject parsedChampionsReader = JsonParser.parseReader(championReader).getAsJsonObject();
    JsonObject parsedActivePlayer = parsedJson.get("activePlayer").getAsJsonObject();
    JsonObject parsedAbilities = parsedJson.get("activePlayer").getAsJsonObject().get("abilities").getAsJsonObject();
    JsonObject parsedPlayer0 = parsedAllPlayers.get(0).getAsJsonObject();
    JsonObject parsedPlayer1 = parsedAllPlayers.get(1).getAsJsonObject();

    ActivePlayer activePlayer = gson.fromJson(parsedActivePlayer,ActivePlayer.class);
    AllPlayer player0= gson.fromJson(parsedPlayer0,AllPlayer.class);
    AllPlayer player1= gson.fromJson(parsedPlayer1,AllPlayer.class);
    ChampionStats championStats = gson.fromJson(parsedActivePlayer.get("championStats"),ChampionStats.class);
    Abilities abilitiesLive = gson.fromJson(parsedAbilities, Abilities.class);
    List <Item> item = gson.fromJson(parsedPlayer0.get("items"), itemsTypeToken);
    List <Item> item1 = gson.fromJson(parsedPlayer1.get("items"), itemsTypeToken);
    List <Stats> stats = gson.fromJson(String.valueOf(getGameItemIds()), statsTypeToken);


    public List<JsonElement> getGameItemIds(){

        List<JsonElement> listItem = new ArrayList<>();
        for(Item i : item) {
            listItem.add(parsedItemsReader.get(String.valueOf(i.getItemID())).getAsJsonObject().get("stats").
                    getAsJsonObject().get("attackDamage"));
        }
        return listItem;
    }

    public int getCurrentLevel(){
        return activePlayer.getLevel();
    }

    public String getSummonerName(){
        return activePlayer.getSummonerName();
    }

    public String getCurrentChampion(){
        return player0.getChampionName();
    }

    public String getChampion1Name(){

        switch(player1.championName){
            case "Wukong":
                player1.setChampionName("MonkeyKing");
                break;
        }
        return player1.championName;
    }

    public String getAbilitiesLive(){
        return abilitiesLive.toString();
    }

    public String getPassiveName(){
        return abilitiesLive.getPassive().getDisplayName();
    }

    public String getQName(){
        return abilitiesLive.getQ().getDisplayName();
    }

    public String getWName(){
        return abilitiesLive.getW().getDisplayName();
    }

    public String getEName(){return abilitiesLive.getE().getDisplayName();}

    public String getRName(){
        return abilitiesLive.getR().getDisplayName();
    }

    public int getQLevel(){
        return abilitiesLive.getQ().getAbilityLevel();
    }
    public int getWLevel(){
        return abilitiesLive.getW().getAbilityLevel();
    }
    public int getELevel(){
        return abilitiesLive.getE().getAbilityLevel();
    }
    public int getRLevel(){
        return abilitiesLive.getR().getAbilityLevel();
    }

    public String getChampionStats(){
        return championStats.toString();
    }

    public double getChampionAD(){
        return championStats.getAttackDamage();
    }

    public double getChampionAP(){
        return championStats.getAbilityPower();
    }

    public ArrayList<Item> getItems0(){
        return player0.getItems();
    }

    public CallSuprema() throws IOException {}
}

