package pojo.allGameData;

import lombok.Data;

import java.util.ArrayList;

@Data
public class JsonObect {
    public ActivePlayer activePlayer;
    public ArrayList<AllPlayer> allPlayers;
    public Events events;
    public GameData gameData;
}
