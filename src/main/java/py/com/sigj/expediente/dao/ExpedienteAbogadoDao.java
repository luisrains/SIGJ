package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.ExpedienteAbogado;

public interface ExpedienteAbogadoDao extends Dao<ExpedienteAbogado> {

	public List<ExpedienteAbogado> findByExpediente(String search);
}
