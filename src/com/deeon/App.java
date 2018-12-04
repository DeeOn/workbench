package com.deeon;

import com.deeon.controller.AppController;
import com.deeon.controller.TaskManager;
import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
import com.deeon.model.FileTaskStorage;
import com.deeon.model.Menu;
import com.deeon.view.ConsoleView;
import com.deeon.view.IView;



public class App {

    public static void main(String[] args) {



        AppController appController = new AppController(new ConsoleView(), new FileTaskStorage("d:\\storage.dat"));

        appController.startSession();


    }
}
