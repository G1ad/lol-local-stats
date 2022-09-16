package pojo.ItemStats;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Omnivamp {

    private double flat;
    private double percent;
    @SerializedName(value = "perLevel", alternate = "per_level")
    private double perLevel;
    @SerializedName(value = "percentPerLevel", alternate = "percent_per_level")
    private double percentPerLevel;
    @SerializedName(value = "percentBase", alternate = "percent_base")
    private double percentBase;
    @SerializedName(value = "percentBonus", alternate = "percent_bonus")
    private double percentBonus;

    @Override
    public String toString() {
        return "Omnivamp{" +
                "flat=" + flat +
                ", percent=" + percent +
                ", perLevel=" + perLevel +
                ", percentPerLevel=" + percentPerLevel +
                ", percentBase=" + percentBase +
                ", percentBonus=" + percentBonus +
                '}';
    }
}
