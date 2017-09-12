package comp1510;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * DEli.
 * @author jay
 * @version 1.0
 */

public class Deli {
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String [] args) {
       final double ouncesPerPound = 16.0;
       double pricePerPound;
       double weightOunces; 
       double weight;
       double totalPrice;
       
       Scanner scan = new Scanner(System.in);
       
       NumberFormat money = NumberFormat.getCurrencyInstance();
       DecimalFormat fmt = new DecimalFormat("0.##");
      
       System.out.println("Welcome to the CS Deli! ! \n");
       System.out.println("Enter the price per pound of your item: ");
       pricePerPound = scan.nextDouble();
       System.out.println("Please enter the weight in ounces: ");
       weightOunces = scan.nextDouble();
       
       weight = weightOunces / ouncesPerPound;
       totalPrice = pricePerPound * weight;
       
       
       System.out.println("***** CSDeli *****");
       System.out.println("Unit Price: $4.25 per pound");
       System.out.println("Weight: " + fmt.format(weight) + " pounds");
       System.out.println("Total : " + money.format(totalPrice));
    
       scan.close();
    }
}
