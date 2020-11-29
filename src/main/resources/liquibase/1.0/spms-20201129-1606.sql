-- переименовываем таблицу user_roles
ALTER TABLE user_roles
    RENAME TO global_roles;

ALTER TABLE global_roles
    RENAME COLUMN user_role_id TO global_role_id;



ALTER TABLE users
    DROP CONSTRAINT FK_Users_UserRoles;

ALTER TABLE users
    DROP COLUMN user_role_id;



create table users_global_roles
(
    user_id        int not null,
    global_role_id int not null,
    constraint PK_UsersGlobalRoles primary key (user_id, global_role_id),
    constraint PK_UsersGlobalRoles_Users foreign key (user_id) references users (user_id) ON DELETE CASCADE,
    constraint PK_UsersGlobalRoles_GlobalRoles foreign key (global_role_id) references global_roles (global_role_id) ON DELETE NO ACTION
);