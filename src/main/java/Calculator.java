import pojo.ChampionInfo.E;
import pojo.ChampionInfo.Q;
import pojo.ChampionInfo.R;
import pojo.ChampionInfo.W;

import java.io.IOException;

public class Calculator extends Game{

    double AD = getActivePlayer().getChampionStats().getAttackDamage();
    double AP = getActivePlayer().getChampionStats().getAbilityPower();
    double lethality = getActivePlayer().getChampionStats().getArmorPenetrationFlat();
    double armorPen = getActivePlayer().getChampionStats().getArmorPenetrationPercent();


    public Calculator() throws IOException {
    }

    public double flatQ() {
        double totalDamage = getAbilityBaseDamage(Q.class) + flatDamage(Q.class);
        return Math.round(totalDamage);
    }

    public double flatW(){
        double totalDamage = getAbilityBaseDamage(W.class) + flatDamage(W.class);
        return Math.round(totalDamage);

    }

    public double flatE(){
        double totalDamage = getAbilityBaseDamage(E.class) + flatDamage(E.class);
        return Math.round(totalDamage);
    }

    public double flatR(){
        double totalDamage = getAbilityBaseDamage(R.class) + flatDamage(R.class);
        return Math.round(totalDamage);
    }

    public <T> double flatDamage(Class<T> clazz){

        if(getScalingUnit(clazz).contains("% bonus AD")){
            return (bonusAD() * getScalingValue(clazz)) /100;
        }else if(getScalingUnit(clazz).contains("% AD")){
            return (AD * getScalingValue(clazz)) /100;
        } else if(getScalingUnit(clazz).contains("%  of target's current health")) {
            return (AP * getScalingValue(clazz));
        }
        return 0;
    }

