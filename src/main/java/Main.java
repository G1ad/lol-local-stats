package main.java;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Item;
import com.merakianalytics.orianna.types.core.staticdata.Items;
import main.java.jsData.E;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import static com.merakianalytics.orianna.types.core.staticdata.Item.named;
import static main.java.Config.*;



public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        SSLUtil.turnOffSslChecking();
        Orianna.setDefaultRegion(Region.EUROPE_WEST);

        Calls call = new Calls();
        CallSuprema callSuprema = new CallSuprema();


        }
}




