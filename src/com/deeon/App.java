package com.deeon;

import com.deeon.controller.AppController;
import com.deeon.model.FileTaskStorage;
import com.deeon.model.SQLTaskStorage;
import com.deeon.model.Task;
import com.deeon.view.ConsoleView;


import java.sql.*;
import java.util.List;


public class App {

    public static void main(String[] args) {



        AppController appController = new AppController(new ConsoleView(), new SQLTaskStorage());

        appController.startSession();



    }
}
