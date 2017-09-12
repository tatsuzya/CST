package ca.bcit.cst;
/*
 *	Version 1 (Buggy)
 *
 *	This programs asks the user to enter a number "n" (bigger than 2).
 *	It then prints out the first "n" numbers of the Fibonacci Sequence.
 *	Each number is the sum of the two previous numbers.
 *
 *  Example: The output for n=11 should look exactly like this: 
 *  
 *		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
 *
 *	Fix all compile-time and run-time errors.
 */

import java.util.Scanner;

public class Fibonacci_buggy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Enter a number bigger than 2: ");
        n = scanner.nextInt();

        if (n > 2) {
            printArray(getFiboArray(n));
        }
    }

    private static int[] getFiboArray(int n) {
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f;
    }

    private static void printArray(int[] fiboArray) {
        for (int i = 0; i < fiboArray.length; i++) {
            System.out.print(" " + fiboArray[i] + ",");
        }
        System.out.println(" ...");
    }
}
