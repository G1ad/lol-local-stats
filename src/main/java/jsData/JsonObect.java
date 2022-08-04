package main.java.jsData;

import lombok.Data;
import main.java.jsData.ActivePlayer;
import main.java.jsData.AllPlayer;
import main.java.jsData.Events;
import main.java.jsData.GameData;

import java.util.ArrayList;

@Data
public class JsonObect {
    public ActivePlayer activePlayer;
    public ArrayList<AllPlayer> allPlayers;
    public Events events;
    public GameData gameData;
}
