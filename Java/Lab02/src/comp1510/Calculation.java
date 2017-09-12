package comp1510;
/**
 * Calculation
 * @author jay
 * @version 1.0
 */
public class Calculation {
    /** 
     * Drives the program
     * @param args
     */
    public static void main(String[] args) {
        int a = 3, b = 10, c = 7;
        double w = 12.9, y = 3.2;

        System.out.println(" a + b * c = " + (a + b * c));
        System.out.println(" a - b - c = " + (a - b - c));
        System.out.println(" a / b = " + (a / b));
        System.out.println(" b / a = " + (b / a));
        System.out.println(" a - b / c = " + (a - b / c));
        System.out.println(" w / y = " + (w / y));
        System.out.println(" y / w = " + (y / w));
        System.out.println(" a + w / b = " + (a + w / b));
        System.out.println(" a % b / y = " + (a % b / y));
        System.out.println(" b % a = " + (b % a));
        System.out.println(" w % y = " + (w % y));
    }
}
