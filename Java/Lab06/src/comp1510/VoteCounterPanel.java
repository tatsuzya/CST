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
 * 
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
    /** number of vote for Sam. */
    private int votesForSam;
    /** Button for Sam. */
    private JButton sam;
    /** Label for Sam. */
    private JLabel labelSam;
    /** Label for result. */
    private JLabel labelresult;

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
        labelresult = new JLabel("");
        add(joe);
        add(labelJoe);
        add(sam);
        add(labelSam);
        add(labelresult);
        final int height = 500;
        final int width = 200;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.cyan);
    }

    /**
     * ActionListener for Joe.
     * 
     * @author jay
     * @version 1.0
     */
    private class JoeButtonListener implements ActionListener {
        /**
         * actionPerformed.
         * 
         * @param event
         *            event
         */
        public void actionPerformed(ActionEvent event) {
            votesForJoe++;
            labelJoe.setText("Votes for Joe: " + votesForJoe);
            if (votesForJoe > votesForSam) {
                labelresult.setText("Joe is winning");
            } else if (votesForJoe == votesForSam) {
                labelresult.setText("There is a tie");
            }
        }
    }

    /**
     * ActionListener for Sam.
     * 
     * @author jay
     * @version 1.0
     */
    private class SamButtonListener implements ActionListener {
        /**
         * actionPerformed.
         * 
         * @param event
         *            event
         */
        public void actionPerformed(ActionEvent event) {
            votesForSam++;
            labelSam.setText("Votes for Sam: " + votesForSam);
            if (votesForSam > votesForJoe) {
                labelresult.setText("Sam is winning");
            } else if (votesForSam == votesForJoe) {
                labelresult.setText("There is a tie");
            }
        }
    }
}
