package pojo.ItemStats;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Omnivamp {

    private double flat;
    private double percent;
    @JsonProperty("perLevel")
    @JsonAlias("per_level")
    private double perLevel;
    @JsonProperty("percentPerLevel")
    @JsonAlias("percent_per_level")
    private double percentPerLevel;
    @JsonProperty("percentBase")
    @JsonAlias("percent_base")
    private double percentBase;
    @JsonProperty("percentBonus")
    @JsonAlias("percent_bonus")
    private double percentBonus;


}
