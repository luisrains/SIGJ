
﻿-- MATERIA CIVIL COMERCIAL - EJECUTIVO

INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'CIV','CIVIL COMERCIAL');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'EJC','EJECUTIVO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Ejecutiva');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Preparatoria de Juicio Ejecutivo');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de alquileres');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones administrativas');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones dictadas en el extranjero');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones judiciales');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución hipotecaria');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución por obligación de dar cosa cierta mueble');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución prendaria');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de dar cosa incierta');
INSERT INTO proceso_tipo_demanda values (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));

-- MATERIA CIVIL COMERCIAL - ESPECIAL
<<<<<<< Temporary merge branch 1

=======
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'CIV','CIVIL COMERCIAL');
>>>>>>> Temporary merge branch 2
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'ESC','ESPECIAL');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción puramente declarativa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Afectación de inmueble como bien de familia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Alimentos y litis expensas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aprobación de cuentas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ausencia con Prensunción de fallecimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para apertura de caja de seguridad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para cumplimiento de medida de urgencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para residir fuera del hogar conyugal');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Beneficio de litigar sin gastos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de hipoteca');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación/levantamiento de inscripción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cesación de la afectación como bien de la familia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Convalidación de transferencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Convocatoria de acreedores');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Copia de titulos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de Toxicomanía');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desafectación de inmueble como bien de la familia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Deslinde');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Diligencias preparatorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Disolución de la comunidad conyugal');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Disolución de la sociedad comercial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Divorcio por mutuo consentimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Exclusión del hogar conyugal');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Expedición de certificado/documentación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Formalización de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Homologación de acuerdo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de capitulación matrimonial extranjera');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de derecho de usufructo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de fallecimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de ley de expropiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de sentencia dictada en el extranjero');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de título en los Registros Públicos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de unión de hecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción preventiva');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Integración de Tribunal Arbitral');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de adquirir');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de obra nueva');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de recobrar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Interdicto de retener');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Intervención judicial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de medida cautelar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de prenda con registro');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de usufructo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medida de urgencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medida judicial con fines de fiscalización tributaria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Precautorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Mensura');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Partición de condominio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prestación de Alimentos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Privación de eficacia jurídica');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Protocolización');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prueba Anticipada');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Quiebra');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación de título');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reinscripción en el Registro del Automotor');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reinscripción en los Registros Públicos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rendición de cuentas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reputación y declaración de sucesión vacante');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Separación de cuerpos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Sucesión Intestada');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Sucesión Testamentaria');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Tasación de inmueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para ejercer el comercio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para vender');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Tasación de inmueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para ejercer el comercio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para vender');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


