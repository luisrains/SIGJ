package py.com.sigj.expediente.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.domain.MovimientoActuacion;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class MovimientoActuacionDaoImpl extends DaoImpl<MovimientoActuacion> implements MovimientoActuacionDao {

	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}

	@Override
	@Transactional
	public List<MovimientoActuacion> getListActuacionByExpediente(Long id_expediente) {

		List<MovimientoActuacion> actu = null;
		String sql = "SELECT object(MovimientoActuacion) FROM MovimientoActuacion AS MovimientoActuacion WHERE expediente_id = ?1 ORDER BY fecha_carga DESC";
		Query query = null;
		// Usuario no envió ningún filtro

		
			query = entityManager.createQuery(sql);
			query.setParameter(1,id_expediente);
		
		try {
			actu = query.getResultList();
			if(!actu.isEmpty()){
				return actu;
			}else{
				return actu;
			}
		} catch (Exception e) {
			logger.info("No se encontraron actuaciones en el expediente");
			return null;
		}
	}
	
	@Override
	@Transactional
	public MovimientoActuacion getActuacionByExpediente(Long id_expediente) {

		List<MovimientoActuacion> actuList= null;
		String sql = "SELECT object(MovimientoActuacion) FROM MovimientoActuacion AS MovimientoActuacion WHERE expediente_id = ?1 ORDER BY fecha_carga DESC";
		Query query = null;
		// Usuario no envió ningún filtro
			query = entityManager.createQuery(sql);
			query.setParameter(1,id_expediente);
		
		try {
			actuList = query.getResultList();
			if(!actuList.isEmpty()){
				return actuList.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.info("No se encontraron actuaciones en el expediente");
			return null;
		}
		
		
	}

	
}
