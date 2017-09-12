package comp1510;

import javax.swing.JFrame;

/**
 * Rebound
 * 
 * @author jay
 * @version 1.0.
 */
public class Rebound {
    /**
     * drives the program.
     * 
     * @param args
     *            command line argument.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rebound");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ReboundPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
