package comp1510;

import java.util.Scanner;
/**
 * StringManips.
 * 
 * @author jay
 * @version 1.0
 */
public class StringManips {
    /**
     * Drives the program.
     * 
     * @param args command line argument
     */
    public static void main(String[] args) {
        String phrase = new String("This is a String test.");
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your city: ");
        String city = scan.nextLine();
        System.out.println("Please enter your state: ");
        String state = scan.nextLine();

        city = city.toLowerCase();
        state = state.toUpperCase();

        System.out.println("" + state + city + state);

        final int phraseLength = phrase.length();
        final int middleIndex = phraseLength / 2;

        String firstHalf = phrase.substring(0, middleIndex);
        String secondHalf = phrase.substring(middleIndex, phraseLength);
        String middle3 = phrase.substring(middleIndex - 1, middleIndex + 2);

        String switchedPhrase = 
                secondHalf.concat(firstHalf).replaceAll("", "*");

        System.out.println();
        System.out.println("Original phrase: " + phrase);
        System.out.println("Length of the phrase: " 
                + phraseLength + " characters ");
        System.out.println("Character at the middle index: " 
                + phrase.charAt(middleIndex));
        System.out.println("Switched phrase: " + switchedPhrase);
        System.out.println("3 character at middle: " + middle3);

        scan.close();
    }
}
