package py.com.sigj.rrhh.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.rrhh.dao.MovimientoEmpleadoDao;
import py.com.sigj.rrhh.domain.MovimientoEmpleado;

@Repository
@Scope("session")
public class MovimientoEmpleadoDaoImpl extends RrhhDaoImpl<MovimientoEmpleado> implements MovimientoEmpleadoDao {
	@Override
	public String getCamposFiltrables() {
		return null; // que retorna
	}
}
