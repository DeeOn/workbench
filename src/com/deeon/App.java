package com.deeon;

import com.deeon.controller.TaskManager;
import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
import com.deeon.model.ArrayTaskStorage;
import com.deeon.model.FileTaskStorage;
import com.deeon.model.Task;
import com.deeon.view.ConsoleView;
import com.deeon.view.IView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager(new FileTaskStorage("d:\\storage.dat"));
        try {
            taskManager.createTask("Task5");
            taskManager.createTask("Task6");
            } catch (TaskIsAlreadyExistException e) {
            System.out.println(e);
        }

//        try {
//            taskManager.deleteTask("Task2");
//            taskManager.deleteTask("Task4");
//        } catch (TaskIsNotExistException e) {
//            System.out.println(e);
//        }

        IView view = new ConsoleView();

        try {
            view.printTasksNames(taskManager.getTasksNames());
        } catch (TaskStorageIsEmptyException e) {
            System.out.println(e);
        }




    }
}
