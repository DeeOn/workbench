package com.deeon.model;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    private final List<Task> taskCollection;

    public TaskStorage() {

        this.taskCollection = new ArrayList<>();

    }

    public List<Task> getTaskCollection() {

        return taskCollection;
    }

    public int getSize() {

        return taskCollection.size();

    }
}
