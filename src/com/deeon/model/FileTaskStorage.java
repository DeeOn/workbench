package com.deeon.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTaskStorage implements ITaskStorage {

    private final String filePath;

    public FileTaskStorage(final String path) {

        this.filePath = path;
        if (!checkFile(filePath)) createFile(filePath);

    }

    @Override
    public List<Task> getTaskCollection() {

        return readFile(filePath);

    }


    @Override
    public void updateStorage(final List<Task> list) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {

            output.writeObject(list);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private boolean checkFile(String path){

        return (new File(path)).exists();
    }


    private void createFile(String path) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)){

                output.writeObject(new ArrayList<>());

        } catch (IOException e) {
            System.out.println(e);
        }

    }


    private List<Task> readFile(String path) {


        try (FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream input = new ObjectInputStream(fileInputStream)){

                @SuppressWarnings("unchecked")
                List<Task> list = (List<Task>) input.readObject();
                return list;

        } catch (IOException | ClassNotFoundException e){
            System.out.println(e);
            return null;

        }
    }
}
