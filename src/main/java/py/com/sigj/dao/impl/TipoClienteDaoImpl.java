package py.com.owl.owlapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.owl.owlapp.dao.TipoClienteDao;
import py.com.owl.owlapp.domain.TipoCliente;

@Repository
@Scope("session")
public class TipoClienteDaoImpl extends DaoImpl<TipoCliente> implements TipoClienteDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||nombre";
	}

}
