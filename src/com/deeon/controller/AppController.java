package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
import com.deeon.model.ITaskStorage;
import com.deeon.view.IView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppController {

    private final IView view;
    private final TaskManager taskManager;

    public AppController(IView view, ITaskStorage taskStorage) {

        this.view = view;
        this.taskManager = new TaskManager(taskStorage);

    }


    public void startSession() {

        view.showMenu();
        while(true) {

            switch(userInput()) {
                case 1:
                    try {
                        view.printTasksNames(taskManager.getTasksNames());
                    } catch (final TaskStorageIsEmptyException e) {
                        view.showErrorMessage(e);
                    }
                    view.showMenu();
                    break;

                case 2:
                    try {
                        System.out.println("Enter task name:");
                        final Scanner inputStr = new Scanner(System.in);
                        String str =  inputStr.next();
                        taskManager.createTask(str);
                    } catch (TaskIsAlreadyExistException e) {
                        view.showErrorMessage(e);
                    }
                    view.showMenu();
                    break;
                case 3:
                    try {
                        System.out.println("Enter task name:");
                        final Scanner inputStr = new Scanner(System.in);
                        String str =  inputStr.next();
                        taskManager.deleteTask(str);
                    } catch (TaskIsNotExistException e) {
                        view.showErrorMessage(e);
                    }
                    view.showMenu();
                    break;
                case 4:
                    taskManager.saveChanges();
                    return;


                default:
                    break;

            }
        }
    }

    private int userInput() {

        try {

            final Scanner input = new Scanner(System.in);
            return input.nextInt();

        } catch (InputMismatchException e) {
            return 0;
        }


    }


}
