import lombok.Data;

import java.io.IOException;

@Data
public class CurrentChampion {


    /*
    Root mainChampion = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()), Root.class);

    Q q = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("Q").getAsJsonArray().get(0),Q.class);
    W w = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("W").getAsJsonArray().get(0),W.class);
    E e = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("E").getAsJsonArray().get(0),E.class);
    R r = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("R").getAsJsonArray().get(0),R.class);



    public ArrayList<Effect> QDamage(){
        return q.effects;
    }

    public double QScaling(){

    Double values = q.effects.get(0).leveling.get(0).modifiers.get(1).values.get(0);
    String units = String.valueOf(q.effects.get(0).leveling.get(0).modifiers.get(1).units.get(0).charAt(0));

    double result = switch(units){
        case "% (+ 3% per 100 AP) of target's current health":
            //2.2%
            double data = ((championStats.abilityPower * 3) /100);
            //4% + 2.2% = 6.2%
            double perCent = values + data;
            //(6.2% x 621)/100 = 38.52
            yield (perCent * enemyOne.getEnemyOneHealth())/100;
        default:
            System.out.println("Wrong sentence");
            yield 0;
    };
        return result;
    }


    Modifier wDamage = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("W").getAsJsonArray().get(0).getAsJsonObject().get("effects").getAsJsonArray().get(0).
        getAsJsonObject().get("leveling").getAsJsonArray().get(0).getAsJsonObject().get("modifiers").
        getAsJsonArray().get(0).getAsJsonObject(),Modifier.class);

    Modifier wScalingAD = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("W").getAsJsonArray().get(0).getAsJsonObject().get("effects").getAsJsonArray().get(1).
        getAsJsonObject().get("leveling").getAsJsonArray().get(0).getAsJsonObject().get("modifiers").
        getAsJsonArray().get(1),Modifier.class);

    Modifier eDamage = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("E").getAsJsonArray().get(0).getAsJsonObject().get("effects").getAsJsonArray().get(0).
        getAsJsonObject().get("leveling").getAsJsonArray().get(0).getAsJsonObject().get("modifiers").
        getAsJsonArray().get(0).getAsJsonObject(),Modifier.class);

    Modifier eScalingAD = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("E").getAsJsonArray().get(0).getAsJsonObject().get("effects").getAsJsonArray().get(1).
        getAsJsonObject().get("leveling").getAsJsonArray().get(0).getAsJsonObject().get("modifiers").
        getAsJsonArray().get(1),Modifier.class);

    Modifier rDamage = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("R").getAsJsonArray().get(0).getAsJsonObject().get("effects").getAsJsonArray().get(0).
        getAsJsonObject().get("leveling").getAsJsonArray().get(0).getAsJsonObject().get("modifiers").
        getAsJsonArray().get(0).getAsJsonObject(),Modifier.class);

    Modifier rScalingAD = gson.fromJson(parsedChampionsReader.get(getCurrentChampion()).getAsJsonObject().get("abilities").
        getAsJsonObject().get("R").getAsJsonArray().get(0).getAsJsonObject().get("effects").getAsJsonArray().get(0).
        getAsJsonObject().get("leveling").getAsJsonArray().get(0).getAsJsonObject().get("modifiers").
        getAsJsonArray().get(0),Modifier.class);*/

    public CurrentChampion() throws IOException {
    }
}
