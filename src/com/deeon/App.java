package com.deeon;

import com.deeon.controller.AppConModule;
import com.deeon.controller.AppController;
import com.deeon.model.SQLTaskStorage;
import com.deeon.view.ConsoleView;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class App {

    public static void main(String[] args) {


        Injector injector = Guice.createInjector(new AppConModule());

        AppController appController = injector.getInstance(AppController.class);

//        AppController appController = new AppController(new ConsoleView(), new SQLTaskStorage());

        appController.startSession();

        System.exit(0);



    }
}
