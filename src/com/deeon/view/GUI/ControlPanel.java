package com.deeon.view.GUI;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    final JTextField txtFld;
    final JButton addBtn;
    final JButton remBtn;
    final JButton saveBtn;

    public ControlPanel(DefaultListModel listModel) {

        txtFld = new JTextField(25);
        txtFld.setBorder(BorderFactory.createTitledBorder("Task name:"));
        addBtn = new JButton("Add");
        remBtn = new JButton("Remove");
        saveBtn = new JButton("Save");


        setBorder(BorderFactory.createTitledBorder("Controls:"));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;

        gc.gridx = 0;
        gc.gridy = 0;
        add(txtFld, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(addBtn, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(remBtn, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(saveBtn, gc);

        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 4;
        add(new JPanel(), gc);
    }
}
