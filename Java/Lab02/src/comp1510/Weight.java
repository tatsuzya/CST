package comp1510;

import java.util.Scanner;
/**
 * Weight.
 * @author jay
 * @version 1.0
 */
public class Weight {
    /** 
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inch, height, Ft, maleWeight, femaleWeight, TotalInch, maleWeight1, maleWeight2, femaleWeight1,
                femaleWeight2;

        System.out.println("Please enter ft: ");
        Ft = scan.nextInt();
        System.out.println("Please enter inch: ");
        inch = scan.nextInt();

        TotalInch = 12 * Ft + inch;
        height = TotalInch - 60;
        maleWeight = 106 + (6 * height);
        femaleWeight = 100 + (5 * height);

        System.out.println("Ideal weight for male who is " + Ft + "'" + inch + " is " + maleWeight);
        System.out.println("Ideal weight for female who is " + Ft + "'" + inch + " is " + femaleWeight);

        maleWeight1 = maleWeight * 115 / 100;
        maleWeight2 = maleWeight * 85 / 100;
        femaleWeight1 = femaleWeight * 115 / 100;
        femaleWeight2 = femaleWeight * 85 / 100;

        System.out.println("Acceptable range for male's ideal weight: " + maleWeight2 + " to " + maleWeight1);
        System.out.println("Acceptable range for female's ideal weight: " + femaleWeight2 + " to " + femaleWeight1);
        
        scan.close();
    }
}
