package org.linkdew.services;

import org.linkdew.daopattern.dao.TaskDAO;
import org.linkdew.daopattern.entities.Task;
import java.util.List;

public class TaskService {
    public List<Task> fetchTasksByUserId(Long userId) {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.findAll();
        taskDAO.closeConnection();

        return tasks.stream().filter(task -> task.getUserId() == userId).toList();
    }
    public Task findById(Long id) {
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.findById(id);
        taskDAO.closeConnection();

        return task;
    }

    public void create(Task task){
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.create(task);
        taskDAO.closeConnection();
    }

    public void update(Long id, Integer priority, String status){
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.update(id, priority, status);
        taskDAO.closeConnection();
    }

    public void delete(Long id){
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.delete(id);
        taskDAO.closeConnection();
    }
}
