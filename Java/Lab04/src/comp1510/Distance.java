package comp1510;

import java.util.Scanner;
/**
 * Distance.
 * @author jay
 * @version 1.0
 */
public class Distance {
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String [] args) {
        final double x1;
        final double y1;
        final double x2;
        final double y2;
        double distance; 
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the coordinates of the first point" 
        + "(put a space betwwen them): ");
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        
        System.out.print("Enter the coordinates of the secod point: ");
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
        
        distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        
        System.out.print("The distance between ( " + x1 + " , " + y1 
                + ") to ( " + x2 + " , " + y2 + ") is : " + distance);
        scan.close();
        
    }
}
