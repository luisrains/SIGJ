package py.com.sigj.expediente.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ExpedienteClienteDao;
import py.com.sigj.expediente.domain.ExpedienteCliente;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ExpedienteClienteDaoImpl extends DaoImpl<ExpedienteCliente> implements ExpedienteClienteDao {

	@Override
	public String getCamposFiltrables() {
		return "";
	}
	
	
	@Override
	public List<ExpedienteCliente> findByCliente(String search) {
		logger.info("Obteniendo lista de ExpedienteCliente, sSearch: {}", search);
		Query query = null;
		
			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "ExpedienteCliente");
			
			if (StringUtils.isBlank(search)) {
				query = entityManager.createQuery(sql);
			} else {
				sql = sql + " WHERE expediente_id = ?1";
				query = entityManager.createQuery(sql);
				query.setParameter(1, Long.parseLong(search));
			}
			List<ExpedienteCliente> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	
	}
}
