package comp1510;
/**
 * Runs.
 * @author jay
 * @version 1.0
 */
public class Runs {
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        final int flips = 100;
        int currentRun = 0;
        int maxRun = 0; 
        Coin coin = new Coin();

        for (int i = 0; i < flips; i++) {
            coin.flip();
            System.out.print(coin.toString());
            if (coin.isHeads()) {
                currentRun++;
            } else {
                currentRun = 0;
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        }
        System.out.println();
        System.out.println("The maxmimum run is: " + maxRun);
        System.out.println("current run length: " + currentRun);
    }
}
