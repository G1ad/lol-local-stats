package main.java;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import main.java.jsData.AllPlayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static java.lang.Character.getType;

public final class HttpConnection {

    static String json = "";
    static Scanner sc;
    static int responsecode;
    static URL url;
    static final String GET_URL = "https://127.0.0.1:2999/liveclientdata/allgamedata";


    public static void getUrl() throws IOException {
        url = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
        responsecode = con.getResponseCode();
            System.out.println("GET Response Code : " + responsecode);
            System.out.println();
        if(responsecode != 200){
            throw new RuntimeException("Httpconnection reposponse code : " + responsecode);
        }
        con.disconnect();
    }

        public static void jsonLocal() throws IOException {
        //Upload del Json in "json" contenente i dati del game locale
            sc = new Scanner(url.openStream());
                while(sc.hasNext()){
                    json+= sc.next();
        }
            sc.close();
    }


        HttpConnection(){
            throw new UnsupportedOperationException("Bad call");
    }
}

