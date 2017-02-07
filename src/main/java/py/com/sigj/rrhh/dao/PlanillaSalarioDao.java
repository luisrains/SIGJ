package py.com.sigj.rrhh.dao;

import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

public interface PlanillaSalarioDao extends Dao<PlanillaSalario> {

	public String lista_planilla(String fecha);

}
