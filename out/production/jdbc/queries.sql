select * from employees;

insert into employees values (1,'Anar','Xocayev','anarx@gmail.com','+994556112116','Xirdalan',2);

delete from employees where id=7;

update employees set name=?,surname=?,email=?,phone=?,address=?,dept_id=? where id=?;

update employees set id = 11 where id = 10;
