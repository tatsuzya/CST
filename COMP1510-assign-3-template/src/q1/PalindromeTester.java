package q1;

import java.util.Scanner;

/**
 * PalidromeTester.
 * 
 * @author jay
 * @version 1.0
 */
public class PalindromeTester {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        String originalStr;
        String reversedStr = "";
        String modified;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a string");
        originalStr = scan.nextLine();

        modified = originalStr.replaceAll("\\W", "");
        int strLength = modified.length();

        for (int i = strLength - 1; i >= 0; i--) {
            reversedStr = reversedStr + modified.charAt(i);
        }

        if (modified.equalsIgnoreCase(reversedStr)) {
            System.out.println(originalStr + " is a palindrome.\n");
        } else {
            System.out.println(originalStr + " is not a palindrome.\n");
        }
        System.out.println("Question one was called and ran sucessfully.");
        scan.close();
    }
}