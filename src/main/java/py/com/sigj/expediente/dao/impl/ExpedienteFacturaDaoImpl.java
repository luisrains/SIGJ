package py.com.sigj.expediente.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ExpedienteFacturaDao;
import py.com.sigj.expediente.domain.ExpedienteFactura;


//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vaaas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ExpedienteFacturaDaoImpl extends DaoImpl<ExpedienteFactura> implements ExpedienteFacturaDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}
	
	
	@Override
	public List<ExpedienteFactura> findFactura(Long id_expediente) {
		List<ExpedienteFactura> me = new ArrayList<>();
		String sql = "SELECT object(ExpedienteFactura) FROM ExpedienteFactura AS ExpedienteFactura WHERE expediente_id=?1";
		Query query = null;
		
		query = entityManager.createQuery(sql);
		query.setParameter(1,id_expediente);
		try{
			me = query.getResultList();
			if(!me.isEmpty()){
				return me;
			}else{
				return me;
			}
		} catch (Exception e) {
			logger.info("No se encontraron actuaciones en el expediente");
			return me;
		}
		
	}
	
}
