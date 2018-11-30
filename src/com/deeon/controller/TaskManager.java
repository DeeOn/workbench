package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
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

        if (findTask(name, tasksCollection) != null) throw new TaskIsAlreadyExistException();

        tasksCollection.add(new Task(name));

    }


    public void deleteTask(final String name) throws TaskIsNotExistException {

        Task task = findTask(name, tasksCollection);
        if (task == null) throw new TaskIsNotExistException();
        else tasksCollection.remove(task);

    }


    public String[] getTasksNames() throws TaskStorageIsEmptyException {

        if (taskStorage.getSize() == 0) throw new TaskStorageIsEmptyException();
        return tasksCollection.stream().map(Task::getName).toArray(String[]::new);

    }


    private Task findTask(final String name, final List<Task> tasksCollection) {

        Task task = null;

        for (Iterator<Task> itr=tasksCollection.iterator(); itr.hasNext();) {

            task = itr.next();
            if (name.equals(task.getName())) {

                return task;

            }
        }
        return null;

    }
}
