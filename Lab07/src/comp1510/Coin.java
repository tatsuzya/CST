package comp1510;

/**
 * Coin.
 * 
 * @author jay
 * @version 1.0
 */
public class Coin {
    public final int HEADS = 0;
    public final int TAILS = 1;
    private int face;


    public Coin() {
        flip();
    }

    public void flip() {
        face = (int) (Math.random() * 2);
    }


    public boolean isHeads() {
        return (face == HEADS);
    }

    public int getFace() {
        return face;
    }


    public String toString() {
        String faceName;
        if (face == HEADS)
            faceName = "H";
        else
            faceName = "T";
        return faceName + " ";
    }
}
