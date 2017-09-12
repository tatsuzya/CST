package q2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * CylinderStats.
 * 
 * @author Jay Lin
 * @version 1.0
 */
public class CylinderStats {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        double r;
        double h;
        double area;
        double volumn;
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the radius: ");
        r = scan.nextDouble();
        System.out.print("Please enter the height: ");
        h = scan.nextDouble();

        volumn = Math.PI * r * r;
        area = 2 * Math.PI * (r + h);

        DecimalFormat df = new DecimalFormat("#.0000");

        System.out.println("Volumn of the cylinder is: " + df.format(area));
        System.out.println("Area of the cylinder is: " + df.format(volumn));
        System.out.println("Question two was called and ran sucessfully.");
        scan.close();
    }

}
