package comp1510;

import java.text.NumberFormat;
import java.util.ArrayList;
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
        ArrayList<Item> cart = new ArrayList<Item>();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        double total = 0;
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
            cart.add(new Item(itemName, itemPrice, quantity));

            for (int i = 0; i < cart.size(); i++) {
                Item items = cart.get(i);
                System.out.print(items);
            }
            System.out.print("\nContinue shopping (y/n)? ");
            scan.nextLine();
            keepShopping = scan.nextLine();
        } while (keepShopping.equals("y"));

        for (int i = 0; i < cart.size(); i++) {
            Item items = cart.get(i);
            System.out.print(items);
            total = total + (items.getQuantity() * items.getPrice());
        }

        System.out.println("Price in total: " + fmt.format(total));
        scan.close();
    }
}