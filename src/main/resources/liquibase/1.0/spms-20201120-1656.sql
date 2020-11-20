create domain email AS varchar(40)
    check (value ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$' );

create table user_roles
(
    user_role_id serial primary key,
    name         varchar(40) not null
);

create table users
(
    user_id      serial primary key,
    username     varchar(40) not null,
    first_name   varchar(20) not null,
    second_name  varchar(20) not null,
    patronymic   varchar(20),
    password     varchar(60),
    email        email,
    user_role_id int,
    constraint FK_Users_UserRoles foreign key (user_role_id) references user_roles (user_role_id)
);

create table projects
(
    project_id  serial primary key,
    name        varchar(60) not null,
    owner_id    int         not null,
    description text,
    constraint FK_Projects_Users foreign key (owner_id) references users (user_id) ON DELETE SET NULL
);

create table project_members
(
    project_id int not null,
    user_id    int not null,
    constraint PK_ProjectMembers primary key (project_id, user_id),
    constraint FK_ProjectMembers_Projects foreign key (project_id) references projects (project_id) on DELETE CASCADE,
    constraint FK_ProjectMembers_Users foreign key (user_id) references users (user_id) on DELETE CASCADE
);

create table task_statuses
(
    task_status_id serial primary key,
    name           varchar(40)
);

create table tasks
(
    task_id     serial primary key,
    project_id  int         not null,
    creator_id  int         not null,
    name        varchar(60) not null,
    description text,
    status_id   int         not null,
    constraint FK_Tasks_Projects foreign key (project_id) references projects (project_id) on DELETE CASCADE,
    constraint FK_Tasks_Users foreign key (creator_id) references users (user_id) ON DELETE SET NULL,
    constraint FK_Tasks_TaskStatuses foreign key (status_id) references task_statuses (task_status_id)
);

create table task_members
(
    task_id        int not null,
    user_id        int not null,
    is_responsible bool,
    constraint PK_TaskMembers primary key (task_id, user_id),
    constraint FK_TaskMembers_Tasks foreign key (task_id) references tasks (task_id) on DELETE CASCADE,
    constraint FK_TaskMembers_Users foreign key (user_id) references users (user_id) on DELETE CASCADE
);

create table task_deadlines
(
    task_deadline_id serial primary key,
    task_id          int       not null,
    time             timestamp not null,
    comment          text,
    constraint FK_TaskDeadlines_Tasks foreign key (task_id) references tasks (task_id) on DELETE CASCADE
);

create table task_comments
(
    task_comment_id serial primary key,
    task_id         int not null,
    user_id         int not null,
    text            text,
    constraint FK_TaskComments_Tasks foreign key (task_id) references tasks (task_id) ON DELETE CASCADE,
    constraint FK_TaskComments_Users foreign key (user_id) references users (user_id) ON DELETE SET NULL
);