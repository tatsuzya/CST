package comp1510;

import javax.swing.JApplet;
import java.awt.*;

/**
 * Coords
 * @author jay
 * @version 1.0
 */
public class Coords extends JApplet {
    /** 
     * Drives the program
     */
    public void paint(Graphics page) {

        int x, y, x1, y1, x2, y2, x3, y3, x4, y4;
        int width, height, width1, height1, width2, height2, width3, height3, width4, height4;

        setBackground(Color.yellow);
        page.setColor(Color.blue);

        x = 0;
        y = 700;
        width = 100;
        height = 100;
        x1 = 700;
        y1 = 0;
        width1 = 100;
        height1 = 100;
        x2 = 700;
        y2 = 700;
        width2 = 100;
        height2 = 100;
        x3 = 0;
        y3 = 0;
        width3 = 100;
        height3 = 100;
        x4 = 350;
        y4 = 350;
        width4 = 100;
        height4 = 100;

        page.fillRect(x, y, width, height);
        page.fillRect(x1, y1, width1, height1);
        page.fillRect(x2, y2, width2, height2);
        page.fillRect(x3, y3, width3, height3);
        page.fillRect(x4, y4, width4, height4);
    }
}
