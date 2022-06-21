package org.linkdew.commands;

import org.linkdew.daopattern.entities.Task;
import org.linkdew.daopattern.entities.User;
import org.linkdew.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CommandMain implements ICommand {
    private final static String MAIN_PAGE = "/main.jsp";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Task> tasks = new TaskService().fetchTasksByUserId(user.getUserId());

        request.setAttribute("tasks", tasks);
        return MAIN_PAGE;
    }
}
