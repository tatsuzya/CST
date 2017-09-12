package comp1510;

/**
 * Compare3
 * 
 * @author jay
 * @version 1.0
 */
public class Compare3 {
    /**
     * Compare object one,two, and three.
     * 
     * @param one
     *            object one
     * @param two
     *            object two
     * @param three
     *            object three
     * @return largest
     */
    public static Comparable largest(Comparable one, Comparable two, Comparable three) {
        if (one.compareTo(two) >= 0) {
            if (one.compareTo(three) >= 0) {
                return one;
            } else {
                return three;
            }
        } else {
            if (two.compareTo(three) >= 0) {
                return two;
            } else {
                return three;
            }

        }
    }
}
