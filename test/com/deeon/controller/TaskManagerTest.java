package com.deeon.controller;

import com.deeon.exception.TaskIsAlreadyExistException;
import com.deeon.exception.TaskIsNotExistException;
import com.deeon.exception.TaskStorageIsEmptyException;
import com.deeon.model.ArrayTaskStorage;
import com.deeon.model.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TaskManagerTest {


    @Test
    public void createTask() {

        TaskManager taskManager = new TaskManager(new ArrayTaskStorage());

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

        TaskManager taskManager = new TaskManager(new ArrayTaskStorage());

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


    @Test
    public void getTasksNames() {

        String[] expectedList = {"name1", "name2"};

        TaskManager taskManager = new TaskManager(new ArrayTaskStorage(new ArrayList<>(Arrays.asList(new Task("name1"), new Task("name2")))));
        TaskManager taskManagerZero = new TaskManager(new ArrayTaskStorage());

        String[] result = null;

        try {

            result = taskManager.getTasksNames();

        } catch (TaskStorageIsEmptyException e) {
            System.out.println(e);
        }

        assertEquals(expectedList[0], result[0]);
        assertEquals(expectedList[1], result[1]);

        try {

            taskManagerZero.getTasksNames();
            fail("An exception was not thrown");

        } catch (TaskStorageIsEmptyException e) {}













    }
}