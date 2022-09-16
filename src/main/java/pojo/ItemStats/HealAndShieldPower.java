package pojo.ItemStats;

import lombok.Getter;

@Getter
public class HealAndShieldPower {

    private double flat;
    private double percent;
    private double perLevel;
    private double percentPerLevel;
    private double percentBase;
    private double percentBonus;

    @Override
    public String toString() {
        return "HealAndShieldPower{" +
                "flat=" + flat +
                ", percent=" + percent +
                ", perLevel=" + perLevel +
                ", percentPerLevel=" + percentPerLevel +
                ", percentBase=" + percentBase +
                ", percentBonus=" + percentBonus +
                '}';
    }
}
