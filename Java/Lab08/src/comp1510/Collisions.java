package comp1510;

/**
 * COllisions.
 * 
 * @author jay
 * @version 1.0
 */

public class Collisions {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        int maxStep = 100000;
        int boundary = 2000000;
        RandomWalk par1 = new RandomWalk(maxStep, boundary, -3, 0);
        RandomWalk par2 = new RandomWalk(maxStep, boundary, 3, 0);
        int collision = 0;
        for (int i = 0; i < maxStep; i++) {
            par1.takeStep();
            par2.takeStep();
            if (samePosition(par1, par2)) {
                collision++;
            }
        }
        System.out.println("Total collision: " + collision);
    }

    /**
     * compare par1 x/y coordinate and par2 x/y coordinate.
     * 
     * @param par1
     *            particle 1
     * @param par2
     *            particle 2
     * @return samePosition
     */
    public static boolean samePosition(RandomWalk par1, RandomWalk par2) {
        return (par1.getX() == par2.getX() && par1.getY() == par2.getY());
    }

}
