package py.com.sigj.rrhh.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.PlanillaSalarioDao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

@Repository
@Scope("session")
public class PlanillaSalarioDaoImpl extends DaoImpl<PlanillaSalario> implements PlanillaSalarioDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}

	@Override
	public List<PlanillaSalario> buscar(Long id) {

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (id == null) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE planillasueldo_id = ?1)";
			query = entityManager.createQuery(sql);
			query.setParameter(1, id);

		}

		List<PlanillaSalario> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	}

}
