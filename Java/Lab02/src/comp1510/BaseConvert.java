package comp1510;

import java.util.Scanner;

/**
 * BaseConvert
 * @author jay
 * @version 1.0
 */
public class BaseConvert {

    /**
     * Drives the program
     * @param args
     */
    public static void main(String[] args) {
        int base, base10Num, maxNumber, place0, place1, place2, place3, q1, q2, q3;
        // q = quotient
        String baseBNum = new String("");
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Base Conversion Program");
        System.out.println();
        System.out.println("Please enter a base ( 2 - 9 ): ");
        base = scan.nextInt();

        maxNumber = (base * base * base * base) - 1;
        System.out.println("Largest base 10 value with 4 digits in base " + base + " : " + maxNumber);
        System.out.println("");
        System.out.print("Please enter a base 10 between 0 to " + maxNumber + "  to convert: ");
        base10Num = scan.nextInt();
        scan.close(); 
        
        place0 = base10Num % base;
        q1 = base10Num / base;
        place1 = q1 % base;
        q2 = q1 / base;
        place2 = q2 % base;
        q3 = q2 / base;
        place3 = q3 % base;

        baseBNum = "" + place3 + place2 + place1 + place0;

        System.out.println("");
        System.out.println("The base " + base + " representation of " + base10Num + "(base 10) is " 
        + baseBNum + "(base " + base + ")");
    }
}
