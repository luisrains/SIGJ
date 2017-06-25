package py.com.sigj.rrhh.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.domain.MovimientoExpediente;

public interface MovimientoExpedienteDao extends Dao<MovimientoExpediente> {
	public List<MovimientoExpediente> findExpediente(Long id_expediente);
}
