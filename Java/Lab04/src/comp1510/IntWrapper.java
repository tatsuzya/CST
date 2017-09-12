package comp1510;
import java.util.Scanner;

/**
 * IntWrapper.
 * @author jay
 * @version 1.0
 */
public class IntWrapper {
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter an integer: ");
        final int a = scan.nextInt(); 
          
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toHexString(a));
        
        System.out.println("Max value of integer :" + Integer.MAX_VALUE);
        System.out.println("Min value of integer :" + Integer.MIN_VALUE);
        
        System.out.println("Please enter two decimal integers: ");
        String b = scan.next();
        String c = scan.next();
        
        final double deci1 = Double.valueOf(b);
        final double deci2 = Double.valueOf(c);

        final int sum = (int) (deci1 + deci2);
        System.out.println("Sum of the integers = " + sum);
        scan.close();
    }
}