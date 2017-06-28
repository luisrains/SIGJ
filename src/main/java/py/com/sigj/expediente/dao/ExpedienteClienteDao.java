package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.ExpedienteCliente;

public interface ExpedienteClienteDao extends Dao<ExpedienteCliente> {
	public List<ExpedienteCliente> findByCliente(String search);
}
