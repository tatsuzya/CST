package comp1510;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
       final int height = 150;
       final int width = 100;
        
       JFrame frame = new JFrame("Vote Counter");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JPanel subPanel1 = new JPanel();
       subPanel1.setPreferredSize(new Dimension(height, width));
       subPanel1.setBackground(Color.green);
       JLabel label1 = new JLabel("Joe");
       subPanel1.add(label1);
       
       JPanel subPanel2 = new JPanel();
       subPanel2.setPreferredSize(new Dimension(height, width));
       subPanel2.setBackground(Color.yellow);
       JLabel label2 = new JLabel("Sam");
       subPanel2.add(label2);
       
       JPanel voteCounterPanel = new JPanel();
       voteCounterPanel.setBackground(Color.blue);
       voteCounterPanel.add(subPanel1);
       voteCounterPanel.add(subPanel2);
       
       frame.getContentPane().add(new VoteCounterPanel());
       
       frame.pack();
       frame.setVisible(true);
    }
}
