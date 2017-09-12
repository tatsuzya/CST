package comp1510;

import java.util.Scanner;

/**
 * Dates.
 * 
 * @author jay
 * @version 1.0
 */
public class Dates {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        int month;
        int day;
        int year;
        int daysInMonth;
        boolean monthValid;
        boolean yearValid;
        boolean dayValid;
        boolean leapYear;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter month as number");
        month = scan.nextInt();
        System.out.println("Please enter the day of the month");
        day = scan.nextInt();
        System.out.println("Please enter the year");
        year = scan.nextInt();

        if (month <= 12 && month > 0) {
            monthValid = true;
        } else {
            monthValid = false;
        }

        if (year <= 1999 && year >= 1000) {
            yearValid = true;
        } else {
            yearValid = false;
        }

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            leapYear = true;
        } else {
            leapYear = false;
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            daysInMonth = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        } else if (month == 2 && leapYear == true) {
            daysInMonth = 29;
        } else {
            daysInMonth = 28;
        }

        if (day <= daysInMonth && day > 0) {
            dayValid = true;
        } else {
            dayValid = false;
        }

        if (dayValid == true && yearValid == true && monthValid == true) {
            System.out.println("Date is Valid.");
            if (leapYear == true) {
                System.out.println("Date is a leap year.");
            } else {
                System.out.println("Date is not a leap year.");
            }
        } else {
            System.out.println("Date is invalid.");
        }
        scan.close();
    }
}
