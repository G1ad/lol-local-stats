import Config.ApiManager;
import Config.Config;
import Config.SSLUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import pojo.ChampionInfo.Root;
import pojo.ItemStats.Stats;
import pojo.allGameData.*;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        SSLUtil.turnOffSslChecking();
        Orianna.setDefaultRegion(Region.EUROPE_WEST);

        ObjectMapper mapper = new ObjectMapper();
        File fileItems = new File(Config.FILE_PATH_ITEMS);
        File fileChampions = new File(Config.FILE_PATH_CHAMPIONS);

        JsonNode nodeItems = mapper.readValue(fileItems,JsonNode.class);
        JsonNode nodeChampion = mapper.readValue(fileChampions,JsonNode.class);
        JsonNode currentGameJSON = mapper.readTree(ApiManager.makeApiCall(Config.URL_LOCAL));
        JsonNode activePlayerJSON = currentGameJSON.get("activePlayer");
        JsonNode allPlayersJSON =  currentGameJSON.get("allPlayers");
        ArrayNode itemsMainJSON = allPlayersJSON.get(0).withArray("items");
        ArrayNode itemsEnemyOneJSON = allPlayersJSON.get(1).withArray("items");
        //ArrayNode itemsEnemyTwo = allPlayersJSON.get(2).withArray("items");
        //ArrayNode itemsEnemyThree = allPlayersJSON.get(3).withArray("items");
        //ArrayNode itemsEnemyFour = allPlayersJSON.get(4).withArray("items");
        //ArrayNode itemsEnemyFive = allPlayersJSON.get(5).withArray("items");

        DataCurrentGame currentGame = mapper.treeToValue(currentGameJSON, DataCurrentGame.class);
        ActivePlayer activePlayer = mapper.treeToValue(activePlayerJSON,ActivePlayer.class);
        List<AllPlayers> allPlayers = Arrays.asList(mapper.treeToValue(allPlayersJSON,AllPlayers[].class));
        List<Item> mainItems = Arrays.asList(mapper.treeToValue(itemsMainJSON,Item[].class));
        List<Item> enemyItems = Arrays.asList(mapper.treeToValue(itemsEnemyOneJSON,Item[].class));
        List<Stats> statsItemsMain = Arrays.asList(mapper.convertValue(getGameItems(nodeItems,mainItems),Stats[].class));
        List<Stats> statsItemsEnemy = Arrays.asList(mapper.convertValue(getGameItems(nodeItems,enemyItems),Stats[].class));
        Abilities abilities = mapper.convertValue(activePlayer.getAbilities(),Abilities.class);
        Root root = mapper.treeToValue(nodeChampion.get(allPlayers.get(0).championName),Root.class);
        Root root1 = mapper.treeToValue(nodeChampion.get(allPlayers.get(1).championName),Root.class);

        ArrayList<Double> qScaling = root.abilities.q.get(0).effects.get(0).leveling.get(0).modifiers.get(0).values;
        double qValues = root.abilities.q.get(0).effects.get(0).leveling.get(0).modifiers.get(1).values.get(0);
        double qDamage = qScaling.get(abilities.q.getAbilityLevel()-1);
        double statAD = activePlayer.championStats.attackDamage;
        double danno = qDamage + (qValues * statAD / 100);

        double armor = root1.stats.armor.getFlat();
        double armorGrowth = root1.stats.armor.getPerLevel();
        double esponente = Math.pow(allPlayers.get(1).level,2);
        double formula = (7/400f * esponente + 267/400f * allPlayers.get(1).level - 137/200f);
        double statIncreaseArmor = armor + armorGrowth * formula;

        double finalDamageQ = danno/(1+(statIncreaseArmor/100f));


        System.out.println(finalDamageQ);




    }

    public static List<JsonNode> getGameItems(JsonNode node, List<Item> item) {
        List<JsonNode> listItem = new ArrayList<>();
        for(int i = 0; i < item.size(); i++) {
            listItem.add(node.get(String.valueOf(item.get(i).getItemID())).get("stats"));
        }
        return listItem;
    }
}








