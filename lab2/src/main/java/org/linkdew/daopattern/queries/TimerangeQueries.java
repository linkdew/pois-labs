package org.linkdew.daopattern.queries;

public enum TimerangeQueries {
    ADD("INSERT INTO timeranges VALUES (?, ?, ?, ?) RETURNING timerange_id;"),
    GET("SELECT * FROM timeranges WHERE timerange_id = ?;"),
    GETALL("SELECT * FROM timeranges;"),
    GETBYTASK("SELECT * FROM timeranges WHERE task_id = ?;"),
    UPDATE("UPDATE timeranges SET note = ? WHERE timerange_id = ? RETURNING timerange_id;"),
    DELETE("DELETE FROM timeranges WHERE timerange_id = ? RETURNING timerange_id;");

    final String Query;

    public String getQuery() {
        return Query;
    }

    TimerangeQueries(String Query) {
        this.Query = Query;
    }
}
