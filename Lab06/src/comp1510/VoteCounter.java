package comp1510;

import javax.swing.JFrame;

/**
 * VoteCounter.
 * @author jay
 * @version 1.0
 */
public class VoteCounter {
    /**
     * Drives the programs.
     * @param args command line argument
     */
   
    public static void main(String[] args) {
        
       JFrame frame = new JFrame("Vote Counter");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(new VoteCounterPanel());
       
       frame.pack();
       frame.setVisible(true);
    }
}
