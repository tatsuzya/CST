package comp1510;

import java.awt.*;
import javax.swing.*;

/**
 * TelephonePanel.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TelephonePanel extends JPanel {
    /**
     * Constructor for object type of TelephonePanel.
     */
    public TelephonePanel() {
        // set BorderLayout for this panel
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Telephone");
        add(title, BorderLayout.NORTH);

        GridLayout layout = new GridLayout(4, 3, 2, 2);
        JPanel keypanel = new JPanel(layout);

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonStar = new JButton("*");
        JButton button0 = new JButton("0");
        JButton buttonHash = new JButton("#");

        keypanel.add(button1);
        keypanel.add(button2);
        keypanel.add(button3);
        keypanel.add(button4);
        keypanel.add(button5);
        keypanel.add(button6);
        keypanel.add(button7);
        keypanel.add(button8);
        keypanel.add(button9);
        keypanel.add(buttonStar);
        keypanel.add(button0);
        keypanel.add(buttonHash);

        add(keypanel, BorderLayout.CENTER);
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }
}
