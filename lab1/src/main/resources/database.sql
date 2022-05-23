drop table if exists tasks cascade;
drop table if exists users cascade;
drop table if exists roles cascade;
drop table if exists timeranges cascade;

CREATE TABLE users (
    user_id BIGINT PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    email VARCHAR NOT NULL
);

CREATE TABLE roles (
    user_id BIGINT PRIMARY KEY,
    rolename VARCHAR NOT NULL,
    CONSTRAINT role_constraint
        FOREIGN KEY (user_id)
            REFERENCES users (user_id)
);

CREATE TABLE tasks (
    task_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    task_name VARCHAR NOT NULL,
    task_description TEXT,
    status VARCHAR NOT NULL,
    priority SMALLINT NOT NULL,
    CONSTRAINT user_constraint
        FOREIGN KEY (user_id)
            REFERENCES users (user_id)
);

CREATE TABLE timeranges (
    timerange_id BIGINT NOT NULL PRIMARY KEY,
    task_id BIGINT NOT NULL,
    timetaken BIGINT NOT NULL,
    note TEXT,
    CONSTRAINT task_constraint
        FOREIGN KEY (task_id)
            REFERENCES tasks (task_id)
                        ON DELETE CASCADE
);

INSERT INTO users VALUES (1, 'loverboy', '43rfdsf23', 'loverboy@loverboy');
INSERT INTO users VALUES (2, 'sweety', 'r32fsdaf32', 'sweety@sweety');
INSERT INTO users VALUES (3, 'stardew', 'r23fsdfa', 'stardew@stardew');
INSERT INTO users VALUES (4, 'normalizedmemory', '214edsf', 'normalizedmemory@normalizedmemory');
-- INSERT INTO users VALUES (5, 'starcatcher');
-- INSERT INTO users VALUES (6, 'poison');


INSERT INTO roles VALUES (1, 'admin');
INSERT INTO roles VALUES (2, 'user');
INSERT INTO roles VALUES (3, 'admin');
INSERT INTO roles VALUES (4, 'moder');
-- INSERT INTO roles VALUES (5, 'moder');
-- INSERT INTO roles VALUES (6, 'user');

INSERT INTO tasks VALUES (1, 1, 'helping', '...', 'active', 1);
INSERT INTO tasks VALUES (2, 2, 'helping 2', '...', 'active', 2);
INSERT INTO tasks VALUES (3, 2, 'helping 3', '...', 'active', 3);
INSERT INTO tasks VALUES (4, 1, 'helping 4', '...', 'active', 5);

INSERT INTO timeranges VALUES (1, 1, 1243, 'good one');
INSERT INTO timeranges VALUES (2, 1, 41324, 'bad one');
INSERT INTO timeranges VALUES (3, 2, 4134);

CREATE OR REPLACE VIEW tasks_and_roles AS
    SELECT t.task_name, u.username, r.rolename
    FROM tasks t JOIN users u ON t.user_id = u.user_id
    LEFT JOIN roles r on t.user_id = r.user_id;

SELECT * FROM tasks WHERE task_id = 2;