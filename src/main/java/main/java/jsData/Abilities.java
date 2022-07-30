package main.java.jsData;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
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
}
