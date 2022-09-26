package pojo.allGameData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Events {

    @JsonProperty("Events")
    public ArrayList<Event> events;
}
