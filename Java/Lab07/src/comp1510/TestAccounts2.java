package comp1510;

import java.util.Scanner;
/**
 * TestAccount2.
 * @author jay
 * @version 1.0
 */
public class TestAccounts2 {
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        final int initBal = 100;
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the name for the account ");
        String name = scan.nextLine();
        Account acct1 = new Account(initBal, name);
        System.out.println(acct1);

        System.out.println("");
        System.out.print("Please enter the name for the account ");
        String name1 = scan.nextLine();
        Account acct2 = new Account(initBal, name1);
        System.out.println(acct2);

        System.out.println("");
        System.out.print("Please enter the name for the account ");
        String name2 = scan.nextLine();
        Account acct3 = new Account(initBal, name2);
        System.out.println(acct3);

        acct1.close();
        Account conAccount = Account.consolidate(acct2, acct3);
        
        System.out.println("");
        System.out.println(acct1);
        System.out.println("");
        System.out.println(acct2);
        System.out.println("");
        System.out.println(acct3);
        System.out.println("");
        System.out.println(conAccount);
        
        scan.close();
    }
}
