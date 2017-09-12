package comp1510;

import java.util.Scanner;

/**
 * Circle
 * @author jay
 * @version 1.0
 */

public class Circle {
    /**
     * Drives the program
     * @param page command line argument.
     */
    public static void main(String[] args) {
        System.out.println("Please enter radius: ");

        int radius1;
        Scanner scan = new Scanner(System.in);
        radius1 = scan.nextInt();
        scan.close();

        int radius2;
        final double PI = 3.14159;
        double area = PI * radius1 * radius1;
        double circumference1 = 2 * PI * radius1;
        double circumference2 = 2 * PI * radius1;
        double result = circumference1 / circumference2;

        System.out.println("The area of a circle with radius " + radius1 + " is " + area);
        System.out.println("");
        System.out.println("The circumference of a circle with radius " + radius1 + " is " + circumference1);
        System.out.println("");

        radius2 = 2 * radius1;
        area = PI * radius2 * radius2;
        circumference2 = 2 * PI * radius2;

        System.out.println("The area of a circle with radius " + radius2 + " is " + area);
        System.out.println("");
        System.out.println("The circumference of a circle with radius " + radius2 + " is " + circumference2);
        System.out.println("");

        result = circumference2 / circumference1;
        System.out.println("The circumference grew by " + result + " times");
    }
}
