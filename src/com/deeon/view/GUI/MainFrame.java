package com.deeon.view.GUI;

import com.deeon.controller.AddListener;
import com.deeon.controller.GUIAppController;
import com.deeon.controller.RemListener;
import com.deeon.controller.SaveListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    final JList tasks;
    private final ControlPanel controlPanel;
    private final GUIAppController guiAppController;


    @SuppressWarnings("unchecked")
    public MainFrame(String title, DefaultListModel listModel, GUIAppController guiAppController) {

        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.guiAppController = guiAppController;

        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(400, 400));


        tasks = new JList(listModel);
        tasks.setBorder(BorderFactory.createTitledBorder("Tasks: "));
        tasks.setLayoutOrientation(JList.VERTICAL);
        tasks.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        controlPanel = new ControlPanel(listModel);

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.BOTH;

        gc.gridx = 0;
        gc.gridy = 0;
        add(new JScrollPane(tasks), gc);

        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 0;
        add(controlPanel, gc);

        controlPanel.addBtn.addActionListener(new AddListener(listModel, controlPanel.txtFld));
        controlPanel.remBtn.addActionListener(new RemListener(listModel, tasks));
        controlPanel.saveBtn.addActionListener(new SaveListener(guiAppController));
        pack();

    }
}
