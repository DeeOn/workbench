package com.deeon.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveListener implements ActionListener {

    private final GUIAppController guiAppController;

    public SaveListener(GUIAppController guiAppController) {

        this.guiAppController = guiAppController;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        guiAppController.save();

    }
}
