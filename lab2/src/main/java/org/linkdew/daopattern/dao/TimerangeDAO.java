package org.linkdew.daopattern.dao;

import org.linkdew.daopattern.entities.Timerange;
import org.linkdew.daopattern.interfaces.TimerangeInterface;
import org.linkdew.daopattern.queries.TimerangeQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.linkdew.daopattern.Main.connectionPool;

public class TimerangeDAO implements TimerangeInterface {
    private Connection connection;
    private Statement statement;
    private static final String ID = "timerange_id";
    private static final String TASK = "task_id";
    private static final String TIME = "timetaken";
    private static final String NOTE = "note";

    public TimerangeDAO() {
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            System.out.println("connection opened");
        } catch (SQLException e) {
            System.err.println("cannot open connection");
        }
    }

    private Timerange getTimerange(ResultSet resultSet) throws SQLException{
        Long timerange_id = resultSet.getLong(ID);
        Long task_id = resultSet.getLong(TASK);
        Long timetaken = resultSet.getLong(TIME);
        String note = resultSet.getString(NOTE);

        return new Timerange(timerange_id, task_id, timetaken, note);
    }

    public Timerange findById(Long id) {
        Timerange timerange = null;
        try (PreparedStatement statement = connection.prepareStatement(TimerangeQueries.GET.getQuery())) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                timerange = getTimerange(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timerange;
    }

    public List<Timerange> findAll() {
        List<Timerange> timeranges = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(TimerangeQueries.GETALL.getQuery());
            while (resultSet.next()) {
                Timerange timerange = getTimerange(resultSet);
                timeranges.add(timerange);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeranges;
    }

    public Timerange findByTaskId(Long id){
        Timerange timerange = null;
        try (PreparedStatement statement = connection.prepareStatement(TimerangeQueries.GETBYTASK.getQuery())) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                timerange = getTimerange(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timerange;
    }

    public void create(Timerange timerange) {
        try (PreparedStatement statement = connection.prepareStatement(TimerangeQueries.ADD.getQuery())) {
            statement.setLong(1, timerange.getTimerangeId());
            statement.setLong(2, timerange.getTaskId());
            statement.setLong(3, timerange.getTimetaken());
            statement.setString(4, timerange.getNote());
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("creation failed");
            e.printStackTrace();
        }
    }

    public void update(Long id, String note) {
        try (PreparedStatement statement = connection.prepareStatement(TimerangeQueries.UPDATE.getQuery())) {
            statement.setString(1, note);
            statement.setLong(2, id);
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(TimerangeQueries.DELETE.getQuery())) {
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
