package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Proceso;
import py.com.sigj.expediente.domain.TipoDemanda;

public interface ProcesoDao extends Dao<Proceso> {
	public List<TipoDemanda> getListaTipoDemanda(Long id) throws Exception;
}
