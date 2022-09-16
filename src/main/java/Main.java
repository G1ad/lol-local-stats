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

        CurrentChampion main = new CurrentChampion();
        CallSuprema supreme = new CallSuprema();
        EnemyOne enemyOne = new EnemyOne();
        Calculator math = new Calculator();

        System.out.println(math.q.getEffects().get(2));

    }
}






