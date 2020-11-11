package q4;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;


/**
 * Class that implements Icon and overrides its paintIcon method along with
 * having a fillPaint method for changing selected colors
 */
public class CustomIcon implements Icon {

    private int size;
    private Color color;

    /**
     * Constructs a Icon object initializing size with the parameter x and
     * initializes color with Red
     *
     * @param x the int containing the size
     */
    CustomIcon(int x) {
        size = x;
        color = Color.RED;
    }

    /**
     * Designs the Icon for displaying using the desired size and color
     *
     * @param c the Component to be used
     * @param g the Graphics object to have its color set
     * @param x int representing desired width
     * @param y int representing desired height
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double custom = new Ellipse2D.Double(x, y, size, size);

        g2.setColor(color);
        g2.fill(custom);

    }

    /**
     * Assigns the paint color to the color property of the Icon object
     *
     * @param s the String containing the desired color
     */
    public void fillPaint(String s) {
        if (s == "RED") {
            color = Color.RED;
        } else if (s == "GREEN") {
            color = Color.GREEN;
        } else if (s == "BLUE") {
            color = Color.BLUE;
        }
    }

    /**
     * gets size of icon
     *
     * @return int representing icon size
     */
    @Override
    public int getIconWidth() {
        return size;
    }

    /**
     * gets size of icon
     *
     * @return int representing icon size
     */
    @Override
    public int getIconHeight() {
        return size;
    }
}