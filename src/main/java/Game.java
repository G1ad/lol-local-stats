import Config.ApiManager;
import Config.Config;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.ChampionInfo.Root;
import pojo.ItemStats.Stats;
import pojo.allGameData.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private ActivePlayer activePlayer;
    private List<AllPlayers> allPlayers;
    private List<Event> events;
    private GameData gameData;
    private List<List<Item>> gameItems = new ArrayList<>();
    private List<Stats> statsList;
    private List<Root> championInfo;
    private Root rootChamp;
    private Abilities abilities;
    private Root prova;

    public Game() throws IOException {
        updateGame();
    }

    public void updateGame() throws IOException {
        //mapper declaration
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        //list of all lol items
        File fileItems = new File(Config.FILE_PATH_ITEMS);
        JsonNode ITEMS_JSON = mapper.readValue(fileItems,JsonNode.class);
        //list of all lol champions
        File fileChampions = new File(Config.FILE_PATH_CHAMPIONS);
        JsonNode CHAMPIONS_JSON = mapper.readValue(fileChampions,JsonNode.class);
        // get game data and put them into a JsonNode
        JsonNode gameJsonNode = mapper.readTree(ApiManager.makeApiCall(Config.URL_LOCAL));

        //get active player
        this.activePlayer = mapper.treeToValue(gameJsonNode.get("activePlayer"), ActivePlayer.class);
        //get abilities from activePlayer
        this.abilities = mapper.convertValue(activePlayer.getAbilities(), Abilities.class);
        //get all players
        this.allPlayers = mapper.convertValue(gameJsonNode.get("allPlayers"), new TypeReference<List<AllPlayers>>(){});
        //get events
        this.events = mapper.convertValue(gameJsonNode.get("events").get("Events"), new TypeReference<List<Event>>(){});
        //get game data
        this.gameData = mapper.treeToValue(gameJsonNode.get("gameData"), GameData.class);
        //get game items
        try{
            int activePlayers = allPlayers.size();
            for(int i = 0; i < activePlayers; i++) {
                this.gameItems.add(allPlayers.get(i).getItems());
            }
        }catch(Exception ex){
                System.out.println("Items imprinting problem" + ex.getStackTrace());
        }
        //getting stats of every item of each champion
        this.statsList = mapper.convertValue(getGameItemsStats(ITEMS_JSON, gameItems), new TypeReference<List<Stats>>(){});
        //getting full description of a champion
        this.championInfo = mapper.convertValue(getFullChampionInfo(CHAMPIONS_JSON, allPlayers), new TypeReference<List<Root>>(){});
        //getting full info about main champion since the position is different each game
        JsonNode root = mapper.readValue(String.valueOf(CHAMPIONS_JSON.get(rootChampionName())),JsonNode.class);
        this.rootChamp = mapper.treeToValue(root,Root.class);
        JsonNode prova = mapper.readValue((String.valueOf(CHAMPIONS_JSON.get("Jayce"))), JsonNode.class);
        this.prova = mapper.treeToValue(prova,Root.class);
    }

    public List<JsonNode> getGameItemsStats(JsonNode node, List<List<Item>> item) {
        List<JsonNode> listItem = new ArrayList<>();
        for(int i = 0; i < item.size(); i++) {
            for(int j = 0; j < item.get(i).size(); j++) {
                listItem.add(node.get(String.valueOf(item.get(i).get(j).getItemID())).get("stats"));
            }
        }
        return listItem;
    }

    public List<JsonNode> getFullChampionInfo(JsonNode node, List<AllPlayers> allPlayers){
        List<JsonNode> listChampionName = new ArrayList<>();
        int activePlayers = allPlayers.size();
        for(int i = 0; i<activePlayers; i++){
            listChampionName.add(node.get(allPlayers.get(i).getChampionName()));
        }
        return listChampionName;
    }

    public String rootChampionName() throws IOException {

        String vodkaGaming = activePlayer.getSummonerName();
        for(int i = 0; i < allPlayers.size(); i++) {
            if(vodkaGaming.equals(allPlayers.get(i).getSummonerName()))
                return allPlayers.get(i).getChampionName();
        }
        return null;
    }

    public ActivePlayer getActivePlayer() {
        return activePlayer;
    }
    public List<AllPlayers> getAllPlayers() {
        return allPlayers;
    }
    public List<Event> getEvents() {
        return events;
    }
    public GameData getGameData() {
        return gameData;
    }
    public List<List<Item>> getGameItems() {
        return gameItems;
    }
    public List<Stats> getStatsList() {
        return statsList;
    }
    public List<Root> getChampionInfo() {
        return championInfo;
    }
    public Root getRootChamp() {
        return rootChamp;
    }
    public Root getProva() {
        return prova;
    }

    public void setProva(Root prova) {
        this.prova = prova;
    }
    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }
    public void setRootChamp(Root mainChamp) {
        this.rootChamp = mainChamp;
    }
    public void setActivePlayer(ActivePlayer activePlayer) {
        this.activePlayer = activePlayer;
    }
    public void setAllPlayers(List<AllPlayers> allPlayers) {
        this.allPlayers = allPlayers;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
    public void setGameItems(List<List<Item>> gameItems) {
        this.gameItems = gameItems;
    }
    public void setStatsList(List<Stats> statsList) {
        this.statsList = statsList;
    }
    public void setChampionInfo(List<Root> championInfo) {
        this.championInfo = championInfo;
    }
}