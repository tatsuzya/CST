package q1;

import java.util.Scanner;

/**
 * Statistics.
 *
 * @author jay
 * @version 1.0
 */
public class Statistics {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        int nextValue;
        float standardDev;
        float mean;
        float sum = 0;
        final int size = 50;
        int count = 0;
        int i = 0;
        int[] value = new int[size];
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            nextValue = scan.nextInt();
            sum = sum + nextValue;
            count++;
            value[i] = nextValue;
            i++;
        }

        mean = sum / count;
        sum = 0;
        for (i = 0; i < count; i++) {
            sum = sum + (float) Math.pow((value[i] - mean), 2);
        }
        standardDev = (float) Math.sqrt(sum / (count - 1));

        System.out.println("Mean : " + mean);
        System.out.println("Standar Deviation : " + standardDev);
        System.out.println("Question one was called and ran sucessfully.");
        scan.close();
    }
}
