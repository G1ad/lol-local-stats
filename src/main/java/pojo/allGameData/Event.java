package pojo.allGameData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    @JsonProperty("EventID")
    public int eventID;
    @JsonProperty("EventName")
    public String eventName;
    @JsonProperty("EventTime")
    public double eventTime;
}
