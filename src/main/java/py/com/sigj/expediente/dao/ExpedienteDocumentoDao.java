package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.ExpedienteDocumento;
import py.com.sigj.expediente.domain.MovimientoActuacion;

public interface ExpedienteDocumentoDao extends Dao<ExpedienteDocumento> {
	

	public List<ExpedienteDocumento> getListByExpedienteDocumento(String sSearch);
	public List<MovimientoActuacion> getListByExpedienteActuacion(String sSearch);
}
