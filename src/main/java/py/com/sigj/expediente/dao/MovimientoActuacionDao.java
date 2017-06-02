package py.com.sigj.expediente.dao;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.MovimientoActuacion;

public interface MovimientoActuacionDao extends Dao<MovimientoActuacion> {
	public MovimientoActuacion getListActuacionByExpediente(Long id_expediente);
}
