package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyKeyListener implements java.awt.event.KeyListener {
    JFrame frame;
    JLabel label;

    MyKeyListener() {   // builded jar and works fine
        frame = new JFrame("Other components");
        label = new JLabel("Title");
        frame.setSize(200,200);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setBounds(0,0, 30, 30);
        label.setBackground(Color.RED);
        label.setOpaque(true);

        frame.add(label);
        frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'w':
                label.setLocation(label.getLocation().x, label.getLocation().y - 5);
                break;
            case 'a':
                label.setLocation(label.getLocation().x - 5, label.getLocation().y);
                break;
            case 's':
                label.setLocation(label.getLocation().x, label.getLocation().y + 5);
                break;
            case 'd':
                label.setLocation(label.getLocation().x + 5, label.getLocation().y);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyKeyListener();
            }
        });
    }
}
