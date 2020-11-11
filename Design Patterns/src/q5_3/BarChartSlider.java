package q5_3;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class BarChartSlider extends JPanel implements KeyListener {

    private int[] x, y, width, height;
    private JTextField[] fields;

    /**
     * @return a BarCharSlider object that has three textfields where a user
     * can enter a number between 1 and 100 and a color bar will expand to specified
     * number in the textfield.
     * */
    public BarChartSlider() {

        // The x and y arrays hold values that represent the distance
        // between the upper left origin of the BarChartSlider panel
        x = new int[]{20, 20, 20};
        y = new int[]{50, 100, 150};


        width = new int[]{0, 0, 0};
        height = new int[]{30, 30, 30};

        // an array of type: JTextField that will hold 3 JTextFields
        fields = new JTextField[3];

        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField("0"); // create a JTextField with initial value of 0
            fields[i].setBounds(420, y[i], 50, 30);
            add(fields[i]); // add JTextfield to itself (a JPanel subclass)
            fields[i].addKeyListener(this); //
        }
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Valid range is [0-100]", 20, 20);
        g.setColor(Color.RED);
        g.fillRect(x[0], y[0], width[0], height[0]);
        g.setColor(Color.YELLOW);
        g.fillRect(x[1], y[1], width[1], height[1]);
        g.setColor(Color.BLUE);
        g.fillRect(x[2], y[2], width[2], height[2]);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setContentPane(new BarChartSlider());
        frame.setVisible(true);
    }


    // implement keyTyped and keyPressed functions from the <<KeyListener>> Interface
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }



    @Override
    public void keyReleased(KeyEvent e) {
        int[] values = {0, 0, 0};
        try {
            for (int i = 0; i < fields.length; i++) values[i] = Integer.parseInt(fields[i].getText());
        } catch (NumberFormatException ignored) {

        }
        for (int i = 0; i < values.length; i++) width[i] = values[i] * 4;
        repaint();
    }
}