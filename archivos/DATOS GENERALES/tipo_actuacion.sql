--Tipo Actuacion
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'PROV' ,'Providencia', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'AI' ,'Auto Interlocutorio', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'SENT' ,'Sentencia', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'NOTF' ,'Notificación', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'AVIS' ,'Aviso', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'PREP' ,'Presentación de las Partes', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'URGI' ,'Urgimiento', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'MAND' ,'Mandamiento Judicial', 3);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'OFIC' ,'Oficio', 0);
INSERT INTO tipo_actuacion(id, abreviatura, descripcion, plazo)
    VALUES (NEXTVAL('tipoactuacion_id_seq'),'INFO' ,'Informe', 1);



--Tipo Documento
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'COMP', 'Comprobante de Pago');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'ESCR', 'Escrito');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'PODR', 'Poder');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'FOTC', 'Fotocopia de Cédula');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'INST', 'Instrumental');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'ESCD', 'Escrito de Demanda');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'DOCV', 'Documentos Varios');
INSERT INTO tipo_documento(id, codigo, descripcion)
    VALUES (NEXTVAL('tipo_documento_id_seq'), 'CARA', 'Carátula');

--Estado Interno
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'INIC','Iniciado','I');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'CULM','Culminado','I');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'PROC','En Proceso','I');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'NOTI','A Notificar','I');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'ACON','A Contestar','I');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'AFIN','A Finiquitar','I');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'OTRI','Otro no contemplano','I');
--Estado Externo
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'INIE','Iniciado','E');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'ENDE','En Despacho','E');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'AUTP','Autos para Resolver','E');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'ENES','En Estadística','E');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'ENCO','En contaduría','E');
INSERT INTO estado_externo_interno(id, codigo, descripcion, tipoestado)
    VALUES (NEXTVAL('estadoexternointernointerno_id_seq'), 'OTRE','Otro no contemplano','E');
