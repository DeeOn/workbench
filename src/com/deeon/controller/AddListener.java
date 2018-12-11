package com.deeon.controller;

import com.deeon.model.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener {

    DefaultListModel listModel;
    JTextField field;

    public AddListener(DefaultListModel listModel, JTextField field) {
        this.listModel = listModel;
        this.field = field;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (field.getText().length() != 0)
        listModel.addElement(new Task(field.getText()));
        field.setText("");
    }
}
