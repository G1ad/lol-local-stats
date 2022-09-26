package pojo.allGameData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCurrentGame {

    public ActivePlayer activePlayer;
    public ArrayList<AllPlayers> allPlayers;
    public Events events;
    public GameData gameData;

    public DataCurrentGame() throws IOException {
    }
}
