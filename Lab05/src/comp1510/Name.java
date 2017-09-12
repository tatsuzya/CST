package comp1510;

import java.util.Scanner;

/**
 * Name.
 * 
 * @author jay
 * @version 1.0
 */
public class Name {
    /** first name. */
    private String firstName;
    /** middle name.*/
    private String middleName;
    /** last name. */
    private String lastName;
    /** scanner. */
    private Scanner scan;
    /** boolean type result. */
    private boolean result;

    /**
     * Constructor for object of type Name.
     */
    public Name() {

    }

    /**
     * get Names.
     * @param first string type 
     * @param middle string type
     * @param last string type
     */
    public Name(String first, String middle, String last) {
        firstName = first;
        middleName = middle;
        lastName = last;
    }

    /**
     * get names from input.
     */
    public void inputName() {
        scan = new Scanner(System.in);
        System.out.print("Please enter first name :");
        firstName = scan.nextLine();
        System.out.print("Please enter middle name :");
        middleName = scan.nextLine();
        System.out.print("Please enter last name : ");
        lastName = scan.nextLine();
    }
    
    /**
     * get first name from input.
     * @return getFirst
     */
    public String getFirst() {
        return firstName;
    }
    /**
     * get middle name from input.
     * @return getMiddle
     */
    public String getMiddle() {
        return middleName;
    }
    /**
     * get last name from input.
     * @return getLast
     */
    public String getLast() {
        return lastName;
    }
    /** 
     * get firstMiddeLast.
     * @return getfirstMiddleLast
     */
    public String getfirstMiddleLast() {
        return "" + firstName + " " + middleName + " " + lastName;
    }
    /**
     * get lastFirstMiddle.
     * @return getlastFirstMiddle
     */
    public String getlastFirstMiddle() {
        return "" + lastName + ", " + firstName + " " + middleName;
    }
    /**
     * get initials.
     * @return getinitials
     */
    public String getinitials() {
        return "" + firstName.toUpperCase().substring(0, 1) 
                + middleName.toUpperCase().substring(0, 1) 
                + lastName.toUpperCase().substring(0, 1);
    }
    /** 
     * get length.
     * @return getlength
     */
    public int getlength() {
        int length = (firstName.length() 
                + middleName.length() + lastName.length());
        return length;
    }

    /**
     * compare names.
     * @param otherName String type
     * @return result
     */
    public boolean equals(Name otherName) {
        result = (this.getFirst().equalsIgnoreCase(otherName.getFirst())
                && this.getMiddle().equalsIgnoreCase(otherName.getMiddle())
                && this.getLast().equalsIgnoreCase(otherName.getLast()));
        return result;
    }
    /**
     * print out result.
     * @return toString
     */
    public String toString() {
        return "" + getfirstMiddleLast() + "\n" + getlastFirstMiddle() 
                  + "\nInitials : " + getinitials() + "\nLength : "
                  + getlength();
    }

    /**
     * TestName.
     * @author jay
     * @version 1.0
     */
    public static class TestName {
        /**
         * Drives the program.
         * 
         * @param args command line argument
         */
        public static void main(String[] args) {

            Name name1 = new Name();
            Name name2 = new Name();

            name1.inputName();
            name2.inputName();
  
            System.out.println(name1);
            System.out.println(name2);
            System.out.println(name1.equals(name2));
        }
    }
}