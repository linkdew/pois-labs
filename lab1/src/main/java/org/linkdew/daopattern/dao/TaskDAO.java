package org.linkdew.daopattern.dao;

import org.linkdew.daopattern.entities.Task;
import org.linkdew.daopattern.interfaces.TaskInterface;
import org.linkdew.daopattern.queries.TaskQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.linkdew.daopattern.Main.connectionPool;

public class TaskDAO implements TaskInterface {
    private Connection connection;
    private Statement statement;

    private static final String ID = "task_id";
    private static final String USER_ID = "user_id";
    private static final String NAME = "task_name";
    private static final String DESC = "task_description";
    private static final String STATUS = "status";
    private static final String PRIORITY = "priority";

    public TaskDAO() {
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            System.out.println("connection opened");
        } catch (SQLException e) {
            System.err.println("cannot open connection");
        }
    }

    private Task getTask(ResultSet resultSet) throws SQLException{
        Long taskId = resultSet.getLong(ID);
        Long userId = resultSet.getLong(USER_ID);
        String taskName = resultSet.getString(NAME);
        String taskDescription = resultSet.getString(DESC);
        String status = resultSet.getString(STATUS);
        Integer priority = resultSet.getInt(PRIORITY);

        return new Task(taskId, userId, taskName, taskDescription, status, priority);
    }

    public Task findById(Long id) {
        Task task = null;
        try (PreparedStatement statement = connection.prepareStatement(TaskQueries.GET.getQuery())) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                task = getTask(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(TaskQueries.GETALL.getQuery());
            while (resultSet.next()) {
                Task task = getTask(resultSet);
                tasks.add(task);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> findByStatus(String status){
        List<Task> tasks = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(TaskQueries.GETSTATUS.getQuery())) {
            statement.setString(1, status);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = getTask(resultSet);
                tasks.add(task);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void create(Task task) {
        try (PreparedStatement statement = connection.prepareStatement(TaskQueries.ADD.getQuery())) {
            statement.setLong(1, task.getTaskId());
            statement.setLong(2, task.getUserId());
            statement.setString(3, task.getTaskName());
            statement.setString(4, task.getTaskDescription());
            statement.setString(5, task.getStatus());
            statement.setInt(6, task.getPriority());
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("creation failed");
            e.printStackTrace();
        }
    }

    public void update(Long id, Integer priority) {
        try (PreparedStatement statement = connection.prepareStatement(TaskQueries.UPDATE.getQuery())) {
            statement.setInt(1, priority);
            statement.setLong(2, id);
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(TaskQueries.DELETE.getQuery())) {
            statement.setLong(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            statement.close();
            connection.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            System.err.println("cannot close connection");
        }
    }
}
