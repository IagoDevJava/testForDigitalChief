create table if not exists employees
(
    id   bigint generated by default as identity primary key,
    name varchar(256) not null
);

create table if not exists universities
(
    id          bigint generated by default as identity primary key,
    name        varchar(256) not null,
    rector_id   bigint references employees (id),
    type        varchar      not null,
    work_status varchar
);

create table if not exists faculties
(
    id            bigint generated by default as identity primary key,
    name          varchar(256) not null,
    dean_id       bigint references employees (id),
    work_status   varchar,
    university_id bigint       not null references universities (id)
);