package comp1510;

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;
/** 
 * Shapes.
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Shapes extends JApplet {
    /**
     * Drives the program.
     * @param page command line arguments.
     */
    public void paint(Graphics page) {
        
        page.setColor(Color.yellow);
        final int x = 0; 
        final int y = 0;
        final int width = 800;
        final int height = 800;
        page.fillRect(x, y, width, height);
        
        page.setColor(Color.blue);
        final int x1 = 200;
        final int y1 = 200;
        final int width1 = 100;
        final int height1 = 100;
        page.fillRect(x1, y1, width1, height1);
        
        page.setColor(Color.red);
        final int x2 = 215;
        final int y2 = 215;
        final int width2 = 70;
        final int height2 = 70; 
        page.fillRect(x2, y2, width2, height2);
        
        page.setColor(Color.green);
        final int x3 = 250;
        final int y3 = 200;
        final int width3 = 80;
        final int height3 = 50;
        page.fillRect(x3, y3, width3, height3);
        
        page.setColor(Color.white);
        final int x4 = 300;
        final int y4 = 300;
        final int width4 = 80;
        final int height4 = 50;
        page.fillRect(x4, y4, width4, height4);
    }
}
