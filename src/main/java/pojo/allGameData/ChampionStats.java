package pojo.allGameData;

import lombok.Data;

import java.io.IOException;

@Data
public class ChampionStats {

   public double abilityHaste;
   public double abilityPower;
   public double armor;
   public double armorPenetrationFlat;
   public double armorPenetrationPercent;
   public double attackDamage;
   public double attackRange;
   public double attackSpeed;
   public double bonusArmorPenetrationPercent;
   public double bonusMagicPenetrationPercent;
   public double critChance;
   public double critDamage;
   public double currentHealth;
   public double healShieldPower;
   public double healthRegenRate;
   public double lifeSteal;
   public double magicLethality;
   public double magicPenetrationFlat;
   public double magicPenetrationPercent;
   public double magicResist;
   public double maxHealth;
   public double moveSpeed;
   public double omnivamp;
   public double physicalLethality;
   public double physicalVamp;
   public double resourceMax;
   public double resourceRegenRate;
   public String resourceType;
   public double resourceValue;
   public double spellVamp;
   public double tenacity;

   public ChampionStats() throws IOException {
   }
}





