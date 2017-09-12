package comp1510;

/**
 * ComparePlayers
 * 
 * @author jay
 * @version 1.0
 */
public class ComparePlayers extends Player {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Please enter first player");
        System.out.println("Please enter second player");

        player1.readPlayer();
        player2.readPlayer();
        if (player1.equals(player2))
            System.out.println("same player");
        else
            System.out.println("different player");

    }
}
