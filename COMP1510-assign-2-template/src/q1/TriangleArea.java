package q1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * TriangleArea.
 * 
 * @author Jay Lin
 * @version 1.0
 */
public class TriangleArea {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        double area;
        double perimeter;
        double s;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the lengths of triangle");
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        perimeter = a + b + c;
        s = 1 / 2 * (a + b + c);

        area = Math.sqrt(s * ((s - a) * (s - b) * (s - c)));

        DecimalFormat df = new DecimalFormat("#.000");

        System.out.println("Perimeter of the triange is: " + df.format(perimeter));
        System.out.println("Area of the triangle is : " + df.format(area));
        System.out.println("Question one was called and ran sucessfully.");

        scan.close();
    }

};
