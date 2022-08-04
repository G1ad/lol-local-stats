package main.java.jsData;

public class GameData {
    String gameMode;
    double gameTim;
    String mapName;
    int mapNumber;
    String mapTerrain;

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public double getGameTim() {
        return gameTim;
    }

    public void setGameTim(double gameTim) {
        this.gameTim = gameTim;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(int mapNumber) {
        this.mapNumber = mapNumber;
    }

    public String getMapTerrain() {
        return mapTerrain;
    }

    public void setMapTerrain(String mapTerrain) {
        this.mapTerrain = mapTerrain;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "gameMode='" + gameMode + '\'' +
                ", gameTim=" + gameTim +
                ", mapName='" + mapName + '\'' +
                ", mapNumber=" + mapNumber +
                ", mapTerrain='" + mapTerrain + '\'' +
                '}';
    }
}
