package comp1510;

import java.util.Scanner;

/**
 * Square.
 * 
 * @author jay
 * @version 1.0
 */
public class Square {
    int[][] square;

    /**
     * Constructor for the object of type Square.
     * 
     * @param size
     *            size for the square
     */
    public Square(int size) {
        square = new int[size][size];
    }

    /**
     * calculate the sum of row.
     * 
     * @param row
     *            row
     * @return sum of row
     */
    public int sumRow(int row) {
        int sum = 0;
        for (int col = 0; col < square.length; col++) {
            sum += square[row][col];
        }
        return sum;
    }

    /**
     * calculate the sum of col.
     * 
     * @param col
     *            col
     * @return sum of col
     */
    public int sumCol(int col) {
        int sum = 0;
        for (int row = 0; row < square.length; row++) {
            sum += square[row][col];
        }
        return sum;
    }

    /**
     * Calculate the sum of diag.
     * 
     * @return sum of diag
     */
    public int sumMainDiag() {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    /**
     * Calculate the sum of reversed diag.
     * 
     * @return sum of reversed diag
     */
    public int sumOtherDiag() {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][square.length - 1 - i];
        }
        return sum;
    }

    /**
     * compare between points.
     * 
     * @return result of comparison
     */
    public boolean magic() {
        boolean result = true;
        int sum = sumMainDiag();
        if (sumOtherDiag() != sum) {
            result = false;
        } else {
            for (int col = 0; col < square.length; col++) {
                if (sum != sumCol(col)) {
                    result = false;
                }
            }
            for (int row = 0; row < square.length; row++) {
                if (sum != sumRow(row)) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * read in scanner from input stream.
     * 
     * @param scan
     */
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col++)
                square[row][col] = scan.nextInt();
    }

    /**
     * print the content.
     */
    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                System.out.print(square[row][col]);
            }
        }
    }
}