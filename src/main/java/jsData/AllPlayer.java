package main.java.jsData;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AllPlayer {
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
}
