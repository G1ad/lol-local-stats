import Config.SSLUtil;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        SSLUtil.turnOffSslChecking();
        Orianna.setDefaultRegion(Region.EUROPE_WEST);

        Game game = new Game();
        Calculator calc = new Calculator();
        game.updateGame();
        for(int i = 0; i < game.getAllPlayers().size(); i++) {
            System.out.println(game.getAllPlayers().get(i).getChampionName() + " " +i);
        }

    }
}








