/***********************
 * author: Ross Parsons
 **********************/
package q4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleIconTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        // set layout so buttons are next to eachother
        frame.setLayout(new FlowLayout());

        // Create JLabel and add construct it with the rectangle icon
        // Add the JLabel to the frame
        RectangleIcon rectangle = new RectangleIcon(150);
        JLabel label = new JLabel(rectangle);
        frame.getContentPane().add(label);

        // Create three buttons. i is the index in String[] colors = {"Red",...} in the createButton function
        // i represents the name of the button (colors[0] is "Red")
        for (int i = 0; i < 3; i++)
        {
            JButton btn = createButton(i, label, rectangle);
            frame.add(btn);
        }

        // Set the rectangle to Yellow initially
        rectangle.fillColor("Yellow");
        label.repaint();

        // Setup frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static JButton createButton(final int i, final JLabel label, final RectangleIcon icon)
    {
        final String[] colors = new String[]{"Red", "Yellow", "Blue"};
        JButton button = new JButton(colors[i]);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                icon.fillColor(colors[i]);
                label.repaint();
            }
        });
        return button;
    }
}
