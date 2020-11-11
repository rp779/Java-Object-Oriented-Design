/**************************
 * @author Ross Parsons
 **************************/

package q4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements Icon {

    /**
     * Constructs a circle of given width (width and height are the same)
     * @param width width of the circle
     */
    public Circle(int width)
    {
        this.width = width;
        this.height = width;
    }


    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;

        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, width, height);
        g2.setColor(color);
        g2.fill(circle);

    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    public void fillColor(String color)
    {
        if(color.equals("Red")) this.color = Color.RED;
        else if(color.equals("Yellow")) this.color = Color.YELLOW;
        else if(color.equals("Blue")) this.color = Color.BLUE;
    }

    private int width;
    private int height;
    private Color color;
}
