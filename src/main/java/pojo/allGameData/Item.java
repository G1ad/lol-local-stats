package pojo.allGameData;
import lombok.Data;

@Data
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

    @Override
    public String toString() {
        return "Item" +
                " displayName = " + displayName +
                ", itemID = " + itemID +
                ", count = " + count +
                ", slot = " + slot +
                ", price = " + price +
                ", canUse = " + canUse +
                ", consumable = " + consumable +
                ", rawDescription= " + rawDescription  +
                ", rawDisplayName= " + rawDisplayName ;
    }
}

