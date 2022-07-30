package main.java.jsData;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FullRunes {
    public ArrayList<GeneralRune> generalRunes;
    public Keystone keystone;
    public PrimaryRuneTree primaryRuneTree;
    public SecondaryRuneTree secondaryRuneTree;
    public ArrayList<StatRune> statRunes;
}
