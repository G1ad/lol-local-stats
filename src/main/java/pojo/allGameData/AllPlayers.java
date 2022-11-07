package pojo.allGameData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.IOException;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllPlayers {

    public String championName;
    public boolean isBot;
    public boolean isDead;
    public List<Item> items;
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


    public AllPlayers() throws IOException {}
}
