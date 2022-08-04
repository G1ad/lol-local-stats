package main.java.jsData;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Abilities {
    @SerializedName("E")
    public E e;
    @SerializedName("Passive")
    public Passive passive;
    @SerializedName("Q")
    public Q q;
    @SerializedName("R")
    public R r;
    @SerializedName("W")
    public W w;

    @Override
    public String toString() {
        return "Abilities: {" +
                "" + e +
                ", " + passive +
                ", " + q +
                ", " + r +
                ", " + w +
                '}';
    }
}

