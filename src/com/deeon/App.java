package com.deeon;

import com.deeon.controller.TaskManager;
import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
import com.deeon.model.FileTaskStorage;
import com.deeon.view.ConsoleView;
import com.deeon.view.IView;



public class App {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager(new FileTaskStorage("d:\\storage.dat"));
        try {
            taskManager.createTask("Task1");
            } catch (TaskIsAlreadyExistException e) {
            System.out.println(e);
        }

        try {
            taskManager.deleteTask("Task3");
        } catch (TaskIsNotExistException e) {
            System.out.println(e);
        }

        IView view = new ConsoleView();

        try {
            view.printTasksNames(taskManager.getTasksNames());
        } catch (TaskStorageIsEmptyException e) {
            System.out.println(e);
        }

        taskManager.saveChanges();



    }
}
