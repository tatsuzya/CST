package comp1510;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * CirclePanel.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CirclePanel extends JPanel {
    private final int WIDTH = 600, HEIGHT = 400;
    private Circle circle;

    /**
     * constructor for object of type CirclePanel.
     */
    public CirclePanel() {
        addMouseListener(new CirclesListener());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    /**
     * Draw the circle.
     */
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        if (circle != null)
            circle.draw(page);
    }

    /**
     * CircleListener.
     * 
     * @author jay
     *
     */
    private class CirclesListener implements MouseListener {

        public void mousePressed(MouseEvent event) {
            Point pos = event.getPoint();
            if (circle == null) {
                circle = new Circle(pos);
            } else if (circle.isInside(pos)) {
                circle = null;
            } else {
                circle.move(pos);
            }
            repaint();
        }

        /**
         * Action when mouse is clicked.
         */
        public void mouseClicked(MouseEvent event) {

        }

        /**
         * Action when mouse is released.
         */
        public void mouseReleased(MouseEvent event) {
        }

        /**
         * Action when mouse enters.
         */
        public void mouseEntered(MouseEvent event) {
            setBackground(Color.WHITE);
            repaint();
        }

        /**
         * Action when mouse exits.
         */
        public void mouseExited(MouseEvent event) {
            setBackground(Color.BLUE);
            repaint();
        }
    }
}