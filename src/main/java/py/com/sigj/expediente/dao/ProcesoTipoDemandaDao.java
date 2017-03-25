package py.com.sigj.expediente.dao;

import javax.persistence.NoResultException;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.ProcesoTipoDemanda;

public interface ProcesoTipoDemandaDao extends Dao<ProcesoTipoDemanda> {
	public Long getListWhere(Long idProceso, Long idTipoDemanda) throws NoResultException;
}
