package comp1510;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * VoteCounterPanel.
 * @author jay
 * @version 1.0
 */
public class VoteCounterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    /** number of vote for Joe. */
    private int votesForJoe;
    /** Button for Joe. */
    private JButton joe;
    /** Label for Joe. */
    private JLabel labelJoe;
    /** number of vote for Sam.*/
    private int votesForSam;
    /** Button for Sam.*/
    private JButton sam;
    /** Label for Sam.*/
    private JLabel labelSam;

    /**
     * constructor for the object VoteCounterPanel.
     */
    public VoteCounterPanel() {
        votesForJoe = 0;
        votesForSam = 0;

        joe = new JButton("Vote for Joe");
        joe.addActionListener(new JoeButtonListener());
        sam = new JButton("Vote for Sam");
        sam.addActionListener(new SamButtonListener());

        labelJoe = new JLabel("Votes for Joe: " + votesForJoe);
        labelSam = new JLabel("Votes for Sam: " + votesForSam);

        add(joe);
        add(labelJoe);
        add(sam);
        add(labelSam);
        final int height = 300;
        final int width = 100;
        setPreferredSize(new Dimension(height, width));
        setBackground(Color.cyan);

    }
    /**
     * ActionListener for Joe.
     * @author jay
     * @version 1.0
     */
    private class JoeButtonListener implements ActionListener {
        /**
         * actionPerformed.
         * @param event event
         */
        public void actionPerformed(ActionEvent event) {
            votesForJoe++;
            labelJoe.setText("Votes for Joe: " + votesForJoe);

        }
    }
    /**
     * ActionListener for Sam. 
     * @author jay
     * @version 1.0
     */
    private class SamButtonListener implements ActionListener {
        /**
         * actionPerformed.
         * @param event event
         */
        public void actionPerformed(ActionEvent event) {
            votesForSam++;
            labelSam.setText("Votes for Sam: " + votesForSam);
        }
    }
}
