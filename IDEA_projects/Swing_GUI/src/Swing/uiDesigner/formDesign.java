package Swing.uiDesigner;

import Swing.MyKeyListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formDesign {
    private JPanel panel1;
    private JTextField textField1;
    private JRadioButton button1;
    private JRadioButton button2;
    private JRadioButton button3;
    private JTextArea textArea1;
    private JButton calculateButton;
    private JComboBox comboBox1;
    private JSpinner spinner1;

    formDesign() {
        JFrame frame = new JFrame("Swing Designer");
        frame.setSize(100,100);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                textArea1.setText(input);
                textField1.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new formDesign();
            }
        });
    }
}