-- MATERIA CIVIL COMERCIAL - ORDINARIO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'CIV','CIVIL COMERCIAL');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'ORC','ORDINARIO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción autónoma de nulidad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Confesoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de convocatoria de asambleas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de impugnación de asambleas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de Indignidad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de restitución');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción derivada de la promesa pública de recompensa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción negatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción por uso indebido de nombre');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Posesoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción redhibitoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción revocatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción subrogatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Adquisición por accesión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Anticipo de herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aprobación de asamblea');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Hipoteca');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Marca por falta de uso');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cesación de uso de Marca o Repetición de uso e Indemnización por Daños y Perjuicios');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Clausura provisional');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaraníes ordinario');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Compensación de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de promesa unilateral de pago');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de desconocimiento de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Derecho de Paso Obligatorio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desafectación de inmueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desheredación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Determinación de cantidad no fijada en la obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Divorcio a petición de una sóla de las partes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Enriquecimiento sin causa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Evicción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Exclusión de heredero');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de plazo para cumplimiento de obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de recompensa e indemnización por hallazgo de cosa perdida');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación judicial de precio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));	
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de documentos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));	
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de Filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación promovida por el hijo o herederos forzosos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daño moral');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por expropiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad contractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad extracontractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización por ejercicio abusivo del derecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de usufructo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Libre Acceso a la Información Pública');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación de cláusulas contractuales o dispensa para incumplimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación equitativa de contrato por lesión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación o cesación de la prestación alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de inscripción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Registro de Dibujos o Modelos Industriales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Registro de Marcas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad o caducidad de patentes de invención');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad por simulación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer Escritura Pública');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de no hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Pago por Consignación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Petición de Herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prescripción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Crédito');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de sociedad de hecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de unión de hecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación de acta en el Registro de Estado Civil de las Personas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación, adición, supresión y otras modificaciones de nombre');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Recuperación de cosa expropiada');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Recuperación de vehículo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reducción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regulación de honorarios extrajudiciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rehabilitación de cuenta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reivindicación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de autoridades');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Repetición de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rescisión de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resolución de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retención de inmueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Revocación de la aceptación de herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Revocación de la renuncia a la herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Servidumbre de acueducto');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Servidumbre de tránsito');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Usucapión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de desconocimiento de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Derecho de Paso Obligatorio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desafectación de inmueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desheredación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Determinación de cantidad no fijada en la obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Divorcio a petición de una sóla de las partes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Enriquecimiento sin causa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Evicción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Exclusión de heredero');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de plazo para cumplimiento de obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de recompensa e indemnización por hallazgo de cosa perdida');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación judicial de precio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))	
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de documentos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))	
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de Filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación promovida por el hijo o herederos forzosos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daño moral');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por expropiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad contractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad extracontractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización por ejercicio abusivo del derecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de usufructo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Libre Acceso a la Información Pública');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación de cláusulas contractuales o dispensa para incumplimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación equitativa de contrato por lesión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación o cesación de la prestación alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de inscripción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Registro de Dibujos o Modelos Industriales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de Registro de Marcas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad o caducidad de patentes de invención');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad por simulación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer Escritura Pública');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de no hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Pago por Consignación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Petición de Herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prescripción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Crédito');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de sociedad de hecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de unión de hecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación de acta en el Registro de Estado Civil de las Personas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rectificación, adición, supresión y otras modificaciones de nombre');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Recuperación de cosa expropiada');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Recuperación de vehículo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reducción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regulación de honorarios extrajudiciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rehabilitación de cuenta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reivindicación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de autoridades');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Repetición de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rescisión de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resolución de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retención de inmueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Revocación de la aceptación de herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Revocación de la renuncia a la herencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Servidumbre de acueducto');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Servidumbre de tránsito');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Usucapión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA CIVIL COMERCIAL - SUMARIO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'CIV','CIVIL COMERCIAL');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'SUC','SUMARIO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción de convocatoria de asambleas');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo con Condena de Futuro');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Insanía');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de nacimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Opcion de Nacionalidad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Oposición al matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo con Condena de Futuro');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Insanía');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción de nacimiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Opcion de Nacionalidad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Oposición al matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA JUSTCIA LETRADA - EJECUTIVO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'JUS','JUSTICIA LETRADA');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'EJJ','EJECUTIVO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Ejecutiva');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Preparatoria de Juicio Ejecutivo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de alquileres');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Diligencias preparatorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones administrativas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones dictadas en el extranjero');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones judiciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución hipotecaria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución prendaria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Preparatoria de Juicio Ejecutivo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de alquileres');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Diligencias preparatorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones administrativas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones dictadas en el extranjero');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones judiciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución hipotecaria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución prendaria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA JUSTCIA LETRADA - ORDINARIO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'JUS','JUSTICIA LETRADA');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'ORJ','ORDINARIO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción autónoma de nulidad');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Confesoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción negatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción redhibitoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción subrogatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aprobación de cuentas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaraníes ordinario');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Compensación de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de promesa unilateral de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de desconocimiento de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Determinación de cantidad no fijada en la obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución por obligación de dar cosa cierta mueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Enriquecimiento sin causa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Evicción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de plazo para cumplimiento de obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de recompensa e indemnización por hallazgo de cosa perdida');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación judicial de precio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daño moral');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad contractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad extracontractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización por ejercicio abusivo del derecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de medida cautelar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Precautorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación equitativa de contrato por lesión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad por simulación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de dar cosa incierta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer Escritura Pública');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de no hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Pago por Consignación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Promesa unilateral de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prueba Anticipada');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Crédito');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rendición de cuentas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Repetición de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resarcimiento por responsabilidad derivada de la gestión de negocios ajenos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rescisión de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resolución de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retención de inmueble por cobro de mejoras');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción Confesoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción negatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción redhibitoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción subrogatoria');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aprobación de cuentas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaraníes ordinario');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Compensación de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de promesa unilateral de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración de desconocimiento de deuda');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Determinación de cantidad no fijada en la obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución por obligación de dar cosa cierta mueble');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Enriquecimiento sin causa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Evicción');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de plazo para cumplimiento de obligación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación de recompensa e indemnización por hallazgo de cosa perdida');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Fijación judicial de precio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daño moral');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad contractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización de daños y perjuicios por responsabilidad extracontractual');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Indemnización por ejercicio abusivo del derecho');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Levantamiento de medida cautelar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Precautorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Modificación equitativa de contrato por lesión');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad de acto jurídico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad por simulación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de dar cosa incierta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de hacer Escritura Pública');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Obligación de no hacer');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Pago por Consignación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Promesa unilateral de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Prueba Anticipada');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Crédito');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rendición de cuentas');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Repetición de pago');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resarcimiento por responsabilidad derivada de la gestión de negocios ajenos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rescisión de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resolución de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retención de inmueble por cobro de mejoras');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA JUSTCIA LETRADA - SUMARIO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'JUS','JUSTICIA LETRADA');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'EJJ','SUMARIO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Beneficio de litigar sin gastos');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo con Condena de Futuro');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Información sumaria de testigos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Precautorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Privación de eficacia jurídica');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));	
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desalojo con Condena de Futuro');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Información sumaria de testigos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Precautorias');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Privación de eficacia jurídica');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))	
>>>>>>> Temporary merge branch 2


