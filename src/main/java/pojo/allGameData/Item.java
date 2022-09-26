package pojo.allGameData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    public String displayName;
    public int itemID;
    public int count;
    public int slot;
    public int price;
    public boolean canUse;
    public boolean consumable;
    public String rawDescription;
    public String rawDisplayName;

    //List <Item> itemMaster = gson.fromJson(parsedPlayer0.get("items"), itemsTypeToken);
    //List <Item> itemPlayer = gson.fromJson(parsedPlayer1.get("items"), itemsTypeToken);

}

