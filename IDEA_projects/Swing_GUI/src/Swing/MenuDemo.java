package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo implements ActionListener {
    JLabel jlab;

    MenuDemo() {
        JFrame jfrm = new JFrame("Menu Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab = new JLabel();
        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("File");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiExit = new JMenuItem("Exit");
            jmFile.add(jmiOpen);
            jmFile.add(jmiSave);
            jmFile.add(jmiExit);
                jmb.add(jmFile);

        JMenu jmOptions = new JMenu("Options");

        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        JMenuItem jmiAuthors = new JMenuItem("Authors");
        jmiAuthors.setToolTipText("Bagaviev Bulat");
            jmHelp.add(jmiAbout);
            jmHelp.add(jmiAuthors);
            jmOptions.add(jmHelp); // menu pod menu
                jmb.add(jmOptions);

        jmiOpen.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);
        jmiAuthors.addActionListener(this);

        jfrm.add(jlab);
        jfrm.setJMenuBar(jmb);  // без J, просто MenuBar будет не тот вызов, не к swing а к awt
        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();

        if (comStr.equals("Exit"))
            System.exit(0);

        jlab.setText(comStr + " Selected");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo();
            }
        });
    }
}
