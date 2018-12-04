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

            switch(optionInput()) {
                case 1:
                    try {
                        view.printTasksNames(taskManager.getTasksNames());
                    } catch (final TaskStorageIsEmptyException e) {
                        view.showErrorMessage(e);
                    }
                    view.printBlankLine();
                    view.showMenu();
                    break;

                case 2:
                    try {
                        view.printMessage();
                        taskManager.createTask(taskNameInput());
                    } catch (TaskIsAlreadyExistException e) {
                        view.showErrorMessage(e);
                    }
                    view.printBlankLine();
                    view.showMenu();
                    break;
                case 3:
                    try {
                        if (!taskManager.collectionHasElements()) throw new TaskStorageIsEmptyException();
                        view.printMessage();
                        taskManager.deleteTask(taskNameInput());
                    } catch (TaskIsNotExistException | TaskStorageIsEmptyException e) {
                        view.showErrorMessage(e);
                    }
                    view.printBlankLine();
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

    private int optionInput() {

        try {

            final Scanner input = new Scanner(System.in);
            return input.nextInt();

        } catch (InputMismatchException e) {
            return 0;
        }
    }

    private String taskNameInput() {

        return new Scanner(System.in).next();

    }


}
