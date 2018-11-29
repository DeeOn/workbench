package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.model.TaskStorage;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskManagerTest {

    TaskManager taskManager = new TaskManager(new TaskStorage());

    @Test
    public void createTask() {

        try {
            taskManager.createTask("name1");
        } catch (TaskIsAlreadyExistException e){ fail("unknown");}

        try {
            taskManager.createTask("name2");
        } catch (TaskIsAlreadyExistException e){fail("unknown");}

        try {
            taskManager.createTask("name1");
            fail("An exception was not thrown");
        } catch (TaskIsAlreadyExistException e){}
    }
}