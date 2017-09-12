package comp1510;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * SquareTest.
 * 
 * @author jay
 * @version 1.0
 */
public class SquareTest {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File(
                "magicData.txt"));
        int count = 1;
        int size = scan.nextInt();
        while (size != -1) {
            Square magicSquare = new Square(size);
            magicSquare.readSquare(scan);
            System.out.println("\n******** Square " + count + " ********");
            magicSquare.printSquare();
            System.out.println("\n");

            for (int row = 0; row < size; row++) {
                System.out.println(
                        "Sum of row " + row + " : " + magicSquare.sumRow(row));
            }
            for (int col = 0; col < size; col++) {
                System.out.println(
                        "Sum of col " + col + " : " + magicSquare.sumCol(col));
            }
            System.out.println("Sum of diagonal :" + magicSquare.sumMainDiag());
            System.out.println(
                    "Sum of reversed diagonal : " + magicSquare.sumOtherDiag());
            System.out.println(magicSquare.magic());
            size = scan.nextInt();
            count++;
        }
    }
}