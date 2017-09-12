package comp1510;

import java.util.Scanner;

/**
 * Count.
 * 
 * @author jay
 * @version 1.0
 */
public class Count {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument.
     */
    public static void main(String[] args) {
        String phrase; 
        int countBlank; 
        int countA = 0;
        int countE = 0;
        int countS = 0;
        int countT = 0;
        char ch = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Character Counter");
        System.out.println();
        System.out.print("Enter a sentence or phrase: ");
        phrase = scan.nextLine();
        countBlank = 0;
        for (int i = 0; i < phrase.length(); i++) {
            ch = phrase.charAt(i);
            switch (ch) {
            case 'a':
            case 'A':
                countA++;
                break;
            case 'e':
            case 'E':
                countE++;
                break;
            case 's':
            case 'S':
                countS++;
                break;
            case 't':
            case 'T':
                countT++;
                break;
            case ' ':
                countBlank++;
                break;
            default:
                break;
            }
        }
        // and count the blank spaces
        // Print the results
        System.out.println();
        System.out.println("Number of blank spaces: " + countBlank);
        System.out.println("number of A/a: " + countA);
        System.out.println("number of E/e: " + countE);
        System.out.println("number of S/s: " + countS);
        System.out.println("number of T/t: " + countT);

        System.out.println();
        scan.close();
    }
}
