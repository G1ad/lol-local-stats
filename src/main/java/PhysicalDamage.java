import java.lang.Math;
import java.util.Scanner;

public class PhysicalDamage {

    Scanner sc = new Scanner(System.in);

    public double mitigationDamage() {
        System.out.print("Inserisci il danno: ");
        int attack = sc.nextInt();
        System.out.print("Inserisci l'armor: ");
        int armor = sc.nextInt();
        double realDamage = attack/(1 + (armor / 100f));
        System.out.print("Farai un danno di: ");
        return realDamage;
    }
}

