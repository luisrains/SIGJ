package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.EstadoExternoInterno;

public interface EstadoExternoInternoDao extends Dao<EstadoExternoInterno> {
	public List<EstadoExternoInterno> getListAllExternoInterno(String string);
}
