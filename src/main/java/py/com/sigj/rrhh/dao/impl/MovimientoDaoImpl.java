package py.com.sigj.rrhh.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.domain.Movimiento;
import py.com.sigj.rrhh.domain.MovimientoExpediente;

@Repository
@Scope("session")
public class MovimientoDaoImpl extends DaoImpl<Movimiento> implements MovimientoDao {
	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}

	@Override
	public List<MovimientoExpediente> getLitMovimientoExpediente(Long search) {
		Query query = null;
		
			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "MovimientoExpediente");
			
			if (search != null) {
				query = entityManager.createQuery(sql);
			} else {
				sql = sql + " WHERE expediente_id = ?1";
				query = entityManager.createQuery(sql);
				query.setParameter(1,search);
			}
			List<MovimientoExpediente> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	}
}
