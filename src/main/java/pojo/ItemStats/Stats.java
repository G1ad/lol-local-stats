package pojo.ItemStats;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Stats {

    @SerializedName(value="abilityPower", alternate = "ability_power")
    private AbilityPower abilityPower;
    private Armor armor;
    @SerializedName(value="armorPenetration", alternate = "armor_penetration")
    private ArmorPenetration armorPenetration;
    @SerializedName(value = "attackDamage", alternate = "attack_damage")
    private AttackDamage attackDamage;
    @SerializedName(value = "attackSpeed", alternate = "attack_speed")
    private AttackSpeed attackSpeed;
    @SerializedName(value = "cooldownReduction", alternate = "cooldown_reduction")
    private CooldownReduction cooldownReduction;
    @SerializedName(value = "criticalStrikeChance", alternate = "critical_strike_chance")
    private CriticalStrikeChance criticalStrikeChance;
    @SerializedName(value = "goldPer_10", alternate = "gold_per_10")
    private GoldPer10 goldPer_10;
    @SerializedName(value = "healAndShieldPower", alternate = "heal_and_shield_power")
    private HealAndShieldPower healAndShieldPower;
    private Health health;
    @SerializedName(value = "healthRegen", alternate = "health_regen")
    private HealthRegen healthRegen;
    private Lethality lethality;
    private Lifesteal lifesteal;
    @SerializedName(value = "magicPenetration", alternate = "magic_penetration")
    private MagicPenetration magicPenetration;
    @SerializedName(value = "magicResistance", alternate = "magic_resistance")
    private MagicResistance magicResistance;
    private Mana mana;
    @SerializedName(value = "manaRegen", alternate = "mana_regen")
    private ManaRegen manaRegen;
    private Movespeed movespeed;
    @SerializedName(value = "abilityHaste", alternate = "ability_haste")
    private AbilityHaste abilityHaste;
    private Omnivamp omnivamp;
    private Tenacity tenacity;

    @Override
    public String toString() {
        return "Stats={" +
                abilityPower +
                armor +
                armorPenetration +
                attackDamage +
                attackSpeed +
                cooldownReduction +
                criticalStrikeChance +
                goldPer_10 +
                healAndShieldPower +
                health +
                healthRegen +
                lethality +
                lifesteal +
                magicPenetration +
                magicResistance +
                mana +
                manaRegen +
                movespeed +
                abilityHaste +
                omnivamp +
                tenacity +
                ";\n\n";
    }
}
