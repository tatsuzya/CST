package comp1510;

import java.util.Scanner;

/**
 * DrunkenWalk.
 * 
 * @author jay
 * @version 1.0
 */
public class DrunkenWalk {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        int maxSteps;
        int falls = 0;
        int boundary;
        int drunks;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the boundary");
        boundary = scan.nextInt();
        System.out.println("Please enter max number of steps");
        maxSteps = scan.nextInt();
        System.out.println("Please enter number of drunks");
        drunks = scan.nextInt();

        for (int i = 0; i < drunks; i++) {
            RandomWalk drunk = new RandomWalk(maxSteps, boundary);
            drunk.walk();
            if (!drunk.inBound()) {
                falls++;
            }
        }
        System.out.println("Total fall:" + falls);
        scan.close();
    }
}