    public <T> double getAbilityBaseDamage(Class <T> clazz){

        int qLevel = getActivePlayer().abilities.q.getAbilityLevel();
        int wLevel = getActivePlayer().abilities.w.getAbilityLevel();
        int eLevel = getActivePlayer().abilities.e.getAbilityLevel();
        int rLevel = getActivePlayer().abilities.r.getAbilityLevel();

        if(clazz == Q.class){
            if(stringLeveling(Q.class).matches("\\[\\]")){
                return getRootChamp().abilities.q.get(0).effects.
                        get(1).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);
            }return getRootChamp().abilities.q.get(0).effects.
                    get(0).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);

        } else if(clazz == W.class) {
            if(stringLeveling(W.class).matches("\\[\\]")){
                return getRootChamp().abilities.w.get(0).effects.
                        get(1).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);
            }return getRootChamp().abilities.w.get(0).effects.
                    get(0).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);

        } else if(clazz == E.class) {
            if(stringLeveling(E.class).matches("\\[\\]")){
                return getRootChamp().abilities.e.get(0).effects.
                        get(1).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);
            }return getRootChamp().abilities.e.get(0).effects.
                    get(0).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);

        }else if(clazz == R.class){
            if(stringLeveling(R.class).matches("\\[\\]")){
                return getRootChamp().abilities.r.get(0).effects.
                        get(1).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);
            }return getRootChamp().abilities.r.get(0).effects.
                    get(0).leveling.get(0).modifiers.get(0).getValues().get(qLevel-1);
        }
        return 0;

    }

    public <T> double getScalingValue(Class<T> clazz){

        int qLevel = getActivePlayer().abilities.q.getAbilityLevel();


        if(clazz == Q.class){
            if(stringLeveling(Q.class).matches("\\[\\]")){
                return getRootChamp().abilities.q.get(0).effects.get(1).leveling.get(0).modifiers.get(1).values.get(0);
            //}else if(stringLeveling(Q.class).contains("")) {
                //return getRootChamp().abilities.q.get(0).effects.get(0).leveling.get(0).modifiers.get(1).values.get(0);
            }else if(stringLeveling(Q.class).matches("\\D+")){
                return getRootChamp().abilities.q.get(0).effects.get(1).leveling.get(0).modifiers.get(0).values.get(qLevel-1);
            }

        } else if(clazz == W.class) {
            if(stringLeveling(W.class).matches("\\[\\]")){
                return getRootChamp().abilities.w.get(0).effects.get(1).leveling.get(0).modifiers.get(1).values.get(0);
            }return getRootChamp().abilities.w.get(0).effects.get(0).leveling.get(0).modifiers.get(1).values.get(0);

        } else if(clazz == E.class) {
            if(stringLeveling(E.class).matches("\\[\\]")){
                return getRootChamp().abilities.e.get(0).effects.get(1).leveling.get(0).modifiers.get(1).values.get(0);
            }return getRootChamp().abilities.e.get(0).effects.get(0).leveling.get(0).modifiers.get(1).values.get(0);

        }else if(clazz == R.class){
            if(stringLeveling(R.class).matches("\\[\\]")){
                return getRootChamp().abilities.r.get(0).effects.get(1).leveling.get(0).modifiers.get(1).values.get(0);
            }return getRootChamp().abilities.r.get(0).effects.get(0).leveling.get(0).modifiers.get(1).values.get(0);
        }
            return 0;
    }

    public <T> String getScalingUnit(Class<T> clazz){
        String error = "getScalingUnit() error";

        if(clazz == Q.class){
            if(stringLeveling(Q.class).matches("\\[\\]")){
                return getRootChamp().abilities.q.get(0).effects.get(1).leveling.get(0).modifiers.get(1).units.get(0);
            }return getRootChamp().abilities.q.get(0).effects.get(0).leveling.get(0).modifiers.get(1).units.get(0);

        }else if(clazz == W.class) {
            if(stringLeveling(W.class).matches("\\[\\]")){
                return getRootChamp().abilities.w.get(0).effects.get(1).leveling.get(0).modifiers.get(1).units.get(0);
            }return getRootChamp().abilities.w.get(0).effects.get(0).leveling.get(0).modifiers.get(1).units.get(0);

        }else if(clazz == E.class) {
            if(stringLeveling(E.class).matches("\\[\\]")){
                return getRootChamp().abilities.e.get(0).effects.get(1).leveling.get(0).modifiers.get(1).units.get(0);
            }return getRootChamp().abilities.e.get(0).effects.get(0).leveling.get(0).modifiers.get(1).units.get(0);

        }else if(clazz == R.class){
            if(stringLeveling(R.class).matches("\\[\\]")){
                return getRootChamp().abilities.r.get(0).effects.get(1).leveling.get(0).modifiers.get(1).units.get(0);
            }return getRootChamp().abilities.r.get(0).effects.get(0).leveling.get(0).modifiers.get(1).units.get(0);
        }
        return error;
    }

    public double bonusAD(){

        int currentLevel = getActivePlayer().getLevel();
        double attackDamage  = getRootChamp().stats.attackDamage.getFlat();
        double attackDamageGrowth = getRootChamp().stats.attackDamage.getPerLevel();
        double esponente = Math.pow(currentLevel,2);
        double formula = (7/400f * esponente + 267/400f * currentLevel - 137/200f);
        double statIncreaseAttackDamage = attackDamage + attackDamageGrowth * formula;
        double bonusAD = (getActivePlayer().championStats.attackDamage - statIncreaseAttackDamage);

        return Math.round(bonusAD);
    }


    public <T> String stringLeveling(Class<T> clazz){

        String error = "stringLevelingClass() error";
        if(clazz == Q.class) {
            return String.valueOf(getRootChamp().abilities.q.get(0).effects.get(0).leveling);
        } else if(clazz == W.class) {
            return String.valueOf(getRootChamp().abilities.w.get(0).effects.get(0).leveling);
        } else if(clazz == E.class) {
            return String.valueOf(getRootChamp().abilities.e.get(0).effects.get(0).leveling);
        } else if(clazz == R.class) {
            return String.valueOf(getRootChamp().abilities.r.get(0).effects.get(0).leveling);
        }
        return error;
    }
}



/*

    public double getTotalDamage(){
        return getDamageQ()+getDamageW()+getDamageE()+getDamageR();
    }

    public double getDamageQ(){

        double realDamage = flatQ()/(1 + (enemyOne.getEnemyOneMagicResistance() / 100f));

        return realDamage;
    }*/

/*
    public double getDamageW(){

        double realDamage = flatW()/(1 + (enemyOne.getEnemyOneMagicResistance() / 100f));

        return realDamage;

    }

    public double getDamageE(){

        double realDamage = flatE()/(1 + (enemyOne.getEnemyOneMagicResistance() / 100f));

        return realDamage;

    }
    public double getDamageR(){

        double realDamage = flatR()/(1 + (enemyOne.getEnemyOneMagicResistance() / 100f));

        return realDamage;

    }*/
/*

    }*/
/*
    public double flatW(){

        double wBaseDamage = wDamage.getValues().get(getWLevel()-1);
        double scalingW = getWScalingAD().getValues().get(0);
        double danno = (bonusAD() * scalingW) /100;
        double dannoFinale = wBaseDamage + danno;

        return dannoFinale;
    }



    public double flatR(){

        double rBaseDamage = rDamage.getValues().get(getRLevel()-1);
        double scalingR = getRScalingAD().getValues().get(0);
        double danno = (bonusAD() * scalingR) /100;
        double dannoFinale = rBaseDamage + danno;

        return dannoFinale;
    }


}*/




