package pojo.allGameData;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {

    @JsonProperty("Passive")
    public Passive passive;
    @JsonProperty("Q")
    public Q q;
    @JsonProperty("E")
    public E e;
    @JsonProperty("W")
    public W w;
    @JsonProperty("R")
    public R r;

    }


