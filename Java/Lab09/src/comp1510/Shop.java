package comp1510;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Shop.
 * 
 * @author jay
 * @version 1.0
 */
public class Shop {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping;
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        do {
            System.out.print("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print("Enter the quantity: ");
            quantity = scan.nextInt();
            cart.addToCart(itemName, itemPrice, quantity);
            System.out.println(cart.toString());

            System.out.print("\nContinue shopping (y/n)? ");
            scan.nextLine();
            keepShopping = scan.nextLine();
        } while (keepShopping.equals("y"));

        System.out.println("Please pay: " + fmt.format(cart.getTotal()));
        scan.close();
    }
}