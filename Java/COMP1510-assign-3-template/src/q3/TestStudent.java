package q3;

/**
 * TestStudent.
 * 
 * @author jay
 * @version 1.0
 */
public class TestStudent {
    /** test number 1. */
    private static final int TEST_NUM_1 = 1;
    /** test number 2. */
    private static final int TEST_NUM_2 = 2;
    /** test number 3. */
    private static final int TEST_NUM_3 = 3;
    /** test score 1. */
    private static final int TEST_SCORE_1 = 50;
    /** test score 2. */
    private static final int TEST_SCORE_2 = 40;
    /** test score 3. */
    private static final int TEST_SCORE_3 = 34;
    /** school zip code. */
    private static final long SCHOOL_ZIP = 19085;
    /** Jeff home zip. */
    private static final long J_HOME_ZIP = 24551;
    /** Marsha home zio. */
    private static final long M_HOME_ZIP = 44132;

    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        Address school = new Address("800 Lancaster Ave.", "Villanova", "PA",
                SCHOOL_ZIP);
        Address jHome = new Address("21 Jump Street", "Blacksburg", "VA",
                J_HOME_ZIP);
        Student jeff = new Student("Jeff", "Smith", jHome, school);
        Address mHome = new Address("123 Main Street", "Euclid", "OH",
                M_HOME_ZIP);
        Student marsha = new Student("Marsha", "Jones", mHome, school);

        jeff.setTestScore(TEST_NUM_1, TEST_SCORE_1);
        jeff.setTestScore(TEST_NUM_2, TEST_SCORE_2);
        jeff.setTestScore(TEST_NUM_3, TEST_SCORE_3);
        marsha.getTestScore(TEST_NUM_1);
        marsha.getTestScore(TEST_NUM_2);
        marsha.getTestScore(TEST_NUM_3);

        System.out.println(jeff + "\n");
        System.out.println(marsha + "\n");
        System.out.println();

        System.out.println("Question three was called and ran sucessfully.");
    }
}
