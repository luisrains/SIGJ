package py.com.sigj.rrhh.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.domain.Movimiento;

@Repository
@Scope("session")
public class MovimientoDaoImpl extends DaoImpl<Movimiento> implements MovimientoDao {
	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}
}
