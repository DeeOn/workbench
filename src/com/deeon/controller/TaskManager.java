package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.model.Task;
import com.deeon.model.TaskStorage;

import java.util.Iterator;
import java.util.List;

public class TaskManager {

    private final TaskStorage taskStorage;
    private final List<Task> tasksCollection;

    public TaskManager(final TaskStorage taskStorage) {

        this.taskStorage = taskStorage;
        this.tasksCollection = taskStorage.getTaskCollection();

    }

    public void createTask(final String name) throws TaskIsAlreadyExistException {

//        tasksCollection.forEach (task -> check(name, task.getName()));

        for (Iterator<Task> itr=tasksCollection.iterator(); itr.hasNext();) {

            checkIfTaskNameExists(name, itr.next().getName());
        }

        tasksCollection.add(new Task(name));

    }

    public void deleteTask(final String name) {



    }

    public List<Task> getTasks() {

        return tasksCollection;

    }

    private boolean checkIfTaskNameExists (final String newName, final String taskNameFromCollection) throws TaskIsAlreadyExistException {

        if (newName.equals(taskNameFromCollection)) throw new TaskIsAlreadyExistException();

        return true;
    }

   /* private boolean check (final String newName, final String taskNameFromCollection) {
        try {
            checkIfTaskNameExists(newName, taskNameFromCollection);
        } catch (TaskIsAlreadyExistException e) {
            throw new RuntimeException(e);
        }
        return true;
    }*/
}
