package py.com.sigj.expediente.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ExpedienteDocumentoDao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.domain.ExpedienteDocumento;
import py.com.sigj.expediente.domain.MovimientoActuacion;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ExpedienteDocumentoDaoImpl extends DaoImpl<ExpedienteDocumento> implements ExpedienteDocumentoDao {

	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}

	@Override
	public List<ExpedienteDocumento> getListByExpediente(String sSearch) {
		logger.info("Obteniendo lista de documentos..");

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE titulo = ?1 order by fechapresentacion asc" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,sSearch);
		}
		List<ExpedienteDocumento> list = query.getResultList();
		logger.info("Documentos encontrados: {}", list);
		return list;
	}
}
