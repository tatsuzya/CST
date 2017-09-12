package comp1510;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * ColorOptionsPanel.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ColorOptionsPanel extends JPanel {
    private final int WIDTH = 350, HEIGHT = 100, FONT_SIZE = 20;
    private final int NUM_COLORS = 5;
    private Color[] color = new Color[NUM_COLORS];
    private JRadioButton[] colorButton = new JRadioButton[NUM_COLORS];
    private JLabel heading;

    /**
     * Constructor for object of type ColorOptionsPanel.
     */
    public ColorOptionsPanel() {
        heading = new JLabel("Choose the background color!");
        heading.setFont(new Font("Helvetica", Font.BOLD, FONT_SIZE));
        color[0] = Color.yellow;
        color[1] = Color.cyan;
        color[2] = Color.red;
        color[3] = Color.green;
        color[4] = Color.magenta;

        colorButton[0] = new JRadioButton("Yellow");
        colorButton[0].setSelected(true);
        colorButton[1] = new JRadioButton("cyan");
        colorButton[2] = new JRadioButton("red");
        colorButton[3] = new JRadioButton("green");
        colorButton[4] = new JRadioButton("magenta");

        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        ColorListener cListener = new ColorListener();
        add(heading);
        setBackground(Color.yellow);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        for (int i = 0; i < colorButton.length; i++) {
            radioPanel.add(colorButton[i]);
            group.add(colorButton[i]);
            colorButton[i].addActionListener(cListener);
            colorButton[i].setBackground(Color.white);
            add(colorButton[i]);
        }
    }

    /**
     * ColorListener
     * 
     * @author jay
     *
     */
    private class ColorListener implements ActionListener {
        /**
         * action performed.
         */
        public void actionPerformed(ActionEvent event) {
            if (colorButton[0].isSelected()) {
                setBackground(Color.YELLOW);
            } else if (colorButton[1].isSelected()) {
                setBackground(Color.CYAN);
            } else if (colorButton[2].isSelected()) {
                setBackground(Color.RED);
            } else if (colorButton[3].isSelected()) {
                setBackground(Color.GREEN);
            } else if (colorButton[4].isSelected()) {
                setBackground(Color.MAGENTA);
            }
        }
    }
}
