package comp1510;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Sales.
 * 
 * @author jay
 * @version 1.0
 */
public class Sales {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        final int SALESPEOPLE = 5;
        @SuppressWarnings("unused")
        int[] sales = new int[SALESPEOPLE];
        double sum;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int salePMax = 0;
        int salePMin = 0;
        int salePerson = 0;
        int amountExd = 0;
        int numSales;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter amounts of salesperson: ");
        numSales = scan.nextInt();
        int[] sale = new int[numSales];
        for (int i = 0; i < sale.length; i++) {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sale[i] = scan.nextInt();
            if (sale[i] > max) {
                max = sale[i];
                salePMax = (i + 1);
            }
            if (sale[i] < min) {
                min = sale[i];
                salePMin = (i + 1);
            }
        }
        System.out.println("\nSalesperson Sales");
        System.out.println(" ------------------ ");
        sum = 0;
        for (int i = 0; i < sale.length; i++) {
            System.out.println("Salesperson " + (i + 1) + " : "
                    + formatter.format(sale[i]));
            sum += sale[i];
        }
        double average = ((double) (sum / numSales));
        System.out.println("\nTotal sales: " + formatter.format(sum));
        System.out.println("\nAverage sales: " + formatter.format(average));
        System.out.println("\nSalesperson " + salePMax
                + " has the highest sale with " + formatter.format(max));
        System.out.println("\nSalesperson " + salePMin
                + " has the least sale with " + formatter.format(min));

        System.out.println("Please enter a cut-off:");
        int cutOff = scan.nextInt();
        for (int i = 0; i < sale.length; i++) {
            if (sale[i] >= cutOff) {
                salePerson = (i + 1);
                amountExd++;
                System.out.println("Salesperson " + salePerson
                        + " exceeds the cutoff with "
                        + formatter.format(sale[i]));
            }
            if (sale[i] < cutOff) {
                salePerson = (i + 1);
                System.out.println("Salesperson " + salePerson
                        + " did not exceed the cutoff");
            }
        }
        System.out.println("\nTotal of " + amountExd
                + " salesperson(s) exceed the cut off");
        scan.close();
    }
}
