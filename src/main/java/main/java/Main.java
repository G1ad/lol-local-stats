package main.java;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.datapipeline.common.HTTPClient;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.spectator.CurrentMatch;
import com.merakianalytics.orianna.types.core.spectator.FeaturedMatches;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.dto.spectator.FeaturedGameInfo;
import com.merakianalytics.orianna.types.dto.staticdata.Champion;

import java.awt.*;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;




public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        SSLUtil.turnOffSslChecking();
        Orianna.setRiotAPIKey("RGAPI-d9268003-df24-4b49-a7c6-6c6af6dbe0f0");
        Orianna.setDefaultRegion(Region.EUROPE_WEST);
        String path = "C:\\Users\\gladi\\Desktop\\LoL Stats\\LoL\\Nuovo File.json";
        HttpConnection.getUrl();
        HttpConnection.jsonLocal();
        Calls call = new Calls();
        call.printChamptionStats();


        //ChampionStats championStats = HttpConnection.gson.fromJson(HttpConnection.gsongString,ChampionStats.class);
        //System.out.println(championStats);




            }
        }



