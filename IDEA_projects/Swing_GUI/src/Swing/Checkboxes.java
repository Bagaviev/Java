package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Checkboxes implements ItemListener {
    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;

    Checkboxes() {
        JFrame jfrm = new JFrame("Demonstrate checkboxes");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(280, 120);
        jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");

        jcbAlpha = new JCheckBox("Alpha");
        jcbAlpha.setEnabled(false);
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");

        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);

        jfrm.add(jcbAlpha);
        jfrm.add(jcbBeta);
        jfrm.add(jcbGamma);
        jfrm.add(jlabChanged);
        jfrm.add(jlabSelected);
        jfrm.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";
        JCheckBox cb = (JCheckBox) e.getItem();

        if (cb.isSelected())
            jlabChanged.setText(cb.getText() + " was selected.");
        else
            jlabChanged.setText(cb.getText() + " was cleared.");

        if (jcbAlpha.isSelected())
            str += "Alpha ";
        if (jcbBeta.isSelected())
            str += "Beta ";
        if (jcbGamma.isSelected())
            str += "Gamma";

        jlabSelected.setText("Selected checkboxes: " + str);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Checkboxes();
            }
        });
    }
}
