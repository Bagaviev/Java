package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFields implements ActionListener {
    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    TextFields() {
        JFrame jfrm = new JFrame("Use а Text Field");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(240, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");     //кароче задает кастомное имя для события ввода при enter. Если этого не сделать,
        // то при вводе "Reverse" в инпут сработает наша реверс функция, тк ее название будет совпадать с вводом

        JButton jbtnRev = new JButton("Reverse");
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");

        jfrm.add(jlabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);
        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand().equals("Reverse")) {  // не работает так: getSource() == jbtnRev
            String orgStr = jtf.getText();
            String resStr = "";

            for (int i = orgStr.length() - 1; i >= 0; i--)
                resStr += orgStr.charAt(i);

            jtf.setText(resStr);
        } else
            jlabContents.setText("You pressed ENTER. Text is: " + jtf.getText());
    }

    public static void main (String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFields();
            }
        });
    }
}