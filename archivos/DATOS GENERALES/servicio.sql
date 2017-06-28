INSERT INTO servicio(id, codigo, costo, tiposervicio)
    VALUES (NEXTVAL('servicio_id_seq'), 'ASE', 700000, 'Asesoramiento');

INSERT INTO servicio(id, codigo, costo, tiposervicio)
    VALUES (NEXTVAL('servicio_id_seq'), 'HONP', 50000, 'Honorarios Profesionales');

INSERT INTO servicio(id, codigo, costo, tiposervicio)
    VALUES (NEXTVAL('servicio_id_seq'), 'ASAU', 500000, 'Asistencia en Audiencias');

INSERT INTO servicio(id, codigo, costo, tiposervicio)
    VALUES (NEXTVAL('servicio_id_seq'), 'CON', 350000, 'Consultas Evacuadas');
