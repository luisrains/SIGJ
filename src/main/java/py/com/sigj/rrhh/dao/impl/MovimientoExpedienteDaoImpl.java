package py.com.sigj.rrhh.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.rrhh.dao.MovimientoExpedienteDao;
import py.com.sigj.rrhh.domain.MovimientoExpediente;

@Repository
@Scope("session")
public class MovimientoExpedienteDaoImpl extends DaoImpl<MovimientoExpediente> implements MovimientoExpedienteDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}

}
