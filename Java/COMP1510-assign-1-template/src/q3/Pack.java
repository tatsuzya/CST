package q3;
import java.util.Scanner;

/**
 * Base convert program.
 * 
 * @author Jay Lin
 * @version 1.0
 */
public class Pack {
    /**
     * Drives the program.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        //read in characters inputs// 
        System.out.println("Please enter the first character");
        final char c1 = scan.next().charAt(0);
        System.out.println("Please enter the second character");
        final char c2 = scan.next().charAt(0);
        System.out.println("Please enter the third character");
        final char c3 = scan.next().charAt(0);
        System.out.println("Please enter the fourth character");
        final char c4 = scan.next().charAt(0);
        System.out.println("Please enter the fifth character");
        final char c5 = scan.next().charAt(0);
        System.out.println("" + c1 + c2 + c3 + c4 + c5);
        System.out.println();
        System.out.println("Original: " + c1 + c2 + c3 + c4 + c5);
        
        // convert characters into values//
        final int v1 = c1 - 'A' + 1;
        final int v2 = c2 - 'A' + 1;
        final int v3 = c3 - 'A' + 1;
        final int v4 = c4 - 'A' + 1;
        final int v5 = c5 - 'A' + 1;
        
        final int base = 56;
        
        // base 56 number to base 10 //
        final int base10Num = ((v1 * base * base * base * base) 
                + (v2 * base * base * base) + (v3 * base * base) + (v4 * base) 
                + (v5));
     
        
        System.out.println("Encoded: " + base10Num);

        //base 10 number to base 56//
        final int n1 = base10Num % base;
        final int q1 = base10Num / base;
        final int n2 = q1 % base;
        final int q2 = q1 / base;
        final int n3 = q2 % base;
        final int q3 = q2 / base;
        final int n4 = q3 % base;
        final int q4 = q3 / base;
        final int n5 = q4 % base;
        
        // convert value into character //
        final char ch1 = (char) (n5 + 'A' - 1);
        final char ch2 = (char) (n4 + 'A' - 1);
        final char ch3 = (char) (n3 + 'A' - 1);
        final char ch4 = (char) (n2 + 'A' - 1);
        final char ch5 = (char) (n1 + 'A' - 1);
        
        
        scan.close();
        System.out.println("Decoded: " + ch1 + ch2 + ch3 + ch4 + ch5);
        System.out.println("Question three was called and ran sucessfully.");
    }

}
