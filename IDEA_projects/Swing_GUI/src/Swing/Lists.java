package Swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Lists implements ListSelectionListener {
    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;

    String[] names = {"Sherry","Jon","Rachel","Randy","Todd"};

    Lists() {
        JFrame jfrm = new JFrame("JList Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 150);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlst = new JList<String>(names);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120, 70));

        jlab = new JLabel("Please choose а name");

        jlst.addListSelectionListener(this);

        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int idx = jlst.getSelectedIndex();
        if (idx != -1)
            jlab.setText("Current selection: " + names[idx]);
        else
            jlab.setText("Please choose а name");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Lists();
            }
        });
    }
}
