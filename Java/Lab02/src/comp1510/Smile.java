package comp1510;

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Smile.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Smile extends JApplet {
    /**
     * Drives the program.
     * 
     * @param page command line argument
     */
    public void paint(Graphics page) {
        //page.fill"shape" ( x, y , width , height)       
        page.setColor(Color.orange);
        final int x = 0;
        final int y = 0; 
        final int width = 800;
        final int height = 800;
        page.fillRect(x, y, width, height);
        
        page.setColor(Color.lightGray);
        final int x1 = 200;
        final int y1 = 200; 
        final int x2 = 500;
        final int width1 = 400;
        final int height1 = 400;
        final int width2 = 100;
        final int height2 = 100;
        page.fillOval(x1, y1, width1, height1);
        page.fillOval(x1, y1, width2, height2);
        page.fillOval(x2, y1, width2, height2);

        page.setColor(Color.black);
        final int x3 = 300;
        final int y3 = 300; 
        final int x4 = 450;
        final int x5 = 380;
        final int y4 = 385;
        final int width3 = 50;
        final int height3 = 50;
        final int width4 = 30;
        final int height4 = 30;
        page.fillOval(x3, y3, width3, height3);
        page.fillOval(x4, y3, width3, height3);
        page.fillOval(x5, y4, width4, height4);

        page.setColor(Color.white);
        final int x6 = 350;
        final int y6 = 430;
        final int width5 = 100;
        final int height5 = 100;
        final int startAngle = 0;
        final int endAngle = -180;
        page.fillArc(x6, y6, width5, height5, startAngle, endAngle);

    }
}
