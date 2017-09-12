package comp1510;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 * Salary.
 * @author jay
 * @version 1.0
 */
public class Salary {
    /**
     * Drives the program.
     * @param args command line argument
     */

    public static void main(String[] args) {
        double currentSalary;
        double raise;
        double newSalary;
        final double excellent = 0.06;
        final double good = 0.04;
        final double poor = 0.015;
        String rating;
        String rating1 = "Excellent";
        String rating2 = "Good";
     
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the current salary: ");
        currentSalary = scan.nextDouble();
        System.out.print("Enter the performance rating" 
                + " (Excellent, Good, or Poor): ");
        rating = scan.next();

        if (rating.equalsIgnoreCase(rating1)) {
            raise = currentSalary * excellent;
            newSalary = currentSalary + (raise);
        } else if (rating.equalsIgnoreCase(rating2)) {
            raise = currentSalary * good;
            newSalary = currentSalary + (raise);
        } else {
            raise = currentSalary * poor;
            newSalary = currentSalary + (raise); 
        }

        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("Current Salary : " + money.format(currentSalary));
        System.out.println("Amount of your raise: " + money.format(raise));
        System.out.println("Your new salary: " + money.format(newSalary));
        scan.close();
    }
}
