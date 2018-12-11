package com.deeon.controller;

import com.deeon.model.Task;
import com.deeon.view.GUI.MainFrame;
import com.deeon.view.IGUIView;
import com.google.inject.Inject;

import javax.swing.*;

public class GUIAppController {

    private final IGUIView view;
    private final TaskManager taskManager;
    private DefaultListModel<Task> listModel;


    @Inject
    public GUIAppController(IGUIView view, TaskManager taskManager) {

        this.view = view;
        this.taskManager = taskManager;

    }

    public void startSession() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                listModel = new DefaultListModel<>();
                for (Task task: taskManager.getTasksCollection()) {
                    listModel.addElement(task);
                }
                JFrame appWindow = new MainFrame("App", listModel, getInstance());
                appWindow.setVisible(true);
            }
        });

    }

    public void save() {
        taskManager.setTasksCollection(listModel);
        taskManager.saveChanges();
    }

    private GUIAppController getInstance() {
        return this;
    }





}





