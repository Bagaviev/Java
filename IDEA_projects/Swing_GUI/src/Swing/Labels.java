package Swing;

import javax.swing.*;
import java.awt.*;

public class Labels {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My first GUI");
        JLabel label = new JLabel("Some text");
        ImageIcon ii = new ImageIcon("java-swing-class-hierarchy.jpg");
        JLabel label2 = new JLabel("Swing class hierarchy", ii, JLabel.CENTER);

        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.add(label, BorderLayout.EAST);
        frame.add(label2, BorderLayout.WEST);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
