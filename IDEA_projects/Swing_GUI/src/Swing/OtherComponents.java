package Swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// еще бывают таблицы JTable
// вкладки JTabbedPane, JPanel
// progress bars
// пиздато в Шилдте и Корнелле асписано все, со скринами
// setLocationRelativeTo(null); чтобы окно гуи открывалось в центре

public class OtherComponents {
    OtherComponents() {
        JFrame frame = new JFrame("Other components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.green);

        JToggleButton toggleButton = new JToggleButton("On / off");
        toggleButton.setBackground(Color.pink);
        JSlider slider = new JSlider();
        JSpinner spinner = new JSpinner();
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Pipka");
        comboBox.addItem("Siska");
        comboBox.addItem("Jdoweihdu");

        JLabel jlab = new JLabel("JToggleButton:");
        JLabel jlab2 = new JLabel("JToggleSlider:");
        JLabel jlab3 = new JLabel("JSpinner:");
        JLabel jlab4 = new JLabel("JComboBox:");

        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AbstractButton abstractButton = (AbstractButton) e.getSource();

                if (abstractButton.isSelected())
                    jlab.setText("Turned on!");
                else
                    jlab.setText("Turned off.");
            }
        });

        slider.addChangeListener(new ChangeListener() {
             @Override
             public void stateChanged(ChangeEvent e) {
                 JSlider slider = (JSlider) e.getSource ();
                 jlab2.setText(String.valueOf(slider.getValue()));
             }
         }
        );

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner slider = (JSpinner) e.getSource();
                jlab3.setText(String.valueOf(slider.getValue()));
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = comboBox.getItemAt(comboBox.getSelectedIndex());
                jlab4.setText(value);
            }
        });

        frame.setLayout(new GridLayout(4, 1, 2,2));
        frame.setSize(300, 125);
        frame.setVisible(true);

        frame.add(jlab);
        frame.add(toggleButton);

        frame.add(jlab2);
        frame.add(slider);

        frame.add(jlab3);
        frame.add(spinner);

        frame.add(jlab4);
        frame.add(comboBox);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OtherComponents();
            }
        });
    }
}
