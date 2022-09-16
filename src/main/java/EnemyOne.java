import lombok.Data;
import pojo.ChampionInfo.Armor;
import pojo.ChampionInfo.Root;
import pojo.allGameData.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class EnemyOne extends CallSuprema {

        Root firstEnemy = gson.fromJson(parsedChampionsReader.get(getChampion1Name()), Root.class);

        public double getEnemyOneArmor(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Quanta adaptive force ha ?");
        int num = sc.nextInt();

        double armor = firstEnemy.stats.armor.getFlat();
        double armorGrowth = firstEnemy.stats.armor.getPerLevel();
        double esponente = Math.pow(player1.getLevel(),2);
        double formula = (7/400f * esponente + 267/400f * player1.getLevel() - 137/200f);
        double statIncreaseArmor = armor + armorGrowth * formula;
        double totalArmor = statIncreaseArmor + getEnemyOneBonusArmor();

        if(num==0){
            sc.close();
            return totalArmor;
        }
        else if (num==1){
            sc.close();
            return totalArmor + 6;
        }else if (num==2){
            sc.close();
            return totalArmor + 12;
        }
        return totalArmor;
    }

    public double getEnemyOneBonusArmor(){

        List<String> listItem = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        double sum = 0;

        for(Item i : item1) {
            listItem.add(String.valueOf(parsedItemsReader.get(String.valueOf(i.getItemID())).getAsJsonObject().get("stats").
                    getAsJsonObject().get("armor").getAsJsonObject().get("flat")));
        }
        for(String s : listItem){
            doubleList.add(Double.valueOf(s));
        }
        for(Double d : doubleList){
            sum +=d;
        }
        return sum;
    }

    public double getEnemyOneMagicResistance(){

        double magicResistance = firstEnemy.stats.magicResistance.getFlat();
        double magicResistancePerLevel = firstEnemy.stats.magicResistance.getPerLevel();
        double esponente = Math.pow(player1.getLevel(),2);
        double formula = (7/400f * esponente + 267/400f * player1.getLevel() - 137/200f);
        double statIncreaseMagicResistance = magicResistance + magicResistancePerLevel * formula;
        double totalMagicResistance = statIncreaseMagicResistance + getEnemyOneBonusArmor();

        return totalMagicResistance;
    }

    public double getEnemyOneHealth(){

        double health = firstEnemy.stats.health.getFlat();
        double healthPerLevel = firstEnemy.stats.health.getPerLevel();
        double esponente = Math.pow(player1.getLevel(),2);
        double formula = (7/400f * esponente + 267/400f * player1.getLevel() - 137/200f);
        double statIncreaseMagicResistance = health + healthPerLevel * formula;
        double totalHealth = statIncreaseMagicResistance + getEnemyOneBonusArmor();

        return totalHealth + 15;
    }

    public double getEnemyOneBonusHealth(){

        List<String> listItem = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        double sum = 0;

        for(Item i : item1) {
            listItem.add(String.valueOf(parsedItemsReader.get(String.valueOf(i.getItemID())).getAsJsonObject().get("stats").
                    getAsJsonObject().get("health").getAsJsonObject().get("flat")));
        }
        for(String s : listItem){
            doubleList.add(Double.valueOf(s));
        }
        for(Double d : doubleList){
            sum +=d;
        }
        return sum;
    }

    public double getEnemyOneBonusMagicR(){

        List<String> listItem = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        double sum = 0;

        for(Item i : item1) {
            listItem.add(String.valueOf(parsedItemsReader.get(String.valueOf(i.getItemID())).getAsJsonObject().get("stats").
                    getAsJsonObject().get("magicResistance").getAsJsonObject().get("flat")));
        }
        for(String s : listItem){
            doubleList.add(Double.valueOf(s));
        }
        for(Double d : doubleList){
            sum +=d;
        }
        return sum;
    }



    public EnemyOne() throws IOException {
    }
}
