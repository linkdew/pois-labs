package org.linkdew.daopattern.queries;

public enum RoleQueries {
    ADD("INSERT INTO roles VALUES (?, ?) RETURNING rolename;"),
    GET("SELECT * FROM roles WHERE user_id = ?;"),
    GETALL("SELECT * FROM roles;"),
    UPDATE("UPDATE roles SET rolename = ? WHERE user_id = ? RETURNING rolename;"),
    DELETE("DELETE FROM roles WHERE user_id = ? RETURNING user_id;");

    final String Query;

    public String getQuery() {
        return Query;
    }

    RoleQueries(String Query) {
        this.Query = Query;
    }
}
