package comp1510;

import java.util.Scanner;
import java.util.Random;
/**
 * Guess.
 * @author jay
 * @version 1.0
 */
public class Guess {
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        int numToGuess;
        int guess = 0;
        boolean tryAgain = false;
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
   
        do {
            System.out.print("Please enter your guess" 
        + " between 1 to 10: ");
            guess = scan.nextInt();
            numToGuess = generator.nextInt(10);
            while (guess != numToGuess) {
                System.out.println("Guess is incorrect");
                System.out.print("Please reenter your guess"
                + " between 1 to 10: ");
                guess = scan.nextInt();
                }
        } while (tryAgain == true);
        System.out.println("Guess is correct");
        scan.close();
    }
}