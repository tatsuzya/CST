package comp1510;

import java.util.Scanner;
/**
 * LabGrade
 * @author jay
 * @version 1.0
 */
public class LabGrade {
    /**
     * Drives the program
     * @param args
     */
    public static void main(String[] args) {

        final double IN_WEIGHT = 0.6;
        final double OUT_WEIGHT = 0.4;

        int preLabPts;
        int preLabMax;
        int labPts;
        int labMax;
        int postLabPts;
        int postLabMax;
        int outClassAvg;
        int inClassAvg;
        double labGrade;

        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome to the Lab Grade Calculator\n");
        System.out.print("Enter the number of points you earned on the pre-lab: ");
        preLabPts = scan.nextInt();
        System.out.print("What was the maximum number of points you could have earned? ");
        preLabMax = scan.nextInt();
        System.out.print("Enter the number of points you earned on the lab: ");
        labPts = scan.nextInt();
        System.out.print("What was the maximum number of points for the lab? ");
        labMax = scan.nextInt();
        System.out.print("Enter the number of points you earned on the post-lab: ");
        postLabPts = scan.nextInt();
        System.out.print("What was the maximum number of points for the post-lab? ");
        postLabMax = scan.nextInt();
        System.out.println();

        
        outClassAvg = 100 * (preLabPts + postLabPts) / (preLabMax + postLabMax);
        inClassAvg = 100 * labPts / labMax;
        labGrade = (OUT_WEIGHT * outClassAvg) + (IN_WEIGHT * inClassAvg);
        
        System.out.println("Your average on out-of-class work is " + outClassAvg + "%");
        System.out.println("Your average on in-class work is " + inClassAvg + "%");
        System.out.println("Your lab grade is " + labGrade + "%");
        System.out.println();
        
    }
}