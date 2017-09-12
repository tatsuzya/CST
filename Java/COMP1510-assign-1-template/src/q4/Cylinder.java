package q4;

import java.util.Scanner;

/**
 * Cylinder.
 * 
 * @author Jay Lin
 * @version 1.0
 */
public class Cylinder {
    /**
     * Drives the program.
     * @param args command line arguments.
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter radius: ");
        final double radius = scan.nextDouble();

        System.out.println("Please enter height: ");
        final double height = scan.nextDouble();

        final double volumn = Math.PI * radius * radius * height;

        System.out.println("The volume of cylinder with the height of " + height
                + " and with the radius of " + radius + " is " + volumn);
        scan.close();
        System.out.println("Question four was called and ran sucessfully.");
    }

}
