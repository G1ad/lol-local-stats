package pojo.ItemStats;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {

    @JsonProperty("abilityPower")
    @JsonAlias("ability_power")
    private AbilityPower abilityPower;
    private Armor armor;
    @JsonProperty("armorPenetration")
    @JsonAlias("armor_penetration")
    private ArmorPenetration armorPenetration;
    @JsonProperty("attackDamage")
    @JsonAlias("attack_damage")
    private AttackDamage attackDamage;
    @JsonProperty("attackSpeed")
    @JsonAlias("attack_speed")
    private AttackSpeed attackSpeed;
    @JsonProperty("cooldownReduction")
    @JsonAlias("cooldown_reduction")
    private CooldownReduction cooldownReduction;
    @JsonProperty("criticalStrikeChance")
    @JsonAlias("critical_strike_chance")
    private CriticalStrikeChance criticalStrikeChance;
    @JsonProperty("goldPer_10")
    @JsonAlias("gold_per_10")
    private GoldPer10 goldPer_10;
    @JsonProperty("healAndShieldPower")
    @JsonAlias("heal_and_shield_power")
    private HealAndShieldPower healAndShieldPower;
    private Health health;
    @JsonProperty("healthRegen")
    @JsonAlias("health_regen")
    private HealthRegen healthRegen;
    private Lethality lethality;
    private Lifesteal lifesteal;
    @JsonProperty("magicPenetration")
    @JsonAlias("magic_penetration")
    private MagicPenetration magicPenetration;
    @JsonProperty("magicResistance")
    @JsonAlias("magic_resistance")
    private MagicResistance magicResistance;
    private Mana mana;
    @JsonProperty("manaRegen")
    @JsonAlias("mana_regen")
    private ManaRegen manaRegen;
    private Movespeed movespeed;
    @JsonProperty("abilityHaste")
    @JsonAlias("ability_haste")
    private AbilityHaste abilityHaste;
    private Omnivamp omnivamp;
    private Tenacity tenacity;
}

