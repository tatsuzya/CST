package comp1510;

import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Colors.
 * 
 * @author jay
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Colors extends JApplet {
    /** 
     * Drives the program.
     * 
     * @param page command line argument.
     */
    public void paint(Graphics page) {
        
        final Color myColor = new Color(2486921);
        setBackground(Color.white);
        page.setColor(Color.white);
        
        int redCode = myColor.getRed();
        int blueCode = myColor.getBlue();
        int greenCode = myColor.getGreen();
        
        page.setColor(myColor);
        final int width = 250;
        final int height = 150;
        page.fillRect(0, 0, width, height);
        
        page.setColor(Color.black);
        final int x = 20;
        final int y = 20;
        final int y1 = 40;
        final int y2 = 60;
        page.drawString("red: " + redCode, x, y);
        page.drawString("blue: " + blueCode, x, y1);
        page.drawString("green: " + greenCode, x, y2);
    }   
}