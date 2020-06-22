create database grupo1bddoo22020;
drop database grupo1bddoo22020;
use grupo1bddoo22020;

select * from pedido;
select * from persona;
select * from cliente;
select * from empleado;
select * from local;
select * from producto;
select * from user;
select * from user_role;

alter table user change password password longtext;

insert into user (enabled, password, username) values (true, "admin", "admin");

insert into user_role (user_id, role) values (1, "administrador");

drop table user_role;
drop table user;


show tables;