package q3;

import javax.swing.JFrame;

/**
 * StopWatch..
 * 
 * @author jay
 * @version 1.0
 */
public class StopWatch {
    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stop Watch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StopWatchPanel());
        frame.pack();
        frame.setVisible(true);
    }
}