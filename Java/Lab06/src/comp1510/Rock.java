package comp1510;

import java.util.Scanner;
import java.util.Random;

/**
 * Rock.
 * 
 * @author jay
 * @version 1.0
 */
public class Rock {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        String personPlay;
        String computerPlay;
        int computerInt;

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("Please enter R/P/S");
        personPlay = scan.nextLine();
        personPlay = personPlay.toUpperCase();
        System.out.println("Player's Play: " + personPlay);

        computerInt = generator.nextInt(3);

        switch (computerInt) {
        case 0:
            computerPlay = "R";
            break;
        case 1:
            computerPlay = "P";
            break;
        case 2:
            computerPlay = "S";
            break;
        default:
            computerPlay = "will not happen";
        }
        System.out.println("Computer's play: " + computerPlay);
        if (personPlay.equals(computerPlay)) {
            System.out.println("It's a tie!");
        } else if (personPlay.equals("R")) {
            if (computerPlay.equals("S")) {
                System.out.println("Rock crushes scissors.  You win!!");
            } else if (computerPlay.equals("P")) {
                System.out.println("Paper eats rock. You lose!!");
            }
        } else if (personPlay.equals("P")) {
            if (computerPlay.equals("S")) {
                System.out.println("Scissor cuts paper. You lose!!");
            } else if (computerPlay.equals("R")) {
                System.out.println("Paper eats rock. You win!!");
            }
        } else if (personPlay.equals("S")) {
            if (computerPlay.equals("P")) {
                System.out.println("Scissor cuts paper. You win!!");
            } else if (computerPlay.equals("R")) {
                System.out.println("Rock breaks scissors. You lose!!");
            }
        } else {
            System.out.println("Invalid.");
        }
        scan.close();
    }
}