package pojo.allGameData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.IOException;
import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllPlayers {

    public String championName;
    public boolean isBot;
    public boolean isDead;
    public ArrayList<Item> items;
    public int level;
    public String position;
    public String rawChampionName;
    public double respawnTimer;
    public Runes runes;
    public Scores scores;
    public int skinID;
    public String summonerName;
    public SummonerSpells summonerSpells;
    public String team;


    /*
    public JsonElement getPlayer(int i) {

        JsonElement player = allPlayers.get(i);
        return player;
    }

    public JsonElement getChampionName(int i) {

        JsonElement name = allPlayers.get(i).getAsJsonObject().get("championName");
        return name;
    }*/

    public AllPlayers() throws IOException {}
}
