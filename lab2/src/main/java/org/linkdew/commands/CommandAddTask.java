package org.linkdew.commands;

import org.linkdew.daopattern.entities.Task;
import org.linkdew.daopattern.entities.User;
import org.linkdew.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandAddTask implements ICommand{
    private static final String ADD_TASK_PAGE = "/addTask.jsp";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskService taskService = new TaskService();
        User user = (User) request.getSession().getAttribute("user");
        if ("GET".equals(request.getMethod())) {
            return ADD_TASK_PAGE ;
        } else {
            String name = request.getParameter("name");
            Long id = user.getUserId();
            String desc = request.getParameter("description");
            String status = request.getParameter("status");
            Integer priority = Integer.valueOf(request.getParameter("priority"));
            Task task = new Task(id, name, desc, status, priority);
            taskService.create(task);
            System.out.println("adding task: " + task.toString());
            return "redirect:/main";
        }
    }
}
