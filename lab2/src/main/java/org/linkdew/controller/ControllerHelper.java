package org.linkdew.controller;

import org.linkdew.commands.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<>();

    private ControllerHelper() {
        commands.put("/login", new CommandLogin());
        commands.put("/main", new CommandMain());
        commands.put("/editTask", new CommandEditTask());
        commands.put("/deleteTask", new CommandDeleteTask());
        commands.put("/addTask", new CommandAddTask());
        commands.put("/logout", new CommandLogout());
    }
    public ICommand getCommand(HttpServletRequest request) {
        return commands.get(request.getRequestURI());
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }

        return instance;
    }
}
