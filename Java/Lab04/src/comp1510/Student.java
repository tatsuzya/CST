package comp1510;

import java.util.Scanner;

/**
 * Student.
 * 
 * @author jay
 * @version 1.0
 */
public class Student {

    /** grade of test 1. */
    private int test1;
    /** grade of test 2. */
    private int test2;
    /** name of the student. */
    private String name;
    /** user inputs.*/
    private Scanner scan;

    /**
     * Constructor for objects of type student.
     * 
     * @param studentName
     *            the student name
     */
    public Student(String studentName) {

        name = studentName;
        scan = new Scanner(System.in);
    }

    /**
     * Input for grades of test 1 and test 2.
     */
    public void inputGrades() {
        System.out.println("Enter grade for " + name + " test 1 : ");
        test1 = scan.nextInt();
        System.out.println("Enter grade for " + name + " test 2 : ");
        test2 = scan.nextInt();

    }

    /**
     * Get the average of 2 tests.
     * 
     * @return getAverage
     */
    public double getAverage() {
        return (test1 + test2) / 2.0;

    }

    /**
     * Get the name of students.
     * 
     * @return getName
     */
    public String getName() {
        return name;
    }

    /**
     * Print the name of the student and the grades.
     * 
     * @return toString
     */
    public String toString() {
        return "Name: " + name + " test 1 : " + test1 + " test 2 : " 
                + test2 + " Average score: " + getAverage();

    }

    /**
     * Grades.
     * 
     * @author jay
     * @version 1.0
     */
    public static class Grades {
        /**
         * Drives the program.
         * 
         * @param args
         *            command line arguments
         */
        public static void main(String[] args) {
            Student student1 = new Student("Mary");
            Student student2 = new Student("Mike");

            student1.inputGrades();
            student2.inputGrades();
            student1.getAverage();
            student2.getAverage();
            System.out.println(student1);
            System.out.println(student2);

        }
    }
}
