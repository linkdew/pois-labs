package org.linkdew.daopattern.dao;

import org.linkdew.daopattern.entities.Role;
import org.linkdew.daopattern.interfaces.RoleInterface;
import org.linkdew.daopattern.queries.RoleQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.linkdew.daopattern.Main.connectionPool;

public class RoleDAO implements RoleInterface {
    private Connection connection;
    private Statement statement;
    private static final String ID = "role_id";
    private static final String ROLE = "rolename";

    public RoleDAO() {
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            System.out.println("connection opened");
        } catch (SQLException e) {
            System.err.println("cannot open connection");
        }
    }

    private Role getRole(ResultSet resultSet) throws SQLException{
        Long roleId = resultSet.getLong(ID);
        String rolename = resultSet.getString(ROLE);

        return new Role(roleId, rolename);
    }

    public Role findById(Long id) {
        Role role = null;
        try (PreparedStatement statement = connection.prepareStatement(RoleQueries.GET.getQuery())) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = getRole(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(RoleQueries.GETALL.getQuery());
            while (resultSet.next()) {
                Role role = getRole(resultSet);
                roles.add(role);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public void create(Role role) {
        try (PreparedStatement statement = connection.prepareStatement(RoleQueries.ADD.getQuery())) {
            statement.setLong(1, role.getRoleId());
            statement.setString(2, role.getRolename());
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("creation failed");
            e.printStackTrace();
        }
    }

    public void update(Long id, String rolename) {
        try (PreparedStatement statement = connection.prepareStatement(RoleQueries.UPDATE.getQuery())) {
            statement.setString(1, rolename);
            statement.setLong(2, id);
            statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(RoleQueries.DELETE.getQuery())) {
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
