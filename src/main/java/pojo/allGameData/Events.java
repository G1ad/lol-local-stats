package pojo.allGameData;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Events {
    @SerializedName("Events")
    public ArrayList<Event> events;
}
