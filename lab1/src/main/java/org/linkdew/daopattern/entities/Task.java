package org.linkdew.daopattern.entities;

public class Task {
    private Long taskId;
    private Long userId;
    private String taskName;
    private String taskDescription;
    private String status;
    private Integer priority;

    public Task(Long taskId, Long userId, String taskName, String taskDescription, String status, Integer priority) {
        this.taskId = taskId;
        this.userId = userId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Task id: " + taskId.toString() +
                "\tUser id: " + userId.toString() +
                "\tTask Name: " + taskName +
                "\tDesc: " + taskDescription +
                "\tStatus: " + status +
                "\tPriority: " + priority.toString();
    }

    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

