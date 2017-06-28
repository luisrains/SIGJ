package py.com.sigj.rrhh.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.domain.Empleado;

@Repository
@Scope("session")
public class EmpleadoDaoImpl extends DaoImpl<Empleado> implements EmpleadoDao {

	@Override
	public String getCamposFiltrables() {
		return "persona.cedula_ruc||persona.nombre_razonSocial||persona.apellido";
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Empleado> getList(Integer filaInicio, Integer filaFin, String sSearch) {
		logger.info("Obteniendo lista de personas, sSearch: {}", sSearch);

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			sql = sql + " WHERE persona_id != 1";
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE lower(" + getCamposFiltrables() + ") LIKE lower(?1) AND id != 1";
			query = entityManager.createQuery(sql);
			query.setParameter(1, "%" + sSearch.replace(" ", "%") + "%");
		}
		query.setFirstResult(filaInicio);
		query.setMaxResults(filaFin);
		List<Empleado> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	}

}
