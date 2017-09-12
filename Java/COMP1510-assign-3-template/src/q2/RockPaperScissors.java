package q2;

import java.util.Scanner;

/**
 * RockPaperScissors.
 *
 * @author Jay Lin
 * @version 1.0
 */
public class RockPaperScissors {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        Play userPlay;
        String playerPlay;
        Scanner scan = new Scanner(System.in);

        String keepPlaying;
        do {
            System.out.println("Please enter Rock/Paper/Scissors");
            playerPlay = scan.nextLine();
            userPlay = new Play(playerPlay);
            System.out.println("Player's Play : " + userPlay.getPPlay());
            System.out.println("Computer's Play : " + userPlay.getCPlay());
            System.out.println(userPlay.getResult());
            System.out.println("\nContinue? Y/N ");
            keepPlaying = scan.nextLine();
            System.out.println();
        } while (keepPlaying.equalsIgnoreCase("y"));
        scan.close();

        System.out.println("Total wins : " + userPlay.getWin());
        System.out.println("Total Loses : " + userPlay.getLose());
        System.out.println("Total Ties : " + userPlay.getTie());

    }
}
