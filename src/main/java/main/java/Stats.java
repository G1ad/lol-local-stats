package main.java;

public class Stats {
    private String armor;
    private String championStats;

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getChampionStats() {
        return championStats;}

    public void setChampionStats(String championStats) {
        this.championStats = championStats;}

    public Stats() {}

    public Stats(String championStats, String armor){
        this.armor=armor;
        this.championStats = championStats;
    }

}
