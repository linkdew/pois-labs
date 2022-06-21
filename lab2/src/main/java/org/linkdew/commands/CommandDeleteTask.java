package org.linkdew.commands;

import org.linkdew.daopattern.entities.Task;
import org.linkdew.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandDeleteTask implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskService taskService = new TaskService();
        Long taskId = Long.valueOf(request.getParameter("taskId"));
        taskService.delete(taskId);
        return "redirect:/main";
    }
}
