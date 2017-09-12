package comp1510;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * ShoppingCart.
 * 
 * @author jay
 * @version 1.0
 */
public class ShoppingCart {
    private int itemCount;
    private double totalPrice;
    private int capacity;
    ArrayList<Item> cart = new ArrayList<>();

    // Item[] cart;
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    /**
     * Constructor for the object of type ShoppingCart.
     */
    public ShoppingCart() {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        // cart = new Item[capacity];
    }

    /**
     * add items to cart and calculate the total.
     * 
     * @param itemName
     *            item's name
     * @param price
     *            item's price
     * @param quantity
     *            item's quantity
     */
    public void addToCart(String itemName, double price, int quantity) {
        Item item = new Item(itemName, price, quantity);
        // cart[itemCount] = new Item(itemName, price, quantity);
        cart.add(item);
        totalPrice = totalPrice + (item.getPrice() * item.getQuantity());
        // itemCount++;
    }

    /**
     * Print the content of the cart.
     */
    public String toString() {
        String contents = "\nShopping Cart\n";
        contents += "Item" + "\t\t" + "Unit Price" + "\t" + "Quantity"
                + "\tTotal\n";
        for (int i = 0; i < cart.size(); i++) {
            contents += cart.get(i).toString() + "\n";
        }
        return contents;
    }

    // /**
    // * Increase the size of capacity.
    // */
    // @SuppressWarnings("unused")
    // private void increaseSize() {
    // capacity = capacity + 3;
    // }

    /**
     * Get total.
     * 
     * @return totalPrice
     */
    public double getTotal() {
        return totalPrice;
    }

}