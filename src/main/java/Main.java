import Config.SSLUtil;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, InterruptedException {

        SSLUtil.turnOffSslChecking();
        Orianna.setDefaultRegion(Region.EUROPE_WEST);

        Game game = new Game();
        Calculator calc = new Calculator(game);

        game.updateGame();

           for(int i = 0; i < game.getAllPlayers().size(); i++) {
               System.out.println(calc.totalDamage(i));
           }
    }
}








