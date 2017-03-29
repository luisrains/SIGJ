package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Materia;
import py.com.sigj.expediente.domain.Proceso;

public interface MateriaDao extends Dao<Materia> {

	public void deleteProcesoRelation(Long id) throws IllegalArgumentException;

	public void refresh(Materia obj);

	public List<Proceso> getListaProcesos(Long id) throws Exception;
}
