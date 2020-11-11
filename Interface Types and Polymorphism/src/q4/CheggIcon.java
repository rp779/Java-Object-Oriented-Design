package q4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Class for the Application of this program including the createButton method
 * for returning new buttons with action listeners
 *
 */
public class CheggIcon{

/**
 * @param args the command line arguments
 */
    /**
     * Creates and returns a JButton with an ActionListener which is an
     * anonymous class
     *
     * @param i index in outer for loop
     * @param label label used to call repaint() to initiate color change
     * @param icon Custom Icon object used to display circle and change colors
     * @return JButton object used to change icon to color designated by the
     * button
     */
    public static JButton createButton(final int i, final JLabel label, final CustomIcon icon) {
        final String[] colors = new String[]{"RED", "GREEN", "BLUE"};

        JButton button = new JButton(colors[i]);
        button.addActionListener(new ActionListener() {
            /**
             * The function called when a button is clicked, will store the
             * selected color and then repaint the icon
             *
             * @param event ActionEvent object holding the data describing the
             * event
             */
            public void actionPerformed(ActionEvent event) {
                icon.fillPaint(colors[i]);
                label.repaint();

            }
        });
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());

        final int FIELD_WIDTH = 20;
        final JTextField textField = new JTextField(FIELD_WIDTH);
        JButton green = new JButton();
        JButton red = new JButton();
        JPanel panel = new JPanel();

        JButton blue = new JButton();
        JButton btn[] = {green, red, blue};
        CustomIcon icon = new CustomIcon(50);
        JLabel label = new JLabel(icon);
        panel.add(label);
        Color c;
        for (int i = 0; i < 3; i++) {

            btn[i] = createButton(i, label, icon);

            panel.add(btn[i]);
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.setLayout(new FlowLayout());

    }

}


