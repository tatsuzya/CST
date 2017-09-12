package q2;

import java.util.Scanner;

/**
 * SecondsConvert.
 * @author Jay Lin
 * @version 1.0
 */
public class SecondsConvert {
    /**
     * Drives the program.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
    
        // minPerHour = hours converted into minutes
        // secPerMin = minutes converted into seconds
        Scanner scan = new Scanner(System.in);
        final int minPerHour = 60;
        final int secPerMin = 60;
        
        System.out.println("Please enter Hours: ");
        final int hours = scan.nextInt();
        System.out.println("Please enter minutes: ");
        final int minutes = scan.nextInt();
        System.out.println("Please enter seconds: ");
        final int seconds = scan.nextInt();
        
        //conversion//
        final int hrToMin = hours * minPerHour; 
        final  int totalMin = hrToMin + minutes;
        final int minToSec = totalMin * secPerMin;
        final int totalSec = minToSec + seconds;
        scan.close();

        System.out.println("Total seconds: " + totalSec);

        System.out.println("Question two was called and ran sucessfully.");
        
    }
}
