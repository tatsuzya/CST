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
    private Random generator = new Random();

    public Account(double initBal, String owner, long number) {
        balance = initBal;
        name = owner;
        acctNum = number;
    }

    /**
     * Constructor for the object of type Account.
     * 
     * @param initBal
     *            initial balance
     * @param owner
     *            owner's name
     */
    public Account(double initBal, String owner) {
        balance = initBal;
        name = owner;
        acctNum = Math.abs(generator.nextLong());
    }

    /**
     * Constructor for the object of type Account.
     * 
     * @param owner
     *            owner's name
     */
    public Account(String owner) {
        balance = 0;
        name = owner;
        acctNum = Math.abs(generator.nextLong());
    }

    /**
     * deduct withdraw from balance.
     * 
     * @param amount
     *            withdraw
     */
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    /**
     * deduct withdraw and fee from balance.
     * 
     * @param amount
     *            withdraw
     * @param fee
     *            fee
     */
    public void withdraw(double amount, double fee) {
        if (balance >= amount) {
            balance -= (amount + fee);
        } else {
            System.out.println("Insufficient funds");
        }
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
     * print the result.
     * 
     * @return toString
     */
    public String toString() {
        return "\nName:" + name + "\nAccount Number: " + acctNum + "\nBalance: " + balance;
    }
}
