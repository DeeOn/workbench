package com.deeon.view;


import com.deeon.model.Menu;

public class ConsoleView implements IView {


    @Override
    public void showMenu() {

        System.out.println("Please select an option:");
        for (String item: Menu.getMenuItems()) {
            System.out.println(item);
        }
    }

    @Override
    public void printTasksNames(String[] names) {

        System.out.println("Tasks: ");

        for (String name: names) {
            System.out.println(name);
        }
    }

    @Override
    public void showErrorMessage(Exception e) {
        switch(e.getClass().getName()) {
            case "com.deeon.exception.TaskStorageIsEmptyException":
                System.out.println("No task is available");
                break;
            case "com.deeon.exception.TaskIsAlreadyExistException":
                System.out.println("Task is already exist");
                break;
            case "com.deeon.exception.TaskIsNotExistException":
                System.out.println("Task is not exist");
                break;
            default:
                System.out.println(e);
        }
    }

    @Override
    public void clear() {


    }

}
