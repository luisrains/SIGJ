package py.com.sigj.rrhh.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

public interface PlanillaSalarioDao extends Dao<PlanillaSalario> {
	public List<PlanillaSalario> buscar(Long id);

}
