package Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public final class ApiManager {

    public static String makeApiCall(String url) throws IOException {
        try{
            //getting url
            URL httpUrl = new URL(url);
            //creating a connection request
            HttpURLConnection con = (HttpURLConnection) httpUrl.openConnection();
            //setting a GET request
            con.setRequestMethod("GET");
            //opening connection
            con.connect();
            //storing the content in a buffer reader for a better performance
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
            }
            String responseString = content.toString();
            in.close();
            con.disconnect();
                return responseString;
        }catch(Exception ex){
            System.out.println("Fail");
        }
        return null;
    }
}


