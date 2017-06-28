package py.com.sigj.rrhh.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.domain.Movimiento;
import py.com.sigj.rrhh.domain.MovimientoExpediente;


public interface MovimientoDao extends Dao<Movimiento> {

	public List<MovimientoExpediente> getLitMovimientoExpediente(Long id_expediente);
}
