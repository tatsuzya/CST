package q2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * DrawRectangle.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DrawRectangle extends JFrame {
    /** point 1. **/
    private Point p1;
    /** point 2. **/
    private Point p2;
    /** draw rectangle. **/
    private Rectangle2D rect;
    /** width of the panel. */
    private final int width = 500;
    /** height of the panel. */
    private final int height = 500;

    /**
     * Set up the panel.
     */
    public DrawRectangle() {
        super("Jay Lin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawRectanglePanel());
        setSize(width, height);
        setVisible(true);
    }

    /**
     * Create the panel.
     */
    private class DrawRectanglePanel extends JPanel
            implements MouseListener, MouseMotionListener {

        /**
         * add listener to the panel.
         */
        DrawRectanglePanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        /**
         * component for drawing rectangle.
         * 
         * @param g
         *            graphic
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (rect != null) {
                ((Graphics2D) g).draw(rect);
            }
            System.out.println("Paint called");
        }

        /**
         * action when mouse is pressed.
         * 
         * @param e
         *            event
         */
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
            rect = new Rectangle2D.Double(p1.x, p1.y, 0, 0);
            System.out.println("Mouse pressed called");
        }

        /**
         * action when mouse is released.
         * 
         * @param e
         *            event
         */
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse released called");
        }

        /**
         * action when mouse is dragged.
         * 
         * @param e
         *            event
         **/

        public void mouseDragged(MouseEvent e) {
            p2 = e.getPoint();
            if (quadOne(p1, p2)) {
                rect.setRect(p1.x, p2.y, p2.x - p1.x, p1.y - p2.y);
            } else if (quadTwo(p1, p2)) {
                rect.setRect(p2.x, p2.y, p1.x - p2.x, p1.y - p2.y);
            } else if (quadThree(p1, p2)) {
                rect.setRect(p2.x, p1.y, p1.x - p2.x, p2.y - p1.y);
            } else {
                rect.setRect(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y);
            }
            repaint();
            System.out.println("Mouse dragged called");
        }

        /**
         * check to see if point 2 is in quad 1.
         * 
         * @param point1
         *            point 1
         * @param point2
         *            point 2
         * @return quad 1 property.
         */
        public boolean quadOne(Point point1, Point point2) {
            return p1.x <= p2.x && p1.y >= p2.y;
        }

        /**
         * check to see if point 2 is in quad 2.
         * 
         * @param point1
         *            point 1
         * @param point2
         *            point 2
         * @return quad 2 property
         */
        public boolean quadTwo(Point point1, Point point2) {
            return p1.x >= p2.x && p1.y >= p2.y;
        }

        /**
         * check to see if point 2 is in quad 3.
         * 
         * @param point1
         *            point 1
         * @param point2
         *            point 2
         * @return quad 3 property
         */
        public boolean quadThree(Point point1, Point point2) {
            return p1.x >= p2.x && p1.y <= p2.y;
        }

        /**
         * action when mouse entered.
         * 
         * @param e
         *            event
         */
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * action when mouse exited.
         * 
         * @param e
         *            event
         */
        public void mouseExited(MouseEvent e) {
        }

        /**
         * action when mouse is clicked.
         * 
         * @param e
         *            event
         */
        public void mouseClicked(MouseEvent e) {
        }

        /**
         * action when mouse is moved.
         * 
         * @param e
         *            event
         */
        public void mouseMoved(MouseEvent e) {
        }

    }

    /**
     * Drives the program.
     * 
     * @param args
     *            command line argument
     */
    public static void main(String[] args) {
        new DrawRectangle();
    }

};
