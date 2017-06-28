package py.com.sigj.expediente.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.EstadoExternoInternoDao;
import py.com.sigj.expediente.domain.EstadoExternoInterno;

@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class EstadoExternoInternoDaoImpl extends DaoImpl<EstadoExternoInterno> implements EstadoExternoInternoDao {

	@Override
	public String getCamposFiltrables() {

		return "codigo||descripcion||tipoEstado";
	}

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EstadoExternoInterno> getListAllExternoInterno(String sSearch) {
		logger.info("Obteniendo lista de {}, sSearch: {}",getEntityName(), sSearch);

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE tipoestado = ?1";
			query = entityManager.createQuery(sql);
			query.setParameter(1, sSearch);
		}
		List<EstadoExternoInterno> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	}
	
	
	
}
