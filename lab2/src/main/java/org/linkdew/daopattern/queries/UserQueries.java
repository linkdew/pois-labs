package org.linkdew.daopattern.queries;

public enum UserQueries {
    ADD("INSERT INTO users VALUES (?, ?, ?, ?, ?) RETURNING user_id"),
    GET("SELECT * FROM users WHERE user_id = ?;"),
    GETALL("SELECT * FROM users;"),
    GETUSERNAME("SELECT * FROM users WHERE username = ?;"),
    UPDATE("UPDATE users SET username = ? WHERE user_id = ? RETURNING user_id"),
    DELETE("DELETE FROM users WHERE user_id = ? RETURNING user_id");

    final String Query;

    public String getQuery() {
        return Query;
    }

    UserQueries(String Query) {
        this.Query = Query;
    }
}
