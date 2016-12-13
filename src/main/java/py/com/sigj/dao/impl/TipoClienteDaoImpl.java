package py.com.sigj.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.TipoClienteDao;
import py.com.sigj.domain.TipoCliente;

@Repository
@Scope("session")
public class TipoClienteDaoImpl extends DaoImpl<TipoCliente> implements TipoClienteDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||nombre";
	}

}
