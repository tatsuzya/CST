package q4;

import java.util.Scanner;

/**
 * Primes.
 * 
 * @author jay
 * @version 1.0
 */
public class Primes {
    /** Primes number of type boolean. */
    private boolean[] boolPrimes;

    /**
     * Constructor for object type of Primes.
     * 
     * @param upperBound
     *            upper bound
     */
    public Primes(int upperBound) {
        boolPrimes = calculatePrimes(upperBound);
        if (upperBound < 0) {
            throw new IllegalArgumentException(
                    "\n upperbound can not be negative value");

        }
    }

    /**
     * Calculate prime numbers.
     * 
     * @param upperBound
     *            upper bound
     * @return isPrimes prime numbers.
     */
    private boolean[] calculatePrimes(int upperBound) {
        boolean[] isPrimes = new boolean[upperBound + 1];
        for (int i = 2; i < upperBound; i++) {
            isPrimes[i] = true;
        }
        for (int i = 2; i < upperBound / 2; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < upperBound; j = j + i) {
                    isPrimes[j] = false;
                }
            }
        }
        return isPrimes;
    }

    /**
     * store prime numbers.
     * 
     * @return primeList list of prime numbers
     */
    public String printPrimes() {
        String primeList = "";
        for (int i = 0; i < boolPrimes.length; i++) {
            if (boolPrimes[i]) {
                primeList = primeList + " " + i;
            }
        }
        return primeList;
    }

    /**
     * count the amount of prime numbers.
     * 
     * @return count amount of prime numbers
     */
    public int countPrimes() {
        int count = 0;
        for (int i = 0; i < boolPrimes.length; i++) {
            if (boolPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Compare whether or not the value is prime number.
     * 
     * @param x
     *            value in the index.
     * @return prime number
     */
    public Boolean isPrime(int x) {
        boolean isAPrime = false;
        for (int i = 0; i < boolPrimes.length; i++) {
            if (x == i) {
                if (boolPrimes[i]) {
                    isAPrime = true;
                } else {
                    isAPrime = false;
                }
            }
        }
        return isAPrime;
    }

    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument.
     */
    public static void main(String[] args) {
        int bound = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an upper bound: ");
        bound = scan.nextInt();
        Primes primes = new Primes(bound);

        System.out.println("There are " + primes.countPrimes() + " primes:\n ");
        System.out.println("The prime numbers between 0 and " + bound
                + " are :\n " + primes.printPrimes());
        System.out.println("Question four was called and ran sucessfully.");
        scan.close();
    }

}
