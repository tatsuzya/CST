package comp1510;

import java.util.Scanner;

/**
 * TestWalk.
 * 
 * @author jay
 * @version 1.0
 */
public class TestWalk {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument.
     */
    public static void main(String[] args) {
        int maxSteps; // maximum number of steps in a walk
        int maxCoord; // the maximum x and y coordinate
        int x, y; // starting x and y coordinates for a walk


        Scanner scan = new Scanner(System.in);
        System.out.println("\nRandom Walk Test Program");
        System.out.println();
        System.out.print("Enter the boundary for the square: ");
        maxCoord = scan.nextInt();
        System.out.print("Enter the maximum number of steps: ");
        maxSteps = scan.nextInt();
        System.out.print("Enter the starting x and y coordinates with " + "a space between: ");
        x = scan.nextInt();
        y = scan.nextInt();
        System.out.println();
        RandomWalk rw1 = new RandomWalk(10, 5);
        RandomWalk rw2 = new RandomWalk(maxSteps, maxCoord, x, y);

        System.out.println(rw1);
        System.out.println(rw2 + "\n");

        for (int i = 0; i < 5; i++) {
            rw1.takeStep();
            rw2.takeStep();
            System.out.println("Random Walk 1: " + rw1);
            System.out.println("Random Walk 2: " + rw2);
            System.out.println("Max distance random walk 1: " + rw1.getMaxDistance());
            System.out.println("Max distance random walk 2: " + rw2.getMaxDistance());

        }

        System.out.println();
        RandomWalk rw3 = new RandomWalk(200, 10);
        rw3.walk();
        System.out.println(rw3);
        scan.close();
    }
}
