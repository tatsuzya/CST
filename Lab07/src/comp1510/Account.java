package comp1510;

import java.util.Random;

/**
 * Account.
 * 
 * @author jay
 * @version 1.0
 */
public class Account {
    private double balance;
    private String name;
    private long acctNum;
    private static int numAccounts = 0;
    private Random generator = new Random();

    /**
     * Constructor for the object of type Account.
     * 
     * @param initBal
     *            initial balance
     * @param owner
     *            owner's name
     * @param number
     *            account number
     */
    public Account(double initBal, String owner, long number) {
        balance = initBal;
        name = owner;
        acctNum = number;
        numAccounts++;

    }

    /**
     * Constructor for the object of type Account
     * 
     * @param initBal
     * @param owner
     */
    public Account(double initBal, String owner) {
        balance = initBal;
        name = owner;
        acctNum = Math.abs(generator.nextLong());
        numAccounts++;
    }

    /**
     * Constructor for the object of type Account
     * 
     * @param owner
     */
    public Account(String owner) {
        balance = 0;
        name = owner;
        numAccounts++;
        acctNum = Math.abs(generator.nextLong());
    }

    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    public void withdraw(double amount, double fee) {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    /**
     * add deposit to balance.
     * 
     * @param amount
     *            deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * get account balance.
     * 
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * get number of accounts.
     * 
     * @return number of accounts
     */
    public static int getNumAccounts() {
        return numAccounts;
    }

    /**
     * get owner's name.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get account number.
     * 
     * @return account number
     */
    public long getAcctNum() {
        return acctNum;
    }

    /**
     * close account.
     */
    public void close() {
        name = name + " CLOSED";
        balance = 0;
        numAccounts--;
    }

    /**
     * Constructor for consolidate of type Account.
     * 
     * @param acct2
     *            account 2
     * @param acct3
     *            account 3
     * @return consolidated accounts
     */
    public static Account consolidate(Account acct2, Account acct3) {
        if (acct2.acctNum == acct3.acctNum) {
            System.out.println("Can not be consolidated");
            return null;
        } else if ((acct2.name).equalsIgnoreCase(acct3.name)) {
            Account acctConsolidate = new Account((acct2.getBalance() + acct3.getBalance()), acct2.name);
            acct2.close();
            acct3.close();
            return acctConsolidate;
        } else {
            System.out.println("Can not consolidate");
            return null;
        }
    }

    /**
     * print the result.
     * 
     * @return toString
     */
    public String toString() {
        return "Name:" + name + "\nAccount Number: " + acctNum + "\nBalance: " + balance;
    }
}
