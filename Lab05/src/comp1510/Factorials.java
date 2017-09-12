package comp1510;

import java.util.Scanner;

/**
 * Factorial program.
 * 
 * @author jay
 * @version 1.0
 */
public class Factorials {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int factorial = 1;
        int number;
        System.out.println("Please enter a non-negative number : ");
        number = scan.nextInt();

        int i;
        i = 1;
        while (number < 0) {
            System.out.println("Please reenter");
            number = scan.nextInt();
        }
        while (i <= number) {
            factorial *= i;
            i++;

        }

        if (number >= 1) {
            System.out.println("" + factorial);
        } else if (number == 0) {
            System.out.println("0");
        }
        scan.close();
    }
}
