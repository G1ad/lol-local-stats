package pojo.allGameData;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Abilities {

    @SerializedName("Passive")
    public Passive passive;
    @SerializedName("Q")
    public Q q;
    @SerializedName("E")
    public E e;
    @SerializedName("W")
    public W w;
    @SerializedName("R")
    public R r;


    @Override
    public String toString() {
        return "Abilities:" +
                "\n" + passive +
                ",\n" + q +
                ",\n" + w +
                ",\n" + e +
                ",\n" + r +
                '}';
    }
}

