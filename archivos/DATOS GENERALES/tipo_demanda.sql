-- CIVIL - TIPO DEMANDA 
--ejecutivo
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Ejecutiva');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Preparatoria de Juicio Ejecutivo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de alquileres');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones administrativas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones dictadas en el extranjero');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones judiciales');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución hipotecaria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución por obligación de dar cosa cierta mueble');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución prendaria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de dar cosa incierta');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(1,(select last_value from tipodemanda_id_seq));


--ESPECIAL
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción puramente declarativa');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Afectación de inmueble como bien de familia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Alimentos y litis expensas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aprobación de cuentas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ausencia con Presunción de fallecimiento');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para apertura de caja de seguridad');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización Judicial para cumplimiento de medida de urgencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para residir fuera del hogar conyugal');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Beneficio de litigar sin gastos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Hipoteca');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación/levantamiento de inscripción');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cesación de la afectación como bien de familia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Convalidación de transferencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Convocatoria de acreedores');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Copia de título');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de Toxicomanía');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desafectación de inmueble como bien de familia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Deslinde');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Diligencias preparatorias');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Disolución de la comunidad conyugal');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Disolución de sociedad comercial');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'División extrajudicial');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Divorcio por mutuo consentimiento');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Exclusión del hogar conyugal');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Expedición de Certificado/documentación ');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Formalización de acto jurídico');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Homologación de acuerdo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de capitulación matrimonial extranjera');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de derecho de usufructo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de fallecimiento');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de ley de expropiación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de matrimonio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de sentencia dictada en el Extranjero');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de título en los Registros Públicos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de unión de hecho');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción preventiva');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Integración de Tribunal Arbitral');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de adquirir');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de obra nueva');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de recobrar');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de retener');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Intervención judicial');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de medida cautelar');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de prenda con registro');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de usufructo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medida de urgencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medida judicial con fines de fiscalización tributaria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Precautorias');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Mensura');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Partición de condominio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prestación de Alimentos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Privación de eficacia jurídica');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Protocolización');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prueba Anticipada');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Quiebra');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación de título');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reinscripción en el Registro del Automotor');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reinscripción en los Registros Públicos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rendición de cuentas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reputación y declaración de sucesión vacante');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Separación de cuerpos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Sucesión Intestada');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Sucesión Testamentaria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Tasación de inmueble');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para ejercer el comercio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para vender');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(2,(select last_value from tipodemanda_id_seq));

--ORDINARIO
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción autónoma de nulidad');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Confesoria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de colación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de convocatoria de asambleas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de impugnación de asambleas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de Indignidad');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de restitución*');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción derivada de la promesa pública de recompensa');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción negatoria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción por uso indebido de nombre');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Posesoria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción redhibitoria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción revocatoria ');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción subrogatoria');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Adquisición por accesión');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Anticipo de herencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aprobación de asamblea');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de deuda');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Hipoteca');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Marca por falta de uso');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cesación de uso de Marca o Repetición de uso e Indemnización por Daños y Perjuicios');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Clausura provisional');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaraníes ordinario');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Compensación de deuda');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de promesa unilateral de pago');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de desconocimiento de deuda');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Derecho de Paso Obligatorio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desafectación de inmueble');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desheredación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Determinación de cantidad no fijada en la obligación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Divorcio a petición de una sóla de las partes');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Enriquecimiento sin causa');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Evicción');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Exclusión de heredero');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de plazo para cumplimiento de obligación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de recompensa e indemnización por hallazgo de cosa perdida');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación judicial de precio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de documentos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de Filiación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación promovida por el hijo o herederos forzosos');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daño moral');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por expropiación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad contractual');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad extracontractual');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización por ejercicio abusivo del derecho');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de usufructo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Libre Acceso a la Información Pública');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación de cláusulas contractuales o dispensa para incumplimiento');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación equitativa de contrato por lesión');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación o cesación de la prestación alimenticia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de acto jurídico');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de inscripción');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Matrimonio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Registro de Dibujos o Modelos Industriales');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Registro de Marcas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad o caducidad de patentes de invención');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad por simulación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer Escritura Pública');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de no hacer');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Pago por Consignación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Petición de Herencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prescripción');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de acto jurídico');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Crédito');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de filiación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de sociedad de hecho');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de unión de hecho');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación de acta en el Registro de Estado Civil de las Personas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación de Instrumento Público');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación adición supresión y otras modificaciones de nombre');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Recuperación de cosa expropiada');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Recuperación de vehículo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reducción');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regulación de honorarios extrajudiciales');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rehabilitación de cuenta');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reivindicación');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de autoridades');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Repetición de pago');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rescisión de contrato');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resolución de contrato');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retención de inmueble');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Revocación de la aceptación de herencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Revocación de la renuncia a la herencia');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Servidumbre de acueducto');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Servidumbre de tránsito');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Usucapión');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(3,(select last_value from tipodemanda_id_seq));

--SUMARIO
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de convocatoria de asambleas');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo con Condena de Futuro');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Insanía');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de nacimiento');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Opcion de Nacionalidad');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Oposición al matrimonio');
INSERT INTO proceso_tipo_demanda(proceso_id,tipodemanda_id) VALUES(4,(select last_value from tipodemanda_id_seq));