--MATERIA LABORAL - EJECUTIVO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'LAB','LABORAL');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'EJL','EJECUTIVO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de Sentencia de resoluciones judiciales');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Documentos privados de deudor o causante, reconocido o declarado');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Instrumento público presentados en forma de acuerdo con las solemnidades prescriptas en la ley');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Confesión judicial expresa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cuentas aprobadas o reconocidas judicilamente y las cuentas simples de gestión que contengan la conformidad del deudor');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaranies en diversos conceptos-juicio ejecutivo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Documentos privados de deudor o causante, reconocido o declarado');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Instrumento público presentados en forma de acuerdo con las solemnidades prescriptas en la ley');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Confesión judicial expresa');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cuentas aprobadas o reconocidas judicilamente y las cuentas simples de gestión que contengan la conformidad del deudor');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaranies en diversos conceptos-juicio ejecutivo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA LABORAL - ESPECIAL
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'LAB','LABORAL');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'ESL','ESPECIAL');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Beneficio de litigar sin gastos');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Homologación de acuerdo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Calificación de Huelga');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Cautelares');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Oficio Comisivo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Comunicacion de la huelga');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Homologación de acuerdo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Calificación de Huelga');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Cautelares');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Oficio Comisivo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Comunicacion de la huelga');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2

--MATERIA LABORAL - ORDINARIO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'LAB','LABORAL');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'ORJ','ORDINARIO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Pago por Consignación');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción autónoma de nulidad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Transferencia de Pase/Liberación de Pase y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retiro Justificado y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reposición Sindical y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reintegro al trabajo y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Antiguedad y otros derechos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad del despido de mujeres embarazadas y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Justificación de causal de despido y suspensión de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Despido injustificado y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaranies en diversos conceptos juicio ordinario');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Personeria Gremial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Justificación de causal de despido');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Acción autónoma de nulidad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cumplimiento de contrato y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Transferencia de Pase/Liberación de Pase y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Retiro Justificado y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reposición Sindical y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reintegro al trabajo y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de Antiguedad y otros derechos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Nulidad del despido de mujeres embarazadas y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Justificación de causal de despido y suspensión de contrato');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Despido injustificado y cobro de guaranies');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cobro de guaranies en diversos conceptos juicio ordinario');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cancelación de Personeria Gremial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Justificación de causal de despido');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA NIÑEZ Y ADOLESCENCIA - ESPECIAL
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'NIÑ','NIÑEZ');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'ESN','ESPECIAL');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Adopción');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Asistencia alimenticia de parientes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Asistencia alimenticia pre-natal');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aumento de la asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autor. jud. para hacer transacciones o compromisos sobre los derechos del niño o adolesc.');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autor. jud. para todo acto o contrato que tengan interés parientes o socios comerciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización jud.para tomar en arrendamiento bienes raíces que no fuese la casa habitación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial cuando existe disentimiento de los padres para viajar al exterior');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para cambio de familia sustituta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para comprar  inmuebles y otros objetos de  alto valor económico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para constituir derechos reales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para constituir derechos reales sobre los bienes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para contraer matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para el abrigo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para enajenar bienes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para enajenar bienes que tengan en condominio con sus hijos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para intervención quirúrgica ante el peligro de muerte');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para pagar deudas que no sean las ordinarias de la administración');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para remitir créditos a favor del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para transferir derechos que tengan sus hijos sobre bienes de otros');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para ubicación del niño o adolescente en un hogar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para ubicación del niño o adolescente en una familia sustituta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para viajar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización juducial para hacer prestamos a nombre del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización para partición de bienes inmuebles');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización para partición de bienes muebles');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización para partición de condominio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorizacón judicial para enajenar bienes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Busqueda y localización del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cesación de la asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Conclusión de Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Confirmación de la tutela dada por los padres');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración judicial de conclusión de Tutela especial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desconocimiento de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Designación de la familia sustituta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Discernimiento de la Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Disminución de la asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones judiciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Guarda del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Homologación de acuerdo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción Judicial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Maltrato del niño o adolescente (Ley 4295/11)');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medida Judicial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Cautelares');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas de Protección');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ofrecimiento de la prestación alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Patria Potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Perdida de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regimen de convivencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regimen de relacionamiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de la administración de los bienes del hijo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de la Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rendición judicial de cuentas de la tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resarcimiento del perjuicio en la tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Suspensión de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para el servicio militar obligatorio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Asistencia alimenticia de parientes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Asistencia alimenticia pre-natal');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Aumento de la asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autor. jud. para hacer transacciones o compromisos sobre los derechos del niño o adolesc.');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autor. jud. para todo acto o contrato que tengan interés parientes o socios comerciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización jud.para tomar en arrendamiento bienes raíces que no fuese la casa habitación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial cuando existe disentimiento de los padres para viajar al exterior');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para cambio de familia sustituta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para comprar  inmuebles y otros objetos de  alto valor económico');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para constituir derechos reales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para constituir derechos reales sobre los bienes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para contraer matrimonio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para el abrigo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para enajenar bienes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para enajenar bienes que tengan en condominio con sus hijos');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para intervención quirúrgica ante el peligro de muerte');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para pagar deudas que no sean las ordinarias de la administración');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para remitir créditos a favor del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para transferir derechos que tengan sus hijos sobre bienes de otros');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para ubicación del niño o adolescente en un hogar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para ubicación del niño o adolescente en una familia sustituta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización judicial para viajar');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización juducial para hacer prestamos a nombre del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización para partición de bienes inmuebles');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización para partición de bienes muebles');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorización para partición de condominio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Autorizacón judicial para enajenar bienes');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Busqueda y localización del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Cesación de la asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Conclusión de Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Confirmación de la tutela dada por los padres');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Declaración judicial de conclusión de Tutela especial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Desconocimiento de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Designación de la familia sustituta');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Discernimiento de la Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Disminución de la asistencia alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ejecución de resoluciones judiciales');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Guarda del niño o adolescente');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Homologación de acuerdo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Impugnación de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Inscripción Judicial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Maltrato del niño o adolescente (Ley 4295/11)');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medida Judicial');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas Cautelares');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Medidas de Protección');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Ofrecimiento de la prestación alimenticia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Patria Potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Perdida de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Reconocimiento de filiación');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regimen de convivencia');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Regimen de relacionamiento');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de la administración de los bienes del hijo');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Remoción de la Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Rendición judicial de cuentas de la tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Resarcimiento del perjuicio en la tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Suspensión de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Tutela');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Venia para el servicio militar obligatorio');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2


--MATERIA NIÑEZ Y ADOLESCENCIA - GENERAL
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'NIÑ','NIÑEZ');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'GEN','GENERAL');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2

--MATERIA NIÑEZ Y ADOLESCENCIA - SUMARIO
INSERT INTO materia(id,codigo,descripcion) VALUES(NEXTVAL('materia_id_seq'),'NIÑ','NIÑEZ');
INSERT INTO proceso(id,codigo,descripcion) VALUES(NEXTVAL('proceso_id_seq'),'SUN','SUMARIO');
INSERT INTO materia_proceso(materia_id, proceso_id) VALUES (currval('materia_id_seq'),currval('proceso_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Beneficio para litigar sin gastos');
<<<<<<< Temporary merge branch 1
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'));
=======
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
INSERT INTO tipo_demanda(id,descripcion) VALUES(NEXTVAL('tipodemanda_id_seq'),'Restitución de la patria potestad');
INSERT INTO proceso_tipo_demanda VALUES (currval('proceso_id_seq'),currval('tipodemanda_id_seq'))
>>>>>>> Temporary merge branch 2

