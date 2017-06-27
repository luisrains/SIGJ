package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.ExpedienteFactura;


public interface ExpedienteFacturaDao extends Dao<ExpedienteFactura> {

	public List<ExpedienteFactura> findFactura(Long id_expediente);
}
