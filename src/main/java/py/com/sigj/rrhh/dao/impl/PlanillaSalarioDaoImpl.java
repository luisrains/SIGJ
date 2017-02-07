package py.com.sigj.rrhh.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	@Override
	public List<Object[]> lista_planilla(String fecha) {
		String aux1 = null;
		String aux2 = null;
		aux1 = fecha.substring(0, 2);
		aux2 = fecha.substring(3, 7);
		String sql1 = "SELECT p.cedula_ruc, p.nombre_razonsocial,p.apellido, SUM(m.egreso) as Egreso,"
				+ " SUM(m.ingreso) as Ingreso, e.salario,"
				+ " (SUM(m.ingreso) - SUM(m.egreso) + e.salario) as TOTALCOBRAR FROM persona p" + " JOIN empleado e"
				+ " ON p.id = e.persona_id" + " JOIN movimiento m" + " ON m.empleado_id = e.id"
				+ " WHERE extract(month from m.fecha)= " + "'" + aux1 + "'" + " AND extract(year from m.fecha)=" + "'"
				+ aux2 + "'" + " GROUP BY p.cedula_ruc,p.nombre_razonsocial,p.apellido,e.salario";
		/*
		 * String sql = "SELECT m.fecha FROM movimiento AS m" +
		 * " WHERE extract(year from m.fecha) =" + "'" + aux1 + "'" +
		 * " AND extract(month from m.fecha)=" + "'" + aux2 + "'";
		 */
		logger.info("Esto es la cagada de consulta:{}", sql1);
		Query query = null;
		query = entityManager.createQuery(sql1);
		query.setFirstResult(1);
		query.setMaxResults(10);
		List<Object[]> list = query.getResultList();
		logger.info("Esto es la lista:{}", list);
		return list;
	}
}
