INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (1, 'ficticio', '111111', '','NO',1,'','', 'ficticio', '', '', 'F');
INSERT INTO empleado(id, fechaingreso, salario, persona_id)
    VALUES (1, '01-01-2017', 0, 1);
--clientes
INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Rains Schmidt', '2594340', 'ildarains@gmial.com','SI',40,'SOLTERO','22-01-1977', 'Hilda Inés', 'F', '0981647902', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Demestri Burian', '1753218', '--','SI',40,'SOLTERO','22-02-1977', 'Andrés Luis', 'M', '0981576488', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Troche Navaez', '2391155', '--','SI',36,'SOLTERO','22-05-1981', 'Christian D.', 'M', '0982536482', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Osorio Nunes', '1730753', '--','SI',35,'SOLTERO','22-04-1982', 'Wilson R.', 'M', '0983535485', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Barrios Almada', '4852698', '--','SI',23,'SOLTERO','30-01-1994', 'Cecilia Belén', 'F', '0982265987', 'F');

--abogados / empleados
INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Méndez González', '1150391', 'c-mendez62@hotmail.com','SI',51,'CASADO','12-08-1966', 'Carlos A.', 'M', '0981576488', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Rains', '1899699', 'rodolforains@hotmail.com','SI',37,'CASADO','09-12-1980', 'Rodolfo', 'M', '0981964832', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Hospital', '2698695', 'drhospital@hotmail.com','SI',52,'CASADO','23-03-1965', 'Juan', 'M', '0985867966', 'F');

INSERT INTO persona(id, apellido, cedula_ruc, correoelectronico, disponible, edad,estadocivil, fechanacimiento, nombre_razonsocial, sexo, telefono, tipopersona)
    VALUES (NEXTVAL('persona_id_seq'), 'Figari', '369269', '--','SI',54,'CASADO','15-06-1963', 'Pedro', 'M', '0986958741', 'F');


--Usuario Prueba
INSERT INTO usuario(id, apellido, cedularuc, nombrerazonsocial, password, rol_id)
    VALUES (NEXTVAL('usuario_id_seq'), 'Méndez', '1150391', 'Carlos', md5('cmendez'), (select id from rol where codigo = 'ADM'));

INSERT INTO usuario(id, apellido, cedularuc, nombrerazonsocial, password, rol_id)
    VALUES (NEXTVAL('usuario_id_seq'), 'prueba', '123456', 'Prueba', md5('123456'), (select id from rol where codigo = 'ADM'));


