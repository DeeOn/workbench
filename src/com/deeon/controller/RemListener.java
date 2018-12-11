package com.deeon.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemListener implements ActionListener {

    DefaultListModel listModel;
    JList list;

    public RemListener(DefaultListModel listModel, JList list) {
        this.listModel = listModel;
        this.list = list;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (list.getSelectedIndex() != -1)
        listModel.removeElementAt(list.getSelectedIndex());

    }
}
