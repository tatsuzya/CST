package comp1510;

import java.util.Scanner;
/**
 * TestAccounts1.
 * @author jay
 * @version 1.0
 */
public class TestAccounts1 {
    /**
     * Drives the programs.
     * @param args command line argument
     */
    public static void main(String[] args) {
        Account testAcct;
        final int initBal = 100;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many accounts would you like to create?");
        int num = scan.nextInt();
        for (int i = 1; i <= num; i++) {
            testAcct = new Account(initBal, "Name" + i);
            System.out.println("\nCreated account " + testAcct);
            System.out.println("Now there are " 
            + Account.getNumAccounts() + " accounts");
            scan.close();
        }
    }
}