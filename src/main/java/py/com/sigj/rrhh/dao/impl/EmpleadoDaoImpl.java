package py.com.sigj.rrhh.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.domain.Empleado;

@Repository
@Scope("session")
public class EmpleadoDaoImpl extends RrhhDaoImpl<Empleado> implements EmpleadoDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo";
	}

}
