package com.deeon.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class SQLTaskStorage implements ITaskStorage {


    private final String instanceName = "192.168.11.11\\sqlserver";
    private final String dbName = "workbench";
    private final String user = "sa";
    private final String pass = "Pp0";
    private final String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
    private final String connectionString = String.format(connectionUrl, instanceName, dbName, user, pass);



    @Override
    public List<Task> getTaskCollection() {

        try {
            Connection con = DriverManager.getConnection(connectionString);
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT Id, Name FROM Tasks");

            List<Task> list = new ArrayList<>();

            while (resultSet.next()) {

                list.add(new Task(UUID.fromString(resultSet.getString("Id")), resultSet.getString("Name")));

            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public void updateStorage(List<Task> list) {

        try {
            Connection con = DriverManager.getConnection(connectionString);
            Statement stm = con.createStatement();

            stm.executeUpdate("DELETE FROM Tasks");

            for (Iterator<Task> itr = list.iterator(); itr.hasNext();) {

                Task currTask = itr.next();
                stm.executeUpdate("INSERT INTO Tasks (Id, Name) values ('"+ currTask.getId().toString() +
                        "', '"+ currTask.getName() + "')");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
