package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Persona;

public interface PersonaDao extends Dao<Persona> {

	public List<Persona> listaPersonas(Integer filaInicio, Integer filaFin,String sSearch);
}
