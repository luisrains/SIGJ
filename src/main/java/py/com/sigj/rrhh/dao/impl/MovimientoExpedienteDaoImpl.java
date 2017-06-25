package py.com.sigj.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.MovimientoExpedienteDao;
import py.com.sigj.rrhh.domain.MovimientoExpediente;

@Repository
@Scope("session")
public class MovimientoExpedienteDaoImpl extends DaoImpl<MovimientoExpediente> implements MovimientoExpedienteDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}

	@Override
	public List<MovimientoExpediente> findExpediente(Long id_expediente) {
		List<MovimientoExpediente> me = new ArrayList<>();
		String sql = "SELECT object(MovimientoExpediente) FROM MovimientoExpediente AS MovimientoExpediente WHERE expediente_id=?1";
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
