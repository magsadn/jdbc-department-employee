create table departments
(
    id    integer not null
        primary key,
    name  varchar(30),
    phone varchar(30)
);

insert into departments values (?,?,?);

select * from departments;

create table employees
(
    id      integer not null
        primary key,
    name    varchar(30),
    surname varchar(30),
    email   varchar(30),
    phone   varchar(30),
    address varchar(30),
    dept_id integer
        constraint emp_dept_id_fk
            references departments
);

insert into employees values (?,?,?,?,?,?);

select * from employees;
