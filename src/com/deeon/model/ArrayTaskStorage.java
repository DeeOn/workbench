package com.deeon.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayTaskStorage implements ITaskStorage {

    private List<Task> taskCollection;

    public ArrayTaskStorage() {

        this.taskCollection = new ArrayList<>();

    }

    public ArrayTaskStorage(ArrayList<Task> list) {

        this.taskCollection = list;

    }

    @Override
    public List<Task> getTaskCollection() {

        return new ArrayList<>(taskCollection);
    }


    @Override
    public void updateStorage(final List<Task> list) {

        taskCollection = new ArrayList<>(list);
        System.out.println("This storage is temporary!");
    }
}
