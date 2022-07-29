package main.java;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.sun.source.tree.AssertTree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException{


        SSLUtil.turnOffSslChecking();
        Orianna.setRiotAPIKey("RGAPI-d9268003-df24-4b49-a7c6-6c6af6dbe0f0");
        Orianna.setDefaultRegion(Region.EUROPE_WEST);

        String path = "C:\\Users\\gladi\\Desktop\\LoL Stats\\LoL\\Nuovo File.json";

        final String GET_URL = "https://127.0.0.1:2999/liveclientdata/allgamedata";
        URL url = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        int responsecode = con.getResponseCode();
        System.out.println("GET Response Code : " + responsecode);

        String inline = "";
        if(responsecode != 200)
            throw new RuntimeException("Httpconnection reposponse code : " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
                inline += sc.nextLine();
            }
            sc.close();
        }


try{
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        //JsonObject jo = JsonParser.parseString(inline).getAsJsonObject();
        //String a = gson.toJson(jo);
        String result = new String(Files.readAllBytes(Path.of(path)));
        Map <String,Object> userData = new Gson().fromJson(result,new TypeToken<HashMap<String,Object>>(){}.getType());
        Map a = (Map)userData.get("activePlayer");
        Map b = (Map)a.get("championStats");
        String gsonString = gson.toJson(b);
        System.out.println(gsonString);



    }catch(Exception e) {
    e.printStackTrace();
    }




/*
        try{
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(gson.toJson(jo));
            fileWriter.close();
        }catch(Exception e) {
            e.printStackTrace();
        }*/

        con.disconnect();
    }
}