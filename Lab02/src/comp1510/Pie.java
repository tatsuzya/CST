package comp1510;

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Pie.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Pie extends JApplet {
    /**
     * Drives the program.
     * 
     * @param page command line arguments.
     */
    public void paint(Graphics page) {
        
        final int x = 100;
        final int y = 100;
        final int width = 300;
        final int height = 300;
         final int startX = 50;
        page.setColor(Color.cyan);
        final int startAngle = 0;
        final int endAngle = 126;
        final int startY = 10;
        page.fillArc(x, y, width, height, startAngle, endAngle);
        page.drawString("Cyan = Rent and Utilities", startX, startY);

        page.setColor(Color.black);
        final int startAngle1 = 126;
        final int endAngle1 = 54;
        final int startY1 = 20;
        page.fillArc(x, y, width, height, startAngle1, endAngle1);
        page.drawString("Black = Transportation", startX, startY1);

        page.setColor(Color.MAGENTA);
        final int startAngle2 = 180;
        final int endAngle2 = 60;
        final int startY2 = 30;
        page.fillArc(x, y, width, height, startAngle2, endAngle2);
        page.drawString("magenta = Food", startX, startY2);

        page.setColor(Color.gray);
        final int startAngle3 = 234;
        final int endAngle3 = 90;
        final int startY3 = 40;
        page.fillArc(x, y, width, height, startAngle3, endAngle3);
        page.drawString("Gray = Educational", startX, startY3);

        page.setColor(Color.darkGray);
        final int startAngle4 = 324;
        final int endAngle4 = 36;
        final int startY4 = 50;
        page.fillArc(x, y, width, height, startAngle4, endAngle4);
        page.drawString("Dark gray = Miscellaneous", startX, startY4);

    }
}
