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
		return "codigo";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanillaSalario> lista_planilla(String fecha) {
		String aux1 = null;
		String aux2 = null;
		aux1 = fecha.substring(0, 2);
		aux2 = fecha.substring(3, 7);
		String sql = "SELECT m.fecha FROM movimiento AS m" + " WHERE extract(year from m.fecha) =" + "'" + aux1 + "'"
				+ " AND extract(month from m.fecha)=" + "'" + aux2 + "'";
		Query query = null;
		query = entityManager.createQuery(sql);
		query.setFirstResult(1);
		query.setMaxResults(10);
		List<PlanillaSalario> list = query.getResultList();
		logger.info("Esto es la lista:{}", list);
		return list;
	}
}
