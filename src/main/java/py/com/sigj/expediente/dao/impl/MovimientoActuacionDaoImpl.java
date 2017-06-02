package py.com.sigj.expediente.dao.impl;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

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
	public MovimientoActuacion getListActuacionByExpediente(Long id_expediente) {
		logger.info("Obteniendo actuacion del expediente: {}", id_expediente);

		String sql = "SELECT object(MovimientoActuacion) FROM MovimientoActuacion AS MovimientoActuacion";
		Query query = null;
		// Usuario no envió ningún filtro

		if (id_expediente!= null) {
			query = entityManager.createQuery(sql);		
			} else {
			sql = sql + " WHERE expediente_id = ?1" ;
			query = entityManager.createQuery(sql);
			query.setParameter(1,id_expediente);
		}
		MovimientoActuacion actu = (MovimientoActuacion) query.getSingleResult();
		logger.info("Documentos encontrados: {}", actu);
		return actu;
	}
}
