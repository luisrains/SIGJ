package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.domain.Abogado;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class AbogadoDaoImpl extends DaoImpl<Abogado> implements AbogadoDao {

	@Override
	public String getCamposFiltrables() {
		return "empleado.persona.cedula_ruc||empleado.persona.nombre_razonSocial||empleado.persona.apellido";
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	@Transactional
//	public List<Abogado> getList(Integer filaInicio, Integer filaFin, String sSearch) {
//		logger.info("Obteniendo lista de personas, sSearch: {}", sSearch);
//
//		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
//		sql = sql.replace("#ENTITY#", getEntityName());
//		Query query = null;
//		// Usuario no envió ningún filtro
//
//		if (StringUtils.isBlank(sSearch)) {
//			query = entityManager.createQuery(sql);
//		} else {
//			sql = sql + " WHERE lower(" + getCamposFiltrables() + ") LIKE lower(?1) AND empleado_id != 1";
//			query = entityManager.createQuery(sql);
//			query.setParameter(1, "%" + sSearch.replace(" ", "%") + "%");
//		}
//		query.setFirstResult(filaInicio);
//		query.setMaxResults(filaFin);
//		List<Abogado> list = query.getResultList();
//		logger.info("Cantidad de registros encontrados: {}", list);
//		return list;
//	}
}
