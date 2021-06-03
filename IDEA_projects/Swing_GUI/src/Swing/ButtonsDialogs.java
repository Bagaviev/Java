package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsDialogs implements ActionListener {
    JFrame frame;
    JLabel jLabel;
    JButton jButton1;

    ButtonsDialogs() {
        frame = new JFrame("Вопрос столетия");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);

        jLabel = new JLabel("Хочешь стать программистом?");
        frame.add(jLabel);

        jButton1 = new JButton("Наверно");
        jButton1.addActionListener(this);  // объект который создает кнопки сам же слушает события с них
        frame.add(jButton1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Наверно")) {
            customDialog dialog = new customDialog(ButtonsDialogs.this.frame);
            dialog.setVisible(true);
            jLabel.setText("Вы были перемещены нахуй.");
            jButton1.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonsDialogs();
            }
        });
    }
}

class customDialog extends JDialog {
    customDialog(JFrame owner) {
        super(owner, "Ask", true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0,30));
        setSize(200, 150);

        add(new JLabel("Да ебись ты в рот!"));
        JButton button = new JButton("Пойти нахуй");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(button);
//        pack();
    }
}