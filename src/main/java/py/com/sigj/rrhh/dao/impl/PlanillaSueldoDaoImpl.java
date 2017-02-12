package py.com.sigj.rrhh.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.PlanillaSueldoDao;
import py.com.sigj.rrhh.domain.PlanillaSueldo;

@Repository
@Scope("session")
public class PlanillaSueldoDaoImpl extends DaoImpl<PlanillaSueldo> implements PlanillaSueldoDao {

	@Override
	public String getCamposFiltrables() {

		return null;
	}

}
