--Primer paso creacion de Roles
insert into rol values(NEXTVAL('rol_id_seq'),'ABG','Abogado');
insert into rol values(NEXTVAL('rol_id_seq'),'GES','Gestor');
insert into rol values(NEXTVAL('rol_id_seq'),'DES','Desarrollador');
insert into rol values(NEXTVAL('rol_id_seq'),'ADM','Administrador'); 

--Segundo Paso creacion de permisos

﻿insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-mat','Agregar Materia');
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-mat','Modificar Materia'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-mat','Eliminar Materia'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-mat','Ver Materias'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-usu','Agregar Usuario'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-usu','Modificar Usuario'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-usu','Eliminar Usuario'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-usu','Ver Usuarios'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-pro','Agregar Proceso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-pro','Modificar Proceso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-pro','Eliminar Proceso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-pro','Ver Procesos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-exp','Agregar Expediente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-exp','Modificar Expediente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-exp','Eliminar Expediente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-exp','Ver Expedientes'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-abg','Agregar Abogado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-abg','Modificar Abogado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-abg','Eliminar Abogado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-abg','Ver Abogados'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-cli','Agregar Cliente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-cli','Modificar Cliente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-cli','Eliminar Cliente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-cli','Ver Clientes'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-act','Agregar Actuacion'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-act','Modificar Actuacion'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-act','Eliminar Actuacion'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-act','Ver Actuaciones'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-des','Agregar Despacho'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-des','Modificar Despacho'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-des','Eliminar Despacho'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-des','Ver Despachos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-doc','Agregar Documento'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-doc','Modificar Documento'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-doc','Eliminar Documento'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-doc','Ver Documentos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-estEx','Agregar EstadoExpediente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-estEx','Modificar EstadoExpediente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-estEx','Eliminar EstadoExpediente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-estEx','Ver EstadoExpedientes'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-estExtInt','Agregar EstadoExternoInterno'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-estExtInt','Modificar EstadoExternoInterno'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-estExtInt','Eliminar EstadoExternoInterno'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-estExtInt','Ver EstadoExternoInternos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-per','Agregar Persona'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-per','Modificar Persona'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-per','Eliminar Persona'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-per','Ver Personas'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-tipAbg','Agregar Tipo Abogado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-tipAbg','Modificar Tipo Abogado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-tipAbg','Eliminar Tipo Abogado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-tipAbg','Ver Tipo Abogados'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-tipAct','Agregar Tipo Actuacion'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-tipAct','Modificar Tipo Actuacion'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-tipAct','Eliminar Tipo Actuacion'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-tipAct','Ver Tipo Actuaciones'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-tipCli','Agregar Tipo Cliente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-tipCli','Modificar Tipo Cliente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-tipCli','Eliminar Tipo Cliente'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-tipCli','Ver Tipo Clientes'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-tipDem','Agregar Tipo Demanda'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-tipDem','Modificar Tipo Demanda'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-tipDem','Eliminar Tipo Demanda'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-tipDem','Eliminar Tipo Demandas'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-tomo','Agregar Tomo'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-tomo','Modificar Tomo'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-tomo','Eliminar Tomo'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-tomo','Eliminar Tomos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-caja','Agregar Caja'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-caja','Modificar Caja'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-caja','Eliminar Caja'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-caja','Ver Cajas'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-factura','Agregar Factura'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-factura','Modificar Factura'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-factura','Eliminar Factura'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-factura','Ver Facturas'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-ingEgre','Agregar IngresoEgreso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-ingEgre','Modificar IngresoEgreso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-ingEgre','Eliminar IngresoEgreso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-ingEgre','Eliminar IngresoEgresos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-servicio','Agregar Servicio'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-servicio','Modificar Servicio'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-servicio','Eliminar Servicio'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-servicio','Ver Servicios'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-tipoIngEgre','Agregar TipoIngresoEgreso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-tipoIngEgre','Modificar TipoIngresoEgreso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-tipoIngEgre','Eliminar TipoIngresoEgreso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-tipoIngEgre','Ver TipoIngresoEgresos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-empleado','Agregar Empleado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-empleado','Modificar Empleado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-empleado','Eliminar Empleado'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-empleado','Ver Empleados'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-movimiento','Agregar Movimiento'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-movimiento','Modificar Movimiento'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-movimiento','Eliminar Movimiento'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-movimiento','Ver Movimientos'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-planilla','Agregar PlanillaSalario'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-planilla','Modificar PlanillaSalario'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-planilla','Eliminar PlanillaSalario'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-planilla','Ver PlanillaSalarios'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'completo','Permiso Completo'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-permiso','Agregar Permiso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-permiso','Modificar Permiso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-permiso','Eliminar Permiso'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-permiso','Ver Permisos'); 
 
insert into permiso values(NEXTVAL('permiso_id_seq'),'agr-rol','Agregar Rol'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'mod-rol','Modificar Rol'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'eli-rol','Eliminar Rol'); 
insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-rol','Ver Roles'); 

insert into permiso values(NEXTVAL('permiso_id_seq'),'ver-inicio','Ver el Inicio');

-- Tercer Paso asociar los roles con los permisos





