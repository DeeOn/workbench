package com.deeon.view;

public class ConsoleView implements IView {

    @Override
    public void printTasksNames(String[] names) {

        for (String name: names) {
            System.out.println(name);
        }
    }

}
