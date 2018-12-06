package com.deeon.model;

public class Menu {

    private static final String[] MENU_ITEMS = new String[]{"1. Show tasks", "2. Add task", "3. Delete task", "4. Save and Exit", "5. Exit without saving"};

    public static String[] getMenuItems() {

        return MENU_ITEMS;

    }
}
