package pojo.allGameData;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class FullRunes {
    public ArrayList<GeneralRune> generalRunes;
    public Keystone keystone;
    public PrimaryRuneTree primaryRuneTree;
    public SecondaryRuneTree secondaryRuneTree;
    public ArrayList<StatRune> statRunes;

    @Override
    public String toString() {
        return "FullRunes={" +
                "generalRunes=" + generalRunes +
                ", keystone=" + keystone +
                ", primaryRuneTree=" + primaryRuneTree +
                ", secondaryRuneTree=" + secondaryRuneTree +
                ", statRunes=" + statRunes +
                '}';
    }
}
