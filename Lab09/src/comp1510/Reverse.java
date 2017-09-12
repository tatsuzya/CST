package comp1510;

import java.util.Scanner;

/**
 * Reverse.
 * 
 * @author jay
 * @version 1.0
 */
public class Reverse {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        int num;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number of integer for the array: ");
        num = scan.nextInt();
        int[] array = new int[num];
        System.out.print("Please enter " + num + " integer ");

        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("\nOriginal array: ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("\nReversed array:");

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        scan.close();
    }
}
