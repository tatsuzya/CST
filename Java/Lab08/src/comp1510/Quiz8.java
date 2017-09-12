package comp1510;

import java.util.Scanner;

public class Quiz8 {
    public static void main(String[] args) {
        int numStep = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the edge of the boundry");
        int boundry = scan.nextInt();

        System.out.println("Please enter a set of coordinates within the boundry");
        int xCoord = scan.nextInt();
        int yCoord = scan.nextInt();

        RandomWalk rw1 = new RandomWalk(numStep,boundry);
        
        
        for (int i = 0; i < (Math.abs(xCoord)); i++) {
            rw1.takeStep();
            if (rw1.inBound()) {
                numStep++;
            }
            System.out.println("Total Step: " + numStep);

        }
    }
}