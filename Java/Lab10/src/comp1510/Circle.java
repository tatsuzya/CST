package comp1510;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * Circle.
 * 
 * @author jay
 * @version 1.0
 */
public class Circle {
    private int centerX, centerY;
    private int radius;
    private Color color;
    static Random generator = new Random();

    /**
     * Constructor for the object of type Circle.
     * 
     * @param point
     */
    public Circle(Point point) {
        radius = Math.abs(generator.nextInt()) % 50 + 25;
        color = new Color(Math.abs(generator.nextInt()) % 16777216);
        centerX = point.x;
        centerY = point.y;
    }

    /**
     * draw circle.
     * 
     * @param page
     */
    public void draw(Graphics page) {
        page.setColor(color);
        page.fillOval(centerX - radius, centerY - radius, radius * 2,
                radius * 2);
    }

    /**
     * move the circle.
     * 
     * @param p
     */
    public void move(Point p) {
        centerX = p.x;
        centerY = p.y;
    }

    /**
     * compare p's distance
     * 
     * @param p
     * @return result
     */
    public boolean isInside(Point p) {
        boolean result = false;
        double distance = Math.sqrt((Math.pow(this.centerX - p.x, 2)
                - Math.pow(this.centerY - p.y, 2)));
        if (distance <= radius) {
            result = true;
        } else
            result = false;
        return result;
    }
}