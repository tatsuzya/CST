package comp1510;

import java.util.Scanner;
/**
 * Average
 * @author jay
 * @version 1.0
 */
public class Average {
    /** 
     * Drives the program
     * @param args
     */
    public static void main(String[] args) {
        int val1, val2, val3;
        double average;
        Scanner scan = new Scanner(System.in);

        // get three values from user
        System.out.println("Please enter three integers and" + " I will compute their average");

        val1 = scan.nextInt();
        val2 = scan.nextInt();
        val3 = scan.nextInt();
        scan.close();
        
        average = (val1 + val2 + val3) / 3;

        System.out.println("The average is " + average);
    }
}