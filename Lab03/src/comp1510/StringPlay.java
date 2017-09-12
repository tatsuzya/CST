package comp1510;

/**
 * StringPlay.
 * 
 * @author jay
 * @version 1.0
 */
public class StringPlay {
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        String college = new String("Podunk College");
        String town = new String(" Anytown, USA");
        String location = new String(college + town);
        int stringLength = college.length();

        String change1 = college.toUpperCase();
        String change2 = change1.replaceAll("O", "*");
        String change3 = location;

        System.out.println(college + " contains " 
        + stringLength + " characters.");
        System.out.println("" + change1);
        System.out.println("" + change2);
        System.out.println("" + change3);
        System.out.println("The Final string is " + change3);

    }
}
