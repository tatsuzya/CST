package q3;

/**
 * Student.
 * 
 * @author jay
 * @version 1.0
 */
public class Student {
    /** Test one. */
    private int test1;
    /** Test two. */
    private int test2;
    /** Test three. */
    private int test3;
    /** first name. */
    private String firstName;
    /** last name. */
    private String lastName;
    /** home address. */
    private Address homeAddress;
    /** School address. */
    private Address schoolAddress;
    /** Test Score one. */
    private final int testScore1 = 1;
    /** Test Score two. */
    private final int testScore2 = 2;
    /** Test Score three. */
    private final int testScore3 = 3;
    /** Number of tests. */
    private final double numTest = 3.0;

    /**
     * Constructor for object of type Student.
     * 
     * @param first
     *            first name
     * @param last
     *            last name
     * @param home
     *            student's home address
     * @param school
     *            student's school address
     */
    public Student(String first, String last, Address home, Address school) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        test1 = 0;
        test2 = 0;
        test3 = 0;
    }

    /**
     * Constructor for object of type Student.
     */
    public Student() {
        test1 = 0;
        test2 = 0;
        test3 = 0;
    }

    /**
     * set the testScore.
     * 
     * @param test
     *            test
     * @param score
     *            score
     */
    public void setTestScore(int test, int score) {
        if (test == testScore1) {
            test1 = score;
        } else if (test == testScore2) {
            test2 = score;
        } else if (test == testScore3) {
            test3 = score;
        }
        if (score < 0) {
            throw new IllegalArgumentException("score can not be lower than 0");
        }
        if (test > testScore3) {
            throw new IllegalArgumentException("there are only 3 tests");
        }
    }

    /**
     * get test score.
     * 
     * @param test
     *            test
     * @return test score
     */
    public int getTestScore(int test) {

        if (test > testScore3) {
            throw new IllegalArgumentException("there are only 3 tests");
        }

        if (test == testScore1) {
            return test1;
        } else if (test == testScore2) {
            return test2;
        } else {
            return test3;
        }

    }

    /**
     * calculate average of tests.
     * 
     * @return average
     */
    public double average() {
        return Math.round((test1 + test2 + test3) / numTest);
    }

    /**
     * print the information of the student.
     * 
     * @return result.
     */
    public String toString() {
        String result;
        result = firstName + " " + lastName + "\n";
        result += "\nHome Address:\n" + homeAddress + "\n";
        result += "\nSchool Address:\n" + schoolAddress + "\n";
        result += "\nTest one:\n" + getTestScore(testScore1) + "\n";
        result += "Test two:\n" + getTestScore(testScore2) + "\n";
        result += "Test three:\n" + getTestScore(testScore3) + "\n";
        result += "Average of tests:\n" + average();
        return result;
    }
}
