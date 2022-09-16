package Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public final class ApiManager {

    public static String makeApiCall(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) httpUrl.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        int responsecode = con.getResponseCode();
        if(responsecode != 200){
            System.out.println("GET Response Code : " + responsecode);
            System.out.println();
            throw new RuntimeException("Httpconnection reposponse code : " + responsecode);
        }
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        String responseString = content.toString();
        in.close();

        con.disconnect();

        return responseString;

    }
}

