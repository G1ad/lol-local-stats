package main.java.jsData;

import lombok.Data;

@Data
public class ActivePlayer {

    public Abilities abilities;
    public ChampionStats championStats;
    public double currentGold;
    public FullRunes fullRunes;
    public int level;
    public String summonerName;
    public boolean teamRelativeColors;
}
