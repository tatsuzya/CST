package comp1510;
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.Color;


public class Stewie extends JApplet {
    public void paint(Graphics page) {
        QuadCurve2D q = new QuadCurve2D.Float();
        q.setCurve(220,350,235,349,250,352);
        Graphics2D g2 = (Graphics2D) page;
        g2.draw(q);
        q.setCurve(225,345,221,349,220,350);
        g2.draw(q);
        q.setCurve(225,350,234,354,235,355);
        g2.draw(q);
        
        CubicCurve2D c = new CubicCurve2D.Double();
        c.setCurve(100, 320, 170, 430, 330, 430, 400, 320);
        g2.draw(c);
        
        c.setCurve(100, 300, 170, 190, 330, 190, 400, 300);
        g2.draw(c);
        
        page.drawArc(395,300,20,20,0,130 );
        page.drawArc(395,300,20,20,0,-130);
        page.drawArc(85,300,20,20,50,130);
        page.drawArc(85,300,20,20,-50,-130);
        page.drawArc(87,305,10,13,0,90);
        page.drawArc(400,305,10,13,90,110);
        
        page.fillOval(310,296,5,5);
        page.fillOval(170,296,5,5);
        page.drawOval(150, 280, 50,50);
        page.drawOval(290, 280, 50,50);
        
        
        g2.draw(new Line2D.Double(160,260,180,270));
        g2.draw(new Line2D.Double(152,295,200,300));
        g2.draw(new Line2D.Double(151,310,195,315));
        g2.draw(new Line2D.Double(338,295,290,300));
        g2.draw(new Line2D.Double(338,310,294,315));
        g2.draw(new Line2D.Double(320,260,300,270));
        g2.draw(new Line2D.Double(240,320,230,330));
        g2.draw(new Line2D.Double(230,330,235,335));
    }
}