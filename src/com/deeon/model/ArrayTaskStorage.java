package com.deeon.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayTaskStorage implements ITaskStorage {

    private List<Task> taskCollection;

    public ArrayTaskStorage() {

        this.taskCollection = new ArrayList<>();

    }

    @Override
    public List<Task> getTaskCollection() {

        return taskCollection;
    }

    @Override
    public int getSize() {

        return taskCollection.size();

    }

    @Override
    public void updateStorage(List<Task> list) {

        taskCollection = list;

    }
}
