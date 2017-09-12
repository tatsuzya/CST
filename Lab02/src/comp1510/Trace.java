package comp1510;

import java.util.Scanner;
 /**
  * Trace
  * @author jay
  * @version 1.0
  */
public class Trace {
    /**
     * Drives into program
     * @param args
     */
    public static void main(String[] args) {
        int one, two, three;
        double what;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        one = scan.nextInt();
        two = scan.nextInt();

        System.out.print("Enter a floating point number: ");
        what = scan.nextDouble();
        three = 4 * one + 5 * two;
        two = 2 * one;

        System.out.println("one " + two + ":" + three);
        one = 46 / 5 * 2 + 19 % 4;
        three = one + two;
        what = (what + 2.5) / 2;

        System.out.println(what + " is what!");
        
        scan.close();
    }
}

/**
 * i/nv = initialized / no value
 *
 * line one two what three
 *
 * 4 - 8 null null null null 9 i/nv i/nv i/nv null 10 - 14 i/nv i/nv i/nv i/nv
 * 15 10 i/nv i/nv i/nv 16 - 18 10 3 i/nv i/nv 19 10 3 14.3 i/nv 20 10 3 14.3 55
 * 21 10 20 14.3 55 22 - 23 10 20 14.3 55 24 21 20 14.3 55 25 21 20 14.3 41 26 -
 * 28 21 20 8.4 41
 */