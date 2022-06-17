package org.linkdew.daopattern.dao;

import org.linkdew.daopattern.entities.User;
import org.linkdew.daopattern.interfaces.UserInterface;
import org.linkdew.daopattern.queries.UserQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.linkdew.daopattern.Main.connectionPool;

public class UserDAO implements UserInterface {
    private Connection connection;
    private Statement statement;
    private static final String ID = "user_id";
    private static final String USERNAME = "username";
    private static final String ROLE = "role_id";
    private static final String PASS = "password";
    private static final String EMAIL = "email";

    public UserDAO() {
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            System.out.println("connection opened");
        } catch (SQLException e) {
            System.err.println("cannot open connection");
        }
    }

    private User getUser(ResultSet resultSet) throws SQLException{
        Long userId = resultSet.getLong(ID);
        String username = resultSet.getString(USERNAME);
        Long roleId = resultSet.getLong(ROLE);
        String password = resultSet.getString(PASS);
        String email = resultSet.getString(EMAIL);

        return new User(userId, username, roleId, password, email);
    }

    public User findById(Long id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(UserQueries.GET.getQuery())) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(UserQueries.GETALL.getQuery());
            while (resultSet.next()) {
                User user = getUser(resultSet);
                users.add(user);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findByUsername(String username){
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(UserQueries.GETUSERNAME.getQuery())) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void create(User user) {
        try (PreparedStatement statement = connection.prepareStatement(UserQueries.ADD.getQuery())) {
            statement.setLong(1, user.getUserId());
            statement.setString(2, user.getUsername());
            statement.setLong(3, user.getRoleId());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmail());
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("creation failed");
            e.printStackTrace();
        }
    }

    public void update(Long id, String username) {
        try (PreparedStatement statement = connection.prepareStatement(UserQueries.UPDATE.getQuery())) {
            statement.setString(1, username);
            statement.setLong(2, id);
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(UserQueries.DELETE.getQuery())) {
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
