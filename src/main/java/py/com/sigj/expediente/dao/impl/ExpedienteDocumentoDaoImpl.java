package py.com.sigj.expediente.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.DocumentoDao;
import py.com.sigj.expediente.dao.ExpedienteDocumentoDao;
import py.com.sigj.expediente.domain.Documento;
import py.com.sigj.expediente.domain.ExpedienteDocumento;
import py.com.sigj.expediente.domain.MovimientoActuacion;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ExpedienteDocumentoDaoImpl extends DaoImpl<ExpedienteDocumento> implements ExpedienteDocumentoDao {
	@Autowired
	private DocumentoDao documentoDao;
	
	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}

	@Override
	@Transactional
	public List<ExpedienteDocumento> getListByExpedienteDocumento(String sSearch) {
		logger.info("Obteniendo lista de documentos..");

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE expediente_id = ?1 order by fecha_presentacion asc" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,Long.parseLong(sSearch));
		}
		Documento d = documentoDao.find((long)52);
		List<ExpedienteDocumento> list = query.getResultList();
		logger.info("Documentos encontrados: {}", list);
		return list;
	}
	
	
	@Override
	@Transactional
	public List<MovimientoActuacion> getListByExpedienteActuacion(String sSearch) {
		logger.info("Obteniendo lista de actuaciones..");

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", "MovimientoActuacion");
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE expediente_id = ?1 order by fecha_carga asc" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,Long.parseLong(sSearch));
		}
		Documento d = documentoDao.find((long)52);
		List<MovimientoActuacion> list = query.getResultList();
		logger.info("Actuaciones encontradas: {}", list);
		return list;
	}
	

	/**
	 * retornamos las actuaciones de forma descendente
	 */
	@Override
	@Transactional
	public List<MovimientoActuacion> getListByExpedienteActuacionDesc(String sSearch) {
		logger.info("Obteniendo lista de actuaciones..");

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", "MovimientoActuacion");
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE expediente_id = ?1 order by fecha_carga desc" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,Long.parseLong(sSearch));
		}
		Documento d = documentoDao.find((long)52);
		List<MovimientoActuacion> list = query.getResultList();
		logger.info("Actuaciones encontradas: {}", list);
		return list;
	}
	
	/**
	 * retornamos los documentos de forma descendente
	 */
	@Override
	@Transactional
	public List<ExpedienteDocumento> getListByExpedienteDocumentoDesc(String sSearch) {
		logger.info("Obteniendo lista de documentos..");

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE expediente_id = ?1 order by fecha_presentacion desc" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,Long.parseLong(sSearch));
		}
		Documento d = documentoDao.find((long)52);
		List<ExpedienteDocumento> list = query.getResultList();
		logger.info("Documentos encontrados: {}", list);
		return list;
	}
}
