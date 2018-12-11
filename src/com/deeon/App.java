package com.deeon;

import com.deeon.controller.AppConModule;
import com.deeon.controller.AppController;
import com.deeon.controller.GUIAppConModule;
import com.deeon.controller.GUIAppController;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class App {

    public static void main(String[] args) {


//        Injector injector = Guice.createInjector(new AppConModule());
//
//        AppController appController = injector.getInstance(AppController.class);
//
//        appController.startSession();

        Injector injector = Guice.createInjector(new GUIAppConModule());

        GUIAppController guiAppController = injector.getInstance(GUIAppController.class);

        guiAppController.startSession();




//        System.exit(0);



    }
}
