package org.linkdew.commands;

import com.sun.source.util.TaskListener;
import org.linkdew.daopattern.entities.Task;
import org.linkdew.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandEditTask implements ICommand{
    private final static String EDIT_TASK_PAGE = "/editTask.jsp";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskService taskService = new TaskService();
        Long taskId = Long.valueOf(request.getParameter("taskId"));
        Task task = taskService.findById(taskId);
        if ("GET".equals(request.getMethod())) {
            request.setAttribute("task", task);
            return EDIT_TASK_PAGE ;
        } else {
            Integer newPriority = Integer.valueOf(request.getParameter("newPriority"));
            String newStatus = request.getParameter("newStatus");
            taskService.update(taskId, newPriority, newStatus);
            return "redirect:/main" ;
        }
    }
}
