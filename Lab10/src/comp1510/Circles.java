package comp1510;

import javax.swing.JFrame;

/**
 * Circles.
 * 
 * @author jay
 * @version 1.0
 */
public class Circles {
    /**
     * Drives the program
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        JFrame circlesFrame = new JFrame("Circles");
        circlesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        circlesFrame.getContentPane().add(new CirclePanel());
        circlesFrame.pack();
        circlesFrame.setVisible(true);
    }
}