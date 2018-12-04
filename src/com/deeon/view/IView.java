package com.deeon.view;

import com.deeon.model.Menu;

public interface IView {

    void showMenu();

    void printTasksNames(final String[] names);

    void showErrorMessage(Exception e);

    void clear();

}
