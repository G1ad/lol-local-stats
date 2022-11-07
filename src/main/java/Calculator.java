import lombok.Data;
import pojo.ChampionInfo.*;
import pojo.allGameData.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Calculator {

    private Game game;

    private double AD;
    private double AP;
    private double lethality;
    private double armorPen;
    //private final DecimalFormat df = new DecimalFormat("0.00");
    //SwingGui gui;

    public Calculator(Game game) throws IOException {
        this.game = game;
        AD = game.getActivePlayer().getChampionStats().getAttackDamage();
        AP = game.getActivePlayer().getChampionStats().getAbilityPower();
        lethality = game.getActivePlayer().getChampionStats().getArmorPenetrationFlat();
        armorPen = game.getActivePlayer().getChampionStats().getArmorPenetrationPercent();
    }

    public String totalDamage(int enemy) throws IOException {

        String champName = game.getAllPlayers().get(enemy).getChampionName();
        String team = "";

        //Getting info about which side is main Champion
        if(champName == game.rootChampionName()){
            team = game.getAllPlayers().get(enemy).getTeam();
        }
        //returning nothing if champions are the same team as main
        if(game.getAllPlayers().get(enemy).getTeam() == team){
            return "";
        }

        String totalDamage = getDamage(Q.class,enemy) + "\t" + getDamage(W.class, enemy) + "\n" +
                getDamage(E.class, enemy) + "\t" + getDamage(R.class, enemy);

        return champName + "\n" + totalDamage;
    }

    public <T> String getDamage(Class<T> clazz , int enemy){

        String error = "Impossible calculate damage";
        String enemyChampion = game.getAllPlayers().get(enemy).getChampionName();

        String damageTypeQ = (String) game.getRootChamp().abilities.q.get(0).getDamageType();
        String damageTypeW = (String) game.getRootChamp().abilities.w.get(0).getDamageType();
        String damageTypeE = (String) game.getRootChamp().abilities.e.get(0).getDamageType();
        String damageTypeR = (String) game.getRootChamp().abilities.r.get(0).getDamageType();

        //Armor
        double damageAdDouble = getChampAbilityDamage(clazz)/
                (1 + (getEnemyResistance(enemy,Armor.class) / 100f));
        String damageAD = String.valueOf(getChampAbilityDamage(clazz)/
                (1 + (getEnemyResistance(enemy,Armor.class) / 100f)));
        //Magic Resistance
        double damageApDouble = getChampAbilityDamage(clazz)/
                (1 + (getEnemyResistance(enemy,MagicResistance.class) / 100f));
        String damageAP = String.valueOf(getChampAbilityDamage(clazz)/
                (1 + (getEnemyResistance(enemy,MagicResistance.class) / 100f)));
        //Q
        if(damageTypeQ == null){
            if(clazz == Q.class)
                return "Q: 0";
        }else if(damageTypeQ.equals("PHYSICAL_DAMAGE") && clazz == Q.class) {
            return String.format("Q: " +"%.5s",damageAD);
        }else if(damageTypeQ.equals("MAGIC_DAMAGE") && clazz == Q.class) {
            return String.format("Q: " +"%.5s",damageAP);}
        //W
       if(damageTypeW == null){
           if(clazz == W.class)
            return "W: 0";
        }else if(damageTypeW.equals("PHYSICAL_DAMAGE") && clazz == W.class){
           return String.format("W: " +" %.5s",damageAD);}
       else if(damageTypeW.equals("MAGIC_DAMAGE") && clazz == W.class) {
           return String.format("W: " +"%.5s",damageAP);}
        //E
        if(damageTypeE == null) {
            if(clazz == E.class)
                return "E: 0";
        }else if(damageTypeE.equals("PHYSICAL_DAMAGE") && clazz == E.class){
            return String.format("E: " +" %.5s",damageAD);
        }else if(damageTypeE.equals("MAGIC_DAMAGE") && clazz == E.class ){
            if(game.getRootChamp().getId() == 34){
                return String.format("E: " +"%.5s/%.5s",damageAP,damageApDouble*2);}
        return String.format("E: " +"%.5s",damageAP);}
        //R
        if(damageTypeR == null) {
            if(clazz == R.class)
                return "R: 0";
        }else if(damageTypeR.equals("PHYSICAL_DAMAGE") && clazz == R.class ){
            return String.format("R: " +" %.5s",damageAD);
        }else if(damageTypeR.equals("MAGIC_DAMAGE") && clazz == R.class ){
            return String.format("R: " +"%.5s",damageAP);}

        return error;
    }


    public <T> double getChampAbilityDamage(Class <T> clazz){
        int qLevel = game.getActivePlayer().abilities.q.getAbilityLevel();
        int wLevel = game.getActivePlayer().abilities.w.getAbilityLevel();
        int eLevel = game.getActivePlayer().abilities.e.getAbilityLevel();
        int rLevel = game.getActivePlayer().abilities.r.getAbilityLevel();
        //Anivia
        if(game.getRootChamp().getId() == 34){
            if(clazz == Q.class) {
                List<Double> damage = Arrays.asList(50.0, 70.0, 90.0, 110.0, 130.0);
                List<Double> detonationDamage = Arrays.asList(50.0, 70.0, 90.0, 110.0, 130.0);
                double scaling = (AP * 25) / 100;
                double finalDamage = damage.get(qLevel-1) + scaling;
                    return finalDamage;
            } else if(clazz == W.class) {
               List <Double> width = Arrays.asList(600.0, 700.0, 800.0, 900.0, 1000.0);
                    return width.get(wLevel-1);
            }else if(clazz == E.class){
                List<Double> damageX = Arrays.asList(50.0, 75.0, 100.0, 125.0, 150.0);
                List<Double> damageY = Arrays.asList(100.0, 150.0, 200.0, 250.0, 300.0);
                double scalingX = (AP * 60) /100;
                double scalingY = (AP * 120) /100;
                double finalDamageX = damageX.get(eLevel-1) + scalingX;
                double finalDamageY = damageY.get(eLevel-1) + scalingY;
                    return finalDamageX; //+ finalDamageY;
            }else if(clazz == R.class) {
                List<Double> damage = Arrays.asList(90.0, 135.0, 180.0);
                double scaling = (AP * 37.5) /100;
                double finalDamage = damage.get(rLevel-1) + scaling;
                    return finalDamage;
            }
        }
        //Ezreal
        if(game.getRootChamp().getId() == 81){
            if(clazz == Q.class) {
                List<Double> damage = Arrays.asList(20.0, 45.0, 70.0, 95.0, 120.0);
                double scaling = ((AD * 130) /100) + ((AP * 15) /100);
                double finalDamage = damage.get(qLevel-1) + scaling;
                    return finalDamage;
            }if(clazz == W.class) {
                List<Double> damage = Arrays.asList(80.0, 135.0, 190.0, 245.0, 300.0);
                double scaling = ((bonusAD() * 60) /100) +((AP * 70) / 100);
                double finalDamage = damage.get(wLevel-1) + scaling;
                    return finalDamage;
            }if(clazz == E.class)  {
                List<Double> damage = Arrays.asList(80.0, 130.0, 180.0, 230.0, 280.0);
                double scaling = ((bonusAD() * 50) /100) + ((AP * 75) /100);
                double finalDamage = damage.get(eLevel-1) + scaling;
                    return finalDamage;
            }if(clazz == R.class) {
                List<Double> damage = Arrays.asList(350.0, 500.0, 650.0);
                double scaling = ((bonusAD() * 100) /100) + ((AP * 90) /100);
                double finalDamage = damage.get(rLevel-1) + scaling;
                    return finalDamage;
            }
        }
        return 0;
    }

    public double bonusAD(){

        int currentLevel = game.getActivePlayer().getLevel();
        double attackDamage  = game.getRootChamp().stats.attackDamage.getFlat();
        double attackDamageGrowth = game.getRootChamp().stats.attackDamage.getPerLevel();
        double esponente = Math.pow(currentLevel,2);
        double formula = (7/400f * esponente + 267/400f * currentLevel - 137/200f);
        double statIncreaseAttackDamage = attackDamage + attackDamageGrowth * formula;
        double bonusAD = (game.getActivePlayer().championStats.attackDamage - statIncreaseAttackDamage);

        return Math.round(bonusAD);
    }


    public <T> double getEnemyBonusResistance(int i, Class<T>clazz){

        List<String> listItem = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        double sum = 0;

        if(clazz == null){
            return 0;
        }
        if(clazz == Armor.class){
            for(Item item : game.getAllPlayers().get(i).getItems()){
                listItem.add(String.valueOf(game.getItemsJson().get(String.valueOf(item.getItemID())).
                        get("stats").get("armor").get("flat")));}
        }
        if(clazz == MagicResistance.class){
            for(Item item : game.getAllPlayers().get(i).getItems()){
                listItem.add(String.valueOf(game.getItemsJson().get(String.valueOf(item.getItemID())).
                        get("stats").get("magicResistance").get("flat")));}
        }
        if(clazz == Health.class){
            for(Item item : game.getAllPlayers().get(i).getItems()){
                listItem.add(String.valueOf(game.getItemsJson().get(String.valueOf(item.getItemID())).
                        get("stats").get("health").get("flat")));}
        }

        for(String s : listItem){
            doubleList.add(Double.valueOf(s));
        }
        for(Double d : doubleList){
            sum+=d;
        }
        return sum;
    }

    public <T> double getEnemyResistance(int enemy, Class <T>clazz){

        int level = game.getAllPlayers().get(enemy).getLevel();
        double statX = 0;
        double statY = 0;

        if(clazz == null){
            return 0;
        }
        if(clazz == Armor.class){
            statX = game.getChampionInfo().get(enemy).getStats().armor.getFlat();
            statY = game.getChampionInfo().get(enemy).getStats().armor.getPerLevel();
        }
        if(clazz == MagicResistance.class){
            statX = game.getChampionInfo().get(enemy).getStats().magicResistance.getFlat();
            statY = game.getChampionInfo().get(enemy).getStats().magicResistance.getPerLevel();
        }
        if(clazz == Health.class){
            statX = game.getChampionInfo().get(enemy).getStats().health.getFlat();
            statY = game.getChampionInfo().get(enemy).getStats().health.getPerLevel();
        }

        double esponente = Math.pow(level,2);
        double formula = (7/400f * esponente + 267/400f * level - 137/200f);
        double stat = statX + statY * formula;
        double totalStat = stat + getEnemyBonusResistance(enemy,clazz);
            return Math.round(totalStat);}
}