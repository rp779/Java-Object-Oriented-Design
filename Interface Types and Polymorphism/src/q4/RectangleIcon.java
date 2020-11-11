/***********************
 * author: Ross Parsons
 **********************/

package q4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleIcon implements Icon {

    public RectangleIcon(int width) {
        this.width = width;
        this.height = width / 2;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);

        g2.setColor(color);
        g2.fill(rect);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
    /**
     * Assigns the paint color to the color property of the Icon object
     * @param: color the String containing the desired color to paint the icon
     */
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