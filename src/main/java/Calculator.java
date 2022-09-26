import java.io.IOException;

public class Calculator{



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
    public double flatQ(){

        double qBaseDamage = QDamage().get(getQLevel()-1);
        //130%
        double scalingQ = QScaling();
        //  (95.42 Ezreal lvl 1 q), (110,5 lvl 4 q)
        double danno = (getChampionAD() * scalingQ) /100;
        //20 + 95.42
        double dannoFinale = qBaseDamage + danno;
        //115.42 lvl1, 205,17 lvl 10(q lvl 4)
        return qBaseDamage + scalingQ;
    }*/
/*
    public double flatW(){

        double wBaseDamage = wDamage.getValues().get(getWLevel()-1);
        double scalingW = getWScalingAD().getValues().get(0);
        double danno = (bonusAD() * scalingW) /100;
        double dannoFinale = wBaseDamage + danno;

        return dannoFinale;
    }

    public double flatE(){

        double eBaseDamage = eDamage.getValues().get(getELevel()-1);
        double scalingE = getEScalingAD().getValues().get(0);
        double danno = (bonusAD() * scalingE) /100;
        double dannoFinale = eBaseDamage + danno;

        return dannoFinale;
    }

    public double flatR(){

        double rBaseDamage = rDamage.getValues().get(getRLevel()-1);
        double scalingR = getRScalingAD().getValues().get(0);
        double danno = (bonusAD() * scalingR) /100;
        double dannoFinale = rBaseDamage + danno;

        return dannoFinale;
    }

    public double bonusAD(){

        double attackDamage = mainChampion.getStats().getAttackDamage().getFlat();
        double attackDamageGrowth = mainChampion.getStats().getAttackDamage().getPerLevel();
        double esponente = Math.pow(getCurrentLevel(),2);
        double formula = (7/400f * esponente + 267/400f * getCurrentLevel() - 137/200f);
        double statIncreaseAttackDamage = attackDamage + attackDamageGrowth * formula;
        double bonusAD = getChampionAD() - statIncreaseAttackDamage;

        return bonusAD;
    }

    public double getScalingAD(Modifier scaling){

        if(scaling==qScalingAD){
            return qScalingAD.getValues().get(0);}
        else if(scaling==wScalingAD) {
            return wScalingAD.getValues().get(0);}
        else if(scaling==eScalingAD) {
            return eScalingAD.getValues().get(0);}
        else if (scaling==rScalingAD){
            return rScalingAD.getValues().get(0);}

        return scaling.getValues().get(0);
    }
*/
    public Calculator() throws IOException {}
}
