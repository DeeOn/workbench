package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.model.TaskStorage;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskManagerTest {


    @Test
    public void createTask() {

        TaskManager taskManager = new TaskManager(new TaskStorage());

        final String firstName = "name1";
        final String secondName = "name2";

        try {
            taskManager.createTask(firstName);
        } catch (TaskIsAlreadyExistException e){ fail("unknown");}

        try {
            taskManager.createTask(secondName);
        } catch (TaskIsAlreadyExistException e){fail("unknown");}

        try {
            taskManager.createTask(firstName);
            fail("An exception was not thrown");
        } catch (TaskIsAlreadyExistException e){}
    }

    @Test
    public void deleteTask() {

        TaskManager taskManager = new TaskManager(new TaskStorage());

        final String name = "name1";

        try {
            taskManager.createTask(name);
        } catch (TaskIsAlreadyExistException e){fail("unknown");}

        try {
            taskManager.deleteTask(name);
        } catch (TaskIsNotExistException e){fail("unknown");}

        try {
            taskManager.deleteTask(name);
            fail("An exception was not thrown");
        } catch (TaskIsNotExistException e){}
    }
}