package main.java.jsData;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import main.java.jsData.Event;

import java.util.ArrayList;

@Data
public class Events {
    @SerializedName("Events")
    public ArrayList<Event> events;
}
