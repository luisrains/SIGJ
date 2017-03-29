package py.com.sigj.expediente.dao;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Proceso;

public interface ProcesoDao extends Dao<Proceso> {

	public void refresh(Proceso obj);
}
