package com.deeon;

import com.deeon.controller.AppController;
import com.deeon.model.FileTaskStorage;
import com.deeon.view.ConsoleView;




public class App {

    public static void main(String[] args) {



        AppController appController = new AppController(new ConsoleView(), new FileTaskStorage("d:\\storage.dat"));

        appController.startSession();


    }
}
