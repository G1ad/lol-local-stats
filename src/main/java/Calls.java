package main.java;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.util.ISO8601Utils;
import main.java.jsData.Item;

import java.io.IOException;

import static main.java.ApiManager.*;


public class Calls extends CallSuprema {

    public Calls() throws IOException {
    }

    public void prova(){
        System.out.println(cCurrentChampion);
    }
    public void printJsonBello(){
        System.out.println(jsonBello);

    }

    public void printChampionStats(){
        System.out.println(activePlayerJson_championStats);
    }

    public void printChampName(){
        System.out.println(sChampName);
    }
    public void printActivePlayer(){
        System.out.println(activePlayerMap);
    }
    public void printChampionStatsAsObject(){
        System.out.println(classChampionStats);
    }

    public void printActivePlayerAsObject(){
        System.out.println(activePlayerJson);
    }

    public void printSummonerName(){
        System.out.println(sSummonerName);
    }

    public void printItemsAsObject(){System.out.println(classItem);}

    public void printPlayerQ(){
        System.out.println(classPlayerQ);
    }
    public void printPlayerW(){
        System.out.println(classPlayerW);
    }
    public void printPlayerE(){
        System.out.println(classPlayerE);
    }
    public void printPlayerR(){
        System.out.println(classPlayerR);
    }
    public void printPlayerAbilities(){
        System.out.println(classPlayerAbilities);
    }
}
