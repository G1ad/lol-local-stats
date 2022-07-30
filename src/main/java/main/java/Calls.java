package main.java;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static main.java.HttpConnection.*;


public class Calls extends CallSuprema{

    public void printJsonBello(){
        System.out.println(jsonBello);
    }

    public void printChamptionStats(){
        System.out.println(activePlayerJson_championStats);
    }

    public void printChampName(){
        System.out.println(cChampName);
    }
    public void printActivePlayer(){
        System.out.println(activePlayerMap);
    }
}
