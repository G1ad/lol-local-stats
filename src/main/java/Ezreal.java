import java.util.Scanner;
public class Ezreal {

    Scanner sc = new Scanner(System.in);

    int hp = 600;
    int hp5 = 4;
    int armor = 24;
    int magicResist = 30;
    int mana = 375;
    double mp5 = 8.5f;
    int attackDamage = 60;

    int hpGrowth = 102;
    double hp5Growth = 0.65f;
    double armorGrowth = 4.7f;
    double magicResistGrowth = 1.3f;
    int manaGrowth = 70;
    double mp5Growth = 0.65f;
    double attackDamageGrowth = 2.5f;



    public String stats() {
        System.out.println("--------------EZREAL--------------");
        System.out.print("Inserisci il livello del campione: ");
        int livello = sc.nextInt();
        double esponente = Math.pow(livello, 2);
        double formula = (7/400f * esponente + 267/400f * livello - 137/200f);
        double statIncreaseHp = hp + hpGrowth * formula;
        double statIncreaseHp5 = hp5 + hp5Growth * formula;
        double statIncreaseArmor = armor + armorGrowth * formula;
        double statIncreaseMagicResist = magicResist + magicResistGrowth * formula;
        double statIncreaseMana = mana + manaGrowth * formula;
        double statIncreaseMp5 = mp5 + mp5Growth * formula;
        double statIncreaseAttackDamage = attackDamage + attackDamageGrowth * formula;

        if (livello > 0) {
            return String.format("Hp: %.2f", statIncreaseHp) +"\n"
                    +String.format("Hp5: %.2f", statIncreaseHp5) +"\n"
                        +String.format("Armor: %.2f", statIncreaseArmor) +"\n"
                            +String.format("Mr: %.2f", statIncreaseMagicResist) +"\n"
                                +String.format("Mana: %.2f", statIncreaseMana) +"\n"
                                    +String.format("Mp5: %.2f", statIncreaseMp5) +"\n"
                                        +String.format("Ad: %.2f", statIncreaseAttackDamage);
        }else {
            return "Il livello non esiste";
        }
    }
}
