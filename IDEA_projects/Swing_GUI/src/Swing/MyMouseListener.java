package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener { // можно сделать extends JFrame и тогда использовать this.setVisible() и тд на текущем объекте
    JFrame frame;
    JLabel label;

    MyMouseListener() {
        frame = new JFrame("Other components");
        label = new JLabel("Title");
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setBounds(105,105, 90, 90);
        label.setBackground(Color.GRAY);
        label.setOpaque(true);

        frame.add(label);
        label.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setBackground(Color.GRAY);
        label.setText("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setBackground(Color.green);
        label.setText("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setBackground(Color.gray);
        label.setText("Mouse Exited");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyMouseListener();
            }
        });
    }
}
