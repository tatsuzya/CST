package q4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TrafficLight.
 * 
 * @author Your Name goes here
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TrafficLight extends JFrame {

    /**
     * click button.
     */
    private JButton button;
    /**
     * state of the lights.
     */
    private int state;
    /**
     * state 1 of the lights.
     */
    private final int state1 = 1;
    /**
     * state 2 of the lights.
     */
    private final int state2 = 2;
    /**
     * state 3 of the lights.
     */
    private final int state3 = 3;
    /**
     * width of the window.
     */
    private final int width = 200;
    /**
     * height of the window.
     */
    private final int height = 420;
    /**
     * height of the panel.
     */
    private final int heightPanel = 340;
    /**
     * width of the panel.
     */
    private final int widthPanel = 150;
    /**
     * value of red of the window's background.
     */
    private final int colorR = 236;
    /**
     * value of green of the window's background.
     */
    private final int colorG = 118;
    /**
     * value of blue of the window's background.
     */
    private final int colorB = 0;
    /**
     * x position of the light.
     */
    private final int xPosition = 40;
    /**
     * y position of the light 1.
     */
    private final int yPosition = 60;
    /**
     * width of the light.
     */
    private final int widthLight = 60;
    /**
     * height of the light.
     */
    private final int heightLight = 60;
    /**
     * y position of the light 2.
     */
    private final int yPosition1 = 150;
    /**
     * y position of the light 3.
     */
    private final int yPosition2 = 240;

    /**
     * 
     * constructor for object of type TrafficLight.
     */
    public TrafficLight() {
        super("Jay Lin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Change");
        button.addActionListener(new ButtonButtonListener());
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(new DrawingPanel());
        panel.setBackground(new Color(colorR, colorG, colorB));

        getContentPane().add(panel);

        setSize(width, height);

        setVisible(true);

        state = 0;
    }

    /**
     * DrawingPanel.
     * 
     * @author jay
     * @version 1.0
     */
    final class DrawingPanel extends JPanel {
        /**
         * Draws the panel.
         */
        private DrawingPanel() {
            setPreferredSize(new Dimension(widthPanel, heightPanel));
        }

        /**
         * Paint component for the graphic.
         * 
         * @param g
         *            graphic
         */
        public void paintComponent(Graphics g) {
            drawBackground(g);
            drawLights(g);

        }

        /**
         * Draws the background of the lights.
         * 
         * @param g
         *            graphic
         */
        private void drawBackground(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillOval(xPosition, yPosition, widthLight, heightLight);
            g.fillOval(xPosition, yPosition1, widthLight, heightLight);
            g.fillOval(xPosition, yPosition2, widthLight, heightLight);

        }

        /**
         * Method drawLight draws the lights.
         * 
         * @param g
         *            graphic
         */
        private void drawLights(Graphics g) {
            if (state == 0) {
                g.setColor(Color.GREEN);
                g.fillOval(xPosition, yPosition, widthLight, heightLight);
            } else if (state == state1) {
                g.setColor(Color.YELLOW);
                g.fillOval(xPosition, yPosition1, widthLight, heightLight);

            } else if (state == state2) {
                g.setColor(Color.RED);
                g.fillOval(xPosition, yPosition2, widthLight, heightLight);

            } else if (state == state3) {
                g.setColor(Color.GREEN);
                g.fillOval(xPosition, yPosition, widthLight, heightLight);

            }
        }
    }

    /**
     * ActionListerner for traffic light.
     * 
     * @author jay
     * @version 1.0
     */
    private class ButtonButtonListener implements ActionListener {
        /**
         * action performed.
         * 
         * @param event
         *            button
         */
        public void actionPerformed(ActionEvent event) {
            if (state == 0) {
                state = state1;
            } else if (state == state1) {
                state = state2;
            } else if (state == state2) {
                state = state3;
            } else if (state == state3) {
                state = state1;
            }
            repaint();
        }
    }

    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        new TrafficLight();
    }
}
