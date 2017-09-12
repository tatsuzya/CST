package q3;

/**
 * Address.
 * 
 * @author jay
 * @version 1.0
 */
public class Address {
    /** street address. */
    private String streetAddress;
    /** city. */
    private String city;
    /** state. */
    private String state;
    /** zip code. */
    private long zipCode;

    /**
     * Constructor for object of type Address.
     * 
     * @param street
     *            street address
     * @param town
     *            town
     * @param st
     *            state
     * @param zip
     *            zip code
     */
    public Address(String street, String town, String st, long zip) {
        streetAddress = street;
        city = town;
        state = st;
        zipCode = zip;
    }

    /**
     * Print the result.
     * 
     * @return result
     */
    public String toString() {
        String result;
        result = streetAddress + "\n";
        result += city + ", " + state + " " + zipCode;
        return result;
    }
}
