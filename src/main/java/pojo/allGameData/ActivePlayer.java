package pojo.allGameData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.IOException;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivePlayer {

    public Abilities abilities;
    public ChampionStats championStats;
    public double currentGold;
    public FullRunes fullRunes;
    public int level;
    public String summonerName;
    public boolean teamRelativeColors;



    //JsonObject parsedJson = JsonParser.parseString(ApiManager.makeApiCall(Config.URL_LOCAL)).getAsJsonObject();
    //JsonObject parsedActivePlayer = parsedJson.get("activePlayer").getAsJsonObject();


    public ActivePlayer() throws IOException {
    }
}

