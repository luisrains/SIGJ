﻿insert into rolpermiso values(NEXTVAL('rolpermiso_id_seq'),4,1);
insert into rolpermiso values(NEXTVAL('rolpermiso_id_seq'),5,1);
insert into rolpermiso values(NEXTVAL('rolpermiso_id_seq'),6,1);
insert into rolpermiso values(NEXTVAL('rolpermiso_id_seq'),3051,4);



###Nuevo - solo 10 de los 27
select id from permiso where descripcion like '%ver-%'

INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),301,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),501,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),701,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),901,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),1101,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),1301,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),1501,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),1701,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),1901,(select id from rol where codigo = 'Admin'));
INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),7501,(select id from rol where codigo = 'Admin'));

INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),7701,(select id from rol where codigo = 'Admin'));

INSERT INTO rolpermiso(id, permiso_id, rol_id) 
	VALUES (NEXTVAL('rolpermiso_id_seq'),5601,(select id from rol where codigo = 'Admin'));
