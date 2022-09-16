package pojo.allGameData;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActivePlayer {

    public Abilities abilities;
    public ChampionStats championStats;
    public double currentGold;
    public FullRunes fullRunes;
    public int level;
    public String summonerName;
    public boolean teamRelativeColors;

    @Override
    public String toString() {
        return "ActivePlayer{" +
                "abilities=" + abilities +
                ", championStats=" + championStats +
                ", currentGold=" + currentGold +
                ", fullRunes=" + fullRunes +
                ", level=" + level +
                ", summonerName='" + summonerName + '\'' +
                ", teamRelativeColors=" + teamRelativeColors +
                '}';
    }
}
