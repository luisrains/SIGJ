package py.com.sigj.expediente.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class PersonaDaoImpl extends DaoImpl<Persona> implements PersonaDao {

	@Override
	public String getCamposFiltrables() {
		return "cedula_ruc||nombre_razonSocial";
	}

	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Persona> listaPersonas(Integer filaInicio, Integer filaFin, String sSearch) {
		logger.info("Obteniendo lista de {}, sSearch: {}",getEntityName(), sSearch);

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			sql = sql + " WHERE lower(disponible)= lower(?1)";
			query = entityManager.createQuery(sql);
			query.setParameter(1,"SI");
		} else {
			sql = sql + " WHERE lower(" + getCamposFiltrables() + ") LIKE lower(?1)";
			query = entityManager.createQuery(sql);
			query.setParameter(1, "%" + sSearch.replace(" ", "%") + "%");
		}
		query.setFirstResult(filaInicio);
		query.setMaxResults(filaFin);
		List<Persona> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	}

}
