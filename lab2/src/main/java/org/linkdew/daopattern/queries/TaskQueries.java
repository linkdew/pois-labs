package org.linkdew.daopattern.queries;

public enum TaskQueries {
    ADD("INSERT INTO tasks (user_id, task_name, task_description, status, priority) VALUES (?, ?, ?, ?, ?) RETURNING task_id;"),
    GET("SELECT * FROM tasks WHERE task_id = ?;"),
    GETALL("SELECT * FROM tasks;"),
    GETSTATUS("SELECT * FROM tasks WHERE status = ?;"),
    UPDATE("UPDATE tasks SET priority = ?, status = ? WHERE task_id = ? RETURNING task_id;"),
    DELETE("DELETE FROM tasks WHERE task_id = ? RETURNING task_id;");

    final String Query;

    public String getQuery() {
        return Query;
    }

    TaskQueries(String Query) {
        this.Query = Query;
    }

}
