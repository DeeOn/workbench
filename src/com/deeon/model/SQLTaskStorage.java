package com.deeon.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class SQLTaskStorage implements ITaskStorage {


    private final String getQuery = "SELECT Id, Name FROM Tasks";
    private final String clearTableQuery = "DELETE FROM Tasks";
    private final String updateQuery = "INSERT INTO Tasks (Id, Name) VALUES ('%s', '%s')";

    @Override
    public List<Task> getTaskCollection() {

        try (Connection con = HikariCPDataSource.getConnection();
             Statement stm = con.createStatement()) {

            ResultSet resultSet = stm.executeQuery(getQuery);

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

        try (Connection con = HikariCPDataSource.getConnection();
             Statement stm = con.createStatement()) {

            stm.executeUpdate(clearTableQuery);

            for (Iterator<Task> itr = list.iterator(); itr.hasNext();) {

                doUpdateQuery(stm, itr.next());

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void doUpdateQuery(Statement stm, Task task) throws SQLException {

        stm.executeUpdate(String.format(updateQuery, task.getId().toString(), task.getName()));

    }
}
