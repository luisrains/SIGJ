package py.com.sigj.rrhh.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

public interface PlanillaSalarioDao extends Dao<PlanillaSalario> {
	public List<Object[]> lista_planilla(String fecha);
}
