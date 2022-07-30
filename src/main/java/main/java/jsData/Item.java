package main.java.jsData;

import lombok.Data;

@Data
public class Item {
    public boolean canUse;
    public boolean consumable;
    public int count;
    public String displayName;
    public int itemID;
    public int price;
    public String rawDescription;
    public String rawDisplayName;
    public int slot;
}
