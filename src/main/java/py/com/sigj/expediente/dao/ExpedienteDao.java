package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.ExpedienteCliente;

public interface ExpedienteDao extends Dao<Expediente> {

	public List<ExpedienteCliente> getListByCedulaRuc(String cedula);
}
