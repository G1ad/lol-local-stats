package pojo.allGameData;

import lombok.Getter;

@Getter
public class Q {
    public int abilityLevel;
    public String displayName;
    public String id;
    public String rawDescription;
    public String rawDisplayName;

    @Override
    public String toString() {
        return "Q{" +
                "abilityLevel=" + abilityLevel +
                ", displayName='" + displayName + '\'' +
                ", id='" + id + '\'' +
                ", rawDescription='" + rawDescription + '\'' +
                ", rawDisplayName='" + rawDisplayName + '\'' +
                '}';
    }
}
