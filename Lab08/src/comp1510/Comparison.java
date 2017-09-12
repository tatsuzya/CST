package comp1510;

import java.util.Scanner;

/**
 * Comparison.
 * 
 * @author jay
 * @version 1.0
 */
public class Comparison {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String val1, val2, val3;
        int num1, num2, num3;

        System.out.println("Please enter 3 strings: ");
        val1 = scan.next();
        val2 = scan.next();
        val3 = scan.next();
        System.out.println("Largest string: " + Compare3.largest(val1, val2, val3) + "\n");

        System.out.println("Please enter 3 integers: ");
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        num3 = scan.nextInt();

        System.out.println("Largest integer: " + Compare3.largest(num1, num2, num3));

        scan.close();
    }
}
