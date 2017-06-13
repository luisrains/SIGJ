package py.com.sigj.expediente.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.domain.Abogado;
import py.com.sigj.expediente.domain.Cliente;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.ExpedienteAbogado;
import py.com.sigj.expediente.domain.ExpedienteCliente;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ExpedienteDaoImpl extends DaoImpl<Expediente> implements ExpedienteDao {

	@Override
	public String getCamposFiltrables() {
		return "caratula||nroExpediente||anho||moneda||estado.descripcion";
	}
	
	@Override
	public List<ExpedienteCliente> getListByCedulaRucCliente(String cedula){
		String sql = "SELECT object(ExpedienteCliente) FROM ExpedienteCliente AS ExpedienteCliente WHERE cliente_id = " 
		        + "(SELECT id FROM Cliente WHERE persona_id = (SELECT id FROM Persona WHERE cedula_ruc = ?1) )";
		
		
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (cedula!= null) {
			query = entityManager.createQuery(sql);
			query.setParameter(1,cedula);
		}
		List<ExpedienteCliente> list = query.getResultList();
		logger.info("Expedientes del cliente encontrado: {}", list);
		 return list;
	}
	
	@Override
	public List<ExpedienteAbogado> getListByCedulaRuc(String cedula) {
		logger.info("Obteniendo lista de expedientes..");

		String sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id = "
				+ "(SELECT id FROM Abogado WHERE empleado_id = (SELECT id FROM Empleado WHERE persona_id = (SELECT id FROM Persona WHERE cedula_ruc= ?1)))"; 
//		INNER JOIN ExpedienteCliente WHERE id = expediente_id";
//				+ " WHERE ExpedienteCliente.cliente_id = ?1";
//				+ "ON e.id = ec.expediente_id JOIN Cliente AS c "
//				+ "ON c.id = ec.cliente_id JOIN Persona AS p "
//				+ "ON p.id = c.persona_id";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (cedula!= null) {
			query = entityManager.createQuery(sql);
			query.setParameter(1,cedula);		
			} else {
			sql = sql + " WHERE ec.abogado_id = ?1" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,(long)2);
		}
		List<ExpedienteAbogado> list = query.getResultList();
		logger.info("Documentos encontrados: {}", list);
		return list;
	}

	@Override
	public List<Expediente> filtro(String nroExpediente, String abogado, String despacho, String estado, String anho) {

		boolean band_exp = false;
		boolean band_abg = false;
		boolean band_est = false;
		boolean band_anho = false;
		boolean band_desp = false;
		String sql = "";
		Query query = null;
		List<Expediente> list = new  ArrayList<Expediente>();
		List<ExpedienteAbogado> list2 = new  ArrayList<ExpedienteAbogado>();
		if(nroExpediente != null && !nroExpediente.equalsIgnoreCase("")){
			if(!band_exp){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE nroexpediente = ?1";
				band_exp = true;
			}else{
				sql = "AND nroexpediente= ?1";
			}
			
		}
		if(abogado != null && !abogado.equalsIgnoreCase("") && !abogado.equalsIgnoreCase("0")){
			if(!band_exp){
				sql = sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)";
				band_abg = true;
			}else{
				sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)"
						+ " AND expediente_id=(SELECT id FROM Expediente WHERE nroexpediente=?1)";
				band_abg = true;
				band_exp = true;
			}
			
		}
		
		
		
		if(estado != null && !estado.equalsIgnoreCase("") && !estado.equalsIgnoreCase("0")){
			if(!band_exp && !band_abg){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE estado_id = ?4";
				band_est = true;
			}
			else if(!band_exp && band_abg){
				sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)"
						+ " AND expediente_id=(SELECT id FROM Expediente WHERE estado_id=?4)";
				band_abg = true;
				band_est = true;
			}
			else if(band_exp && !band_abg){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE nroexpediente = ?1 AND estado_id = ?4";
				band_exp = true;
				band_est = true;
			}else{
				sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)"
						+ " AND expediente_id=(SELECT id FROM Expediente WHERE nroexpediente = ?1 AND estado_id= ?4)";
				band_exp = true;
				band_est = true;
				band_abg = true;
			}
		}
		if(anho != null && ! anho.equalsIgnoreCase("")){
			if(!band_exp && !band_abg && !band_est){
				sql =  "SELECT object(Expediente) FROM Expediente AS Expediente WHERE anho = ?5";
				band_anho = true;
			}
			else if(!band_exp && !band_abg && band_est){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE estado_id = ?4 AND anho = ?5";
				band_anho = true;
				band_est = true;
			}
			else if(!band_exp && band_abg && band_est){
				sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)"
						+ " AND expediente_id=(SELECT id FROM Expediente WHERE anho = ?5 AND estado_id= ?4)";
				band_abg = true;
				band_anho = true;
				band_est = true;
			}
			else if(band_exp && band_abg && band_est){
				sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)"
						+ " AND expediente_id=(SELECT id FROM Expediente WHERE nroexpediente = ?1 AND anho = ?5 AND estado_id= ?4)";
				band_abg = true;
				band_anho = true;
				band_est = true;
				band_exp = true;
			}
		}
		if(despacho != null && !despacho.equalsIgnoreCase("") && !despacho.equalsIgnoreCase("0")){
			if(!band_exp && !band_abg && !band_est && !band_anho){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE despachoactual_id = ?3";
				band_desp = true;
			}
			else if(!band_exp && !band_abg && !band_est && band_anho){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE despachoactual_id = ?3 AND anho = ?5";
				band_desp = true;
				band_anho = true;
			}
			else if(!band_exp && !band_abg && band_est && band_anho){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE despachoactual_id = ?3 AND anho = ?5 AND estado_id= ?4";
				band_est = true;
				band_anho = true;
				band_desp = true;
			}
			else if(band_exp && !band_abg && band_est && band_anho){
				sql = "SELECT object(Expediente) FROM Expediente AS Expediente WHERE nroexpediente= ?1 AND despachoactual_id = ?3 AND anho = ?5 AND estado_id= ?4";
				band_est = true;
				band_exp = true;
				band_desp = true;
				band_anho = true;
			}
			else if(band_exp && band_abg && band_est && band_anho){
				sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE abogado_id= (SELECT id FROM Abogado WHERE id =?2)"
						+ " AND expediente_id=(SELECT id FROM Expediente WHERE nroexpediente = ?1 AND anho = ?5 AND estado_id= ?4 AND despachoactual_id = ?3)";
				band_est = true;
				band_exp = true;
				band_desp = true;
				band_anho = true;
				band_abg = true;
			}
		}
		
		query = entityManager.createQuery(sql);
		if(nroExpediente != null && !nroExpediente.equalsIgnoreCase("")){
			query.setParameter(1,nroExpediente);
		}
		if(abogado != null && !abogado.equalsIgnoreCase("") && !abogado.equalsIgnoreCase("0")){
			query.setParameter(2,Long.parseLong(abogado));
		}
		if(despacho != null && !despacho.equalsIgnoreCase("") && !despacho.equalsIgnoreCase("0")){
			query.setParameter(3,Long.parseLong(despacho));
		}
		if(estado != null && !estado.equalsIgnoreCase("") && !estado.equalsIgnoreCase("0")){
			query.setParameter(4,Long.parseLong(estado));
		}
		if(anho != null && ! anho.equalsIgnoreCase("")){
			query.setParameter(5,anho);
		}
		
		
		String nombreClase =  getEntityName();
		logger.info(nombreClase);
		list = query.getResultList();
		if(list == null){
			for(int i=0;i< list2.size();i++){
				list.add(list2.get(i).getExpediente());
			}
		}
		return list;
	}

	@Override
	public List<ExpedienteCliente> getListByExpedienteId(String id_expediente) {
		
		String sql = "SELECT object(ExpedienteCliente) FROM ExpedienteCliente AS ExpedienteCliente WHERE expediente_id = ?1"; 

		Query query = null;
		// Usuario no envió ningún filtro

		if (id_expediente != null) {
			query = entityManager.createQuery(sql);
			query.setParameter(1,Long.parseLong(id_expediente));		
			
		}
		List<ExpedienteCliente> list = query.getResultList();
		logger.info("Documentos encontrados: {}", list);
		return list;
	}

	@Override
	public List<Cliente> buscarParteCliente(String search) {
		logger.info("Obteniendo lista de clientes, sSearch: {}", search);
		Query query = null;
		
			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "Cliente");
			
			if (StringUtils.isBlank(search)) {
				query = entityManager.createQuery(sql);
			} else {
				sql = sql + " WHERE lower(persona.cedula_ruc||persona.nombre_razonSocial||persona.apellido) LIKE lower(?1)";
				query = entityManager.createQuery(sql);
				query.setParameter(1, "%" + search.replace(" ", "%") + "%");
			}
			List<Cliente> list = (List<Cliente>) query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	
	}
	
	@Override
	public List<Abogado> buscarParteAbogado(String search) {
		logger.info("Obteniendo lista de Abogadosp, sSearch: {}", search);
		Query query = null;
		
			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "Abogado");
			
			if (StringUtils.isBlank(search)) {
				query = entityManager.createQuery(sql);
			} else {
				sql = sql + " WHERE lower(empleado.persona.cedula_ruc||empleado.persona.nombre_razonSocial||empleado.persona.apellido) LIKE lower(?1)";
				query = entityManager.createQuery(sql);
				query.setParameter(1, "%" + search.replace(" ", "%") + "%");
			}
			List<Abogado> list = (List<Abogado>) query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	
	}
	
	
	@Override
	public List<ExpedienteAbogado> getListByExpedienteIdAb(String id_expediente) {
		String sql = "SELECT object(ExpedienteAbogado) FROM ExpedienteAbogado AS ExpedienteAbogado WHERE expediente_id = ?1"; 

		Query query = null;
		// Usuario no envió ningún filtro

		if (id_expediente != null) {
			query = entityManager.createQuery(sql);
			query.setParameter(1,Long.parseLong(id_expediente));		
			
		}
		List<ExpedienteAbogado> list = query.getResultList();
		logger.info("Documentos encontrados: {}", list);
		return list;
	
	}

}
