package comp1510;

/**
 * Average.
 * 
 * @author jay
 * @version 1.0
 */
public class Average {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        int num = 0;
        int count = 0;

        if (args.length == 0) {
            System.out.println("no arguments were given.");
        } else {
            for (int i = 0; i < args.length; i++) {
                num = num + Integer.parseInt(args[i]);
                count++;
            }
        }
        int average = num / count;
        System.out.println("Total number of string:" + count);
        System.out.println("Total : " + num);
        System.out.println("The average :" + average);
    }
}
