package comp1510;

import java.util.Scanner;
/**
 * Errors
 * @author jay
 * @version 1.0
 */
public class Errors {
    /**
     * Drives the program
     * @param args
     */
    public static void main(String[] args) {
        String Name; // Name of the user
        int number;
        int numSq;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name, please: ");
        Name = scan.next();

        System.out.print("What is your favorite number?");
        number = scan.nextInt();
        
        numSq = number * number;

        System.out.println(Name + ", the square of your number is " + numSq);
        
        scan.close();
    }
}