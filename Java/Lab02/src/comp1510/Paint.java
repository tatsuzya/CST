package comp1510;

import java.util.Scanner;
/** 
 * Paint
 * @author jay
 * @version 1.0
 */
public class Paint {
    /**
     * Drives into program
     * @param args
     */
    public static void main(String[] args) {
        final int COVERAGE = 350; // paint covers 350 SqFt/gal
        int length, width, height, doors, windows, areaofWindows, areaofDoors;
        double totalSqFt;
        double paintNeeded;

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the length of the room : ");
        length = scan.nextInt();

        System.out.println("Please enter the width of the room : ");
        width = scan.nextInt();

        System.out.println("Please enter the height of the room :");
        height = scan.nextInt();

        totalSqFt = (2 * length * width) + (2 * height * width);

        System.out.println("Total windows: ");
        windows = scan.nextInt();
        System.out.println("Total doors : ");
        doors = scan.nextInt();

        areaofWindows = 15 * windows;
        areaofDoors = 20 * doors;

        System.out.println("Total SqFt to be painted : " + (totalSqFt - areaofDoors - areaofWindows));

        paintNeeded = totalSqFt / COVERAGE;

        System.out.println("Length = " + length);
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.println("Total windows = " + windows);
        System.out.println("Total doors = " + doors);
        System.out.println("gallos of paint needed = " + paintNeeded);

    }
}