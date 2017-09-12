package comp1510;

import java.util.Random;

/**
 * RandomWalk.
 * 
 * @author jay
 * @version 1.0
 */
public class RandomWalk {
    int xCoord;
    int yCoord;
    int maxStep;
    int numStep;
    int boundary;
    int maxDistance = 0;
    int edge;

    /**
     * Constructor for the object of type RandomWalk.
     * 
     * @param max
     *            max steps
     * @param edge
     *            max range
     */
    public RandomWalk(int max, int edge) {
        maxStep = max;
        boundary = edge;
        xCoord = 0;
        yCoord = 0;
        numStep = 0;
    }

    /**
     * Constructor for the object of type RandomWalk.
     * 
     * @param max
     *            max steps
     * @param edge
     *            max range
     * @param startX
     *            start position of x
     * @param startY
     *            start position of y
     */
    public RandomWalk(int max, int edge, int startX, int startY) {
        xCoord = startX;
        yCoord = startY;
        numStep = 0;
        maxStep = max;
        boundary = edge;
    }

    /**
     * print the result.
     * 
     * @return toSting
     */
    public String toString() {
        return "Steps: " + numStep + ";" + "Position:(" + xCoord + "," + yCoord + ")";
    }

    /**
     * Update x/y coordinate and number of step.
     */
    public void takeStep() {
        Random generator = new Random();
        int random = generator.nextInt(4);
        switch (random) {
        case 0:
            xCoord++;
            break;
        case 1:
            yCoord++;
            break;
        case 2:
            xCoord--;
            break;
        case 3:
            yCoord--;
            break;
        default:
            break;
        }
        numStep++;
        max(Math.sqrt(Math.pow(xCoord, 2) + Math.pow(yCoord, 2)));
    }

    /**
     * compare numStep and maxStep.
     * 
     * @return moreSteps.
     */
    public boolean moreSteps() {
        return (numStep < maxStep);
    }

    /**
     * check if xCoord and yCoord are in bound.
     * 
     * @return inBound()
     */
    public boolean inBound() {
        return ((Math.abs(xCoord)) < boundary && (Math.abs(yCoord)) < boundary);
    }

    /**
     * take step while step is in bound.
     */
    public void walk() {
        while (moreSteps() && inBound()) {
            takeStep();
        }
    }

    /**
     * get x coordinate.
     * 
     * @return x coordinate
     */
    public int getX() {
        return xCoord;
    }

    /**
     * y coordinate.
     * 
     * @return y coordinate
     */
    public int getY() {
        return yCoord;
    }

    /**
     * compare absolute value of x/y coordinate and set the largest as max
     * distance traveled.
     * 
     * @param distance
     * 
     * @param num1
     *            x coordinate
     * @param num2
     *            y coordinate
     * @return maxDistance
     */
    private int max(double distance) {
        // num1 = Math.abs(num1);
        // num2 = Math.abs(num2);
        // if (num1 >= num2) {
        // maxDistance = num1;
        // } else {
        // maxDistance = num2;
        // }
        maxDistance = (int) (Math.round(distance));
        return maxDistance;
    }

    /**
     * get max distance.
     * 
     * @return maxDistance
     */
    public int getMaxDistance() {
        return maxDistance;
    }
}
