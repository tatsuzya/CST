package comp1510;

import java.text.NumberFormat;

/**
 * Item.
 * 
 * @author jay
 * @version 1.0
 */
public class Item {
    /** name of the item. */
    private String name;
    /** price of the item. */
    private double price;
    /** quantity of the item. */
    private int quantity;

    /**
     * Create a new item with the given attributes.
     * 
     * @param itemName
     *            item's name
     * @param itemPrice
     *            item's price
     * @param numPurchased
     *            items purchased
     */

    public Item(String itemName, double itemPrice, int numPurchased) {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }

    /**
     * Return a string with the information about the item.
     * 
     * @return toString
     */
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return ("Item: " + name + "\t" + "price: " + fmt.format(price) 
        + "\tquantity: " + quantity + "\t" + "Total: " 
                + fmt.format(price * quantity) + "\n");
    }

    /**
     * Returns the unit price of the item.
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the name of the item.
     * 
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the quantity of the item.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
