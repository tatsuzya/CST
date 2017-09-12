package q5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * BusinessCard.
 *
 * @author Jay Lin
 * @version 1.0
 */
public class BusinessCard extends JFrame {
    /**SerialVersionUID.*/
    private static final long serialVersionUID = 7062469334560391173L;
    /**string x position.*/
    private static final int X_POSITION = 20;
    /**image x position.*/
    private static final int IMG_X_POSITION = 200;
    /**image y position.*/
    private static final int IMG_Y_POSITION = 0;
    /**string y position.*/
    private static final int Y_POSITION = 40;
    /**string y1 position.*/
    private static final int Y1_POSITION = 50;
    /**string y2 position.*/
    private static final int Y2_POSITION = 60;
    /**string y3 position.*/
    private static final int Y3_POSITION = 70;
    /**string y4 position.*/
    private static final int Y4_POSITION = 80;
    /** string y5 position.*/
    private static final int Y5_POSITION = 90;
    /**value of red.*/
    private static final int RED = 60;
    /**value of green.*/
    private static final int GREEN = 255;
    /** value of blue.*/
    private static final int BLUE = 140;
    /**value of new red. */
    private static final int NEW_RED = 140;
    /**value of new green.*/
    private static final int NEW_GREEN = 50;
    /**value of new blue.*/
    private static final int NEW_BLUE = 200;
    /**set the size of the program.*/
    public BusinessCard() {
        super("Jay Lin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new BusinessCardPanel());
        final int width = 350;
        final int height = 220;
        setSize(width, height); 
        setVisible(true);
    }

    /**
     * BusinessCardPanel.
     * @author jay
     * @version 1.0
     */
    public class BusinessCardPanel extends JPanel {
        // SerialVersionUID.//
        private static final long serialVersionUID = 1L;
        
        /**
         * Image.
         */
        private  Image img;
        /**
         * Display Image.
         */
        public BusinessCardPanel() {
            img = new ImageIcon(BusinessCardPanel.class.getResource(
                "/q5/running-robot.gif")).getImage();
        }

        /**
         * Called by the environment when tneedshe frame  to be updated.
         *
         * @param g the graphics context with which we paint into.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(new Color(RED, GREEN, BLUE));
            g.setColor(new Color(NEW_RED, NEW_GREEN, NEW_BLUE));
            g.drawString("Jay Lin", X_POSITION, Y_POSITION);
            g.drawString("KairoSoft inc", X_POSITION, Y1_POSITION);
            g.drawString("4567 Bryne lake,Burnaby BC"
                    + " CA ", X_POSITION, Y2_POSITION);
            g.drawString("Phone number:778 938 0707", X_POSITION, Y3_POSITION);
            g.drawString("Tax number : 604 928 0707", X_POSITION, Y4_POSITION);
            g.drawString("Email: KSOFT@GMAIL.COM", X_POSITION, Y5_POSITION);
            g.drawImage(img, IMG_X_POSITION, IMG_Y_POSITION, this);
        }
    }

    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        new BusinessCard();
    }

};
