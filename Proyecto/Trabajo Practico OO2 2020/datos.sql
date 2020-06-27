alter table user change password password longtext;

insert into `user` (id, createdat, enabled, password, updatedat, username) values (1, '2011-12-18 12:31:00' ,true, "$2a$04$UGnCJ6fDWPsuHz.HV.4kG.vVk78C3xfWkEW7BmMMgewMsP.mNdzuS", '2011-12-18 12:31:00' ,"admin");
insert into `user` (id, createdat, enabled, password, updatedat, username) values (2, '2011-12-18 12:31:00' ,true, "$2a$04$byFwva1I3mEGjbYNWNhrK.9XoIeHSK50sqw7mceQr1jPff6yUb02K", '2011-12-18 12:31:00' ,"gerente");
insert into `user` (id, createdat, enabled, password, updatedat, username) values (3, '2011-12-18 12:31:00' ,true, "$2a$04$CV3tr2aBE8Y.zFnpr0n6g.HIBQJ450hlZuo62qSxz2WphM1WsZmB2", '2011-12-18 12:31:00' ,"empleado");

insert into user_role (id, createdat, role, updatedat, user_id) values (1, '2011-12-18 12:31:00' ,'ROLE_ADMIN', '2011-12-18 12:31:00', 1);
insert into user_role (id, createdat, role, updatedat, user_id) values (2, '2011-12-18 12:31:00' ,'ROLE_GERENTE', '2011-12-18 12:31:00', 2);
insert into user_role (id, createdat, role, updatedat, user_id) values (3, '2011-12-18 12:31:00' ,'ROLE_EMPLEADO', '2011-12-18 12:31:00', 3);

insert into `local` (id_local, telefono, direccion, latitud, longitud) values (1, "42461111", "Cangallo 2020", 20.2, 10.4);
insert into `local` (telefono, direccion, latitud, longitud) values ("42462222", "Av. 9 de Julio 5500", 1.3, 2.5);
insert into `local` (telefono, direccion, latitud, longitud) values ("42463333", "Av. Rivadavia 6464", 8.2, 42.3);
insert into `local` (telefono, direccion, latitud, longitud) values ("42464444", "Corvalan 3050", 10.2, 1.2);

insert into `persona` (id_persona, apellido, nombre, dni, fecha_nacimiento) values (1, "Rodriguez", "Javier", 11111111, "2020-06-09");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Alvarez", "Roberto", 22222222, "1969-05-09");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Albertengo", "Lucas", 33333333, "1956-01-09");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Ronaldo", "Cristiano", 44444444, "1988-10-25");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Fernandez", "Manuel", 55555555, "1995-11-09");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Tinelli", "Marcelo", 66666666, "1966-12-09");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Fernandez", "Titi", 77777777, "1980-06-09");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Killian", "MBappe", 88888888, "1996-06-10");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Messi", "Lionel", 99999999, "1966-06-10");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Perez", "Gabriel", 10101010, "1984-06-10");
insert into `persona` (apellido, nombre, dni, fecha_nacimiento) values ("Maidana", "Chino", 12121212, "1935-06-10");

insert into `cliente` (id_persona, email) values (1, "rodriguezjavier@gmail.com");
insert into `cliente` (id_persona, email) values (2, "alvarezroberto@gmail.com");
insert into `cliente` (id_persona, email) values (3, "albertengolucas@gmail.com");

insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (4, 1, 8000, 0, "12:00", "20:00", 1);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (5, 2, 8000, 0, "13:00", "21:00", 1);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (6, 3, 8000, 0, "14:00", "22:00", 1);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (7, 4, 8000, 0, "15:00", "23:00", 1);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (8, 1, 5000, 0, "16:00", "01:00", 0);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (9, 2, 5000, 0, "17:00", "02:00", 0);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (10, 3, 5000, 0, "18:00", "03:00", 0);
insert into `empleado` (id_persona, id_local, sueldo_basico, comision, horario_trabajoe, horario_trabajos, gerente) values (11, 4, 5000, 0, "19:00", "04:00", 0);

insert into `producto` (id_producto, nombre, descripcion, precio_unitario, fecha_alta) values (1, "Zapatillas Adidas", "Running", 8500, "2020-06-10");
insert into `producto` (nombre, descripcion, precio_unitario, fecha_alta) values ("Zapatillas Nike", "Caminar", 5000, "2020-06-10");
insert into `producto` (nombre, descripcion, precio_unitario, fecha_alta) values ("Botines Adidas", "Futsal", 9600, "2020-06-10");
insert into `producto` (nombre, descripcion, precio_unitario, fecha_alta) values ("Botines Puma", "Cancha de 11", 11000, "2020-06-10");
insert into `producto` (nombre, descripcion, precio_unitario, fecha_alta) values ("Ojotas Fila", "Running", 1800, "2020-06-10");
insert into `producto` (nombre, descripcion, precio_unitario, fecha_alta) values ("Camiseta Independiente", "Futbol", 3200, "2020-06-10");

insert into `lote` (id_lote, cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (1, 10000, 10000, "2020-06-10", 1, 1, 1);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 1, 2);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 1, 3);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 1, 4);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 0, 1, 5);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 1, 6);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 2, 1);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 2, 3);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 3, 5);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 3, 1);
insert into `lote` (cantidad_actual, cantidad_ingreso, fecha_ingreso, activo, local_id, producto_id_producto) values (10000, 10000, "2020-06-10", 1, 4, 5);

insert into `pedido` (id_pedido, producto_id_producto, cantidad, precio_total, fecha_pedido, resuelto, local_id_local, empleado_id_persona, cliente_id_persona) values (1, 1, 2, 17000.0, "2020-06-10", 1, 1, 8, 1);

insert into `venta` (id_venta, fecha_venta, id_local, empleado_id_persona, cliente_id_persona, total) values (1, "2020-06-10", 1, 8, 1, 5400.0);

insert into `detalle_venta` (id_detalle_venta, id_venta, fecha_detalle, producto_id_producto, cantidad, precio_sub_total) values (1, 1, "2020-06-10", 5, 3, 1800.0);