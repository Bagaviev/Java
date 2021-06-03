package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {
    private JMenuItem undoMenuItem;     // отмена
    private JMenuItem redoMenuItem;     // возврат
    private View view;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.redoMenuItem = redoMenuItem;
        this.undoMenuItem = undoMenuItem;
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
/*
        if (view.canUndo() & view.canRedo()) {
            undoMenuItem.setEnabled(true);
            redoMenuItem.setEnabled(true);
        } else if (view.canUndo())
            undoMenuItem.setEnabled(false);
          else if (view.canRedo())
            redoMenuItem.setEnabled(false);
          else {
            undoMenuItem.setEnabled(false);
            redoMenuItem.setEnabled(false);
        }
*/
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
