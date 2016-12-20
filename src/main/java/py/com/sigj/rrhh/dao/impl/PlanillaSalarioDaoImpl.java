package py.com.sigj.rrhh.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.rrhh.dao.PlanillaSalarioDao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

@Repository
@Scope("session")
public class PlanillaSalarioDaoImpl extends RrhhDaoImpl<PlanillaSalario> implements PlanillaSalarioDao {
	@Override
	public String getCamposFiltrables() {
		return "codigo";
	}
}
