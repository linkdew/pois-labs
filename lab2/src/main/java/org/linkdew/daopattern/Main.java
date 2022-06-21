package org.linkdew.daopattern;

import org.linkdew.daopattern.connection.ConnectionPool;
import org.linkdew.daopattern.dao.RoleDAO;
import org.linkdew.daopattern.dao.TaskDAO;
import org.linkdew.daopattern.dao.TimerangeDAO;
import org.linkdew.daopattern.dao.UserDAO;
import org.linkdew.daopattern.entities.Role;
import org.linkdew.daopattern.entities.Task;
import org.linkdew.daopattern.entities.Timerange;
import org.linkdew.daopattern.entities.User;

import java.util.List;

public class Main {
    public static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static void printTasks(List<Task> list){
        for(Task value : list) {
            System.out.println(value.toString());
        }
    }

    public static void printUsers(List<User> list){
        for(User value : list) {
            System.out.println(value.toString());
        }
    }

    public static void printTimeranges(List<Timerange> list){
        for(Timerange value : list) {
            System.out.println(value.toString());
        }
    }

    public static void printRoles(List<Role> list){
        for(Role value : list) {
            System.out.println(value.toString());
        }
    }


    public static void main(String[] args){
        TaskDAO taskDAO = new TaskDAO();
        UserDAO userDAO = new UserDAO();
        RoleDAO roleDAO = new RoleDAO();
        TimerangeDAO timerangeDAO = new TimerangeDAO();

        System.out.println("Task DAO Testing");
        Task task = new Task(4L, "4", "4", "active", 4);
        taskDAO.create(task);
        taskDAO.update(16L, 12, "frozen");
        taskDAO.delete(16L);

        List<Task> tasks = taskDAO.findByStatus("active");
        printTasks((tasks));

        System.out.println(taskDAO.findById(1L));

        System.out.println("User DAO Testing");
        User user = new User(9L, "chope", 3L, "sdgvsadg", "a@2");
        userDAO.create(user);
        userDAO.update(9L, "deep1q");
        userDAO.delete(9L);

        List<User> users = userDAO.findAll();
        printUsers(users);

        System.out.println(userDAO.findById(9L));
        System.out.println(userDAO.findByUsername("stardew"));

        System.out.println("Role DAO Testing");
        Role role = new Role(5L, "superadmin");
        roleDAO.create(role);
        roleDAO.update(1L, "moder");
        roleDAO.delete(5L);

        List<Role> roles = roleDAO.findAll();
        printRoles(roles);

        System.out.println(roleDAO.findById(1L));

        System.out.println("Timerange DAO Testing");
        Timerange timerange = new Timerange(10L, 1L, 405L, "not so bad");
        timerangeDAO.create(timerange);
        timerangeDAO.update(10L, "help");
        timerangeDAO.delete(10L);

        List<Timerange> timeranges = timerangeDAO.findAll();
        printTimeranges(timeranges);

        System.out.println(timerangeDAO.findById(1L));
        System.out.println(timerangeDAO.findByTaskId(1L));

        taskDAO.closeConnection();
        userDAO.closeConnection();
        roleDAO.closeConnection();
        timerangeDAO.closeConnection();

    }
}
