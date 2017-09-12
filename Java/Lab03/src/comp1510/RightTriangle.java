package comp1510;

import java.util.Scanner;
/**
 * RightTriangles
 * @author jay
 * @version 1.0
 */
public class RightTriangle {
    /**
     * Drives the program
     * @param args
     */
    public static void main (String [] args){
        
        double side1, side2, hypotenuse, value;
        
        Scanner scan = new Scanner (System.in);
        
        System.out.print ("Please enter the lengths of the two sides of " 
                + " a right triangle :" );
        side1 = scan.nextInt();
        side2 = scan.nextInt();
        
        value = side1 * side1 + side2 * side2;
        hypotenuse = Math.sqrt(value);
    
        System.out.print ("Length of the hypotenuse is: " + hypotenuse);
        
        scan.close();
    }
}
