package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
import com.deeon.model.ITaskStorage;
import com.deeon.model.Task;
import java.util.List;

public class TaskManager {

    private final ITaskStorage taskStorage;
    private final List<Task> tasksCollection;

    public TaskManager(final ITaskStorage taskStorage) {

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

        if (!collectionHasElements()) throw new TaskStorageIsEmptyException();
        return tasksCollection.stream().map(Task::getName).toArray(String[]::new);

    }

    public void saveChanges() {

        taskStorage.updateStorage(tasksCollection);
    }

    public boolean collectionHasElements() {

        return tasksCollection.size() != 0;

    }


    private Task findTask(final String name, final List<Task> tasksCollection) {

        for (Task task: tasksCollection) {
            if (name.equals(task.getName()))
                return task;
        }
        return null;
    }



}
