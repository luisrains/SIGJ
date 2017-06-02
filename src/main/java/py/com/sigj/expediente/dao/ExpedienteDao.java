package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Expediente;

public interface ExpedienteDao extends Dao<Expediente> {

	public List<Expediente> getListByCedulaRuc(Long cedula);
}
