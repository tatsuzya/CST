package comp1510;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ReboundPanel.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ReboundPanel extends JPanel {
    private int WIDTH = 500, HEIGHT = 300;
    private final int DELAY = 10, IMAGE_SIZE = 10;
    private ImageIcon image1;
    private ImageIcon image2;
    private Timer timer;
    private int x, y, moveX, moveY, x2, y2, moveX2, moveY2;

    /**
     * set up the panel.
     */
    public ReboundPanel() {
        timer = new Timer(DELAY, new ReboundListener());
        image1 = new ImageIcon("1.PNG");
        image2 = new ImageIcon("1.PNG");
        x = 0;
        y = 40;
        x2 = 40;
        y2 = 40;
        moveX = moveY = 3;
        moveX2 = 5;
        moveY2 = 8;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        timer.start();
    }

    /**
     * draw the image.
     */
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        image1.paintIcon(this, page, x, y);
        image2.paintIcon(this, page, x2, y2);
    }

    /**
     * ReboundListener.
     * 
     * @author jay
     * @version 1.0
     */
    private class ReboundListener implements ActionListener {
        /**
         * actionPerformed.
         * 
         * @param event
         *            event
         */
        public void actionPerformed(ActionEvent event) {
            x += moveX;
            y += moveY;
            x2 += moveX2;
            y2 += moveY2;
            if (x <= 0 || x >= WIDTH - IMAGE_SIZE) {
                moveX = moveX * -1;
            }
            if (y <= 0 || y >= HEIGHT - IMAGE_SIZE) {
                moveY = moveY * -1;
            }
            if (x2 <= 0 || x2 >= WIDTH - IMAGE_SIZE) {
                moveX2 = moveX2 * -1;
            }
            if (y2 <= 0 || y2 >= HEIGHT - IMAGE_SIZE) {
                moveY2 = moveY2 * -1;
            }
            if (x + IMAGE_SIZE >= x2 - IMAGE_SIZE
                    && y - IMAGE_SIZE <= y2 + IMAGE_SIZE) {
                if (x - IMAGE_SIZE <= x2 + IMAGE_SIZE
                        && y + IMAGE_SIZE >= y2 - IMAGE_SIZE) {
                    moveX = moveX * -1;
                    moveY = moveY * -1;
                }
            }
            if (x + IMAGE_SIZE >= x2 - IMAGE_SIZE
                    && y - IMAGE_SIZE <= y2 + IMAGE_SIZE) {
                if (x - IMAGE_SIZE <= x2 + IMAGE_SIZE
                        && y + IMAGE_SIZE >= y2 - IMAGE_SIZE) {
                    moveX2 = moveX2 * -1;
                    moveY2 = moveY2 * -1;
                }
            }
            repaint();
        }
    }
}
