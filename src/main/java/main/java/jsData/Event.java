package main.java.jsData;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Event {

    @SerializedName("EventID")
    public int eventID;
    @SerializedName("EventName")
    public String eventName;
    @SerializedName("EventTime")
    public double eventTime;
}
